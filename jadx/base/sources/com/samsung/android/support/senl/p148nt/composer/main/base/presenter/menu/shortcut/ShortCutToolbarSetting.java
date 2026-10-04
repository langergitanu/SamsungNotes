package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutToolbarSetting extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutToolbarSetting");
    private HwToolbarPresenter mHwToolbarPresenter;
    private ModeManager mModeManager;
    private RtToolbarPresenter mRtToolbarPresenter;

    public ShortCutToolbarSetting(ModeManager modeManager, RtToolbarPresenter rtToolbarPresenter, HwToolbarPresenter hwToolbarPresenter) {
        super(Shortcut.ToolbarSetting);
        this.mModeManager = modeManager;
        this.mRtToolbarPresenter = rtToolbarPresenter;
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        Logger.m11003i(TAG, "doAction# " + this.mModeManager.getMode());
        if (this.mModeManager.isMode(Mode.Text)) {
            this.mRtToolbarPresenter.executeTextStyle();
            return true;
        }
        this.mHwToolbarPresenter.executePenSetting();
        return true;
    }
}
