/*     */ package org.cef;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FocusTraversalPolicy;
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ import org.cef.browser.CefBrowser;
/*     */ import org.cef.browser.CefBrowserFactory;
/*     */ import org.cef.browser.CefFrame;
/*     */ import org.cef.browser.CefMessageRouter;
/*     */ import org.cef.browser.CefRequestContext;
/*     */ import org.cef.callback.CefAuthCallback;
/*     */ import org.cef.callback.CefBeforeDownloadCallback;
/*     */ import org.cef.callback.CefContextMenuParams;
/*     */ import org.cef.callback.CefDownloadItem;
/*     */ import org.cef.callback.CefDownloadItemCallback;
/*     */ import org.cef.callback.CefDragData;
/*     */ import org.cef.callback.CefFileDialogCallback;
/*     */ import org.cef.callback.CefJSDialogCallback;
/*     */ import org.cef.callback.CefMenuModel;
/*     */ import org.cef.callback.CefPrintDialogCallback;
/*     */ import org.cef.callback.CefPrintJobCallback;
/*     */ import org.cef.callback.CefRequestCallback;
/*     */ import org.cef.handler.CefClientHandler;
/*     */ import org.cef.handler.CefContextMenuHandler;
/*     */ import org.cef.handler.CefDialogHandler;
/*     */ import org.cef.handler.CefDisplayHandler;
/*     */ import org.cef.handler.CefDownloadHandler;
/*     */ import org.cef.handler.CefDragHandler;
/*     */ import org.cef.handler.CefFocusHandler;
/*     */ import org.cef.handler.CefJSDialogHandler;
/*     */ import org.cef.handler.CefKeyboardHandler;
/*     */ import org.cef.handler.CefLifeSpanHandler;
/*     */ import org.cef.handler.CefLoadHandler;
/*     */ import org.cef.handler.CefPrintHandler;
/*     */ import org.cef.handler.CefRenderHandler;
/*     */ import org.cef.handler.CefRequestHandler;
/*     */ import org.cef.handler.CefResourceRequestHandler;
/*     */ import org.cef.handler.CefScreenInfo;
/*     */ import org.cef.handler.CefWindowHandler;
/*     */ import org.cef.misc.BoolRef;
/*     */ import org.cef.misc.CefPrintSettings;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CefClient
/*     */   extends CefClientHandler
/*     */   implements CefContextMenuHandler, CefDialogHandler, CefDisplayHandler, CefDownloadHandler, CefDragHandler, CefFocusHandler, CefJSDialogHandler, CefKeyboardHandler, CefLifeSpanHandler, CefLoadHandler, CefPrintHandler, CefRenderHandler, CefRequestHandler, CefWindowHandler
/*     */ {
/*  75 */   private final HashMap<Integer, CefBrowser> browser_ = new HashMap<>();
/*  76 */   private CefContextMenuHandler contextMenuHandler_ = null;
/*  77 */   private CefDialogHandler dialogHandler_ = null;
/*  78 */   private CefDisplayHandler displayHandler_ = null;
/*  79 */   private CefDownloadHandler downloadHandler_ = null;
/*  80 */   private CefDragHandler dragHandler_ = null;
/*  81 */   private CefFocusHandler focusHandler_ = null;
/*  82 */   private CefJSDialogHandler jsDialogHandler_ = null;
/*  83 */   private CefKeyboardHandler keyboardHandler_ = null;
/*  84 */   private CefLifeSpanHandler lifeSpanHandler_ = null;
/*  85 */   private CefLoadHandler loadHandler_ = null;
/*  86 */   private CefPrintHandler printHandler_ = null;
/*  87 */   private CefRequestHandler requestHandler_ = null;
/*     */   private boolean isDisposed_ = false;
/*  89 */   private volatile CefBrowser focusedBrowser_ = null;
/*  90 */   private final PropertyChangeListener propertyChangeListener = new PropertyChangeListener()
/*     */     {
/*     */       public void propertyChange(PropertyChangeEvent param1PropertyChangeEvent) {
/*  93 */         if (CefClient.this.focusedBrowser_ != null) {
/*  94 */           Component component = CefClient.this.focusedBrowser_.getUIComponent();
/*  95 */           Object object = param1PropertyChangeEvent.getOldValue();
/*  96 */           if (CefClient.this.isPartOf(object, component)) {
/*  97 */             CefClient.this.focusedBrowser_.setFocus(false);
/*  98 */             CefClient.this.focusedBrowser_ = null;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CefClient() throws UnsatisfiedLinkError {
/* 113 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener(this.propertyChangeListener);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isPartOf(Object paramObject, Component paramComponent) {
/* 118 */     if (paramObject == paramComponent) return true; 
/* 119 */     if (paramObject instanceof Container) {
/* 120 */       Component[] arrayOfComponent1 = ((Container)paramObject).getComponents();
/* 121 */       Component[] arrayOfComponent2 = arrayOfComponent1; int i = arrayOfComponent2.length; byte b = 0; if (b < i) { Component component = arrayOfComponent2[b];
/* 122 */         return isPartOf(component, paramComponent); }
/*     */     
/*     */     } 
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 130 */     this.isDisposed_ = true;
/* 131 */     cleanupBrowser(-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CefBrowser createBrowser(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 138 */     return createBrowser(paramString, paramBoolean1, paramBoolean2, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public CefBrowser createBrowser(String paramString, boolean paramBoolean1, boolean paramBoolean2, CefRequestContext paramCefRequestContext) {
/* 143 */     if (this.isDisposed_)
/* 144 */       throw new IllegalStateException("Can't create browser. CefClient is disposed"); 
/* 145 */     return CefBrowserFactory.create(this, paramString, paramBoolean1, paramBoolean2, paramCefRequestContext);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefBrowser getBrowser(int paramInt) {
/* 150 */     synchronized (this.browser_) {
/* 151 */       return this.browser_.get(Integer.valueOf(paramInt));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object[] getAllBrowser() {
/* 157 */     synchronized (this.browser_) {
/* 158 */       return this.browser_.values().toArray();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefContextMenuHandler getContextMenuHandler() {
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefDialogHandler getDialogHandler() {
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefDisplayHandler getDisplayHandler() {
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefDownloadHandler getDownloadHandler() {
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefDragHandler getDragHandler() {
/* 184 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefFocusHandler getFocusHandler() {
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefJSDialogHandler getJSDialogHandler() {
/* 194 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefKeyboardHandler getKeyboardHandler() {
/* 199 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefLifeSpanHandler getLifeSpanHandler() {
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefLoadHandler getLoadHandler() {
/* 209 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefPrintHandler getPrintHandler() {
/* 214 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefRenderHandler getRenderHandler() {
/* 219 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefRequestHandler getRequestHandler() {
/* 224 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CefWindowHandler getWindowHandler() {
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CefClient addContextMenuHandler(CefContextMenuHandler paramCefContextMenuHandler) {
/* 235 */     if (this.contextMenuHandler_ == null) this.contextMenuHandler_ = paramCefContextMenuHandler; 
/* 236 */     return this;
/*     */   }
/*     */   
/*     */   public void removeContextMenuHandler() {
/* 240 */     this.contextMenuHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBeforeContextMenu(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefContextMenuParams paramCefContextMenuParams, CefMenuModel paramCefMenuModel) {
/* 246 */     if (this.contextMenuHandler_ != null && paramCefBrowser != null) {
/* 247 */       this.contextMenuHandler_.onBeforeContextMenu(paramCefBrowser, paramCefFrame, paramCefContextMenuParams, paramCefMenuModel);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onContextMenuCommand(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefContextMenuParams paramCefContextMenuParams, int paramInt1, int paramInt2) {
/* 253 */     if (this.contextMenuHandler_ != null && paramCefBrowser != null) {
/* 254 */       return this.contextMenuHandler_.onContextMenuCommand(paramCefBrowser, paramCefFrame, paramCefContextMenuParams, paramInt1, paramInt2);
/*     */     }
/* 256 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onContextMenuDismissed(CefBrowser paramCefBrowser, CefFrame paramCefFrame) {
/* 261 */     if (this.contextMenuHandler_ != null && paramCefBrowser != null) {
/* 262 */       this.contextMenuHandler_.onContextMenuDismissed(paramCefBrowser, paramCefFrame);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient addDialogHandler(CefDialogHandler paramCefDialogHandler) {
/* 268 */     if (this.dialogHandler_ == null) this.dialogHandler_ = paramCefDialogHandler; 
/* 269 */     return this;
/*     */   }
/*     */   
/*     */   public void removeDialogHandler() {
/* 273 */     this.dialogHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onFileDialog(CefBrowser paramCefBrowser, FileDialogMode paramFileDialogMode, String paramString1, String paramString2, Vector<String> paramVector, int paramInt, CefFileDialogCallback paramCefFileDialogCallback) {
/* 280 */     if (this.dialogHandler_ != null && paramCefBrowser != null) {
/* 281 */       return this.dialogHandler_.onFileDialog(paramCefBrowser, paramFileDialogMode, paramString1, paramString2, paramVector, paramInt, paramCefFileDialogCallback);
/*     */     }
/*     */     
/* 284 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CefClient addDisplayHandler(CefDisplayHandler paramCefDisplayHandler) {
/* 290 */     if (this.displayHandler_ == null) this.displayHandler_ = paramCefDisplayHandler; 
/* 291 */     return this;
/*     */   }
/*     */   
/*     */   public void removeDisplayHandler() {
/* 295 */     this.displayHandler_ = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onAddressChange(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString) {
/* 300 */     if (this.displayHandler_ != null && paramCefBrowser != null) {
/* 301 */       this.displayHandler_.onAddressChange(paramCefBrowser, paramCefFrame, paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onTitleChange(CefBrowser paramCefBrowser, String paramString) {
/* 306 */     if (this.displayHandler_ != null && paramCefBrowser != null) {
/* 307 */       this.displayHandler_.onTitleChange(paramCefBrowser, paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onTooltip(CefBrowser paramCefBrowser, String paramString) {
/* 312 */     if (this.displayHandler_ != null && paramCefBrowser != null) {
/* 313 */       return this.displayHandler_.onTooltip(paramCefBrowser, paramString);
/*     */     }
/* 315 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onStatusMessage(CefBrowser paramCefBrowser, String paramString) {
/* 320 */     if (this.displayHandler_ != null && paramCefBrowser != null) {
/* 321 */       this.displayHandler_.onStatusMessage(paramCefBrowser, paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onConsoleMessage(CefBrowser paramCefBrowser, CefSettings.LogSeverity paramLogSeverity, String paramString1, String paramString2, int paramInt) {
/* 328 */     if (this.displayHandler_ != null && paramCefBrowser != null) {
/* 329 */       return this.displayHandler_.onConsoleMessage(paramCefBrowser, paramLogSeverity, paramString1, paramString2, paramInt);
/*     */     }
/* 331 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onCursorChange(CefBrowser paramCefBrowser, int paramInt) {
/* 336 */     if (paramCefBrowser == null) {
/* 337 */       return false;
/*     */     }
/*     */     
/* 340 */     if (this.displayHandler_ != null && this.displayHandler_.onCursorChange(paramCefBrowser, paramInt)) {
/* 341 */       return true;
/*     */     }
/*     */     
/* 344 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 345 */     if (cefRenderHandler != null) {
/* 346 */       return cefRenderHandler.onCursorChange(paramCefBrowser, paramInt);
/*     */     }
/*     */     
/* 349 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CefClient addDownloadHandler(CefDownloadHandler paramCefDownloadHandler) {
/* 355 */     if (this.downloadHandler_ == null) this.downloadHandler_ = paramCefDownloadHandler; 
/* 356 */     return this;
/*     */   }
/*     */   
/*     */   public void removeDownloadHandler() {
/* 360 */     this.downloadHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBeforeDownload(CefBrowser paramCefBrowser, CefDownloadItem paramCefDownloadItem, String paramString, CefBeforeDownloadCallback paramCefBeforeDownloadCallback) {
/* 366 */     if (this.downloadHandler_ != null && paramCefBrowser != null) {
/* 367 */       this.downloadHandler_.onBeforeDownload(paramCefBrowser, paramCefDownloadItem, paramString, paramCefBeforeDownloadCallback);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDownloadUpdated(CefBrowser paramCefBrowser, CefDownloadItem paramCefDownloadItem, CefDownloadItemCallback paramCefDownloadItemCallback) {
/* 373 */     if (this.downloadHandler_ != null && paramCefBrowser != null) {
/* 374 */       this.downloadHandler_.onDownloadUpdated(paramCefBrowser, paramCefDownloadItem, paramCefDownloadItemCallback);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient addDragHandler(CefDragHandler paramCefDragHandler) {
/* 380 */     if (this.dragHandler_ == null) this.dragHandler_ = paramCefDragHandler; 
/* 381 */     return this;
/*     */   }
/*     */   
/*     */   public void removeDragHandler() {
/* 385 */     this.dragHandler_ = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onDragEnter(CefBrowser paramCefBrowser, CefDragData paramCefDragData, int paramInt) {
/* 390 */     if (this.dragHandler_ != null && paramCefBrowser != null)
/* 391 */       return this.dragHandler_.onDragEnter(paramCefBrowser, paramCefDragData, paramInt); 
/* 392 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CefClient addFocusHandler(CefFocusHandler paramCefFocusHandler) {
/* 398 */     if (this.focusHandler_ == null) this.focusHandler_ = paramCefFocusHandler; 
/* 399 */     return this;
/*     */   }
/*     */   
/*     */   public void removeFocusHandler() {
/* 403 */     this.focusHandler_ = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onTakeFocus(CefBrowser paramCefBrowser, boolean paramBoolean) {
/* 408 */     if (paramCefBrowser == null)
/*     */       return; 
/* 410 */     paramCefBrowser.setFocus(false);
/* 411 */     Container container = paramCefBrowser.getUIComponent().getParent();
/* 412 */     if (container != null) {
/* 413 */       FocusTraversalPolicy focusTraversalPolicy = null;
/* 414 */       while (container != null) {
/* 415 */         focusTraversalPolicy = container.getFocusTraversalPolicy();
/* 416 */         if (focusTraversalPolicy != null)
/* 417 */           break;  container = container.getParent();
/*     */       } 
/* 419 */       if (focusTraversalPolicy != null) {
/*     */ 
/*     */         
/* 422 */         Component component = paramBoolean ? focusTraversalPolicy.getComponentAfter(container, paramCefBrowser.getUIComponent()) : focusTraversalPolicy.getComponentBefore(container, paramCefBrowser.getUIComponent());
/* 423 */         if (component == null) {
/* 424 */           focusTraversalPolicy.getDefaultComponent(container).requestFocus();
/*     */         } else {
/* 426 */           component.requestFocus();
/*     */         } 
/*     */       } 
/*     */     } 
/* 430 */     this.focusedBrowser_ = null;
/* 431 */     if (this.focusHandler_ != null) this.focusHandler_.onTakeFocus(paramCefBrowser, paramBoolean);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean onSetFocus(CefBrowser paramCefBrowser, FocusSource paramFocusSource) {
/* 436 */     if (paramCefBrowser == null) return false;
/*     */     
/* 438 */     boolean bool = false;
/* 439 */     if (this.focusHandler_ != null) bool = this.focusHandler_.onSetFocus(paramCefBrowser, paramFocusSource); 
/* 440 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGotFocus(CefBrowser paramCefBrowser) {
/* 445 */     if (paramCefBrowser == null)
/*     */       return; 
/* 447 */     this.focusedBrowser_ = paramCefBrowser;
/* 448 */     paramCefBrowser.setFocus(true);
/* 449 */     if (this.focusHandler_ != null) this.focusHandler_.onGotFocus(paramCefBrowser);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient addJSDialogHandler(CefJSDialogHandler paramCefJSDialogHandler) {
/* 455 */     if (this.jsDialogHandler_ == null) this.jsDialogHandler_ = paramCefJSDialogHandler; 
/* 456 */     return this;
/*     */   }
/*     */   
/*     */   public void removeJSDialogHandler() {
/* 460 */     this.jsDialogHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onJSDialog(CefBrowser paramCefBrowser, String paramString1, JSDialogType paramJSDialogType, String paramString2, String paramString3, CefJSDialogCallback paramCefJSDialogCallback, BoolRef paramBoolRef) {
/* 467 */     if (this.jsDialogHandler_ != null && paramCefBrowser != null) {
/* 468 */       return this.jsDialogHandler_.onJSDialog(paramCefBrowser, paramString1, paramJSDialogType, paramString2, paramString3, paramCefJSDialogCallback, paramBoolRef);
/*     */     }
/* 470 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBeforeUnloadDialog(CefBrowser paramCefBrowser, String paramString, boolean paramBoolean, CefJSDialogCallback paramCefJSDialogCallback) {
/* 476 */     if (this.jsDialogHandler_ != null && paramCefBrowser != null) {
/* 477 */       return this.jsDialogHandler_.onBeforeUnloadDialog(paramCefBrowser, paramString, paramBoolean, paramCefJSDialogCallback);
/*     */     }
/* 479 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onResetDialogState(CefBrowser paramCefBrowser) {
/* 484 */     if (this.jsDialogHandler_ != null && paramCefBrowser != null) {
/* 485 */       this.jsDialogHandler_.onResetDialogState(paramCefBrowser);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onDialogClosed(CefBrowser paramCefBrowser) {
/* 490 */     if (this.jsDialogHandler_ != null && paramCefBrowser != null) this.jsDialogHandler_.onDialogClosed(paramCefBrowser);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient addKeyboardHandler(CefKeyboardHandler paramCefKeyboardHandler) {
/* 496 */     if (this.keyboardHandler_ == null) this.keyboardHandler_ = paramCefKeyboardHandler; 
/* 497 */     return this;
/*     */   }
/*     */   
/*     */   public void removeKeyboardHandler() {
/* 501 */     this.keyboardHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onPreKeyEvent(CefBrowser paramCefBrowser, CefKeyEvent paramCefKeyEvent, BoolRef paramBoolRef) {
/* 507 */     if (this.keyboardHandler_ != null && paramCefBrowser != null)
/* 508 */       return this.keyboardHandler_.onPreKeyEvent(paramCefBrowser, paramCefKeyEvent, paramBoolRef); 
/* 509 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onKeyEvent(CefBrowser paramCefBrowser, CefKeyEvent paramCefKeyEvent) {
/* 514 */     if (this.keyboardHandler_ != null && paramCefBrowser != null)
/* 515 */       return this.keyboardHandler_.onKeyEvent(paramCefBrowser, paramCefKeyEvent); 
/* 516 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CefClient addLifeSpanHandler(CefLifeSpanHandler paramCefLifeSpanHandler) {
/* 522 */     if (this.lifeSpanHandler_ == null) this.lifeSpanHandler_ = paramCefLifeSpanHandler; 
/* 523 */     return this;
/*     */   }
/*     */   
/*     */   public void removeLifeSpanHandler() {
/* 527 */     this.lifeSpanHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBeforePopup(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString1, String paramString2) {
/* 533 */     if (this.isDisposed_) return true; 
/* 534 */     if (this.lifeSpanHandler_ != null && paramCefBrowser != null)
/* 535 */       return this.lifeSpanHandler_.onBeforePopup(paramCefBrowser, paramCefFrame, paramString1, paramString2); 
/* 536 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onAfterCreated(CefBrowser paramCefBrowser) {
/* 541 */     if (paramCefBrowser == null) {
/*     */       return;
/*     */     }
/* 544 */     Integer integer = Integer.valueOf(paramCefBrowser.getIdentifier());
/* 545 */     synchronized (this.browser_) {
/* 546 */       this.browser_.put(integer, paramCefBrowser);
/*     */     } 
/* 548 */     if (this.lifeSpanHandler_ != null) this.lifeSpanHandler_.onAfterCreated(paramCefBrowser);
/*     */   
/*     */   }
/*     */   
/*     */   public void onAfterParentChanged(CefBrowser paramCefBrowser) {
/* 553 */     if (paramCefBrowser == null)
/* 554 */       return;  if (this.lifeSpanHandler_ != null) this.lifeSpanHandler_.onAfterParentChanged(paramCefBrowser);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean doClose(CefBrowser paramCefBrowser) {
/* 559 */     if (paramCefBrowser == null) return false; 
/* 560 */     if (this.lifeSpanHandler_ != null) return this.lifeSpanHandler_.doClose(paramCefBrowser); 
/* 561 */     return paramCefBrowser.doClose();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onBeforeClose(CefBrowser paramCefBrowser) {
/* 566 */     if (paramCefBrowser == null)
/* 567 */       return;  if (this.lifeSpanHandler_ != null) this.lifeSpanHandler_.onBeforeClose(paramCefBrowser); 
/* 568 */     paramCefBrowser.onBeforeClose();
/*     */ 
/*     */     
/* 571 */     cleanupBrowser(paramCefBrowser.getIdentifier());
/*     */   }
/*     */   
/*     */   private void cleanupBrowser(int paramInt) {
/* 575 */     synchronized (this.browser_) {
/* 576 */       if (paramInt >= 0) {
/*     */         
/* 578 */         this.browser_.remove(Integer.valueOf(paramInt));
/* 579 */       } else if (!this.browser_.isEmpty()) {
/*     */         
/* 581 */         Collection<CefBrowser> collection = this.browser_.values();
/* 582 */         for (CefBrowser cefBrowser : collection) {
/* 583 */           cefBrowser.close(true);
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 588 */       if (this.browser_.isEmpty() && this.isDisposed_) {
/* 589 */         KeyboardFocusManager.getCurrentKeyboardFocusManager().removePropertyChangeListener(this.propertyChangeListener);
/*     */         
/* 591 */         removeContextMenuHandler(this);
/* 592 */         removeDialogHandler(this);
/* 593 */         removeDisplayHandler(this);
/* 594 */         removeDownloadHandler(this);
/* 595 */         removeDragHandler(this);
/* 596 */         removeFocusHandler(this);
/* 597 */         removeJSDialogHandler(this);
/* 598 */         removeKeyboardHandler(this);
/* 599 */         removeLifeSpanHandler(this);
/* 600 */         removeLoadHandler(this);
/* 601 */         removePrintHandler(this);
/* 602 */         removeRenderHandler(this);
/* 603 */         removeRequestHandler(this);
/* 604 */         removeWindowHandler(this);
/* 605 */         super.dispose();
/*     */         
/* 607 */         CefApp.getInstance().clientWasDisposed(this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CefClient addLoadHandler(CefLoadHandler paramCefLoadHandler) {
/* 615 */     if (this.loadHandler_ == null) this.loadHandler_ = paramCefLoadHandler; 
/* 616 */     return this;
/*     */   }
/*     */   
/*     */   public void removeLoadHandler() {
/* 620 */     this.loadHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLoadingStateChange(CefBrowser paramCefBrowser, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 626 */     if (this.loadHandler_ != null && paramCefBrowser != null) {
/* 627 */       this.loadHandler_.onLoadingStateChange(paramCefBrowser, paramBoolean1, paramBoolean2, paramBoolean3);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onLoadStart(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest.TransitionType paramTransitionType) {
/* 632 */     if (this.loadHandler_ != null && paramCefBrowser != null) {
/* 633 */       this.loadHandler_.onLoadStart(paramCefBrowser, paramCefFrame, paramTransitionType);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onLoadEnd(CefBrowser paramCefBrowser, CefFrame paramCefFrame, int paramInt) {
/* 638 */     if (this.loadHandler_ != null && paramCefBrowser != null) {
/* 639 */       this.loadHandler_.onLoadEnd(paramCefBrowser, paramCefFrame, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLoadError(CefBrowser paramCefBrowser, CefFrame paramCefFrame, ErrorCode paramErrorCode, String paramString1, String paramString2) {
/* 645 */     if (this.loadHandler_ != null && paramCefBrowser != null) {
/* 646 */       this.loadHandler_.onLoadError(paramCefBrowser, paramCefFrame, paramErrorCode, paramString1, paramString2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient addPrintHandler(CefPrintHandler paramCefPrintHandler) {
/* 652 */     if (this.printHandler_ == null) this.printHandler_ = paramCefPrintHandler; 
/* 653 */     return this;
/*     */   }
/*     */   
/*     */   public void removePrintHandler() {
/* 657 */     this.printHandler_ = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPrintStart(CefBrowser paramCefBrowser) {
/* 662 */     if (this.printHandler_ != null && paramCefBrowser != null) this.printHandler_.onPrintStart(paramCefBrowser);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPrintSettings(CefBrowser paramCefBrowser, CefPrintSettings paramCefPrintSettings, boolean paramBoolean) {
/* 668 */     if (this.printHandler_ != null && paramCefBrowser != null) {
/* 669 */       this.printHandler_.onPrintSettings(paramCefBrowser, paramCefPrintSettings, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onPrintDialog(CefBrowser paramCefBrowser, boolean paramBoolean, CefPrintDialogCallback paramCefPrintDialogCallback) {
/* 675 */     if (this.printHandler_ != null && paramCefBrowser != null)
/* 676 */       return this.printHandler_.onPrintDialog(paramCefBrowser, paramBoolean, paramCefPrintDialogCallback); 
/* 677 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onPrintJob(CefBrowser paramCefBrowser, String paramString1, String paramString2, CefPrintJobCallback paramCefPrintJobCallback) {
/* 683 */     if (this.printHandler_ != null && paramCefBrowser != null)
/* 684 */       return this.printHandler_.onPrintJob(paramCefBrowser, paramString1, paramString2, paramCefPrintJobCallback); 
/* 685 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPrintReset(CefBrowser paramCefBrowser) {
/* 690 */     if (this.printHandler_ != null && paramCefBrowser != null) this.printHandler_.onPrintReset(paramCefBrowser);
/*     */   
/*     */   }
/*     */   
/*     */   public Dimension getPdfPaperSize(CefBrowser paramCefBrowser, int paramInt) {
/* 695 */     if (this.printHandler_ != null && paramCefBrowser != null)
/* 696 */       return this.printHandler_.getPdfPaperSize(paramCefBrowser, paramInt); 
/* 697 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void addMessageRouter(CefMessageRouter paramCefMessageRouter) {
/* 704 */     super.addMessageRouter(paramCefMessageRouter);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void removeMessageRouter(CefMessageRouter paramCefMessageRouter) {
/* 709 */     super.removeMessageRouter(paramCefMessageRouter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getViewRect(CefBrowser paramCefBrowser) {
/* 716 */     if (paramCefBrowser == null) return new Rectangle(0, 0, 0, 0);
/*     */     
/* 718 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 719 */     if (cefRenderHandler != null) return cefRenderHandler.getViewRect(paramCefBrowser); 
/* 720 */     return new Rectangle(0, 0, 0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Point getScreenPoint(CefBrowser paramCefBrowser, Point paramPoint) {
/* 725 */     if (paramCefBrowser == null) return new Point(0, 0);
/*     */     
/* 727 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 728 */     if (cefRenderHandler != null) return cefRenderHandler.getScreenPoint(paramCefBrowser, paramPoint); 
/* 729 */     return new Point(0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPopupShow(CefBrowser paramCefBrowser, boolean paramBoolean) {
/* 734 */     if (paramCefBrowser == null)
/*     */       return; 
/* 736 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 737 */     if (cefRenderHandler != null) cefRenderHandler.onPopupShow(paramCefBrowser, paramBoolean);
/*     */   
/*     */   }
/*     */   
/*     */   public void onPopupSize(CefBrowser paramCefBrowser, Rectangle paramRectangle) {
/* 742 */     if (paramCefBrowser == null)
/*     */       return; 
/* 744 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 745 */     if (cefRenderHandler != null) cefRenderHandler.onPopupSize(paramCefBrowser, paramRectangle);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPaint(CefBrowser paramCefBrowser, boolean paramBoolean, Rectangle[] paramArrayOfRectangle, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 751 */     if (paramCefBrowser == null)
/*     */       return; 
/* 753 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 754 */     if (cefRenderHandler != null) {
/* 755 */       cefRenderHandler.onPaint(paramCefBrowser, paramBoolean, paramArrayOfRectangle, paramByteBuffer, paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean startDragging(CefBrowser paramCefBrowser, CefDragData paramCefDragData, int paramInt1, int paramInt2, int paramInt3) {
/* 760 */     if (paramCefBrowser == null) return false;
/*     */     
/* 762 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 763 */     if (cefRenderHandler != null) return cefRenderHandler.startDragging(paramCefBrowser, paramCefDragData, paramInt1, paramInt2, paramInt3); 
/* 764 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateDragCursor(CefBrowser paramCefBrowser, int paramInt) {
/* 769 */     if (paramCefBrowser == null)
/*     */       return; 
/* 771 */     CefRenderHandler cefRenderHandler = paramCefBrowser.getRenderHandler();
/* 772 */     if (cefRenderHandler != null) cefRenderHandler.updateDragCursor(paramCefBrowser, paramInt);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public CefClient addRequestHandler(CefRequestHandler paramCefRequestHandler) {
/* 778 */     if (this.requestHandler_ == null) this.requestHandler_ = paramCefRequestHandler; 
/* 779 */     return this;
/*     */   }
/*     */   
/*     */   public void removeRequestHandler() {
/* 783 */     this.requestHandler_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBeforeBrowse(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2) {
/* 789 */     if (this.requestHandler_ != null && paramCefBrowser != null) {
/* 790 */       return this.requestHandler_.onBeforeBrowse(paramCefBrowser, paramCefFrame, paramCefRequest, paramBoolean1, paramBoolean2);
/*     */     }
/* 792 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onOpenURLFromTab(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString, boolean paramBoolean) {
/* 798 */     if (this.isDisposed_) return true; 
/* 799 */     if (this.requestHandler_ != null && paramCefBrowser != null)
/* 800 */       return this.requestHandler_.onOpenURLFromTab(paramCefBrowser, paramCefFrame, paramString, paramBoolean); 
/* 801 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CefResourceRequestHandler getResourceRequestHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2, String paramString, BoolRef paramBoolRef) {
/* 808 */     if (this.requestHandler_ != null && paramCefBrowser != null) {
/* 809 */       return this.requestHandler_.getResourceRequestHandler(paramCefBrowser, paramCefFrame, paramCefRequest, paramBoolean1, paramBoolean2, paramString, paramBoolRef);
/*     */     }
/*     */     
/* 812 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAuthCredentials(CefBrowser paramCefBrowser, String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, String paramString4, CefAuthCallback paramCefAuthCallback) {
/* 818 */     if (this.requestHandler_ != null && paramCefBrowser != null) {
/* 819 */       return this.requestHandler_.getAuthCredentials(paramCefBrowser, paramString1, paramBoolean, paramString2, paramInt, paramString3, paramString4, paramCefAuthCallback);
/*     */     }
/* 821 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onQuotaRequest(CefBrowser paramCefBrowser, String paramString, long paramLong, CefRequestCallback paramCefRequestCallback) {
/* 827 */     if (this.requestHandler_ != null && paramCefBrowser != null)
/* 828 */       return this.requestHandler_.onQuotaRequest(paramCefBrowser, paramString, paramLong, paramCefRequestCallback); 
/* 829 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onCertificateError(CefBrowser paramCefBrowser, ErrorCode paramErrorCode, String paramString, CefRequestCallback paramCefRequestCallback) {
/* 835 */     if (this.requestHandler_ != null)
/* 836 */       return this.requestHandler_.onCertificateError(paramCefBrowser, paramErrorCode, paramString, paramCefRequestCallback); 
/* 837 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPluginCrashed(CefBrowser paramCefBrowser, String paramString) {
/* 842 */     if (this.requestHandler_ != null) this.requestHandler_.onPluginCrashed(paramCefBrowser, paramString);
/*     */   
/*     */   }
/*     */   
/*     */   public void onRenderProcessTerminated(CefBrowser paramCefBrowser, TerminationStatus paramTerminationStatus) {
/* 847 */     if (this.requestHandler_ != null) this.requestHandler_.onRenderProcessTerminated(paramCefBrowser, paramTerminationStatus);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getRect(CefBrowser paramCefBrowser) {
/* 854 */     if (paramCefBrowser == null) return new Rectangle(0, 0, 0, 0);
/*     */     
/* 856 */     CefWindowHandler cefWindowHandler = paramCefBrowser.getWindowHandler();
/* 857 */     if (cefWindowHandler != null) return cefWindowHandler.getRect(paramCefBrowser); 
/* 858 */     return new Rectangle(0, 0, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onMouseEvent(CefBrowser paramCefBrowser, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 864 */     if (paramCefBrowser == null)
/*     */       return; 
/* 866 */     CefWindowHandler cefWindowHandler = paramCefBrowser.getWindowHandler();
/* 867 */     if (cefWindowHandler != null) {
/* 868 */       cefWindowHandler.onMouseEvent(paramCefBrowser, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean getScreenInfo(CefBrowser paramCefBrowser, CefScreenInfo paramCefScreenInfo) {
/* 873 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\CefClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */