package com.microsoft.identity.common.internal.p131ui.webview.challengehandlers;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.challengehandlers.PKeyAuthChallenge;
import com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.logging.Logger;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class PKeyAuthChallengeHandler implements IChallengeHandler<PKeyAuthChallenge, Void> {
    private static final String TAG = "PKeyAuthChallengeHandler";
    private final IAuthorizationCompletionCallback mChallengeCallback;
    private final WebView mWebView;

    public PKeyAuthChallengeHandler(@NonNull WebView webView, @NonNull IAuthorizationCompletionCallback iAuthorizationCompletionCallback) {
        this.mWebView = webView;
        this.mChallengeCallback = iAuthorizationCompletionCallback;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(final PKeyAuthChallenge pKeyAuthChallenge) {
        boolean z;
        Error error;
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":processChallenge", new StringBuilder());
        this.mWebView.stopLoading();
        this.mChallengeCallback.setPKeyAuthStatus(true);
        try {
            final Map<String, String> challengeHeader = pKeyAuthChallenge.getChallengeHeader();
            this.mWebView.post(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    String submitUrl = pKeyAuthChallenge.getSubmitUrl();
                    Logger.info(strM1170p, "Respond to pkeyAuth challenge");
                    Logger.infoPII(strM1170p, "Challenge submit url:" + pKeyAuthChallenge.getSubmitUrl());
                    PKeyAuthChallengeHandler.this.mWebView.loadUrl(submitUrl, challengeHeader);
                }
            });
            return null;
        } finally {
            if (!z) {
            }
        }
    }
}
