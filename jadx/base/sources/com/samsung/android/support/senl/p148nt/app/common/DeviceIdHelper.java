package com.samsung.android.support.senl.p148nt.app.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.samsung.android.deviceidservice.IDeviceIdService;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DeviceIdHelper {
    public static final String TAG = "StubManager$DeviceIdHelper";
    private String mOaid;
    private OnDeviceIdListener sOnDeviceIdListener;
    private boolean mIsServiceConnected = false;
    private boolean mIsSupport = false;
    private final ServiceConnection sServiceConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.app.common.DeviceIdHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainLogger.m7258i(DeviceIdHelper.TAG, "bindDeviceIdService onServiceConnected");
            DeviceIdHelper.this.mIsSupport = true;
            try {
                IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
                String oaid = iDeviceIdServiceAsInterface != null ? iDeviceIdServiceAsInterface.getOAID() : "";
                MainLogger.m7258i(DeviceIdHelper.TAG, "onServiceConnected: oaid = " + oaid);
                DeviceIdHelper.this.mOaid = oaid;
                if (DeviceIdHelper.this.sOnDeviceIdListener != null) {
                    DeviceIdHelper.this.sOnDeviceIdListener.success();
                }
                DeviceIdHelper.this.mIsServiceConnected = false;
                ApplicationManager.getInstance().getAppContext().unbindService(DeviceIdHelper.this.sServiceConnection);
            } catch (Exception e) {
                e = e;
                MainLogger.m7255e(DeviceIdHelper.TAG, "onServiceConnected: error" + e.getMessage());
            } catch (UnsatisfiedLinkError e2) {
                e = e2;
                MainLogger.m7255e(DeviceIdHelper.TAG, "onServiceConnected: error" + e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            DeviceIdHelper.this.mIsSupport = false;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDeviceIdListener {
        void success();
    }

    public void bindDeviceIdService(Context context, OnDeviceIdListener onDeviceIdListener) {
        try {
            MainLogger.m7258i(TAG, "bindDeviceIdService start");
            this.sOnDeviceIdListener = onDeviceIdListener;
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            context.bindService(intent, this.sServiceConnection, 37);
            this.mIsServiceConnected = true;
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("bindDeviceIdService error: "), TAG);
            this.mIsServiceConnected = false;
        }
    }

    public String getOaid() {
        return TextUtils.isEmpty(this.mOaid) ? SettingsCompat.getInstance().getAndroidDeviceId(BaseUtils.getApplicationContext()) : this.mOaid;
    }

    public boolean isSupported() {
        return this.mIsSupport;
    }

    public void unBindDeviceIdService() {
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            try {
                ApplicationManager.getInstance().getAppContext().unbindService(this.sServiceConnection);
            } catch (Exception e) {
                AbstractC14516b.m15115c(e, new StringBuilder("unBindDeviceIdService error: "), TAG);
            }
        }
    }
}
