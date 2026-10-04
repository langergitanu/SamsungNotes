package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuSAUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuSelectAll extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuSelectAll");
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final TextManager mTextManager;

    public ContextMenuSelectAll(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTextManager = composerViewPresenter.getTextManager();
    }

    private boolean canSelectAllText(SpenObjectShape spenObjectShape, int[] iArr) {
        return (spenObjectShape.getText() == null || spenObjectShape.getText().isEmpty() || (iArr[0] == 0 && iArr[1] == spenObjectShape.getText().length())) ? false : true;
    }

    private boolean canShowObjectSpan() {
        return canSelectAllText(this.mObjectManager.getNote().getBodyText(), new ObjectSpanHelper(this.mObjectManager.getNote()).findObjectSpanCursorPosition(this.mObjectManager.getSelectedObjectList()));
    }

    private boolean canShowText() {
        if (!this.mModeManager.isEditMode() && TextUtils.isEmpty(this.mTextManager.getSelectedText())) {
            return false;
        }
        SpenObjectShape textBox = this.mTextManager.getTextBox();
        return canSelectAllText(textBox, this.mTextManager.getCursor(textBox));
    }

    private void executeText() {
        SpenObjectShape textBox = this.mTextManager.getTextBox();
        String text = textBox.getText();
        if (text == null) {
            return;
        }
        if (this.mModeManager.isEditMode()) {
            Logger.addFileLog(TAG, "CTXSelectAll: " + text.length(), 0);
        }
        textBox.setSelection(0, text.length());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_select_all).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (this.mTextManager.hasFocusedTextBox() || this.mObjectManager.isFocusedTextBox()) {
            return canShowText();
        }
        if (this.mObjectManager.isSelectedObjectOfObjectSpan()) {
            return canShowObjectSpan();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        ComposerSA.insertLog((String) null, ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "5");
        if (this.mModeManager.isEditMode()) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CTX_SELECT_ALL, MenuSAUtils.getSADetailValue(null, this.mObjectManager));
        } else {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_CTX_SELECT_ALL, MenuSAUtils.getSADetailValue(null, this.mObjectManager));
        }
        if (this.mTextManager.hasFocusedTextBox() || this.mObjectManager.isFocusedTextBox()) {
            executeText();
        } else if (this.mObjectManager.isSelectedObjectOfObjectSpan()) {
            this.mObjectManager.getNote().selectObject(this.mObjectManager.getNote().getBodyText());
            executeText();
        }
    }
}
