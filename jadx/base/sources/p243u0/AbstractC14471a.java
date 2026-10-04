package p243u0;

import android.content.Context;
import com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import p010C.C0042g;
import p026F1.AbstractC0100d;

/* JADX INFO: renamed from: u0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC14471a extends AbstractC6703c {

    /* JADX INFO: renamed from: b */
    public int f10274b = 1;

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: d */
    public final void mo4791d() {
        if (CommonUtils.hasCloudSetting((Context) this.f4022a)) {
            mo15053f();
        } else {
            mo15054g();
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract void mo15053f();

    /* JADX INFO: renamed from: g */
    public abstract void mo15054g();

    /* JADX INFO: renamed from: h */
    public final void m15055h() {
        C0042g c0042gM78a = C0042g.m78a((Context) this.f4022a);
        int i = this.f10274b;
        if (c0042gM78a.m79b()) {
            c0042gM78a.f186b.mo72i(i);
        } else {
            Debugger.m8609e("SCRPCSettingManager", "notifySyncError() : fail!");
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m15056i() {
        AbstractC0100d.m244f((Context) this.f4022a, this.f10274b);
    }
}
