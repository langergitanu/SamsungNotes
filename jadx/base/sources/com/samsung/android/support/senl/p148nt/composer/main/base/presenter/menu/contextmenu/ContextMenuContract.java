package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ContextMenuContract {
    boolean canShowContextMenu(Menu menu);

    boolean createContextMenu(Menu menu, boolean z);

    void executeMenuItem(MenuItem menuItem, boolean z);

    boolean onPerformContextMenuAction(int i);
}
