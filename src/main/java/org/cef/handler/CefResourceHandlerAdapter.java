/*    */ package org.cef.handler;
/*    */ 
/*    */ import org.cef.callback.CefCallback;
/*    */ import org.cef.misc.IntRef;
/*    */ import org.cef.misc.StringRef;
/*    */ import org.cef.network.CefRequest;
/*    */ import org.cef.network.CefResponse;
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
/*    */ public abstract class CefResourceHandlerAdapter
/*    */   implements CefResourceHandler
/*    */ {
/*    */   public boolean processRequest(CefRequest paramCefRequest, CefCallback paramCefCallback) {
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void getResponseHeaders(CefResponse paramCefResponse, IntRef paramIntRef, StringRef paramStringRef) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean readResponse(byte[] paramArrayOfbyte, int paramInt, IntRef paramIntRef, CefCallback paramCefCallback) {
/* 32 */     return false;
/*    */   }
/*    */   
/*    */   public void cancel() {}
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefResourceHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */