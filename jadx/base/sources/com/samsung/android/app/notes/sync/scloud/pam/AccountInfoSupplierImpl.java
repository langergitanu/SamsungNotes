package com.samsung.android.app.notes.sync.scloud.pam;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.scsp.framework.core.Scsp;
import com.samsung.scsp.framework.core.identity.AccountInfoSupplier;
import p001A.AbstractC0000a;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AccountInfoSupplierImpl implements AccountInfoSupplier {
    private static final String TAG = "AccountInfoSupplierImpl";
    private String mAccessToken = null;
    private String mUserId = null;
    IAuthInfoReqListener mAuthInfoReqListener = new IAuthInfoReqListener() { // from class: com.samsung.android.app.notes.sync.scloud.pam.AccountInfoSupplierImpl.1
        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
        public void onError(String str, String str2) {
            Debugger.m8609e(AccountInfoSupplierImpl.TAG, "[PAM] onFailed() : errorCode = " + str + ", errMsg = " + str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
        public void onReceived(String str, String str2) {
            AccountInfoSupplierImpl.this.setAccountInfo(str, str2);
            Debugger.m8615i(AccountInfoSupplierImpl.TAG, "[PAM] onReceived() : call refreshToken()");
            new SenlThreadFactory("PamAccountInfoThread1").newThread(new Runnable() { // from class: com.samsung.android.app.notes.sync.scloud.pam.AccountInfoSupplierImpl.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Scsp.refreshToken();
                    } catch (Exception e) {
                        AbstractC0000a.m22s("[PAM] onReceived() : ", e, AccountInfoSupplierImpl.TAG);
                    }
                }
            }).start();
        }
    };

    private void requestAccessToken() {
        Debugger.m8615i(TAG, "[PAM] requestAccessToken()");
        C13541h.m14287e().m14295i(this.mAuthInfoReqListener);
    }

    @Override // com.samsung.scsp.framework.core.identity.AccountInfoSupplier
    public String getAccessToken() {
        if (TextUtils.isEmpty(this.mAccessToken)) {
            Debugger.m8609e(TAG, "[PAM] getAccessToken() : accessToken is empty!");
        } else {
            Debugger.m8615i(TAG, "[PAM] getAccessToken()");
        }
        return this.mAccessToken;
    }

    @Override // com.samsung.scsp.framework.core.identity.AccountInfoSupplier
    public String getUserId() {
        if (TextUtils.isEmpty(this.mUserId)) {
            Debugger.m8609e(TAG, "[PAM] getUserId() : userId is empty!");
        }
        return this.mUserId;
    }

    @Override // com.samsung.scsp.framework.core.identity.AccountInfoSupplier
    public void onUnauthorized() {
        if (TextUtils.isEmpty(this.mAccessToken) || TextUtils.isEmpty(this.mUserId)) {
            Debugger.m8609e(TAG, "[PAM] onUnauthorized() : invalid access token or guid");
        } else {
            Debugger.m8615i(TAG, "[PAM] onUnauthorized()");
        }
    }

    public void requestAccessTokenWithExpiredTokenToSamsungAccount() {
        Debugger.m8615i(TAG, "[PAM] requestAccessTokenWithExpiredTokenToSamsungAccount()");
        requestAccessToken();
    }

    public void setAccountInfo(String str, String str2) {
        Debugger.m8615i(TAG, "[PAM] setAccountInfo()");
        this.mAccessToken = str;
        this.mUserId = str2;
    }
}
