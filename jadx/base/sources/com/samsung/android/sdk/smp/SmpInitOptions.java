package com.samsung.android.sdk.smp;

import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpInitOptions {
    private SmpConstants.OptInPolicy optInPolicy = SmpConstants.OptInPolicy.DEVICE_BASED;
    private boolean isDebugMode = false;
    private String sppAppId = null;
    private boolean isMultiProcessMode = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Option {
        OPT_IN_POLICY,
        ENABLE_DEBUG_MODE,
        SPP_APPID,
        MULTI_PROCESS_MODE
    }

    public boolean getEnableDebugLog() {
        return this.isDebugMode;
    }

    public boolean getMultiProcessMode() {
        return this.isMultiProcessMode;
    }

    public SmpConstants.OptInPolicy getOptInPolicy() {
        return this.optInPolicy;
    }

    public String getSppAppId() {
        return this.sppAppId;
    }

    public SmpInitOptions setEnableDebugLog(boolean z) {
        this.isDebugMode = z;
        return this;
    }

    public SmpInitOptions setMultiProcessMode(boolean z) {
        this.isMultiProcessMode = z;
        return this;
    }

    public SmpInitOptions setOptInPolicy(SmpConstants.OptInPolicy optInPolicy) {
        this.optInPolicy = optInPolicy;
        return this;
    }

    public SmpInitOptions setSppAppId(String str) {
        this.sppAppId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" D:");
        sb.append(this.isDebugMode);
        sb.append(" O:");
        sb.append(this.optInPolicy);
        sb.append(" S:");
        sb.append(!TextUtils.isEmpty(this.sppAppId));
        sb.append(" M:");
        sb.append(this.isMultiProcessMode);
        return sb.toString();
    }
}
