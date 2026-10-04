package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.GetObjectUploadUrlRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.data.SnapGrpcDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.method.DownloadNoteRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.method.GetNoteLatestInfoRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.snap.method.UploadNoteRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SnapGrpcClient {
    private static final String TAG = "SnapGrpcClient";
    private GrpcRunnable mDownloadNoteRunnable;
    private final GrpcRunnable.Contract mGrpcRunnableContract;
    private ExecutorService mMultiThreadPool = Executors.newScheduledThreadPool(5, new SenlThreadFactory("SnapGrpcClient_Multi"));
    private final SnapGrpcData mSnapData;

    public SnapGrpcClient(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, SnapGrpcDataContract snapGrpcDataContract, GrpcRunnable.Contract contract) {
        SnapGrpcData snapGrpcData = new SnapGrpcData();
        this.mSnapData = snapGrpcData;
        snapGrpcData.initialize(str, str2, str3, str4, str5, str6, str7, str8, snapGrpcDataContract);
        this.mGrpcRunnableContract = contract;
    }

    private void requestDownloadNote(String str) {
        CoeditLogger.m8923i(TAG, "requestDownloadNote(), message : " + str);
        DownloadNoteRunnable downloadNoteRunnable = new DownloadNoteRunnable(this.mSnapData, this.mGrpcRunnableContract);
        this.mDownloadNoteRunnable = downloadNoteRunnable;
        downloadNoteRunnable.run();
        this.mDownloadNoteRunnable = null;
    }

    private void requestGetNoteLatestInfo(String str) throws Throwable {
        CoeditLogger.m8923i(TAG, "requestGetNoteLatestInfo(), message : " + str);
        new GetNoteLatestInfoRunnable(this.mSnapData, this.mGrpcRunnableContract).run();
    }

    private void requestGetObjectUploadUrl(String str) {
        if (this.mSnapData.isInvalidObjectUploader()) {
            CoeditLogger.m8924w(TAG, "requestGetObjectUploadUrl(), failed by null stub");
        } else {
            AbstractC8014b.m7223y("requestGetObjectUploadUrl(), message : ", str, TAG);
            this.mMultiThreadPool.execute(new GetObjectUploadUrlRunnable(this.mSnapData, this.mGrpcRunnableContract));
        }
    }

    private void requestStart(String str) {
        AbstractC8014b.m7223y("requestStart(), message : ", str, TAG);
        this.mSnapData.start("requestStart - SnapGrpcClient");
    }

    private void requestStop(String str) {
        AbstractC8014b.m7223y("requestStop(), message : ", str, TAG);
        this.mSnapData.stop("requestStop - SnapCoeditClient", str, false);
    }

    private void requestUploadNote(String str) {
        CoeditLogger.m8923i(TAG, "requestUploadNote(), message : " + str);
        new UploadNoteRunnable(this.mSnapData, this.mGrpcRunnableContract).run();
    }

    public SnapGrpcData getSnapData() {
        return this.mSnapData;
    }

    public synchronized void release() {
        try {
            GrpcRunnable grpcRunnable = this.mDownloadNoteRunnable;
            if (grpcRunnable != null) {
                grpcRunnable.interrupt();
                this.mDownloadNoteRunnable = null;
            }
            ExecutorService executorService = this.mMultiThreadPool;
            if (executorService != null) {
                executorService.shutdown();
                this.mMultiThreadPool = null;
            }
            SnapGrpcData snapGrpcData = this.mSnapData;
            if (snapGrpcData != null) {
                snapGrpcData.release();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void request(String str, int i) {
        try {
            if (i == 0) {
                requestStart(str);
            } else if (i != 4) {
                switch (i) {
                    case 101:
                        requestGetObjectUploadUrl(str);
                        break;
                    case 102:
                        requestUploadNote(str);
                        break;
                    case 103:
                        requestDownloadNote(str);
                        break;
                    case 104:
                        requestGetNoteLatestInfo(str);
                        break;
                    default:
                        CoeditLogger.m8924w(TAG, "request(), unexpected method: " + i + ", message : " + str);
                        break;
                }
            } else {
                requestStop(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
