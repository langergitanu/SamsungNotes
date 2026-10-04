package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public interface AddonSessionHandler {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum EndReason {
        SESSION_ENDED_BY_USER,
        MEETING_ENDED_BY_USER,
        SESSION_ENDED_UNEXPECTEDLY,
        SESSION_ENDED_DUE_TO_RECORDING_STATE_SYNC_ISSUE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum Privilege {
        UNKNOWN,
        MAY_CHANGE_ADDON_SESSION_STATE
    }

    void onCollaborationStartingStateUpdate(@NonNull CollaborationStartingState collaborationStartingState);

    void onParticipantPrivilegeChanged(@NonNull List<Privilege> list, @NonNull List<Privilege> list2);

    void onSessionEnded(@NonNull EndReason endReason);
}
