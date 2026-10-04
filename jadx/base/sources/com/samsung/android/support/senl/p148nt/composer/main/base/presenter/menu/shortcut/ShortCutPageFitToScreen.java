package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutPageFitToScreen extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutPageFitToScreen");

    public ShortCutPageFitToScreen() {
        setShortcut(Shortcut.FitToScreen);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        Logger.m11003i(TAG, "doAction# ");
        return isBLEEvent(keyEvent);
    }
}
