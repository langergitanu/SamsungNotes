package com.samsung.android.support.senl.p148nt.coedit.control;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.ntnl.coedit.BaseCoeditManager;
import com.samsung.android.support.senl.ntnl.coedit.CoeditCallback;
import com.samsung.android.support.senl.ntnl.coedit.CoeditManager;
import com.samsung.android.support.senl.ntnl.coedit.SnapCallback;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.coedit.C8996R;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract;
import com.samsung.android.support.senl.p148nt.coedit.control.common.ExternalControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.model.CoeditHandlerModel;
import com.samsung.android.support.senl.p148nt.coedit.control.presenter.CoeditControlPresenter;
import com.samsung.android.support.senl.p148nt.coedit.control.presenter.CoeditGrpcPresenter;
import com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditHandler implements ICoeditHandler, ICoeditHandlerPresenterListener {
    private static final String TAG = "CoeditHandler";
    private final CoeditHandlerModel mCoeditHandlerModel;
    private final ICoeditHandler.HandlerMangeContract mHandlerMangeContract;
    private Runnable mSnapRunnable = null;
    private BaseCoeditManager mCoeditManager = new BaseCoeditManager();
    private final CoeditGrpcPresenter mCoeditGrpcPresenter = new CoeditGrpcPresenter(this);
    private final CoeditControlPresenter mCoeditControlPresenter = new CoeditControlPresenter(this);
    private ICoeditHandler.ComposerContract mComposerContract = new EmptyComposerContract();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CoeditOpenCallbackImpl implements CoeditCallback {
        final CoeditControlCallback mCoeditCallback;

        public CoeditOpenCallbackImpl(CoeditControlCallback coeditControlCallback) {
            this.mCoeditCallback = coeditControlCallback;
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.CoeditCallback
        public void onCompleted(String str) {
            this.mCoeditCallback.onCompleted(str);
            CoeditHandler.this.mCoeditControlPresenter.showDebugToast(str);
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.CoeditCallback
        public void onError(String str) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ExternalSnapCallbackImpl implements SnapCallback {
        final ExternalControlCallback mExternalControlCallback;
        final SpenWNote mNote;

        public ExternalSnapCallbackImpl(SpenWNote spenWNote, ExternalControlCallback externalControlCallback) {
            this.mNote = spenWNote;
            this.mExternalControlCallback = externalControlCallback;
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.SnapCallback
        public void onSnapCompleted(String str, boolean z) {
            CoeditHandler.this.setSnapEndState("ExternalSnapCallbackImpl# onSnapCompleted: " + str);
            this.mExternalControlCallback.onCompleted(this.mNote, str);
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.SnapCallback
        public void onSnapError(String str) {
            CoeditHandler.this.setSnapEndState("ExternalSnapCallbackImpl# onSnapError: " + str);
            this.mExternalControlCallback.onError(this.mNote, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExternalSyncCallbackImpl implements CoeditCallback {
        final ExternalControlCallback mExternalControlCallback;
        final SpenWNote mNote;

        public ExternalSyncCallbackImpl(SpenWNote spenWNote, ExternalControlCallback externalControlCallback) {
            this.mNote = spenWNote;
            this.mExternalControlCallback = externalControlCallback;
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.CoeditCallback
        public void onCompleted(String str) {
            this.mExternalControlCallback.onCompleted(this.mNote, str);
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.CoeditCallback
        public void onError(String str) {
            this.mExternalControlCallback.onError(this.mNote, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SnapStartCallbackImpl implements SnapCallback {
        final SnapControlCallback mSnapCallback;

        public SnapStartCallbackImpl(SnapControlCallback snapControlCallback) {
            this.mSnapCallback = snapControlCallback;
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.SnapCallback
        public void onSnapCompleted(String str, boolean z) {
            CoeditHandler.this.setSnapEndState("SnapStartCallbackImpl# onSnapCompleted: " + str);
            this.mSnapCallback.onCompleted(str, z);
            CoeditHandler.this.mCoeditControlPresenter.showDebugToast(str);
            CoeditHandler.this.mCoeditControlPresenter.initNetworkConnector();
        }

        @Override // com.samsung.android.support.senl.ntnl.coedit.SnapCallback
        public void onSnapError(String str) {
            CoeditHandler.this.setSnapEndState("SnapStartCallbackImpl# onSnapError: " + str);
            this.mSnapCallback.onError(str);
            CoeditHandler.this.mCoeditControlPresenter.handleSnapStartError(str);
        }
    }

    public CoeditHandler(@NonNull String str, CoeditConstants.User user, ICoeditHandler.HandlerMangeContract handlerMangeContract) {
        this.mHandlerMangeContract = handlerMangeContract;
        this.mCoeditHandlerModel = new CoeditHandlerModel(str, user);
    }

    private void directlyRelease(Runnable runnable) {
        CoeditLogger.m8923i(TAG, "directlyRelease");
        this.mCoeditControlPresenter.releaseNetworkConnector();
        this.mCoeditControlPresenter.stopCoeditManager();
        CoeditCacheUtils.release(getUuid());
        this.mHandlerMangeContract.releaseUiThreadHandler(getUuid());
        releaseCoeditManager();
        this.mCoeditGrpcPresenter.releaseGrpcController();
        this.mCoeditControlPresenter.releaseCoeditController();
        if (!isAlreadySnapReleased()) {
            releaseSnapRunnable();
        }
        this.mComposerContract = new EmptyComposerContract();
        setClosedState();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ long m8870i(CoeditHandler coeditHandler, SpenWNote spenWNote, String str) {
        return coeditHandler.snapInitialize(spenWNote, str, "internalSnapStartInitialize");
    }

    private void initCoeditManager() {
        if (this.mCoeditManager.isValid()) {
            return;
        }
        this.mCoeditManager = new CoeditManager(getUuid(), false);
    }

    private void internalSnapStartInitialize(@NonNull final SpenWNote spenWNote, @NonNull final String str, @NonNull final String str2, @NonNull final String str3, final SnapControlCallback snapControlCallback) {
        this.mSnapRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.7
            /* JADX INFO: Access modifiers changed from: private */
            public void clearSnapCoeditCache(long j, String str4) {
                CoeditUtils.removeCoeditCacheIfCheckPointIsChanged(CoeditHandler.this.getUuid(), j, spenWNote.getServerCheckPoint(), str4);
                CoeditHandler.this.releaseSnapRunnable();
            }

            private void internalSnapStart(final long j) {
                CoeditHandler.this.mCoeditManager.internalSnapStart(spenWNote.getMHandle(), str2, str3, new SnapStartCallbackImpl(snapControlCallback) { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.7.1
                    {
                        CoeditHandler coeditHandler = CoeditHandler.this;
                    }

                    @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.SnapStartCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
                    public void onSnapCompleted(String str4, boolean z) {
                        clearSnapCoeditCache(j, "internalSnapStartInitialize isSnapUploaded: " + z);
                        if (CoeditHandler.this.isCancelled()) {
                            super.onSnapError("succeed to internalSnapStart, but cancelled");
                        } else {
                            CoeditCacheUtils.setSnapUploadCompleted(CoeditHandler.this.getUuid());
                            super.onSnapCompleted(str4, z);
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.SnapStartCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
                    public void onSnapError(String str4) {
                        clearSnapCoeditCache(j, "internalSnapStartInitialize");
                        super.onSnapError(str4);
                    }
                });
            }

            public void finalize() throws Throwable {
                super.finalize();
                SnapControlCallback snapControlCallback2 = snapControlCallback;
                if (snapControlCallback2 != null) {
                    snapControlCallback2.onRelease();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CoeditHandler.this.isValidInternalSnapStart(str, snapControlCallback)) {
                    if (CoeditHandler.this.isSnapDelayedState() && !CoeditHandler.this.mCoeditManager.checkSkipDownloadNote()) {
                        CoeditHandler.this.setInitState();
                        CoeditHandler.this.mCoeditManager.onError(CoeditServiceConstants.SnapError.VIEW_REATTACH);
                    } else {
                        long jM8870i = CoeditHandler.m8870i(CoeditHandler.this, spenWNote, str);
                        internalSnapStart(jM8870i);
                        CoeditHandler.this.onStartOfflineModeForUpload(jM8870i, snapControlCallback);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCancelled() {
        return this.mCoeditHandlerModel.isCancelled();
    }

    private boolean isDisableCoeditHandling(String str, String str2, CoeditHandlingContract coeditHandlingContract) {
        if (!CoeditUtils.verify(str, str2)) {
            coeditHandlingContract.verifyFail();
            return true;
        }
        if (!isCancelled()) {
            return false;
        }
        coeditHandlingContract.alreadyCanceled();
        return true;
    }

    private boolean isInitState() {
        return getState() == 1;
    }

    private boolean isNoneState() {
        return getState() == 0;
    }

    private boolean isRunningState() {
        return getState() == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidInternalSnapStart(@NonNull String str, final SnapControlCallback snapControlCallback) {
        if (!this.mCoeditManager.isValid()) {
            return false;
        }
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            this.mHandlerMangeContract.runOnWorkerThread(this.mSnapRunnable, getUuid(), 1000);
            pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.NETWORK_ISSUE);
            return false;
        }
        if (isDisableCoeditHandling(getUuid(), "isValidInternalSnapStart", new CoeditHandlingContract() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.8
            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract
            public void alreadyCanceled() {
                snapControlCallback.onError("isValidInternalSnapStart# already cancelled");
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract
            public void verifyFail() {
                snapControlCallback.onError("isValidInternalSnapStart# verifyFail");
            }
        })) {
            return false;
        }
        if (SpenWNoteFile.isValid(str)) {
            return true;
        }
        snapControlCallback.onError("isValidInternalSnapStart# note file is invalid");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartOfflineModeForUpload(long j, SnapControlCallback snapControlCallback) {
        if (snapControlCallback == null || j >= 0 || CoeditCacheUtils.isSnapUploadCompleted(getUuid())) {
            return;
        }
        setSnapDelayedState("onStartOfflineModeForUpload");
        snapControlCallback.onStartOfflineMode(CoeditServiceConstants.SnapError.NO_NETWORK);
    }

    private void releaseCoeditManager() {
        if (this.mCoeditManager.isValid()) {
            this.mCoeditManager.close();
            this.mCoeditManager = new BaseCoeditManager();
        }
    }

    private synchronized void releaseWithTimeout(Runnable runnable) {
        try {
            try {
                this.mCoeditControlPresenter.waitRelease();
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "releaseWithTimeout e : " + e.getMessage());
            }
        } finally {
            directlyRelease(runnable);
        }
    }

    @WorkerThread
    private void reloadHandler(String str) {
        final String strM756B = AbstractC0541b.m756B(str, "/reloadHandler");
        if (isRunningState()) {
            release(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.9
                @Override // java.lang.Runnable
                public void run() {
                    CoeditHandler.this.initialize(strM756B);
                }
            }, null, str);
        } else {
            if (isNoneState()) {
                initialize(str);
                return;
            }
            StringBuilder sbM15l = AbstractC0000a.m15l("reloadHandler already post init, synchronized initialize caller# ", str, " ");
            sbM15l.append(this.mCoeditHandlerModel.toString());
            CoeditLogger.m8919d(TAG, sbM15l.toString());
        }
    }

    private void setClosedState() {
        setState(7);
    }

    private void setClosingState() {
        setState(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInitState() {
        setState(1);
    }

    private void setRunningState(String str) {
        AbstractC8014b.m7219u("setRunningState# caller: ", str, TAG);
        setState(5);
    }

    private void setSnapDelayedState(String str) {
        AbstractC8014b.m7219u("setSnapDelayedState# caller: ", str, TAG);
        setState(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnapEndState(String str) {
        if (isClosingState("setSnapEndState")) {
            return;
        }
        AbstractC8014b.m7219u("setSnapEndState# caller: ", str, TAG);
        setState(4);
    }

    private void setSnapRunningState(String str) {
        AbstractC8014b.m7219u("setSnapRunningState# caller: ", str, TAG);
        setState(2);
    }

    private void setState(int i) {
        this.mCoeditHandlerModel.setState(i);
        CoeditLogger.m8919d(TAG, "setState, state: " + getState() + ", user: " + getUser() + ", hashCode: " + hashCode());
    }

    private long snapInitialize(@NonNull SpenWNote spenWNote, String str, String str2) {
        CoeditUtils.refreshUpdateCorrupted(spenWNote, getUuid());
        CoeditCacheUtils.initPrefInfo(getUuid());
        CoeditUtils.makeBodyTextNotEmpty(spenWNote);
        this.mCoeditHandlerModel.setFilePath(str);
        setSnapRunningState(str2);
        return spenWNote.getServerCheckPoint();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void checkDeleteOnlyMode() {
        this.mCoeditControlPresenter.checkDeleteOnlyMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void externalChannelOpen(final SpenWNote spenWNote, String str, String str2, final ExternalControlCallback externalControlCallback) {
        if (isDisableCoeditHandling(getUuid(), "externalChannelOpen", new CoeditHandlingContract() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.2
            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract
            public void alreadyCanceled() {
                externalControlCallback.onError(spenWNote, "externalChannelOpen# alreadyCanceled");
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract
            public void verifyFail() {
                externalControlCallback.onError(spenWNote, "externalChannelOpen# verifyFail");
            }
        })) {
            return;
        }
        synchronized (this) {
            try {
                if (isClosingState("externalChannelOpen")) {
                    return;
                }
                if (!isSnapDelayedState()) {
                    setRunningState("externalChannelOpen");
                }
                this.mCoeditManager.externalChannelOpen(spenWNote.getMHandle(), str, str2, new ExternalSyncCallbackImpl(spenWNote, externalControlCallback));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void externalSnapDownload(@NonNull SpenWNote spenWNote, String str, @NonNull String str2, @NonNull String str3, ExternalControlCallback externalControlCallback) {
        reloadHandler("externalSnapDownload");
        if (!CoeditUtils.verify(getUuid(), "externalSnapDownload")) {
            externalControlCallback.onError(spenWNote, "externalSnapDownload# verifyFail");
            return;
        }
        this.mCoeditHandlerModel.setFilePath(str);
        setSnapRunningState("externalSnapDownload");
        this.mCoeditManager.externalSnapDownload(spenWNote.getMHandle(), str2, str3, new ExternalSnapCallbackImpl(spenWNote, externalControlCallback) { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.5
            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.ExternalSnapCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
            public void onSnapCompleted(String str4, boolean z) {
                CoeditLogger.m8919d(CoeditHandler.TAG, "externalSnapDownload success# " + str4 + " isSnapUploaded# " + z);
                CoeditCacheUtils.setSnapUploadCompleted(CoeditHandler.this.getUuid());
                super.onSnapCompleted(str4, z);
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.ExternalSnapCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
            public void onSnapError(String str4) {
                CoeditLogger.m8920e(CoeditHandler.TAG, "externalSnapDownload fail# " + str4);
                super.onSnapError(str4);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void externalSnapStart(final SpenWNote spenWNote, String str, String str2, String str3, ExternalControlCallback externalControlCallback) {
        reloadHandler("externalSnapStart");
        if (!CoeditUtils.verify(getUuid(), "externalSnapStart")) {
            externalControlCallback.onError(spenWNote, "externalSnapStart# verifyFail");
        } else {
            final long jSnapInitialize = snapInitialize(spenWNote, str, "externalSnapStart");
            this.mCoeditManager.externalSnapStart(spenWNote.getMHandle(), str2, str3, new ExternalSnapCallbackImpl(spenWNote, externalControlCallback) { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.3
                @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.ExternalSnapCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
                public void onSnapCompleted(String str4, boolean z) {
                    CoeditLogger.m8919d(CoeditHandler.TAG, "externalSnapStart success# " + str4 + " isSnapUploaded# " + z);
                    CoeditUtils.removeCoeditCacheIfCheckPointIsChanged(CoeditHandler.this.getUuid(), jSnapInitialize, spenWNote.getServerCheckPoint(), "externalSnapStart");
                    CoeditCacheUtils.setSnapUploadCompleted(CoeditHandler.this.getUuid());
                    super.onSnapCompleted(str4, z);
                }

                @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.ExternalSnapCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
                public void onSnapError(String str4) {
                    CoeditLogger.m8920e(CoeditHandler.TAG, "externalSnapStart fail# " + str4);
                    CoeditUtils.removeCoeditCacheIfCheckPointIsChanged(CoeditHandler.this.getUuid(), jSnapInitialize, spenWNote.getServerCheckPoint(), "externalSnapStart");
                    super.onSnapError(str4);
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void externalSnapUpload(@NonNull SpenWNote spenWNote, String str, @NonNull String str2, @NonNull String str3, ExternalControlCallback externalControlCallback) {
        reloadHandler("externalSnapUpload");
        if (!CoeditUtils.verify(getUuid(), "externalSnapUpload")) {
            externalControlCallback.onError(spenWNote, "externalSnapUpload# verifyFail");
            return;
        }
        CoeditUtils.makeBodyTextNotEmpty(spenWNote);
        this.mCoeditHandlerModel.setFilePath(str);
        setSnapRunningState("externalSnapUpload");
        this.mCoeditManager.externalSnapUpload(spenWNote.getMHandle(), str2, str3, new ExternalSnapCallbackImpl(spenWNote, externalControlCallback) { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.4
            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.ExternalSnapCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
            public void onSnapCompleted(String str4, boolean z) {
                CoeditLogger.m8919d(CoeditHandler.TAG, "externalSnapUpload success# " + str4 + " isSnapUploaded# " + z);
                CoeditCacheUtils.setSnapUploadCompleted(CoeditHandler.this.getUuid());
                super.onSnapCompleted(str4, z);
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.ExternalSnapCallbackImpl, com.samsung.android.support.senl.ntnl.coedit.SnapCallback
            public void onSnapError(String str4) {
                CoeditLogger.m8920e(CoeditHandler.TAG, "externalSnapUpload fail# " + str4);
                super.onSnapError(str4);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public CoeditControlPresenter getCoeditControlPresenter() {
        return this.mCoeditControlPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public CoeditGrpcPresenter getCoeditGrpcPresenter() {
        return this.mCoeditGrpcPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public CoeditHandlerModel getCoeditHandlerModel() {
        return this.mCoeditHandlerModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public BaseCoeditManager getCoeditManager() {
        return this.mCoeditManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public ICoeditHandler.ComposerContract getComposerContract() {
        return this.mComposerContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int getState() {
        return this.mCoeditHandlerModel.getState();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public CoeditConstants.User getUser() {
        return this.mCoeditHandlerModel.getUser();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public String getUuid() {
        return this.mCoeditHandlerModel.getUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public void initUiThreadHandler() {
        this.mHandlerMangeContract.initUiThreadHandler(getUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void initialize(String str) {
        synchronized (this) {
            try {
                if (isInitState()) {
                    CoeditLogger.m8924w(TAG, "initialize, already in initialize state, caller# " + str + this.mCoeditHandlerModel.toString());
                    return;
                }
                CoeditLogger.m8919d(TAG, "initialize, synchronized initialize caller# " + str + this.mCoeditHandlerModel.toString());
                setInitState();
                this.mHandlerMangeContract.initUiThreadHandler(getUuid());
                initCoeditManager();
                this.mCoeditGrpcPresenter.initGrpcController();
                this.mCoeditControlPresenter.initCoeditController();
                this.mCoeditControlPresenter.initNetworkConnector();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void internalChannelOpen(Activity activity, @NonNull SpenWNote spenWNote, @NonNull String str, @NonNull String str2, final CoeditControlCallback coeditControlCallback) {
        if (isDisableCoeditHandling(this.mCoeditHandlerModel.getUuid(), "internalChannelOpen", new CoeditHandlingContract() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.1
            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract
            public void alreadyCanceled() {
                coeditControlCallback.onError("internalChannelOpen# alreadyCanceled");
            }

            @Override // com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditHandlingContract
            public void verifyFail() {
                coeditControlCallback.onError("internalChannelOpen# verifyFail");
            }
        })) {
            return;
        }
        this.mCoeditControlPresenter.setActivity(activity);
        synchronized (this) {
            try {
                if (isClosingState("internalChannelOpen")) {
                    return;
                }
                if (isRunningState()) {
                    coeditControlCallback.onCompleted("internalChannelOpen# Already Running#" + this.mCoeditHandlerModel.getUuid());
                } else {
                    if (!isSnapDelayedState()) {
                        setRunningState("internalChannelOpen");
                    }
                    this.mCoeditManager.internalChannelOpen(spenWNote.getMHandle(), str, str2, new CoeditOpenCallbackImpl(coeditControlCallback));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @UiThread
    public void internalSnapRefresh() {
        if (this.mComposerContract.canShowProgress()) {
            this.mComposerContract.showProgress("internalSnapRefresh");
            this.mHandlerMangeContract.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!CoeditHandler.this.mCoeditManager.isValid() || CoeditHandler.this.mCoeditManager.isConcurrencyPaused(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.COEDIT_RELEASE)) {
                        CoeditLogger.m8924w(CoeditHandler.TAG, "internalSnapRefresh ignored, already released or release now");
                    } else if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                        CoeditHandler.this.mCoeditControlPresenter.showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_connect_to_wifi_or_allow_mobile_data));
                    } else if (CoeditHandler.this.mCoeditManager.isConcurrencyPaused(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.SNAP_UPLOADING)) {
                        CoeditHandler.this.mCoeditControlPresenter.showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_unexpected_server_error_try_again_later));
                    } else {
                        boolean zInternalSnapRefresh = CoeditHandler.this.mCoeditManager.internalSnapRefresh();
                        if (!zInternalSnapRefresh) {
                            CoeditHandler.this.mCoeditControlPresenter.showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_internal_refresh_block_downloading_update) + " " + BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_internal_refresh_block_try_again_later));
                        }
                        CoeditLogger.m8919d(CoeditHandler.TAG, "internalSnapRefresh start internalSnapRefresh: " + zInternalSnapRefresh);
                    }
                    CoeditHandler.this.mComposerContract.hideProgress("internalSnapRefresh");
                }
            }, this.mCoeditHandlerModel.getUuid());
            return;
        }
        this.mCoeditControlPresenter.showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_internal_refresh_block_downloading_update) + " " + BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_internal_refresh_block_try_again_later));
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void internalSnapRestart(String str, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback) {
        CoeditCacheUtils.removeComposeCoeditCache(BaseUtils.getApplicationContext(), getUuid());
        if (isClosingState("internalSnapRestart")) {
            return;
        }
        this.mCoeditManager.internalSnapRestart(new SnapStartCallbackImpl(snapControlCallback), new CoeditOpenCallbackImpl(coeditControlCallback), str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public synchronized void internalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, SnapControlCallback snapControlCallback, ICoeditHandler.ComposerContract composerContract) throws Throwable {
        Throwable th;
        try {
            try {
                initialize("internalSnapStart");
                this.mComposerContract = composerContract;
                if (isRunningState()) {
                    try {
                        snapControlCallback.onCompleted("internalSnapStart# Already Running#" + getUuid(), false);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                internalSnapStartInitialize(spenWNote, str, str2, str3, snapControlCallback);
                if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                    this.mSnapRunnable.run();
                } else {
                    if (snapControlCallback != null) {
                        setSnapDelayedState("internalSnapStart");
                        snapControlCallback.onStartOfflineMode(CoeditServiceConstants.SnapError.NO_NETWORK);
                    }
                    this.mHandlerMangeContract.runOnWorkerThread(this.mSnapRunnable, getUuid(), 1000);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public boolean isAlreadySnapReleased() {
        return this.mSnapRunnable == null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler, com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public boolean isClosingState() {
        return getState() >= 6;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public boolean isInitializing() {
        return this.mCoeditManager.isInitializing();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public boolean isMaxCounted(long j, String str) {
        return this.mHandlerMangeContract.isMaxCounted(getUuid(), j, str);
    }

    public boolean isSnapDelayedState() {
        return getState() == 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public boolean isSnapEndState() {
        return getState() >= 4;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public boolean isWritePermissionGranted() {
        return this.mCoeditControlPresenter.isWritePermissionGranted();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int pauseConcurrency(String str) {
        return pauseConcurrency(str, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void release(Runnable runnable, Runnable runnable2, String str) {
        StringBuilder sbM12325j = AbstractC11014a.m12325j("release caller# ", str);
        sbM12325j.append(this.mCoeditHandlerModel.toString());
        CoeditLogger.m8919d(TAG, sbM12325j.toString());
        synchronized (this) {
            try {
                CoeditLogger.m8919d(TAG, "release, synchronized release caller# " + str + this.mCoeditHandlerModel);
                if (isClosingState("release")) {
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                } else {
                    setClosingState();
                    pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.COEDIT_RELEASE);
                    releaseWithTimeout(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseSnapRunnable() {
        this.mSnapRunnable = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public void releaseUiThreadHandler() {
        this.mHandlerMangeContract.releaseUiThreadHandler(getUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void requestReadPermission() {
        if (CoeditUtils.isCoeditDataNetworkAvailable()) {
            this.mCoeditManager.requestPermission(false);
        } else {
            CoeditLogger.m8924w(TAG, "requestReadPermission skip, data network is not available");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int resumeConcurrency(String str) {
        return this.mCoeditManager.resumeConcurrency(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public void runOnUIThread(final Runnable runnable, final String str) {
        if (isClosingState(str)) {
            return;
        }
        this.mHandlerMangeContract.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.10
            @Override // java.lang.Runnable
            public void run() {
                if (CoeditHandler.this.isClosingState(str)) {
                    return;
                }
                runnable.run();
            }
        }, getUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public void runOnWorkerThread(final Runnable runnable, final String str, int i) {
        if (isClosingState(str)) {
            return;
        }
        this.mHandlerMangeContract.runOnWorkerThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.CoeditHandler.11
            @Override // java.lang.Runnable
            public void run() {
                if (CoeditHandler.this.isClosingState(str)) {
                    return;
                }
                runnable.run();
            }
        }, getUuid(), i);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    @WorkerThread
    public void saveCoeditCache() {
        if (isSnapDelayedState() || isClosingState("saveCoeditCache")) {
            return;
        }
        CoeditCacheUtils.saveCoeditCache(getUuid());
        CoeditCacheUtils.setLocalDataChanged(getUuid(), this.mCoeditManager.saveCoeditCache());
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public void setCancelled() {
        this.mCoeditHandlerModel.setCancelled();
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.presenter.ICoeditHandlerPresenterListener
    public boolean isClosingState(String str) {
        if (getState() < 6) {
            return false;
        }
        CoeditLogger.m8924w(TAG, "Handler is closing now. uuid" + getUuid() + " caller : " + str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.ICoeditHandler
    public int pauseConcurrency(String str, Runnable runnable) {
        return this.mCoeditManager.pauseConcurrency(str, runnable);
    }
}
