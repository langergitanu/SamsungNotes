package com.samsung.android.support.senl.addons.brush.view.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.brush.view.injector.MenuLayoutInjector;
import com.samsung.android.support.senl.addons.brush.view.popup.SettingPopupViewUtils;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/ColorPopupViewDelegate;", "", "context", "Landroid/content/Context;", SmpConstants.MARKETING_TYPE_POPUP, "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;)V", "mColorPopup", "mMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "mRotateDelegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", "close", "", "updatePosition", "info", Constants.IntentExtraValue.SHOW, "setRotationDelegate", "delegate", "rotate", "event", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "getHorizontalMargin", "", "getVerticalMargin", "isNeedAdditionalHorizontalMargin", "", "isNeedAdditionalVerticalMargin", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColorPopupViewDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorPopupViewDelegate.kt\ncom/samsung/android/support/senl/addons/brush/view/popup/ColorPopupViewDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n1#2:126\n*E\n"})
public final class ColorPopupViewDelegate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private IBrushSettingPopupView mColorPopup;

    @Nullable
    private IBrushMenuInfo mMenuInfo;

    @Nullable
    private RotationDelegate mRotateDelegate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/ColorPopupViewDelegate$Companion;", "", "<init>", "()V", "getPivotByColorMenuAlign", "", "info", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "isColorPopupStartOrTop", "", "align", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getPivotByColorMenuAlign(IBrushMenuInfo info) {
            if (info == null) {
                return 0;
            }
            int colorAlign = info.getColorAlign();
            if (colorAlign == 0) {
                return 10;
            }
            if (colorAlign == 1) {
                return 9;
            }
            if (colorAlign != 2) {
                return colorAlign != 3 ? 0 : 9;
            }
            return 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isColorPopupStartOrTop(int align) {
            return (align == 3 || align == 0 || align == 1) ? false : true;
        }

        private Companion() {
        }
    }

    public ColorPopupViewDelegate(@NotNull Context context, @Nullable IBrushSettingPopupView iBrushSettingPopupView) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColorPopup = iBrushSettingPopupView;
        MenuLayoutInjector menuLayoutInjector = new MenuLayoutInjector(context);
        IBrushSettingPopupView iBrushSettingPopupView2 = this.mColorPopup;
        if (iBrushSettingPopupView2 != null) {
            iBrushSettingPopupView2.setRoundedBackground(menuLayoutInjector.getRadius(), menuLayoutInjector.getBackgroundColor(), menuLayoutInjector.getStrokeSize(), menuLayoutInjector.getStrokeColor());
        }
    }

    private final boolean isNeedAdditionalHorizontalMargin() {
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        if (iBrushMenuInfo == null) {
            return false;
        }
        Intrinsics.checkNotNull(iBrushMenuInfo);
        int colorAlign = iBrushMenuInfo.getColorAlign();
        return colorAlign == 2 || colorAlign == 1;
    }

    private final boolean isNeedAdditionalVerticalMargin() {
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        if (iBrushMenuInfo == null) {
            return false;
        }
        Intrinsics.checkNotNull(iBrushMenuInfo);
        int colorAlign = iBrushMenuInfo.getColorAlign();
        return colorAlign == 3 || colorAlign == 0;
    }

    public final void close() {
        this.mColorPopup = null;
        this.mMenuInfo = null;
        this.mRotateDelegate = null;
    }

    public final int getHorizontalMargin() {
        Object obj = this.mColorPopup;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        ViewGroup.LayoutParams layoutParams = ((View) obj).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        if (!isNeedAdditionalHorizontalMargin()) {
            return i;
        }
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo);
        return iBrushMenuInfo.getPenRect().height() + i;
    }

    public final int getVerticalMargin() {
        Object obj = this.mColorPopup;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        ViewGroup.LayoutParams layoutParams = ((View) obj).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        if (!isNeedAdditionalVerticalMargin()) {
            return i;
        }
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo);
        return iBrushMenuInfo.getColorRect().height() + i;
    }

    public final void rotate(@Nullable IRotationEvent event) {
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            IBrushSettingPopupView iBrushSettingPopupView = this.mColorPopup;
            Intrinsics.checkNotNull(iBrushSettingPopupView);
            rotationDelegate.rotate(iBrushSettingPopupView, INSTANCE.getPivotByColorMenuAlign(this.mMenuInfo));
        }
    }

    public final void setRotationDelegate(@Nullable RotationDelegate delegate) {
        this.mRotateDelegate = delegate;
    }

    public final void show() {
        RotationDelegate rotationDelegate;
        View view = (View) this.mColorPopup;
        if (view != null) {
            view.setVisibility(0);
        }
        IBrushSettingPopupView iBrushSettingPopupView = this.mColorPopup;
        if (iBrushSettingPopupView == null || (rotationDelegate = this.mRotateDelegate) == null) {
            return;
        }
        rotationDelegate.onShow(iBrushSettingPopupView, INSTANCE.getPivotByColorMenuAlign(this.mMenuInfo));
    }

    public final void updatePosition(@Nullable IBrushMenuInfo info) {
        this.mMenuInfo = info;
        updatePosition();
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            IBrushSettingPopupView iBrushSettingPopupView = this.mColorPopup;
            Intrinsics.checkNotNull(iBrushSettingPopupView);
            rotationDelegate.rotate(iBrushSettingPopupView, INSTANCE.getPivotByColorMenuAlign(this.mMenuInfo), true);
        }
    }

    public final void updatePosition() {
        View view = (View) this.mColorPopup;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (this.mMenuInfo != null) {
            SettingPopupViewUtils.Companion companion = SettingPopupViewUtils.INSTANCE;
            companion.resetPopupParams(layoutParams2);
            IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo);
            int colorAlign = iBrushMenuInfo.getColorAlign();
            companion.setPopupParams(layoutParams2, C7944R.id.popup_color_view, colorAlign, view.getResources().getDimensionPixelSize(C7944R.dimen.brush_setting_popup_layout_between_space), INSTANCE.isColorPopupStartOrTop(colorAlign), 0);
        }
        if (view != null) {
            view.setLayoutParams(layoutParams2);
        }
    }
}
