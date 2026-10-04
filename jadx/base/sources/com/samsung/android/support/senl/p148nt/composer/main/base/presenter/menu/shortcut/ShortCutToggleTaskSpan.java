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
public class ShortCutToggleTaskSpan extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutToggleTaskSpan");
    private final ModeManager mModeManager;
    private final RtToolbarPresenter mRtToolbarPresenter;
    private final int mTaskType;

    public ShortCutToggleTaskSpan(ModeManager modeManager, RtToolbarPresenter rtToolbarPresenter, int i) {
        this.mModeManager = modeManager;
        this.mRtToolbarPresenter = rtToolbarPresenter;
        this.mTaskType = i;
        setKeyCode(i);
    }

    private void setKeyCode(int i) {
        if (i == 2) {
            setShortcut(Shortcut.TaskSpanTodo);
            return;
        }
        if (i == 4) {
            setShortcut(Shortcut.TaskSpanNumbering);
        } else if (i != 8) {
            setShortcut(Shortcut.None);
        } else {
            setShortcut(Shortcut.TaskSpanBullet);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        AbstractC8014b.m7221w(new StringBuilder("doAction# "), TAG, this.mTaskType);
        if (!this.mModeManager.isMode(Mode.Text)) {
            return false;
        }
        this.mRtToolbarPresenter.toggleTask(this.mTaskType);
        return true;
    }
}
