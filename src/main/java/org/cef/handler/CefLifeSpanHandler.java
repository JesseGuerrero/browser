package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;

public interface CefLifeSpanHandler {
  boolean onBeforePopup(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString1, String paramString2);
  
  void onAfterCreated(CefBrowser paramCefBrowser);
  
  void onAfterParentChanged(CefBrowser paramCefBrowser);
  
  boolean doClose(CefBrowser paramCefBrowser);
  
  void onBeforeClose(CefBrowser paramCefBrowser);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefLifeSpanHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */