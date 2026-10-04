package com.samsung.android.kmxservice.sdk.e2ee;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface KmxE2EEContract {
    public static final int KMX_E2EE_TYPE_KMX = 1;
    public static final int KMX_E2EE_TYPE_NONE = 0;
    public static final int KMX_E2EE_TYPE_SKS = 2;
    public static final int KMX_INTEGRITY_NORMAL = 0;
    public static final int KMX_KEY_DEVICE = 2;
    public static final int KMX_KEY_FABRIC = 0;
    public static final int KMX_KEY_SERVICE = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface KmxKeyType {
    }
}
