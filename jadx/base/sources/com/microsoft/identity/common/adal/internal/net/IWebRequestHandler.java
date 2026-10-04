package com.microsoft.identity.common.adal.internal.net;

import java.net.URL;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IWebRequestHandler {
    HttpWebResponse sendGet(URL url, Map<String, String> map);

    HttpWebResponse sendPost(URL url, Map<String, String> map, byte[] bArr, String str);

    void setClientVersion(String str);

    void setRequestCorrelationId(UUID uuid);
}
