package com.microsoft.identity.common.java.util;

import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UrlUtil {
    private static final String TAG = "UrlUtil";

    public static URL appendPathAndQueryToURL(@NonNull URL url, @Nullable String str, @Nullable String str2) {
        if (url == null) {
            throw new NullPointerException("urlToAppend is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            return url;
        }
        CommonURIBuilder commonURIBuilder = new CommonURIBuilder();
        commonURIBuilder.setPath(str);
        List<String> pathSegments = commonURIBuilder.getPathSegments();
        CommonURIBuilder commonURIBuilder2 = new CommonURIBuilder(url.toString());
        ArrayList arrayList = new ArrayList(commonURIBuilder2.getPathSegments());
        if (arrayList.size() > 0) {
            int size = arrayList.size() - 1;
            if (((String) arrayList.get(size)).equals("") && !commonURIBuilder.isPathEmpty()) {
                arrayList.remove(size);
            }
        }
        for (String str3 : pathSegments) {
            if (!StringUtil.isNullOrEmpty(str3)) {
                arrayList.add(str3);
            }
        }
        commonURIBuilder2.setPathSegments(arrayList);
        if (str2 != null && !str2.isEmpty()) {
            commonURIBuilder2.setQuery(str2);
        }
        return commonURIBuilder2.build().toURL();
    }

    public static URL appendPathToURL(@NonNull URL url, @Nullable String str) {
        if (url != null) {
            return appendPathAndQueryToURL(url, str, null);
        }
        throw new NullPointerException("urlToAppend is marked non-null but is null");
    }

    @NonNull
    public static Map<String, String> getParameters(@Nullable String str) throws ClientException {
        if (StringUtil.isNullOrEmpty(str)) {
            Logger.warn(TAG, "url string is null.");
            return Collections.EMPTY_MAP;
        }
        try {
            return getParameters(new URI(str));
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", "Cannot extract parameter from a malformed URL string.", e);
        }
    }

    public static URL makeUrlSilent(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String removeTrailingSlash(@NonNull String str) {
        if (str != null) {
            return str.replaceFirst("/*$", "");
        }
        throw new NullPointerException("urlString is marked non-null but is null");
    }

    @NonNull
    public static Map<String, String> urlFormDecode(@NonNull String str) {
        if (str != null) {
            return urlFormDecodeData(str, MsalUtils.QUERY_STRING_DELIMITER);
        }
        throw new NullPointerException("urlParameter is marked non-null but is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0014 A[SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> urlFormDecodeData(@NonNull String str, @NonNull String str2) {
        String strUrlFormDecode;
        String strUrlFormDecode2;
        if (str == null) {
            throw new NullPointerException("urlParameter is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("delimiter is marked non-null but is null");
        }
        HashMap map = new HashMap();
        if (!StringUtil.isNullOrEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                String[] strArrSplit = stringTokenizer.nextToken().split(MarketingConstants.REFERRER_DELIMITER_U003D, 2);
                if (strArrSplit.length == 2) {
                    try {
                        strUrlFormDecode = StringUtil.urlFormDecode(strArrSplit[0].trim());
                        strUrlFormDecode2 = StringUtil.urlFormDecode(strArrSplit[1].trim());
                        if (StringUtil.isNullOrEmpty(strUrlFormDecode)) {
                            map.put(strUrlFormDecode, strUrlFormDecode2);
                        }
                    } catch (UnsupportedEncodingException e) {
                        Logger.errorPII(TAG + ":urlFormDecodeData", "Encoding format is not supported", e);
                    }
                } else {
                    if (strArrSplit.length == 1) {
                        try {
                            strUrlFormDecode = StringUtil.urlFormDecode(strArrSplit[0].trim());
                            strUrlFormDecode2 = "";
                        } catch (UnsupportedEncodingException e2) {
                            Logger.errorPII(TAG + ":urlFormDecodeData", "Encoding format is not supported", e2);
                        }
                    } else {
                        strUrlFormDecode = null;
                        strUrlFormDecode2 = null;
                    }
                    if (StringUtil.isNullOrEmpty(strUrlFormDecode)) {
                    }
                }
            }
        }
        return map;
    }

    @NonNull
    public static Map<String, String> getParameters(@Nullable URI uri) {
        if (uri == null) {
            Logger.warn(TAG, "uri is null.");
            return Collections.EMPTY_MAP;
        }
        if (uri.isOpaque()) {
            try {
                return getParameters(new URI("scheme://" + uri.toString()));
            } catch (URISyntaxException unused) {
                Logger.warn(TAG, "Cannot convert opaque URI.");
                return Collections.EMPTY_MAP;
            }
        }
        String fragment = uri.getFragment();
        if (!StringUtil.isNullOrEmpty(fragment) && !urlFormDecode(fragment).isEmpty()) {
            String str = TAG;
            Logger.warn(str, "Received url contains unexpected fragment parameters.");
            Logger.warnPII(str, "Unexpected fragment: " + uri.getFragment());
        }
        if (StringUtil.isNullOrEmpty(uri.getQuery())) {
            Logger.info(TAG + ":getUrlParameters", "URL does not contain query parameter");
            return Collections.EMPTY_MAP;
        }
        return urlFormDecode(uri.getRawQuery());
    }
}
