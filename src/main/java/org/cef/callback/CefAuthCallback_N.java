/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefAuthCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefAuthCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 12 */     cancel();
/* 13 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void Continue(String paramString1, String paramString2) {
/*    */     try {
/* 19 */       N_Continue(getNativeRef(null), paramString1, paramString2);
/* 20 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 21 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel() {
/*    */     try {
/* 28 */       N_Cancel(getNativeRef(null));
/* 29 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 30 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Continue(long paramLong, String paramString1, String paramString2);
/*    */   
/*    */   private final native void N_Cancel(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefAuthCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */