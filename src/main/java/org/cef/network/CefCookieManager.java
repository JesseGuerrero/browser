/*    */ package org.cef.network;
/*    */ 
/*    */ import org.cef.callback.CefCompletionCallback;
/*    */ import org.cef.callback.CefCookieVisitor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefCookieManager
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 22 */     dispose();
/* 23 */     super.finalize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final CefCookieManager getGlobalManager() {
/* 32 */     return CefCookieManager_N.getGlobalManagerNative();
/*    */   }
/*    */   
/*    */   public abstract void dispose();
/*    */   
/*    */   public abstract boolean visitAllCookies(CefCookieVisitor paramCefCookieVisitor);
/*    */   
/*    */   public abstract boolean visitUrlCookies(String paramString, boolean paramBoolean, CefCookieVisitor paramCefCookieVisitor);
/*    */   
/*    */   public abstract boolean setCookie(String paramString, CefCookie paramCefCookie);
/*    */   
/*    */   public abstract boolean deleteCookies(String paramString1, String paramString2);
/*    */   
/*    */   public abstract boolean flushStore(CefCompletionCallback paramCefCompletionCallback);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefCookieManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */