package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuConvertToTextLink extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuAddTextBox");
    private ListenerImplContract.IDialogPresenter mDialogPresentManager;
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;
    private TextManager mTextManager;

    public ContextMenuConvertToTextLink(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mDialogPresentManager = composerViewPresenter.getDialogPresenterManager();
    }

    private String getCustomData() {
        SpenObjectShape textBox = this.mTextManager.getTextBox();
        int[] cursor = this.mTextManager.getCursor(textBox);
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = textBox.findTextSpan(cursor[0], cursor[1], 512);
        if (arrayListFindTextSpan == null || arrayListFindTextSpan.isEmpty()) {
            return "";
        }
        for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
            if (spenTextSpanBase.getType() == 9 && spenTextSpanBase.getStart() == cursor[0] && spenTextSpanBase.getEnd() == cursor[1] && (spenTextSpanBase instanceof SpenHyperTextSpan)) {
                SpenHyperTextSpan spenHyperTextSpan = (SpenHyperTextSpan) spenTextSpanBase;
                return !TextUtils.isEmpty(spenHyperTextSpan.getCustomData()) ? spenHyperTextSpan.getCustomData() : "";
            }
        }
        return "";
    }

    private boolean isAvailableToTextLink() {
        int[] cursor = TextUtil.getCursor(this.mTextManager.getTextBox());
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = this.mTextManager.getTextBox().findObjectSpan(cursor[0], cursor[1]);
        if (arrayListFindObjectSpan != null && !arrayListFindObjectSpan.isEmpty()) {
            for (SpenObjectSpan spenObjectSpan : arrayListFindObjectSpan) {
                if (spenObjectSpan.getObj() != null && spenObjectSpan.getObj().getType() != 2) {
                    Logger.m10999d(TAG, "isAvailableToTextLink# invalid object");
                    return false;
                }
            }
        }
        return !TextUtils.isEmpty(this.mTextManager.getSelectedText());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_TEXT_LINK;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.convert_to_text_link).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (this.mModeManager.isEditMode() && this.mObjectManager.isSelectedBodyText()) {
            return isAvailableToTextLink();
        }
        Logger.m10999d(TAG, "canShow# invalid status");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeConvertToTextLinkMenu# ");
        TextManager textManager = this.mTextManager;
        int[] cursor = textManager.getCursor(textManager.getTextBox());
        String strSubstring = this.mTextManager.getTextBox().getText().substring(cursor[0], cursor[1]);
        SpenHyperTextSpan spenHyperTextSpan = new SpenHyperTextSpan(cursor[0], cursor[1], 2);
        spenHyperTextSpan.setHyperTextType(3);
        spenHyperTextSpan.setCustomData(getCustomData());
        this.mDialogPresentManager.showLinkEditDialog(strSubstring, spenHyperTextSpan, false, true);
    }
}
