package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HashMapExtensions {
    public static HashMap<String, String> getJsonResponse(HttpResponse httpResponse) {
        return (httpResponse == null || StringUtil.isNullOrEmpty(httpResponse.getBody())) ? new HashMap<>() : getJsonResponseFromResponseBody(httpResponse.getBody());
    }

    public static HashMap<String, String> getJsonResponseFromResponseBody(String str) {
        HashMap<String, String> map = new HashMap<>();
        SpanExtension.current().setAttribute(AttributeName.response_body_length.name(), str.length());
        if (!StringUtil.isNullOrEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next).toString());
            }
        }
        return map;
    }
}
