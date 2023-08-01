/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefQueryCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefQueryCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 12 */     failure(-1, "Unexpected call to CefQueryCallback_N::finalize()");
/* 13 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void success(String paramString) {
/*    */     try {
/* 19 */       N_Success(getNativeRef(null), paramString);
/* 20 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 21 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void failure(int paramInt, String paramString) {
/*    */     try {
/* 28 */       N_Failure(getNativeRef(null), paramInt, paramString);
/* 29 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 30 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Success(long paramLong, String paramString);
/*    */   
/*    */   private final native void N_Failure(long paramLong, int paramInt, String paramString);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefQueryCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */