package com.microsoft.identity.common.adal.internal.net;

import android.os.Build;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WebRequestHandler implements IWebRequestHandler {
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_JSON = "application/json";
    private UUID mRequestCorrelationId = null;
    private String mCurrentClientVersion = "";

    private Map<String, String> updateHeaders(Map<String, String> map) {
        UUID uuid = this.mRequestCorrelationId;
        if (uuid != null) {
            map.put("client-request-id", uuid.toString());
        }
        map.put("x-client-SKU", AuthenticationConstants.AAD.ADAL_ID_PLATFORM_VALUE);
        map.put("x-client-Ver", this.mCurrentClientVersion);
        map.put("x-client-OS", "" + Build.VERSION.SDK_INT);
        map.put("x-client-DM", Build.MODEL);
        return map;
    }

    @Override // com.microsoft.identity.common.adal.internal.net.IWebRequestHandler
    public HttpWebResponse sendGet(URL url, Map<String, String> map) {
        return new HttpWebRequest(url, "GET", updateHeaders(map)).send();
    }

    @Override // com.microsoft.identity.common.adal.internal.net.IWebRequestHandler
    public HttpWebResponse sendPost(URL url, Map<String, String> map, byte[] bArr, String str) {
        return new HttpWebRequest(url, "POST", updateHeaders(map), bArr, str).send();
    }

    @Override // com.microsoft.identity.common.adal.internal.net.IWebRequestHandler
    public void setClientVersion(String str) {
        if (StringExtensions.isNullOrBlank(str)) {
            return;
        }
        this.mCurrentClientVersion = str;
    }

    @Override // com.microsoft.identity.common.adal.internal.net.IWebRequestHandler
    public void setRequestCorrelationId(UUID uuid) {
        this.mRequestCorrelationId = uuid;
    }
}
