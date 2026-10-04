package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.handoff;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.base.winset.snackbar.SnackbarHelper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$J\b\u0010%\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/handoff/NotesHandoffContentObserver;", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffContentObserver;", "<init>", "()V", "mFragment", "Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/NotesPresenter;", "mHandoffLaunchManager", "Lcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager;", "mSenderName", "", "mAction", "mIsSyncRequested", "", "mContract", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/handoff/NotesHandoffContentObserver$Contract;", "mTimerStartAction", "Ljava/lang/Runnable;", "mTimerFailAction", "mTimerEndAction", "initialize", "", "fragment", "presenter", "contract", "updateHandoffInfo", "onDataReceived", "handoffLaunchManager", "getHandoffLaunchManager", "()Lcom/samsung/android/support/senl/nt/app/main/common/handoff/HandoffLaunchManager;", "handleActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "requestUnregisterNoteHandoffObserver", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotesHandoffContentObserver extends HandoffContentObserver {

    @NotNull
    private static final String TAG = "NotesHandoffContentObserver";

    @Nullable
    private Contract mContract;

    @Nullable
    private AbsFragment mFragment;

    @Nullable
    private HandoffLaunchManager mHandoffLaunchManager;
    private boolean mIsSyncRequested;

    @Nullable
    private NotesPresenter mPresenter;

    @NotNull
    private String mSenderName = "";

    @Nullable
    private String mAction = "";

    @NotNull
    private final Runnable mTimerStartAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver$mTimerStartAction$1
        @Override // java.lang.Runnable
        public void run() {
            AbstractC0000a.m3D(this.this$0.hashCode(), "time, startAction ", "NotesHandoffContentObserver");
            this.this$0.mIsSyncRequested = true;
            HandoffUtils.INSTANCE.getInstance().requestSyncHandoffData();
        }
    };

    @NotNull
    private final Runnable mTimerFailAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver$mTimerFailAction$1
        @Override // java.lang.Runnable
        public void run() {
            AbstractC0000a.m3D(this.this$0.hashCode(), "time, failAction ", "NotesHandoffContentObserver");
            this.this$0.requestUnregisterNoteHandoffObserver();
            NotesPresenter notesPresenter = this.this$0.mPresenter;
            Intrinsics.checkNotNull(notesPresenter);
            notesPresenter.removeCircleProgressDialog();
        }
    };

    @NotNull
    private final Runnable mTimerEndAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver$mTimerEndAction$1
        @Override // java.lang.Runnable
        public void run() {
            AbstractC0000a.m3D(this.this$0.hashCode(), "time, endAction ", "NotesHandoffContentObserver");
            NotesPresenter notesPresenter = this.this$0.mPresenter;
            Intrinsics.checkNotNull(notesPresenter);
            notesPresenter.removeCircleProgressDialog();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/handoff/NotesHandoffContentObserver$Contract;", "", "requestUnregisterNoteHandoffObserver", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void requestUnregisterNoteHandoffObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandoffLaunchManager getHandoffLaunchManager() {
        FragmentActivity activity;
        AbsFragment absFragment = this.mFragment;
        if (absFragment != null && (activity = absFragment.getActivity()) != null && this.mHandoffLaunchManager == null && (activity instanceof AppCompatActivity)) {
            this.mHandoffLaunchManager = new HandoffLaunchManager(new WeakReference((AppCompatActivity) activity), false, new HandoffLaunchManager.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver$handoffLaunchManager$1$1
                @Override // com.samsung.android.support.senl.nt.app.main.common.handoff.HandoffLaunchManager.Contract
                public void requestUnregisterHandoffObserver() {
                    this.this$0.requestUnregisterNoteHandoffObserver();
                }
            });
        }
        return this.mHandoffLaunchManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestUnregisterNoteHandoffObserver() {
        MainLogger.m7255e(TAG, "requestUnregisterNoteHandoffObserver");
        Contract contract = this.mContract;
        if (contract != null) {
            contract.requestUnregisterNoteHandoffObserver();
        }
    }

    public final boolean handleActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        HandoffLaunchManager handoffLaunchManager = this.mHandoffLaunchManager;
        return handoffLaunchManager != null && handoffLaunchManager.onActivityResult(requestCode, resultCode, data);
    }

    public final void initialize(@Nullable AbsFragment fragment, @NotNull NotesPresenter presenter, @Nullable Contract contract) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mFragment = fragment;
        this.mPresenter = presenter;
        this.mContract = contract;
        this.mIsSyncRequested = false;
        if (fragment == null || (activity = fragment.getActivity()) == null) {
            return;
        }
        this.mAction = activity.getIntent().getAction();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver
    public void onDataReceived() {
        super.onDataReceived();
        HandoffLaunchManager handoffLaunchManager = getHandoffLaunchManager();
        if (handoffLaunchManager != null) {
            handoffLaunchManager.cancelTimer();
        }
        if (TextUtils.isEmpty(this.mSenderName)) {
            MainLogger.m7258i(TAG, "HandoffContentObserverImpl, onDataReceived, sender is changed, ignore this event");
        } else if (!this.mIsSyncRequested) {
            MainLogger.m7259w(TAG, "HandoffContentObserverImpl, onDataReceived, ignore, sync is not requested in this observer");
        } else {
            AbstractC8014b.m7201c(hashCode(), "HandoffContentObserverImpl, onDataReceived ", TAG);
            HandoffUtils.INSTANCE.getInstance().loadHandoffData(new HandoffUtils.CallBack() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver.onDataReceived.1
                @Override // com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.CallBack
                public void onResult(Bundle result) {
                    HandoffLaunchManager handoffLaunchManager2;
                    if (result == null) {
                        MainLogger.m7254d(NotesHandoffContentObserver.TAG, "HandoffContentObserverImpl, onDataReceived, loadHandoffDataResult# result == null");
                        return;
                    }
                    String string = result.getString(HandoffConstant.KEY_HANDOFF_DATA);
                    if (TextUtils.isEmpty(string)) {
                        MainLogger.m7255e(NotesHandoffContentObserver.TAG, "HandoffContentObserverImpl, onDataReceived, loadHandoffDataResult# handoffData == null");
                        return;
                    }
                    AbstractC8014b.m7209k("HandoffContentObserverImpl, onDataReceived, handoffData : ", MainLogger.getEncode(string), NotesHandoffContentObserver.TAG);
                    AbsFragment absFragment = NotesHandoffContentObserver.this.mFragment;
                    if ((absFragment != null ? absFragment.getActivity() : null) == null || (handoffLaunchManager2 = NotesHandoffContentObserver.this.getHandoffLaunchManager()) == null) {
                        return;
                    }
                    HandoffLaunchManager.handleHandoffData$default(handoffLaunchManager2, string, null, 2, null);
                }
            });
        }
    }

    public final void updateHandoffInfo() {
        AbsFragment absFragment = this.mFragment;
        if (absFragment != null) {
            Intrinsics.checkNotNull(absFragment);
            if (!absFragment.isResumed() || Intrinsics.areEqual(Constants.ACTION_HANDOFF, this.mAction)) {
                return;
            }
            MainLogger.m7258i(TAG, "updateHandoffInfo");
            this.mSenderName = "";
            HandoffUtils.INSTANCE.getInstance().updateHandoffInfo(new HandoffUtils.UpdateHandoffInfoCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver.updateHandoffInfo.1
                @Override // com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.UpdateHandoffInfoCallback
                public void onUpdateFinished(boolean success, String senderName, String deviceType, long lastModificationTime) {
                    AbsFragment absFragment2;
                    FragmentActivity activity;
                    Intrinsics.checkNotNullParameter(senderName, "senderName");
                    Intrinsics.checkNotNullParameter(deviceType, "deviceType");
                    NotesHandoffContentObserver.this.mSenderName = senderName;
                    StringBuilder sb = new StringBuilder("updateHandoffInfo, onUpdateFinished# success : ");
                    sb.append(success);
                    sb.append(", senderName : ");
                    AbstractC2821a.m2207B(sb, senderName, ", deviceType : ", deviceType, ", lastModificationTime : ");
                    sb.append(lastModificationTime);
                    MainLogger.m7258i(NotesHandoffContentObserver.TAG, sb.toString());
                    if (!success || (absFragment2 = NotesHandoffContentObserver.this.mFragment) == null || (activity = absFragment2.getActivity()) == null) {
                        return;
                    }
                    String string = activity.getString(C8003R.string.handoff_note_from_sender, NotesHandoffContentObserver.this.mSenderName);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = activity.getString(C8003R.string.handoff_note_from_sender_open);
                    Integer numValueOf = Integer.valueOf(HandoffUtils.INSTANCE.getInstance().getMLastHandoffCallerDeviceType() == 0 ? C8003R.drawable.ic_handoff_notice_phone : C8003R.drawable.ic_handoff_notice_tablet);
                    Integer numValueOf2 = Integer.valueOf(activity.getResources().getColor(C8003R.color.handoff_notice_text, null));
                    Integer numValueOf3 = Integer.valueOf(activity.getResources().getColor(C8003R.color.handoff_notice_text, null));
                    Integer numValueOf4 = Integer.valueOf(activity.getResources().getColor(C8003R.color.handoff_notice_bg, null));
                    final NotesHandoffContentObserver notesHandoffContentObserver = NotesHandoffContentObserver.this;
                    SnackbarHelper.show$default(activity, string, string2, -1, numValueOf, numValueOf2, numValueOf3, numValueOf4, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver$updateHandoffInfo$1$onUpdateFinished$1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            MainLogger.m7258i("NotesHandoffContentObserver", "updateHandoffInfo, onClick snackBar");
                            HandoffLaunchManager handoffLaunchManager = notesHandoffContentObserver.getHandoffLaunchManager();
                            if (handoffLaunchManager != null) {
                                handoffLaunchManager.setTimerStartAction(notesHandoffContentObserver.mTimerStartAction);
                            }
                            HandoffLaunchManager handoffLaunchManager2 = notesHandoffContentObserver.getHandoffLaunchManager();
                            if (handoffLaunchManager2 != null) {
                                handoffLaunchManager2.setTimerFailAction(notesHandoffContentObserver.mTimerFailAction);
                            }
                            HandoffLaunchManager handoffLaunchManager3 = notesHandoffContentObserver.getHandoffLaunchManager();
                            if (handoffLaunchManager3 != null) {
                                handoffLaunchManager3.setTimerEndAction(notesHandoffContentObserver.mTimerEndAction);
                            }
                            NotesPresenter notesPresenter = notesHandoffContentObserver.mPresenter;
                            Intrinsics.checkNotNull(notesPresenter);
                            final NotesHandoffContentObserver notesHandoffContentObserver2 = notesHandoffContentObserver;
                            notesPresenter.showCircleProgressDialog(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver$updateHandoffInfo$1$onUpdateFinished$1$onClick$1
                                @Override // android.content.DialogInterface.OnKeyListener
                                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    if (keyCode != 4 || event.getAction() != 1) {
                                        return false;
                                    }
                                    MainLogger.m7258i("NotesHandoffContentObserver", "CircleProgress Back Key pressed");
                                    HandoffLaunchManager handoffLaunchManager4 = notesHandoffContentObserver2.getHandoffLaunchManager();
                                    if (handoffLaunchManager4 != null) {
                                        handoffLaunchManager4.cancelTimer();
                                    }
                                    return true;
                                }
                            });
                            HandoffLaunchManager handoffLaunchManager4 = notesHandoffContentObserver.getHandoffLaunchManager();
                            if (handoffLaunchManager4 != null) {
                                handoffLaunchManager4.createTimer();
                            }
                        }
                    }, null, 512, null);
                }
            });
        }
    }
}
