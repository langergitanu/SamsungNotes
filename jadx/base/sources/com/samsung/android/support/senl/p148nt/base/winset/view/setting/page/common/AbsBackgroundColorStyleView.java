package com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 /2\u00020\u0001:\u0001/B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u001cJ\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H&J\b\u0010%\u001a\u00020&H&J\b\u0010'\u001a\u00020\u0007H&J\b\u0010(\u001a\u00020\u0007H&J\b\u0010)\u001a\u00020\u0007H&J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020\u001cH&J\b\u0010-\u001a\u00020.H&R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsBackgroundColorStyleView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mPalette", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator;", "getMPalette", "()Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator;", "setMPalette", "(Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator;)V", "mInvertSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "getMInvertSwitch", "()Landroidx/appcompat/widget/SwitchCompat;", "setMInvertSwitch", "(Landroidx/appcompat/widget/SwitchCompat;)V", "mCurrentColor", "mCurrentPaletteId", "mCurrentColorIndex", "initialize", "", "initSelectedColor", "updateSelectedColor", "newColor", "updateDefaultColorLayout", "setSelectedColor", "paletteId", "colorIndex", "getLayoutResource", "getPaletteItemActionListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator$OnItemActionListener;", "getCurrentColor", "getPaletteItemWidth", "getPaletteItemHeight", "getPaletteItemScale", "", "initInvertSwitch", "isDefaultBackgroundColorInverted", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBackgroundColorStyleView extends FrameLayout {

    @NotNull
    private static final String TAG = "AbsBackgroundColorStyleView";
    private int mCurrentColor;
    private int mCurrentColorIndex;
    private int mCurrentPaletteId;

    @Nullable
    private SwitchCompat mInvertSwitch;

    @Nullable
    private PaletteCreator mPalette;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBackgroundColorStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize(context);
    }

    public abstract int getCurrentColor();

    public abstract int getLayoutResource();

    @Nullable
    public final SwitchCompat getMInvertSwitch() {
        return this.mInvertSwitch;
    }

    @Nullable
    public final PaletteCreator getMPalette() {
        return this.mPalette;
    }

    @NotNull
    public abstract PaletteCreator.OnItemActionListener getPaletteItemActionListener();

    public abstract int getPaletteItemHeight();

    public abstract float getPaletteItemScale();

    public abstract int getPaletteItemWidth();

    public abstract void initInvertSwitch();

    public final void initSelectedColor() {
        PaletteCreator paletteCreator = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator);
        int size = paletteCreator.getColorPaletteData().size();
        for (int i = 0; i < size; i++) {
            PaletteCreator paletteCreator2 = this.mPalette;
            Intrinsics.checkNotNull(paletteCreator2);
            SpenColorPaletteData spenColorPaletteData = paletteCreator2.getColorPaletteData().get(i);
            int length = spenColorPaletteData.values.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (spenColorPaletteData.values[i2] == this.mCurrentColor) {
                    PaletteCreator paletteCreator3 = this.mPalette;
                    Intrinsics.checkNotNull(paletteCreator3);
                    paletteCreator3.getPaletteContainerViewList().get(i).updatePaletteItem(i2, true, false);
                    this.mCurrentPaletteId = i;
                    this.mCurrentColorIndex = i2;
                    return;
                }
            }
        }
        AbstractC4539a.m3212v(this.mCurrentColor, "initSelectedColor# if it don't find the color position. color : ", TAG);
        PaletteCreator paletteCreator4 = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator4);
        paletteCreator4.getPaletteContainerViewList().get(0).updatePaletteItem(0, true, false);
        this.mCurrentPaletteId = 0;
        this.mCurrentColorIndex = 0;
    }

    public void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(getLayoutResource(), (ViewGroup) this, true);
        this.mPalette = new PaletteCreator(context, getPaletteItemActionListener());
        this.mCurrentColor = getCurrentColor();
        PaletteCreator paletteCreator = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator);
        paletteCreator.create(getPaletteItemWidth(), getPaletteItemHeight(), getPaletteItemScale(), isDefaultBackgroundColorInverted());
    }

    public abstract boolean isDefaultBackgroundColorInverted();

    public final void setMInvertSwitch(@Nullable SwitchCompat switchCompat) {
        this.mInvertSwitch = switchCompat;
    }

    public final void setMPalette(@Nullable PaletteCreator paletteCreator) {
        this.mPalette = paletteCreator;
    }

    public void setSelectedColor(int paletteId, int colorIndex) {
        Logger.m8702i(TAG, "setSelectedColor# paletteIndex=" + paletteId + " index=" + colorIndex);
        int i = this.mCurrentPaletteId;
        if (i >= 0 && (i != paletteId || this.mCurrentColorIndex != colorIndex)) {
            PaletteCreator paletteCreator = this.mPalette;
            Intrinsics.checkNotNull(paletteCreator);
            List<PaletteContainerView> paletteContainerViewList = paletteCreator.getPaletteContainerViewList();
            Intrinsics.checkNotNull(paletteContainerViewList);
            paletteContainerViewList.get(this.mCurrentPaletteId).updatePaletteItem(this.mCurrentColorIndex, false, true);
        }
        this.mCurrentPaletteId = paletteId;
        this.mCurrentColorIndex = colorIndex;
        PaletteCreator paletteCreator2 = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator2);
        List<SpenColorPaletteData> colorPaletteData = paletteCreator2.getColorPaletteData();
        Intrinsics.checkNotNull(colorPaletteData);
        if (colorPaletteData.size() > paletteId) {
            PaletteCreator paletteCreator3 = this.mPalette;
            Intrinsics.checkNotNull(paletteCreator3);
            List<SpenColorPaletteData> colorPaletteData2 = paletteCreator3.getColorPaletteData();
            Intrinsics.checkNotNull(colorPaletteData2);
            int[] iArr = colorPaletteData2.get(paletteId).values;
            if (iArr.length > colorIndex) {
                this.mCurrentColor = iArr[colorIndex];
            }
        }
        PaletteCreator paletteCreator4 = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator4);
        List<PaletteContainerView> paletteContainerViewList2 = paletteCreator4.getPaletteContainerViewList();
        Intrinsics.checkNotNull(paletteContainerViewList2);
        paletteContainerViewList2.get(paletteId).updatePaletteItem(colorIndex, true, true);
    }

    public final void updateDefaultColorLayout() {
        PaletteCreator paletteCreator = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator);
        paletteCreator.updateDefaultColorLayout(isDefaultBackgroundColorInverted());
    }

    public final void updateSelectedColor(int newColor) {
        if (this.mCurrentColor == newColor) {
            return;
        }
        this.mCurrentColor = newColor;
        PaletteCreator paletteCreator = this.mPalette;
        Intrinsics.checkNotNull(paletteCreator);
        int size = paletteCreator.getColorPaletteData().size();
        for (int i = 0; i < size; i++) {
            PaletteCreator paletteCreator2 = this.mPalette;
            Intrinsics.checkNotNull(paletteCreator2);
            SpenColorPaletteData spenColorPaletteData = paletteCreator2.getColorPaletteData().get(i);
            int length = spenColorPaletteData.values.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (spenColorPaletteData.values[i2] == this.mCurrentColor) {
                    PaletteCreator paletteCreator3 = this.mPalette;
                    Intrinsics.checkNotNull(paletteCreator3);
                    paletteCreator3.getPaletteContainerViewList().get(i).updatePaletteItem(i2, true, true);
                    this.mCurrentPaletteId = i;
                    this.mCurrentColorIndex = i2;
                } else {
                    PaletteCreator paletteCreator4 = this.mPalette;
                    Intrinsics.checkNotNull(paletteCreator4);
                    paletteCreator4.getPaletteContainerViewList().get(i).updatePaletteItem(i2, false, true);
                }
            }
        }
        AbstractC4539a.m3212v(this.mCurrentColor, "updateSelectedColor# if it don't find the color position. color : ", TAG);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBackgroundColorStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBackgroundColorStyleView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize(context);
    }
}
