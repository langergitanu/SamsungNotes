package com.samsung.android.scs.p140ai.sdkcommon.suggestion;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppCategoryDetail implements Parcelable {
    public static final Parcelable.Creator<AppCategoryDetail> CREATOR = new Parcelable.Creator<AppCategoryDetail>() { // from class: com.samsung.android.scs.ai.sdkcommon.suggestion.AppCategoryDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppCategoryDetail createFromParcel(Parcel parcel) {
            return AppCategoryDetail.readAppCategoryDataFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppCategoryDetail[] newArray(int i) {
            return new AppCategoryDetail[i];
        }
    };
    private int mCategoryId;
    private String mCategoryString;
    private String mPackageName;

    private AppCategoryDetail() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AppCategoryDetail readAppCategoryDataFromParcel(Parcel parcel) {
        AppCategoryDetail appCategoryDetail = new AppCategoryDetail();
        appCategoryDetail.mPackageName = parcel.readString();
        appCategoryDetail.mCategoryString = parcel.readString();
        appCategoryDetail.mCategoryId = parcel.readInt();
        return appCategoryDetail;
    }

    private void writeAppCategoryDataToParcel(Parcel parcel, AppCategoryDetail appCategoryDetail) {
        parcel.writeString(appCategoryDetail.mPackageName);
        parcel.writeString(appCategoryDetail.mCategoryString);
        parcel.writeInt(appCategoryDetail.mCategoryId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCategoryId() {
        return this.mCategoryId;
    }

    public String getCategoryString() {
        return this.mCategoryString;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setCategoryId(int i) {
        this.mCategoryId = i;
    }

    public void setCategoryString(String str) {
        this.mCategoryString = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppCategoryDetail{mPackageName='");
        sb.append(this.mPackageName);
        sb.append("', mCategoryString='");
        sb.append(this.mCategoryString);
        sb.append("', mCategoryId=");
        return AbstractC0000a.m13j(sb, this.mCategoryId, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeAppCategoryDataToParcel(parcel, this);
    }

    public AppCategoryDetail(String str, String str2, int i) {
        this.mPackageName = str;
        this.mCategoryString = str2;
        this.mCategoryId = i;
    }
}
