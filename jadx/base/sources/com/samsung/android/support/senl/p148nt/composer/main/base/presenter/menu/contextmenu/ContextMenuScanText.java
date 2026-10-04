package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuScanText extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuScanText");
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final TextManager mTextManager;

    public ContextMenuScanText(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTextManager = composerViewPresenter.getTextManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SCAN_TEXT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_scan_text).setEnabled(canShow());
    }

    public boolean canScanText() {
        if (!FeatureInfo.isEnabledScanText()) {
            return false;
        }
        InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
        Activity activity = this.mActivity;
        if (inputMethodCompat.canShowHoneyBoardSIP(activity, activity.getCurrentFocus())) {
            return DeviceInfo.getSemPlatformVersionInt(0) >= 130100;
        }
        Logger.m11003i(TAG, "canShowClipboardOnSIP# canShowHoneyBoardSIP is false");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (this.mModeManager.isEditMode() && this.mObjectManager.isFocusedTextBox() && !this.mTextManager.isSelected() && DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.mActivity)) {
            return canScanText();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeScanTextMenu#");
        Bundle bundle = new Bundle();
        bundle.putString("board", InputMethodCompat.EXTRA_VALUE_BOARD_EAGLE_EYE);
        InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
        Activity activity = this.mActivity;
        inputMethodCompat.showSoftInput(activity, activity.getCurrentFocus(), bundle);
    }
}
