package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.AddonException;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzia {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/ExceptionUtils");

    public static ListenableFuture zza(ListenableFuture listenableFuture, final String str, final Object... objArr) {
        return Futures.catchingAsync(listenableFuture, Throwable.class, new AsyncFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzhz
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                zzia.zzf((Throwable) obj, str, objArr);
                return Futures.immediateVoidFuture();
            }
        }, zzir.zza);
    }

    public static ListenableFuture zzb(ListenableFuture listenableFuture, final String str) {
        return Futures.catchingAsync(listenableFuture, Throwable.class, new AsyncFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzhy
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzia.zze(th);
                boolean z = th instanceof AddonException;
                String str2 = str;
                if (z) {
                    throw com.google.android.meet.addons.zza.zzc(str2, ((AddonException) th).getCode());
                }
                throw com.google.android.meet.addons.zza.zzb(str2);
            }
        }, zzir.zza);
    }

    public static Object zzc(Supplier supplier, String str) {
        try {
            return supplier.get();
        } catch (Throwable th) {
            zze(th);
            throw com.google.android.meet.addons.zza.zzb(str);
        }
    }

    public static void zzd(final Runnable runnable, String str) {
    }

    public static void zze(Throwable th) {
        zzf(th, "", new Object[0]);
    }

    public static void zzf(Throwable th, String str, Object... objArr) {
        ((zzkv) ((zzkv) zza.zzd().zzg(th)).zzh("com/google/android/meet/addons/internal/ExceptionUtils", "recordInternalException", 25, "ExceptionUtils.java")).zzu(str, objArr);
    }
}
