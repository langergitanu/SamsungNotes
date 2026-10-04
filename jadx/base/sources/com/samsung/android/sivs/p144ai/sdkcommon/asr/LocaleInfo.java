package com.samsung.android.sivs.p144ai.sdkcommon.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.glance.AbstractC2821a;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LocaleInfo implements Parcelable {
    public static final Parcelable.Creator<LocaleInfo> CREATOR = new Parcelable.Creator<LocaleInfo>() { // from class: com.samsung.android.sivs.ai.sdkcommon.asr.LocaleInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocaleInfo createFromParcel(Parcel parcel) {
            return new LocaleInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocaleInfo[] newArray(int i) {
            return new LocaleInfo[i];
        }
    };
    private final String mDisplayName;
    private final Locale mLocale;
    private final int mOrder;

    public LocaleInfo(Locale locale, String str, int i) {
        this.mLocale = locale;
        this.mDisplayName = str;
        this.mOrder = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof LocaleInfo) && this.mLocale == ((LocaleInfo) obj).mLocale;
    }

    @Nullable
    public String getDisplayName() {
        return this.mDisplayName;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public int hashCode() {
        return Objects.hash(this.mLocale.toLanguageTag());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocaleInfo{Locale=");
        sb.append(this.mLocale);
        sb.append(", DisplayName='");
        sb.append(this.mDisplayName);
        sb.append("', Order='");
        return AbstractC2821a.m2223n(sb, "'}", this.mOrder);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.mLocale);
        parcel.writeString(this.mDisplayName);
        parcel.writeInt(this.mOrder);
    }

    public LocaleInfo(Parcel parcel) {
        this.mLocale = (Locale) parcel.readSerializable();
        this.mDisplayName = parcel.readString();
        this.mOrder = parcel.readInt();
    }
}
