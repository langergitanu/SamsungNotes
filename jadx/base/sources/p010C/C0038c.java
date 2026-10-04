package p010C;

import com.samsung.android.scloud.rpc.SamsungCloudRPCStatus;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: C.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0038c implements SamsungCloudRPCStatus {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0039d f178a;

    public C0038c(C0039d c0039d) {
        this.f178a = c0039d;
    }

    @Override // com.samsung.android.scloud.rpc.SamsungCloudRPCStatus
    public final String getServiceType() {
        return "SYNC";
    }

    @Override // com.samsung.android.scloud.rpc.SamsungCloudRPCStatus
    public final void onBind(boolean z) {
        C0039d c0039d = this.f178a;
        if (!z) {
            Debugger.m8609e("SCRPCSettingV1", "bindSamsungCloudRPC() : failed to bind!");
            c0039d.f179d = 0;
        } else {
            Debugger.m8615i("SCRPCSettingV1", "bindSamsungCloudRPC() : succeed to bind");
            c0039d.f179d = 2;
            new SenlThreadFactory("SCPCSettingV1").newThread(new RunnableC0037b(this, 0)).start();
        }
    }
}
