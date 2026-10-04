package com.google.android.meet.addons;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.meet.addons.AddonSession;
import com.google.android.meet.addons.annotations.PublicApi;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public interface AddonClient {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum AddonFailureEventType {
        FAILURE_EVENT_UNSPECIFIED,
        FAILURE_USER_INSUFFICIENT_TIER,
        FAILURE_USER_UNKNOWN,
        FAILURE_USER_CANCELLED,
        FAILURE_USER_UNAUTHORIZED,
        FAILURE_APP_GENERIC_ERROR,
        FAILURE_APP_NETWORK_CONNECTIVITY,
        FAILURE_APP_STARTUP
    }

    @NonNull
    AddonSession.Builder newSessionBuilder(@NonNull AddonSessionHandler addonSessionHandler);

    void notifyAddonFailureEvent(@NonNull Context context, @NonNull AddonFailureEventType addonFailureEventType);

    void registerMeetingStatusListener(@NonNull Context context, @NonNull MeetingStatusListener meetingStatusListener, @NonNull Optional<Handler> optional);

    void unregisterMeetingStatusListener(@NonNull Context context);
}
