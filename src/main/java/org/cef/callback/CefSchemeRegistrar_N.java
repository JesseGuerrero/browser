/*    */ package org.cef.callback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefSchemeRegistrar_N
/*    */   extends CefNativeAdapter
/*    */   implements CefSchemeRegistrar
/*    */ {
/*    */   public boolean addCustomScheme(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7) {
/*    */     try {
/* 13 */       return N_AddCustomScheme(paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7);
/*    */     }
/* 15 */     catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 16 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 18 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native boolean N_AddCustomScheme(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefSchemeRegistrar_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */