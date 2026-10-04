package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuCrop extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuCrop");
    boolean mIsSupportedPainting = true;
    ModeManager mModeManager;
    ObjectManager mObjectManager;

    public ContextMenuCrop(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CROP;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_crop).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        return isAvailableToCropImage(this.mModeManager, this.mObjectManager);
    }

    public void execute() {
        this.mObjectManager.setImageEditable(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        int size = selectedSafeObjectList != null ? selectedSafeObjectList.size() : 0;
        AbstractC0000a.m3D(size, "executeMenu#", getLogTag());
        if (size != 1) {
            return;
        }
        int type = selectedSafeObjectList.get(0).getType();
        if (type == 3) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CROP, "2");
        } else if (type == 14) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_BRUSH_CROP, "3");
        }
        execute();
    }

    public String getLogTag() {
        return TAG;
    }

    public boolean isAvailableToCropImage(ModeManager modeManager, ObjectManager objectManager) {
        ArrayList<SpenObjectBase> selectedSafeObjectList;
        if (modeManager.isEditMode() && (selectedSafeObjectList = objectManager.getSelectedSafeObjectList()) != null && selectedSafeObjectList.size() == 1) {
            for (SpenObjectBase spenObjectBase : selectedSafeObjectList) {
                String imagePath = spenObjectBase.getType() == 3 ? ((SpenObjectImage) spenObjectBase).getImagePath() : (this.mIsSupportedPainting && spenObjectBase.getType() == 14) ? ((SpenObjectPainting) spenObjectBase).getThumbnailPath() : null;
                if (!TextUtils.isEmpty(imagePath) && !imagePath.toLowerCase().endsWith(Constants.THUMBNAIL_GIF_EXTENSION)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }
}
