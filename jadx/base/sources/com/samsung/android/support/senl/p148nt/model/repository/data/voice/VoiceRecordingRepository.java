package com.samsung.android.support.senl.p148nt.model.repository.data.voice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VoiceRecordingRepository implements VoiceRecordingDataSource {
    public static final Parcelable.Creator<VoiceRecordingRepository> CREATOR = new Parcelable.Creator<VoiceRecordingRepository>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.voice.VoiceRecordingRepository.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceRecordingRepository createFromParcel(Parcel parcel) {
            return new VoiceRecordingRepository(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceRecordingRepository[] newArray(int i) {
            return new VoiceRecordingRepository[i];
        }
    };
    int mContentIndex;
    String mFilePath;
    int mProcessId;
    int mTargetPageIndex;

    public VoiceRecordingRepository(String str, int i, int i2) {
        this.mFilePath = str;
        this.mContentIndex = i;
        this.mTargetPageIndex = i2;
        this.mProcessId = Process.myPid();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource
    public int getContentIndex() {
        return this.mContentIndex;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource
    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource
    public int getProcessId() {
        return this.mProcessId;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource
    public int getTargetPageIndex() {
        return this.mTargetPageIndex;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource
    public boolean isValid() {
        return (TextUtils.isEmpty(this.mFilePath) || this.mContentIndex <= -1 || this.mProcessId == 0) ? false : true;
    }

    public String toString() {
        return "VoiceRecordingInfo: " + Integer.toHexString(hashCode()) + ", filePath: " + getFilePath() + ", contentIndex: " + getContentIndex() + ", targetPageIndex: " + getTargetPageIndex() + ", processId: " + getProcessId();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFilePath);
        parcel.writeInt(this.mContentIndex);
        parcel.writeInt(this.mTargetPageIndex);
        parcel.writeInt(this.mProcessId);
    }

    public VoiceRecordingRepository(Parcel parcel) {
        this.mFilePath = parcel.readString();
        this.mContentIndex = parcel.readInt();
        this.mTargetPageIndex = parcel.readInt();
        this.mProcessId = parcel.readInt();
    }
}
