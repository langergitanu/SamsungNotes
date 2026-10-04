package com.google.android.gms.internal.meet_coactivities;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzde {
    public static final ImmutableMap zza;
    public static final ImmutableMap zzb;
    public static final ImmutableList zzc;

    static {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        zzj zzjVar = zzj.HOST_APP_HAM;
        ImmutableMap.Builder builderPut = builder.put(zzjVar, 3061514L);
        zzj zzjVar2 = zzj.HOST_APP_MIG;
        ImmutableMap.Builder builderPut2 = builderPut.put(zzjVar2, 63397229L);
        zzj zzjVar3 = zzj.HOST_APP_DUET;
        ImmutableMap.Builder builderPut3 = builderPut2.put(zzjVar3, 3775507L);
        zzj zzjVar4 = zzj.HOST_APP_FAKE_TACHYON;
        zza = builderPut3.put(zzjVar4, 0L).buildOrThrow();
        zzb = ImmutableMap.builder().put(zzjVar, "com.google.android.apps.meetings").put(zzjVar2, "com.google.android.gm").put(zzjVar3, "com.google.android.apps.tachyon").put(zzjVar4, "com.google.android.apps.faketachyon").buildOrThrow();
        zzc = ImmutableList.m4306of(zzjVar4, zzjVar3, zzjVar, zzjVar2);
    }
}
