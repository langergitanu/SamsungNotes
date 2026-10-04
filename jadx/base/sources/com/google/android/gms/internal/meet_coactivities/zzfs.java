package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSession;
import com.google.android.meet.addons.CoDoingClient;
import com.google.android.meet.addons.CoWatchingClient;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfs implements AddonSession {
    private final zzie zza;
    private final AddonMeetingInfo zzb;
    private final Optional zzc;
    private final Optional zzd;
    private final zzip zze;
    private final AtomicBoolean zzf = new AtomicBoolean(true);

    public zzfs(zzie zzieVar, AddonMeetingInfo addonMeetingInfo, Optional optional, Optional optional2, zzip zzipVar) {
        this.zza = (zzie) Preconditions.checkNotNull(zzieVar);
        this.zzb = (AddonMeetingInfo) Preconditions.checkNotNull(addonMeetingInfo);
        this.zzc = (Optional) Preconditions.checkNotNull(optional);
        this.zzd = (Optional) Preconditions.checkNotNull(optional2);
        this.zze = (zzip) Preconditions.checkNotNull(zzipVar);
    }

    private final void zzd() {
        Preconditions.checkState(this.zzf.get(), "Cannot call this method after the AddonSession has ended.");
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final ListenableFuture<Void> endSession() {
        zzc();
        return this.zza.zzd();
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final void endSuspension() {
        zzd();
        this.zze.zza();
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final CoDoingClient getCoDoing() {
        zzd();
        return (CoDoingClient) this.zzd.orElseThrow(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzfp
            @Override // java.util.function.Supplier
            public final Object get() {
                return new IllegalStateException("Must call withCoDoing() while building the session for co-doing to be present.");
            }
        });
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final CoWatchingClient getCoWatching() {
        zzd();
        return (CoWatchingClient) this.zzc.orElseThrow(new Supplier() { // from class: com.google.android.gms.internal.meet_coactivities.zzfq
            @Override // java.util.function.Supplier
            public final Object get() {
                return new IllegalStateException("Must call withCoWatching() while building the session for co-watching to be present.");
            }
        });
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final AddonMeetingInfo getMeetingInfo() {
        zzd();
        return this.zzb;
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final boolean isSessionEnded() {
        return !this.zzf.get();
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final boolean isSuspended() {
        zzd();
        return this.zze.zzd();
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final void resetCollaborationStartingState() {
        zzd();
        final zzie zzieVar = this.zza;
        Objects.requireNonNull(zzieVar);
        zzia.zzd(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzfr
            @Override // java.lang.Runnable
            public final void run() {
                zzieVar.zzR();
            }
        }, "Unexpected error occurred while resetting collaboration starting state.");
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final void suspend() {
        zzd();
        this.zze.zzc();
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final void updateCollaborationStartingState(final CollaborationStartingState collaborationStartingState) {
        zzd();
        Preconditions.checkNotNull(collaborationStartingState, "Parameter 'startingState' cannot be null.");
        zzia.zzd(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzfn
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(collaborationStartingState);
            }
        }, "Unexpected error occurred while setting collaboration starting state.");
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final void updateParticipantMetadata(final byte[] bArr) {
        zzd();
        Preconditions.checkNotNull(bArr, "Parameter 'metadata' cannot be null.");
        Preconditions.checkArgument(bArr.length <= 200, "Participant metadata size cannot exceed %s bytes.", 200);
        zzia.zzd(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzfo
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(bArr);
            }
        }, "Unexpected error occurred while setting metadata.");
    }

    public final /* synthetic */ void zza(CollaborationStartingState collaborationStartingState) {
        this.zza.zzS(collaborationStartingState);
    }

    public final /* synthetic */ void zzb(byte[] bArr) {
        zzrq zzrqVar = zzrq.zzb;
        this.zza.zzT(zzrq.zzk(bArr, 0, bArr.length));
    }

    public final void zzc() {
        this.zzf.set(false);
    }

    @Override // com.google.android.meet.addons.AddonSession
    public final ListenableFuture<Void> endSession(AddonSession.EndReason endReason) {
        zzc();
        return this.zza.zzn(endReason);
    }
}
