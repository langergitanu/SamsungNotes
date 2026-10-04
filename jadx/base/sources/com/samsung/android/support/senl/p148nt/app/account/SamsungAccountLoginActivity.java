package com.samsung.android.support.senl.p148nt.app.account;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import com.samsung.android.support.senl.p145cm.base.region.RegionUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SamsungAccountLoginActivity extends Activity {
    private static final String SAMSUNG_ACCOUNT_URL_SERVER = RegionUtils.getAccountServerURL();
    private static final String TAG = "SA/SamsungAccountLoginActivity";
    protected static final String TRUE = "true";
    protected boolean mIsGetToken = false;
    protected WebView webView;

    public String getLoginUri() {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.getDefault();
        sb.append(SAMSUNG_ACCOUNT_URL_SERVER);
        sb.append("/mobile/account/check.do?accessToken=Y&serviceID=");
        sb.append(CommonUtils.getAppServiceId());
        sb.append("&actionID=StartOAuth2&countryCode=");
        sb.append(locale.getCountry());
        sb.append("&languageCode=");
        sb.append(locale.getLanguage());
        return sb.toString();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.sync_weblogin);
        ((Button) findViewById(C8003R.id.sync_weblogin_close)).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.account.SamsungAccountLoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SamsungAccountLoginActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Debugger.m8615i(TAG, "[SA] onDestroy()");
        if (!this.mIsGetToken) {
            Debugger.m8615i(TAG, "User cancel to log in!");
        }
        WebView webView = this.webView;
        if (webView != null) {
            try {
                webView.setWebViewClient(null);
                this.webView.setWebChromeClient(null);
                this.webView.clearHistory();
                this.webView.clearCache(true);
                this.webView.destroy();
                this.webView = null;
            } catch (Exception e) {
                AbstractC0000a.m22s("[SA] onDestroy() : fail to clear webView, ", e, TAG);
            }
        }
        super.onDestroy();
    }
}
