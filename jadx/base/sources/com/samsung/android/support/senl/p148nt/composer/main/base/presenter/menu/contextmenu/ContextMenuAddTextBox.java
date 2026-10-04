package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.graphics.PointF;
import android.view.Menu;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuAddTextBox extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuAddTextBox");
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;

    public ContextMenuAddTextBox(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ADD_TEXT_BOX;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_add_text_box).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.mModeManager.isEditMode()) {
            return false;
        }
        if (this.mObjectManager.getSelectedObjectList() == null || this.mObjectManager.getSelectedObjectList().isEmpty()) {
            return true;
        }
        return this.mObjectManager.isSelectedTextBox() && this.mObjectManager.getSelectedObjectPageList() == null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        PointF pointF;
        String str = TAG;
        Logger.addFileLog(str, "CTXAddTextBox", 0);
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.composer_text_box_margin);
        PointF pastePosition = this.mObjectManager.getPastePosition();
        if (this.mObjectManager.isValidPosition(pastePosition)) {
            pointF = new PointF(pastePosition.x, pastePosition.y);
            float f = dimensionPixelSize;
            if (pointF.x < f) {
                pointF.x = f;
            }
        } else {
            float f4 = dimensionPixelSize;
            pointF = new PointF(f4, f4);
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_INSERT_TEXT_BOX);
        Logger.m10999d(str, "executeAddTextBoxMenu# ");
        this.mObjectManager.addTextBox(pointF);
        this.mModeManager.setMode(Mode.Text, "add textbox from contextmenu", true);
    }
}
