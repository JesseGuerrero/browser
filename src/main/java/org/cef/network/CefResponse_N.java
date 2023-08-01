/*     */ package org.cef.network;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.cef.callback.CefNative;
/*     */ import org.cef.handler.CefLoadHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefResponse_N
/*     */   extends CefResponse
/*     */   implements CefNative
/*     */ {
/*  14 */   private long N_CefHandle = 0L;
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  18 */     this.N_CefHandle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  23 */     return this.N_CefHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CefResponse createNative() {
/*     */     try {
/*  32 */       return N_Create();
/*  33 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  34 */       unsatisfiedLinkError.printStackTrace();
/*  35 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  42 */       N_Dispose(this.N_CefHandle);
/*  43 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  44 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*     */     try {
/*  51 */       return N_IsReadOnly(this.N_CefHandle);
/*  52 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  53 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  55 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CefLoadHandler.ErrorCode getError() {
/*     */     try {
/*  61 */       return N_GetError(this.N_CefHandle);
/*  62 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  63 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  65 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setError(CefLoadHandler.ErrorCode paramErrorCode) {
/*     */     try {
/*  71 */       N_SetError(this.N_CefHandle, paramErrorCode);
/*  72 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  73 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStatus() {
/*     */     try {
/*  80 */       return N_GetStatus(this.N_CefHandle);
/*  81 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  82 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  84 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setStatus(int paramInt) {
/*     */     try {
/*  90 */       N_SetStatus(this.N_CefHandle, paramInt);
/*  91 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  92 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStatusText() {
/*     */     try {
/*  99 */       return N_GetStatusText(this.N_CefHandle);
/* 100 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 101 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 103 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setStatusText(String paramString) {
/*     */     try {
/* 109 */       N_SetStatusText(this.N_CefHandle, paramString);
/* 110 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 111 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMimeType() {
/*     */     try {
/* 118 */       return N_GetMimeType(this.N_CefHandle);
/* 119 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 120 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 122 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMimeType(String paramString) {
/*     */     try {
/* 128 */       N_SetMimeType(this.N_CefHandle, paramString);
/* 129 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 130 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHeaderByName(String paramString) {
/*     */     try {
/* 137 */       return N_GetHeaderByName(this.N_CefHandle, paramString);
/* 138 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 139 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 141 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setHeaderByName(String paramString1, String paramString2, boolean paramBoolean) {
/*     */     try {
/* 147 */       N_SetHeaderByName(this.N_CefHandle, paramString1, paramString2, paramBoolean);
/* 148 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 149 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void getHeaderMap(Map<String, String> paramMap) {
/*     */     try {
/* 156 */       N_GetHeaderMap(this.N_CefHandle, paramMap);
/* 157 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 158 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeaderMap(Map<String, String> paramMap) {
/*     */     try {
/* 165 */       N_SetHeaderMap(this.N_CefHandle, paramMap);
/* 166 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 167 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final native CefResponse_N N_Create();
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native boolean N_IsReadOnly(long paramLong);
/*     */   
/*     */   private final native CefLoadHandler.ErrorCode N_GetError(long paramLong);
/*     */   
/*     */   private final native void N_SetError(long paramLong, CefLoadHandler.ErrorCode paramErrorCode);
/*     */   
/*     */   private final native int N_GetStatus(long paramLong);
/*     */   
/*     */   private final native void N_SetStatus(long paramLong, int paramInt);
/*     */   
/*     */   private final native String N_GetStatusText(long paramLong);
/*     */   
/*     */   private final native void N_SetStatusText(long paramLong, String paramString);
/*     */   
/*     */   private final native String N_GetMimeType(long paramLong);
/*     */   
/*     */   private final native void N_SetMimeType(long paramLong, String paramString);
/*     */   
/*     */   private final native String N_GetHeaderByName(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetHeaderByName(long paramLong, String paramString1, String paramString2, boolean paramBoolean);
/*     */   
/*     */   private final native void N_GetHeaderMap(long paramLong, Map<String, String> paramMap);
/*     */   
/*     */   private final native void N_SetHeaderMap(long paramLong, Map<String, String> paramMap);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefResponse_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */