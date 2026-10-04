package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzahi implements zzaes {
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", zzo()).toString();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zza(zzahy zzahyVar) {
        zzo().zza(zzahyVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzb(zzabd zzabdVar) {
        zzo().zzb(zzabdVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzc() {
        zzo().zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzd() {
        zzo().zzd();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zze() {
        zzo().zze();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzf(int i) {
        zzo().zzf(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzg(zzwv zzwvVar) {
        zzo().zzg(zzwvVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzh(zzxi zzxiVar) {
        zzo().zzh(zzxiVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzi(zzxl zzxlVar) {
        zzo().zzi(zzxlVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzj(int i) {
        zzo().zzj(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public final void zzk(int i) {
        zzo().zzk(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaes
    public void zzl(zzaeu zzaeuVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final void zzm(InputStream inputStream) {
        zzo().zzm(inputStream);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaos
    public final boolean zzn() {
        return zzo().zzn();
    }

    public abstract zzaes zzo();
}
