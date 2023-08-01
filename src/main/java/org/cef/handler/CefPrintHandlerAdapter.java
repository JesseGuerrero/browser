/*    */ package org.cef.handler;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import org.cef.browser.CefBrowser;
/*    */ import org.cef.callback.CefNativeAdapter;
/*    */ import org.cef.callback.CefPrintDialogCallback;
/*    */ import org.cef.callback.CefPrintJobCallback;
/*    */ import org.cef.misc.CefPrintSettings;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CefPrintHandlerAdapter
/*    */   extends CefNativeAdapter
/*    */   implements CefPrintHandler
/*    */ {
/*    */   public void onPrintStart(CefBrowser paramCefBrowser) {}
/*    */   
/*    */   public void onPrintSettings(CefBrowser paramCefBrowser, CefPrintSettings paramCefPrintSettings, boolean paramBoolean) {}
/*    */   
/*    */   public boolean onPrintDialog(CefBrowser paramCefBrowser, boolean paramBoolean, CefPrintDialogCallback paramCefPrintDialogCallback) {
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onPrintJob(CefBrowser paramCefBrowser, String paramString1, String paramString2, CefPrintJobCallback paramCefPrintJobCallback) {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPrintReset(CefBrowser paramCefBrowser) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Dimension getPdfPaperSize(CefBrowser paramCefBrowser, int paramInt) {
/* 56 */     int i = (int)(paramInt / 300.0D * 2480.0D);
/* 57 */     int j = (int)(paramInt / 300.0D * 3508.0D);
/* 58 */     return new Dimension(i, j);
/*    */   }
/*    */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefPrintHandlerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */