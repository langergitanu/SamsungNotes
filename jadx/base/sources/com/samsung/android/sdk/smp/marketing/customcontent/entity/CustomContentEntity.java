package com.samsung.android.sdk.smp.marketing.customcontent.entity;

import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.customcontent.CustomContentResult;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class CustomContentEntity {
    private static final String TAG = "CustomContentEntity";
    public final String mid;
    public final String path;
    public final String uid;
    public final String userdata;

    public CustomContentEntity(String str, String str2, String str3, String str4) {
        this.path = str;
        this.mid = str2;
        this.uid = str3;
        this.userdata = str4;
    }

    public CustomContentResult checkValidation() {
        if (!this.uid.isEmpty()) {
            return null;
        }
        SmpLog.m6494e(TAG, "uid is empty. cannot request custom content");
        return CustomContentResult.fail(FeedbackDetailConstants.EMPTY_UID);
    }

    public abstract Map<String, String> getRequestQueries();

    public abstract String printData();
}
