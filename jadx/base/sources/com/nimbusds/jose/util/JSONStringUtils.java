package com.nimbusds.jose.util;

import com.nimbusds.jose.shaded.gson.Gson;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JSONStringUtils {
    private JSONStringUtils() {
    }

    public static String toJSONString(String str) {
        return new Gson().toJson(str);
    }
}
