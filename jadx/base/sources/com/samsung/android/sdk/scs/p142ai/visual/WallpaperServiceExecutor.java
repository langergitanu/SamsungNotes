package com.samsung.android.sdk.scs.p142ai.visual;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.ConnectionHelper;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class WallpaperServiceExecutor extends ServiceExecutor {
    private static final String TAG = "ScsApi@WallpaperServiceExecutor";
    private IBinder.DeathRecipient deathRecipient;
    private IWallpaperService mWallpaperService;

    public WallpaperServiceExecutor(Context context) {
        super(context, 1, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.visual.WallpaperServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(WallpaperServiceExecutor.TAG, "binderDied deathRecipient callback");
                WallpaperServiceExecutor.this.mWallpaperService.asBinder().unlinkToDeath(WallpaperServiceExecutor.this.deathRecipient, 0);
            }
        };
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return ConnectionHelper.getWallpaperServiceIntent();
    }

    public IWallpaperService getWallpaperService() {
        return this.mWallpaperService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "onServiceConnected");
        IWallpaperService iWallpaperServiceAsInterface = IWallpaperService.Stub.asInterface(iBinder);
        this.mWallpaperService = iWallpaperServiceAsInterface;
        try {
            iWallpaperServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.m6485d(TAG, "onServiceDisconnected " + componentName);
        this.mWallpaperService = null;
    }
}
