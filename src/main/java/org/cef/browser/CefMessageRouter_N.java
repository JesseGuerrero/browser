/*    */ package org.cef.browser;
/*    */ 
/*    */ import org.cef.callback.CefNative;
/*    */ import org.cef.handler.CefMessageRouterHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefMessageRouter_N
/*    */   extends CefMessageRouter
/*    */   implements CefNative
/*    */ {
/* 12 */   private long N_CefHandle = 0L;
/*    */ 
/*    */   
/*    */   public void setNativeRef(String paramString, long paramLong) {
/* 16 */     this.N_CefHandle = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getNativeRef(String paramString) {
/* 21 */     return this.N_CefHandle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final CefMessageRouter createNative(CefMessageRouterConfig paramCefMessageRouterConfig) {
/*    */     try {
/* 30 */       return N_Create(paramCefMessageRouterConfig);
/* 31 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 32 */       unsatisfiedLinkError.printStackTrace();
/* 33 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/*    */     try {
/* 40 */       N_Dispose(this.N_CefHandle);
/* 41 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 42 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean addHandler(CefMessageRouterHandler paramCefMessageRouterHandler, boolean paramBoolean) {
/*    */     try {
/* 49 */       return N_AddHandler(this.N_CefHandle, paramCefMessageRouterHandler, paramBoolean);
/* 50 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 51 */       unsatisfiedLinkError.printStackTrace();
/* 52 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean removeHandler(CefMessageRouterHandler paramCefMessageRouterHandler) {
/*    */     try {
/* 59 */       return N_RemoveHandler(this.N_CefHandle, paramCefMessageRouterHandler);
/* 60 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 61 */       unsatisfiedLinkError.printStackTrace();
/* 62 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelPending(CefBrowser paramCefBrowser, CefMessageRouterHandler paramCefMessageRouterHandler) {
/*    */     try {
/* 69 */       N_CancelPending(this.N_CefHandle, paramCefBrowser, paramCefMessageRouterHandler);
/* 70 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 71 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private static final native CefMessageRouter_N N_Create(CefMessageRouterConfig paramCefMessageRouterConfig);
/*    */   
/*    */   private final native void N_Dispose(long paramLong);
/*    */   
/*    */   private final native boolean N_AddHandler(long paramLong, CefMessageRouterHandler paramCefMessageRouterHandler, boolean paramBoolean);
/*    */   
/*    */   private final native boolean N_RemoveHandler(long paramLong, CefMessageRouterHandler paramCefMessageRouterHandler);
/*    */   
/*    */   private final native void N_CancelPending(long paramLong, CefBrowser paramCefBrowser, CefMessageRouterHandler paramCefMessageRouterHandler);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefMessageRouter_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */