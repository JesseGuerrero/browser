/*     */ package org.cef.network;
/*     */ 
/*     */ import org.cef.callback.CefCompletionCallback;
/*     */ import org.cef.callback.CefCookieVisitor;
/*     */ import org.cef.callback.CefNative;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefCookieManager_N
/*     */   extends CefCookieManager
/*     */   implements CefNative
/*     */ {
/*  15 */   private long N_CefHandle = 0L;
/*  16 */   private static CefCookieManager_N globalInstance = null;
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  20 */     this.N_CefHandle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  25 */     return this.N_CefHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final synchronized CefCookieManager_N getGlobalManagerNative() {
/*  33 */     if (globalInstance != null && globalInstance.N_CefHandle != 0L)
/*     */     {
/*  35 */       return globalInstance;
/*     */     }
/*     */     
/*  38 */     CefCookieManager_N cefCookieManager_N = null;
/*     */     try {
/*  40 */       cefCookieManager_N = N_GetGlobalManager();
/*  41 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  42 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */     
/*  45 */     globalInstance = cefCookieManager_N;
/*  46 */     return globalInstance;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  52 */       N_Dispose(this.N_CefHandle);
/*  53 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  54 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean visitAllCookies(CefCookieVisitor paramCefCookieVisitor) {
/*     */     try {
/*  61 */       return N_VisitAllCookies(this.N_CefHandle, paramCefCookieVisitor);
/*  62 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  63 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  65 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean visitUrlCookies(String paramString, boolean paramBoolean, CefCookieVisitor paramCefCookieVisitor) {
/*     */     try {
/*  71 */       return N_VisitUrlCookies(this.N_CefHandle, paramString, paramBoolean, paramCefCookieVisitor);
/*  72 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  73 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  75 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setCookie(String paramString, CefCookie paramCefCookie) {
/*     */     try {
/*  81 */       return N_SetCookie(this.N_CefHandle, paramString, paramCefCookie);
/*  82 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  83 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  85 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean deleteCookies(String paramString1, String paramString2) {
/*     */     try {
/*  91 */       return N_DeleteCookies(this.N_CefHandle, paramString1, paramString2);
/*  92 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  93 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  95 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean flushStore(CefCompletionCallback paramCefCompletionCallback) {
/*     */     try {
/* 101 */       return N_FlushStore(this.N_CefHandle, paramCefCompletionCallback);
/* 102 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 103 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 105 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final native CefCookieManager_N N_GetGlobalManager();
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native boolean N_VisitAllCookies(long paramLong, CefCookieVisitor paramCefCookieVisitor);
/*     */   
/*     */   private final native boolean N_VisitUrlCookies(long paramLong, String paramString, boolean paramBoolean, CefCookieVisitor paramCefCookieVisitor);
/*     */   
/*     */   private final native boolean N_SetCookie(long paramLong, String paramString, CefCookie paramCefCookie);
/*     */   
/*     */   private final native boolean N_DeleteCookies(long paramLong, String paramString1, String paramString2);
/*     */   
/*     */   private final native boolean N_FlushStore(long paramLong, CefCompletionCallback paramCefCompletionCallback);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefCookieManager_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */