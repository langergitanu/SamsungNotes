package com.samsung.android.support.senl.p148nt.coedit.control.networkutils;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCloudHttpClient {
    private final HttpRequestUtil mHttpRequestUtil = new HttpRequestUrlUtil();

    public SCloudHttpResponse get(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        return this.mHttpRequestUtil.get(str, map, map2, str2);
    }

    public SCloudHttpResponse post(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        return this.mHttpRequestUtil.post(str, map, map2, str2);
    }

    public SCloudHttpResponse put(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        return this.mHttpRequestUtil.put(str, map, map2, str2);
    }
}
