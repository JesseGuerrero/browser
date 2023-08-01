/*     */ package org.cef.browser;
/*     */ 
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import org.cef.callback.CefDragData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CefDropTargetListener
/*     */   implements DropTargetListener
/*     */ {
/*     */   private final CefBrowser_N browser_;
/*  23 */   private CefDragData dragData_ = null;
/*  24 */   private int dragOperations_ = 1;
/*  25 */   private int dragModifiers_ = 0;
/*  26 */   private int acceptOperations_ = 1;
/*     */   
/*     */   CefDropTargetListener(CefBrowser_N paramCefBrowser_N) {
/*  29 */     this.browser_ = paramCefBrowser_N;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragEnter(DropTargetDragEvent paramDropTargetDragEvent) {
/*  34 */     CreateDragData(paramDropTargetDragEvent);
/*  35 */     this.browser_.dragTargetDragEnter(this.dragData_, paramDropTargetDragEvent
/*  36 */         .getLocation(), this.dragModifiers_, this.dragOperations_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragExit(DropTargetEvent paramDropTargetEvent) {
/*  41 */     AssertDragData();
/*  42 */     this.browser_.dragTargetDragLeave();
/*  43 */     ClearDragData();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragOver(DropTargetDragEvent paramDropTargetDragEvent) {
/*  48 */     AssertDragData();
/*  49 */     this.browser_.dragTargetDragOver(paramDropTargetDragEvent.getLocation(), this.dragModifiers_, this.dragOperations_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dropActionChanged(DropTargetDragEvent paramDropTargetDragEvent) {
/*  54 */     AssertDragData();
/*  55 */     this.acceptOperations_ = paramDropTargetDragEvent.getDropAction();
/*  56 */     switch (this.acceptOperations_) {
/*     */       case 1073741824:
/*  58 */         this.dragOperations_ = 2;
/*  59 */         this.dragModifiers_ = 6;
/*     */         break;
/*     */       
/*     */       case 1:
/*  63 */         this.dragOperations_ = 1;
/*  64 */         this.dragModifiers_ = 4;
/*     */         break;
/*     */       case 2:
/*  67 */         this.dragOperations_ = 16;
/*  68 */         this.dragModifiers_ = 2;
/*     */         break;
/*     */       
/*     */       case 0:
/*  72 */         this.dragOperations_ = 1;
/*  73 */         this.dragModifiers_ = 0;
/*  74 */         this.acceptOperations_ = 1;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drop(DropTargetDropEvent paramDropTargetDropEvent) {
/*  81 */     AssertDragData();
/*  82 */     this.browser_.dragTargetDrop(paramDropTargetDropEvent.getLocation(), this.dragModifiers_);
/*  83 */     paramDropTargetDropEvent.acceptDrop(this.acceptOperations_);
/*  84 */     paramDropTargetDropEvent.dropComplete(true);
/*  85 */     ClearDragData();
/*     */   }
/*     */   
/*     */   private void CreateDragData(DropTargetDragEvent paramDropTargetDragEvent) {
/*  89 */     assert this.dragData_ == null;
/*  90 */     this.dragData_ = createDragData(paramDropTargetDragEvent);
/*  91 */     dropActionChanged(paramDropTargetDragEvent);
/*     */   }
/*     */   
/*     */   private void AssertDragData() {
/*  95 */     assert this.dragData_ != null;
/*     */   }
/*     */   
/*     */   private void ClearDragData() {
/*  99 */     this.dragData_ = null;
/*     */   }
/*     */   
/*     */   private static CefDragData createDragData(DropTargetDragEvent paramDropTargetDragEvent) {
/* 103 */     CefDragData cefDragData = CefDragData.create();
/*     */     
/* 105 */     Transferable transferable = paramDropTargetDragEvent.getTransferable();
/* 106 */     DataFlavor[] arrayOfDataFlavor = transferable.getTransferDataFlavors();
/* 107 */     for (DataFlavor dataFlavor : arrayOfDataFlavor) {
/*     */       try {
/* 109 */         if (dataFlavor.isFlavorTextType()) {
/* 110 */           Object object = transferable.getTransferData(dataFlavor);
/* 111 */           if (object instanceof String)
/* 112 */             cefDragData.setFragmentText((String)object); 
/* 113 */         } else if (dataFlavor.isFlavorJavaFileListType()) {
/* 114 */           List<File> list = (List<File>)transferable.getTransferData(dataFlavor);
/* 115 */           for (File file : list) {
/* 116 */             cefDragData.addFile(file.getPath(), file.getName());
/*     */           }
/*     */         } 
/* 119 */       } catch (Exception exception) {
/*     */         
/* 121 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     return cefDragData;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefDropTargetListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */