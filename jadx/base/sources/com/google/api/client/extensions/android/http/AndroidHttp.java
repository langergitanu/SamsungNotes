package com.google.api.client.extensions.android.http;

import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class AndroidHttp {
    private AndroidHttp() {
    }

    public static HttpTransport newCompatibleTransport() {
        return AndroidUtils.isMinimumSdkLevel(9) ? new NetHttpTransport() : new ApacheHttpTransport();
    }
}
