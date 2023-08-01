package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.callback.CefNative;
import org.cef.callback.CefQueryCallback;

public interface CefMessageRouterHandler extends CefNative {
  boolean onQuery(CefBrowser paramCefBrowser, CefFrame paramCefFrame, long paramLong, String paramString, boolean paramBoolean, CefQueryCallback paramCefQueryCallback);
  
  void onQueryCanceled(CefBrowser paramCefBrowser, CefFrame paramCefFrame, long paramLong);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefMessageRouterHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */