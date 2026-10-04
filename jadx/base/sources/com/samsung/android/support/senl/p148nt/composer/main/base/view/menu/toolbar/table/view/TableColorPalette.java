package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0220b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u00012B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000eJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nJ\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J*\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001fH\u0002J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\nJ\u0016\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001fJ\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\nJ\u000e\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u0015J\u0006\u00101\u001a\u00020\u001aR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/view/TableColorPalette;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contract", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/BaseColorPalette$Contract;", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/BaseColorPalette$Contract;)V", "mChild", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/view/TableColorChipView;", "mPaletteData", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "mContract", "mCurrentColor", "mCurrentColorPosition", "initPresetLayout", "", "presetLayout", "Landroid/widget/RelativeLayout;", "initPalette", "needToSelectColor", "", "currentColor", "setDefaultColorInPalette", "initPaletteInfo", "updateColorView", "i", "colorView", "colorId", "hoverString", "", "initSelectedColorByColor", "setSelectedColorPicker", "animation", "setSelectedColor", "childAt", "onColorChangedByPicker", "setPaletteActionListener", "actionListener", "close", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableColorPalette extends LinearLayout {
    public static final int INVALIDATE_POS = -1;
    public static final int PALETTE_SIZE = 8;
    public static final int PICKER_POS = 7;

    @Nullable
    private SpenPaletteViewActionListener mActionListener;

    @NotNull
    private final List<TableColorChipView> mChild;

    @Nullable
    private BaseColorPalette.Contract mContract;
    private int mCurrentColor;
    private int mCurrentColorPosition;

    @NotNull
    private final SpenColorPaletteData mPaletteData;

    public TableColorPalette(@Nullable Context context) {
        super(context);
        this.mChild = new ArrayList();
        this.mPaletteData = new SpenColorPaletteData();
        this.mCurrentColorPosition = -1;
    }

    private final void initPaletteInfo() {
        removeAllViews();
        int[] iArr = {C9086R.id.col1, C9086R.id.col2, C9086R.id.col3, C9086R.id.col4, C9086R.id.col5, C9086R.id.col6, C9086R.id.col7, C9086R.id.col8};
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C9086R.dimen.table_color_palette_chip_width_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C9086R.dimen.table_color_palette_chip_between_margin);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMarginStart(dimensionPixelSize2);
        layoutParams.setMarginEnd(dimensionPixelSize2);
        for (int i = 0; i < 8; i++) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            TableColorChipView tableColorChipView = new TableColorChipView(context);
            SpenColorPaletteData spenColorPaletteData = this.mPaletteData;
            updateColorView(i, tableColorChipView, spenColorPaletteData.values[i], spenColorPaletteData.names[i]);
            tableColorChipView.setId(iArr[i]);
            tableColorChipView.setTag(String.valueOf(i));
            tableColorChipView.setOnClickListener(new ViewOnClickListenerC0220b(this, i, 5));
            ViewCompat.INSTANCE.getInstance().setTooltipText(tableColorChipView);
            addView(tableColorChipView, layoutParams);
            this.mChild.add(tableColorChipView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPaletteInfo$lambda$0(TableColorPalette tableColorPalette, int i, View view) {
        SpenPaletteViewActionListener spenPaletteViewActionListener = tableColorPalette.mActionListener;
        if (spenPaletteViewActionListener != null) {
            spenPaletteViewActionListener.onButtonClick(0, i, true);
        }
    }

    private final void initSelectedColorByColor() {
        int length = this.mPaletteData.values.length;
        for (int i = 0; i < length; i++) {
            if (this.mPaletteData.values[i] == this.mCurrentColor) {
                setSelectedColor(i, false);
                return;
            }
        }
        setSelectedColorPicker(false);
    }

    private final void setDefaultColorInPalette() {
        SpenColorPaletteData spenColorPaletteData = this.mPaletteData;
        spenColorPaletteData.index = 0;
        spenColorPaletteData.nameId = C9086R.array.table_color_set_name;
        spenColorPaletteData.valueId = C9086R.array.table_color_set;
        int[] intArray = getContext().getResources().getIntArray(this.mPaletteData.valueId);
        Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
        spenColorPaletteData.values = intArray;
        SpenColorPaletteData spenColorPaletteData2 = this.mPaletteData;
        int[] intArray2 = getContext().getResources().getIntArray(C9086R.array.table_color_set);
        Intrinsics.checkNotNullExpressionValue(intArray2, "getIntArray(...)");
        spenColorPaletteData2.themeValues = intArray2;
        SpenColorPaletteData spenColorPaletteData3 = this.mPaletteData;
        String[] stringArray = getContext().getResources().getStringArray(C9086R.array.table_color_set_name);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        spenColorPaletteData3.names = stringArray;
        int length = this.mPaletteData.values.length;
        float[] fArr = new float[3];
        for (int i = 0; i < length; i++) {
            Color.colorToHSV(this.mPaletteData.values[i], fArr);
        }
    }

    private final void setSelectedColorPicker(boolean animation) {
        this.mChild.get(7).updateSelectViewResource(this.mCurrentColor);
        setSelectedColor(7, animation);
    }

    private final void updateColorView(int i, TableColorChipView colorView, int colorId, String hoverString) {
        if (i == 0) {
            colorView.setResource(getContext().getDrawable(C9086R.drawable.blank_stroke_dot), 0.5f, hoverString);
        } else if (i != 7) {
            colorView.setColor(colorId, hoverString);
        } else {
            colorView.setResource(getContext().getDrawable(C9086R.drawable.note_handwriting_setting_color_01), hoverString);
            colorView.updateSelectViewResource(this.mCurrentColor);
        }
    }

    public final void close() {
        this.mChild.clear();
    }

    public final void initPalette(boolean needToSelectColor, int currentColor) {
        this.mCurrentColor = currentColor;
        setDefaultColorInPalette();
        initPaletteInfo();
        if (needToSelectColor) {
            initSelectedColorByColor();
        }
    }

    public final void initPresetLayout(@NotNull RelativeLayout presetLayout) {
        Intrinsics.checkNotNullParameter(presetLayout, "presetLayout");
        presetLayout.removeAllViews();
        presetLayout.addView(this);
        presetLayout.setGravity(1);
    }

    public final void onColorChangedByPicker(int currentColor) {
        this.mCurrentColor = currentColor;
        setSelectedColorPicker(true);
    }

    public final void setPaletteActionListener(@NotNull SpenPaletteViewActionListener actionListener) {
        Intrinsics.checkNotNullParameter(actionListener, "actionListener");
        this.mActionListener = actionListener;
    }

    public final void setSelectedColor(int childAt) {
        setSelectedColor(childAt, true);
    }

    public final void setSelectedColor(int childAt, boolean animation) {
        int i = this.mCurrentColorPosition;
        if (i == childAt) {
            return;
        }
        if (i > -1) {
            this.mChild.get(i).setSelected(false, animation);
        }
        this.mChild.get(childAt).setSelected(true, animation);
        this.mCurrentColorPosition = childAt;
        if (childAt < 7) {
            this.mCurrentColor = this.mPaletteData.values[childAt];
        }
        BaseColorPalette.Contract contract = this.mContract;
        if (contract != null) {
            contract.notifyChangedColor(this.mCurrentColor);
        }
    }

    public TableColorPalette(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChild = new ArrayList();
        this.mPaletteData = new SpenColorPaletteData();
        this.mCurrentColorPosition = -1;
    }

    public TableColorPalette(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChild = new ArrayList();
        this.mPaletteData = new SpenColorPaletteData();
        this.mCurrentColorPosition = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableColorPalette(@NotNull Context context, @NotNull BaseColorPalette.Contract contract) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mChild = new ArrayList();
        this.mPaletteData = new SpenColorPaletteData();
        this.mCurrentColorPosition = -1;
        this.mContract = contract;
    }
}
