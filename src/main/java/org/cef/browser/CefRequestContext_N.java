/*    */ package org.cef.browser;
/*    */ 
/*    */ import org.cef.callback.CefNative;
/*    */ import org.cef.handler.CefRequestContextHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefRequestContext_N
/*    */   extends CefRequestContext
/*    */   implements CefNative
/*    */ {
/* 12 */   private long N_CefHandle = 0L;
/* 13 */   private static CefRequestContext_N globalInstance = null;
/* 14 */   private CefRequestContextHandler handler = null;
/*    */ 
/*    */   
/*    */   public void setNativeRef(String paramString, long paramLong) {
/* 18 */     this.N_CefHandle = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getNativeRef(String paramString) {
/* 23 */     return this.N_CefHandle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static final CefRequestContext_N getGlobalContextNative() {
/* 31 */     CefRequestContext_N cefRequestContext_N = null;
/*    */     try {
/* 33 */       cefRequestContext_N = N_GetGlobalContext();
/* 34 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 35 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */     
/* 38 */     if (globalInstance == null) {
/* 39 */       globalInstance = cefRequestContext_N;
/* 40 */     } else if (globalInstance.N_CefHandle == cefRequestContext_N.N_CefHandle) {
/* 41 */       cefRequestContext_N.N_CefRequestContext_DTOR();
/*    */     } 
/* 43 */     return globalInstance;
/*    */   }
/*    */   
/*    */   static final CefRequestContext_N createNative(CefRequestContextHandler paramCefRequestContextHandler) {
/* 47 */     CefRequestContext_N cefRequestContext_N = null;
/*    */     try {
/* 49 */       cefRequestContext_N = N_CreateContext(paramCefRequestContextHandler);
/* 50 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 51 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/* 53 */     if (cefRequestContext_N != null) cefRequestContext_N.handler = paramCefRequestContextHandler; 
/* 54 */     return cefRequestContext_N;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/*    */     try {
/* 60 */       N_CefRequestContext_DTOR();
/* 61 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 62 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isGlobal() {
/*    */     try {
/* 69 */       return N_IsGlobal();
/* 70 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 71 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 73 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public CefRequestContextHandler getHandler() {
/* 78 */     return this.handler;
/*    */   }
/*    */   
/*    */   private static final native CefRequestContext_N N_GetGlobalContext();
/*    */   
/*    */   private static final native CefRequestContext_N N_CreateContext(CefRequestContextHandler paramCefRequestContextHandler);
/*    */   
/*    */   private final native boolean N_IsGlobal();
/*    */   
/*    */   private final native void N_CefRequestContext_DTOR();
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefRequestContext_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */