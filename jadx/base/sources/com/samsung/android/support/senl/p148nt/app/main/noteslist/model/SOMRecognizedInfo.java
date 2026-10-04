package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizedInfo implements Parcelable {
    public static final Parcelable.Creator<SOMRecognizedInfo> CREATOR = new Parcelable.Creator<SOMRecognizedInfo>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.SOMRecognizedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SOMRecognizedInfo createFromParcel(Parcel parcel) {
            return new SOMRecognizedInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SOMRecognizedInfo[] newArray(int i) {
            return new SOMRecognizedInfo[i];
        }
    };
    private boolean mIsSelected;
    private final long mLastModifiedTime;
    private final String mOriginalText;
    private final String mRecognizedLanguage;
    private final String mRecognizerDBVersion;
    private final SpannableStringBuilder mTextInfo;
    private final String mUuid;

    public SOMRecognizedInfo() {
        this("", "", SpannableStringBuilder.valueOf(""), "", "", 0L);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SOMRecognizedInfo)) {
            return false;
        }
        SOMRecognizedInfo sOMRecognizedInfo = (SOMRecognizedInfo) obj;
        if (this.mUuid.equals(sOMRecognizedInfo.mUuid) && this.mRecognizedLanguage.equals(sOMRecognizedInfo.mRecognizedLanguage) && this.mRecognizerDBVersion.equals(sOMRecognizedInfo.mRecognizerDBVersion) && this.mLastModifiedTime == sOMRecognizedInfo.mLastModifiedTime) {
            return this.mOriginalText.equals(sOMRecognizedInfo.mOriginalText);
        }
        return false;
    }

    public long getLastModifiedTime() {
        return this.mLastModifiedTime;
    }

    public String getOriginalText() {
        return this.mOriginalText;
    }

    public String getRecognizedLanguage() {
        return this.mRecognizedLanguage;
    }

    public String getRecognizerDBVersion() {
        return this.mRecognizerDBVersion;
    }

    public SpannableStringBuilder getTextInfo() {
        return this.mTextInfo;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public boolean setIsSelected(boolean z) {
        if (this.mIsSelected == z) {
            return false;
        }
        this.mIsSelected = z;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mOriginalText);
        TextUtils.writeToParcel(this.mTextInfo, parcel, i);
        parcel.writeString(this.mRecognizedLanguage);
        parcel.writeString(this.mRecognizerDBVersion);
        parcel.writeLong(this.mLastModifiedTime);
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.writeBoolean(this.mIsSelected);
        }
    }

    public SOMRecognizedInfo(String str, String str2, SpannableStringBuilder spannableStringBuilder, String str3, String str4, long j) {
        this.mUuid = str;
        this.mOriginalText = str2;
        this.mTextInfo = spannableStringBuilder;
        this.mRecognizedLanguage = str3;
        this.mRecognizerDBVersion = str4;
        this.mLastModifiedTime = j;
    }

    public SOMRecognizedInfo(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), SpannableStringBuilder.valueOf((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel)), parcel.readString(), parcel.readString(), parcel.readLong());
        if (Build.VERSION.SDK_INT >= 29) {
            this.mIsSelected = parcel.readBoolean();
        }
    }
}
