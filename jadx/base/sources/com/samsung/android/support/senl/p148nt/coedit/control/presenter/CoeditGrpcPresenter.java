package com.samsung.android.support.senl.p148nt.coedit.control.presenter;

import android.text.TextUtils;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpFileData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.coedit.C8996R;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.GrpcController;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract;
import com.samsung.android.support.senl.p148nt.coedit.control.networkutils.CancelRequest;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.GetJwtItem;
import com.samsung.android.support.senl.p148nt.coedit.control.util.SCloudJwtManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditGrpcPresenter {
    private static final String TAG = "CoeditGrpcPresenter";
    private final ICoeditHandlerPresenterListener mCoeditListener;
    private GrpcController mGrpcController = null;
    private final ConcurrentLinkedQueue<CancelRequest> mCancelRequestList = new ConcurrentLinkedQueue<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GrpcControllerConnectionContractImpl implements ConnectionControllerContract {
        public GrpcControllerConnectionContractImpl() {
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public ConnectionControllerContract.JwtResultItem getJWT(String str, String str2, String str3, String str4) {
            CoeditLogger.m8923i(CoeditGrpcPresenter.TAG, "[CS3] CoeditHandler() : getJWT for " + str + ", caller: " + str4);
            if (!TextUtils.isEmpty(CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().getJwt()) && CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().isNetworkReconnecting()) {
                return new ConnectionControllerContract.JwtResultItem(CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().getJwt(), CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().getRegionDomain());
            }
            if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                CoeditLogger.m8920e(CoeditGrpcPresenter.TAG, "[CS3-2] getJWT : fail to getJWT due to the network connection");
                return new ConnectionControllerContract.JwtResultItem(CoeditServiceConstants.ServerError.UNKNOWN, null);
            }
            CancelRequest cancelRequest = new CancelRequest();
            CoeditGrpcPresenter.this.mCancelRequestList.add(cancelRequest);
            GetJwtItem jwt = SCloudJwtManager.getInstance().getJWT(str, str2, str3, cancelRequest);
            CoeditGrpcPresenter.this.mCancelRequestList.remove(cancelRequest);
            if (!jwt.isError()) {
                String jwt2 = jwt.getJwt();
                String ownerRegionDomain = jwt.getOwnerRegionDomain();
                CoeditLogger.m8923i(CoeditGrpcPresenter.TAG, "[CS3-1] getJWT : succeed to getJWT for " + str + " in " + ownerRegionDomain);
                if (CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().isNetworkReconnecting()) {
                    CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().setJwt(jwt2);
                    CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().setRegionDomain(ownerRegionDomain);
                }
                return new ConnectionControllerContract.JwtResultItem(jwt2, ownerRegionDomain);
            }
            int errorCode = jwt.getErrorCode();
            if (errorCode != 1) {
                if (errorCode == 2) {
                    return new ConnectionControllerContract.JwtResultItem(CoeditServiceConstants.ServerError.UPDATE_APP_VERSION, null);
                }
                if (errorCode == 3) {
                    return new ConnectionControllerContract.JwtResultItem(CoeditServiceConstants.ServerError.MAINTENANCE, null);
                }
                if (errorCode != 13) {
                    CoeditLogger.m8920e(CoeditGrpcPresenter.TAG, "[CS3-2] getJWT : fail to getJWT due to the unknown error, errorCode = " + jwt.getErrorCode());
                    return new ConnectionControllerContract.JwtResultItem(CoeditServiceConstants.ServerError.UNKNOWN, null);
                }
            }
            return new ConnectionControllerContract.JwtResultItem(CoeditServiceConstants.ServerError.AUTH_TOKEN_EXPIRED, null);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public int getJwtMode(String str) {
            return SCloudJwtManager.getInstance().getJwtMode(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public String getUuid() {
            return CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().getUuid();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public boolean isAlreadySnapReleased() {
            return CoeditGrpcPresenter.this.mCoeditListener.isAlreadySnapReleased();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public void onContentFileUploadError(int i) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().onContentFileUploadError(i);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public int pauseConcurrency(String str) {
            return CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().pauseConcurrency(str, null);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public void reconnect(String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().reconnect(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ConnectionControllerContract
        public int resumeConcurrency(String str) {
            return CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().resumeConcurrency(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GrpcControllerManagerContractImpl implements ManagerControllerContract {
        public GrpcControllerManagerContractImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0(String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().reconnect(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void applyStrokeBinary(String str, byte[] bArr) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().applyStrokeBinary(str, bArr);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void downloadContentFile(String str, String str2) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().downloadContentFile(str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public String getWorkspaceId() {
            return CoeditGrpcPresenter.this.mCoeditListener.getComposerContract().getWorkspaceId();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void handleDownloadUrlMap(Map<String, String> map) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().handleDownloadUrlMap(map);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void handleReceiveServerResponse(long j, long j2, long j3, long j5, long j6, boolean z) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().handleReceiveServerResponse(j, j2, j3, j5, j6, z);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void handleResetWorkspaceResponse(long j) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().handleResetWorkspaceResponse(j);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void handleWorkspaceBlock() {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().handleWorkspaceBlock();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public boolean isClosing() {
            return CoeditGrpcPresenter.this.mCoeditListener.isClosingState();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public boolean isConcurrencyPausedByNetwork() {
            return CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().isConcurrencyPaused(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.NETWORK_ISSUE);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void onError(final String str) {
            if (CoeditServiceConstants.WorkspaceError.CONNECT_BLOCKED.equals(str)) {
                CoeditGrpcPresenter.this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6656a.lambda$onError$0(str);
                    }
                }, "onError");
            } else {
                CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().onError(str);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void onSnapError(String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().onSnapError(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void putNotifyNoteOpsBuffer(long j, List<NoteOp> list, String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().putNotifyNoteOpsBuffer(j, list, str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void releaseLock(String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().releaseLock(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void runResumeRunnable() {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().runResumeRunnable();
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void setAbnormalAckCheckPoint(long j) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().setAbnormalAckCheckPoint(j);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public boolean setLock(String str) {
            return CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().setLock(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void setPausedByNetwork(String str) {
            AbstractC8014b.m7219u("setPausedByNetwork, msg: ", str, CoeditGrpcPresenter.TAG);
            if (!isConcurrencyPausedByNetwork()) {
                CoeditGrpcPresenter.this.mCoeditListener.getCoeditControlPresenter().showToast(BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_pause_by_server_unable_to_connect_server) + " " + BaseUtils.getApplicationContext().getString(C8996R.string.co_edit_pause_by_server_working_offline_reopen_note_to_sync_it));
            }
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.NETWORK_ISSUE, null);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void updateSnapNoteLatestInfo(long j, long j2, String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().setNoteSnapServerCheckPoint(j);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void uploadContentFile(NoteOpFileData noteOpFileData, String str, String str2) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().uploadContentFile(noteOpFileData, str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ManagerControllerContract
        public void wakeConcurrencyPool() {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().wakeConcurrencyPool();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GrpcControllerViewContractImpl implements ViewControllerContract {
        public GrpcControllerViewContractImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEditorUpdate$0(String str, String str2) {
            CoeditGrpcPresenter.this.mCoeditListener.getComposerContract().onEditorUpdate(str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
        public void handleDeviceListChange(String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditManager().handleDeviceListChange(str);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
        public void onEditorUpdate(final String str, final String str2) {
            CoeditGrpcPresenter.this.mCoeditListener.runOnUIThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6658a.lambda$onEditorUpdate$0(str, str2);
                }
            }, "onEditorUpdate");
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
        public void saveUndownloadedStrokeInfo(String str, String str2) {
            CoeditCacheUtils.saveUndownloadedStrokeInfo(CoeditGrpcPresenter.this.mCoeditListener.getCoeditHandlerModel().getUuid(), str, str2);
        }

        @Override // com.samsung.android.support.senl.p148nt.coedit.control.controller.grpc.contract.ViewControllerContract
        public void showToast(String str) {
            CoeditGrpcPresenter.this.mCoeditListener.getCoeditControlPresenter().showDebugToast(str);
        }
    }

    public CoeditGrpcPresenter(ICoeditHandlerPresenterListener iCoeditHandlerPresenterListener) {
        this.mCoeditListener = iCoeditHandlerPresenterListener;
    }

    private void cancelRequestList() {
        for (CancelRequest cancelRequest : this.mCancelRequestList) {
            if (!cancelRequest.isCanceled()) {
                cancelRequest.cancel();
            }
        }
    }

    public int getDownloadXmlDataSize() {
        if (isValid()) {
            return this.mGrpcController.getDownloadXmlDataSize();
        }
        return -1;
    }

    public void initGrpcController() {
        if (isValid()) {
            return;
        }
        this.mGrpcController = new GrpcController(new GrpcControllerConnectionContractImpl(), new GrpcControllerViewContractImpl(), new GrpcControllerManagerContractImpl());
        this.mCoeditListener.getCoeditManager().initGrpcController(this.mGrpcController);
    }

    public boolean isConnectionUnstable() {
        if (isValid()) {
            return this.mGrpcController.isCoeditDataResultDeadlineExceeded() || this.mGrpcController.isCoeditDataResultNotFound() || this.mGrpcController.isCoeditDataResultUnavailable();
        }
        return false;
    }

    public boolean isValid() {
        return this.mGrpcController != null;
    }

    public void refreshForReopen() {
        if (isValid()) {
            this.mGrpcController.refreshForReopen();
        }
    }

    public void releaseForReconnect(String str) {
        if (isValid()) {
            this.mGrpcController.releaseContinuousMessageThread("releaseForReConnect# " + str);
        }
    }

    public void releaseGrpcController() {
        if (isValid()) {
            cancelRequestList();
            this.mCancelRequestList.clear();
            this.mGrpcController.release();
            this.mGrpcController = null;
        }
    }

    public void requestReconnect(String str) {
        if (isValid()) {
            if (!this.mGrpcController.isChannelConnected()) {
                this.mCoeditListener.getCoeditManager().channelReconnected();
                return;
            }
            this.mGrpcController.reOpen("From NetworkConnector# " + str);
        }
    }

    public void restoreUndownloadStroke(String str, String str2) {
        if (isValid()) {
            this.mGrpcController.requestDownloadStroke(str, str2);
        }
    }
}
