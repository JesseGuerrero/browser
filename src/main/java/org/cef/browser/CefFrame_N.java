/*     */ package org.cef.browser;
/*     */ 
/*     */ import org.cef.callback.CefNativeAdapter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefFrame_N
/*     */   extends CefNativeAdapter
/*     */   implements CefFrame
/*     */ {
/*     */   protected void finalize() throws Throwable {
/*  19 */     dispose();
/*  20 */     super.finalize();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  26 */       N_Dispose(getNativeRef(null));
/*  27 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  28 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getIdentifier() {
/*     */     try {
/*  35 */       return N_GetIdentifier(getNativeRef(null));
/*  36 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  37 */       unsatisfiedLinkError.printStackTrace();
/*  38 */       return -1L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getURL() {
/*     */     try {
/*  45 */       return N_GetURL(getNativeRef(null));
/*  46 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  47 */       unsatisfiedLinkError.printStackTrace();
/*  48 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*     */     try {
/*  55 */       return N_GetName(getNativeRef(null));
/*  56 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  57 */       unsatisfiedLinkError.printStackTrace();
/*  58 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMain() {
/*     */     try {
/*  65 */       return N_IsMain(getNativeRef(null));
/*  66 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  67 */       unsatisfiedLinkError.printStackTrace();
/*  68 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/*     */     try {
/*  75 */       return N_IsValid(getNativeRef(null));
/*  76 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  77 */       unsatisfiedLinkError.printStackTrace();
/*  78 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFocused() {
/*     */     try {
/*  85 */       return N_IsFocused(getNativeRef(null));
/*  86 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  87 */       unsatisfiedLinkError.printStackTrace();
/*  88 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefFrame getParent() {
/*     */     try {
/*  95 */       return N_GetParent(getNativeRef(null));
/*  96 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  97 */       unsatisfiedLinkError.printStackTrace();
/*  98 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeJavaScript(String paramString1, String paramString2, int paramInt) {
/*     */     try {
/* 105 */       N_ExecuteJavaScript(getNativeRef(null), paramString1, paramString2, paramInt);
/* 106 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 107 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void undo() {
/*     */     try {
/* 113 */       N_Undo(getNativeRef(null));
/* 114 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 115 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void redo() {
/*     */     try {
/* 121 */       N_Redo(getNativeRef(null));
/* 122 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 123 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cut() {
/*     */     try {
/* 129 */       N_Cut(getNativeRef(null));
/* 130 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 131 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void copy() {
/*     */     try {
/* 137 */       N_Copy(getNativeRef(null));
/* 138 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 139 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void paste() {
/*     */     try {
/* 145 */       N_Paste(getNativeRef(null));
/* 146 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 147 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native long N_GetIdentifier(long paramLong);
/*     */   
/*     */   private final native String N_GetURL(long paramLong);
/*     */   
/*     */   private final native String N_GetName(long paramLong);
/*     */   
/*     */   private final native boolean N_IsMain(long paramLong);
/*     */   
/*     */   private final native boolean N_IsValid(long paramLong);
/*     */   
/*     */   private final native boolean N_IsFocused(long paramLong);
/*     */   
/*     */   private final native CefFrame N_GetParent(long paramLong);
/*     */   
/*     */   private final native void N_ExecuteJavaScript(long paramLong, String paramString1, String paramString2, int paramInt);
/*     */   
/*     */   private final native void N_Undo(long paramLong);
/*     */   
/*     */   private final native void N_Redo(long paramLong);
/*     */   
/*     */   private final native void N_Cut(long paramLong);
/*     */   
/*     */   private final native void N_Copy(long paramLong);
/*     */   
/*     */   private final native void N_Paste(long paramLong);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefFrame_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */