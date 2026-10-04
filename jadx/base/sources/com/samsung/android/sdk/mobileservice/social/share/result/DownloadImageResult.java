package com.samsung.android.sdk.mobileservice.social.share.result;

import android.net.Uri;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.common.result.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DownloadImageResult implements Result {
    private DownloadedImage mImage;
    private CommonResultStatus mStatus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadedImage {
        private String mHash;
        private Uri mImageUri;
        private String mItemId;

        public DownloadedImage(String str, String str2, Uri uri) {
            this.mItemId = str;
            this.mHash = str2;
            this.mImageUri = uri;
        }

        public String getHash() {
            return this.mHash;
        }

        public Uri getImageUri() {
            return this.mImageUri;
        }

        public String getItemId() {
            return this.mItemId;
        }
    }

    public DownloadImageResult(CommonResultStatus commonResultStatus, DownloadedImage downloadedImage) {
        this.mStatus = commonResultStatus;
        this.mImage = downloadedImage;
    }

    public DownloadedImage getResult() {
        return this.mImage;
    }

    @Override // com.samsung.android.sdk.mobileservice.common.result.Result
    public CommonResultStatus getStatus() {
        return this.mStatus;
    }
}
