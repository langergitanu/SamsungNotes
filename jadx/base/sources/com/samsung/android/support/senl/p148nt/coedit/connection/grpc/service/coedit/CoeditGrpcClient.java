package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit;

import android.os.Handler;
import android.os.Looper;
import coeditCoreMessage.ClientCmd;
import coeditCoreMessage.ClientMsg;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.method.GrpcMethod;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditGrpcDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CatchupRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.ContinuousMessageRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.DownloadStrokeRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.GetObjectUploadUrlRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.GetSignedDownloadUrlRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.PermissionRequestRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.ResetWorkspaceRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.SubmitRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.UploadStrokeRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditGrpcClient {
    private static final String TAG = "CoeditGrpcClient";
    private final CoeditGrpcData mCoeditData;
    private ContinuousMessageThread mContinuousMessageThread;
    private final GrpcRunnable.Contract mGrpcRunnableContract;
    private ExecutorService mMultiThreadPool;
    private int mReopenCount = 0;
    private ExecutorService mThreadPool;

    public CoeditGrpcClient(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CoeditGrpcDataContract coeditGrpcDataContract, GrpcRunnable.Contract contract) {
        CoeditGrpcData coeditGrpcData = new CoeditGrpcData();
        this.mCoeditData = coeditGrpcData;
        this.mThreadPool = createSingleThreadPool();
        this.mMultiThreadPool = createMultiThreadPool();
        coeditGrpcData.initialize(str, str2, str3, str4, str5, str6, str7, str8, coeditGrpcDataContract);
        this.mGrpcRunnableContract = contract;
        coeditGrpcData.setSubmitCheckPoint(-1L);
        coeditGrpcData.setNotifyCheckPoint(-1L);
        coeditGrpcData.setCatchupEndCheckPoint(-1L);
    }

    private void connect() {
        CoeditLogger.m8923i(TAG, "connect()");
        try {
            this.mCoeditData.putClientMsg(ClientMsg.newBuilder().setClientCmd(ClientCmd.CONNECT).build());
            checkClientMsg();
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("Failed to make connect msg. "), TAG);
            this.mGrpcRunnableContract.onError(CoeditServiceConstants.WorkspaceError.CONNECT_BLOCKED);
        }
    }

    private ExecutorService createMultiThreadPool() {
        return Executors.newScheduledThreadPool(10, new SenlThreadFactory("CoeditGrpcClient_Multi_" + this.mReopenCount));
    }

    private ExecutorService createSingleThreadPool() {
        return Executors.newSingleThreadExecutor(new SenlThreadFactory("CoeditGrpcClient_Single_" + this.mReopenCount));
    }

    private void postReleaseContinuousMessageThread() {
        if (this.mContinuousMessageThread == null) {
            return;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.connection.grpc.service.coedit.CoeditGrpcClient.1
            @Override // java.lang.Runnable
            public void run() {
                CoeditGrpcClient.this.releaseContinuousMessageThread("postReleaseContinuousMessageThread");
            }
        }, 200L);
    }

    private void requestCatchup(String str) {
        if (this.mCoeditData.isInvalidAsyncCatcher()) {
            CoeditLogger.m8924w(TAG, "requestCatchup(), failed by null stub");
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("requestCatchup(), Catchup message : ", str, ", startCheckPoint : ");
        sbM15l.append(this.mCoeditData.getCatchupStartCheckPoint());
        sbM15l.append(", endCheckPoint : ");
        sbM15l.append(this.mCoeditData.getCatchupEndCheckPoint());
        CoeditLogger.m8923i(TAG, sbM15l.toString());
        this.mThreadPool.execute(new CatchupRunnable(this.mCoeditData, this.mGrpcRunnableContract));
    }

    private void requestDisconnect(String str) {
        AbstractC8014b.m7223y("requestDisconnect(), Disconnect message : ", str, TAG);
        try {
            this.mCoeditData.putClientMsg(ClientMsg.newBuilder().setClientCmd(ClientCmd.DISCONNECT).build());
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("Failed to make disconnect msg. "), TAG);
        }
        checkClientMsg();
    }

    private void requestDownloadStroke(String str) {
        if (this.mCoeditData.isInvalidObjectAsyncDownloader()) {
            CoeditLogger.m8924w(TAG, "requestDownloadStroke(), failed by null stub");
        } else {
            AbstractC8014b.m7223y("requestDownloadStroke(), DownloadStroke message : ", str, TAG);
            this.mMultiThreadPool.execute(new DownloadStrokeRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        }
    }

    private void requestGetDeviceList(String str) {
        AbstractC8014b.m7223y("requestGetDeviceList(), GetDeviceList message : ", str, TAG);
        try {
            this.mCoeditData.putClientMsg(ClientMsg.newBuilder().setClientCmd(ClientCmd.GET_DEVICE_LIST).build());
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("Failed to make getDeviceList msg. "), TAG);
        }
        checkClientMsg();
    }

    private void requestGetObjectUploadUrl(String str) {
        if (this.mCoeditData.isInvalidObjectUploader()) {
            CoeditLogger.m8924w(TAG, "requestGetObjectUploadUrl(), failed by null stub");
        } else {
            AbstractC8014b.m7223y("requestGetObjectUploadUrl(), GetObjectUploadUrl message : ", str, TAG);
            this.mMultiThreadPool.execute(new GetObjectUploadUrlRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        }
    }

    private void requestGetSignedDownloadUrl(String str) {
        if (this.mCoeditData.isInvalidObjectDownloader()) {
            CoeditLogger.m8924w(TAG, "requestGetSignedDownloadUrl(), failed by null stub");
        } else {
            AbstractC8014b.m7223y("requestGetSignedDownloadUrl(), GetSignedDownloadUrl message : ", str, TAG);
            this.mMultiThreadPool.execute(new GetSignedDownloadUrlRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        }
    }

    private void requestOpen(String str) {
        CoeditLogger.m8923i(TAG, "requestOpen(), Open message : " + str);
        createContinuousMessageThread("requestStart(" + str + ")");
        connect();
    }

    private void requestRefresh(String str) {
        AbstractC8014b.m7223y("requestRefresh(), Refresh message : ", str, TAG);
        try {
            this.mCoeditData.putClientMsg(ClientMsg.newBuilder().setClientCmd(ClientCmd.REFRESH).build());
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("Failed to make refresh msg. "), TAG);
        }
        checkClientMsg();
    }

    private void requestRequestPermission(String str) {
        if (this.mCoeditData.isInvalidPolicyManager()) {
            CoeditLogger.m8924w(TAG, "requestRequestPermission(), failed by null stub");
            return;
        }
        CoeditLogger.m8923i(TAG, "requestRequestPermission(), RequestPermission message : " + str);
        new PermissionRequestRunnable(this.mCoeditData, this.mGrpcRunnableContract).run();
    }

    private void requestResetWorkspace(String str) {
        if (this.mCoeditData.isInvalidWorkspaceManager()) {
            CoeditLogger.m8924w(TAG, "requestResetWorkspace(), failed by null stub");
        } else {
            AbstractC8014b.m7223y("requestResetWorkspace(), ResetWorkspace message : ", str, TAG);
            this.mThreadPool.execute(new ResetWorkspaceRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        }
    }

    private void requestStart(String str) {
        AbstractC8014b.m7223y("requestStart(), message : ", str, TAG);
        this.mCoeditData.start("requestStart - CoeditGrpcClient");
    }

    private void requestStop(String str) {
        AbstractC8014b.m7223y("requestStop(), message : ", str, TAG);
        this.mCoeditData.stop("requestStop - CoeditGrpcClient", str, true);
        postReleaseContinuousMessageThread();
    }

    private void requestSubmit(String str) {
        if (this.mCoeditData.isInvalidSubmitter()) {
            CoeditLogger.m8924w(TAG, "requestSubmit(), failed by null stub");
            return;
        }
        AbstractC8014b.m7223y("requestSubmit(), Submit message : ", str, TAG);
        if (this.mThreadPool == null) {
            CoeditLogger.m8924w(TAG, "requestSubmit(), failed by invalid threadpool");
            return;
        }
        AbstractC8014b.m7223y("request(), Submit message : ", str, TAG);
        if (this.mCoeditData.hasSubmitRequestQueue()) {
            this.mThreadPool.execute(new SubmitRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        } else {
            CoeditLogger.m8919d(TAG, "submitMsgQueue size 0 ");
        }
    }

    private void requestUploadStroke(String str) {
        if (this.mCoeditData.isInvalidAsyncObjectUploader()) {
            CoeditLogger.m8924w(TAG, "requestUploadStroke(), failed by null stub");
        } else {
            AbstractC8014b.m7223y("requestUploadStroke(), UploadStroke message : ", str, TAG);
            this.mMultiThreadPool.execute(new UploadStrokeRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        }
    }

    public synchronized void checkClientMsg() {
        ContinuousMessageThread continuousMessageThread = this.mContinuousMessageThread;
        if (continuousMessageThread != null && !continuousMessageThread.getTargetRunnable().isCheckingClientMsg()) {
            this.mContinuousMessageThread.getTargetRunnable().checkClientMsg();
        }
    }

    public void createContinuousMessageThread(String str) {
        releaseContinuousMessageThread(str + "/createContinuousMessageThread");
        ContinuousMessageThread continuousMessageThread = new ContinuousMessageThread(new ContinuousMessageRunnable(this.mCoeditData, this.mGrpcRunnableContract));
        this.mContinuousMessageThread = continuousMessageThread;
        continuousMessageThread.setDaemon(true);
        this.mContinuousMessageThread.start();
    }

    public CoeditGrpcData getCoeditData() {
        return this.mCoeditData;
    }

    public void refreshForReopen() {
        this.mReopenCount++;
        CoeditLogger.m8923i(TAG, "refreshForReopen, count: " + this.mReopenCount);
        ExecutorService executorService = this.mThreadPool;
        if (executorService != null) {
            executorService.shutdown();
            this.mThreadPool = createSingleThreadPool();
        }
        ExecutorService executorService2 = this.mMultiThreadPool;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.mMultiThreadPool = createMultiThreadPool();
        }
        CoeditGrpcData coeditGrpcData = this.mCoeditData;
        if (coeditGrpcData != null) {
            coeditGrpcData.setSubmitCheckPoint(-1L);
            this.mCoeditData.setNotifyCheckPoint(-1L);
            this.mCoeditData.setCatchupEndCheckPoint(-1L);
            this.mCoeditData.refreshForReopen();
        }
    }

    public void release() {
        CoeditLogger.m8919d(TAG, "release()");
        ExecutorService executorService = this.mThreadPool;
        if (executorService != null) {
            executorService.shutdown();
            this.mThreadPool = null;
        }
        ExecutorService executorService2 = this.mMultiThreadPool;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.mMultiThreadPool = null;
        }
        CoeditGrpcData coeditGrpcData = this.mCoeditData;
        if (coeditGrpcData != null) {
            coeditGrpcData.setSubmitCheckPoint(-1L);
            this.mCoeditData.setNotifyCheckPoint(-1L);
            this.mCoeditData.setCatchupEndCheckPoint(-1L);
            this.mCoeditData.release();
        }
    }

    public synchronized void releaseContinuousMessageThread(String str) {
        ContinuousMessageThread continuousMessageThread = this.mContinuousMessageThread;
        if (continuousMessageThread == null) {
            return;
        }
        try {
            continuousMessageThread.interrupt();
            this.mContinuousMessageThread.getTargetRunnable().release(str);
            this.mContinuousMessageThread.release();
            this.mContinuousMessageThread = null;
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, "releaseContinuousMessageThread msg. " + e.getMessage());
        }
    }

    public void request(String str, @GrpcMethod int i) {
        if (this.mCoeditData.isInvalidStub()) {
            CoeditLogger.m8919d(TAG, "request(), failed by invalid stub");
        }
        if (i == 0) {
            requestStart(str);
            return;
        }
        if (i == 1) {
            requestOpen(str);
            return;
        }
        if (i == 2) {
            requestRefresh(str);
            return;
        }
        if (i == 3) {
            requestDisconnect(str);
            return;
        }
        if (i == 4) {
            requestStop(str);
            return;
        }
        switch (i) {
            case 101:
                requestGetObjectUploadUrl(str);
                break;
            case 102:
                requestGetSignedDownloadUrl(str);
                break;
            case 103:
                requestSubmit(str);
                break;
            case 104:
                requestUploadStroke(str);
                break;
            case 105:
                requestDownloadStroke(str);
                break;
            default:
                switch (i) {
                    case 110:
                        requestCatchup(str);
                        break;
                    case 111:
                        requestGetDeviceList(str);
                        break;
                    case 112:
                        requestRequestPermission(str);
                        break;
                    case 113:
                        requestResetWorkspace(str);
                        break;
                }
                break;
        }
    }
}
