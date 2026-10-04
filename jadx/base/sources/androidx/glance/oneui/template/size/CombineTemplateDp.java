package androidx.glance.oneui.template.size;

import android.content.Context;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/glance/oneui/template/size/CombineTemplateDp;", "", "()V", "LARGE_PRIMARY_ICON_BOTTOM_PADDING", "Landroidx/compose/ui/unit/Dp;", "getLARGE_PRIMARY_ICON_BOTTOM_PADDING-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "LARGE_PRIMARY_ICON_END_PADDING", "getLARGE_PRIMARY_ICON_END_PADDING-D9Ej5fM", "MULTIPLE_TEXT_HEIGHT", "getMULTIPLE_TEXT_HEIGHT", "(Landroidx/compose/runtime/Composer;I)F", "SMALL_END_PADDING", "getSMALL_END_PADDING", "SMALL_START_PADDING", "getSMALL_START_PADDING", "SMALL_TEXT_PADDING", "getSMALL_TEXT_PADDING", "TINY_MULTIPLE_TEXT_HEIGHT", "getTINY_MULTIPLE_TEXT_HEIGHT", "getMaxButtonSize", "context", "Landroid/content/Context;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getMaxButtonSize-mDIpwz4", "(Landroid/content/Context;I)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCombineLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombineLayoutSize.kt\nandroidx/glance/oneui/template/size/CombineTemplateDp\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,259:1\n74#2:260\n74#2:263\n74#2:266\n74#2:269\n74#2:272\n74#2:273\n154#3:261\n154#3:262\n154#3:264\n154#3:265\n154#3:267\n154#3:268\n154#3:270\n154#3:271\n154#3:274\n154#3:275\n154#3:276\n174#3:277\n174#3:278\n174#3:279\n154#3:280\n154#3:281\n*S KotlinDebug\n*F\n+ 1 CombineLayoutSize.kt\nandroidx/glance/oneui/template/size/CombineTemplateDp\n*L\n31#1:260\n40#1:263\n48#1:266\n59#1:269\n71#1:272\n76#1:273\n32#1:261\n33#1:262\n41#1:264\n42#1:265\n49#1:267\n50#1:268\n61#1:270\n64#1:271\n78#1:274\n79#1:275\n82#1:276\n88#1:277\n89#1:278\n90#1:279\n53#1:280\n54#1:281\n*E\n"})
public final class CombineTemplateDp {
    public static final int $stable = 0;

    @NotNull
    public static final CombineTemplateDp INSTANCE = new CombineTemplateDp();
    private static final float LARGE_PRIMARY_ICON_BOTTOM_PADDING;
    private static final float LARGE_PRIMARY_ICON_END_PADDING;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.Tablet.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        float f = 14;
        LARGE_PRIMARY_ICON_END_PADDING = C2256Dp.m20968constructorimpl(f);
        LARGE_PRIMARY_ICON_BOTTOM_PADDING = C2256Dp.m20968constructorimpl(f);
    }

    private CombineTemplateDp() {
    }

    /* JADX INFO: renamed from: getLARGE_PRIMARY_ICON_BOTTOM_PADDING-D9Ej5fM, reason: not valid java name */
    public final float m21934getLARGE_PRIMARY_ICON_BOTTOM_PADDINGD9Ej5fM() {
        return LARGE_PRIMARY_ICON_BOTTOM_PADDING;
    }

    /* JADX INFO: renamed from: getLARGE_PRIMARY_ICON_END_PADDING-D9Ej5fM, reason: not valid java name */
    public final float m21935getLARGE_PRIMARY_ICON_END_PADDINGD9Ej5fM() {
        return LARGE_PRIMARY_ICON_END_PADDING;
    }

    @Composable
    @JvmName(name = "getMULTIPLE_TEXT_HEIGHT")
    public final float getMULTIPLE_TEXT_HEIGHT(@Nullable Composer composer, int i) {
        float fM20968constructorimpl;
        composer.startReplaceableGroup(1069533648);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1069533648, i, -1, "androidx.glance.oneui.template.size.CombineTemplateDp.<get-MULTIPLE_TEXT_HEIGHT> (CombineLayoutSize.kt:58)");
        }
        if (WhenMappings.$EnumSwitchMapping$0[((DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType())).ordinal()] == 1) {
            composer.startReplaceableGroup(-1889135244);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(CombineLayoutSizeKt.getSmallestWidth(composer, 0) > 700 ? 44 : 38);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1889135133);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(CombineLayoutSizeKt.getSmallestWidth(composer, 0) > 700 ? 44 : 36);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    /* JADX INFO: renamed from: getMaxButtonSize-mDIpwz4, reason: not valid java name */
    public final float m21936getMaxButtonSizemDIpwz4(@NotNull Context context, int widgetSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21569getMediumrx25Pp4()) ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_combine_max_button_medium_size)) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21568getLargerx25Pp4()) ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_combine_max_button_large_size)) : C2256Dp.m20968constructorimpl(Float.MAX_VALUE);
    }

    @Composable
    @JvmName(name = "getSMALL_END_PADDING")
    public final float getSMALL_END_PADDING(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1413989942);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413989942, i, -1, "androidx.glance.oneui.template.size.CombineTemplateDp.<get-SMALL_END_PADDING> (CombineLayoutSize.kt:39)");
        }
        float fM20968constructorimpl = WhenMappings.$EnumSwitchMapping$0[((DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType())).ordinal()] == 1 ? C2256Dp.m20968constructorimpl(8) : C2256Dp.m20968constructorimpl(8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    @JvmName(name = "getSMALL_START_PADDING")
    public final float getSMALL_START_PADDING(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1872736918);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1872736918, i, -1, "androidx.glance.oneui.template.size.CombineTemplateDp.<get-SMALL_START_PADDING> (CombineLayoutSize.kt:30)");
        }
        float fM20968constructorimpl = WhenMappings.$EnumSwitchMapping$0[((DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType())).ordinal()] == 1 ? C2256Dp.m20968constructorimpl(7) : C2256Dp.m20968constructorimpl(7);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    @JvmName(name = "getSMALL_TEXT_PADDING")
    public final float getSMALL_TEXT_PADDING(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1309692906);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1309692906, i, -1, "androidx.glance.oneui.template.size.CombineTemplateDp.<get-SMALL_TEXT_PADDING> (CombineLayoutSize.kt:47)");
        }
        float fM20968constructorimpl = WhenMappings.$EnumSwitchMapping$0[((DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType())).ordinal()] == 1 ? C2256Dp.m20968constructorimpl(6) : C2256Dp.m20968constructorimpl(6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    @JvmName(name = "getTINY_MULTIPLE_TEXT_HEIGHT")
    public final float getTINY_MULTIPLE_TEXT_HEIGHT(@Nullable Composer composer, int i) {
        float fM20968constructorimpl;
        composer.startReplaceableGroup(-1705990730);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1705990730, i, -1, "androidx.glance.oneui.template.size.CombineTemplateDp.<get-TINY_MULTIPLE_TEXT_HEIGHT> (CombineLayoutSize.kt:70)");
        }
        if (WhenMappings.$EnumSwitchMapping$0[((DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType())).ordinal()] == 1) {
            composer.startReplaceableGroup(-2110537356);
            fM20968constructorimpl = (CombineLayoutSizeKt.getSmallestWidth(composer, 0) >= 700 || !AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21587getMonotoneWOdBnnM())) ? C2256Dp.m20968constructorimpl(40) : C2256Dp.m20968constructorimpl(32);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2110537017);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(CombineLayoutSizeKt.getSmallestWidth(composer, 0) > 700 ? 40 : 32);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }
}
