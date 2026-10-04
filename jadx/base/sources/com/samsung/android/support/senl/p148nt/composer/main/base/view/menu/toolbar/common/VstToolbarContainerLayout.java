package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VstToolbarContainerLayout extends AllSideToolbarContainerLayout {
    public VstToolbarContainerLayout(Context context) {
        super(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void dispatchLongPress(MotionEvent motionEvent) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout
    public int getDockingSizePixel() {
        return getResources().getDimensionPixelSize(C9086R.dimen.vst_comp_vertical_toolbar_width);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout
    public float getHorizontalDockingArea() {
        return getDockingSizePixel();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout
    public float getHorizontalMenuWidth() {
        return getDockingSizePixel();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onFieldSizeChanged() {
        super.onFieldSizeChanged();
        ToolbarUtil.adjustToolbarItemLayoutForVST(findViewById(C9086R.id.hw_toolbar_container), (ViewGroup) findViewById(C9086R.id.hw_toolbar_menu_item_container));
        ToolbarUtil.adjustToolbarItemLayoutForVST(findViewById(C9086R.id.rt_toolbar_container), (ViewGroup) findViewById(C9086R.id.rt_toolbar_menu_item_container));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public boolean onTouchMove(PointF pointF) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean updateDockState(float f, float f4) {
        dropVerticalDocking(false, 3);
        this.mRotate = true;
        this.mDockSide = -1;
        return true;
    }

    public VstToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VstToolbarContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VstToolbarContainerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
