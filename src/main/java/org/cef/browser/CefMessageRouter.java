/*     */ package org.cef.browser;
/*     */ 
/*     */ import org.cef.handler.CefMessageRouterHandler;
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
/*     */ public abstract class CefMessageRouter
/*     */ {
/* 145 */   private CefMessageRouterConfig routerConfig_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CefMessageRouterConfig
/*     */   {
/*     */     public String jsQueryFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String jsCancelFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CefMessageRouterConfig() {
/* 165 */       this("cefQuery", "cefQueryCancel");
/*     */     }
/*     */     
/*     */     public CefMessageRouterConfig(String param1String1, String param1String2) {
/* 169 */       this.jsQueryFunction = param1String1;
/* 170 */       this.jsCancelFunction = param1String2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 179 */     dispose();
/* 180 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefMessageRouter create() {
/* 188 */     return create(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefMessageRouter create(CefMessageRouterConfig paramCefMessageRouterConfig) {
/* 196 */     return create(paramCefMessageRouterConfig, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefMessageRouter create(CefMessageRouterHandler paramCefMessageRouterHandler) {
/* 203 */     return create(null, paramCefMessageRouterHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefMessageRouter create(CefMessageRouterConfig paramCefMessageRouterConfig, CefMessageRouterHandler paramCefMessageRouterHandler) {
/* 211 */     CefMessageRouter cefMessageRouter = CefMessageRouter_N.createNative(paramCefMessageRouterConfig);
/* 212 */     if (cefMessageRouter != null && paramCefMessageRouterHandler != null) cefMessageRouter.addHandler(paramCefMessageRouterHandler, true); 
/* 213 */     return cefMessageRouter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void dispose();
/*     */ 
/*     */ 
/*     */   
/*     */   void setMessageRouterConfig(CefMessageRouterConfig paramCefMessageRouterConfig) {
/* 223 */     this.routerConfig_ = paramCefMessageRouterConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CefMessageRouterConfig getMessageRouterConfig() {
/* 228 */     return this.routerConfig_;
/*     */   }
/*     */   
/*     */   public abstract boolean addHandler(CefMessageRouterHandler paramCefMessageRouterHandler, boolean paramBoolean);
/*     */   
/*     */   public abstract boolean removeHandler(CefMessageRouterHandler paramCefMessageRouterHandler);
/*     */   
/*     */   public abstract void cancelPending(CefBrowser paramCefBrowser, CefMessageRouterHandler paramCefMessageRouterHandler);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefMessageRouter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */