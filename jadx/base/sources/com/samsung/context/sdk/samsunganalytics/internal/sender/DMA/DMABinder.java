package com.samsung.context.sdk.samsunganalytics.internal.sender.DMA;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.context.sdk.samsunganalytics.internal.Callback;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.sec.android.diagmonagent.p168sa.IDMAInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DMABinder {
    private Context context;
    private IDMAInterface dmaInterface;
    private ServiceConnection serviceConnection;
    private boolean isTokenFail = false;
    private boolean isBind = false;

    public DMABinder(Context context, final Callback<Void, String> callback) {
        this.context = context;
        this.serviceConnection = new ServiceConnection() { // from class: com.samsung.context.sdk.samsunganalytics.internal.sender.DMA.DMABinder.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    DMABinder.this.dmaInterface = IDMAInterface.Stub.asInterface(iBinder);
                    String strCheckToken = DMABinder.this.dmaInterface.checkToken();
                    if (strCheckToken == null) {
                        DMABinder.this.unBind();
                        DMABinder.this.isTokenFail = true;
                        Debug.LogD("DMABinder", "Token failed");
                    } else {
                        DMABinder.this.isTokenFail = false;
                        callback.onResult(strCheckToken);
                        Debug.LogD("DMABinder", "DMA connected");
                    }
                } catch (Exception e) {
                    DMABinder.this.unBind();
                    DMABinder.this.isTokenFail = true;
                    Debug.logwingW("failed to connect binder" + e.getMessage());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                DMABinder.this.dmaInterface = null;
            }
        };
    }

    public boolean bind() {
        if (!this.isBind && !this.isTokenFail) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.sec.android.diagmonagent", "com.sec.android.diagmonagent.sa.receiver.SALogReceiverService");
                this.isBind = this.context.bindService(intent, this.serviceConnection, 1);
                Debug.LogD("DMABinder", "bind " + this.isBind);
            } catch (Exception e) {
                Debug.logwingW("failed to bind" + e.getMessage());
            }
        }
        return this.isTokenFail;
    }

    public IDMAInterface getDmaInterface() {
        return this.dmaInterface;
    }

    public boolean isBind() {
        return this.isBind;
    }

    public boolean isTokenfail() {
        return this.isTokenFail;
    }

    public void unBind() {
        if (this.dmaInterface == null || !this.isBind) {
            return;
        }
        try {
            this.context.unbindService(this.serviceConnection);
            this.isBind = false;
            Debug.LogD("DMABinder", "unbind");
        } catch (Exception e) {
            Debug.logwingW("failed to unbind" + e.getMessage());
        }
    }
}
