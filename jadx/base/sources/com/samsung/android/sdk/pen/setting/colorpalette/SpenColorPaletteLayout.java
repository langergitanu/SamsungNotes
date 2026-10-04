package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bJ0\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\fH\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorPaletteLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorBaseLayout;", "context", "Landroid/content/Context;", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Z)V", "layoutID", "", "isCircleShape", "(Landroid/content/Context;Ljava/util/List;ZIZ)V", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV4;", "mRectPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV2;", "mSelectorDegree", "close", "", "setPaletteList", "palettes", "setSelectorDegree", "degree", "setFlipperEnabled", "enabled", "construct", "recentColor", "layoutId", "chipShape", "Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "getDefaultLayout", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPaletteLayout extends SpenColorBaseLayout {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @NotNull
    private static final ColorChipShape DefaultShape = ColorChipShape.CIRCLE;

    @Deprecated
    @NotNull
    public static final String TAG = "SpenColorPaletteLayout";

    @Nullable
    private SpenPaletteViewV4 mPaletteView;

    @Nullable
    private SpenPaletteViewV2 mRectPaletteView;
    private int mSelectorDegree;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorPaletteLayout$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DefaultShape", "Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "getDefaultShape", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorChipShape getDefaultShape() {
            return SpenColorPaletteLayout.DefaultShape;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorChipShape.values().length];
            try {
                iArr[ColorChipShape.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorChipShape.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPaletteLayout(@NotNull Context context, @Nullable List<SpenHSVColor> list, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, list, getDefaultLayout(), DefaultShape);
    }

    private final void construct(Context context, List<SpenHSVColor> recentColor, int layoutId, ColorChipShape chipShape) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        this.mSelectorDegree = 0;
        int i = WhenMappings.$EnumSwitchMapping$0[chipShape.ordinal()];
        if (i == 1) {
            SpenPaletteViewV4 spenPaletteViewV4 = (SpenPaletteViewV4) findViewById(C7932R.id.pen_palette_view);
            this.mPaletteView = spenPaletteViewV4;
            initView(context, spenPaletteViewV4, 8);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            SpenPaletteViewV2 spenPaletteViewV2 = (SpenPaletteViewV2) findViewById(C7932R.id.pen_palette_view);
            this.mRectPaletteView = spenPaletteViewV2;
            initView(context, spenPaletteViewV2, 8);
        }
        if (recentColor != null) {
            setRecentColor(recentColor);
        }
    }

    private final int getDefaultLayout() {
        int i = WhenMappings.$EnumSwitchMapping$0[DefaultShape.ordinal()];
        if (i == 1) {
            return C7932R.layout.setting_pen_color_layout_oneui70_v15;
        }
        if (i == 2) {
            return C7932R.layout.setting_pen_color_layout_v60;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout
    public void close() {
        SpenPaletteViewV4 spenPaletteViewV4 = this.mPaletteView;
        if (spenPaletteViewV4 != null) {
            spenPaletteViewV4.close();
        }
        SpenPaletteViewV2 spenPaletteViewV2 = this.mRectPaletteView;
        if (spenPaletteViewV2 != null) {
            spenPaletteViewV2.close();
        }
        super.close();
    }

    public final void setFlipperEnabled(boolean enabled) {
        SpenPaletteViewV4 spenPaletteViewV4 = this.mPaletteView;
        if (spenPaletteViewV4 != null) {
            spenPaletteViewV4.setFlipperEnabled(enabled);
        }
        SpenPaletteViewV2 spenPaletteViewV2 = this.mRectPaletteView;
        if (spenPaletteViewV2 != null) {
            spenPaletteViewV2.setFlipperEnabled(enabled);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public boolean setPaletteList(@NotNull List<Integer> palettes) {
        int i;
        Intrinsics.checkNotNullParameter(palettes, "palettes");
        boolean paletteList = super.setPaletteList(palettes);
        return (!paletteList || (i = this.mSelectorDegree) == 0) ? paletteList : setSelectorDegree(i);
    }

    public final boolean setSelectorDegree(int degree) {
        SpenPaletteViewV4 spenPaletteViewV4 = this.mPaletteView;
        if (spenPaletteViewV4 != null && spenPaletteViewV4.setSelectorDegree(degree)) {
            this.mSelectorDegree = degree;
            return true;
        }
        SpenPaletteViewV2 spenPaletteViewV2 = this.mRectPaletteView;
        if (spenPaletteViewV2 == null || !spenPaletteViewV2.setSelectorDegree(degree)) {
            return false;
        }
        this.mSelectorDegree = degree;
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorPaletteLayout(@NotNull Context context, @Nullable List<SpenHSVColor> list, boolean z, int i, boolean z2) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, list, i, z2 ? ColorChipShape.CIRCLE : ColorChipShape.RECTANGLE);
    }
}
