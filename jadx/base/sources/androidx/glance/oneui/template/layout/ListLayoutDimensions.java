package androidx.glance.oneui.template.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.layout.Alignment;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ListItem;
import androidx.glance.oneui.template.ProgressListItem;
import androidx.glance.oneui.template.TemplateState;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001eR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/ListLayoutDimensions;", "", "()V", "defaultItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDefaultItemHorizontalPadding-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "smallItemHorizontalPadding", "getSmallItemHorizontalPadding-D9Ej5fM", "getVisibleItemCount", "", "items", "", "Landroidx/glance/oneui/template/ListItem;", "listAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "getVisibleItemCount-vA4zNRs", "(Ljava/util/List;ILandroidx/compose/runtime/Composer;I)I", "listBottomPadding", "listBottomPadding-lQh0xVc", "(I)F", "listTopPadding", "listTopPadding-6r0uhjY", "(ILandroidx/compose/runtime/Composer;I)F", "restrictVisibleItemCount", "listSize", "restricted", "", "minOrMax", "(IZILandroidx/compose/runtime/Composer;I)I", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutDimensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/ListLayoutDimensions\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,729:1\n74#2:730\n74#2:733\n74#2:734\n154#3:731\n154#3:732\n154#3:735\n154#3:736\n*S KotlinDebug\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/ListLayoutDimensions\n*L\n209#1:730\n228#1:733\n235#1:734\n212#1:731\n219#1:732\n222#1:735\n223#1:736\n*E\n"})
public final class ListLayoutDimensions {
    public static final int $stable = 0;

    @NotNull
    public static final ListLayoutDimensions INSTANCE = new ListLayoutDimensions();
    private static final float defaultItemHorizontalPadding = C2256Dp.m20968constructorimpl(16);
    private static final float smallItemHorizontalPadding = C2256Dp.m20968constructorimpl(18);

    private ListLayoutDimensions() {
    }

    @Composable
    private final int restrictVisibleItemCount(int i, boolean z, int i2, Composer composer, int i4) {
        composer.startReplaceableGroup(-1061659008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1061659008, i4, -1, "androidx.glance.oneui.template.layout.ListLayoutDimensions.restrictVisibleItemCount (LayoutDimensions.kt:243)");
        }
        if (!z) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return i;
        }
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "restrictVisibleItemCount ", " doesn't allowed. return ", " instead of ");
        sbM1173s.append(i);
        sbM1173s.append(Extension.DOT);
        companion.m2301i("GWT:LayoutDimension", sbM1173s.toString());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return i2;
    }

    /* JADX INFO: renamed from: getDefaultItemHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m21780getDefaultItemHorizontalPaddingD9Ej5fM() {
        return defaultItemHorizontalPadding;
    }

    /* JADX INFO: renamed from: getSmallItemHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m21781getSmallItemHorizontalPaddingD9Ej5fM() {
        return smallItemHorizontalPadding;
    }

    @Composable
    /* JADX INFO: renamed from: getVisibleItemCount-vA4zNRs, reason: not valid java name */
    public final int m21782getVisibleItemCountvA4zNRs(@NotNull List<? extends ListItem> items, int i, @Nullable Composer composer, int i2) {
        Composer composer2;
        int iMin;
        Intrinsics.checkNotNullParameter(items, "items");
        composer.startReplaceableGroup(247798196);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(247798196, i2, -1, "androidx.glance.oneui.template.layout.ListLayoutDimensions.getVisibleItemCount (LayoutDimensions.kt:225)");
        }
        int size = items.size();
        composer.startReplaceableGroup(708893276);
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        boolean z = AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) >= 0;
        composer.endReplaceableGroup();
        if (z) {
            composer.startReplaceableGroup(708893325);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            if (Alignment.Vertical.m21448equalsimpl0(i, companion2.m21434getTopmnfRV0w())) {
                composer.startReplaceableGroup(708893395);
                composer2 = composer;
                iMin = restrictVisibleItemCount(size, size > 100, 100, composer2, ((i2 << 3) & 7168) | 384);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composer;
                if (Alignment.Vertical.m21448equalsimpl0(i, companion2.m21431getCenterVerticallymnfRV0w())) {
                    composer2.startReplaceableGroup(708893497);
                    iMin = restrictVisibleItemCount(size, size < 4, 4, composer2, ((i2 << 3) & 7168) | 384);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(708893586);
                    iMin = restrictVisibleItemCount(size, size < 3, 3, composer2, ((i2 << 3) & 7168) | 384);
                    composer2.endReplaceableGroup();
                }
            }
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceableGroup(708893684);
            if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), companion.m21573getWideSmallrx25Pp4()) <= 0 && (CollectionsKt.first((List) items) instanceof ProgressListItem)) {
                z = true;
            }
            composer2.endReplaceableGroup();
            iMin = z ? Math.min(2, size) : Math.min(3, size);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return iMin;
    }

    /* JADX INFO: renamed from: listBottomPadding-lQh0xVc, reason: not valid java name */
    public final float m21783listBottomPaddinglQh0xVc(int listAlignment) {
        return !Alignment.Vertical.m21448equalsimpl0(listAlignment, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w()) ? CommonDimensions.INSTANCE.m21776getLayoutVerticalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(0);
    }

    @Composable
    /* JADX INFO: renamed from: listTopPadding-6r0uhjY, reason: not valid java name */
    public final float m21784listTopPadding6r0uhjY(int i, @Nullable Composer composer, int i2) {
        composer.startReplaceableGroup(1151533855);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1151533855, i2, -1, "androidx.glance.oneui.template.layout.ListLayoutDimensions.listTopPadding (LayoutDimensions.kt:208)");
        }
        float fM20968constructorimpl = (!Alignment.Vertical.m21448equalsimpl0(i, Alignment.INSTANCE.m21434getTopmnfRV0w()) || ((TemplateState) composer.consume(CompositionLocalsKt.getLocalTemplateState())).getHasTitleBar()) ? C2256Dp.m20968constructorimpl(0) : CommonDimensions.INSTANCE.m21776getLayoutVerticalPaddingD9Ej5fM();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }
}
