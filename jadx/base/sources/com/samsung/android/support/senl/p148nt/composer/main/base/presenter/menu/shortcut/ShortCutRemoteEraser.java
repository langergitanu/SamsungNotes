package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutRemoteEraser extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutRemoteEraser");
    private final HwToolbarPresenter mHwToolbarPresenter;

    public ShortCutRemoteEraser(HwToolbarPresenter hwToolbarPresenter) {
        setShortcut(Shortcut.RemoteEraser);
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        Logger.m10999d(TAG, "doAction# ");
        if (!isBLEEvent(keyEvent)) {
            return false;
        }
        this.mHwToolbarPresenter.executeRemoteEraser();
        return true;
    }
}
