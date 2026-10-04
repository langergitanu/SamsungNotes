package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectLayoutOption;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuTextWrap extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuTextWrap");
    private int mLayoutType = ObjectLayoutOption.LAYOUT_NORMAL;
    private ModeManager mModeManager;
    private ObjectManager mObjectManager;

    public ContextMenuTextWrap(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        boolean zCanShow = canShow();
        int i = C9086R.string.composer_ctx_menu_disable_text_wrap;
        if (this.mLayoutType == ObjectLayoutOption.LAYOUT_WRAP_TEXT_BEHIND) {
            i = C9086R.string.composer_ctx_menu_enable_text_wrap;
        }
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_WRAP;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), i).setEnabled(zCanShow);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList;
        if (this.mModeManager.isEditMode() && !this.mObjectManager.isFocusedTextBox() && !this.mObjectManager.isSelectedObjectOfObjectSpan() && (selectedObjectList = this.mObjectManager.getSelectedObjectList()) != null && !selectedObjectList.isEmpty()) {
            for (SpenObjectBase spenObjectBase : selectedObjectList) {
                if (spenObjectBase.getLayoutType() == ObjectLayoutOption.LAYOUT_WRAP_TEXT_AROUND || spenObjectBase.getLayoutType() == ObjectLayoutOption.LAYOUT_WRAP_TEXT_BEHIND) {
                    this.mLayoutType = spenObjectBase.getLayoutType();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.isEmpty()) {
            return;
        }
        Logger.m10999d(TAG, "executeTextWrapMenu#" + selectedObjectList.size());
        if (this.mLayoutType == ObjectLayoutOption.LAYOUT_WRAP_TEXT_AROUND) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_VIEW_CTX_WRAP_TEXT_BEHIND, "b");
            this.mLayoutType = ObjectLayoutOption.LAYOUT_WRAP_TEXT_BEHIND;
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_VIEW_CTX_WRAP_TEXT_BEHIND, "a");
            this.mLayoutType = ObjectLayoutOption.LAYOUT_WRAP_TEXT_AROUND;
        }
        Iterator<SpenObjectBase> it = selectedObjectList.iterator();
        while (it.hasNext()) {
            it.next().setLayoutType(this.mLayoutType);
        }
        this.mObjectManager.clearSelectObject();
        this.mObjectManager.setLayoutOption(this.mLayoutType);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }
}
