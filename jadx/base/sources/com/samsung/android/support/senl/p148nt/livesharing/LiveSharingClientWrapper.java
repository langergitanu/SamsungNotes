package com.samsung.android.support.senl.p148nt.livesharing;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class LiveSharingClientWrapper {
    private static final String TAG = "LS$LiveSharingClientWrapper";
    private final LiveSharingClientDelegate mLiveSharingClientDelegate;

    public LiveSharingClientWrapper() {
        if (isSupported()) {
            this.mLiveSharingClientDelegate = new LiveSharingGoogleClientDelegate();
        } else {
            this.mLiveSharingClientDelegate = new LiveSharingEmptyClientDelegate();
        }
    }

    public static boolean isSupported() {
        return true;
    }

    public ILiveSharingClient.ErrorState connectMeeting(Context context, ILiveSharingClient.Callback<AddonMeetingInfo> callback, AddonSessionHandler addonSessionHandler, ILiveSharingClient.StateChangeListener stateChangeListener) {
        Log.i(TAG, "connectMeeting#");
        if (this.mLiveSharingClientDelegate.isConnected()) {
            Log.i(TAG, "connectMeeting# already connected");
            return ILiveSharingClient.ErrorState.ALREADY_CONNECTED;
        }
        this.mLiveSharingClientDelegate.connectMeeting(context, callback, addonSessionHandler, stateChangeListener);
        return ILiveSharingClient.ErrorState.NONE;
    }

    public ILiveSharingClient.ErrorState disconnectMeeting(ILiveSharingClient.Callback<Void> callback) {
        Log.i(TAG, "disconnectMeeting#");
        if (this.mLiveSharingClientDelegate.isConnected()) {
            this.mLiveSharingClientDelegate.disconnectMeeting(callback);
            return ILiveSharingClient.ErrorState.NONE;
        }
        Log.i(TAG, "disconnectMeeting# meeting is not connected");
        return ILiveSharingClient.ErrorState.NOT_CONNECTED;
    }

    @Nullable
    public AddonMeetingInfo getMeetingInfo() {
        return this.mLiveSharingClientDelegate.getMeetingInfo();
    }

    public void registerMeetingStatusListener(Context context, MeetingStatusListener meetingStatusListener) {
        this.mLiveSharingClientDelegate.registerMeetingStatusListener(context, meetingStatusListener);
    }

    public ILiveSharingClient.ErrorState sendSharingData(LiveSharingData liveSharingData) {
        Log.i(TAG, "sendSharingData# " + liveSharingData);
        if (!this.mLiveSharingClientDelegate.isConnected()) {
            Log.i(TAG, "sendSharingData# meeting is not connected");
            return ILiveSharingClient.ErrorState.NOT_CONNECTED;
        }
        StringBuilder sb = new StringBuilder("sendSharingData# current state: ");
        sb.append(this.mLiveSharingClientDelegate.getMeetingInfo() == null ? null : this.mLiveSharingClientDelegate.getMeetingInfo().meetingStatus());
        Log.i(TAG, sb.toString());
        if (liveSharingData.isValidSize()) {
            this.mLiveSharingClientDelegate.sendSharingData(liveSharingData);
            return ILiveSharingClient.ErrorState.NONE;
        }
        AbstractC0000a.m26w(new StringBuilder("sendSharingData## data is exceeded 1MB: "), TAG, liveSharingData.convertBytes().length);
        return ILiveSharingClient.ErrorState.OVER_SIZE_DATA;
    }

    public void unregisterMeetingStatusListener(Context context) {
        this.mLiveSharingClientDelegate.unregisterMeetingStatusListener(context);
    }
}
