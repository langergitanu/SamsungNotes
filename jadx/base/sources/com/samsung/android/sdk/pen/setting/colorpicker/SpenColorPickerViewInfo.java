package com.samsung.android.sdk.pen.setting.colorpicker;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerViewInfo;)V", "modeType", "", "layoutId", "itemLayoutId", "gradientCursorSizeDimen", "gradientCursorOutlineDimen", "gradientSelectorRadiusDimen", "gradientHeightDimen", "swatchTopMarginDimen", "swatchStartMarginDimen", "swatchEndMarginDimen", "swatchBottomMarginDimen", "gradientModeBtnSize", "gradientModeBtnStartMargin", "swatchModeBtnSize", "swatchModeBtnStartMargin", "colorDisplayRadius", "eyedropperBgResourceId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPickerViewInfo {
    public static final int MODE_TYPE_BUTTON = 2;
    public static final int MODE_TYPE_NONE = 0;
    public static final int MODE_TYPE_TAB = 1;

    @JvmField
    public int colorDisplayRadius;

    @JvmField
    public int eyedropperBgResourceId;

    @JvmField
    public int gradientCursorOutlineDimen;

    @JvmField
    public int gradientCursorSizeDimen;

    @JvmField
    public int gradientHeightDimen;

    @JvmField
    public int gradientModeBtnSize;

    @JvmField
    public int gradientModeBtnStartMargin;

    @JvmField
    public int gradientSelectorRadiusDimen;

    @JvmField
    public int itemLayoutId;

    @JvmField
    public int layoutId;

    @JvmField
    public int modeType;

    @JvmField
    public int swatchBottomMarginDimen;

    @JvmField
    public int swatchEndMarginDimen;

    @JvmField
    public int swatchModeBtnSize;

    @JvmField
    public int swatchModeBtnStartMargin;

    @JvmField
    public int swatchStartMarginDimen;

    @JvmField
    public int swatchTopMarginDimen;

    public SpenColorPickerViewInfo() {
        this.modeType = 0;
    }

    public SpenColorPickerViewInfo(@NotNull SpenColorPickerViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.layoutId = info.layoutId;
        this.itemLayoutId = info.itemLayoutId;
        this.gradientCursorSizeDimen = info.gradientCursorSizeDimen;
        this.gradientCursorOutlineDimen = info.gradientCursorOutlineDimen;
        this.gradientSelectorRadiusDimen = info.gradientSelectorRadiusDimen;
        this.gradientHeightDimen = info.gradientHeightDimen;
        this.swatchTopMarginDimen = info.swatchTopMarginDimen;
        this.swatchStartMarginDimen = info.swatchStartMarginDimen;
        this.swatchEndMarginDimen = info.swatchEndMarginDimen;
        this.swatchBottomMarginDimen = info.swatchBottomMarginDimen;
        this.gradientModeBtnSize = info.gradientModeBtnSize;
        this.gradientModeBtnStartMargin = info.gradientModeBtnStartMargin;
        this.swatchModeBtnSize = info.swatchModeBtnSize;
        this.swatchModeBtnStartMargin = info.swatchModeBtnStartMargin;
        this.colorDisplayRadius = info.colorDisplayRadius;
        this.modeType = info.modeType;
        this.eyedropperBgResourceId = info.eyedropperBgResourceId;
    }
}
