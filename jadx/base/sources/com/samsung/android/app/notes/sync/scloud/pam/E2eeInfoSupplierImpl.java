package com.samsung.android.app.notes.sync.scloud.pam;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.scsp.framework.core.identity.E2eeInfoSupplier;
import p001A.AbstractC0000a;
import p211o0.C13569c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class E2eeInfoSupplierImpl implements E2eeInfoSupplier {
    private static final String TAG = "E2eeInfoSupplierImpl";

    @Override // com.samsung.scsp.framework.core.identity.E2eeInfoSupplier
    public int getDeviceIntegrity() {
        return super.getDeviceIntegrity();
    }

    @Override // com.samsung.scsp.framework.core.identity.E2eeInfoSupplier
    public String getSakUid() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            Debugger.m8609e(TAG, "[PAM] getSakUid() : appContext is null!");
            return null;
        }
        if (TextUtils.isEmpty(C13569c.m14376d(applicationContext).m14379e())) {
            Debugger.m8609e(TAG, "[PAM] getSakUid() : Empty!");
        } else {
            Debugger.m8615i(TAG, "[PAM] getSakUid() : Valid");
        }
        return C13569c.m14376d(applicationContext).m14379e();
    }

    @Override // com.samsung.scsp.framework.core.identity.E2eeInfoSupplier
    public int getType() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            Debugger.m8609e(TAG, "[PAM] getType() : appContext is null!");
            return -1;
        }
        int e2EEDeviceType = C13569c.m14376d(applicationContext).f9619b.getE2EEDeviceType();
        AbstractC0000a.m0A(e2EEDeviceType, "[PAM] getType() : ", TAG);
        return e2EEDeviceType;
    }
}
