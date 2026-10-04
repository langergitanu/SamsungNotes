package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfFileInfo implements Parcelable {
    public static final Parcelable.Creator<PdfFileInfo> CREATOR = new Parcelable.Creator<PdfFileInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.model.PdfFileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PdfFileInfo createFromParcel(Parcel parcel) {
            return new PdfFileInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PdfFileInfo[] newArray(int i) {
            return new PdfFileInfo[i];
        }
    };
    private String mName;
    private String mPath;
    private boolean mSaveAs;

    public PdfFileInfo() {
        this.mName = "";
        this.mPath = "";
        this.mSaveAs = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public String getPath() {
        return this.mPath;
    }

    public boolean isSaveAs() {
        return this.mSaveAs;
    }

    public void setName(String str) {
        if (str == null) {
            return;
        }
        this.mName = str;
    }

    public void setPath(String str) {
        if (str == null) {
            return;
        }
        this.mPath = str;
    }

    public void setSaveAs(boolean z) {
        this.mSaveAs = z;
    }

    @NonNull
    public String toString() {
        return Logger.getEncode(this.mName) + " " + Logger.getEncode(this.mPath) + " " + this.mSaveAs;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mPath);
        parcel.writeByte(this.mSaveAs ? (byte) 1 : (byte) 0);
    }

    public PdfFileInfo(Parcel parcel) {
        this.mName = "";
        this.mPath = "";
        this.mSaveAs = true;
        this.mName = parcel.readString();
        this.mPath = parcel.readString();
        this.mSaveAs = parcel.readByte() != 0;
    }
}
