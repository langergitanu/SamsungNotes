package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzang {
    final boolean zza;

    @Nullable
    final List zzb;
    final Collection zzc;
    final Collection zzd;
    final int zze;

    @Nullable
    final zzanp zzf;
    final boolean zzg;
    final boolean zzh;

    public zzang(@Nullable List list, Collection collection, Collection collection2, @Nullable zzanp zzanpVar, boolean z, boolean z2, boolean z3, int i) {
        this.zzb = list;
        this.zzc = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
        this.zzf = zzanpVar;
        this.zzd = collection2;
        this.zzg = z;
        this.zza = z2;
        this.zzh = z3;
        this.zze = i;
        Preconditions.checkState(!z2 || list == null, "passThrough should imply buffer is null");
        Preconditions.checkState((z2 && zzanpVar == null) ? false : true, "passThrough should imply winningSubstream != null");
        Preconditions.checkState(!z2 || (collection.size() == 1 && collection.contains(zzanpVar)) || (collection.size() == 0 && zzanpVar.zzb), "passThrough should imply winningSubstream is drained");
        Preconditions.checkState((z && zzanpVar == null) ? false : true, "cancelled should imply committed");
    }

    @CheckReturnValue
    public final zzang zza(zzanp zzanpVar) {
        Collection collectionUnmodifiableCollection;
        Preconditions.checkState(!this.zzh, "hedging frozen");
        Preconditions.checkState(this.zzf == null, "already committed");
        Collection collection = this.zzd;
        if (collection == null) {
            collectionUnmodifiableCollection = Collections.singleton(zzanpVar);
        } else {
            ArrayList arrayList = new ArrayList(collection);
            arrayList.add(zzanpVar);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        return new zzang(this.zzb, this.zzc, collectionUnmodifiableCollection, this.zzf, this.zzg, this.zza, this.zzh, this.zze + 1);
    }

    @CheckReturnValue
    public final zzang zzb() {
        return this.zzh ? this : new zzang(this.zzb, this.zzc, this.zzd, this.zzf, this.zzg, this.zza, true, this.zze);
    }

    @CheckReturnValue
    public final zzang zzc(zzanp zzanpVar) {
        Collection collectionUnmodifiableCollection;
        Preconditions.checkState(!this.zza, "Already passThrough");
        if (zzanpVar.zzb) {
            collectionUnmodifiableCollection = this.zzc;
        } else if (this.zzc.isEmpty()) {
            collectionUnmodifiableCollection = Collections.singletonList(zzanpVar);
        } else {
            ArrayList arrayList = new ArrayList(this.zzc);
            arrayList.add(zzanpVar);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        Collection collection = collectionUnmodifiableCollection;
        zzanp zzanpVar2 = this.zzf;
        boolean z = zzanpVar2 != null;
        List list = this.zzb;
        if (z) {
            Preconditions.checkState(zzanpVar2 == zzanpVar, "Another RPC attempt has already committed");
            list = null;
        }
        return new zzang(list, collection, this.zzd, this.zzf, this.zzg, z, this.zzh, this.zze);
    }
}
