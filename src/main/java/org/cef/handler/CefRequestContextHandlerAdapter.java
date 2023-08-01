/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.browser.CefFrame;
/*    */ import org.cef.misc.BoolRef;
/*    */ import org.cef.network.CefRequest;
/*    */ import org.cef.network.CefWebPluginInfo;
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
/*    */ public abstract class CefRequestContextHandlerAdapter
/*    */   implements CefRequestContextHandler
/*    */ {
/*    */   public boolean onBeforePluginLoad(String paramString1, String paramString2, boolean paramBoolean, String paramString3, CefWebPluginInfo paramCefWebPluginInfo) {
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CefResourceRequestHandler getResourceRequestHandler(CefBrowser paramCefBrowser, CefFrame paramCefFrame, CefRequest paramCefRequest, boolean paramBoolean1, boolean paramBoolean2, String paramString, BoolRef paramBoolRef) {
/* 29 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefRequestContextHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */