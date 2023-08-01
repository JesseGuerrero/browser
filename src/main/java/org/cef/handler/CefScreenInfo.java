/*    */ package org.cef.handler;
/*    */ 
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CefScreenInfo
/*    */ {
/*    */   public double device_scale_factor;
/*    */   public int depth;
/*    */   public int depth_per_component;
/*    */   public boolean is_monochrome;
/*    */   public int x;
/*    */   public int y;
/*    */   public int width;
/*    */   public int height;
/*    */   public int available_x;
/*    */   public int available_y;
/*    */   public int available_width;
/*    */   public int available_height;
/*    */   
/*    */   public void Set(double paramDouble, int paramInt1, int paramInt2, boolean paramBoolean, Rectangle paramRectangle1, Rectangle paramRectangle2) {
/* 23 */     this.device_scale_factor = paramDouble;
/* 24 */     this.depth = paramInt1;
/* 25 */     this.depth_per_component = paramInt2;
/* 26 */     this.is_monochrome = paramBoolean;
/* 27 */     this.x = paramRectangle1.x;
/* 28 */     this.y = paramRectangle1.y;
/* 29 */     this.width = paramRectangle1.width;
/* 30 */     this.height = paramRectangle1.height;
/* 31 */     this.available_x = paramRectangle2.x;
/* 32 */     this.available_y = paramRectangle2.y;
/* 33 */     this.available_width = paramRectangle2.width;
/* 34 */     this.available_height = paramRectangle2.height;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefScreenInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */