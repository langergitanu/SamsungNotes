package com.google.android.gms.internal.meet_coactivities;

import android.net.Uri;
import com.google.android.meet.addons.AddonSession;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzez implements zzce {
    final /* synthetic */ zzfa zza;

    public /* synthetic */ zzez(zzfa zzfaVar, zzey zzeyVar) {
        this.zza = zzfaVar;
    }

    private final void zzg(AddonSessionHandler.EndReason endReason) {
        ((zzil) this.zza.zzs.get()).zzd().onSessionEnded(endReason);
        this.zza.zzq.forEach(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzet
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Runnable) obj).run();
            }
        });
        this.zza.zzq.clear();
        if (this.zza.zzg.isPresent()) {
            this.zza.zzah();
        }
        if (this.zza.zzf.isPresent()) {
            this.zza.zzag();
        }
        this.zza.zzai();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzce
    public final void zza(final zzr zzrVar) {
        this.zza.zzp.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzev
            @Override // java.lang.Runnable
            public final void run() {
                AddonSessionHandler addonSessionHandlerZzd = ((zzil) this.zza.zza.zzs.get()).zzd();
                zzr zzrVar2 = zzrVar;
                if (zzrVar2 == null) {
                    throw new AssertionError("Empty collaboration starting state proto");
                }
                CollaborationStartingState.Builder builder = CollaborationStartingState.builder();
                builder.setAdditionalData(zzrVar2.zzd());
                builder.setMainStageUrl(Uri.parse(zzrVar2.zze()));
                builder.setSidePanelUrl(Uri.parse(zzrVar2.zzf()));
                addonSessionHandlerZzd.onCollaborationStartingStateUpdate(builder.build());
            }
        });
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzce
    public final void zzb(final zzl zzlVar) {
        this.zza.zzp.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzes
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(zzlVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzce
    public final void zzc(final zzn zznVar) {
        if (zznVar.zzd().isEmpty()) {
            ((zzkv) zzfa.zzd.zzc().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "handleParticipantMetadataSetUpdate", SpenHoverPointerIcon.HOVER_POINTER_ICON_TYPE_CONTROL_ROTATE, "AddonClientImpl.java")).zzo("Participant metadata set is empty. Not updating delegate.");
        } else {
            this.zza.zzp.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzer
                /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.meet.addons.ParticipantMetadataHandler, java.lang.Object] */
                @Override // java.lang.Runnable
                public final void run() {
                    zzez zzezVar = this.zza;
                    if (!zzezVar.zza.zzt.isPresent()) {
                        ((zzkv) zzfa.zzd.zzc().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "lambda$handleParticipantMetadataSetUpdate$1", TemplateConstants.REQUEST_ACTION_CHOOSE_PDF, "AddonClientImpl.java")).zzo("Delegate is missing on non-empty participant metadata set update.");
                        return;
                    }
                    zzn zznVar2 = zznVar;
                    ?? r02 = zzezVar.zza.zzt.get();
                    ImmutableSet immutableSetCopyOf = ImmutableSet.copyOf((Iterable) zznVar2.zzd().stream().map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzdh
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            int i = zzfa.zzc;
                            byte[] bArrZzn = ((zzrq) obj).zzn();
                            int length = bArrZzn.length;
                            Byte[] bArr = new Byte[length];
                            int i2 = 0;
                            int i4 = 0;
                            while (i2 < length) {
                                bArr[i4] = Byte.valueOf(bArrZzn[i2]);
                                i2++;
                                i4++;
                            }
                            return bArr;
                        }
                    }).collect(Collectors.toCollection(new zzem())));
                    if (zznVar2.zzd().equals(ImmutableList.m4303of(zzfa.zzb))) {
                        immutableSetCopyOf = ImmutableSet.m4349of();
                    }
                    r02.onParticipantMetadataUpdated(immutableSetCopyOf);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzce
    public final void zzd(List list, List list2) {
        zzfa zzfaVar = this.zza;
        Stream stream = list.stream();
        final zzkl zzklVar = zzfaVar.zzl;
        Objects.requireNonNull(zzklVar);
        List<AddonSessionHandler.Privilege> list3 = (List) stream.map(new Function(zzklVar) { // from class: com.google.android.gms.internal.meet_coactivities.zzew
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return zzkl.zzc((zzam) obj);
            }
        }).collect(Collectors.toCollection(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzex
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ArrayList();
            }
        }));
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            zzam zzamVarZzb = zzacVar.zzb();
            arrayList.add(zzkl.zzc(zzamVarZzb));
            ((zzkv) zzfa.zzd.zzc().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "handlePrivilegeUpdate", 1227, "AddonClientImpl.java")).zzs("Privilege %s is now revoked due to these reasons: %s.", zzamVarZzb, zzacVar.zzc());
        }
        ((zzil) this.zza.zzs.get()).zzd().onParticipantPrivilegeChanged(list3, arrayList);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzce
    public final void zze(final zzpx zzpxVar) {
        this.zza.zzp.execute(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzeu
            /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.meet_coactivities.zzhe, java.lang.Object] */
            @Override // java.lang.Runnable
            public final void run() {
                zzez zzezVar = this.zza;
                zzpx zzpxVar2 = zzpxVar;
                if (zzpxVar2.zzs()) {
                    if (zzezVar.zza.zzf.isPresent()) {
                        ((zzhu) zzezVar.zza.zzf.get()).zzd(zzpxVar2);
                        return;
                    } else {
                        ((zzkv) zzfa.zzd.zze().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "lambda$handleStateUpdates$0", 1083, "AddonClientImpl.java")).zzo("Received a co-doing update, but beginCoDoing() was never called.");
                        return;
                    }
                }
                if (zzpxVar2.zzt()) {
                    if (zzezVar.zza.zzg.isPresent()) {
                        zzezVar.zza.zzg.get().zzd(zzpxVar2);
                    } else {
                        ((zzkv) zzfa.zzd.zze().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "lambda$handleStateUpdates$0", 1091, "AddonClientImpl.java")).zzo("Received a co-watching update, but beginCoWatching() was never called.");
                    }
                }
            }
        });
    }

    public final /* synthetic */ void zzf(zzl zzlVar) {
        ((zzkv) zzfa.zzd.zzb().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "lambda$handleMeetingStateUpdate$3", 1156, "AddonClientImpl.java")).zzp("Received updated Meeting State : %s", zzlVar.zzd());
        if (!this.zza.zzak()) {
            ((zzkv) zzfa.zzd.zze().zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "lambda$handleMeetingStateUpdate$3", 1162, "AddonClientImpl.java")).zzo("Received a meeting state update while disconnected");
            return;
        }
        try {
            this.zza.zzA = zzjw.zzb(zzlVar);
        } catch (AssertionError e) {
            ((zzkv) ((zzkv) zzfa.zzd.zzd().zzg(e)).zzh("com/google/android/meet/addons/internal/AddonClientImpl$LiveSharingIpcHandler", "lambda$handleMeetingStateUpdate$3", 1170, "AddonClientImpl.java")).zzo("Invalid meeting info proto.");
        }
        zzal zzalVarZzd = zzlVar.zzd();
        AddonSession.EndReason endReason = AddonSession.EndReason.UNKNOWN;
        int iOrdinal = zzalVarZzd.ordinal();
        if (iOrdinal == 4) {
            zzg(AddonSessionHandler.EndReason.SESSION_ENDED_BY_USER);
            return;
        }
        if (iOrdinal == 7) {
            zzg(AddonSessionHandler.EndReason.MEETING_ENDED_BY_USER);
        } else if (iOrdinal == 8) {
            zzg(AddonSessionHandler.EndReason.SESSION_ENDED_UNEXPECTEDLY);
        } else {
            if (iOrdinal != 9) {
                return;
            }
            zzg(AddonSessionHandler.EndReason.SESSION_ENDED_DUE_TO_RECORDING_STATE_SYNC_ISSUE);
        }
    }
}
