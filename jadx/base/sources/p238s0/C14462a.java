package p238s0;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p038I1.C0128d;
import p038I1.C0129e;
import p038I1.C0130f;
import p038I1.C0137m;
import p042J1.AbstractC0155m;
import p086V.C0322h;

/* JADX INFO: renamed from: s0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14462a extends AbstractC6703c {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f10249b;

    /* JADX INFO: renamed from: c */
    public DocTypeConstants f10250c;

    public /* synthetic */ C14462a(int i) {
        this.f10249b = i;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: d */
    public final void mo4791d() {
        switch (this.f10249b) {
            case 0:
                C0128d c0128d = new C0128d();
                DocTypeConstants docTypeConstants = this.f10250c;
                Context appContext = C0322h.m670a().f815a.getAppContext();
                C0137m c0137mM280d = C0137m.m280d();
                NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
                if (!c0137mM280d.m283a(c0128d)) {
                    Debugger.m8607d("HandleImportTipCardNotification", "Do not added tipCard " + C0137m.m282j(c0128d.getType()) + ". already exist");
                } else if (C0137m.f389c.size() <= 0) {
                    notificationContractImpl.launchImportTipCardNotification(docTypeConstants, c0128d.getType());
                } else {
                    c0137mM280d.m284b(c0128d);
                    if (AbstractC0155m.m404s(appContext)) {
                        notificationContractImpl.launchImportTipCardNotification(docTypeConstants, c0128d.getType());
                    }
                }
                break;
            case 1:
                Context context = (Context) this.f4022a;
                if (!AbstractC0155m.m404s(context)) {
                    C0322h.m670a().f822h.show(context, 3);
                } else {
                    C0129e c0129e = new C0129e(3, 0, 0, 0, 0, 3);
                    DocTypeConstants docTypeConstants2 = this.f10250c;
                    C0322h.m670a().f815a.getAppContext();
                    C0137m.m280d();
                    C0322h.m670a().f818d.launchImportNotification(docTypeConstants2, c0129e.getType());
                }
                break;
            default:
                C0130f c0130f = new C0130f();
                DocTypeConstants docTypeConstants3 = this.f10250c;
                Context appContext2 = C0322h.m670a().f815a.getAppContext();
                C0137m c0137mM280d2 = C0137m.m280d();
                NotificationContractImpl notificationContractImpl2 = C0322h.m670a().f818d;
                if (!c0137mM280d2.m283a(c0130f)) {
                    Debugger.m8607d("HandleImportTipCardNotification", "Do not added tipCard " + C0137m.m282j(c0130f.getType()) + ". already exist");
                } else if (C0137m.f389c.size() <= 0) {
                    notificationContractImpl2.launchImportTipCardNotification(docTypeConstants3, c0130f.getType());
                } else {
                    c0137mM280d2.m284b(c0130f);
                    if (AbstractC0155m.m404s(appContext2)) {
                        notificationContractImpl2.launchImportTipCardNotification(docTypeConstants3, c0130f.getType());
                    }
                }
                break;
        }
    }
}
