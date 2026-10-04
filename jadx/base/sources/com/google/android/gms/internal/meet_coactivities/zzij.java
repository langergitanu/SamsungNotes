package com.google.android.gms.internal.meet_coactivities;

import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzij implements zzig {
    private static final ImmutableMap zza = ImmutableMap.builder().put(845714248040L, "youtube").put(523214873043L, "youtube-music").put(583859152812L, "testapp").put(32147523519L, "samsung-notes").put(878579687799L, "kahoot").put(135083966748L, "spotify").buildOrThrow();

    private zzij() {
        throw null;
    }

    public static zzij zzb() {
        return zzih.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzig
    public final String zza(long j) {
        return (String) zza.getOrDefault(Long.valueOf(j), "");
    }

    public /* synthetic */ zzij(zzii zziiVar) {
    }
}
