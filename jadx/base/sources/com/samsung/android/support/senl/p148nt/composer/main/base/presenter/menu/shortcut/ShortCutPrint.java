package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutPrint extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutPrint");
    private final ActionManager mActionManager;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final OptionMenuPresenter mOptionMenuPresenter;

    public ShortCutPrint(ComposerViewPresenter composerViewPresenter, ActionManager actionManager, OptionMenuPresenter optionMenuPresenter) {
        setShortcut(Shortcut.Print);
        this.mComposerViewPresenter = composerViewPresenter;
        this.mActionManager = actionManager;
        this.mOptionMenuPresenter = optionMenuPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
        if (!UserInputSkipper.isValidEvent(tag)) {
            Logger.m11004w(TAG, "doAction# skip UserInputSkipper");
            return false;
        }
        if (this.mComposerViewPresenter.getComposerModel().isTranslatedPDFNote()) {
            Logger.m10999d(TAG, "doAction#, cannot print translated pdf note");
            return true;
        }
        if (this.mOptionMenuPresenter.isTranslationOverlayActivated()) {
            Logger.m10999d(TAG, "doAction#, translation overlay is enabled");
            return true;
        }
        UserInputSkipper.setHoldingEventTime(tag);
        String str = TAG;
        Logger.m10999d(str, "doAction# ");
        return this.mActionManager.doAction(ActionManager.ActionType.Print, str);
    }
}
