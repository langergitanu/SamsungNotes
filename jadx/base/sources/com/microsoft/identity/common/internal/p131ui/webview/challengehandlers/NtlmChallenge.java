package com.microsoft.identity.common.internal.p131ui.webview.challengehandlers;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NtlmChallenge {
    private HttpAuthHandler mHandler;
    private String mHost;
    private String mRealm;
    private WebView mView;

    public NtlmChallenge(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mHandler = httpAuthHandler;
        this.mView = webView;
        this.mHost = str;
        this.mRealm = str2;
    }

    public HttpAuthHandler getHandler() {
        return this.mHandler;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getRealm() {
        return this.mRealm;
    }

    public WebView getView() {
        return this.mView;
    }
}
