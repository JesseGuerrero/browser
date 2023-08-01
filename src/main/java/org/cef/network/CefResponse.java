/*     */ package org.cef.network;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.cef.handler.CefLoadHandler;
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
/*     */ public abstract class CefResponse
/*     */ {
/*     */   protected void finalize() throws Throwable {
/*  24 */     dispose();
/*  25 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefResponse create() {
/*  32 */     return CefResponse_N.createNative();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void dispose();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isReadOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract CefLoadHandler.ErrorCode getError();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setError(CefLoadHandler.ErrorCode paramErrorCode);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getStatus();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setStatus(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getStatusText();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setStatusText(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getMimeType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setMimeType(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getHeaderByName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setHeaderByName(String paramString1, String paramString2, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void getHeaderMap(Map<String, String> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setHeaderMap(Map<String, String> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     String str = "\nHTTP-Response:";
/*     */     
/* 116 */     str = str + "\n  error: " + getError();
/* 117 */     str = str + "\n  readOnly: " + isReadOnly();
/* 118 */     str = str + "\n    HTTP/1.1 " + getStatus() + " " + getStatusText();
/* 119 */     str = str + "\n    Content-Type: " + getMimeType();
/*     */     
/* 121 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 122 */     getHeaderMap((Map)hashMap);
/* 123 */     Set<Map.Entry<Object, Object>> set = hashMap.entrySet();
/* 124 */     for (Map.Entry<Object, Object> entry : set) {
/* 125 */       str = str + "    " + entry.getKey() + "=" + entry.getValue() + "\n";
/*     */     }
/*     */     
/* 128 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */