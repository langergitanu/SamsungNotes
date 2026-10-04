package com.samsung.android.sdk.mobileservice.social.group;

import android.net.Uri;
import com.samsung.android.sdk.mobileservice.social.group.GroupAuthority;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupMember {

    @Deprecated
    public static final int ID_TYPE_ACCOUNT_ID = 3;

    @Deprecated
    public static final int ID_TYPE_DUID = 2;

    @Deprecated
    public static final int ID_TYPE_GUID = 0;

    @Deprecated
    public static final int ID_TYPE_MSISDN = 1;
    private GroupAuthority.AuthorityType mAuthority;
    private String mId;
    private boolean mIsLeader;
    private String mName;
    private String mOptionalId;
    private int mOptionalIdType;
    private int mStatus;
    private Uri mThumbnailContentUri;
    private Uri mThumbnailFileUri;

    @Deprecated
    public GroupMember(int i, String str, String str2, int i2, String str3, boolean z, Uri uri, Uri uri2) {
        this.mOptionalIdType = i;
        this.mId = str;
        this.mOptionalId = str2;
        this.mStatus = i2;
        this.mName = str3;
        this.mIsLeader = z;
        this.mThumbnailFileUri = uri;
        this.mThumbnailContentUri = uri2;
    }

    public GroupAuthority.AuthorityType getAuthority() {
        return this.mAuthority;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getOptionalId() {
        return this.mOptionalId;
    }

    @Deprecated
    public int getOptionalIdType() {
        return this.mOptionalIdType;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public Uri getThumbnailContentUri() {
        return this.mThumbnailContentUri;
    }

    public Uri getThumbnailFileUri() {
        return this.mThumbnailFileUri;
    }

    public boolean isLeader() {
        return this.mIsLeader;
    }

    public GroupMember(String str, String str2, int i, String str3, boolean z, Uri uri, Uri uri2, GroupAuthority.AuthorityType authorityType) {
        this.mOptionalIdType = 0;
        this.mId = str;
        this.mOptionalId = str2;
        this.mStatus = i;
        this.mName = str3;
        this.mIsLeader = z;
        this.mThumbnailFileUri = uri;
        this.mThumbnailContentUri = uri2;
        this.mAuthority = authorityType;
    }
}
