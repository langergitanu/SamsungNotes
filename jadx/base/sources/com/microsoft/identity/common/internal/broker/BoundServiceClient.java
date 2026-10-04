package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BoundServiceClient<T extends IInterface> {
    private static final int DEFAULT_BIND_TIMEOUT_IN_SECONDS = 30;
    private static final String TAG = "BoundServiceClient";
    private BoundServiceConnection mConnection;
    protected final Context mContext;
    private boolean mHasStartedBinding;
    private final String mTargetServiceClassName;
    private final String mTargetServiceIntentFilter;
    private final int mTimeOutInSeconds;

    public BoundServiceClient(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        this(context, str, str2, 30);
    }

    @NonNull
    private Intent getIntentForBoundService(@NonNull String str) {
        Intent intent = new Intent(this.mTargetServiceIntentFilter);
        intent.setPackage(str);
        intent.setClassName(str, this.mTargetServiceClassName);
        return intent;
    }

    @NonNull
    public T connect(@NonNull String str) throws BrokerCommunicationException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":connect", new StringBuilder());
        if (!isBoundServiceSupported(str)) {
            Logger.info(strM1170p, "Bound service is not supported.");
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, IIpcStrategy.Type.BOUND_SERVICE, "Bound service is not supported.", null);
        }
        ResultFuture resultFuture = new ResultFuture();
        this.mConnection = new BoundServiceConnection(resultFuture);
        boolean zBindService = this.mContext.bindService(getIntentForBoundService(str), this.mConnection, 1);
        this.mHasStartedBinding = zBindService;
        if (zBindService) {
            Logger.info(strM1170p, "Android is establishing the bound service connection.");
            return (T) getInterfaceFromIBinder((IBinder) resultFuture.get(this.mTimeOutInSeconds, TimeUnit.SECONDS));
        }
        Logger.info(strM1170p, "failed to bind. The service is not available.");
        throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, IIpcStrategy.Type.BOUND_SERVICE, "failed to bind. The service is not available.", null);
    }

    public void disconnect() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":disconnect", new StringBuilder());
        if (this.mHasStartedBinding) {
            try {
                this.mContext.unbindService(this.mConnection);
            } catch (IllegalArgumentException e) {
                Logger.error(strM1170p, "Error occurred while unbinding bound Service with ".concat(getClass().getSimpleName()), e);
            }
            this.mHasStartedBinding = false;
        }
    }

    @NonNull
    public abstract T getInterfaceFromIBinder(@NonNull IBinder iBinder);

    public boolean isBoundServiceSupported(@NonNull String str) {
        List<ResolveInfo> listQueryIntentServices = this.mContext.getPackageManager().queryIntentServices(getIntentForBoundService(str), 0);
        return listQueryIntentServices != null && listQueryIntentServices.size() > 0;
    }

    @Nullable
    public Bundle performOperation(@NonNull BrokerOperationBundle brokerOperationBundle) {
        return performOperationInternal(brokerOperationBundle, connect(brokerOperationBundle.getTargetBrokerAppPackageName()));
    }

    @Nullable
    public abstract Bundle performOperationInternal(@NonNull BrokerOperationBundle brokerOperationBundle, @NonNull T t);

    public BoundServiceClient(@NonNull Context context, @NonNull String str, @NonNull String str2, int i) {
        this.mContext = context;
        this.mTimeOutInSeconds = i;
        this.mTargetServiceClassName = str;
        this.mTargetServiceIntentFilter = str2;
    }
}
