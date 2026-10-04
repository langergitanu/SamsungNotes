package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionAudioSeek extends AbsAction {
    private static final String TAG = Logger.createTag("ActionAudioSeek");
    private final boolean mIsForward;
    private final MenuPresenterContract.IMenuManager mMenuManager;

    public ActionAudioSeek(MenuPresenterContract.IMenuManager iMenuManager, boolean z) {
        this.mMenuManager = iMenuManager;
        this.mIsForward = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        Logger.m11003i(TAG, "doAction# isForward =" + this.mIsForward + " / " + str);
        this.mMenuManager.onEvent(this.mIsForward ? 7 : 8);
        return true;
    }
}
