package com.samsung.android.support.senl.p148nt.app.main.common.view;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.view.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8236b implements AppBarLayout.AppBarStateChangedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6163a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ActionMenuController f6164b;

    public /* synthetic */ C8236b(ActionMenuController actionMenuController, int i) {
        this.f6163a = i;
        this.f6164b = actionMenuController;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.AppBarStateChangedListener
    public final void onStateChanged(int i, int i2) {
        switch (this.f6163a) {
            case 0:
                this.f6164b.lambda$setFloatingToolbarStateListener$0(i, i2);
                break;
            default:
                this.f6164b.lambda$addFolderPathStateChangeListener$3(i, i2);
                break;
        }
    }
}
