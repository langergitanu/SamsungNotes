package com.sec.android.diagmonagent.log.provider;

import android.content.Context;
import android.util.Log;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiagMonConfig {
    private Context mContext;
    private String mServiceVer;
    private oldDiagMonConfig oldConf;
    private String mServiceId = "";
    private String mAgreeAsString = "";
    private String mDeviceId = "";
    private String mTrackingId = "";
    private boolean mAgreement = false;
    public boolean serviceNetworkMode = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class oldDiagMonConfig {
        private boolean mAgreement = false;
        private String mAgreeAsString = "";

        public oldDiagMonConfig() {
        }

        public boolean getAgree() {
            return this.mAgreement;
        }

        public String getAgreeAsString() {
            return this.mAgreeAsString;
        }

        public void setAgree(String str) {
            this.mAgreeAsString = str;
            if ("S".equals(str)) {
                this.mAgreeAsString = DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY;
            }
            if (this.mAgreeAsString.isEmpty()) {
                Log.w(DiagMonUtil.TAG, "Empty agreement");
                this.mAgreement = false;
            } else {
                if (DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY.equals(this.mAgreeAsString) || DiagMonUtil.AGREE_TYPE_DIAGNOSTIC.equals(this.mAgreeAsString)) {
                    this.mAgreement = true;
                    return;
                }
                Log.w(DiagMonUtil.TAG, "Wrong agreement : " + str);
                this.mAgreement = false;
            }
        }
    }

    public DiagMonConfig(Context context) {
        this.mServiceVer = "";
        this.mContext = context;
        this.mServiceVer = CommonUtils.getPackageVersion(context);
        if (DiagMonUtil.checkDMA(this.mContext) == 1) {
            this.oldConf = new oldDiagMonConfig();
        }
    }

    public boolean getAgree() {
        return DiagMonUtil.checkDMA(this.mContext) == 1 ? this.oldConf.getAgree() : this.mAgreement;
    }

    public String getAgreeAsString() {
        return DiagMonUtil.checkDMA(this.mContext) == 1 ? this.oldConf.getAgreeAsString() : this.mAgreeAsString;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getServiceId() {
        return this.mServiceId;
    }

    public boolean getServiceNetworkMode() {
        return this.serviceNetworkMode;
    }

    public String getServiceVer() {
        return this.mServiceVer;
    }

    public String getTrackingId() {
        return this.mTrackingId;
    }

    public DiagMonConfig setAgree(String str) {
        this.mAgreeAsString = str;
        if (str == null) {
            Log.e(DiagMonUtil.TAG, "You can't use agreement as null");
            return this;
        }
        if (DiagMonUtil.checkDMA(this.mContext) == 1) {
            this.oldConf.setAgree(this.mAgreeAsString);
            return this;
        }
        if (DiagMonUtil.AGREE_TYPE_DIAGNOSTIC.equals(this.mAgreeAsString) || "S".equals(this.mAgreeAsString)) {
            this.mAgreement = true;
            return this;
        }
        this.mAgreement = false;
        return this;
    }

    public DiagMonConfig setDeviceId(String str) {
        this.mDeviceId = str;
        return this;
    }

    public DiagMonConfig setServiceId(String str) {
        this.mServiceId = str;
        return this;
    }

    public DiagMonConfig setTrackingId(String str) {
        this.mTrackingId = str;
        return this;
    }

    public DiagMonConfig setAgree(String str, String str2) {
        setAgree(str);
        if (DiagMonSDK.NETWORK_ANY.equals(str2) && "S".equals(str)) {
            this.serviceNetworkMode = false;
        }
        AbstractC0000a.m27x(new StringBuilder("serviceNetworkMode : "), this.serviceNetworkMode, DiagMonUtil.TAG);
        return this;
    }
}
