package com.samsung.android.sdk.pen.setting;

import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushLayoutInfo;", "", "<init>", "()V", "style", "", "penViewType", "isOpened", "", "moveable", "penWidthRatio", "", "penHeightRatio", "penAlign", "spaceRatio", "colorWidthRatio", "colorHeightRatio", "colorAlign", "penResourceList", "", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushLayoutInfo {
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_END = 1;
    public static final int ALIGN_START = 2;
    public static final int ALIGN_TOP = 3;
    public static final int PEN_VIEW_TYPE_LIST = 2;
    public static final int PEN_VIEW_TYPE_OPEN_CLOSE = 1;
    public static final int STYLE_PACKED = 2;
    public static final int STYLE_SPREAD = 1;

    @JvmField
    public int colorAlign;

    @JvmField
    public float colorHeightRatio;

    @JvmField
    public float colorWidthRatio;

    @JvmField
    public boolean isOpened;

    @JvmField
    public boolean moveable;

    @JvmField
    public int penAlign;

    @JvmField
    public float penHeightRatio;

    @JvmField
    @Nullable
    public List<SpenSettingPenResource> penResourceList;

    @JvmField
    public int penViewType;

    @JvmField
    public float penWidthRatio;

    @JvmField
    public float spaceRatio;

    @JvmField
    public int style;
}
