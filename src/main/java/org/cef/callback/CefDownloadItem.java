package org.cef.callback;

import java.util.Date;

public interface CefDownloadItem {
  boolean isValid();
  
  boolean isInProgress();
  
  boolean isComplete();
  
  boolean isCanceled();
  
  long getCurrentSpeed();
  
  int getPercentComplete();
  
  long getTotalBytes();
  
  long getReceivedBytes();
  
  Date getStartTime();
  
  Date getEndTime();
  
  String getFullPath();
  
  int getId();
  
  String getURL();
  
  String getSuggestedFileName();
  
  String getContentDisposition();
  
  String getMimeType();
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefDownloadItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */