package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzzn extends zzzq {
    private final zzzo zza;

    public /* synthetic */ zzzn(String str, boolean z, zzzo zzzoVar, zzzm zzzmVar) {
        super(str, false, zzzoVar, null);
        Preconditions.checkArgument(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
        this.zza = (zzzo) Preconditions.checkNotNull(zzzoVar, "marshaller");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzq
    public final Object zza(byte[] bArr) {
        return this.zza.zza(new String(bArr, Charsets.US_ASCII));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzq
    public final byte[] zzb(Object obj) {
        return ((String) Preconditions.checkNotNull(this.zza.zzb(obj), "null marshaller.toAsciiString()")).getBytes(Charsets.US_ASCII);
    }
}
