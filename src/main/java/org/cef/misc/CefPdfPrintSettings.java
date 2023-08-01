/*     */ package org.cef.misc;public class CefPdfPrintSettings { public boolean header_footer_enabled; public String header_footer_title; public String header_footer_url; public boolean landscape;
/*     */   public boolean backgrounds_enabled;
/*     */   public int page_width;
/*     */   public int page_height;
/*     */   public boolean selection_only;
/*     */   public int scale_factor;
/*     */   public int margin_top;
/*     */   public int margin_right;
/*     */   public int margin_bottom;
/*     */   public int margin_left;
/*     */   public MarginType margin_type;
/*     */   
/*  13 */   public enum MarginType { DEFAULT,
/*     */ 
/*     */     
/*  16 */     NONE,
/*     */ 
/*     */     
/*  19 */     MINIMUM,
/*     */ 
/*     */     
/*  22 */     CUSTOM
}
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
/*     */   public CefPdfPrintSettings clone() {
/*  94 */     CefPdfPrintSettings cefPdfPrintSettings = new CefPdfPrintSettings();
/*  95 */     cefPdfPrintSettings.header_footer_enabled = this.header_footer_enabled;
/*  96 */     cefPdfPrintSettings.header_footer_title = this.header_footer_title;
/*  97 */     cefPdfPrintSettings.header_footer_url = this.header_footer_url;
/*  98 */     cefPdfPrintSettings.landscape = this.landscape;
/*  99 */     cefPdfPrintSettings.backgrounds_enabled = this.backgrounds_enabled;
/* 100 */     cefPdfPrintSettings.page_width = this.page_width;
/* 101 */     cefPdfPrintSettings.page_height = this.page_height;
/* 102 */     cefPdfPrintSettings.selection_only = this.selection_only;
/* 103 */     cefPdfPrintSettings.scale_factor = this.scale_factor;
/* 104 */     cefPdfPrintSettings.margin_top = this.margin_top;
/* 105 */     cefPdfPrintSettings.margin_right = this.margin_right;
/* 106 */     cefPdfPrintSettings.margin_bottom = this.margin_bottom;
/* 107 */     cefPdfPrintSettings.margin_left = this.margin_left;
/* 108 */     cefPdfPrintSettings.margin_type = this.margin_type;
/* 109 */     return cefPdfPrintSettings;
/*     */   } }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\misc\CefPdfPrintSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */