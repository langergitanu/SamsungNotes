package com.samsung.android.scloud.lib.setting;

import android.util.Log;
import com.samsung.android.scloud.rpc.SamsungCloudRPCContract;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCProperty {
    static final String TAG = "SamsungCloudRPCProperty";
    static boolean isInitCompleted;
    static Object initObject = new Object();
    static PropertyChangeSupport pcs = new PropertyChangeSupport(initObject);
    static long TIMER_INIT_COMPLETED = AiSTTListView.USER_SCROLL_INTERVAL;

    public static synchronized void firePropertyChange(String str, boolean z) {
        try {
            if (SamsungCloudRPCContract.Property.APP_INITIALIZATION_COMPLTED.equals(str)) {
                isInitCompleted = z;
            }
            pcs.firePropertyChange(str, (Object) null, Boolean.valueOf(z));
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void waitForInitCompleted() {
        if (isInitCompleted) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() { // from class: com.samsung.android.scloud.lib.setting.SamsungCloudRPCProperty.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                Log.d(SamsungCloudRPCProperty.TAG, "initCompletedListner: notified");
                SamsungCloudRPCProperty.pcs.removePropertyChangeListener(SamsungCloudRPCContract.Property.APP_INITIALIZATION_COMPLTED, this);
                countDownLatch.countDown();
            }
        };
        try {
            try {
                pcs.addPropertyChangeListener(SamsungCloudRPCContract.Property.APP_INITIALIZATION_COMPLTED, propertyChangeListener);
                countDownLatch.await(TIMER_INIT_COMPLETED, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        } finally {
            pcs.removePropertyChangeListener(SamsungCloudRPCContract.Property.APP_INITIALIZATION_COMPLTED, propertyChangeListener);
            isInitCompleted = true;
        }
    }
}
