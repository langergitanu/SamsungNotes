package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutSeekAudio extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutSeekAudio");
    private final ActionManager mActionManager;
    private final boolean mIsForward;

    public ShortCutSeekAudio(ActionManager actionManager, boolean z) {
        this.mIsForward = z;
        if (z) {
            setShortcut(Shortcut.SeekAudioForward);
        } else {
            setShortcut(Shortcut.SeekAudioBackward);
        }
        this.mActionManager = actionManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        String str = TAG;
        Logger.m10999d(str, "doAction# ");
        return this.mActionManager.doAction(this.mIsForward ? ActionManager.ActionType.SeekForward : ActionManager.ActionType.SeekRewind, str);
    }
}
