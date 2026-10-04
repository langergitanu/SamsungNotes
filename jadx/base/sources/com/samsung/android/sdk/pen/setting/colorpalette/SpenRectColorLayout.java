package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\bJ(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\fH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenRectColorLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorBaseLayout;", "context", "Landroid/content/Context;", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Z)V", "layoutID", "", "(Landroid/content/Context;Ljava/util/List;ZI)V", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV2;", "mSelectorDegree", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setPaletteList", "palettes", "setSelectorDegree", "degree", "setFlipperEnabled", "enabled", "construct", "recentColor", "layoutId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRectColorLayout extends SpenColorBaseLayout {

    @NotNull
    private static final String TAG = "SpenRectColorLayout";
    private SpenPaletteViewV2 mPaletteView;
    private int mSelectorDegree;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectColorLayout(@NotNull Context context, @Nullable List<SpenHSVColor> list, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, list, C7932R.layout.setting_pen_color_layout_v60);
    }

    private final void construct(Context context, List<SpenHSVColor> recentColor, int layoutId) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        this.mSelectorDegree = 0;
        SpenPaletteViewV2 spenPaletteViewV2 = (SpenPaletteViewV2) findViewById(C7932R.id.pen_palette_view);
        this.mPaletteView = spenPaletteViewV2;
        if (spenPaletteViewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV2 = null;
        }
        initView(context, spenPaletteViewV2, 8);
        if (recentColor != null) {
            setRecentColor(recentColor);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout
    public void close() {
        SpenPaletteViewV2 spenPaletteViewV2 = this.mPaletteView;
        if (spenPaletteViewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV2 = null;
        }
        spenPaletteViewV2.close();
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setColorTheme(int theme) {
        super.setColorTheme(theme);
    }

    public final void setFlipperEnabled(boolean enabled) {
        SpenPaletteViewV2 spenPaletteViewV2 = this.mPaletteView;
        if (spenPaletteViewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV2 = null;
        }
        spenPaletteViewV2.setFlipperEnabled(enabled);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public boolean setPaletteList(@NotNull List<Integer> palettes) {
        int i;
        Intrinsics.checkNotNullParameter(palettes, "palettes");
        boolean paletteList = super.setPaletteList(palettes);
        return (!paletteList || (i = this.mSelectorDegree) == 0) ? paletteList : setSelectorDegree(i);
    }

    public final boolean setSelectorDegree(int degree) {
        SpenPaletteViewV2 spenPaletteViewV2 = this.mPaletteView;
        if (spenPaletteViewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV2 = null;
        }
        if (!spenPaletteViewV2.setSelectorDegree(degree)) {
            return false;
        }
        this.mSelectorDegree = degree;
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectColorLayout(@NotNull Context context, @Nullable List<SpenHSVColor> list, boolean z, int i) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, list, i);
    }
}
