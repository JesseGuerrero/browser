/*     */ package org.cef.misc;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.Vector;
/*     */ import org.cef.callback.CefNative;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefPrintSettings_N
/*     */   extends CefPrintSettings
/*     */   implements CefNative
/*     */ {
/*  15 */   private long N_CefHandle = 0L;
/*     */ 
/*     */   
/*     */   public void setNativeRef(String paramString, long paramLong) {
/*  19 */     this.N_CefHandle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNativeRef(String paramString) {
/*  24 */     return this.N_CefHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CefPrintSettings createNative() {
/*     */     try {
/*  33 */       return N_Create();
/*  34 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  35 */       unsatisfiedLinkError.printStackTrace();
/*  36 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/*  43 */       N_Dispose(this.N_CefHandle);
/*  44 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  45 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/*     */     try {
/*  52 */       return N_IsValid(this.N_CefHandle);
/*  53 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  54 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  56 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isReadOnly() {
/*     */     try {
/*  62 */       return N_IsReadOnly(this.N_CefHandle);
/*  63 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  64 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  66 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setOrientation(boolean paramBoolean) {
/*     */     try {
/*  72 */       N_SetOrientation(this.N_CefHandle, paramBoolean);
/*  73 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  74 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLandscape() {
/*     */     try {
/*  81 */       return N_IsLandscape(this.N_CefHandle);
/*  82 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  83 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  85 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrinterPrintableArea(Dimension paramDimension, Rectangle paramRectangle, boolean paramBoolean) {
/*     */     try {
/*  92 */       N_SetPrinterPrintableArea(this.N_CefHandle, paramDimension, paramRectangle, paramBoolean);
/*     */     }
/*  94 */     catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  95 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeviceName(String paramString) {
/*     */     try {
/* 102 */       N_SetDeviceName(this.N_CefHandle, paramString);
/* 103 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 104 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeviceName() {
/*     */     try {
/* 111 */       return N_GetDeviceName(this.N_CefHandle);
/* 112 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 113 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 115 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDPI(int paramInt) {
/*     */     try {
/* 121 */       N_SetDPI(this.N_CefHandle, paramInt);
/* 122 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 123 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDPI() {
/*     */     try {
/* 130 */       return N_GetDPI(this.N_CefHandle);
/* 131 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 132 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 134 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPageRanges(Vector<CefPageRange> paramVector) {
/*     */     try {
/* 140 */       N_SetPageRanges(this.N_CefHandle, paramVector);
/* 141 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 142 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPageRangesCount() {
/*     */     try {
/* 149 */       return N_GetPageRangesCount(this.N_CefHandle);
/* 150 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 151 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 153 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void getPageRanges(Vector<CefPageRange> paramVector) {
/*     */     try {
/* 159 */       N_GetPageRanges(this.N_CefHandle, paramVector);
/* 160 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 161 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectionOnly(boolean paramBoolean) {
/*     */     try {
/* 168 */       N_SetSelectionOnly(this.N_CefHandle, paramBoolean);
/* 169 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 170 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSelectionOnly() {
/*     */     try {
/* 177 */       return N_IsSelectionOnly(this.N_CefHandle);
/* 178 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 179 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 181 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCollate(boolean paramBoolean) {
/*     */     try {
/* 187 */       N_SetCollate(this.N_CefHandle, paramBoolean);
/* 188 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 189 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean willCollate() {
/*     */     try {
/* 196 */       return N_WillCollate(this.N_CefHandle);
/* 197 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 198 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 200 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setColorModel(ColorModel paramColorModel) {
/*     */     try {
/* 206 */       N_SetColorModel(this.N_CefHandle, paramColorModel);
/* 207 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 208 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorModel getColorModel() {
/*     */     try {
/* 215 */       return N_GetColorModel(this.N_CefHandle);
/* 216 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 217 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 219 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCopies(int paramInt) {
/*     */     try {
/* 225 */       N_SetCopies(this.N_CefHandle, paramInt);
/* 226 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 227 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCopies() {
/*     */     try {
/* 234 */       return N_GetCopies(this.N_CefHandle);
/* 235 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 236 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 238 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDuplexMode(DuplexMode paramDuplexMode) {
/*     */     try {
/* 244 */       N_SetDuplexMode(this.N_CefHandle, paramDuplexMode);
/* 245 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 246 */       unsatisfiedLinkError.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public DuplexMode getDuplexMode() {
/*     */     try {
/* 253 */       return N_GetDuplexMode(this.N_CefHandle);
/* 254 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 255 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 257 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final native CefPrintSettings_N N_Create();
/*     */   
/*     */   private final native void N_Dispose(long paramLong);
/*     */   
/*     */   private final native boolean N_IsValid(long paramLong);
/*     */   
/*     */   private final native boolean N_IsReadOnly(long paramLong);
/*     */   
/*     */   private final native void N_SetOrientation(long paramLong, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_IsLandscape(long paramLong);
/*     */   
/*     */   private final native void N_SetPrinterPrintableArea(long paramLong, Dimension paramDimension, Rectangle paramRectangle, boolean paramBoolean);
/*     */   
/*     */   private final native void N_SetDeviceName(long paramLong, String paramString);
/*     */   
/*     */   private final native String N_GetDeviceName(long paramLong);
/*     */   
/*     */   private final native void N_SetDPI(long paramLong, int paramInt);
/*     */   
/*     */   private final native int N_GetDPI(long paramLong);
/*     */   
/*     */   private final native void N_SetPageRanges(long paramLong, Vector<CefPageRange> paramVector);
/*     */   
/*     */   private final native int N_GetPageRangesCount(long paramLong);
/*     */   
/*     */   private final native void N_GetPageRanges(long paramLong, Vector<CefPageRange> paramVector);
/*     */   
/*     */   private final native void N_SetSelectionOnly(long paramLong, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_IsSelectionOnly(long paramLong);
/*     */   
/*     */   private final native void N_SetCollate(long paramLong, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_WillCollate(long paramLong);
/*     */   
/*     */   private final native void N_SetColorModel(long paramLong, ColorModel paramColorModel);
/*     */   
/*     */   private final native ColorModel N_GetColorModel(long paramLong);
/*     */   
/*     */   private final native void N_SetCopies(long paramLong, int paramInt);
/*     */   
/*     */   private final native int N_GetCopies(long paramLong);
/*     */   
/*     */   private final native void N_SetDuplexMode(long paramLong, DuplexMode paramDuplexMode);
/*     */   
/*     */   private final native DuplexMode N_GetDuplexMode(long paramLong);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\misc\CefPrintSettings_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */