package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoDoingState;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzgl implements Supplier {
    public final /* synthetic */ zzgm zza;
    public final /* synthetic */ CoDoingState zzb;

    public /* synthetic */ zzgl(zzgm zzgmVar, CoDoingState coDoingState) {
        this.zza = zzgmVar;
        this.zzb = coDoingState;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        zzjo zzjoVar = (zzjo) this.zza.zzc;
        final CoDoingState coDoingState = this.zzb;
        return zzjoVar.zza(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgk
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return zzjz.zzd(coDoingState);
            }
        });
    }
}
