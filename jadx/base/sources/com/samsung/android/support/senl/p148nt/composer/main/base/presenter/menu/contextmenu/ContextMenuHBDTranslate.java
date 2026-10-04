package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuHBDTranslate extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuHBDTranslate");
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final TextManager mTextManager;

    public ContextMenuHBDTranslate(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTextManager = composerViewPresenter.getTextManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_HBD_TRANSLATE;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_hbd_translate).setEnabled(canShow());
    }

    public boolean canHBDTranslate() {
        if (!DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.mActivity)) {
            return false;
        }
        InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
        Activity activity = this.mActivity;
        if (inputMethodCompat.canShowHoneyBoardSIP(activity, activity.getCurrentFocus())) {
            return DeviceInfo.getSemPlatformVersionInt(0) > 130100;
        }
        Logger.m11003i(TAG, "canHBDTranslate# canShowHoneyBoardSIP is false");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!canHBDTranslate() || !this.mModeManager.isEditMode() || !this.mObjectManager.isFocusedTextBox()) {
            return false;
        }
        String selectedText = this.mTextManager.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            return false;
        }
        int length = selectedText.length();
        for (int i = 0; i < length; i++) {
            if (selectedText.charAt(i) == 65532) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeHBDTranslateMenu#");
        Bundle bundle = new Bundle();
        bundle.putString("board", InputMethodCompat.EXTRA_VALUE_BOARD_HBD_TRANSLATE);
        InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
        Activity activity = this.mActivity;
        inputMethodCompat.showSoftInput(activity, activity.getCurrentFocus(), bundle);
    }
}
