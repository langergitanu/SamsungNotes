package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorDialControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.ChipView;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0012J\u0014\u0010!\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0016J\u0010\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\rJ\u0016\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(J\u000e\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0012J\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;Z)V", "mDialViewControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl;", "mDialLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout;", "mColorChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorLayout$OnColorChangedListener;", "close", "", "setVisibility", "visibility", "", "hasAnimation", "setPaletteList", "paletteList", "", "setColor", "uiInfo", "color", "", "moveToCurrent", "getColor", "setPickerColor", "hsvColor", "setEyedropperColor", "inputColor", "setRecentColor", "recentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "setOnColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isScrollAt", "rawX", "", "rawY", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "applyPickerColor", "view", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/ChipView;", "Companion", "OnColorChangedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SettingQTColorLayout extends FrameLayout {

    @NotNull
    private static final String TAG = "SettingQTColorLayout";

    @Nullable
    private OnColorChangedListener mColorChangedListener;

    @NotNull
    private final SettingQTColorDialLayout mDialLayout;

    @NotNull
    private final QTColorDialControl mDialViewControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorLayout$OnColorChangedListener;", "", "onColorChanged", "", "info", "", "hsvColor", "", "isSame", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnColorChangedListener {
        void onColorChanged(int info, @NotNull float[] hsvColor, boolean isSame);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTColorLayout(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        QTColorDialControl qTColorDialControl = new QTColorDialControl(context, true);
        this.mDialViewControl = qTColorDialControl;
        SettingQTColorDialLayout settingQTColorDialLayout = new SettingQTColorDialLayout(context);
        this.mDialLayout = settingQTColorDialLayout;
        addView(settingQTColorDialLayout);
        qTColorDialControl.initColorLayout(settingQTColorDialLayout, z);
        qTColorDialControl.setColorChangedListener(new QTColorDialControl.OnColorChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorDialControl.OnColorChangedListener
            public void onColorChanged(int info, float[] hsvColor, boolean isSame) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                OnColorChangedListener onColorChangedListener = SettingQTColorLayout.this.mColorChangedListener;
                if (onColorChangedListener != null) {
                    onColorChangedListener.onColorChanged(info, hsvColor, isSame);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVisibility$lambda$0(SettingQTColorLayout settingQTColorLayout) {
        settingQTColorLayout.setVisibility(8);
        settingQTColorLayout.setAlpha(1.0f);
    }

    public final void applyPickerColor(@NotNull ChipView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mDialViewControl.applyPickerColor(view);
    }

    public final void close() {
        this.mDialViewControl.close();
    }

    public final void getColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
    }

    public final boolean isScrollAt(float rawX, float rawY) {
        return this.mDialLayout.isScrollAt(rawX, rawY);
    }

    public final void setColor(int uiInfo, @NotNull float[] color, boolean moveToCurrent) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.mDialViewControl.setColor(uiInfo, color, moveToCurrent);
    }

    public final void setColorTheme(int theme) {
        this.mDialViewControl.setColorTheme(theme);
    }

    public final void setEyedropperColor(int inputColor) {
        this.mDialViewControl.setEyedropperColor(inputColor | (-16777216));
    }

    public final void setOnColorChangedListener(@Nullable OnColorChangedListener listener) {
        this.mColorChangedListener = listener;
    }

    public final void setPaletteList(@NotNull List<Integer> paletteList) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        this.mDialViewControl.setPaletteList(paletteList);
    }

    public final void setPickerColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mDialViewControl.setPickerColor(hsvColor);
    }

    public final void setRecentColor(@NotNull List<SpenHSVColor> recentColors) {
        Intrinsics.checkNotNullParameter(recentColors, "recentColors");
        this.mDialViewControl.setRecentColor(recentColors);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        setVisibility(visibility, false);
    }

    public final void setVisibility(int visibility, boolean hasAnimation) {
        boolean z = hasAnimation && (visibility == 0 || getVisibility() == 0);
        AbstractC8014b.m7222x(AbstractC2821a.m2226q("setVisibility(", visibility, SQLKeyword.COMMA, hasAnimation, ") isAnimation="), z, TAG);
        if (!z) {
            super.setVisibility(visibility);
            return;
        }
        if (visibility != 0) {
            if (visibility != 8) {
                super.setVisibility(visibility);
                return;
            } else {
                animate().alpha(0.0f).setDuration(100L).withEndAction(new RunnableC9767a(this, 11)).setInterpolator(new LinearInterpolator()).start();
                return;
            }
        }
        animate().cancel();
        super.setVisibility(0);
        setAlpha(1.0f);
        this.mDialLayout.showAnimation(true);
    }
}
