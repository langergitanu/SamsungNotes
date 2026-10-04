package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.InputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzadn implements zzaes {
    private final zzacp zza;
    private final zzadd zzb;

    @Nullable
    private InputStream zzc;

    @Nullable
    private zzxi zzd;

    public zzadn(zzacp zzacpVar, zzadd zzaddVar, zzvy zzvyVar) {
        this.zza = zzacpVar;
        this.zzb = zzaddVar;
    }

    public final String toString() {
        return AbstractC0541b.m775q("SingleMessageClientStream[", this.zza.toString(), "/", this.zzb.toString(), "]");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzb(zzabd zzabdVar) {
        synchronized (this.zza) {
            this.zza.zzh(zzabdVar);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzd() {
        try {
            synchronized (this.zzb) {
                try {
                    zzxi zzxiVar = this.zzd;
                    if (zzxiVar != null) {
                        this.zzb.zzb(zzxiVar);
                    }
                    this.zzb.zze();
                    zzadd zzaddVar = this.zzb;
                    InputStream inputStream = this.zzc;
                    if (inputStream != null) {
                        zzaddVar.zzd(inputStream);
                    }
                    zzaddVar.zzf();
                    zzaddVar.zzg();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (zzabe e) {
            synchronized (this.zza) {
                this.zza.zzg(e.zza());
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzf(int i) {
        synchronized (this.zza) {
            this.zza.zzn(i);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzh(@Nonnull zzxi zzxiVar) {
        this.zzd = zzxiVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzl(zzaeu zzaeuVar) {
        synchronized (this.zza) {
            this.zza.zzk(this.zzb, zzaeuVar);
        }
        if (this.zzb.zzh()) {
            zzaeuVar.zzg();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzm(InputStream inputStream) {
        if (this.zzc == null) {
            this.zzc = inputStream;
            return;
        }
        synchronized (this.zza) {
            this.zza.zzg(zzabd.zzj.zze("too many messages"));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final boolean zzn() {
        return this.zzb.zzh();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zza(zzahy zzahyVar) {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzg(zzwv zzwvVar) {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzi(zzxl zzxlVar) {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzj(int i) {
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzk(int i) {
    }
}
