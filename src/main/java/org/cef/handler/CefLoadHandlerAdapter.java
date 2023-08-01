package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.network.CefRequest;

public abstract class CefLoadHandlerAdapter implements CefLoadHandler {
  public void onLoadingStateChange(CefBrowser paramCefBrowser, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onLoadStart(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest.TransitionType paramTransitionType) {}
  
  public void onLoadEnd(CefBrowser paramCefBrowser, CefFrame paramCefFrame, int paramInt) {}
  
  public void onLoadError(CefBrowser paramCefBrowser, CefFrame paramCefFrame, ErrorCode paramErrorCode, String paramString1, String paramString2) {}
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefLoadHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */