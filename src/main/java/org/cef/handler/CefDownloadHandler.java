package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.callback.CefBeforeDownloadCallback;
import org.cef.callback.CefDownloadItem;
import org.cef.callback.CefDownloadItemCallback;

public interface CefDownloadHandler {
  void onBeforeDownload(CefBrowser paramCefBrowser, CefDownloadItem paramCefDownloadItem, String paramString, CefBeforeDownloadCallback paramCefBeforeDownloadCallback);
  
  void onDownloadUpdated(CefBrowser paramCefBrowser, CefDownloadItem paramCefDownloadItem, CefDownloadItemCallback paramCefDownloadItemCallback);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefDownloadHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */