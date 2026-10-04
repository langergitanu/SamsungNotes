package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzge extends zzin {
    private final ListeningExecutorService zza;
    private final ListeningScheduledExecutorService zzb;
    private final ListeningExecutorService zzc;
    private final ListeningExecutorService zzd;
    private final ListeningExecutorService zze;
    private final ListeningExecutorService zzf;

    public /* synthetic */ zzge(ListeningExecutorService listeningExecutorService, ListeningScheduledExecutorService listeningScheduledExecutorService, ListeningExecutorService listeningExecutorService2, ListeningExecutorService listeningExecutorService3, ListeningExecutorService listeningExecutorService4, ListeningExecutorService listeningExecutorService5, zzgd zzgdVar) {
        this.zza = listeningExecutorService;
        this.zzb = listeningScheduledExecutorService;
        this.zzc = listeningExecutorService2;
        this.zzd = listeningExecutorService3;
        this.zze = listeningExecutorService4;
        this.zzf = listeningExecutorService5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzin) {
            zzin zzinVar = (zzin) obj;
            if (this.zza.equals(zzinVar.zzd()) && this.zzb.equals(zzinVar.zzf()) && this.zzc.equals(zzinVar.zzb()) && this.zzd.equals(zzinVar.zza()) && this.zze.equals(zzinVar.zze()) && this.zzf.equals(zzinVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode();
    }

    public final String toString() {
        ListeningExecutorService listeningExecutorService = this.zzf;
        ListeningExecutorService listeningExecutorService2 = this.zze;
        ListeningExecutorService listeningExecutorService3 = this.zzd;
        ListeningExecutorService listeningExecutorService4 = this.zzc;
        ListeningScheduledExecutorService listeningScheduledExecutorService = this.zzb;
        String string = this.zza.toString();
        String string2 = listeningScheduledExecutorService.toString();
        String string3 = listeningExecutorService4.toString();
        String string4 = listeningExecutorService3.toString();
        String string5 = listeningExecutorService2.toString();
        String string6 = listeningExecutorService.toString();
        StringBuilder sbM16m = AbstractC0000a.m16m("LiveSharingExecutors{internalExecutor=", string, ", heartbeatExecutor=", string2, ", coWatchingHandlerExecutor=");
        AbstractC2821a.m2207B(sbM16m, string3, ", coDoingHandlerExecutor=", string4, ", outgoingIpcExecutor=");
        return AbstractC0541b.m776r(sbM16m, string5, ", incomingIpcExecutor=", string6, "}");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzin
    public final ListeningExecutorService zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzin
    public final ListeningExecutorService zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzin
    public final ListeningExecutorService zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzin
    public final ListeningExecutorService zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzin
    public final ListeningExecutorService zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzin
    public final ListeningScheduledExecutorService zzf() {
        return this.zzb;
    }
}
