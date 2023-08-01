/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.callback.CefJSDialogCallback;
/*    */ import org.cef.misc.BoolRef;
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
/*    */ public abstract class CefJSDialogHandlerAdapter
/*    */   implements CefJSDialogHandler
/*    */ {
/*    */   public boolean onJSDialog(CefBrowser paramCefBrowser, String paramString1, JSDialogType paramJSDialogType, String paramString2, String paramString3, CefJSDialogCallback paramCefJSDialogCallback, BoolRef paramBoolRef) {
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onBeforeUnloadDialog(CefBrowser paramCefBrowser, String paramString, boolean paramBoolean, CefJSDialogCallback paramCefJSDialogCallback) {
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   public void onResetDialogState(CefBrowser paramCefBrowser) {}
/*    */   
/*    */   public void onDialogClosed(CefBrowser paramCefBrowser) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefJSDialogHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */