/*    */ package org.cef.network;
/*    */ 
/*    */ import org.cef.callback.CefURLRequestClient;
/*    */ import org.cef.handler.CefLoadHandler;
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
/*    */ public abstract class CefURLRequest
/*    */ {
/*    */   public enum Status
/*    */   {
/* 19 */     UR_UNKNOWN,
/* 20 */     UR_SUCCESS,
/* 21 */     UR_IO_PENDING,
/* 22 */     UR_CANCELED,
/* 23 */     UR_FAILED
	/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void finalize() throws Throwable {
/* 31 */     dispose();
/* 32 */     super.finalize();
/*    */   }
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
/*    */   public static final CefURLRequest create(CefRequest paramCefRequest, CefURLRequestClient paramCefURLRequestClient) {
/* 48 */     return CefURLRequest_N.createNative(paramCefRequest, paramCefURLRequestClient);
/*    */   }
/*    */   
/*    */   public abstract void dispose();
/*    */   
/*    */   public abstract CefRequest getRequest();
/*    */   
/*    */   public abstract CefURLRequestClient getClient();
/*    */   
/*    */   public abstract Status getRequestStatus();
/*    */   
/*    */   public abstract CefLoadHandler.ErrorCode getRequestError();
/*    */   
/*    */   public abstract CefResponse getResponse();
/*    */   
/*    */   public abstract void cancel();
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefURLRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */