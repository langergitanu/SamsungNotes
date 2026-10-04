package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.util.BrushToastHandler;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.listeners.IPaletteSettingActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 62\u00020\u0001:\u00016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u001eJ\b\u0010&\u001a\u0004\u0018\u00010'J\u0016\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001eJ\u0006\u0010+\u001a\u00020\u001eJ\u001e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200J\b\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u0004\u0018\u000102J\b\u00105\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorMenuViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "manager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mColorManager", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "mScreenModel", "mPalettes", "", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorPaletteViewModel;", "mRecent", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorRecentViewModel;", "setColorPalettes", "", "clearPalettes", "setSettingModel", "settingModel", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "getRecentVM", "clearModels", "closeSubViewModels", "closeCallbacks", "getSelectedIndices", "", "", "getSelectedPalettes", "getMaxPaletteIndices", "getMaxPaletteSelectable", "setMainColorAndPosition", "hsvColor", "", "position", "getSelectedColor", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "swipePalettes", "direction", "id", "getCurrentPage", "selectColorButton", "pageIndex", "childIndex", "isSelected", "", "mPaletteSettingActionListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/listeners/IPaletteSettingActionListener;", "updatePalettes", "getPaletteSettingListener", "getScreenModel", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorMenuViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorMenuViewModel");

    @Nullable
    private IBaseModel.Observer mCallback;

    @Nullable
    private ColorModelsManager mColorManager;

    @NotNull
    private final IPaletteSettingActionListener mPaletteSettingActionListener;

    @Nullable
    private List<ColorPaletteViewModel> mPalettes;

    @Nullable
    private ColorRecentViewModel mRecent;

    @Nullable
    private IScreenModel mScreenModel;

    @Nullable
    private SettingsModel mSettingsModel;

    public ColorMenuViewModel(@NotNull ColorModelsManager manager, @NotNull IScreenModel screenModel) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(screenModel, "screenModel");
        this.mPalettes = new ArrayList();
        this.mColorManager = manager;
        this.mScreenModel = screenModel;
        setColorPalettes();
        this.mCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                if (id.intValue() == 506) {
                    SettingsModel settingsModel = this.this$0.mSettingsModel;
                    Intrinsics.checkNotNull(settingsModel);
                    if (settingsModel.getPaletteSettingVisibility()) {
                        return;
                    }
                    this.this$0.updatePalettes();
                }
            }
        };
        this.mPaletteSettingActionListener = new IPaletteSettingActionListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel$mPaletteSettingActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayout.IEventListener
            public void onChangeSelected(List<Integer> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                StringBuilder sb = new StringBuilder();
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().intValue());
                    sb.append('/');
                }
                Logger.m7100d(ColorMenuViewModel.TAG, "onChangeSelected. " + ((Object) sb));
                SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                systemLogManager.onPaletteChangeSelected(string);
                ColorModelsManager colorModelsManager = this.this$0.mColorManager;
                Intrinsics.checkNotNull(colorModelsManager);
                colorModelsManager.changeSelectedPalette(list);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayout.OnCloseClickListener
            public void onCloseButtonClick() {
                SettingsModel settingsModel = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel);
                settingsModel.setPaletteSettingVisibility(false);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayout.ToastTextNotifyListener
            public void onNotifyToastText(String text) {
                BrushToastHandler.showShort(text);
            }
        };
    }

    private final void clearPalettes() {
        List<ColorPaletteViewModel> list = this.mPalettes;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<ColorPaletteViewModel> list2 = this.mPalettes;
            Intrinsics.checkNotNull(list2);
            list2.get(i).close();
        }
        List<ColorPaletteViewModel> list3 = this.mPalettes;
        Intrinsics.checkNotNull(list3);
        list3.clear();
    }

    private final void setColorPalettes() {
        clearPalettes();
        if (this.mRecent == null) {
            ColorModelsManager colorModelsManager = this.mColorManager;
            Intrinsics.checkNotNull(colorModelsManager);
            this.mRecent = new ColorRecentViewModel(colorModelsManager.getRecent(), this.mScreenModel);
        }
        ColorModelsManager colorModelsManager2 = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager2);
        int colorPalletSize = colorModelsManager2.getColorPalletSize();
        for (int i = 0; i < colorPalletSize; i++) {
            ColorModelsManager colorModelsManager3 = this.mColorManager;
            Intrinsics.checkNotNull(colorModelsManager3);
            ColorPaletteViewModel colorPaletteViewModel = new ColorPaletteViewModel(colorModelsManager3.getPalette(i), this.mScreenModel);
            List<ColorPaletteViewModel> list = this.mPalettes;
            Intrinsics.checkNotNull(list);
            list.add(colorPaletteViewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePalettes() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager);
        colorModelsManager.updatePalette();
        setColorPalettes();
        notifyChanged("palette_list_change");
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            settingsModel.removeObserver(observer);
            this.mSettingsModel = null;
        }
        if (this.mScreenModel != null) {
            this.mScreenModel = null;
        }
        if (this.mColorManager != null) {
            this.mColorManager = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallback = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        List<ColorPaletteViewModel> list = this.mPalettes;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<ColorPaletteViewModel> list2 = this.mPalettes;
                Intrinsics.checkNotNull(list2);
                list2.get(i).close();
            }
            List<ColorPaletteViewModel> list3 = this.mPalettes;
            Intrinsics.checkNotNull(list3);
            list3.clear();
            this.mPalettes = null;
        }
        ColorRecentViewModel colorRecentViewModel = this.mRecent;
        if (colorRecentViewModel != null) {
            Intrinsics.checkNotNull(colorRecentViewModel);
            colorRecentViewModel.close();
            this.mRecent = null;
        }
    }

    public final int getCurrentPage() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        if (colorModelsManager == null) {
            return 0;
        }
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getMActivatedPage() - 1;
    }

    @Nullable
    public final List<Integer> getMaxPaletteIndices() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getMaxPaletteIndices();
    }

    public final int getMaxPaletteSelectable() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getMSelectableMaxPalette();
    }

    @Nullable
    /* JADX INFO: renamed from: getPaletteSettingListener, reason: from getter */
    public final IPaletteSettingActionListener getMPaletteSettingActionListener() {
        return this.mPaletteSettingActionListener;
    }

    @Nullable
    /* JADX INFO: renamed from: getRecentVM, reason: from getter */
    public final ColorRecentViewModel getMRecent() {
        return this.mRecent;
    }

    @Nullable
    /* JADX INFO: renamed from: getScreenModel, reason: from getter */
    public final IScreenModel getMScreenModel() {
        return this.mScreenModel;
    }

    @Nullable
    public final IExtendedColor getSelectedColor() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getSelectedColor();
    }

    @Nullable
    public final List<Integer> getSelectedIndices() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getSelectedIndices();
    }

    @Nullable
    public final List<Integer> getSelectedPalettes() {
        ColorModelsManager colorModelsManager = this.mColorManager;
        Intrinsics.checkNotNull(colorModelsManager);
        return colorModelsManager.getSelectedPalettes();
    }

    public final void selectColorButton(int pageIndex, int childIndex, boolean isSelected) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIndex, childIndex, "selectColorButton. ", "/", SQLKeyword.COMMA);
        sbM1173s.append(isSelected);
        Logger.m7100d(str, sbM1173s.toString());
        SettingsModel settingsModel = this.mSettingsModel;
        Intrinsics.checkNotNull(settingsModel);
        if (settingsModel.getCurrentMode() != 5) {
            SettingsModel settingsModel2 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            settingsModel2.setMode(2);
            SettingsModel settingsModel3 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel3);
            settingsModel3.clearAllPopupVisibility();
        }
    }

    public final void setMainColorAndPosition(@Nullable float[] hsvColor, int position) {
        if (hsvColor != null) {
            int iHSVToColor = ColorCompat.HSVToColor(hsvColor);
            ColorRecentViewModel colorRecentViewModel = this.mRecent;
            Intrinsics.checkNotNull(colorRecentViewModel);
            colorRecentViewModel.selectPaletteColor(iHSVToColor, position);
            List<ColorPaletteViewModel> list = this.mPalettes;
            Intrinsics.checkNotNull(list);
            Iterator<ColorPaletteViewModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().selectPaletteColor(iHSVToColor, position);
            }
            ColorModelsManager colorModelsManager = this.mColorManager;
            Intrinsics.checkNotNull(colorModelsManager);
            colorModelsManager.setSelectedColor(hsvColor, position, true);
            SystemLogManager.INSTANCE.onColorSelected(iHSVToColor);
        }
    }

    public final void setSettingModel(@Nullable SettingsModel settingModel) {
        this.mSettingsModel = settingModel;
        ColorRecentViewModel colorRecentViewModel = this.mRecent;
        if (colorRecentViewModel != null) {
            Intrinsics.checkNotNull(colorRecentViewModel);
            colorRecentViewModel.setSettingModel(this.mSettingsModel);
        }
        List<ColorPaletteViewModel> list = this.mPalettes;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<ColorPaletteViewModel> list2 = this.mPalettes;
            Intrinsics.checkNotNull(list2);
            list2.get(i).setSettingModel(this.mSettingsModel);
        }
        SettingsModel settingsModel = this.mSettingsModel;
        Intrinsics.checkNotNull(settingsModel);
        IBaseModel.Observer observer = this.mCallback;
        Intrinsics.checkNotNull(observer);
        settingsModel.addObserver(observer);
    }

    public final void swipePalettes(int direction, int id) {
        Logger.m7100d(TAG, "swipePalettes. " + direction + "/" + id);
        if (direction < 0) {
            ColorModelsManager colorModelsManager = this.mColorManager;
            Intrinsics.checkNotNull(colorModelsManager);
            colorModelsManager.prev();
            SystemLogManager.INSTANCE.onPaletteSwipeNext();
            return;
        }
        if (direction <= 0) {
            ColorModelsManager colorModelsManager2 = this.mColorManager;
            Intrinsics.checkNotNull(colorModelsManager2);
            colorModelsManager2.setActivatedPage(id);
        } else {
            ColorModelsManager colorModelsManager3 = this.mColorManager;
            Intrinsics.checkNotNull(colorModelsManager3);
            colorModelsManager3.next();
            SystemLogManager.INSTANCE.onPaletteSwipePrev();
        }
    }
}
