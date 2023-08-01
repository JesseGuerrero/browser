package org.cef.callback;

import org.cef.network.CefURLRequest;

public interface CefURLRequestClient extends CefNative {
  void onRequestComplete(CefURLRequest paramCefURLRequest);
  
  void onUploadProgress(CefURLRequest paramCefURLRequest, int paramInt1, int paramInt2);
  
  void onDownloadProgress(CefURLRequest paramCefURLRequest, int paramInt1, int paramInt2);
  
  void onDownloadData(CefURLRequest paramCefURLRequest, byte[] paramArrayOfbyte, int paramInt);
  
  boolean getAuthCredentials(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, CefAuthCallback paramCefAuthCallback);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefURLRequestClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */