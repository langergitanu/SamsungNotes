package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutSetAlign extends AbsShortCutAction {
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 1;
    private static final String TAG = Logger.createTag("ShortCutSetAlign");
    private final int mAlignType;
    private final ModeManager mModeManager;
    private final RtToolbarPresenter mRtToolbarPresenter;

    public ShortCutSetAlign(ModeManager modeManager, RtToolbarPresenter rtToolbarPresenter, int i) {
        this.mModeManager = modeManager;
        this.mAlignType = i;
        this.mRtToolbarPresenter = rtToolbarPresenter;
        if (i == 1) {
            setShortcut(Shortcut.AlignRight);
        } else if (i == 2) {
            setShortcut(Shortcut.AlignCenter);
        } else {
            setShortcut(Shortcut.AlignLeft);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        AbstractC8014b.m7221w(new StringBuilder("doAction# mAlignType = "), TAG, this.mAlignType);
        if (!this.mModeManager.isMode(Mode.Text)) {
            return false;
        }
        this.mRtToolbarPresenter.setAlign(this.mAlignType);
        return true;
    }
}
