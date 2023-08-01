/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.CefSettings;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefDisplayHandlerAdapter
/*    */   implements CefDisplayHandler
/*    */ {
/*    */   public void onAddressChange(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString) {}
/*    */   
/*    */   public void onTitleChange(CefBrowser paramCefBrowser, String paramString) {}
/*    */   
/*    */   public boolean onTooltip(CefBrowser paramCefBrowser, String paramString) {
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onStatusMessage(CefBrowser paramCefBrowser, String paramString) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onConsoleMessage(CefBrowser paramCefBrowser, CefSettings.LogSeverity paramLogSeverity, String paramString1, String paramString2, int paramInt) {
/* 40 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onCursorChange(CefBrowser paramCefBrowser, int paramInt) {
/* 45 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefDisplayHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */