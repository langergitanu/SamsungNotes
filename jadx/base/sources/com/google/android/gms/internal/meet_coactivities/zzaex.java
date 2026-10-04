package com.google.android.gms.internal.meet_coactivities;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface zzaex extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    zzaey zza(SocketAddress socketAddress, zzaew zzaewVar, zzwg zzwgVar);

    ScheduledExecutorService zzb();
}
