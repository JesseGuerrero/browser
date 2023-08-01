/*    */ package org.cef;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SystemBootstrap
/*    */ {
/* 21 */   private static Loader loader_ = new Loader()
/*    */     {
/*    */       public void loadLibrary(String param1String) {
/* 24 */         System.loadLibrary(param1String);
/*    */       }
/*    */     };
/*    */   
/*    */   public static void setLoader(Loader paramLoader) {
/* 29 */     if (paramLoader == null) {
/* 30 */       throw new NullPointerException("Loader cannot be null");
/*    */     }
/* 32 */     loader_ = paramLoader;
/*    */   } public interface Loader {
/*    */     void loadLibrary(String param1String); }
/*    */   public static void loadLibrary(String paramString) {
/* 36 */     loader_.loadLibrary(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\SystemBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */