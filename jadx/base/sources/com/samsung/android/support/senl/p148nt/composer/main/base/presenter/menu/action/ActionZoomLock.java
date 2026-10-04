package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionZoomLock extends AbsAction {
    private static final String TAG = Logger.createTag("ActionZoomLock");
    private final MenuPresenterContract.IMenuManager mMenuManager;

    public ActionZoomLock(MenuPresenterContract.IMenuManager iMenuManager) {
        this.mMenuManager = iMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        this.mMenuManager.onEvent(10);
        return true;
    }
}
