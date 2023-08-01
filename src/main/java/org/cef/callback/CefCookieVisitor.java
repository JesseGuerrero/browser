package org.cef.callback;

import org.cef.misc.BoolRef;
import org.cef.network.CefCookie;

public interface CefCookieVisitor {
  boolean visit(CefCookie paramCefCookie, int paramInt1, int paramInt2, BoolRef paramBoolRef);
}


/* Location:              C:\Users\jesse\Desktop\jcef.jar!\org\cef\callback\CefCookieVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */