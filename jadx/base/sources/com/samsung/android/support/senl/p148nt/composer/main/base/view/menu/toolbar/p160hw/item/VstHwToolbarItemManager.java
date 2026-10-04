package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VstHwToolbarItemManager extends HwToolbarItemManager {
    private static final String TAG = Logger.createTag("VstHwToolbarItemManager");

    public VstHwToolbarItemManager(Activity activity, AbsToolbarContainerLayout absToolbarContainerLayout, FloaterContainer floaterContainer, ViewGroup viewGroup, HwToolbarPresenterImpl hwToolbarPresenterImpl, HwToolbarItemManager.IHwToolbarMenu iHwToolbarMenu, @NonNull HwToolbarOrderManager.ComponentFactory componentFactory) {
        super(activity, absToolbarContainerLayout, floaterContainer, viewGroup, hwToolbarPresenterImpl, iHwToolbarMenu, componentFactory);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public boolean correctSelectionMenu(HwToolbarState hwToolbarState) {
        Logger.m10999d(TAG, "correctSelectionMenu# " + hwToolbarState);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager
    public void onConfigurationChanged(Configuration configuration) {
        Logger.m10999d(TAG, "onConfigurationChanged# " + configuration);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager
    public void updateItemLayout(int i) {
        AbstractC0000a.m3D(i, "updateItemLayout# ", TAG);
    }
}
