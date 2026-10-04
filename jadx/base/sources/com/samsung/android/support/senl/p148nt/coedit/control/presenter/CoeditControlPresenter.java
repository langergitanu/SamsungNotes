package com.samsung.android.support.senl.p148nt.coedit.control.presenter;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.C8996R;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditNetworkManager;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.CoeditController;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.coedit.view.CriticalErrorDialogFragment;
import com.samsung.android.support.senl.p148nt.coedit.view.DialogManager;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditControlPresenter implements CoeditNetworkManager.Callback {
    private static final String TAG = "CoeditControlPresenter";
    private WeakReference<AppCompatActivity> mActivityRef;
    private final ICoeditHandlerPresenterListener mCoeditListener;
    private CoeditController mCoeditController = null;
    private DialogManager mDialogManager = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditControllerComposerContractImpl implements CoeditController.ComposerContract {
        public CoeditControllerComposerContractImpl() {
        }

        private void hideInitProgress(final String str) {
            CoeditControlPresenter.this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.CoeditControllerComposerContractImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    CoeditControlPresenter.this.mCoeditListener.getComposerContract().hideInitProgress(str);
                }
            }, "hideInitProgress");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDeviceListUpdate(List<CoeditDeviceInfo> list) {
            if (CoeditControlPresenter.this.mCoeditListener.isClosingState("onDeviceListUpdate")) {
                return;
            }
            CoeditControlPresenter.this.mCoeditListener.getComposerContract().onListUpdate(list);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public boolean canShowProgress() {
            return CoeditControlPresenter.this.mCoeditListener.getComposerContract().canShowProgress();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public void handleError(long j, String str) {
            String strM772n = AbstractC0541b.m772n("handleError# msg: ", str);
            StringBuilder sbM781w = AbstractC0541b.m781w(strM772n, ", isServerError: ");
            sbM781w.append(CoeditServiceConstants.isServerError(str));
            sbM781w.append(", isConcurrencyError: ");
            sbM781w.append(CoeditServiceConstants.isConcurrencyError(str));
            sbM781w.append(", isClientError: ");
            sbM781w.append(CoeditServiceConstants.isClientError(str));
            sbM781w.append(", checkPoint: ");
            sbM781w.append(j);
            CoeditLogger.m8923i(CoeditControlPresenter.TAG, sbM781w.toString());
            CoeditControlPresenter.this.mCoeditListener.releaseUiThreadHandler();
            CoeditControlPresenter.this.mCoeditListener.initUiThreadHandler();
            if (CoeditServiceConstants.isServerError(str)) {
                CoeditControlPresenter.this.setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_server_error_check_app_update), strM772n);
                return;
            }
            if (CoeditServiceConstants.WorkspaceError.RESET.equals(str)) {
                hideInitProgress(strM772n);
                CoeditControlPresenter.this.setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_can_not_use_note_nonnection_not_unstable), strM772n);
            } else if (CoeditServiceConstants.isClientUpdateError(str) && CoeditControlPresenter.this.mCoeditListener.isMaxCounted(j, str)) {
                CoeditControlPresenter.this.showCriticalErrorDialog(str);
            } else {
                CoeditControlPresenter.this.requestReopenDirectly(str);
            }
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public void handleExceedMaxConnectDevice(long j) {
            CoeditControlPresenter.this.setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_disable_edit_mode_for_exceed_max_editable_device_count, Long.valueOf(j)), "handleExceedMaxConnectDevice");
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        @WorkerThread
        public void hideProgress(final String str) {
            CoeditControlPresenter.this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.CoeditControllerComposerContractImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    CoeditControlPresenter.this.mCoeditListener.getComposerContract().hideProgress(str);
                }
            }, "hideProgress");
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public boolean isEditMode() {
            return CoeditControlPresenter.this.mCoeditListener.getComposerContract().isEditMode();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public void onDeviceListUpdated(final List<CoeditDeviceInfo> list) {
            CoeditControlPresenter.this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.CoeditControllerComposerContractImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    CoeditControllerComposerContractImpl.this.onDeviceListUpdate(list);
                }
            }, "onDeviceListUpdated");
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public void setDisableOfflineEditMode(boolean z) {
            CoeditControlPresenter.this.setFixedReadPermission(z, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_disable_edit_mode_for_offline), "setDisableOfflineEditMode");
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public void setRequestUpdate(boolean z) {
            CoeditControlPresenter.this.mCoeditListener.getComposerContract().setRequestUpdate(z);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ComposerContract
        public void showProgress(String str) {
            CoeditControlPresenter.this.mCoeditListener.getComposerContract().showProgress(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditControllerManagerContractImpl implements CoeditController.ManagerContract {
        public CoeditControllerManagerContractImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ManagerContract
        public int getDownloadXmlDataSize() {
            return CoeditControlPresenter.this.mCoeditListener.getCoeditGrpcPresenter().getDownloadXmlDataSize();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ManagerContract
        public boolean isReconnectAvailable() {
            if (!CoeditControlPresenter.this.mCoeditListener.getCoeditGrpcPresenter().isValid()) {
                CoeditLogger.m8924w(CoeditControlPresenter.TAG, "isReConnectAvailable# GrpcController is invalid");
                return false;
            }
            if (!CoeditControlPresenter.this.isValid()) {
                CoeditLogger.m8924w(CoeditControlPresenter.TAG, "isReConnectAvailable# mCoeditController is invalid");
                return false;
            }
            if (!CoeditControlPresenter.this.mCoeditListener.getCoeditManager().isValid()) {
                CoeditLogger.m8924w(CoeditControlPresenter.TAG, "isReConnectAvailable# mCoeditManager is invalid");
                return false;
            }
            if (CoeditControlPresenter.this.mCoeditListener.isAlreadySnapReleased()) {
                return true;
            }
            CoeditLogger.m8924w(CoeditControlPresenter.TAG, "isReConnectAvailable# SnapRunnable is valid");
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ManagerContract
        public void releaseForReconnect(String str) {
            CoeditControlPresenter.this.mCoeditListener.getCoeditGrpcPresenter().releaseForReconnect(str);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ManagerContract
        public void releaseJwt() {
            CoeditControlPresenter.this.mCoeditListener.getCoeditHandlerModel().setJwt(null);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ManagerContract
        public void requestReconnect(String str) {
            CoeditControlPresenter.this.mCoeditListener.getCoeditGrpcPresenter().requestReconnect(str);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.ManagerContract
        public void runOnUiThread(final long j) {
            CoeditControlPresenter.this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.CoeditControllerManagerContractImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    CoeditControlPresenter.this.mCoeditListener.getCoeditManager().runOnUiThread(j);
                }
            }, "CoeditControllerManagerContractImpl");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditControllerRestoreContractImpl implements CoeditController.RestoreContract {
        public CoeditControllerRestoreContractImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.RestoreContract
        public void restoreDownloadStroke(String str, byte[] bArr) {
            CoeditControlPresenter.this.mCoeditListener.getCoeditManager().applyStrokeBinary(str, bArr);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.RestoreContract
        public void restoreUndownloadStroke(String str, String str2) {
            CoeditControlPresenter.this.mCoeditListener.getCoeditGrpcPresenter().restoreUndownloadStroke(str, str2);
        }
    }

    public CoeditControlPresenter(ICoeditHandlerPresenterListener iCoeditHandlerPresenterListener) {
        this.mCoeditListener = iCoeditHandlerPresenterListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisableFixedReadPermission(boolean z) {
        return this.mCoeditListener.getComposerContract().isCoeditUpdateListenerNonNull() || z == this.mCoeditListener.getComposerContract().isFixedReadPermission();
    }

    private void requestReopen(final String str) {
        if (CoeditServiceConstants.ConcurrencyError.UPLOAD_FAILED.equals(str)) {
            CoeditCacheUtils.removeCoeditCache(BaseUtils.getApplicationContext(), this.mCoeditListener.getCoeditHandlerModel().getUuid());
        } else {
            CoeditCacheUtils.removeComposeCoeditCache(BaseUtils.getApplicationContext(), this.mCoeditListener.getCoeditHandlerModel().getUuid());
        }
        this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                CoeditControlPresenter.this.mCoeditListener.getComposerContract().requestReopen(str, true, "requestReopen");
            }
        }, "requestReopen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestReopenDirectly(String str) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Coedit;
        if (UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            AbstractC8014b.m7219u("requestReopenDirectly# ", str, TAG);
            UserInputSkipper.setHoldingSingleActionEventTime(300L, tag);
            releaseNetworkConnector();
            this.mCoeditListener.getCoeditGrpcPresenter().refreshForReopen();
            requestReopen(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSaveToDevice(@StringRes int i) {
        this.mCoeditListener.getComposerContract().requestSaveToDevice(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckDeleteOnlyModeTimer() {
        this.mCoeditListener.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.7
            @Override // java.lang.Runnable
            public void run() {
                int xmlDataWeight = CoeditControlPresenter.this.mCoeditListener.getComposerContract().getXmlDataWeight();
                CoeditLogger.m8919d(CoeditControlPresenter.TAG, "setCheckDeleteOnlyModeTimer weightCount " + xmlDataWeight);
                if (xmlDataWeight > 41500) {
                    CoeditControlPresenter.this.setCheckDeleteOnlyModeTimer();
                } else if (CoeditControlPresenter.this.mCoeditListener.getComposerContract().isDeleteOnlyMode()) {
                    CoeditLogger.m8919d(CoeditControlPresenter.TAG, "setCheckDeleteOnlyModeTimer setDeleteOnlyMode false");
                    CoeditControlPresenter.this.setDeleteOnlyMode(false);
                }
            }
        }, "setCheckDeleteOnlyModeTimer", 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteOnlyMode(final boolean z) {
        this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                CoeditControlPresenter.this.mCoeditListener.getComposerContract().setDeleteOnlyMode(z);
            }
        }, "setDeleteOnlyMode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFixedReadPermission(final boolean z, final String str, String str2) {
        if (isDisableFixedReadPermission(z)) {
            return;
        }
        this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                if (CoeditControlPresenter.this.isDisableFixedReadPermission(z)) {
                    return;
                }
                CoeditControlPresenter.this.mCoeditListener.getComposerContract().setFixedReadPermission(z, str);
            }
        }, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCriticalDialog(String str) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Coedit;
        if (UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            AbstractC8014b.m7219u("showCriticalDialog# ", str, TAG);
            UserInputSkipper.setHoldingSingleActionEventTime(300L, tag);
            this.mCoeditListener.getCoeditGrpcPresenter().refreshForReopen();
            if (this.mActivityRef == null) {
                CoeditLogger.m8924w(TAG, "showCriticalDialog ignore, activity reference is invalid");
                return;
            }
            if (this.mDialogManager == null) {
                DialogManager dialogManager = new DialogManager();
                this.mDialogManager = dialogManager;
                dialogManager.init(this.mActivityRef);
            }
            this.mDialogManager.showCriticalDialog(new CriticalErrorDialogFragment.Contract() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.2
                @Override // com.samsung.android.support.senl.nt.coedit.view.CriticalErrorDialogFragment.Contract
                public void onClickCloseComposer() {
                    CoeditLogger.m8919d(CoeditControlPresenter.TAG, "onClickCloseComposer");
                    CoeditControlPresenter.this.mCoeditListener.getComposerContract().onClickCloseComposer();
                }

                @Override // com.samsung.android.support.senl.nt.coedit.view.CriticalErrorDialogFragment.Contract
                public void onClickSaveToDeviceBtn() {
                    CoeditLogger.m8919d(CoeditControlPresenter.TAG, "onClickSaveToDeviceBtn");
                    CoeditControlPresenter.this.requestSaveToDevice(C8996R.string.co_edit_save_to_device_success);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        CoeditLogger.m8920e(CoeditControlPresenter.TAG, "onClickSaveToDeviceBtn wait, exception: " + e.getMessage());
                    }
                    CoeditControlPresenter.this.mCoeditListener.getComposerContract().onClickCloseComposer();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCriticalErrorDialog(final String str) {
        releaseNetworkConnector();
        this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                CoeditControlPresenter.this.showCriticalDialog(str);
            }
        }, "showCriticalErrorDialog");
    }

    public void checkDeleteOnlyMode() {
        int xmlDataWeight = this.mCoeditListener.getComposerContract().getXmlDataWeight();
        CoeditLogger.m8919d(TAG, "checkDeleteOnlyMode weightCount " + xmlDataWeight);
        if (xmlDataWeight <= 42000 || this.mCoeditListener.getComposerContract().isDeleteOnlyMode()) {
            return;
        }
        CoeditLogger.m8919d(TAG, "checkDeleteOnlyMode setDeleteOnlyMode true");
        setDeleteOnlyMode(true);
        setCheckDeleteOnlyModeTimer();
    }

    public void handleSnapStartError(String str) {
        String strM772n = AbstractC0541b.m772n("SnapStartCallbackImpl# ", str);
        boolean zIsCoeditDataNetworkAvailable = CoeditUtils.isCoeditDataNetworkAvailable();
        CoeditLogger.m8924w(TAG, strM772n + " Network : " + zIsCoeditDataNetworkAvailable);
        if (CoeditServiceConstants.SnapError.SET_XML_FAIL.equals(str)) {
            setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_can_not_use_note_changed_to_view_mode), strM772n);
            return;
        }
        if (CoeditServiceConstants.isServerError(str)) {
            setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_server_error_check_app_update_and_can_not_use_co_edit), strM772n);
            return;
        }
        if (CoeditServiceConstants.ServerError.UNKNOWN.equals(str) || CoeditServiceConstants.SnapError.EMPTY_XML_FAIL.equals(str) || !zIsCoeditDataNetworkAvailable) {
            if (CoeditCacheUtils.isSnapUploadCompleted(this.mCoeditListener.getCoeditHandlerModel().getUuid())) {
                setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_unexpected_server_error_try_again_later), strM772n);
                return;
            } else {
                setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_could_not_create_shared_note_try_again_later), strM772n);
                return;
            }
        }
        if (CoeditServiceConstants.SnapError.UPLOAD_FAIL.equals(str)) {
            showDebugToast("Fail to upload coedit note");
        } else if (CoeditServiceConstants.ServerError.AUTH_TOKEN_EXPIRED.equals(str)) {
            setFixedReadPermission(true, BaseUtils.getApplicationContext().getString(C8996R.string.base_coedit_to_continue_using_services_securely_sign_in_again), strM772n);
        } else {
            showDebugToast("Fail to download coedit note");
        }
    }

    public void initCoeditController() {
        if (this.mCoeditController != null) {
            return;
        }
        this.mCoeditController = new CoeditController(new CoeditControllerRestoreContractImpl(), new CoeditControllerManagerContractImpl(), new CoeditControllerComposerContractImpl());
        this.mCoeditListener.getCoeditManager().initCoeditController(this.mCoeditController);
    }

    public void initNetworkConnector() {
        this.mCoeditListener.getCoeditManager().initNetworkReconnector();
        CoeditNetworkManager.getInstance().registerNetworkCallback(this.mCoeditListener.getCoeditHandlerModel().getUuid(), this);
    }

    public boolean isValid() {
        return this.mCoeditController != null;
    }

    public boolean isWritePermissionGranted() {
        if (!this.mCoeditListener.getCoeditManager().isValid()) {
            CoeditLogger.m8924w(TAG, "isWritePermissionGranted, mCoeditManager not created yet");
            return true;
        }
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            CoeditLogger.m8924w(TAG, "isWritePermissionGranted, use offline edit, data network is not available");
            if (!CoeditCacheUtils.isRequestUpdateCorrupted(this.mCoeditListener.getCoeditHandlerModel().getUuid())) {
                return true;
            }
            showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_can_not_use_note_nonnection_not_unstable));
            return false;
        }
        if (this.mCoeditListener.getCoeditManager().isConcurrencyPaused(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.NETWORK_ISSUE)) {
            CoeditLogger.m8924w(TAG, "isWritePermissionGranted, use offline edit, concurrency paused by network issue");
            if (!CoeditCacheUtils.isRequestUpdateCorrupted(this.mCoeditListener.getCoeditHandlerModel().getUuid())) {
                return true;
            }
            showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_can_not_use_note_nonnection_not_unstable));
            return false;
        }
        boolean zRequestPermission = this.mCoeditListener.getCoeditManager().requestPermission(true);
        if (!zRequestPermission) {
            if (this.mCoeditListener.getCoeditGrpcPresenter().isConnectionUnstable()) {
                showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_can_not_use_note_nonnection_not_unstable));
                return zRequestPermission;
            }
            showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_can_not_use_note_maximum_edit_mode));
            NotesSamsungAnalytics.insertLog(this.mCoeditListener.getComposerContract().isEditModeWithReadOnly() ? "683" : "682", "7650");
        }
        return zRequestPermission;
    }

    @Override // com.samsung.android.support.senl.nt.coedit.common.CoeditNetworkManager.Callback
    public void onAvailable() {
        this.mCoeditListener.getCoeditManager().reconnect("onAvailable");
    }

    @Override // com.samsung.android.support.senl.nt.coedit.common.CoeditNetworkManager.Callback
    public void onLost() {
        this.mCoeditListener.getCoeditManager().pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.NETWORK_ISSUE, null);
    }

    public void releaseCoeditController() {
        CoeditController coeditController = this.mCoeditController;
        if (coeditController != null) {
            coeditController.release();
            this.mCoeditController = null;
        }
        DialogManager dialogManager = this.mDialogManager;
        if (dialogManager != null) {
            dialogManager.release();
            this.mDialogManager = null;
        }
        WeakReference<AppCompatActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mActivityRef = null;
        }
    }

    public void releaseNetworkConnector() {
        CoeditNetworkManager.getInstance().unregisterNetworkCallback(this.mCoeditListener.getCoeditHandlerModel().getUuid());
        this.mCoeditListener.getCoeditManager().releaseNetworkReconnector();
    }

    public void setActivity(Activity activity) {
        if (activity instanceof AppCompatActivity) {
            this.mActivityRef = new WeakReference<>((AppCompatActivity) activity);
        }
    }

    public void setServerCheckPoint(long j) {
        this.mCoeditListener.getCoeditManager().setServerCheckPoint(j);
        String filePath = this.mCoeditListener.getCoeditHandlerModel().getFilePath();
        if (TextUtils.isEmpty(filePath) || !SpenWNoteFile.isValid(filePath)) {
            CoeditLogger.m8924w(TAG, "setServerCheckPoint, ignore, path: [" + CoeditLogger.getEncode(filePath) + "], setServerCheckPoint : " + j);
            return;
        }
        try {
            SpenWNoteFile.setServerCheckPoint(filePath, j);
            CoeditLogger.m8923i(TAG, "setServerCheckPoint : " + j);
        } catch (IllegalArgumentException e) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "setServerCheckPoint failed : ", " ");
            sbM1323p.append(e.getMessage());
            CoeditLogger.m8920e(TAG, sbM1323p.toString());
        }
    }

    public void showDebugToast(String str) {
        AbstractC8014b.m7223y("showDebugToast: ", str, TAG);
    }

    public void showToast(final String str) {
        this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.CoeditControlPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(BaseUtils.getApplicationContext(), str, 0);
            }
        }, "showToast");
    }

    public void stopCoeditManager() {
        if (this.mCoeditListener.getCoeditManager().isValid()) {
            long jStop = this.mCoeditListener.getCoeditManager().stop();
            CoeditLogger.m8922f(TAG, "stopCoeditManager# end, uuid: [" + this.mCoeditListener.getCoeditHandlerModel().getUuid() + "], serverCheckPoint: " + jStop);
            if (jStop <= 0) {
                return;
            }
            setServerCheckPoint(jStop);
        }
    }

    public void waitRelease() {
        int i = 0;
        while (i < 5) {
            if (!this.mCoeditListener.getCoeditManager().isValid()) {
                CoeditLogger.m8919d(TAG, "waitRelease finish, CoeditManager is released");
                return;
            }
            if (!this.mCoeditListener.getCoeditManager().isWorkingConcurrency()) {
                CoeditLogger.m8919d(TAG, "waitRelease finish, concurrency is not working");
                return;
            }
            if (!this.mCoeditListener.getCoeditManager().isConcurrencyPaused(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.COEDIT_RELEASE)) {
                CoeditLogger.m8919d(TAG, "waitRelease finish, concurrency is paused for coedit_release");
                return;
            }
            StringBuilder sb = new StringBuilder("waitRelease wait, concurrency is working and not paused, count: ");
            int i2 = i + 1;
            sb.append(i);
            CoeditLogger.m8924w(TAG, sb.toString());
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                CoeditLogger.m8920e(TAG, "waitRelease wait, exception: " + e.getMessage());
            }
            i = i2;
        }
    }
}
