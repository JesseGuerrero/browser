/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefBeforeDownloadCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefBeforeDownloadCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 12 */     Continue("", false);
/* 13 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void Continue(String paramString, boolean paramBoolean) {
/*    */     try {
/* 19 */       N_Continue(getNativeRef(null), paramString, paramBoolean);
/* 20 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 21 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Continue(long paramLong, String paramString, boolean paramBoolean);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefBeforeDownloadCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */