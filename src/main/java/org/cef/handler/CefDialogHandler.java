/*    */ package org.cef.handler;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.callback.CefFileDialogCallback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface CefDialogHandler
/*    */ {
/*    */   boolean onFileDialog(CefBrowser paramCefBrowser, FileDialogMode paramFileDialogMode, String paramString1, String paramString2, Vector<String> paramVector, int paramInt, CefFileDialogCallback paramCefFileDialogCallback);
/*    */   
/*    */    enum FileDialogMode
/*    */   {
/* 21 */     FILE_DIALOG_OPEN,
/* 22 */     FILE_DIALOG_OPEN_MULTIPLE,
/* 23 */     FILE_DIALOG_SAVE
	/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefDialogHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */