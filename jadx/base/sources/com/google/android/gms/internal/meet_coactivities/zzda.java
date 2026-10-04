package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.meet.addons.AddonException;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.RecordingInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.time.Duration;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzda extends zzcf implements zzbw {
    private static final zzkz zza = zzkz.zzj("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl");
    private static final Object zzb = new Object();
    private static final Object zzc = new Object();
    private volatile Duration zzd;
    private volatile Duration zze;
    private final Object zzf;
    private zzrq zzg;
    private CollaborationStartingState zzh;
    private final Object zzi;
    private Set zzj;
    private Set zzk;
    private final Object zzl;
    private zzcb zzm;
    private zzapf zzn;
    private zzbu zzo;
    private RecordingInfo zzp;
    private final ListeningExecutorService zzq;
    private final ListeningExecutorService zzr;
    private final zzce zzs;
    private final zzdd zzt;
    private volatile zzg zzu;
    private final String zzv;
    private volatile Optional zzw;

    public zzda(Context context, zzce zzceVar, zzby zzbyVar) {
        zzcc zzccVar = new zzcc(context);
        this.zzd = zzcd.zzb;
        this.zze = zzcd.zzc;
        this.zzf = new Object();
        this.zzi = new Object();
        this.zzj = new HashSet();
        this.zzk = new HashSet();
        this.zzl = new Object();
        this.zzm = zzcb.zza;
        this.zzn = null;
        this.zzo = null;
        this.zzp = null;
        this.zzw = Optional.empty();
        this.zzs = zzceVar;
        this.zzt = zzccVar;
        this.zzu = null;
        this.zzv = context.getPackageName();
        this.zzq = zzbyVar.zzb();
        this.zzr = zzbyVar.zza();
    }

    @AnyThread
    private static zzi zzC() {
        zzh zzhVarZza = zzi.zza();
        zzhVarZza.zza("2.0.0-alpha08");
        return (zzi) zzhVarZza.zzk();
    }

    private final zzl zzD(zzal zzalVar) {
        zzl zzlVar;
        synchronized (this.zzl) {
            Verify.verifyNotNull(this.zzm.zzb(), "meetingInfo unexpectedly null when handling end of meeting", new Object[0]);
            zzk zzkVar = (zzk) this.zzm.zzb().zzB();
            zzkVar.zza(zzalVar);
            zzlVar = (zzl) zzkVar.zzk();
        }
        int iOrdinal = zzalVar.ordinal();
        if (iOrdinal == 4 || iOrdinal == 7) {
            zzL();
        } else {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "processIncomingMeetingStateUpdate", 531, "MeetIpcManagerImpl.java")).zzp("Unexpected receipt of meeting status %s", zzalVar.name());
        }
        return (zzl) Verify.verifyNotNull(zzlVar);
    }

    @AnyThread
    private static zzu zzE(zzi zziVar, String str, zzp zzpVar, ImmutableSet immutableSet) {
        if (zzpVar.zza() == 0) {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getMeetingRequest", 1194, "MeetIpcManagerImpl.java")).zzo("Missing cloud project number in start info.");
        }
        zzs zzsVarZza = zzu.zza();
        zzsVarZza.zzf(zziVar);
        zzsVarZza.zzb(zzpVar.zze());
        zzsVarZza.zzd(str);
        zzsVarZza.zzc(zzpVar.zza());
        zzsVarZza.zza(immutableSet);
        zzsVarZza.zze(zzpVar.zzk());
        return (zzu) zzsVarZza.zzk();
    }

    private static IllegalStateException zzF(String str) {
        return new IllegalStateException("Timed out waiting for IPC : ".concat(str));
    }

    @AnyThread
    private static Throwable zzG(zzj zzjVar, String str) {
        if (zzjVar.equals(zzj.HOST_APP_UNKNOWN)) {
            return new IllegalStateException(AbstractC0541b.m773o("The ", str, " call is not executed because host application is missing."));
        }
        return null;
    }

    private static void zzH(String str, zzca zzcaVar) {
        zzI(str, ImmutableSet.m4351of(zzca.CONNECTED, zzca.BROADCASTING), zzcaVar);
    }

    private static void zzI(String str, Set set, zzca zzcaVar) {
        Preconditions.checkState(set.contains(zzcaVar), "Unexpected call to %s in state: %s", str, zzcaVar.name());
    }

    private static void zzJ(ListenableFuture listenableFuture, Executor executor, String str) {
        Futures.addCallback(listenableFuture, new zzcz(str), executor);
    }

    private final void zzK(List list, List list2) {
        zzkz zzkzVar = zza;
        ((zzkv) zzkzVar.zzc().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "processPrivilegeUpdates", 460, "MeetIpcManagerImpl.java")).zzs("Processing privilege updates with enabled privileges: %s and disabled privileges %s", list, list2);
        synchronized (this.zzi) {
            try {
                if (list.isEmpty() && list2.isEmpty()) {
                    ((zzkv) zzkzVar.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "processPrivilegeUpdates", 466, "MeetIpcManagerImpl.java")).zzo("Both enabled and disabled privileges lists received from Meet are empty.");
                    return;
                }
                HashSet hashSet = new HashSet(list);
                HashSet hashSet2 = new HashSet(list2);
                if (this.zzj.equals(hashSet) && this.zzk.equals(hashSet2)) {
                    ((zzkv) zzkzVar.zzc().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "processPrivilegeUpdates", 477, "MeetIpcManagerImpl.java")).zzo("Ignoring privilege information as it has not changed since previous update.");
                    return;
                }
                EnumSet enumSetNewEnumSet = Sets.newEnumSet(hashSet, zzam.class);
                enumSetNewEnumSet.retainAll((Set) list2.stream().map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzcv
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((zzac) obj).zzb();
                    }
                }).collect(Collectors.toCollection(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzcw
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return new LinkedHashSet();
                    }
                })));
                if (!enumSetNewEnumSet.isEmpty()) {
                    ((zzkv) zzkzVar.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "processPrivilegeUpdates", 491, "MeetIpcManagerImpl.java")).zzo("Ignoring privilege updates as enabled and disabled privileges have common privileges which is not expected.");
                    return;
                }
                this.zzj = hashSet;
                this.zzk = hashSet2;
                this.zzs.zzd(list, list2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzL() {
        synchronized (this.zzl) {
            zzM(Optional.empty());
        }
    }

    private final void zzM(Optional optional) {
        optional.ifPresent(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzck
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((zzkv) zzda.zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "lambda$resetIpcState$14", 940, "MeetIpcManagerImpl.java")).zzp("Resetting state in response to %s", (String) obj);
            }
        });
        if (this.zzm.zzc().equals(zzca.DISCONNECTED)) {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "resetIpcState", 943, "MeetIpcManagerImpl.java")).zzp("Already disconnected when resetting IPC State - thread %s", Thread.currentThread().getName());
        }
        this.zzm = zzcb.zza;
        synchronized (zzc) {
            this.zzo = null;
        }
        synchronized (zzb) {
            this.zzn = null;
        }
    }

    private final void zzN(String str, final Runnable runnable) {
        ListenableFuture listenableFutureSubmit = this.zzr.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                runnable.run();
                return null;
            }
        });
        ((zzkv) zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "submitIncomingIpcTask", 979, "MeetIpcManagerImpl.java")).zzs("Called %s on ipcHandler - thread %s", str, Thread.currentThread().getName());
        Futures.addCallback(listenableFutureSubmit, new zzcy(this, str), this.zzr);
    }

    private final void zzO(zzpx zzpxVar, zzqw zzqwVar, zzc zzcVar) {
        zzar zzarVarZza = zzas.zza();
        zzarVarZza.zza(zzqwVar);
        zzarVarZza.zzb(zzpxVar.zzq() ? zzqx.HEARTBEAT : zzqx.UPDATE);
        zzas zzasVar = (zzas) zzarVarZza.zzk();
        zzkz zzkzVar = zza;
        ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "sendStatRequestOverIpc", 626, "MeetIpcManagerImpl.java")).zzt("Calling broadcastStatSample of type %s and direction %s - thread %s", zzasVar.zzd(), zzasVar.zzc(), Thread.currentThread().getName());
        if (zzcVar == null) {
            ((zzkv) zzkzVar.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "sendStatRequestOverIpc", 631, "MeetIpcManagerImpl.java")).zzo("Unexpected null stub, skipping stat request");
            return;
        }
        final zzdc zzdcVar = new zzdc(this.zzd, "StatResponseObserver");
        zzbf zzbfVarZza = zzbg.zza();
        zzbfVarZza.zza(zzasVar);
        zzapl.zzb(zzcVar.zzc().zza(zzd.zzc(), zzcVar.zzb()), (zzbg) zzbfVarZza.zzk(), zzdcVar);
        zzJ(this.zzq.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzda.zzr(zzdcVar);
            }
        }), this.zzr, "broadcastStatSample");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* JADX INFO: renamed from: zzP, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzx zzo(zzdc zzdcVar, zzc zzcVar) throws Throwable {
        zzkz zzkzVar = zza;
        ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getConnectionResponseAndSetMeetingHandle", 868, "MeetIpcManagerImpl.java")).zzp("Calling getConnectMeetingResponse - thread %s", Thread.currentThread().getName());
        zzx zzxVar = (zzx) zzdcVar.zzd();
        Throwable th = zzdcVar.zzb;
        if (zzxVar == null || !zzxVar.zzj() || zzxVar.zzk() != 2) {
            Throwable thZzR = zzR(zzxVar == null ? 0 : zzxVar.zzk());
            if (thZzR == null) {
                if (th == null) {
                    ((zzkv) zzkzVar.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getConnectionException", SpenHoverPointerIcon.HOVER_POINTER_ICON_TYPE_CONTROL_ROTATE, "MeetIpcManagerImpl.java")).zzp("Timed out waiting for connectMeeting - thread %s", Thread.currentThread().getName());
                    thZzR = zzF("connectMeeting");
                } else if (!(th instanceof zzabf) || ((zzabf) th).zza().zza() != zzabd.zze.zza() || (thZzR = zzR(7)) == null) {
                    thZzR = th instanceof AddonException ? (AddonException) th : new IllegalStateException("ConnectMeetingResponse or MeetingInfo is null");
                    ((zzkv) ((zzkv) zzkzVar.zze().zzg(th)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getConnectionException", 1128, "MeetIpcManagerImpl.java")).zzp("Failed call to connectMeeting - thread %s", Thread.currentThread().getName());
                }
            }
            zzL();
            throw thZzR;
        }
        ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getConnectionResponseAndSetMeetingHandle", 872, "MeetIpcManagerImpl.java")).zzs("Received response for connectMeeting with meetingInfo %s - thread %s", zzxVar.zzb().zzf(), Thread.currentThread().getName());
        this.zzw = Optional.of(zzxVar.zze());
        this.zzu = zzxVar.zza();
        synchronized (this.zzl) {
            if (!this.zzm.zzc().equals(zzca.CONNECTING)) {
                throw new IllegalStateException("Ignoring connection response received in state " + this.zzm.zzc().name());
            }
            zzl zzlVarZzb = zzxVar.zzb();
            zzbs zzbsVar = new zzbs();
            zzbsVar.zzc(zzca.CONNECTED);
            zzbsVar.zzb(zzlVarZzb);
            zzbsVar.zza(zzcVar);
            this.zzm = zzbsVar.zzd();
        }
        synchronized (this.zzi) {
            this.zzj.clear();
            this.zzk.clear();
        }
        zzK(zzxVar.zzh(), zzxVar.zzf());
        return zzxVar;
    }

    private static Object zzQ(zzdc zzdcVar, String str) {
        Object objZzd = zzdcVar.zzd();
        if (objZzd != null) {
            ((zzkv) zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getIpcResponse", 1062, "MeetIpcManagerImpl.java")).zzs("Received response for %s - thread %s", str, Thread.currentThread().getName());
            return objZzd;
        }
        Throwable th = zzdcVar.zzb;
        if (th == null) {
            IllegalStateException illegalStateExceptionZzF = zzF(str);
            ((zzkv) ((zzkv) zza.zze().zzg(illegalStateExceptionZzF)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getIpcResponse", WidgetConstant.COVER_SCREEN_HEIGHT, "MeetIpcManagerImpl.java")).zzn();
            throw illegalStateExceptionZzF;
        }
        IllegalStateException illegalStateException = new IllegalStateException(th);
        ((zzkv) ((zzkv) zza.zzd().zzg(illegalStateException)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getIpcResponse", 1058, "MeetIpcManagerImpl.java")).zzp("Failed to get %s response ", str);
        throw illegalStateException;
    }

    private static RuntimeException zzR(int i) {
        int i2;
        if (i == 0 || i - 2 == 0) {
            return null;
        }
        if (i2 == 2) {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1150, "MeetIpcManagerImpl.java")).zzp("Failed to connect because the feature is disabled - thread %s", Thread.currentThread().getName());
            return com.google.android.meet.addons.zza.zza(AddonException.Code.PARTICIPANT_INELIGIBLE);
        }
        switch (i2) {
            case 4:
                ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1155, "MeetIpcManagerImpl.java")).zzp("Failed to connect because live sharing is already in progress with a different LSA - thread %s", Thread.currentThread().getName());
                return com.google.android.meet.addons.zza.zza(AddonException.Code.ADDON_SESSION_IN_PROGRESS_WITH_DIFFERENT_APPLICATION);
            case 5:
                ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1161, "MeetIpcManagerImpl.java")).zzp("Failed to connect because there was a security policy exception - thread %s", Thread.currentThread().getName());
                return com.google.android.meet.addons.zza.zza(AddonException.Code.SECURITY_POLICY_EXCEPTION);
            case 6:
                ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1176, "MeetIpcManagerImpl.java")).zzp("Failed to connect because addon was not installed - thread %s", Thread.currentThread().getName());
                return com.google.android.meet.addons.zza.zza(AddonException.Code.ADDON_NOT_INSTALLED);
            case 7:
                ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1166, "MeetIpcManagerImpl.java")).zzp("Failed to connect because an unsupported operation was requested - thread %s", Thread.currentThread().getName());
                return com.google.android.meet.addons.zza.zza(AddonException.Code.OPERATION_UNSUPPORTED);
            case 8:
                ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1171, "MeetIpcManagerImpl.java")).zzp("Failed to connect because ongoing recording was detected in Meet - thread %s", Thread.currentThread().getName());
                return com.google.android.meet.addons.zza.zza(AddonException.Code.ONGOING_RECORDING);
            default:
                ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "getExceptionFromFailureReason", 1181, "MeetIpcManagerImpl.java")).zzs("Failed to connect: %s - thread %s", zzy.zza(i), Thread.currentThread().getName());
                return new IllegalStateException("Failed for reason: ".concat(zzy.zza(i)));
        }
    }

    public static /* synthetic */ zzag zzp(zzdc zzdcVar) {
        return (zzag) zzQ(zzdcVar, "disconnectMeeting");
    }

    public static /* synthetic */ zzak zzq(zzdc zzdcVar) {
        return (zzak) zzQ(zzdcVar, "broadcastEventNotification");
    }

    public static /* synthetic */ zzbi zzr(zzdc zzdcVar) {
        return (zzbi) zzQ(zzdcVar, "broadcastStatSample");
    }

    public final /* synthetic */ void zzA(zzpx zzpxVar) {
        zzkz zzkzVar = zza;
        ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleBroadcastStateUpdate", 665, "MeetIpcManagerImpl.java")).zzp("Calling handleBroadcastStateUpdate - thread %s", Thread.currentThread().getName());
        synchronized (zzb) {
            try {
                if (this.zzn == null) {
                    ((zzkv) zzkzVar.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleBroadcastStateUpdate", 673, "MeetIpcManagerImpl.java")).zzo("Missing outgoing observer, skipping sending update");
                    return;
                }
                zzbj zzbjVarZza = zzbk.zza();
                zzbjVarZza.zze(zzpxVar);
                zzbjVarZza.zzb((zzao) this.zzw.get());
                synchronized (this.zzf) {
                    try {
                        if (this.zzg != null) {
                            zzm zzmVarZza = zzn.zza();
                            zzmVarZza.zza((zzrq) Preconditions.checkNotNull(this.zzg));
                            zzmVarZza.zzb(zzpxVar.zzh());
                            zzmVarZza.zzc(zzpxVar.zza());
                            zzbjVarZza.zzd(zzmVarZza);
                        }
                        CollaborationStartingState collaborationStartingState = this.zzh;
                        if (collaborationStartingState != null) {
                            CollaborationStartingState collaborationStartingState2 = (CollaborationStartingState) Preconditions.checkNotNull(collaborationStartingState);
                            if (collaborationStartingState2 == null) {
                                throw new AssertionError("Empty collaboration starting state");
                            }
                            zzq zzqVarZza = zzr.zza();
                            if (collaborationStartingState2.additionalData() != null) {
                                zzqVarZza.zza((String) Preconditions.checkNotNull(collaborationStartingState2.additionalData()));
                            }
                            Uri uriMainStageUrl = collaborationStartingState2.mainStageUrl();
                            if (uriMainStageUrl != null && uriMainStageUrl.getPath() != null) {
                                zzqVarZza.zzb((String) Preconditions.checkNotNull(uriMainStageUrl.getPath()));
                            }
                            Uri uriSidePanelUrl = collaborationStartingState2.sidePanelUrl();
                            if (uriSidePanelUrl != null && uriSidePanelUrl.getPath() != null) {
                                zzqVarZza.zzc((String) Preconditions.checkNotNull(uriSidePanelUrl.getPath()));
                            }
                            zzbjVarZza.zza((zzr) zzqVarZza.zzk());
                        }
                        RecordingInfo recordingInfo = this.zzp;
                        if (recordingInfo != null) {
                            RecordingInfo recordingInfo2 = (RecordingInfo) Preconditions.checkNotNull(recordingInfo);
                            zzap zzapVarZza = zzaq.zza();
                            RecordingInfo.RecordingStatus recordingStatusStatus = recordingInfo2.status();
                            RecordingInfo.RecordingStatus recordingStatus = RecordingInfo.RecordingStatus.UNKNOWN;
                            int iOrdinal = recordingStatusStatus.ordinal();
                            int i = 2;
                            if (iOrdinal != 0) {
                                if (iOrdinal == 1) {
                                    i = 3;
                                } else if (iOrdinal == 2) {
                                    i = 4;
                                }
                            }
                            zzapVarZza.zza(i);
                            zzbjVarZza.zzc((zzaq) zzapVarZza.zzk());
                        }
                        ((zzapf) Preconditions.checkNotNull(this.zzn)).zzc((zzbk) zzbjVarZza.zzk());
                        this.zzg = null;
                        this.zzh = null;
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbw
    @BinderThread
    public final void zza(final zzbn zzbnVar) {
        zzc zzcVarZza;
        synchronized (this.zzl) {
            zzcVarZza = this.zzm.zza();
        }
        if (zzcVarZza == null) {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleIncomingUpdate", 404, "MeetIpcManagerImpl.java")).zzo("Ignoring stale incoming update");
            return;
        }
        zzpx zzpxVarZzf = zzbnVar.zzf();
        synchronized (zzc) {
            try {
                int iZzu = zzpxVarZzf.zzu();
                if (iZzu == 0) {
                    throw null;
                }
                if (iZzu != 1) {
                    zzO(zzpxVarZzf, zzqw.INCOMING, zzcVarZza);
                }
                zzN("handleStateUpdate", new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzu(zzbnVar);
                    }
                });
                if (!zzbnVar.zza().zzd().isEmpty()) {
                    zzN("handleParticipantMetadataSet", new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcm
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzv(zzbnVar);
                        }
                    });
                }
                if (zzbnVar.zzj()) {
                    ((zzkv) zza.zzc().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleIncomingUpdate", 428, "MeetIpcManagerImpl.java")).zzp("Handle incoming collaboration starting state: %s", zzbnVar.zzb());
                    zzN("handleCollaborationStartingState", new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcn
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzw(zzbnVar);
                        }
                    });
                }
                zzK(zzbnVar.zzh(), zzbnVar.zzg());
                if (!zzbnVar.zzc().equals(zzal.CONNECTED)) {
                    final zzl zzlVarZzD = zzD(zzbnVar.zzc());
                    zzN("handleMeetingStateUpdate", new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzco
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzx(zzlVarZzD);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbw
    public final void zzb(Optional optional) {
        zzL();
        if (optional.isPresent()) {
            zzk zzkVarZza = zzl.zza();
            zzkVarZza.zza(zzal.ENDED_UNEXPECTEDLY);
            final zzl zzlVar = (zzl) zzkVarZza.zzk();
            zzN("handleMeetingStateUpdate", new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcs
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzy(zzlVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzbw
    @BinderThread
    public final void zzc(zzx zzxVar) {
        if (zzxVar == null) {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleStreamingConnectMeetingResponse", 545, "MeetIpcManagerImpl.java")).zzo("Received null ConnectMeetingResponse, ignoring it.");
            return;
        }
        zzal zzalVarZzd = zzxVar.zzb().zzd();
        if (!Objects.equals(zzalVarZzd, zzal.NOT_CONNECTED)) {
            ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleStreamingConnectMeetingResponse", 550, "MeetIpcManagerImpl.java")).zzp("Received ConnectMeetingResponse with status: %s, ignoring it.", zzalVarZzd.name());
            return;
        }
        Optional optional = this.zzw;
        if (optional.isPresent()) {
            if (((zzsy) optional.get()).equals(zzxVar.zze())) {
                final zzl zzlVarZzD = zzD(zzalVarZzd);
                zzN("handleMeetingStateUpdate", new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzz(zzlVarZzD);
                    }
                });
                return;
            }
        }
        ((zzkv) zza.zze().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "handleStreamingConnectMeetingResponse", 558, "MeetIpcManagerImpl.java")).zzo("ConnectMeetingHandle doesn't match, ignoring it.");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    @WorkerThread
    public final zzg zzd() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    @WorkerThread
    public final ListenableFuture zzf(final zzp zzpVar, final ImmutableSet immutableSet) {
        zzkz zzkzVar = zza;
        ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "connectMeeting", 207, "MeetIpcManagerImpl.java")).zzp("Calling connectMeeting - thread %s", Thread.currentThread().getName());
        Throwable illegalStateException = zzpVar.zza() == 0 ? new IllegalStateException("The connectMeeting call is not executed because cloudProjectNumber is missing.") : zzG(zzpVar.zzb(), "connectMeeting");
        if (illegalStateException != null) {
            ((zzkv) ((zzkv) zzkzVar.zze().zzg(illegalStateException)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "connectMeeting", 211, "MeetIpcManagerImpl.java")).zzn();
            return Futures.immediateFailedFuture(illegalStateException);
        }
        synchronized (this.zzl) {
            try {
                zzI("connectMeeting", ImmutableSet.m4350of(zzca.DISCONNECTED), this.zzm.zzc());
                final Optional optionalZza = this.zzt.zza(zzpVar.zzb());
                if (!optionalZza.isPresent()) {
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unable to create a stub for host application " + zzpVar.zzb().name());
                    ((zzkv) ((zzkv) zzkzVar.zzd().zzg(illegalStateException2)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "connectMeeting", JPEG.APP4, "MeetIpcManagerImpl.java")).zzn();
                    return Futures.immediateFailedFuture(illegalStateException2);
                }
                this.zzm = zzcb.zzd((zzc) optionalZza.get());
                final zzc zzcVar = (zzc) optionalZza.get();
                final zzbv zzbvVar = new zzbv(this, this.zze);
                zzapl.zza(zzcVar.zzc().zza(zzd.zze(), zzcVar.zzb()), zzbvVar).zzc(zzE(zzC(), this.zzv, zzpVar, immutableSet));
                ListenableFuture listenableFutureSubmit = this.zzr.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzci
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzn(zzbvVar, zzcVar);
                    }
                });
                zzJ(listenableFutureSubmit, this.zzr, "connectMeetingAsStream");
                return Futures.catchingAsync(listenableFutureSubmit, Exception.class, new AsyncFunction() { // from class: com.google.android.gms.internal.meet_coactivities.zzch
                    @Override // com.google.common.util.concurrent.AsyncFunction
                    public final ListenableFuture apply(Object obj) {
                        return this.zza.zzt(zzpVar, optionalZza, immutableSet, (Exception) obj);
                    }
                }, this.zzr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    @WorkerThread
    public final void zzg(final zzpx zzpxVar) {
        zzcb zzcbVar;
        zzkz zzkzVar = zza;
        ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "broadcastStateUpdate", 583, "MeetIpcManagerImpl.java")).zzq("Calling broadcastStateUpdate with lamport counter: %d - thread %s", zzpxVar.zzb(), Thread.currentThread().getName());
        synchronized (this.zzl) {
            try {
                zzH("broadcastStateUpdate", this.zzm.zzc());
                if (this.zzm.zzc().equals(zzca.CONNECTED)) {
                    zzl zzlVar = (zzl) Verify.verifyNotNull(this.zzm.zzb());
                    zzc zzcVar = (zzc) Verify.verifyNotNull(this.zzm.zza());
                    zzbs zzbsVar = new zzbs();
                    zzbsVar.zzc(zzca.BROADCASTING);
                    zzbsVar.zzb(zzlVar);
                    zzbsVar.zza(zzcVar);
                    this.zzm = zzbsVar.zzd();
                    ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "broadcastStateUpdate", 599, "MeetIpcManagerImpl.java")).zzp("Updated to %s state.", this.zzm.zzc().name());
                }
                zzcbVar = this.zzm;
            } finally {
            }
        }
        synchronized (zzb) {
            try {
                if (this.zzn == null) {
                    boolean z = true;
                    Verify.verify(true);
                    ((zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "initializeObservers", 716, "MeetIpcManagerImpl.java")).zzp("Initializing the Incoming and Outgoing observers - thread %s", Thread.currentThread().getName());
                    zzc zzcVar2 = (zzc) Verify.verifyNotNull(zzcbVar.zza());
                    synchronized (zzc) {
                        if (this.zzo != null) {
                            z = false;
                        }
                        Verify.verify(z);
                        zzbu zzbuVar = new zzbu(this);
                        this.zzo = zzbuVar;
                        this.zzn = (zzapf) zzapl.zza(zzcVar2.zzc().zza(zzd.zzd(), zzcVar2.zzb()), zzbuVar);
                    }
                }
                zzO(zzpxVar, zzqw.OUTGOING, zzcbVar.zza());
                zzJ(this.zzq.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcp
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzA(zzpxVar);
                    }
                }), this.zzq, "broadcastUpdate");
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    public final void zzh(RecordingInfo recordingInfo) {
        synchronized (this.zzf) {
            this.zzp = recordingInfo;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    public final void zzi() {
        synchronized (this.zzf) {
            this.zzh = CollaborationStartingState.builder().build();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    public final void zzj(CollaborationStartingState collaborationStartingState) {
        Preconditions.checkArgument(collaborationStartingState != null, "Unexpected null collaboration starting state.");
        String strAdditionalData = collaborationStartingState.additionalData();
        Preconditions.checkState(strAdditionalData == null || strAdditionalData.length() <= 4096, "Collaboration starting state additional data cannot exceed %s characters.", 4096);
        Uri uriMainStageUrl = collaborationStartingState.mainStageUrl();
        Preconditions.checkState(uriMainStageUrl == null || uriMainStageUrl.getPath() == null || ((String) Preconditions.checkNotNull(uriMainStageUrl.getPath())).length() <= 512, "Collaboration starting state main stage URL cannot exceed %s characters.", 512);
        Uri uriSidePanelUrl = collaborationStartingState.sidePanelUrl();
        Preconditions.checkState(uriSidePanelUrl == null || uriSidePanelUrl.getPath() == null || ((String) Preconditions.checkNotNull(uriSidePanelUrl.getPath())).length() <= 512, "Collaboration starting state side panel URL cannot exceed %s characters.", 512);
        synchronized (this.zzl) {
            try {
                Preconditions.checkState(this.zzm.zzc().equals(zzca.CONNECTED) || this.zzm.zzc().equals(zzca.BROADCASTING), "Tried to set collaboration starting state while not connected to a meeting.");
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzf) {
            this.zzh = collaborationStartingState;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    public final void zzk(zzrq zzrqVar) {
        Preconditions.checkArgument((zzrqVar == null || zzrqVar.zzm()) ? false : true, "Unexpected empty metadata");
        synchronized (this.zzl) {
            try {
                Preconditions.checkState(this.zzm.zzc().equals(zzca.CONNECTED) || this.zzm.zzc().equals(zzca.BROADCASTING), "Tried to set participant metadata while not connected to a meeting.");
            } catch (Throwable th) {
                throw th;
            }
        }
        Preconditions.checkState(((long) ((zzrq) Preconditions.checkNotNull(zzrqVar)).zzd()) <= 200, "Participant metadata size cannot exceed %s.", 200L);
        synchronized (this.zzf) {
            this.zzg = zzrqVar;
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    @WorkerThread
    public final ListenableFuture zzl(int i) {
        zzcb zzcbVar;
        ((zzkv) zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "disconnectMeeting", 311, "MeetIpcManagerImpl.java")).zzp("Calling disconnectMeeting with thread %s", Thread.currentThread().getName());
        synchronized (this.zzl) {
            zzH("disconnectMeeting", this.zzm.zzc());
            zzcbVar = this.zzm;
            zzM(Optional.of("disconnectMeeting"));
        }
        this.zzu = null;
        Object obj = this.zzw.get();
        this.zzw = Optional.empty();
        zzc zzcVar = (zzc) Verify.verifyNotNull(zzcbVar.zza());
        zzl zzlVar = (zzl) Verify.verifyNotNull(zzcbVar.zzb());
        final zzdc zzdcVar = new zzdc(this.zzd, "DisconnectMeetingResponseObserver");
        zzad zzadVarZza = zzae.zza();
        zzadVarZza.zzb(zzlVar);
        zzadVarZza.zza((zzao) obj);
        zzadVarZza.zzc(i);
        zzapl.zzb(zzcVar.zzc().zza(zzd.zzg(), zzcVar.zzb()), (zzae) zzadVarZza.zzk(), zzdcVar);
        ListenableFuture listenableFutureSubmit = this.zzr.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzda.zzp(zzdcVar);
            }
        });
        zzJ(listenableFutureSubmit, this.zzr, "disconnectMeeting");
        return Futures.transform(listenableFutureSubmit, new com.google.common.base.Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzcr
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return null;
            }
        }, this.zzq);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzcf
    @WorkerThread
    public final void zzm(Context context, int i, zzj zzjVar) {
        String str;
        zzkz zzkzVar = zza;
        zzkv zzkvVar = (zzkv) zzkzVar.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "broadcastFailureEvent", AiActionStatus.REQUEST_INTENT_ACCOUNT_SIGN_UP, "MeetIpcManagerImpl.java");
        switch (i) {
            case 2:
                str = "FAILURE_EVENT_UNSPECIFIED";
                break;
            case 3:
                str = "FAILURE_USER_INSUFFICIENT_TIER";
                break;
            case 4:
                str = "FAILURE_USER_UNKNOWN";
                break;
            case 5:
                str = "FAILURE_USER_CANCELLED";
                break;
            case 6:
                str = "FAILURE_USER_UNAUTHORIZED";
                break;
            case 7:
                str = "FAILURE_APP_GENERIC_ERROR";
                break;
            case 8:
                str = "FAILURE_APP_NETWORK_CONNECTIVITY";
                break;
            default:
                str = "FAILURE_APP_STARTUP";
                break;
        }
        zzkvVar.zzs("Calling broadcastEventNotification of type %s - thread %s", str, Thread.currentThread().getName());
        Throwable thZzG = zzG(zzjVar, "broadcastFailureEvent");
        if (thZzG != null) {
            ((zzkv) ((zzkv) zzkzVar.zze().zzg(thZzG)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "broadcastFailureEvent", AiActionStatus.REQUEST_INTENT_TOKEN_RETRY, "MeetIpcManagerImpl.java")).zzo("Failure while validating host application.");
            return;
        }
        synchronized (this.zzl) {
            try {
                Optional optionalZza = this.zzt.zza(zzjVar);
                if (!optionalZza.isPresent()) {
                    ((zzkv) zzkzVar.zzd().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "broadcastFailureEvent", 824, "MeetIpcManagerImpl.java")).zzp("broadcastEventNotification: Unable to create a stub for host application %s", zzjVar.name());
                    return;
                }
                final zzdc zzdcVar = new zzdc(this.zzd, "EventNotificationResponseObserver");
                zzc zzcVar = (zzc) optionalZza.get();
                zzah zzahVarZza = zzai.zza();
                zzahVarZza.zzc(i);
                zzahVarZza.zza(this.zzv);
                zzahVarZza.zzb(zzC());
                zzapl.zzb(zzcVar.zzc().zza(zzd.zzb(), zzcVar.zzb()), (zzai) zzahVarZza.zzk(), zzdcVar);
                zzJ(this.zzq.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzcj
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzda.zzq(zzdcVar);
                    }
                }), this.zzr, "broadcastEventNotification");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ ListenableFuture zzt(zzp zzpVar, Optional optional, ImmutableSet immutableSet, Exception exc) {
        ListenableFuture listenableFutureSubmit;
        if (exc instanceof AddonException) {
            AddonException addonException = (AddonException) exc;
            if (addonException.getCode().equals(AddonException.Code.MEET_VERSION_UNSUPPORTED)) {
                ((zzkv) ((zzkv) zza.zzc().zzg(addonException)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "logConnectMeetingAsStreamException", 1216, "MeetIpcManagerImpl.java")).zzp("connectMeetingAsStream failed due to old %s.", zzpVar.zzb().name());
            } else {
                ((zzkv) ((zzkv) zza.zzc().zzg(addonException)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "logConnectMeetingAsStreamException", 1220, "MeetIpcManagerImpl.java")).zzs("connectMeetingAsStream failed with code %s while connecting to %s", addonException.getCode(), zzpVar.zzb().name());
            }
        } else {
            ((zzkv) ((zzkv) zza.zze().zzg(exc)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "logConnectMeetingAsStreamException", 1209, "MeetIpcManagerImpl.java")).zzp("connectMeetingAsStream request failed with a generic exception while connecting to %s.", zzpVar.zzb().name());
        }
        synchronized (this.zzl) {
            ((zzkv) zza.zzc().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl", "lambda$connectMeeting$0", 245, "MeetIpcManagerImpl.java")).zzp("connectMeetingAsStream is not implemented and switch to unary connectMeeting. Current state is: %s.", this.zzm.zzc());
            this.zzm = zzcb.zzd((zzc) optional.get());
            final zzc zzcVar = (zzc) optional.get();
            final zzdc zzdcVar = new zzdc(this.zze, "ConnectMeetingResponseObserver");
            zzapl.zzb(zzcVar.zzc().zza(zzd.zzf(), zzcVar.zzb()), zzE(zzC(), this.zzv, zzpVar, immutableSet), zzdcVar);
            listenableFutureSubmit = this.zzr.submit(new Callable() { // from class: com.google.android.gms.internal.meet_coactivities.zzct
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzo(zzdcVar, zzcVar);
                }
            });
            zzJ(listenableFutureSubmit, this.zzr, "connectMeeting");
        }
        return listenableFutureSubmit;
    }

    public final /* synthetic */ void zzu(zzbn zzbnVar) {
        this.zzs.zze(zzbnVar.zzf());
    }

    public final /* synthetic */ void zzv(zzbn zzbnVar) {
        this.zzs.zzc(zzbnVar.zza());
    }

    public final /* synthetic */ void zzw(zzbn zzbnVar) {
        this.zzs.zza(zzbnVar.zzb());
    }

    public final /* synthetic */ void zzx(zzl zzlVar) {
        this.zzs.zzb(zzlVar);
    }

    public final /* synthetic */ void zzy(zzl zzlVar) {
        this.zzs.zzb(zzlVar);
    }

    public final /* synthetic */ void zzz(zzl zzlVar) {
        this.zzs.zzb(zzlVar);
    }
}
