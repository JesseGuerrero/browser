/*     */ package org.cef.browser;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.MouseInfo;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.awt.event.HierarchyBoundsListener;
/*     */ import java.awt.event.HierarchyEvent;
/*     */ import java.awt.event.HierarchyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.MenuSelectionManager;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.ToolTipManager;
/*     */ import org.cef.CefClient;
/*     */ import org.cef.OS;
/*     */ import org.cef.handler.CefClientHandler;
/*     */ import org.cef.handler.CefWindowHandler;
/*     */ import org.cef.handler.CefWindowHandlerAdapter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefBrowserWr
/*     */   extends CefBrowser_N
/*     */ {
/*  50 */   private Canvas canvas_ = null;
/*  51 */   private Component component_ = null;
/*  52 */   private Rectangle content_rect_ = new Rectangle(0, 0, 0, 0);
/*  53 */   private long window_handle_ = 0L;
/*     */   private boolean justCreated_ = false;
/*  55 */   private double scaleFactor_ = 1.0D;
/*  56 */   private final Timer delayedUpdate_ = new Timer(100, new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent param1ActionEvent) {
/*  59 */           SwingUtilities.invokeLater(new Runnable()
/*     */               {
/*     */                 public void run() {
/*  62 */                   if (CefBrowserWr.this.isClosed())
/*     */                     return; 
/*  64 */                   boolean bool = CefBrowserWr.this.createBrowserIfRequired(true);
/*     */                   
/*  66 */                   if (bool)
/*  67 */                   { CefBrowserWr.this.delayedUpdate_.restart();
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/*     */                      }
/*     */                   
/*  74 */                   else if (OS.isMacintosh() || OS.isLinux()) { CefBrowserWr.this.doUpdate(); }
/*     */                 
/*     */                 }
/*     */               });
/*     */         }
/*     */       });
/*     */   
/*  81 */   private final CefWindowHandlerAdapter win_handler_ = new CefWindowHandlerAdapter() {
/*  82 */       private Point lastPos = new Point(-1, -1);
/*  83 */       private final long[] nextClick = new long[MouseInfo.getNumberOfButtons()];
/*  84 */       private final int[] clickCnt = new int[MouseInfo.getNumberOfButtons()];
/*     */ 
/*     */       
/*     */       public Rectangle getRect(CefBrowser param1CefBrowser) {
/*  88 */         synchronized (CefBrowserWr.this.content_rect_) {
/*  89 */           return CefBrowserWr.this.content_rect_;
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onMouseEvent(CefBrowser param1CefBrowser, int param1Int1, final int screenX, final int screenY, final int modifier, final int button) {
/*  96 */         final Point pt = new Point(screenX, screenY);
/*  97 */         if (param1Int1 == 503) {
/*     */ 
/*     */           
/* 100 */           if (pt.equals(this.lastPos))
/* 101 */             return;  this.lastPos = pt;
/*     */ 
/*     */ 
/*     */           
/* 105 */           if ((modifier & 0x400) != 0) {
/* 106 */             param1Int1 = 506;
/*     */           }
/*     */         } 
/* 109 */         final int finalEvent = param1Int1;
/*     */         
/* 111 */         SwingUtilities.invokeLater(new Runnable()
/*     */             {
/*     */               
/*     */               public void run()
/*     */               {
/* 116 */                 Component component = SwingUtilities.getRoot(CefBrowserWr.this.component_);
/* 117 */                 if (component == null) {
/*     */                   return;
/*     */                 }
/* 120 */                 SwingUtilities.convertPointFromScreen(pt, component);
/*     */                 
/* 122 */                 int i = 0;
/* 123 */                 long l = (new Date()).getTime();
/* 124 */                 if (finalEvent == 507) {
/* 125 */                   int bool1 = 0;
/* 126 */                   int bool2 = 1;
/* 127 */                   CefBrowserWr.this.component_.dispatchEvent(new MouseWheelEvent(component, finalEvent, l, modifier, pt.x, pt.y, 0, false, bool1, 3, bool2));
/*     */                 } else {
/*     */                   
/* 130 */                   i = getClickCount(finalEvent, button);
/* 131 */                   CefBrowserWr.this.component_.dispatchEvent(new MouseEvent(component, finalEvent, l, modifier, pt.x, pt.y, screenX, screenY, i, false, button));
/*     */                 } 
/*     */ 
/*     */ 
/*     */                 
/* 136 */                 if (finalEvent == 502) {
/* 137 */                   CefBrowserWr.this.component_.dispatchEvent(new MouseEvent(component, 500, l, modifier, pt.x, pt.y, screenX, screenY, i, false, button));
/*     */                 }
/*     */               }
/*     */             });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int getClickCount(int param1Int1, int param1Int2) {
/*     */         long l;
/* 147 */         int i = param1Int2 % this.nextClick.length;
/*     */         
/* 149 */         switch (param1Int1) {
/*     */           case 501:
/* 151 */             l = (new Date()).getTime();
/* 152 */             if (l > this.nextClick[i]) {
/* 153 */               this.nextClick[i] = l + (
/* 154 */                 (Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval")).intValue();
/*     */               
/* 156 */               this.clickCnt[i] = 1;
/*     */             } else {
/* 158 */               this.clickCnt[i] = this.clickCnt[i] + 1;
/*     */             } 
/*     */           
/*     */           case 502:
/* 162 */             return this.clickCnt[i];
/*     */         } 
/* 164 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   CefBrowserWr(CefClient paramCefClient, String paramString, CefRequestContext paramCefRequestContext) {
/* 170 */     this(paramCefClient, paramString, paramCefRequestContext, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private CefBrowserWr(CefClient paramCefClient, String paramString, CefRequestContext paramCefRequestContext, CefBrowserWr paramCefBrowserWr, Point paramPoint) {
/* 176 */     super(paramCefClient, paramString, paramCefRequestContext, paramCefBrowserWr, paramPoint);
/* 177 */     this.delayedUpdate_.setRepeats(false);
/*     */ 
/*     */ 
/*     */     
/* 181 */     JPopupMenu.setDefaultLightWeightPopupEnabled(false);
/* 182 */     ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
/*     */ 
/*     */ 
/*     */     
/* 186 */     this.component_ = new JPanel(new BorderLayout())
/*     */       {
/*     */         private boolean removed_ = true;
/*     */         
/*     */         public void setBounds(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 191 */           super.setBounds(param1Int1, param1Int2, param1Int3, param1Int4);
/* 192 */           CefBrowserWr.this.wasResized((int)(param1Int3 * CefBrowserWr.this.scaleFactor_), (int)(param1Int4 * CefBrowserWr.this.scaleFactor_));
/*     */         }
/*     */ 
/*     */         
/*     */         public void setBounds(Rectangle param1Rectangle) {
/* 197 */           setBounds(param1Rectangle.x, param1Rectangle.y, param1Rectangle.width, param1Rectangle.height);
/*     */         }
/*     */ 
/*     */         
/*     */         public void setSize(int param1Int1, int param1Int2) {
/* 202 */           super.setSize(param1Int1, param1Int2);
/* 203 */           CefBrowserWr.this.wasResized((int)(param1Int1 * CefBrowserWr.this.scaleFactor_), (int)(param1Int2 * CefBrowserWr.this.scaleFactor_));
/*     */         }
/*     */ 
/*     */         
/*     */         public void setSize(Dimension param1Dimension) {
/* 208 */           setSize(param1Dimension.width, param1Dimension.height);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void paint(Graphics param1Graphics) {
/* 221 */           if (param1Graphics instanceof Graphics2D) {
/* 222 */             CefBrowserWr.this.scaleFactor_ = ((Graphics2D)param1Graphics).getTransform().getScaleX();
/*     */           }
/* 224 */           CefBrowserWr.this.doUpdate();
/* 225 */           CefBrowserWr.this.delayedUpdate_.restart();
/*     */         }
/*     */ 
/*     */         
/*     */         public void addNotify() {
/* 230 */           super.addNotify();
/* 231 */           if (this.removed_) {
/* 232 */             CefBrowserWr.this.setParent(CefBrowserWr.getWindowHandle(this), CefBrowserWr.this.canvas_);
/* 233 */             this.removed_ = false;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void removeNotify() {
/* 239 */           if (!this.removed_) {
/* 240 */             if (!CefBrowserWr.this.isClosed()) {
/* 241 */               CefBrowserWr.this.setParent(0L, null);
/*     */             }
/* 243 */             this.removed_ = true;
/*     */           } 
/* 245 */           super.removeNotify();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     if (OS.isWindows() || OS.isLinux()) {
/* 253 */       this.canvas_ = new Canvas();
/* 254 */       ((JPanel)this.component_).add(this.canvas_, "Center");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 259 */     this.component_.setMinimumSize(new Dimension(0, 0));
/* 260 */     this.component_.setFocusable(true);
/* 261 */     this.component_.addFocusListener(new FocusListener()
/*     */         {
/*     */           public void focusLost(FocusEvent param1FocusEvent) {
/* 264 */             CefBrowserWr.this.setFocus(false);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 270 */             MenuSelectionManager.defaultManager().clearSelectedPath();
/* 271 */             CefBrowserWr.this.setFocus(true);
/*     */           }
/*     */         });
/* 274 */     this.component_.addHierarchyBoundsListener(new HierarchyBoundsListener()
/*     */         {
/*     */           public void ancestorResized(HierarchyEvent param1HierarchyEvent) {
/* 277 */             CefBrowserWr.this.doUpdate();
/*     */           }
/*     */           
/*     */           public void ancestorMoved(HierarchyEvent param1HierarchyEvent) {
/* 281 */             CefBrowserWr.this.doUpdate();
/* 282 */             CefBrowserWr.this.notifyMoveOrResizeStarted();
/*     */           }
/*     */         });
/* 285 */     this.component_.addHierarchyListener(new HierarchyListener()
/*     */         {
/*     */           public void hierarchyChanged(HierarchyEvent param1HierarchyEvent) {
/* 288 */             if ((param1HierarchyEvent.getChangeFlags() & 0x4L) != 0L) {
/* 289 */               CefBrowserWr.this.setWindowVisibility(param1HierarchyEvent.getChanged().isVisible());
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void createImmediately() {
/* 297 */     this.justCreated_ = true;
/* 298 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/* 303 */             CefBrowserWr.this.createBrowserIfRequired(false);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public Component getUIComponent() {
/* 310 */     return this.component_;
/*     */   }
/*     */ 
/*     */   
/*     */   public CefWindowHandler getWindowHandler() {
/* 315 */     return this.win_handler_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CefBrowser_N createDevToolsBrowser(CefClient paramCefClient, String paramString, CefRequestContext paramCefRequestContext, CefBrowser_N paramCefBrowser_N, Point paramPoint) {
/* 321 */     return new CefBrowserWr(paramCefClient, paramString, paramCefRequestContext, this, paramPoint);
/*     */   }
/*     */   
/*     */   private synchronized long getWindowHandle() {
/* 325 */     if (this.window_handle_ == 0L && OS.isMacintosh()) {
/* 326 */       this.window_handle_ = getWindowHandle(this.component_);
/*     */     }
/* 328 */     return this.window_handle_;
/*     */   }
/*     */   
/*     */   private static long getWindowHandle(Component paramComponent) {
/* 332 */     if (OS.isMacintosh()) {
/*     */       try {
/* 334 */         Class<?> clazz = Class.forName("org.cef.browser.mac.CefBrowserWindowMac");
/* 335 */         CefBrowserWindow cefBrowserWindow = (CefBrowserWindow)clazz.newInstance();
/* 336 */         if (cefBrowserWindow != null) {
/* 337 */           return cefBrowserWindow.getWindowHandle(paramComponent);
/*     */         }
/* 339 */       } catch (ClassNotFoundException classNotFoundException) {
/* 340 */         classNotFoundException.printStackTrace();
/* 341 */       } catch (InstantiationException instantiationException) {
/* 342 */         instantiationException.printStackTrace();
/* 343 */       } catch (IllegalAccessException illegalAccessException) {
/* 344 */         illegalAccessException.printStackTrace();
/*     */       } 
/*     */     }
/* 347 */     return 0L;
/*     */   }
/*     */   
/*     */   private void doUpdate() {
/* 351 */     if (isClosed())
/*     */       return; 
/* 353 */     Rectangle rectangle1 = ((JPanel)this.component_).getVisibleRect();
/*     */ 
/*     */     
/* 356 */     Rectangle rectangle2 = new Rectangle((int)(rectangle1.getX() * this.scaleFactor_), (int)(rectangle1.getY() * this.scaleFactor_), (int)(rectangle1.getWidth() * this.scaleFactor_), (int)(rectangle1.getHeight() * this.scaleFactor_));
/*     */     
/* 358 */     if (OS.isMacintosh()) {
/* 359 */       Container container = this.component_.getParent();
/* 360 */       Point point1 = this.component_.getLocation();
/* 361 */       while (container != null) {
/* 362 */         Container container1 = container.getParent();
/* 363 */         if (container1 != null && container1 instanceof java.awt.Window)
/* 364 */           break;  Point point = container.getLocation();
/* 365 */         point1.translate(point.x, point.y);
/* 366 */         container = container1;
/*     */       } 
/* 368 */       point1.translate(rectangle2.x, rectangle2.y);
/*     */       
/* 370 */       Point point2 = rectangle2.getLocation();
/* 371 */       point2.x *= -1;
/* 372 */       point2.y *= -1;
/*     */       
/* 374 */       synchronized (this.content_rect_) {
/* 375 */         this.content_rect_ = new Rectangle(point1, rectangle2.getSize());
/* 376 */         Rectangle rectangle = new Rectangle(point2, this.component_.getSize());
/* 377 */         updateUI(this.content_rect_, rectangle);
/*     */       } 
/*     */     } else {
/* 380 */       synchronized (this.content_rect_) {
/* 381 */         Rectangle rectangle = this.component_.getBounds();
/* 382 */         this
/*     */ 
/*     */           
/* 385 */           .content_rect_ = new Rectangle((int)(rectangle.getX() * this.scaleFactor_), (int)(rectangle.getY() * this.scaleFactor_), (int)(rectangle.getWidth() * this.scaleFactor_), (int)(rectangle.getHeight() * this.scaleFactor_));
/* 386 */         updateUI(rectangle2, this.content_rect_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean createBrowserIfRequired(boolean paramBoolean) {
/* 392 */     if (isClosed()) return false;
/*     */     
/* 394 */     long l = 0L;
/* 395 */     Component component = null;
/* 396 */     if (paramBoolean) {
/* 397 */       l = getWindowHandle();
/* 398 */       component = (OS.isWindows() || OS.isLinux()) ? this.canvas_ : this.component_;
/*     */     } 
/*     */     
/* 401 */     if (getNativeRef("CefBrowser") == 0L) {
/* 402 */       if (getParentBrowser() != null) {
/* 403 */         createDevTools(getParentBrowser(), getClient(), l, false, false, component,
/* 404 */             getInspectAt());
/* 405 */         return true;
/*     */       } 
/* 407 */       createBrowser(getClient(), l, getUrl(), false, false, component,
/* 408 */           getRequestContext());
/* 409 */       return true;
/*     */     } 
/* 411 */     if (paramBoolean && this.justCreated_) {
/* 412 */       setParent(l, component);
/* 413 */       setFocus(true);
/* 414 */       this.justCreated_ = false;
/*     */     } 
/*     */     
/* 417 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CompletableFuture<BufferedImage> createScreenshot(boolean paramBoolean) {
/* 422 */     throw new UnsupportedOperationException("Unsupported for windowed rendering");
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefBrowserWr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */