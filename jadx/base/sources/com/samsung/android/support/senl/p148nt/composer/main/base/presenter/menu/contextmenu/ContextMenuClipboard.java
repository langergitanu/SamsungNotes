package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.view.Menu;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuClipboard extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuClipboard");
    private final ClipboardController mClipboardController;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final SoftInputManager mSoftInputManager;

    public ContextMenuClipboard(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mClipboardController = controllerManager.getClipboardController();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_clipboard_n).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.mModeManager.isEditMode() || !DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.mActivity) || this.mObjectManager.isObjectPlotSelected()) {
            return false;
        }
        ClipboardManagerCompat companion = ClipboardManagerCompat.INSTANCE.getInstance();
        Activity activity = this.mActivity;
        return companion.canShowClipboard(activity, activity.getCurrentFocus());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeClipboardMenu#");
        ComposerSA.insertLog((String) null, ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "7");
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CLIPBOARD);
        this.mObjectManager.clearSelection();
        int typeAll = ClipboardManagerCompat.INSTANCE.getInstance().getTypeAll();
        this.mClipboardController.setClipboardFilter(typeAll, "executeClipboardMenu");
        this.mClipboardController.showClipboard(typeAll);
    }

    public void setClearSkip(boolean z) {
        if (z) {
            return;
        }
        this.mSoftInputManager.setClearSkip(true);
    }
}
