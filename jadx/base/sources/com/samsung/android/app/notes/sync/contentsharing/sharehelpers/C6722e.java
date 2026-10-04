package com.samsung.android.app.notes.sync.contentsharing.sharehelpers;

import com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a;
import com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.ShareSingleTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import p020E.C0073a;
import p068Q.C0204a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharehelpers.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6722e extends AbstractC6718a implements InterfaceC6717a {

    /* JADX INFO: renamed from: h */
    public C0073a f4063h;

    /* JADX INFO: renamed from: i */
    public ShareSingleTask f4064i;

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: b */
    public final void mo200b(ArrayList arrayList) {
        synchronized (this) {
            try {
                this.f4053a = 1;
                C0073a c0073a = this.f4063h;
                if (c0073a != null) {
                    c0073a.mo200b(arrayList);
                }
                if (this.f4056d) {
                    this.f4054b.unbindService(this.f4059g);
                    this.f4056d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: c */
    public final void mo201c() {
        Debugger.m8607d("SdocShareHelper", "onShareEnded()");
        synchronized (this) {
            try {
                this.f4053a = 1;
                C0073a c0073a = this.f4063h;
                if (c0073a != null) {
                    c0073a.mo201c();
                }
                if (this.f4056d) {
                    this.f4054b.unbindService(this.f4059g);
                    this.f4056d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: e */
    public final void mo202e(String str) {
        synchronized (this) {
            try {
                C0073a c0073a = this.f4063h;
                if (c0073a != null) {
                    c0073a.mo202e(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: f */
    public final void mo203f() {
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbstractC6718a
    /* JADX INFO: renamed from: h */
    public final void mo4811h(C0204a c0204a) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c0204a);
        mo200b(arrayList);
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbstractC6718a
    /* JADX INFO: renamed from: i */
    public final void mo4812i(String str) {
        Debugger.m8616s("SdocShareHelper", "Finish getting account id : ".concat(str));
        synchronized (this) {
            ShareSingleTask shareSingleTask = new ShareSingleTask(this.f4054b, this, this.f4058f);
            this.f4064i = shareSingleTask;
            this.f4053a = 3;
            shareSingleTask.executeOnExecutor(this.f4055c, new Void[0]);
        }
    }
}
