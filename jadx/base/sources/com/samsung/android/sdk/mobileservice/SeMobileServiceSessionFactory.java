package com.samsung.android.sdk.mobileservice;

import android.content.Context;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.CommonUtils;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SeMobileServiceSessionFactory {
    private static final String TAG = "SeMobileServiceSessionFactory";
    protected String mAppId;
    protected SeMobileServiceSession.ConnectionResultCallback mConnectionResultCallback;
    protected Context mCtx;
    protected HashSet<String> mServiceList;

    public SeMobileServiceSessionFactory(Context context, SeMobileServiceSession.ConnectionResultCallback connectionResultCallback) {
        HashSet<String> hashSet = new HashSet<>();
        this.mServiceList = hashSet;
        this.mCtx = context;
        this.mConnectionResultCallback = connectionResultCallback;
        hashSet.clear();
        this.mServiceList.add("AuthService");
        if (context != null) {
            if (CommonUtils.isStandAloneSamsungAccountSupported(context) && SeMobileService.isAgentInstalled(context) && SeMobileService.isAgentEnabled(context)) {
                this.mServiceList.add("SocialService");
            }
            String metaData = CommonUtils.getMetaData(context, context.getPackageName(), CommonConstants.META_DATA_APP_ID);
            this.mAppId = metaData == null ? CommonUtils.getMetaData(context, context.getPackageName(), CommonConstants.META_DATA_ACCOUNT_APP_ID) : metaData;
        }
    }

    public SeMobileServiceSessionFactory addService(String str) {
        this.mServiceList.add(str);
        return this;
    }

    public SeMobileServiceSession build() {
        Context context = this.mCtx;
        if (context == null) {
            SdkLog.m5782d(TAG, "context is null");
            return null;
        }
        SeMobileServiceSessionImpl seMobileServiceSessionImpl = new SeMobileServiceSessionImpl(context, this.mServiceList, this.mAppId, this.mConnectionResultCallback);
        SdkLog.m5782d(TAG, "build " + this.mServiceList.toString());
        return seMobileServiceSessionImpl;
    }

    public SeMobileServiceSessionFactory setAppId(String str) {
        SdkLog.m5782d(TAG, "set " + str + " in factory");
        this.mAppId = str;
        return this;
    }
}
