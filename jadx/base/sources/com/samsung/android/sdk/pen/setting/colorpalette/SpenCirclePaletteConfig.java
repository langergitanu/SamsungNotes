package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilImage;
import com.samsung.android.spen.C7932R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u001a\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0019H\u0016J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u001a\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenCirclePaletteConfig;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteConfig;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPickerButtonIdx", "", "mSettingButtonIdx", "mRecentIndicatorSize", "mContext", "mColorPalette", "", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "mRecentIndexList", "", "mRecentPageIndex", "mRecentControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl;", "mIndicatorUnselectedColor", "mIndicatorSelectedColor", "close", "", "initTable", "", "palette", "recentControl", "initRecentPalette", "pageIndex", "initDefinedPalette", "paletteData", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "getPickerButtonIdx", "getSettingButtonIdx", "getColorIdxList", "setRecentIndicatorSize", "size", "setReverseMode", "enable", "setPaletteVisibleColor", "getButtonType", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteConfig$ButtonType;", "childAt", "isPickerButton", "hasPickerButton", "applyPickerColor", "drawable", "Landroid/graphics/drawable/Drawable;", "color", "adjustTableIndex", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCirclePaletteConfig implements SpenPaletteConfig {

    @NotNull
    private List<Integer> mColorPalette;

    @NotNull
    private Context mContext;
    private final int mIndicatorSelectedColor;
    private final int mIndicatorUnselectedColor;

    @Nullable
    private SpenPaletteViewInterface mPaletteView;
    private int mPickerButtonIdx;

    @Nullable
    private SpenPaletteRecentControl mRecentControl;

    @NotNull
    private int[] mRecentIndexList;
    private int mRecentIndicatorSize;
    private int mRecentPageIndex;
    private int mSettingButtonIdx;

    public SpenCirclePaletteConfig(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRecentIndexList = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.mContext = context;
        this.mRecentIndicatorSize = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_palette_recent_indicator_size);
        this.mRecentPageIndex = -1;
        this.mColorPalette = new ArrayList();
        this.mRecentControl = null;
        this.mIndicatorUnselectedColor = SpenSettingUtil.getColor(context, C7932R.color.setting_palette_indicator_unselected_color);
        this.mIndicatorSelectedColor = SpenSettingUtil.getColor(context, C7932R.color.setting_palette_indicator_selected_color);
    }

    private final void adjustTableIndex() {
        this.mColorPalette = CollectionsKt.emptyList();
        this.mColorPalette = CollectionsKt.listOf(Arrays.copyOf(new Integer[]{8, 6, 4, 2, 9, 7, 5, 3}, 8));
        this.mRecentIndexList = (int[]) new int[]{8, 6, 4, 2, 0, 9, 7, 5, 3, 1}.clone();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void close() {
        this.mColorPalette = CollectionsKt.emptyList();
        this.mRecentControl = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    @NotNull
    public SpenPaletteConfig.ButtonType getButtonType(int pageIndex, int childAt) {
        if (pageIndex < 0) {
            return SpenPaletteConfig.ButtonType.NONE;
        }
        if (this.mRecentPageIndex != pageIndex) {
            return childAt == getMPickerButtonIdx() ? SpenPaletteConfig.ButtonType.PICKER : childAt == getMSettingButtonIdx() ? SpenPaletteConfig.ButtonType.SETTING : SpenPaletteConfig.ButtonType.NONE;
        }
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        return (spenPaletteRecentControl == null || !spenPaletteRecentControl.isEyedropperButton(childAt)) ? SpenPaletteConfig.ButtonType.NONE : SpenPaletteConfig.ButtonType.EYEDROPPER;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    @NotNull
    public List<Integer> getColorIdxList() {
        return this.mColorPalette;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    /* JADX INFO: renamed from: getPickerButtonIdx, reason: from getter */
    public int getMPickerButtonIdx() {
        return this.mPickerButtonIdx;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    /* JADX INFO: renamed from: getSettingButtonIdx, reason: from getter */
    public int getMSettingButtonIdx() {
        return this.mSettingButtonIdx;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public boolean hasPickerButton(int pageIndex) {
        return pageIndex >= 0 && pageIndex != this.mRecentPageIndex;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void initDefinedPalette(int pageIndex, @Nullable SpenColorPaletteData paletteData) {
        setPaletteVisibleColor(pageIndex, paletteData);
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            spenPaletteViewInterface.setResource(pageIndex, this.mPickerButtonIdx, C7932R.drawable.note_handwriting_setting_color_01, C7932R.string.pen_string_color_picker);
        }
        SpenPaletteViewInterface spenPaletteViewInterface2 = this.mPaletteView;
        if (spenPaletteViewInterface2 != null) {
            spenPaletteViewInterface2.setResource(pageIndex, this.mSettingButtonIdx, C7932R.drawable.note_handwriting_setting_color_02, C7932R.string.pen_string_select_color_set_to_show);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void initRecentPalette(int pageIndex) {
        SpenPaletteRecentControl spenPaletteRecentControl;
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface == null || (spenPaletteRecentControl = this.mRecentControl) == null) {
            return;
        }
        spenPaletteRecentControl.initPage(this.mRecentIndexList, C7932R.drawable.color_circle_eyedropper);
        spenPaletteRecentControl.updateColor();
        spenPaletteViewInterface.setIndicator(pageIndex, this.mRecentIndicatorSize, SpenSettingUtilImage.getVectorDrawableSelected(this.mContext, C7932R.drawable.note_ic_recent_selected, this.mIndicatorUnselectedColor, this.mIndicatorSelectedColor), this.mContext.getResources().getString(C7932R.string.pen_string_palette_recent));
        this.mRecentPageIndex = pageIndex;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public boolean initTable(@NotNull SpenPaletteViewInterface palette, @Nullable SpenPaletteRecentControl recentControl) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        this.mPaletteView = palette;
        this.mRecentControl = recentControl;
        this.mColorPalette = palette.getSwipeChildIndex();
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        List<Integer> fixedChildIndex = spenPaletteViewInterface != null ? spenPaletteViewInterface.getFixedChildIndex() : null;
        if (fixedChildIndex != null) {
            if (fixedChildIndex.contains(0)) {
                adjustTableIndex();
            }
            this.mPickerButtonIdx = fixedChildIndex.get(0).intValue();
            this.mSettingButtonIdx = fixedChildIndex.get(1).intValue();
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public boolean isPickerButton(int pageIndex, int childAt) {
        return hasPickerButton(pageIndex) && getMPickerButtonIdx() == childAt;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void setPaletteVisibleColor(int pageIndex, @Nullable SpenColorPaletteData paletteData) {
        float[] fArr = new float[3];
        if (paletteData != null) {
            int length = paletteData.values.length;
            for (int i = 0; i < length; i++) {
                Color.colorToHSV(paletteData.values[i], fArr);
                SpenPaletteColorInfo spenPaletteColorInfo = new SpenPaletteColorInfo();
                spenPaletteColorInfo.setColor(fArr, Color.alpha(paletteData.values[i]), paletteData.names[i]);
                SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
                if (spenPaletteViewInterface != null) {
                    spenPaletteViewInterface.setColor(pageIndex, this.mColorPalette.get(i).intValue(), spenPaletteColorInfo);
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void setRecentIndicatorSize(int size) {
        this.mRecentIndicatorSize = size;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void setReverseMode(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void applyPickerColor(@Nullable Drawable drawable, int color) {
    }
}
