package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxu extends zzaas {
    private final SocketAddress zza;
    private final InetSocketAddress zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final String zzd;

    public /* synthetic */ zzxu(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, zzxt zzxtVar) {
        Preconditions.checkNotNull(socketAddress, "proxyAddress");
        Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            Preconditions.checkState(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.zza = socketAddress;
        this.zzb = inetSocketAddress;
        this.zzc = str;
        this.zzd = str2;
    }

    public static zzxs zza() {
        return new zzxs(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxu)) {
            return false;
        }
        zzxu zzxuVar = (zzxu) obj;
        return Objects.equal(this.zza, zzxuVar.zza) && Objects.equal(this.zzb, zzxuVar.zzb) && Objects.equal(this.zzc, zzxuVar.zzc) && Objects.equal(this.zzd, zzxuVar.zzd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("proxyAddr", this.zza).add("targetAddr", this.zzb).add("username", this.zzc).add("hasPassword", this.zzd != null).toString();
    }

    public final InetSocketAddress zzb() {
        return this.zzb;
    }
}
