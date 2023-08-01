/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
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
/*    */ public abstract class CefFocusHandlerAdapter
/*    */   implements CefFocusHandler
/*    */ {
/*    */   public void onTakeFocus(CefBrowser paramCefBrowser, boolean paramBoolean) {}
/*    */   
/*    */   public boolean onSetFocus(CefBrowser paramCefBrowser, FocusSource paramFocusSource) {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   public void onGotFocus(CefBrowser paramCefBrowser) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefFocusHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */