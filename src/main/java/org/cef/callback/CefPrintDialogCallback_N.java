/*    */ package org.cef.callback;
/*    */ 
/*    */ import org.cef.misc.CefPrintSettings;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefPrintDialogCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefPrintDialogCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 14 */     cancel();
/* 15 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void Continue(CefPrintSettings paramCefPrintSettings) {
/*    */     try {
/* 21 */       N_Continue(getNativeRef(null), paramCefPrintSettings);
/* 22 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 23 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel() {
/*    */     try {
/* 30 */       N_Cancel(getNativeRef(null));
/* 31 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 32 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Continue(long paramLong, CefPrintSettings paramCefPrintSettings);
/*    */   
/*    */   private final native void N_Cancel(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefPrintDialogCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */