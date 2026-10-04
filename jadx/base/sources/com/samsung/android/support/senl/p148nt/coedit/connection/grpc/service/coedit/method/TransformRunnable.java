package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditOtMessage.TransformRequest;
import coeditOtMessage.TransformResponse;
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
public class TransformRunnable extends GrpcRunnable {
    private static final String TAG = "TransformRunnable";
    private final CoeditTransformData mData;

    public TransformRunnable(@NonNull CoeditTransformData coeditTransformData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditTransformData;
    }

    private void printRequest(String str, TransformRequest transformRequest) {
        if (transformRequest == null) {
            CoeditLogger.m8920e(TAG, "Request# invalid request, requestId: " + str);
        } else {
            StringBuilder sbM15l = AbstractC0000a.m15l("Request# requestId: ", str, ", requestByte Size: ");
            sbM15l.append(transformRequest.toString().getBytes(StandardCharsets.UTF_8).length);
            CoeditLogger.m8923i(TAG, sbM15l.toString());
            OtDetectionLogger.printIdxCedOpsPair(this, "Request/FirstOp", transformRequest.getFirst());
            OtDetectionLogger.printIdxCedOpsPair(this, "Request/SecondOp", transformRequest.getSecond());
        }
    }

    private void printResponse(TransformResponse transformResponse) {
        if (transformResponse == null) {
            CoeditLogger.m8920e(TAG, "Response# invalid request");
        } else {
            OtDetectionLogger.printIdxCedOpsPair(this, "Response/FirstTransformedOp", transformResponse.getFirstTransformed());
            OtDetectionLogger.printIdxCedOpsPair(this, "Response/SecondTransformedOp", transformResponse.getSecondTransformed());
        }
    }

    private void retryTransform(TransformRequest transformRequest, TransformResponse transformResponse) {
        if (transformRequest == null || transformResponse != null || this.mData.needBlockCoedit(getRetryCount())) {
            return;
        }
        try {
            increaseRetryCount();
            this.mData.putTransformRequest(transformRequest);
            Thread.sleep(1000L);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("retryTransform, Failed reason: "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        TransformResponse transformResponseTransform;
        Exception e;
        TransformRequest transformRequestTakeTransformRequest;
        super.run();
        while (!this.mData.isTransformRequestEmpty()) {
            try {
                try {
                    transformRequestTakeTransformRequest = this.mData.takeTransformRequest();
                    try {
                        try {
                            String requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                            printRequest(requestNumber, transformRequestTakeTransformRequest);
                            transformResponseTransform = this.mData.transform(requestNumber, transformRequestTakeTransformRequest);
                        } catch (TimeoutException e2) {
                            e = e2;
                            CoeditLogger.m8920e(TAG, "Failed to Transform. " + e.getMessage());
                            showToast("Transform, Timeout, " + e.getMessage());
                            retryTransform(transformRequestTakeTransformRequest, null);
                            if (this.mData.isTransformRequestEmpty()) {
                            }
                        }
                    } catch (Exception e3) {
                        transformResponseTransform = null;
                        e = e3;
                    }
                    try {
                        printResponse(transformResponseTransform);
                        this.mData.putTransformResponse(transformResponseTransform);
                    } catch (Exception e5) {
                        e = e5;
                        CoeditLogger.m8920e(TAG, "Failed to Transform. " + e.getMessage());
                        if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(e.getMessage())) {
                            retryTransform(transformRequestTakeTransformRequest, transformResponseTransform);
                        } else if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(e.getMessage())) {
                            this.mData.reconnect(e.getMessage());
                            this.mData.releaseLock(CoeditServiceConstants.ConcurrencyError.MULTIPLE_TRANSFORM_FAILED);
                        } else {
                            this.mData.releaseLock(CoeditServiceConstants.ConcurrencyError.MULTIPLE_TRANSFORM_FAILED);
                        }
                        if (this.mData.isTransformRequestEmpty()) {
                        }
                    }
                } catch (Throwable th) {
                    if (this.mData.isTransformRequestEmpty()) {
                        this.mData.releaseLock("TransformWithMultiple response");
                    }
                    throw th;
                }
            } catch (TimeoutException e6) {
                e = e6;
                transformRequestTakeTransformRequest = null;
            } catch (Exception e7) {
                transformResponseTransform = null;
                e = e7;
                transformRequestTakeTransformRequest = null;
            }
            if (this.mData.isTransformRequestEmpty()) {
                this.mData.releaseLock("TransformWithMultiple response");
            }
        }
    }
}
