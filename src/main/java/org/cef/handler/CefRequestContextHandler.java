package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.misc.BoolRef;
import org.cef.network.CefRequest;
import org.cef.network.CefWebPluginInfo;

public interface CefRequestContextHandler {
  boolean onBeforePluginLoad(String paramString1, String paramString2, boolean paramBoolean, String paramString3, CefWebPluginInfo paramCefWebPluginInfo);
  
  CefResourceRequestHandler getResourceRequestHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2, String paramString, BoolRef paramBoolRef);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefRequestContextHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */