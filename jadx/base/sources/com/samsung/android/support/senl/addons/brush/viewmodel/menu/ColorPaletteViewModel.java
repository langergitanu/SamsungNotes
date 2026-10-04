package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel;
import com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorPaletteViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "model", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mModel", "getMModel", "()Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;", "setMModel", "(Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;)V", "mColorVMSet", "", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorViewModel;", "getMColorVMSet", "()[Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorViewModel;", "setMColorVMSet", "([Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorViewModel;)V", "[Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorViewModel;", "setSettingModel", "", "settingModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "getColorViewModel", "index", "", "closeSubViewModels", "clearModels", "closeCallbacks", "getSelectedIndex", "selectPaletteColor", "color", "position", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorPaletteViewModel extends AbsBaseViewModel {

    @Nullable
    private ColorViewModel[] mColorVMSet;

    @Nullable
    private ColorPaletteModel mModel;

    public ColorPaletteViewModel(@Nullable ColorPaletteModel colorPaletteModel, @Nullable IScreenModel iScreenModel) {
        this.mModel = colorPaletteModel;
        Intrinsics.checkNotNull(colorPaletteModel);
        int colorSize = colorPaletteModel.getColorSize();
        this.mColorVMSet = new ColorViewModel[colorSize];
        for (int i = 0; i < colorSize; i++) {
            ColorViewModel[] colorViewModelArr = this.mColorVMSet;
            Intrinsics.checkNotNull(colorViewModelArr);
            ColorPaletteModel colorPaletteModel2 = this.mModel;
            Intrinsics.checkNotNull(colorPaletteModel2);
            IMenuColorModel colorModel = colorPaletteModel2.getColorModel(i);
            Intrinsics.checkNotNull(colorModel);
            colorViewModelArr[i] = new ColorViewModel(colorModel, iScreenModel);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mModel = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        ColorViewModel[] colorViewModelArr = this.mColorVMSet;
        if (colorViewModelArr != null) {
            Intrinsics.checkNotNull(colorViewModelArr);
            int length = colorViewModelArr.length;
            for (int i = 0; i < length; i++) {
                ColorViewModel[] colorViewModelArr2 = this.mColorVMSet;
                Intrinsics.checkNotNull(colorViewModelArr2);
                ColorViewModel colorViewModel = colorViewModelArr2[i];
                Intrinsics.checkNotNull(colorViewModel);
                colorViewModel.close();
                ColorViewModel[] colorViewModelArr3 = this.mColorVMSet;
                Intrinsics.checkNotNull(colorViewModelArr3);
                colorViewModelArr3[i] = null;
            }
            this.mColorVMSet = null;
        }
    }

    @Nullable
    public ColorViewModel getColorViewModel(int index) {
        ColorViewModel[] colorViewModelArr = this.mColorVMSet;
        Intrinsics.checkNotNull(colorViewModelArr);
        return colorViewModelArr[index];
    }

    @Nullable
    public final ColorViewModel[] getMColorVMSet() {
        return this.mColorVMSet;
    }

    @Nullable
    public final ColorPaletteModel getMModel() {
        return this.mModel;
    }

    public int getSelectedIndex() {
        ColorViewModel[] colorViewModelArr = this.mColorVMSet;
        if (colorViewModelArr == null) {
            return -1;
        }
        Intrinsics.checkNotNull(colorViewModelArr);
        int length = colorViewModelArr.length;
        for (int i = 0; i < length; i++) {
            ColorViewModel[] colorViewModelArr2 = this.mColorVMSet;
            Intrinsics.checkNotNull(colorViewModelArr2);
            ColorViewModel colorViewModel = colorViewModelArr2[i];
            Intrinsics.checkNotNull(colorViewModel);
            if (colorViewModel.isSelected()) {
                return i;
            }
        }
        return -1;
    }

    public void selectPaletteColor(int color, int position) {
        ColorViewModel[] colorViewModelArr = this.mColorVMSet;
        Intrinsics.checkNotNull(colorViewModelArr);
        for (ColorViewModel colorViewModel : colorViewModelArr) {
            Intrinsics.checkNotNull(colorViewModel);
            colorViewModel.setSelected(colorViewModel.getColor() == color && ((-1048576) & position) == 2097152);
        }
    }

    public final void setMColorVMSet(@Nullable ColorViewModel[] colorViewModelArr) {
        this.mColorVMSet = colorViewModelArr;
    }

    public final void setMModel(@Nullable ColorPaletteModel colorPaletteModel) {
        this.mModel = colorPaletteModel;
    }

    public void setSettingModel(@Nullable SettingsModel settingModel) {
        ColorPaletteModel colorPaletteModel = this.mModel;
        Intrinsics.checkNotNull(colorPaletteModel);
        int colorSize = colorPaletteModel.getColorSize();
        for (int i = 0; i < colorSize; i++) {
            ColorViewModel[] colorViewModelArr = this.mColorVMSet;
            Intrinsics.checkNotNull(colorViewModelArr);
            ColorViewModel colorViewModel = colorViewModelArr[i];
            Intrinsics.checkNotNull(colorViewModel);
            colorViewModel.setSettingModel(settingModel);
        }
    }
}
