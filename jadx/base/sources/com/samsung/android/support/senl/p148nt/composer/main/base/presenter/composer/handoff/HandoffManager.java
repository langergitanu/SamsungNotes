package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Looper;
import com.samsung.android.sdk.composer.util.SpenPagePan;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandOffData;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffSendManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.CvPageSettingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandoffManager {
    private static final String TAG = Logger.createTag("HandoffManager");
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private final IComposerPresenter mComposerViewPresenter;
    private ControllerManager mControllerManager;
    private IDialogManager mDialogManager;
    private boolean mDisabled;
    private final HandoffHandler mHandoffHandler = new HandoffHandler(Looper.getMainLooper(), new HandoffHandler.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffHandler.Contract
        public boolean isDisabled() {
            return HandoffManager.this.isDisabled();
        }
    });
    private SpenWNote mNote;
    private ObjectManager mObjectManager;
    private final ScrollController mScrollController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IComposerPresenter {
        void updatedLastPenInfo();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogManager extends HandoffHandler.DialogManager {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffHandler.DialogManager
        void hideSyncWaitingProgressDialog();

        void showSyncWaitingProgressDialog();
    }

    public HandoffManager(ScrollController scrollController, IComposerPresenter iComposerPresenter) {
        this.mScrollController = scrollController;
        this.mComposerViewPresenter = iComposerPresenter;
        setDisabled(false);
    }

    private boolean isHandOffAction() {
        Intent intent = this.mActivity.getIntent();
        return intent.getAction() != null && intent.getAction().equals(Constants.ACTION_HANDOFF);
    }

    private boolean isNotAvailableToUpdateStateFromHandoff(CoHandOffData coHandOffData, final Intent intent, Runnable runnable) {
        if (!SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false)) {
            HandoffUtils.getInstance().showDialogDisableSyncTurnOn(new WeakReference<>(this.mActivity), runnable, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.4
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m11003i(HandoffManager.TAG, "isNotAvailableToUpdateStateFromHandoff# cancel release ");
                    intent.removeExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING);
                }
            });
            return true;
        }
        if (!PermissionHelper.isPermissionGranted(this.mActivity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.5
            @Override // java.lang.Runnable
            public void run() {
                intent.putExtra(CoHandoffConstant.ARG_HANDOFF_WAITING, true);
                PermissionHelper.requestPermissions(HandoffManager.this.mActivity, 202, "android.permission.READ_PHONE_STATE");
            }
        }, "android.permission.READ_PHONE_STATE")) {
            return true;
        }
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataCallNotLimitedForApp()) {
            HandoffUtils.getInstance().showConnectToNetwork();
            intent.removeExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING);
            return true;
        }
        if (companion.isWiFiSyncOnlyAndNotWiFiConnected(this.mActivity)) {
            HandoffUtils.getInstance().showWiFiSyncOnlyAndNotWiFiConnected(new WeakReference<>(this.mActivity));
            intent.removeExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING);
            return true;
        }
        if (this.mComposerModel.getModeManager().isEditModeWithReadOnly() && (this.mComposerModel.isChangedDocStateOrRecording() || !this.mComposerModel.getMenuDirty().isEmpty())) {
            Logger.m11003i(TAG, "updateStateFromHandoff# editing " + this.mComposerModel.isChangedDocStateOrRecording() + " " + this.mComposerModel.getMenuDirty());
            intent.removeExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING);
            return true;
        }
        Long l = coHandOffData.getLong(CoHandoffConstant.ARG_SERVER_TIME_STAMP);
        if (l != null && l.longValue() <= this.mComposerModel.getNotesDocEntityManager().getServerTimeStampFromRepository()) {
            return false;
        }
        Logger.m11003i(TAG, "updateStateFromHandoff# cur: " + this.mComposerModel.getNotesDocEntityManager().getServerTimeStampFromRepository() + " input: " + l);
        updateHandoffSyncWaitingState();
        return true;
    }

    private void restorePosition(CoHandOffData coHandOffData) {
        Double d = coHandOffData.getDouble(CoHandoffConstant.ARG_CURR_X_POSITION_ON_PAGE);
        if (d != null) {
            restorePositionNew(coHandOffData, d);
        } else {
            restorePositionOld(coHandOffData);
        }
    }

    private void restorePositionNew(CoHandOffData coHandOffData, Double d) {
        Integer num = coHandOffData.getInt(CoHandoffConstant.ARG_SCREEN_WIDTH);
        Double d2 = coHandOffData.getDouble(CoHandoffConstant.ARG_CURR_Y_POSITION_ON_PAGE);
        Integer num2 = coHandOffData.getInt(CoHandoffConstant.ARG_CURR_PAGE_INDEX);
        Double d3 = coHandOffData.getDouble(CoHandoffConstant.ARG_CURR_ZOOM);
        if (num == null || d2 == null || num2 == null || d3 == null) {
            Logger.m11000e(TAG, "restorePositionNew# senderScreenWidth = " + num + " / yPosition = " + d2 + " / pageIndex = " + num2 + " / zoomValue = " + d3);
            return;
        }
        SpenPagePan spenPagePan = new SpenPagePan();
        spenPagePan.pageIndex = num2.intValue();
        if (this.mHandoffHandler.getScreenWidth() != num.intValue()) {
            float screenWidth = this.mHandoffHandler.getScreenWidth() / num.floatValue();
            spenPagePan.pan = new PointF(d.floatValue() * screenWidth, d2.floatValue() * screenWidth);
        } else {
            spenPagePan.pan = new PointF(d.floatValue(), d2.floatValue());
        }
        PointF pointFConvertPagePanToContentPan = SpenPagePan.convertPagePanToContentPan(this.mNote, spenPagePan);
        if (pointFConvertPagePanToContentPan == null) {
            Logger.m11000e(TAG, "restorePositionNew# contentPan is null");
        } else {
            this.mScrollController.setContentPan(d3.floatValue(), pointFConvertPagePanToContentPan.x, pointFConvertPagePanToContentPan.y, spenPagePan.pageIndex);
        }
    }

    private void restorePositionOld(CoHandOffData coHandOffData) {
        Integer num = coHandOffData.getInt(CoHandoffConstant.ARG_SCREEN_WIDTH);
        Double dValueOf = coHandOffData.getDouble(CoHandoffConstant.ARG_CURR_Y_POSITION);
        if (num != null && dValueOf != null) {
            if (this.mHandoffHandler.getScreenWidth() != num.intValue()) {
                dValueOf = Double.valueOf((dValueOf.doubleValue() * ((double) this.mHandoffHandler.getScreenWidth())) / ((double) num.intValue()));
            }
            this.mScrollController.setContentPan(0.0f, 0.0f, dValueOf.floatValue(), -1);
        } else {
            Logger.m11000e(TAG, "restorePositionOld# senderScreenWidth = " + num + " / yPosition = " + dValueOf);
        }
    }

    private void updateHandoffSyncWaitingState() {
        this.mDialogManager.showSyncWaitingProgressDialog();
    }

    private void updateTextMode(CoHandOffData coHandOffData) {
        Integer num = coHandOffData.getInt(CoHandoffConstant.ARG_CURR_CURSOR);
        if (num == null) {
            this.mControllerManager.getSoftInputManager().blockToShow(true, "updateStateFromHandoff");
        }
        this.mComposerModel.getModeManager().setMode(Mode.Text, "updateStateFromHandoff", true, num == null ? ModeManager.SIPShowType.NONE : ModeManager.SIPShowType.FORCE);
        if (num == null) {
            this.mObjectManager.selectObject(null);
            this.mControllerManager.getSoftInputManager().blockToShow(false, "updateStateFromHandoff");
            return;
        }
        SpenObjectTextBox bodyText = this.mNote.getBodyText();
        String text = bodyText.getText();
        if (text != null) {
            if (text.length() > num.intValue()) {
                bodyText.setCursorPosition(num.intValue());
            } else {
                bodyText.setCursorPosition(text.length());
            }
        }
    }

    public void cancelWaitingSync() {
        if (isDisabled()) {
            return;
        }
        Logger.m10999d(TAG, "cancelWaitingSync#");
        this.mActivity.getIntent().removeExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING);
        this.mDialogManager.hideSyncWaitingProgressDialog();
    }

    public void disableHandoffTemporary() {
        if (isDisabled()) {
            return;
        }
        this.mHandoffHandler.removeMessages(1);
        CoHandoffSendManager.getInstance().disable(this.mComposerModel.getDocState().getUuid());
    }

    public HandoffHandler getHandler() {
        return this.mHandoffHandler;
    }

    public void init(Activity activity, ControllerManager controllerManager, ComposerModel composerModel, ModelManager modelManager, IDialogManager iDialogManager, CvPageSettingController cvPageSettingController) {
        this.mComposerModel = composerModel;
        this.mActivity = activity;
        this.mNote = composerModel.getDoc();
        this.mControllerManager = controllerManager;
        this.mObjectManager = modelManager.getObjectManager();
        this.mDialogManager = iDialogManager;
        this.mHandoffHandler.init(composerModel, modelManager.getPageManager(), this.mObjectManager, modelManager.getTextManager(), cvPageSettingController, this.mComposerModel.getDoc().getPageDefaultWidth());
    }

    public boolean isDisabled() {
        return this.mDisabled || this.mComposerModel.isUnsupportedHandoff();
    }

    public void release() {
        this.mActivity = null;
        this.mNote = null;
        this.mHandoffHandler.release();
    }

    public void sendHandoffData() {
        if (isDisabled()) {
            return;
        }
        this.mHandoffHandler.sendHandoffData();
    }

    public void setDisabled(boolean z) {
        if (HandoffUtils.getInstance().isHandoffFixedStateEnabled()) {
            this.mDisabled = z;
        } else {
            this.mDisabled = true;
        }
    }

    public void updatePendingStateFromHandoff() {
        if (isNotAvailableToUpdateStateFromHandoff()) {
            return;
        }
        if (this.mControllerManager.getTaskController().isRunning()) {
            this.mControllerManager.getTaskController().addPendingJob(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.2
                @Override // java.lang.Runnable
                public void run() {
                    HandoffManager.this.updateStateFromHandoff();
                }
            }, 2);
        } else {
            updateStateFromHandoff();
        }
    }

    public void updateStateFromHandoff() {
        if (isNotAvailableToUpdateStateFromHandoff()) {
            return;
        }
        Intent intent = this.mActivity.getIntent();
        CoHandOffData coHandOffData = new CoHandOffData(intent.getStringExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING));
        Logger.m11003i(TAG, "updateStateFromHandoff# " + coHandOffData.getJsonObject());
        if (isNotAvailableToUpdateStateFromHandoff(coHandOffData, intent, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.m11003i(HandoffManager.TAG, "updateStateFromHandoff# pending release");
                HandoffManager.this.updateStateFromHandoff();
            }
        })) {
            return;
        }
        restorePosition(coHandOffData);
        Mode mode = this.mComposerModel.getModeManager().getMode(coHandOffData.getString(CoHandoffConstant.ARG_CURR_MODE));
        if (mode == Mode.Text) {
            updateTextMode(coHandOffData);
        } else {
            this.mComposerModel.getModeManager().setMode(mode, "updateStateFromHandoff", true);
            if (mode == Mode.Writing) {
                this.mComposerModel.getLastPenInfoOnlyOnce();
                this.mComposerViewPresenter.updatedLastPenInfo();
            }
        }
        intent.removeExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING);
        this.mDialogManager.hideSyncWaitingProgressDialog();
    }

    public void init(Activity activity, SpenWNote spenWNote) {
        this.mActivity = activity;
        this.mNote = spenWNote;
        this.mHandoffHandler.init();
    }

    private boolean isNotAvailableToUpdateStateFromHandoff() {
        return isDisabled() || !isHandOffAction() || !this.mActivity.getIntent().hasExtra(CoHandoffConstant.ARG_HANDOFF_DATA_STRING) || this.mActivity.getIntent().getBooleanExtra(CoHandoffConstant.ARG_HANDOFF_WAITING, false);
    }
}
