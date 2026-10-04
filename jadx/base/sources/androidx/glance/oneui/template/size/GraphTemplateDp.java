package androidx.glance.oneui.template.size;

import android.content.Context;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.template.TextType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplateDp;", "", "()V", "getMaxGraphSize", "Landroidx/compose/ui/unit/Dp;", "context", "Landroid/content/Context;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "gridCount", "", "getMaxGraphSize-XPoHa0U", "(Landroid/content/Context;II)F", "getMaxIconSize", "getMaxIconSize-AtWbyfM", "(I)F", "getTextSizeRange", "Lkotlin/Pair;", "", "textType", "Landroidx/glance/oneui/template/TextType;", "getTextSizeRange-z-rxCuU", "(ILandroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraphLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphLayoutSize.kt\nandroidx/glance/oneui/template/size/GraphTemplateDp\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,186:1\n154#2:187\n*S KotlinDebug\n*F\n+ 1 GraphLayoutSize.kt\nandroidx/glance/oneui/template/size/GraphTemplateDp\n*L\n175#1:187\n*E\n"})
public final class GraphTemplateDp {
    public static final int $stable = 0;

    @NotNull
    public static final GraphTemplateDp INSTANCE = new GraphTemplateDp();

    private GraphTemplateDp() {
    }

    /* JADX INFO: renamed from: getMaxGraphSize-XPoHa0U, reason: not valid java name */
    public final float m21940getMaxGraphSizeXPoHa0U(@NotNull Context context, int widgetSize, int gridCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        return GridTemplateDp.INSTANCE.m21951getMaxIconSizexeG5q6M(context, widgetSize, true, gridCount);
    }

    /* JADX INFO: renamed from: getMaxIconSize-AtWbyfM, reason: not valid java name */
    public final float m21941getMaxIconSizeAtWbyfM(int widgetSize) {
        return C2256Dp.m20968constructorimpl(25);
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: getTextSizeRange-z-rxCuU, reason: not valid java name */
    public final Pair<Float, Float> m21942getTextSizeRangezrxCuU(int i, @Nullable Composer composer, int i2) {
        Float fValueOf = Float.valueOf(10.0f);
        composer.startReplaceableGroup(534169479);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(534169479, i2, -1, "androidx.glance.oneui.template.size.GraphTemplateDp.getTextSizeRange (GraphLayoutSize.kt:178)");
        }
        Pair<Float, Float> pair = TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21694getTitlegxbDmow()) ? new Pair<>(fValueOf, Float.valueOf(20.0f)) : new Pair<>(fValueOf, Float.valueOf(14.0f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pair;
    }
}
