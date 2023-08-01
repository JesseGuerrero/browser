package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.network.CefCookie;
import org.cef.network.CefRequest;
import org.cef.network.CefResponse;

public interface CefCookieAccessFilter {
  boolean canSendCookie(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefCookie paramCefCookie);
  
  boolean canSaveCookie(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, CefResponse paramCefResponse, CefCookie paramCefCookie);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefCookieAccessFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */