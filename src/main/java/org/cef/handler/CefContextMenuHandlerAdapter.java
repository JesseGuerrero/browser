/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
/*    */ import org.cef.callback.CefContextMenuParams;
/*    */ import org.cef.callback.CefMenuModel;
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
/*    */ 
/*    */ 
/*    */ public abstract class CefContextMenuHandlerAdapter
/*    */   implements CefContextMenuHandler
/*    */ {
/*    */   public void onBeforeContextMenu(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefContextMenuParams paramCefContextMenuParams, CefMenuModel paramCefMenuModel) {}
/*    */   
/*    */   public boolean onContextMenuCommand(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefContextMenuParams paramCefContextMenuParams, int paramInt1, int paramInt2) {
/* 25 */     return false;
/*    */   }
/*    */   
/*    */   public void onContextMenuDismissed(CefBrowser paramCefBrowser, CefFrame paramCefFrame) {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefContextMenuHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */