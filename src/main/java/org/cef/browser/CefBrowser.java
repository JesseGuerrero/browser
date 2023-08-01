package org.cef.browser;

import java.awt.Component;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import org.cef.CefClient;
import org.cef.callback.CefPdfPrintCallback;
import org.cef.callback.CefRunFileDialogCallback;
import org.cef.callback.CefStringVisitor;
import org.cef.handler.CefDialogHandler;
import org.cef.handler.CefRenderHandler;
import org.cef.handler.CefWindowHandler;
import org.cef.misc.CefPdfPrintSettings;
import org.cef.network.CefRequest;

public interface CefBrowser {
  void createImmediately();
  
  Component getUIComponent();
  
  CefClient getClient();
  
  CefRenderHandler getRenderHandler();
  
  CefWindowHandler getWindowHandler();
  
  boolean canGoBack();
  
  void goBack();
  
  boolean canGoForward();
  
  void goForward();
  
  boolean isLoading();
  
  void reload();
  
  void reloadIgnoreCache();
  
  void stopLoad();
  
  int getIdentifier();
  
  CefFrame getMainFrame();
  
  CefFrame getFocusedFrame();
  
  CefFrame getFrame(long paramLong);
  
  CefFrame getFrame(String paramString);
  
  Vector<Long> getFrameIdentifiers();
  
  Vector<String> getFrameNames();
  
  int getFrameCount();
  
  boolean isPopup();
  
  boolean hasDocument();
  
  void viewSource();
  
  void getSource(CefStringVisitor paramCefStringVisitor);
  
  void getText(CefStringVisitor paramCefStringVisitor);

  void loadHTTPRequest(CefRequest paramCefRequest);
  
  void loadURL(String paramString);
  
  void executeJavaScript(String paramString1, String paramString2, int paramInt);
  
  String getURL();
  
  void close(boolean paramBoolean);
  
  void setCloseAllowed();
  
  boolean doClose();
  
  void onBeforeClose();
  
  void setFocus(boolean paramBoolean);
  
  void setWindowVisibility(boolean paramBoolean);
  
  double getZoomLevel();
  
  void setZoomLevel(double paramDouble);
  
  void runFileDialog(CefDialogHandler.FileDialogMode paramFileDialogMode, String paramString1, String paramString2, Vector<String> paramVector, int paramInt, CefRunFileDialogCallback paramCefRunFileDialogCallback);
  
  void startDownload(String paramString);
  
  void print();
  
  void printToPDF(String paramString, CefPdfPrintSettings paramCefPdfPrintSettings, CefPdfPrintCallback paramCefPdfPrintCallback);
  
  void find(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  void stopFinding(boolean paramBoolean);
  
  CefBrowser getDevTools();
  
  CefBrowser getDevTools(Point paramPoint);
  
  void replaceMisspelling(String paramString);
  
  CompletableFuture<BufferedImage> createScreenshot(boolean paramBoolean);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\browser\CefBrowser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */