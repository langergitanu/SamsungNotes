package com.samsung.android.sdk.scs.p142ai.gateway;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AiServiceExecutor<T extends IInterface> extends ServiceExecutor {
    private static final String TAG = "AiServiceExecutor";
    protected final Context context;
    private final Function<IBinder, T> creator;
    private final IBinder.DeathRecipient deathRecipient;
    private T service;
    private final String serviceAction;
    private final String servicePackage;
    private final AiServiceExecutorFactory.ServiceType serviceType;

    public AiServiceExecutor(@NonNull Context context, @NonNull AiServiceExecutorFactory.ServiceType serviceType, @NonNull Function<IBinder, T> function, @NonNull String str, @NonNull String str2) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.gateway.AiServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(AiServiceExecutor.TAG, "binderDied deathRecipient callback");
                AiServiceExecutor.this.service.asBinder().unlinkToDeath(AiServiceExecutor.this.deathRecipient, 0);
            }
        };
        this.context = context.getApplicationContext();
        this.serviceType = serviceType;
        this.creator = function;
        this.serviceAction = str;
        this.servicePackage = str2;
    }

    @NonNull
    public T getService() {
        return this.service;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    @NonNull
    public Intent getServiceIntent() {
        Intent intent = new Intent(this.serviceAction);
        intent.setPackage(this.servicePackage);
        return intent;
    }

    @NonNull
    public String getServicePackage() {
        return this.servicePackage;
    }

    @NonNull
    public AiServiceExecutorFactory.ServiceType getServiceType() {
        return this.serviceType;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "onServiceConnected");
        T t = (T) new AiServiceFactory(this.creator).createService(iBinder);
        this.service = t;
        try {
            t.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        this.service = null;
    }
}
