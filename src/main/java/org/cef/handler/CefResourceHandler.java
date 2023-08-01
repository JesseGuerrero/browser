package org.cef.handler;

import org.cef.callback.CefCallback;
import org.cef.misc.IntRef;
import org.cef.misc.StringRef;
import org.cef.network.CefRequest;
import org.cef.network.CefResponse;

public interface CefResourceHandler {
  boolean processRequest(CefRequest paramCefRequest, CefCallback paramCefCallback);
  
  void getResponseHeaders(CefResponse paramCefResponse, IntRef paramIntRef, StringRef paramStringRef);
  
  boolean readResponse(byte[] paramArrayOfbyte, int paramInt, IntRef paramIntRef, CefCallback paramCefCallback);
  
  void cancel();
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefResourceHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */