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
import com.samsung.android.visual.p167ai.sdkcommon.IDownloadCallback;
import com.samsung.android.visual.p167ai.sdkcommon.IDownloadService;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ModelDownloaderCoreExecutor extends ServiceExecutor {
    private static final String TAG = "ScsApi@ModelDownloaderCoreExecutor";
    private IBinder.DeathRecipient deathRecipient;
    private HashMap<String, IDownloadCallback.Stub> mCallbacks;
    private IDownloadService mDownloadService;

    public ModelDownloaderCoreExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.downloader.ModelDownloaderCoreExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(ModelDownloaderCoreExecutor.TAG, "binderDied deathRecipient callback");
                ModelDownloaderCoreExecutor.this.mDownloadService.asBinder().unlinkToDeath(ModelDownloaderCoreExecutor.this.deathRecipient, 0);
            }
        };
        this.mCallbacks = new HashMap<>();
    }

    public void addCallback(String str, IDownloadCallback.Stub stub) {
        this.mCallbacks.put(str, stub);
    }

    public IDownloadService getDownloadService() {
        return this.mDownloadService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return ConnectionHelper.getDownloadCoreServiceIntent();
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
        for (String str : this.mCallbacks.keySet()) {
            IDownloadCallback.Stub stubRemove = this.mCallbacks.remove(str);
            if (stubRemove != null) {
                try {
                    stubRemove.onError(str, "Service disconnected");
                } catch (RemoteException unused) {
                }
            }
        }
        this.mDownloadService = null;
    }

    public void removeCallback(String str) {
        this.mCallbacks.remove(str);
    }
}
