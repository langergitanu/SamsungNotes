package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSimpleChipView;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0014J\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "hsvColor", "", "<init>", "(Landroid/content/Context;[F)V", "colorPickerView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView;", "mPickerViewCore", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerViewCore;", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout$AnimationListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "", "getCurrentColor", "", "hsv", "setCurrentColor", "setOnColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataChangedListener;", "setOnActionListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout$ActionListener;", "setAnimationListener", "getVisibleContentRect", "rect", "Landroid/graphics/Rect;", "setVisibility", "visibility", "animation", "setShouldShowHueWheel", "value", "ActionListener", "AnimationListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nSettingQTColorPickerLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingQTColorPickerLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,103:1\n255#2:104\n*S KotlinDebug\n*F\n+ 1 SettingQTColorPickerLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout\n*L\n91#1:104\n*E\n"})
public final class SettingQTColorPickerLayout extends FrameLayout {

    @NotNull
    private final QTColorPickerView colorPickerView;

    @Nullable
    private AnimationListener mAnimationListener;

    @NotNull
    private final QTColorPickerViewCore mPickerViewCore;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout$ActionListener;", "", "onColorTap", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ActionListener {
        void onColorTap();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout$AnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTColorPickerLayout(@NotNull Context context, @NotNull float[] hsvColor) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_color_picker_layout_width), getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_color_picker_layout_height));
        QTColorPickerView qTColorPickerView = new QTColorPickerView(context);
        this.colorPickerView = qTColorPickerView;
        qTColorPickerView.setLayoutParams(layoutParams);
        addView(qTColorPickerView);
        QTColorPickerPreviewContainer qTColorPickerPreviewContainer = new QTColorPickerPreviewContainer(context);
        qTColorPickerPreviewContainer.setLayoutParams(layoutParams);
        addView(qTColorPickerPreviewContainer);
        SpenSimpleChipView colorPreview = qTColorPickerPreviewContainer.getColorPreview();
        QTColorPickerViewCore qTColorPickerViewCore = new QTColorPickerViewCore(context, hsvColor);
        this.mPickerViewCore = qTColorPickerViewCore;
        Object parent = colorPreview.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        qTColorPickerViewCore.initPickerView(qTColorPickerView, colorPreview, (View) parent);
        qTColorPickerViewCore.setAnimationListener(new QTColorPickerViewCore.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerViewCore.AnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                AnimationListener animationListener = SettingQTColorPickerLayout.this.mAnimationListener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(isShowAnimation);
                }
            }
        });
    }

    public final void close() {
        this.mPickerViewCore.close();
        this.mAnimationListener = null;
    }

    public final boolean getCurrentColor(@Nullable float[] hsv) {
        return false;
    }

    public final boolean getVisibleContentRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        rect.set(0, 0, getContext().getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_color_picker_layout_width), getContext().getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_color_picker_layout_height));
        return true;
    }

    public final void setAnimationListener(@Nullable AnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setColorTheme(int theme) {
        this.mPickerViewCore.setColorTheme(theme);
    }

    public final void setCurrentColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mPickerViewCore.setCurrentColor(hsvColor);
    }

    public final void setOnActionListener(@Nullable ActionListener listener) {
        this.mPickerViewCore.setActionListener(listener);
    }

    public final void setOnColorChangedListener(@Nullable SpenColorPickerDataChangedListener listener) {
        this.mPickerViewCore.setDataChangedListener(listener);
    }

    public final void setShouldShowHueWheel(boolean value) {
        this.colorPickerView.setShouldShowHueWheel(value);
    }

    public final void setVisibility(int visibility, boolean animation) {
        if ((visibility != 0 && getVisibility() != 0) || !animation) {
            setVisibility(visibility);
        } else {
            setVisibility(0);
            this.mPickerViewCore.startAnimation(visibility == 0);
        }
    }
}
