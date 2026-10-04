package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzalw extends zzzd {
    private final zzyt zze;
    private zzza zzf;
    private zzwz zzg = zzwz.IDLE;

    public zzalw(zzyt zzytVar) {
        this.zze = (zzyt) Preconditions.checkNotNull(zzytVar, "helper");
    }

    public static /* bridge */ /* synthetic */ void zzg(zzalw zzalwVar, zzza zzzaVar, zzxa zzxaVar) {
        zzzb zzaltVar;
        zzwz zzwzVarZza = zzxaVar.zza();
        if (zzwzVarZza == zzwz.SHUTDOWN) {
            return;
        }
        zzwz zzwzVar = zzwz.TRANSIENT_FAILURE;
        if (zzwzVarZza == zzwzVar || zzwzVarZza == zzwz.IDLE) {
            zzalwVar.zze.zzd();
        }
        if (zzalwVar.zzg == zzwzVar) {
            if (zzwzVarZza == zzwz.CONNECTING) {
                return;
            }
            if (zzwzVarZza == zzwz.IDLE) {
                zzalwVar.zzd();
                return;
            }
        }
        int iOrdinal = zzwzVarZza.ordinal();
        if (iOrdinal == 0) {
            zzaltVar = new zzalt(zzyv.zzc());
        } else if (iOrdinal == 1) {
            zzaltVar = new zzalt(zzyv.zzd(zzzaVar, null));
        } else if (iOrdinal == 2) {
            zzaltVar = new zzalt(zzyv.zzb(zzxaVar.zzd()));
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(String.valueOf(zzwzVarZza)));
            }
            zzaltVar = new zzalv(zzalwVar, zzzaVar);
        }
        zzalwVar.zzh(zzwzVarZza, zzaltVar);
    }

    private final void zzh(zzwz zzwzVar, zzzb zzzbVar) {
        this.zzg = zzwzVar;
        this.zze.zze(zzwzVar, zzzbVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final zzabd zza(zzyz zzyzVar) {
        Boolean bool;
        List listZze = zzyzVar.zze();
        if (listZze.isEmpty()) {
            zzabd zzabdVarZze = zzabd.zzk.zze("NameResolver returned no usable address. addrs=" + String.valueOf(zzyzVar.zze()) + ", attrs=" + String.valueOf(zzyzVar.zza()));
            zzb(zzabdVarZze);
            return zzabdVarZze;
        }
        if ((zzyzVar.zzd() instanceof zzals) && (bool = ((zzals) zzyzVar.zzd()).zza) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listZze);
            Collections.shuffle(arrayList, new Random());
            listZze = arrayList;
        }
        zzza zzzaVar = this.zzf;
        if (zzzaVar == null) {
            zzyt zzytVar = this.zze;
            zzyn zzynVarZzb = zzyq.zzb();
            zzynVarZzb.zzb(listZze);
            zzza zzzaVarZza = zzytVar.zza(zzynVarZzb.zzc());
            zzzaVarZza.zzd(new zzalr(this, zzzaVarZza));
            this.zzf = zzzaVarZza;
            zzh(zzwz.CONNECTING, new zzalt(zzyv.zzd(zzzaVarZza, null)));
            zzzaVarZza.zzb();
        } else {
            zzzaVar.zze(listZze);
        }
        return zzabd.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zzb(zzabd zzabdVar) {
        zzza zzzaVar = this.zzf;
        if (zzzaVar != null) {
            zzzaVar.zzc();
            this.zzf = null;
        }
        zzh(zzwz.TRANSIENT_FAILURE, new zzalt(zzyv.zzb(zzabdVar)));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zzd() {
        zzza zzzaVar = this.zzf;
        if (zzzaVar != null) {
            zzzaVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzd
    public final void zze() {
        zzza zzzaVar = this.zzf;
        if (zzzaVar != null) {
            zzzaVar.zzc();
        }
    }
}
