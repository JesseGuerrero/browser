package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.callback.CefContextMenuParams;
import org.cef.callback.CefMenuModel;

public interface CefContextMenuHandler {
  void onBeforeContextMenu(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefContextMenuParams paramCefContextMenuParams, CefMenuModel paramCefMenuModel);
  
  boolean onContextMenuCommand(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefContextMenuParams paramCefContextMenuParams, int paramInt1, int paramInt2);
  
  void onContextMenuDismissed(CefBrowser paramCefBrowser, CefFrame paramCefFrame);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefContextMenuHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */