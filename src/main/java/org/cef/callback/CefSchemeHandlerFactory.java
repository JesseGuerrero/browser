package org.cef.callback;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.handler.CefResourceHandler;
import org.cef.network.CefRequest;

public interface CefSchemeHandlerFactory {
  CefResourceHandler create(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString, CefRequest paramCefRequest);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefSchemeHandlerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */