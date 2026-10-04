package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutPageZoom extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutPageZoom");
    private final ActionManager mActionManager;
    private final ComposerState mComposerState;
    private final boolean mIsZoomIn;

    public ShortCutPageZoom(ActionManager actionManager, ComposerState composerState, boolean z) {
        this.mActionManager = actionManager;
        this.mComposerState = composerState;
        this.mIsZoomIn = z;
        if (z) {
            setShortcut(Shortcut.ZoomIn);
        } else {
            setShortcut(Shortcut.ZoomOut);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        Logger.m11003i(TAG, "doAction# ");
        if (AiDrawingUtil.isPopupShowingState(this.mComposerState.getAiDrawingState())) {
            return false;
        }
        return this.mActionManager.doAction(this.mIsZoomIn ? ActionManager.ActionType.ZoomIn : ActionManager.ActionType.ZoomOut);
    }
}
