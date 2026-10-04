package com.samsung.android.support.senl.p148nt.app.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SamsungAccountLoginForLockActivity extends SamsungAccountLoginActivity {
    public static final String ERROR_FLAG_NAME = "error_flag";
    public static final int ERROR_NETWORK_ERROR_CODE_FLAG = 1;
    public static final int ERROR_NO_ERROR_CODE_FLAG = 0;
    public static final String SAMSUNG_ACCOUNT_USER_ID = "userId";
    private static final String TAG = "SA/SamsungAccountLoginForLockActivity";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LoginWebViewClient extends WebViewClient {
        public LoginWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Debugger.m8616s(SamsungAccountLoginForLockActivity.TAG, str);
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter("access_token");
            String queryParameter2 = uri.getQueryParameter("close");
            if (str.contains("signInSuccessOAuth2") && queryParameter != null) {
                String queryParameter3 = uri.getQueryParameter(SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID);
                Debugger.m8615i(SamsungAccountLoginForLockActivity.TAG, "[SA] userId = " + Debugger.pii(queryParameter3));
                Intent intent = new Intent();
                intent.putExtra(SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, queryParameter3);
                SamsungAccountLoginForLockActivity.this.setResult(-1, intent);
                SamsungAccountLoginForLockActivity.this.mIsGetToken = true;
            }
            if ("true".equals(queryParameter2)) {
                SamsungAccountLoginForLockActivity samsungAccountLoginForLockActivity = SamsungAccountLoginForLockActivity.this;
                if (!samsungAccountLoginForLockActivity.mIsGetToken) {
                    samsungAccountLoginForLockActivity.setResult(0, new Intent());
                    Debugger.m8609e(SamsungAccountLoginForLockActivity.TAG, "[SA] fail to log in : error_code = " + uri.getQueryParameter("error_code") + ", error_description = " + (uri.getQueryParameter("error") + uri.getQueryParameter("error_description")));
                }
                SamsungAccountLoginForLockActivity.this.finish();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url = webResourceRequest.getUrl();
            String queryParameter = url.getQueryParameter("closedAction");
            if (queryParameter == null || !url.toString().contains("signInSuccessOAuth2") || !queryParameter.equals("signInSuccess")) {
                return false;
            }
            Debugger.m8616s(SamsungAccountLoginForLockActivity.TAG, "shouldOverrideUrlLoading : signInSuccess");
            ((ViewGroup) SamsungAccountLoginForLockActivity.this.findViewById(C8003R.id.sync_weblogin_layout)).setVisibility(4);
            return false;
        }
    }

    private boolean handleNetworkState() {
        if (C0145c.m334s(this)) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra(ERROR_FLAG_NAME, 1);
        setResult(0, intent);
        ToastHandler.show(this, C8003R.string.network_error_check_your_network_connection_and_try_again, 0);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!handleNetworkState()) {
            Debugger.m8609e(TAG, "[SA] onCreate() : No network connection!");
            finish();
            return;
        }
        ((ViewGroup) findViewById(C8003R.id.sync_weblogin_layout)).setVisibility(0);
        WebView webView = (WebView) findViewById(C8003R.id.sync_weblogin_webview);
        this.webView = webView;
        webView.setWebViewClient(new LoginWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setHorizontalScrollBarEnabled(true);
        this.webView.loadUrl(getLoginUri());
    }
}
