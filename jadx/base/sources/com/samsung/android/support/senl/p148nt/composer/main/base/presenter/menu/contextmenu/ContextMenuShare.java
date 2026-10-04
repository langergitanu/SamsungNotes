package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.text.TextUtils;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuSAUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareSelectedItems;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuShare extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuShare");
    private final ComposerModel mComposerModel;
    protected final KeyguardPresenter mKeyguardPresenter;
    private final ObjectManager mObjectManager;
    private final PdfManager mPdfManager;
    private final TaskController mTaskController;
    private final TextManager mTextManager;

    public ContextMenuShare(ComposerViewPresenter composerViewPresenter, TaskController taskController) {
        this.mKeyguardPresenter = composerViewPresenter.getKeyguardPresenter();
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mTaskController = taskController;
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SHARE;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_share).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        boolean zIsEmpty;
        if (this.mComposerModel.getComposerState().isSecured()) {
            return false;
        }
        if ((this.mComposerModel.getNotesDocEntityManager().isLocked() && !DeviceUtils.isSupportedFileProvider()) || this.mObjectManager.isObjectPlotSelected()) {
            return false;
        }
        if (this.mPdfManager.hasSelectedPDF()) {
            return true;
        }
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList == null || selectedSafeObjectList.isEmpty()) {
            return false;
        }
        if (!this.mTextManager.hasFocusedTextBox()) {
            if (selectedSafeObjectList.size() == 1) {
                SpenObjectBase spenObjectBase = selectedSafeObjectList.get(0);
                if (spenObjectBase.getType() == 2) {
                    zIsEmpty = TextUtils.isEmpty(((SpenObjectShape) spenObjectBase).getText());
                }
            }
            Iterator<SpenObjectBase> it = selectedSafeObjectList.iterator();
            while (it.hasNext()) {
                if (ObjectTypeUtil.isStrokeType(it.next().getType())) {
                    return false;
                }
            }
            return true;
        }
        zIsEmpty = TextUtils.isEmpty(this.mTextManager.getSelectedText());
        return !zIsEmpty;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m10999d(str, "executeShareMenu#");
        ComposerSA.insertLog((String) null, ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "6");
        ComposerSA.insertLog(this.mComposerModel.getModeManager().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_CTX_SHARE, MenuSAUtils.getSADetailValue(this.mPdfManager, this.mObjectManager));
        if (!this.mObjectManager.getSelectedSafeObjectList().isEmpty() || this.mPdfManager.hasSelectedPDF()) {
            TaskShareSelectedItems.InputValues inputValues = new TaskShareSelectedItems.InputValues(this.mActivity, this.mObjectManager, this.mPdfManager);
            if (ShareUtils.isNotSupportedFileProviderForChina()) {
                String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
                if (!PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
                    Logger.m10999d(str, "to get WRITE_EXTERNAL_STORAGE permission");
                    Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().findFragmentByTag("Composer");
                    if (fragmentFindFragmentByTag != null) {
                        PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 110, storagePermissions);
                        this.mTaskController.setPendingTask(new TaskShareSelectedItems(), inputValues, null, false);
                        return;
                    }
                    return;
                }
            }
            this.mTaskController.execute(new TaskShareSelectedItems(), inputValues, new Task.Callback<TaskShareSelectedItems.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuShare.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskShareSelectedItems.ResultValues resultValues) {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskShareSelectedItems.ResultValues resultValues) {
                    ContextMenuShare.this.mObjectManager.clearSelection();
                    if (resultValues != null) {
                        resultValues.getPostAction().run();
                    }
                }
            }, false);
        }
    }
}
