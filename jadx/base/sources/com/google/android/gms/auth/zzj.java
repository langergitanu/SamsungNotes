package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzby;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzj implements zzk {
    final /* synthetic */ String zza;

    public zzj(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws IOException, GoogleAuthException {
        Bundle bundleZzg = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzg(this.zza);
        zzl.zzd(bundleZzg);
        String string = bundleZzg.getString("Error");
        Intent intent = (Intent) bundleZzg.getParcelable("userRecoveryIntent");
        zzby zzbyVarZza = zzby.zza(string);
        if (zzby.SUCCESS.equals(zzbyVarZza)) {
            return Boolean.TRUE;
        }
        if (!zzby.zzb(zzbyVarZza)) {
            throw new GoogleAuthException(string);
        }
        zzl.zzd.m3237w("isUserRecoverableError status: ".concat(String.valueOf(zzbyVarZza)), new Object[0]);
        throw new UserRecoverableAuthException(string, intent);
    }
}
