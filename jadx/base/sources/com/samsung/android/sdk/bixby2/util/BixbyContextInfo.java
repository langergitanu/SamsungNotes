package com.samsung.android.sdk.bixby2.util;

import android.os.Bundle;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.bixby2.LogUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BixbyContextInfo {
    private static final String TAG = "BixbyContextInfo";
    private final String BIXBY_CLIENT_TASK_ID;
    private final String IS_MEDIA_CONTROL_ACTIVE;
    private final String IS_MUSIC_ACTIVE;
    private final String LOCALE;
    private Integer bixbyClientTaskId;
    private final boolean isMediaControlActive;
    private final boolean isMusicActive;
    private final String locale;

    public BixbyContextInfo(Bundle bundle) {
        this.LOCALE = "locale";
        this.IS_MUSIC_ACTIVE = "isMusicActive";
        this.IS_MEDIA_CONTROL_ACTIVE = "isMediaControlActive";
        this.BIXBY_CLIENT_TASK_ID = "bixbyClient_taskId";
        String string = bundle.getString("locale", "");
        this.locale = string;
        boolean z = bundle.getBoolean("isMusicActive", false);
        this.isMusicActive = z;
        boolean z2 = bundle.getBoolean("isMediaControlActive", false);
        this.isMediaControlActive = z2;
        if (bundle.containsKey("bixbyClient_taskId")) {
            this.bixbyClientTaskId = Integer.valueOf(bundle.getInt("bixbyClient_taskId"));
        }
        StringBuilder sbM2229t = AbstractC2821a.m2229t("BixbyContextInfo() :: locale - ", string, ", isMusicActive - ", z, ", isMediaControlActive - ");
        sbM2229t.append(z2);
        LogUtil.m5745d(TAG, sbM2229t.toString());
    }

    public Integer getBixbyClientTaskId() {
        return this.bixbyClientTaskId;
    }

    public String getLocale() {
        return this.locale;
    }

    public boolean isMediaControlActive() {
        return this.isMediaControlActive;
    }

    public boolean isMusicActive() {
        return this.isMusicActive;
    }

    public BixbyContextInfo() {
        this.LOCALE = "locale";
        this.IS_MUSIC_ACTIVE = "isMusicActive";
        this.IS_MEDIA_CONTROL_ACTIVE = "isMediaControlActive";
        this.BIXBY_CLIENT_TASK_ID = "bixbyClient_taskId";
        this.locale = "";
        this.isMusicActive = false;
        this.isMediaControlActive = false;
    }
}
