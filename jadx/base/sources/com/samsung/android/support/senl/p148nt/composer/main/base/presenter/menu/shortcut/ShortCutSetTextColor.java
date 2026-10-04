package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutSetTextColor extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutSetTextColor");
    private final boolean mIsBGColor;
    private final ModeManager mModeManager;
    private final RtToolbarPresenter mRtToolbarPresenter;

    public ShortCutSetTextColor(ModeManager modeManager, RtToolbarPresenter rtToolbarPresenter, boolean z) {
        super(z ? Shortcut.TextBackgroundColor : Shortcut.TextColor);
        this.mModeManager = modeManager;
        this.mRtToolbarPresenter = rtToolbarPresenter;
        this.mIsBGColor = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        if (!this.mModeManager.isMode(Mode.Text)) {
            return false;
        }
        this.mRtToolbarPresenter.showTextColor(this.mIsBGColor);
        return true;
    }
}
