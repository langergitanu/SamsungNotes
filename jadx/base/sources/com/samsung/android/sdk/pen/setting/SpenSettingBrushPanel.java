package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenExtendedColorLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSetting;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushAttrSettingLayout;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenListLayout;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushUIPolicy;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nB=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u0014\u001a\u00020\u0015J<\u0010!\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushPanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;)V", "penNames", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "mPenLayout", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "mAttrLayout", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSettingLayout;", "mColorLayout", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedColorLayout;", "close", "", "penView", "getPenView", "()Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "colorView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteSetting;", "getColorView", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteSetting;", "attrView", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSetting;", "getAttrView", "()Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushAttrSetting;", "construct", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingBrushPanel extends LinearLayout {

    @NotNull
    private static final String TAG = "SpenSettingBrushPanel";

    @Nullable
    private SpenBrushAttrSettingLayout mAttrLayout;

    @Nullable
    private SpenExtendedColorLayout mColorLayout;

    @Nullable
    private SpenBrushPenLayoutInterface mPenLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingBrushPanel(@NotNull Context context, @NotNull List<Integer> paletteList, @Nullable List<SpenHSVColor> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        construct(context, SpenBrushUIPolicy.INSTANCE.getPenNameList(context), paletteList, list);
    }

    private final void construct(Context context, List<String> penNames, List<Integer> paletteList, List<SpenHSVColor> recentList) {
        setOrientation(1);
        Resources resources = context.getResources();
        SpenBrushPenListLayout spenBrushPenListLayout = new SpenBrushPenListLayout(context);
        this.mPenLayout = spenBrushPenListLayout;
        spenBrushPenListLayout.setPenLayoutRatio(0.0f, 0.0f);
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface = this.mPenLayout;
        if (spenBrushPenLayoutInterface != null) {
            spenBrushPenLayoutInterface.setPenList(penNames);
        }
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_pen_panel_height));
        ((LinearLayout.LayoutParams) layoutParams).topMargin = resources.getDimensionPixelSize(C7932R.dimen.drawing_brush_pen_panel_margin_top);
        addView((SpenBrushPenListLayout) getMPenLayout(), layoutParams);
        View view = new View(context);
        view.setBackgroundColor(SpenSettingUtil.getColor(context, C7932R.color.setting_handwriting_pen_divider));
        addView(view, new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_divider_height)));
        this.mAttrLayout = new SpenBrushAttrSettingLayout(context, true);
        LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams2).gravity = 17;
        addView(this.mAttrLayout, layoutParams2);
        SpenExtendedColorLayout spenExtendedColorLayout = new SpenExtendedColorLayout(context, null, false);
        this.mColorLayout = spenExtendedColorLayout;
        spenExtendedColorLayout.setPaletteList(paletteList);
        SpenExtendedColorLayout spenExtendedColorLayout2 = this.mColorLayout;
        if (spenExtendedColorLayout2 != null) {
            spenExtendedColorLayout2.setRecentColor(recentList);
        }
        LinearLayoutCompat.LayoutParams layoutParams3 = new LinearLayoutCompat.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams3).gravity = 17;
        addView(this.mColorLayout, layoutParams3);
    }

    public final void close() {
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface = this.mPenLayout;
        if (spenBrushPenLayoutInterface != null) {
            spenBrushPenLayoutInterface.close();
        }
        this.mPenLayout = null;
        SpenBrushAttrSettingLayout spenBrushAttrSettingLayout = this.mAttrLayout;
        if (spenBrushAttrSettingLayout != null) {
            spenBrushAttrSettingLayout.close();
        }
        this.mAttrLayout = null;
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout != null) {
            spenExtendedColorLayout.close();
        }
        this.mColorLayout = null;
    }

    @Nullable
    public final SpenBrushAttrSetting getAttrView() {
        return this.mAttrLayout;
    }

    @Nullable
    public final SpenPaletteSetting getColorView() {
        return this.mColorLayout;
    }

    @Nullable
    /* JADX INFO: renamed from: getPenView, reason: from getter */
    public final SpenBrushPenLayoutInterface getMPenLayout() {
        return this.mPenLayout;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingBrushPanel(@NotNull Context context, @NotNull List<String> penNames, @NotNull List<Integer> paletteList, @Nullable List<SpenHSVColor> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penNames, "penNames");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        construct(context, penNames, paletteList, list);
    }
}
