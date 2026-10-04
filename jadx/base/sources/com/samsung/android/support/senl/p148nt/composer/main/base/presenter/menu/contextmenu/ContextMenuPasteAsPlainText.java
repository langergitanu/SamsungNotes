package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.content.ClipDescription;
import android.os.Build;
import android.view.Menu;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuPasteAsPlainText extends ContextMenuPaste {
    private static final String TAG = Logger.createTag("ContextMenuPasteAsPlainText");

    public ContextMenuPasteAsPlainText(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, AiMenuManager aiMenuManager) {
        super(composerViewPresenter, controllerManager, aiMenuManager);
        this.mPlainTextFlags = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPaste, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE_AS_PLAIN_TEXT;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_paste_as_plain_text).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPaste
    public boolean checkClipData() {
        if (Build.VERSION.SDK_INT >= 31 && this.mObjectManager.isFocusedTextBox()) {
            ClipDescription primaryClipDescription = ClipboardManagerCompat.INSTANCE.getInstance().getPrimaryClipDescription(this.mActivity);
            if (primaryClipDescription == null) {
                Logger.m11003i(TAG, "checkClipData# ClipDescription is null.");
                return false;
            }
            if ((primaryClipDescription.hasMimeType("text/plain") && primaryClipDescription.isStyledText()) || primaryClipDescription.hasMimeType(Constants.MIME_HTML)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPaste
    public void insertSALog() {
    }
}
