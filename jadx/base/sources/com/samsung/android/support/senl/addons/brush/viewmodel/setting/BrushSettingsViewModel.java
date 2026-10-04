package com.samsung.android.support.senl.addons.brush.viewmodel.setting;

import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopup;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.SettingPopupBuilder;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.ColorPickerViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.SettingPopupHiderViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u0004\u0018\u00010\u0005J\b\u0010#\u001a\u00020 H\u0014J\b\u0010$\u001a\u00020 H\u0014J\b\u0010%\u001a\u00020 H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/BrushSettingsViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "settingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "manager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;)V", "value", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/SettingPopupHiderViewModel;", "settingPopupHiderViewModel", "getSettingPopupHiderViewModel", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/SettingPopupHiderViewModel;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/ColorPickerViewModel;", "colorPickerViewModel", "getColorPickerViewModel", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/ColorPickerViewModel;", "mSettingPopups", "", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopup;", "getData", "", "id", "", "mSettingCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "popup", "getPopup", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopup;", "onPaletteSettingClick", "", "onEraseAllClick", "getSettingsModel", "closeSubViewModels", "closeCallbacks", "clearModels", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBrushSettingsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrushSettingsViewModel.kt\ncom/samsung/android/support/senl/addons/brush/viewmodel/setting/BrushSettingsViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
public class BrushSettingsViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_POPUP = "popup";

    @NotNull
    private static final String BINDING_ID_SETTING_VIEW_MODEL = "settingViewModel";

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushSettingsViewModel");

    @Nullable
    private ColorPickerViewModel colorPickerViewModel;

    @Nullable
    private IBaseModel.Observer mSettingCallback;

    @NotNull
    private final List<ISettingPopup> mSettingPopups = new ArrayList();

    @Nullable
    private SettingPopupHiderViewModel settingPopupHiderViewModel;

    @Nullable
    private SettingsModel settingsModel;

    public BrushSettingsViewModel(@Nullable BrushFacade brushFacade, @Nullable final SettingsModel settingsModel, @Nullable ColorModelsManager colorModelsManager) {
        this.mSettingCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.setting.BrushSettingsViewModel$mSettingCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                ISettingPopup iSettingPopupCreateRecreatePopup = null;
                Integer id = info != null ? info.getId() : null;
                if (id != null && id.intValue() == 505) {
                    SettingPopupBuilder.Companion companion = SettingPopupBuilder.INSTANCE;
                    SettingsModel settingsModel2 = settingsModel;
                    Intrinsics.checkNotNull(settingsModel2);
                    iSettingPopupCreateRecreatePopup = companion.createColorPickerPopup(settingsModel2.getColorPickerVisibility());
                } else if (id != null && id.intValue() == 502) {
                    SettingPopupBuilder.Companion companion2 = SettingPopupBuilder.INSTANCE;
                    SettingsModel settingsModel3 = settingsModel;
                    Intrinsics.checkNotNull(settingsModel3);
                    iSettingPopupCreateRecreatePopup = companion2.createErasePopup(settingsModel3.getEraserSettingVisibility());
                } else if (id != null && id.intValue() == 501) {
                    SettingPopupBuilder.Companion companion3 = SettingPopupBuilder.INSTANCE;
                    SettingsModel settingsModel4 = settingsModel;
                    Intrinsics.checkNotNull(settingsModel4);
                    iSettingPopupCreateRecreatePopup = companion3.createPenPopup(settingsModel4.getPenSettingVisibility());
                } else if (id != null && id.intValue() == 504) {
                    SettingPopupBuilder.Companion companion4 = SettingPopupBuilder.INSTANCE;
                    SettingsModel settingsModel5 = settingsModel;
                    Intrinsics.checkNotNull(settingsModel5);
                    iSettingPopupCreateRecreatePopup = companion4.createGradationPopup(settingsModel5.getColorGradationVisibility(), null);
                } else if (id != null && id.intValue() == 506) {
                    SettingPopupBuilder.Companion companion5 = SettingPopupBuilder.INSTANCE;
                    SettingsModel settingsModel6 = settingsModel;
                    Intrinsics.checkNotNull(settingsModel6);
                    iSettingPopupCreateRecreatePopup = companion5.createColorPalletPopup(settingsModel6.getPaletteSettingVisibility(), null);
                } else if (id != null && id.intValue() == 509) {
                    Logger.m7100d(BrushSettingsViewModel.TAG, "generate recreate popup");
                    iSettingPopupCreateRecreatePopup = SettingPopupBuilder.INSTANCE.createRecreatePopup();
                }
                if (iSettingPopupCreateRecreatePopup != null) {
                    this.mSettingPopups.add(iSettingPopupCreateRecreatePopup);
                    this.notifyChanged(SmpConstants.MARKETING_TYPE_POPUP);
                }
            }
        };
        this.settingPopupHiderViewModel = new SettingPopupHiderViewModel(settingsModel);
        this.colorPickerViewModel = new ColorPickerViewModel(brushFacade, settingsModel, colorModelsManager);
        this.settingsModel = settingsModel;
        Intrinsics.checkNotNull(settingsModel);
        IBaseModel.Observer observer = this.mSettingCallback;
        Intrinsics.checkNotNull(observer);
        settingsModel.addObserver(observer);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        SettingsModel settingsModel = this.settingsModel;
        if (settingsModel != null) {
            IBaseModel.Observer observer = this.mSettingCallback;
            if (observer != null) {
                Intrinsics.checkNotNull(settingsModel);
                settingsModel.removeObserver(observer);
            }
            this.settingsModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mSettingCallback = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        SettingPopupHiderViewModel settingPopupHiderViewModel = this.settingPopupHiderViewModel;
        if (settingPopupHiderViewModel != null) {
            Intrinsics.checkNotNull(settingPopupHiderViewModel);
            settingPopupHiderViewModel.close();
            this.settingPopupHiderViewModel = null;
        }
        ColorPickerViewModel colorPickerViewModel = this.colorPickerViewModel;
        if (colorPickerViewModel != null) {
            Intrinsics.checkNotNull(colorPickerViewModel);
            colorPickerViewModel.close();
            this.colorPickerViewModel = null;
        }
    }

    @Nullable
    public final ColorPickerViewModel getColorPickerViewModel() {
        return this.colorPickerViewModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual("popup", id) ? getPopup() : Intrinsics.areEqual(BINDING_ID_SETTING_VIEW_MODEL, id) ? this : super.getData(id);
    }

    @NotNull
    public final ISettingPopup getPopup() {
        if (this.mSettingPopups.isEmpty()) {
            return SettingPopupBuilder.INSTANCE.createNonePopup();
        }
        ISettingPopup iSettingPopup = this.mSettingPopups.get(0);
        this.mSettingPopups.remove(0);
        if (!this.mSettingPopups.isEmpty()) {
            notifyChanged("popup");
        }
        return iSettingPopup;
    }

    @Nullable
    public final SettingPopupHiderViewModel getSettingPopupHiderViewModel() {
        return this.settingPopupHiderViewModel;
    }

    @Nullable
    public final SettingsModel getSettingsModel() {
        return this.settingsModel;
    }

    public final void onEraseAllClick() {
        Logger.m7100d(TAG, "onEraseAllClick");
        SettingsModel settingsModel = this.settingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            settingsModel.clearAllPopupVisibility();
            SettingsModel settingsModel2 = this.settingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            settingsModel2.setMode(2);
            SystemLogManager.INSTANCE.onEraseAllClicked();
        }
    }

    public final void onPaletteSettingClick() {
        Logger.m7100d(TAG, "onPaletteSettingClick");
        SettingsModel settingsModel = this.settingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            boolean paletteSettingVisibility = settingsModel.getPaletteSettingVisibility();
            SettingsModel settingsModel2 = this.settingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            settingsModel2.clearAllPopupVisibility();
            SettingsModel settingsModel3 = this.settingsModel;
            Intrinsics.checkNotNull(settingsModel3);
            settingsModel3.setPaletteSettingVisibility(!paletteSettingVisibility);
            SystemLogManager.INSTANCE.onSelectColorSetsOpened();
        }
    }
}
