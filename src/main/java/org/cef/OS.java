/*    */ package org.cef;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OS
/*    */ {
/*    */   private enum OSType
/*    */   {
/*  9 */     OSUndefined,
/* 10 */     OSLinux,
/* 11 */     OSWindows,
/* 12 */     OSMacintosh,
/* 13 */     OSUnknown
	/*    */   }
/*    */   
/* 16 */   private static OSType osType = OSType.OSUndefined;
/*    */   
/*    */   public static final boolean isWindows() {
/* 19 */     return (getOSType() == OSType.OSWindows);
/*    */   }
/*    */   
/*    */   public static final boolean isMacintosh() {
/* 23 */     return (getOSType() == OSType.OSMacintosh);
/*    */   }
/*    */   
/*    */   public static final boolean isLinux() {
/* 27 */     return (getOSType() == OSType.OSLinux);
/*    */   }
/*    */   
/*    */   private static final OSType getOSType() {
/* 31 */     if (osType == OSType.OSUndefined) {
/* 32 */       String str = System.getProperty("os.name").toLowerCase();
/* 33 */       if (str.startsWith("windows")) {
/* 34 */         osType = OSType.OSWindows;
/* 35 */       } else if (str.startsWith("linux")) {
/* 36 */         osType = OSType.OSLinux;
/* 37 */       } else if (str.startsWith("mac")) {
/* 38 */         osType = OSType.OSMacintosh;
/*    */       } else {
/* 40 */         osType = OSType.OSUnknown;
/*    */       } 
/* 42 */     }  return osType;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\OS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */