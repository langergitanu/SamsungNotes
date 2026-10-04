package p010C;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: C.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0041f extends AbstractC0036a {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f183d;

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: a */
    public final String mo64a() {
        switch (this.f183d) {
            case 0:
                return "SCSetting";
            default:
                return "SCRPCSettingNotSupported";
        }
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: g */
    public void mo70g() {
        switch (this.f183d) {
            case 1:
                Debugger.m8615i("SCRPCSettingNotSupported", "notifySyncCancel() : Not supported!");
                break;
            default:
                super.mo70g();
                break;
        }
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: h */
    public void mo71h() {
        switch (this.f183d) {
            case 1:
                Debugger.m8615i("SCRPCSettingNotSupported", "notifySyncComplete() : Not supported!");
                break;
            default:
                super.mo71h();
                break;
        }
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: i */
    public void mo72i(int i) {
        switch (this.f183d) {
            case 1:
                Debugger.m8615i("SCRPCSettingNotSupported", "notifySyncError() : Not supported!");
                break;
            default:
                super.mo72i(i);
                break;
        }
    }

    @Override // p010C.AbstractC0036a
    /* JADX INFO: renamed from: k */
    public void mo74k() {
        switch (this.f183d) {
            case 1:
                Debugger.m8615i("SCRPCSettingNotSupported", "notifySyncStart() : Not supported!");
                break;
            default:
                super.mo74k();
                break;
        }
    }
}
