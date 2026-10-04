package com.samsung.android.kmxservice.sdk.e2ee.common;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxExceptionMessageFactory {
    private static final String FORMAT = "[%s] %s: %s";
    private static final Map<Integer, String> TAGS;

    static {
        HashMap map = new HashMap();
        TAGS = map;
        AbstractC6670b.m4751l(1, map, "KMX_ERROR", 2, "KMX_CONNECTION_ERROR");
        AbstractC6670b.m4751l(3, map, "FAIL_GET_SAK_UID", 4, "INPUT_ERROR");
        AbstractC6670b.m4751l(5, map, "FAIL_CHECK_DEVICE_INTEGRITY", 101, "FAIL_IMPORT_KEY");
        AbstractC6670b.m4751l(102, map, "FAIL_EXPORT_KEY", 103, "FAIL_GENERATE_KEY");
        AbstractC6670b.m4751l(104, map, "FAIL_REMOVE_KEY", 105, "KEY_DOES_NOT_EXIST");
        AbstractC6670b.m4751l(106, map, "FABRIC_KEYSTORE_ERROR", 201, "FAIL_ENCRYPT_DATA");
        AbstractC6670b.m4751l(202, map, "FAIL_DECRYPT_DATA", 203, "FAIL_GET_DATA");
        AbstractC6670b.m4751l(204, map, "FAIL_SET_DATA", 301, "INVALID_FABRIC_ID");
        AbstractC6670b.m4751l(302, map, "INVALID_FABRIC_KEY_ID", 303, "INVALID_SAK_UID");
        AbstractC6670b.m4751l(304, map, "INVALID_SERVICE_ID", 305, "INVALID_SERVICE_KEY_ID");
        AbstractC6670b.m4751l(306, map, "INVALID_MEMBER_KEY_ID", 401, "INVALID_CERTIFICATE");
        AbstractC6670b.m4751l(402, map, "INVALID_SIGNATURE", 403, "INVALID_RECOVERY_DATA");
        AbstractC6670b.m4751l(404, map, "INVALID_PACKAGE", 6, "TA_ERROR");
        map.put(250, "KEYSTORE_TOO_MANY_OPERATIONS");
    }

    public static String get(String str, int i) {
        String str2 = TAGS.get(Integer.valueOf(i));
        if (str2 == null) {
            str2 = "Unknown Exception";
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("[", str2, "] ", str, ": ");
        sbM16m.append(i);
        return sbM16m.toString();
    }
}
