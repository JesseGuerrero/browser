package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.callback.CefDragData;

public interface CefDragHandler {
  boolean onDragEnter(CefBrowser paramCefBrowser, CefDragData paramCefDragData, int paramInt);
  
  final class DragOperationMask {
    public static final int DRAG_OPERATION_NONE = 0;
    
    public static final int DRAG_OPERATION_COPY = 1;
    
    public static final int DRAG_OPERATION_LINK = 2;
    
    public static final int DRAG_OPERATION_GENERIC = 4;
    
    public static final int DRAG_OPERATION_PRIVATE = 8;
    
    public static final int DRAG_OPERATION_MOVE = 16;
    
    public static final int DRAG_OPERATION_DELETE = 32;
    
    public static final int DRAG_OPERATION_EVERY = 2147483647;
  }
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefDragHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */