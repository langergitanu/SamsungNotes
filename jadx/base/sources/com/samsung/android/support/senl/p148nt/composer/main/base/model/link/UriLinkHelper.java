package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.net.Uri;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UriLinkHelper {
    public static Uri makeMapUrl(String str) {
        return Uri.parse("geo:0,0?q=" + str);
    }

    public static String makeUrl(String str) {
        return makeUrl(str, new String[]{WebConstants.HTTP_PROTOCOL, "https://", "rtsp://"});
    }

    public static String makeUrl(String str, String[] strArr) {
        boolean z;
        if (str == null) {
            return str;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            String str2 = strArr[i];
            String str3 = str;
            if (str3.regionMatches(true, 0, str2, 0, str2.length())) {
                String str4 = strArr[i];
                z = true;
                if (str3.regionMatches(false, 0, str4, 0, str4.length())) {
                    str = str3;
                } else {
                    str = strArr[i] + str3.substring(strArr[i].length());
                }
            } else {
                i++;
                str = str3;
            }
        }
        if (z) {
            return str;
        }
        return AbstractC0622a.m1170p(strArr[0], str, new StringBuilder());
    }
}
