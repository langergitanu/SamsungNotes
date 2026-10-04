package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutRemoteUndo extends ShortCutUndo {
    private static final String TAG = Logger.createTag("ShortCutRemoteUndo");

    public ShortCutRemoteUndo(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter) {
        super(composerViewPresenter, hwToolbarPresenter);
        setShortcut(Shortcut.RemoteUndo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.ShortCutUndo, com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        Logger.m10999d(TAG, "doAction# ");
        return super.doAction();
    }
}
