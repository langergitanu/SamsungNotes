package com.samsung.android.sdk.smp.common.preference;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.SmpInitOptions;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.MarketingManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class InitOptionsHolder {
    private static InitOptionsHolder mInitOptionsHolder;
    private String mAppId;
    private boolean mDebugMode;
    private boolean mMultiProcessMode;
    private SmpConstants.OptInPolicy mOptInPolicy;
    private SmpConstants.PushModeForHkAndMo mPushModeForHkAndMo;
    private String mSppAppId;

    private InitOptionsHolder() {
    }

    public static synchronized InitOptionsHolder getInstance() {
        try {
            if (mInitOptionsHolder == null) {
                mInitOptionsHolder = new InitOptionsHolder();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInitOptionsHolder;
    }

    public String getAppId(Context context) {
        if (this.mAppId == null) {
            this.mAppId = PrefManager.getInstance(context).getAID();
        }
        return this.mAppId;
    }

    public SmpConstants.OptInPolicy getOptInPolicy(Context context) {
        if (this.mOptInPolicy == null) {
            this.mOptInPolicy = PrefManager.getInstance(context).getOptinPolicy();
        }
        return this.mOptInPolicy;
    }

    public SmpConstants.PushModeForHkAndMo getPushModeForHkAndMo(Context context) {
        if (this.mPushModeForHkAndMo == null) {
            this.mPushModeForHkAndMo = PrefManager.getInstance(context).getPushModeForHkAndMo();
        }
        return this.mPushModeForHkAndMo;
    }

    public String getSppAppId(Context context) {
        if (this.mSppAppId == null) {
            this.mSppAppId = PrefManager.getInstance(context).getSppAppId();
        }
        return this.mSppAppId;
    }

    public void initialize(String str, SmpConstants.PushModeForHkAndMo pushModeForHkAndMo, SmpInitOptions smpInitOptions) {
        this.mAppId = str;
        this.mPushModeForHkAndMo = pushModeForHkAndMo;
        if (smpInitOptions != null) {
            boolean enableDebugLog = smpInitOptions.getEnableDebugLog();
            this.mDebugMode = enableDebugLog;
            SmpLog.enableLog(enableDebugLog);
            this.mOptInPolicy = smpInitOptions.getOptInPolicy();
            this.mSppAppId = smpInitOptions.getSppAppId();
            this.mMultiProcessMode = smpInitOptions.getMultiProcessMode();
        }
    }

    public boolean isMultiprocessMode() {
        return this.mMultiProcessMode;
    }

    public void saveInitDataToPref(Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        if (this.mAppId != null) {
            prefManager.setAID(getAppId(context));
        }
        SmpConstants.OptInPolicy optInPolicy = this.mOptInPolicy;
        if (optInPolicy != null) {
            if (!optInPolicy.equals(prefManager.getOptinPolicy())) {
                MarketingManager.deleteIncompletedMarketings(context, FeedbackDetailConstants.OPT_IN_POLICY_CHANGED);
            }
            prefManager.setOptinPolicy(getOptInPolicy(context));
        }
        if (this.mSppAppId != null) {
            prefManager.setSppAppId(getSppAppId(context));
        }
        SmpConstants.PushModeForHkAndMo pushModeForHkAndMo = this.mPushModeForHkAndMo;
        if (pushModeForHkAndMo != null) {
            prefManager.setPushModeForHkAndMo(pushModeForHkAndMo);
        }
    }

    public String toString() {
        return "D:" + this.mDebugMode + ", O:" + this.mOptInPolicy + ", S:" + TextUtils.isEmpty(this.mSppAppId) + ", M:" + this.mMultiProcessMode + ", P:" + SmpConstants.PushModeForHkAndMo.getName(this.mPushModeForHkAndMo);
    }
}
