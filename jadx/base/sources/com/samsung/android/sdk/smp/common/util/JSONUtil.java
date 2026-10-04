package com.samsung.android.sdk.smp.common.util;

import android.text.TextUtils;
import com.adobe.internal.xmp.XMPConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class JSONUtil {
    private static final String TAG = "JSONUtil";

    public static JSONArray combineJSONArrays(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray2;
        }
        if (jSONArray2 == null || jSONArray2.length() == 0) {
            return jSONArray;
        }
        try {
            String string = jSONArray.toString();
            String string2 = jSONArray2.toString();
            return new JSONArray("[" + string.substring(string.indexOf("[") + 1, string.lastIndexOf("]")) + "," + string2.substring(string2.indexOf("[") + 1, string2.lastIndexOf("]")) + "]");
        } catch (Exception e) {
            SmpLog.m6494e(TAG, e.toString());
            return null;
        }
    }

    public static JSONObject getJSONObjectFromMap(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                jSONObject.put(key, value);
            }
        }
        return jSONObject;
    }

    public static List<String> getStringListFromJsonArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str) || XMPConst.ARRAY_ITEM_NAME.equals(str) || "{}".equals(str);
    }

    public static JSONArray removeItemFromJsonArray(JSONArray jSONArray, int i) {
        jSONArray.remove(i);
        return jSONArray;
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }
}
