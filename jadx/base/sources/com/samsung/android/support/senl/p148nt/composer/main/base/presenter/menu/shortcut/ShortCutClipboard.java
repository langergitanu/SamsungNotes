package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutClipboard extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutClipboard");
    private final ClipboardController mClipboardController;

    public ShortCutClipboard(ClipboardController clipboardController) {
        super(Shortcut.Clipboard);
        this.mClipboardController = clipboardController;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        Logger.m10999d(TAG, "doAction# ");
        ClipboardController clipboardController = this.mClipboardController;
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        clipboardController.setClipboardFilter(companion.getInstance().getTypeAll(), "ShortCutClipboard");
        this.mClipboardController.showClipboard(companion.getInstance().getTypeAll());
        return true;
    }
}
