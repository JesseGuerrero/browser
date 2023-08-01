/*    */ package org.cef.network;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefPostData
/*    */ {
/*    */   protected void finalize() throws Throwable {
/* 19 */     dispose();
/* 20 */     super.finalize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final CefPostData create() {
/* 27 */     return CefPostData_N.createNative();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void dispose();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean isReadOnly();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract int getElementCount();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void getElements(Vector<CefPostDataElement> paramVector);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean removeElement(CefPostDataElement paramCefPostDataElement);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean addElement(CefPostDataElement paramCefPostDataElement);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void removeElements();
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     return toString(null);
/*    */   }
/*    */   
/*    */   public String toString(String paramString) {
/* 72 */     Vector<CefPostDataElement> vector = new Vector();
/* 73 */     getElements(vector);
/*    */     
/* 75 */     String str = "";
/* 76 */     for (CefPostDataElement cefPostDataElement : vector) {
/* 77 */       str = str + cefPostDataElement.toString(paramString) + "\n";
/*    */     }
/* 79 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\network\CefPostData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */