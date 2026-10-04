package androidx.glance.oneui.template.component.compose;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ActionButtonData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.layout.TitleBarTextSizes;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a;\u0010\r\u001a\u00020\u0001*\u00020\u00102\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"TitleBarText", "", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "modifier", "Landroidx/compose/ui/Modifier;", "TitleBarText-2FzTWkw", "(Landroidx/glance/oneui/template/TextData;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "isSmallTablet", "", "(Landroidx/compose/runtime/Composer;I)Z", "ComposeContent", "Landroidx/glance/oneui/template/ActionButtonData;", "(Landroidx/glance/oneui/template/ActionButtonData;Landroidx/compose/runtime/Composer;I)V", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionContent", "(Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTitleBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TitleBar.kt\nandroidx/glance/oneui/template/component/compose/TitleBarKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n*L\n1#1,165:1\n74#2:166\n74#2:167\n76#2:179\n76#2:214\n76#2:259\n76#2:302\n76#2:336\n154#3:168\n154#3:169\n154#3:170\n154#3:171\n154#3:205\n154#3:206\n154#3:240\n154#3:241\n154#3:243\n154#3:249\n154#3:250\n154#3:251\n154#3:295\n154#3:328\n154#3:367\n75#4,6:172\n81#4:204\n75#4,6:252\n81#4:284\n85#4:289\n85#4:294\n75#5:178\n76#5,11:180\n75#5:213\n76#5,11:215\n89#5:247\n75#5:258\n76#5,11:260\n89#5:288\n89#5:293\n75#5:301\n76#5,11:303\n75#5:335\n76#5,11:337\n89#5:365\n89#5:371\n460#6,13:191\n460#6,13:226\n473#6,3:244\n460#6,13:271\n473#6,3:285\n473#6,3:290\n460#6,13:314\n460#6,13:348\n473#6,3:362\n473#6,3:368\n74#7,6:207\n80#7:239\n84#7:248\n1#8:242\n68#9,5:296\n73#9:327\n67#9,6:329\n73#9:361\n77#9:366\n77#9:372\n*S KotlinDebug\n*F\n+ 1 TitleBar.kt\nandroidx/glance/oneui/template/component/compose/TitleBarKt\n*L\n44#1:166\n55#1:167\n70#1:179\n75#1:214\n114#1:259\n124#1:302\n128#1:336\n59#1:168\n62#1:169\n64#1:170\n66#1:171\n81#1:205\n83#1:206\n93#1:240\n95#1:241\n103#1:243\n108#1:249\n112#1:250\n114#1:251\n125#1:295\n129#1:328\n141#1:367\n70#1:172,6\n70#1:204\n114#1:252,6\n114#1:284\n114#1:289\n70#1:294\n70#1:178\n70#1:180,11\n75#1:213\n75#1:215,11\n75#1:247\n114#1:258\n114#1:260,11\n114#1:288\n70#1:293\n124#1:301\n124#1:303,11\n128#1:335\n128#1:337,11\n128#1:365\n124#1:371\n70#1:191,13\n75#1:226,13\n75#1:244,3\n114#1:271,13\n114#1:285,3\n70#1:290,3\n124#1:314,13\n128#1:348,13\n128#1:362,3\n124#1:368,3\n75#1:207,6\n75#1:239\n75#1:248\n124#1:296,5\n124#1:327\n128#1:329,6\n128#1:361\n128#1:366\n124#1:372\n*E\n"})
public final class TitleBarKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void ComposeContent(@NotNull final TitleBarData titleBarData, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, final int i) {
        boolean z;
        float fM20968constructorimpl;
        Intrinsics.checkNotNullParameter(titleBarData, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(280211651);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(280211651, i, -1, "androidx.glance.oneui.template.component.compose.ComposeContent (TitleBar.kt:51)");
        }
        if (!titleBarData.getShowTitleBar(composerStartRestartGroup, 8)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TitleBarKt.ComposeContent.1
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
                        TitleBarKt.ComposeContent(titleBarData, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        boolean zM21550equalsimpl0 = AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4());
        Modifier.Companion companion = Modifier.INSTANCE;
        float f = 16;
        Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(f), 0.0f, function22 != null ? C2256Dp.m20968constructorimpl(0) : (titleBarData.getActionButton1() == null && titleBarData.getActionButton2() == null) ? C2256Dp.m20968constructorimpl(f) : C2256Dp.m20968constructorimpl(10), 0.0f, 10, null);
        Modifier modifierFillMaxHeight$default = zM21550equalsimpl0 ? SizeKt.fillMaxHeight$default(modifierM15858paddingqDBjuR0$default, 0.0f, 1, null) : SizeKt.wrapContentHeight$default(modifierM15858paddingqDBjuR0$default, null, false, 3, null);
        Alignment.Companion companion2 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = zM21550equalsimpl0 ? companion2.getCenterVertically() : companion2.getTop();
        composerStartRestartGroup.startReplaceableGroup(693286680);
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(arrangement, centerVertically, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxHeight$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), null, false, 3, null);
        composerStartRestartGroup.startReplaceableGroup(2098146201);
        float fM20968constructorimpl2 = zM21550equalsimpl0 ? C2256Dp.m20968constructorimpl(0) : isSmallTablet(composerStartRestartGroup, 0) ? C2256Dp.m20968constructorimpl(8) : CommonDimensions.INSTANCE.m21776getLayoutVerticalPaddingD9Ej5fM();
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(modifierWrapContentHeight$default, 0.0f, fM20968constructorimpl2, 0.0f, 0.0f, 13, null);
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion4 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion4, top, composerStartRestartGroup, 0, -1323940314);
        Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
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
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TextData title = titleBarData.getTitle();
        TextType.Companion companion5 = TextType.INSTANCE;
        int iM21694getTitlegxbDmow = companion5.m21694getTitlegxbDmow();
        if (titleBarData.getSubtitle() == null && function2 == null && !zM21550equalsimpl0) {
            z = true;
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(titleBarData.getTitle().getMaxLines() > 1 ? 2 : 12);
        } else {
            z = true;
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
        }
        m21735TitleBarText2FzTWkw(title, iM21694getTitlegxbDmow, PaddingKt.m15858paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, fM20968constructorimpl, 7, null), composerStartRestartGroup, 56, 0);
        if (function2 != null) {
            composerStartRestartGroup.startReplaceableGroup(-766132898);
            AbstractC1038a.m1198C(composerStartRestartGroup, (i >> 3) & 14, function2);
        } else {
            composerStartRestartGroup.startReplaceableGroup(-766132843);
            TextData subtitle = titleBarData.getSubtitle();
            if (subtitle != null) {
                m21735TitleBarText2FzTWkw(subtitle, companion5.m21689getBodygxbDmow(), PaddingKt.m15856paddingVpY3zN4$default(companion, 0.0f, C2256Dp.m20968constructorimpl(2), 1, null), composerStartRestartGroup, 440, 0);
                Unit unit = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (function22 != null) {
            composerStartRestartGroup.startReplaceableGroup(2098147095);
            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(6)), composerStartRestartGroup, 6);
            AbstractC1038a.m1198C(composerStartRestartGroup, (i >> 6) & 14, function22);
        } else if (titleBarData.getActionButton1() == null && titleBarData.getActionButton2() == null) {
            composerStartRestartGroup.startReplaceableGroup(2098147511);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(2098147270);
            SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, C2256Dp.m20968constructorimpl(2)), composerStartRestartGroup, 6);
            Modifier modifierM15858paddingqDBjuR0$default3 = PaddingKt.m15858paddingqDBjuR0$default(companion, 0.0f, C2256Dp.m20968constructorimpl(10), 0.0f, 0.0f, 13, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion4, arrangement.getStart(), composerStartRestartGroup, 0, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default3);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1208i, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ActionButtonData actionButton1 = titleBarData.getActionButton1();
            composerStartRestartGroup.startReplaceableGroup(-766132352);
            if (actionButton1 != null) {
                ComposeContent(actionButton1, composerStartRestartGroup, 0);
                Unit unit2 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            ActionButtonData actionButton2 = titleBarData.getActionButton2();
            composerStartRestartGroup.startReplaceableGroup(2098147471);
            if (actionButton2 != null) {
                ComposeContent(actionButton2, composerStartRestartGroup, 0);
                Unit unit3 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TitleBarKt.ComposeContent.3
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
                    TitleBarKt.ComposeContent(titleBarData, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: TitleBarText-2FzTWkw, reason: not valid java name */
    public static final void m21735TitleBarText2FzTWkw(final TextData textData, final int i, Modifier modifier, Composer composer, final int i2, final int i4) {
        TextSize textSize;
        ColorProvider onSurfaceVariant;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1466942584);
        final Modifier modifier2 = (i4 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1466942584, i2, -1, "androidx.glance.oneui.template.component.compose.TitleBarText (TitleBar.kt:146)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1744361080);
            textSize = isSmallTablet(composerStartRestartGroup, 0) ? new TextSize(12.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null) : TitleBarTextSizes.INSTANCE.getTitleText();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1744361199);
            textSize = isSmallTablet(composerStartRestartGroup, 0) ? new TextSize(8.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null) : TitleBarTextSizes.INSTANCE.getBodyText();
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextSize textSize2 = textSize;
        if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1744361374);
            onSurfaceVariant = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1744361443);
            onSurfaceVariant = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurfaceVariant();
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.ComposeText(textData, textSize2, onSurfaceVariant, modifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | ((i2 << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TitleBarKt$TitleBarText$1
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
                    TitleBarKt.m21735TitleBarText2FzTWkw(textData, i, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isSmallTablet(Composer composer, int i) {
        boolean z;
        composer.startReplaceableGroup(-986551802);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-986551802, i, -1, "androidx.glance.oneui.template.component.compose.isSmallTablet (TitleBar.kt:42)");
        }
        if (((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getConfiguration().smallestScreenWidthDp < 500) {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            z = StringsKt.m14162r(MODEL, "SM-X");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeContent(final ActionButtonData actionButtonData, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-68424530);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(actionButtonData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-68424530, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeContent (TitleBar.kt:122)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(companion, C2256Dp.m20968constructorimpl(30));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment center = companion2.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM15899size3ABfNKs2 = SizeKt.m15899size3ABfNKs(companion, C2256Dp.m20968constructorimpl(22));
            GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
            int i4 = GlanceTheme.$stable;
            Modifier modifierAlpha = AlphaKt.alpha(BackgroundKt.m15408backgroundbw27NRU(modifierM15899size3ABfNKs2, ComposeUtilsKt.convert(ColorProvidersKt.override(glanceTheme.getColors(composerStartRestartGroup, i4).getSurface(), actionButtonData.getBackgroundColor()), composerStartRestartGroup, 8), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM())), actionButtonData.getEnabled() ? 1.0f : 0.6f);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierAlpha);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            ComposeUtilsKt.m21961ImageButtonucPst7w(actionButtonData.getImageProvider(), actionButtonData.getContentDescription(), AlphaKt.alpha(PaddingKt.m15854padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(6)), actionButtonData.getEnabled() ? 1.0f : 0.6f), Color.m18515boximpl(Color.INSTANCE.m18560getTransparent0d7_KjU()), 0, 0.0f, 0.0f, null, glanceTheme.getColors(composerStartRestartGroup, i4).getOnSurface(), 0.0f, 0.0f, composer2, 134220808, 0, 1776);
            if (AbstractC2821a.m2209D(composer2)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.TitleBarKt.ComposeContent.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i5) {
                    TitleBarKt.ComposeContent(actionButtonData, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
