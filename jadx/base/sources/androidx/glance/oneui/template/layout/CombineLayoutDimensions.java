package androidx.glance.oneui.template.layout;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJP\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\f\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/CombineLayoutDimensions;", "", "()V", "primaryContentResIds", "Landroidx/glance/oneui/template/layout/ImageButtonResIds;", "getPrimaryContentResIds", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/ImageButtonResIds;", "primaryIconSizeResId", "", "hasSecondText", "", "(ZLandroidx/compose/runtime/Composer;I)I", "textPadding", "Landroidx/compose/ui/unit/DpRect;", "currTextType", "Landroidx/glance/oneui/template/TextType;", "prevTextType", "nextTextType", "inSecondaryContent", "hasTertiaryContent", "orientation", "Landroidx/glance/oneui/template/Orientation;", "textPadding-AS5t1TI", "(ILandroidx/glance/oneui/template/TextType;Landroidx/glance/oneui/template/TextType;ZZLandroidx/glance/oneui/template/Orientation;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/unit/DpRect;", "textList", "", "Landroidx/glance/oneui/template/TypedTextData;", "i", "(Ljava/util/List;IZZLandroidx/glance/oneui/template/Orientation;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/unit/DpRect;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutDimensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/CombineLayoutDimensions\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,729:1\n74#2:730\n74#2:731\n74#2:732\n154#3:733\n154#3:734\n154#3:735\n154#3:736\n154#3:737\n154#3:738\n154#3:739\n154#3:740\n154#3:741\n154#3:742\n154#3:743\n154#3:744\n154#3:745\n154#3:746\n154#3:747\n154#3:748\n154#3:749\n154#3:750\n154#3:751\n154#3:752\n154#3:753\n154#3:754\n154#3:755\n*S KotlinDebug\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/CombineLayoutDimensions\n*L\n261#1:730\n268#1:731\n319#1:732\n324#1:733\n326#1:734\n333#1:735\n335#1:736\n338#1:737\n342#1:738\n344#1:739\n348#1:740\n356#1:741\n358#1:742\n361#1:743\n363#1:744\n364#1:745\n365#1:746\n369#1:747\n373#1:748\n374#1:749\n378#1:750\n380#1:751\n382#1:752\n384#1:753\n386#1:754\n388#1:755\n*E\n"})
public final class CombineLayoutDimensions {
    public static final int $stable = 0;

    @NotNull
    public static final CombineLayoutDimensions INSTANCE = new CombineLayoutDimensions();

    private CombineLayoutDimensions() {
    }

    @Composable
    @JvmName(name = "getPrimaryContentResIds")
    @NotNull
    public final ImageButtonResIds getPrimaryContentResIds(@Nullable Composer composer, int i) {
        ImageButtonResIds imageButtonResIds;
        composer.startReplaceableGroup(644793920);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(644793920, i, -1, "androidx.glance.oneui.template.layout.CombineLayoutDimensions.<get-primaryContentResIds> (LayoutDimensions.kt:260)");
        }
        composer.startReplaceableGroup(-1881405370);
        boolean z = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0;
        composer.endReplaceableGroup();
        if (z) {
            imageButtonResIds = new ImageButtonResIds(C3094R.dimen.sesl_glance_combine_primary_small_circle_padding, C3094R.dimen.sesl_glance_combine_primary_small_circle_size);
        } else {
            composer.startReplaceableGroup(-1881404883);
            boolean hasTitleBar = ((TemplateState) composer.consume(CompositionLocalsKt.getLocalTemplateState())).getHasTitleBar();
            composer.endReplaceableGroup();
            imageButtonResIds = hasTitleBar ? new ImageButtonResIds(C3094R.dimen.sesl_glance_combine_primary_large_with_titlebar_circle_padding, C3094R.dimen.sesl_glance_combine_primary_large_with_titlebar_circle_size) : new ImageButtonResIds(C3094R.dimen.sesl_glance_combine_primary_medium_circle_padding, C3094R.dimen.sesl_glance_combine_primary_medium_circle_size);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageButtonResIds;
    }

    @Composable
    public final int primaryIconSizeResId(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1433013452);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1433013452, i, -1, "androidx.glance.oneui.template.layout.CombineLayoutDimensions.primaryIconSizeResId (LayoutDimensions.kt:282)");
        }
        int i2 = z ? C3094R.dimen.sesl_glance_combine_primary_with_2texts_tiny_icon_size : C3094R.dimen.sesl_glance_combine_primary_with_text_tiny_icon_size;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return i2;
    }

    @Composable
    @NotNull
    public final DpRect textPadding(@NotNull List<? extends TypedTextData> textList, int i, boolean z, boolean z2, @Nullable Orientation orientation, @Nullable Composer composer, int i2, int i4) {
        Intrinsics.checkNotNullParameter(textList, "textList");
        composer.startReplaceableGroup(1088587773);
        boolean z3 = (i4 & 4) != 0 ? true : z;
        boolean z4 = (i4 & 8) != 0 ? false : z2;
        Orientation orientation2 = (i4 & 16) != 0 ? Orientation.Vertical : orientation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1088587773, i2, -1, "androidx.glance.oneui.template.layout.CombineLayoutDimensions.textPadding (LayoutDimensions.kt:298)");
        }
        int textType = textList.get(i).getTextType();
        TextType textTypeM21680boximpl = i > 0 ? TextType.m21680boximpl(textList.get(i - 1).getTextType()) : null;
        int i5 = i + 1;
        DpRect dpRectM21772textPaddingAS5t1TI = m21772textPaddingAS5t1TI(textType, textTypeM21680boximpl, i5 < textList.size() ? TextType.m21680boximpl(textList.get(i5).getTextType()) : null, z3, z4, orientation2, composer, (i2 << 3) & 4193280, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dpRectM21772textPaddingAS5t1TI;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textPadding-AS5t1TI, reason: not valid java name */
    public final DpRect m21772textPaddingAS5t1TI(int i, @Nullable TextType textType, @Nullable TextType textType2, boolean z, boolean z2, @Nullable Orientation orientation, @Nullable Composer composer, int i2, int i4) {
        DpRect dpRect;
        float fM20968constructorimpl;
        float fM20968constructorimpl2;
        composer.startReplaceableGroup(-1775939997);
        TextType textType3 = (i4 & 2) != 0 ? null : textType;
        TextType textType4 = (i4 & 4) == 0 ? textType2 : null;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        boolean z4 = (i4 & 16) != 0 ? false : z2;
        Orientation orientation2 = (i4 & 32) != 0 ? Orientation.Vertical : orientation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1775939997, i2, -1, "androidx.glance.oneui.template.layout.CombineLayoutDimensions.textPadding (LayoutDimensions.kt:317)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        if (orientation2 == Orientation.Vertical) {
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
                if (TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21691getDisplaygxbDmow())) {
                    float f = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(5), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), null);
                } else {
                    float f4 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), null);
                }
            } else if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                float f5 = 8;
                float f6 = 0;
                dpRect = new DpRect(C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(f6), null);
            } else if (z4) {
                if (!z3) {
                    float f7 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f7), C2256Dp.m20968constructorimpl(f7), C2256Dp.m20968constructorimpl(f7), null);
                } else if (TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21691getDisplaygxbDmow())) {
                    float f8 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(5), C2256Dp.m20968constructorimpl(f8), C2256Dp.m20968constructorimpl(f8), C2256Dp.m20968constructorimpl(f8), null);
                } else {
                    float f9 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f9), C2256Dp.m20968constructorimpl(f9), C2256Dp.m20968constructorimpl(f9), null);
                }
            } else if (TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21691getDisplaygxbDmow())) {
                float f10 = 0;
                dpRect = new DpRect(C2256Dp.m20968constructorimpl(5), C2256Dp.m20968constructorimpl(f10), C2256Dp.m20968constructorimpl(f10), C2256Dp.m20968constructorimpl(f10), null);
            } else {
                float f11 = 0;
                dpRect = new DpRect(C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f11), C2256Dp.m20968constructorimpl(f11), C2256Dp.m20968constructorimpl(f11), null);
            }
        } else {
            TextType.Companion companion2 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(i, companion2.m21691getDisplaygxbDmow())) {
                if (textType3 == null) {
                    if (AppWidgetSize.m21546compareToL2j3NV4(mask, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                        fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(0);
                    } else if (z4) {
                        fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(z3 ? 5 : 3);
                    } else {
                        fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(5);
                    }
                    float f12 = 0;
                    dpRect = new DpRect(fM20968constructorimpl2, C2256Dp.m20968constructorimpl(f12), C2256Dp.m20968constructorimpl(f12), C2256Dp.m20968constructorimpl(f12), null);
                } else {
                    float f13 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(4), C2256Dp.m20968constructorimpl(f13), C2256Dp.m20968constructorimpl(f13), C2256Dp.m20968constructorimpl(f13), null);
                }
            } else if (TextType.m21684equalsimpl0(i, companion2.m21693getLabelgxbDmow())) {
                float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(2);
                float f14 = 0;
                float fM20968constructorimpl4 = C2256Dp.m20968constructorimpl(f14);
                if (textType4 != null || AppWidgetSize.m21546compareToL2j3NV4(mask, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(f14);
                } else if (z4) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(z3 ? 3 : 12);
                } else {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(12);
                }
                dpRect = new DpRect(fM20968constructorimpl3, fM20968constructorimpl4, fM20968constructorimpl, C2256Dp.m20968constructorimpl(f14), null);
            } else {
                float f15 = 0;
                dpRect = new DpRect(C2256Dp.m20968constructorimpl(f15), C2256Dp.m20968constructorimpl(f15), C2256Dp.m20968constructorimpl(f15), C2256Dp.m20968constructorimpl(f15), null);
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dpRect;
    }
}
