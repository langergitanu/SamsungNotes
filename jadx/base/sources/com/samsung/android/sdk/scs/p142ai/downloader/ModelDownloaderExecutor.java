package com.samsung.android.sdk.scs.p142ai.downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.ConnectionHelper;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.visual.p167ai.sdkcommon.cloudcore.IDownloadService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ModelDownloaderExecutor extends ServiceExecutor {
    private static final String TAG = "ScsApi@ModelDownloaderExecutor";
    private IBinder.DeathRecipient deathRecipient;
    private IDownloadService mDownloadService;

    public ModelDownloaderExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.downloader.ModelDownloaderExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(ModelDownloaderExecutor.TAG, "binderDied deathRecipient callback");
                ModelDownloaderExecutor.this.mDownloadService.asBinder().unlinkToDeath(ModelDownloaderExecutor.this.deathRecipient, 0);
            }
        };
    }

    public IDownloadService getDownloadService() {
        return this.mDownloadService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return ConnectionHelper.getDownloadServiceIntent();
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "onServiceConnected");
        IDownloadService iDownloadServiceAsInterface = IDownloadService.Stub.asInterface(iBinder);
        this.mDownloadService = iDownloadServiceAsInterface;
        try {
            iDownloadServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.m6485d(TAG, "onServiceDisconnected " + componentName);
        this.mDownloadService = null;
    }
}
