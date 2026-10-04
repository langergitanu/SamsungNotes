package p010C;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.samsung.android.scloud.lib.setting.SamsungCloudRPCSetting;
import com.samsung.android.scloud.rpc.SamsungCloudRPCProfile;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: C.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0039d extends AbstractC0036a {

    /* JADX INFO: renamed from: d */
    public int f179d;

    /* JADX INFO: renamed from: e */
    public SamsungCloudRPCSetting f180e;

    /* JADX INFO: renamed from: f */
    public long f181f;

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: a */
    public final String mo64a() {
        return "SCRPCSettingV1";
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: b */
    public final int mo65b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (m67d()) {
            return this.f173a;
        }
        this.f173a = -1;
        if (this.f179d != 2) {
            m76m();
        } else if (this.f180e == null) {
            Debugger.m8609e("SCRPCSettingV1", "getPreCondition() : samsungCloudRPCSetting is null!");
        } else {
            m77n();
        }
        Debugger.m8615i("SCRPCSettingV1", "getPreCondition() : " + this.f173a + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return this.f173a;
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: l */
    public final void mo75l(Activity activity) {
        if (this.f179d != 2) {
            Debugger.m8609e("SCRPCSettingV1", "showSyncSetting() : fail to showSetting() <- isServiceBinding = " + this.f179d);
            m76m();
            return;
        }
        if (this.f180e == null) {
            Debugger.m8609e("SCRPCSettingV1", "showSyncSetting() : fail to showSetting() <- samsungCloudRPCSetting is null!");
            return;
        }
        Debugger.m8615i("SCRPCSettingV1", "showSyncSetting() : preCondition = " + this.f173a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f180e.showSetting("com.samsung.android.app.notes.sync");
        Debugger.m8615i("SCRPCSettingV1", "showSyncSetting() : succeed to showSetting(), et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    /* JADX INFO: renamed from: m */
    public final synchronized void m76m() {
        if (this.f179d == 1) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f181f;
            if (jElapsedRealtime < 30000) {
                Debugger.m8615i("SCRPCSettingV1", "bindSamsungCloudRPC() : false <- being binded, et = " + jElapsedRealtime);
                return;
            }
        }
        if (this.f179d == 1) {
            Debugger.m8607d("SCRPCSettingV1", "bindSamsungCloudRPC() : request to close and bind again");
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            try {
                this.f180e.close(this.f175c);
                Debugger.m8615i("SCRPCSettingV1", "showSyncSetting() : succeed to close(), et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
            } catch (Exception e) {
                Debugger.m8609e("SCRPCSettingV1", "bindSamsungCloudRPC() : fail to close : " + e.toString());
            }
        } else {
            Debugger.m8615i("SCRPCSettingV1", "bindSamsungCloudRPC() : start to bind");
            this.f179d = 1;
        }
        this.f181f = SystemClock.elapsedRealtime();
        this.f180e = new SamsungCloudRPCSetting(this.f175c, new C0038c(this));
    }

    /* JADX INFO: renamed from: n */
    public final void m77n() {
        Debugger.m8615i("SCRPCSettingV1", "getSyncProfile() : preCondition = " + this.f173a);
        SamsungCloudRPCProfile samsungCloudRPCProfile = new SamsungCloudRPCProfile();
        Bundle profile = this.f180e.getProfile("com.samsung.android.app.notes.sync", samsungCloudRPCProfile);
        Debugger.m8607d("SCRPCSettingV1", "getSyncProfile() - cloudDisplayName: " + samsungCloudRPCProfile.cloudDisplayName + "\n serviceDiaplayName: " + samsungCloudRPCProfile.serviceDiaplayName + "\n preCondition: " + samsungCloudRPCProfile.preCondition + "\n lastUpdatedTime: " + samsungCloudRPCProfile.lastUpdatedTime + "\n isOn: " + samsungCloudRPCProfile.isOn + "\n usingNetworkOption: " + samsungCloudRPCProfile.usingNetworkOption + "\n status: " + profile.getString("rcode"));
        String string = profile.getString("rcode");
        if ("20000000".equals(string)) {
            this.f173a = samsungCloudRPCProfile.preCondition;
            Debugger.m8615i("SCRPCSettingV1", "handleResult() : preCondition = " + this.f173a);
        } else if ("90000000".equals(string)) {
            this.f173a = samsungCloudRPCProfile.preCondition;
            StringBuilder sbM15l = AbstractC0000a.m15l("handleErrorResult() : statusCode = ", string, ", preCondition = ");
            sbM15l.append(this.f173a);
            Debugger.m8609e("SCRPCSettingV1", sbM15l.toString());
        }
        this.f174b = SystemClock.elapsedRealtime();
    }
}
