package com.microsoft.identity.common.java.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderSerializationUtil {
    public static HashMap<String, List<String>> fromJson(@NonNull String str) {
        if (str != null) {
            return (HashMap) new Gson().fromJson(str, TypeToken.getParameterized(HashMap.class, String.class, TypeToken.getParameterized(List.class, String.class).getRawType()).getType());
        }
        throw new NullPointerException("jsonIn is marked non-null but is null");
    }

    public static String toJson(@NonNull Map<String, List<String>> map) {
        if (map != null) {
            return new Gson().toJson(map);
        }
        throw new NullPointerException("headersIn is marked non-null but is null");
    }
}
