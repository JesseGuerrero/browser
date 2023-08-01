/*     */ package org.cef.callback;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefDownloadItem_N
/*     */   extends CefNativeAdapter
/*     */   implements CefDownloadItem
/*     */ {
/*     */   public boolean isValid() {
/*     */     try {
/*  15 */       return N_IsValid(getNativeRef(null));
/*  16 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  17 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  19 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isInProgress() {
/*     */     try {
/*  25 */       return N_IsInProgress(getNativeRef(null));
/*  26 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  27 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  29 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isComplete() {
/*     */     try {
/*  35 */       return N_IsComplete(getNativeRef(null));
/*  36 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  37 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  39 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCanceled() {
/*     */     try {
/*  45 */       return N_IsCanceled(getNativeRef(null));
/*  46 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  47 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  49 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getCurrentSpeed() {
/*     */     try {
/*  55 */       return N_GetCurrentSpeed(getNativeRef(null));
/*  56 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  57 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  59 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPercentComplete() {
/*     */     try {
/*  65 */       return N_GetPercentComplete(getNativeRef(null));
/*  66 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  67 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  69 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getTotalBytes() {
/*     */     try {
/*  75 */       return N_GetTotalBytes(getNativeRef(null));
/*  76 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  77 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  79 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getReceivedBytes() {
/*     */     try {
/*  85 */       return N_GetReceivedBytes(getNativeRef(null));
/*  86 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  87 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  89 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/*     */     try {
/*  95 */       return N_GetStartTime(getNativeRef(null));
/*  96 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  97 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  99 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Date getEndTime() {
/*     */     try {
/* 105 */       return N_GetEndTime(getNativeRef(null));
/* 106 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 107 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 109 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFullPath() {
/*     */     try {
/* 115 */       return N_GetFullPath(getNativeRef(null));
/* 116 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 117 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 119 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getId() {
/*     */     try {
/* 125 */       return N_GetId(getNativeRef(null));
/* 126 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 127 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 129 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getURL() {
/*     */     try {
/* 135 */       return N_GetURL(getNativeRef(null));
/* 136 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 137 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 139 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getSuggestedFileName() {
/*     */     try {
/* 145 */       return N_GetSuggestedFileName(getNativeRef(null));
/* 146 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 147 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 149 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getContentDisposition() {
/*     */     try {
/* 155 */       return N_GetContentDisposition(getNativeRef(null));
/* 156 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 157 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 159 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getMimeType() {
/*     */     try {
/* 165 */       return N_GetMimeType(getNativeRef(null));
/* 166 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 167 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 169 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final native boolean N_IsValid(long paramLong);
/*     */   
/*     */   private final native boolean N_IsInProgress(long paramLong);
/*     */   
/*     */   private final native boolean N_IsComplete(long paramLong);
/*     */   
/*     */   private final native boolean N_IsCanceled(long paramLong);
/*     */   
/*     */   private final native long N_GetCurrentSpeed(long paramLong);
/*     */   
/*     */   private final native int N_GetPercentComplete(long paramLong);
/*     */   
/*     */   private final native long N_GetTotalBytes(long paramLong);
/*     */   
/*     */   private final native long N_GetReceivedBytes(long paramLong);
/*     */   
/*     */   private final native Date N_GetStartTime(long paramLong);
/*     */   
/*     */   private final native Date N_GetEndTime(long paramLong);
/*     */   
/*     */   private final native String N_GetFullPath(long paramLong);
/*     */   
/*     */   private final native int N_GetId(long paramLong);
/*     */   
/*     */   private final native String N_GetURL(long paramLong);
/*     */   
/*     */   private final native String N_GetSuggestedFileName(long paramLong);
/*     */   
/*     */   private final native String N_GetContentDisposition(long paramLong);
/*     */   
/*     */   private final native String N_GetMimeType(long paramLong);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefDownloadItem_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */