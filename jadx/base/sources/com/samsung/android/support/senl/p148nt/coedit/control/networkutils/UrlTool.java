package com.samsung.android.support.senl.p148nt.coedit.control.networkutils;

import android.text.TextUtils;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UrlTool {
    private static final String TAG = "UrlTool";

    public static void addUrlParameter(StringBuilder sb, String str, String str2, boolean z) {
        try {
            String string = StandardCharsets.UTF_8.toString();
            if (z) {
                if (TextUtils.isEmpty(str2)) {
                    sb.append(URLEncoder.encode(str, string));
                    sb.append('=');
                    return;
                } else {
                    sb.append(URLEncoder.encode(str, string));
                    sb.append('=');
                    sb.append(URLEncoder.encode(str2, string));
                    return;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                sb.append(Typography.amp);
                sb.append(URLEncoder.encode(str, string));
                sb.append('=');
            } else {
                sb.append(Typography.amp);
                sb.append(URLEncoder.encode(str, string));
                sb.append('=');
                sb.append(URLEncoder.encode(str2, string));
            }
        } catch (NullPointerException e) {
            CoeditLogger.m8920e(TAG, "NullPointerException : addUrlParameter - key : " + str + ", value : " + str2);
            throw e;
        }
    }

    public static String addUrlParameters(String str, Map<String, String> map) {
        if (map == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains(MsalUtils.QUERY_STRING_SYMBOL)) {
            sb.append('?');
        }
        boolean zEndsWith = sb.toString().endsWith(MsalUtils.QUERY_STRING_DELIMITER);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            addUrlParameter(sb, entry.getKey(), entry.getValue(), zEndsWith);
            zEndsWith = false;
        }
        return sb.toString();
    }
}
