package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.setting.SpenSettingQuickSizeLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.LazyUpdateHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingPenSizeLayout extends HwSettingLayout {
    private static final String TAG = Logger.createTag("HwSettingPenSizeLayout");
    protected ViewGroup mSettingContainer;
    private SpenSettingQuickSizeLayout mSpenPenSizeLayout = null;
    private LazyUpdateHelper mLazyUpdateHelper = new LazyUpdateHelper(new LazyUpdateHelper.Callback<Integer>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenSizeLayout.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.LazyUpdateHelper.Callback
        public void onLazyUpdate(Integer num) {
            Logger.m11003i(HwSettingPenSizeLayout.TAG, "onLazyUpdate " + num);
            if (HwSettingPenSizeLayout.this.mSettingViewManager.getSettingInstance() == null) {
                return;
            }
            HwSettingPenSizeLayout.this.mSettingViewManager.getSettingInstance().setQuickSizeInfo(HwToolbarConstants.QUICK_SIZE.getOrdinal(HwSettingPenSizeLayout.this.getCallerType()), num.intValue());
            HwSettingPenSizeLayout.this.mSettingViewManager.getSettingInstance().applyQuickSize(num.intValue());
        }
    });

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        if (this.mSpenPenSizeLayout != null) {
            this.mSpenPenSizeLayout = null;
        }
        this.mSettingContainer = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        internalHide(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenPenSizeLayout != null) {
            return;
        }
        SpenSettingQuickSizeLayout spenSettingQuickSizeLayout = new SpenSettingQuickSizeLayout(this.mFloatingContainer.getContext());
        this.mSpenPenSizeLayout = spenSettingQuickSizeLayout;
        spenSettingQuickSizeLayout.setPenInfo(this.mSettingViewManager.getSettingInstance().getSelectedPenInfo());
        this.mSpenPenSizeLayout.setDisallowPreview(false);
        this.mSpenPenSizeLayout.setDataChangedListener(new SpenSettingQuickSizeLayout.OnDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenSizeLayout.2
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenQuickSizeView.OnDataChangedListener
            public void onSizeChanged(int i) {
                AbstractC8014b.m7217s(i, "onSizeChanged ", HwSettingPenSizeLayout.TAG);
                HwSettingPenSizeLayout.this.mLazyUpdateHelper.updateValue(Integer.valueOf(i));
            }
        });
        ViewGroup viewGroupAddWrappingViewGroup = addWrappingViewGroup(this.mSpenPenSizeLayout);
        this.mSettingContainer = viewGroupAddWrappingViewGroup;
        viewGroupAddWrappingViewGroup.setVisibility(8);
    }

    public boolean internalHide(boolean z) {
        if (!isVisible()) {
            return false;
        }
        inOutVI(this.mSettingContainer, z);
        this.mSettingContainer.setVisibility(8);
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mSettingContainer;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public void setSettingInfo(int i) {
        if (isVisible()) {
            this.mSpenPenSizeLayout.setSizeLevel(i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSettingContainer.getVisibility() == 0) {
            return;
        }
        this.mSpenPenSizeLayout.setPenInfo(this.mSettingViewManager.getSettingInstance().getSelectedPenInfo());
        inOutVI(this.mSettingContainer, z);
        this.mSettingContainer.setVisibility(0);
        this.mSettingContainer.requestFocus();
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true);
        updatePosition(i, view, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(i, view, this.mSettingContainer);
    }
}
