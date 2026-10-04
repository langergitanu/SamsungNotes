package com.samsung.android.sdk.scs.p142ai.language.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IOnDeviceService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@Deprecated
public class OnDeviceServiceExecutor extends ServiceExecutor {
    private static final String TAG = "OnDeviceServiceExecutor";
    public final Context context;
    private final IBinder.DeathRecipient deathRecipient;
    private IOnDeviceService onDeviceService;

    public OnDeviceServiceExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.language.service.OnDeviceServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(OnDeviceServiceExecutor.TAG, "binderDied deathRecipient callback");
                OnDeviceServiceExecutor.this.onDeviceService.asBinder().unlinkToDeath(OnDeviceServiceExecutor.this.deathRecipient, 0);
            }
        };
        this.context = context.getApplicationContext();
    }

    public IOnDeviceService getService() {
        return this.onDeviceService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return AbstractC2821a.m2214e("android.intellivoiceservice.OnDeviceService", BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "onServiceConnected");
        IOnDeviceService iOnDeviceServiceAsInterface = IOnDeviceService.Stub.asInterface(iBinder);
        this.onDeviceService = iOnDeviceServiceAsInterface;
        try {
            iOnDeviceServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        this.onDeviceService = null;
    }
}
