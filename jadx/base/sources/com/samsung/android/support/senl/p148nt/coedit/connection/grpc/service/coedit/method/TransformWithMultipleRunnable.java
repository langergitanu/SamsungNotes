package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method;

import androidx.annotation.NonNull;
import coeditOtMessage.TransformWithMultipleRequest;
import coeditOtMessage.TransformWithMultipleResponse;
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
public class TransformWithMultipleRunnable extends GrpcRunnable {
    private static final String TAG = "TransformWithMultipleRunnable";
    private final CoeditTransformData mData;

    public TransformWithMultipleRunnable(@NonNull CoeditTransformData coeditTransformData, GrpcRunnable.Contract contract) {
        super(contract);
        this.mData = coeditTransformData;
    }

    private void printRequest(String str, TransformWithMultipleRequest transformWithMultipleRequest) {
        if (transformWithMultipleRequest == null) {
            CoeditLogger.m8920e(TAG, "Request# invalid request, requestId: " + str);
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("Request# requestId: ", str, ", requestByte Size: ");
        sbM15l.append(transformWithMultipleRequest.toString().getBytes(StandardCharsets.UTF_8).length);
        CoeditLogger.m8923i(TAG, sbM15l.toString());
        OtDetectionLogger.printIdxCedOpsPair(this, "Request/FirstOp", transformWithMultipleRequest.getFirst());
        int secondCount = transformWithMultipleRequest.getSecondCount();
        CoeditLogger.m8923i(TAG, "Request# SecondOpCount: " + secondCount);
        for (int i = 0; i < secondCount; i++) {
            OtDetectionLogger.printIdxCedOpsPair(this, "Request/SecondOp", transformWithMultipleRequest.getSecond(i));
        }
    }

    private void printResponse(TransformWithMultipleResponse transformWithMultipleResponse) {
        if (transformWithMultipleResponse == null) {
            CoeditLogger.m8920e(TAG, "Response# invalid response");
            return;
        }
        OtDetectionLogger.printIdxCedOpsPair(this, "Response/FirstTransformedOp", transformWithMultipleResponse.getFirst());
        int secondCount = transformWithMultipleResponse.getSecondCount();
        CoeditLogger.m8923i(TAG, "Response# SecondTransformedOpCount: " + secondCount);
        for (int i = 0; i < secondCount; i++) {
            OtDetectionLogger.printIdxCedOpsPair(this, "Response/SecondTransformedOp", transformWithMultipleResponse.getSecond(i));
        }
    }

    private void retryTransformWithMultiple(TransformWithMultipleRequest transformWithMultipleRequest, TransformWithMultipleResponse transformWithMultipleResponse) {
        if (transformWithMultipleRequest == null || transformWithMultipleResponse != null || this.mData.needBlockCoedit(getRetryCount())) {
            return;
        }
        try {
            increaseRetryCount();
            this.mData.putTransformWithMultipleRequest(transformWithMultipleRequest);
            Thread.sleep(1000L);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("retryTransformWithMultiple, Failed reason: "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util.OtDetectionListener
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.grpc.task.GrpcRunnable, java.lang.Runnable
    public void run() {
        TransformWithMultipleResponse transformWithMultipleResponseTransform;
        Exception e;
        TransformWithMultipleRequest transformWithMultipleRequestTakeTransformWithMultipleRequest;
        String requestNumber;
        boolean zIsTransformWithMultipleRequestEmpty;
        super.run();
        while (!this.mData.isTransformWithMultipleRequestEmpty()) {
            try {
                try {
                    transformWithMultipleRequestTakeTransformWithMultipleRequest = this.mData.takeTransformWithMultipleRequest();
                    try {
                        try {
                            requestNumber = CoeditUtils.getRequestNumber(this.mData.getWorkspaceId());
                            printRequest(requestNumber, transformWithMultipleRequestTakeTransformWithMultipleRequest);
                        } catch (TimeoutException e2) {
                            e = e2;
                            CoeditLogger.m8920e(TAG, "Failed to TransformWithMultiple. " + e.getMessage());
                            showToast("TransformWithMultiple, Timeout, " + e.getMessage());
                            retryTransformWithMultiple(transformWithMultipleRequestTakeTransformWithMultipleRequest, null);
                            if (this.mData.isTransformWithMultipleRequestEmpty()) {
                            }
                        }
                    } catch (Exception e3) {
                        transformWithMultipleResponseTransform = null;
                        e = e3;
                    }
                } finally {
                    if (this.mData.isTransformWithMultipleRequestEmpty()) {
                        this.mData.releaseLock("TransformWithMultiple response");
                    }
                }
            } catch (TimeoutException e5) {
                e = e5;
                transformWithMultipleRequestTakeTransformWithMultipleRequest = null;
            } catch (Exception e6) {
                transformWithMultipleResponseTransform = null;
                e = e6;
                transformWithMultipleRequestTakeTransformWithMultipleRequest = null;
            }
            if (transformWithMultipleRequestTakeTransformWithMultipleRequest.hasFirst() && !transformWithMultipleRequestTakeTransformWithMultipleRequest.getSecondList().isEmpty()) {
                transformWithMultipleResponseTransform = this.mData.transform(requestNumber, transformWithMultipleRequestTakeTransformWithMultipleRequest);
                try {
                    printResponse(transformWithMultipleResponseTransform);
                    this.mData.putTransformWithMultipleResponse(transformWithMultipleResponseTransform);
                } catch (Exception e7) {
                    e = e7;
                    CoeditLogger.m8920e(TAG, "Failed to TransformWithMultiple. " + e.getMessage());
                    if (CoeditServiceConstants.ServerResponseCode.isRetryNeeded(e.getMessage())) {
                        retryTransformWithMultiple(transformWithMultipleRequestTakeTransformWithMultipleRequest, transformWithMultipleResponseTransform);
                    } else if (CoeditServiceConstants.ServerResponseCode.isConnectNeeded(e.getMessage())) {
                        this.mData.reconnect(e.getMessage());
                        retryTransformWithMultiple(transformWithMultipleRequestTakeTransformWithMultipleRequest, transformWithMultipleResponseTransform);
                    } else {
                        this.mData.releaseLock(CoeditServiceConstants.ConcurrencyError.MULTIPLE_TRANSFORM_FAILED);
                    }
                    if (this.mData.isTransformWithMultipleRequestEmpty()) {
                    }
                }
                if (this.mData.isTransformWithMultipleRequestEmpty()) {
                    this.mData.releaseLock("TransformWithMultiple response");
                }
            }
            this.mData.releaseLock("TransformWithMultipleRunnable no one list");
            if (zIsTransformWithMultipleRequestEmpty) {
                return;
            } else {
                return;
            }
        }
    }
}
