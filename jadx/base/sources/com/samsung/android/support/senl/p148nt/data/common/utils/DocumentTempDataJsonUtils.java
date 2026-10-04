package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentTempDataJsonUtils {
    public static JSONObject removeTempData(@NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject(str2);
        jSONObject.remove(str);
        return jSONObject;
    }

    public static String updateTempData(@NonNull String str, @NonNull JSONObject jSONObject, @Nullable String str2) throws JSONException {
        JSONObject jSONObject2 = TextUtils.isEmpty(str2) ? new JSONObject() : new JSONObject(str2);
        jSONObject2.put(str, jSONObject);
        return jSONObject2.toString();
    }
}
