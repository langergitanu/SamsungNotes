package com.microsoft.identity.common.internal.controllers;

import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.internal.util.FindBugsConstants;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.marker.CodeMarkerManager;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerOperationExecutor {
    private static final String TAG = "BrokerOperationExecutor";
    private final ActiveBrokerCacheUpdater mCacheUpdaterManager;
    private final List<IIpcStrategy> mStrategies;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BrokerOperation<T> {
        @NonNull
        T extractResultBundle(@Nullable Bundle bundle);

        @NonNull
        BrokerOperationBundle getBundle();

        @NonNull
        String getMethodName();

        @Nullable
        String getTelemetryApiId();

        void performPrerequisites(@NonNull IIpcStrategy iIpcStrategy);

        void putValueInSuccessEvent(@NonNull ApiEndEvent apiEndEvent, @NonNull T t);
    }

    public BrokerOperationExecutor(@NonNull List<IIpcStrategy> list, @NonNull ActiveBrokerCacheUpdater activeBrokerCacheUpdater) {
        if (list == null) {
            throw new NullPointerException("strategies is marked non-null but is null");
        }
        if (activeBrokerCacheUpdater == null) {
            throw new NullPointerException("cacheUpdaterManager is marked non-null but is null");
        }
        this.mStrategies = list;
        this.mCacheUpdaterManager = activeBrokerCacheUpdater;
    }

    private <U> void emitOperationFailureEvent(@NonNull BrokerOperation<U> brokerOperation, BaseException baseException) {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        String telemetryApiId = brokerOperation.getTelemetryApiId();
        if (StringUtil.isNullOrEmpty(telemetryApiId)) {
            return;
        }
        Telemetry.emit(new ApiEndEvent().putException(baseException).putApiId(telemetryApiId));
    }

    private <T extends CommandParameters, U> void emitOperationStartEvent(@Nullable T t, @NonNull BrokerOperation<U> brokerOperation) {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        String telemetryApiId = brokerOperation.getTelemetryApiId();
        if (StringUtil.isNullOrEmpty(telemetryApiId)) {
            return;
        }
        Telemetry.emit(new ApiStartEvent().putProperties(t).putApiId(telemetryApiId));
    }

    @SuppressFBWarnings({FindBugsConstants.NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE})
    private <U> void emitOperationSuccessEvent(@NonNull BrokerOperation<U> brokerOperation, U u) {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        String telemetryApiId = brokerOperation.getTelemetryApiId();
        if (telemetryApiId != null) {
            ApiEndEvent apiEndEvent = (ApiEndEvent) new ApiEndEvent().putApiId(telemetryApiId).isApiCallSuccessful(Boolean.TRUE);
            brokerOperation.putValueInSuccessEvent(apiEndEvent, u);
            Telemetry.emit(apiEndEvent);
        }
    }

    private <T> T performStrategy(@NonNull IIpcStrategy iIpcStrategy, @NonNull BrokerOperation<T> brokerOperation) {
        if (iIpcStrategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        Logger.info(TAG + brokerOperation.getMethodName(), "Executing with IIpcStrategy: ".concat(iIpcStrategy.getClass().getSimpleName()));
        Span spanCreateSpan = OTelUtility.createSpan(SpanName.MSAL_PerformIpcStrategy.name());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpan);
            try {
                spanCreateSpan.setAttribute(AttributeName.ipc_strategy.name(), iIpcStrategy.getType().name());
                spanCreateSpan.setAttribute(AttributeName.broker_operation_name.name(), brokerOperation.getMethodName());
                brokerOperation.performPrerequisites(iIpcStrategy);
                Bundle bundleCommunicateToBroker = iIpcStrategy.communicateToBroker(brokerOperation.getBundle());
                this.mCacheUpdaterManager.updateCachedActiveBrokerFromResultBundle(bundleCommunicateToBroker);
                spanCreateSpan.setStatus(StatusCode.OK);
                T tExtractResultBundle = brokerOperation.extractResultBundle(bundleCommunicateToBroker);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                return tExtractResultBundle;
            } finally {
            }
        } finally {
        }
    }

    public <T extends CommandParameters, U> U execute(@Nullable T t, @NonNull BrokerOperation<U> brokerOperation) throws BaseException {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        CodeMarkerManager codeMarkerManager = CodeMarkerManager.getInstance();
        codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.BROKER_OPERATION_EXECUTION_START);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":execute", new StringBuilder());
        emitOperationStartEvent(t, brokerOperation);
        if (this.mStrategies.size() == 0) {
            ClientException clientException = new ClientException("Failed to bind the service in broker app", "No strategies can be used to connect to the broker.");
            emitOperationFailureEvent(brokerOperation, clientException);
            throw clientException;
        }
        ArrayList<BrokerCommunicationException> arrayList = new ArrayList();
        for (IIpcStrategy iIpcStrategy : this.mStrategies) {
            try {
                codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.BROKER_PROCESS_START);
                U u = (U) performStrategy(iIpcStrategy, brokerOperation);
                codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.BROKER_PROCESS_END);
                emitOperationSuccessEvent(brokerOperation, u);
                return u;
            } catch (BrokerCommunicationException e) {
                arrayList.add(e);
            } catch (BaseException e2) {
                emitOperationFailureEvent(brokerOperation, e2);
                throw e2;
            }
        }
        ClientException clientException2 = new ClientException("Failed to bind the service in broker app", "Unable to connect to the broker. Please refer to MSAL/Broker logs or suppressed exception (API 19+) for more details.");
        for (BrokerCommunicationException brokerCommunicationException : arrayList) {
            com.microsoft.identity.common.logging.Logger.error(strM1170p, brokerCommunicationException.getMessage(), brokerCommunicationException);
            clientException2.addSuppressedException(brokerCommunicationException);
        }
        emitOperationFailureEvent(brokerOperation, clientException2);
        throw clientException2;
    }
}
