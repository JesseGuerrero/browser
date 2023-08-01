package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.misc.BoolRef;
import org.cef.misc.StringRef;
import org.cef.network.CefRequest;
import org.cef.network.CefResponse;
import org.cef.network.CefURLRequest;

public interface CefResourceRequestHandler {
  CefCookieAccessFilter getCookieAccessFilter(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest);
  
  boolean onBeforeResourceLoad(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest);
  
  CefResourceHandler getResourceHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest);
  
  void onResourceRedirect(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse, StringRef paramStringRef);
  
  boolean onResourceResponse(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse);
  
  void onResourceLoadComplete(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse, CefURLRequest.Status paramStatus, long paramLong);
  
  void onProtocolExecution(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, BoolRef paramBoolRef);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefResourceRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */