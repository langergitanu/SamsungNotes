package com.microsoft.identity.common.internal.p131ui.webview.challengehandlers;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ChallengeFactory {
    public static NtlmChallenge getNtlmChallenge(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        return new NtlmChallenge(webView, httpAuthHandler, str, str2);
    }
}
