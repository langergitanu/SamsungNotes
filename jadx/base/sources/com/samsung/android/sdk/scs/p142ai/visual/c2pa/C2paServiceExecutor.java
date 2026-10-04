package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.ConnectionHelper;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class C2paServiceExecutor extends ServiceExecutor {
    private static final String TAG = "ScsApi@C2PAServiceExecutor";
    private final IBinder.DeathRecipient deathRecipient;
    private IDpsC2pa mC2PAService;

    public C2paServiceExecutor(Context context) {
        super(context, 1, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.visual.c2pa.C2paServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(C2paServiceExecutor.TAG, "binderDied deathRecipient callback");
                C2paServiceExecutor.this.mC2PAService.asBinder().unlinkToDeath(C2paServiceExecutor.this.deathRecipient, 0);
            }
        };
    }

    public IDpsC2pa getC2PAService() {
        return this.mC2PAService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return ConnectionHelper.getC2PAServiceIntent();
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "onServiceConnected");
        IDpsC2pa iDpsC2paAsInterface = IDpsC2pa.Stub.asInterface(iBinder);
        this.mC2PAService = iDpsC2paAsInterface;
        try {
            iDpsC2paAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.m6485d(TAG, "onServiceDisconnected " + componentName);
        this.mC2PAService = null;
    }
}
