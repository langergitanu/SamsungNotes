package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BoundServiceClient;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.logging.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BoundServiceStrategy<T extends IInterface> extends AbstractIpcStrategyWithServiceValidation {
    private static final String TAG = "BoundServiceStrategy";
    private final BoundServiceClient<T> mClient;

    public BoundServiceStrategy(@NonNull BoundServiceClient<T> boundServiceClient) {
        super(false);
        this.mClient = boundServiceClient;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.AbstractIpcStrategyWithServiceValidation
    @Nullable
    public Bundle communicateToBrokerAfterValidation(@NonNull BrokerOperationBundle brokerOperationBundle) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":communicateToBroker", new StringBuilder());
        StringBuilder sbM15l = AbstractC0000a.m15l("Broker operation: ", brokerOperationBundle.getOperation().name(), " brokerPackage: ");
        sbM15l.append(brokerOperationBundle.getTargetBrokerAppPackageName());
        Logger.info(strM1170p, sbM15l.toString());
        try {
            try {
                return this.mClient.performOperation(brokerOperationBundle);
            } finally {
                this.mClient.disconnect();
            }
        } catch (RemoteException | InterruptedException | RuntimeException | ExecutionException | TimeoutException e) {
            String strConcat = "Error occurred while awaiting (get) return of bound Service with ".concat(this.mClient.getClass().getSimpleName());
            Logger.error(strM1170p, strConcat, e);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), strConcat, e);
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    @NonNull
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.BOUND_SERVICE;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(@NonNull String str) {
        return this.mClient.isBoundServiceSupported(str);
    }

    @VisibleForTesting
    public BoundServiceStrategy(@NonNull BoundServiceClient<T> boundServiceClient, boolean z) {
        super(z);
        this.mClient = boundServiceClient;
    }
}
