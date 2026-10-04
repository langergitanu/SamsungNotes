package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppColorPickerLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingColorPickerLayout;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/impl/InAppSettingImpl;", "<init>", "()V", "mSpenColorPickerPopup", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup;", "mHsvColor", "", "getMHsvColor", "()[F", "setMHsvColor", "([F)V", "init", "", "setPickerColorChangedListener", "colorPickerChangeListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerChangedListener;", Constants.IntentExtraValue.SHOW, "callerType", "", "container", "Landroid/view/View;", "withAnimation", "", "showColorPickerPopup", "parentView", "hide", "dismissColorPicker", "internalHide", "close", "setCurrentColor", "hsvColor", "setColorTheme", "colorTheme", "isVisible", "closeColorPopup", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppColorPickerLayout extends HwSettingColorPickerLayout implements InAppSettingImpl {

    @NotNull
    private static final String TAG = "InAppColorPickerLayout";

    @NotNull
    private float[] mHsvColor = new float[3];

    @Nullable
    private SpenColorPickerPopup mSpenColorPickerPopup;

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissColorPicker() {
        SpenColorPickerPopup spenColorPickerPopup;
        if (!isVisible() || (spenColorPickerPopup = this.mSpenColorPickerPopup) == null) {
            return;
        }
        spenColorPickerPopup.dismiss();
    }

    private final void internalHide() {
        if (isVisible()) {
            SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
            if (spenColorPickerPopup != null) {
                spenColorPickerPopup.dismiss();
            }
            this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.close();
        }
        this.mSpenColorPickerPopup = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl
    public void closeColorPopup() {
        hide(false);
    }

    @NotNull
    public final float[] getMHsvColor() {
        return this.mHsvColor;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean withAnimation) {
        internalHide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        dismissColorPicker();
        if (this.mSpenColorPickerPopup != null) {
            return;
        }
        Context context = this.mFloatingContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenColorPickerPopup spenColorPickerPopup = new SpenColorPickerPopup(context, 2, new float[3], false);
        this.mSpenColorPickerPopup = spenColorPickerPopup;
        spenColorPickerPopup.setCloseButton(new SpenColorPickerPopup.OnCloseClickListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppColorPickerLayout.init.1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.OnCloseClickListener
            public void onCloseButtonClick() {
                InAppColorPickerLayout.this.dismissColorPicker();
            }
        });
        SpenColorPickerPopup spenColorPickerPopup2 = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup2 != null) {
            spenColorPickerPopup2.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 2));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup == null) {
            return false;
        }
        Intrinsics.checkNotNull(spenColorPickerPopup);
        return spenColorPickerPopup.isShowing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setColorTheme(int colorTheme) {
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.setColorTheme(colorTheme);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout
    public void setCurrentColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.setCurrentColor(hsvColor);
        }
        this.mHsvColor = hsvColor;
    }

    public final void setMHsvColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.mHsvColor = fArr;
    }

    public final void setPickerColorChangedListener(@Nullable SpenColorPickerPopup.ColorPickerChangedListener colorPickerChangeListener) {
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.setColorPickerChangeListener(colorPickerChangeListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingColorPickerLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int callerType, @Nullable View container, boolean withAnimation) {
        setCallerType(callerType);
        showColorPickerPopup(container);
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true);
    }

    public final void showColorPickerPopup(@Nullable View parentView) {
        InAppLogger.m8595d(TAG, "showColorPickerPopup");
        setColorTheme(this.mSettingViewManager.getColorTheme());
        SpenColorPickerPopup spenColorPickerPopup = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.setOrientationMode(1);
        }
        SpenColorPickerPopup spenColorPickerPopup2 = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup2 != null) {
            spenColorPickerPopup2.show(parentView);
        }
        SpenColorPickerPopup spenColorPickerPopup3 = this.mSpenColorPickerPopup;
        if (spenColorPickerPopup3 != null) {
            spenColorPickerPopup3.setCurrentColor(this.mHsvColor);
        }
    }
}
