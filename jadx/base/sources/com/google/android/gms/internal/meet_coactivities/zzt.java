package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum zzt implements zzta {
    LIVE_SHARING_APP_CAPABILITY_UNSPECIFIED(0),
    SESSION_LEAVING(1),
    UNRECOGNIZED(-1);

    private final int zze;

    zzt(int i) {
        this.zze = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(zza());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzta
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zze;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
