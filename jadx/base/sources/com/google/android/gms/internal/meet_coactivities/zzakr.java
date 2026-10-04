package com.google.android.gms.internal.meet_coactivities;

import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakr extends zzaan {
    final SocketAddress zza;
    final String zzb;
    final Collection zzc;

    public zzakr(SocketAddress socketAddress, String str) {
        this.zza = socketAddress;
        this.zzb = str;
        this.zzc = Collections.singleton(socketAddress.getClass());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaah
    public final zzaam zza(URI uri, zzaaf zzaafVar) {
        return new zzakq(this);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaah
    public final String zzb() {
        return "directaddress";
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaan
    public final int zzc() {
        return 5;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaan
    public final Collection zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaan
    public final boolean zze() {
        return true;
    }
}
