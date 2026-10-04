package com.samsung.android.support.senl.addons.brush.view.menu;

import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorRecentViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.ColorPickerViewModel;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$mColorMenuCallback$1", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "onUpdate", "", "info", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Info;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushMenuContainer$mColorMenuCallback$1 extends IBaseViewModel.Observer {
    final /* synthetic */ BrushMenuContainer this$0;

    public BrushMenuContainer$mColorMenuCallback$1(BrushMenuContainer brushMenuContainer) {
        this.this$0 = brushMenuContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$0(BrushMenuContainer brushMenuContainer) {
        float[] fArr = new float[3];
        ColorPickerViewModel colorPickerViewModel = brushMenuContainer.mColorPickerViewModel;
        Integer numValueOf = colorPickerViewModel != null ? Integer.valueOf(colorPickerViewModel.getPickerColor()) : null;
        Intrinsics.checkNotNull(numValueOf);
        ColorCompat.colorToHSV(numValueOf.intValue(), fArr);
        ColorMenuViewModel colorMenuViewModel = brushMenuContainer.mColorMenuViewModel;
        if (colorMenuViewModel != null) {
            colorMenuViewModel.setMainColorAndPosition(fArr, 1048576);
        }
        BrushMenuControl brushMenuControl = brushMenuContainer.mBrushMenuControl;
        if (brushMenuControl != null) {
            brushMenuControl.updateCurrentColorView(true);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
    public void onUpdate(IBaseViewModel.Info info) {
        BrushMenuControl brushMenuControl;
        BrushMenuControl brushMenuControl2;
        String id = info != null ? info.getId() : null;
        if (id != null) {
            switch (id.hashCode()) {
                case -2143738195:
                    if (id.equals("palette_list_change") && (brushMenuControl = this.this$0.mBrushMenuControl) != null) {
                        ColorMenuViewModel colorMenuViewModel = this.this$0.mColorMenuViewModel;
                        Intrinsics.checkNotNull(colorMenuViewModel);
                        brushMenuControl.updatePaletteList(colorMenuViewModel.getSelectedIndices());
                    }
                    break;
                case -1468153535:
                    if (id.equals("color_picker_color_change") && (brushMenuControl2 = this.this$0.mBrushMenuControl) != null) {
                        ColorPickerViewModel colorPickerViewModel = this.this$0.mColorPickerViewModel;
                        Integer numValueOf = colorPickerViewModel != null ? Integer.valueOf(colorPickerViewModel.getPickerColor()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        brushMenuControl2.updateCurrentPenView(numValueOf.intValue());
                    }
                    break;
                case -945363366:
                    if (id.equals("color_picker_color_update")) {
                        BrushMenuContainer brushMenuContainer = this.this$0;
                        brushMenuContainer.post(new RunnableC7599e(brushMenuContainer, 9));
                        break;
                    }
                    break;
                case 1306379660:
                    if (id.equals("color_gradation_color_select")) {
                        BrushMenuControl brushMenuControl3 = this.this$0.mBrushMenuControl;
                        if (brushMenuControl3 != null) {
                            brushMenuControl3.updateCurrentColorView(true);
                        }
                        BrushMenuControl brushMenuControl4 = this.this$0.mBrushMenuControl;
                        if (brushMenuControl4 != null) {
                            brushMenuControl4.updateCurrentPenView();
                        }
                        break;
                    }
                    break;
                case 2040641204:
                    if (id.equals("recent_palette_item_change")) {
                        BrushMenuControl brushMenuControl5 = this.this$0.mBrushMenuControl;
                        if (brushMenuControl5 != null) {
                            ColorRecentViewModel colorRecentViewModel = this.this$0.mColorRecentViewModel;
                            ColorViewModel colorViewModel = colorRecentViewModel != null ? colorRecentViewModel.getColorViewModel(0) : null;
                            Intrinsics.checkNotNull(colorViewModel);
                            brushMenuControl5.addRecentColor(colorViewModel.getHSV());
                        }
                        ColorRecentViewModel colorRecentViewModel2 = this.this$0.mColorRecentViewModel;
                        if (colorRecentViewModel2 != null) {
                            BrushMenuControl brushMenuControl6 = this.this$0.mBrushMenuControl;
                            colorRecentViewModel2.updateColorRecentViewModel(brushMenuControl6 != null ? brushMenuControl6.getRecentPalette() : null);
                        }
                        break;
                    }
                    break;
            }
        }
    }
}
