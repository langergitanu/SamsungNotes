package com.microsoft.identity.common.internal.p131ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.WarningType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WebViewUtil {
    private static CookieManager getCookieManager(Context context) {
        setDataDirectorySuffix(context);
        return CookieManager.getInstance();
    }

    public static void removeCookiesFromWebView(Context context) {
        CookieManager cookieManager = getCookieManager(context);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    public static void removeSessionCookiesFromWebView(Context context) {
        CookieManager cookieManager = getCookieManager(context);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    public static void setAcceptCookie(boolean z, Context context) {
        getCookieManager(context).setAcceptCookie(z);
    }

    @SuppressLint({WarningType.NewApi})
    public static void setDataDirectorySuffix(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                if (ProcessUtil.isRunningOnAuthService(context)) {
                    WebView.setDataDirectorySuffix(ProcessUtil.AuthServiceProcess);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }
}
