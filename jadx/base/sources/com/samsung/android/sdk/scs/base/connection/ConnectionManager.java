package com.samsung.android.sdk.scs.base.connection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class ConnectionManager {
    private static final String TAG = "ScsApi@ConnectionManager";
    private Context mContext;
    private InternalServiceConnectionListener mInternalServiceConnectionListener;
    private boolean mIsConnected = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.samsung.android.sdk.scs.base.connection.ConnectionManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.m6485d(ConnectionManager.TAG, "onServiceConnected " + componentName);
            ConnectionManager.this.notifyServiceConnection(1, componentName, iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.m6485d(ConnectionManager.TAG, "onServiceDisconnected " + componentName);
            ConnectionManager.this.notifyServiceConnection(2, null, null);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyServiceConnection(int i, ComponentName componentName, IBinder iBinder) {
        Log.m6485d(TAG, "notifyServiceConnection : " + i);
        InternalServiceConnectionListener internalServiceConnectionListener = this.mInternalServiceConnectionListener;
        if (internalServiceConnectionListener != null) {
            if (i == 1) {
                this.mIsConnected = true;
                internalServiceConnectionListener.onConnected(componentName, iBinder);
            } else if (i == 2) {
                this.mIsConnected = false;
                internalServiceConnectionListener.onDisconnected(componentName);
            } else {
                if (i != 3) {
                    return;
                }
                this.mIsConnected = false;
                internalServiceConnectionListener.onError();
            }
        }
    }

    public boolean connect(Context context, Intent intent, InternalServiceConnectionListener internalServiceConnectionListener) {
        setConnectionStatusListener(internalServiceConnectionListener);
        if (isServiceConnected()) {
            Log.m6485d(TAG, "just return already bound service obj");
            return true;
        }
        boolean zConnectToService = connectToService(context, intent);
        Log.m6485d(TAG, "connectToService result : " + zConnectToService);
        if (!zConnectToService) {
            notifyServiceConnection(3, null, null);
        }
        return zConnectToService;
    }

    public boolean connectToService(Context context, Intent intent) {
        if (context == null) {
            Log.m6487e(TAG, "Context is null");
            return false;
        }
        if (intent == null) {
            Log.m6487e(TAG, "Intent is null");
            return false;
        }
        Log.m6485d(TAG, "connectToService mIsConnected = " + this.mIsConnected);
        if (this.mIsConnected) {
            Log.m6485d(TAG, "already bound");
            return true;
        }
        Log.m6485d(TAG, "Binding service with app context");
        this.mContext = context;
        return context.bindService(intent, this.mServiceConnection, 1);
    }

    public void disconnect() {
        Log.m6485d(TAG, "disConnectService mIsConnected = " + this.mIsConnected);
        if (this.mIsConnected) {
            Log.m6485d(TAG, "unbindService");
            this.mIsConnected = false;
            this.mContext.unbindService(this.mServiceConnection);
            notifyServiceConnection(2, null, null);
        }
    }

    public boolean isServiceConnected() {
        Log.m6485d(TAG, "isServiceConnected = " + this.mIsConnected);
        return this.mIsConnected;
    }

    public void setConnectionStatusListener(InternalServiceConnectionListener internalServiceConnectionListener) {
        this.mInternalServiceConnectionListener = internalServiceConnectionListener;
    }
}
