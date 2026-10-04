package com.samsung.android.support.senl.p148nt.app.main.livesharing;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LiveSharingHelper implements MeetingStatusListener {
    private static final String TAG = "LiveSharingHelper";
    private final Activity mActivity;
    private MeetingStatus.Status mMeetingStatus;
    private final ITipCard mTipCardListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ITipCard {
        void setMeetTipCard(int i);
    }

    public LiveSharingHelper(Activity activity, ITipCard iTipCard) {
        this.mActivity = activity;
        this.mTipCardListener = iTipCard;
    }

    private void callOnMeetNotWorking(LiveSharingManager.Caller caller, @Nullable LiveSharingManager.TipCardCallback tipCardCallback) {
        MainLogger.m7254d(TAG, "onMeetNotWorking#");
        if (tipCardCallback != null) {
            tipCardCallback.dismiss();
        }
        if (callerIsTipCard(caller)) {
            LiveSharingManager.getInstance().setCanceled("onMeetNotWorking, Tipcard dismiss");
            ToastHandler.show(this.mActivity, C8003R.string.meet_is_cancelled, 0);
        }
    }

    private void callOnMeetWorking(LiveSharingManager.Caller caller, @Nullable final LiveSharingManager.TipCardCallback tipCardCallback, final boolean z) {
        MainLogger.m7254d(TAG, "onMeetWorking# caller : " + caller + ", isHost : " + z);
        if (!callerIsTipCard(caller)) {
            if (LiveSharingManager.getInstance().getMShowConfirmDialogFlag() && !LiveSharingManager.getInstance().getNotNow()) {
                LiveSharingManager.getInstance().showConfirmDialog(this.mActivity, z, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingHelper.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i != -3 && i != 99) {
                            LiveSharingManager.getInstance().runLiveSharingActivity(LiveSharingHelper.this.mActivity, z, i == -1);
                        }
                        LiveSharingManager.TipCardCallback tipCardCallback2 = tipCardCallback;
                        if (tipCardCallback2 != null) {
                            tipCardCallback2.show(z ? LiveSharingManager.TIPCARD_HOST : LiveSharingManager.TIPCARD_GUEST);
                        }
                    }
                });
                return;
            } else {
                if (tipCardCallback != null) {
                    tipCardCallback.show(z ? LiveSharingManager.TIPCARD_HOST : LiveSharingManager.TIPCARD_GUEST);
                    return;
                }
                return;
            }
        }
        if (z && caller == LiveSharingManager.Caller.TIP_CARD_JOIN) {
            if (tipCardCallback != null) {
                LiveSharingManager.getInstance().setCanceled("onMeetWorking, Tipcard show again");
                tipCardCallback.show(LiveSharingManager.TIPCARD_HOST);
                return;
            }
            return;
        }
        if (!z && caller == LiveSharingManager.Caller.TIP_CARD_NEW) {
            if (tipCardCallback != null) {
                LiveSharingManager.getInstance().setCanceled("onMeetWorking, Tipcard show again");
                tipCardCallback.show(LiveSharingManager.TIPCARD_GUEST);
                return;
            }
            return;
        }
        LiveSharingManager.getInstance().runLiveSharingActivity(this.mActivity, z, z && caller == LiveSharingManager.Caller.TIP_CARD_EXIST);
        if (tipCardCallback != null) {
            LiveSharingManager.getInstance().setCanceled("onMeetWorking, runLiveSharingActivity, Tipcard dismiss");
            tipCardCallback.dismiss();
        }
    }

    private boolean callerIsTipCard(LiveSharingManager.Caller caller) {
        return caller == LiveSharingManager.Caller.TIP_CARD_NEW || caller == LiveSharingManager.Caller.TIP_CARD_EXIST || caller == LiveSharingManager.Caller.TIP_CARD_JOIN;
    }

    public void joinMeetingWithTipCard(LiveSharingManager.Caller caller, boolean z, LiveSharingManager.TipCardCallback tipCardCallback) {
        MainLogger.m7254d(TAG, "joinMeetingWithTipCard# meetingStatus : " + this.mMeetingStatus);
        if (MeetingStatus.Status.NO_MEETING.equals(this.mMeetingStatus)) {
            callOnMeetNotWorking(caller, new LiveSharingManager.TipCardCallback() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingHelper.4
                @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
                public void dismiss() {
                    MainLogger.m7254d(LiveSharingHelper.TAG, "joinMeetingWithTipCard#callOnMeetNotWorking dismiss");
                    if (LiveSharingHelper.this.mTipCardListener != null) {
                        LiveSharingHelper.this.mTipCardListener.setMeetTipCard(LiveSharingManager.NONE);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
                public void show(int i) {
                    MainLogger.m7254d(LiveSharingHelper.TAG, "joinMeetingWithTipCard#callOnMeetNotWorking show");
                }
            });
        } else {
            callOnMeetWorking(caller, tipCardCallback, z);
        }
    }

    @Override // com.google.android.meet.addons.MeetingStatusListener
    public void onMeetingStatusChange(@NonNull MeetingStatus meetingStatus) {
        this.mMeetingStatus = meetingStatus.status();
        MainLogger.m7254d(TAG, "onMeetingStatusChange# " + this.mMeetingStatus);
        if (MeetingStatus.Status.NO_MEETING.equals(this.mMeetingStatus)) {
            callOnMeetNotWorking(LiveSharingManager.Caller.NONE, new LiveSharingManager.TipCardCallback() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingHelper.1
                @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
                public void dismiss() {
                    MainLogger.m7254d(LiveSharingHelper.TAG, "onMeetingStatusChange#callOnMeetNotWorking dismiss");
                    if (LiveSharingHelper.this.mTipCardListener != null) {
                        LiveSharingHelper.this.mTipCardListener.setMeetTipCard(LiveSharingManager.NONE);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
                public void show(int i) {
                    MainLogger.m7254d(LiveSharingHelper.TAG, "onMeetingStatusChange#callOnMeetNotWorking show");
                }
            });
        } else {
            callOnMeetWorking(LiveSharingManager.Caller.NONE, new LiveSharingManager.TipCardCallback() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingHelper.2
                @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
                public void dismiss() {
                    MainLogger.m7254d(LiveSharingHelper.TAG, "onMeetingStatusChange#callOnMeetWorking dismiss");
                    if (LiveSharingHelper.this.mTipCardListener != null) {
                        LiveSharingHelper.this.mTipCardListener.setMeetTipCard(LiveSharingManager.NONE);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
                public void show(int i) {
                    AbstractC6670b.m4736A(i, "onMeetingStatusChange#callOnMeetWorking show : ", LiveSharingHelper.TAG);
                    if (LiveSharingHelper.this.mTipCardListener != null) {
                        LiveSharingHelper.this.mTipCardListener.setMeetTipCard(i);
                    }
                }
            }, MeetingStatus.Status.MEETING.equals(this.mMeetingStatus));
        }
    }

    public void registerLiveSharing() {
        LiveSharingManager.getInstance().registerMeetingStatusListener(this.mActivity, this);
    }

    public void unregisterLiveSharing() {
        LiveSharingManager.getInstance().unregisterMeetingStatusListener(this);
        LiveSharingManager.getInstance().disconnectMeeting(null);
    }
}
