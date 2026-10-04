package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxs {
    private SocketAddress zza;
    private InetSocketAddress zzb;

    @Nullable
    private String zzc;

    @Nullable
    private String zzd;

    private zzxs() {
        throw null;
    }

    public final zzxs zza(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    public final zzxs zzb(SocketAddress socketAddress) {
        this.zza = (SocketAddress) Preconditions.checkNotNull(socketAddress, "proxyAddress");
        return this;
    }

    public final zzxs zzc(InetSocketAddress inetSocketAddress) {
        this.zzb = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "targetAddress");
        return this;
    }

    public final zzxs zzd(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    public final zzxu zze() {
        return new zzxu(this.zza, this.zzb, this.zzc, this.zzd, null);
    }

    public /* synthetic */ zzxs(zzxr zzxrVar) {
    }
}
