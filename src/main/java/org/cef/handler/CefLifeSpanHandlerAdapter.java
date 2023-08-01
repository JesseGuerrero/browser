/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
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
/*    */ public abstract class CefLifeSpanHandlerAdapter
/*    */   implements CefLifeSpanHandler
/*    */ {
/*    */   public boolean onBeforePopup(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString1, String paramString2) {
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onAfterCreated(CefBrowser paramCefBrowser) {}
/*    */ 
/*    */   
/*    */   public void onAfterParentChanged(CefBrowser paramCefBrowser) {}
/*    */ 
/*    */   
/*    */   public boolean doClose(CefBrowser paramCefBrowser) {
/* 30 */     return false;
/*    */   }
/*    */   
/*    */   public void onBeforeClose(CefBrowser paramCefBrowser) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefLifeSpanHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */