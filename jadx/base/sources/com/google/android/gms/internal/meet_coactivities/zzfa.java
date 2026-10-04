package com.google.android.gms.internal.meet_coactivities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.meet.addons.AddonClient;
import com.google.android.meet.addons.AddonException;
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
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.google.android.meet.addons.ParticipantMetadataHandler;
import com.google.android.meet.addons.RecordingInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import cz.msebera.android.httpclient.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfa implements zzie {
    static final AddonMeetingInfo zza;
    static final zzrq zzb;
    public static final /* synthetic */ int zzc = 0;
    private static final zzkz zzd;
    private static final Object zze;
    private final zzin zzi;
    private final long zzj;
    private final zzig zzk;
    private final Function zzn;
    private final Executor zzp;
    private Optional zzf = Optional.empty();
    private Optional zzg = Optional.empty();
    private final zzez zzh = new zzez(this, null);
    private final zzkl zzl = zzkl.zzb();
    private final zzki zzm = zzki.zzc();
    private final ArrayList zzq = new ArrayList(1);
    private Optional zzs = Optional.empty();
    private Optional zzt = Optional.empty();
    private Optional zzu = Optional.empty();
    private Optional zzv = Optional.empty();
    private Optional zzw = Optional.empty();
    private Optional zzx = Optional.empty();
    private Optional zzy = Optional.empty();
    private Optional zzz = Optional.empty();
    private AddonMeetingInfo zzA = zza;
    private zzgg zzB = zzgg.zza;
    private List zzC = ImmutableList.m4302of();
    private final Optional zzo = Optional.empty();
    private final zziv zzD = zziv.zza();
    private zzip zzr = new zzip();

    static {
        AddonMeetingInfo.Builder builder = AddonMeetingInfo.builder();
        builder.setMeetingCode("");
        builder.setMeetingUrl("");
        RecordingInfo.Builder builder2 = RecordingInfo.builder();
        builder2.setStatus(RecordingInfo.RecordingStatus.UNKNOWN);
        builder.setRecordingInfo(builder2.build());
        builder.setMeetingStatus(AddonMeetingInfo.MeetingStatus.NOT_CONNECTED);
        zza = builder.build();
        zzb = zzrq.zzl("{}");
        zzd = zzkz.zzj("com/google/android/meet/addons/internal/AddonClientImpl");
        zze = new Object();
    }

    public zzfa(long j, Optional optional, Optional optional2, zzig zzigVar) {
        ListeningScheduledExecutorService listeningScheduledExecutorServiceListeningDecorator;
        this.zzj = j;
        this.zzk = zzigVar;
        zzgc zzgcVar = new zzgc();
        zzgcVar.zze(zzir.zza(optional));
        if (optional2.isPresent()) {
            listeningScheduledExecutorServiceListeningDecorator = MoreExecutors.listeningDecorator((ScheduledExecutorService) optional2.get());
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1, new ThreadFactoryBuilder().setNameFormat("heartbeat-thread-%d").setDaemon(true).build());
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
            listeningScheduledExecutorServiceListeningDecorator = MoreExecutors.listeningDecorator((ScheduledExecutorService) scheduledThreadPoolExecutor);
        }
        zzgcVar.zzc(listeningScheduledExecutorServiceListeningDecorator);
        zzgcVar.zzb(zzir.zza(optional));
        zzgcVar.zza(zzir.zza(optional));
        zzgcVar.zzd(zzir.zza(optional));
        zzgcVar.zzf(zzir.zza(optional));
        zzin zzinVarZzg = zzgcVar.zzg();
        this.zzi = zzinVarZzg;
        this.zzn = new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzdv
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.zza.zzf((Context) obj);
            }
        };
        this.zzp = MoreExecutors.newSequentialExecutor(zzinVarZzg.zzd());
    }

    private final AddonMeetingInfo zzab(AddonMeetingInfo addonMeetingInfo, zzpx zzpxVar) {
        try {
            return addonMeetingInfo.toBuilder().setInitialCoWatchingState(this.zzm.zza(zzpxVar.zzg().zza())).build();
        } catch (AssertionError e) {
            ((zzkv) ((zzkv) zzd.zzd().zzg(e)).zzh("com/google/android/meet/addons/internal/AddonClientImpl", "updateInitialCoWatchingState", HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, "AddonClientImpl.java")).zzo("Invalid update proto.");
            return addonMeetingInfo;
        }
    }

    private final zzhs zzac() {
        this.zzo.isPresent();
        return new zzhs(((zzil) this.zzs.get()).zzc(), ((zzil) this.zzs.get()).zze(), this.zzB, zzpp.zza(), this.zzi, this.zzr, this.zzj);
    }

    private final ListenableFuture zzad(final Context context, final AddonSessionHandler addonSessionHandler, final boolean z) {
        Preconditions.checkNotNull(context, "Expected 'appContext' to be provided.");
        Preconditions.checkNotNull(addonSessionHandler, "Expected 'handler' to be provided.");
        final String strZza = this.zzk.zza(this.zzj);
        return Futures.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzeg
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzq(context, strZza, z, addonSessionHandler);
            }
        }, this.zzp);
    }

    private final void zzae(String str) {
        Preconditions.checkState(zzak(), "Expected meeting to be connected before calling %s.", str);
    }

    private final void zzaf(String str) {
        Preconditions.checkState(this.zzu.isPresent(), "Expected meeting to be connected before calling %s.", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzag() {
        ((zzhu) this.zzf.get()).zzc();
        this.zzf = Optional.empty();
        this.zzw = Optional.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.meet_coactivities.zzhe, java.lang.Object] */
    public final void zzah() {
        this.zzg.get().zzc();
        this.zzg = Optional.empty();
        this.zzv = Optional.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzai() {
        ((zzkv) zzd.zzb().zzh("com/google/android/meet/addons/internal/AddonClientImpl", "resetDisconnectState", 984, "AddonClientImpl.java")).zzo("Resetting client to disconnected state.");
        this.zzs.ifPresent(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzea
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                zzil zzilVar = (zzil) obj;
                int i = zzfa.zzc;
                if (zzilVar.zzb().zzk()) {
                    zzcf zzcfVarZzc = zzilVar.zzc();
                    RecordingInfo.Builder builder = RecordingInfo.builder();
                    builder.setStatus(RecordingInfo.RecordingStatus.UNKNOWN);
                    zzcfVarZzc.zzh(builder.build());
                }
            }
        });
        this.zzs = Optional.empty();
        this.zzA = zza;
        this.zzB = zzgg.zza;
        this.zzu = Optional.empty();
        this.zzv = Optional.empty();
        this.zzw = Optional.empty();
        this.zzx = Optional.empty();
        this.zzy = Optional.empty();
        this.zzq.clear();
        this.zzr = new zzip();
    }

    private final void zzaj(final zzrq zzrqVar, final Runnable runnable) {
        Preconditions.checkState(((long) zzrqVar.zzd()) <= 200, "Participant metadata size cannot exceed %s.", 200L);
        if (zzrqVar.zzm()) {
            zzrqVar = zzb;
        }
        zzia.zza(Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzeo
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzP(zzrqVar, runnable);
            }
        }, this.zzp), "Failed to setParticipantMetadata or setParticipantMetadataDelegateOptional in MeetIpcManager.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzak() {
        return this.zzA.meetingStatus() == AddonMeetingInfo.MeetingStatus.CONNECTED && this.zzs.isPresent();
    }

    private static final zzp zzal(zzgi zzgiVar) {
        zzp zzpVarZza = zzgiVar.zza();
        boolean zZzb = zzgiVar.zzb();
        zzj zzjVarZzb = zzpVarZza.zzb();
        if (zzjVarZzb.equals(zzj.HOST_APP_UNKNOWN)) {
            throw com.google.android.meet.addons.zza.zzd("No apps are available for live sharing.", AddonException.Code.MEET_VERSION_UNSUPPORTED, "com.google.android.gm");
        }
        String str = (String) zzde.zzb.get(zzjVarZzb);
        if (zZzb) {
            throw com.google.android.meet.addons.zza.zzd(AbstractC0541b.m773o("Package ", str, " is too old. Please update."), AddonException.Code.MEET_VERSION_UNSUPPORTED, (String) Preconditions.checkNotNull(str));
        }
        return zzpVarZza;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.common.util.concurrent.ListenableFuture, java.lang.Object] */
    private final ListenableFuture zzam(final int i) {
        Preconditions.checkState(this.zzu.isPresent(), "Unexpected call to disconnectMeeting before calling connectMeeting");
        return Futures.transformAsync(this.zzu.get(), new AsyncFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzdu
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.zza.zzaa(i, (AddonMeetingInfo) obj);
            }
        }, this.zzp);
    }

    @Override // com.google.android.meet.addons.AddonClient
    public final AddonSession.Builder newSessionBuilder(AddonSessionHandler addonSessionHandler) {
        return new zzfm(addonSessionHandler, this, this.zzr);
    }

    @Override // com.google.android.meet.addons.AddonClient
    public final void notifyAddonFailureEvent(final Context context, final AddonClient.AddonFailureEventType addonFailureEventType) {
        Preconditions.checkNotNull(context, "Expected 'appContext' to be provided.");
        Preconditions.checkNotNull(addonFailureEventType, "Expected 'failureEventType' to be provided.");
        zzia.zza(Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzeb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzL(context, addonFailureEventType);
            }
        }, this.zzp), "Failed to get start info or to broadcast failure event in MeetIpcManager.", new Object[0]);
    }

    @Override // com.google.android.meet.addons.AddonClient
    public final void registerMeetingStatusListener(Context context, MeetingStatusListener meetingStatusListener, Optional<Handler> optional) {
        synchronized (zze) {
            try {
                Preconditions.checkNotNull(context, "Expected 'appContext' to be provided.");
                Preconditions.checkNotNull(context.getApplicationContext(), "Expected 'appContext#getApplicationContext()' to resolve to a non-null value.");
                Preconditions.checkNotNull(context.getApplicationContext().getPackageName(), "Expected 'appContext#getPackageName()' to be provided.");
                Preconditions.checkNotNull(optional, "Expected 'handler' to be non-null, even if Optional#empty().");
                Preconditions.checkNotNull(meetingStatusListener, "Expected 'listener' to be provided.");
                Preconditions.checkState(!this.zzz.isPresent(), "Unexpected call to registerMeetingStatusListener before calling unRegisterMeetingStatusListener.");
                Optional optionalOf = Optional.of(new zziy(new zziz(ImmutableSet.m4351of(meetingStatusListener, new MeetingStatusListener() { // from class: com.google.android.gms.internal.meet_coactivities.zzdw
                    @Override // com.google.android.meet.addons.MeetingStatusListener
                    public final void onMeetingStatusChange(MeetingStatus meetingStatus) {
                        this.zza.zzs.ifPresent(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzdo
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                zzil zzilVar = (zzil) obj;
                                int i = zzfa.zzc;
                                if (zzilVar.zzb().zzk()) {
                                    zzilVar.zzc().zzh(meetingStatus.recordingInfo());
                                }
                            }
                        });
                    }
                })), context.getApplicationContext().getPackageName(), this.zzj));
                this.zzz = optionalOf;
                zzjb.zza(context, optional, (BroadcastReceiver) optionalOf.get(), Optional.empty(), this.zzj);
                Object obj = this.zzz.get();
                if (Build.VERSION.SDK_INT >= 33) {
                    context.getApplicationContext().registerReceiver((BroadcastReceiver) obj, new IntentFilter("ACTION_S11Y_EVENT_BUS"), null, optional.orElse(null), 2);
                } else {
                    context.getApplicationContext().registerReceiver((BroadcastReceiver) obj, new IntentFilter("ACTION_S11Y_EVENT_BUS"), null, optional.orElse(null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.meet.addons.AddonClient
    public final void unregisterMeetingStatusListener(Context context) {
        synchronized (zze) {
            Preconditions.checkNotNull(context, "Expected 'appContext' to be provided.");
            Preconditions.checkNotNull(context.getApplicationContext(), "Expected 'appContext#getApplicationContext()' to resolve to a non-null value.");
            Preconditions.checkState(this.zzz.isPresent(), "Unexpected call to `unRegisterMeetingStatusListener` before calling `registerStatusListener`");
            this.zzs.ifPresent(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzef
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfa.zzc;
                    Preconditions.checkState(!((zzil) obj).zzb().zzk(), "Unexpected call to `unRegisterMeetingStatusListener` after calling `verifyRecordingInfo` before connecting to the meeting.");
                }
            });
            context.unregisterReceiver((BroadcastReceiver) this.zzz.get());
            this.zzz = Optional.empty();
        }
    }

    public final /* synthetic */ void zzL(Context context, AddonClient.AddonFailureEventType addonFailureEventType) {
        int i;
        zzp zzpVarZzal = zzal(zzgj.zza(context, "", this.zzj, this.zzD, false));
        zzcf zzcfVar = (zzcf) this.zzn.apply(context);
        AddonClient.AddonFailureEventType addonFailureEventType2 = AddonClient.AddonFailureEventType.FAILURE_EVENT_UNSPECIFIED;
        switch (addonFailureEventType) {
            case FAILURE_EVENT_UNSPECIFIED:
                i = 2;
                break;
            case FAILURE_USER_INSUFFICIENT_TIER:
                i = 3;
                break;
            case FAILURE_USER_UNKNOWN:
                i = 4;
                break;
            case FAILURE_USER_CANCELLED:
                i = 5;
                break;
            case FAILURE_USER_UNAUTHORIZED:
                i = 6;
                break;
            case FAILURE_APP_GENERIC_ERROR:
                i = 7;
                break;
            case FAILURE_APP_NETWORK_CONNECTIVITY:
                i = 8;
                break;
            case FAILURE_APP_STARTUP:
                i = 9;
                break;
            default:
                throw new AssertionError();
        }
        zzcfVar.zzm(context, i, zzpVarZzal.zzb());
    }

    public final /* synthetic */ void zzM() {
        ((zzil) this.zzs.get()).zzc().zzi();
    }

    public final /* synthetic */ void zzN(CollaborationStartingState collaborationStartingState) {
        ((zzil) this.zzs.get()).zzc().zzj(collaborationStartingState);
    }

    public final /* synthetic */ void zzO(ParticipantMetadataHandler participantMetadataHandler) {
        this.zzt = Optional.of(participantMetadataHandler);
    }

    public final /* synthetic */ void zzP(zzrq zzrqVar, Runnable runnable) {
        ((zzil) this.zzs.get()).zzc().zzk(zzrqVar);
        runnable.run();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final void zzQ(Runnable runnable) {
        this.zzq.add(runnable);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final void zzR() {
        zzia.zza(Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzed
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzM();
            }
        }, this.zzp), "Failed to resetCollaborationStartingState in MeetIpcManager.", new Object[0]);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final void zzS(final CollaborationStartingState collaborationStartingState) {
        Preconditions.checkNotNull(collaborationStartingState, "Expected parameter 'startingState' to be provided.");
        zzia.zza(Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzN(collaborationStartingState);
            }
        }, this.zzp), "Failed to setCollaborationStartingState in MeetIpcManager.", new Object[0]);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final void zzT(zzrq zzrqVar) {
        zzaj(zzrqVar, new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdr
            @Override // java.lang.Runnable
            public final void run() {
                int i = zzfa.zzc;
            }
        });
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final void zzU(zzrq zzrqVar, final ParticipantMetadataHandler participantMetadataHandler) {
        Preconditions.checkNotNull(participantMetadataHandler, "Expected 'handler' to be provided.");
        zzaj(zzrqVar, new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzel
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzO(participantMetadataHandler);
            }
        });
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final boolean zzW() {
        return this.zzs.isPresent();
    }

    public final /* synthetic */ zzgm zzX(CoDoingHandler coDoingHandler, Optional optional) {
        Optional optionalOf = Optional.of(zzac().zzg(coDoingHandler));
        this.zzf = optionalOf;
        Object obj = optionalOf.get();
        if (optional.isPresent()) {
            ((zzkv) zzd.zzc().zzh("com/google/android/meet/addons/internal/AddonClientImpl", "handleInitialCoDoingStates", 644, "AddonClientImpl.java")).zzo("CoDoing initial state present");
            CoDoingState coDoingState = (CoDoingState) optional.get();
            Preconditions.checkNotNull(coDoingState, "Expected 'newGlobalState' to be provided.");
            Preconditions.checkState(zzjz.zzd(coDoingState).zzd().zzd() <= 16384, "Blob size cannot be greater than %s bytes.", 16384);
            ((zzhu) obj).zze(new zzgl((zzgm) obj, coDoingState));
        } else {
            Stream streamFilter = this.zzC.stream().filter(new zzen());
            Objects.requireNonNull(obj);
            final zzgm zzgmVar = (zzgm) obj;
            streamFilter.forEach(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzee
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    zzgmVar.zzd((zzpx) obj2);
                }
            });
        }
        return (zzgm) this.zzf.get();
    }

    public final /* synthetic */ ListenableFuture zzY(int i) {
        return ((zzil) this.zzs.get()).zzc().zzl(i);
    }

    public final /* synthetic */ ListenableFuture zzZ(final int i) {
        return Futures.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdq
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzY(i);
            }
        }, this.zzp);
    }

    @Override // com.google.android.meet.addons.zzaj
    public final ListenableFuture zza(final CoDoingHandler coDoingHandler, final Optional optional) {
        Preconditions.checkNotNull(coDoingHandler, "Expected 'handler' to be provided.");
        Preconditions.checkNotNull(optional, "Expected 'initiatorInitialCoDoingState' to be provided.");
        return Futures.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdn
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzo(coDoingHandler, optional);
            }
        }, this.zzp);
    }

    public final /* synthetic */ ListenableFuture zzaa(final int i, AddonMeetingInfo addonMeetingInfo) {
        Preconditions.checkState(this.zzs.isPresent(), "Unexpected call to disconnectMeeting before calling connectMeeting");
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.add(zzia.zza(this.zzw.isPresent() ? (ListenableFuture) this.zzy.orElseGet(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzdj
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.zza.zzt();
            }
        }) : Futures.immediateVoidFuture(), "Failed to end co-doing.", new Object[0]));
        builder.add(zzia.zza(this.zzv.isPresent() ? (ListenableFuture) this.zzx.orElseGet(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzdk
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.zza.zzu();
            }
        }) : Futures.immediateVoidFuture(), "Failed to end co-watching.", new Object[0]));
        Futures.FutureCombiner futureCombinerWhenAllComplete = Futures.whenAllComplete(builder.build());
        AsyncCallable asyncCallable = new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdl
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzZ(i);
            }
        };
        Executor executor = zzir.zza;
        return zzia.zzb(Futures.transformAsync(futureCombinerWhenAllComplete.callAsync(asyncCallable, executor), new AsyncFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzdm
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.zza.zzv((Void) obj);
            }
        }, executor), "Unexpected error when trying to disconnect from meeting.");
    }

    @Override // com.google.android.meet.addons.zzaj
    public final ListenableFuture zzb(final CoWatchingHandler coWatchingHandler, final Optional optional) {
        Preconditions.checkNotNull(coWatchingHandler, "Expected 'handler' to be provided.");
        Preconditions.checkNotNull(optional, "Expected 'initiatorInitialCoWatchingState' to be provided.");
        return Futures.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdg
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzp(coWatchingHandler, optional);
            }
        }, this.zzp);
    }

    @Override // com.google.android.meet.addons.zzaj
    public final ListenableFuture zzc(Context context, AddonSessionHandler addonSessionHandler) {
        return zzad(context, addonSessionHandler, false);
    }

    @Override // com.google.android.meet.addons.zzaj
    public final ListenableFuture zzd() {
        return Futures.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzep
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzr();
            }
        }, this.zzp);
    }

    public final /* synthetic */ zzce zze() {
        return this.zzh;
    }

    public final /* synthetic */ zzcf zzf(Context context) {
        Context applicationContext = context.getApplicationContext();
        Supplier supplier = new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzdf
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.zza.zze();
            }
        };
        zzin zzinVar = this.zzi;
        zzbx zzbxVarZzc = zzby.zzc();
        zzbxVarZzc.zza(zzinVar.zzc());
        zzbxVarZzc.zzb(this.zzi.zze());
        return zzcf.zze(applicationContext, supplier, zzbxVarZzc.zzc());
    }

    public final /* synthetic */ AddonMeetingInfo zzg(zzx zzxVar) {
        this.zzA = zzjw.zzb(zzxVar.zzb());
        ((zzkv) zzd.zzb().zzh("com/google/android/meet/addons/internal/AddonClientImpl", "lambda$handleConnectMeeting$4", 335, "AddonClientImpl.java")).zzp("Received meetingInfo with status : %s", zzxVar.zzb().zzd());
        this.zzB = zzgg.zzf(((zzil) this.zzs.get()).zzc().zzd());
        List listZzg = zzxVar.zzg();
        this.zzC = listZzg;
        AddonMeetingInfo addonMeetingInfoBuild = this.zzA;
        List list = (List) listZzg.stream().filter(new zzej()).collect(Collectors.toCollection(new zzem()));
        if (list.size() > 1) {
            throw new IllegalStateException("More than one CoWatching initial state received.");
        }
        if (!list.isEmpty()) {
            addonMeetingInfoBuild = zzab(addonMeetingInfoBuild, (zzpx) list.get(0));
        }
        List list2 = (List) this.zzC.stream().filter(new zzen()).collect(Collectors.toCollection(new zzem()));
        if (list2.size() > 1) {
            throw new IllegalStateException("More than one CoDoing initial state received.");
        }
        if (!list2.isEmpty()) {
            addonMeetingInfoBuild = addonMeetingInfoBuild.toBuilder().setInitialCoDoingState(zzjz.zzc(((zzpx) list2.get(0)).zzf().zza())).build();
        }
        this.zzA = addonMeetingInfoBuild;
        return addonMeetingInfoBuild;
    }

    public final /* synthetic */ CoDoingClient zzh(final CoDoingHandler coDoingHandler, final Optional optional, AddonMeetingInfo addonMeetingInfo) {
        zzae("beginCoDoing");
        Preconditions.checkState(!this.zzf.isPresent(), "Unexpected call to beginCoDoing during an existing co-doing activity.");
        return (CoDoingClient) zzia.zzc(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzdi
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.zza.zzX(coDoingHandler, optional);
            }
        }, "Unexpected error when trying to begin co-doing.");
    }

    public final /* synthetic */ CoWatchingClient zzi(final CoWatchingHandler coWatchingHandler, final Optional optional, AddonMeetingInfo addonMeetingInfo) {
        zzae("beginCoWatching");
        Preconditions.checkState(!this.zzg.isPresent(), "Unexpected call to beginCoWatching during an existing co-watching activity.");
        return (CoWatchingClient) zzia.zzc(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzds
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.zza.zzj(coWatchingHandler, optional);
            }
        }, "Unexpected error when trying to begin co-watching.");
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.android.gms.internal.meet_coactivities.zzif, com.google.android.meet.addons.CoWatchingClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.google.android.gms.internal.meet_coactivities.zzif, java.lang.Object] */
    public final /* synthetic */ zzif zzj(CoWatchingHandler coWatchingHandler, Optional optional) {
        Optional optionalOf = Optional.of(zzac().zzb(coWatchingHandler));
        this.zzg = optionalOf;
        final ?? r6 = optionalOf.get();
        if (optional.isPresent()) {
            ((zzkv) zzd.zzc().zzh("com/google/android/meet/addons/internal/AddonClientImpl", "handleInitialCoWatchingStates", 763, "AddonClientImpl.java")).zzo("CoWatching initial state present");
            CoWatchingState coWatchingState = (CoWatchingState) optional.get();
            r6.notifySwitchedToMedia("", coWatchingState.mediaId(), coWatchingState.mediaPlayoutPosition(), coWatchingState.coWatchingQueue());
        } else {
            Stream streamFilter = this.zzC.stream().filter(new zzej());
            Objects.requireNonNull(r6);
            streamFilter.forEach(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzec
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    r6.zzd((zzpx) obj);
                }
            });
        }
        return this.zzg.get();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final ListenableFuture zzm(Context context, AddonSessionHandler addonSessionHandler) {
        return zzad(context, addonSessionHandler, true);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzie
    public final ListenableFuture zzn(final AddonSession.EndReason endReason) {
        return Futures.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.meet_coactivities.zzek
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                return this.zza.zzs(endReason);
            }
        }, this.zzp);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.common.util.concurrent.ListenableFuture, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.common.util.concurrent.ListenableFuture, java.lang.Object] */
    public final /* synthetic */ ListenableFuture zzo(final CoDoingHandler coDoingHandler, final Optional optional) {
        this.zzy = Optional.empty();
        zzaf("beginCoDoing");
        Optional optionalOf = Optional.of(Futures.transform(this.zzu.get(), new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzeh
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.zza.zzh(coDoingHandler, optional, (AddonMeetingInfo) obj);
            }
        }, this.zzp));
        this.zzw = optionalOf;
        return optionalOf.get();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.common.util.concurrent.ListenableFuture, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.common.util.concurrent.ListenableFuture, java.lang.Object] */
    public final /* synthetic */ ListenableFuture zzp(final CoWatchingHandler coWatchingHandler, final Optional optional) {
        this.zzx = Optional.empty();
        zzaf("beginCoWatching");
        Optional optionalOf = Optional.of(Futures.transform(this.zzu.get(), new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzdy
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.zza.zzi(coWatchingHandler, optional, (AddonMeetingInfo) obj);
            }
        }, this.zzp));
        this.zzv = optionalOf;
        return optionalOf.get();
    }

    /* JADX WARN: Type inference failed for: r9v12, types: [com.google.common.util.concurrent.ListenableFuture, java.lang.Object] */
    public final /* synthetic */ ListenableFuture zzq(Context context, String str, boolean z, AddonSessionHandler addonSessionHandler) {
        Preconditions.checkState(!this.zzs.isPresent(), "Unexpected call to connectMeeting before calling disconnectMeeting");
        zzp zzpVarZzal = zzal(zzgj.zza(context, str, this.zzj, this.zzD, z));
        zzfz zzfzVar = new zzfz();
        zzfzVar.zzc(context);
        zzfzVar.zzd((zzcf) this.zzn.apply(context));
        zzfzVar.zzb(addonSessionHandler);
        zzfzVar.zza(str);
        zzfzVar.zze(zzpVarZzal);
        this.zzs = Optional.of(zzfzVar.zzf());
        if (z && !this.zzz.isPresent()) {
            zzai();
            return Futures.immediateFailedFuture(new IllegalStateException("Meeting status listener is not registered before tracking recording info."));
        }
        ListenableFuture listenableFutureZzf = ((zzil) this.zzs.get()).zzc().zzf(((zzil) this.zzs.get()).zzb(), ImmutableSet.m4350of(zzt.SESSION_LEAVING));
        com.google.common.base.Function function = new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzdp
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.zza.zzg((zzx) obj);
            }
        };
        Executor executor = zzir.zza;
        ListenableFuture listenableFutureTransform = Futures.transform(listenableFutureZzf, function, executor);
        Futures.addCallback(listenableFutureTransform, new zzeq(this), executor);
        Optional optionalOf = Optional.of(listenableFutureTransform);
        this.zzu = optionalOf;
        return zzia.zzb(optionalOf.get(), "Unexpected error when trying to connect to meeting.");
    }

    public final /* synthetic */ ListenableFuture zzr() {
        return zzam(2);
    }

    public final /* synthetic */ ListenableFuture zzs(AddonSession.EndReason endReason) {
        AddonSession.EndReason endReason2 = AddonSession.EndReason.UNKNOWN;
        return zzam(endReason.ordinal() != 1 ? 2 : 3);
    }

    public final /* synthetic */ ListenableFuture zzt() {
        zzae("endCoDoing");
        Preconditions.checkState(this.zzf.isPresent(), "Expected co-doing activity to exist before calling endCoDoing.");
        zzia.zzd(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzei
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzag();
            }
        }, "Unexpected error when trying to end co-doing.");
        return Futures.immediateFuture(null);
    }

    public final /* synthetic */ ListenableFuture zzu() {
        zzae("endCoWatching");
        Preconditions.checkState(this.zzg.isPresent(), "Expected co-watching activity to exist before calling endCoWatching.");
        zzia.zzd(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdt
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzah();
            }
        }, "Unexpected error when trying to end co-watching.");
        return Futures.immediateFuture(null);
    }

    public final /* synthetic */ ListenableFuture zzv(Void r2) {
        return Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzdz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzai();
            }
        }, this.zzp);
    }
}
