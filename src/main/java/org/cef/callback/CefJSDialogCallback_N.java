/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefJSDialogCallback_N
/*    */   extends CefNativeAdapter
/*    */   implements CefJSDialogCallback
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 12 */     Continue(false, "");
/* 13 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void Continue(boolean paramBoolean, String paramString) {
/*    */     try {
/* 19 */       N_Continue(getNativeRef(null), paramBoolean, paramString);
/* 20 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 21 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Continue(long paramLong, boolean paramBoolean, String paramString);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefJSDialogCallback_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */