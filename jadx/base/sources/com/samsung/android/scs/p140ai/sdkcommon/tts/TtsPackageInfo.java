package com.samsung.android.scs.p140ai.sdkcommon.tts;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.C2747a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TtsPackageInfo implements Parcelable {
    public static final Parcelable.Creator<TtsPackageInfo> CREATOR = new Parcelable.Creator<TtsPackageInfo>() { // from class: com.samsung.android.scs.ai.sdkcommon.tts.TtsPackageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TtsPackageInfo createFromParcel(Parcel parcel) {
            return new TtsPackageInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TtsPackageInfo[] newArray(int i) {
            return new TtsPackageInfo[i];
        }
    };
    private Bundle mExtras;
    private final String mPackageName;
    private final List<TtsSpeakerInfo> mSpeakerList;
    private final TtsPackageType mType;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TtsPackageInfo(String str, TtsPackageType ttsPackageType, List<TtsSpeakerInfo> list) {
        this.mPackageName = str;
        this.mType = ttsPackageType;
        this.mSpeakerList = (List) Optional.ofNullable(list).orElseGet(new C2747a(2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof TtsPackageInfo)) {
            TtsPackageInfo ttsPackageInfo = (TtsPackageInfo) obj;
            if (this.mType == ttsPackageInfo.mType && this.mPackageName.equals(ttsPackageInfo.mPackageName)) {
                return true;
            }
        }
        return false;
    }

    public Bundle getExtras() {
        return (Bundle) Optional.ofNullable(this.mExtras).orElse(Bundle.EMPTY);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public List<TtsSpeakerInfo> getSpeakerInfo() {
        return this.mSpeakerList;
    }

    public TtsPackageType getType() {
        return this.mType;
    }

    public int hashCode() {
        return Objects.hash(this.mPackageName + this.mType);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setExtras(Bundle bundle) {
        if (bundle != null) {
            this.mExtras = bundle;
        }
    }

    public String toString() {
        return "TtsPackageInfo{mPackageName='" + this.mPackageName + "', mSpeakerList=" + this.mSpeakerList.size() + ", mType=" + this.mType + ", mExtras=" + this.mExtras + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mType.toString());
        parcel.writeList(this.mSpeakerList);
        parcel.writeBundle((Bundle) Optional.ofNullable(this.mExtras).orElse(Bundle.EMPTY));
    }

    public TtsPackageInfo(Parcel parcel) {
        this.mPackageName = parcel.readString();
        this.mType = TtsPackageType.valueOf(parcel.readString());
        ArrayList arrayList = new ArrayList();
        this.mSpeakerList = arrayList;
        parcel.readList(arrayList, TtsSpeakerInfo.class.getClassLoader());
        this.mExtras = parcel.readBundle();
    }
}
