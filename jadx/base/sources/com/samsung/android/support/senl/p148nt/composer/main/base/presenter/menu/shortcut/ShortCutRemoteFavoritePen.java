package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutRemoteFavoritePen extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutRemoteFavoritePen");
    private final ComposerState mComposerState;
    private final HwToolbarPresenter mHwToolbarPresenter;
    private boolean mIsForward;

    public ShortCutRemoteFavoritePen(HwToolbarPresenter hwToolbarPresenter, ComposerState composerState, boolean z) {
        this.mIsForward = true;
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mComposerState = composerState;
        if (z) {
            setShortcut(Shortcut.RemoteFavoritePenForward);
        } else {
            this.mIsForward = false;
            setShortcut(Shortcut.RemoteFavoritePenBackward);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        Logger.m10999d(TAG, "doAction# ");
        if (!isBLEEvent(keyEvent) || AiDrawingUtil.isRemoteFavoritePenChangedNotAllowedState(this.mComposerState.getAiDrawingState())) {
            return false;
        }
        this.mHwToolbarPresenter.executeRemoteFavoritePen(this.mIsForward);
        return true;
    }
}
