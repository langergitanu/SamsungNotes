package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoWatchingQueue;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.RateLimiter;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhb extends zzhu implements zzif {
    private final RateLimiter zze;
    private final zzkf zzf;

    public zzhb(zzhw zzhwVar) {
        super(zzhwVar);
        this.zzf = zzkf.zzc();
        this.zze = RateLimiter.create(0.9d);
    }

    private final void zzg(String str, final String str2, final Duration duration, final Optional optional) {
        Preconditions.checkNotNull(str, "Expected 'mediaTitle' to be provided.");
        Preconditions.checkNotNull(str2, "Expected 'mediaId' to be provided.");
        Preconditions.checkNotNull(duration, "Expected 'mediaPlayoutPosition' to be provided.");
        ((zzjq) this.zzc).zzj(str);
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgt
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                this.zza.zzb(str2, duration, optional, zzqiVar);
                return zzqiVar;
            }
        }, zzql.SWITCH_MEDIA);
    }

    private final void zzh(final UnaryOperator unaryOperator, final zzql zzqlVar) {
        Preconditions.checkState(Double.compare(((zzqj) ((zzqi) unaryOperator.apply((zzqi) ((zzqj) ((zzjq) this.zzc).zzg().zzb()).zzB())).zzk()).zza(), 2.0d) <= 0, "Playout rate cannot be set higher than %s.", Double.valueOf(2.0d));
        zze(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzgy
            @Override // java.util.function.Supplier
            public final Object get() {
                zzjq zzjqVar = (zzjq) this.zza.zzc;
                final UnaryOperator unaryOperator2 = unaryOperator;
                return zzjqVar.zzb(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgu
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return (zzqj) ((zzqi) unaryOperator2.apply((zzqi) ((zzqj) obj).zzB())).zzk();
                    }
                }, zzqlVar);
            }
        });
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifyBuffering(final Duration duration) {
        Preconditions.checkNotNull(duration, "Expected 'mediaPlayoutPosition' to be provided.");
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgs
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                zzqiVar.zze(zzvt.zza(duration));
                zzqiVar.zzg(3);
                return zzqiVar;
            }
        }, zzql.ALTER_PLAYBACK_STATE);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifyEnded(final Duration duration) {
        Preconditions.checkNotNull(duration, "Expected 'mediaPlayoutPosition' to be provided.");
        zzf();
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgw
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                zzqiVar.zze(zzvt.zza(duration));
                zzqiVar.zzg(6);
                return zzqiVar;
            }
        }, zzql.ALTER_PLAYBACK_STATE);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifyPauseState(final boolean z, final Duration duration) {
        Preconditions.checkNotNull(duration, "Expected 'mediaPlayoutPosition' to be provided.");
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgr
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                zzqiVar.zzg(true != z ? 4 : 5);
                zzqiVar.zze(zzvt.zza(duration));
                return zzqiVar;
            }
        }, zzql.ALTER_PLAYBACK_STATE);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifyPlayoutRate(final double d, Duration duration) {
        final zzsg zzsgVarZza = zzvt.zza(duration);
        Preconditions.checkState(d > 0.0d, "Expected 'rate' to be a value greater than zero.");
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgv
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                zzqiVar.zzf(d);
                zzqiVar.zze(zzsgVarZza);
                return zzqiVar;
            }
        }, zzql.ALTER_SPEED);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifyQueueUpdate(final CoWatchingQueue coWatchingQueue) {
        Preconditions.checkNotNull(coWatchingQueue, "Expected 'queue' to be provided.");
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                this.zza.zza(coWatchingQueue, zzqiVar);
                return zzqiVar;
            }
        }, zzql.ALTER_QUEUE);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifyReady(final Duration duration) {
        Preconditions.checkNotNull(duration, "Expected 'mediaPlayoutPosition' to be provided.");
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgz
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                zzqiVar.zze(zzvt.zza(duration));
                zzqiVar.zzg(4);
                return zzqiVar;
            }
        }, zzql.ALTER_PLAYBACK_STATE);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifySeekToTimestamp(final Duration duration) {
        Preconditions.checkNotNull(duration, "Expected 'mediaPlayoutPosition' to be provided.");
        Preconditions.checkState(this.zze.tryAcquire(), "Number of seeks per second cannot exceed %s.", Double.valueOf(0.9d));
        zzh(new UnaryOperator() { // from class: com.google.android.gms.internal.meet_coactivities.zzgp
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzqi zzqiVar = (zzqi) obj;
                zzqiVar.zze(zzvt.zza(duration));
                return zzqiVar;
            }
        }, zzql.ALTER_POSITION);
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifySwitchedToMedia(String str, String str2, Duration duration) {
        zzg(str, str2, duration, Optional.empty());
    }

    public final /* synthetic */ zzqi zza(CoWatchingQueue coWatchingQueue, zzqi zzqiVar) {
        zzqiVar.zzc(this.zzf.zzd(coWatchingQueue));
        zzqiVar.zze(((zzjq) this.zzc).zzd());
        return zzqiVar;
    }

    public final /* synthetic */ zzqi zzb(String str, Duration duration, Optional optional, final zzqi zzqiVar) {
        zzqiVar.zzd(str);
        zzqiVar.zze(zzvt.zza(duration));
        zzqiVar.zzg(4);
        final zzkf zzkfVar = this.zzf;
        Objects.requireNonNull(zzkfVar);
        optional.map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzha
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return zzkfVar.zzd((CoWatchingQueue) obj);
            }
        }).ifPresent(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzgq
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                zzqiVar.zzc((zzqh) obj);
            }
        });
        return zzqiVar;
    }

    @Override // com.google.android.meet.addons.CoWatchingClient
    public final void notifySwitchedToMedia(String str, String str2, Duration duration, CoWatchingQueue coWatchingQueue) {
        Preconditions.checkNotNull(coWatchingQueue, "Expected 'queue' to be provided.");
        zzg(str, str2, duration, Optional.of(coWatchingQueue));
    }
}
