package com.samsung.android.sdk.mobileservice.social.social;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupDetailRequest {
    private static final String DELIMITER = ";";
    private static final String KEY_APP_ID = "app_id";
    private static final String KEY_FEATURE_ID = "feature_id";
    private static final String KEY_GROUP_ID = "group_id";
    private static final String KEY_IGNORE_APP_ID = "ignore_app_id";
    private static final String KEY_INVITABLE = "invitable";
    private static final String KEY_MAX_GROUP_MEMBER_COUNT = "max_group_member_count";
    private static final String KEY_SPACE_NAME = "space_name";
    private static final String KEY_SUPPORT_LOCAL_GROUP_OWNER_DELEGATION = "support_local_group_owner_delegation";
    private final String mAppId;
    private int mFeatureId;
    private final List<Integer> mFeatureIdList;
    private final String mGroupId;
    private final boolean mInvitable;
    private final int mMaxGroupMemberCount;
    private final String mSpaceName;
    private final boolean mSupportGroupOwnerDelegation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private final String mAppId;
        private int mFeatureId;
        private List<Integer> mFeatureIdList;
        private final String mGroupId;
        private boolean mInvitable;
        private int mMaxGroupMemberCount;
        private String mSpaceName;
        public boolean mSupportGroupOwnerDelegation;

        @Deprecated
        public Builder(String str, String str2) {
            this.mMaxGroupMemberCount = -1;
            this.mSpaceName = null;
            this.mFeatureIdList = null;
            this.mInvitable = true;
            this.mFeatureId = -1;
            this.mSupportGroupOwnerDelegation = true;
            this.mAppId = str;
            this.mGroupId = str2;
        }

        public GroupDetailRequest build() {
            if (TextUtils.isEmpty(this.mAppId)) {
                throw new NullPointerException("AppId should not be empty");
            }
            if (TextUtils.isEmpty(this.mGroupId)) {
                throw new NullPointerException("GroupId should not be empty");
            }
            return new GroupDetailRequest(this);
        }

        @Deprecated
        public Builder setFeatureId(List<Integer> list) {
            this.mFeatureIdList = list;
            return this;
        }

        @Deprecated
        public Builder setFeatureIdList(List<String> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next()));
            }
            this.mFeatureIdList = arrayList;
            return this;
        }

        public Builder setInvitable(boolean z) {
            this.mInvitable = z;
            return this;
        }

        public Builder setMaxGroupMemberCount(int i) {
            this.mMaxGroupMemberCount = i;
            return this;
        }

        public Builder setSpaceName(String str) {
            this.mSpaceName = str;
            return this;
        }

        public Builder setSupportGroupOwnerDelegation(boolean z) {
            this.mSupportGroupOwnerDelegation = z;
            return this;
        }

        public Builder setFeatureId(int i) {
            this.mFeatureId = i;
            return this;
        }

        public Builder(String str, String str2, int i) {
            this.mMaxGroupMemberCount = -1;
            this.mSpaceName = null;
            this.mFeatureIdList = null;
            this.mInvitable = true;
            this.mSupportGroupOwnerDelegation = true;
            this.mAppId = str;
            this.mGroupId = str2;
            this.mFeatureId = i;
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("app_id", this.mAppId);
        bundle.putString("group_id", this.mGroupId);
        bundle.putBoolean(KEY_INVITABLE, this.mInvitable);
        bundle.putBoolean(KEY_IGNORE_APP_ID, true);
        bundle.putBoolean(KEY_SUPPORT_LOCAL_GROUP_OWNER_DELEGATION, this.mSupportGroupOwnerDelegation);
        int i = this.mMaxGroupMemberCount;
        if (i != -1) {
            bundle.putInt(KEY_MAX_GROUP_MEMBER_COUNT, i);
        }
        if (!TextUtils.isEmpty(this.mSpaceName)) {
            bundle.putString("space_name", this.mSpaceName);
        }
        int i2 = this.mFeatureId;
        if (i2 != -1) {
            bundle.putString("feature_id", String.valueOf(i2));
            return bundle;
        }
        List<Integer> list = this.mFeatureIdList;
        if (list != null && !list.isEmpty()) {
            bundle.putString("feature_id", TextUtils.join(";", this.mFeatureIdList));
        }
        return bundle;
    }

    private GroupDetailRequest(Builder builder) {
        this.mAppId = builder.mAppId;
        this.mGroupId = builder.mGroupId;
        this.mSpaceName = builder.mSpaceName;
        this.mFeatureIdList = builder.mFeatureIdList;
        this.mMaxGroupMemberCount = builder.mMaxGroupMemberCount;
        this.mInvitable = builder.mInvitable;
        this.mFeatureId = builder.mFeatureId;
        this.mSupportGroupOwnerDelegation = builder.mSupportGroupOwnerDelegation;
    }
}
