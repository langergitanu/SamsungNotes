package com.google.android.meet.addons;

import androidx.annotation.Nullable;
import com.google.android.meet.addons.AddonException;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zza {
    public static AddonException zza(AddonException.Code code) {
        return new AddonException(null, code, Optional.empty());
    }

    public static AddonException zzb(String str) {
        return new AddonException(str, AddonException.Code.UNKNOWN, Optional.empty());
    }

    public static AddonException zzc(@Nullable String str, AddonException.Code code) {
        return new AddonException(str, code, Optional.empty());
    }

    public static AddonException zzd(@Nullable String str, AddonException.Code code, String str2) {
        zzc zzcVar = new zzc();
        zzcVar.zza(str2);
        return new AddonException(str, code, Optional.of(zzcVar.zzb()));
    }
}
