package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.FontSizeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutSetFontSize extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutSetFontSize");
    private int[] mFontSizeList;
    private final boolean mIsIncrease;
    private final ModeManager mModeManager;
    private final RtToolbarPresenter mRtToolbarPresenter;

    public ShortCutSetFontSize(ModeManager modeManager, RtToolbarPresenter rtToolbarPresenter, boolean z) {
        this.mModeManager = modeManager;
        this.mIsIncrease = z;
        if (z) {
            setShortcut(Shortcut.FontSizeIncrease);
        } else {
            setShortcut(Shortcut.FontSizeDecrease);
        }
        this.mRtToolbarPresenter = rtToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        if (!this.mModeManager.isMode(Mode.Text)) {
            return false;
        }
        if (this.mFontSizeList == null) {
            this.mFontSizeList = this.mRtToolbarPresenter.getFontSizeList();
        }
        int[] iArr = this.mFontSizeList;
        if (iArr == null || iArr.length == 0) {
            Logger.m11003i(TAG, "doAction# mFontSizeList is null");
            return false;
        }
        int nextFontSize = FontSizeUtil.getNextFontSize(iArr, this.mRtToolbarPresenter.getCurrentViewFontSize(), this.mIsIncrease);
        AbstractC8014b.m7217s(nextFontSize, "doAction# nextFontSize = ", TAG);
        this.mRtToolbarPresenter.setFontSizeAndUpdate(nextFontSize);
        return true;
    }
}
