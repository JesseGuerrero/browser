/*    */ package org.cef.handler;
/*    */ 
/*    */ import java.awt.Rectangle;
/*    */ import org.cef.browser.CefBrowser;
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
/*    */ public abstract class CefWindowHandlerAdapter
/*    */   implements CefWindowHandler
/*    */ {
/*    */   public Rectangle getRect(CefBrowser paramCefBrowser) {
/* 19 */     return new Rectangle(0, 0, 0, 0);
/*    */   }
/*    */   
/*    */   public void onMouseEvent(CefBrowser paramCefBrowser, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefWindowHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */