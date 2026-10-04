package com.sec.android.diagmonagent.common.logger;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AppLogData implements IAppLogData {
    private static final String APP_TAG = "DIAGMON_SDK";
    private String mMessagePrefix;

    private void makeAdditionalData(String str) {
        this.mMessagePrefix = AbstractC0541b.m773o("[605079][", str, "] ");
    }

    @Override // com.sec.android.diagmonagent.common.logger.IAppLogData
    /* JADX INFO: renamed from: d */
    public int mo13145d(String str, String str2) {
        try {
            makeAdditionalData(str);
            return Log.d(APP_TAG + this.mMessagePrefix, str2);
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.sec.android.diagmonagent.common.logger.IAppLogData
    /* JADX INFO: renamed from: e */
    public int mo13146e(String str, String str2) {
        try {
            makeAdditionalData(str);
            return Log.e(APP_TAG + this.mMessagePrefix, str2);
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.sec.android.diagmonagent.common.logger.IAppLogData
    /* JADX INFO: renamed from: i */
    public int mo13147i(String str, String str2) {
        try {
            makeAdditionalData(str);
            return Log.i(APP_TAG + this.mMessagePrefix, str2);
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.sec.android.diagmonagent.common.logger.IAppLogData
    /* JADX INFO: renamed from: v */
    public int mo13148v(String str, String str2) {
        try {
            makeAdditionalData(str);
            return Log.v(APP_TAG + this.mMessagePrefix, str2);
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.sec.android.diagmonagent.common.logger.IAppLogData
    /* JADX INFO: renamed from: w */
    public int mo13149w(String str, String str2) {
        try {
            makeAdditionalData(str);
            return Log.w(APP_TAG + this.mMessagePrefix, str2);
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
            return -1;
        }
    }
}
