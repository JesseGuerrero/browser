package org.cef.callback;

import java.util.Map;
import java.util.Vector;

public interface CefCommandLine {
  void reset();
  
  String getProgram();
  
  void setProgram(String paramString);
  
  boolean hasSwitches();
  
  boolean hasSwitch(String paramString);
  
  String getSwitchValue(String paramString);
  
  Map<String, String> getSwitches();
  
  void appendSwitch(String paramString);
  
  void appendSwitchWithValue(String paramString1, String paramString2);
  
  boolean hasArguments();
  
  Vector<String> getArguments();
  
  void appendArgument(String paramString);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefCommandLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */