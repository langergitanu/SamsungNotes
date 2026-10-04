package com.samsung.android.sdk.mobileservice.social.share;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Space {
    private long mContentUpdatedTime;
    private Uri mCoverThumbnailFileUri;
    private long mCreatedTime;
    private String mGroupId;
    private boolean mIsOwnedByMe;
    private boolean mIsStandAlone = false;
    private int mItemCount;
    private String mLeaderId;
    private String mMemo;
    private Map mMetaData;
    private long mModifiedTime;
    private long mMyCountUsage;
    private long mMyUsage;
    private long mSize;
    private String mSourceCid;
    private String mSpaceId;
    private String mTitle;
    private int mUnreadCount;
    private WebLink mWebLink;

    public Space(String str, String str2, String str3) {
        this.mGroupId = str;
        this.mSpaceId = str2;
        this.mLeaderId = str3;
    }

    public long getContentUpdatedTime() {
        return this.mContentUpdatedTime;
    }

    public Uri getCoverThumbnailFileUri() {
        return this.mCoverThumbnailFileUri;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public String getLeaderId() {
        return this.mLeaderId;
    }

    public String getMemo() {
        return this.mMemo;
    }

    public Map getMetaData() {
        return this.mMetaData;
    }

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public long getMyCountUsage() {
        return this.mMyCountUsage;
    }

    public long getMyUsage() {
        return this.mMyUsage;
    }

    public long getSize() {
        return this.mSize;
    }

    public String getSourceCid() {
        return this.mSourceCid;
    }

    public String getSpaceId() {
        return this.mSpaceId;
    }

    public boolean getStandAlone() {
        return this.mIsStandAlone;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getUnreadCount() {
        return this.mUnreadCount;
    }

    public WebLink getWebLink() {
        return this.mWebLink;
    }

    public boolean isOwnedByMe() {
        return this.mIsOwnedByMe;
    }

    public void setContentUpdatedTime(long j) {
        this.mContentUpdatedTime = j;
    }

    public void setCoverThumbnailFileUri(Uri uri) {
        this.mCoverThumbnailFileUri = uri;
    }

    public void setCreatedTime(long j) {
        this.mCreatedTime = j;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setItemCount(int i) {
        this.mItemCount = i;
    }

    public void setLeaderId(String str) {
        this.mLeaderId = str;
    }

    public void setMemo(String str) {
        this.mMemo = str;
    }

    public void setMetaData(Map map) {
        this.mMetaData = map;
    }

    public void setModifiedTime(long j) {
        this.mModifiedTime = j;
    }

    public void setMyCountUsage(long j) {
        this.mMyCountUsage = j;
    }

    public void setMyUsage(long j) {
        this.mMyUsage = j;
    }

    public void setOwnedByMe(boolean z) {
        this.mIsOwnedByMe = z;
    }

    public void setSize(long j) {
        this.mSize = j;
    }

    public void setSourceCid(String str) {
        this.mSourceCid = str;
    }

    public void setSpaceId(String str) {
        this.mSpaceId = str;
    }

    public void setStandAlone(boolean z) {
        this.mIsStandAlone = z;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUnreadCount(int i) {
        this.mUnreadCount = i;
    }

    public void setWebLink(WebLink webLink) {
        this.mWebLink = webLink;
    }
}
