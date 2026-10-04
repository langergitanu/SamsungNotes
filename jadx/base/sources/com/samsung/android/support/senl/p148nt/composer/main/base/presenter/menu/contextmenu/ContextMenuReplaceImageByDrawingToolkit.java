package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuReplaceImageByDrawingToolkit extends ContextMenuItem {
    private static final String TAG = Logger.createDynamicTemplateLog("ContextMenuReplaceImageByDrawingToolkit");
    private final DynamicTemplateController mDynamicTemplateController;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;

    public ContextMenuReplaceImageByDrawingToolkit(ComposerViewPresenter composerViewPresenter, DynamicTemplateController dynamicTemplateController) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mDynamicTemplateController = dynamicTemplateController;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REPLACE_IMAGE_BY_DRAWING_TOOLKIT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_generate_new_image).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        ArrayList<SpenObjectBase> selectedSafeObjectList;
        if (this.mModeManager.isEditMode() && AiDrawingUtil.isDrawingToolkitUsed() && (selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList()) != null && selectedSafeObjectList.size() == 1) {
            SpenObjectBase spenObjectBase = selectedSafeObjectList.get(0);
            if (spenObjectBase instanceof SpenObjectImage) {
                SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBase;
                if (DynamicTemplateUtil.isDynamicTemplateObject(spenObjectImage) && DynamicTemplateUtil.isInsertGeneratedImageActionObject(spenObjectImage)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeMenu#");
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList == null || selectedSafeObjectList.size() != 1) {
            return;
        }
        this.mDynamicTemplateController.showDrawingToolkitsPopOver(selectedSafeObjectList.get(0));
    }
}
