package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditOtMessage.MultipleTransformRequest;
import coeditOtMessage.MultipleTransformResponse;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.data.CoeditTransformData;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionLogger;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MultipleTransformRunnable extends GrpcRunnable {
    private static final String TAG = "MultipleTransformRunnable";
    private final CoeditTransformData mData;

    public MultipleTransformRunnable(@NonNull CoeditTransformData coeditTransformData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditTransformData;
    }

    private void printRequest(String str, MultipleTransformRequest multipleTransformRequest) {
        if (multipleTransformRequest == null) {
            CoeditLogger.m8920e(TAG, "Request# invalid request, requestId: " + str);
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("Request# requestId: ", str, ", requestByte Size: ");
        sbM15l.append(multipleTransformRequest.toString().getBytes(StandardCharsets.UTF_8).length);
        CoeditLogger.m8923i(TAG, sbM15l.toString());
        int firstCount = multipleTransformRequest.getFirstCount();
        CoeditLogger.m8923i(TAG, "Request# FirstOpCount: " + firstCount);
        for (int i = 0; i < firstCount; i++) {
            OtDetectionLogger.printIdxCedOpsPair(this, "Request/FirstOp", multipleTransformRequest.getFirst(i));
        }
        OtDetectionLogger.printIdxCedOpsPair(this, "Request/SecondOp", multipleTransformRequest.getSecond());
    }

    private void printResponse(MultipleTransformResponse multipleTransformResponse) {
        if (multipleTransformResponse == null) {
            CoeditLogger.m8920e(TAG, "printResponse# invalid response");
            return;
        }
        int firstCount = multipleTransformResponse.getFirstCount();
        CoeditLogger.m8923i(TAG, "Response# FirstTransformedOpCount: " + firstCount);
        for (int i = 0; i < firstCount; i++) {
            OtDetectionLogger.printIdxCedOpsPair(this, "Response/FirstTransformedOp", multipleTransformResponse.getFirst(i));
        }
        OtDetectionLogger.printIdxCedOpsPair(this, "Response/SecondTransformedOp", multipleTransformResponse.getSecond());
    }

    private void retryMultipleTransform(String str, MultipleTransformRequest multipleTransformRequest, MultipleTransformResponse multipleTransformResponse) {
        if (multipleTransformRequest == null || multipleTransformResponse != null) {
            return;
        }
        if (3 <= getRetryCount()) {
            this.mData.setPausedByNetwork(getTag() + " exceed retry count");
            this.mData.releaseLock("retryMultipleTransform response");
            return;
        }
        try {
            CoeditLogger.m8919d(TAG, "retryMultipleTransform");
            increaseRetryCount();
            printRequest(str, multipleTransformRequest);
            this.mData.putMultipleTransformRequest(multipleTransformRequest);
            Thread.sleep(1000L);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("retryMultipleTransform, Failed reason: "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        MultipleTransformResponse multipleTransformResponseTransform;
        Exception e;
        MultipleTransformRequest multipleTransformRequestTakeMultipleTransformRequest;
        boolean zIsMultipleTransformRequestEmpty;
        super.run();
        while (!this.mData.isMultipleTransformRequestEmpty()) {
            String requestNumber = "";
            try {
                try {
                    multipleTransformRequestTakeMultipleTransformRequest = this.mData.takeMultipleTransformRequest();
                    try {
                        try {
                            requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                            printRequest(requestNumber, multipleTransformRequestTakeMultipleTransformRequest);
                        } catch (TimeoutException e2) {
                            e = e2;
                            CoeditLogger.m8920e(TAG, "Failed to MultipleTransform. " + e.getMessage());
                            retryMultipleTransform(requestNumber, multipleTransformRequestTakeMultipleTransformRequest, null);
                            if (this.mData.isMultipleTransformRequestEmpty()) {
                            }
                        }
                    } catch (Exception e3) {
                        multipleTransformResponseTransform = null;
                        e = e3;
                    }
                } finally {
                    if (this.mData.isMultipleTransformRequestEmpty()) {
                        this.mData.releaseLock("MultipleTransform response");
                    }
                }
            } catch (TimeoutException e5) {
                e = e5;
                multipleTransformRequestTakeMultipleTransformRequest = null;
            } catch (Exception e6) {
                multipleTransformResponseTransform = null;
                e = e6;
                multipleTransformRequestTakeMultipleTransformRequest = null;
            }
            if (!multipleTransformRequestTakeMultipleTransformRequest.getFirstOrBuilderList().isEmpty() && multipleTransformRequestTakeMultipleTransformRequest.hasSecond()) {
                multipleTransformResponseTransform = this.mData.transform(requestNumber, multipleTransformRequestTakeMultipleTransformRequest);
                try {
                    printResponse(multipleTransformResponseTransform);
                    this.mData.putMultipleTransformResponse(multipleTransformResponseTransform);
                } catch (Exception e7) {
                    e = e7;
                    CoeditLogger.m8920e(TAG, "Failed to MultipleTransform. " + e.getMessage());
                    if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(e.getMessage())) {
                        retryMultipleTransform(requestNumber, multipleTransformRequestTakeMultipleTransformRequest, multipleTransformResponseTransform);
                    } else if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(e.getMessage())) {
                        this.mData.reconnect(e.getMessage());
                        retryMultipleTransform(requestNumber, multipleTransformRequestTakeMultipleTransformRequest, multipleTransformResponseTransform);
                    } else {
                        this.mData.releaseLock(CoeditServiceConstants.ConcurrencyError.MULTIPLE_TRANSFORM_FAILED);
                    }
                    if (this.mData.isMultipleTransformRequestEmpty()) {
                    }
                }
                if (this.mData.isMultipleTransformRequestEmpty()) {
                    this.mData.releaseLock("MultipleTransform response");
                }
            }
            this.mData.releaseLock("MultipleTransformRunnable no one list");
            if (zIsMultipleTransformRequestEmpty) {
                return;
            } else {
                return;
            }
        }
    }
}
