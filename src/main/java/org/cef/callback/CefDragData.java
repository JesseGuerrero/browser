/*     */ package org.cef.callback;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.Vector;
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
/*     */ public abstract class CefDragData
/*     */ {
/*     */   public static final class DragOperations
/*     */   {
/*     */     public static final int DRAG_OPERATION_NONE = 0;
/*     */     public static final int DRAG_OPERATION_COPY = 1;
/*     */     public static final int DRAG_OPERATION_LINK = 2;
/*     */     public static final int DRAG_OPERATION_GENERIC = 4;
/*     */     public static final int DRAG_OPERATION_PRIVATE = 8;
/*     */     public static final int DRAG_OPERATION_MOVE = 16;
/*     */     public static final int DRAG_OPERATION_DELETE = 32;
/*     */     public static final int DRAG_OPERATION_EVERY = 2147483647;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable {
/*  34 */     dispose();
/*  35 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefDragData create() {
/*  42 */     return CefDragData_N.createNative();
/*     */   }
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
/*     */   public String toString() {
/* 182 */     return "CefDragData [isReadOnly()=" + isReadOnly() + ", isLink()=" + isLink() + ", isFragment()=" + 
/* 183 */       isFragment() + ", isFile()=" + isFile() + ", getLinkURL()=" + 
/* 184 */       getLinkURL() + ", getLinkTitle()=" + getLinkTitle() + ", getLinkMetadata()=" + 
/* 185 */       getLinkMetadata() + ", getFragmentText()=" + getFragmentText() + ", getFragmentHtml()=" + 
/* 186 */       getFragmentHtml() + ", getFragmentBaseURL()=" + 
/* 187 */       getFragmentBaseURL() + ", getFileName()=" + getFileName() + "]";
/*     */   }
/*     */   
/*     */   public abstract CefDragData clone();
/*     */   
/*     */   public abstract void dispose();
/*     */   
/*     */   public abstract boolean isReadOnly();
/*     */   
/*     */   public abstract boolean isLink();
/*     */   
/*     */   public abstract boolean isFragment();
/*     */   
/*     */   public abstract boolean isFile();
/*     */   
/*     */   public abstract String getLinkURL();
/*     */   
/*     */   public abstract String getLinkTitle();
/*     */   
/*     */   public abstract String getLinkMetadata();
/*     */   
/*     */   public abstract String getFragmentText();
/*     */   
/*     */   public abstract String getFragmentHtml();
/*     */   
/*     */   public abstract String getFragmentBaseURL();
/*     */   
/*     */   public abstract int getFileContents(OutputStream paramOutputStream);
/*     */   
/*     */   public abstract String getFileName();
/*     */   
/*     */   public abstract boolean getFileNames(Vector<String> paramVector);
/*     */   
/*     */   public abstract void setLinkURL(String paramString);
/*     */   
/*     */   public abstract void setLinkTitle(String paramString);
/*     */   
/*     */   public abstract void setLinkMetadata(String paramString);
/*     */   
/*     */   public abstract void setFragmentText(String paramString);
/*     */   
/*     */   public abstract void setFragmentHtml(String paramString);
/*     */   
/*     */   public abstract void setFragmentBaseURL(String paramString);
/*     */   
/*     */   public abstract void resetFileContents();
/*     */   
/*     */   public abstract void addFile(String paramString1, String paramString2);
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefDragData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */