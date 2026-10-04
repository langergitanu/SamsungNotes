package com.samsung.android.support.senl.p148nt.composer.main.base.model.info;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocInfo implements Parcelable {
    public static final String KEY_DOC_INFO = "docInfo";
    private ErrorType mErrorType;
    private OpenType mOpenType;
    private String mRawDocPath;
    private String mUuid;
    private static final String TAG = Logger.createTag("DocInfo");
    public static final Parcelable.Creator<DocInfo> CREATOR = new Parcelable.Creator<DocInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.info.DocInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocInfo createFromParcel(Parcel parcel) {
            return new DocInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocInfo[] newArray(int i) {
            return new DocInfo[i];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorType {
        None,
        UnsupportedFileType
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum OpenType {
        None,
        New,
        Open,
        OpenByView,
        OpenByShare
    }

    public DocInfo(OpenType openType, String str, String str2) {
        init(openType, str, ErrorType.None, str2);
    }

    public static DocInfo restoreFromSavedInstance(Bundle bundle) {
        return (DocInfo) bundle.getParcelable(KEY_DOC_INFO);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDocPath() {
        return this.mRawDocPath;
    }

    public OpenType getOpenType() {
        return this.mOpenType;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void init(OpenType openType, String str, ErrorType errorType, String str2) {
        this.mOpenType = openType;
        this.mRawDocPath = str;
        this.mErrorType = errorType;
        this.mUuid = str2;
    }

    public boolean isInvalid() {
        return this.mErrorType != ErrorType.None;
    }

    public boolean isOpenType(OpenType openType) {
        return this.mOpenType.equals(openType);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(KEY_DOC_INFO, this);
    }

    public void setDocPath(String str) {
        this.mRawDocPath = str;
    }

    public void setOpenType(OpenType openType) {
        this.mOpenType = openType;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    @NonNull
    public String toString() {
        return "Type: " + this.mOpenType.toString() + ", Err: " + this.mErrorType.toString() + ", P: " + Logger.getEncode(this.mRawDocPath);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mOpenType.ordinal());
        parcel.writeString(this.mRawDocPath);
        parcel.writeString(this.mUuid);
    }

    public DocInfo(OpenType openType, String str, ErrorType errorType, String str2) {
        init(openType, str, errorType, str2);
    }

    public DocInfo(Parcel parcel) {
        this.mOpenType = OpenType.values()[parcel.readInt()];
        this.mRawDocPath = parcel.readString();
        this.mErrorType = ErrorType.None;
        this.mUuid = parcel.readString();
    }
}
