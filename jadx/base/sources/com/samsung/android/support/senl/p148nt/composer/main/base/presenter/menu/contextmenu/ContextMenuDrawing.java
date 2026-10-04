package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExecuteOtherActivityController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuDrawing extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuDrawing");
    private ExecuteOtherActivityController mExecuteOtherActivityController;
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;
    private ComposerViewPresenter mPresenter;

    public ContextMenuDrawing(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mExecuteOtherActivityController = controllerManager.getExecuteOtherActivityController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_DRAWING;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_drawing).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        ArrayList<SpenObjectBase> selectedSafeObjectList;
        if (this.mModeManager.isEditMode() && (selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList()) != null && selectedSafeObjectList.size() == 1 && selectedSafeObjectList.get(0).getType() == 14) {
            return !selectedSafeObjectList.get(0).getLockState();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeDrawing#");
        SpenObjectPainting spenObjectPainting = (SpenObjectPainting) this.mObjectManager.getSelectedSafeObjectList().get(0);
        this.mObjectManager.setClickedObject(spenObjectPainting);
        this.mPresenter.requestReadyForSave();
        this.mExecuteOtherActivityController.executeBrush(spenObjectPainting.getId(), spenObjectPainting.getAttachedFile(), spenObjectPainting.getThumbnailPath());
        this.mObjectManager.clearSelectObject();
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_BRUSH_DRAWING);
    }
}
