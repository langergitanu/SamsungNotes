package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.canvas.BrushCanvasViewModel;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ\b\u0010 \u001a\u0004\u0018\u00010\u0010J\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u001c\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0019J\b\u0010-\u001a\u00020#H\u0014J\b\u0010.\u001a\u00020#H\u0014J\b\u0010/\u001a\u00020#H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/MenuLayoutViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;", "manager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;)V", "mScreenModel", "mColorMenuViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorMenuViewModel;", "mColorGradationViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorGradationViewModel;", "mSubMenuLayoutViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/SubMenuLayoutViewModel;", "mBrushCanvasViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/canvas/BrushCanvasViewModel;", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "mColorManager", "mPenModeOpen", "", "penPopupAlign", "", "getPenPopupAlign", "()I", "setPenPopupAlign", "(I)V", "getColorGradationViewModel", "getColorMenuViewModel", "getSubMenuLayoutViewModel", "getBrushCanvasViewModel", "setSettingModel", "", "settingModel", "penCount", "selectedPosition", "isOpen", "penViewMode", "getPenViewMode", "()Z", "setPenViewMode", "(Z)V", "closeSubViewModels", "clearModels", "closeCallbacks", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuLayoutViewModel extends AbsBaseViewModel {
    private static final int PEN_SETTING_POPUP_ALIGN_CENTER = 0;
    private static final int PEN_SETTING_POPUP_ALIGN_END = 1;
    private static final int PEN_SETTING_POPUP_ALIGN_START = -1;

    @Nullable
    private BrushCanvasViewModel mBrushCanvasViewModel;

    @Nullable
    private ColorGradationViewModel mColorGradationViewModel;

    @Nullable
    private ColorModelsManager mColorManager;

    @Nullable
    private ColorMenuViewModel mColorMenuViewModel;
    private boolean mPenModeOpen;

    @Nullable
    private IScreenModel mScreenModel;

    @Nullable
    private SettingsModel mSettingsModel;

    @Nullable
    private SubMenuLayoutViewModel mSubMenuLayoutViewModel;
    private int penPopupAlign = -1;

    @NotNull
    private static final String TAG = Logger.createBrushTag("MenuLayoutViewModel");

    public MenuLayoutViewModel(@Nullable IScreenModel iScreenModel, @Nullable IMenuSizeInjector iMenuSizeInjector, @Nullable ColorModelsManager colorModelsManager) {
        Intrinsics.checkNotNull(colorModelsManager);
        Intrinsics.checkNotNull(iScreenModel);
        this.mColorMenuViewModel = new ColorMenuViewModel(colorModelsManager, iScreenModel);
        Intrinsics.checkNotNull(iMenuSizeInjector);
        this.mSubMenuLayoutViewModel = new SubMenuLayoutViewModel(iMenuSizeInjector, iScreenModel);
        this.mBrushCanvasViewModel = new BrushCanvasViewModel();
        this.mColorGradationViewModel = new ColorGradationViewModel(colorModelsManager);
        this.mScreenModel = iScreenModel;
        this.mColorManager = colorModelsManager;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mScreenModel = null;
        this.mSettingsModel = null;
        this.mColorManager = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        SubMenuLayoutViewModel subMenuLayoutViewModel = this.mSubMenuLayoutViewModel;
        if (subMenuLayoutViewModel != null) {
            Intrinsics.checkNotNull(subMenuLayoutViewModel);
            subMenuLayoutViewModel.close();
            this.mSubMenuLayoutViewModel = null;
        }
        ColorMenuViewModel colorMenuViewModel = this.mColorMenuViewModel;
        if (colorMenuViewModel != null) {
            Intrinsics.checkNotNull(colorMenuViewModel);
            colorMenuViewModel.close();
            this.mColorMenuViewModel = null;
        }
        BrushCanvasViewModel brushCanvasViewModel = this.mBrushCanvasViewModel;
        if (brushCanvasViewModel != null) {
            Intrinsics.checkNotNull(brushCanvasViewModel);
            brushCanvasViewModel.close();
            this.mBrushCanvasViewModel = null;
        }
        ColorGradationViewModel colorGradationViewModel = this.mColorGradationViewModel;
        if (colorGradationViewModel != null) {
            Intrinsics.checkNotNull(colorGradationViewModel);
            colorGradationViewModel.close();
            this.mColorGradationViewModel = null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getBrushCanvasViewModel, reason: from getter */
    public final BrushCanvasViewModel getMBrushCanvasViewModel() {
        return this.mBrushCanvasViewModel;
    }

    @Nullable
    /* JADX INFO: renamed from: getColorGradationViewModel, reason: from getter */
    public final ColorGradationViewModel getMColorGradationViewModel() {
        return this.mColorGradationViewModel;
    }

    @Nullable
    /* JADX INFO: renamed from: getColorMenuViewModel, reason: from getter */
    public final ColorMenuViewModel getMColorMenuViewModel() {
        return this.mColorMenuViewModel;
    }

    public final int getPenPopupAlign() {
        return this.penPopupAlign;
    }

    /* JADX INFO: renamed from: getPenViewMode, reason: from getter */
    public final boolean getMPenModeOpen() {
        return this.mPenModeOpen;
    }

    @Nullable
    /* JADX INFO: renamed from: getSubMenuLayoutViewModel, reason: from getter */
    public final SubMenuLayoutViewModel getMSubMenuLayoutViewModel() {
        return this.mSubMenuLayoutViewModel;
    }

    public final void setPenPopupAlign(int i) {
        this.penPopupAlign = i;
    }

    public final void setPenViewMode(boolean z) {
        this.mPenModeOpen = z;
        SystemLogManager.INSTANCE.onShowHideBrushesClicked(z);
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            settingsModel.clearAllPopupVisibility();
        }
    }

    public final void setSettingModel(@Nullable SettingsModel settingModel) {
        this.mSettingsModel = settingModel;
    }

    public final void setPenPopupAlign(int penCount, int selectedPosition) {
        if (penCount % 3 == 0) {
            this.penPopupAlign = (selectedPosition / 3) - 1;
        } else {
            this.penPopupAlign = 0;
            if (selectedPosition < 3) {
                this.penPopupAlign = -1;
            } else if (selectedPosition >= 5) {
                this.penPopupAlign = 1;
            }
        }
        int i = this.penPopupAlign;
        String str = i == 0 ? "CENTER" : i == -1 ? CoeditGrpcMethod.Caller.START : i == 1 ? CoeditGrpcMethod.Caller.END : "";
        String str2 = TAG;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("penPopupAlign. ", i, SQLKeyword.COMMA, str, " / ");
        sbM1629s.append(penCount);
        sbM1629s.append(" , ");
        sbM1629s.append(selectedPosition);
        Logger.m7100d(str2, sbM1629s.toString());
    }
}
