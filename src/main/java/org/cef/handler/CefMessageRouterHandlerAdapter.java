/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
/*    */ import org.cef.callback.CefNativeAdapter;
/*    */ import org.cef.callback.CefQueryCallback;
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
/*    */ public abstract class CefMessageRouterHandlerAdapter
/*    */   extends CefNativeAdapter
/*    */   implements CefMessageRouterHandler
/*    */ {
/*    */   public boolean onQuery(CefBrowser paramCefBrowser, CefFrame paramCefFrame, long paramLong, String paramString, boolean paramBoolean, CefQueryCallback paramCefQueryCallback) {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   public void onQueryCanceled(CefBrowser paramCefBrowser, CefFrame paramCefFrame, long paramLong) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefMessageRouterHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */