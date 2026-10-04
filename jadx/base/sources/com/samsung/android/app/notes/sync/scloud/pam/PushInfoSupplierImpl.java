package com.samsung.android.app.notes.sync.scloud.pam;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.smp.Smp;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.scsp.framework.core.identity.PushInfo;
import com.samsung.scsp.framework.core.identity.PushInfoSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PushInfoSupplierImpl implements PushInfoSupplier {
    private static final String SMP_FCM_TYPE = "fcm";
    private static final String SMP_SPP_TYPE = "spp";
    private static final String TAG = "PushInfoSupplierImpl";
    private String mPushId = null;
    private String mPushType = null;
    private String mPushToken = null;

    private void fillPushInfo() {
        Debugger.m8615i(TAG, "[PAM] fillPushInfo()");
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            Debugger.m8609e(TAG, "[PAM] getPushInfo() : appContext is null!");
            return;
        }
        try {
            getPushTypeOfSCloud(Smp.getPushType(applicationContext));
            this.mPushToken = Smp.getPushToken(applicationContext);
        } catch (Exception e) {
            AbstractC4539a.m3213w(e, new StringBuilder("[PAM] fillPushInfo : Exception = "), TAG);
        }
        if (TextUtils.isEmpty(this.mPushType) || TextUtils.isEmpty(this.mPushToken)) {
            return;
        }
        getPushId();
    }

    private void getPushId() {
        if (this.mPushType == "SMPFCM") {
            this.mPushId = "660656629413";
        } else {
            this.mPushId = "8938bd824975bfb2";
        }
    }

    private void getPushTypeOfSCloud(String str) {
        if ("fcm".equals(str)) {
            this.mPushType = "SMPFCM";
        } else if ("spp".equals(str)) {
            this.mPushType = "SMPSPP";
        } else {
            this.mPushType = null;
        }
    }

    @Override // com.samsung.scsp.framework.core.identity.PushInfoSupplier
    public PushInfo[] getPushInfo() {
        Debugger.m8615i(TAG, "[PAM] getPushInfo()");
        fillPushInfo();
        if (!TextUtils.isEmpty(this.mPushType) && !TextUtils.isEmpty(this.mPushToken)) {
            return new PushInfo[]{new PushInfo(this.mPushId, this.mPushType, this.mPushToken)};
        }
        Debugger.m8609e(TAG, "[PAM] getPushInfo() : invalid pushType or pushToken!");
        return null;
    }
}
