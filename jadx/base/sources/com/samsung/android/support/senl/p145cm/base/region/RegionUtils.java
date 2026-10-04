package com.samsung.android.support.senl.p145cm.base.region;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/region/RegionUtils;", "", "<init>", "()V", "accountServerURL", "", "getAccountServerURL$annotations", "getAccountServerURL", "()Ljava/lang/String;", "policyServerURL", "getPolicyServerURL$annotations", "getPolicyServerURL", "consentServerURL", "getConsentServerURL$annotations", "getConsentServerURL", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RegionUtils {

    @NotNull
    public static final RegionUtils INSTANCE = new RegionUtils();

    private RegionUtils() {
    }

    @NotNull
    public static final String getAccountServerURL() {
        return RegionConstants.SAMSUNG_ACCOUNT_URL;
    }

    @NotNull
    public static final String getConsentServerURL() {
        return RegionConstants.CONSENT_SERVER_URL;
    }

    @NotNull
    public static final String getPolicyServerURL() {
        return RegionConstants.CONSENT_URL;
    }

    @JvmStatic
    public static /* synthetic */ void getAccountServerURL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getConsentServerURL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPolicyServerURL$annotations() {
    }
}
