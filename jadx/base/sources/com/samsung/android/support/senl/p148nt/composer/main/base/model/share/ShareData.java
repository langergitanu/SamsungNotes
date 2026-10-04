package com.samsung.android.support.senl.p148nt.composer.main.base.model.share;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareData implements Parcelable {
    public static final Parcelable.Creator<ShareData> CREATOR = new Parcelable.Creator<ShareData>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.share.ShareData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareData createFromParcel(Parcel parcel) {
            return new ShareData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareData[] newArray(int i) {
            return new ShareData[i];
        }
    };
    private long mCreatedTime;
    private final long mLastModifiedTime;
    private String mNewPath;
    private String mPath;
    private ShareTo mShareTo;
    private final String mTitle;
    private final String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ShareTo {
        private String mActivity;
        private String mPackage;

        public void setActivity(String str) {
            this.mActivity = str;
        }

        public void setPackage(String str) {
            this.mPackage = str;
        }
    }

    public ShareData(@NonNull String str, @NonNull String str2, String str3, long j) {
        this.mPath = str;
        this.mUuid = str2;
        this.mTitle = Restriction.getTitleForFileName(str3);
        this.mLastModifiedTime = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public long getLastModifiedTime() {
        return this.mLastModifiedTime;
    }

    public String getNewPath() {
        return this.mNewPath;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void setShareTo(Intent intent) {
        ShareTo shareTo = this.mShareTo;
        if (shareTo != null) {
            intent.setPackage(shareTo.mPackage);
            intent.setClassName(this.mShareTo.mPackage, this.mShareTo.mActivity);
        }
    }

    public void setShareToInfo(ShareTo shareTo) {
        this.mShareTo = shareTo;
    }

    public void syncPath() {
        this.mPath = this.mNewPath;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPath);
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mCreatedTime);
        parcel.writeLong(this.mLastModifiedTime);
        parcel.writeString(this.mNewPath);
    }

    public ShareData(@NonNull String str, @NonNull String str2, String str3, long j, long j2, String str4) {
        this(str, str2, str3, j2);
        this.mCreatedTime = j;
        this.mNewPath = str4;
    }

    public ShareData(Parcel parcel) {
        this.mPath = parcel.readString();
        this.mUuid = parcel.readString();
        this.mTitle = parcel.readString();
        this.mCreatedTime = parcel.readLong();
        this.mLastModifiedTime = parcel.readLong();
        this.mNewPath = parcel.readString();
    }
}
