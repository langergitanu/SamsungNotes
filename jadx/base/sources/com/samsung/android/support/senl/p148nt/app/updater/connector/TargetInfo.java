package com.samsung.android.support.senl.p148nt.app.updater.connector;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.DeviceIdHelper;
import com.samsung.android.support.senl.p148nt.app.common.util.AppUpdateUtil;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TargetInfo {
    private static final String TAG = "TargetInfo";
    private static DeviceIdHelper mDeviceIdHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDeviceIdListener {
        void success();
    }

    public static String getExtuk() {
        DeviceIdHelper deviceIdHelper;
        return (!AppUpdateUtil.isDeviceIdServiceSupported() || (deviceIdHelper = mDeviceIdHelper) == null) ? SettingsCompat.getInstance().getAndroidDeviceId(BaseUtils.getApplicationContext()) : deviceIdHelper.getOaid();
    }

    public static void release() {
        DeviceIdHelper deviceIdHelper;
        if (!AppUpdateUtil.isDeviceIdServiceSupported() || (deviceIdHelper = mDeviceIdHelper) == null) {
            return;
        }
        deviceIdHelper.unBindDeviceIdService();
    }

    public static void setOnDeviceIdHelper(final OnDeviceIdListener onDeviceIdListener) {
        if (AppUpdateUtil.isDeviceIdServiceSupported()) {
            DeviceIdHelper deviceIdHelper = new DeviceIdHelper();
            mDeviceIdHelper = deviceIdHelper;
            deviceIdHelper.bindDeviceIdService(ApplicationManager.getInstance().getAppContext(), new DeviceIdHelper.OnDeviceIdListener() { // from class: com.samsung.android.support.senl.nt.app.updater.connector.TargetInfo.1
                @Override // com.samsung.android.support.senl.nt.app.common.DeviceIdHelper.OnDeviceIdListener
                public void success() {
                    OnDeviceIdListener onDeviceIdListener2 = onDeviceIdListener;
                    if (onDeviceIdListener2 != null) {
                        onDeviceIdListener2.success();
                    }
                }
            });
        } else if (onDeviceIdListener != null) {
            onDeviceIdListener.success();
        }
    }

    public static void setOnDeviceIdHelperForSamsungNotes(INewVersionCheckResetListener iNewVersionCheckResetListener, final OnDeviceIdListener onDeviceIdListener) {
        if (iNewVersionCheckResetListener == null || onDeviceIdListener == null) {
            return;
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet()) {
            iNewVersionCheckResetListener.getResult(3);
        } else {
            new SenlThreadFactory(TAG).newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.updater.connector.TargetInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    TargetInfo.setOnDeviceIdHelper(onDeviceIdListener);
                }
            }).start();
        }
    }
}
