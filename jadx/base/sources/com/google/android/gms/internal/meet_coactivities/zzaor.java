package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzaor {
    private final zzabg[] zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    static {
        new zzaor(new zzabg[0]);
    }

    @VisibleForTesting
    public zzaor(zzabg[] zzabgVarArr) {
        this.zza = zzabgVarArr;
    }

    public static zzaor zza(zzwq[] zzwqVarArr, zzvy zzvyVar, zzzv zzzvVar) {
        zzaor zzaorVar = new zzaor(zzwqVarArr);
        for (zzwq zzwqVar : zzwqVarArr) {
        }
        return zzaorVar;
    }

    public final void zzb() {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            i++;
        }
    }

    public final void zzc(zzzv zzzvVar) {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            i++;
        }
    }

    public final void zzd() {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            i++;
        }
    }

    public final void zze(int i) {
        int i2 = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i2 >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i2];
            i2++;
        }
    }

    public final void zzf(int i, long j, long j2) {
        int i2 = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i2 >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i2];
            i2++;
        }
    }

    public final void zzg(long j) {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i];
            i++;
        }
    }

    public final void zzh(long j) {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i];
            i++;
        }
    }

    public final void zzi(int i) {
        int i2 = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i2 >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i2];
            i2++;
        }
    }

    public final void zzj(int i, long j, long j2) {
        int i2 = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i2 >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i2];
            i2++;
        }
    }

    public final void zzk(long j) {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            zzabg zzabgVar = zzabgVarArr[i];
            i++;
        }
    }

    public final void zzl(long j) {
        int i = 0;
        while (true) {
            zzabg[] zzabgVarArr = this.zza;
            if (i >= zzabgVarArr.length) {
                return;
            }
            zzabgVarArr[i].zza(j);
            i++;
        }
    }

    public final void zzm(zzabd zzabdVar) {
        if (this.zzb.compareAndSet(false, true)) {
            for (zzabg zzabgVar : this.zza) {
            }
        }
    }
}
