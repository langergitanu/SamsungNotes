package com.samsung.android.scs.p140ai.sdkcommon.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpeechInfo implements Parcelable {
    public static final Parcelable.Creator<SpeechInfo> CREATOR = new Parcelable.Creator<SpeechInfo>() { // from class: com.samsung.android.scs.ai.sdkcommon.asr.SpeechInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpeechInfo createFromParcel(Parcel parcel) {
            return new SpeechInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpeechInfo[] newArray(int i) {
            return new SpeechInfo[i];
        }
    };
    private final int endTime;
    private final int speaker;
    private final int startTime;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpeechInfo(int i, int i2, int i4) {
        this.speaker = i;
        this.startTime = i2;
        this.endTime = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getSpeaker() {
        return this.speaker;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SpeechInfo{speaker=");
        sb.append(this.speaker);
        sb.append(", startTime=");
        sb.append(this.startTime);
        sb.append(", endTime=");
        return AbstractC0000a.m13j(sb, this.endTime, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.speaker);
        parcel.writeInt(this.startTime);
        parcel.writeInt(this.endTime);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpeechInfo(Parcel parcel) {
        this.speaker = parcel.readInt();
        this.startTime = parcel.readInt();
        this.endTime = parcel.readInt();
    }
}
