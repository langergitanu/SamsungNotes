package com.microsoft.identity.common.internal.p131ui.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.ChallengeFactory;
import com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.NtlmChallengeHandler;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.logging.Logger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class OAuth2WebViewClient extends WebViewClient {
    private static final String TAG = "OAuth2WebViewClient";

    @SuppressFBWarnings(justification = "This is only exposed in testing", value = {"MS_SHOULD_BE_FINAL"})
    @VisibleForTesting
    public static ExpectedPage mExpectedPage;
    private final Activity mActivity;
    private final IAuthorizationCompletionCallback mCompletionCallback;
    private final OnPageLoadedCallback mPageLoadedCallback;

    public OAuth2WebViewClient(@NonNull Activity activity, @NonNull IAuthorizationCompletionCallback iAuthorizationCompletionCallback, @NonNull OnPageLoadedCallback onPageLoadedCallback) {
        this.mActivity = activity;
        this.mCompletionCallback = iAuthorizationCompletionCallback;
        this.mPageLoadedCallback = onPageLoadedCallback;
    }

    private void checkStartUrl(String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":checkStartUrl", new StringBuilder());
        if (StringUtil.isEmpty(str)) {
            Logger.info(strM1170p, "onPageStarted: Null url for page to load.");
            return;
        }
        Uri uri = Uri.parse(str);
        if (uri.isOpaque()) {
            Logger.info(strM1170p, "onPageStarted: Non-hierarchical loading uri.");
            Logger.infoPII(strM1170p, "start url: " + str);
            return;
        }
        if (StringUtil.isEmpty(uri.getQueryParameter("code"))) {
            Logger.info(strM1170p, "onPageStarted: URI has no auth code ('code') query parameter.");
            Logger.infoPII(strM1170p, "Scheme:" + uri.getScheme() + " Host: " + uri.getHost() + " Path: " + uri.getPath());
            return;
        }
        Logger.info(strM1170p, "Auth code is returned for the loading url.");
        Logger.infoPII(strM1170p, "Scheme:" + uri.getScheme() + " Host: " + uri.getHost() + " Path: " + uri.getPath());
    }

    private void sendErrorToCallback(@NonNull WebView webView, int i, @NonNull String str) {
        webView.stopLoading();
        this.mCompletionCallback.onChallengeResponseReceived(RawAuthorizationResult.fromException(new ClientException(AbstractC0000a.m11h(i, "Code:"), str)));
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public IAuthorizationCompletionCallback getCompletionCallback() {
        return this.mCompletionCallback;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.mPageLoadedCallback.onPageLoaded(str);
        ExpectedPage expectedPage = mExpectedPage;
        if (expectedPage != null && str.startsWith(expectedPage.mExpectedPageUrlStartsWith)) {
            mExpectedPage.mCallback.onPageLoaded(str);
        }
        webView.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onPageStarted", new StringBuilder());
        checkStartUrl(str);
        Logger.info(strM1170p, "WebView starts loading.");
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        sendErrorToCallback(webView, i, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        String str3 = TAG + ":onReceivedHttpAuthRequest";
        Logger.info(str3, "Receive the http auth request. Start the dialog to ask for creds. ");
        Logger.infoPII(str3, "Host:" + str);
        new NtlmChallengeHandler(this.mActivity, this.mCompletionCallback).processChallenge(ChallengeFactory.getNtlmChallenge(webView, httpAuthHandler, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        sslErrorHandler.cancel();
        Logger.error(TAG + ":onReceivedSslError", "Received SSL Error during request. For more info see: https://go.microsoft.com/fwlink/?linkid=2138180", null);
        this.mCompletionCallback.onChallengeResponseReceived(RawAuthorizationResult.fromException(new ClientException("Code:-11", sslError.toString())));
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onReceivedError", new StringBuilder());
        Logger.warn(strM1170p, "WebResourceError - isForMainFrame? " + webResourceRequest.isForMainFrame());
        Logger.warnPII(strM1170p, "Failing url: " + webResourceRequest.getUrl());
        if (webResourceRequest.isForMainFrame()) {
            sendErrorToCallback(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString());
        }
    }
}
