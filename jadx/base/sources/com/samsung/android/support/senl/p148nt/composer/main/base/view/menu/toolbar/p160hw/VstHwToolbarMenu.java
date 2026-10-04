package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.VstHwToolbarItemManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VstHwToolbarMenu extends HwToolbarMenu {
    private ScrollView mVerticalScrollView;

    public VstHwToolbarMenu(Activity activity, ViewGroup viewGroup, IToolbarManager iToolbarManager, HwToolbarPresenterImpl hwToolbarPresenterImpl, @NonNull HwToolbarOrderManager.ComponentFactory componentFactory) {
        super(activity, viewGroup, iToolbarManager, hwToolbarPresenterImpl, componentFactory);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu
    public HwToolbarItemManager createHwToolbarItemManager() {
        return new VstHwToolbarItemManager(this.mActivity, this.mFloatingContainer, this.mFloatingArea, this.mMenuItems, this.mPresenter, this, this.mComponentFactory);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu
    public void init(View view) {
        FloaterContainer floaterContainer = (FloaterContainer) view.findViewById(C9086R.id.floating_layout_container);
        this.mFloatingArea = floaterContainer;
        AbsToolbarContainerLayout absToolbarContainerLayout = (AbsToolbarContainerLayout) floaterContainer.findViewById(C9086R.id.vst_floating_layout);
        this.mFloatingContainer = absToolbarContainerLayout;
        asyncInflate(C9086R.layout.vst_comp_hw_fixed_menu, absToolbarContainerLayout);
        this.mPresenter.setView(this);
        this.mToolbarManager.setSpenColorThemeUtil(this.mPresenter.getColorTheme());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu
    public void initToggleBtn() {
        super.initToggleBtn();
        ToolbarUtil.setBgRippleToolbar(this.mToggleClickBtn);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void onInflated(View view) {
        this.mHwMenusView = view.findViewById(C9086R.id.hw_toolbar_menu_container);
        this.mVerticalScrollView = (ScrollView) view.findViewById(C9086R.id.hw_toolbar_scroll_view);
        this.mMenuItems = (ViewGroup) view.findViewById(C9086R.id.hw_toolbar_menu_item_container);
        this.mHwToolbarItemManager = createHwToolbarItemManager();
        initToggleBtn();
        ToolbarUtil.adjustToolbarItemLayoutForVST(this.mHwMenusView.findViewById(C9086R.id.hw_toolbar_container), this.mMenuItems);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void onMovePosition(View view) {
        this.mVerticalScrollView.scrollTo(0, view.getTop());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void requestItemOnToolbarMenu(View view) {
        if (view == null) {
            return;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        this.mVerticalScrollView.requestChildRectangleOnScreen(view, rect, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void show() {
        super.show();
    }
}
