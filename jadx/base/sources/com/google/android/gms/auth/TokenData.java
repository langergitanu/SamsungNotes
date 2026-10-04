package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "TokenDataCreator")
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<TokenData> CREATOR = new zzm();

    @SafeParcelable.VersionField(m3230id = 1)
    final int zza;

    @SafeParcelable.Field(getter = "getToken", m3227id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", m3227id = 3)
    private final Long zzc;

    @SafeParcelable.Field(getter = "isCached", m3227id = 4)
    private final boolean zzd;

    @SafeParcelable.Field(getter = "isSnowballed", m3227id = 5)
    private final boolean zze;

    @Nullable
    @SafeParcelable.Field(getter = "getGrantedScopes", m3227id = 6)
    private final List zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getScopeData", m3227id = 7)
    private final String zzg;

    @SafeParcelable.Constructor
    public TokenData(@SafeParcelable.Param(m3228id = 1) int i, @SafeParcelable.Param(m3228id = 2) String str, @Nullable @SafeParcelable.Param(m3228id = 3) Long l, @SafeParcelable.Param(m3228id = 4) boolean z, @SafeParcelable.Param(m3228id = 5) boolean z2, @Nullable @SafeParcelable.Param(m3228id = 6) List list, @Nullable @SafeParcelable.Param(m3228id = 7) String str2) {
        this.zza = i;
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzc = l;
        this.zzd = z;
        this.zze = z2;
        this.zzf = list;
        this.zzg = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.zzb, tokenData.zzb) && Objects.equal(this.zzc, tokenData.zzc) && this.zzd == tokenData.zzd && this.zze == tokenData.zze && Objects.equal(this.zzf, tokenData.zzf) && Objects.equal(this.zzg, tokenData.zzg);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeLongObject(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @NonNull
    public final String zza() {
        return this.zzb;
    }
}
