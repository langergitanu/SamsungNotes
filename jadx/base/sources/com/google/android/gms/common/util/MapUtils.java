package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(@NonNull StringBuilder sb, @NonNull HashMap<String, String> map) {
        sb.append(Parse.BRACKET_LCB);
        boolean z = true;
        for (String str : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str2 = map.get(str);
            AbstractC1974b.m1332y(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                AbstractC1974b.m1332y(sb, "\"", str2, "\"");
            }
            z = false;
        }
        sb.append("}");
    }
}
