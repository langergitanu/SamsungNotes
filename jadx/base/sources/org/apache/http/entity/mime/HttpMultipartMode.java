package org.apache.http.entity.mime;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum HttpMultipartMode {
    STRICT,
    BROWSER_COMPATIBLE,
    RFC6532;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static HttpMultipartMode[] valuesCustom() {
        HttpMultipartMode[] httpMultipartModeArrValuesCustom = values();
        int length = httpMultipartModeArrValuesCustom.length;
        HttpMultipartMode[] httpMultipartModeArr = new HttpMultipartMode[length];
        System.arraycopy(httpMultipartModeArrValuesCustom, 0, httpMultipartModeArr, 0, length);
        return httpMultipartModeArr;
    }
}
