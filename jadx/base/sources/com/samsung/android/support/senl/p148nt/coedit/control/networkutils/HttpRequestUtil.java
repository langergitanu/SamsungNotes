package com.samsung.android.support.senl.p148nt.coedit.control.networkutils;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpRequestUtil {
    private static final String TAG = "HttpRequestUtil";

    public static boolean isFailedResponse(int i) {
        return i < 200 || i >= 400;
    }

    public static int parseRCode(String str) {
        if (TextUtils.isEmpty(str)) {
            CoeditLogger.m8920e(TAG, "parseRCode Fail : jsonString is empty!");
            return 0;
        }
        try {
            return new JSONObject(str).optInt("rcode");
        } catch (JSONException e) {
            CoeditLogger.m8920e(TAG, "parseRCode Fail " + e.getMessage());
            return 0;
        }
    }

    public abstract SCloudHttpResponse get(String str, Map<String, String> map, Map<String, String> map2, String str2);

    public abstract SCloudHttpResponse post(String str, Map<String, String> map, Map<String, String> map2, String str2);

    public abstract SCloudHttpResponse put(String str, Map<String, String> map, Map<String, String> map2, String str2);
}
