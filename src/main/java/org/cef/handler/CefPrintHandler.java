package org.cef.handler;

import java.awt.Dimension;
import org.cef.browser.CefBrowser;
import org.cef.callback.CefNative;
import org.cef.callback.CefPrintDialogCallback;
import org.cef.callback.CefPrintJobCallback;
import org.cef.misc.CefPrintSettings;

public interface CefPrintHandler extends CefNative {
  void onPrintStart(CefBrowser paramCefBrowser);
  
  void onPrintSettings(CefBrowser paramCefBrowser, CefPrintSettings paramCefPrintSettings, boolean paramBoolean);
  
  boolean onPrintDialog(CefBrowser paramCefBrowser, boolean paramBoolean, CefPrintDialogCallback paramCefPrintDialogCallback);
  
  boolean onPrintJob(CefBrowser paramCefBrowser, String paramString1, String paramString2, CefPrintJobCallback paramCefPrintJobCallback);
  
  void onPrintReset(CefBrowser paramCefBrowser);
  
  Dimension getPdfPaperSize(CefBrowser paramCefBrowser, int paramInt);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefPrintHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */