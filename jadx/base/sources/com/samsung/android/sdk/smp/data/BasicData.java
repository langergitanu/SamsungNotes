package com.samsung.android.sdk.smp.data;

import android.os.Build;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class BasicData {
    private String mAppv;
    private boolean mBackgroundRestricted;
    private JSONObject mChannel;
    private int mConfv;
    private String mCsc;
    private boolean mDatasaver;
    private String mDcc;
    private boolean mFold;
    private long mInitsts;
    private boolean mIntegratedOptin;
    private boolean mIsProductShip;
    private String mLc;
    private String mModel;
    private String mNmcc;
    private String mNmnc;
    private String mOneUIV;
    private boolean mOptin;
    private long mOptinTime;
    private String mOs;
    private int mOsv;
    private String mPid;
    private boolean mPowersaver;
    private String mPtype;
    private String mSdkv;
    private int mSmallestScreenWidth;
    private String mSmcc;
    private String mSmnc;
    private JSONObject mSpsPolicy;
    private int mStandByBucket;
    private int mTargetSdkLevel;
    private String mTimezone;
    private String mUid;

    public void setAppv(String str) {
        this.mAppv = str;
    }

    public void setBackgroundRestricted(boolean z) {
        this.mBackgroundRestricted = z;
    }

    public void setChannel(JSONObject jSONObject) {
        this.mChannel = jSONObject;
    }

    public void setConfv(int i) {
        this.mConfv = i;
    }

    public void setCsc(String str) {
        this.mCsc = str;
    }

    public void setDatasaver(boolean z) {
        this.mDatasaver = z;
    }

    public void setDcc(String str) {
        this.mDcc = str;
    }

    public void setFold(boolean z) {
        this.mFold = z;
    }

    public void setInitsts(long j) {
        this.mInitsts = j;
    }

    public void setIntegratedOptin(boolean z) {
        this.mIntegratedOptin = z;
    }

    public void setIsProductShip(boolean z) {
        this.mIsProductShip = z;
    }

    public void setLc(String str) {
        this.mLc = str;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public void setNmcc(String str) {
        this.mNmcc = str;
    }

    public void setNmnc(String str) {
        this.mNmnc = str;
    }

    public void setOneUIV(String str) {
        this.mOneUIV = str;
    }

    public void setOptin(boolean z) {
        this.mOptin = z;
    }

    public void setOptintime(long j) {
        this.mOptinTime = j;
    }

    public void setOs(String str) {
        this.mOs = str;
    }

    public void setOsv(int i) {
        this.mOsv = i;
    }

    public void setPid(String str) {
        this.mPid = str;
    }

    public void setPowersaver(boolean z) {
        this.mPowersaver = z;
    }

    public void setPtype(String str) {
        this.mPtype = str;
    }

    public void setSdkv(String str) {
        this.mSdkv = str;
    }

    public void setSmallestScreenWidth(int i) {
        this.mSmallestScreenWidth = i;
    }

    public void setSmcc(String str) {
        this.mSmcc = str;
    }

    public void setSmnc(String str) {
        this.mSmnc = str;
    }

    public void setSpspolicy(JSONObject jSONObject) {
        this.mSpsPolicy = jSONObject;
    }

    public void setStandByBucket(int i) {
        this.mStandByBucket = i;
    }

    public void setTargetSdkLevel(int i) {
        this.mTargetSdkLevel = i;
    }

    public void setTimezone(String str) {
        this.mTimezone = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NetworkConfig.CLIENTS_INIT_STS, this.mInitsts);
        jSONObject.put("dcc", this.mDcc);
        jSONObject.put(NetworkConfig.CLIENTS_LANGUAGE, this.mLc);
        jSONObject.put(NetworkConfig.CLIENTS_OS, this.mOs);
        jSONObject.put(NetworkConfig.CLIENTS_OSV, this.mOsv);
        jSONObject.put(NetworkConfig.CLIENTS_ONE_UI_V, this.mOneUIV);
        jSONObject.put("mcc", this.mSmcc);
        jSONObject.put(NetworkConfig.CLIENTS_NMCC, this.mNmcc);
        jSONObject.put("mnc", this.mSmnc);
        jSONObject.put(NetworkConfig.CLIENTS_NMNC, this.mNmnc);
        jSONObject.put(NetworkConfig.CLIENTS_IS_PRODUCT_SHIP, this.mIsProductShip);
        jSONObject.put("model", this.mModel);
        jSONObject.put("csc", this.mCsc);
        jSONObject.put(NetworkConfig.CLIENTS_SDKV, this.mSdkv);
        jSONObject.put(NetworkConfig.CLIENTS_APPV, this.mAppv);
        jSONObject.put(NetworkConfig.CLIENTS_TARGET_SDK_LEVEL, this.mTargetSdkLevel);
        jSONObject.put(NetworkConfig.CLIENTS_CHANNEL, this.mChannel);
        jSONObject.put(NetworkConfig.CLIENTS_PID, this.mPid);
        jSONObject.put("ptype", this.mPtype);
        jSONObject.put(NetworkConfig.CLIENTS_CONFIG_VER, this.mConfv);
        jSONObject.put("uid", this.mUid);
        jSONObject.put("optin", this.mOptin);
        jSONObject.put(NetworkConfig.CLIENTS_OPTIN_TIME, this.mOptinTime);
        jSONObject.put(NetworkConfig.CLIENTS_IS_INTEGRATED_OPTIN, this.mIntegratedOptin);
        jSONObject.put(NetworkConfig.CLIENTS_POWERSAVER, this.mPowersaver);
        jSONObject.put(NetworkConfig.CLIENTS_DATASAVER, this.mDatasaver);
        jSONObject.put(NetworkConfig.CLIENTS_TIMEZONE, this.mTimezone);
        JSONObject jSONObject2 = this.mSpsPolicy;
        if (jSONObject2 != null) {
            jSONObject.put(NetworkConfig.CLIENTS_SPS_POLICY, jSONObject2);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            jSONObject.put(NetworkConfig.CLIENTS_STAND_BY_BUCKET, this.mStandByBucket);
            jSONObject.put(NetworkConfig.CLIENTS_BACKGROUND_RESTRICTED, this.mBackgroundRestricted);
        }
        jSONObject.put(NetworkConfig.CLIENTS_SMALLEST_SCREEN_WIDTH, this.mSmallestScreenWidth);
        jSONObject.put(NetworkConfig.CLIENTS_FOLD, this.mFold);
        return jSONObject;
    }
}
