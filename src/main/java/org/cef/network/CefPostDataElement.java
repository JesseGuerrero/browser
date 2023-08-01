/*     */ package org.cef.network;
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
/*     */ public abstract class CefPostDataElement
/*     */ {
/*     */   public enum Type
/*     */   {
/*  16 */     PDE_TYPE_EMPTY,
/*  17 */     PDE_TYPE_BYTES,
/*  18 */     PDE_TYPE_FILE
	/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*  26 */     dispose();
/*  27 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefPostDataElement create() {
/*  34 */     return CefPostDataElement_N.createNative();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void dispose();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isReadOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setToEmpty();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setToFile(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setToBytes(int paramInt, byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Type getType();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getFile();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getBytesCount();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getBytes(int paramInt, byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  86 */     return toString(null);
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/*  90 */     int i = getBytesCount();
/*  91 */     byte[] arrayOfByte = null;
/*  92 */     if (i > 0) {
/*  93 */       arrayOfByte = new byte[i];
/*     */     }
/*     */     
/*  96 */     boolean bool = false;
/*  97 */     if (paramString != null) {
/*  98 */       if (paramString.startsWith("text/")) {
/*  99 */         bool = true;
/* 100 */       } else if (paramString.startsWith("application/xml")) {
/* 101 */         bool = true;
/* 102 */       } else if (paramString.startsWith("application/xhtml")) {
/* 103 */         bool = true;
/* 104 */       } else if (paramString.startsWith("application/x-www-form-urlencoded")) {
/* 105 */         bool = true;
/*     */       } 
/*     */     }
/* 108 */     String str = "";
/*     */     
/* 110 */     if (getType() == Type.PDE_TYPE_BYTES) {
/* 111 */       int j = getBytes(arrayOfByte.length, arrayOfByte);
/* 112 */       str = str + "    Content-Length: " + i + "\n";
/* 113 */       if (bool) {
/* 114 */         str = str + "\n    " + new String(arrayOfByte);
/*     */       } else {
/* 116 */         for (byte b = 0; b < j; b++) {
/* 117 */           if (b % 40 == 0) str = str + "\n    "; 
/* 118 */           str = str + String.format("%02X", Byte.valueOf(arrayOfByte[b])) + " ";
/*     */         } 
/*     */       } 
/* 121 */       str = str + "\n";
/* 122 */     } else if (getType() == Type.PDE_TYPE_FILE) {
/* 123 */       str = str + "\n    Bytes of file: " + getFile() + "\n";
/*     */     } 
/* 125 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefPostDataElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */