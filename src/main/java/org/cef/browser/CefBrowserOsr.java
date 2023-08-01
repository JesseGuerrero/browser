/*     */ package org.cef.browser;
/*     */ 
/*     */ import com.jogamp.nativewindow.NativeSurface;
/*     */ import com.jogamp.opengl.GL2;
/*     */ import com.jogamp.opengl.GLAutoDrawable;
/*     */ import com.jogamp.opengl.GLCapabilities;
/*     */ import com.jogamp.opengl.GLCapabilitiesImmutable;
/*     */ import com.jogamp.opengl.GLContext;
/*     */ import com.jogamp.opengl.GLEventListener;
/*     */ import com.jogamp.opengl.GLProfile;
/*     */ import com.jogamp.opengl.awt.GLCanvas;
/*     */ import com.jogamp.opengl.util.GLBuffers;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.datatransfer.StringSelection;
/*     */ import java.awt.dnd.DragGestureEvent;
/*     */ import java.awt.dnd.DragGestureRecognizer;
/*     */ import java.awt.dnd.DragSource;
/*     */ import java.awt.dnd.DragSourceAdapter;
/*     */ import java.awt.dnd.DragSourceDropEvent;
/*     */ import java.awt.dnd.DropTarget;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.awt.event.InputEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import java.awt.event.MouseWheelListener;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.image.AffineTransformOp;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import javax.swing.MenuSelectionManager;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.cef.CefClient;
/*     */ import org.cef.OS;
/*     */ import org.cef.callback.CefDragData;
/*     */ import org.cef.handler.CefClientHandler;
/*     */ import org.cef.handler.CefRenderHandler;
/*     */ import org.cef.handler.CefScreenInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefBrowserOsr
/*     */   extends CefBrowser_N
/*     */   implements CefRenderHandler
/*     */ {
/*     */   private final CefRenderer renderer_;
/*     */   private GLCanvas canvas_;
/*  78 */   private long window_handle_ = 0L;
/*     */   private boolean justCreated_ = false;
/*  80 */   private final Rectangle browser_rect_ = new Rectangle(0, 0, 1, 1);
/*  81 */   private Point screenPoint_ = new Point(0, 0);
/*  82 */   private double scaleFactor_ = 1.0D;
/*  83 */   private int depth = 32;
/*  84 */   private int depth_per_component = 8;
/*     */   private final boolean isTransparent_;
/*     */   
/*     */   CefBrowserOsr(CefClient paramCefClient, String paramString, boolean paramBoolean, CefRequestContext paramCefRequestContext) {
/*  88 */     this(paramCefClient, paramString, paramBoolean, paramCefRequestContext, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private CefBrowserOsr(CefClient paramCefClient, String paramString, boolean paramBoolean, CefRequestContext paramCefRequestContext, CefBrowserOsr paramCefBrowserOsr, Point paramPoint) {
/*  93 */     super(paramCefClient, paramString, paramCefRequestContext, paramCefBrowserOsr, paramPoint);
/*  94 */     this.isTransparent_ = paramBoolean;
/*  95 */     this.renderer_ = new CefRenderer(paramBoolean);
/*  96 */     createGLCanvas();
/*     */   }
/*     */ 
/*     */   
/*     */   public void createImmediately() {
/* 101 */     this.justCreated_ = true;
/*     */     
/* 103 */     createBrowserIfRequired(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Component getUIComponent() {
/* 108 */     return this.canvas_;
/*     */   }
/*     */ 
/*     */   
/*     */   public CefRenderHandler getRenderHandler() {
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CefBrowser_N createDevToolsBrowser(CefClient paramCefClient, String paramString, CefRequestContext paramCefRequestContext, CefBrowser_N paramCefBrowser_N, Point paramPoint) {
/* 119 */     return new CefBrowserOsr(paramCefClient, paramString, this.isTransparent_, paramCefRequestContext, this, paramPoint);
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized long getWindowHandle() {
/* 124 */     if (this.window_handle_ == 0L) {
/* 125 */       NativeSurface nativeSurface = this.canvas_.getNativeSurface();
/* 126 */       if (nativeSurface != null) {
/* 127 */         nativeSurface.lockSurface();
/* 128 */         this.window_handle_ = getWindowHandle(nativeSurface.getSurfaceHandle());
/* 129 */         nativeSurface.unlockSurface();
/* 130 */         assert this.window_handle_ != 0L;
/*     */       } 
/*     */     } 
/* 133 */     return this.window_handle_;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createGLCanvas() {
/* 138 */     GLProfile gLProfile = GLProfile.getMaxFixedFunc(true);
/* 139 */     GLCapabilities gLCapabilities = new GLCapabilities(gLProfile);
/* 140 */     this.canvas_ = new GLCanvas(gLCapabilities) {
/* 141 */         private Method scaleFactorAccessor = null;
/*     */         
/*     */         private boolean removed_ = true;
/*     */         
/*     */         public void paint(Graphics param1Graphics) {
/* 146 */           CefBrowserOsr.this.createBrowserIfRequired(true);
/* 147 */           if (param1Graphics instanceof Graphics2D) {
/* 148 */             GraphicsConfiguration graphicsConfiguration = ((Graphics2D)param1Graphics).getDeviceConfiguration();
/* 149 */             CefBrowserOsr.this.depth = graphicsConfiguration.getColorModel().getPixelSize();
/* 150 */             CefBrowserOsr.this.depth_per_component = graphicsConfiguration.getColorModel().getComponentSize()[0];
/*     */             
/* 152 */             if (OS.isMacintosh() && 
/* 153 */               System.getProperty("java.runtime.version").startsWith("1.8")) {
/*     */ 
/*     */               
/*     */               try {
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
/*     */                 
/* 168 */                 if (this.scaleFactorAccessor == null) {
/* 169 */                   this
/*     */ 
/*     */                     
/* 172 */                     .scaleFactorAccessor = getClass().getClassLoader().loadClass("sun.awt.CGraphicsDevice").getDeclaredMethod("getScaleFactor");
/*     */                 }
/* 174 */                 Object object = this.scaleFactorAccessor.invoke(graphicsConfiguration.getDevice());
/* 175 */                 if (object instanceof Integer) {
/* 176 */                   CefBrowserOsr.this.scaleFactor_ = ((Integer)object).doubleValue();
/*     */                 } else {
/* 178 */                   CefBrowserOsr.this.scaleFactor_ = 1.0D;
/*     */                 } 
/* 180 */               } catch (InvocationTargetException|IllegalAccessException|IllegalArgumentException|NoSuchMethodException|SecurityException|ClassNotFoundException invocationTargetException) {
/*     */ 
/*     */                 
/* 183 */                 CefBrowserOsr.this.scaleFactor_ = 1.0D;
/*     */               } 
/*     */             } else {
/* 186 */               CefBrowserOsr.this.scaleFactor_ = ((Graphics2D)param1Graphics).getTransform().getScaleX();
/*     */             } 
/*     */           } 
/* 189 */           super.paint(param1Graphics);
/*     */         }
/*     */ 
/*     */         
/*     */         public void addNotify() {
/* 194 */           super.addNotify();
/* 195 */           if (this.removed_) {
/* 196 */             CefBrowserOsr.this.notifyAfterParentChanged();
/* 197 */             this.removed_ = false;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void removeNotify() {
/* 203 */           if (!this.removed_) {
/* 204 */             if (!CefBrowserOsr.this.isClosed()) {
/* 205 */               CefBrowserOsr.this.notifyAfterParentChanged();
/*     */             }
/* 207 */             this.removed_ = true;
/*     */           } 
/* 209 */           super.removeNotify();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 215 */     this.canvas_.addGLEventListener(new GLEventListener()
/*     */         {
/*     */           public void reshape(GLAutoDrawable param1GLAutoDrawable, int param1Int1, int param1Int2, int param1Int3, int param1Int4)
/*     */           {
/* 219 */             int i = param1Int3;
/* 220 */             int j = param1Int4;
/* 221 */             if (OS.isMacintosh()) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 226 */               i = (int)(param1Int3 / CefBrowserOsr.this.scaleFactor_);
/* 227 */               j = (int)(param1Int4 / CefBrowserOsr.this.scaleFactor_);
/*     */             } 
/* 229 */             CefBrowserOsr.this.browser_rect_.setBounds(param1Int1, param1Int2, i, j);
/* 230 */             CefBrowserOsr.this.screenPoint_ = CefBrowserOsr.this.canvas_.getLocationOnScreen();
/* 231 */             CefBrowserOsr.this.wasResized(i, j);
/*     */           }
/*     */ 
/*     */           
/*     */           public void init(GLAutoDrawable param1GLAutoDrawable) {
/* 236 */             CefBrowserOsr.this.renderer_.initialize(param1GLAutoDrawable.getGL().getGL2());
/*     */           }
/*     */ 
/*     */           
/*     */           public void dispose(GLAutoDrawable param1GLAutoDrawable) {
/* 241 */             CefBrowserOsr.this.renderer_.cleanup(param1GLAutoDrawable.getGL().getGL2());
/*     */           }
/*     */ 
/*     */           
/*     */           public void display(GLAutoDrawable param1GLAutoDrawable) {
/* 246 */             CefBrowserOsr.this.renderer_.render(param1GLAutoDrawable.getGL().getGL2());
/*     */           }
/*     */         });
/*     */     
/* 250 */     this.canvas_.addMouseListener(new MouseListener()
/*     */         {
/*     */           public void mousePressed(MouseEvent param1MouseEvent) {
/* 253 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void mouseReleased(MouseEvent param1MouseEvent) {
/* 258 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void mouseEntered(MouseEvent param1MouseEvent) {
/* 263 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void mouseExited(MouseEvent param1MouseEvent) {
/* 268 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void mouseClicked(MouseEvent param1MouseEvent) {
/* 273 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */         });
/*     */     
/* 277 */     this.canvas_.addMouseMotionListener(new MouseMotionListener()
/*     */         {
/*     */           public void mouseMoved(MouseEvent param1MouseEvent) {
/* 280 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void mouseDragged(MouseEvent param1MouseEvent) {
/* 285 */             CefBrowserOsr.this.sendMouseEvent(param1MouseEvent);
/*     */           }
/*     */         });
/*     */     
/* 289 */     this.canvas_.addMouseWheelListener(new MouseWheelListener()
/*     */         {
/*     */           public void mouseWheelMoved(MouseWheelEvent param1MouseWheelEvent) {
/* 292 */             CefBrowserOsr.this.sendMouseWheelEvent(param1MouseWheelEvent);
/*     */           }
/*     */         });
/*     */     
/* 296 */     this.canvas_.addKeyListener(new KeyListener()
/*     */         {
/*     */           public void keyTyped(KeyEvent param1KeyEvent) {
/* 299 */             CefBrowserOsr.this.sendKeyEvent(param1KeyEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/* 304 */             CefBrowserOsr.this.sendKeyEvent(param1KeyEvent);
/*     */           }
/*     */ 
/*     */           
/*     */           public void keyReleased(KeyEvent param1KeyEvent) {
/* 309 */             CefBrowserOsr.this.sendKeyEvent(param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/* 313 */     this.canvas_.setFocusable(true);
/* 314 */     this.canvas_.addFocusListener(new FocusListener()
/*     */         {
/*     */           public void focusLost(FocusEvent param1FocusEvent) {
/* 317 */             CefBrowserOsr.this.setFocus(false);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/* 323 */             MenuSelectionManager.defaultManager().clearSelectedPath();
/* 324 */             CefBrowserOsr.this.setFocus(true);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 329 */     new DropTarget(this.canvas_, new CefDropTargetListener(this));
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle getViewRect(CefBrowser paramCefBrowser) {
/* 334 */     return this.browser_rect_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Point getScreenPoint(CefBrowser paramCefBrowser, Point paramPoint) {
/* 339 */     Point point = new Point(this.screenPoint_);
/* 340 */     point.translate(paramPoint.x, paramPoint.y);
/* 341 */     return point;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPopupShow(CefBrowser paramCefBrowser, boolean paramBoolean) {
/* 346 */     if (!paramBoolean) {
/* 347 */       this.renderer_.clearPopupRects();
/* 348 */       invalidate();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPopupSize(CefBrowser paramCefBrowser, Rectangle paramRectangle) {
/* 354 */     this.renderer_.onPopupSize(paramRectangle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPaint(CefBrowser paramCefBrowser, boolean paramBoolean, Rectangle[] paramArrayOfRectangle, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 361 */     GLContext gLContext = (this.canvas_ != null) ? this.canvas_.getContext() : null;
/*     */     
/* 363 */     if (gLContext == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 368 */     if (gLContext.makeCurrent() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 372 */     this.renderer_.onPaint(this.canvas_.getGL().getGL2(), paramBoolean, paramArrayOfRectangle, paramByteBuffer, paramInt1, paramInt2);
/* 373 */     gLContext.release();
/* 374 */     SwingUtilities.invokeLater(new Runnable() {
/*     */           public void run() {
/* 376 */             CefBrowserOsr.this.canvas_.display();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onCursorChange(CefBrowser paramCefBrowser, final int cursorType) {
/* 383 */     SwingUtilities.invokeLater(new Runnable() {
/*     */           public void run() {
/* 385 */             CefBrowserOsr.this.canvas_.setCursor(new Cursor(cursorType));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 390 */     return true;
/*     */   }
/*     */   
/*     */   private static final class SyntheticDragGestureRecognizer extends DragGestureRecognizer {
/*     */     public SyntheticDragGestureRecognizer(Component param1Component, int param1Int, MouseEvent param1MouseEvent) {
/* 395 */       super(new DragSource(), param1Component, param1Int);
/* 396 */       appendEvent(param1MouseEvent);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void registerListeners() {}
/*     */     
/*     */     protected void unregisterListeners() {}
/*     */   }
/*     */   
/*     */   public boolean startDragging(CefBrowser paramCefBrowser, CefDragData paramCefDragData, final int mask, int paramInt2, int paramInt3) {
/* 406 */     int bool = 1;
/*     */ 
/*     */     
/* 409 */     MouseEvent mouseEvent = new MouseEvent(this.canvas_, 506, 0L, 0, paramInt2, paramInt3, 0, false);
/*     */ 
/*     */ 
/*     */     
/* 413 */     DragGestureEvent dragGestureEvent = new DragGestureEvent(new SyntheticDragGestureRecognizer(this.canvas_, bool, mouseEvent), bool, new Point(paramInt2, paramInt3), new ArrayList<>(Arrays.asList((InputEvent[])new MouseEvent[] { mouseEvent })));
/*     */     
/* 415 */     DragSource.getDefaultDragSource().startDrag(dragGestureEvent, null, new StringSelection(paramCefDragData
/* 416 */           .getFragmentText()), new DragSourceAdapter()
/*     */         {
/*     */           public void dragDropEnd(DragSourceDropEvent param1DragSourceDropEvent) {
/* 419 */             CefBrowserOsr.this.dragSourceEndedAt(param1DragSourceDropEvent.getLocation(), mask);
/* 420 */             CefBrowserOsr.this.dragSourceSystemDragEnded();
/*     */           }
/*     */         });
/* 423 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateDragCursor(CefBrowser paramCefBrowser, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void createBrowserIfRequired(boolean paramBoolean) {
/* 433 */     long l = 0L;
/* 434 */     if (paramBoolean) {
/* 435 */       l = getWindowHandle();
/*     */     }
/*     */     
/* 438 */     if (getNativeRef("CefBrowser") == 0L) {
/* 439 */       if (getParentBrowser() != null) {
/* 440 */         createDevTools(getParentBrowser(), getClient(), l, true, this.isTransparent_, null,
/* 441 */             getInspectAt());
/*     */       } else {
/* 443 */         createBrowser(getClient(), l, getUrl(), true, this.isTransparent_, null,
/* 444 */             getRequestContext());
/*     */       } 
/* 446 */     } else if (paramBoolean && this.justCreated_) {
/* 447 */       notifyAfterParentChanged();
/* 448 */       setFocus(true);
/* 449 */       this.justCreated_ = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void notifyAfterParentChanged() {
/* 456 */     getClient().onAfterParentChanged(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getScreenInfo(CefBrowser paramCefBrowser, CefScreenInfo paramCefScreenInfo) {
/* 461 */     paramCefScreenInfo.Set(this.scaleFactor_, this.depth, this.depth_per_component, false, this.browser_rect_.getBounds(), this.browser_rect_
/* 462 */         .getBounds());
/*     */     
/* 464 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public CompletableFuture<BufferedImage> createScreenshot(final boolean nativeResolution) {
/* 469 */     final int width = (int)(this.canvas_.getWidth() * this.scaleFactor_);
/* 470 */     final int height = (int)(this.canvas_.getHeight() * this.scaleFactor_);
/*     */ 
/*     */ 
/*     */     
/* 474 */     final GL2 gl = this.canvas_.getGL().getGL2();
/* 475 */     final int textureId = this.renderer_.getTextureID();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 484 */     final boolean useReadPixels = true;//k == 0) ? true : false;
/*     */ 
/*     */ 
/*     */     
/* 488 */     final Callable<BufferedImage> pixelGrabberCallable = new Callable<BufferedImage>()
/*     */       {
/*     */         public BufferedImage call() {
/* 491 */           BufferedImage bufferedImage = new BufferedImage(width, height, 2);
/*     */           
/* 493 */           ByteBuffer byteBuffer = GLBuffers.newDirectByteBuffer(width * height * 4);
/*     */           
/* 495 */           gl.getContext().makeCurrent();
/*     */           try {
/* 497 */             if (useReadPixels) {
/*     */ 
/*     */               
/* 500 */               gl.glReadPixels(0, 0, width, height, 6408, 5121, byteBuffer);
/*     */             
/*     */             }
/*     */             else {
/*     */               
/* 505 */               gl.glEnable(3553);
/* 506 */               gl.glBindTexture(3553, textureId);
/* 507 */               gl.glGetTexImage(3553, 0, 6408, 5121, byteBuffer);
/*     */               
/* 509 */               gl.glDisable(3553);
/*     */             } 
/*     */           } finally {
/* 512 */             gl.getContext().release();
/*     */           } 
/*     */           
/* 515 */           for (byte b = 0; b < height; b++) {
/* 516 */             for (byte b1 = 0; b1 < width; b1++) {
/*     */ 
/*     */               
/* 519 */               int i = byteBuffer.get() & 0xFF;
/* 520 */               int j = byteBuffer.get() & 0xFF;
/* 521 */               int k = byteBuffer.get() & 0xFF;
/* 522 */               int m = byteBuffer.get() & 0xFF;
/* 523 */               int n = m << 24 | i << 16 | j << 8 | k << 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 529 */               bufferedImage.setRGB(b1, useReadPixels ? (height - b - 1) : b, n);
/*     */             } 
/*     */           } 
/*     */           
/* 533 */           if (!nativeResolution && CefBrowserOsr.this.scaleFactor_ != 1.0D) {
/*     */ 
/*     */ 
/*     */             
/* 537 */             BufferedImage bufferedImage1 = new BufferedImage((int)(bufferedImage.getWidth() / CefBrowserOsr.this.scaleFactor_), (int)(bufferedImage.getHeight() / CefBrowserOsr.this.scaleFactor_), 2);
/*     */             
/* 539 */             AffineTransform affineTransform = new AffineTransform();
/* 540 */             affineTransform.scale(1.0D / CefBrowserOsr.this.scaleFactor_, 1.0D / CefBrowserOsr.this.scaleFactor_);
/* 541 */             AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, 2);
/*     */             
/* 543 */             bufferedImage1 = affineTransformOp.filter(bufferedImage, bufferedImage1);
/* 544 */             return bufferedImage1;
/*     */           } 
/* 546 */           return bufferedImage;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 551 */     if (SwingUtilities.isEventDispatchThread()) {
/*     */       
/*     */       try {
/* 554 */         BufferedImage bufferedImage = pixelGrabberCallable.call();
/* 555 */         return CompletableFuture.completedFuture(bufferedImage);
/* 556 */       } catch (Exception exception) {
/* 557 */         CompletableFuture<BufferedImage> completableFuture1 = new CompletableFuture();
/* 558 */         completableFuture1.completeExceptionally(exception);
/* 559 */         return completableFuture1;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 567 */     final CompletableFuture<BufferedImage> future = new CompletableFuture<BufferedImage>() {
/*     */         private void safeguardGet() {
/* 569 */           if (SwingUtilities.isEventDispatchThread()) {
/* 570 */             throw new RuntimeException("Waiting on this Future using the AWT Event Thread is illegal, because it can potentially deadlock the thread.");
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public BufferedImage get() throws InterruptedException, ExecutionException {
/* 578 */           safeguardGet();
/* 579 */           return super.get();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public BufferedImage get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/* 585 */           safeguardGet();
/* 586 */           return super.get(param1Long, param1TimeUnit);
/*     */         }
/*     */       };
/* 589 */     this.canvas_.addGLEventListener(new GLEventListener()
/*     */         {
/*     */           public void reshape(GLAutoDrawable param1GLAutoDrawable, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void init(GLAutoDrawable param1GLAutoDrawable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void dispose(GLAutoDrawable param1GLAutoDrawable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void display(GLAutoDrawable param1GLAutoDrawable) {
/* 608 */             CefBrowserOsr.this.canvas_.removeGLEventListener(this);
/*     */             try {
/* 610 */               future.complete(pixelGrabberCallable.call());
/* 611 */             } catch (Exception exception) {
/* 612 */               future.completeExceptionally(exception);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 619 */     this.canvas_.repaint();
/*     */     
/* 621 */     return future;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefBrowserOsr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */