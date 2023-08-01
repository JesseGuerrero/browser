package org.cef.callback;

import java.util.Vector;

public interface CefFileDialogCallback {
  void Continue(int paramInt, Vector<String> paramVector);
  
  void Cancel();
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefFileDialogCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */