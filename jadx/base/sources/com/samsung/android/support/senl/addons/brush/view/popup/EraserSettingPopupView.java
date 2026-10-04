package com.samsung.android.support.senl.addons.brush.view.popup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.brush.view.injector.MenuLayoutInjector;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/EraserSettingPopupView;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenSettingLayout;", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "context", "Landroid/content/Context;", "needSeekBarStroke", "", "<init>", "(Landroid/content/Context;Z)V", "mMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "mBottomClickListener", "Landroid/view/View$OnClickListener;", "mRotateDelegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", Constants.IntentExtraValue.SHOW, "", "hide", "result", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopupView$IPopupResult;", "updatePosition", "info", "subAlign", "", "setRotationDelegate", "delegate", "isVisible", "rotate", "event", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "setBottomClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getHorizontalMargin", "getVerticalMargin", "close", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class EraserSettingPopupView extends SpenBrushPenSettingLayout implements IBrushSettingPopupView {

    @Nullable
    private View.OnClickListener mBottomClickListener;

    @Nullable
    private IBrushMenuInfo mMenuInfo;

    @Nullable
    private RotationDelegate mRotateDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EraserSettingPopupView(@NotNull Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        setBottomButton(context.getResources().getText(C7944R.string.pen_string_clear_all), new ViewOnClickListenerC7538b(this, 21));
        MenuLayoutInjector menuLayoutInjector = new MenuLayoutInjector(context);
        setRoundedBackground(menuLayoutInjector.getRadius(), menuLayoutInjector.getBackgroundColor(), menuLayoutInjector.getStrokeSize(), menuLayoutInjector.getStrokeColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(EraserSettingPopupView eraserSettingPopupView, View view) {
        View.OnClickListener onClickListener = eraserSettingPopupView.mBottomClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
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
        setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public void rotate(@Nullable IRotationEvent event) {
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            Intrinsics.checkNotNull(rotationDelegate);
            rotationDelegate.rotate(this, 2);
        }
    }

    public final void setBottomClickListener(@Nullable View.OnClickListener listener) {
        this.mBottomClickListener = listener;
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void setRotationDelegate(@NotNull RotationDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.mRotateDelegate = delegate;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void show() {
        setVisibility(0);
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            rotationDelegate.onShow(this, 2);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition(@Nullable IBrushMenuInfo info, int subAlign) {
        this.mMenuInfo = info;
        updatePosition();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition() {
        int iHeight;
        if (this.mMenuInfo == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C7944R.dimen.brush_setting_popup_spen_eraser_layout_margin_bottom);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(C7944R.dimen.brush_setting_popup_spen_eraser_layout_margin_bottom_land);
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo);
        int iWidth = iBrushMenuInfo.getColorRect().width();
        IBrushMenuInfo iBrushMenuInfo2 = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo2);
        if (iWidth < iBrushMenuInfo2.getColorRect().height()) {
            IBrushMenuInfo iBrushMenuInfo3 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo3);
            iHeight = iBrushMenuInfo3.getColorRect().width();
        } else {
            IBrushMenuInfo iBrushMenuInfo4 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo4);
            iHeight = iBrushMenuInfo4.getColorRect().height();
        }
        if (TabletUtil.isTabletUi()) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C7944R.dimen.brush_setting_popup_spen_eraser_layout_margin_bottom_tablet);
            dimensionPixelOffset = dimensionPixelSize;
            iHeight = 0;
        }
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        IBrushMenuInfo iBrushMenuInfo5 = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo5);
        if (iBrushMenuInfo5.getColorAlign() == 2) {
            layoutParams2.bottomMargin = dimensionPixelOffset;
        } else {
            layoutParams2.bottomMargin = dimensionPixelSize;
            iHeight = 0;
        }
        layoutParams2.setMarginStart(0);
        setLayoutParams(layoutParams2);
        if (getResources().getConfiguration().getLayoutDirection() == 0) {
            setTranslationX(iHeight / 2.0f);
        } else if (getResources().getConfiguration().getLayoutDirection() == 1) {
            setTranslationX((-iHeight) / 2.0f);
        }
    }
}
