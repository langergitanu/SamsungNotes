package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8414f implements DialogViewContract.IUnlockConfirmDialog {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6191a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesPresenter f6192b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Map f6193c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ boolean f6194d;

    public /* synthetic */ C8414f(NotesPresenter notesPresenter, Map map, boolean z) {
        this.f6192b = notesPresenter;
        this.f6193c = map;
        this.f6194d = z;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IUnlockConfirmDialog
    public final void unLock() {
        switch (this.f6191a) {
            case 0:
                this.f6192b.lambda$showExportOptionPopup$2(this.f6194d, this.f6193c);
                break;
            default:
                this.f6192b.lambda$showExportOptionPopup$3(this.f6193c, this.f6194d);
                break;
        }
    }

    public /* synthetic */ C8414f(NotesPresenter notesPresenter, boolean z, Map map) {
        this.f6192b = notesPresenter;
        this.f6194d = z;
        this.f6193c = map;
    }
}
