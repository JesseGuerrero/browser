/*     */ package org.cef.callback;
/*     */ 
/*     */ import org.cef.misc.BoolRef;
/*     */ import org.cef.misc.IntRef;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefMenuModel_N
/*     */   extends CefNativeAdapter
/*     */   implements CefMenuModel
/*     */ {
/*     */   public boolean clear() {
/*     */     try {
/*  16 */       return N_Clear(getNativeRef(null));
/*  17 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  18 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  20 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getCount() {
/*     */     try {
/*  26 */       return N_GetCount(getNativeRef(null));
/*  27 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  28 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  30 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean addSeparator() {
/*     */     try {
/*  36 */       return N_AddSeparator(getNativeRef(null));
/*  37 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  38 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  40 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean addItem(int paramInt, String paramString) {
/*     */     try {
/*  46 */       return N_AddItem(getNativeRef(null), paramInt, paramString);
/*  47 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  48 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  50 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean addCheckItem(int paramInt, String paramString) {
/*     */     try {
/*  56 */       return N_AddCheckItem(getNativeRef(null), paramInt, paramString);
/*  57 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  58 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  60 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean addRadioItem(int paramInt1, String paramString, int paramInt2) {
/*     */     try {
/*  66 */       return N_AddRadioItem(getNativeRef(null), paramInt1, paramString, paramInt2);
/*  67 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  68 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  70 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CefMenuModel addSubMenu(int paramInt, String paramString) {
/*     */     try {
/*  76 */       return N_AddSubMenu(getNativeRef(null), paramInt, paramString);
/*  77 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  78 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  80 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean insertSeparatorAt(int paramInt) {
/*     */     try {
/*  86 */       return N_InsertSeparatorAt(getNativeRef(null), paramInt);
/*  87 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  88 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/*  90 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean insertItemAt(int paramInt1, int paramInt2, String paramString) {
/*     */     try {
/*  96 */       return N_InsertItemAt(getNativeRef(null), paramInt1, paramInt2, paramString);
/*  97 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*  98 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 100 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean insertCheckItemAt(int paramInt1, int paramInt2, String paramString) {
/*     */     try {
/* 106 */       return N_InsertCheckItemAt(getNativeRef(null), paramInt1, paramInt2, paramString);
/* 107 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 108 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 110 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean insertRadioItemAt(int paramInt1, int paramInt2, String paramString, int paramInt3) {
/*     */     try {
/* 116 */       return N_InsertRadioItemAt(getNativeRef(null), paramInt1, paramInt2, paramString, paramInt3);
/* 117 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 118 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 120 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CefMenuModel insertSubMenuAt(int paramInt1, int paramInt2, String paramString) {
/*     */     try {
/* 126 */       return N_InsertSubMenuAt(getNativeRef(null), paramInt1, paramInt2, paramString);
/* 127 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 128 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 130 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean remove(int paramInt) {
/*     */     try {
/* 136 */       return N_Remove(getNativeRef(null), paramInt);
/* 137 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 138 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 140 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean removeAt(int paramInt) {
/*     */     try {
/* 146 */       return N_RemoveAt(getNativeRef(null), paramInt);
/* 147 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 148 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 150 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getIndexOf(int paramInt) {
/*     */     try {
/* 156 */       return N_GetIndexOf(getNativeRef(null), paramInt);
/* 157 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 158 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 160 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getCommandIdAt(int paramInt) {
/*     */     try {
/* 166 */       return N_GetCommandIdAt(getNativeRef(null), paramInt);
/* 167 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 168 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 170 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setCommandIdAt(int paramInt1, int paramInt2) {
/*     */     try {
/* 176 */       return N_SetCommandIdAt(getNativeRef(null), paramInt1, paramInt2);
/* 177 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 178 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 180 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLabel(int paramInt) {
/*     */     try {
/* 186 */       return N_GetLabel(getNativeRef(null), paramInt);
/* 187 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 188 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 190 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLabelAt(int paramInt) {
/*     */     try {
/* 196 */       return N_GetLabelAt(getNativeRef(null), paramInt);
/* 197 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 198 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 200 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setLabel(int paramInt, String paramString) {
/*     */     try {
/* 206 */       return N_SetLabel(getNativeRef(null), paramInt, paramString);
/* 207 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 208 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 210 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setLabelAt(int paramInt, String paramString) {
/*     */     try {
/* 216 */       return N_SetLabelAt(getNativeRef(null), paramInt, paramString);
/* 217 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 218 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 220 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public MenuItemType getType(int paramInt) {
/*     */     try {
/* 226 */       return N_GetType(getNativeRef(null), paramInt);
/* 227 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 228 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 230 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public MenuItemType getTypeAt(int paramInt) {
/*     */     try {
/* 236 */       return N_GetTypeAt(getNativeRef(null), paramInt);
/* 237 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 238 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 240 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getGroupId(int paramInt) {
/*     */     try {
/* 246 */       return N_GetGroupId(getNativeRef(null), paramInt);
/* 247 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 248 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 250 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getGroupIdAt(int paramInt) {
/*     */     try {
/* 256 */       return N_GetGroupIdAt(getNativeRef(null), paramInt);
/* 257 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 258 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 260 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setGroupId(int paramInt1, int paramInt2) {
/*     */     try {
/* 266 */       return N_SetGroupId(getNativeRef(null), paramInt1, paramInt2);
/* 267 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 268 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 270 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setGroupIdAt(int paramInt1, int paramInt2) {
/*     */     try {
/* 276 */       return N_SetGroupIdAt(getNativeRef(null), paramInt1, paramInt2);
/* 277 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 278 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 280 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CefMenuModel getSubMenu(int paramInt) {
/*     */     try {
/* 286 */       return N_GetSubMenu(getNativeRef(null), paramInt);
/* 287 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 288 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 290 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CefMenuModel getSubMenuAt(int paramInt) {
/*     */     try {
/* 296 */       return N_GetSubMenuAt(getNativeRef(null), paramInt);
/* 297 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 298 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 300 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isVisible(int paramInt) {
/*     */     try {
/* 306 */       return N_IsVisible(getNativeRef(null), paramInt);
/* 307 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 308 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 310 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isVisibleAt(int paramInt) {
/*     */     try {
/* 316 */       return N_IsVisibleAt(getNativeRef(null), paramInt);
/* 317 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 318 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 320 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setVisible(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 326 */       return N_SetVisible(getNativeRef(null), paramInt, paramBoolean);
/* 327 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 328 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 330 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setVisibleAt(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 336 */       return N_SetVisibleAt(getNativeRef(null), paramInt, paramBoolean);
/* 337 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 338 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 340 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isEnabled(int paramInt) {
/*     */     try {
/* 346 */       return N_IsEnabled(getNativeRef(null), paramInt);
/* 347 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 348 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 350 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isEnabledAt(int paramInt) {
/*     */     try {
/* 356 */       return N_IsEnabledAt(getNativeRef(null), paramInt);
/* 357 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 358 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 360 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setEnabled(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 366 */       return N_SetEnabled(getNativeRef(null), paramInt, paramBoolean);
/* 367 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 368 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 370 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setEnabledAt(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 376 */       return N_SetEnabledAt(getNativeRef(null), paramInt, paramBoolean);
/* 377 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 378 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 380 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isChecked(int paramInt) {
/*     */     try {
/* 386 */       return N_IsChecked(getNativeRef(null), paramInt);
/* 387 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 388 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 390 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCheckedAt(int paramInt) {
/*     */     try {
/* 396 */       return N_IsCheckedAt(getNativeRef(null), paramInt);
/* 397 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 398 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 400 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setChecked(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 406 */       return N_SetChecked(getNativeRef(null), paramInt, paramBoolean);
/* 407 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 408 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 410 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean setCheckedAt(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 416 */       return N_SetCheckedAt(getNativeRef(null), paramInt, paramBoolean);
/* 417 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 418 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 420 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasAccelerator(int paramInt) {
/*     */     try {
/* 426 */       return N_HasAccelerator(getNativeRef(null), paramInt);
/* 427 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 428 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 430 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasAcceleratorAt(int paramInt) {
/*     */     try {
/* 436 */       return N_HasAcceleratorAt(getNativeRef(null), paramInt);
/* 437 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 438 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 440 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setAccelerator(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*     */     try {
/* 447 */       return N_SetAccelerator(getNativeRef(null), paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
/*     */     }
/* 449 */     catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 450 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 452 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setAcceleratorAt(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*     */     try {
/* 459 */       return N_SetAcceleratorAt(
/* 460 */           getNativeRef(null), paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
/* 461 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 462 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 464 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean removeAccelerator(int paramInt) {
/*     */     try {
/* 470 */       return N_RemoveAccelerator(getNativeRef(null), paramInt);
/* 471 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 472 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 474 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean removeAcceleratorAt(int paramInt) {
/*     */     try {
/* 480 */       return N_RemoveAcceleratorAt(getNativeRef(null), paramInt);
/* 481 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 482 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 484 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAccelerator(int paramInt, IntRef paramIntRef, BoolRef paramBoolRef1, BoolRef paramBoolRef2, BoolRef paramBoolRef3) {
/*     */     try {
/* 491 */       return N_GetAccelerator(getNativeRef(null), paramInt, paramIntRef, paramBoolRef1, paramBoolRef2, paramBoolRef3);
/*     */     }
/* 493 */     catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 494 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 496 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAcceleratorAt(int paramInt, IntRef paramIntRef, BoolRef paramBoolRef1, BoolRef paramBoolRef2, BoolRef paramBoolRef3) {
/*     */     try {
/* 503 */       return N_GetAcceleratorAt(
/* 504 */           getNativeRef(null), paramInt, paramIntRef, paramBoolRef1, paramBoolRef2, paramBoolRef3);
/* 505 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 506 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 508 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final native boolean N_Clear(long paramLong);
/*     */   
/*     */   private final native int N_GetCount(long paramLong);
/*     */   
/*     */   private final native boolean N_AddSeparator(long paramLong);
/*     */   
/*     */   private final native boolean N_AddItem(long paramLong, int paramInt, String paramString);
/*     */   
/*     */   private final native boolean N_AddCheckItem(long paramLong, int paramInt, String paramString);
/*     */   
/*     */   private final native boolean N_AddRadioItem(long paramLong, int paramInt1, String paramString, int paramInt2);
/*     */   
/*     */   private final native CefMenuModel N_AddSubMenu(long paramLong, int paramInt, String paramString);
/*     */   
/*     */   private final native boolean N_InsertSeparatorAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_InsertItemAt(long paramLong, int paramInt1, int paramInt2, String paramString);
/*     */   
/*     */   private final native boolean N_InsertCheckItemAt(long paramLong, int paramInt1, int paramInt2, String paramString);
/*     */   
/*     */   private final native boolean N_InsertRadioItemAt(long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3);
/*     */   
/*     */   private final native CefMenuModel N_InsertSubMenuAt(long paramLong, int paramInt1, int paramInt2, String paramString);
/*     */   
/*     */   private final native boolean N_Remove(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_RemoveAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native int N_GetIndexOf(long paramLong, int paramInt);
/*     */   
/*     */   private final native int N_GetCommandIdAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetCommandIdAt(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   private final native String N_GetLabel(long paramLong, int paramInt);
/*     */   
/*     */   private final native String N_GetLabelAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetLabel(long paramLong, int paramInt, String paramString);
/*     */   
/*     */   private final native boolean N_SetLabelAt(long paramLong, int paramInt, String paramString);
/*     */   
/*     */   private final native MenuItemType N_GetType(long paramLong, int paramInt);
/*     */   
/*     */   private final native MenuItemType N_GetTypeAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native int N_GetGroupId(long paramLong, int paramInt);
/*     */   
/*     */   private final native int N_GetGroupIdAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetGroupId(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   private final native boolean N_SetGroupIdAt(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   private final native CefMenuModel N_GetSubMenu(long paramLong, int paramInt);
/*     */   
/*     */   private final native CefMenuModel N_GetSubMenuAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_IsVisible(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_IsVisibleAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetVisible(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_SetVisibleAt(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_IsEnabled(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_IsEnabledAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetEnabled(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_SetEnabledAt(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_IsChecked(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_IsCheckedAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetChecked(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_SetCheckedAt(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native boolean N_HasAccelerator(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_HasAcceleratorAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_SetAccelerator(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*     */   
/*     */   private final native boolean N_SetAcceleratorAt(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*     */   
/*     */   private final native boolean N_RemoveAccelerator(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_RemoveAcceleratorAt(long paramLong, int paramInt);
/*     */   
/*     */   private final native boolean N_GetAccelerator(long paramLong, int paramInt, IntRef paramIntRef, BoolRef paramBoolRef1, BoolRef paramBoolRef2, BoolRef paramBoolRef3);
/*     */   
/*     */   private final native boolean N_GetAcceleratorAt(long paramLong, int paramInt, IntRef paramIntRef, BoolRef paramBoolRef1, BoolRef paramBoolRef2, BoolRef paramBoolRef3);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefMenuModel_N.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */