package com.samsung.android.app.notes.sync.scloud.pam;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.scsp.framework.core.identity.DeviceIdSupplier;
import p001A.AbstractC0000a;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DeviceIdSupplierImpl implements DeviceIdSupplier {
    private static final String TAG = "DeviceIdSupplierImpl";

    @Override // com.samsung.scsp.framework.core.identity.DeviceIdSupplier
    public String getImei() {
        String deviceId;
        try {
            deviceId = ((TelephonyManager) BaseUtils.getApplicationContext().getSystemService("phone")).getDeviceId();
        } catch (SecurityException e) {
            Debugger.m8609e("DeviceUtil", "getImei() : " + e.getMessage());
            deviceId = null;
        }
        Debugger.m8607d(TAG, "[PAM] getImei() : ".concat(TextUtils.isEmpty(deviceId) ? "empty" : "XXX"));
        return deviceId;
    }

    @Override // com.samsung.scsp.framework.core.identity.DeviceIdSupplier
    public String getSerial() {
        String str = Build.SERIAL;
        Context appContext = C0322h.m670a().f815a.getAppContext();
        if (appContext == null) {
            Debugger.m8609e("DeviceUtil", "getSerial() : appContext is null!");
        } else if ("unknown".equals(str) && PermissionHelper.isPermissionGrantedWithoutNotice(appContext, "android.permission.READ_PHONE_STATE")) {
            try {
                str = (String) Build.class.getMethod("getSerial", null).invoke(null, null);
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("getSerial : "), "DeviceUtil");
            }
        }
        Debugger.m8607d(TAG, "[PAM] getSerial() : ".concat(TextUtils.isEmpty(str) ? "empty" : "XXX"));
        return str;
    }
}
