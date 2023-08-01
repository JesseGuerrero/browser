/*     */ package org.cef.callback;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.Vector;
/*     */ 
/*     */ class CefDragData_N
/*     */   extends CefDragData implements CefNative {
/*   8 */   private long N_CefHandle = 0L;
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  12 */     this.N_CefHandle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  17 */     return this.N_CefHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CefDragData createNative() {
/*     */     try {
/*  26 */       return N_Create();
/*  27 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  28 */       unsatisfiedLinkError.printStackTrace();
/*  29 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CefDragData clone() {
/*     */     try {
/*  36 */       return N_Clone(this.N_CefHandle);
/*  37 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  38 */       unsatisfiedLinkError.printStackTrace();
/*  39 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  46 */       N_Dispose(this.N_CefHandle);
/*  47 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  48 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*     */     try {
/*  55 */       return N_IsReadOnly(this.N_CefHandle);
/*  56 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  57 */       unsatisfiedLinkError.printStackTrace();
/*  58 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLink() {
/*     */     try {
/*  65 */       return N_IsLink(this.N_CefHandle);
/*  66 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  67 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  69 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFragment() {
/*     */     try {
/*  75 */       return N_IsFragment(this.N_CefHandle);
/*  76 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  77 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  79 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFile() {
/*     */     try {
/*  85 */       return N_IsFile(this.N_CefHandle);
/*  86 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  87 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  89 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLinkURL() {
/*     */     try {
/*  95 */       return N_GetLinkURL(this.N_CefHandle);
/*  96 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  97 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  99 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLinkTitle() {
/*     */     try {
/* 105 */       return N_GetLinkTitle(this.N_CefHandle);
/* 106 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 107 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 109 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLinkMetadata() {
/*     */     try {
/* 115 */       return N_GetLinkMetadata(this.N_CefHandle);
/* 116 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 117 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 119 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFragmentText() {
/*     */     try {
/* 125 */       return N_GetFragmentText(this.N_CefHandle);
/* 126 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 127 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 129 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFragmentHtml() {
/*     */     try {
/* 135 */       return N_GetFragmentHtml(this.N_CefHandle);
/* 136 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 137 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 139 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFragmentBaseURL() {
/*     */     try {
/* 145 */       return N_GetFragmentBaseURL(this.N_CefHandle);
/* 146 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 147 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 149 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getFileContents(OutputStream paramOutputStream) {
/*     */     try {
/* 155 */       return N_GetFileContents(this.N_CefHandle, paramOutputStream);
/* 156 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 157 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 159 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFileName() {
/*     */     try {
/* 165 */       return N_GetFileName(this.N_CefHandle);
/* 166 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 167 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 169 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean getFileNames(Vector<String> paramVector) {
/*     */     try {
/* 175 */       return N_GetFileNames(this.N_CefHandle, paramVector);
/* 176 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 177 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 179 */       return false;
/*     */     } 
/*     */   }
/*     */   public void setLinkURL(String paramString) {
/*     */     try {
/* 184 */       N_SetLinkURL(this.N_CefHandle, paramString);
/* 185 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 186 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setLinkTitle(String paramString) {
/*     */     try {
/* 192 */       N_SetLinkTitle(this.N_CefHandle, paramString);
/* 193 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 194 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setLinkMetadata(String paramString) {
/*     */     try {
/* 200 */       N_SetLinkMetadata(this.N_CefHandle, paramString);
/* 201 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 202 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFragmentText(String paramString) {
/*     */     try {
/* 208 */       N_SetFragmentText(this.N_CefHandle, paramString);
/* 209 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 210 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFragmentHtml(String paramString) {
/*     */     try {
/* 216 */       N_SetFragmentHtml(this.N_CefHandle, paramString);
/* 217 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 218 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFragmentBaseURL(String paramString) {
/*     */     try {
/* 224 */       N_SetFragmentBaseURL(this.N_CefHandle, paramString);
/* 225 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 226 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void resetFileContents() {
/*     */     try {
/* 232 */       N_ResetFileContents(this.N_CefHandle);
/* 233 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 234 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addFile(String paramString1, String paramString2) {
/*     */     try {
/* 240 */       N_AddFile(this.N_CefHandle, paramString1, paramString2);
/* 241 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 242 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 273 */     Vector<String> vector = new Vector();
/* 274 */     getFileNames(vector);
/* 275 */     String str = "{";
/* 276 */     for (String str1 : vector) str = str + str1 + ","; 
/* 277 */     str = str + "}";
/*     */     
/* 279 */     return "CefDragData_N [isLink()=" + isLink() + ", isFragment()=" + isFragment() + ", isFile()=" + 
/* 280 */       isFile() + ", getLinkURL()=" + getLinkURL() + ", getLinkTitle()=" + 
/* 281 */       getLinkTitle() + ", getLinkMetadata()=" + getLinkMetadata() + ", getFragmentText()=" + 
/* 282 */       getFragmentText() + ", getFragmentHtml()=" + 
/* 283 */       getFragmentHtml() + ", getFragmentBaseURL()=" + getFragmentBaseURL() + ", getFileName()=" + 
/* 284 */       getFileName() + ", getFileNames(vector)=" + str + "]";
/*     */   }
/*     */   
/*     */   private static final native CefDragData_N N_Create();
/*     */   
/*     */   private final native CefDragData_N N_Clone(long paramLong);
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native boolean N_IsReadOnly(long paramLong);
/*     */   
/*     */   private final native boolean N_IsLink(long paramLong);
/*     */   
/*     */   private final native boolean N_IsFragment(long paramLong);
/*     */   
/*     */   private final native boolean N_IsFile(long paramLong);
/*     */   
/*     */   private final native String N_GetLinkURL(long paramLong);
/*     */   
/*     */   private final native String N_GetLinkTitle(long paramLong);
/*     */   
/*     */   private final native String N_GetLinkMetadata(long paramLong);
/*     */   
/*     */   private final native String N_GetFragmentText(long paramLong);
/*     */   
/*     */   private final native String N_GetFragmentHtml(long paramLong);
/*     */   
/*     */   private final native String N_GetFragmentBaseURL(long paramLong);
/*     */   
/*     */   private final native int N_GetFileContents(long paramLong, OutputStream paramOutputStream);
/*     */   
/*     */   private final native String N_GetFileName(long paramLong);
/*     */   
/*     */   private final native boolean N_GetFileNames(long paramLong, Vector<String> paramVector);
/*     */   
/*     */   private final native void N_SetLinkURL(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetLinkTitle(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetLinkMetadata(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetFragmentText(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetFragmentHtml(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetFragmentBaseURL(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_ResetFileContents(long paramLong);
/*     */   
/*     */   private final native void N_AddFile(long paramLong, String paramString1, String paramString2);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefDragData_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */