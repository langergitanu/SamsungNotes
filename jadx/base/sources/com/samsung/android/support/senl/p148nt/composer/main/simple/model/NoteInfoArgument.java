package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NoteInfoArgument implements Parcelable {
    public static final Parcelable.Creator<NoteInfoArgument> CREATOR = new Parcelable.Creator<NoteInfoArgument>() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.model.NoteInfoArgument.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteInfoArgument createFromParcel(Parcel parcel) {
            return new NoteInfoArgument(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteInfoArgument[] newArray(int i) {
            return new NoteInfoArgument[i];
        }
    };
    public static String KEY_BUNDLE = "NoteInfoArgument";
    private final boolean mIsNeededClose;
    private final boolean mIsNeededDownload;
    private final String mLockAccountGuid;
    private final String mPath;
    private final String mUuid;

    public NoteInfoArgument(String str, String str2, boolean z, boolean z2) {
        this(str, str2, null, z, z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLockAccountGuid() {
        return this.mLockAccountGuid;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public boolean isNeededClose() {
        return this.mIsNeededClose;
    }

    public boolean isNeededDownload() {
        return this.mIsNeededDownload;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mPath);
        parcel.writeString(this.mLockAccountGuid);
        parcel.writeByte(this.mIsNeededClose ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsNeededDownload ? (byte) 1 : (byte) 0);
    }

    public NoteInfoArgument(String str, String str2, String str3, boolean z, boolean z2) {
        this.mUuid = str;
        this.mPath = str2;
        this.mLockAccountGuid = str3;
        this.mIsNeededClose = z;
        this.mIsNeededDownload = z2;
    }

    public NoteInfoArgument(Parcel parcel) {
        this.mUuid = parcel.readString();
        this.mPath = parcel.readString();
        this.mLockAccountGuid = parcel.readString();
        this.mIsNeededClose = parcel.readByte() != 0;
        this.mIsNeededDownload = parcel.readByte() != 0;
    }
}
