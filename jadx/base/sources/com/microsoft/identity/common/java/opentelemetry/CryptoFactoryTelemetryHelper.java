package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.java.crypto.ICryptoFactory;
import com.microsoft.identity.common.java.exception.IErrorInformation;
import com.microsoft.identity.common.java.util.ThrowableUtil;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CryptoFactoryTelemetryHelper {
    private static final LongCounter sFailedCryptoOperationCount = OTelUtility.createLongCounter("failed_crypto_operation_count", "Number of failed crypto operations");

    private static String getCryptoOperationEventName(@NonNull CryptoObjectName cryptoObjectName, @NonNull String str) {
        if (cryptoObjectName == null) {
            throw new NullPointerException("operationName is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        return cryptoObjectName.name() + "_" + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T performCryptoOperationAndUploadTelemetry(@NonNull CryptoObjectName cryptoObjectName, @NonNull String str, @NonNull ICryptoFactory iCryptoFactory, @NonNull ICryptoOperation<T> iCryptoOperation) throws Exception {
        if (cryptoObjectName == null) {
            throw new NullPointerException("operationName is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("algorithmName is marked non-null but is null");
        }
        if (iCryptoFactory == null) {
            throw new NullPointerException("cryptoFactory is marked non-null but is null");
        }
        if (iCryptoOperation == null) {
            throw new NullPointerException("cryptoOperation is marked non-null but is null");
        }
        try {
            return iCryptoOperation.perform();
        } catch (Exception e) {
            sFailedCryptoOperationCount.add(1L, Attributes.m13787of(AttributeKey.stringKey(AttributeName.crypto_controller.name()), iCryptoFactory.getTelemetryClassName().name(), AttributeKey.stringKey(AttributeName.crypto_operation.name()), getCryptoOperationEventName(cryptoObjectName, str), AttributeKey.stringKey(AttributeName.error_type.name()), e.getClass().getSimpleName(), AttributeKey.stringKey(AttributeName.error_code.name()), e instanceof IErrorInformation ? ((IErrorInformation) e).getErrorCode() : "N/A", AttributeKey.stringKey(AttributeName.crypto_exception_stack_trace.name()), ThrowableUtil.getStackTraceAsString(e)));
            throw e;
        }
    }
}
