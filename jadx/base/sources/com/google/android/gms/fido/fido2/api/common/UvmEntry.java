package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "UvmEntryCreator")
public class UvmEntry extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<UvmEntry> CREATOR = new zzba();

    @SafeParcelable.Field(getter = "getUserVerificationMethod", m3227id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getKeyProtectionType", m3227id = 2)
    private final short zzb;

    @SafeParcelable.Field(getter = "getMatcherProtectionType", m3227id = 3)
    private final short zzc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private int zza;
        private short zzb;
        private short zzc;

        @NonNull
        public UvmEntry build() {
            return new UvmEntry(this.zza, this.zzb, this.zzc);
        }

        @NonNull
        public Builder setKeyProtectionType(short s) {
            this.zzb = s;
            return this;
        }

        @NonNull
        public Builder setMatcherProtectionType(short s) {
            this.zzc = s;
            return this;
        }

        @NonNull
        public Builder setUserVerificationMethod(int i) {
            this.zza = i;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public UvmEntry(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) short s, @SafeParcelable.Param(m3228id = 3) short s2) {
        this.zza = i;
        this.zzb = s;
        this.zzc = s2;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof UvmEntry)) {
            return false;
        }
        UvmEntry uvmEntry = (UvmEntry) obj;
        return this.zza == uvmEntry.zza && this.zzb == uvmEntry.zzb && this.zzc == uvmEntry.zzc;
    }

    public short getKeyProtectionType() {
        return this.zzb;
    }

    public short getMatcherProtectionType() {
        return this.zzc;
    }

    public int getUserVerificationMethod() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Short.valueOf(this.zzb), Short.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getUserVerificationMethod());
        SafeParcelWriter.writeShort(parcel, 2, getKeyProtectionType());
        SafeParcelWriter.writeShort(parcel, 3, getMatcherProtectionType());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
