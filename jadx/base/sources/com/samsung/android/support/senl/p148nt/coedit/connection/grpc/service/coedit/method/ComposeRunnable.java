package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditOtMessage.ComposeRequest;
import coeditOtMessage.ComposeResponse;
import coeditOtMessage.IdxCedOpsPair;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposeRunnable extends GrpcRunnable {
    private static final String TAG = "ComposeRunnable";
    private final CoeditTransformData mData;

    public ComposeRunnable(@NonNull CoeditTransformData coeditTransformData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditTransformData;
    }

    private void printRequest(String str, ComposeRequest composeRequest) {
        if (composeRequest == null) {
            CoeditLogger.m8920e(TAG, "Request# invalid request, requestId: " + str);
            return;
        }
        CoeditLogger.m8923i(TAG, "Request# requestId: " + str);
        CoeditLogger.m8923i(TAG, "Request# pairsCount: " + composeRequest.getPairsCount());
        Iterator<IdxCedOpsPair> it = composeRequest.getPairsList().iterator();
        while (it.hasNext()) {
            OtDetectionLogger.printIdxCedOpsPair(this, "Request", it.next());
        }
    }

    private void printResponse(ComposeResponse composeResponse) {
        if (composeResponse == null) {
            CoeditLogger.m8920e(TAG, "Response# invalid request");
            return;
        }
        boolean zHasPairs = composeResponse.hasPairs();
        CoeditLogger.m8923i(TAG, "Response# hasPairs: " + zHasPairs);
        if (zHasPairs) {
            OtDetectionLogger.printIdxCedOpsPair(this, "Response", composeResponse.getPairs());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        super.run();
        if (this.mData.isComposeRequestEmpty()) {
            this.mData.releaseLock("ComposeRunnable, Warning request is empty");
            return;
        }
        String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
        try {
            ComposeRequest composeRequestTakeComposeRequest = this.mData.takeComposeRequest();
            printRequest(requestNumber, composeRequestTakeComposeRequest);
            ComposeResponse composeResponseCompose = this.mData.compose(requestNumber, composeRequestTakeComposeRequest);
            printResponse(composeResponseCompose);
            this.mData.putComposeResponse(composeResponseCompose);
            this.mData.releaseLock("ComposeRunnable, Success");
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, AbstractC0000a.m15l("Failed to compose, requestId: [", requestNumber, "], error: "), TAG);
            this.mData.reconnect(getTag() + " error: " + e.getMessage());
            CoeditTransformData coeditTransformData = this.mData;
            StringBuilder sb = new StringBuilder("ComposeRunnable, Error, ");
            sb.append(e.getMessage());
            coeditTransformData.releaseLock(sb.toString());
        }
    }
}
