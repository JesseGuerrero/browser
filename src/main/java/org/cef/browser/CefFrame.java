package org.cef.browser;

public interface CefFrame {
  void dispose();
  
  long getIdentifier();
  
  String getURL();
  
  String getName();
  
  boolean isMain();
  
  boolean isValid();
  
  boolean isFocused();
  
  CefFrame getParent();
  
  void executeJavaScript(String paramString1, String paramString2, int paramInt);
  
  void undo();
  
  void redo();
  
  void cut();
  
  void copy();
  
  void paste();
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */