package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoDoingHandler;
import com.google.android.meet.addons.CoWatchingHandler;
import com.google.android.meet.addons.QueriedCoWatchingState;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhs {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/CoXClientFactory");
    private final zzin zzb;
    private final zzcf zzc;
    private final String zzd;
    private final zzgg zze;
    private final zzpq zzf;
    private final zzip zzg;
    private final long zzh;

    public zzhs(zzcf zzcfVar, String str, zzgg zzggVar, zzpq zzpqVar, zzin zzinVar, zzip zzipVar, long j) {
        this.zzc = zzcfVar;
        this.zzd = str;
        this.zze = zzggVar;
        this.zzf = zzpqVar;
        this.zzb = zzinVar;
        this.zzg = zzipVar;
        this.zzh = j;
    }

    public static /* synthetic */ void zzf(zzib zzibVar, zzkm zzkmVar, Object obj) {
        try {
            zzibVar.zzb(zzkmVar.zza(obj));
        } catch (AssertionError e) {
            ((zzkv) ((zzkv) zza.zzd().zzg(e)).zzh("com/google/android/meet/addons/internal/CoXClientFactory", "lambda$createAndActivateCoActivity$5", 175, "CoXClientFactory.java")).zzo("Invalid update proto.");
        } catch (RuntimeException e2) {
            ((zzkv) ((zzkv) zza.zzd().zzg(e2)).zzh("com/google/android/meet/addons/internal/CoXClientFactory", "lambda$createAndActivateCoActivity$5", 177, "CoXClientFactory.java")).zzo("Unexpected error while applying an update.");
        }
    }

    private final zzhe zzh(Function function, zzjr zzjrVar, final zzib zzibVar, final zzkm zzkmVar, zzhr zzhrVar, final Supplier supplier) {
        Consumer consumer = new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzhk
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                zzhs.zzf(zzibVar, zzkmVar, obj);
            }
        };
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzhl
            @Override // java.lang.Runnable
            public final void run() {
                Futures.addCallback((ListenableFuture) supplier.get(), new zzhq(this.zza), MoreExecutors.directExecutor());
            }
        };
        zzfw zzfwVar = new zzfw();
        zzfwVar.zzd(this.zzc);
        zzfwVar.zze(zzjrVar);
        zzfwVar.zzc(zzid.zza(this.zze, runnable, this.zzb.zzf()));
        final zzcf zzcfVar = this.zzc;
        Objects.requireNonNull(zzcfVar);
        zzfwVar.zzf(zzhrVar.zza(zzjrVar, consumer, new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzhm
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                zzcfVar.zzg((zzpx) obj);
            }
        }));
        zzfwVar.zza(this.zze);
        zzfwVar.zzb(zzibVar);
        return (zzhe) function.apply(zzfwVar.zzg());
    }

    public final zzif zzb(final CoWatchingHandler coWatchingHandler) {
        zzhr zzhrVar = new zzhr() { // from class: com.google.android.gms.internal.meet_coactivities.zzhg
            @Override // com.google.android.gms.internal.meet_coactivities.zzhr
            public final zzjv zza(zzjr zzjrVar, Consumer consumer, Consumer consumer2) {
                return this.zza.zzd((zzjq) zzjrVar, consumer, consumer2);
            }
        };
        final zzjq zzjqVarZza = zzjq.zza(this.zzd, this.zzh, this.zzf, this.zze);
        return (zzif) zzh(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzhj
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new zzhb((zzhw) obj);
            }
        }, zzjqVarZza, zzhd.zza(coWatchingHandler, this.zzb.zzb()), zzki.zzc(), zzhrVar, new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzhi
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.zza.zze(coWatchingHandler, zzjqVarZza);
            }
        });
    }

    public final /* synthetic */ zzjv zzc(zzjo zzjoVar, Consumer consumer, Consumer consumer2) {
        return new zzjk(zzjoVar, consumer, this.zze, this.zzg);
    }

    public final /* synthetic */ zzjv zzd(zzjq zzjqVar, Consumer consumer, Consumer consumer2) {
        return new zzjm(zzjqVar, consumer, this.zze, this.zzg);
    }

    public final /* synthetic */ ListenableFuture zze(final CoWatchingHandler coWatchingHandler, final zzjq zzjqVar) {
        Objects.requireNonNull(coWatchingHandler);
        return Futures.transform(Futures.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzho
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return coWatchingHandler.onStateQuery();
            }
        }, this.zzb.zzb()), new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzhp
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Optional optional = (Optional) obj;
                return zzjqVar.zzc(optional.isPresent() ? ((QueriedCoWatchingState) optional.get()).mediaPlayoutPosition() : Duration.ZERO);
            }
        }, MoreExecutors.directExecutor());
    }

    public final zzgm zzg(CoDoingHandler coDoingHandler) {
        zzhr zzhrVar = new zzhr() { // from class: com.google.android.gms.internal.meet_coactivities.zzhn
            @Override // com.google.android.gms.internal.meet_coactivities.zzhr
            public final zzjv zza(zzjr zzjrVar, Consumer consumer, Consumer consumer2) {
                return this.zza.zzc((zzjo) zzjrVar, consumer, consumer2);
            }
        };
        final zzjo zzjoVar = new zzjo(this.zzd, this.zzh);
        return (zzgm) zzh(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzhh
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new zzgm((zzhw) obj);
            }
        }, zzjoVar, zzgo.zza(coDoingHandler, this.zzb.zza()), zzjz.zzb(), zzhrVar, new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzhf
            @Override // java.util.function.Supplier
            public final Object get() {
                return Futures.immediateFuture(zzjoVar.zzb());
            }
        });
    }
}
