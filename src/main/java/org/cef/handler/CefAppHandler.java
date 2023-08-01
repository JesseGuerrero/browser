package org.cef.handler;

import org.cef.CefApp;
import org.cef.callback.CefCommandLine;
import org.cef.callback.CefSchemeRegistrar;

public interface CefAppHandler {
  void onBeforeCommandLineProcessing(String paramString, CefCommandLine paramCefCommandLine);
  
  boolean onBeforeTerminate();
  
  void stateHasChanged(CefApp.CefAppState paramCefAppState);
  
  void onRegisterCustomSchemes(CefSchemeRegistrar paramCefSchemeRegistrar);
  
  void onContextInitialized();
  
  void onScheduleMessagePumpWork(long paramLong);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefAppHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */