/*     */ package org.cef.network;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.cef.callback.CefNative;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefRequest_N
/*     */   extends CefRequest
/*     */   implements CefNative
/*     */ {
/*  13 */   private long N_CefHandle = 0L;
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  17 */     this.N_CefHandle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  22 */     return this.N_CefHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CefRequest createNative() {
/*     */     try {
/*  31 */       return N_Create();
/*  32 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  33 */       unsatisfiedLinkError.printStackTrace();
/*  34 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  41 */       N_Dispose(this.N_CefHandle);
/*  42 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  43 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getIdentifier() {
/*     */     try {
/*  50 */       return N_GetIdentifier(this.N_CefHandle);
/*  51 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  52 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  54 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isReadOnly() {
/*     */     try {
/*  60 */       return N_IsReadOnly(this.N_CefHandle);
/*  61 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  62 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  64 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getURL() {
/*     */     try {
/*  70 */       return N_GetURL(this.N_CefHandle);
/*  71 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  72 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  74 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setURL(String paramString) {
/*     */     try {
/*  80 */       N_SetURL(this.N_CefHandle, paramString);
/*  81 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  82 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMethod() {
/*     */     try {
/*  89 */       return N_GetMethod(this.N_CefHandle);
/*  90 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  91 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  93 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMethod(String paramString) {
/*     */     try {
/*  99 */       N_SetMethod(this.N_CefHandle, paramString);
/* 100 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 101 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReferrer(String paramString, ReferrerPolicy paramReferrerPolicy) {
/*     */     try {
/* 108 */       N_SetReferrer(this.N_CefHandle, paramString, paramReferrerPolicy);
/* 109 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 110 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getReferrerURL() {
/*     */     try {
/* 117 */       return N_GetReferrerURL(this.N_CefHandle);
/* 118 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 119 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 121 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public ReferrerPolicy getReferrerPolicy() {
/*     */     try {
/* 127 */       return N_GetReferrerPolicy(this.N_CefHandle);
/* 128 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 129 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 131 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CefPostData getPostData() {
/*     */     try {
/* 137 */       return N_GetPostData(this.N_CefHandle);
/* 138 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 139 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 141 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPostData(CefPostData paramCefPostData) {
/*     */     try {
/* 147 */       N_SetPostData(this.N_CefHandle, paramCefPostData);
/* 148 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 149 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHeaderByName(String paramString) {
/*     */     try {
/* 156 */       return N_GetHeaderByName(this.N_CefHandle, paramString);
/* 157 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 158 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 160 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setHeaderByName(String paramString1, String paramString2, boolean paramBoolean) {
/*     */     try {
/* 166 */       N_SetHeaderByName(this.N_CefHandle, paramString1, paramString2, paramBoolean);
/* 167 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 168 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void getHeaderMap(Map<String, String> paramMap) {
/*     */     try {
/* 175 */       N_GetHeaderMap(this.N_CefHandle, paramMap);
/* 176 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 177 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeaderMap(Map<String, String> paramMap) {
/*     */     try {
/* 184 */       N_SetHeaderMap(this.N_CefHandle, paramMap);
/* 185 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 186 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(String paramString1, String paramString2, CefPostData paramCefPostData, Map<String, String> paramMap) {
/*     */     try {
/* 194 */       N_Set(this.N_CefHandle, paramString1, paramString2, paramCefPostData, paramMap);
/* 195 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 196 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFlags() {
/*     */     try {
/* 203 */       return N_GetFlags(this.N_CefHandle);
/* 204 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 205 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 207 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFlags(int paramInt) {
/*     */     try {
/* 213 */       N_SetFlags(this.N_CefHandle, paramInt);
/* 214 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 215 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFirstPartyForCookies() {
/*     */     try {
/* 222 */       return N_GetFirstPartyForCookies(this.N_CefHandle);
/* 223 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 224 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 226 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFirstPartyForCookies(String paramString) {
/*     */     try {
/* 232 */       N_SetFirstPartyForCookies(this.N_CefHandle, paramString);
/* 233 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 234 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceType getResourceType() {
/*     */     try {
/* 241 */       return N_GetResourceType(this.N_CefHandle);
/* 242 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 243 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 245 */       return ResourceType.RT_MAIN_FRAME;
/*     */     } 
/*     */   }
/*     */   
/*     */   public TransitionType getTransitionType() {
/*     */     try {
/* 251 */       return N_GetTransitionType(this.N_CefHandle);
/* 252 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 253 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 255 */       return TransitionType.TT_AUTO_SUBFRAME;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final native CefRequest_N N_Create();
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native long N_GetIdentifier(long paramLong);
/*     */   
/*     */   private final native boolean N_IsReadOnly(long paramLong);
/*     */   
/*     */   private final native String N_GetURL(long paramLong);
/*     */   
/*     */   private final native void N_SetURL(long paramLong, String paramString);
/*     */   
/*     */   private final native String N_GetMethod(long paramLong);
/*     */   
/*     */   private final native void N_SetMethod(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetReferrer(long paramLong, String paramString, ReferrerPolicy paramReferrerPolicy);
/*     */   
/*     */   private final native String N_GetReferrerURL(long paramLong);
/*     */   
/*     */   private final native ReferrerPolicy N_GetReferrerPolicy(long paramLong);
/*     */   
/*     */   private final native CefPostData N_GetPostData(long paramLong);
/*     */   
/*     */   private final native void N_SetPostData(long paramLong, CefPostData paramCefPostData);
/*     */   
/*     */   private final native String N_GetHeaderByName(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_SetHeaderByName(long paramLong, String paramString1, String paramString2, boolean paramBoolean);
/*     */   
/*     */   private final native void N_GetHeaderMap(long paramLong, Map<String, String> paramMap);
/*     */   
/*     */   private final native void N_SetHeaderMap(long paramLong, Map<String, String> paramMap);
/*     */   
/*     */   private final native void N_Set(long paramLong, String paramString1, String paramString2, CefPostData paramCefPostData, Map<String, String> paramMap);
/*     */   
/*     */   private final native int N_GetFlags(long paramLong);
/*     */   
/*     */   private final native void N_SetFlags(long paramLong, int paramInt);
/*     */   
/*     */   private final native String N_GetFirstPartyForCookies(long paramLong);
/*     */   
/*     */   private final native void N_SetFirstPartyForCookies(long paramLong, String paramString);
/*     */   
/*     */   private final native ResourceType N_GetResourceType(long paramLong);
/*     */   
/*     */   private final native TransitionType N_GetTransitionType(long paramLong);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefRequest_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */