/*     */ package org.cef.browser;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.Vector;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.cef.CefClient;
/*     */ import org.cef.callback.CefDragData;
/*     */ import org.cef.callback.CefNativeAdapter;
/*     */ import org.cef.callback.CefPdfPrintCallback;
/*     */ import org.cef.callback.CefRunFileDialogCallback;
/*     */ import org.cef.callback.CefStringVisitor;
/*     */ import org.cef.handler.CefClientHandler;
/*     */ import org.cef.handler.CefDialogHandler;
/*     */ import org.cef.handler.CefRenderHandler;
/*     */ import org.cef.handler.CefWindowHandler;
/*     */ import org.cef.misc.CefPdfPrintSettings;
/*     */ import org.cef.network.CefRequest;
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
/*     */ abstract class CefBrowser_N
/*     */   extends CefNativeAdapter
/*     */   implements CefBrowser
/*     */ {
/*     */   private volatile boolean isPending_ = false;
/*     */   private final CefClient client_;
/*     */   private final String url_;
/*     */   private final CefRequestContext request_context_;
/*  45 */   private volatile CefBrowser_N parent_ = null;
/*  46 */   private volatile Point inspectAt_ = null;
/*  47 */   private volatile CefBrowser_N devTools_ = null;
/*     */   
/*     */   private boolean closeAllowed_ = false;
/*     */   private volatile boolean isClosed_ = false;
/*     */   private volatile boolean isClosing_ = false;
/*     */   
/*     */   protected CefBrowser_N(CefClient paramCefClient, String paramString, CefRequestContext paramCefRequestContext, CefBrowser_N paramCefBrowser_N, Point paramPoint) {
/*  54 */     this.client_ = paramCefClient;
/*  55 */     this.url_ = paramString;
/*  56 */     this.request_context_ = paramCefRequestContext;
/*  57 */     this.parent_ = paramCefBrowser_N;
/*  58 */     this.inspectAt_ = paramPoint;
/*     */   }
/*     */   
/*     */   protected String getUrl() {
/*  62 */     return this.url_;
/*     */   }
/*     */   
/*     */   protected CefRequestContext getRequestContext() {
/*  66 */     return this.request_context_;
/*     */   }
/*     */   
/*     */   protected CefBrowser_N getParentBrowser() {
/*  70 */     return this.parent_;
/*     */   }
/*     */   
/*     */   protected Point getInspectAt() {
/*  74 */     return this.inspectAt_;
/*     */   }
/*     */   
/*     */   protected boolean isClosed() {
/*  78 */     return this.isClosed_;
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient getClient() {
/*  83 */     return this.client_;
/*     */   }
/*     */ 
/*     */   
/*     */   public CefRenderHandler getRenderHandler() {
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CefWindowHandler getWindowHandler() {
/*  93 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setCloseAllowed() {
/*  98 */     this.closeAllowed_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean doClose() {
/* 103 */     if (this.closeAllowed_)
/*     */     {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 112 */             Component component = SwingUtilities.getRoot(CefBrowser_N.this.getUIComponent());
/* 113 */             if (component != null) {
/* 114 */               component.dispatchEvent(new WindowEvent((Window)component, 201));
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void onBeforeClose() {
/* 126 */     this.isClosed_ = true;
/* 127 */     if (this.request_context_ != null) this.request_context_.dispose(); 
/* 128 */     if (this.parent_ != null) {
/* 129 */       this.parent_.closeDevTools();
/* 130 */       this.parent_.devTools_ = null;
/* 131 */       this.parent_ = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefBrowser getDevTools() {
/* 137 */     return getDevTools(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized CefBrowser getDevTools(Point paramPoint) {
/* 142 */     if (this.devTools_ == null) {
/* 143 */       this.devTools_ = createDevToolsBrowser(this.client_, this.url_, this.request_context_, this, paramPoint);
/*     */     }
/* 145 */     return this.devTools_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefBrowser_N createDevToolsBrowser(CefClient paramCefClient, String paramString, CefRequestContext paramCefRequestContext, CefBrowser_N paramCefBrowser_N, Point paramPoint);
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createBrowser(CefClientHandler paramCefClientHandler, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, Component paramComponent, CefRequestContext paramCefRequestContext) {
/* 156 */     if (getNativeRef("CefBrowser") == 0L && !this.isPending_) {
/*     */       try {
/* 158 */         N_CreateBrowser(paramCefClientHandler, paramLong, paramString, paramBoolean1, paramBoolean2, paramComponent, paramCefRequestContext);
/*     */       }
/* 160 */       catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 161 */         unsatisfiedLinkError.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void notifyBrowserCreated() {
/* 170 */     this.isPending_ = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void createDevTools(CefBrowser_N paramCefBrowser_N, CefClientHandler paramCefClientHandler, long paramLong, boolean paramBoolean1, boolean paramBoolean2, Component paramComponent, Point paramPoint) {
/* 179 */     if (getNativeRef("CefBrowser") == 0L && !this.isPending_) {
/*     */       try {
/* 181 */         this.isPending_ = N_CreateDevTools(paramCefBrowser_N, paramCefClientHandler, paramLong, paramBoolean1, paramBoolean2, paramComponent, paramPoint);
/*     */       }
/* 183 */       catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 184 */         unsatisfiedLinkError.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final long getWindowHandle(long paramLong) {
/*     */     try {
/* 194 */       return N_GetWindowHandle(paramLong);
/* 195 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 196 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 198 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 203 */     close(true);
/* 204 */     super.finalize();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGoBack() {
/*     */     try {
/* 210 */       return N_CanGoBack();
/* 211 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 212 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 214 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void goBack() {
/*     */     try {
/* 220 */       N_GoBack();
/* 221 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 222 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGoForward() {
/*     */     try {
/* 229 */       return N_CanGoForward();
/* 230 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 231 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 233 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void goForward() {
/*     */     try {
/* 239 */       N_GoForward();
/* 240 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 241 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLoading() {
/*     */     try {
/* 248 */       return N_IsLoading();
/* 249 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 250 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 252 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void reload() {
/*     */     try {
/* 258 */       N_Reload();
/* 259 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 260 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void reloadIgnoreCache() {
/*     */     try {
/* 267 */       N_ReloadIgnoreCache();
/* 268 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 269 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopLoad() {
/*     */     try {
/* 276 */       N_StopLoad();
/* 277 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 278 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIdentifier() {
/*     */     try {
/* 285 */       return N_GetIdentifier();
/* 286 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 287 */       unsatisfiedLinkError.printStackTrace();
/* 288 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefFrame getMainFrame() {
/*     */     try {
/* 295 */       return N_GetMainFrame();
/* 296 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 297 */       unsatisfiedLinkError.printStackTrace();
/* 298 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefFrame getFocusedFrame() {
/*     */     try {
/* 305 */       return N_GetFocusedFrame();
/* 306 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 307 */       unsatisfiedLinkError.printStackTrace();
/* 308 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefFrame getFrame(long paramLong) {
/*     */     try {
/* 315 */       return N_GetFrame(paramLong);
/* 316 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 317 */       unsatisfiedLinkError.printStackTrace();
/* 318 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefFrame getFrame(String paramString) {
/*     */     try {
/* 325 */       return N_GetFrame2(paramString);
/* 326 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 327 */       unsatisfiedLinkError.printStackTrace();
/* 328 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector<Long> getFrameIdentifiers() {
/*     */     try {
/* 335 */       return N_GetFrameIdentifiers();
/* 336 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 337 */       unsatisfiedLinkError.printStackTrace();
/* 338 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector<String> getFrameNames() {
/*     */     try {
/* 345 */       return N_GetFrameNames();
/* 346 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 347 */       unsatisfiedLinkError.printStackTrace();
/* 348 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFrameCount() {
/*     */     try {
/* 355 */       return N_GetFrameCount();
/* 356 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 357 */       unsatisfiedLinkError.printStackTrace();
/* 358 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPopup() {
/*     */     try {
/* 365 */       return N_IsPopup();
/* 366 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 367 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 369 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasDocument() {
/*     */     try {
/* 375 */       return N_HasDocument();
/* 376 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 377 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 379 */       return false;
/*     */     } 
/*     */   }
/*     */   public void viewSource() {
/*     */     try {
/* 384 */       N_ViewSource();
/* 385 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 386 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getSource(CefStringVisitor paramCefStringVisitor) {
/*     */     try {
/* 392 */       N_GetSource(paramCefStringVisitor);
/* 393 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 394 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getText(CefStringVisitor paramCefStringVisitor) {
/*     */     try {
/* 400 */       N_GetText(paramCefStringVisitor);
/* 401 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 402 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadHTTPRequest(CefRequest paramCefRequest) {
/*     */     try {
/* 409 */       N_LoadRequest(paramCefRequest);
/* 410 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 411 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadURL(String paramString) {
/*     */     try {
/* 418 */       N_LoadURL(paramString);
/* 419 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 420 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeJavaScript(String paramString1, String paramString2, int paramInt) {
/*     */     try {
/* 427 */       N_ExecuteJavaScript(paramString1, paramString2, paramInt);
/* 428 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 429 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getURL() {
/*     */     try {
/* 436 */       return N_GetURL();
/* 437 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 438 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 440 */       return "";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close(boolean paramBoolean) {
/* 445 */     if (this.isClosing_ || this.isClosed_)
/* 446 */       return;  if (paramBoolean) this.isClosing_ = true;
/*     */     
/*     */     try {
/* 449 */       N_Close(paramBoolean);
/* 450 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 451 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFocus(boolean paramBoolean) {
/*     */     try {
/* 458 */       N_SetFocus(paramBoolean);
/* 459 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 460 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWindowVisibility(boolean paramBoolean) {
/*     */     try {
/* 467 */       N_SetWindowVisibility(paramBoolean);
/* 468 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 469 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double getZoomLevel() {
/*     */     try {
/* 476 */       return N_GetZoomLevel();
/* 477 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 478 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 480 */       return 0.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setZoomLevel(double paramDouble) {
/*     */     try {
/* 486 */       N_SetZoomLevel(paramDouble);
/* 487 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 488 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void runFileDialog(CefDialogHandler.FileDialogMode paramFileDialogMode, String paramString1, String paramString2, Vector<String> paramVector, int paramInt, CefRunFileDialogCallback paramCefRunFileDialogCallback) {
/*     */     try {
/* 497 */       N_RunFileDialog(paramFileDialogMode, paramString1, paramString2, paramVector, paramInt, paramCefRunFileDialogCallback);
/*     */     }
/* 499 */     catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 500 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void startDownload(String paramString) {
/*     */     try {
/* 507 */       N_StartDownload(paramString);
/* 508 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 509 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void print() {
/*     */     try {
/* 516 */       N_Print();
/* 517 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 518 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void printToPDF(String paramString, CefPdfPrintSettings paramCefPdfPrintSettings, CefPdfPrintCallback paramCefPdfPrintCallback) {
/* 525 */     if (paramString == null || paramString.isEmpty()) {
/* 526 */       throw new IllegalArgumentException("path was null or empty");
/*     */     }
/*     */     try {
/* 529 */       N_PrintToPDF(paramString, paramCefPdfPrintSettings, paramCefPdfPrintCallback);
/* 530 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 531 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void find(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*     */     try {
/* 539 */       N_Find(paramInt, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
/* 540 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 541 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopFinding(boolean paramBoolean) {
/*     */     try {
/* 548 */       N_StopFinding(paramBoolean);
/* 549 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 550 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void closeDevTools() {
/*     */     try {
/* 556 */       N_CloseDevTools();
/* 557 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 558 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceMisspelling(String paramString) {
/*     */     try {
/* 565 */       N_ReplaceMisspelling(paramString);
/* 566 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 567 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void wasResized(int paramInt1, int paramInt2) {
/*     */     try {
/* 578 */       N_WasResized(paramInt1, paramInt2);
/* 579 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 580 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void invalidate() {
/*     */     try {
/* 589 */       N_Invalidate();
/* 590 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 591 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void sendKeyEvent(KeyEvent paramKeyEvent) {
/*     */     try {
/* 601 */       N_SendKeyEvent(paramKeyEvent);
/* 602 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 603 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void sendMouseEvent(MouseEvent paramMouseEvent) {
/*     */     try {
/* 613 */       N_SendMouseEvent(paramMouseEvent);
/* 614 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 615 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void sendMouseWheelEvent(MouseWheelEvent paramMouseWheelEvent) {
/*     */     try {
/* 625 */       N_SendMouseWheelEvent(paramMouseWheelEvent);
/* 626 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 627 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
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
/*     */   protected final void dragTargetDragEnter(CefDragData paramCefDragData, Point paramPoint, int paramInt1, int paramInt2) {
/*     */     try {
/* 643 */       N_DragTargetDragEnter(paramCefDragData, paramPoint, paramInt1, paramInt2);
/* 644 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 645 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void dragTargetDragOver(Point paramPoint, int paramInt1, int paramInt2) {
/*     */     try {
/* 657 */       N_DragTargetDragOver(paramPoint, paramInt1, paramInt2);
/* 658 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 659 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void dragTargetDragLeave() {
/*     */     try {
/* 670 */       N_DragTargetDragLeave();
/* 671 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 672 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void dragTargetDrop(Point paramPoint, int paramInt) {
/*     */     try {
/* 685 */       N_DragTargetDrop(paramPoint, paramInt);
/* 686 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 687 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
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
/*     */   protected final void dragSourceEndedAt(Point paramPoint, int paramInt) {
/*     */     try {
/* 702 */       N_DragSourceEndedAt(paramPoint, paramInt);
/* 703 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 704 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
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
/*     */   protected final void dragSourceSystemDragEnded() {
/*     */     try {
/* 719 */       N_DragSourceSystemDragEnded();
/* 720 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 721 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void updateUI(Rectangle paramRectangle1, Rectangle paramRectangle2) {
/*     */     try {
/* 727 */       N_UpdateUI(paramRectangle1, paramRectangle2);
/* 728 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 729 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void setParent(long paramLong, Component paramComponent) {
/* 734 */     if (this.isClosing_ || this.isClosed_)
/*     */       return; 
/*     */     try {
/* 737 */       N_SetParent(paramLong, paramComponent);
/* 738 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 739 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void notifyMoveOrResizeStarted() {
/*     */     try {
/* 749 */       N_NotifyMoveOrResizeStarted();
/* 750 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 751 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private final native boolean N_CreateBrowser(CefClientHandler paramCefClientHandler, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, Component paramComponent, CefRequestContext paramCefRequestContext);
/*     */   
/*     */   private final native boolean N_CreateDevTools(CefBrowser paramCefBrowser, CefClientHandler paramCefClientHandler, long paramLong, boolean paramBoolean1, boolean paramBoolean2, Component paramComponent, Point paramPoint);
/*     */   
/*     */   private final native long N_GetWindowHandle(long paramLong);
/*     */   
/*     */   private final native boolean N_CanGoBack();
/*     */   
/*     */   private final native void N_GoBack();
/*     */   
/*     */   private final native boolean N_CanGoForward();
/*     */   
/*     */   private final native void N_GoForward();
/*     */   
/*     */   private final native boolean N_IsLoading();
/*     */   
/*     */   private final native void N_Reload();
/*     */   
/*     */   private final native void N_ReloadIgnoreCache();
/*     */   
/*     */   private final native void N_StopLoad();
/*     */   
/*     */   private final native int N_GetIdentifier();
/*     */   
/*     */   private final native CefFrame N_GetMainFrame();
/*     */   
/*     */   private final native CefFrame N_GetFocusedFrame();
/*     */   
/*     */   private final native CefFrame N_GetFrame(long paramLong);
/*     */   
/*     */   private final native CefFrame N_GetFrame2(String paramString);
/*     */   
/*     */   private final native Vector<Long> N_GetFrameIdentifiers();
/*     */   
/*     */   private final native Vector<String> N_GetFrameNames();
/*     */   
/*     */   private final native int N_GetFrameCount();
/*     */   
/*     */   private final native boolean N_IsPopup();
/*     */   
/*     */   private final native boolean N_HasDocument();
/*     */   
/*     */   private final native void N_ViewSource();
/*     */   
/*     */   private final native void N_GetSource(CefStringVisitor paramCefStringVisitor);
/*     */   
/*     */   private final native void N_GetText(CefStringVisitor paramCefStringVisitor);
/*     */   
/*     */   private final native void N_LoadRequest(CefRequest paramCefRequest);
/*     */   
/*     */   private final native void N_LoadURL(String paramString);
/*     */   
/*     */   private final native void N_ExecuteJavaScript(String paramString1, String paramString2, int paramInt);
/*     */   
/*     */   private final native String N_GetURL();
/*     */   
/*     */   private final native void N_Close(boolean paramBoolean);
/*     */   
/*     */   private final native void N_SetFocus(boolean paramBoolean);
/*     */   
/*     */   private final native void N_SetWindowVisibility(boolean paramBoolean);
/*     */   
/*     */   private final native double N_GetZoomLevel();
/*     */   
/*     */   private final native void N_SetZoomLevel(double paramDouble);
/*     */   
/*     */   private final native void N_RunFileDialog(CefDialogHandler.FileDialogMode paramFileDialogMode, String paramString1, String paramString2, Vector<String> paramVector, int paramInt, CefRunFileDialogCallback paramCefRunFileDialogCallback);
/*     */   
/*     */   private final native void N_StartDownload(String paramString);
/*     */   
/*     */   private final native void N_Print();
/*     */   
/*     */   private final native void N_PrintToPDF(String paramString, CefPdfPrintSettings paramCefPdfPrintSettings, CefPdfPrintCallback paramCefPdfPrintCallback);
/*     */   
/*     */   private final native void N_Find(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*     */   
/*     */   private final native void N_StopFinding(boolean paramBoolean);
/*     */   
/*     */   private final native void N_CloseDevTools();
/*     */   
/*     */   private final native void N_ReplaceMisspelling(String paramString);
/*     */   
/*     */   private final native void N_WasResized(int paramInt1, int paramInt2);
/*     */   
/*     */   private final native void N_Invalidate();
/*     */   
/*     */   private final native void N_SendKeyEvent(KeyEvent paramKeyEvent);
/*     */   
/*     */   private final native void N_SendMouseEvent(MouseEvent paramMouseEvent);
/*     */   
/*     */   private final native void N_SendMouseWheelEvent(MouseWheelEvent paramMouseWheelEvent);
/*     */   
/*     */   private final native void N_DragTargetDragEnter(CefDragData paramCefDragData, Point paramPoint, int paramInt1, int paramInt2);
/*     */   
/*     */   private final native void N_DragTargetDragOver(Point paramPoint, int paramInt1, int paramInt2);
/*     */   
/*     */   private final native void N_DragTargetDragLeave();
/*     */   
/*     */   private final native void N_DragTargetDrop(Point paramPoint, int paramInt);
/*     */   
/*     */   private final native void N_DragSourceEndedAt(Point paramPoint, int paramInt);
/*     */   
/*     */   private final native void N_DragSourceSystemDragEnded();
/*     */   
/*     */   private final native void N_UpdateUI(Rectangle paramRectangle1, Rectangle paramRectangle2);
/*     */   
/*     */   private final native void N_SetParent(long paramLong, Component paramComponent);
/*     */   
/*     */   private final native void N_NotifyMoveOrResizeStarted();
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefBrowser_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */