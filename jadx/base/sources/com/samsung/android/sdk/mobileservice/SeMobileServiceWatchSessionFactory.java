package com.samsung.android.sdk.mobileservice;

import android.content.Context;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.util.SdkLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SeMobileServiceWatchSessionFactory extends SeMobileServiceSessionFactory {
    private static final String TAG = "SeMobileServiceWatchSessionFactory";

    public SeMobileServiceWatchSessionFactory(Context context, SeMobileServiceSession.ConnectionResultCallback connectionResultCallback) {
        super(context, connectionResultCallback);
        this.mServiceList.remove("AuthService");
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSessionFactory
    public SeMobileServiceSession build() {
        Context context = this.mCtx;
        if (context == null) {
            SdkLog.m5782d(TAG, "context is null");
            return null;
        }
        SeMobileServiceWatchSessionImpl seMobileServiceWatchSessionImpl = new SeMobileServiceWatchSessionImpl(context, this.mServiceList, this.mAppId, this.mConnectionResultCallback);
        SdkLog.m5782d(TAG, "build " + this.mServiceList.toString());
        return seMobileServiceWatchSessionImpl;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSessionFactory
    public SeMobileServiceWatchSessionFactory addService(String str) {
        if ("SocialService".equals(str)) {
            this.mServiceList.add(str);
            return this;
        }
        SdkLog.m5784i(TAG, "support only SocialApi - not support " + str);
        return this;
    }
}
