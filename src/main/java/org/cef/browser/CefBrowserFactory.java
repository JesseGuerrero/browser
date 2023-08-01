/*    */ package org.cef.browser;
/*    */ 
/*    */ import org.cef.CefClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CefBrowserFactory
/*    */ {
/*    */   public static CefBrowser create(CefClient paramCefClient, String paramString, boolean paramBoolean1, boolean paramBoolean2, CefRequestContext paramCefRequestContext) {
/* 15 */     if (paramBoolean1) return new CefBrowserOsr(paramCefClient, paramString, paramBoolean2, paramCefRequestContext); 
/* 16 */     return new CefBrowserWr(paramCefClient, paramString, paramCefRequestContext);
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefBrowserFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */