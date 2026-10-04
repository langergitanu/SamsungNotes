package com.samsung.android.support.senl.addons.brush.model.color;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import com.samsung.android.support.senl.addons.brush.model.color.MenuColorModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000256B=\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rBG\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\u0011J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010 J\u0006\u0010.\u001a\u00020$J\u001e\u0010/\u001a\u0002002\u0006\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u00042\u0006\u00101\u001a\u000200J\u000e\u00102\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\u000e\u00104\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorPaletteModel;", "page", "", "colorSets", "", "nameSets", "", "", "mode", "selectPage", "<init>", "(I[I[Ljava/lang/String;II)V", "hsvColorSets", "", "positionSets", "(I[I[[F[Ljava/lang/String;[I)V", "mColorTableSet", "", "Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel;", "getMColorTableSet", "()Ljava/util/List;", "setMColorTableSet", "(Ljava/util/List;)V", "mPage", "mSelectedIndex", "getMSelectedIndex", "()I", "setMSelectedIndex", "(I)V", "mSelectionListener", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel$OnSelectedListener;", "mColorSelectionListener", "Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel$OnSelectionListener;", "onSelected", "", "position", "color", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "getColorModel", "Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel;", "index", "getColorSize", "setSelectionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "releaseSelectedColor", "selectColorPosition", "", "isSkip", "updateSelectedIndex", "getColorPosition", "getColorIndex", "Companion", "OnSelectedListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorPaletteModel extends AbsBaseModel implements IColorPaletteModel {
    public static final int PALETTE_LENGTH = 8;
    private int mPage;

    @Nullable
    private OnSelectedListener mSelectionListener;

    @NotNull
    private List<MenuColorModel> mColorTableSet = new ArrayList();
    private int mSelectedIndex = -1;

    @NotNull
    private final MenuColorModel.OnSelectionListener mColorSelectionListener = new MenuColorModel.OnSelectionListener() { // from class: com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel$mColorSelectionListener$1
        @Override // com.samsung.android.support.senl.addons.brush.model.color.MenuColorModel.OnSelectionListener
        public void onSelected(int index, IExtendedColor color) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.this$0.onSelected(index, color);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel$OnSelectedListener;", "", "onSelected", "", "page", "", "position", "color", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSelectedListener {
        void onSelected(int page, int position, @Nullable IExtendedColor color);
    }

    public ColorPaletteModel(int i, @Nullable int[] iArr, @Nullable String[] strArr, int i2, int i4) {
        int i5;
        boolean z;
        String str;
        int i6 = ((i2 << 20) & (-1048576)) | ((i4 << 8) & 1048320);
        int length = iArr != null ? iArr.length : 0;
        int length2 = strArr != null ? strArr.length : 0;
        this.mPage = i;
        int colorSize = getColorSize();
        for (int i7 = 0; i7 < colorSize; i7++) {
            if (i7 < length) {
                Intrinsics.checkNotNull(iArr);
                i5 = iArr[i7];
                z = true;
            } else {
                i5 = 0;
                z = false;
            }
            if (i7 < length2) {
                Intrinsics.checkNotNull(strArr);
                str = strArr[i7];
            } else {
                str = null;
            }
            MenuColorModel menuColorModel = new MenuColorModel(i5, str, (i7 & 255) | i6);
            menuColorModel.setEnabled(z);
            menuColorModel.setSelectionListener(this.mColorSelectionListener);
            this.mColorTableSet.add(menuColorModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelected(int position, IExtendedColor color) {
        if (((-1048576) & position) == 1048576) {
            int colorIndex = getColorIndex(color);
            if (this.mSelectedIndex != colorIndex) {
                releaseSelectedColor();
                this.mSelectedIndex = colorIndex;
            }
        } else {
            int i = position & 255;
            if (this.mSelectedIndex != i) {
                releaseSelectedColor();
                this.mSelectedIndex = i;
            }
        }
        OnSelectedListener onSelectedListener = this.mSelectionListener;
        if (onSelectedListener != null) {
            onSelectedListener.onSelected(this.mPage, position, color);
        }
    }

    public final int getColorIndex(@NotNull IExtendedColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        int size = this.mColorTableSet.size();
        for (int i = 0; i < size; i++) {
            if (this.mColorTableSet.get(i).getMIsEnabled() && this.mColorTableSet.get(i).isRgbSame(color)) {
                return i;
            }
        }
        return -1;
    }

    @Nullable
    public IMenuColorModel getColorModel(int index) {
        return this.mColorTableSet.get(index);
    }

    public final int getColorPosition(int color) {
        for (MenuColorModel menuColorModel : this.mColorTableSet) {
            if (menuColorModel.getMIsEnabled() && (menuColorModel.getMColor() | (-16777216)) == ((-16777216) | color)) {
                return menuColorModel.getMPosition();
            }
        }
        return 4194304;
    }

    public int getColorSize() {
        return 8;
    }

    @NotNull
    public final List<MenuColorModel> getMColorTableSet() {
        return this.mColorTableSet;
    }

    public final int getMSelectedIndex() {
        return this.mSelectedIndex;
    }

    public final void releaseSelectedColor() {
        int i = this.mSelectedIndex;
        if (i >= 0 && i < this.mColorTableSet.size()) {
            this.mColorTableSet.get(this.mSelectedIndex).select(false);
        }
        this.mSelectedIndex = -1;
    }

    public final boolean selectColorPosition(@NotNull IExtendedColor color, int position, boolean isSkip) {
        Intrinsics.checkNotNullParameter(color, "color");
        if (((-1048576) & position) == 4194304) {
            return false;
        }
        int size = this.mColorTableSet.size();
        for (int i = 0; i < size; i++) {
            if (this.mColorTableSet.get(i).getMIsEnabled() && this.mColorTableSet.get(i).isRgbSame(color) && (isSkip || this.mColorTableSet.get(i).getMPosition() == position)) {
                this.mColorTableSet.get(i).select(true);
                updateSelectedIndex(i);
                return true;
            }
        }
        return false;
    }

    public final void setMColorTableSet(@NotNull List<MenuColorModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mColorTableSet = list;
    }

    public final void setMSelectedIndex(int i) {
        this.mSelectedIndex = i;
    }

    public final void setSelectionListener(@Nullable OnSelectedListener listener) {
        this.mSelectionListener = listener;
    }

    public final void updateSelectedIndex(int index) {
        this.mSelectedIndex = index;
    }

    public ColorPaletteModel(int i, @Nullable int[] iArr, @Nullable float[][] fArr, @Nullable String[] strArr, @Nullable int[] iArr2) {
        int i2;
        String str;
        int i4;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        this.mPage = i;
        int length = iArr != null ? iArr.length : 0;
        int length2 = strArr != null ? strArr.length : 0;
        int length3 = iArr2 != null ? iArr2.length : 0;
        int colorSize = getColorSize();
        float[] fArr5 = new float[3];
        for (int i5 = 0; i5 < colorSize; i5++) {
            boolean z = true;
            float f = 0.0f;
            if (i5 < length) {
                Intrinsics.checkNotNull(iArr);
                i2 = iArr[i5];
                fArr5[0] = (fArr == null || (fArr4 = fArr[i5]) == null) ? 0.0f : fArr4[0];
                fArr5[1] = (fArr == null || (fArr3 = fArr[i5]) == null) ? 0.0f : fArr3[1];
                if (fArr != null && (fArr2 = fArr[i5]) != null) {
                    f = fArr2[2];
                }
                fArr5[2] = f;
            } else {
                fArr5[0] = 0.0f;
                fArr5[1] = 0.0f;
                fArr5[2] = 0.0f;
                z = false;
                i2 = 0;
            }
            if (i5 < length2) {
                Intrinsics.checkNotNull(strArr);
                str = strArr[i5];
            } else {
                str = null;
            }
            if (i5 < length3) {
                Intrinsics.checkNotNull(iArr2);
                int i6 = iArr2[i5];
                i4 = (i6 & 255) | 1048576 | (1048320 & i6);
            } else {
                i4 = 2097151;
            }
            MenuColorModel menuColorModel = new MenuColorModel(i2, fArr5, str, i4);
            menuColorModel.setEnabled(z);
            menuColorModel.setSelectionListener(this.mColorSelectionListener);
            this.mColorTableSet.add(menuColorModel);
        }
    }
}
