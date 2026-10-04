package com.google.android.gms.internal.meet_coactivities;

import java.util.logging.Level;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkz extends zzko {
    private static final zzky zza = new zzky(null);

    public zzkz(zzmn zzmnVar) {
        super(zzmnVar);
    }

    @Nonnull
    @Deprecated
    public static zzkz zzj(String str) {
        zzpi.zzc(!str.isEmpty(), "injected class name is empty");
        return new zzkz(zznr.zzd(str.replace('/', '.')));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzko
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzkv zza(Level level) {
        boolean zZzh = zzh(level);
        zznr.zzn(zzf(), level, zZzh);
        return !zZzh ? zza : new zzkw(this, level, false);
    }
}
