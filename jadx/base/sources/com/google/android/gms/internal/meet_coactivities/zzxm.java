package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxm {
    public static final zzvw zza = zzvw.zza("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");
    private final List zzb;
    private final zzvy zzc;
    private final int zzd;

    public zzxm(List list, zzvy zzvyVar) {
        Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.zzb = listUnmodifiableList;
        this.zzc = (zzvy) Preconditions.checkNotNull(zzvyVar, "attrs");
        this.zzd = listUnmodifiableList.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxm)) {
            return false;
        }
        zzxm zzxmVar = (zzxm) obj;
        if (this.zzb.size() != zzxmVar.zzb.size()) {
            return false;
        }
        for (int i = 0; i < this.zzb.size(); i++) {
            if (!((SocketAddress) this.zzb.get(i)).equals(zzxmVar.zzb.get(i))) {
                return false;
            }
        }
        return this.zzc.equals(zzxmVar.zzc);
    }

    public final int hashCode() {
        return this.zzd;
    }

    public final String toString() {
        return AbstractC0541b.m775q("[", String.valueOf(this.zzb), "/", String.valueOf(this.zzc), "]");
    }

    public final zzvy zza() {
        return this.zzc;
    }

    public final List zzb() {
        return this.zzb;
    }
}
