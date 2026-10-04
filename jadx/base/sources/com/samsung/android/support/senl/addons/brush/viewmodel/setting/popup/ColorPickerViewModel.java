package com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup;

import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.listeners.IColorPickerActionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/ColorPickerViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsModelControlViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "model", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "manager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;)V", "mSettingsModel", "mColorModelsManager", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "onClickClose", "", "closeSubViewModels", "clearModels", "closeCallbacks", "mColorPickerActionListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/listeners/IColorPickerActionListener;", "getPickerColor", "", "getColorPickerActionListener", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ColorPickerViewModel extends AbsModelControlViewModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorPickerViewModel");

    @Nullable
    private IBaseModel.Observer mCallback;

    @Nullable
    private ColorModelsManager mColorModelsManager;

    @NotNull
    private final IColorPickerActionListener mColorPickerActionListener;

    @Nullable
    private SettingsModel mSettingsModel;

    public ColorPickerViewModel(@Nullable BrushFacade brushFacade, @Nullable SettingsModel settingsModel, @Nullable ColorModelsManager colorModelsManager) {
        super(brushFacade);
        this.mCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.ColorPickerViewModel$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                int iIntValue = id.intValue();
                if (iIntValue == 203) {
                    SettingsModel settingsModel2 = this.this$0.mSettingsModel;
                    Intrinsics.checkNotNull(settingsModel2);
                    if (settingsModel2.getColorPickerVisibility()) {
                        this.this$0.notifyChanged("color_picker_color_change");
                        return;
                    }
                    return;
                }
                if (iIntValue == 505) {
                    SettingsModel settingsModel3 = this.this$0.mSettingsModel;
                    Intrinsics.checkNotNull(settingsModel3);
                    if (settingsModel3.getColorPickerVisibility()) {
                        this.this$0.notifyChanged("color_picker_color_change");
                        return;
                    } else {
                        this.this$0.notifyChanged("color_picker_color_update");
                        return;
                    }
                }
                if (iIntValue != 11303) {
                    return;
                }
                SettingsModel settingsModel4 = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel4);
                if (settingsModel4.getColorPickerVisibility()) {
                    SystemLogManager.INSTANCE.onTouchByEyedropper();
                }
            }
        };
        Logger.m7100d(TAG, "ColorPickerViewModel construct ");
        this.mSettingsModel = settingsModel;
        this.mColorModelsManager = colorModelsManager;
        IFacade mFacade = getMFacade();
        if (mFacade != null) {
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            mFacade.addObserver(observer);
        }
        ColorModelsManager colorModelsManager2 = this.mColorModelsManager;
        if (colorModelsManager2 != null) {
            IBaseModel.Observer observer2 = this.mCallback;
            Intrinsics.checkNotNull(observer2);
            colorModelsManager2.addObserver(observer2);
        }
        SettingsModel settingsModel2 = this.mSettingsModel;
        if (settingsModel2 != null) {
            IBaseModel.Observer observer3 = this.mCallback;
            Intrinsics.checkNotNull(observer3);
            settingsModel2.addObserver(observer3);
        }
        this.mColorPickerActionListener = new IColorPickerActionListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.ColorPickerViewModel$mColorPickerActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
            public void onHandlerTapped() {
                SystemLogManager.INSTANCE.onEyeDropperHandlerTapped();
            }

            @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
            public void onSpoidClosed() {
                Logger.m7100d(ColorPickerViewModel.TAG, "onSpoidClosed.");
                this.this$0.onClickClose();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickClose() {
        SettingsModel settingsModel = this.mSettingsModel;
        Intrinsics.checkNotNull(settingsModel);
        settingsModel.setColorPickerVisibility(false);
        SystemLogManager.INSTANCE.onEyeDropperClosed();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        if (colorModelsManager != null) {
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            colorModelsManager.removeObserver(observer);
        }
        this.mColorModelsManager = null;
        IFacade mFacade = getMFacade();
        if (mFacade != null) {
            IBaseModel.Observer observer2 = this.mCallback;
            Intrinsics.checkNotNull(observer2);
            mFacade.removeObserver(observer2);
        }
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            IBaseModel.Observer observer3 = this.mCallback;
            Intrinsics.checkNotNull(observer3);
            settingsModel.removeObserver(observer3);
        }
        this.mSettingsModel = null;
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallback = null;
        super.closeCallbacks();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @NotNull
    /* JADX INFO: renamed from: getColorPickerActionListener, reason: from getter */
    public final IColorPickerActionListener getMColorPickerActionListener() {
        return this.mColorPickerActionListener;
    }

    public final int getPickerColor() {
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        Intrinsics.checkNotNull(colorModelsManager);
        IExtendedColor colorPickerColor = colorModelsManager.getColorPickerColor();
        Intrinsics.checkNotNull(colorPickerColor);
        return colorPickerColor.getMColor() | (-16777216);
    }
}
