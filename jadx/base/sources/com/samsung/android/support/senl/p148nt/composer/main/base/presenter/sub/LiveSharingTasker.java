package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LiveSharingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LiveSharingTasker implements LiveSharingContract, MeetingStatusListener {
    private static final String TAG = Logger.createTag("LiveSharingTasker");
    private AddonSessionHandler mAddonSessionHandler;
    private ComposerCloser mComposerCloser;
    private final boolean mIsLiveSharingEnabled;
    private final List<LiveSharingContract.Listener> mListenerList = new ArrayList(1);
    private Runnable mPendingShowConfirmDialog;
    private final BaseSubManager mSubManager;

    public LiveSharingTasker(BaseSubManager baseSubManager) {
        this.mSubManager = baseSubManager;
        this.mIsLiveSharingEnabled = baseSubManager.getConfig().isLiveSharingEnabled();
    }

    private Runnable createShowConfirmDialog(final BaseSubManager baseSubManager, final ComposerCloser composerCloser, final boolean z) {
        return new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.LiveSharingTasker.1
            @Override // java.lang.Runnable
            public void run() {
                LiveSharingTasker.this.mPendingShowConfirmDialog = null;
                if (baseSubManager.getComposerLifeState().getActivity() == null) {
                    return;
                }
                LiveSharingManager.getInstance().showConfirmDialog(baseSubManager.getComposerLifeState().getActivity(), z, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.LiveSharingTasker.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == -3 || i == 99) {
                            return;
                        }
                        LiveSharingManager.getInstance().runLiveSharingActivity(baseSubManager.getComposerLifeState().getActivity(), z, i == -1);
                        RunnableC99501 runnableC99501 = RunnableC99501.this;
                        composerCloser.closeComposer(baseSubManager.getComposerLifeState().getActivity(), null, null);
                    }
                });
            }
        };
    }

    private void registerAddonSessionHandler(Activity activity) {
        if (this.mAddonSessionHandler == null && this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote() && LiveSharingManager.getInstance().isCoEditingNote(activity.getIntent().getStringExtra("sdoc_uuid"))) {
            Logger.m11003i(TAG, "registerAddonSessionHandler#");
            this.mAddonSessionHandler = new AddonSessionHandler() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.LiveSharingTasker.2
                @Override // com.google.android.meet.addons.AddonSessionHandler
                public void onCollaborationStartingStateUpdate(@NonNull CollaborationStartingState collaborationStartingState) {
                    Logger.m11003i(LiveSharingTasker.TAG, "onCollaborationStartingStateUpdate# " + collaborationStartingState.mainStageUrl());
                }

                @Override // com.google.android.meet.addons.AddonSessionHandler
                public void onParticipantPrivilegeChanged(@NonNull List<AddonSessionHandler.Privilege> list, @NonNull List<AddonSessionHandler.Privilege> list2) {
                    Logger.m11003i(LiveSharingTasker.TAG, "onParticipantPrivilegeChanged#");
                }

                @Override // com.google.android.meet.addons.AddonSessionHandler
                public void onSessionEnded(@NonNull AddonSessionHandler.EndReason endReason) {
                    Logger.m11003i(LiveSharingTasker.TAG, "onSessionEnded#");
                    LiveSharingTasker.this.mAddonSessionHandler = null;
                    Iterator it = LiveSharingTasker.this.mListenerList.iterator();
                    while (it.hasNext()) {
                        ((LiveSharingContract.Listener) it.next()).onLiveSharingDisconnected();
                    }
                }
            };
            LiveSharingManager.getInstance().registerAddonSessionHandler(this.mAddonSessionHandler);
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, "7682");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LiveSharingContract
    public boolean isLiveSharingNote() {
        return this.mAddonSessionHandler != null;
    }

    public void onDestroy(Activity activity) {
        if (this.mIsLiveSharingEnabled) {
            this.mListenerList.clear();
            if (this.mAddonSessionHandler != null) {
                LiveSharingManager.getInstance().unregisterAddonSessionHandler(this.mAddonSessionHandler);
            }
            LiveSharingManager.getInstance().unregisterMeetingStatusListener(this);
            LiveSharingManager.getInstance().disconnectMeeting(activity.getIntent().getStringExtra("sdoc_uuid"), null);
        }
    }

    @Override // com.google.android.meet.addons.MeetingStatusListener
    public void onMeetingStatusChange(@NonNull MeetingStatus meetingStatus) {
        if (!MeetingStatus.Status.NO_MEETING.equals(meetingStatus.status()) && LiveSharingManager.getInstance().getMShowConfirmDialogFlag()) {
            Logger.m10999d(TAG, "onMeetingStatusChange# " + meetingStatus.status());
            Runnable runnableCreateShowConfirmDialog = createShowConfirmDialog(this.mSubManager, this.mComposerCloser, MeetingStatus.Status.MEETING.equals(meetingStatus.status()));
            if (!this.mSubManager.getComposerLifeState().isInitLayoutFinished()) {
                this.mPendingShowConfirmDialog = runnableCreateShowConfirmDialog;
            } else if (this.mSubManager.getControllerManager().getTaskController().isRunning()) {
                this.mSubManager.getControllerManager().getTaskController().addPendingJob(runnableCreateShowConfirmDialog, 2);
            } else {
                runnableCreateShowConfirmDialog.run();
            }
        }
    }

    public void onResume(ComposerCloser composerCloser) {
        if (this.mIsLiveSharingEnabled) {
            this.mComposerCloser = composerCloser;
            LiveSharingManager.getInstance().registerMeetingStatusListener(BaseUtils.getContext(), this);
        }
    }

    public void onStart(Activity activity) {
        if (this.mIsLiveSharingEnabled) {
            registerAddonSessionHandler(activity);
        }
    }

    public void runPending() {
        Runnable runnable = this.mPendingShowConfirmDialog;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LiveSharingContract
    public void setListener(LiveSharingContract.Listener listener) {
        Logger.m11003i(TAG, "setListener# " + listener);
        this.mListenerList.clear();
        if (listener != null) {
            this.mListenerList.add(listener);
        }
    }
}
