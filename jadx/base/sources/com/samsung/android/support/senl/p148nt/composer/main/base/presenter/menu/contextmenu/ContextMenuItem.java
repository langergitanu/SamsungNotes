package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContextMenuItem {
    protected Activity mActivity;
    protected MenuItem mExecuteMenuItem;

    public abstract void addMenu(Menu menu);

    public abstract boolean canShow();

    public abstract void executeMenu();

    public void executeMenu(MenuItem menuItem) {
        this.mExecuteMenuItem = menuItem;
        executeMenu();
    }

    public boolean isForOnlyActionMode() {
        return false;
    }

    public boolean isLockRelated() {
        return false;
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public void onDetachView() {
        this.mActivity = null;
    }
}
