/*     */ package org.cef.network;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public abstract class CefRequest
/*     */ {
/*     */   public enum ResourceType
/*     */   {
/*  21 */     RT_MAIN_FRAME,
/*  22 */     RT_SUB_FRAME,
/*  23 */     RT_STYLESHEET,
/*  24 */     RT_SCRIPT,
/*  25 */     RT_IMAGE,
/*  26 */     RT_FONT_RESOURCE,
/*  27 */     RT_SUB_RESOURCE,
/*     */     
/*  29 */     RT_OBJECT,
/*     */     
/*  31 */     RT_MEDIA,
/*  32 */     RT_WORKER,
/*  33 */     RT_SHARED_WORKER,
/*  34 */     RT_PREFETCH,
/*  35 */     RT_FAVICON,
/*  36 */     RT_XHR,
/*  37 */     RT_PING,
/*  38 */     RT_SERVICE_WORKER,
/*  39 */     RT_CSP_REPORT,
/*  40 */     RT_PLUGIN_RESOURCE
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
/*     */   public enum TransitionType
/*     */   {
/*  53 */     TT_LINK(0),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     TT_EXPLICIT(1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     TT_AUTO_SUBFRAME(3),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     TT_MANUAL_SUBFRAME(4),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     TT_FORM_SUBMIT(7),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     TT_RELOAD(8);
/*     */     private int value;
/*     */     
/*     */     TransitionType(int param1Int1) {
/*  96 */       this.value = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getValue() {
/* 105 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSource() {
/* 113 */       return this.value & 0xFF;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addQualifier(TransitionFlags param1TransitionFlags) {
/* 122 */       this.value |= param1TransitionFlags.getValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addQualifiers(int param1Int) {
/* 129 */       this.value |= param1Int & 0xFFFFFF00;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getQualifiers() {
/* 137 */       return this.value & 0xFFFFFF00;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeQualifier(TransitionFlags param1TransitionFlags) {
/* 145 */       this.value &= param1TransitionFlags.getValue() ^ 0xFFFFFFFF;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSet(TransitionFlags param1TransitionFlags) {
/* 152 */       return ((this.value & param1TransitionFlags.getValue()) != 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isRedirect() {
/* 159 */       return ((this.value & 0xC0000000) != 0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class CefUrlRequestFlags
/*     */   {
/*     */     public static final int UR_FLAG_NONE = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int UR_FLAG_SKIP_CACHE = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int UR_FLAG_ALLOW_CACHED_CREDENTIALS = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int UR_FLAG_REPORT_UPLOAD_PROGRESS = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int UR_FLAG_REPORT_RAW_HEADERS = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int UR_FLAG_NO_DOWNLOAD_DATA = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int UR_FLAG_NO_RETRY_ON_5XX = 128;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum TransitionFlags
/*     */   {
/* 212 */     TT_BLOCKED_FLAG(8388608),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     TT_FORWARD_BACK_FLAG(16777216),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     TT_CHAIN_START_FLAG(268435456),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     TT_CHAIN_END_FLAG(536870912),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     TT_CLIENT_REDIRECT_FLAG(1073741824),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 237 */     TT_SERVER_REDIRECT_FLAG(-2147483648);
/*     */     private final int flag;
/*     */     
/*     */     TransitionFlags(int param1Int1) {
/* 241 */       this.flag = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getValue() {
/* 249 */       return this.flag;
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
/*     */   public enum ReferrerPolicy
/*     */   {
/* 264 */     REFERRER_POLICY_DEFAULT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     REFERRER_POLICY_CLEAR_REFERRER_ON_TRANSITION_FROM_SECURE_TO_INSECURE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     REFERRER_POLICY_REDUCE_REFERRER_GRANULARITY_ON_TRANSITION_CROSS_ORIGIN,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     REFERRER_POLICY_ORIGIN_ONLY_ON_TRANSITION_CROSS_ORIGIN,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     REFERRER_POLICY_NEVER_CLEAR_REFERRER,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     REFERRER_POLICY_ORIGIN,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     REFERRER_POLICY_CLEAR_REFERRER_ON_TRANSITION_CROSS_ORIGIN,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     REFERRER_POLICY_ORIGIN_CLEAR_ON_TRANSITION_FROM_SECURE_TO_INSECURE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 312 */     REFERRER_POLICY_NO_REFERRER,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 317 */     REFERRER_POLICY_LAST_VALUE
	/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 325 */     dispose();
/* 326 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefRequest create() {

/* 333 */     return CefRequest_N.createNative();
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
/*     */   public abstract long getIdentifier();
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
/*     */   public abstract String getURL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setURL(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getMethod();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setMethod(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setReferrer(String paramString, ReferrerPolicy paramReferrerPolicy);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getReferrerURL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ReferrerPolicy getReferrerPolicy();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract CefPostData getPostData();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setPostData(CefPostData paramCefPostData);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getHeaderByName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setHeaderByName(String paramString1, String paramString2, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void getHeaderMap(Map<String, String> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setHeaderMap(Map<String, String> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void set(String paramString1, String paramString2, CefPostData paramCefPostData, Map<String, String> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getFlags();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setFlags(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getFirstPartyForCookies();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setFirstPartyForCookies(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ResourceType getResourceType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract TransitionType getTransitionType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 474 */     String str1 = "\nHTTP-Request";
/* 475 */     str1 = str1 + "\n  flags: " + getFlags();
/* 476 */     str1 = str1 + "\n  resourceType: " + getResourceType();
/* 477 */     str1 = str1 + "\n  transitionType: " + getTransitionType();
/* 478 */     str1 = str1 + "\n  firstPartyForCookies: " + getFirstPartyForCookies();
/* 479 */     str1 = str1 + "\n  referrerURL: " + getReferrerURL();
/* 480 */     str1 = str1 + "\n  referrerPolicy: " + getReferrerPolicy();
/* 481 */     str1 = str1 + "\n    " + getMethod() + " " + getURL() + " HTTP/1.1\n";
/*     */     
/* 483 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 484 */     getHeaderMap((Map)hashMap);
/* 485 */     Set<Map.Entry<Object, Object>> set = hashMap.entrySet();
/* 486 */     String str2 = null;
/* 487 */     for (Map.Entry<Object, Object> entry : set) {
/* 488 */       String str = (String)entry.getKey();
/* 489 */       str1 = str1 + "    " + str + "=" + entry.getValue() + "\n";
/* 490 */       if (str.equals("Content-Type")) {
/* 491 */         str2 = (String)entry.getValue();
/*     */       }
/*     */     } 
/*     */     
/* 495 */     CefPostData cefPostData = getPostData();
/* 496 */     if (cefPostData != null) {
/* 497 */       str1 = str1 + cefPostData.toString(str2);
/*     */     }
/*     */     
/* 500 */     return str1;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */