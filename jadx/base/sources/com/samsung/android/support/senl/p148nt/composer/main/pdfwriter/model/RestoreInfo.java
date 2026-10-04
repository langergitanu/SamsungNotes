package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RestoreInfo implements Parcelable {
    public static final Parcelable.Creator<RestoreInfo> CREATOR = new Parcelable.Creator<RestoreInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.model.RestoreInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreInfo createFromParcel(Parcel parcel) {
            return new RestoreInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RestoreInfo[] newArray(int i) {
            return new RestoreInfo[i];
        }
    };
    PdfFileInfo mPdfFileInfo;
    String mSavePath;
    String mUuid;

    public RestoreInfo(String str, PdfFileInfo pdfFileInfo, String str2) {
        this.mUuid = str;
        this.mPdfFileInfo = pdfFileInfo;
        this.mSavePath = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PdfFileInfo getPdfFileInfo() {
        return this.mPdfFileInfo;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public String getUuid() {
        return this.mUuid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUuid);
        parcel.writeParcelable(this.mPdfFileInfo, i);
        parcel.writeString(this.mSavePath);
    }

    public RestoreInfo(Parcel parcel) {
        this.mUuid = parcel.readString();
        this.mPdfFileInfo = (PdfFileInfo) parcel.readParcelable(PdfFileInfo.class.getClassLoader());
        this.mSavePath = parcel.readString();
    }
}
