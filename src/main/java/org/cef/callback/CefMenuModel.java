/*    */ package org.cef.callback;

import org.cef.misc.BoolRef;
import org.cef.misc.IntRef;

/*    */ public interface CefMenuModel { boolean clear();
/*    */   int getCount();
/*    */   boolean addSeparator();
/*    */   boolean addItem(int paramInt, String paramString);
/*    */   boolean addCheckItem(int paramInt, String paramString);
/*    */   boolean addRadioItem(int paramInt1, String paramString, int paramInt2);
/*    */   CefMenuModel addSubMenu(int paramInt, String paramString);
/*    */   boolean insertSeparatorAt(int paramInt);
/*    */   boolean insertItemAt(int paramInt1, int paramInt2, String paramString);
/*    */   boolean insertCheckItemAt(int paramInt1, int paramInt2, String paramString);
/*    */   boolean insertRadioItemAt(int paramInt1, int paramInt2, String paramString, int paramInt3);
/*    */   CefMenuModel insertSubMenuAt(int paramInt1, int paramInt2, String paramString);
/*    */   boolean remove(int paramInt);
/*    */   boolean removeAt(int paramInt);
/*    */   int getIndexOf(int paramInt);
/*    */   int getCommandIdAt(int paramInt);
/*    */   boolean setCommandIdAt(int paramInt1, int paramInt2);
/*    */   String getLabel(int paramInt);
/*    */   String getLabelAt(int paramInt);
/*    */   boolean setLabel(int paramInt, String paramString);
/*    */   boolean setLabelAt(int paramInt, String paramString);
/*    */   MenuItemType getType(int paramInt);
/*    */   MenuItemType getTypeAt(int paramInt);
/*    */   int getGroupId(int paramInt);
/*    */   int getGroupIdAt(int paramInt);
/*    */   boolean setGroupId(int paramInt1, int paramInt2);
/*    */   boolean setGroupIdAt(int paramInt1, int paramInt2);
/*    */   CefMenuModel getSubMenu(int paramInt);
/*    */   CefMenuModel getSubMenuAt(int paramInt);
/*    */   boolean isVisible(int paramInt);
/*    */   boolean isVisibleAt(int paramInt);
/*    */   boolean setVisible(int paramInt, boolean paramBoolean);
/*    */   boolean setVisibleAt(int paramInt, boolean paramBoolean);
/*    */   boolean isEnabled(int paramInt);
/*    */   boolean isEnabledAt(int paramInt);
/*    */   boolean setEnabled(int paramInt, boolean paramBoolean);
/*    */   boolean setEnabledAt(int paramInt, boolean paramBoolean);
/*    */   boolean isChecked(int paramInt);
/*    */   boolean isCheckedAt(int paramInt);
/*    */   boolean setChecked(int paramInt, boolean paramBoolean);
/*    */   boolean setCheckedAt(int paramInt, boolean paramBoolean);
/*    */   boolean hasAccelerator(int paramInt);
/*    */   boolean hasAcceleratorAt(int paramInt);
/*    */   boolean setAccelerator(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*    */   boolean setAcceleratorAt(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*    */   boolean removeAccelerator(int paramInt);
/*    */   boolean removeAcceleratorAt(int paramInt);
/*    */   boolean getAccelerator(int paramInt, IntRef paramIntRef, BoolRef paramBoolRef1, BoolRef paramBoolRef2, BoolRef paramBoolRef3);
/*    */   boolean getAcceleratorAt(int paramInt, IntRef paramIntRef, BoolRef paramBoolRef1, BoolRef paramBoolRef2, BoolRef paramBoolRef3);
/*    */   final class MenuId { public static final int MENU_ID_BACK = 100; public static final int MENU_ID_FORWARD = 101; public static final int MENU_ID_RELOAD = 102; public static final int MENU_ID_RELOAD_NOCACHE = 103; public static final int MENU_ID_STOPLOAD = 104; public static final int MENU_ID_UNDO = 110; public static final int MENU_ID_REDO = 111; public static final int MENU_ID_CUT = 112; public static final int MENU_ID_COPY = 113; public static final int MENU_ID_PASTE = 114; public static final int MENU_ID_DELETE = 115; public static final int MENU_ID_SELECT_ALL = 116; public static final int MENU_ID_FIND = 130; public static final int MENU_ID_PRINT = 131; public static final int MENU_ID_VIEW_SOURCE = 132; public static final int MENU_ID_SPELLCHECK_SUGGESTION_0 = 200; public static final int MENU_ID_SPELLCHECK_SUGGESTION_1 = 201; public static final int MENU_ID_SPELLCHECK_SUGGESTION_2 = 202; public static final int MENU_ID_SPELLCHECK_SUGGESTION_3 = 203;
/*    */     public static final int MENU_ID_SPELLCHECK_SUGGESTION_4 = 204;
/*    */     public static final int MENU_ID_SPELLCHECK_SUGGESTION_LAST = 204;
/*    */     public static final int MENU_ID_NO_SPELLING_SUGGESTIONS = 205;
/*    */     public static final int MENU_ID_USER_FIRST = 26500;
/*    */     public static final int MENU_ID_USER_LAST = 28500; }
/*    */   
/* 58 */    enum MenuItemType { MENUITEMTYPE_NONE,
/* 59 */     MENUITEMTYPE_COMMAND,
/* 60 */     MENUITEMTYPE_CHECK,
/* 61 */     MENUITEMTYPE_RADIO,
/* 62 */     MENUITEMTYPE_SEPARATOR,
/* 63 */     MENUITEMTYPE_SUBMENU
}
/*    */    }


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefMenuModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */