package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzod extends zzoj {
    private static final zzod zza = new zzod(zzoj.zze());
    private final AtomicReference zzb;

    public zzod(zzoj zzojVar) {
        this.zzb = new AtomicReference(zzojVar);
    }

    public static final zzod zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoj
    public final zzmr zza() {
        return ((zzoj) this.zzb.get()).zza();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoj
    public final zzov zzc() {
        return ((zzoj) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzoj
    public final boolean zzd(String str, Level level, boolean z) {
        ((zzoj) this.zzb.get()).zzd(str, level, z);
        return false;
    }
}
