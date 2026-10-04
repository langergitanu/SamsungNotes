package com.samsung.android.support.senl.addons.brush.view.menu.control;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenBrushLayoutInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushPhoneMenuControl;", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;", "prev", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;)V", "mPenType", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout;", "getBrushLayoutInfo", "Lcom/samsung/android/sdk/pen/setting/SpenBrushLayoutInfo;", "setBrushLayout", "", "brushLayout", "Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout$OnModeChangeListener;", "close", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushPhoneMenuControl extends BrushMenuControl {

    @Nullable
    private SpenBrushPenTypeLayout mPenType;

    public BrushPhoneMenuControl(@Nullable BrushMenuControl brushMenuControl) {
        super(brushMenuControl);
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    public void close() {
        SpenBrushPenTypeLayout spenBrushPenTypeLayout = this.mPenType;
        if (spenBrushPenTypeLayout != null) {
            Intrinsics.checkNotNull(spenBrushPenTypeLayout);
            spenBrushPenTypeLayout.setViewModeChangeListener(null);
            this.mPenType = null;
        }
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    @NotNull
    public SpenBrushLayoutInfo getBrushLayoutInfo() {
        SpenBrushLayoutInfo spenBrushLayoutInfo = new SpenBrushLayoutInfo();
        spenBrushLayoutInfo.style = 1;
        spenBrushLayoutInfo.penViewType = 1;
        spenBrushLayoutInfo.moveable = false;
        spenBrushLayoutInfo.isOpened = false;
        spenBrushLayoutInfo.penWidthRatio = 0.9888f;
        spenBrushLayoutInfo.penHeightRatio = 0.261f;
        spenBrushLayoutInfo.penAlign = 3;
        spenBrushLayoutInfo.colorWidthRatio = 0.739f;
        spenBrushLayoutInfo.colorHeightRatio = 0.261f;
        spenBrushLayoutInfo.colorAlign = 3;
        spenBrushLayoutInfo.spaceRatio = 0.0056f;
        return spenBrushLayoutInfo;
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    public void setBrushLayout(@NotNull SpenSettingBrushLayout brushLayout, @Nullable SpenBrushPenTypeLayout.OnModeChangeListener listener) {
        Intrinsics.checkNotNullParameter(brushLayout, "brushLayout");
        super.setBrushLayout(brushLayout, listener);
        if (getMPenView() instanceof SpenBrushPenTypeLayout) {
            SpenBrushPenLayoutInterface mPenView = getMPenView();
            Intrinsics.checkNotNull(mPenView, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout");
            SpenBrushPenTypeLayout spenBrushPenTypeLayout = (SpenBrushPenTypeLayout) mPenView;
            this.mPenType = spenBrushPenTypeLayout;
            if (spenBrushPenTypeLayout != null) {
                spenBrushPenTypeLayout.setViewModeChangeListener(listener);
            }
        }
    }
}
