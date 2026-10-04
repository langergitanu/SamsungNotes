package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig;
import com.samsung.android.spen.C7932R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\bH\u0016J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedPaletteConfig;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteConfig;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mColorPalette", "", "", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "mRecentControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl;", "mIsReverseMode", "", "close", "", "initTable", "palette", "recentControl", "getPickerButtonIdx", "getSettingButtonIdx", "getColorIdxList", "setRecentIndicatorSize", "size", "setReverseMode", "enable", "initRecentPalette", "pageIndex", "initDefinedPalette", "paletteData", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "setPaletteVisibleColor", "getButtonType", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteConfig$ButtonType;", "childAt", "hasPickerButton", "applyPickerColor", "drawable", "Landroid/graphics/drawable/Drawable;", "color", "isPickerButton", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenExtendedPaletteConfig implements SpenPaletteConfig {

    @NotNull
    private List<Integer> mColorPalette = new ArrayList();
    private boolean mIsReverseMode;

    @Nullable
    private SpenPaletteViewInterface mPaletteView;

    @Nullable
    private SpenPaletteRecentControl mRecentControl;

    public SpenExtendedPaletteConfig(@Nullable Context context) {
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void close() {
        this.mRecentControl = null;
        this.mPaletteView = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    @NotNull
    public SpenPaletteConfig.ButtonType getButtonType(int pageIndex, int childAt) {
        return SpenPaletteConfig.ButtonType.NONE;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    @NotNull
    public List<Integer> getColorIdxList() {
        return this.mColorPalette;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    /* JADX INFO: renamed from: getPickerButtonIdx */
    public int getMPickerButtonIdx() {
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    /* JADX INFO: renamed from: getSettingButtonIdx */
    public int getMSettingButtonIdx() {
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public boolean hasPickerButton(int pageIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void initDefinedPalette(int pageIndex, @Nullable SpenColorPaletteData paletteData) {
        setPaletteVisibleColor(pageIndex, paletteData);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void initRecentPalette(int pageIndex) {
        SpenPaletteRecentControl spenPaletteRecentControl;
        if (this.mPaletteView == null || pageIndex == -1 || (spenPaletteRecentControl = this.mRecentControl) == null) {
            return;
        }
        spenPaletteRecentControl.initPage(new int[]{0, 1, 2, 3, 4, 5, 6}, C7932R.drawable.note_handwriting_eyedropper_rect_drawable);
        spenPaletteRecentControl.updateColor();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public boolean initTable(@NotNull SpenPaletteViewInterface palette, @Nullable SpenPaletteRecentControl recentControl) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        if (!(palette instanceof SpenPaletteViewV3)) {
            return false;
        }
        this.mPaletteView = palette;
        this.mRecentControl = recentControl;
        this.mColorPalette = ((SpenPaletteViewV3) palette).getSwipeChildIndex();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public boolean isPickerButton(int pageIndex, int childAt) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void setPaletteVisibleColor(int pageIndex, @Nullable SpenColorPaletteData paletteData) {
        float[] fArr = new float[3];
        if (paletteData != null) {
            int length = paletteData.values.length;
            for (int i = 0; i < length; i++) {
                int i2 = !this.mIsReverseMode ? paletteData.values[i] : paletteData.themeValues[i];
                Color.colorToHSV(i2, fArr);
                SpenPaletteColorInfo spenPaletteColorInfo = new SpenPaletteColorInfo();
                spenPaletteColorInfo.setColor(fArr, Color.alpha(i2), paletteData.names[i]);
                SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
                if (spenPaletteViewInterface != null) {
                    spenPaletteViewInterface.setColor(pageIndex, this.mColorPalette.get(i).intValue(), spenPaletteColorInfo);
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void setReverseMode(boolean enable) {
        this.mIsReverseMode = enable;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void setRecentIndicatorSize(int size) {
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig
    public void applyPickerColor(@Nullable Drawable drawable, int color) {
    }
}
