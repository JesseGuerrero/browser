/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.CefApp;
/*    */ import org.cef.callback.CefCommandLine;
/*    */ import org.cef.callback.CefSchemeRegistrar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefAppHandlerAdapter
/*    */   implements CefAppHandler
/*    */ {
/*    */   private final String[] args_;
/*    */   
/*    */   public CefAppHandlerAdapter(String[] paramArrayOfString) {
/* 21 */     this.args_ = paramArrayOfString;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onBeforeCommandLineProcessing(String paramString, CefCommandLine paramCefCommandLine) {
/* 26 */     if (paramString.isEmpty() && this.args_ != null) {
/*    */       
/* 28 */       boolean bool = false;
/* 29 */       for (String str : this.args_) {
/* 30 */         if (bool || str.length() < 2) {
/* 31 */           paramCefCommandLine.appendArgument(str);
/*    */         } else {
/*    */           String[] arrayOfString;
/*    */ 
/*    */ 
/*    */           
/* 37 */           int bool1 = str.startsWith("--") ? 1 : (str.startsWith("/") ? 1 : (str.startsWith("-") ? 1 : 0));
/* 38 */           switch (bool1) {
/*    */ 
/*    */             
/*    */             case 1:
/* 42 */               if (str.length() == 2) {
/* 43 */                 bool = true;
/*    */                 break;
/*    */               } 
/*    */ 
/*    */ 
/*    */             
/*    */
/* 50 */               arrayOfString = str.substring(bool1).split("=");
/* 51 */               if (arrayOfString.length == 2) {
/* 52 */                 paramCefCommandLine.appendSwitchWithValue(arrayOfString[0], arrayOfString[1]); break;
/*    */               } 
/* 54 */               paramCefCommandLine.appendSwitch(arrayOfString[0]);
/*    */               break;
/*    */ 
/*    */             
/*    */             case 0:
/* 59 */               paramCefCommandLine.appendArgument(str);
/*    */               break;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onBeforeTerminate() {
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void stateHasChanged(CefApp.CefAppState paramCefAppState) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onRegisterCustomSchemes(CefSchemeRegistrar paramCefSchemeRegistrar) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void onContextInitialized() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void onScheduleMessagePumpWork(long paramLong) {
/* 89 */     CefApp.getInstance().doMessageLoopWork(paramLong);
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefAppHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */