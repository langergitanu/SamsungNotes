package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Charsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum zzaay {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);

    private final int zzs;
    private final byte[] zzt;

    zzaay(int i) {
        this.zzs = i;
        this.zzt = Integer.toString(i).getBytes(Charsets.US_ASCII);
    }

    public final int zza() {
        return this.zzs;
    }

    public final zzabd zzb() {
        return (zzabd) zzabd.zzl.get(this.zzs);
    }
}
