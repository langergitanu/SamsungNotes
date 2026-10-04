package com.samsung.android.app.notes.trigger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class EmptyTriggerService extends Service {
    private static final String INTENT_STRING_EXTRA_NAME_SOURCE = "source";
    private static final String TAG = "EmptyTriggerService";

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MainLogger.m7254d(TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MainLogger.m7254d(TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        MainLogger.m7254d(TAG, "onStartCommand");
        if (intent != null) {
            AbstractC0000a.m25v("onStartCommand source ", intent.getStringExtra("source"), TAG);
        }
        stopSelf();
        return 2;
    }
}
