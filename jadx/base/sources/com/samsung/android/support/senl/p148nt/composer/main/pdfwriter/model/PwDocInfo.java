package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwDocInfo extends DocInfo {
    public static final Parcelable.Creator<DocInfo> CREATOR = new Parcelable.Creator<DocInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.model.PwDocInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocInfo createFromParcel(Parcel parcel) {
            return new PwDocInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocInfo[] newArray(int i) {
            return new PwDocInfo[i];
        }
    };
    private PdfFileInfo mPdfFileInfo;

    public PwDocInfo(DocInfo.OpenType openType, String str, String str2) {
        super(openType, str, str2);
    }

    public PdfFileInfo getPdfFileInfo() {
        return this.mPdfFileInfo;
    }

    public void setPdfFileInfo(PdfFileInfo pdfFileInfo) {
        this.mPdfFileInfo = pdfFileInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo
    @NonNull
    public String toString() {
        return super.toString() + "\t" + this.mPdfFileInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mPdfFileInfo, i);
    }

    public PwDocInfo(DocInfo.OpenType openType, String str, DocInfo.ErrorType errorType, String str2) {
        super(openType, str, errorType, str2);
    }

    public PwDocInfo(Parcel parcel) {
        super(parcel);
        this.mPdfFileInfo = (PdfFileInfo) parcel.readParcelable(PdfFileInfo.class.getClassLoader());
    }
}
