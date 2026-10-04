package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p263authapiphone.zzab;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class SmsRetriever {

    @NonNull
    public static final String EXTRA_CONSENT_INTENT = "com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT";

    @NonNull
    public static final String EXTRA_SIM_SUBSCRIPTION_ID = "com.google.android.gms.auth.api.phone.EXTRA_SIM_SUBSCRIPTION_ID";

    @NonNull
    public static final String EXTRA_SMS_MESSAGE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE";

    @NonNull
    public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";

    @NonNull
    public static final String SEND_PERMISSION = "com.google.android.gms.auth.api.phone.permission.SEND";

    @NonNull
    public static final String SMS_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED";

    private SmsRetriever() {
    }

    @NonNull
    public static SmsRetrieverClient getClient(@NonNull Activity activity) {
        return new zzab(activity);
    }

    @NonNull
    public static SmsRetrieverClient getClient(@NonNull Context context) {
        return new zzab(context);
    }
}
