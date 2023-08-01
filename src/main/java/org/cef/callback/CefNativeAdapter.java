/*    */ package org.cef.callback;
/*    */ 
/*    */ public class CefNativeAdapter
/*    */   implements CefNative {
/*  5 */   private long N_CefHandle = 0L;
/*    */ 
/*    */   
/*    */   public void setNativeRef(String paramString, long paramLong) {
/*  9 */     this.N_CefHandle = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getNativeRef(String paramString) {
/* 14 */     return this.N_CefHandle;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefNativeAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */