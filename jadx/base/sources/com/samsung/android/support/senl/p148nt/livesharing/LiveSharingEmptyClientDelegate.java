package com.samsung.android.support.senl.p148nt.livesharing;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
class LiveSharingEmptyClientDelegate implements LiveSharingClientDelegate {
    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    @Nullable
    public AddonMeetingInfo getMeetingInfo() {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public boolean isCoDoing() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public boolean isConnected() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void disconnectMeeting(ILiveSharingClient.Callback<Void> callback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void sendSharingData(LiveSharingData liveSharingData) {
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void unregisterMeetingStatusListener(Context context) {
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void registerMeetingStatusListener(Context context, MeetingStatusListener meetingStatusListener) {
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void connectMeeting(Context context, ILiveSharingClient.Callback<AddonMeetingInfo> callback, AddonSessionHandler addonSessionHandler, ILiveSharingClient.StateChangeListener stateChangeListener) {
    }
}
