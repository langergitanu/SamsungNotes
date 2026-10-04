package com.microsoft.identity.common.java.jwt;

import com.google.gson.Gson;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.nio.charset.Charset;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtUtils {
    private static final String TAG = "JwtUtils";

    private JwtUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String generateJWT(@NonNull JwtRequestHeader jwtRequestHeader, @NonNull JwtRequestBody jwtRequestBody) {
        if (jwtRequestHeader == null) {
            throw new NullPointerException("header is marked non-null but is null");
        }
        if (jwtRequestBody == null) {
            throw new NullPointerException("body is marked non-null but is null");
        }
        Logger.verbose(TAG + ":generateJWT", "Generating JWT.");
        String json = new Gson().toJson(jwtRequestHeader);
        String json2 = new Gson().toJson(jwtRequestBody);
        StringBuilder sb = new StringBuilder();
        Charset charset = AuthenticationConstants.ENCODING_UTF8;
        sb.append(StringUtil.encodeUrlSafeString(json.getBytes(charset)));
        sb.append(Extension.DOT);
        sb.append(StringUtil.encodeUrlSafeString(json2.getBytes(charset)));
        return sb.toString();
    }
}
