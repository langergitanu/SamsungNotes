package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Objects;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class zzvy {
    public static final zzvy zza;
    private static final IdentityHashMap zzb;
    private final IdentityHashMap zzc;

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        zzb = identityHashMap;
        zza = new zzvy(identityHashMap);
    }

    private zzvy(IdentityHashMap identityHashMap) {
        this.zzc = identityHashMap;
    }

    public static zzvv zza() {
        return new zzvv(zza, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzvy.class != obj.getClass()) {
            return false;
        }
        zzvy zzvyVar = (zzvy) obj;
        if (this.zzc.size() != zzvyVar.zzc.size()) {
            return false;
        }
        for (Map.Entry entry : this.zzc.entrySet()) {
            if (!zzvyVar.zzc.containsKey(entry.getKey()) || !Objects.equal(entry.getValue(), zzvyVar.zzc.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.zzc.entrySet()) {
            iHashCode += Objects.hashCode(entry.getKey(), entry.getValue());
        }
        return iHashCode;
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final zzvv zzb() {
        return new zzvv(this, null);
    }

    @Nullable
    public final Object zzc(zzvw zzvwVar) {
        return this.zzc.get(zzvwVar);
    }

    public /* synthetic */ zzvy(IdentityHashMap identityHashMap, zzvx zzvxVar) {
        this.zzc = identityHashMap;
    }
}
