package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuAlignment extends ContextMenuRecognitionBase {
    private static final String TAG = Logger.createTag("ContextMenuAlignment");
    private final HwToolbarPresenter mHwToolbarPresenter;
    private final WritingToolManager mWritingToolManager;

    public ContextMenuAlignment(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter) {
        super(composerViewPresenter.getObjectManager(), composerViewPresenter.getComposerModel().getModeManager());
        this.mWritingToolManager = composerViewPresenter.getWritingToolManager();
        this.mHwToolbarPresenter = hwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        int i = C9086R.string.composer_ctx_menu_alignment;
        if (!FeatureInfo.isBeautifierFeatureEnabled()) {
            i = C9086R.string.composer_ctx_menu_legacy_alignment;
        }
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_ALIGNMENT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), i).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        boolean zExecuteSelectionAlignment;
        String str = TAG;
        Logger.m10999d(str, "executeAlignmentMenu#" + this.mObjectManager.getSelectedObjectList().size());
        if (FeatureInfo.isBeautifierFeatureEnabled()) {
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().applyAlignmentOptions();
            zExecuteSelectionAlignment = this.mWritingToolManager.executeSelectionCleanUp();
        } else {
            zExecuteSelectionAlignment = this.mWritingToolManager.executeSelectionAlignment();
        }
        if (zExecuteSelectionAlignment) {
            Logger.addFileLog(str, "CTXAlign", 0);
            this.mHwToolbarPresenter.offEasyWritingPad();
        } else {
            ToastHandler.show(this.mActivity, C9086R.string.composer_could_not_find_any_handwriting, 1);
        }
        this.mObjectManager.clearSelectObject();
        ComposerSA.insertLog("411", ComposerSAConstants.EVENT_WRITING_CTX_STRAIGHTEN);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuRecognitionBase
    public boolean isAvailableMode() {
        if (this.mHwToolbarPresenter.isCoeditNote()) {
            return false;
        }
        return super.isAvailableMode();
    }
}
