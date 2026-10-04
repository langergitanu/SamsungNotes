package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu;

import android.view.MenuItem;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.menu.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8677a implements BottomMenuController.AnimationEndListener, NavigationBarView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ EditModeView f6280a;

    public /* synthetic */ C8677a(EditModeView editModeView) {
        this.f6280a = editModeView;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.BottomMenuController.AnimationEndListener
    public void onAnimationEnd(boolean z) {
        this.f6280a.lambda$onPrepareOptionsMenu$0(z);
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return this.f6280a.lambda$invalidateMenu$1(menuItem);
    }
}
