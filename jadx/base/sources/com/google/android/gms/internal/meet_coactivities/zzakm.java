package com.google.android.gms.internal.meet_coactivities;

import java.util.Collection;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzakm {
    final Object zza = new Object();

    @GuardedBy("lock")
    Collection zzb = new HashSet();

    @GuardedBy("lock")
    zzabd zzc;
    final /* synthetic */ zzakn zzd;

    public /* synthetic */ zzakm(zzakn zzaknVar, zzakl zzaklVar) {
        this.zzd = zzaknVar;
    }
}
