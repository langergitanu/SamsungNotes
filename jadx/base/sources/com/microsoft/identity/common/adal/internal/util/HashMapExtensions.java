package com.microsoft.identity.common.adal.internal.util;

import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.adal.internal.net.HttpWebResponse;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class HashMapExtensions {
    private static final String TAG = "HashMapExtensions";

    private HashMapExtensions() {
    }

    public static HashMap<String, String> getJsonResponse(HttpWebResponse httpWebResponse) {
        HashMap<String, String> map = new HashMap<>();
        if (httpWebResponse != null && !TextUtils.isEmpty(httpWebResponse.getBody())) {
            JSONObject jSONObject = new JSONObject(httpWebResponse.getBody());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
        }
        return map;
    }

    public static HashMap<String, String> jsonStringAsMap(String str) {
        HashMap<String, String> map = new HashMap<>();
        if (!StringExtensions.isNullOrBlank(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
        }
        return map;
    }

    public static HashMap<String, List<String>> jsonStringAsMapList(String str) {
        HashMap<String, List<String>> map = new HashMap<>();
        if (!StringExtensions.isNullOrBlank(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(jSONObject.getString(next));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.get(i).toString());
                }
                map.put(next, arrayList);
            }
        }
        return map;
    }

    public static HashMap<String, String> urlFormDecode(String str) {
        return urlFormDecodeData(str, MsalUtils.QUERY_STRING_DELIMITER);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> urlFormDecodeData(String str, String str2) {
        String strUrlFormDecode;
        String strUrlFormDecode2;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":urlFormDecodeData", new StringBuilder());
        HashMap<String, String> map = new HashMap<>();
        if (!StringExtensions.isNullOrBlank(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                String[] strArrSplit = stringTokenizer.nextToken().split(MarketingConstants.REFERRER_DELIMITER_U003D);
                if (strArrSplit.length == 2) {
                    try {
                        strUrlFormDecode = StringExtensions.urlFormDecode(strArrSplit[0].trim());
                        strUrlFormDecode2 = StringExtensions.urlFormDecode(strArrSplit[1].trim());
                        if (StringExtensions.isNullOrBlank(strUrlFormDecode)) {
                            map.put(strUrlFormDecode, strUrlFormDecode2);
                        }
                    } catch (UnsupportedEncodingException e) {
                        Logger.errorPII(strM1170p, "Encoding format is not supported", e);
                    }
                } else {
                    if (strArrSplit.length == 1) {
                        try {
                            strUrlFormDecode = StringExtensions.urlFormDecode(strArrSplit[0].trim());
                            strUrlFormDecode2 = "";
                        } catch (UnsupportedEncodingException e2) {
                            Logger.errorPII(strM1170p, "Encoding format is not supported", e2);
                        }
                    } else {
                        strUrlFormDecode = null;
                        strUrlFormDecode2 = null;
                    }
                    if (StringExtensions.isNullOrBlank(strUrlFormDecode)) {
                    }
                }
            }
        }
        return map;
    }
}
