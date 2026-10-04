package com.samsung.android.sivs.p144ai.sdkcommon.translation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DetectionCandidate implements Parcelable {
    public static final Parcelable.Creator<DetectionCandidate> CREATOR = new Parcelable.Creator<DetectionCandidate>() { // from class: com.samsung.android.sivs.ai.sdkcommon.translation.DetectionCandidate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DetectionCandidate createFromParcel(Parcel parcel) {
            return new DetectionCandidate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DetectionCandidate[] newArray(int i) {
            return new DetectionCandidate[i];
        }
    };
    public String languageCode;
    public float probability;

    public DetectionCandidate(String str, float f) {
        this.languageCode = str;
        this.probability = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.languageCode);
        parcel.writeFloat(this.probability);
    }

    public DetectionCandidate(Parcel parcel) {
        this.languageCode = parcel.readString();
        this.probability = parcel.readFloat();
    }
}
