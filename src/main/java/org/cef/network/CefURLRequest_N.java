/*    */ package org.cef.network;
/*    */ 
/*    */ import org.cef.callback.CefNative;
/*    */ import org.cef.callback.CefURLRequestClient;
/*    */ import org.cef.handler.CefLoadHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ class CefURLRequest_N
/*    */   extends CefURLRequest
/*    */   implements CefNative
/*    */ {
/* 13 */   private long N_CefHandle = 0L;
/*    */   
/*    */   private final CefRequest request_;
/*    */   private final CefURLRequestClient client_;
/*    */   
/*    */   public void setNativeRef(String paramString, long paramLong) {
/* 19 */     this.N_CefHandle = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getNativeRef(String paramString) {
/* 24 */     return this.N_CefHandle;
/*    */   }
/*    */ 
/*    */   
/*    */   CefURLRequest_N(CefRequest paramCefRequest, CefURLRequestClient paramCefURLRequestClient) {
/* 29 */     this.request_ = paramCefRequest;
/* 30 */     this.client_ = paramCefURLRequestClient;
/*    */   }
/*    */ 
/*    */   
/*    */   public static final CefURLRequest createNative(CefRequest paramCefRequest, CefURLRequestClient paramCefURLRequestClient) {
/* 35 */     CefURLRequest_N cefURLRequest_N = new CefURLRequest_N(paramCefRequest, paramCefURLRequestClient);
/*    */     try {
/* 37 */       cefURLRequest_N.N_Create(paramCefRequest, paramCefURLRequestClient);
/* 38 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 39 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/* 41 */     if (cefURLRequest_N.N_CefHandle == 0L) return null; 
/* 42 */     return cefURLRequest_N;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/*    */     try {
/* 48 */       N_Dispose(this.N_CefHandle);
/* 49 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 50 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CefRequest getRequest() {
/* 56 */     return this.request_;
/*    */   }
/*    */ 
/*    */   
/*    */   public CefURLRequestClient getClient() {
/* 61 */     return this.client_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Status getRequestStatus() {
/*    */     try {
/* 67 */       return N_GetRequestStatus(this.N_CefHandle);
/* 68 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 69 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 71 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public CefLoadHandler.ErrorCode getRequestError() {
/*    */     try {
/* 77 */       return N_GetRequestError(this.N_CefHandle);
/* 78 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 79 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 81 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public CefResponse getResponse() {
/*    */     try {
/* 87 */       return N_GetResponse(this.N_CefHandle);
/* 88 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 89 */       unsatisfiedLinkError.printStackTrace();
/*    */       
/* 91 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void cancel() {
/*    */     try {
/* 97 */       N_Cancel(this.N_CefHandle);
/* 98 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 99 */       unsatisfiedLinkError.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final native void N_Create(CefRequest paramCefRequest, CefURLRequestClient paramCefURLRequestClient);
/*    */   
/*    */   private final native void N_Dispose(long paramLong);
/*    */   
/*    */   private final native Status N_GetRequestStatus(long paramLong);
/*    */   
/*    */   private final native CefLoadHandler.ErrorCode N_GetRequestError(long paramLong);
/*    */   
/*    */   private final native CefResponse N_GetResponse(long paramLong);
/*    */   
/*    */   private final native void N_Cancel(long paramLong);
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefURLRequest_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */