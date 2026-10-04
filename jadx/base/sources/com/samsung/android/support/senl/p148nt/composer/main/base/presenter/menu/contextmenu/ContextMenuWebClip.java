package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.AddPdfUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClipWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuWebClip extends ContextMenuItem {
    private static final String MAPS_URL_APP = "https://maps.app.goo.gl";
    private static final String MAPS_URL_WEB = "https://www.google.com/maps";
    private static final String TAG = Logger.createTag("ContextMenuWebClip");
    private final ComposerModel mComposerModel;
    private final ModeManager mModeManager;
    private final NoteManager mNoteManager;
    private final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    private final PdfManager mPdfManager;
    private final ScrollController mScrollController;
    private final TaskController mTaskController;
    private final TextManager mTextManager;

    public ContextMenuWebClip(ComposerViewPresenter composerViewPresenter, TaskController taskController) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mPageManager = composerViewPresenter.getPageManager();
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mScrollController = composerViewPresenter.getComposerControllerManager().getScrollController();
        this.mTaskController = taskController;
    }

    private void addWebClip(String str) {
        Logger.m11003i(TAG, "addWebClip#");
        this.mTaskController.execute(new TaskWebClipWrapper(), new TaskWebClipWrapper.InputValues(this.mActivity, this.mNoteManager, this.mPdfManager, this.mPageManager, this.mTextManager, this.mScrollController, str, this.mComposerModel.getCoeditAdapter().isCoeditNote(), this.mObjectManager, this.mComposerModel), new Task.Callback<TaskWebClip.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuWebClip.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskWebClip.ResultValues resultValues) {
                ContextMenuWebClip.this.showErrorToast(resultValues.getErrorCode());
                Logger.m11003i(ContextMenuWebClip.TAG, "add WebClip error: " + resultValues.getErrorCode());
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskWebClip.ResultValues resultValues) {
                ContextMenuWebClip.this.showErrorToast(resultValues.getErrorCode());
                ContextMenuWebClip.this.mNoteManager.updateInvertBackgroundColor();
                Logger.m11003i(ContextMenuWebClip.TAG, "add WebClip done");
            }
        }, false);
    }

    private boolean isMapUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(MAPS_URL_APP) || str.startsWith(MAPS_URL_WEB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToast(int i) {
        AbstractC8014b.m7217s(i, "showErrorToast#", TAG);
        AddPdfUtil.showErrorToast(this.mActivity, i, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_WEB_CLIP;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_web_clip).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList;
        if (!this.mComposerModel.isSingleMode() && this.mModeManager.isEditMode() && (selectedObjectList = this.mObjectManager.getSelectedObjectList()) != null && selectedObjectList.size() == 1) {
            SpenObjectBase spenObjectBase = selectedObjectList.get(0);
            if (spenObjectBase.getType() == 13) {
                String uri = ((SpenObjectWeb) spenObjectBase).getUri();
                return (TextUtils.isEmpty(uri) || isMapUri(uri)) ? false : true;
            }
            if (spenObjectBase.getType() == 17) {
                String option = ((SpenObjectLink) spenObjectBase).getOption();
                if (!TextUtils.isEmpty(option) && option.startsWith("http") && !isMapUri(option)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m11003i(str, "executeWebClipMenu#");
        SpenObjectBase spenObjectBase = this.mObjectManager.getSelectedObjectList().get(0);
        String uri = spenObjectBase instanceof SpenObjectWeb ? ((SpenObjectWeb) spenObjectBase).getUri() : spenObjectBase instanceof SpenObjectLink ? ((SpenObjectLink) spenObjectBase).getOption() : "";
        if (TextUtils.isEmpty(uri)) {
            Logger.m11000e(str, "url is empty");
        } else {
            addWebClip(uri);
            this.mObjectManager.clearSelectObject();
        }
    }
}
