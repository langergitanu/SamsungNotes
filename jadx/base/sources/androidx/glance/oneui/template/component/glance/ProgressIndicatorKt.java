package androidx.glance.oneui.template.component.glance;

import android.content.Context;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.ArcProgressIndicatorKt;
import androidx.glance.appwidget.CircularProgressIndicatorKt;
import androidx.glance.appwidget.ContentScale;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.LinearProgressIndicatorKt;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.color.ColorProviders;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.ArcProgressData;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CircularProgressData;
import androidx.glance.oneui.template.CustomArcProgressData;
import androidx.glance.oneui.template.CustomLinearProgressData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.GridLayoutDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt;
import androidx.glance.oneui.template.size.GraphTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001a5\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\"\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m13886d2 = {"CircularProgressIndicator", "", "modifier", "Landroidx/glance/GlanceModifier;", "data", "Landroidx/glance/oneui/template/CircularProgressData;", "gridPosition", "", "textData", "Landroidx/glance/oneui/template/TextData;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/CircularProgressData;ILandroidx/glance/oneui/template/TextData;Landroidx/compose/runtime/Composer;II)V", "GlanceCircularProgressIndicator", "(Landroidx/glance/oneui/template/CircularProgressData;Landroidx/compose/runtime/Composer;I)V", "GlanceLinearProgressIndicator", "Landroidx/glance/oneui/template/LinearProgressData;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/LinearProgressData;Landroidx/compose/runtime/Composer;II)V", "size", "Landroidx/compose/ui/unit/Dp;", "GlanceLinearProgressIndicator-ziNgDLE", "(Landroidx/glance/oneui/template/LinearProgressData;FLandroidx/compose/runtime/Composer;I)V", "sizeResId", "(Landroidx/glance/oneui/template/LinearProgressData;ILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "(Landroidx/glance/oneui/template/LinearProgressData;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nProgressIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProgressIndicator.kt\nandroidx/glance/oneui/template/component/glance/ProgressIndicatorKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,518:1\n74#2:519\n74#2:522\n74#2:523\n74#2:524\n74#2:525\n74#2:526\n154#3:520\n154#3:521\n*S KotlinDebug\n*F\n+ 1 ProgressIndicator.kt\nandroidx/glance/oneui/template/component/glance/ProgressIndicatorKt\n*L\n79#1:519\n248#1:522\n249#1:523\n257#1:524\n315#1:525\n316#1:526\n79#1:520\n86#1:521\n*E\n"})
public final class ProgressIndicatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Object] */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressIndicator(final GlanceModifier glanceModifier, final CircularProgressData circularProgressData, int i, TextData textData, Composer composer, final int i2, final int i4) {
        final TextData textData2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1577572696);
        int i5 = (i4 & 4) != 0 ? 0 : i;
        TextData textData3 = (i4 & 8) != 0 ? null : textData;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1577572696, i2, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator (ProgressIndicator.kt:246)");
        }
        final Context context = (Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext());
        final int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Pair<ColorProvider, ColorProvider> pairCircularProgressIndicator$initColor = CircularProgressIndicator$initColor(circularProgressData, composerStartRestartGroup, 0);
        objectRef.element = pairCircularProgressIndicator$initColor.getFirst();
        objectRef2.element = pairCircularProgressIndicator$initColor.getSecond();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        final ContentScale contentScale = AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4()) ? ContentScale.Large : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? ContentScale.Medium : ContentScale.Small;
        if (circularProgressData instanceof ArcProgressData) {
            composerStartRestartGroup.startReplaceableGroup(1751878163);
            final float f = 0.8f;
            if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21568getLargerx25Pp4()) < 0) {
                composerStartRestartGroup.startReplaceableGroup(1751878211);
                Debug.INSTANCE.debugBox(glanceModifier, Alignment.INSTANCE.getCenter(), "Progress6", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1577645369, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i6) {
                        if ((i6 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1577645369, i6, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous> (ProgressIndicator.kt:384)");
                        }
                        Pair<Float, Float> pairM21943getGraphSizeR2GYfMI = GraphTemplatePercent.Graph.INSTANCE.m21943getGraphSizeR2GYfMI(mask, composer3, 48);
                        final float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21943getGraphSizeR2GYfMI.getFirst().floatValue(), pairM21943getGraphSizeR2GYfMI.getSecond().floatValue(), 0.0f, 0.0f, 1.0f, composer3, (PercentSizeUtils.$stable << 15) | 24576, 12));
                        Debug debug = Debug.INSTANCE;
                        GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, fM21064getHeightD9Ej5fM);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        final float f4 = f;
                        final CircularProgressData circularProgressData2 = circularProgressData;
                        final Ref.ObjectRef<ColorProvider> objectRef3 = objectRef;
                        final Ref.ObjectRef<ColorProvider> objectRef4 = objectRef2;
                        final ContentScale contentScale2 = contentScale;
                        debug.debugBox(glanceModifierM21506size3ABfNKs, center, "Progress7", false, ComposableLambdaKt.composableLambda(composer3, -1046382160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i7) {
                                if ((i7 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1046382160, i7, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous> (ProgressIndicator.kt:397)");
                                }
                                Ref.ObjectRef<ColorProvider> objectRef5 = objectRef3;
                                Ref.ObjectRef<ColorProvider> objectRef6 = objectRef4;
                                ContentScale contentScale3 = contentScale2;
                                GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                ProgressIndicatorKt.CircularProgressIndicator$ArcProgress(objectRef5, objectRef6, contentScale3, GlanceModifierUtilsKt.maybeAnimation(SizeModifiersKt.m21506size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(fM21064getHeightD9Ej5fM * f4)), circularProgressData2.getAnimation()), (ArcProgressData) circularProgressData2, composer4, 64);
                                GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(companion2);
                                final CircularProgressData circularProgressData3 = circularProgressData2;
                                final float f5 = fM21064getHeightD9Ej5fM;
                                ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, 0, 0, ComposableLambdaKt.composableLambda(composer4, -199712986, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer5, Integer num) {
                                        invoke(columnScope, composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                    @Composable
                                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer5, int i8) {
                                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-199712986, i8, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:404)");
                                        }
                                        GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                        SpacerKt.Spacer(Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion3)), composer5, 0, 0);
                                        GlanceModifier glanceModifierDefaultWeight = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion3));
                                        final CircularProgressData circularProgressData4 = circularProgressData3;
                                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierDefaultWeight, 0, 0, ComposableLambdaKt.composableLambda(composer5, 1036326300, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.2.1.1.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer6, Integer num) {
                                                invoke(columnScope, composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer6, int i9) {
                                                Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1036326300, i9, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:406)");
                                                }
                                                ProgressIndicatorKt.CircularProgressIndicator$ArcIcon(Column2.defaultWeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), circularProgressData4.getIcon(), composer6, 64);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 3072, 6);
                                        Debug debug2 = Debug.INSTANCE;
                                        GlanceModifier glanceModifierDefaultWeight2 = Column.defaultWeight(SizeModifiersKt.fillMaxWidth(companion3));
                                        Alignment center2 = Alignment.INSTANCE.getCenter();
                                        final float f6 = f5;
                                        final CircularProgressData circularProgressData5 = circularProgressData3;
                                        debug2.debugBox(glanceModifierDefaultWeight2, center2, "Progress8", false, ComposableLambdaKt.composableLambda(composer5, 1439631439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.2.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer6, int i9) {
                                                if ((i9 & 11) == 2 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1439631439, i9, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:416)");
                                                }
                                                ProvidableCompositionLocal<DpSize> localAreaSize = androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize();
                                                float f7 = f6;
                                                ProvidedValue<DpSize> providedValueProvides = localAreaSize.provides(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(f7, C2256Dp.m20968constructorimpl(f7 / 3))));
                                                final CircularProgressData circularProgressData6 = circularProgressData5;
                                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda(composer6, -1333809905, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.2.1.1.2.1
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                        invoke(composer7, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer7, int i10) {
                                                        if ((i10 & 11) == 2 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1333809905, i10, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:419)");
                                                        }
                                                        ProgressIndicatorKt.CircularProgressIndicator$BottomTextArea((ArcProgressData) circularProgressData6, composer7, 8);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer6, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, (Alignment.$stable << 3) | 221568, 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer4, 3072, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (Alignment.$stable << 3) | 221568, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (i2 & 14) | 221568 | (Alignment.$stable << 3), 8);
                composerStartRestartGroup.endReplaceableGroup();
                composer2 = composerStartRestartGroup;
                textData2 = textData3;
            } else {
                composerStartRestartGroup.startReplaceableGroup(1751880377);
                Pair<Float, Float> pairM21943getGraphSizeR2GYfMI = GraphTemplatePercent.Graph.INSTANCE.m21943getGraphSizeR2GYfMI(mask, composerStartRestartGroup, 48);
                final float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21943getGraphSizeR2GYfMI.getFirst().floatValue(), pairM21943getGraphSizeR2GYfMI.getSecond().floatValue(), 0.0f, 0.0f, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24576, 12));
                Debug debug = Debug.INSTANCE;
                GlanceModifier glanceModifierM21358paddings2pLCVw = PaddingModifiersKt.m21358paddings2pLCVw(glanceModifier, 0.005f, 0.0f, 0.005f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i2 & 14) | 3120, 250);
                final TextData textData4 = textData3;
                Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i6) {
                        if ((i6 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(321135760, i6, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous> (ProgressIndicator.kt:438)");
                        }
                        GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        int iM21430getCenterHorizontallyPGIyAqw = companion2.m21430getCenterHorizontallyPGIyAqw();
                        int iM21431getCenterVerticallymnfRV0w = companion2.m21431getCenterVerticallymnfRV0w();
                        final float f4 = fM21064getHeightD9Ej5fM;
                        final TextData textData5 = textData4;
                        final float f5 = f;
                        final CircularProgressData circularProgressData2 = circularProgressData;
                        final Ref.ObjectRef<ColorProvider> objectRef3 = objectRef;
                        final Ref.ObjectRef<ColorProvider> objectRef4 = objectRef2;
                        final ContentScale contentScale2 = contentScale;
                        final Context context2 = context;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, iM21431getCenterVerticallymnfRV0w, iM21430getCenterHorizontallyPGIyAqw, ComposableLambdaKt.composableLambda(composer3, 1254531846, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer4, Integer num) {
                                invoke(columnScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                            @Composable
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i7) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1254531846, i7, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous> (ProgressIndicator.kt:443)");
                                }
                                Debug debug2 = Debug.INSTANCE;
                                GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                                GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(companion3, f4);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                final float f6 = f4;
                                final float f7 = f5;
                                final CircularProgressData circularProgressData3 = circularProgressData2;
                                final Ref.ObjectRef<ColorProvider> objectRef5 = objectRef3;
                                final Ref.ObjectRef<ColorProvider> objectRef6 = objectRef4;
                                final ContentScale contentScale3 = contentScale2;
                                debug2.debugBox(glanceModifierM21506size3ABfNKs, center, "Progress10", false, ComposableLambdaKt.composableLambda(composer4, -1403542097, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i8) {
                                        if ((i8 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1403542097, i8, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:448)");
                                        }
                                        Ref.ObjectRef<ColorProvider> objectRef7 = objectRef5;
                                        Ref.ObjectRef<ColorProvider> objectRef8 = objectRef6;
                                        ContentScale contentScale4 = contentScale3;
                                        GlanceModifier.Companion companion4 = GlanceModifier.INSTANCE;
                                        ProgressIndicatorKt.CircularProgressIndicator$ArcProgress(objectRef7, objectRef8, contentScale4, GlanceModifierUtilsKt.maybeAnimation(SizeModifiersKt.m21506size3ABfNKs(companion4, C2256Dp.m20968constructorimpl(f6 * f7)), circularProgressData3.getAnimation()), (ArcProgressData) circularProgressData3, composer5, 64);
                                        GlanceModifier glanceModifierFillMaxSize2 = SizeModifiersKt.fillMaxSize(companion4);
                                        final CircularProgressData circularProgressData4 = circularProgressData3;
                                        final float f8 = f6;
                                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize2, 0, 0, ComposableLambdaKt.composableLambda(composer5, 1887125925, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.3.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer6, Integer num) {
                                                invoke(columnScope, composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer6, int i9) {
                                                Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1887125925, i9, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:455)");
                                                }
                                                GlanceModifier.Companion companion5 = GlanceModifier.INSTANCE;
                                                SpacerKt.Spacer(Column2.defaultWeight(SizeModifiersKt.fillMaxWidth(companion5)), composer6, 0, 0);
                                                ProgressIndicatorKt.CircularProgressIndicator$ArcIcon(Column2.defaultWeight(SizeModifiersKt.fillMaxWidth(companion5)), circularProgressData4.getIcon(), composer6, 64);
                                                Debug debug3 = Debug.INSTANCE;
                                                GlanceModifier glanceModifierDefaultWeight = Column2.defaultWeight(SizeModifiersKt.fillMaxWidth(companion5));
                                                Alignment center2 = Alignment.INSTANCE.getCenter();
                                                final float f9 = f8;
                                                final CircularProgressData circularProgressData5 = circularProgressData4;
                                                debug3.debugBox(glanceModifierDefaultWeight, center2, "Progress11", false, ComposableLambdaKt.composableLambda(composer6, -1725092210, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.3.1.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                        invoke(composer7, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer7, int i10) {
                                                        if ((i10 & 11) == 2 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1725092210, i10, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:465)");
                                                        }
                                                        ProvidableCompositionLocal<DpSize> localAreaSize = androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize();
                                                        float f10 = f9;
                                                        ProvidedValue<DpSize> providedValueProvides = localAreaSize.provides(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(f10, C2256Dp.m20968constructorimpl(f10 / 3))));
                                                        final CircularProgressData circularProgressData6 = circularProgressData5;
                                                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda(composer7, -1354554546, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.3.1.1.1.1.1
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer8, Integer num) {
                                                                invoke(composer8, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                                            @Composable
                                                            public final void invoke(@Nullable Composer composer8, int i11) {
                                                                if ((i11 & 11) == 2 && composer8.getSkipping()) {
                                                                    composer8.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1354554546, i11, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:468)");
                                                                }
                                                                ProgressIndicatorKt.CircularProgressIndicator$BottomTextArea((ArcProgressData) circularProgressData6, composer8, 8);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }), composer7, ProvidedValue.$stable | 48);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer6, (Alignment.$stable << 3) | 221568, 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer4, (Alignment.$stable << 3) | 221568, 8);
                                TextData textData6 = textData5;
                                if (textData6 != null) {
                                    Context context3 = context2;
                                    ProgressIndicatorKt.CircularProgressIndicator$ArcLabelText(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion3), textData6.getMaxLines() == 1 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_grid_item_text_view_height)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context3, C3094R.dimen.sesl_glance_grid_item_text_view_height_over_2_line))), textData6, composer4, 64, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 3072, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                textData2 = textData4;
                debug.debugBox(glanceModifierM21358paddings2pLCVw, null, "Progress9", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 321135760, true, function2), composerStartRestartGroup, 221568, 10);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
        } else {
            textData2 = textData3;
            composerStartRestartGroup.startReplaceableGroup(1751883502);
            CircularProgressIndicatorKt.CircularProgressIndicator(circularProgressData.getValue(), AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), circularProgressData.getAnimation()), circularProgressData.getKeepColor()), (ColorProvider) objectRef.element, (ColorProvider) objectRef2.element, contentScale, null, composerStartRestartGroup, 4608, 32);
            composer2 = composerStartRestartGroup;
            ImageKt.GlanceImage(circularProgressData.getIcon(), AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0 ? C3094R.dimen.sesl_glance_circular_progress_small_icon_size : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? C3094R.dimen.sesl_glance_circular_progress_medium_icon_size : C3094R.dimen.sesl_glance_circular_progress_large_icon_size, composer2, 8);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i7) {
                    ProgressIndicatorKt.CircularProgressIndicator(glanceModifier, circularProgressData, i6, textData2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void CircularProgressIndicator$ArcIcon(GlanceModifier glanceModifier, ImageData imageData, Composer composer, int i) {
        composer.startReplaceableGroup(1208373847);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208373847, i, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcIcon (ProgressIndicator.kt:304)");
        }
        ImageKt.m21746GlanceImagecuCYCYk(imageData, glanceModifier, 0, composer, ((i << 3) & 112) | 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressIndicator$ArcLabelText(GlanceModifier glanceModifier, final TextData textData, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1713450023);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1713450023, i, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcLabelText (ProgressIndicator.kt:327)");
        }
        Debug.INSTANCE.debugBox(glanceModifier2, Alignment.INSTANCE.getTopCenter(), "Progress6", false, ComposableLambdaKt.composableLambda(composer, 430847170, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt$CircularProgressIndicator$ArcLabelText$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(430847170, i4, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcLabelText.<anonymous> (ProgressIndicator.kt:329)");
                }
                GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(1), 0.0f, 2, null);
                TextKt.GlanceText(textData, new TextSize((Context) composer2.consume(CompositionLocalsKt.getLocalContext()), C3094R.dimen.sesl_glance_grid_item_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null), GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getOnBackground(), glanceModifierM21498paddingVpY3zN4$default, composer2, (TextPercentData.$stable << 3) | 520, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 221568 | (Alignment.$stable << 3), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressIndicator$ArcProgress(final Ref.ObjectRef<ColorProvider> objectRef, final Ref.ObjectRef<ColorProvider> objectRef2, final ContentScale contentScale, GlanceModifier glanceModifier, final ArcProgressData arcProgressData, Composer composer, int i) {
        composer.startReplaceableGroup(-1054533945);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1054533945, i, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcProgress (ProgressIndicator.kt:288)");
        }
        Debug.INSTANCE.debugBox(glanceModifier, Alignment.INSTANCE.getCenter(), "Progress4", false, ComposableLambdaKt.composableLambda(composer, 1702388976, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt$CircularProgressIndicator$ArcProgress$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1702388976, i2, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcProgress.<anonymous> (ProgressIndicator.kt:290)");
                }
                ArcProgressIndicatorKt.ArcProgressIndicator(arcProgressData.getValue(), AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), arcProgressData.getAnimation()), arcProgressData.getKeepColor()), objectRef.element, objectRef2.element, contentScale, null, composer2, 4608, 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 221568 | (Alignment.$stable << 3), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressIndicator$ArcTitleText(GlanceModifier glanceModifier, final TextData textData, Alignment alignment, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1206632510);
        GlanceModifier glanceModifier2 = (i2 & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1206632510, i, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcTitleText (ProgressIndicator.kt:313)");
        }
        final float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue());
        final float fM21064getHeightD9Ej5fM2 = DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize())).getPackedValue());
        Debug.INSTANCE.debugBox(glanceModifier2, alignment, "Progress5", false, ComposableLambdaKt.composableLambda(composer, -668347929, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt$CircularProgressIndicator$ArcTitleText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-668347929, i4, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.ArcTitleText.<anonymous> (ProgressIndicator.kt:317)");
                }
                TextKt.m21750GlanceText2T94tj4(null, textData, new TextPercentData(0.0f, 0.0f, 0.0f, fM21064getHeightD9Ej5fM2 / fM21064getHeightD9Ej5fM, null, false, 55, null), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getOnBackground(), composer2, (TextPercentData.$stable << 6) | 32832, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (i & 14) | 221568 | (Alignment.$stable << 3) | ((i >> 3) & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressIndicator$BottomTextArea(final ArcProgressData arcProgressData, Composer composer, int i) {
        composer.startReplaceableGroup(2044655474);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2044655474, i, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.BottomTextArea (ProgressIndicator.kt:345)");
        }
        final float f = 0.85f;
        ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), Alignment.INSTANCE.m21434getTopmnfRV0w(), 0, ComposableLambdaKt.composableLambda(composer, -281228056, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt$CircularProgressIndicator$BottomTextArea$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-281228056, i2, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.BottomTextArea.<anonymous> (ProgressIndicator.kt:348)");
                }
                ProvidedValue<DpSize> providedValueProvides = androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize().provides(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize())).getPackedValue()), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer2.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize())).getPackedValue()) * f))));
                final float f4 = f;
                final ArcProgressData arcProgressData2 = arcProgressData;
                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda(composer2, 525951400, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt$CircularProgressIndicator$BottomTextArea$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i4) {
                        if ((i4 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(525951400, i4, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.BottomTextArea.<anonymous>.<anonymous> (ProgressIndicator.kt:355)");
                        }
                        Debug debug = Debug.INSTANCE;
                        GlanceModifier glanceModifierM21505height3ABfNKs = SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer3.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize())).getPackedValue()) * f4));
                        Alignment center = Alignment.INSTANCE.getCenter();
                        final ArcProgressData arcProgressData3 = arcProgressData2;
                        debug.debugBox(glanceModifierM21505height3ABfNKs, center, null, false, ComposableLambdaKt.composableLambda(composer3, 2143034769, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.CircularProgressIndicator.BottomTextArea.1.1.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i5) {
                                if ((i5 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2143034769, i5, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.BottomTextArea.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:361)");
                                }
                                if (arcProgressData3 instanceof CustomArcProgressData) {
                                    composer4.startReplaceableGroup(538572184);
                                    ArcProgressData arcProgressData4 = arcProgressData3;
                                    ((CustomArcProgressData) arcProgressData4).CustomContent((CustomArcProgressData) arcProgressData4, composer4, 0);
                                    composer4.endReplaceableGroup();
                                } else {
                                    composer4.startReplaceableGroup(538572262);
                                    ProgressIndicatorKt.CircularProgressIndicator$ArcTitleText(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), DpSize.m21064getHeightD9Ej5fM(((DpSize) composer4.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalAreaSize())).getPackedValue())), arcProgressData3.getText(), Alignment.INSTANCE.getTopCenter(), composer4, (Alignment.$stable << 6) | 64, 0);
                                    composer4.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (Alignment.$stable << 3) | 221184, 12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final Pair<ColorProvider, ColorProvider> CircularProgressIndicator$initColor(CircularProgressData circularProgressData, Composer composer, int i) {
        composer.startReplaceableGroup(-1650047623);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650047623, i, -1, "androidx.glance.oneui.template.component.glance.CircularProgressIndicator.initColor (ProgressIndicator.kt:254)");
        }
        ColorProviders colors = GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable);
        if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
            Pair<ColorProvider, ColorProvider> pair = new Pair<>(ColorProvidersKt.override(colors.getPrimary(), circularProgressData.getProgressColor()), ColorProvidersKt.override(colors.getPrimaryContainer(), circularProgressData.getBackgroundColor()));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return pair;
        }
        if (!circularProgressData.getKeepColor()) {
            Pair<ColorProvider, ColorProvider> pair2 = new Pair<>(colors.getOnPrimary(), colors.getPrimary());
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return pair2;
        }
        ColorProvider progressColor = circularProgressData.getProgressColor();
        composer.startReplaceableGroup(1202969909);
        ColorProvider colorProviderMixedByAlpha = progressColor == null ? null : ColorProvidersKt.mixedByAlpha(progressColor, colors.getPrimary(), composer, 72);
        composer.endReplaceableGroup();
        if (colorProviderMixedByAlpha == null) {
            colorProviderMixedByAlpha = colors.getPrimary();
        }
        ColorProvider backgroundColor = circularProgressData.getBackgroundColor();
        ColorProvider colorProviderMixedByAlpha2 = backgroundColor != null ? ColorProvidersKt.mixedByAlpha(backgroundColor, colors.getPrimaryContainer(), composer, 72) : null;
        if (colorProviderMixedByAlpha2 == null) {
            colorProviderMixedByAlpha2 = colors.getPrimaryContainer();
        }
        Pair<ColorProvider, ColorProvider> pair3 = new Pair<>(colorProviderMixedByAlpha, colorProviderMixedByAlpha2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pair3;
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceCircularProgressIndicator(@Nullable GlanceModifier glanceModifier, @NotNull final CircularProgressData data, int i, @Nullable TextData textData, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1581794860);
        if ((i4 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if ((i4 & 4) != 0) {
            i = 0;
        }
        final int i5 = i;
        TextData textData2 = (i4 & 8) != 0 ? null : textData;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1581794860, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceCircularProgressIndicator (ProgressIndicator.kt:222)");
        }
        CircularProgressIndicator(glanceModifier2, data, i5, textData2, composerStartRestartGroup, (i2 & 14) | 4160 | (i2 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextData textData3 = textData2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.GlanceCircularProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    ProgressIndicatorKt.GlanceCircularProgressIndicator(glanceModifier2, data, i5, textData3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceLinearProgressIndicator(@Nullable final GlanceModifier glanceModifier, @NotNull final LinearProgressData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1513011660);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1513011660, i, -1, "androidx.glance.oneui.template.component.glance.GlanceLinearProgressIndicator (ProgressIndicator.kt:66)");
        }
        LinearProgressIndicator(data, glanceModifier, composerStartRestartGroup, ((i << 3) & 112) | 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.GlanceLinearProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    ProgressIndicatorKt.GlanceLinearProgressIndicator(glanceModifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GlanceLinearProgressIndicator-ziNgDLE, reason: not valid java name */
    public static final void m21748GlanceLinearProgressIndicatorziNgDLE(@NotNull final LinearProgressData data, final float f, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2071116235);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2071116235, i, -1, "androidx.glance.oneui.template.component.glance.GlanceLinearProgressIndicator (ProgressIndicator.kt:84)");
        }
        if (C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(0)) > 0) {
            composerStartRestartGroup.startReplaceableGroup(598339333);
            LinearProgressIndicator(data, SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), f), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(598339428);
            GlanceLinearProgressIndicator(data, 0, composerStartRestartGroup, 56, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.GlanceLinearProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ProgressIndicatorKt.m21748GlanceLinearProgressIndicatorziNgDLE(data, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void LinearProgressIndicator(final LinearProgressData linearProgressData, final GlanceModifier glanceModifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-532695326);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-532695326, i, -1, "androidx.glance.oneui.template.component.glance.LinearProgressIndicator (ProgressIndicator.kt:93)");
        }
        Debug.INSTANCE.debugBox(glanceModifier, null, "Progress1", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1876536089, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.LinearProgressIndicator.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                ColorProvider colorProviderMixedByAlpha;
                ColorProvider colorProviderMixedByAlpha2;
                Composer composer3 = composer2;
                if ((i2 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1876536089, i2, -1, "androidx.glance.oneui.template.component.glance.LinearProgressIndicator.<anonymous> (ProgressIndicator.kt:95)");
                }
                if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer3.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
                    composer3.startReplaceableGroup(168479679);
                    Debug debug = Debug.INSTANCE;
                    GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                    float f = 1;
                    GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxSize(companion), C2256Dp.m20968constructorimpl(f), 0.0f, C2256Dp.m20968constructorimpl(f), 0.0f, 10, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    final LinearProgressData linearProgressData2 = linearProgressData;
                    debug.debugBox(glanceModifierM21500paddingqDBjuR0$default, center, "Progress2", false, ComposableLambdaKt.composableLambda(composer3, 342325845, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.LinearProgressIndicator.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer4, int i4) {
                            if ((i4 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(342325845, i4, -1, "androidx.glance.oneui.template.component.glance.LinearProgressIndicator.<anonymous>.<anonymous> (ProgressIndicator.kt:102)");
                            }
                            Debug.INSTANCE.debugBox(CornerRadiusKt.m21286cornerRadius3ABfNKs(BackgroundKt.background(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getPrimaryContainer(), linearProgressData2.getBackgroundColor())), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()), null, "Progress3", false, ComposableSingletons$ProgressIndicatorKt.INSTANCE.m21737getLambda1$glance_oneui_template_release(), composer4, 221568, 10);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (Alignment.$stable << 3) | 221568, 8);
                    composer3 = composer2;
                    LinearProgressIndicatorKt.LinearProgressIndicator(linearProgressData.getValue(), CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifierUtilsKt.maybeAnimation(companion, linearProgressData.getAnimation())), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimary(), linearProgressData.getProgressColor()), ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()), null, composer3, 4608, 16);
                    composer3.endReplaceableGroup();
                } else {
                    composer3.startReplaceableGroup(168480754);
                    if (linearProgressData.getIcon() == null && linearProgressData.getMainText() == null && linearProgressData.getSubText() == null) {
                        composer3.startReplaceableGroup(168481552);
                        if (linearProgressData.getKeepColor()) {
                            composer3.startReplaceableGroup(168481590);
                            ColorProvider progressColor = linearProgressData.getProgressColor();
                            composer3.startReplaceableGroup(168481672);
                            colorProviderMixedByAlpha2 = progressColor == null ? null : ColorProvidersKt.mixedByAlpha(progressColor, GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary(), composer3, 72);
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(168481652);
                            if (colorProviderMixedByAlpha2 == null) {
                                colorProviderMixedByAlpha2 = GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary();
                            }
                            composer3.endReplaceableGroup();
                            ColorProvider backgroundColor = linearProgressData.getBackgroundColor();
                            composer3.startReplaceableGroup(168481859);
                            colorProviderMixedByAlpha = backgroundColor != null ? ColorProvidersKt.mixedByAlpha(backgroundColor, GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimary(), composer3, 72) : null;
                            composer3.endReplaceableGroup();
                            if (colorProviderMixedByAlpha == null) {
                                colorProviderMixedByAlpha = GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimary();
                            }
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(168481981);
                            GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                            int i4 = GlanceTheme.$stable;
                            ColorProvider onPrimary = glanceTheme.getColors(composer3, i4).getOnPrimary();
                            ColorProvider primary = glanceTheme.getColors(composer3, i4).getPrimary();
                            composer3.endReplaceableGroup();
                            colorProviderMixedByAlpha = primary;
                            colorProviderMixedByAlpha2 = onPrimary;
                        }
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(168480933);
                        if (linearProgressData.getKeepColor()) {
                            composer3.startReplaceableGroup(168480971);
                            ColorProvider progressColor2 = linearProgressData.getProgressColor();
                            composer3.startReplaceableGroup(168481053);
                            colorProviderMixedByAlpha2 = progressColor2 == null ? null : ColorProvidersKt.mixedByAlpha(progressColor2, GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimary(), composer3, 72);
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(168481033);
                            if (colorProviderMixedByAlpha2 == null) {
                                colorProviderMixedByAlpha2 = GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimary();
                            }
                            composer3.endReplaceableGroup();
                            ColorProvider backgroundColor2 = linearProgressData.getBackgroundColor();
                            composer3.startReplaceableGroup(168481236);
                            colorProviderMixedByAlpha = backgroundColor2 != null ? ColorProvidersKt.mixedByAlpha(backgroundColor2, GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimaryContainer(), composer3, 72) : null;
                            composer3.endReplaceableGroup();
                            if (colorProviderMixedByAlpha == null) {
                                colorProviderMixedByAlpha = GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getPrimaryContainer();
                            }
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(168481376);
                            GlanceTheme glanceTheme2 = GlanceTheme.INSTANCE;
                            int i5 = GlanceTheme.$stable;
                            ColorProvider primary2 = glanceTheme2.getColors(composer3, i5).getPrimary();
                            ColorProvider primaryContainer = glanceTheme2.getColors(composer3, i5).getPrimaryContainer();
                            composer3.endReplaceableGroup();
                            colorProviderMixedByAlpha = primaryContainer;
                            colorProviderMixedByAlpha2 = primary2;
                        }
                        composer3.endReplaceableGroup();
                    }
                    LinearProgressIndicatorKt.LinearProgressIndicator(linearProgressData.getValue(), AppWidgetModifiersKt.keepColor(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.fillMaxSize(GlanceModifierUtilsKt.maybeAnimation(GlanceModifier.INSTANCE, linearProgressData.getAnimation())), CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()), linearProgressData.getKeepColor()), colorProviderMixedByAlpha2, colorProviderMixedByAlpha, null, composer3, 4608, 16);
                    composer3.endReplaceableGroup();
                }
                if (linearProgressData instanceof CustomLinearProgressData) {
                    composer3.startReplaceableGroup(168482562);
                    LinearProgressData linearProgressData3 = linearProgressData;
                    ((CustomLinearProgressData) linearProgressData3).CustomContent((CustomLinearProgressData) linearProgressData3, composer3, 0);
                    composer3.endReplaceableGroup();
                } else {
                    composer3.startReplaceableGroup(168482616);
                    GlanceModifier glanceModifierM21310marginqDBjuR0$default = MarginKt.m21310marginqDBjuR0$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), linearProgressData.getIcon() != null ? C2256Dp.m20968constructorimpl(5) : C2256Dp.m20968constructorimpl(10), 0.0f, C2256Dp.m20968constructorimpl(10), 0.0f, 10, null);
                    int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                    final LinearProgressData linearProgressData4 = linearProgressData;
                    RowKt.m21502RowlMAjyxE(glanceModifierM21310marginqDBjuR0$default, 0, iM21431getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer3, -1779486406, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.LinearProgressIndicator.1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer4, int i6) {
                            TextData mainText;
                            Composer composer5 = composer4;
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1779486406, i6, -1, "androidx.glance.oneui.template.component.glance.LinearProgressIndicator.<anonymous>.<anonymous> (ProgressIndicator.kt:177)");
                            }
                            ImageData icon = linearProgressData4.getIcon();
                            composer5.startReplaceableGroup(-366036860);
                            if (icon != null) {
                                composer5.startReplaceableGroup(-366036762);
                                if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer5.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
                                    ColorProvider imageTintColor = icon.getImageTintColor();
                                    if (imageTintColor == null) {
                                        imageTintColor = GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnPrimary();
                                    }
                                    icon.setImageTintColor$glance_oneui_template_release(imageTintColor);
                                }
                                composer5.endReplaceableGroup();
                                ImageKt.m21747GlanceImageziNgDLE(icon, AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer5.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0 ? CommonDimensions.INSTANCE.m21774getDefaultIconSizeD9Ej5fM() : C2256Dp.m20968constructorimpl(14), composer5, 8);
                                Unit unit = Unit.INSTANCE;
                            }
                            composer5.endReplaceableGroup();
                            composer5.startReplaceableGroup(-366036218);
                            if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer5.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) >= 0 && (mainText = linearProgressData4.getMainText()) != null) {
                                ImageData icon2 = linearProgressData4.getIcon();
                                composer5.startReplaceableGroup(-366036088);
                                if (icon2 != null) {
                                    SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(6)), composer5, 0, 0);
                                }
                                composer5.endReplaceableGroup();
                                LinearGraphLayoutKt.m21840GlanceGraphTextlL68QWg(mainText, TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnPrimaryContainer(), null, composer4, 568, 8);
                                composer5 = composer4;
                            }
                            composer5.endReplaceableGroup();
                            SpacerKt.Spacer(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.m21505height3ABfNKs(Row.defaultWeight(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(1)), 0.0f, 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 11, null), composer5, 0, 0);
                            TextData subText = linearProgressData4.getSubText();
                            if (subText != null) {
                                LinearGraphLayoutKt.m21840GlanceGraphTextlL68QWg(subText, TextType.INSTANCE.m21693getLabelgxbDmow(), GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnPrimaryContainer(), null, composer5, 568, 8);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, ((i >> 3) & 14) | 221568, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.LinearProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ProgressIndicatorKt.LinearProgressIndicator(linearProgressData, glanceModifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void GlanceLinearProgressIndicator(@NotNull final LinearProgressData data, final int i, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-124971944);
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-124971944, i2, -1, "androidx.glance.oneui.template.component.glance.GlanceLinearProgressIndicator (ProgressIndicator.kt:71)");
        }
        if (i != 0) {
            composerStartRestartGroup.startReplaceableGroup(598338910);
            LinearProgressIndicator(data, SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), i), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(598339010);
            LinearProgressIndicator(data, SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0 ? 20 : 26)), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.GlanceLinearProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    ProgressIndicatorKt.GlanceLinearProgressIndicator(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "Use GlanceCircularProgressIndicator(GlanceModifier, CircularProgressData) instead")
    @Composable
    public static final void GlanceCircularProgressIndicator(@NotNull final CircularProgressData data, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(2040446887);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2040446887, i, -1, "androidx.glance.oneui.template.component.glance.GlanceCircularProgressIndicator (ProgressIndicator.kt:233)");
        }
        CircularProgressIndicator(SizeModifiersKt.size(GlanceModifier.INSTANCE, GridLayoutDimensions.INSTANCE.itemResIds(false, 0, composerStartRestartGroup, 384, 3).getSize()), data, 0, null, composerStartRestartGroup, 64, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.glance.ProgressIndicatorKt.GlanceCircularProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ProgressIndicatorKt.GlanceCircularProgressIndicator(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
