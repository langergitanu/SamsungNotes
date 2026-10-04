package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class zzto {
    protected volatile zzue zza;
    private volatile zzrq zzb;

    static {
        int i = zzsj.zzb;
        int i2 = zzum.zza;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzto)) {
            return false;
        }
        zzto zztoVar = (zzto) obj;
        zzue zzueVar = this.zza;
        zzue zzueVar2 = zztoVar.zza;
        if (zzueVar == null && zzueVar2 == null) {
            return zzb().equals(zztoVar.zzb());
        }
        if (zzueVar != null && zzueVar2 != null) {
            return zzueVar.equals(zzueVar2);
        }
        if (zzueVar != null) {
            zztoVar.zzd(zzueVar.zzT());
            return zzueVar.equals(zztoVar.zza);
        }
        zzd(zzueVar2.zzT());
        return this.zza.equals(zzueVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzrp) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzz();
        }
        return 0;
    }

    public final zzrq zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    return this.zzb;
                }
                if (this.zza == null) {
                    this.zzb = zzrq.zzb;
                } else {
                    this.zzb = this.zza.zzw();
                }
                return this.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzue zzc(zzue zzueVar) {
        zzue zzueVar2 = this.zza;
        this.zzb = null;
        this.zza = zzueVar;
        return zzueVar2;
    }

    public final void zzd(zzue zzueVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzueVar;
                this.zzb = zzrq.zzb;
            } catch (zzti unused) {
                this.zza = zzueVar;
                this.zzb = zzrq.zzb;
            }
        }
    }
}
