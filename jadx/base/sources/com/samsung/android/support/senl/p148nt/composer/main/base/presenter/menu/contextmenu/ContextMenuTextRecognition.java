package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LanguageUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuTextRecognition extends ContextMenuRecognitionBase {
    private static final String TAG = Logger.createTag("ContextMenuTextRecognition");
    private HwToolbarPresenter mHwToolbarPresenter;
    private WritingToolManager mWritingToolManager;

    public ContextMenuTextRecognition(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter) {
        super(composerViewPresenter.getObjectManager(), composerViewPresenter.getComposerModel().getModeManager());
        this.mWritingToolManager = composerViewPresenter.getWritingToolManager();
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_RECOGNITION;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.hw_toolbar_convert_to_text).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuRecognitionBase, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        return super.canShow();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeTextRecognitionMenu#" + this.mObjectManager.getSelectedObjectList().size());
        try {
            if (this.mWritingToolManager.executeExtractText(LanguageUtil.getConvertToTextLanguage(this.mActivity))) {
                this.mHwToolbarPresenter.offEasyWritingPad();
            } else {
                ToastHandler.show(this.mActivity, C9086R.string.composer_could_not_find_any_handwriting, 1);
            }
        } catch (TextRecognitionLanguage.SupportedLanguageException e) {
            Logger.m11000e(TAG, "executeTextRecognitionMenu#, e : " + e.getMessage());
        }
        ComposerSA.insertLog("411", ComposerSAConstants.EVENT_WRITING_CTX_CONVERT_TO_TEXT);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuRecognitionBase
    public boolean isAvailableMode() {
        if (this.mHwToolbarPresenter.isCoeditNote()) {
            return false;
        }
        return this.mModeManager.isMode(Mode.Writing);
    }
}
