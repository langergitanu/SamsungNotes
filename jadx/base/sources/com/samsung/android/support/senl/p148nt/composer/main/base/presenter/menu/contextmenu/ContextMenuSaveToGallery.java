package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuSAUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSaveToGallery;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuSaveToGallery extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuSaveToGallery");
    protected final KeyguardPresenter mKeyguardPresenter;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final TaskController mTaskController;

    public ContextMenuSaveToGallery(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mKeyguardPresenter = composerViewPresenter.getKeyguardPresenter();
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTaskController = controllerManager.getTaskController();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SAVE_TO_GALLERY;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_save_to_gallery).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList.isEmpty()) {
            return false;
        }
        for (SpenObjectBase spenObjectBase : selectedSafeObjectList) {
            if (spenObjectBase.getType() != 3 && spenObjectBase.getType() != 14) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m11003i(str, "executeSaveToGalleryMenu#" + this.mObjectManager.getSelectedSafeObjectList().size());
        ComposerSA.insertLog(this.mModeManager.isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_CTX_SAVEINGALLERY, MenuSAUtils.getSADetailValue(null, this.mObjectManager));
        TaskSaveToGallery.InputValues inputValues = new TaskSaveToGallery.InputValues(this.mActivity, this.mObjectManager);
        Task.Callback<TaskSaveToGallery.ResultValues> callback = new Task.Callback<TaskSaveToGallery.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSaveToGallery.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskSaveToGallery.ResultValues resultValues) {
                ToastHandler.show(ContextMenuSaveToGallery.this.mActivity, C9086R.string.composer_save_to_image_fail, 1);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskSaveToGallery.ResultValues resultValues) {
                ContextMenuSaveToGallery.this.mObjectManager.clearSelectObject();
                ToastHandler.show(ContextMenuSaveToGallery.this.mActivity, C9086R.string.composer_save_to_image_done, 1);
            }
        };
        String[] storagePermissions = PermissionCompat.getStoragePermissions(6);
        if (PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
            this.mTaskController.execute(new TaskSaveToGallery(), inputValues, callback, false);
            return;
        }
        Logger.m11003i(str, "to get WRITE_EXTERNAL_STORAGE permission");
        Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().findFragmentByTag("Composer");
        if (fragmentFindFragmentByTag != null) {
            PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 107, storagePermissions);
            this.mTaskController.setPendingTask(new TaskSaveToGallery(), inputValues, callback, false);
        }
    }
}
