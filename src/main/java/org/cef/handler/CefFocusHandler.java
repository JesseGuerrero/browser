/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface CefFocusHandler
/*    */ {
/*    */   void onTakeFocus(CefBrowser paramCefBrowser, boolean paramBoolean);
/*    */   
/*    */   boolean onSetFocus(CefBrowser paramCefBrowser, FocusSource paramFocusSource);
/*    */   
/*    */   void onGotFocus(CefBrowser paramCefBrowser);
/*    */   
/*    */    enum FocusSource
/*    */   {
/* 18 */     FOCUS_SOURCE_NAVIGATION,
/*    */     
/* 20 */     FOCUS_SOURCE_SYSTEM
	/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefFocusHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */