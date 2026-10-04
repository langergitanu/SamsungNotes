package com.samsung.android.support.senl.p148nt.livesharing;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.meet.addons.AddonClient;
import com.google.android.meet.addons.AddonClientFactory;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSession;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CoDoingHandler;
import com.google.android.meet.addons.CoDoingState;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 24)
class LiveSharingGoogleClientDelegate implements LiveSharingClientDelegate {
    private static final String APPLICATION_NAME = "samsung-notes";
    private static final String TAG = "LS$LiveSharingGoogleClientDelegate";
    private final AddonsSessionHandlerImpl mAddonSessionHandler;
    private Context mApplicationContext;
    private AddonSessionHandler mCallerSessionHandler;
    private final CoDoingHandlerImpl mCoDoingHandler;
    private Executor mExecutorService;
    private MeetingStatusListener mMeetingStatusListener;
    private MeetingStatusListener mMeetingStatusListenerCaller;
    private AddonSession mSession;
    private ILiveSharingClient.StateChangeListener mStateChangeListener;
    private final long CLOUD_PROJECT_NUMBER = 563957018064L;
    private final AddonClient mAddonsClient = AddonClientFactory.getClient(563957018064L);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AddonsSessionHandlerImpl implements AddonSessionHandler {
        private AddonsSessionHandlerImpl() {
        }

        @Override // com.google.android.meet.addons.AddonSessionHandler
        public void onCollaborationStartingStateUpdate(@NonNull CollaborationStartingState collaborationStartingState) {
            Log.i(LiveSharingGoogleClientDelegate.TAG, "onCollaborationStartingStateUpdate# " + collaborationStartingState);
        }

        @Override // com.google.android.meet.addons.AddonSessionHandler
        public void onParticipantPrivilegeChanged(@NonNull List<AddonSessionHandler.Privilege> list, @NonNull List<AddonSessionHandler.Privilege> list2) {
            Log.i(LiveSharingGoogleClientDelegate.TAG, "onParticipantPrivilegeChanged# " + list + " " + list2);
        }

        @Override // com.google.android.meet.addons.AddonSessionHandler
        public void onSessionEnded(@NonNull AddonSessionHandler.EndReason endReason) {
            if (LiveSharingGoogleClientDelegate.this.mSession == null) {
                Log.i(LiveSharingGoogleClientDelegate.TAG, "onSessionEnded# no connected session");
                return;
            }
            Log.i(LiveSharingGoogleClientDelegate.TAG, "onSessionEnded# " + endReason);
            if (LiveSharingGoogleClientDelegate.this.mCallerSessionHandler != null) {
                LiveSharingGoogleClientDelegate.this.mCallerSessionHandler.onSessionEnded(endReason);
            }
            LiveSharingGoogleClientDelegate.this.mSession = null;
            LiveSharingGoogleClientDelegate.this.mCallerSessionHandler = null;
            LiveSharingGoogleClientDelegate.this.mStateChangeListener = null;
            LiveSharingGoogleClientDelegate liveSharingGoogleClientDelegate = LiveSharingGoogleClientDelegate.this;
            liveSharingGoogleClientDelegate.unregisterMeetingStatusListener(liveSharingGoogleClientDelegate.mApplicationContext);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoDoingHandlerImpl implements CoDoingHandler {
        private CoDoingHandlerImpl() {
        }

        @Override // com.google.android.meet.addons.CoDoingHandler
        public void onGlobalStateChanged(@NonNull CoDoingState coDoingState) {
            Log.i(LiveSharingGoogleClientDelegate.TAG, "onGlobalStateChanged# " + coDoingState);
            if (LiveSharingGoogleClientDelegate.this.mStateChangeListener != null) {
                Log.i(LiveSharingGoogleClientDelegate.TAG, "onGlobalStateChanged# call");
                LiveSharingGoogleClientDelegate.this.mStateChangeListener.onStateChanged(new LiveSharingData(coDoingState));
            }
        }
    }

    public LiveSharingGoogleClientDelegate() {
        this.mAddonSessionHandler = new AddonsSessionHandlerImpl();
        this.mCoDoingHandler = new CoDoingHandlerImpl();
    }

    private Executor getExecutor() {
        if (this.mExecutorService == null) {
            this.mExecutorService = MoreExecutors.directExecutor();
        }
        return this.mExecutorService;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void connectMeeting(Context context, final ILiveSharingClient.Callback<AddonMeetingInfo> callback, final AddonSessionHandler addonSessionHandler, ILiveSharingClient.StateChangeListener stateChangeListener) {
        Log.i(TAG, "connectMeeting# ");
        final ListenableFuture<AddonSession> listenableFutureBegin = this.mAddonsClient.newSessionBuilder(this.mAddonSessionHandler).withCoDoing(this.mCoDoingHandler).begin(context.getApplicationContext());
        listenableFutureBegin.addListener(new Runnable() { // from class: com.samsung.android.support.senl.nt.livesharing.LiveSharingGoogleClientDelegate.2
            @Override // java.lang.Runnable
            public void run() {
                Log.i(LiveSharingGoogleClientDelegate.TAG, "connectMeeting# open session");
                try {
                    LiveSharingGoogleClientDelegate.this.mSession = (AddonSession) listenableFutureBegin.get();
                    callback.onSuccess(LiveSharingGoogleClientDelegate.this.mSession.getMeetingInfo());
                    LiveSharingGoogleClientDelegate.this.mCallerSessionHandler = addonSessionHandler;
                } catch (InterruptedException | ExecutionException e) {
                    Log.e(LiveSharingGoogleClientDelegate.TAG, "connectMeeting## " + e.getMessage());
                    callback.onFailure(e);
                    LiveSharingGoogleClientDelegate.this.mCallerSessionHandler = null;
                }
            }
        }, getExecutor());
        this.mStateChangeListener = stateChangeListener;
        this.mApplicationContext = context.getApplicationContext();
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void disconnectMeeting(final ILiveSharingClient.Callback<Void> callback) {
        Log.i(TAG, "disconnectMeeting# ");
        this.mSession.endSession().addListener(new Runnable() { // from class: com.samsung.android.support.senl.nt.livesharing.LiveSharingGoogleClientDelegate.3
            @Override // java.lang.Runnable
            public void run() {
                LiveSharingGoogleClientDelegate.this.mSession = null;
                LiveSharingGoogleClientDelegate.this.mCallerSessionHandler = null;
                callback.onSuccess(null);
            }
        }, getExecutor());
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    @Nullable
    public AddonMeetingInfo getMeetingInfo() {
        AddonSession addonSession = this.mSession;
        if (addonSession != null) {
            return addonSession.getMeetingInfo();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public boolean isCoDoing() {
        AddonSession addonSession = this.mSession;
        return addonSession != null && addonSession.getMeetingInfo().meetingStatus() == AddonMeetingInfo.MeetingStatus.CONNECTED_WITH_ADDON_SESSION;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public boolean isConnected() {
        return this.mSession != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void registerMeetingStatusListener(Context context, MeetingStatusListener meetingStatusListener) {
        if (this.mMeetingStatusListener == null) {
            this.mMeetingStatusListener = new MeetingStatusListener() { // from class: com.samsung.android.support.senl.nt.livesharing.LiveSharingGoogleClientDelegate.1
                @Override // com.google.android.meet.addons.MeetingStatusListener
                public void onMeetingStatusChange(@NonNull MeetingStatus meetingStatus) {
                    Log.i(LiveSharingGoogleClientDelegate.TAG, "onMeetingStatusChange# " + meetingStatus);
                    if (LiveSharingGoogleClientDelegate.this.mMeetingStatusListenerCaller != null) {
                        LiveSharingGoogleClientDelegate.this.mMeetingStatusListenerCaller.onMeetingStatusChange(meetingStatus);
                    }
                }
            };
        }
        this.mMeetingStatusListenerCaller = meetingStatusListener;
        this.mAddonsClient.registerMeetingStatusListener(context.getApplicationContext(), this.mMeetingStatusListener, Optional.empty());
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void sendSharingData(LiveSharingData liveSharingData) {
        Log.i(TAG, "sendSharingData#");
        AddonSession addonSession = this.mSession;
        if (addonSession == null || addonSession.isSessionEnded()) {
            Log.i(TAG, "sendSharingData# " + this.mSession);
        } else {
            if (AddonMeetingInfo.MeetingStatus.NOT_CONNECTED.equals(this.mSession.getMeetingInfo().meetingStatus())) {
                Log.i(TAG, "sendSharingData# meeting is not connected");
                return;
            }
            Log.i(TAG, "sendSharingData# " + liveSharingData);
            this.mSession.getCoDoing().setGlobalState(liveSharingData.getCoDoingState());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientDelegate
    public void unregisterMeetingStatusListener(Context context) {
        if (context == null) {
            Log.d(TAG, "unregisterMeetingStatusListener# context is null");
        } else {
            this.mAddonsClient.unregisterMeetingStatusListener(context.getApplicationContext());
        }
    }
}
