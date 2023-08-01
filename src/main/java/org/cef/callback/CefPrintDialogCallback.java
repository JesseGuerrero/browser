package org.cef.callback;

import org.cef.misc.CefPrintSettings;

public interface CefPrintDialogCallback {
  void Continue(CefPrintSettings paramCefPrintSettings);
  
  void cancel();
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefPrintDialogCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */