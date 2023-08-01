/*    */ package org.cef.handler;
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
/*    */ import org.cef.callback.CefAuthCallback;
import org.cef.callback.CefRequestCallback;
import org.cef.misc.BoolRef;
import org.cef.network.CefRequest;
/*    */ 
/*    */ public interface CefRequestHandler {
/*    */   boolean onBeforeBrowse(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2);
/*    */   
/*    */   boolean onOpenURLFromTab(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString, boolean paramBoolean);
/*    */   
/*    */   CefResourceRequestHandler getResourceRequestHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2, String paramString, BoolRef paramBoolRef);
/*    */   
/*    */   boolean getAuthCredentials(CefBrowser paramCefBrowser, String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, String paramString4, CefAuthCallback paramCefAuthCallback);
/*    */   
/*    */   boolean onQuotaRequest(CefBrowser paramCefBrowser, String paramString, long paramLong, CefRequestCallback paramCefRequestCallback);
/*    */   
/*    */   boolean onCertificateError(CefBrowser paramCefBrowser, CefLoadHandler.ErrorCode paramErrorCode, String paramString, CefRequestCallback paramCefRequestCallback);
/*    */   
/*    */   void onPluginCrashed(CefBrowser paramCefBrowser, String paramString);
/*    */   
/*    */   void onRenderProcessTerminated(CefBrowser paramCefBrowser, TerminationStatus paramTerminationStatus);
/*    */   
/*    */    enum TerminationStatus {
/* 24 */     TS_ABNORMAL_TERMINATION,
/* 25 */     TS_PROCESS_WAS_KILLED,
/* 26 */     TS_PROCESS_CRASHED,
/* 27 */     TS_PROCESS_OOM
	/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */