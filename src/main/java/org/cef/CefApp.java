/*     */ package org.cef;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.FilenameFilter;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.HashSet;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.Timer;
/*     */ import org.cef.callback.CefSchemeHandlerFactory;
/*     */ import org.cef.handler.CefAppHandler;
/*     */ import org.cef.handler.CefAppHandlerAdapter;
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
/*     */ public class CefApp
/*     */   extends CefAppHandlerAdapter
/*     */ {
/*     */   public final class CefVersion
/*     */   {
/*     */     public final int JCEF_COMMIT_NUMBER;
/*     */     public final int CEF_VERSION_MAJOR;
/*     */     public final int CEF_VERSION_MINOR;
/*     */     public final int CEF_VERSION_PATCH;
/*     */     public final int CEF_COMMIT_NUMBER;
/*     */     public final int CHROME_VERSION_MAJOR;
/*     */     public final int CHROME_VERSION_MINOR;
/*     */     public final int CHROME_VERSION_BUILD;
/*     */     public final int CHROME_VERSION_PATCH;
/*     */     
/*     */     private CefVersion(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, int param1Int9) {
/*  41 */       this.JCEF_COMMIT_NUMBER = param1Int1;
/*     */       
/*  43 */       this.CEF_VERSION_MAJOR = param1Int2;
/*  44 */       this.CEF_VERSION_MINOR = param1Int3;
/*  45 */       this.CEF_VERSION_PATCH = param1Int4;
/*  46 */       this.CEF_COMMIT_NUMBER = param1Int5;
/*     */       
/*  48 */       this.CHROME_VERSION_MAJOR = param1Int6;
/*  49 */       this.CHROME_VERSION_MINOR = param1Int7;
/*  50 */       this.CHROME_VERSION_BUILD = param1Int8;
/*  51 */       this.CHROME_VERSION_PATCH = param1Int9;
/*     */     }
/*     */     
/*     */     public String getJcefVersion() {
/*  55 */       return this.CEF_VERSION_MAJOR + "." + this.CEF_VERSION_MINOR + "." + this.CEF_VERSION_PATCH + "." + this.JCEF_COMMIT_NUMBER;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getCefVersion() {
/*  60 */       return this.CEF_VERSION_MAJOR + "." + this.CEF_VERSION_MINOR + "." + this.CEF_VERSION_PATCH;
/*     */     }
/*     */     
/*     */     public String getChromeVersion() {
/*  64 */       return this.CHROME_VERSION_MAJOR + "." + this.CHROME_VERSION_MINOR + "." + this.CHROME_VERSION_BUILD + "." + this.CHROME_VERSION_PATCH;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  70 */       return "JCEF Version = " + getJcefVersion() + "\nCEF Version = " + 
/*  71 */         getCefVersion() + "\nChromium Version = " + 
/*  72 */         getChromeVersion();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum CefAppState
/*     */   {
/*  85 */     NONE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     NEW,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     INITIALIZING,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     INITIALIZED,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     SHUTTING_DOWN,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     TERMINATED
	/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   private static CefApp self = null;
/* 125 */   private static CefAppHandler appHandler_ = null;
/* 126 */   private static CefAppState state_ = CefAppState.NONE;
/* 127 */   private Timer workTimer_ = null;
/* 128 */   private final HashSet<CefClient> clients_ = new HashSet<>();
/* 129 */   private CefSettings settings_ = null;
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
/*     */   private CefApp(String[] paramArrayOfString, CefSettings paramCefSettings) throws UnsatisfiedLinkError {
/* 141 */     super(paramArrayOfString);
/* 142 */     if (paramCefSettings != null) this.settings_ = paramCefSettings.clone(); 
/* 143 */     if (OS.isWindows()) {
/* 144 */       SystemBootstrap.loadLibrary("jawt");
/* 145 */       SystemBootstrap.loadLibrary("chrome_elf");
/* 146 */       SystemBootstrap.loadLibrary("libcef");
/*     */ 
/*     */       
/* 149 */       SystemBootstrap.loadLibrary("jcef");
/* 150 */     } else if (OS.isLinux()) {
/* 151 */       SystemBootstrap.loadLibrary("cef");
/*     */     } 
/* 153 */     if (appHandler_ == null) {
/* 154 */       appHandler_ = this;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 159 */       Runnable runnable = new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 163 */             if (!CefApp.this.N_PreInitialize())
/* 164 */               throw new IllegalStateException("Failed to pre-initialize native code"); 
/*     */           }
/*     */         };
/* 167 */       if (SwingUtilities.isEventDispatchThread())
/* 168 */       { runnable.run(); }
/*     */       else
/* 170 */       { SwingUtilities.invokeAndWait(runnable); } 
/* 171 */     } catch (Exception exception) {
/* 172 */       exception.printStackTrace();
/*     */     } 
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
/*     */   public static void addAppHandler(CefAppHandler paramCefAppHandler) throws IllegalStateException {
/* 188 */     if (getState().compareTo(CefAppState.NEW) > 0)
/* 189 */       throw new IllegalStateException("Must be called before CefApp is initialized"); 
/* 190 */     appHandler_ = paramCefAppHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized CefApp getInstance() throws UnsatisfiedLinkError {
/* 199 */     return getInstance(null, null);
/*     */   }
/*     */   
/*     */   public static synchronized CefApp getInstance(String[] paramArrayOfString) throws UnsatisfiedLinkError {
/* 203 */     return getInstance(paramArrayOfString, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized CefApp getInstance(CefSettings paramCefSettings) throws UnsatisfiedLinkError {
/* 208 */     return getInstance(null, paramCefSettings);
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized CefApp getInstance(String[] paramArrayOfString, CefSettings paramCefSettings) throws UnsatisfiedLinkError {
/* 213 */     if (paramCefSettings != null && 
/* 214 */       getState() != CefAppState.NONE && getState() != CefAppState.NEW) {
/* 215 */       throw new IllegalStateException("Settings can only be passed to CEF before createClient is called the first time.");
/*     */     }
/*     */     
/* 218 */     if (self == null) {
/* 219 */       if (getState() == CefAppState.TERMINATED)
/* 220 */         throw new IllegalStateException("CefApp was terminated"); 
/* 221 */       self = new CefApp(paramArrayOfString, paramCefSettings);
/* 222 */       setState(CefAppState.NEW);
/*     */     } 
/* 224 */     return self;
/*     */   }
/*     */   
/*     */   public final void setSettings(CefSettings paramCefSettings) throws IllegalStateException {
/* 228 */     if (getState() != CefAppState.NONE && getState() != CefAppState.NEW) {
/* 229 */       throw new IllegalStateException("Settings can only be passed to CEF before createClient is called the first time.");
/*     */     }
/* 231 */     this.settings_ = paramCefSettings.clone();
/*     */   }
/*     */   
/*     */   public final CefVersion getVersion() {
/*     */     try {
/* 236 */       return N_GetVersion();
/* 237 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 238 */       unsatisfiedLinkError.printStackTrace();
/*     */       
/* 240 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final CefAppState getState() {
/* 248 */     synchronized (state_) {
/* 249 */       return state_;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final void setState(final CefAppState state) {
/* 254 */     synchronized (state_) {
/* 255 */       state_ = state;
/*     */     } 
/*     */     
/* 258 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           public void run() {
/* 261 */             if (CefApp.appHandler_ != null) CefApp.appHandler_.stateHasChanged(state);
/*     */           
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized void dispose() {
/*     */     HashSet<CefClient> hashSet;
/* 273 */     switch (getState()) {
/*     */       
/*     */       case NEW:
/* 276 */         setState(CefAppState.TERMINATED);
/*     */         break;
/*     */ 
/*     */       
/*     */       case INITIALIZING:
/*     */       case INITIALIZED:
/* 282 */         setState(CefAppState.SHUTTING_DOWN);
/* 283 */         if (this.clients_.isEmpty()) {
/* 284 */           shutdown();
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 289 */         hashSet = new HashSet<>(this.clients_);
/* 290 */         for (CefClient cefClient : hashSet) {
/* 291 */           cefClient.dispose();
/*     */         }
/*     */         break;
/*     */     } 
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
/*     */   public synchronized CefClient createClient() {
/*     */     CefClient cefClient;
/* 312 */     switch (getState()) {
/*     */       case NEW:
/* 314 */         setState(CefAppState.INITIALIZING);
/* 315 */         initialize();
/*     */ 
/*     */       
/*     */       case INITIALIZING:
/*     */       case INITIALIZED:
/* 320 */         cefClient = new CefClient();
/* 321 */         this.clients_.add(cefClient);
/* 322 */         return cefClient;
/*     */     } 
/*     */     
/* 325 */     throw new IllegalStateException("Can't crate client in state " + state_);
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
/*     */   public boolean registerSchemeHandlerFactory(String paramString1, String paramString2, CefSchemeHandlerFactory paramCefSchemeHandlerFactory) {
/*     */     try {
/* 345 */       return N_RegisterSchemeHandlerFactory(paramString1, paramString2, paramCefSchemeHandlerFactory);
/* 346 */     } catch (Exception exception) {
/* 347 */       exception.printStackTrace();
/*     */       
/* 349 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean clearSchemeHandlerFactories() {
/*     */     try {
/* 358 */       return N_ClearSchemeHandlerFactories();
/* 359 */     } catch (Exception exception) {
/* 360 */       exception.printStackTrace();
/*     */       
/* 362 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final synchronized void clientWasDisposed(CefClient paramCefClient) {
/* 372 */     this.clients_.remove(paramCefClient);
/* 373 */     if (this.clients_.isEmpty() && getState().compareTo(CefAppState.SHUTTING_DOWN) >= 0)
/*     */     {
/* 375 */       shutdown();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void initialize() {
/*     */     try {
/* 386 */       Runnable runnable = new Runnable()
/*     */         {
/*     */           public void run() {
/* 389 */             String str = CefApp.getJcefLibPath();
/* 390 */             System.out.println("initialize on " + Thread.currentThread() + " with library path " + str);
/*     */ 
/*     */             
/* 393 */             CefSettings cefSettings = (CefApp.this.settings_ != null) ? CefApp.this.settings_ : new CefSettings();
/*     */ 
/*     */             
/* 396 */             if (OS.isMacintosh()) {
/* 397 */               if (cefSettings.browser_subprocess_path == null) {
/* 398 */                 Path path = Paths.get(str, "../Frameworks/jcef Helper.app/Contents/MacOS/jcef Helper");
/*     */                 
/* 400 */                 cefSettings
/* 401 */                   .browser_subprocess_path = path.normalize().toAbsolutePath().toString();
/*     */               } 
/* 403 */             } else if (OS.isWindows()) {
/* 404 */               if (cefSettings.browser_subprocess_path == null) {
/* 405 */                 Path path = Paths.get(str, "jcef_helper.exe");
/* 406 */                 cefSettings
/* 407 */                   .browser_subprocess_path = path.normalize().toAbsolutePath().toString();
/*     */               } 
/* 409 */             } else if (OS.isLinux()) {
/* 410 */               if (cefSettings.browser_subprocess_path == null) {
/* 411 */                 Path path = Paths.get(str, "jcef_helper");
/* 412 */                 cefSettings
/* 413 */                   .browser_subprocess_path = path.normalize().toAbsolutePath().toString();
/*     */               } 
/* 415 */               if (cefSettings.resources_dir_path == null) {
/* 416 */                 Path path = Paths.get(str);
/* 417 */                 cefSettings
/* 418 */                   .resources_dir_path = path.normalize().toAbsolutePath().toString();
/*     */               } 
/* 420 */               if (cefSettings.locales_dir_path == null) {
/* 421 */                 Path path = Paths.get(str, "locales");
/* 422 */                 cefSettings
/* 423 */                   .locales_dir_path = path.normalize().toAbsolutePath().toString();
/*     */               } 
/*     */             } 
/*     */             
/* 427 */             if (CefApp.this.N_Initialize(CefApp.appHandler_, cefSettings)) CefApp.setState(CefAppState.INITIALIZED);
/*     */           }
/*     */         };
/* 430 */       if (SwingUtilities.isEventDispatchThread())
/* 431 */       { runnable.run(); }
/*     */       else
/* 433 */       { SwingUtilities.invokeAndWait(runnable); } 
/* 434 */     } catch (Exception exception) {
/* 435 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void handleBeforeTerminate() {
/* 444 */     System.out.println("Cmd+Q termination request.");
/*     */ 
/*     */     
/* 447 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 451 */             CefAppHandler cefAppHandler = (CefApp.appHandler_ == null) ? getSelf() : CefApp.appHandler_;
/* 452 */             if (!cefAppHandler.onBeforeTerminate()) CefApp.this.dispose();
/*     */           
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 	private CefApp getSelf() { return this; }
/*     */ 
/*     */ 
/*     */   
/*     */   private final void shutdown() {
/* 463 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           public void run() {
/* 466 */             System.out.println("shutdown on " + Thread.currentThread());
/*     */ 
/*     */             
/* 469 */             CefApp.this.N_Shutdown();
/*     */             
/* 471 */             CefApp.setState(CefAppState.TERMINATED);
/* 472 */             CefApp.self = null;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void doMessageLoopWork(final long delay_ms) {
/* 483 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           public void run() {
/* 486 */             if (CefApp.getState() == CefAppState.TERMINATED) {
/*     */               return;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 492 */             if (CefApp.this.workTimer_ != null) {
/* 493 */               CefApp.this.workTimer_.stop();
/* 494 */               CefApp.this.workTimer_ = null;
/*     */             } 
/*     */             
/* 497 */             if (delay_ms <= 0L) {
/*     */               
/* 499 */               CefApp.this.N_DoMessageLoopWork();
/*     */ 
/*     */               
/* 502 */               CefApp.this.doMessageLoopWork(33L);
/*     */             } else {
/* 504 */               long l = delay_ms;
/*     */               
/* 506 */               if (l > 33L) l = 33L;
/*     */               
/* 508 */               CefApp.this.workTimer_ = new Timer((int)l, new ActionListener()
/*     */                   {
/*     */                     public void actionPerformed(ActionEvent param2ActionEvent)
/*     */                     {
/* 512 */                       CefApp.this.workTimer_.stop();
/* 513 */                       CefApp.this.workTimer_ = null;
/*     */                       
/* 515 */                       CefApp.this.N_DoMessageLoopWork();
/*     */ 
/*     */                       
/* 518 */                       CefApp.this.doMessageLoopWork(33L);
/*     */                     }
/*     */                   });
/* 521 */               CefApp.this.workTimer_.start();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean startup(String[] paramArrayOfString) {
/* 535 */     if (OS.isLinux() || OS.isMacintosh()) {
/* 536 */       SystemBootstrap.loadLibrary("jcef");
/* 537 */       return N_Startup(OS.isMacintosh() ? getCefFrameworkPath(paramArrayOfString) : null);
/*     */     } 
/* 539 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String getJcefLibPath() {
/* 547 */     String str = System.getProperty("java.library.path");
/* 548 */     String[] arrayOfString = str.split(System.getProperty("path.separator"));
/* 549 */     for (String str1 : arrayOfString) {
/* 550 */       File file = new File(str1);
/* 551 */       String[] arrayOfString1 = file.list(new FilenameFilter()
/*     */           {
/*     */             public boolean accept(File param1File, String param1String) {
/* 554 */               return (param1String.equalsIgnoreCase("libjcef.dylib") || param1String
/* 555 */                 .equalsIgnoreCase("libjcef.so") || param1String
/* 556 */                 .equalsIgnoreCase("jcef.dll"));
/*     */             }
/*     */           });
/* 559 */       if (arrayOfString1 != null && arrayOfString1.length != 0) return str1; 
/*     */     } 
/* 561 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String getCefFrameworkPath(String[] paramArrayOfString) {
/* 570 */     String str = "--framework-dir-path=";
/* 571 */     for (String str1 : paramArrayOfString) {
/* 572 */       if (str1.startsWith(str)) {
/* 573 */         return (new File(str1.substring(str.length()))).getAbsolutePath();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 578 */     return (new File(getJcefLibPath() + "/../Frameworks/Chromium Embedded Framework.framework"))
/* 579 */       .getAbsolutePath();
/*     */   }
/*     */   
/*     */   private static final native boolean N_Startup(String paramString);
/*     */   
/*     */   private final native boolean N_PreInitialize();
/*     */   
/*     */   private final native boolean N_Initialize(CefAppHandler paramCefAppHandler, CefSettings paramCefSettings);
/*     */   
/*     */   private final native void N_Shutdown();
/*     */   
/*     */   private final native void N_DoMessageLoopWork();
/*     */   
/*     */   private final native CefVersion N_GetVersion();
/*     */   
/*     */   private final native boolean N_RegisterSchemeHandlerFactory(String paramString1, String paramString2, CefSchemeHandlerFactory paramCefSchemeHandlerFactory);
/*     */   
/*     */   private final native boolean N_ClearSchemeHandlerFactories();
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\CefApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */