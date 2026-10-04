package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzjt implements zzns {
    private final zzjr zznx;

    private zzjt(zzjr zzjrVar) {
        zzjr zzjrVar2 = (zzjr) zzkm.zza(zzjrVar, "output");
        this.zznx = zzjrVar2;
        zzjrVar2.zzoh = this;
    }

    public static zzjt zza(zzjr zzjrVar) {
        zzjt zzjtVar = zzjrVar.zzoh;
        return zzjtVar != null ? zzjtVar : new zzjt(zzjrVar);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzak(int i) {
        this.zznx.zzb(i, 3);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzal(int i) {
        this.zznx.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i, boolean z) {
        this.zznx.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzc(int i, int i2) {
        this.zznx.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final int zzcd() {
        return zzkk.zze.zzsi;
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzd(int i, int i2) {
        this.zznx.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zze(int i, int i2) {
        this.zznx.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzf(int i, int i2) {
        this.zznx.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzb = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzb += zzjr.zzb(list.get(i4).doubleValue());
        }
        this.zznx.zzy(iZzb);
        while (i2 < list.size()) {
            this.zznx.zza(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zzc(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzah = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzah += zzjr.zzah(list.get(i4).intValue());
        }
        this.zznx.zzy(iZzah);
        while (i2 < list.size()) {
            this.zznx.zzx(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzi(int i, long j) {
        this.zznx.zza(i, j);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzj(int i, long j) {
        this.zznx.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzag += zzjr.zzag(list.get(i4).intValue());
        }
        this.zznx.zzy(iZzag);
        while (i2 < list.size()) {
            this.zznx.zzaa(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzs = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzs += zzjr.zzs(list.get(i4).longValue());
        }
        this.zznx.zzy(iZzs);
        while (i2 < list.size()) {
            this.zznx.zzn(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzm(int i, int i2) {
        this.zznx.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzn(int i, int i2) {
        this.zznx.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i, long j) {
        this.zznx.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzc(int i, long j) {
        this.zznx.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzp = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzp += zzjr.zzp(list.get(i4).longValue());
        }
        this.zznx.zzy(iZzp);
        while (i2 < list.size()) {
            this.zznx.zzl(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzr = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzr += zzjr.zzr(list.get(i4).longValue());
        }
        this.zznx.zzy(iZzr);
        while (i2 < list.size()) {
            this.zznx.zzn(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zznx.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zznx.zzb(i, 2);
        int iZzb = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzb += zzjr.zzb(list.get(i4).floatValue());
        }
        this.zznx.zzy(iZzb);
        while (i2 < list.size()) {
            this.zznx.zza(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, float f) {
        this.zznx.zza(i, f);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i, Object obj, zzmf zzmfVar) {
        zzjr zzjrVar = this.zznx;
        zzjrVar.zzb(i, 3);
        zzmfVar.zza((zzlq) obj, zzjrVar.zzoh);
        zzjrVar.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzo = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzo += zzjr.zzo(list.get(i4).longValue());
            }
            this.zznx.zzy(iZzo);
            while (i2 < list.size()) {
                this.zznx.zzl(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzd = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzd += zzjr.zzd(list.get(i4).booleanValue());
            }
            this.zznx.zzy(iZzd);
            while (i2 < list.size()) {
                this.zznx.zzc(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzad = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzad += zzjr.zzad(list.get(i4).intValue());
            }
            this.zznx.zzy(iZzad);
            while (i2 < list.size()) {
                this.zznx.zzy(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzae = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzae += zzjr.zzae(list.get(i4).intValue());
            }
            this.zznx.zzy(iZzae);
            while (i2 < list.size()) {
                this.zznx.zzz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzq = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzq += zzjr.zzq(list.get(i4).longValue());
            }
            this.zznx.zzy(iZzq);
            while (i2 < list.size()) {
                this.zznx.zzm(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, double d) {
        this.zznx.zza(i, d);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, long j) {
        this.zznx.zza(i, j);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, String str) {
        this.zznx.zza(i, str);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, zzjc zzjcVar) {
        this.zznx.zza(i, zzjcVar);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzaf = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzaf += zzjr.zzaf(list.get(i4).intValue());
            }
            this.zznx.zzy(iZzaf);
            while (i2 < list.size()) {
                this.zznx.zzaa(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, Object obj, zzmf zzmfVar) {
        this.zznx.zza(i, (zzlq) obj, zzmfVar);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, Object obj) {
        if (obj instanceof zzjc) {
            this.zznx.zzb(i, (zzjc) obj);
        } else {
            this.zznx.zza(i, (zzlq) obj);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zznx.zzb(i, 2);
            int iZzac = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZzac += zzjr.zzac(list.get(i4).intValue());
            }
            this.zznx.zzy(iZzac);
            while (i2 < list.size()) {
                this.zznx.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i, List<zzjc> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zznx.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i, List<?> list, zzmf zzmfVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzmfVar);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzkz) {
            zzkz zzkzVar = (zzkz) list;
            while (i2 < list.size()) {
                Object objZzao = zzkzVar.zzao(i2);
                if (objZzao instanceof String) {
                    this.zznx.zza(i, (String) objZzao);
                } else {
                    this.zznx.zza(i, (zzjc) objZzao);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zznx.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i, List<?> list, zzmf zzmfVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzmfVar);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final <K, V> void zza(int i, zzlj<K, V> zzljVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zznx.zzb(i, 2);
            this.zznx.zzy(zzli.zza(zzljVar, entry.getKey(), entry.getValue()));
            zzli.zza(this.zznx, zzljVar, entry.getKey(), entry.getValue());
        }
    }
}
