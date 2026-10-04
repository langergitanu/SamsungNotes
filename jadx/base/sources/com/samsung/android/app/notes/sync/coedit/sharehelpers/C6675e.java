package com.samsung.android.app.notes.sync.coedit.sharehelpers;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.CoeditShareSingleTask;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import p068Q.C0204a;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharehelpers.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6675e extends AbstractC6671a implements InterfaceC6669a {

    /* JADX INFO: renamed from: h */
    public C14433b f3958h;

    /* JADX INFO: renamed from: i */
    public CoeditShareSingleTask f3959i;

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: b */
    public final void mo4732b(ArrayList arrayList) {
        synchronized (this) {
            try {
                this.f3948a = 1;
                C14433b c14433b = this.f3958h;
                if (c14433b != null) {
                    c14433b.mo4732b(arrayList);
                }
                if (this.f3951d) {
                    this.f3949b.unbindService(this.f3954g);
                    this.f3951d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: c */
    public final void mo4733c() {
        Debugger.m8607d("CoeditSdocShareHelper", "onShareEnded()");
        synchronized (this) {
            try {
                this.f3948a = 1;
                C14433b c14433b = this.f3958h;
                if (c14433b != null) {
                    c14433b.mo4733c();
                }
                if (this.f3951d) {
                    this.f3949b.unbindService(this.f3954g);
                    this.f3951d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: e */
    public final void mo4734e(String str) {
        synchronized (this) {
            try {
                C14433b c14433b = this.f3958h;
                if (c14433b != null) {
                    c14433b.mo4734e(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: f */
    public final void mo4735f() {
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharehelpers.AbstractC6671a
    /* JADX INFO: renamed from: h */
    public final void mo4767h(C0204a c0204a) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c0204a);
        mo4732b(arrayList);
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharehelpers.AbstractC6671a
    /* JADX INFO: renamed from: i */
    public final void mo4768i(String str) {
        Debugger.m8616s("CoeditSdocShareHelper", "Finish getting account id : ".concat(str));
        synchronized (this) {
            CoeditShareSingleTask coeditShareSingleTask = new CoeditShareSingleTask(this.f3949b, this, this.f3953f);
            this.f3959i = coeditShareSingleTask;
            this.f3948a = 3;
            coeditShareSingleTask.executeOnExecutor(this.f3950c, new Void[0]);
        }
    }
}
