package com.samsung.android.support.senl.p148nt.livesharing;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
interface LiveSharingClientDelegate {
    void connectMeeting(Context context, ILiveSharingClient.Callback<AddonMeetingInfo> callback, AddonSessionHandler addonSessionHandler, ILiveSharingClient.StateChangeListener stateChangeListener);

    void disconnectMeeting(ILiveSharingClient.Callback<Void> callback);

    @Nullable
    AddonMeetingInfo getMeetingInfo();

    boolean isCoDoing();

    boolean isConnected();

    void registerMeetingStatusListener(Context context, MeetingStatusListener meetingStatusListener);

    void sendSharingData(LiveSharingData liveSharingData);

    void unregisterMeetingStatusListener(Context context);
}
