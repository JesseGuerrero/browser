/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefDownloadItemCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefDownloadItemCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/*    */     try {
/* 13 */       N_Dispose(getNativeRef(null));
/* 14 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 15 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/* 17 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel() {
/*    */     try {
/* 23 */       N_Cancel(getNativeRef(null));
/* 24 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 25 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void pause() {
/*    */     try {
/* 32 */       N_Pause(getNativeRef(null));
/* 33 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 34 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void resume() {
/*    */     try {
/* 41 */       N_Resume(getNativeRef(null));
/* 42 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 43 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Dispose(long paramLong);
/*    */   
/*    */   private final native void N_Cancel(long paramLong);
/*    */   
/*    */   private final native void N_Pause(long paramLong);
/*    */   
/*    */   private final native void N_Resume(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefDownloadItemCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */