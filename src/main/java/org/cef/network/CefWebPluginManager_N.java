/*    */ package org.cef.network;
/*    */ 
/*    */ import org.cef.callback.CefWebPluginInfoVisitor;
/*    */ import org.cef.callback.CefWebPluginUnstableCallback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefWebPluginManager_N
/*    */   extends CefWebPluginManager
/*    */ {
/* 12 */   private static CefWebPluginManager_N instance = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized CefWebPluginManager_N getInstance() {
/* 19 */     if (instance == null) instance = new CefWebPluginManager_N(); 
/* 20 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   public void visitPlugins(CefWebPluginInfoVisitor paramCefWebPluginInfoVisitor) {
/*    */     try {
/* 26 */       N_VisitPlugins(paramCefWebPluginInfoVisitor);
/* 27 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 28 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void refreshPlugins() {
/*    */     try {
/* 35 */       N_RefreshPlugins();
/* 36 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 37 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void unregisterInternalPlugin(String paramString) {
/*    */     try {
/* 44 */       N_UnregisterInternalPlugin(paramString);
/* 45 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 46 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerPluginCrash(String paramString) {
/*    */     try {
/* 53 */       N_RegisterPluginCrash(paramString);
/* 54 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 55 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void isWebPluginUnstable(String paramString, CefWebPluginUnstableCallback paramCefWebPluginUnstableCallback) {
/*    */     try {
/* 62 */       N_IsWebPluginUnstable(paramString, paramCefWebPluginUnstableCallback);
/* 63 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 64 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_VisitPlugins(CefWebPluginInfoVisitor paramCefWebPluginInfoVisitor);
/*    */   
/*    */   private final native void N_RefreshPlugins();
/*    */   
/*    */   private final native void N_UnregisterInternalPlugin(String paramString);
/*    */   
/*    */   private final native void N_RegisterPluginCrash(String paramString);
/*    */   
/*    */   private final native void N_IsWebPluginUnstable(String paramString, CefWebPluginUnstableCallback paramCefWebPluginUnstableCallback);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefWebPluginManager_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */