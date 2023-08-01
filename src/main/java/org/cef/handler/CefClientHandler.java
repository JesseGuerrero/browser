/*     */ package org.cef.handler;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ import org.cef.browser.CefBrowser;
/*     */ import org.cef.browser.CefMessageRouter;
/*     */ import org.cef.callback.CefNative;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CefClientHandler
/*     */   implements CefNative
/*     */ {
/*  19 */   private final HashMap<String, Long> N_CefHandle = new HashMap<>();
/*  20 */   private final Vector<CefMessageRouter> msgRouters = new Vector<>();
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  24 */     synchronized (this.N_CefHandle) {
/*  25 */       this.N_CefHandle.put(paramString, Long.valueOf(paramLong));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  31 */     synchronized (this.N_CefHandle) {
/*  32 */       if (this.N_CefHandle.containsKey(paramString)) return this.N_CefHandle.get(paramString).longValue();
/*     */     } 
/*  34 */     return 0L;
/*     */   }
/*     */   
/*     */   public CefClientHandler() {
/*     */     try {
/*  39 */       N_CefClientHandler_CTOR();
/*  40 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  41 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*     */     try {
/*  48 */       for (byte b = 0; b < this.msgRouters.size(); b++) {
/*  49 */         this.msgRouters.get(b).dispose();
/*     */       }
/*  51 */       this.msgRouters.clear();
/*     */       
/*  53 */       N_CefClientHandler_DTOR();
/*  54 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  55 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefBrowser getBrowser(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Object[] getAllBrowser();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefContextMenuHandler getContextMenuHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefDialogHandler getDialogHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefDisplayHandler getDisplayHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefDownloadHandler getDownloadHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefDragHandler getDragHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefFocusHandler getFocusHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefJSDialogHandler getJSDialogHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefKeyboardHandler getKeyboardHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefLifeSpanHandler getLifeSpanHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefLoadHandler getLoadHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefPrintHandler getPrintHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefRenderHandler getRenderHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefRequestHandler getRequestHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CefWindowHandler getWindowHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected synchronized void addMessageRouter(CefMessageRouter paramCefMessageRouter) {
/*     */     try {
/* 171 */       this.msgRouters.add(paramCefMessageRouter);
/* 172 */       N_addMessageRouter(paramCefMessageRouter);
/* 173 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 174 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeContextMenuHandler(CefContextMenuHandler paramCefContextMenuHandler) {
/*     */     try {
/* 180 */       N_removeContextMenuHandler(paramCefContextMenuHandler);
/* 181 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 182 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeDialogHandler(CefDialogHandler paramCefDialogHandler) {
/*     */     try {
/* 188 */       N_removeDialogHandler(paramCefDialogHandler);
/* 189 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 190 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeDisplayHandler(CefDisplayHandler paramCefDisplayHandler) {
/*     */     try {
/* 196 */       N_removeDisplayHandler(paramCefDisplayHandler);
/* 197 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 198 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeDownloadHandler(CefDisplayHandler paramCefDisplayHandler) {
/*     */     try {
/* 204 */       N_removeDownloadHandler(paramCefDisplayHandler);
/* 205 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 206 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeDragHandler(CefDragHandler paramCefDragHandler) {
/*     */     try {
/* 212 */       N_removeDragHandler(paramCefDragHandler);
/* 213 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 214 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeFocusHandler(CefFocusHandler paramCefFocusHandler) {
/*     */     try {
/* 220 */       N_removeFocusHandler(paramCefFocusHandler);
/* 221 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 222 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeJSDialogHandler(CefJSDialogHandler paramCefJSDialogHandler) {
/*     */     try {
/* 228 */       N_removeJSDialogHandler(paramCefJSDialogHandler);
/* 229 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 230 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeKeyboardHandler(CefKeyboardHandler paramCefKeyboardHandler) {
/*     */     try {
/* 236 */       N_removeKeyboardHandler(paramCefKeyboardHandler);
/* 237 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 238 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeLifeSpanHandler(CefLifeSpanHandler paramCefLifeSpanHandler) {
/*     */     try {
/* 244 */       N_removeLifeSpanHandler(paramCefLifeSpanHandler);
/* 245 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 246 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeLoadHandler(CefLoadHandler paramCefLoadHandler) {
/*     */     try {
/* 252 */       N_removeLoadHandler(paramCefLoadHandler);
/* 253 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 254 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removePrintHandler(CefPrintHandler paramCefPrintHandler) {
/*     */     try {
/* 260 */       N_removePrintHandler(paramCefPrintHandler);
/* 261 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 262 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected synchronized void removeMessageRouter(CefMessageRouter paramCefMessageRouter) {
/*     */     try {
/* 268 */       this.msgRouters.remove(paramCefMessageRouter);
/* 269 */       N_removeMessageRouter(paramCefMessageRouter);
/* 270 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 271 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeRenderHandler(CefRenderHandler paramCefRenderHandler) {
/*     */     try {
/* 277 */       N_removeRenderHandler(paramCefRenderHandler);
/* 278 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 279 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeRequestHandler(CefRequestHandler paramCefRequestHandler) {
/*     */     try {
/* 285 */       N_removeRequestHandler(paramCefRequestHandler);
/* 286 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 287 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void removeWindowHandler(CefWindowHandler paramCefWindowHandler) {
/*     */     try {
/* 293 */       N_removeWindowHandler(paramCefWindowHandler);
/* 294 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 295 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private final native void N_CefClientHandler_CTOR();
/*     */   
/*     */   private final native void N_addMessageRouter(CefMessageRouter paramCefMessageRouter);
/*     */   
/*     */   private final native void N_removeContextMenuHandler(CefContextMenuHandler paramCefContextMenuHandler);
/*     */   
/*     */   private final native void N_removeDialogHandler(CefDialogHandler paramCefDialogHandler);
/*     */   
/*     */   private final native void N_removeDisplayHandler(CefDisplayHandler paramCefDisplayHandler);
/*     */   
/*     */   private final native void N_removeDownloadHandler(CefDisplayHandler paramCefDisplayHandler);
/*     */   
/*     */   private final native void N_removeDragHandler(CefDragHandler paramCefDragHandler);
/*     */   
/*     */   private final native void N_removeFocusHandler(CefFocusHandler paramCefFocusHandler);
/*     */   
/*     */   private final native void N_removeJSDialogHandler(CefJSDialogHandler paramCefJSDialogHandler);
/*     */   
/*     */   private final native void N_removeKeyboardHandler(CefKeyboardHandler paramCefKeyboardHandler);
/*     */   
/*     */   private final native void N_removeLifeSpanHandler(CefLifeSpanHandler paramCefLifeSpanHandler);
/*     */   
/*     */   private final native void N_removeLoadHandler(CefLoadHandler paramCefLoadHandler);
/*     */   
/*     */   private final native void N_removePrintHandler(CefPrintHandler paramCefPrintHandler);
/*     */   
/*     */   private final native void N_removeMessageRouter(CefMessageRouter paramCefMessageRouter);
/*     */   
/*     */   private final native void N_removeRenderHandler(CefRenderHandler paramCefRenderHandler);
/*     */   
/*     */   private final native void N_removeRequestHandler(CefRequestHandler paramCefRequestHandler);
/*     */   
/*     */   private final native void N_removeWindowHandler(CefWindowHandler paramCefWindowHandler);
/*     */   
/*     */   private final native void N_CefClientHandler_DTOR();
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefClientHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */