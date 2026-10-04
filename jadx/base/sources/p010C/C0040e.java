package p010C;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.samsung.android.scloud.lib.setting.SamsungCloudRPCSettingV2Std;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatus;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: C.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0040e extends AbstractC0036a {

    /* JADX INFO: renamed from: d */
    public SamsungCloudRPCSettingV2Std f182d;

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: a */
    public final String mo64a() {
        return "SCRPCSettingV2";
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: b */
    public final int mo65b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (m67d()) {
            return this.f173a;
        }
        this.f173a = -1;
        Bundle profile = this.f182d.getProfile();
        if (profile == null) {
            Debugger.m8609e("SCRPCSettingV2", "getPreCondition() : Bundle result is null!");
            return this.f173a;
        }
        if (profile.containsKey("precondition")) {
            this.f173a = profile.getInt("precondition");
            Debugger.m8615i("SCRPCSettingV2", "getPreCondition() : " + this.f173a + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        } else {
            Debugger.m8609e("SCRPCSettingV2", "getPreCondition() : No precondition key, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
        this.f174b = SystemClock.elapsedRealtime();
        return this.f173a;
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: c */
    public final Bundle mo66c() {
        return this.f182d.getProfile();
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: e */
    public final void mo68e(boolean z) {
        Debugger.m8615i("SCRPCSettingV2", "notifyAutoSyncChanged() : sync = " + z);
        this.f182d.notifyAutoSyncChanged(z);
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: f */
    public final void mo69f(boolean z) {
        AbstractC0000a.m0A(z ? 1 : 0, "notifyNetworkOptionChanged() : networkOption = ", "SCRPCSettingV2");
        this.f182d.notifyNetworkOptionChanged(z ? 1 : 0);
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: g */
    public final void mo70g() {
        Debugger.m8615i("SCRPCSettingV2", "notifySyncCancel()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f182d.notifySyncStatusChanged("cancel", SamsungCloudRPCStatus.Value.SUCCESS);
        Debugger.m8615i("SCRPCSettingV2", "notifySyncCancel() finish : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: h */
    public final void mo71h() {
        Debugger.m8615i("SCRPCSettingV2", "notifySyncComplete()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f182d.notifySyncStatusChanged("complete", SamsungCloudRPCStatus.Value.SUCCESS);
        Debugger.m8615i("SCRPCSettingV2", "notifySyncComplete() finish : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo72i(int i) {
        int i2 = SamsungCloudRPCStatus.Value.FAILED_INTERNAL_AGENT_ERROR;
        if (i != 1) {
            if (i == 106) {
                i2 = SamsungCloudRPCStatus.Value.FAILED_NO_ACCOUNT;
            } else if (i != 108 && i != 124) {
                if (i == 118) {
                    i2 = SamsungCloudRPCStatus.Value.FAILED_NO_NETWORK;
                } else if (i == 119) {
                    i2 = SamsungCloudRPCStatus.Value.FAILED_CONSENT_TO_USE_PERSONAL_INFORMATION;
                } else if (i == 200) {
                    i2 = SamsungCloudRPCStatus.Value.FAILED_EXCEED_UPLOAD_SIZE;
                } else if (i != 201) {
                    switch (i) {
                        case 100:
                            i2 = SamsungCloudRPCStatus.Value.FAILED_QUOTA_EXCEEDED;
                            break;
                        case 101:
                        case 103:
                            break;
                        case 102:
                            i2 = 70000002;
                            break;
                        case 104:
                            i2 = SamsungCloudRPCStatus.Value.FAILED_INSUFFICIENT_STORAGE_ON_DEVICE;
                            break;
                        default:
                            Debugger.m8609e("SCRPCSettingV2", "getConvertedErrorCodeFromSyncErrors() : Not matched!");
                            break;
                    }
                } else {
                    i2 = SamsungCloudRPCStatus.Value.FAILED_INTERNAL_SERVER_ERROR;
                }
            }
        }
        Debugger.m8609e("SCRPCSettingV2", "notifySyncError() : syncErrorCode = " + i + ", convertedErrorCode = " + i2);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f182d.notifySyncStatusChanged("complete", i2);
        Debugger.m8615i("SCRPCSettingV2", "notifySyncError() finish : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: j */
    public final void mo73j() {
        Debugger.m8615i("SCRPCSettingV2", "notifySyncProgress()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f182d.notifySyncStatusChanged("progress", SamsungCloudRPCStatus.Value.SUCCESS);
        Debugger.m8615i("SCRPCSettingV2", "notifySyncProgress() finish : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: k */
    public final void mo74k() {
        Debugger.m8615i("SCRPCSettingV2", "notifySyncStart()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f182d.notifySyncStatusChanged("start", SamsungCloudRPCStatus.Value.SUCCESS);
        Debugger.m8615i("SCRPCSettingV2", "notifySyncStart() finish : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: l */
    public final void mo75l(Activity activity) {
        Debugger.m8607d("SCRPCSettingV2", "showSyncSetting() : preCondition = " + this.f173a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f182d.showSetting(activity, 536870912);
        Debugger.m8615i("SCRPCSettingV2", "showSyncSetting() : preCondition = " + this.f173a + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }
}
