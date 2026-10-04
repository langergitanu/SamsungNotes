package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import android.view.MenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MenuItemOnMenuItemClickListenerC8924a implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6458a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6459b;

    public /* synthetic */ MenuItemOnMenuItemClickListenerC8924a(Object obj, int i) {
        this.f6458a = i;
        this.f6459b = obj;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.f6458a) {
            case 0:
                return SmContextMenuManager.setMenuItemClickListener$lambda$0((SmContextMenuManager) this.f6459b, menuItem);
            case 1:
                return AiResultContextMenuManager.setMenuItemClickListener$lambda$0((AiResultContextMenuManager) this.f6459b, menuItem);
            default:
                return ((ContextMenuManager) this.f6459b).lambda$createContextMenu$0(menuItem);
        }
    }
}
