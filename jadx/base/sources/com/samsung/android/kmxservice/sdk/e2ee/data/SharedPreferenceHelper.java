package com.samsung.android.kmxservice.sdk.e2ee.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SharedPreferenceHelper {
    public static String getSakUid(Context context) {
        return context.getSharedPreferences("kmx_sdk_shared_preference", 0).getString("kmx_sdk_shared_preference_sak_uid", null);
    }

    public static void setSakUid(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("kmx_sdk_shared_preference", 0).edit();
        editorEdit.putString("kmx_sdk_shared_preference_sak_uid", str);
        editorEdit.apply();
    }
}
