package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.DictionaryHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuDictionary extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuDictionary");
    private final ObjectManager mObjectManager;
    private final PdfManager mPdfManager;
    private final TextManager mTextManager;

    public ContextMenuDictionary(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_DICTIONARY;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_dictionary).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        boolean zHasSelectedText = this.mPdfManager.hasSelectedText();
        String selectedText = this.mPdfManager.getSelectedText();
        if (zHasSelectedText && !TextUtils.isEmpty(selectedText)) {
            Logger.m11003i(TAG, "canShow# hasSelectedPdfText length = " + selectedText.length());
            return DictionaryHelper.isDictionaryEnabled(this.mActivity);
        }
        if (!this.mObjectManager.isFocusedTextBox()) {
            return false;
        }
        String selectedText2 = this.mTextManager.getSelectedText();
        if (TextUtils.isEmpty(selectedText2)) {
            return false;
        }
        int length = selectedText2.length();
        for (int i = 0; i < length; i++) {
            if (selectedText2.charAt(i) == 65532) {
                return false;
            }
        }
        return DictionaryHelper.isDictionaryEnabled(this.mActivity);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        ComposerSA.insertLog((String) null, ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "3");
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CTX_DICTIONARY);
        boolean zHasSelectedText = this.mPdfManager.hasSelectedText();
        AbstractC8014b.m7220v("executeDictionaryMenu# hasSelectedPdfText:", TAG, zHasSelectedText);
        String selectedText = zHasSelectedText ? this.mPdfManager.getSelectedText() : this.mTextManager.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            return;
        }
        DictionaryHelper.executeDictionary(this.mActivity, selectedText);
        this.mObjectManager.clearSelectObject();
    }
}
