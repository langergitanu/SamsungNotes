package com.samsung.android.sdk.mobileservice.social.share.result;

import android.net.Uri;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContentDownloadResult implements Result {
    private ArrayList<DownloadedContent> mFailureList;
    private CommonResultStatus mStatus;
    private ArrayList<DownloadedContent> mSuccessList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadedContent {
        private Uri mContentUri;
        private long mFileSize;
        private Uri mFileUri;
        private String mHash;
        private String mItemId;
        private String mMimeType;
        private String mSpaceId;

        public DownloadedContent(String str, String str2, String str3, Uri uri, Uri uri2, String str4, long j) {
            this.mSpaceId = str;
            this.mItemId = str2;
            this.mFileUri = uri;
            this.mContentUri = uri2;
            this.mMimeType = str4;
            this.mHash = str3;
            this.mFileSize = j;
        }

        public Uri getContentUri() {
            return this.mContentUri;
        }

        public long getFileSize() {
            return this.mFileSize;
        }

        public Uri getFileUri() {
            return this.mFileUri;
        }

        public String getHash() {
            return this.mHash;
        }

        public String getItemId() {
            return this.mItemId;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        public String getSpaceId() {
            return this.mSpaceId;
        }
    }

    public ContentDownloadResult(CommonResultStatus commonResultStatus, ArrayList<DownloadedContent> arrayList, ArrayList<DownloadedContent> arrayList2) {
        this.mStatus = commonResultStatus;
        this.mSuccessList = arrayList;
        this.mFailureList = arrayList2;
    }

    public List<DownloadedContent> getFailedList() {
        return this.mFailureList;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }

    public List<DownloadedContent> getSuccessList() {
        return this.mSuccessList;
    }
}
