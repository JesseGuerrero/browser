package org.cef.handler;

import java.awt.Point;
import java.awt.Rectangle;
import java.nio.ByteBuffer;
import org.cef.browser.CefBrowser;
import org.cef.callback.CefDragData;

public interface CefRenderHandler {
  Rectangle getViewRect(CefBrowser paramCefBrowser);
  
  boolean getScreenInfo(CefBrowser paramCefBrowser, CefScreenInfo paramCefScreenInfo);
  
  Point getScreenPoint(CefBrowser paramCefBrowser, Point paramPoint);
  
  void onPopupShow(CefBrowser paramCefBrowser, boolean paramBoolean);
  
  void onPopupSize(CefBrowser paramCefBrowser, Rectangle paramRectangle);
  
  void onPaint(CefBrowser paramCefBrowser, boolean paramBoolean, Rectangle[] paramArrayOfRectangle, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  boolean onCursorChange(CefBrowser paramCefBrowser, int paramInt);
  
  boolean startDragging(CefBrowser paramCefBrowser, CefDragData paramCefDragData, int paramInt1, int paramInt2, int paramInt3);
  
  void updateDragCursor(CefBrowser paramCefBrowser, int paramInt);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefRenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */