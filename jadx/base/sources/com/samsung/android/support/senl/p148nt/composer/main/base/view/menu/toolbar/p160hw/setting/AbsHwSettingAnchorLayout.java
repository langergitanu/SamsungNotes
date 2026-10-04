package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import androidx.annotation.CallSuper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsHwSettingAnchorLayout extends HwSettingLayout {
    AnchorInfo mAnchorInfo;
    private View.OnLayoutChangeListener mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorLayout.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (CommonUtil.compare(i, i2, i4, i5, i6, i7, i8, i9)) {
                return;
            }
            AbsHwSettingAnchorLayout absHwSettingAnchorLayout = AbsHwSettingAnchorLayout.this;
            if (absHwSettingAnchorLayout.mAnchorInfo != null) {
                return;
            }
            absHwSettingAnchorLayout.mSettingViewManager.updateLayoutParam(absHwSettingAnchorLayout.getCallerType(), AbsHwSettingAnchorLayout.this.getView());
        }
    };

    public abstract View getView();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    @CallSuper
    public void hide(boolean z) {
        this.mFloatingContainer.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        this.mAnchorInfo = null;
    }

    public void setAnchorInfo(AnchorInfo anchorInfo) {
        this.mAnchorInfo = anchorInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    @CallSuper
    public void show(int i, View view, boolean z) {
        this.mFloatingContainer.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null) {
            this.mSettingViewManager.updateLayoutParam(anchorInfo, getView());
        } else {
            this.mSettingViewManager.updateLayoutParam(i, view, getView());
        }
    }
}
