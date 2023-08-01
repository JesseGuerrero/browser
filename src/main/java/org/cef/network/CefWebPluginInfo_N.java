/*    */ package org.cef.network;
/*    */ 
/*    */ import org.cef.callback.CefNativeAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefWebPluginInfo_N
/*    */   extends CefNativeAdapter
/*    */   implements CefWebPluginInfo
/*    */ {
/*    */   public String getName() {
/*    */     try {
/* 15 */       return N_GetName(getNativeRef(null));
/* 16 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 17 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 19 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getPath() {
/*    */     try {
/* 25 */       return N_GetPath(getNativeRef(null));
/* 26 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 27 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 29 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getVersion() {
/*    */     try {
/* 35 */       return N_GetVersion(getNativeRef(null));
/* 36 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 37 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 39 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getDescription() {
/*    */     try {
/* 45 */       return N_GetDescription(getNativeRef(null));
/* 46 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 47 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 49 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native String N_GetName(long paramLong);
/*    */   
/*    */   private final native String N_GetPath(long paramLong);
/*    */   
/*    */   private final native String N_GetVersion(long paramLong);
/*    */   
/*    */   private final native String N_GetDescription(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefWebPluginInfo_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */