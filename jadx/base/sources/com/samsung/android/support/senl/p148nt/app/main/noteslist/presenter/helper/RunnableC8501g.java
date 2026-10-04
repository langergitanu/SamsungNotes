package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsPasswordAndBiometricsFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8501g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6209a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f6210b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f6211c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f6212d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f6213e;

    public /* synthetic */ RunnableC8501g(LockHelper lockHelper, String str, boolean z, boolean z2) {
        this.f6212d = lockHelper;
        this.f6210b = z;
        this.f6211c = z2;
        this.f6213e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6209a) {
            case 0:
                ((LockHelper) this.f6212d).lambda$setConvertingItem$1(this.f6210b, this.f6211c, (String) this.f6213e);
                break;
            case 1:
                SettingsPasswordAndBiometricsFragment.updateBiometricsViews$lambda$1((SettingsPasswordAndBiometricsFragment) this.f6212d, (Context) this.f6213e, this.f6210b, this.f6211c);
                break;
            default:
                ((ServiceContractImpl) this.f6212d).lambda$onChangedDoc$1(this.f6210b, (NotesDocument) this.f6213e, this.f6211c);
                break;
        }
    }

    public /* synthetic */ RunnableC8501g(SettingsPasswordAndBiometricsFragment settingsPasswordAndBiometricsFragment, Context context, boolean z, boolean z2) {
        this.f6212d = settingsPasswordAndBiometricsFragment;
        this.f6213e = context;
        this.f6210b = z;
        this.f6211c = z2;
    }

    public /* synthetic */ RunnableC8501g(ServiceContractImpl serviceContractImpl, boolean z, NotesDocument notesDocument, boolean z2) {
        this.f6212d = serviceContractImpl;
        this.f6210b = z;
        this.f6213e = notesDocument;
        this.f6211c = z2;
    }
}
