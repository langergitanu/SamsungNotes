package androidx.glance.oneui.template.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.FuturePublicApi;
import androidx.glance.appwidget.CompositionLocalsKt;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.DeviceTypeUtil;
import androidx.glance.oneui.template.component.padding.Padding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a$\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\r\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m13886d2 = {"checkSizeIsNotSet", "Landroidx/compose/ui/unit/DpSize;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;I)J", "getLocalSizeWithoutPadding", "padding", "Landroidx/glance/oneui/template/component/padding/Padding;", "size", "getLocalSizeWithoutPadding-eVKgIn8", "(Landroidx/glance/oneui/template/component/padding/Padding;JLandroidx/compose/runtime/Composer;II)J", "getWidgetContainerRatio", "", "(Landroidx/compose/runtime/Composer;I)F", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSizeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SizeUtils.kt\nandroidx/glance/oneui/template/utils/SizeUtilsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,81:1\n74#2:82\n74#2:83\n74#2:84\n74#2:86\n74#2:88\n74#2:89\n74#2:92\n74#2:93\n74#2:94\n1#3:85\n154#4:87\n154#4:95\n154#4:96\n58#5:90\n58#5:91\n*S KotlinDebug\n*F\n+ 1 SizeUtils.kt\nandroidx/glance/oneui/template/utils/SizeUtilsKt\n*L\n23#1:82\n24#1:83\n59#1:84\n60#1:86\n64#1:88\n71#1:89\n33#1:92\n34#1:93\n50#1:94\n61#1:87\n54#1:95\n55#1:96\n77#1:90\n78#1:91\n*E\n"})
public final class SizeUtilsKt {

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
            try {
                iArr[DeviceType.FoldMain.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Composable
    public static final long checkSizeIsNotSet(@NotNull Context context, @Nullable Composer composer, int i) {
        Object objM22215constructorimpl;
        long jCheckSizeIsNotSet$getTemporarySize;
        Intrinsics.checkNotNullParameter(context, "context");
        composer.startReplaceableGroup(-581682012);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-581682012, i, -1, "androidx.glance.oneui.template.utils.checkSizeIsNotSet (SizeUtils.kt:29)");
        }
        Bundle bundle = (Bundle) composer.consume(CompositionLocalsKt.getLocalAppWidgetOptions());
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(DpSize.m21054boximpl(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        DpSize dpSize = (DpSize) objM22215constructorimpl;
        if (dpSize != null) {
            float f = 0;
            if (C2256Dp.m20967compareTo0680j_4(DpSize.m21066getWidthD9Ej5fM(dpSize.getPackedValue()), C2256Dp.m20968constructorimpl(f)) > 0 && C2256Dp.m20967compareTo0680j_4(DpSize.m21064getHeightD9Ej5fM(dpSize.getPackedValue()), C2256Dp.m20968constructorimpl(f)) > 0) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return dpSize.getPackedValue();
            }
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("appWidgetSizes");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            composer.startReplaceableGroup(347051449);
            jCheckSizeIsNotSet$getTemporarySize = checkSizeIsNotSet$getTemporarySize(context, composer, 8);
        } else {
            composer.startReplaceableGroup(347051500);
            jCheckSizeIsNotSet$getTemporarySize = ((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue();
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jCheckSizeIsNotSet$getTemporarySize;
    }

    @Composable
    private static final long checkSizeIsNotSet$getTemporarySize(Context context, Composer composer, int i) {
        composer.startReplaceableGroup(-1796889990);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1796889990, i, -1, "androidx.glance.oneui.template.utils.checkSizeIsNotSet.getTemporarySize (SizeUtils.kt:31)");
        }
        int mask = ((AppWidgetStyle) composer.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask();
        int mask2 = ((AppWidgetHostType) composer.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalHostType())).getMask();
        int i2 = WhenMappings.$EnumSwitchMapping$0[DeviceTypeUtil.INSTANCE.get(context).ordinal()];
        int i4 = 60;
        if (i2 == 1 || i2 == 2) {
            if (AppWidgetStyle.m21578equalsimpl0(mask, AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
                i4 = 58;
            } else if (!AppWidgetHostType.m21524equalsimpl0(mask2, AppWidgetHostType.INSTANCE.m21536getLockAndAODmn_SBp8())) {
                i4 = 50;
            }
        } else if (!AppWidgetStyle.m21578equalsimpl0(mask, AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
            i4 = 56;
        }
        Point pointM21558toSpanimpl = AppWidgetSize.m21558toSpanimpl(((AppWidgetSize) composer.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), context);
        int i5 = pointM21558toSpanimpl.x;
        int i6 = pointM21558toSpanimpl.y;
        long jM20990DpSizeYgX7TsA = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(AbstractC1974b.m1304A(i5, 1, 14, i4 * i5)), C2256Dp.m20968constructorimpl(AbstractC1974b.m1304A(i6, 1, 13, i4 * i6)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM20990DpSizeYgX7TsA;
    }

    @Composable
    @FuturePublicApi
    /* JADX INFO: renamed from: getLocalSizeWithoutPadding-eVKgIn8, reason: not valid java name */
    public static final long m21968getLocalSizeWithoutPaddingeVKgIn8(@NotNull Padding padding, long j, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        composer.startReplaceableGroup(1512190892);
        if ((i2 & 2) != 0) {
            j = ((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1512190892, i, -1, "androidx.glance.oneui.template.utils.getLocalSizeWithoutPadding (SizeUtils.kt:71)");
        }
        int i4 = i & 14;
        long jM20990DpSizeYgX7TsA = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(j) - padding.m21767getStartchRvn1I(composer, i4)) - padding.m21765getEndchRvn1I(composer, i4)), C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(j) - padding.m21769getTopchRvn1I(composer, i4)) - padding.m21763getBottomchRvn1I(composer, i4)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM20990DpSizeYgX7TsA;
    }

    @Composable
    public static final float getWidgetContainerRatio(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1424655482);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1424655482, i, -1, "androidx.glance.oneui.template.utils.getWidgetContainerRatio (SizeUtils.kt:21)");
        }
        float fM21066getWidthD9Ej5fM = DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) / DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM21066getWidthD9Ej5fM;
    }
}
