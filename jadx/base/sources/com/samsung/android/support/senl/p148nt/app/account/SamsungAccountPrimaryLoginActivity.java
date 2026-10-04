package com.samsung.android.support.senl.p148nt.app.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.auth.AuthConstants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SamsungAccountPrimaryLoginActivity extends SamsungAccountLoginActivity {
    private static final String TAG = "SA/SamsungAccountPrimaryLoginActivity";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LoginWebViewClient extends WebViewClient {
        public LoginWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Debugger.m8616s(SamsungAccountPrimaryLoginActivity.TAG, str);
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter("access_token");
            String queryParameter2 = uri.getQueryParameter("close");
            if (str.contains("signInSuccessOAuth2") && queryParameter != null) {
                String queryParameter3 = uri.getQueryParameter(SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID);
                String queryParameter4 = uri.getQueryParameter("access_token_expires_in");
                String queryParameter5 = uri.getQueryParameter("refresh_token");
                String queryParameter6 = uri.getQueryParameter("refresh_token_expires_in");
                uri.getQueryParameter(AuthConstants.EXTRA_API_SERVER_URL);
                String queryParameter7 = uri.getQueryParameter(AuthConstants.EXTRA_AUTH_SERVER_URL);
                String queryParameter8 = uri.getQueryParameter("inputEmailID");
                Debugger.m8616s(SamsungAccountPrimaryLoginActivity.TAG, "uri = " + uri);
                StringBuilder sb = new StringBuilder("uid = ");
                sb.append(queryParameter3);
                AbstractC2821a.m2207B(sb, " expire = ", queryParameter4, " inputEmailID = ", queryParameter8);
                sb.append(" ");
                sb.append(queryParameter7);
                Debugger.m8616s(SamsungAccountPrimaryLoginActivity.TAG, sb.toString());
                Debugger.m8616s(SamsungAccountPrimaryLoginActivity.TAG, "refreshToken = " + queryParameter5 + " expire = " + queryParameter6);
                SamsungAccountPrimaryLoginActivity.this.setResult(-1, new Intent());
                C13541h c13541hM14287e = C13541h.m14287e();
                if (queryParameter4 != null) {
                    Long.decode(queryParameter4).longValue();
                }
                if (queryParameter6 != null) {
                    Long.decode(queryParameter6).longValue();
                }
                c13541hM14287e.getClass();
                Debugger.m8609e("SAccountManager", "[SA] onAuthInfoReceived() : Not supported yet!");
                SamsungAccountPrimaryLoginActivity.this.mIsGetToken = true;
            }
            if ("true".equals(queryParameter2)) {
                SamsungAccountPrimaryLoginActivity samsungAccountPrimaryLoginActivity = SamsungAccountPrimaryLoginActivity.this;
                if (!samsungAccountPrimaryLoginActivity.mIsGetToken) {
                    samsungAccountPrimaryLoginActivity.setResult(0, new Intent());
                    Debugger.m8609e(SamsungAccountPrimaryLoginActivity.TAG, "fail to log in : error_code = " + uri.getQueryParameter("error_code") + ", error_description = " + (uri.getQueryParameter("error") + uri.getQueryParameter("error_description")));
                }
                SamsungAccountPrimaryLoginActivity.this.finish();
            }
            super.onPageFinished(webView, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = (WebView) findViewById(C8003R.id.sync_weblogin_webview);
        this.webView = webView;
        webView.setWebViewClient(new LoginWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setHorizontalScrollBarEnabled(true);
        this.webView.loadUrl(getLoginUri());
    }
}
