package com.samsung.android.support.senl.addons.brush.view.popup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J(\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\u0011H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/ColorSpuitPopupView;", "Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout;", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "context", "Landroid/content/Context;", "canvasLayout", "Landroid/widget/RelativeLayout;", "x", "", "y", "<init>", "(Landroid/content/Context;Landroid/widget/RelativeLayout;II)V", "mMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "mRotateDelegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", Constants.IntentExtraValue.SHOW, "", "hide", "result", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopupView$IPopupResult;", "updatePosition", "info", "subAlign", "setRotationDelegate", "delegate", "setRoundedBackground", "radius", "bgColor", "strokeSize", "strokeColor", "rotate", "event", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "isVisible", "", "getHorizontalMargin", "getVerticalMargin", "close", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class ColorSpuitPopupView extends SpenColorSpoidLayout implements IBrushSettingPopupView {

    @Nullable
    private IBrushMenuInfo mMenuInfo;

    @Nullable
    private RotationDelegate mRotateDelegate;

    public ColorSpuitPopupView(@Nullable Context context, @Nullable RelativeLayout relativeLayout, int i, int i2) {
        super(context, relativeLayout, i, i2);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void close() {
        this.mMenuInfo = null;
        this.mRotateDelegate = null;
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public int getHorizontalMargin() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public int getVerticalMargin() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void hide(@Nullable ISettingPopupView.IPopupResult result) {
        SpenColorSpoidLayout.hide$default(this, false, 1, null);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public boolean isVisible() {
        return getSpoidView().getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public void rotate(@Nullable IRotationEvent event) {
        if (this.mRotateDelegate != null) {
            int x = (int) getSpoidView().getX();
            int y2 = (int) getSpoidView().getY();
            int dimensionPixelSize = (getResources().getDimensionPixelSize(C7932R.dimen.color_spoid_width) / 2) + ((int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()));
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C7932R.dimen.color_spoid_height) / 2;
            Object parent = getSpoidView().getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            int width = ((View) parent).getWidth();
            Object parent2 = getSpoidView().getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            int height = ((View) parent2).getHeight();
            Integer numValueOf = event != null ? Integer.valueOf(event.getMTarget()) : null;
            if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 180)) {
                if (x - dimensionPixelSize <= 0) {
                    RotationDelegate rotationDelegate = this.mRotateDelegate;
                    Intrinsics.checkNotNull(rotationDelegate);
                    rotationDelegate.rotate(this, getSpoidView(), 4);
                } else if (x + dimensionPixelSize + dimensionPixelSize2 >= width) {
                    RotationDelegate rotationDelegate2 = this.mRotateDelegate;
                    Intrinsics.checkNotNull(rotationDelegate2);
                    rotationDelegate2.rotate(this, getSpoidView(), 8);
                } else {
                    RotationDelegate rotationDelegate3 = this.mRotateDelegate;
                    Intrinsics.checkNotNull(rotationDelegate3);
                    rotationDelegate3.rotate(this, getSpoidView(), 0);
                }
            }
            if ((numValueOf != null && numValueOf.intValue() == 90) || (numValueOf != null && numValueOf.intValue() == 270)) {
                if (y2 - dimensionPixelSize <= 0) {
                    RotationDelegate rotationDelegate4 = this.mRotateDelegate;
                    Intrinsics.checkNotNull(rotationDelegate4);
                    rotationDelegate4.rotate(this, getSpoidView(), 1);
                } else if (y2 + dimensionPixelSize >= height) {
                    RotationDelegate rotationDelegate5 = this.mRotateDelegate;
                    Intrinsics.checkNotNull(rotationDelegate5);
                    rotationDelegate5.rotate(this, getSpoidView(), 2);
                } else {
                    RotationDelegate rotationDelegate6 = this.mRotateDelegate;
                    Intrinsics.checkNotNull(rotationDelegate6);
                    rotationDelegate6.rotate(this, getSpoidView(), 0);
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void setRotationDelegate(@NotNull RotationDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.mRotateDelegate = delegate;
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor) {
    }

    @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void show() {
        super.show();
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            rotationDelegate.onShow(this, getSpoidView(), 0);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition(@Nullable IBrushMenuInfo info, int subAlign) {
        this.mMenuInfo = info;
        updatePosition();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition() {
        if (this.mMenuInfo == null) {
            return;
        }
        int x = (int) getSpoidView().getX();
        int y2 = (int) getSpoidView().getY();
        int dimensionPixelSize = getResources().getDimensionPixelSize(C7932R.dimen.color_spoid_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C7932R.dimen.color_spoid_height);
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo);
        int i = dimensionPixelSize + x;
        int i2 = dimensionPixelSize2 + y2;
        if (iBrushMenuInfo.getPenRect().intersects(x, y2, i, i2)) {
            IBrushMenuInfo iBrushMenuInfo2 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo2);
            if (iBrushMenuInfo2.getPenAlign() == 3) {
                IBrushMenuInfo iBrushMenuInfo3 = this.mMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo3);
                movePosition(x, iBrushMenuInfo3.getPenRect().height() + y2);
                return;
            }
            IBrushMenuInfo iBrushMenuInfo4 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo4);
            if (iBrushMenuInfo4.getPenAlign() == 2) {
                IBrushMenuInfo iBrushMenuInfo5 = this.mMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo5);
                movePosition(iBrushMenuInfo5.getPenRect().width() + x, y2);
                return;
            }
            return;
        }
        IBrushMenuInfo iBrushMenuInfo6 = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo6);
        if (iBrushMenuInfo6.getColorRect().intersects(x, y2, i, i2)) {
            IBrushMenuInfo iBrushMenuInfo7 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo7);
            if (iBrushMenuInfo7.getColorAlign() == 3) {
                IBrushMenuInfo iBrushMenuInfo8 = this.mMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo8);
                movePosition(x, iBrushMenuInfo8.getColorRect().height() + y2);
                return;
            }
            IBrushMenuInfo iBrushMenuInfo9 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo9);
            if (iBrushMenuInfo9.getColorAlign() == 2) {
                IBrushMenuInfo iBrushMenuInfo10 = this.mMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo10);
                movePosition(iBrushMenuInfo10.getColorRect().width() + x, y2);
            }
        }
    }
}
