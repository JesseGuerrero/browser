/*     */ package org.cef.network;
/*     */ 
/*     */ import org.cef.callback.CefNative;
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefPostDataElement_N
/*     */   extends CefPostDataElement
/*     */   implements CefNative
/*     */ {
/*  11 */   private long N_CefHandle = 0L;
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  15 */     this.N_CefHandle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  20 */     return this.N_CefHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CefPostDataElement createNative() {
/*     */     try {
/*  29 */       return N_Create();
/*  30 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  31 */       unsatisfiedLinkError.printStackTrace();
/*  32 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  39 */       N_Dispose(this.N_CefHandle);
/*  40 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  41 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*     */     try {
/*  48 */       return N_IsReadOnly(this.N_CefHandle);
/*  49 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  50 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  52 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setToEmpty() {
/*     */     try {
/*  58 */       N_SetToEmpty(this.N_CefHandle);
/*  59 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  60 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setToFile(String paramString) {
/*     */     try {
/*  67 */       N_SetToFile(this.N_CefHandle, paramString);
/*  68 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  69 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setToBytes(int paramInt, byte[] paramArrayOfbyte) {
/*     */     try {
/*  76 */       N_SetToBytes(this.N_CefHandle, paramInt, paramArrayOfbyte);
/*  77 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  78 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getType() {
/*     */     try {
/*  85 */       return N_GetType(this.N_CefHandle);
/*  86 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  87 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  89 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFile() {
/*     */     try {
/*  95 */       return N_GetFile(this.N_CefHandle);
/*  96 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  97 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  99 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getBytesCount() {
/*     */     try {
/* 105 */       return N_GetBytesCount(this.N_CefHandle);
/* 106 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 107 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 109 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getBytes(int paramInt, byte[] paramArrayOfbyte) {
/*     */     try {
/* 115 */       return N_GetBytes(this.N_CefHandle, paramInt, paramArrayOfbyte);
/* 116 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 117 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 119 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final native CefPostDataElement_N N_Create();
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native boolean N_IsReadOnly(long paramLong);
/*     */   
/*     */   private final native void N_SetToEmpty(long paramLong);
/*     */   
/*     */   private final native void N_SetToFile(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetToBytes(long paramLong, int paramInt, byte[] paramArrayOfbyte);
/*     */   
/*     */   private final native Type N_GetType(long paramLong);
/*     */   
/*     */   private final native String N_GetFile(long paramLong);
/*     */   
/*     */   private final native int N_GetBytesCount(long paramLong);
/*     */   
/*     */   private final native int N_GetBytes(long paramLong, int paramInt, byte[] paramArrayOfbyte);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefPostDataElement_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */