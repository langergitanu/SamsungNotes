package com.google.android.meet.addons;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public interface AddonSession {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public interface Builder {
        @NonNull
        ListenableFuture<AddonSession> begin(@NonNull Context context);

        @NonNull
        Builder verifyRecordingInfo();

        @NonNull
        Builder withCoDoing(@NonNull CoDoingHandler coDoingHandler);

        @NonNull
        Builder withCoDoing(@NonNull CoDoingHandler coDoingHandler, @NonNull Optional<CoDoingState> optional);

        @NonNull
        Builder withCoWatching(@NonNull CoWatchingHandler coWatchingHandler);

        @NonNull
        Builder withCoWatching(@NonNull CoWatchingHandler coWatchingHandler, @NonNull Optional<CoWatchingState> optional);

        @NonNull
        Builder withCollaborationStartingState(@NonNull CollaborationStartingState collaborationStartingState);

        @NonNull
        Builder withParticipantMetadata(@NonNull ParticipantMetadataHandler participantMetadataHandler);

        @NonNull
        Builder withParticipantMetadata(@NonNull ParticipantMetadataHandler participantMetadataHandler, @NonNull byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum EndReason {
        UNKNOWN,
        RECORDING
    }

    @NonNull
    ListenableFuture<Void> endSession();

    @NonNull
    ListenableFuture<Void> endSession(@NonNull EndReason endReason);

    void endSuspension();

    @NonNull
    CoDoingClient getCoDoing();

    @NonNull
    CoWatchingClient getCoWatching();

    @NonNull
    AddonMeetingInfo getMeetingInfo();

    boolean isSessionEnded();

    boolean isSuspended();

    void resetCollaborationStartingState();

    void suspend();

    void updateCollaborationStartingState(@NonNull CollaborationStartingState collaborationStartingState);

    void updateParticipantMetadata(@NonNull byte[] bArr);
}
