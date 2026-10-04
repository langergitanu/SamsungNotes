package com.samsung.android.sdk.mobileservice.social.social;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SocialPickerRequest {
    private static final String DELIMITER = ";";
    private static final String KEY_DISPLAY_BUDDY = "display_buddy";
    private static final String KEY_DISPLAY_SA_FAMILY = "display_sa_family";
    private static final String KEY_ENABLE_QUICK_INVITATION = "enable_quick_invitation";
    private static final String KEY_ENABLE_RECENT_INVITATION = "enable_recent_invitation";
    private static final String KEY_ENABLE_SHARING_ACCOUNT = "enable_sharing_account";
    private static final String KEY_ENABLE_SKIP = "enable_skip_button";
    private static final String KEY_EXCEPTION_GUID = "exception_guid_list";
    private static final String KEY_FILTER_APP_ID = "filter_app_id";
    private static final String KEY_FILTER_CAPABILITY = "filter_capability";
    private static final String KEY_FILTER_FEATURE_ID = "filter_feature_id";
    private static final String KEY_IGNORE_APP_ID = "ignore_app_id";
    private static final String KEY_INVITE_TITLE_URI = "invite_title_uri";
    private static final String KEY_MAX_RECIPIENT_COUNT = "maxRecipientCount";
    private static final String KEY_REQUEST_GROUP_PERMISSION = "request_group_permission";
    private static final String KEY_SELECTED_GUIDS = "selected_guids";
    private static final String KEY_SHOW_EDIT_AUTHORITY = "show_edit_authority";
    private static final String KEY_SHOW_INVITATION_CHOICE = "show_invitation_choice";
    private static final String KEY_STANDALONE_GROUP = "standalone_group";
    private final boolean mEnableFilterCapability;
    private final boolean mEnableQuickInvitation;
    private final boolean mEnableRecentInvitation;
    private final boolean mEnableSharingAccount;
    private final boolean mEnableSkip;
    private final List<String> mExceptionGuidList;
    private final int mFeatureId;
    private final String mFilterAppId;
    private final List<Integer> mFilterFeatureIdList;
    private final String mInviteTitleUri;
    private final int mMaxRecipientCount;
    private final boolean mRequestGroupPermission;
    private final List<String> mSelectedGuids;
    private final boolean mShowBuddy;
    private final boolean mShowEditAuthority;
    private final boolean mShowFamilyMember;
    private final boolean mShowInvitationChoice;
    private final boolean mStandalone;

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FILTER_APP_ID, this.mFilterAppId);
        int i = this.mFeatureId;
        if (i != -1) {
            bundle.putString(KEY_FILTER_FEATURE_ID, String.valueOf(i));
        } else {
            List<Integer> list = this.mFilterFeatureIdList;
            if (list != null && !list.isEmpty()) {
                bundle.putString(KEY_FILTER_FEATURE_ID, TextUtils.join(";", this.mFilterFeatureIdList));
            }
        }
        List<String> list2 = this.mExceptionGuidList;
        if (list2 != null && !list2.isEmpty()) {
            bundle.putString(KEY_EXCEPTION_GUID, TextUtils.join(";", this.mExceptionGuidList));
        }
        int i2 = this.mMaxRecipientCount;
        if (i2 != -1) {
            bundle.putInt(KEY_MAX_RECIPIENT_COUNT, i2);
        }
        bundle.putBoolean(KEY_ENABLE_SHARING_ACCOUNT, this.mEnableSharingAccount);
        bundle.putBoolean(KEY_ENABLE_RECENT_INVITATION, this.mEnableRecentInvitation);
        bundle.putBoolean(KEY_REQUEST_GROUP_PERMISSION, this.mRequestGroupPermission);
        bundle.putBoolean(KEY_IGNORE_APP_ID, true);
        bundle.putBoolean(KEY_SHOW_INVITATION_CHOICE, this.mShowInvitationChoice);
        bundle.putBoolean(KEY_SHOW_EDIT_AUTHORITY, this.mShowEditAuthority);
        bundle.putBoolean(KEY_ENABLE_SKIP, this.mEnableSkip);
        bundle.putBoolean(KEY_STANDALONE_GROUP, this.mStandalone);
        bundle.putBoolean(KEY_FILTER_CAPABILITY, this.mEnableFilterCapability);
        bundle.putBoolean(KEY_DISPLAY_BUDDY, this.mShowBuddy);
        bundle.putBoolean(KEY_DISPLAY_SA_FAMILY, this.mShowFamilyMember);
        bundle.putBoolean(KEY_ENABLE_QUICK_INVITATION, this.mEnableQuickInvitation);
        bundle.putStringArray(KEY_SELECTED_GUIDS, (String[]) this.mSelectedGuids.toArray(new String[0]));
        if (!TextUtils.isEmpty(this.mInviteTitleUri)) {
            bundle.putString(KEY_INVITE_TITLE_URI, this.mInviteTitleUri);
        }
        return bundle;
    }

    private SocialPickerRequest(Builder builder) {
        this.mFilterAppId = builder.mFilterAppId;
        this.mFilterFeatureIdList = builder.mFilterFeatureIdList;
        this.mFeatureId = builder.mFeatureId;
        this.mShowInvitationChoice = builder.mShowInvitationChoice;
        this.mShowEditAuthority = builder.mShowEditAuthority;
        this.mExceptionGuidList = builder.mExceptionGuidList;
        this.mMaxRecipientCount = builder.mMaxRecipientCount;
        this.mEnableSharingAccount = builder.mEnableSharingAccount;
        this.mEnableRecentInvitation = builder.mEnableRecentInvitation;
        this.mRequestGroupPermission = builder.mRequestGroupPermission;
        this.mInviteTitleUri = builder.mInviteTitleUri;
        this.mEnableSkip = builder.mEnableSkip;
        this.mStandalone = builder.mStandalone;
        this.mEnableFilterCapability = builder.mEnableFilterCapability;
        this.mShowBuddy = builder.mShowBuddy;
        this.mShowFamilyMember = builder.mShowFamilyMember;
        this.mEnableQuickInvitation = builder.mEnableQuickInvitation;
        this.mSelectedGuids = builder.mSelectedGuids;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private boolean mEnableFilterCapability;
        private boolean mEnableQuickInvitation;
        private boolean mEnableRecentInvitation;
        private boolean mEnableSharingAccount;
        private boolean mEnableSkip;
        private List<String> mExceptionGuidList;
        private int mFeatureId;
        private String mFilterAppId;
        private List<Integer> mFilterFeatureIdList;
        private String mInviteTitleUri;
        private int mMaxRecipientCount;
        private boolean mRequestGroupPermission;
        private List<String> mSelectedGuids;
        private boolean mShowBuddy;
        private boolean mShowEditAuthority;
        private boolean mShowFamilyMember;
        private boolean mShowInvitationChoice;
        private boolean mStandalone;

        @Deprecated
        public Builder() {
            this.mFilterAppId = null;
            this.mFilterFeatureIdList = null;
            this.mFeatureId = -1;
            this.mShowInvitationChoice = false;
            this.mShowEditAuthority = false;
            this.mExceptionGuidList = null;
            this.mMaxRecipientCount = -1;
            this.mEnableSharingAccount = true;
            this.mEnableRecentInvitation = true;
            this.mRequestGroupPermission = false;
            this.mInviteTitleUri = null;
            this.mEnableSkip = false;
            this.mStandalone = false;
            this.mEnableFilterCapability = true;
            this.mShowBuddy = true;
            this.mShowFamilyMember = false;
            this.mEnableQuickInvitation = false;
            this.mSelectedGuids = new ArrayList();
        }

        public SocialPickerRequest build() {
            return new SocialPickerRequest(this);
        }

        public Builder setEnableFilterCapability(boolean z) {
            this.mEnableFilterCapability = z;
            return this;
        }

        public Builder setEnableQuickInvitation(boolean z) {
            this.mEnableQuickInvitation = z;
            return this;
        }

        public Builder setEnableRecentInvitation(boolean z) {
            this.mEnableRecentInvitation = z;
            return this;
        }

        public Builder setEnableSharingAccount(boolean z) {
            this.mEnableSharingAccount = z;
            return this;
        }

        public Builder setEnableSkip(boolean z) {
            this.mEnableSkip = z;
            return this;
        }

        public Builder setExceptionGuidList(List<String> list) {
            this.mExceptionGuidList = list;
            return this;
        }

        @Deprecated
        public Builder setFilterAppId(String str) {
            this.mFilterAppId = str;
            return this;
        }

        @Deprecated
        public Builder setFilterFeatureIdList(List<String> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next()));
            }
            this.mFilterFeatureIdList = arrayList;
            return this;
        }

        public Builder setInviteTitleUri(Context context, int i) {
            this.mInviteTitleUri = new Uri.Builder().scheme("android.resource").authority(context.getResources().getResourcePackageName(i)).appendPath(String.valueOf(i)).build().toString();
            return this;
        }

        public Builder setMaxRecipientCount(int i) {
            this.mMaxRecipientCount = i;
            return this;
        }

        public Builder setRequestGroupPermission(boolean z) {
            this.mRequestGroupPermission = z;
            return this;
        }

        public Builder setSelectedGuids(List<String> list) {
            this.mSelectedGuids = list;
            return this;
        }

        public Builder setShowBuddy(boolean z) {
            this.mShowBuddy = z;
            return this;
        }

        public Builder setShowEditAuthority(Boolean bool) {
            this.mShowEditAuthority = bool.booleanValue();
            return this;
        }

        public Builder setShowFamilyMember(boolean z) {
            this.mShowFamilyMember = z;
            return this;
        }

        public Builder setShowInvitationChoice(Boolean bool) {
            this.mShowInvitationChoice = bool.booleanValue();
            return this;
        }

        public Builder setStandalone(boolean z) {
            this.mStandalone = z;
            return this;
        }

        @Deprecated
        public Builder(String str, List<Integer> list) {
            this.mFilterAppId = null;
            this.mFilterFeatureIdList = null;
            this.mFeatureId = -1;
            this.mShowInvitationChoice = false;
            this.mShowEditAuthority = false;
            this.mExceptionGuidList = null;
            this.mMaxRecipientCount = -1;
            this.mEnableSharingAccount = true;
            this.mEnableRecentInvitation = true;
            this.mRequestGroupPermission = false;
            this.mInviteTitleUri = null;
            this.mEnableSkip = false;
            this.mStandalone = false;
            this.mEnableFilterCapability = true;
            this.mShowBuddy = true;
            this.mShowFamilyMember = false;
            this.mEnableQuickInvitation = false;
            this.mSelectedGuids = new ArrayList();
            this.mFilterAppId = str;
            this.mFilterFeatureIdList = list;
        }

        public Builder(String str, int i) {
            this.mFilterAppId = null;
            this.mFilterFeatureIdList = null;
            this.mFeatureId = -1;
            this.mShowInvitationChoice = false;
            this.mShowEditAuthority = false;
            this.mExceptionGuidList = null;
            this.mMaxRecipientCount = -1;
            this.mEnableSharingAccount = true;
            this.mEnableRecentInvitation = true;
            this.mRequestGroupPermission = false;
            this.mInviteTitleUri = null;
            this.mEnableSkip = false;
            this.mStandalone = false;
            this.mEnableFilterCapability = true;
            this.mShowBuddy = true;
            this.mShowFamilyMember = false;
            this.mEnableQuickInvitation = false;
            this.mSelectedGuids = new ArrayList();
            this.mFilterAppId = str;
            this.mFeatureId = i;
        }

        public Builder(String str) {
            this.mFilterAppId = null;
            this.mFilterFeatureIdList = null;
            this.mFeatureId = -1;
            this.mShowInvitationChoice = false;
            this.mShowEditAuthority = false;
            this.mExceptionGuidList = null;
            this.mMaxRecipientCount = -1;
            this.mEnableSharingAccount = true;
            this.mEnableRecentInvitation = true;
            this.mRequestGroupPermission = false;
            this.mInviteTitleUri = null;
            this.mEnableSkip = false;
            this.mStandalone = false;
            this.mEnableFilterCapability = true;
            this.mShowBuddy = true;
            this.mShowFamilyMember = false;
            this.mEnableQuickInvitation = false;
            this.mSelectedGuids = new ArrayList();
            this.mFilterAppId = str;
        }
    }
}
