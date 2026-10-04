package androidx.glance.oneui.template.layout.compose.combine;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
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
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.component.TextKt;
import androidx.glance.oneui.template.component.compose.ImageButtonKt;
import androidx.glance.oneui.template.component.compose.ImageKt;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.size.CombineTemplateDp;
import androidx.glance.oneui.template.size.CombineTemplatePercent;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001ag\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001ao\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\\\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a=\u0010!\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020&2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m13886d2 = {"ComposeCombineAutoText", "", "modifier", "Landroidx/compose/ui/Modifier;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "textData", "Landroidx/glance/oneui/template/TextData;", "type", "Landroidx/glance/oneui/template/TextType;", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "viewWidth", "", "viewHeight", "ComposeCombineAutoText-BnzNfJc", "(Landroidx/compose/ui/Modifier;ILandroidx/glance/oneui/template/TextData;ILandroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;II)V", "ComposeCombineLayout", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "tertiaryContent", "ComposeCombineLayout-wXoZbBE", "(IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "data", "Landroidx/glance/oneui/template/CombineData;", "ComposeCombineLayout-Vekbxm4", "(Landroidx/glance/oneui/template/CombineData;IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ComposeCombineText", "fontWeight", "Landroidx/glance/text/FontWeight;", "ComposeCombineText-57gRyVA", "(Landroidx/compose/ui/Modifier;ILandroidx/glance/oneui/template/TextData;IILandroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;II)V", "Landroidx/glance/oneui/template/TypedTextData;", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/compose/ui/Modifier;Landroidx/glance/unit/ColorProvider;FFLandroidx/compose/runtime/Composer;II)V", "PrimaryButtonContent", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCombineLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombineLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/CombineLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,309:1\n74#2:310\n74#2:311\n74#2:314\n74#2:317\n74#2:318\n76#2:326\n74#2:357\n76#2:365\n174#3:312\n154#3:313\n154#3:315\n154#3:316\n88#4:319\n68#5,5:320\n73#5:351\n77#5:356\n68#5,5:359\n73#5:390\n77#5:395\n75#6:325\n76#6,11:327\n89#6:355\n75#6:364\n76#6,11:366\n89#6:394\n460#7,13:338\n473#7,3:352\n460#7,13:377\n473#7,3:391\n1#8:358\n*S KotlinDebug\n*F\n+ 1 CombineLayout.kt\nandroidx/glance/oneui/template/layout/compose/combine/CombineLayoutKt\n*L\n48#1:310\n63#1:311\n118#1:314\n176#1:317\n177#1:318\n233#1:326\n264#1:357\n294#1:365\n65#1:312\n75#1:313\n129#1:315\n138#1:316\n197#1:319\n233#1:320,5\n233#1:351\n233#1:356\n294#1:359,5\n294#1:390\n294#1:395\n233#1:325\n233#1:327,11\n233#1:355\n294#1:364\n294#1:366,11\n294#1:394\n233#1:338,13\n233#1:352,3\n294#1:377,13\n294#1:391,3\n*E\n"})
public final class CombineLayoutKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeCombineAutoText-BnzNfJc, reason: not valid java name */
    public static final void m21822ComposeCombineAutoTextBnzNfJc(@Nullable Modifier modifier, int i, @NotNull final TextData textData, final int i2, @Nullable ColorProvider colorProvider, float f, float f4, @Nullable Composer composer, final int i4, final int i5) {
        final ColorProvider onBackground;
        int i6;
        int i7;
        float fM21939getTextViewHeightPercenttZlUyYw;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(757220797);
        Modifier modifier2 = (i5 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i5 & 16) != 0) {
            onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
            i6 = i4 & (-57345);
        } else {
            onBackground = colorProvider;
            i6 = i4;
        }
        float f5 = (i5 & 32) != 0 ? 0.0f : f;
        float f6 = (i5 & 64) != 0 ? 0.0f : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(757220797, i6, -1, "androidx.glance.oneui.template.layout.compose.combine.ComposeCombineAutoText (CombineLayout.kt:281)");
        }
        if (textData.getMaxLines() >= 2) {
            String text = textData.getText();
            textData.setMaxLines$glance_oneui_template_release((text != null ? text.length() : 0) <= 8 ? 1 : 2);
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        int iM21998getNormalWjrlUT0 = TextType.m21684equalsimpl0(i2, TextType.INSTANCE.m21689getBodygxbDmow()) ? FontWeight.INSTANCE.m21998getNormalWjrlUT0() : FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
        if (f6 == 0.0f) {
            i7 = i;
            fM21939getTextViewHeightPercenttZlUyYw = CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i7, i2, textData.getMaxLines());
        } else {
            i7 = i;
            fM21939getTextViewHeightPercenttZlUyYw = f6;
        }
        Modifier modifierDebugBox = Debug.INSTANCE.debugBox(SizeKt.wrapContentSize$default(modifier2, null, false, 3, null), "Combine2");
        Alignment centerStart = Alignment.INSTANCE.getCenterStart();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(centerStart, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierDebugBox);
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
        TextKt.m21707AutoTemplateTextRbqdM5c(textData, new TextPercentData(0.0f, 0.0f, 0.0f, fM21939getTextViewHeightPercenttZlUyYw, TextType.m21682covertToCategoryimpl(i2), false, 39, null), iM21998getNormalWjrlUT0, composerStartRestartGroup, (TextPercentData.$stable << 3) | 8);
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
            final float f7 = f5;
            final float f8 = f6;
            final int i8 = i7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt$ComposeCombineAutoText$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i9) {
                    CombineLayoutKt.m21822ComposeCombineAutoTextBnzNfJc(modifier3, i8, textData, i2, onBackground, f7, f8, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ComposeCombineLayout-Vekbxm4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21823ComposeCombineLayoutVekbxm4(@NotNull final CombineData data, final int i, final int i2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i4, final int i5) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1140091297);
        Function2<? super Composer, ? super Integer, Unit> function26 = (i5 & 8) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function27 = (i5 & 16) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i5 & 32) != 0 ? null : function23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1140091297, i4, -1, "androidx.glance.oneui.template.layout.compose.combine.ComposeCombineLayout (CombineLayout.kt:45)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(528890559);
            TinyLayoutKt.TinyLayout(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), data.getPrimaryContentData(), data.getSecondaryContentData(), function26, composerStartRestartGroup, (i4 & 7168) | 582, 0);
            composerStartRestartGroup.endReplaceableGroup();
            function24 = function27;
        } else {
            if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
                function24 = function27;
                if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                    composerStartRestartGroup.startReplaceableGroup(528891495);
                    Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                    int i6 = i4 << 3;
                    function25 = function28;
                    WideSmallLayoutKt.WideSmallLayout(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null), data.getPrimaryContentData(), data.getSecondaryContentData(), data.getTertiaryContentData(), function29, function24, function25, composerStartRestartGroup, (i6 & 3670016) | (i6 & 57344) | 4678 | (i6 & 458752), 0);
                    function26 = function29;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                    if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                        composerStartRestartGroup.startReplaceableGroup(528891973);
                        int i7 = i4 << 3;
                        Function2<? super Composer, ? super Integer, Unit> function211 = function26;
                        MediumLayoutKt.m21827MediumLayoutfWZZ6NI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), data.getPrimaryContentData(), data.getSecondaryContentData(), i, function211, function24, composerStartRestartGroup, ((i4 << 6) & 7168) | 582 | (i7 & 57344) | (i7 & 458752), 0);
                        function26 = function211;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                        function25 = function210;
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(528892360);
                        Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                        int i8 = i4 << 9;
                        LargeLayoutKt.m21826LargeLayoutTafRHR0(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), data.getPrimaryContentData(), data.getSecondaryContentData(), data.getTertiaryContentData(), i, i2, function212, function24, function210, composerStartRestartGroup, (458752 & i8) | (i8 & 57344) | 4678 | (i8 & 3670016) | (29360128 & i8) | (i8 & 234881024), 0);
                        function26 = function212;
                        function24 = function24;
                        function25 = function210;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    final Function2<? super Composer, ? super Integer, Unit> function213 = function26;
                    final Function2<? super Composer, ? super Integer, Unit> function214 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt$ComposeCombineLayout$1
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

                        public final void invoke(@Nullable Composer composer2, int i9) {
                            CombineLayoutKt.m21823ComposeCombineLayoutVekbxm4(data, i, i2, function213, function214, function215, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                    return;
                }
                return;
            }
            composerStartRestartGroup.startReplaceableGroup(528890843);
            Function2<? super Composer, ? super Integer, Unit> function216 = function27;
            SmallLayoutKt.SmallLayout(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), C3094R.dimen.sesl_glance_combine_layout_start_padding)), 0.0f, 2, null), data.getPrimaryContentData(), data.getSecondaryContentData(), function26, function216, composerStartRestartGroup, (i4 & 7168) | Units.MASTER_DPI | (i4 & 57344), 0);
            function24 = function216;
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        }
        function25 = function28;
        if (ComposerKt.isTraceInProgress()) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ComposeCombineLayout-wXoZbBE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21824ComposeCombineLayoutwXoZbBE(final int i, final int i2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int mask;
        AppWidgetSize.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-279278276);
        if ((i5 & 1) != 0) {
            i7 = i4 | 6;
            i6 = i;
        } else if ((i4 & 14) == 0) {
            i6 = i;
            i7 = (composerStartRestartGroup.changed(i6) ? 4 : 2) | i4;
        } else {
            i6 = i;
            i7 = i4;
        }
        if ((i5 & 2) != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 112) == 0) {
                i8 = i2;
                i7 |= composerStartRestartGroup.changed(i8) ? 32 : 16;
            }
            i9 = i5 & 4;
            if (i9 == 0) {
                i7 |= 384;
            } else {
                if ((i4 & 896) == 0) {
                    function24 = function2;
                    i7 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
                }
                i10 = i5 & 8;
                if (i10 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i4 & 7168) == 0) {
                        function25 = function22;
                        i7 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    }
                    i11 = i5 & 16;
                    if (i11 != 0) {
                        if ((i4 & 57344) == 0) {
                            function26 = function23;
                            i7 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
                        }
                        if ((46811 & i7) == 9362 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function28 = function25;
                        } else {
                            if (i9 != 0) {
                                function24 = null;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function29 = i10 == 0 ? null : function25;
                            Function2<? super Composer, ? super Integer, Unit> function210 = i11 == 0 ? null : function26;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-279278276, i7, -1, "androidx.glance.oneui.template.layout.compose.combine.ComposeCombineLayout (CombineLayout.kt:115)");
                            }
                            mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
                            companion = AppWidgetSize.INSTANCE;
                            if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
                                composerStartRestartGroup.startReplaceableGroup(528893332);
                                Function2<? super Composer, ? super Integer, Unit> function211 = function24;
                                TinyLayoutKt.TinyLayout(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, function211, composerStartRestartGroup, ((i7 << 3) & 7168) | 438, 0);
                                function24 = function211;
                                composerStartRestartGroup.endReplaceableGroup();
                                function27 = function29;
                            } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
                                composerStartRestartGroup.startReplaceableGroup(528893576);
                                int i12 = i7 << 3;
                                Function2<? super Composer, ? super Integer, Unit> function212 = function24;
                                Function2<? super Composer, ? super Integer, Unit> function213 = function29;
                                SmallLayoutKt.SmallLayout(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null), null, null, function212, function213, composerStartRestartGroup, (i12 & 7168) | 438 | (i12 & 57344), 0);
                                function24 = function212;
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceableGroup();
                                function27 = function213;
                            } else {
                                Function2<? super Composer, ? super Integer, Unit> function214 = function29;
                                if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                                    composerStartRestartGroup.startReplaceableGroup(528893905);
                                    int i13 = i7 << 6;
                                    function27 = function214;
                                    function26 = function210;
                                    Function2<? super Composer, ? super Integer, Unit> function215 = function24;
                                    WideSmallLayoutKt.WideSmallLayout(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null), null, null, null, function215, function27, function26, composerStartRestartGroup, (i13 & 3670016) | (i13 & 57344) | 3510 | (i13 & 458752), 0);
                                    function24 = function215;
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceableGroup();
                                } else {
                                    function27 = function214;
                                    Function2<? super Composer, ? super Integer, Unit> function216 = function210;
                                    if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                                        composerStartRestartGroup.startReplaceableGroup(528894323);
                                        int i14 = ((i7 << 9) & 7168) | 438;
                                        int i15 = i7 << 6;
                                        Function2<? super Composer, ? super Integer, Unit> function217 = function24;
                                        MediumLayoutKt.m21827MediumLayoutfWZZ6NI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, i6, function217, function27, composerStartRestartGroup, i14 | (i15 & 57344) | (i15 & 458752), 0);
                                        function24 = function217;
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceableGroup();
                                        function26 = function216;
                                    } else {
                                        composerStartRestartGroup.startReplaceableGroup(528894670);
                                        int i16 = i7 << 12;
                                        Function2<? super Composer, ? super Integer, Unit> function218 = function24;
                                        LargeLayoutKt.m21826LargeLayoutTafRHR0(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, i, i8, function218, function27, function216, composerStartRestartGroup, (i16 & 57344) | 3510 | (i16 & 458752) | (i16 & 3670016) | (29360128 & i16) | (i16 & 234881024), 0);
                                        function24 = function218;
                                        function27 = function27;
                                        function26 = function216;
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceableGroup();
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function28 = function27;
                            }
                            function26 = function210;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function28 = function27;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function219 = function24;
                        final Function2<? super Composer, ? super Integer, Unit> function220 = function26;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt$ComposeCombineLayout$2
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

                                public final void invoke(@Nullable Composer composer2, int i17) {
                                    CombineLayoutKt.m21824ComposeCombineLayoutwXoZbBE(i, i2, function219, function28, function220, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 |= 24576;
                    function26 = function23;
                    if ((46811 & i7) == 9362) {
                        if (i9 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
                        companion = AppWidgetSize.INSTANCE;
                        if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
                        }
                        function26 = function210;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function28 = function27;
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function2192 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function2202 = function26;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function25 = function22;
                i11 = i5 & 16;
                if (i11 != 0) {
                }
                function26 = function23;
                if ((46811 & i7) == 9362) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function21922 = function24;
                final Function2<? super Composer, ? super Integer, Unit> function22022 = function26;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function24 = function2;
            i10 = i5 & 8;
            if (i10 != 0) {
            }
            function25 = function22;
            i11 = i5 & 16;
            if (i11 != 0) {
            }
            function26 = function23;
            if ((46811 & i7) == 9362) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function219222 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function220222 = function26;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i8 = i2;
        i9 = i5 & 4;
        if (i9 == 0) {
        }
        function24 = function2;
        i10 = i5 & 8;
        if (i10 != 0) {
        }
        function25 = function22;
        i11 = i5 & 16;
        if (i11 != 0) {
        }
        function26 = function23;
        if ((46811 & i7) == 9362) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function2192222 = function24;
        final Function2<? super Composer, ? super Integer, Unit> function2202222 = function26;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ComposeCombineText(@NotNull final TypedTextData textData, @Nullable Modifier modifier, @Nullable ColorProvider colorProvider, float f, float f4, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        float f5;
        int i5;
        float f6;
        Modifier modifier2;
        ColorProvider onBackground;
        ColorProvider colorProvider2;
        float f7;
        float f8;
        final Modifier modifier3;
        final ColorProvider colorProvider3;
        final float f9;
        final float f10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(1802168429);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(textData) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i4 |= 128;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                f5 = f;
                i4 |= composerStartRestartGroup.changed(f5) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 != 0) {
                if ((57344 & i) == 0) {
                    f6 = f4;
                    i4 |= composerStartRestartGroup.changed(f6) ? 16384 : 8192;
                }
                if (i7 == 4 && (46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    colorProvider3 = colorProvider;
                    f9 = f5;
                    f10 = f6;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier2 = i6 == 0 ? Modifier.INSTANCE : modifier;
                        if (i7 == 0) {
                            onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
                            i4 &= -897;
                        } else {
                            onBackground = colorProvider;
                        }
                        if (i8 != 0) {
                            f5 = 0.0f;
                        }
                        if (i5 == 0) {
                            f7 = 0.0f;
                            f8 = f5;
                            colorProvider2 = onBackground;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1802168429, i4, -1, "androidx.glance.oneui.template.layout.compose.combine.ComposeCombineText (CombineLayout.kt:260)");
                            }
                            Modifier modifier4 = modifier2;
                            int i9 = ((i4 >> 3) & 14) | 262144 | ((i4 << 6) & 896);
                            int i10 = i4 << 9;
                            m21825ComposeCombineText57gRyVA(modifier4, ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), textData, textData.getTextType(), 0, colorProvider2, f8, f7, composerStartRestartGroup, i9 | (3670016 & i10) | (i10 & 29360128), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            colorProvider3 = colorProvider2;
                            f9 = f8;
                            f10 = f7;
                        } else {
                            colorProvider2 = onBackground;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if (i7 != 0) {
                            i4 &= -897;
                        }
                        modifier2 = modifier;
                        colorProvider2 = colorProvider;
                    }
                    f8 = f5;
                    f7 = f6;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier modifier42 = modifier2;
                    int i92 = ((i4 >> 3) & 14) | 262144 | ((i4 << 6) & 896);
                    int i102 = i4 << 9;
                    m21825ComposeCombineText57gRyVA(modifier42, ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), textData, textData.getTextType(), 0, colorProvider2, f8, f7, composerStartRestartGroup, i92 | (3670016 & i102) | (i102 & 29360128), 16);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    colorProvider3 = colorProvider2;
                    f9 = f8;
                    f10 = f7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt.ComposeCombineText.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i11) {
                            CombineLayoutKt.ComposeCombineText(textData, modifier3, colorProvider3, f9, f10, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            f6 = f4;
            if (i7 == 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i5 == 0) {
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        f5 = f;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        f6 = f4;
        if (i7 == 4) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeCombineText-57gRyVA, reason: not valid java name */
    public static final void m21825ComposeCombineText57gRyVA(@Nullable Modifier modifier, final int i, @NotNull final TextData textData, final int i2, int i4, @Nullable ColorProvider colorProvider, float f, float f4, @Nullable Composer composer, final int i5, final int i6) {
        int iM21999getSemiBoldWjrlUT0;
        int i7;
        ColorProvider onBackground;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2075352259);
        Modifier modifier2 = (i6 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i6 & 16) != 0) {
            iM21999getSemiBoldWjrlUT0 = FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0();
            i7 = i5 & (-57345);
        } else {
            iM21999getSemiBoldWjrlUT0 = i4;
            i7 = i5;
        }
        if ((i6 & 32) != 0) {
            i7 &= -458753;
            onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        } else {
            onBackground = colorProvider;
        }
        float f5 = (i6 & 64) != 0 ? 0.0f : f;
        float f6 = (i6 & 128) != 0 ? 0.0f : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2075352259, i7, -1, "androidx.glance.oneui.template.layout.compose.combine.ComposeCombineText (CombineLayout.kt:216)");
        }
        if (!TextType.m21684equalsimpl0(i2, TextType.INSTANCE.m21694getTitlegxbDmow())) {
            textData.setMaxLines$glance_oneui_template_release(1);
        } else if (textData.getMaxLines() >= 2) {
            textData.setMaxLines$glance_oneui_template_release(2);
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        float fM21939getTextViewHeightPercenttZlUyYw = f6 == 0.0f ? CombineTemplatePercent.INSTANCE.m21939getTextViewHeightPercenttZlUyYw(i, i2, textData.getMaxLines()) : f6;
        Pair<Float, Float> pairM21938getTextSizeRangetEsvO4U = CombineTemplatePercent.INSTANCE.m21938getTextSizeRangetEsvO4U(i, i2);
        Modifier modifierDebugBox = Debug.INSTANCE.debugBox(SizeKt.wrapContentSize$default(modifier2, null, false, 3, null), "Combine1");
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierDebugBox);
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
        ColorProvider textColor = textData.getTextColor();
        ColorProvider colorProvider2 = textColor == null ? onBackground : textColor;
        TextPercentData textPercentData = new TextPercentData(pairM21938getTextSizeRangetEsvO4U.getFirst().floatValue(), pairM21938getTextSizeRangetEsvO4U.getSecond().floatValue(), f5 == 0.0f ? 1.0f : f5, fM21939getTextViewHeightPercenttZlUyYw, TextType.m21682covertToCategoryimpl(i2), false);
        int i8 = (TextPercentData.$stable << 6) | 32832 | ((i7 >> 3) & 7168);
        final int i9 = iM21999getSemiBoldWjrlUT0;
        androidx.glance.oneui.template.component.compose.TextKt.m21728ComposeText2T94tj4(null, textData, textPercentData, i9, colorProvider2, composerStartRestartGroup, i8, 1);
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final ColorProvider colorProvider3 = onBackground;
            final float f7 = f5;
            final float f8 = f6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt.ComposeCombineText.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i10) {
                    CombineLayoutKt.m21825ComposeCombineText57gRyVA(modifier3, i, textData, i2, i9, colorProvider3, f7, f8, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void PrimaryButtonContent(@NotNull Modifier modifier, @NotNull final PrimaryContentData primaryData, @Nullable Composer composer, final int i) {
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(primaryData, "primaryData");
        Composer composerStartRestartGroup = composer.startRestartGroup(600727286);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(600727286, i, -1, "androidx.glance.oneui.template.layout.compose.combine.PrimaryButtonContent (CombineLayout.kt:172)");
        }
        if (primaryData.getImage() != null) {
            composerStartRestartGroup.startReplaceableGroup(1382844867);
            if (primaryData.getImage() instanceof ImageButtonData) {
                composerStartRestartGroup.startReplaceableGroup(1382844919);
                Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
                Pair<Float, Float> pairM21937getButtonSizeL2j3NV4 = CombineTemplatePercent.INSTANCE.m21937getButtonSizeL2j3NV4(mask);
                float fM21936getMaxButtonSizemDIpwz4 = CombineTemplateDp.INSTANCE.m21936getMaxButtonSizemDIpwz4(context, mask);
                long jM21383getMinDpSizeFromPercentDataM_xkUdw = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21937getButtonSizeL2j3NV4.getFirst().floatValue(), pairM21937getButtonSizeL2j3NV4.getSecond().floatValue(), fM21936getMaxButtonSizemDIpwz4, fM21936getMaxButtonSizemDIpwz4, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24576, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceableGroup(1382845582);
                ImageButtonData imageButtonData = (ImageButtonData) primaryData.getImage();
                if (imageButtonData.getBackgroundColor() == null) {
                    imageButtonData.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageButtonKt.m21714ComposeImageButtondjqsMU(imageButtonData, DpSize.m21064getHeightD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw) * 0.2f), null, composerStartRestartGroup, 8, 8);
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier;
            } else {
                composerStartRestartGroup.startReplaceableGroup(1382845895);
                ImageKt.ComposeImage(primaryData.getImage(), modifier, null, true, composerStartRestartGroup, ((i << 3) & 112) | 3080, 4);
                modifier2 = modifier;
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            modifier2 = modifier;
            if (primaryData.getProgressIndicator() != null) {
                composerStartRestartGroup.startReplaceableGroup(1382846057);
                ProgressIndicatorKt.ComposeCircularProgressIndicator(modifier2, primaryData.getProgressIndicator(), 0, null, composerStartRestartGroup, (i & 14) | 64, 12);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1382846164);
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.combine.CombineLayoutKt.PrimaryButtonContent.2
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
                    CombineLayoutKt.PrimaryButtonContent(modifier2, primaryData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
