package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import com.google.android.meet.addons.AddonClient;
import com.google.android.meet.addons.AddonSession;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.ParticipantMetadataHandler;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface zzie extends AddonClient, com.google.android.meet.addons.zzaj {
    void zzQ(Runnable runnable);

    void zzR();

    void zzS(CollaborationStartingState collaborationStartingState);

    void zzT(zzrq zzrqVar);

    void zzU(zzrq zzrqVar, ParticipantMetadataHandler participantMetadataHandler);

    boolean zzW();

    ListenableFuture zzm(Context context, AddonSessionHandler addonSessionHandler);

    ListenableFuture zzn(AddonSession.EndReason endReason);
}
