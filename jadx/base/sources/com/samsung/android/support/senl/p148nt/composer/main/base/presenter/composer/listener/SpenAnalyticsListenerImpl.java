package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.composer.listener.SpenAnalyticsListener;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenAnalyticsListenerImpl extends SpenAnalyticsListener {
    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertLog(String str) {
        if (str != null) {
            CommonSamsungAnalytics.insertLog(str);
        }
    }

    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertStatusLog(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        CommonSamsungAnalytics.insertStatusLog(str, str2);
    }

    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertLog(String str, String str2) {
        if (str2 != null) {
            CommonSamsungAnalytics.insertLog(str, str2);
        }
    }

    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertStatusLog(String str, int i) {
        if (str != null) {
            CommonSamsungAnalytics.insertStatusLog(str, i);
        }
    }

    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertLog(String str, String str2, int i) {
        if (str2 != null) {
            CommonSamsungAnalytics.insertLog(str, str2, i);
        }
    }

    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertLog(String str, String str2, String str3) {
        if (str2 == null || str3 == null) {
            return;
        }
        CommonSamsungAnalytics.insertLog(str, str2, str3);
    }

    @Override // com.samsung.android.sdk.pen.util.SpenAnalyticsUtil.AnalyticsListener
    public void onInsertLog(String str, String str2, String str3, int i) {
        if (str2 == null || str3 == null) {
            return;
        }
        CommonSamsungAnalytics.insertLog(str, str2, str3, i);
    }
}
