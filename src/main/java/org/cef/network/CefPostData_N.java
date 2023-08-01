/*     */ package org.cef.network;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.cef.callback.CefNative;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefPostData_N
/*     */   extends CefPostData
/*     */   implements CefNative
/*     */ {
/*  16 */   private long N_CefHandle = 0L;
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
/*     */   public static CefPostData createNative() {
/*     */     try {
/*  34 */       return N_Create();
/*  35 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  36 */       unsatisfiedLinkError.printStackTrace();
/*  37 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  44 */       N_Dispose(this.N_CefHandle);
/*  45 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  46 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*     */     try {
/*  53 */       return N_IsReadOnly(this.N_CefHandle);
/*  54 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  55 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  57 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getElementCount() {
/*     */     try {
/*  63 */       return N_GetElementCount(this.N_CefHandle);
/*  64 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  65 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  67 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getElements(Vector<CefPostDataElement> paramVector) {
/*     */     try {
/*  73 */       N_GetElements(this.N_CefHandle, paramVector);
/*  74 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  75 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeElement(CefPostDataElement paramCefPostDataElement) {
/*     */     try {
/*  82 */       return N_RemoveElement(this.N_CefHandle, paramCefPostDataElement);
/*  83 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  84 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  86 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean addElement(CefPostDataElement paramCefPostDataElement) {
/*     */     try {
/*  92 */       return N_AddElement(this.N_CefHandle, paramCefPostDataElement);
/*  93 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  94 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  96 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeElements() {
/*     */     try {
/* 102 */       N_RemoveElements(this.N_CefHandle);
/* 103 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 104 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final native CefPostData_N N_Create();
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native boolean N_IsReadOnly(long paramLong);
/*     */   
/*     */   private final native int N_GetElementCount(long paramLong);
/*     */   
/*     */   private final native void N_GetElements(long paramLong, Vector<CefPostDataElement> paramVector);
/*     */   
/*     */   private final native boolean N_RemoveElement(long paramLong, CefPostDataElement paramCefPostDataElement);
/*     */   
/*     */   private final native boolean N_AddElement(long paramLong, CefPostDataElement paramCefPostDataElement);
/*     */   
/*     */   private final native void N_RemoveElements(long paramLong);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefPostData_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */