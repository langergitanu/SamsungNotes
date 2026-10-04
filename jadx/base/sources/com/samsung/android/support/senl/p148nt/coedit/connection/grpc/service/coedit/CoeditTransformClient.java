package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformDataContract;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.ComposeRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.MultipleTransformRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.TransformRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.TransformWithMultipleRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditTransformClient {
    private static final String TAG = "CoeditTransformClient";
    private final GrpcRunnable.Contract mGrpcRunnableContract;
    private ExecutorService mThreadPool = AbstractC4539a.m3201k(TAG);
    private final CoeditTransformData mTransformData;

    public CoeditTransformClient(String str, String str2, String str3, String str4, String str5, String str6, String str7, CoeditTransformDataContract coeditTransformDataContract, GrpcRunnable.Contract contract) {
        CoeditTransformData coeditTransformData = new CoeditTransformData();
        this.mTransformData = coeditTransformData;
        coeditTransformData.initialize(str, str2, str3, str4, str5, str6, str7, coeditTransformDataContract);
        this.mGrpcRunnableContract = contract;
    }

    private void requestCompose(String str) {
        AbstractC8014b.m7223y("requestCompose(), COMPOSE message : ", str, TAG);
        if (this.mTransformData.isComposeRequestEmpty()) {
            return;
        }
        this.mThreadPool.execute(new ComposeRunnable(this.mTransformData, this.mGrpcRunnableContract));
    }

    private void requestMultipleTransform(String str) {
        AbstractC8014b.m7223y("requestMultipleTransform(), MULTIPLE TRANSFORM message : ", str, TAG);
        if (this.mThreadPool == null) {
            CoeditLogger.m8924w(TAG, "requestMultipleTransform(), failed, threadpool is invalid");
        } else {
            if (this.mTransformData.isMultipleTransformRequestEmpty()) {
                return;
            }
            this.mThreadPool.execute(new MultipleTransformRunnable(this.mTransformData, this.mGrpcRunnableContract));
        }
    }

    private void requestStart(String str) {
        AbstractC8014b.m7223y("requestStart(), message : ", str, TAG);
        this.mTransformData.start("requestStart - CoeditTransformClient");
    }

    private void requestStop(String str) {
        AbstractC8014b.m7223y("requestStop(), message : ", str, TAG);
        this.mTransformData.stop("requestStop - CoeditTransformClient", str, false);
    }

    private void requestTransform(String str) {
        AbstractC8014b.m7223y("requestTransform(), TRANSFORM message : ", str, TAG);
        if (this.mThreadPool == null) {
            CoeditLogger.m8924w(TAG, "requestTransform(), failed, threadpool is invalid");
        } else {
            if (this.mTransformData.isTransformRequestEmpty()) {
                return;
            }
            this.mThreadPool.execute(new TransformRunnable(this.mTransformData, this.mGrpcRunnableContract));
        }
    }

    private void requestTransformWithMultiple(String str) {
        AbstractC8014b.m7223y("requestTransformWithMultiple(), TRANSFORM WITH MULTIPLE message : ", str, TAG);
        if (this.mThreadPool == null) {
            CoeditLogger.m8924w(TAG, "requestTransformWithMultiple(), failed, threadpool is invalid");
        } else {
            if (this.mTransformData.isTransformWithMultipleRequestEmpty()) {
                return;
            }
            this.mThreadPool.execute(new TransformWithMultipleRunnable(this.mTransformData, this.mGrpcRunnableContract));
        }
    }

    public CoeditTransformData getTransformData() {
        return this.mTransformData;
    }

    public void refreshForReopen() {
        ExecutorService executorService = this.mThreadPool;
        if (executorService != null) {
            executorService.shutdown();
            this.mThreadPool = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        }
    }

    public void release() {
        CoeditTransformData coeditTransformData = this.mTransformData;
        if (coeditTransformData != null) {
            coeditTransformData.release();
        }
        ExecutorService executorService = this.mThreadPool;
        if (executorService != null) {
            executorService.shutdown();
            this.mThreadPool = null;
        }
    }

    public void request(String str, int i) {
        if (this.mTransformData.isInvalidStub()) {
            CoeditLogger.m8924w(TAG, "request(), failed, stub is invalid");
        }
        if (i == 0) {
            requestStart(str);
            return;
        }
        if (i == 4) {
            requestStop(str);
            return;
        }
        switch (i) {
            case 106:
                requestTransform(str);
                break;
            case 107:
                requestMultipleTransform(str);
                break;
            case 108:
                requestTransformWithMultiple(str);
                break;
            case 109:
                requestCompose(str);
                break;
            default:
                CoeditLogger.m8924w(TAG, "request(), unexpected message : " + str);
                break;
        }
    }
}
