/*    */ package org.cef.handler;
/*    */ 
/*    */ import java.awt.Point;
/*    */ import java.awt.Rectangle;
/*    */ import java.nio.ByteBuffer;
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.callback.CefDragData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefRenderHandlerAdapter
/*    */   implements CefRenderHandler
/*    */ {
/*    */   public Rectangle getViewRect(CefBrowser paramCefBrowser) {
/* 22 */     return new Rectangle(0, 0, 0, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getScreenInfo(CefBrowser paramCefBrowser, CefScreenInfo paramCefScreenInfo) {
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Point getScreenPoint(CefBrowser paramCefBrowser, Point paramPoint) {
/* 32 */     return new Point(0, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPopupShow(CefBrowser paramCefBrowser, boolean paramBoolean) {}
/*    */ 
/*    */   
/*    */   public void onPopupSize(CefBrowser paramCefBrowser, Rectangle paramRectangle) {}
/*    */ 
/*    */   
/*    */   public void onPaint(CefBrowser paramCefBrowser, boolean paramBoolean, Rectangle[] paramArrayOfRectangle, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {}
/*    */ 
/*    */   
/*    */   public boolean onCursorChange(CefBrowser paramCefBrowser, int paramInt) {
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean startDragging(CefBrowser paramCefBrowser, CefDragData paramCefDragData, int paramInt1, int paramInt2, int paramInt3) {
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public void updateDragCursor(CefBrowser paramCefBrowser, int paramInt) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefRenderHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */