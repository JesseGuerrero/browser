/*    */ package org.cef.misc;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Rectangle;
/*    */ import java.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefPrintSettings
/*    */ {
/*    */   public enum ColorModel
/*    */   {
/* 19 */     COLOR_MODEL_UNKNOWN,
/* 20 */     COLOR_MODEL_GRAY,
/* 21 */     COLOR_MODEL_COLOR,
/* 22 */     COLOR_MODEL_CMYK,
/* 23 */     COLOR_MODEL_CMY,
/* 24 */     COLOR_MODEL_KCMY,
/* 25 */     COLOR_MODEL_CMY_K,
/* 26 */     COLOR_MODEL_BLACK,
/* 27 */     COLOR_MODEL_GRAYSCALE,
/* 28 */     COLOR_MODEL_RGB,
/* 29 */     COLOR_MODEL_RGB16,
/* 30 */     COLOR_MODEL_RGBA,
/* 31 */     COLOR_MODEL_COLORMODE_COLOR,
/* 32 */     COLOR_MODEL_COLORMODE_MONOCHROME,
/* 33 */     COLOR_MODEL_HP_COLOR_COLOR,
/* 34 */     COLOR_MODEL_HP_COLOR_BLACK,
/* 35 */     COLOR_MODEL_PRINTOUTMODE_NORMAL,
/* 36 */     COLOR_MODEL_PRINTOUTMODE_NORMAL_GRAY,
/* 37 */     COLOR_MODEL_PROCESSCOLORMODEL_CMYK,
/* 38 */     COLOR_MODEL_PROCESSCOLORMODEL_GREYSCALE,
/* 39 */     COLOR_MODEL_PROCESSCOLORMODEL_RGB
	/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public enum DuplexMode
/*    */   {
/* 46 */     DUPLEX_MODE_UNKNOWN,
/* 47 */     DUPLEX_MODE_SIMPLEX,
/* 48 */     DUPLEX_MODE_LONG_EDGE,
/* 49 */     DUPLEX_MODE_SHORT_EDGE
	/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void finalize() throws Throwable {
/* 57 */     dispose();
/* 58 */     super.finalize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final CefPrintSettings create() {
/* 65 */     return CefPrintSettings_N.createNative();
/*    */   }
/*    */   
/*    */   public abstract void dispose();
/*    */   
/*    */   public abstract boolean isValid();
/*    */   
/*    */   public abstract boolean isReadOnly();
/*    */   
/*    */   public abstract void setOrientation(boolean paramBoolean);
/*    */   
/*    */   public abstract boolean isLandscape();
/*    */   
/*    */   public abstract void setPrinterPrintableArea(Dimension paramDimension, Rectangle paramRectangle, boolean paramBoolean);
/*    */   
/*    */   public abstract void setDeviceName(String paramString);
/*    */   
/*    */   public abstract String getDeviceName();
/*    */   
/*    */   public abstract void setDPI(int paramInt);
/*    */   
/*    */   public abstract int getDPI();
/*    */   
/*    */   public abstract void setPageRanges(Vector<CefPageRange> paramVector);
/*    */   
/*    */   public abstract int getPageRangesCount();
/*    */   
/*    */   public abstract void getPageRanges(Vector<CefPageRange> paramVector);
/*    */   
/*    */   public abstract void setSelectionOnly(boolean paramBoolean);
/*    */   
/*    */   public abstract boolean isSelectionOnly();
/*    */   
/*    */   public abstract void setCollate(boolean paramBoolean);
/*    */   
/*    */   public abstract boolean willCollate();
/*    */   
/*    */   public abstract void setColorModel(ColorModel paramColorModel);
/*    */   
/*    */   public abstract ColorModel getColorModel();
/*    */   
/*    */   public abstract void setCopies(int paramInt);
/*    */   
/*    */   public abstract int getCopies();
/*    */   
/*    */   public abstract void setDuplexMode(DuplexMode paramDuplexMode);
/*    */   
/*    */   public abstract DuplexMode getDuplexMode();
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\misc\CefPrintSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */