package androidx.glance.oneui.template.layout.compose;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceTheme;
import androidx.glance.action.Action;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.color.ColorProviders;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.BadgeData;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.GridItem;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.ProgressGridItem;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.color.ColorProviderUtils;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.compose.ImageKt;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.compose.TextKt;
import androidx.glance.oneui.template.layout.GridLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.layout.glance.GridMapManager;
import androidx.glance.oneui.template.size.GridTemplateDp;
import androidx.glance.oneui.template.size.GridTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¢\u0006\u0002\u0010\t\u001a,\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a/\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001aX\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001aH\u0010&\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010'\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020)H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a,\u0010,\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a9\u0010/\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001601H\u0003¢\u0006\u0002\u00102\u001a-\u00103\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00104\u001a\u000205H\u0003¢\u0006\u0002\u00106\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, m13886d2 = {"Badge", "", "badge", "Landroidx/glance/oneui/template/BadgeData;", "(Landroidx/glance/oneui/template/BadgeData;Landroidx/compose/runtime/Composer;I)V", "ComposeGridLayout", "items", "", "Landroidx/glance/oneui/template/GridItem;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "ComposeGridText", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "modifier", "Landroidx/compose/ui/Modifier;", "ComposeGridText-2FzTWkw", "(Landroidx/glance/oneui/template/TextData;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GridItemContainer", "gridItem", "gridCount", "", "gridPosition", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/GridItem;IILandroidx/compose/runtime/Composer;II)V", "GridItemContent", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "imageData", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "showLabel", "", "textOverlapped", "badgeData", "onClick", "Landroidx/glance/action/Action;", "GridItemContent-sPTUXxQ", "(IILandroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/TextData;ZZLandroidx/glance/oneui/template/BadgeData;Landroidx/glance/action/Action;Landroidx/compose/runtime/Composer;I)V", "GridItemIcon", "hasCornerRadius", "padding", "Landroidx/compose/ui/unit/Dp;", "GridItemIcon-HYR8e34", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/BadgeData;ZZFLandroidx/compose/runtime/Composer;II)V", "GridItemText", "GridItemText-ium9O2g", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/TextData;ILandroidx/compose/runtime/Composer;II)V", "GridMap", "map", "Lkotlin/Pair;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/Pair;Landroidx/compose/runtime/Composer;II)V", "GridRow", Bixby2Constants.BIXBY_PARAM_RANGE, "Lkotlin/ranges/IntRange;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/ranges/IntRange;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGridLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GridLayout.kt\nandroidx/glance/oneui/template/layout/compose/GridLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 9 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 10 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,390:1\n74#2:391\n76#2:398\n76#2:436\n76#2:474\n74#2:505\n76#2:512\n74#2:543\n74#2:544\n76#2:556\n76#2:593\n76#2:634\n74#2:668\n76#2:686\n76#2:718\n76#2:759\n68#3,5:392\n73#3:423\n77#3:428\n68#3,5:506\n73#3:537\n77#3:542\n67#3,6:549\n73#3:581\n77#3:586\n68#3,5:587\n73#3:618\n77#3:623\n68#3,5:628\n73#3:659\n77#3:666\n67#3,6:679\n73#3:711\n68#3,5:712\n73#3:743\n77#3:752\n68#3,5:753\n73#3:784\n77#3:789\n77#3:794\n75#4:397\n76#4,11:399\n89#4:427\n75#4:435\n76#4,11:437\n89#4:465\n75#4:473\n76#4,11:475\n89#4:503\n75#4:511\n76#4,11:513\n89#4:541\n75#4:555\n76#4,11:557\n89#4:585\n75#4:592\n76#4,11:594\n89#4:622\n75#4:633\n76#4,11:635\n89#4:665\n75#4:685\n76#4,11:687\n75#4:717\n76#4,11:719\n89#4:751\n75#4:758\n76#4,11:760\n89#4:788\n89#4:793\n460#5,13:410\n473#5,3:424\n460#5,13:448\n473#5,3:462\n460#5,13:486\n473#5,3:500\n460#5,13:524\n473#5,3:538\n460#5,13:568\n473#5,3:582\n460#5,13:605\n473#5,3:619\n460#5,13:646\n473#5,3:662\n460#5,13:698\n460#5,13:730\n473#5,3:748\n460#5,13:771\n473#5,3:785\n473#5,3:790\n74#6,6:429\n80#6:461\n84#6:466\n75#7,6:467\n81#7:499\n85#7:504\n189#8:545\n174#8:546\n174#8:547\n154#8:548\n154#8:624\n154#8:625\n164#8:626\n154#8:627\n154#8:660\n164#8:661\n154#8:667\n154#8:670\n154#8:672\n154#8:674\n154#8:675\n154#8:676\n154#8:677\n154#8:745\n154#8:747\n75#9:669\n75#9:671\n51#9:678\n75#9:744\n75#9:746\n1#10:673\n*S KotlinDebug\n*F\n+ 1 GridLayout.kt\nandroidx/glance/oneui/template/layout/compose/GridLayoutKt\n*L\n75#1:391\n79#1:398\n92#1:436\n107#1:474\n132#1:505\n149#1:512\n184#1:543\n185#1:544\n291#1:556\n315#1:593\n324#1:634\n383#1:668\n245#1:686\n246#1:718\n263#1:759\n79#1:392,5\n79#1:423\n79#1:428\n149#1:506,5\n149#1:537\n149#1:542\n291#1:549,6\n291#1:581\n291#1:586\n315#1:587,5\n315#1:618\n315#1:623\n324#1:628,5\n324#1:659\n324#1:666\n245#1:679,6\n245#1:711\n246#1:712,5\n246#1:743\n246#1:752\n263#1:753,5\n263#1:784\n263#1:789\n245#1:794\n79#1:397\n79#1:399,11\n79#1:427\n92#1:435\n92#1:437,11\n92#1:465\n107#1:473\n107#1:475,11\n107#1:503\n149#1:511\n149#1:513,11\n149#1:541\n291#1:555\n291#1:557,11\n291#1:585\n315#1:592\n315#1:594,11\n315#1:622\n324#1:633\n324#1:635,11\n324#1:665\n245#1:685\n245#1:687,11\n246#1:717\n246#1:719,11\n246#1:751\n263#1:758\n263#1:760,11\n263#1:788\n245#1:793\n79#1:410,13\n79#1:424,3\n92#1:448,13\n92#1:462,3\n107#1:486,13\n107#1:500,3\n149#1:524,13\n149#1:538,3\n291#1:568,13\n291#1:582,3\n315#1:605,13\n315#1:619,3\n324#1:646,13\n324#1:662,3\n245#1:698,13\n246#1:730,13\n246#1:748,3\n263#1:771,13\n263#1:785,3\n245#1:790,3\n92#1:429,6\n92#1:461\n92#1:466\n107#1:467,6\n107#1:499\n107#1:504\n198#1:545\n203#1:546\n204#1:547\n288#1:548\n322#1:624\n327#1:625\n328#1:626\n329#1:627\n334#1:660\n337#1:661\n374#1:667\n214#1:670\n221#1:672\n237#1:674\n238#1:675\n240#1:676\n242#1:677\n252#1:745\n258#1:747\n214#1:669\n221#1:671\n245#1:678\n252#1:744\n258#1:746\n*E\n"})
public final class GridLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Badge(final BadgeData badgeData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(289501097);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(289501097, i, -1, "androidx.glance.oneui.template.layout.compose.Badge (GridLayout.kt:318)");
        }
        long jConvert = ComposeUtilsKt.convert(ColorProvidersKt.override(ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294266131L)), badgeData.getBackgroundColor()), composerStartRestartGroup, 8);
        if (badgeData.getCollapsed()) {
            composerStartRestartGroup.startReplaceableGroup(2070523463);
            SpacerKt.Spacer(BackgroundKt.m15408backgroundbw27NRU(SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(6)), jConvert, RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.m16129CornerSize0680j_4(C2256Dp.m20968constructorimpl(3)))), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(2070523573);
            Modifier.Companion companion = Modifier.INSTANCE;
            float f = 17;
            Modifier modifierM15884defaultMinSizeVpY3zN4$default = SizeKt.m15884defaultMinSizeVpY3zN4$default(BackgroundKt.m15408backgroundbw27NRU(SizeKt.m15885height3ABfNKs(SizeKt.wrapContentWidth$default(companion, null, false, 3, null), C2256Dp.m20968constructorimpl(f)), jConvert, RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.m16129CornerSize0680j_4(C2256Dp.m20968constructorimpl((float) 8.5d)))), C2256Dp.m20968constructorimpl(f), 0.0f, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15884defaultMinSizeVpY3zN4$default);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            TextKt.m21730ComposeTextFbLeKfk(new TextData(badgeData.getText(), (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null), C2256Dp.m20968constructorimpl(12), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), ColorProvidersKt.override(ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4294769916L)), badgeData.getTextColor()), PaddingKt.m15856paddingVpY3zN4$default(companion, C2256Dp.m20968constructorimpl((float) 1.5d), 0.0f, 2, null), composerStartRestartGroup, 28728, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt.Badge.2
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
                    GridLayoutKt.Badge(badgeData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeGridLayout(@NotNull final List<? extends GridItem> items, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        Composer composerStartRestartGroup = composer.startRestartGroup(1200863393);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1200863393, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeGridLayout (GridLayout.kt:71)");
        }
        if (items.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt.ComposeGridLayout.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i2) {
                        GridLayoutKt.ComposeGridLayout(items, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        float fM21837getGridContainerHorizontalPaddingR2GYfMI = androidx.glance.oneui.template.layout.glance.GridLayoutKt.m21837getGridContainerHorizontalPaddingR2GYfMI(mask, composerStartRestartGroup, 0);
        float fM21838getGridContainerVerticalPaddingR2GYfMI = androidx.glance.oneui.template.layout.glance.GridLayoutKt.m21838getGridContainerVerticalPaddingR2GYfMI(mask, composerStartRestartGroup, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ComposeModifierUtilsKt.m21956padding6PoWaU8(companion, fM21837getGridContainerHorizontalPaddingR2GYfMI, fM21838getGridContainerVerticalPaddingR2GYfMI, 0.0f, 0.0f, composerStartRestartGroup, 6, 12), 0.0f, 1, null);
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        GridMap(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), items, GridMapManager.INSTANCE.m21839getGridMapnXd0AQQ(mask, items.size(), items.get(0), composerStartRestartGroup, 3584), composerStartRestartGroup, 70, 0);
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt.ComposeGridLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    GridLayoutKt.ComposeGridLayout(items, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeGridText-2FzTWkw, reason: not valid java name */
    public static final void m21792ComposeGridText2FzTWkw(final TextData textData, final int i, Modifier modifier, Composer composer, final int i2, final int i4) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-362193913);
        if ((i4 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-362193913, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeGridText (GridLayout.kt:343)");
        }
        if (TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21689getBodygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(-362484162);
            TextKt.ComposeText(textData, GridLayoutTextSizes.INSTANCE.getBodyText(composerStartRestartGroup, 6), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface(), textData.getTextColor()), modifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 << 3) & 7168), 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-362483938);
            TextKt.ComposeText(textData, GridLayoutTextSizes.INSTANCE.getLabelText(), ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground(), textData.getTextColor()), modifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 << 3) & 7168), 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt$ComposeGridText$1
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
                    GridLayoutKt.m21792ComposeGridText2FzTWkw(textData, i, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GridItemContainer(@Nullable Modifier modifier, @NotNull final GridItem gridItem, final int i, final int i2, @Nullable Composer composer, final int i4, final int i5) {
        Intrinsics.checkNotNullParameter(gridItem, "gridItem");
        Composer composerStartRestartGroup = composer.startRestartGroup(542050933);
        Modifier modifier2 = (i5 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(542050933, i4, -1, "androidx.glance.oneui.template.layout.compose.GridItemContainer (GridLayout.kt:130)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        TextData text = gridItem.getText();
        ImageWithBackgroundData image = gridItem.getImage();
        Action onClick = gridItem.getOnClick();
        boolean textOverlapped = gridItem.getTextOverlapped();
        boolean z = gridItem instanceof ProgressGridItem;
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        final Modifier modifier3 = modifier2;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(-1102004200);
            ProgressGridItem progressGridItem = (ProgressGridItem) gridItem;
            ProgressIndicatorKt.ComposeCircularProgressIndicator(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), progressGridItem.getProgress(), i2, progressGridItem.getText(), composerStartRestartGroup, ((i4 >> 3) & 896) | 4166, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1102003875);
            m21793GridItemContentsPTUXxQ(mask, i, image, text, GridItemContainer$isShowLabel(text, z, mask, i), textOverlapped, gridItem.getBadge(), onClick, composerStartRestartGroup, ((i4 >> 3) & 112) | 18878976);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt.GridItemContainer.2
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
                    GridLayoutKt.GridItemContainer(modifier3, gridItem, i, i2, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    private static final boolean GridItemContainer$isShowLabel(TextData textData, boolean z, int i, int i2) {
        if (textData != null) {
            if (z) {
                AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                return AppWidgetSize.m21546compareToL2j3NV4(i, companion.m21568getLargerx25Pp4()) > 0 || (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4()) && i2 == 4);
            }
            if (AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: GridItemContent-sPTUXxQ, reason: not valid java name */
    public static final void m21793GridItemContentsPTUXxQ(final int i, final int i2, final ImageWithBackgroundData imageWithBackgroundData, final TextData textData, final boolean z, final boolean z2, final BadgeData badgeData, final Action action, Composer composer, final int i4) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1001331435);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1001331435, i4, -1, "androidx.glance.oneui.template.layout.compose.GridItemContent (GridLayout.kt:182)");
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue();
        ImageType imageType = imageWithBackgroundData.getImageType();
        float fM21951getMaxIconSizexeG5q6M = GridTemplateDp.INSTANCE.m21951getMaxIconSizexeG5q6M(context, i, z, i2);
        Pair<Float, Float> pairM21952getIconSizePercentnXd0AQQ = GridTemplatePercent.INSTANCE.m21952getIconSizePercentnXd0AQQ(i, i2, z, composerStartRestartGroup, ((i4 >> 6) & 896) | (i4 & 14) | 3072 | (i4 & 112));
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(Math.min(DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21952getIconSizePercentnXd0AQQ.getFirst().floatValue(), pairM21952getIconSizePercentnXd0AQQ.getSecond().floatValue(), fM21951getMaxIconSizexeG5q6M, fM21951getMaxIconSizexeG5q6M, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24576, 0)), fM21951getMaxIconSizexeG5q6M));
        TextType.Companion companion = TextType.INSTANCE;
        int iM21693getLabelgxbDmow = z ? companion.m21693getLabelgxbDmow() : companion.m21689getBodygxbDmow();
        int i5 = (AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) < 0 || i2 > 4) ? 1 : 2;
        float fM20968constructorimpl2 = i5 == 1 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_text_view_height)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_text_view_height_over_2_line));
        BadgeData badgeData2 = badgeData == null ? new BadgeData("", true, null, ColorProviderUtils.INSTANCE.getTransparent(), false, 20, null) : badgeData;
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(2033397562);
            composer2 = composerStartRestartGroup;
            GridItemContent_sPTUXxQ$GridItemContentWithLabel(i, i2, fM20968constructorimpl, fM20968constructorimpl2, imageType, imageWithBackgroundData, badgeData2, textData, iM21693getLabelgxbDmow, i5, composer2, 0);
        } else {
            composerStartRestartGroup.startReplaceableGroup(2033397594);
            composer2 = composerStartRestartGroup;
            GridItemContent_sPTUXxQ$GridItemContent(fM20968constructorimpl, imageType, imageWithBackgroundData, badgeData2, z2, i, textData, fM20968constructorimpl2, iM21693getLabelgxbDmow, i5, composer2, 0);
        }
        Composer composer3 = composer2;
        composer3.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt$GridItemContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer4, int i6) {
                    GridLayoutKt.m21793GridItemContentsPTUXxQ(i, i2, imageWithBackgroundData, textData, z, z2, badgeData, action, composer4, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void GridItemContent_sPTUXxQ$GridItemContent(float f, ImageType imageType, ImageWithBackgroundData imageWithBackgroundData, BadgeData badgeData, boolean z, int i, TextData textData, float f4, int i2, int i4, Composer composer, int i5) {
        composer.startReplaceableGroup(-1879793667);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1879793667, i5, -1, "androidx.glance.oneui.template.layout.compose.GridItemContent.GridItemContent (GridLayout.kt:207)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(companion, f);
        ImageType imageType2 = ImageType.AppIcon;
        m21794GridItemIconHYR8e34(ClipKt.clip(modifierM15899size3ABfNKs, RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(imageType != imageType2 ? C2256Dp.m20968constructorimpl(f / 2) : C2256Dp.m20968constructorimpl(0))), imageWithBackgroundData, badgeData, z && AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0, imageType != imageType2, imageType == ImageType.Icon ? C2256Dp.m20968constructorimpl(f / 5) : C2256Dp.m20968constructorimpl(0), composer, Units.MASTER_DPI, 0);
        if (z && textData != null && imageType != imageType2) {
            Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(companion, f), f4);
            textData.setMaxLines$glance_oneui_template_release(i4);
            m21795GridItemTextium9O2g(modifierM15885height3ABfNKs, textData, i2, composer, 64, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x029d  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void GridItemContent_sPTUXxQ$GridItemContentWithLabel(int i, int i2, float f, float f4, ImageType imageType, ImageWithBackgroundData imageWithBackgroundData, BadgeData badgeData, TextData textData, int i4, int i5, Composer composer, int i6) {
        float fM20968constructorimpl;
        float f5;
        float f6;
        composer.startReplaceableGroup(-1917035705);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1917035705, i6, -1, "androidx.glance.oneui.template.layout.compose.GridItemContent.GridItemContentWithLabel (GridLayout.kt:233)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4())) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(2);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4())) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(i2 <= 4 ? 4 : 2);
        } else {
            fM20968constructorimpl = AppWidgetSize.m21550equalsimpl0(i, companion.m21566getExtraLargerx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21567getExtraLargeLongrx25Pp4()) ? C2256Dp.m20968constructorimpl(4) : C2256Dp.m20968constructorimpl(0);
        }
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(fM20968constructorimpl + f) + f4));
        composer.startReplaceableGroup(733328855);
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composer, 0, -1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15885height3ABfNKs);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
        Alignment topCenter = companion3.getTopCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topCenter, false, composer, 6);
        Density density2 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxSize$default);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(companion2, f);
        ImageType imageType2 = ImageType.AppIcon;
        m21794GridItemIconHYR8e34(ClipKt.clip(modifierM15899size3ABfNKs, RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(imageType != imageType2 ? C2256Dp.m20968constructorimpl(f / 2) : C2256Dp.m20968constructorimpl(0))), imageWithBackgroundData, badgeData, false, imageType != imageType2, imageType == ImageType.Icon ? C2256Dp.m20968constructorimpl(f / 5) : C2256Dp.m20968constructorimpl(0), composer, Units.MASTER_DPI, 8);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4())) {
            f6 = 0.03f;
        } else {
            if (AppWidgetSize.m21546compareToL2j3NV4(i, companion.m21569getMediumrx25Pp4()) < 0) {
                f5 = 0.0f;
                Modifier modifierM21958paddings2pLCVw = ComposeModifierUtilsKt.m21958paddings2pLCVw(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), f5, 0.0f, f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer, 6, 250);
                Alignment bottomCenter = companion3.getBottomCenter();
                composer.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer, 6);
                Density density3 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
                LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM21958paddings2pLCVw);
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.useNode();
                } else {
                    composer.createNode(constructor3);
                }
                composer.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
                composer.startReplaceableGroup(2058660585);
                Modifier modifierM15885height3ABfNKs2 = SizeKt.m15885height3ABfNKs(companion2, f4);
                Intrinsics.checkNotNull(textData);
                textData.setMaxLines$glance_oneui_template_release(i5);
                m21795GridItemTextium9O2g(modifierM15885height3ABfNKs2, textData, i4, composer, 64, 0);
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
            }
            f6 = 0.02f;
        }
        f5 = f6;
        Modifier modifierM21958paddings2pLCVw2 = ComposeModifierUtilsKt.m21958paddings2pLCVw(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), f5, 0.0f, f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer, 6, 250);
        Alignment bottomCenter2 = companion3.getBottomCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(bottomCenter2, false, composer, 6);
        Density density32 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection32 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration32 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor32 = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf32 = LayoutKt.materializerOf(modifierM21958paddings2pLCVw2);
        if (composer.getApplier() == null) {
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl32 = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl32, layoutDirection32, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl32, measurePolicyRememberBoxMeasurePolicy22, composerM18018constructorimpl32, density32));
        function3MaterializerOf32.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl32, viewConfiguration32, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        Modifier modifierM15885height3ABfNKs22 = SizeKt.m15885height3ABfNKs(companion2, f4);
        Intrinsics.checkNotNull(textData);
        textData.setMaxLines$glance_oneui_template_release(i5);
        m21795GridItemTextium9O2g(modifierM15885height3ABfNKs22, textData, i4, composer, 64, 0);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GridItemIcon-HYR8e34, reason: not valid java name */
    public static final void m21794GridItemIconHYR8e34(final Modifier modifier, final ImageWithBackgroundData imageWithBackgroundData, final BadgeData badgeData, boolean z, boolean z2, float f, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-263323902);
        final boolean z3 = (i2 & 8) != 0 ? false : z;
        boolean z4 = (i2 & 16) != 0 ? false : z2;
        final float fM20968constructorimpl = (i2 & 32) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-263323902, i, -1, "androidx.glance.oneui.template.layout.compose.GridItemIcon (GridLayout.kt:288)");
        }
        ImageType imageType = imageWithBackgroundData.getImageType();
        composerStartRestartGroup.startReplaceableGroup(1623715910);
        Modifier modifierM15409backgroundbw27NRU$default = imageType != ImageType.Icon ? modifier : BackgroundKt.m15409backgroundbw27NRU$default(modifier, ComposeUtilsKt.convert(ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface(), imageWithBackgroundData.getBackgroundColor()), composerStartRestartGroup, 8), null, 2, null);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15409backgroundbw27NRU$default);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        int i4 = (i >> 3) & 7168;
        ImageKt.ComposeImage(imageWithBackgroundData, PaddingKt.m15854padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM20968constructorimpl), null, z4, composerStartRestartGroup, i4 | 8, 4);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(1623716308);
        if (z3 && imageWithBackgroundData.getImageType() != ImageType.AppIcon) {
            ImageKt.ComposeImage(new ImageData(androidx.glance.ImageKt.ImageProvider(C3094R.color.sesl_glance_text_overlapped_icon_dim), null, null, null, null, false, 62, null), modifier, null, z4, composerStartRestartGroup, ((i << 3) & 112) | 8 | i4, 4);
        }
        composerStartRestartGroup.endReplaceableGroup();
        Alignment topEnd = companion.getTopEnd();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topEnd, false, composerStartRestartGroup, 6);
        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor2);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        Badge(badgeData, composerStartRestartGroup, 8);
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z5 = z4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt$GridItemIcon$3
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
                    GridLayoutKt.m21794GridItemIconHYR8e34(modifier, imageWithBackgroundData, badgeData, z3, z5, fM20968constructorimpl, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: GridItemText-ium9O2g, reason: not valid java name */
    public static final void m21795GridItemTextium9O2g(Modifier modifier, final TextData textData, final int i, Composer composer, int i2, final int i4) {
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1498254890);
        Modifier modifier2 = (i4 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i5 = i2;
            ComposerKt.traceEventStart(1498254890, i5, -1, "androidx.glance.oneui.template.layout.compose.GridItemText (GridLayout.kt:362)");
        } else {
            i5 = i2;
        }
        ColorProviders colors = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable);
        int iGridItemText_ium9O2g$getFontStyle = GridItemText_ium9O2g$getFontStyle(i);
        ColorProvider colorProviderOverride = TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21689getBodygxbDmow()) ? ColorProvidersKt.override(colors.getOnSurface(), textData.getTextColor()) : ColorProvidersKt.override(colors.getOnBackground(), textData.getTextColor());
        Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(modifier2, C2256Dp.m20968constructorimpl(1), 0.0f, 2, null);
        textData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig());
        TextKt.ComposeText(textData, new TextSize((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), C3094R.dimen.sesl_glance_grid_item_text_size, ComplexUnit.f1613DP, iGridItemText_ium9O2g$getFontStyle, 0.0f, 16, (DefaultConstructorMarker) null), colorProviderOverride, modifierM15856paddingVpY3zN4$default, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final int i6 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt$GridItemText$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    GridLayoutKt.m21795GridItemTextium9O2g(modifier3, textData, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i4);
                }
            });
        }
    }

    private static final int GridItemText_ium9O2g$getFontStyle(int i) {
        return TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21693getLabelgxbDmow()) ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GridMap(Modifier modifier, final List<? extends GridItem> list, final Pair<Integer, Integer> pair, Composer composer, int i, final int i2) {
        final int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1702999138);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(1702999138, i4, -1, "androidx.glance.oneui.template.layout.compose.GridMap (GridLayout.kt:88)");
        } else {
            i4 = i;
        }
        int iIntValue = pair.getFirst().intValue();
        int iIntValue2 = pair.getSecond().intValue();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-637128825);
        for (int i5 = 0; i5 < iIntValue2; i5++) {
            int i6 = i5 * iIntValue;
            GridRow(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), list, RangesKt.until(i6, i6 + iIntValue), composerStartRestartGroup, Units.MASTER_DPI, 0);
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt.GridMap.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    GridLayoutKt.GridMap(modifier3, list, pair, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GridRow(Modifier modifier, final List<? extends GridItem> list, final IntRange intRange, Composer composer, int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-835637800);
        final Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(-835637800, i4, -1, "androidx.glance.oneui.template.layout.compose.GridRow (GridLayout.kt:104)");
        } else {
            i4 = i;
        }
        int size = list.size();
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        composerStartRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composerStartRestartGroup, 48, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-636965728);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            int i5 = first;
            while (true) {
                GridItemContainer(RowScope.weight$default(rowScopeInstance, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), i5 < size ? list.get(i5) : list.get(0).getText() != null ? androidx.glance.oneui.template.layout.glance.GridLayoutKt.getEmptyLabelGridItem() : androidx.glance.oneui.template.layout.glance.GridLayoutKt.getEmptyGridItem(), size, i5, composerStartRestartGroup, 64, 0);
                if (i5 == last) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i6 = i4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.GridLayoutKt.GridRow.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    GridLayoutKt.GridRow(modifier2, list, intRange, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i2);
                }
            });
        }
    }
}
