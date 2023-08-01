/*     */ package org.cef.callback;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefContextMenuParams_N
/*     */   extends CefNativeAdapter
/*     */   implements CefContextMenuParams
/*     */ {
/*     */   public int getXCoord() {
/*     */     try {
/*  15 */       return N_GetXCoord(getNativeRef(null));
/*  16 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  17 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  19 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getYCoord() {
/*     */     try {
/*  25 */       return N_GetYCoord(getNativeRef(null));
/*  26 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  27 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  29 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getTypeFlags() {
/*     */     try {
/*  35 */       return N_GetTypeFlags(getNativeRef(null));
/*  36 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  37 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  39 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLinkUrl() {
/*     */     try {
/*  45 */       return N_GetLinkUrl(getNativeRef(null));
/*  46 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  47 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  49 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getUnfilteredLinkUrl() {
/*     */     try {
/*  55 */       return N_GetUnfilteredLinkUrl(getNativeRef(null));
/*  56 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  57 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  59 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getSourceUrl() {
/*     */     try {
/*  65 */       return N_GetSourceUrl(getNativeRef(null));
/*  66 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  67 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  69 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasImageContents() {
/*     */     try {
/*  75 */       return N_HasImageContents(getNativeRef(null));
/*  76 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  77 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  79 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getPageUrl() {
/*     */     try {
/*  85 */       return N_GetPageUrl(getNativeRef(null));
/*  86 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  87 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  89 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFrameUrl() {
/*     */     try {
/*  95 */       return N_GetFrameUrl(getNativeRef(null));
/*  96 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  97 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  99 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getFrameCharset() {
/*     */     try {
/* 105 */       return N_GetFrameCharset(getNativeRef(null));
/* 106 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 107 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 109 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public MediaType getMediaType() {
/*     */     try {
/* 115 */       return N_GetMediaType(getNativeRef(null));
/* 116 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 117 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 119 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getMediaStateFlags() {
/*     */     try {
/* 125 */       return N_GetMediaStateFlags(getNativeRef(null));
/* 126 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 127 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 129 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getSelectionText() {
/*     */     try {
/* 135 */       return N_GetSelectionText(getNativeRef(null));
/* 136 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 137 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 139 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getMisspelledWord() {
/*     */     try {
/* 145 */       return N_GetMisspelledWord(getNativeRef(null));
/* 146 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 147 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 149 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean getDictionarySuggestions(Vector<String> paramVector) {
/*     */     try {
/* 155 */       return N_GetDictionarySuggestions(getNativeRef(null), paramVector);
/* 156 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 157 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 159 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isEditable() {
/*     */     try {
/* 165 */       return N_IsEditable(getNativeRef(null));
/* 166 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 167 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 169 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSpellCheckEnabled() {
/*     */     try {
/* 175 */       return N_IsSpellCheckEnabled(getNativeRef(null));
/* 176 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 177 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 179 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getEditStateFlags() {
/*     */     try {
/* 185 */       return N_GetEditStateFlags(getNativeRef(null));
/* 186 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 187 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 189 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final native int N_GetXCoord(long paramLong);
/*     */   
/*     */   private final native int N_GetYCoord(long paramLong);
/*     */   
/*     */   private final native int N_GetTypeFlags(long paramLong);
/*     */   
/*     */   private final native String N_GetLinkUrl(long paramLong);
/*     */   
/*     */   private final native String N_GetUnfilteredLinkUrl(long paramLong);
/*     */   
/*     */   private final native String N_GetSourceUrl(long paramLong);
/*     */   
/*     */   private final native boolean N_HasImageContents(long paramLong);
/*     */   
/*     */   private final native String N_GetPageUrl(long paramLong);
/*     */   
/*     */   private final native String N_GetFrameUrl(long paramLong);
/*     */   
/*     */   private final native String N_GetFrameCharset(long paramLong);
/*     */   
/*     */   private final native MediaType N_GetMediaType(long paramLong);
/*     */   
/*     */   private final native int N_GetMediaStateFlags(long paramLong);
/*     */   
/*     */   private final native String N_GetSelectionText(long paramLong);
/*     */   
/*     */   private final native String N_GetMisspelledWord(long paramLong);
/*     */   
/*     */   private final native boolean N_GetDictionarySuggestions(long paramLong, Vector<String> paramVector);
/*     */   
/*     */   private final native boolean N_IsEditable(long paramLong);
/*     */   
/*     */   private final native boolean N_IsSpellCheckEnabled(long paramLong);
/*     */   
/*     */   private final native int N_GetEditStateFlags(long paramLong);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefContextMenuParams_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */