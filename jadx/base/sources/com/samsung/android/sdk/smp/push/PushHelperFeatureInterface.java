package com.samsung.android.sdk.smp.push;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface PushHelperFeatureInterface {
    void handleBootOrUpdateEvent(Context context);

    void handlePushRegistrationFail(Context context, String str, String str2, String str3);

    void initializePushPlatform(Context context);

    boolean isValidPushRegistration(Context context, String str, String str2);

    void register(Context context);

    void switchPushWhenSppDeactivated(Context context);

    boolean validateAndSwitchPushPlatform(Context context);
}
