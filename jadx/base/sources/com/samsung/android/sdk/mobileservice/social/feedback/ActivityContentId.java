package com.samsung.android.sdk.mobileservice.social.feedback;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ActivityContentId extends ContentId {
    public static final int ACTIVITY_TYPE_POSTING = 4;
    public static final int ACTIVITY_TYPE_PROFILE_CHANGE = 3;
    public static final int ACTIVITY_TYPE_PROFILE_IMAGE = 2;
    public static final int ACTIVITY_TYPE_STATUS_MESSAGE = 1;
    private String mActivityId;
    private int mActivityType;
    private String mGuid;

    public ActivityContentId(String str, String str2) {
        super(1);
        this.mGuid = str;
        this.mActivityId = str2;
        this.mActivityType = 3;
    }

    public String getActivityId() {
        return this.mActivityId;
    }

    public int getActivityType() {
        return this.mActivityType;
    }

    public String getGuid() {
        return this.mGuid;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.feedback.ContentId
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("contentIdType", getContentIdType());
        bundle.putString("guid", this.mGuid);
        bundle.putString("activityId", this.mActivityId);
        bundle.putInt("activityType", this.mActivityType);
        return bundle;
    }

    public String toString() {
        return "activityId: " + this.mActivityId + ", guid: " + this.mGuid + ", activityType: " + this.mActivityType;
    }

    public ActivityContentId(String str, String str2, int i) {
        super(1);
        this.mGuid = str;
        this.mActivityId = str2;
        this.mActivityType = i;
    }

    public ActivityContentId(Bundle bundle) {
        super(1);
        if (bundle == null) {
            return;
        }
        this.mGuid = bundle.getString("guid");
        this.mActivityId = bundle.getString("activityId");
        if (TextUtils.equals(bundle.getString("activityType", null), "post")) {
            this.mActivityType = 4;
        } else {
            this.mActivityType = 3;
        }
    }
}
