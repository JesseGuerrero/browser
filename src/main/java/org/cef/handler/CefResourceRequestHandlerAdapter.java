/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
/*    */ import org.cef.misc.BoolRef;
/*    */ import org.cef.misc.StringRef;
/*    */ import org.cef.network.CefRequest;
/*    */ import org.cef.network.CefResponse;
/*    */ import org.cef.network.CefURLRequest;
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
/*    */ public abstract class CefResourceRequestHandlerAdapter
/*    */   implements CefResourceRequestHandler
/*    */ {
/*    */   public CefCookieAccessFilter getCookieAccessFilter(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest) {
/* 25 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onBeforeResourceLoad(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest) {
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CefResourceHandler getResourceHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest) {
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onResourceRedirect(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse, StringRef paramStringRef) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onResourceResponse(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse) {
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public void onResourceLoadComplete(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse, CefURLRequest.Status paramStatus, long paramLong) {}
/*    */   
/*    */   public void onProtocolExecution(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, BoolRef paramBoolRef) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefResourceRequestHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */