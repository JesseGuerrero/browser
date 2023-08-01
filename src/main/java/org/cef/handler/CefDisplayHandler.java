package org.cef.handler;

import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;

public interface CefDisplayHandler {
  void onAddressChange(CefBrowser paramCefBrowser, CefFrame paramCefFrame, String paramString);
  
  void onTitleChange(CefBrowser paramCefBrowser, String paramString);
  
  boolean onTooltip(CefBrowser paramCefBrowser, String paramString);
  
  void onStatusMessage(CefBrowser paramCefBrowser, String paramString);
  
  boolean onConsoleMessage(CefBrowser paramCefBrowser, CefSettings.LogSeverity paramLogSeverity, String paramString1, String paramString2, int paramInt);
  
  boolean onCursorChange(CefBrowser paramCefBrowser, int paramInt);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefDisplayHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */