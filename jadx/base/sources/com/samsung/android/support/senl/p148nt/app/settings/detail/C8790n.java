package com.samsung.android.support.senl.p148nt.app.settings.detail;

import com.samsung.android.app.notes.sync.quota.InterfaceC6872e;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8790n implements InterfaceC6872e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6322a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6323b;

    public /* synthetic */ C8790n(Object obj, int i) {
        this.f6322a = i;
        this.f6323b = obj;
    }

    @Override // com.samsung.android.app.notes.sync.quota.InterfaceC6872e
    /* JADX INFO: renamed from: a */
    public final void mo5055a(int i, long j, long j2) {
        switch (this.f6322a) {
            case 0:
                SettingsSyncWithSamsungAccountPrefFragment.mQuotaListener$lambda$1((SettingsSyncWithSamsungAccountPrefFragment) this.f6323b, i, j, j2);
                break;
            default:
                ImportDocumentMode.mSyncQuotaListener$lambda$2((ImportDocumentMode) this.f6323b, i, j, j2);
                break;
        }
    }
}
