package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzakt {
    public final URI zza;
    public final zzaan zzb;

    public zzakt(URI uri, zzaan zzaanVar) {
        this.zza = (URI) Preconditions.checkNotNull(uri, "targetUri");
        this.zzb = (zzaan) Preconditions.checkNotNull(zzaanVar, "provider");
    }
}
