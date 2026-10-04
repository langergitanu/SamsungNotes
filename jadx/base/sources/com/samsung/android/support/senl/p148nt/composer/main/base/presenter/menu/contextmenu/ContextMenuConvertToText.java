package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.graphics.PointF;
import android.view.Menu;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LanguageUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuConvertToText extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuConvertToText");
    private HwToolbarPresenter mHwToolbarPresenter;
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;
    private PdfManager mPdfManager;
    private WritingToolManager mWritingToolManager;

    public ContextMenuConvertToText(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mWritingToolManager = composerViewPresenter.getWritingToolManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mPdfManager = composerViewPresenter.getPdfManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_TEXT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.hw_toolbar_convert_to_text).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!RecognitionUtil.isSupported(this.mActivity) || !this.mModeManager.isMode(Mode.Writing) || this.mPdfManager.hasSelectedPDF()) {
            return false;
        }
        ObjectManager objectManager = this.mObjectManager;
        if (objectManager.isValidPosition(objectManager.getPastePosition()) && !this.mHwToolbarPresenter.isCoeditNote()) {
            return this.mObjectManager.getSelectedObjectList() == null || this.mObjectManager.getSelectedObjectList().isEmpty();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        PointF pastePosition = this.mObjectManager.getPastePosition();
        Logger.m10999d(TAG, "executeConvertToTextMenu#" + pastePosition);
        try {
            if (this.mWritingToolManager.executeConvertToText(pastePosition, LanguageUtil.getConvertToTextLanguage(this.mActivity))) {
                this.mHwToolbarPresenter.offEasyWritingPad();
            } else {
                ToastHandler.show(this.mActivity, C9086R.string.composer_could_not_find_any_handwriting, 1);
            }
        } catch (TextRecognitionLanguage.SupportedLanguageException e) {
            Logger.m11000e(TAG, "executeConvertToTextMenu#, e : " + e.getMessage());
        }
        ComposerSA.insertLog("411", ComposerSAConstants.EVENT_WRITING_CTX_CONVERT_TO_TEXT);
    }
}
