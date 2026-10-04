package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListComposerModeHelper {
    private static final int MODE_CHANGE_FROM_VIEW_TO_TEXT = 1;
    private static final int MODE_CHANGE_NONE = 0;
    private static final String TAG = Logger.createTag("PageListComposerModeHelper");
    private final ComposerViewPresenter mCompViewPresenter;
    private final ComposerModel mComposerModel;
    private int mLastToolType;
    private final SoftInputManager mSoftInputManager;

    public PageListComposerModeHelper(ComposerModel composerModel, ComposerViewPresenter composerViewPresenter, SoftInputManager softInputManager) {
        this.mComposerModel = composerModel;
        this.mCompViewPresenter = composerViewPresenter;
        this.mSoftInputManager = softInputManager;
    }

    private int setCanvasModeFromLastToolType(String str) {
        if (this.mLastToolType == 2 || this.mComposerModel.isPDFReader()) {
            this.mComposerModel.getModeManager().setMode(Mode.Writing, AbstractC2322a.m1626p(new StringBuilder(), TAG, ContentUtils.HASH_SYMBOL, str), true);
            return 0;
        }
        SoftInputManager softInputManager = this.mSoftInputManager;
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        softInputManager.blockToShow(true, AbstractC2322a.m1626p(sb, str2, ContentUtils.HASH_SYMBOL, str));
        if (this.mComposerModel.getModeManager().isComposerViewMode()) {
            this.mCompViewPresenter.getNoteManager().setCursorOnScreen(this.mCompViewPresenter.getPageManager().getDocPageInfo().getCurrentPageIndex());
        }
        this.mComposerModel.getModeManager().setMode(Mode.Text, AbstractC0541b.m757C(str2, ContentUtils.HASH_SYMBOL, str), true);
        this.mSoftInputManager.blockToShow(false, str2 + ContentUtils.HASH_SYMBOL + str);
        return 1;
    }

    public boolean checkNoServerPermission() {
        return this.mComposerModel.getModeManager().isComposerViewMode() && !this.mComposerModel.getCoeditAdapter().takeServerWritePermission();
    }

    public int releaseReadMode(String str) {
        ModeManager modeManager = this.mComposerModel.getModeManager();
        if (modeManager.isMode(Mode.ReadOnly)) {
            Mode prevMode = modeManager.getPrevMode();
            Mode mode = Mode.Text;
            if (prevMode == mode) {
                this.mSoftInputManager.blockToShow(true, "release read mode start");
                modeManager.setMode(mode, AbstractC2322a.m1626p(new StringBuilder(), TAG, ContentUtils.HASH_SYMBOL, str), true);
                this.mSoftInputManager.blockToShow(false, "release read mode end");
            } else {
                modeManager.setMode(Mode.Writing, AbstractC2322a.m1626p(new StringBuilder(), TAG, ContentUtils.HASH_SYMBOL, str), true);
            }
        } else if (modeManager.isComposerViewMode()) {
            return setCanvasModeFromLastToolType(str);
        }
        return 0;
    }

    public void setCursorAfterEditModeChange(int i, int i2) {
        if (1 == i) {
            this.mCompViewPresenter.getNoteManager().setCursorOnScreen(i2);
        }
    }

    public void setLastToolType(int i) {
        this.mLastToolType = i;
    }
}
