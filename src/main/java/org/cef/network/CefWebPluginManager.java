/*    */ package org.cef.network;
/*    */ 
/*    */ import org.cef.callback.CefWebPluginInfoVisitor;
/*    */ import org.cef.callback.CefWebPluginUnstableCallback;
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
/*    */ 
/*    */ public abstract class CefWebPluginManager
/*    */ {
/*    */   public static final CefWebPluginManager getGlobalManager() {
/* 21 */     return CefWebPluginManager_N.getInstance();
/*    */   }
/*    */   
/*    */   public abstract void visitPlugins(CefWebPluginInfoVisitor paramCefWebPluginInfoVisitor);
/*    */   
/*    */   public abstract void refreshPlugins();
/*    */   
/*    */   public abstract void unregisterInternalPlugin(String paramString);
/*    */   
/*    */   public abstract void registerPluginCrash(String paramString);
/*    */   
/*    */   public abstract void isWebPluginUnstable(String paramString, CefWebPluginUnstableCallback paramCefWebPluginUnstableCallback);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefWebPluginManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */