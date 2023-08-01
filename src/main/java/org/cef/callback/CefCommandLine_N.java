/*     */ package org.cef.callback;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefCommandLine_N
/*     */   extends CefNativeAdapter
/*     */   implements CefCommandLine
/*     */ {
/*     */   public void reset() {
/*     */     try {
/*  16 */       N_Reset(getNativeRef(null));
/*  17 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  18 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getProgram() {
/*     */     try {
/*  25 */       return N_GetProgram(getNativeRef(null));
/*  26 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  27 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  29 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setProgram(String paramString) {
/*     */     try {
/*  35 */       N_SetProgram(getNativeRef(null), paramString);
/*  36 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  37 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSwitches() {
/*     */     try {
/*  44 */       return N_HasSwitches(getNativeRef(null));
/*  45 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  46 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  48 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasSwitch(String paramString) {
/*     */     try {
/*  54 */       return N_HasSwitch(getNativeRef(null), paramString);
/*  55 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  56 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  58 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getSwitchValue(String paramString) {
/*     */     try {
/*  64 */       return N_GetSwitchValue(getNativeRef(null), paramString);
/*  65 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  66 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  68 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<String, String> getSwitches() {
/*     */     try {
/*  74 */       return N_GetSwitches(getNativeRef(null));
/*  75 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  76 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  78 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void appendSwitch(String paramString) {
/*     */     try {
/*  84 */       N_AppendSwitch(getNativeRef(null), paramString);
/*  85 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  86 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendSwitchWithValue(String paramString1, String paramString2) {
/*     */     try {
/*  93 */       N_AppendSwitchWithValue(getNativeRef(null), paramString1, paramString2);
/*  94 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  95 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasArguments() {
/*     */     try {
/* 102 */       return N_HasArguments(getNativeRef(null));
/* 103 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 104 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 106 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Vector<String> getArguments() {
/*     */     try {
/* 112 */       return N_GetArguments(getNativeRef(null));
/* 113 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 114 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 116 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void appendArgument(String paramString) {
/*     */     try {
/* 122 */       N_AppendArgument(getNativeRef(null), paramString);
/* 123 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 124 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     String str = "CefCommandLine [program='" + getProgram() + "'";
/* 131 */     if (hasSwitches()) {
/* 132 */       Map<String, String> map = getSwitches();
/* 133 */       str = str + ", switches=" + map;
/*     */     } 
/* 135 */     if (hasArguments()) {
/* 136 */       Vector<String> vector = getArguments();
/* 137 */       str = str + ", arguments=" + vector;
/*     */     } 
/* 139 */     return str + "]";
/*     */   }
/*     */   
/*     */   private final native void N_Reset(long paramLong);
/*     */   
/*     */   private final native String N_GetProgram(long paramLong);
/*     */   
/*     */   private final native void N_SetProgram(long paramLong, String paramString);
/*     */   
/*     */   private final native boolean N_HasSwitches(long paramLong);
/*     */   
/*     */   private final native boolean N_HasSwitch(long paramLong, String paramString);
/*     */   
/*     */   private final native String N_GetSwitchValue(long paramLong, String paramString);
/*     */   
/*     */   private final native Map<String, String> N_GetSwitches(long paramLong);
/*     */   
/*     */   private final native void N_AppendSwitch(long paramLong, String paramString);
/*     */   
/*     */   private final native void N_AppendSwitchWithValue(long paramLong, String paramString1, String paramString2);
/*     */   
/*     */   private final native boolean N_HasArguments(long paramLong);
/*     */   
/*     */   private final native Vector<String> N_GetArguments(long paramLong);
/*     */   
/*     */   private final native void N_AppendArgument(long paramLong, String paramString);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefCommandLine_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */