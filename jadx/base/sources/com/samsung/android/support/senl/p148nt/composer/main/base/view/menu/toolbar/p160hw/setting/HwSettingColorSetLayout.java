package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayoutV2;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingColorSetLayout extends HwSettingLayout {
    private static final String TAG = Logger.createTag("HwSettingColorSetLayout");
    protected SpenColorSettingLayoutV2 mSpenColorSettingLayout = null;

    private boolean internalHide(boolean z) {
        if (!isVisible()) {
            return false;
        }
        inOutVI(this.mSpenColorSettingLayout, z);
        this.mSpenColorSettingLayout.setVisibility(8);
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        SpenColorSettingLayoutV2 spenColorSettingLayoutV2 = this.mSpenColorSettingLayout;
        if (spenColorSettingLayoutV2 != null) {
            spenColorSettingLayoutV2.close();
            this.mSpenColorSettingLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        internalHide(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenColorSettingLayout != null) {
            return;
        }
        SpenColorSettingLayoutV2 spenColorSettingLayoutV2 = new SpenColorSettingLayoutV2(this.mFloatingContainer.getContext(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSwatchList(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getMaxSelectCount());
        this.mSpenColorSettingLayout = spenColorSettingLayoutV2;
        spenColorSettingLayoutV2.setSelectPaletteList(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList());
        this.mSpenColorSettingLayout.setOnActionListener(new SpenColorSettingLayoutV2.OnActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingColorSetLayout.1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayoutV2.OnActionListener
            public void OnDone(int i) {
                Logger.m11003i(HwSettingColorSetLayout.TAG, "OnDone");
                HwSettingColorSetLayout.this.hide(true);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayoutV2.OnActionListener
            public void onCancel() {
                Logger.m11003i(HwSettingColorSetLayout.TAG, "onCancel");
                HwSettingColorSetLayout.this.hide(true);
            }
        });
        this.mSpenColorSettingLayout.setEventListener(new SpenColorSettingLayoutV2.IEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingColorSetLayout.2
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayoutV2.IEventListener
            public void onChangeSelected(List<Integer> list) {
                HwSettingColorSetLayout.this.mSettingViewManager.getSettingInstance().onPaletteChanged(list);
            }
        });
        this.mSpenColorSettingLayout.setOnSelectItemEventListener(ToolbarUtil.getColorSetRestrictToastListener(this.mFloatingContainer.getContext(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getMaxSelectCount()));
        this.mSpenColorSettingLayout.setVisibility(8);
        this.mFloatingContainer.addView(this.mSpenColorSettingLayout);
        setColorTheme(this.mSettingViewManager.getColorTheme());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenColorSettingLayoutV2 spenColorSettingLayoutV2 = this.mSpenColorSettingLayout;
        return spenColorSettingLayoutV2 != null && spenColorSettingLayoutV2.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setColorTheme(int i) {
        SpenColorSettingLayoutV2 spenColorSettingLayoutV2 = this.mSpenColorSettingLayout;
        if (spenColorSettingLayoutV2 != null) {
            spenColorSettingLayoutV2.setColorTheme(i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSpenColorSettingLayout.getVisibility() == 0) {
            return;
        }
        this.mSpenColorSettingLayout.setSelectPaletteList(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList());
        inOutVI(this.mSpenColorSettingLayout, z);
        this.mSpenColorSettingLayout.setVisibility(0);
        this.mSpenColorSettingLayout.requestFocus();
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true);
        updatePosition(i, view, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(i, view, this.mSpenColorSettingLayout);
    }
}
