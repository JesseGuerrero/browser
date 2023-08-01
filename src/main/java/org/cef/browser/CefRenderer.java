/*     */ package org.cef.browser;
/*     */ 
/*     */ import com.jogamp.opengl.GL2;
/*     */ import java.awt.Rectangle;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefRenderer
/*     */ {
/*     */   private final boolean transparent_;
/*  15 */   private GL2 initialized_context_ = null;
/*  16 */   private final int[] texture_id_ = new int[1];
/*  17 */   private int view_width_ = 0;
/*  18 */   private int view_height_ = 0;
/*  19 */   private float spin_x_ = 0.0F;
/*  20 */   private float spin_y_ = 0.0F;
/*  21 */   private Rectangle popup_rect_ = new Rectangle(0, 0, 0, 0);
/*  22 */   private Rectangle original_popup_rect_ = new Rectangle(0, 0, 0, 0);
/*     */   private boolean use_draw_pixels_ = false;
/*     */   
/*     */   protected CefRenderer(boolean paramBoolean) {
/*  26 */     this.transparent_ = paramBoolean;
/*     */   }
/*     */   
/*     */   protected boolean isTransparent() {
/*  30 */     return this.transparent_;
/*     */   }
/*     */   
/*     */   protected int getTextureID() {
/*  34 */     return this.texture_id_[0];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void initialize(GL2 paramGL2) {
/*  39 */     if (this.initialized_context_ == paramGL2)
/*     */       return; 
/*  41 */     this.initialized_context_ = paramGL2;
/*     */     
/*  43 */     if (!paramGL2.getContext().isHardwareRasterizer()) {
/*     */       
/*  45 */       System.out.println("opengl rendering may be slow as hardware rendering isn't available");
/*     */       
/*  47 */       this.use_draw_pixels_ = true;
/*     */       
/*     */       return;
/*     */     } 
/*  51 */     paramGL2.glHint(3155, 4354);
/*     */     
/*  53 */     paramGL2.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */     
/*  56 */     paramGL2.glPixelStorei(3317, 1);
/*     */ 
/*     */     
/*  59 */     paramGL2.glGenTextures(1, this.texture_id_, 0);
/*  60 */     assert this.texture_id_[0] != 0;
/*     */     
/*  62 */     paramGL2.glBindTexture(3553, this.texture_id_[0]);
/*  63 */     paramGL2.glTexParameteri(3553, 10241, 9728);
/*  64 */     paramGL2.glTexParameteri(3553, 10240, 9728);
/*  65 */     paramGL2.glTexEnvf(8960, 8704, 8448.0F);
/*     */   }
/*     */   
/*     */   protected void cleanup(GL2 paramGL2) {
/*  69 */     if (this.texture_id_[0] != 0) paramGL2.glDeleteTextures(1, this.texture_id_, 0); 
/*  70 */     this.view_width_ = this.view_height_ = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(GL2 paramGL2) {
/*  75 */     if (this.use_draw_pixels_ || this.view_width_ == 0 || this.view_height_ == 0)
/*     */       return; 
/*  77 */     assert this.initialized_context_ != null;
/*     */     
/*  79 */     float[] arrayOfFloat = { 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F };
/*     */ 
/*     */     
/*  82 */     FloatBuffer floatBuffer = FloatBuffer.wrap(arrayOfFloat);
/*     */     
/*  84 */     paramGL2.glClear(0x4000 | 0x100);
/*     */     
/*  86 */     paramGL2.glMatrixMode(5888);
/*  87 */     paramGL2.glLoadIdentity();
/*     */ 
/*     */     
/*  90 */     paramGL2.glViewport(0, 0, this.view_width_, this.view_height_);
/*  91 */     paramGL2.glMatrixMode(5889);
/*  92 */     paramGL2.glLoadIdentity();
/*     */ 
/*     */     
/*  95 */     paramGL2.glPushAttrib(1048575);
/*  96 */     paramGL2.glBegin(7);
/*  97 */     paramGL2.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
/*  98 */     paramGL2.glVertex2f(-1.0F, -1.0F);
/*  99 */     paramGL2.glVertex2f(1.0F, -1.0F);
/* 100 */     paramGL2.glColor4f(0.0F, 0.0F, 1.0F, 1.0F);
/* 101 */     paramGL2.glVertex2f(1.0F, 1.0F);
/* 102 */     paramGL2.glVertex2f(-1.0F, 1.0F);
/* 103 */     paramGL2.glEnd();
/* 104 */     paramGL2.glPopAttrib();
/*     */ 
/*     */     
/* 107 */     if (this.spin_x_ != 0.0F) paramGL2.glRotatef(-this.spin_x_, 1.0F, 0.0F, 0.0F); 
/* 108 */     if (this.spin_y_ != 0.0F) paramGL2.glRotatef(-this.spin_y_, 0.0F, 1.0F, 0.0F);
/*     */     
/* 110 */     if (this.transparent_) {
/*     */       
/* 112 */       paramGL2.glBlendFunc(1, 771);
/*     */ 
/*     */       
/* 115 */       paramGL2.glEnable(3042);
/*     */     } 
/*     */ 
/*     */     
/* 119 */     paramGL2.glEnable(3553);
/*     */ 
/*     */     
/* 122 */     assert this.texture_id_[0] != 0;
/* 123 */     paramGL2.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 124 */     paramGL2.glBindTexture(3553, this.texture_id_[0]);
/* 125 */     paramGL2.glInterleavedArrays(10791, 0, floatBuffer);
/* 126 */     paramGL2.glDrawArrays(7, 0, 4);
/*     */ 
/*     */     
/* 129 */     paramGL2.glDisable(3553);
/*     */     
/* 131 */     if (this.transparent_)
/*     */     {
/* 133 */       paramGL2.glDisable(3042);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onPopupSize(Rectangle paramRectangle) {
/* 138 */     if (paramRectangle.width <= 0 || paramRectangle.height <= 0)
/* 139 */       return;  this.original_popup_rect_ = paramRectangle;
/* 140 */     this.popup_rect_ = getPopupRectInWebView(this.original_popup_rect_);
/*     */   }
/*     */   
/*     */   protected Rectangle getPopupRect() {
/* 144 */     return (Rectangle)this.popup_rect_.clone();
/*     */   }
/*     */   
/*     */   protected Rectangle getPopupRectInWebView(Rectangle paramRectangle) {
/* 148 */     Rectangle rectangle = paramRectangle;
/*     */     
/* 150 */     if (rectangle.x < 0) rectangle.x = 0; 
/* 151 */     if (rectangle.y < 0) rectangle.y = 0;
/*     */     
/* 153 */     if (rectangle.x + rectangle.width > this.view_width_) rectangle.x = this.view_width_ - rectangle.width; 
/* 154 */     if (rectangle.y + rectangle.height > this.view_height_) rectangle.y = this.view_height_ - rectangle.height;
/*     */     
/* 156 */     if (rectangle.x < 0) rectangle.x = 0; 
/* 157 */     if (rectangle.y < 0) rectangle.y = 0; 
/* 158 */     return rectangle;
/*     */   }
/*     */   
/*     */   protected void clearPopupRects() {
/* 162 */     this.popup_rect_.setBounds(0, 0, 0, 0);
/* 163 */     this.original_popup_rect_.setBounds(0, 0, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onPaint(GL2 paramGL2, boolean paramBoolean, Rectangle[] paramArrayOfRectangle, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 169 */     initialize(paramGL2);
/*     */     
/* 171 */     if (this.use_draw_pixels_) {
/* 172 */       paramGL2.glRasterPos2f(-1.0F, 1.0F);
/* 173 */       paramGL2.glPixelZoom(1.0F, -1.0F);
/* 174 */       paramGL2.glDrawPixels(paramInt1, paramInt2, 32993, 5121, paramByteBuffer);
/*     */       
/*     */       return;
/*     */     } 
/* 178 */     if (this.transparent_)
/*     */     {
/* 180 */       paramGL2.glEnable(3042);
/*     */     }
/*     */ 
/*     */     
/* 184 */     paramGL2.glEnable(3553);
/*     */     
/* 186 */     assert this.texture_id_[0] != 0;
/* 187 */     paramGL2.glBindTexture(3553, this.texture_id_[0]);
/*     */     
/* 189 */     if (!paramBoolean) {
/* 190 */       int i = this.view_width_;
/* 191 */       int j = this.view_height_;
/*     */       
/* 193 */       this.view_width_ = paramInt1;
/* 194 */       this.view_height_ = paramInt2;
/*     */       
/* 196 */       paramGL2.glPixelStorei(3314, this.view_width_);
/*     */       
/* 198 */       if (i != this.view_width_ || j != this.view_height_) {
/*     */         
/* 200 */         paramGL2.glPixelStorei(3316, 0);
/* 201 */         paramGL2.glPixelStorei(3315, 0);
/* 202 */         paramGL2.glTexImage2D(3553, 0, 6408, this.view_width_, this.view_height_, 0, 32993, 33639, paramByteBuffer);
/*     */       }
/*     */       else {
/*     */         
/* 206 */         for (byte b = 0; b < paramArrayOfRectangle.length; b++) {
/* 207 */           Rectangle rectangle = paramArrayOfRectangle[b];
/* 208 */           paramGL2.glPixelStorei(3316, rectangle.x);
/* 209 */           paramGL2.glPixelStorei(3315, rectangle.y);
/* 210 */           paramGL2.glTexSubImage2D(3553, 0, rectangle.x, rectangle.y, rectangle.width, rectangle.height, 32993, 33639, paramByteBuffer);
/*     */         }
/*     */       
/*     */       } 
/* 214 */     } else if (paramBoolean && this.popup_rect_.width > 0 && this.popup_rect_.height > 0) {
/* 215 */       int i = 0, j = this.popup_rect_.x;
/* 216 */       int k = 0, m = this.popup_rect_.y;
/* 217 */       int n = paramInt1;
/* 218 */       int i1 = paramInt2;
/*     */ 
/*     */       
/* 221 */       if (j < 0) {
/* 222 */         i = -j;
/* 223 */         j = 0;
/*     */       } 
/* 225 */       if (m < 0) {
/* 226 */         k = -m;
/* 227 */         m = 0;
/*     */       } 
/* 229 */       if (j + n > this.view_width_) n -= j + n - this.view_width_; 
/* 230 */       if (m + i1 > this.view_height_) i1 -= m + i1 - this.view_height_;
/*     */ 
/*     */       
/* 233 */       paramGL2.glPixelStorei(3314, paramInt1);
/* 234 */       paramGL2.glPixelStorei(3316, i);
/* 235 */       paramGL2.glPixelStorei(3315, k);
/* 236 */       paramGL2.glTexSubImage2D(3553, 0, j, m, n, i1, 32993, 33639, paramByteBuffer);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 241 */     paramGL2.glDisable(3553);
/*     */     
/* 243 */     if (this.transparent_)
/*     */     {
/* 245 */       paramGL2.glDisable(3042);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void setSpin(float paramFloat1, float paramFloat2) {
/* 250 */     this.spin_x_ = paramFloat1;
/* 251 */     this.spin_y_ = paramFloat2;
/*     */   }
/*     */   
/*     */   protected void incrementSpin(float paramFloat1, float paramFloat2) {
/* 255 */     this.spin_x_ -= paramFloat1;
/* 256 */     this.spin_y_ -= paramFloat2;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */