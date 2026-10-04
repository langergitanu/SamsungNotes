package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i, boolean z, @Nullable String str2, @Nullable Throwable th) {
        this.zza = str;
        this.zzb = z;
        this.zzc = str2;
        this.zzd = th;
    }

    @NonNull
    public static PackageVerificationResult zza(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    @NonNull
    public static PackageVerificationResult zzd(@NonNull String str, int i) {
        return new PackageVerificationResult(str, i, true, null, null);
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        String strValueOf = String.valueOf(this.zzc);
        Throwable th = this.zzd;
        String strConcat = "PackageVerificationRslt: ".concat(strValueOf);
        if (th == null) {
            throw new SecurityException(strConcat);
        }
        throw new SecurityException(strConcat, th);
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
