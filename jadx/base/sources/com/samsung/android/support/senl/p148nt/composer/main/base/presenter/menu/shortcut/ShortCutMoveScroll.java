package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.view.KeyEvent;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutMoveScroll extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutMoveScroll");
    private final ActionManager mActionManager;
    private final boolean mIsUpOrLeft;
    private final boolean mIsVertical;
    private final ModeManager mModeManager;

    public ShortCutMoveScroll(ModeManager modeManager, ActionManager actionManager, boolean z, boolean z2) {
        this.mModeManager = modeManager;
        this.mActionManager = actionManager;
        this.mIsVertical = z;
        this.mIsUpOrLeft = z2;
        if (z) {
            if (z2) {
                setShortcut(Shortcut.ScrollUp);
                return;
            } else {
                setShortcut(Shortcut.ScrollDown);
                return;
            }
        }
        if (z2) {
            setShortcut(Shortcut.ScrollLeft);
        } else {
            setShortcut(Shortcut.ScrollRight);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction(KeyEvent keyEvent) {
        String str = TAG;
        Logger.m11003i(str, "doAction# ");
        if (this.mModeManager.isMode(Mode.Text)) {
            return false;
        }
        return this.mActionManager.doAction(this.mIsVertical ? ActionManager.ActionType.MoveVerticalScroll : ActionManager.ActionType.MoveHorizontalScroll, str, Boolean.valueOf(this.mIsUpOrLeft));
    }
}
