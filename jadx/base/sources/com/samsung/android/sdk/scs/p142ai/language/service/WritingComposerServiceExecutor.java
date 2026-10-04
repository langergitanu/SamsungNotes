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
import com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class WritingComposerServiceExecutor extends ServiceExecutor {
    private static final String TAG = "WritingComposerServiceExecutor";
    public final Context context;
    private final IBinder.DeathRecipient deathRecipient;
    private IWritingComposerService mService;

    public WritingComposerServiceExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.language.service.WritingComposerServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(WritingComposerServiceExecutor.TAG, "binderDied deathRecipient callback");
                WritingComposerServiceExecutor.this.mService.asBinder().unlinkToDeath(WritingComposerServiceExecutor.this.deathRecipient, 0);
            }
        };
        this.context = context.getApplicationContext();
    }

    public IWritingComposerService getService() {
        return this.mService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return AbstractC2821a.m2214e(BaseConstants.SERVICE_ACTION.ACTION_WRITING_COMPOSER_SERVICE, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "onServiceConnected");
        IWritingComposerService iWritingComposerServiceAsInterface = IWritingComposerService.Stub.asInterface(iBinder);
        this.mService = iWritingComposerServiceAsInterface;
        try {
            iWritingComposerServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        this.mService = null;
    }
}
