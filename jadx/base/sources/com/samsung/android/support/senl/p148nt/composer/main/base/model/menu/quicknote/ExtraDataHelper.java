package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExtraDataHelper {
    public static final int EXTRA_TYPE_BOOL = 2;
    public static final int EXTRA_TYPE_INT = 0;
    public static final int EXTRA_TYPE_LONG = 3;
    public static final int EXTRA_TYPE_STRING = 1;
    public static final String KEY_ACTION = "key_action";
    public static final String KEY_DEVICE_ID = "key_device_id";
    public static final String KEY_MIME_TYPE = "key_mimeType";
    public static final String KEY_URI = "key_uri";

    public void createJson(@NonNull JSONObject jSONObject, String str, String str2, @Nullable String str3) {
        jSONObject.put("key_action", str);
        jSONObject.put(KEY_URI, str2);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        jSONObject.put(KEY_MIME_TYPE, str3);
    }

    public void putDeviceId(@NonNull JSONObject jSONObject, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        jSONObject.put(KEY_DEVICE_ID, str);
    }

    public void setExtraToIntent(Intent intent, JSONObject jSONObject) {
        JSONArray jSONArray;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!next.equals("key_action") && !next.equals(KEY_URI) && !next.equals(KEY_MIME_TYPE) && !next.equals(KEY_DEVICE_ID) && (jSONArray = (JSONArray) jSONObject.opt(next)) != null) {
                int iOptInt = jSONArray.optInt(0);
                if (iOptInt == 0) {
                    intent.putExtra(next, jSONArray.optInt(1));
                } else if (iOptInt == 1) {
                    intent.putExtra(next, jSONArray.optString(1));
                } else if (iOptInt == 2) {
                    intent.putExtra(next, jSONArray.optBoolean(1));
                } else if (iOptInt == 3) {
                    intent.putExtra(next, jSONArray.optLong(1));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExtraPutter<T> {
        private final int mType;

        public ExtraPutter(int i) {
            this.mType = i;
        }

        public void put(JSONObject jSONObject, List<Pair<String, T>> list) throws JSONException {
            Iterator<Pair<String, T>> it = list.iterator();
            while (it.hasNext()) {
                put(jSONObject, it.next());
            }
        }

        public void put(JSONObject jSONObject, Pair<String, T> pair) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.mType).put(pair.second);
            jSONObject.put((String) pair.first, jSONArray);
        }
    }
}
