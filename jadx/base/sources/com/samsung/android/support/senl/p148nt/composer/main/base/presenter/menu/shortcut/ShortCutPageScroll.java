package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutPageScroll extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutPageScroll");
    private final ComposerState mComposerState;
    private final boolean mIsPrevious;
    private final ModeManager mModeManager;
    private final ScrollController mScrollController;

    public ShortCutPageScroll(ModeManager modeManager, ScrollController scrollController, ComposerState composerState, boolean z) {
        this.mModeManager = modeManager;
        this.mScrollController = scrollController;
        this.mComposerState = composerState;
        this.mIsPrevious = z;
        if (z) {
            setShortcut(Shortcut.PageScrollUp);
        } else {
            setShortcut(Shortcut.PageScrollDown);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        Logger.m11003i(TAG, "doAction# ");
        if ((this.mModeManager.isMode(Mode.Text) && !isBLEEvent(keyEvent)) || AiDrawingUtil.isPopupShowingState(this.mComposerState.getAiDrawingState())) {
            return false;
        }
        this.mScrollController.pageScroll(this.mIsPrevious);
        return true;
    }
}
