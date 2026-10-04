package com.samsung.android.support.senl.p148nt.app.main.noteslist.view;

import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8587a implements ActionMenuController.OnClickNavigateListener, ActionMenuController.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6272a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesView f6273b;

    public /* synthetic */ C8587a(NotesView notesView, int i) {
        this.f6272a = i;
        this.f6273b = notesView;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.Contract
    public int getModeIndex() {
        switch (this.f6272a) {
            case 1:
                return this.f6273b.lambda$createActionMenuController$1();
            default:
                return this.f6273b.lambda$createActionMenuController$3();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.OnClickNavigateListener
    public void onClick(boolean z) {
        switch (this.f6272a) {
            case 0:
                this.f6273b.lambda$createActionMenuController$0(z);
                break;
            default:
                this.f6273b.lambda$createActionMenuController$2(z);
                break;
        }
    }
}
