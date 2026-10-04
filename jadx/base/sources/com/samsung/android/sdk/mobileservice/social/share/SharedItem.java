package com.samsung.android.sdk.mobileservice.social.share;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedItem {
    private long mCreatedTime;
    private String mCreator;
    private boolean mIsOwnedByMe;
    private String mItemId;
    private String mLastModifier;
    private String mLeaderId;
    private String mMemo;

    @Deprecated
    private Map mMetaData;
    private String mMetaString;
    private String mMimeType;
    private long mModifiedTime;
    private String mOriginalContentPath;
    private Uri mOriginalContentUri;
    private String mReferredResourceId;
    private long mSize;
    private String mSourceCid;
    private String mSpaceId;
    private String mStreamingUrl;
    private Uri mThumbnailContentUri;
    private Uri mThumbnailFileUri;
    private String mTitle;

    public SharedItem(String str, String str2, String str3) {
        setItemId(str);
        setSpaceId(str2);
        setLeaderId(str3);
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public String getCreator() {
        return this.mCreator;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public String getLastModifier() {
        return this.mLastModifier;
    }

    public String getLeaderId() {
        return this.mLeaderId;
    }

    public String getMemo() {
        return this.mMemo;
    }

    @Deprecated
    public Map getMetaData() {
        return this.mMetaData;
    }

    public String getMetaString() {
        return this.mMetaString;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public String getOriginalContentPath() {
        return this.mOriginalContentPath;
    }

    public Uri getOriginalContentUri() {
        return this.mOriginalContentUri;
    }

    public String getResourceId() {
        return this.mReferredResourceId;
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

    public String getStreamingUrl() {
        return this.mStreamingUrl;
    }

    public Uri getThumbnailContentUri() {
        return this.mThumbnailContentUri;
    }

    public Uri getThumbnailFileUri() {
        return this.mThumbnailFileUri;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isOwnedByMe() {
        return this.mIsOwnedByMe;
    }

    public void setCreatedTime(long j) {
        this.mCreatedTime = j;
    }

    public void setCreator(String str) {
        this.mCreator = str;
    }

    public void setItemId(String str) {
        this.mItemId = str;
    }

    public void setLastModifier(String str) {
        this.mLastModifier = str;
    }

    public void setLeaderId(String str) {
        this.mLeaderId = str;
    }

    public void setMemo(String str) {
        this.mMemo = str;
    }

    @Deprecated
    public void setMetaData(Map map) {
        this.mMetaData = map;
    }

    public void setMetaString(String str) {
        this.mMetaString = str;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setModifiedTime(long j) {
        this.mModifiedTime = j;
    }

    public void setOriginalContentPath(String str) {
        this.mOriginalContentPath = str;
    }

    public void setOriginalContentUri(Uri uri) {
        this.mOriginalContentUri = uri;
    }

    public void setOwnedByMe(boolean z) {
        this.mIsOwnedByMe = z;
    }

    public void setResourceId(String str) {
        this.mReferredResourceId = str;
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

    public void setStreamingUrl(String str) {
        this.mStreamingUrl = str;
    }

    public void setThumbnailContentUri(Uri uri) {
        this.mThumbnailContentUri = uri;
    }

    public void setThumbnailFileUri(Uri uri) {
        this.mThumbnailFileUri = uri;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
