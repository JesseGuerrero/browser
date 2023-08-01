/*    */ package org.cef.browser;
/*    */ 
/*    */ import org.cef.handler.CefRequestContextHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefRequestContext
/*    */ {
/*    */   public static final CefRequestContext getGlobalContext() {
/* 32 */     return CefRequestContext_N.getGlobalContextNative();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final CefRequestContext createContext(CefRequestContextHandler paramCefRequestContextHandler) {
/* 39 */     return CefRequestContext_N.createNative(paramCefRequestContextHandler);
/*    */   }
/*    */   
/*    */   public abstract void dispose();
/*    */   
/*    */   public abstract boolean isGlobal();
/*    */   
/*    */   public abstract CefRequestContextHandler getHandler();
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefRequestContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */