package com.microsoft.identity.common.internal.broker;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BoundServiceConnection implements ServiceConnection {
    private static final String TAG = "BoundServiceConnection";
    private final ResultFuture<IBinder> mFuture;

    public BoundServiceConnection(@NonNull ResultFuture<IBinder> resultFuture) {
        this.mFuture = resultFuture;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger.info(AbstractC0622a.m1170p(TAG, ":onServiceConnected", new StringBuilder()), componentName.getClassName() + " is connected.");
        this.mFuture.setResult(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@NonNull ComponentName componentName) {
        Logger.info(AbstractC0622a.m1170p(TAG, ":onServiceDisconnected", new StringBuilder()), componentName.getClassName() + " is disconnected.");
    }
}
