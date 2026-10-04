package com.samsung.android.sivs.p144ai.sdkcommon.tts;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TtsSpeakerInfo implements Parcelable {
    public static final Parcelable.Creator<TtsSpeakerInfo> CREATOR = new Parcelable.Creator<TtsSpeakerInfo>() { // from class: com.samsung.android.sivs.ai.sdkcommon.tts.TtsSpeakerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TtsSpeakerInfo createFromParcel(Parcel parcel) {
            return new TtsSpeakerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TtsSpeakerInfo[] newArray(int i) {
            return new TtsSpeakerInfo[i];
        }
    };
    private final String displayName;

    /* JADX INFO: renamed from: id */
    private final String f5427id;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TtsSpeakerInfo(String str, String str2) {
        this.f5427id = str;
        this.displayName = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof TtsSpeakerInfo)) {
            return false;
        }
        return this.f5427id.equals(((TtsSpeakerInfo) obj).f5427id);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.f5427id;
    }

    public int hashCode() {
        return Objects.hash(this.f5427id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Speaker {id='");
        sb.append(this.f5427id);
        sb.append("', Name='");
        return AbstractC0622a.m1170p(this.displayName, "'}", sb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5427id);
        parcel.writeString(this.displayName);
    }

    public TtsSpeakerInfo(Parcel parcel) {
        this.f5427id = parcel.readString();
        this.displayName = parcel.readString();
    }
}
