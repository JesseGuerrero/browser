/*    */ package org.cef.network;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public final class CefCookie
/*    */ {
/*    */   public final String name;
/*    */   public final String value;
/*    */   public final String domain;
/*    */   public final String path;
/*    */   public final boolean secure;
/*    */   
/*    */   public CefCookie(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, Date paramDate1, Date paramDate2, boolean paramBoolean3, Date paramDate3) {
/* 15 */     this.name = paramString1;
/* 16 */     this.value = paramString2;
/* 17 */     this.domain = paramString3;
/* 18 */     this.path = paramString4;
/* 19 */     this.secure = paramBoolean1;
/* 20 */     this.httponly = paramBoolean2;
/* 21 */     this.creation = paramDate1;
/* 22 */     this.lastAccess = paramDate2;
/* 23 */     this.hasExpires = paramBoolean3;
/* 24 */     this.expires = paramDate3;
/*    */   }
/*    */   
/*    */   public final boolean httponly;
/*    */   public final Date creation;
/*    */   public final Date lastAccess;
/*    */   public final boolean hasExpires;
/*    */   public final Date expires;
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefCookie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */