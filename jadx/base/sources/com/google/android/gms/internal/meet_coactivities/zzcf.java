package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.RecordingInfo;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Optional;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcf {
    private static Optional zza = Optional.empty();

    @AnyThread
    public static synchronized zzcf zze(Context context, Supplier supplier, zzby zzbyVar) {
        try {
            if (!zza.isPresent()) {
                zza = Optional.of(new zzda(context, (zzce) supplier.get(), zzbyVar));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzcf) zza.get();
    }

    @Nullable
    @WorkerThread
    public abstract zzg zzd();

    @WorkerThread
    public abstract ListenableFuture zzf(zzp zzpVar, ImmutableSet immutableSet);

    @WorkerThread
    public abstract void zzg(zzpx zzpxVar);

    public abstract void zzh(RecordingInfo recordingInfo);

    public abstract void zzi();

    public abstract void zzj(CollaborationStartingState collaborationStartingState);

    public abstract void zzk(zzrq zzrqVar);

    @WorkerThread
    public abstract ListenableFuture zzl(int i);

    @WorkerThread
    public abstract void zzm(Context context, int i, zzj zzjVar);
}
