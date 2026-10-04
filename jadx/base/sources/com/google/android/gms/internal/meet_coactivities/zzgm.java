package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoDoingClient;
import com.google.android.meet.addons.CoDoingState;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzgm extends zzhu implements CoDoingClient, zzhe {
    public zzgm(zzhw zzhwVar) {
        super(zzhwVar);
    }

    @Override // com.google.android.meet.addons.CoDoingClient
    public final void setGlobalState(CoDoingState coDoingState) {
        Preconditions.checkNotNull(coDoingState, "Expected 'newGlobalState' to be provided.");
        Preconditions.checkState(zzjz.zzd(coDoingState).zzd().zzd() <= 16384, "Blob size cannot be greater than %s bytes.", 16384);
        zze(new zzgl(this, coDoingState));
    }
}
