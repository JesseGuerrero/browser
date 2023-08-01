/*     */ package org.cef;
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
/*     */ public class CefSettings
/*     */ {
/*     */   public enum LogSeverity
/*     */   {
/*  20 */     LOGSEVERITY_DEFAULT,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  25 */     LOGSEVERITY_VERBOSE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  30 */     LOGSEVERITY_INFO,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     LOGSEVERITY_WARNING,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     LOGSEVERITY_ERROR,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     LOGSEVERITY_FATAL,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     LOGSEVERITY_DISABLE
	/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class ColorType
/*     */   {
/*  58 */     private long color_value = 0L;
/*     */ 
/*     */ 
/*     */     
/*     */     public ColorType(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  63 */       this.color_value = ((long) param1Int1 << 24 | (long) param1Int2 << 16 | (long) param1Int3 << 8 | param1Int4 << 0);
/*     */     }
/*     */     
/*     */     public long getColor() {
/*  67 */       return this.color_value;
/*     */     }
/*     */ 
/*     */     
/*     */     public ColorType clone() {
/*  72 */       ColorType colorType = new ColorType();
/*  73 */       colorType.color_value = this.color_value;
/*  74 */       return colorType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ColorType() {}
/*     */   }
/*     */ 
/*     */   
/*  84 */   public String browser_subprocess_path = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean windowless_rendering_enabled = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean command_line_args_disabled = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public String cache_path = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean persist_session_cookies = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   public String user_agent = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public String user_agent_product = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public String locale = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   public String log_file = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public LogSeverity log_severity = LogSeverity.LOGSEVERITY_DEFAULT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public String javascript_flags = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   public String resources_dir_path = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 182 */   public String locales_dir_path = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean pack_loading_disabled = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 200 */   public int remote_debugging_port = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 209 */   public int uncaught_exception_stack_size = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ignore_certificate_errors = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 226 */   public ColorType background_color = null;
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
/* 239 */   public String cookieable_schemes_list = null;
/*     */ 
/*     */   
/*     */   public boolean cookieable_schemes_exclude_defaults = false;
/*     */ 
/*     */   
/*     */   public CefSettings clone() {
/* 246 */     CefSettings cefSettings = new CefSettings();
/* 247 */     cefSettings.browser_subprocess_path = this.browser_subprocess_path;
/* 248 */     cefSettings.windowless_rendering_enabled = this.windowless_rendering_enabled;
/* 249 */     cefSettings.command_line_args_disabled = this.command_line_args_disabled;
/* 250 */     cefSettings.cache_path = this.cache_path;
/* 251 */     cefSettings.persist_session_cookies = this.persist_session_cookies;
/* 252 */     cefSettings.user_agent = this.user_agent;
/* 253 */     cefSettings.user_agent_product = this.user_agent_product;
/* 254 */     cefSettings.locale = this.locale;
/* 255 */     cefSettings.log_file = this.log_file;
/* 256 */     cefSettings.log_severity = this.log_severity;
/* 257 */     cefSettings.javascript_flags = this.javascript_flags;
/* 258 */     cefSettings.resources_dir_path = this.resources_dir_path;
/* 259 */     cefSettings.locales_dir_path = this.locales_dir_path;
/* 260 */     cefSettings.pack_loading_disabled = this.pack_loading_disabled;
/* 261 */     cefSettings.remote_debugging_port = this.remote_debugging_port;
/* 262 */     cefSettings.uncaught_exception_stack_size = this.uncaught_exception_stack_size;
/* 263 */     cefSettings.ignore_certificate_errors = this.ignore_certificate_errors;
/* 264 */     if (this.background_color != null) cefSettings.background_color = this.background_color.clone(); 
/* 265 */     cefSettings.cookieable_schemes_list = this.cookieable_schemes_list;
/* 266 */     cefSettings.cookieable_schemes_exclude_defaults = this.cookieable_schemes_exclude_defaults;
/* 267 */     return cefSettings;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\CefSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */