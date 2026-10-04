package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSession;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CoDoingClient;
import com.google.android.meet.addons.CoDoingHandler;
import com.google.android.meet.addons.CoDoingState;
import com.google.android.meet.addons.CoWatchingClient;
import com.google.android.meet.addons.CoWatchingHandler;
import com.google.android.meet.addons.CoWatchingState;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.ParticipantMetadataHandler;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfm implements AddonSession.Builder {
    private static final zzkz zza = zzkz.zzj("com/google/android/meet/addons/internal/AddonSessionBuilderImpl");
    private final AddonSessionHandler zzb;
    private final zzie zzc;
    private final zzip zzd;
    private CollaborationStartingState zzi;
    private Optional zze = Optional.empty();
    private Optional zzf = Optional.empty();
    private Optional zzg = Optional.empty();
    private zzrq zzh = zzrq.zzb;
    private boolean zzj = false;
    private Optional zzk = Optional.empty();
    private Optional zzl = Optional.empty();

    public zzfm(AddonSessionHandler addonSessionHandler, zzie zzieVar, zzip zzipVar) {
        this.zzb = addonSessionHandler;
        this.zzc = zzieVar;
        this.zzd = zzipVar;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final ListenableFuture<AddonSession> begin(Context context) {
        Preconditions.checkState(!this.zzc.zzW(), "Cannot call begin() while a meeting connection already exists.");
        return Futures.transformAsync(this.zzj ? this.zzc.zzm(context, this.zzb) : this.zzc.zzc(context, this.zzb), new AsyncFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzfh
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.zza.zze((AddonMeetingInfo) obj);
            }
        }, zzir.zza);
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder verifyRecordingInfo() {
        this.zzj = true;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withCoDoing(CoDoingHandler coDoingHandler) {
        Optional optionalEmpty = Optional.empty();
        Preconditions.checkNotNull(coDoingHandler, "Parameter 'coDoingHandler' cannot be null.");
        Preconditions.checkNotNull(optionalEmpty, "Parameter 'initiatorInitialCoDoingState' cannot be null.");
        this.zzf = Optional.of(coDoingHandler);
        this.zzl = optionalEmpty;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withCoWatching(CoWatchingHandler coWatchingHandler) {
        Optional optionalEmpty = Optional.empty();
        Preconditions.checkNotNull(coWatchingHandler, "Parameter 'coWatchingHandler' cannot be null.");
        Preconditions.checkNotNull(optionalEmpty, "Parameter 'initiatorInitialCoWatchingState' cannot be null.");
        this.zze = Optional.of(coWatchingHandler);
        this.zzk = optionalEmpty;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withCollaborationStartingState(CollaborationStartingState collaborationStartingState) {
        Preconditions.checkNotNull(collaborationStartingState, "Parameter 'startingState' cannot be null.");
        this.zzi = collaborationStartingState;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withParticipantMetadata(ParticipantMetadataHandler participantMetadataHandler) {
        Preconditions.checkNotNull(participantMetadataHandler, "Parameter 'handler' cannot be null.");
        this.zzg = Optional.of(participantMetadataHandler);
        return this;
    }

    public final /* synthetic */ AddonSession zza(AddonMeetingInfo addonMeetingInfo, ListenableFuture listenableFuture, ListenableFuture listenableFuture2) {
        return new zzfs(this.zzc, addonMeetingInfo, (Optional) Futures.getDone(listenableFuture), (Optional) Futures.getDone(listenableFuture2), this.zzd);
    }

    public final /* synthetic */ ListenableFuture zze(final AddonMeetingInfo addonMeetingInfo) {
        final ListenableFuture listenableFuture = (ListenableFuture) this.zze.map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzfg
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.zza.zzg((CoWatchingHandler) obj);
            }
        }).orElse(Futures.immediateFuture(Optional.empty()));
        final ListenableFuture listenableFuture2 = (ListenableFuture) this.zzf.map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzfb
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.zza.zzf((CoDoingHandler) obj);
            }
        }).orElse(Futures.immediateFuture(Optional.empty()));
        Futures.FutureCombiner futureCombinerWhenAllSucceed = Futures.whenAllSucceed(listenableFuture, listenableFuture2);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzfe
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(addonMeetingInfo, listenableFuture, listenableFuture2);
            }
        };
        Executor executor = zzir.zza;
        final ListenableFuture listenableFutureCall = futureCombinerWhenAllSucceed.call(callable, executor);
        Futures.addCallback(listenableFutureCall, new zzfl(this), executor);
        this.zzg.ifPresent(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzfd
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Futures.addCallback(listenableFutureCall, new zzfi(this.zza, (ParticipantMetadataHandler) obj), zzir.zza);
            }
        });
        if (this.zzi == null) {
            ((zzkv) zza.zzc().zzh("com/google/android/meet/addons/internal/AddonSessionBuilderImpl", "maybeConfigureCollaborationStartingState", JPEG.APP10, "AddonSessionBuilderImpl.java")).zzo("Collaboration starting state is null.");
            return listenableFutureCall;
        }
        Futures.addCallback(listenableFutureCall, new zzfj(this), executor);
        return listenableFutureCall;
    }

    public final /* synthetic */ ListenableFuture zzf(CoDoingHandler coDoingHandler) {
        return Futures.transform(this.zzc.zza(coDoingHandler, this.zzl), new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzfc
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Optional.of((CoDoingClient) obj);
            }
        }, zzir.zza);
    }

    public final /* synthetic */ ListenableFuture zzg(CoWatchingHandler coWatchingHandler) {
        return Futures.transform(this.zzc.zzb(coWatchingHandler, this.zzk), new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzff
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Optional.of((CoWatchingClient) obj);
            }
        }, zzir.zza);
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withParticipantMetadata(ParticipantMetadataHandler participantMetadataHandler, byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Parameter 'metadata' cannot be null.");
        Preconditions.checkNotNull(participantMetadataHandler, "Parameter 'handler' cannot be null.");
        int length = bArr.length;
        Preconditions.checkArgument(length <= 200, "Participant metadata size cannot exceed %s bytes.", 200);
        this.zzg = Optional.of(participantMetadataHandler);
        this.zzh = zzrq.zzk(bArr, 0, length);
        return this;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withCoDoing(CoDoingHandler coDoingHandler, Optional<CoDoingState> optional) {
        Preconditions.checkNotNull(coDoingHandler, "Parameter 'coDoingHandler' cannot be null.");
        Preconditions.checkNotNull(optional, "Parameter 'initiatorInitialCoDoingState' cannot be null.");
        this.zzf = Optional.of(coDoingHandler);
        this.zzl = optional;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonSession.Builder
    public final AddonSession.Builder withCoWatching(CoWatchingHandler coWatchingHandler, Optional<CoWatchingState> optional) {
        Preconditions.checkNotNull(coWatchingHandler, "Parameter 'coWatchingHandler' cannot be null.");
        Preconditions.checkNotNull(optional, "Parameter 'initiatorInitialCoWatchingState' cannot be null.");
        this.zze = Optional.of(coWatchingHandler);
        this.zzk = optional;
        return this;
    }
}
