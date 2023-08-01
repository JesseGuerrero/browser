/*    */ package org.cef.callback;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefFileDialogCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefFileDialogCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 14 */     Cancel();
/* 15 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void Continue(int paramInt, Vector<String> paramVector) {
/*    */     try {
/* 21 */       N_Continue(getNativeRef(null), paramInt, paramVector);
/* 22 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 23 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void Cancel() {
/*    */     try {
/* 30 */       N_Cancel(getNativeRef(null));
/* 31 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 32 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Continue(long paramLong, int paramInt, Vector<String> paramVector);
/*    */   
/*    */   private final native void N_Cancel(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefFileDialogCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */