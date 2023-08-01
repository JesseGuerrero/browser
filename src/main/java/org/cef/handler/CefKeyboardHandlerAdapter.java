/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.misc.BoolRef;
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
/*    */ public abstract class CefKeyboardHandlerAdapter
/*    */   implements CefKeyboardHandler
/*    */ {
/*    */   public boolean onPreKeyEvent(CefBrowser paramCefBrowser, CefKeyEvent paramCefKeyEvent, BoolRef paramBoolRef) {
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onKeyEvent(CefBrowser paramCefBrowser, CefKeyEvent paramCefKeyEvent) {
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefKeyboardHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */