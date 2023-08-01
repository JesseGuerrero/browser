/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
/*    */ import org.cef.callback.CefAuthCallback;
/*    */ import org.cef.callback.CefRequestCallback;
/*    */ import org.cef.misc.BoolRef;
/*    */ import org.cef.network.CefRequest;
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
/*    */ public abstract class CefRequestHandlerAdapter
/*    */   implements CefRequestHandler
/*    */ {
/*    */   public boolean onBeforeBrowse(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2) {
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onOpenURLFromTab(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString, boolean paramBoolean) {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CefResourceRequestHandler getResourceRequestHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2, String paramString, BoolRef paramBoolRef) {
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getAuthCredentials(CefBrowser paramCefBrowser, String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, String paramString4, CefAuthCallback paramCefAuthCallback) {
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onQuotaRequest(CefBrowser paramCefBrowser, String paramString, long paramLong, CefRequestCallback paramCefRequestCallback) {
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCertificateError(CefBrowser paramCefBrowser, CefLoadHandler.ErrorCode paramErrorCode, String paramString, CefRequestCallback paramCefRequestCallback) {
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public void onPluginCrashed(CefBrowser paramCefBrowser, String paramString) {}
/*    */   
/*    */   public void onRenderProcessTerminated(CefBrowser paramCefBrowser, TerminationStatus paramTerminationStatus) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefRequestHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */