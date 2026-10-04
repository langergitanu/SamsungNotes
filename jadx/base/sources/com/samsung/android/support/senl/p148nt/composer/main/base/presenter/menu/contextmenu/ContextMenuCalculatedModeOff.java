package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuCalculatedModeOff extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuCalculatedModeOff");
    private AiMenuManager mAiMenuManager;
    private HwToolbarPresenter mHwToolbarPresenter;
    private ObjectManager mObjectManager;

    public ContextMenuCalculatedModeOff(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter, AiMenuManager aiMenuManager) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mAiMenuManager = aiMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CALCULATE_MODE_OFF;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_turn_off_calculate_mode).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList == null) {
            return false;
        }
        Iterator<SpenObjectBase> it = selectedObjectList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() != 1) {
                return false;
            }
        }
        return this.mAiMenuManager.getSolveMathPresenter().isSupportState() && this.mAiMenuManager.getSolveMathPresenter().isEnabled();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeMenuCalculatedModeOff#");
        this.mAiMenuManager.getSolveMathPresenter().setEnabled(false);
        this.mHwToolbarPresenter.setSolveMathEnabled(false);
    }
}
