package com.samsung.android.support.senl.addons.brush.model.color;

import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorRecentModel;", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;", "page", "", "colorSets", "", "hsvColorSets", "", "", "nameSets", "", "positionSets", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", "<init>", "(I[I[[F[Ljava/lang/String;[ILcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;)V", "mColorModelInjector", "getColorModel", "Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel;", "index", "getColorSize", "push", "", "color", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "updateSelectPosition", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorRecentModel extends ColorPaletteModel {
    public static final int OBSV_PROPERTY_RECENT_PUSHED = 20100;
    private static final int RECENT_LENGTH = 9;

    @Nullable
    private IColorModelInjector mColorModelInjector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorRecentModel(int i, @Nullable int[] iArr, @Nullable float[][] fArr, @Nullable String[] strArr, @Nullable int[] iArr2, @NotNull IColorModelInjector injector) {
        super(i, iArr, fArr, strArr, iArr2);
        Intrinsics.checkNotNullParameter(injector, "injector");
        this.mColorModelInjector = injector;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel
    @Nullable
    public IMenuColorModel getColorModel(int index) {
        if (index == 8) {
            index = 4;
        } else if (index > 3) {
            index++;
        }
        return super.getColorModel(index);
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel
    public int getColorSize() {
        return 9;
    }

    public final void push(@NotNull IExtendedColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        int colorSize = getColorSize();
        MenuColorModel menuColorModel = null;
        int i = -1;
        for (int i2 = 0; i2 < colorSize; i2++) {
            MenuColorModel menuColorModel2 = getMColorTableSet().get(i2);
            menuColorModel2.select(false);
            if (menuColorModel2.isRgbSame(color)) {
                i = i2;
                menuColorModel = menuColorModel2;
            }
        }
        if (menuColorModel == null) {
            i = colorSize - 1;
            menuColorModel = getMColorTableSet().get(i);
        }
        if (i != 0) {
            getMColorTableSet().remove(menuColorModel);
            menuColorModel.setColor(color.getMColor() | (-16777216), color.getMHSV());
            int mPosition = (color.getMPosition() & (-1048576)) == 4194304 ? 2097151 : (color.getMPosition() & 255) | (color.getMPosition() & 1048320) | 1048576;
            menuColorModel.setPosition(mPosition);
            menuColorModel.setEnabled(true);
            IColorModelInjector iColorModelInjector = this.mColorModelInjector;
            Intrinsics.checkNotNull(iColorModelInjector);
            menuColorModel.setName(String.valueOf(iColorModelInjector.getColorName(menuColorModel.getMColor(), ((mPosition & 1048320) >> 8) & 4095, mPosition & 255)));
            getMColorTableSet().add(0, menuColorModel);
            notifyChanged(20100);
            ColorInfoManager.INSTANCE.getInstance().saveRecentColor(getMColorTableSet());
        }
    }

    public final void updateSelectPosition(@NotNull IExtendedColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        int colorIndex = getColorIndex(color);
        if (colorIndex < 0 || colorIndex >= getMColorTableSet().size()) {
            return;
        }
        setMSelectedIndex(-1);
        getMColorTableSet().get(colorIndex).select(true);
    }
}
