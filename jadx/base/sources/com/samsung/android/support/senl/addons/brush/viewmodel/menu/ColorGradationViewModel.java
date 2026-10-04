package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.listeners.IGradationActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\nH\u0014J\b\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0018\u001a\u00020\nH\u0014J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorGradationViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "manager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;)V", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "mColorModelsManager", "setSettingModel", "", "settingsModel", "onColorGradationClick", "getActionListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/listeners/IGradationActionListener;", "getCurrentColor", "", "getViewMode", "", "getRecentColors", "getRecentColorsNum", "mCloseGradationListener", "clearModels", "closeSubViewModels", "closeCallbacks", "setColorGradationColor", "hsvColor", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorGradationViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorGradationViewModel");

    @NotNull
    private final IGradationActionListener mCloseGradationListener = new IGradationActionListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorGradationViewModel$mCloseGradationListener$1
        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayout.OnCloseClickListener
        public void onCloseButtonClick() {
            Logger.m7100d(ColorGradationViewModel.TAG, "onCloseButtonClick");
            if (this.this$0.mSettingsModel != null) {
                SystemLogManager.INSTANCE.onColorGradationClose();
                SettingsModel settingsModel = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel);
                settingsModel.setColorGradationVisibility(false);
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
        public void onColorChanged(int color, float[] hsvColor) {
            Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
            if (this.this$0.mColorModelsManager != null) {
                ColorModelsManager colorModelsManager = this.this$0.mColorModelsManager;
                Intrinsics.checkNotNull(colorModelsManager);
                int colorGradationPosition = colorModelsManager.getColorGradationPosition();
                ColorModel colorModel = new ColorModel(color, hsvColor, colorGradationPosition);
                ColorModelsManager colorModelsManager2 = this.this$0.mColorModelsManager;
                Intrinsics.checkNotNull(colorModelsManager2);
                colorModelsManager2.updateColorAndPosition(colorModel, colorGradationPosition);
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
        public void onColorPickerChanged(int mode) {
            SystemLogManager.INSTANCE.onColorGradationChange();
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
        public void onColorSeekBarChanged() {
            SystemLogManager.INSTANCE.onColorGradationSeekBarChange();
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerActionListener
        public void onRecentColorSelected() {
            SystemLogManager.INSTANCE.onColorGradationColorItemChange();
        }

        @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerViewModeChangedListener
        public void onViewModeChanged(int mode) {
            if (this.this$0.mColorModelsManager != null) {
                ColorModelsManager colorModelsManager = this.this$0.mColorModelsManager;
                Intrinsics.checkNotNull(colorModelsManager);
                colorModelsManager.setColorPickerViewMode(mode);
                SystemLogManager.INSTANCE.onColorGradationViewModeChange(mode);
            }
        }
    };

    @Nullable
    private ColorModelsManager mColorModelsManager;

    @Nullable
    private SettingsModel mSettingsModel;

    public ColorGradationViewModel(@Nullable ColorModelsManager colorModelsManager) {
        this.mColorModelsManager = colorModelsManager;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mSettingsModel = null;
        this.mColorModelsManager = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @NotNull
    /* JADX INFO: renamed from: getActionListener, reason: from getter */
    public final IGradationActionListener getMCloseGradationListener() {
        return this.mCloseGradationListener;
    }

    @NotNull
    public final float[] getCurrentColor() {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getHSVColor();
    }

    @Nullable
    public final float[] getRecentColors() {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getColorPickerRecent();
    }

    public final int getRecentColorsNum() {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getColorPickerRecentNum();
    }

    public final int getViewMode() {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getMColorPickerViewMode();
    }

    public final void onColorGradationClick() {
        Logger.m7100d(TAG, "onColorGradationClick.");
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            boolean colorGradationVisibility = settingsModel.getColorGradationVisibility();
            SettingsModel settingsModel2 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            settingsModel2.clearAllPopupVisibility();
            SystemLogManager.INSTANCE.onColorPickerSelected();
            if (colorGradationVisibility) {
                return;
            }
            SettingsModel settingsModel3 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel3);
            settingsModel3.setColorGradationVisibility(true);
        }
    }

    public final void setColorGradationColor(@Nullable float[] hsvColor) {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager);
        int colorGradationPosition = colorModelsManager.getColorGradationPosition();
        ColorModel colorModel = new ColorModel(ColorCompat.HSVToColor(hsvColor), hsvColor, colorGradationPosition);
        ColorModelsManager colorModelsManager2 = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager2);
        colorModelsManager2.updateColorAndPosition(colorModel, colorGradationPosition);
        if (hsvColor != null) {
            ColorModelsManager colorModelsManager3 = this.mColorModelsManager;
            Intrinsics.checkNotNull(colorModelsManager3);
            colorModelsManager3.saveColorPickerRecentColor(hsvColor);
        }
        notifyChanged("color_gradation_color_select");
    }

    public final void setSettingModel(@Nullable SettingsModel settingsModel) {
        this.mSettingsModel = settingsModel;
    }
}
