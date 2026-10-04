package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.model;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecognizeTextInfo {
    private static final String TAG = "RecognizeTextInfo";
    private JSONArray contentsInfo;

    public RecognizeTextInfo(String str) {
        this.contentsInfo = new JSONArray();
        try {
            this.contentsInfo = new JSONArray(str);
        } catch (JSONException unused) {
        }
    }

    public SpannableStringBuilder getContentStr() {
        JSONArray jSONArray = this.contentsInfo;
        if (jSONArray == null) {
            return new SpannableStringBuilder();
        }
        int length = jSONArray.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < length; i++) {
            try {
                spannableStringBuilder.append((CharSequence) this.contentsInfo.getJSONObject(i).keys().next());
            } catch (JSONException e) {
                MainLogger.m7255e(TAG, "getContentStr, JSONException: " + e.getMessage());
            }
        }
        return spannableStringBuilder;
    }

    public JSONArray getContentsInfo() {
        return this.contentsInfo;
    }

    public void putContentInfo(String str, int i) {
        if (this.contentsInfo == null) {
            this.contentsInfo = new JSONArray();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, i);
            this.contentsInfo.put(jSONObject);
        } catch (JSONException e) {
            MainLogger.m7255e(TAG, "putContentInfo, JSONException: " + e.getMessage());
        }
    }

    @NonNull
    public String toString() {
        return getContentStr().toString();
    }
}
