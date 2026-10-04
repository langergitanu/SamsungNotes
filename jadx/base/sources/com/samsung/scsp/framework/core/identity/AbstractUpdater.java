package com.samsung.scsp.framework.core.identity;

import android.content.Context;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractUpdater {
    public DeviceInfo getNewDeviceInfo() {
        Context applicationContext = ContextFactory.getApplicationContext();
        String simMcc = DeviceUtil.getSimMcc(applicationContext);
        String simMnc = DeviceUtil.getSimMnc(applicationContext);
        String deviceName = DeviceUtil.getDeviceName(applicationContext);
        if (StringUtil.equals(ScspCorePreferences.get().simMcc.get(), simMcc)) {
            simMcc = null;
        }
        if (StringUtil.equals(ScspCorePreferences.get().simMnc.get(), simMnc)) {
            simMnc = null;
        }
        if (StringUtil.equals(ScspCorePreferences.get().deviceAlias.get(), deviceName)) {
            deviceName = null;
        }
        return new DeviceInfo(simMcc, simMnc, deviceName);
    }

    public abstract void update();
}
