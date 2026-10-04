package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.PointF;
import android.view.Menu;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuPaste extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuPaste");
    private final AiMenuManager mAiMenuManager;
    private final ClipboardController mClipboardController;
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ModeManager mModeManager;
    private final NoteManager mNoteManager;
    protected final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    private final PdfManager mPdfManager;
    public boolean mPlainTextFlags = false;
    private final SoftInputManager mSoftInputManager;
    private final TextManager mTextManager;

    public ContextMenuPaste(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, AiMenuManager aiMenuManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mPageManager = composerViewPresenter.getPageManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mClipboardController = controllerManager.getClipboardController();
        this.mAiMenuManager = aiMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_paste).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.mComposerModel.getModeManager().isSubModeEnabled() && this.mModeManager.isEditMode()) {
            return checkClipData();
        }
        return false;
    }

    public boolean checkClipData() {
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        return companion.getInstance().hasPrimaryClip(this.mActivity, companion.getInstance().getTypeAll());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        insertSALog();
        executeTaskPaste(this.mClipboardController.getPastePosition());
    }

    public void executeTaskPaste(PointF pointF) {
        String str = TAG;
        Logger.m11003i(str, "executeTaskPaste# " + pointF);
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        ClipData primaryClip = companion.getInstance().getPrimaryClip(this.mActivity, companion.getInstance().getTypeAll());
        if (primaryClip == null) {
            Logger.m11000e(str, "executeTaskPaste# clipData is null.");
            return;
        }
        Activity activity = this.mActivity;
        ComposerModel composerModel = this.mComposerModel;
        ObjectManager objectManager = this.mObjectManager;
        NoteManager noteManager = this.mNoteManager;
        PageManager pageManager = this.mPageManager;
        TaskPaste.InputValues inputValues = new TaskPaste.InputValues(activity, primaryClip, composerModel, objectManager, noteManager, pageManager, this.mTextManager, this.mPdfManager, pageManager.getDocPageInfo().getCurrentPageIndex(), pointF, new TaskPaste.ISoftInputController() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPaste.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPaste.ISoftInputController
            public void blockToShow(boolean z, String str2) {
                ContextMenuPaste.this.mSoftInputManager.blockToShow(z, str2);
            }
        }, this.mPlainTextFlags);
        if (FeatureInfo.isAiFeatureEnabled() && this.mComposerModel.getDoc().getBodyText() != null) {
            inputValues.setAiSuggestionAction(this.mAiMenuManager.getRunnableAiSuggestionForAutoFormat());
        }
        this.mClipboardController.executeTaskPaste(primaryClip, inputValues);
    }

    public void insertSALog() {
        ComposerSA.insertStatusLog(ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "4");
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_PASTE);
    }
}
