package com.samsung.android.support.senl.p148nt.base.common.cms;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.region.RegionUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SamsungAccountUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\n¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/cms/SamsungAccountConsentHelper;", "", "<init>", "()V", "getConsentUrl", "", "type", "", "isConsentInterfaceAvailable", "", "()Z", "appKey", "getAppKey", "()Ljava/lang/String;", BuddyContract.Address.REGION, "getRegion", "language", "getLanguage", "appVersion", "getAppVersion", "isDartMode", "isRtlMode", "getType", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SamsungAccountConsentHelper {
    public static final int PDP_TYPE = 3;
    public static final int PN_TYPE = 1;

    @NotNull
    private static final String STAGING_DOMAIN_URL = "https://policys.samsungconsentdev.com";
    private static final boolean STAGING_TEST = false;

    @NotNull
    private static final String TAG = "SamsungAccountConsentHelper";
    public static final int TC_TYPE = 2;

    private final String getType(int type) {
        if (type == 1) {
            return "PN";
        }
        if (type == 2) {
            return "TC";
        }
        if (type == 3) {
            return "PDP";
        }
        Debugger.INSTANCE.m8621e(TAG, "[SA] getType() : Unknown Type = " + type);
        return "TC";
    }

    private final boolean isDartMode() {
        return ContextUtils.isNightMode(BaseUtils.getApplicationContext());
    }

    private final boolean isRtlMode() {
        return LocaleUtils.isRTLMode();
    }

    @NotNull
    public final String getAppKey() {
        return CommonUtils.getAppServiceId();
    }

    @NotNull
    public final String getAppVersion() {
        Context applicationContext = BaseUtils.getApplicationContext();
        return PackageManagerCompat.INSTANCE.getApkVersionName(applicationContext, applicationContext != null ? applicationContext.getPackageName() : null);
    }

    @NotNull
    public final String getConsentUrl(int type) {
        return getConsentUrl(getType(type));
    }

    @NotNull
    public final String getLanguage() {
        try {
            String iSO3Language = Locale.getDefault().getISO3Language();
            Intrinsics.checkNotNullExpressionValue(iSO3Language, "getISO3Language(...)");
            return iSO3Language;
        } catch (Exception e) {
            Debugger.INSTANCE.m8621e(TAG, "[SA] getLanguage() : " + e);
            return "";
        }
    }

    @Nullable
    public final String getRegion() {
        String lowerCase;
        try {
            String iSO3Country = Locale.getDefault().getISO3Country();
            Intrinsics.checkNotNullExpressionValue(iSO3Country, "getISO3Country(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            lowerCase = iSO3Country.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } catch (Exception e) {
            Debugger.INSTANCE.m8621e(TAG, "[SA] getRegion() : " + e);
            lowerCase = "";
        }
        if (!TextUtils.isEmpty(lowerCase)) {
            return lowerCase;
        }
        Debugger.INSTANCE.m8627i(TAG, "[SA] getRegion() : region is empty so get a application region!");
        return SamsungAccountUtil.getApplicationRegion();
    }

    public final boolean isConsentInterfaceAvailable() {
        Bundle bundle;
        Context applicationContext = BaseUtils.getApplicationContext();
        ApplicationInfo applicationInfo = null;
        if (applicationContext != null) {
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager != null) {
                    applicationInfo = packageManager.getApplicationInfo("com.osp.app.signin", 128);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Debugger.INSTANCE.m8619d(TAG, "[SA] isConsentInterfaceAvailable() : NameNotFoundException");
            }
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || bundle.getFloat("TNC_SYS_VER", 0.0f) < 2.0d) {
            return false;
        }
        Debugger.INSTANCE.m8619d(TAG, "[SA] isConsentInterfaceAvailable() : true");
        return true;
    }

    @NotNull
    public final String getConsentUrl(@Nullable String type) {
        StringBuilder sb = new StringBuilder();
        sb.append(RegionUtils.getPolicyServerURL());
        sb.append("/terms?appKey=");
        sb.append(getAppKey());
        sb.append("&applicationRegion=");
        sb.append(SamsungAccountUtil.getApplicationRegion());
        sb.append("&region=");
        sb.append(getRegion());
        sb.append("&language=");
        sb.append(getLanguage());
        sb.append("&appVersion=");
        sb.append(getAppVersion());
        sb.append("&darkMode=");
        sb.append(isDartMode());
        sb.append("&rtl=");
        sb.append(isRtlMode());
        sb.append("&type=");
        sb.append(type);
        Debugger.INSTANCE.m8627i(TAG, "[SA] consentUrl = " + ((Object) sb));
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
