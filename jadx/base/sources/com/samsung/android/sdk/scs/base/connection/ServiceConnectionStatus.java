package com.samsung.android.sdk.scs.base.connection;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Retention(RetentionPolicy.SOURCE)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public @interface ServiceConnectionStatus {
    public static final int BINDFAIL = 3;
    public static final int CONNECTED = 1;
    public static final int DISCONNECTED = 2;
}
