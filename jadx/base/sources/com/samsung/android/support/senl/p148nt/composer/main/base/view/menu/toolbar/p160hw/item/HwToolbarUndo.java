package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarUndo extends HwToolbarUndoRedo {
    private static final String TAG = Logger.createTag("HwToolbarUndo");

    public HwToolbarUndo(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        if (z) {
            this.mPresenter.getMRemoteHwSettingPresenter().undo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarUndoRedo
    public void onUndoRedo() {
        Logger.m10999d(TAG, "onUndoRedo()");
        functionEnable(true);
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_UNDO_SETTING);
    }
}
