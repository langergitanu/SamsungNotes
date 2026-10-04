package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutFind extends AbsShortCutAction {
    private static final String TAG = Logger.createTag("ShortCutFind");
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final CompListPresenter mListPresenter;
    private final OptionMenuPresenter mOptionMenuPresenter;

    public ShortCutFind(ComposerViewPresenter composerViewPresenter, CompListPresenter compListPresenter, OptionMenuPresenter optionMenuPresenter) {
        super(Shortcut.Find);
        this.mComposerViewPresenter = composerViewPresenter;
        this.mListPresenter = compListPresenter;
        this.mOptionMenuPresenter = optionMenuPresenter;
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction
    public boolean doAction() {
        String str = TAG;
        Logger.m10999d(str, "doAction# ");
        if (this.mListPresenter.onKeyEvent(getKeyCode())) {
            Logger.m10999d(str, "doAction#, SortPage consumed a key event");
            return true;
        }
        Mode mode = this.mComposerModel.getModeManager().getMode();
        if (this.mComposerModel.isSupportedViewMode()) {
            if (mode != Mode.View) {
                return false;
            }
        } else if (mode != Mode.View && mode != Mode.Text && mode != Mode.Writing && mode != Mode.ReadOnly) {
            return false;
        }
        if (this.mOptionMenuPresenter.isTranslationOverlayActivated()) {
            Logger.m10999d(str, "doAction#, translation overlay is enabled");
            return true;
        }
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
        this.mComposerModel.getModeManager().setMode(Mode.Search, "ShortCutFind", true);
        return true;
    }
}
