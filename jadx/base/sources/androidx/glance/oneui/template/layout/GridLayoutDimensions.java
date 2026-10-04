package androidx.glance.oneui.template.layout;

import android.content.Context;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateCompositor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005J!\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/GridLayoutDimensions;", "", "()V", "isFoldMainOverSw700", "", "(Landroidx/compose/runtime/Composer;I)Z", "isFoldableUnderSw700", "isTabletSw400", "itemResIds", "Landroidx/glance/oneui/template/layout/ImageButtonResIds;", "hasLabel", "itemCountInLarge", "", "(ZILandroidx/compose/runtime/Composer;II)Landroidx/glance/oneui/template/layout/ImageButtonResIds;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutDimensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/GridLayoutDimensions\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,729:1\n74#2:730\n74#2:731\n74#2:732\n74#2:733\n74#2:734\n74#2:735\n74#2:736\n74#2:737\n74#2:738\n74#2:739\n*S KotlinDebug\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/GridLayoutDimensions\n*L\n73#1:730\n174#1:731\n176#1:732\n177#1:733\n185#1:734\n187#1:735\n188#1:736\n196#1:737\n198#1:738\n199#1:739\n*E\n"})
public final class GridLayoutDimensions {
    public static final int $stable = 0;

    @NotNull
    public static final GridLayoutDimensions INSTANCE = new GridLayoutDimensions();

    private GridLayoutDimensions() {
    }

    @Composable
    private final boolean isFoldMainOverSw700(Composer composer, int i) {
        Context context;
        composer.startReplaceableGroup(-922186030);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-922186030, i, -1, "androidx.glance.oneui.template.layout.GridLayoutDimensions.isFoldMainOverSw700 (LayoutDimensions.kt:183)");
        }
        if (composer.consume(CompositionLocalsKt.getLocalDeviceType()) != DeviceType.FoldMain) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return false;
        }
        if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(307989703);
            context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(307989774);
            context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composer.endReplaceableGroup();
        }
        boolean z = context.getResources().getConfiguration().smallestScreenWidthDp >= 700;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }

    @Composable
    private final boolean isFoldableUnderSw700(Composer composer, int i) {
        Context context;
        composer.startReplaceableGroup(1126633489);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1126633489, i, -1, "androidx.glance.oneui.template.layout.GridLayoutDimensions.isFoldableUnderSw700 (LayoutDimensions.kt:194)");
        }
        if (composer.consume(CompositionLocalsKt.getLocalDeviceType()) != DeviceType.FoldMain) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return false;
        }
        if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(-726193496);
            context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-726193425);
            context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composer.endReplaceableGroup();
        }
        boolean z = context.getResources().getConfiguration().smallestScreenWidthDp < 700;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }

    @Composable
    private final boolean isTabletSw400(Composer composer, int i) {
        Context context;
        composer.startReplaceableGroup(-363027827);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-363027827, i, -1, "androidx.glance.oneui.template.layout.GridLayoutDimensions.isTabletSw400 (LayoutDimensions.kt:172)");
        }
        if (composer.consume(CompositionLocalsKt.getLocalDeviceType()) != DeviceType.Tablet) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return false;
        }
        if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(-463000947);
            context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-463000876);
            context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composer.endReplaceableGroup();
        }
        boolean z = context.getResources().getConfiguration().smallestScreenWidthDp == 400;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }

    @Composable
    @NotNull
    public final ImageButtonResIds itemResIds(boolean z, int i, @Nullable Composer composer, int i2, int i4) {
        ImageButtonResIds imageButtonResIds;
        composer.startReplaceableGroup(-2072490128);
        if ((i4 & 1) != 0) {
            z = false;
        }
        if ((i4 & 2) != 0) {
            i = 4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2072490128, i2, -1, "androidx.glance.oneui.template.layout.GridLayoutDimensions.itemResIds (LayoutDimensions.kt:71)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
            composer.startReplaceableGroup(-616914644);
            int i5 = (i2 >> 6) & 14;
            imageButtonResIds = isTabletSw400(composer, i5) ? new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding_fallback, C3094R.dimen.sesl_glance_grid_item_small_circle_size_fallback) : isFoldMainOverSw700(composer, i5) ? new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding, C3094R.dimen.sesl_glance_grid_item_small_circle_size_fold_main_over_sw_700) : new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding, C3094R.dimen.sesl_glance_grid_item_small_circle_size);
            composer.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
            composer.startReplaceableGroup(-616913416);
            if (z) {
                composer.startReplaceableGroup(-616913402);
                imageButtonResIds = isTabletSw400(composer, (i2 >> 6) & 14) ? new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding_fallback, C3094R.dimen.sesl_glance_grid_item_small_circle_size_fallback) : new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_with_label_medium_circle_padding, C3094R.dimen.sesl_glance_grid_item_with_label_medium_circle_size);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-616912670);
                int i6 = (i2 >> 6) & 14;
                if (isTabletSw400(composer, i6)) {
                    imageButtonResIds = new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding_fallback, C3094R.dimen.sesl_glance_grid_item_small_circle_size_fallback);
                } else {
                    imageButtonResIds = new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_medium_circle_padding, isFoldableUnderSw700(composer, i6) ? C3094R.dimen.sesl_glance_grid_item_with_label_medium_circle_size_fallback : C3094R.dimen.sesl_glance_grid_item_medium_circle_size);
                }
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4())) {
            composer.startReplaceableGroup(-616911671);
            if (i == 4) {
                composer.startReplaceableGroup(-616911644);
                int i7 = (i2 >> 6) & 14;
                if (isTabletSw400(composer, i7)) {
                    imageButtonResIds = new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding_fallback, C3094R.dimen.sesl_glance_grid_item_small_circle_size_large_fallback);
                } else {
                    imageButtonResIds = new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_large_circle_padding, isFoldableUnderSw700(composer, i7) ? C3094R.dimen.sesl_glance_grid_item_large_circle_size_fallback : C3094R.dimen.sesl_glance_grid_item_large_circle_size);
                }
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-616910747);
                imageButtonResIds = isTabletSw400(composer, (i2 >> 6) & 14) ? new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_small_circle_padding_fallback, C3094R.dimen.sesl_glance_grid_item_small_circle_size_large_fallback) : new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_medium_circle_padding, C3094R.dimen.sesl_glance_grid_item_medium_circle_size);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-616909930);
            composer.endReplaceableGroup();
            imageButtonResIds = new ImageButtonResIds(C3094R.dimen.sesl_glance_grid_item_large_circle_padding, C3094R.dimen.sesl_glance_grid_item_large_circle_size);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageButtonResIds;
    }
}
