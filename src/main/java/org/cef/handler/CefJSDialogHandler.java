/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.callback.CefJSDialogCallback;
/*    */ import org.cef.misc.BoolRef;
/*    */ 
/*    */ 
/*    */ public interface CefJSDialogHandler
/*    */ {
/*    */   boolean onJSDialog(CefBrowser paramCefBrowser, String paramString1, JSDialogType paramJSDialogType, String paramString2, String paramString3, CefJSDialogCallback paramCefJSDialogCallback, BoolRef paramBoolRef);
/*    */   
/*    */   boolean onBeforeUnloadDialog(CefBrowser paramCefBrowser, String paramString, boolean paramBoolean, CefJSDialogCallback paramCefJSDialogCallback);
/*    */   
/*    */   void onResetDialogState(CefBrowser paramCefBrowser);
/*    */   
/*    */   void onDialogClosed(CefBrowser paramCefBrowser);
/*    */   
/*    */    enum JSDialogType
/*    */   {
/* 20 */     JSDIALOGTYPE_ALERT,
/* 21 */     JSDIALOGTYPE_CONFIRM,
/* 22 */     JSDIALOGTYPE_PROMPT
	/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefJSDialogHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */