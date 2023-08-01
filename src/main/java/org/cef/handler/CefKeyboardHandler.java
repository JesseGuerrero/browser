/*     */ package org.cef.handler;
/*     */ 
/*     */ import org.cef.browser.CefBrowser;
/*     */ import org.cef.misc.BoolRef;
/*     */ 
/*     */ 
/*     */ public interface CefKeyboardHandler
/*     */ {
/*     */   boolean onPreKeyEvent(CefBrowser paramCefBrowser, CefKeyEvent paramCefKeyEvent, BoolRef paramBoolRef);
/*     */   
/*     */   boolean onKeyEvent(CefBrowser paramCefBrowser, CefKeyEvent paramCefKeyEvent);
/*     */   
/*     */   final class CefKeyEvent
/*     */   {
/*     */     public final EventType type;
/*     */     public final int modifiers;
/*     */     public final int windows_key_code;
/*     */     public final int native_key_code;
/*     */     public final boolean is_system_key;
/*     */     public final char character;
/*     */     public final char unmodified_character;
/*     */     public final boolean focus_on_editable_field;
/*     */     
/*     */     public enum EventType
/*     */     {
/*  26 */       KEYEVENT_RAWKEYDOWN,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  33 */       KEYEVENT_KEYDOWN,
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  38 */       KEYEVENT_KEYUP,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  45 */       KEYEVENT_CHAR
	/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     CefKeyEvent(EventType param1EventType, int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean1, char param1Char1, char param1Char2, boolean param1Boolean2) {
/*  51 */       this.type = param1EventType;
/*  52 */       this.modifiers = param1Int1;
/*  53 */       this.windows_key_code = param1Int2;
/*  54 */       this.native_key_code = param1Int3;
/*  55 */       this.is_system_key = param1Boolean1;
/*  56 */       this.character = param1Char1;
/*  57 */       this.unmodified_character = param1Char2;
/*  58 */       this.focus_on_editable_field = param1Boolean2;
/*     */     }
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
/*     */     public String toString() {
/* 111 */       return "CefKeyEvent [type=" + this.type + ", modifiers=" + this.modifiers + ", windows_key_code=" + this.windows_key_code + ", native_key_code=" + this.native_key_code + ", is_system_key=" + this.is_system_key + ", character=" + this.character + ", unmodified_character=" + this.unmodified_character + ", focus_on_editable_field=" + this.focus_on_editable_field + "]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\handler\CefKeyboardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */