package com.google.android.gms.internal.meet_coactivities;

import android.os.Parcel;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzacp extends zzact {
    private final boolean zzg;

    @GuardedBy("this")
    @Nullable
    private zzabd zzh;

    @GuardedBy("this")
    @Nullable
    private zzzv zzi;

    public zzacp(zzacl zzaclVar, zzvy zzvyVar, int i, boolean z) {
        super(zzaclVar, zzvyVar, i, null);
        this.zzg = z;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.meet_coactivities.zzaeu, com.google.android.gms.internal.meet_coactivities.zzaou] */
    @Override // com.google.android.gms.internal.meet_coactivities.zzact
    @GuardedBy("this")
    public final void zza(zzabd zzabdVar) {
        this.zzf.zzd(zzabdVar, zzaet.PROCESSED, new zzzv());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.meet_coactivities.zzaeu, com.google.android.gms.internal.meet_coactivities.zzaou] */
    @Override // com.google.android.gms.internal.meet_coactivities.zzact
    @GuardedBy("this")
    public final void zzb() {
        this.zze.zzc(this.zzi);
        this.zze.zzm(this.zzh);
        zzl(zzacq.CLOSED);
        this.zzf.zzd(this.zzh, zzaet.PROCESSED, this.zzi);
        this.zza.zzn(this);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.internal.meet_coactivities.zzaeu, com.google.android.gms.internal.meet_coactivities.zzaou] */
    @Override // com.google.android.gms.internal.meet_coactivities.zzact
    @GuardedBy("this")
    public final void zzc(int i, Parcel parcel) {
        zzzv zzzvVarZza = zzacw.zza(parcel, this.zzb);
        this.zze.zzb();
        this.zzf.zze(zzzvVarZza);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzact
    @GuardedBy("this")
    public final void zzd(int i, Parcel parcel) {
        this.zzh = zzado.zza(i, parcel);
        this.zzi = zzacw.zza(parcel, this.zzb);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzact
    public final boolean zze() {
        return this.zzg;
    }
}
