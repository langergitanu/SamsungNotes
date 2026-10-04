package com.samsung.android.sdk.mobileservice.social.share;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedItemWithUriList {
    private List<Content> mContentList = new ArrayList();
    private long mCreatedTime;
    private String mCreator;
    private boolean mIsOwnedByMe;
    private String mItemId;
    private String mLastModifierId;
    private String mLeaderId;
    private String mMemo;

    @Deprecated
    private Map mMetaData;
    private String mMetaString;
    private long mModifiedTime;
    private String mReferredResourceId;
    private String mSpaceId;
    private String mTitle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Content {
        private String mFileName;
        private String mHash;
        private String mMimeType;

        @Deprecated
        private String mOriginalContentPath;
        private long mSize;
        private Uri mThumbnailContentUri;

        @Deprecated
        private Uri mThumbnailFileUri;

        public Content(String str, String str2, Uri uri, String str3, long j, String str4) {
            this.mHash = str;
            this.mMimeType = str2;
            this.mThumbnailFileUri = uri;
            this.mFileName = str3;
            this.mSize = j;
            this.mOriginalContentPath = str4;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public String getHash() {
            return this.mHash;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        @Deprecated
        public String getOriginalContentPath() {
            return this.mOriginalContentPath;
        }

        public long getSize() {
            return this.mSize;
        }

        public Uri getThumbnailContentUri() {
            return this.mThumbnailContentUri;
        }

        @Deprecated
        public Uri getThumbnailFileUri() {
            return this.mThumbnailFileUri;
        }

        public void setThumbnailContentUri(Uri uri) {
            this.mThumbnailContentUri = uri;
        }
    }

    public SharedItemWithUriList(String str, String str2, String str3) {
        setItemId(str);
        setSpaceId(str2);
        setLeaderId(str3);
    }

    public void addContent(Content content) {
        this.mContentList.add(content);
    }

    public List<Content> getContentList() {
        return this.mContentList;
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

    public String getLastModifierId() {
        return this.mLastModifierId;
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

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public String getResourceId() {
        return this.mReferredResourceId;
    }

    public String getSpaceId() {
        return this.mSpaceId;
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

    public void setLastModifierId(String str) {
        this.mLastModifierId = str;
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

    public void setModifiedTime(long j) {
        this.mModifiedTime = j;
    }

    public void setOwnedByMe(boolean z) {
        this.mIsOwnedByMe = z;
    }

    public void setResourceId(String str) {
        this.mReferredResourceId = str;
    }

    public void setSpaceId(String str) {
        this.mSpaceId = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public SharedItemWithUriList(Bundle bundle) {
        this.mItemId = bundle.getString("item_id");
        this.mSpaceId = bundle.getString("space_id");
        this.mLeaderId = bundle.getString(BundleKey.OWNER_ID);
        this.mLastModifierId = bundle.getString(BundleKey.LAST_MODIFIER_ID);
        this.mTitle = bundle.getString("title", "");
        this.mMemo = bundle.getString("memo", "");
        this.mCreatedTime = bundle.getLong(BundleKey.CREATED_TIME, 0L);
        this.mModifiedTime = bundle.getLong("modified_time", 0L);
        this.mIsOwnedByMe = bundle.getBoolean("is_owned_by_me", false);
        this.mMetaData = (HashMap) bundle.getSerializable("meta_data");
        this.mCreator = bundle.getString("creator", null);
        this.mReferredResourceId = bundle.getString("referred_resource_id", null);
        for (Bundle bundle2 : bundle.getParcelableArrayList(BundleKey.SHARE_FILE_LIST)) {
            this.mContentList.add(new Content(bundle2.getString(BundleKey.CONTENT_HASH, ""), bundle2.getString("mime_type", ""), Uri.parse(bundle2.getString(BundleKey.THUMBNAIL_URI, "")), bundle2.getString("file_name"), bundle2.getLong(BundleKey.FILE_SIZE, 0L), bundle2.getString("original_content_path", "")));
        }
    }
}
