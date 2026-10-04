package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzzt extends zzzq {
    private final zzzu zza;

    public /* synthetic */ zzzt(String str, boolean z, zzzu zzzuVar, zzzs zzzsVar) {
        super(str, z, zzzuVar, null);
        Preconditions.checkArgument(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
        this.zza = (zzzu) Preconditions.checkNotNull(zzzuVar, "marshaller");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzq
    public final Object zza(byte[] bArr) {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzq
    public final byte[] zzb(Object obj) {
        return (byte[]) Preconditions.checkNotNull(this.zza.zza(obj), "null marshaller.toAsciiString()");
    }
}
