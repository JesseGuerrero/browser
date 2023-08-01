/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefRequestCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefRequestCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 12 */     Cancel();
/* 13 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void Continue(boolean paramBoolean) {
/*    */     try {
/* 19 */       N_Continue(getNativeRef(null), paramBoolean);
/* 20 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 21 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void Cancel() {
/*    */     try {
/* 28 */       N_Cancel(getNativeRef(null));
/* 29 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 30 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Continue(long paramLong, boolean paramBoolean);
/*    */   
/*    */   private final native void N_Cancel(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefRequestCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */