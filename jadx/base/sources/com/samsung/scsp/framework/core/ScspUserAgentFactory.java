package com.samsung.scsp.framework.core;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspUserAgentFactory {
    public static String get(SContext sContext, String str, String str2) {
        String[] strArrSplit = str.split(RemoteConstant.VERSION_DIVIDE);
        String strM1626p = strArrSplit[strArrSplit.length - 1];
        if ("lite".equals(strM1626p) && strArrSplit.length > 1) {
            strM1626p = AbstractC2322a.m1626p(new StringBuilder(), strArrSplit[strArrSplit.length - 2], Extension.DOT, strM1626p);
        }
        Context applicationContext = ContextFactory.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        String appVersion = sContext.getAppVersion();
        String b2BMode = DeviceUtil.getB2BMode(applicationContext);
        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        String str5 = Build.DISPLAY;
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        StringBuilder sbM2228s = AbstractC2821a.m2228s(str4, "; ", str5, "; ", packageName);
        AbstractC2821a.m2207B(sbM2228s, MarketingConstants.REFERRER_DELIMITER_U003D, appVersion, "; android sdk=", strValueOf);
        AbstractC2821a.m2207B(sbM2228s, ", sw=", str3, "; ", strM1626p);
        sbM2228s.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        sbM2228s.append(str2);
        sb.append(sbM2228s.toString());
        if (!"none".equals(b2BMode)) {
            sb.append(", b2b=" + b2BMode);
        }
        sb.append(";");
        return sb.toString();
    }

    public static String get() {
        return get(SContext.getInstance(), BuildConfig.LIBRARY_PACKAGE_NAME, BuildConfig.VERSION_NAME);
    }
}
