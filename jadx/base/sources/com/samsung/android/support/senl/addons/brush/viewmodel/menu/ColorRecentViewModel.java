package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorRecentModel;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001)B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u0016\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0018\u0010!\u001a\u00020\u00142\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fJ\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bJ\b\u0010'\u001a\u0004\u0018\u00010$J\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorRecentViewModel;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorPaletteViewModel;", "model", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorRecentModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/color/ColorRecentModel;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "mIsShown", "", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "getData", "", "id", "", "getVisibility", "setSettingModel", "", "settingModel", "onClickColorPicker", "clearModels", "closeCallbacks", "selectPaletteColor", "color", "", "position", "getSelectedIndex", "getRecentPaletteList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "updateColorRecentViewModel", XmlErrorCodes.LIST, "getNextRecentColor", "", "getSelectedNextItem", "selectIdx", "getPrevRecentColor", "getSelectedPrevItem", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorRecentViewModel extends ColorPaletteViewModel {

    @NotNull
    private static final String BINDING_ID_VISIBILITY = "visibility";
    private static final int RECENT_MAX_SIZE = 9;

    @Nullable
    private IBaseModel.Observer mCallback;
    private boolean mIsShown;

    @Nullable
    private SettingsModel mSettingsModel;

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorRecentViewModel");

    public ColorRecentViewModel(@Nullable ColorRecentModel colorRecentModel, @Nullable IScreenModel iScreenModel) {
        super(colorRecentModel, iScreenModel);
        this.mCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorRecentViewModel$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                if (id.intValue() == 20100) {
                    Logger.m7100d(ColorRecentViewModel.TAG, "RECENT PUSHED");
                    ColorViewModel[] mColorVMSet = this.this$0.getMColorVMSet();
                    Intrinsics.checkNotNull(mColorVMSet);
                    int length = mColorVMSet.length;
                    for (int i = 0; i < length; i++) {
                        ColorViewModel[] mColorVMSet2 = this.this$0.getMColorVMSet();
                        Intrinsics.checkNotNull(mColorVMSet2);
                        ColorViewModel colorViewModel = mColorVMSet2[i];
                        Intrinsics.checkNotNull(colorViewModel);
                        ColorPaletteModel mModel = this.this$0.getMModel();
                        Intrinsics.checkNotNull(mModel);
                        colorViewModel.setModel(mModel.getColorModel(i));
                    }
                    this.this$0.notifyChanged("recent_palette_item_change");
                }
            }
        };
        ColorPaletteModel mModel = getMModel();
        Intrinsics.checkNotNull(mModel);
        IBaseModel.Observer observer = this.mCallback;
        Intrinsics.checkNotNull(observer);
        mModel.addObserver(observer);
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorPaletteViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        ColorPaletteModel mModel = getMModel();
        if (mModel != null) {
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            mModel.removeObserver(observer);
        }
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorPaletteViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallback = null;
        super.closeCallbacks();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual("visibility", id) ? Boolean.valueOf(getMIsShown()) : super.getData(id);
    }

    @Nullable
    public final float[] getNextRecentColor() {
        int selectedNextItem = getSelectedNextItem(getSelectedIndex());
        if (selectedNextItem < 0 || selectedNextItem >= 9) {
            return null;
        }
        Logger.m7100d(TAG, "getNextRecentColor. " + selectedNextItem);
        ColorViewModel colorViewModel = getColorViewModel(selectedNextItem);
        Intrinsics.checkNotNull(colorViewModel);
        return colorViewModel.getHSV();
    }

    @Nullable
    public final float[] getPrevRecentColor() {
        int selectedPrevItem = getSelectedPrevItem(getSelectedIndex());
        if (selectedPrevItem < 0 || selectedPrevItem >= 9) {
            return null;
        }
        Logger.m7100d(TAG, "getPrevRecentColor. " + selectedPrevItem);
        ColorViewModel colorViewModel = getColorViewModel(selectedPrevItem);
        Intrinsics.checkNotNull(colorViewModel);
        return colorViewModel.getHSV();
    }

    @NotNull
    public final List<SpenHSVColor> getRecentPaletteList() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            ColorViewModel[] mColorVMSet = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet);
            ColorViewModel colorViewModel = mColorVMSet[i];
            Intrinsics.checkNotNull(colorViewModel);
            if (colorViewModel.isEnabled()) {
                arrayList.add(new SpenHSVColor(colorViewModel.getHSV()));
            }
        }
        updateColorRecentViewModel(arrayList);
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorPaletteViewModel
    public int getSelectedIndex() {
        if (getMColorVMSet() == null) {
            return -1;
        }
        for (int i = 0; i < 9; i++) {
            ColorViewModel[] mColorVMSet = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet);
            ColorViewModel colorViewModel = mColorVMSet[i];
            Intrinsics.checkNotNull(colorViewModel);
            if (colorViewModel.getEnabled()) {
                ColorViewModel[] mColorVMSet2 = getMColorVMSet();
                Intrinsics.checkNotNull(mColorVMSet2);
                ColorViewModel colorViewModel2 = mColorVMSet2[i];
                Intrinsics.checkNotNull(colorViewModel2);
                if (colorViewModel2.isSelected()) {
                    AbstractC6670b.m4761v(i, "getSelectedIndex. ", TAG);
                    return i;
                }
            }
        }
        return -1;
    }

    public final int getSelectedNextItem(int selectIdx) {
        int i = selectIdx + 1;
        if (i >= 0 && i < 9) {
            ColorViewModel[] mColorVMSet = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet);
            ColorViewModel colorViewModel = mColorVMSet[i];
            Intrinsics.checkNotNull(colorViewModel);
            if (colorViewModel.getEnabled()) {
                return i;
            }
        }
        ColorViewModel[] mColorVMSet2 = getMColorVMSet();
        Intrinsics.checkNotNull(mColorVMSet2);
        ColorViewModel colorViewModel2 = mColorVMSet2[0];
        Intrinsics.checkNotNull(colorViewModel2);
        return colorViewModel2.getEnabled() ? 0 : -1;
    }

    public final int getSelectedPrevItem(int selectIdx) {
        int i = selectIdx - 1;
        if (i >= 0 && i < 9) {
            ColorViewModel[] mColorVMSet = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet);
            ColorViewModel colorViewModel = mColorVMSet[i];
            Intrinsics.checkNotNull(colorViewModel);
            if (colorViewModel.getEnabled()) {
                return i;
            }
        }
        for (int i2 = 8; -1 < i2; i2--) {
            ColorViewModel[] mColorVMSet2 = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet2);
            ColorViewModel colorViewModel2 = mColorVMSet2[i2];
            Intrinsics.checkNotNull(colorViewModel2);
            if (colorViewModel2.getEnabled()) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: getVisibility, reason: from getter */
    public final boolean getMIsShown() {
        return this.mIsShown;
    }

    public final void onClickColorPicker() {
        Logger.m7100d(TAG, "onClickColorPicker");
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            if (settingsModel.getColorPickerVisibility()) {
                return;
            }
            SettingsModel settingsModel2 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            if (settingsModel2.getCurrentMode() == 4) {
                SettingsModel settingsModel3 = this.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel3);
                settingsModel3.setMode(2);
            }
            SystemLogManager.INSTANCE.onEyeDropperOpened();
            SettingsModel settingsModel4 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel4);
            settingsModel4.setColorPickerVisibility(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorPaletteViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void selectPaletteColor(int color, int position) {
        boolean z;
        for (int i = 0; i < 9; i++) {
            ColorViewModel[] mColorVMSet = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet);
            ColorViewModel colorViewModel = mColorVMSet[i];
            Intrinsics.checkNotNull(colorViewModel);
            ColorViewModel[] mColorVMSet2 = getMColorVMSet();
            Intrinsics.checkNotNull(mColorVMSet2);
            ColorViewModel colorViewModel2 = mColorVMSet2[i];
            Intrinsics.checkNotNull(colorViewModel2);
            if (colorViewModel2.getEnabled()) {
                ColorViewModel[] mColorVMSet3 = getMColorVMSet();
                Intrinsics.checkNotNull(mColorVMSet3);
                ColorViewModel colorViewModel3 = mColorVMSet3[i];
                Intrinsics.checkNotNull(colorViewModel3);
                z = colorViewModel3.getColor() == color && ((-1048576) & position) == 1048576;
            }
            colorViewModel.setSelected(z);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorPaletteViewModel
    public void setSettingModel(@Nullable SettingsModel settingModel) {
        this.mSettingsModel = settingModel;
    }

    public final void updateColorRecentViewModel(@Nullable List<SpenHSVColor> list) {
        if (list == null) {
            return;
        }
        float[] fArr = new float[3];
        int size = list.size();
        StringBuilder sb = new StringBuilder("recent color : ");
        for (int i = 0; i < 9; i++) {
            if (i < size) {
                ColorViewModel[] mColorVMSet = getMColorVMSet();
                Intrinsics.checkNotNull(mColorVMSet);
                ColorViewModel colorViewModel = mColorVMSet[i];
                Intrinsics.checkNotNull(colorViewModel);
                colorViewModel.setEnabled(true);
                SpenHSVColor spenHSVColor = list.get(i);
                Intrinsics.checkNotNull(spenHSVColor);
                spenHSVColor.getColor(fArr);
                ColorViewModel[] mColorVMSet2 = getMColorVMSet();
                Intrinsics.checkNotNull(mColorVMSet2);
                ColorViewModel colorViewModel2 = mColorVMSet2[i];
                Intrinsics.checkNotNull(colorViewModel2);
                colorViewModel2.setColor(fArr);
                ColorViewModel[] mColorVMSet3 = getMColorVMSet();
                Intrinsics.checkNotNull(mColorVMSet3);
                ColorViewModel colorViewModel3 = mColorVMSet3[i];
                Intrinsics.checkNotNull(colorViewModel3);
                sb.append(Integer.toHexString(colorViewModel3.getColor()));
                sb.append('|');
            } else {
                ColorViewModel[] mColorVMSet4 = getMColorVMSet();
                Intrinsics.checkNotNull(mColorVMSet4);
                ColorViewModel colorViewModel4 = mColorVMSet4[i];
                Intrinsics.checkNotNull(colorViewModel4);
                colorViewModel4.setEnabled(false);
            }
        }
        Logger.m7104i(TAG, sb.toString());
    }
}
