package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.meet.addons.AddonSessionHandler;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzgb extends zzil {
    private final Context zza;
    private final zzcf zzb;
    private final String zzc;
    private final zzp zzd;
    private final AddonSessionHandler zze;

    public /* synthetic */ zzgb(Context context, zzcf zzcfVar, String str, zzp zzpVar, AddonSessionHandler addonSessionHandler, zzga zzgaVar) {
        this.zza = context;
        this.zzb = zzcfVar;
        this.zzc = str;
        this.zzd = zzpVar;
        this.zze = addonSessionHandler;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzil) {
            zzil zzilVar = (zzil) obj;
            if (this.zza.equals(zzilVar.zza()) && this.zzb.equals(zzilVar.zzc()) && this.zzc.equals(zzilVar.zze()) && this.zzd.equals(zzilVar.zzb()) && this.zze.equals(zzilVar.zzd())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        AddonSessionHandler addonSessionHandler = this.zze;
        zzp zzpVar = this.zzd;
        zzcf zzcfVar = this.zzb;
        String string = this.zza.toString();
        String string2 = zzcfVar.toString();
        String string3 = zzpVar.toString();
        String string4 = addonSessionHandler.toString();
        StringBuilder sbM16m = AbstractC0000a.m16m("LiveSharingConnection{appContext=", string, ", ipcManager=", string2, ", activityName=");
        AbstractC2821a.m2207B(sbM16m, this.zzc, ", startInfo=", string3, ", addonSessionHandler=");
        return AbstractC0622a.m1170p(string4, "}", sbM16m);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzil
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzil
    public final zzp zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzil
    public final zzcf zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzil
    public final AddonSessionHandler zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzil
    public final String zze() {
        return this.zzc;
    }
}
