package androidx.glance.oneui.template.layout.compose;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CombineTemplateKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.PermissionData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.compose.ImageButtonKt;
import androidx.glance.oneui.template.component.compose.TextKt;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a@\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"ComposePermissionLayout", "", "data", "Landroidx/glance/oneui/template/PermissionData;", "(Landroidx/glance/oneui/template/PermissionData;Landroidx/compose/runtime/Composer;I)V", "ExtraLargeContent", "MediumAndLargeContent", "PermissionIcon", "size", "Landroidx/compose/ui/unit/Dp;", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "PermissionIcon-kHDZbjc", "(FLandroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/compose/runtime/Composer;I)V", "SmallContent", "TinyContent", "WideSmallContent", "getTextViewHeight", "", "textType", "Landroidx/glance/oneui/template/TextType;", "maxLines", "", "getTextViewHeight-w94YkXw", "(IILandroidx/compose/runtime/Composer;I)F", "PermissionText", "Landroidx/glance/oneui/template/TextData;", "textAlign", "Landroidx/glance/text/TextAlign;", "fontWeight", "Landroidx/glance/text/FontWeight;", "autoResize", "", "PermissionText-yq-FBXw", "(Landroidx/glance/oneui/template/TextData;IIIIZLandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPermissionLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionLayout.kt\nandroidx/glance/oneui/template/layout/compose/PermissionLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,233:1\n74#2:234\n74#2:235\n76#2:244\n76#2:281\n76#2:315\n76#2:358\n76#2:392\n88#3:236\n154#4:237\n154#4:307\n154#4:341\n154#4:384\n154#4:418\n68#5,5:238\n73#5:269\n77#5:274\n68#5,5:275\n73#5:306\n77#5:351\n68#5,5:352\n73#5:383\n77#5:428\n75#6:243\n76#6,11:245\n89#6:273\n75#6:280\n76#6,11:282\n75#6:314\n76#6,11:316\n89#6:345\n89#6:350\n75#6:357\n76#6,11:359\n75#6:391\n76#6,11:393\n89#6:422\n89#6:427\n460#7,13:256\n473#7,3:270\n460#7,13:293\n460#7,13:327\n473#7,3:342\n473#7,3:347\n460#7,13:370\n460#7,13:404\n473#7,3:419\n473#7,3:424\n74#8,6:308\n80#8:340\n84#8:346\n74#8,6:385\n80#8:417\n84#8:423\n*S KotlinDebug\n*F\n+ 1 PermissionLayout.kt\nandroidx/glance/oneui/template/layout/compose/PermissionLayoutKt\n*L\n42#1:234\n55#1:235\n119#1:244\n176#1:281\n183#1:315\n208#1:358\n215#1:392\n106#1:236\n106#1:237\n184#1:307\n196#1:341\n216#1:384\n221#1:418\n119#1:238,5\n119#1:269\n119#1:274\n176#1:275,5\n176#1:306\n176#1:351\n208#1:352,5\n208#1:383\n208#1:428\n119#1:243\n119#1:245,11\n119#1:273\n176#1:280\n176#1:282,11\n183#1:314\n183#1:316,11\n183#1:345\n176#1:350\n208#1:357\n208#1:359,11\n215#1:391\n215#1:393,11\n215#1:422\n208#1:427\n119#1:256,13\n119#1:270,3\n176#1:293,13\n183#1:327,13\n183#1:342,3\n176#1:347,3\n208#1:370,13\n215#1:404,13\n215#1:419,3\n208#1:424,3\n183#1:308,6\n183#1:340\n183#1:346\n215#1:385,6\n215#1:417\n215#1:423\n*E\n"})
public final class PermissionLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposePermissionLayout(@NotNull final PermissionData data, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1632274102);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1632274102, i, -1, "androidx.glance.oneui.template.layout.compose.ComposePermissionLayout (PermissionLayout.kt:40)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-1316850801);
            TinyContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-1316850752);
            SmallContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-1316850698);
            WideSmallContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-1316850643);
            MediumAndLargeContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(-1316850584);
            MediumAndLargeContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1316850540);
            ExtraLargeContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.ComposePermissionLayout.1
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
                    PermissionLayoutKt.ComposePermissionLayout(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ExtraLargeContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(502050311);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502050311, i, -1, "androidx.glance.oneui.template.layout.compose.ExtraLargeContent (PermissionLayout.kt:203)");
        }
        float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(0.28f, 0.11f, 0.0f, 0.0f, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24630, 12));
        Debug debug = Debug.INSTANCE;
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierDebugBox = debug.debugBox(ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), 0.0f, 0.045f, 0.0f, 0.0f, composerStartRestartGroup, 438, 12), "Permission3");
        Alignment.Companion companion2 = Alignment.INSTANCE;
        Alignment center = companion2.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(16), 0.0f, 2, null);
        Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
        m21806PermissionIconkHDZbjc(fM21064getHeightD9Ej5fM, permissionData.getIcon(), composerStartRestartGroup, 64);
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion, C2256Dp.m20968constructorimpl(12)), composerStartRestartGroup, 6);
        TextData mainText = permissionData.getMainText();
        TextType.Companion companion4 = TextType.INSTANCE;
        int iM21694getTitlegxbDmow = companion4.m21694getTitlegxbDmow();
        TextAlign.Companion companion5 = TextAlign.INSTANCE;
        int iM22007getCenterROrN78o = companion5.m22007getCenterROrN78o();
        FontWeight.Companion companion6 = FontWeight.INSTANCE;
        m21807PermissionTextyqFBXw(mainText, iM21694getTitlegxbDmow, iM22007getCenterROrN78o, companion6.m21999getSemiBoldWjrlUT0(), permissionData.getMainText().getMaxLines(), false, composerStartRestartGroup, 56, 16);
        TextData subText = permissionData.getSubText();
        composerStartRestartGroup.startReplaceableGroup(609474586);
        if (subText != null) {
            m21807PermissionTextyqFBXw(subText, companion4.m21689getBodygxbDmow(), companion5.m22007getCenterROrN78o(), companion6.m21998getNormalWjrlUT0(), 1, false, composerStartRestartGroup, 24632, 16);
        }
        composerStartRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.ExtraLargeContent.2
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
                    PermissionLayoutKt.ExtraLargeContent(permissionData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MediumAndLargeContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-582995531);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582995531, i, -1, "androidx.glance.oneui.template.layout.compose.MediumAndLargeContent (PermissionLayout.kt:171)");
        }
        float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(0.28f, 0.245f, 0.0f, 0.0f, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24630, 12));
        Debug debug = Debug.INSTANCE;
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierDebugBox = debug.debugBox(ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), 0.0f, 0.1f, 0.0f, 0.0f, composerStartRestartGroup, 438, 12), "Permission2");
        Alignment.Companion companion2 = Alignment.INSTANCE;
        Alignment center = companion2.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), C2256Dp.m20968constructorimpl(16), 0.0f, 2, null);
        Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
        m21806PermissionIconkHDZbjc(fM21064getHeightD9Ej5fM, permissionData.getIcon(), composerStartRestartGroup, 64);
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
        TextData mainText = permissionData.getMainText();
        TextType.Companion companion4 = TextType.INSTANCE;
        int iM21694getTitlegxbDmow = companion4.m21694getTitlegxbDmow();
        TextAlign.Companion companion5 = TextAlign.INSTANCE;
        int iM22007getCenterROrN78o = companion5.m22007getCenterROrN78o();
        FontWeight.Companion companion6 = FontWeight.INSTANCE;
        m21807PermissionTextyqFBXw(mainText, iM21694getTitlegxbDmow, iM22007getCenterROrN78o, companion6.m21999getSemiBoldWjrlUT0(), permissionData.getMainText().getMaxLines(), false, composerStartRestartGroup, 56, 16);
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion, C2256Dp.m20968constructorimpl(2)), composerStartRestartGroup, 6);
        TextData subText = permissionData.getSubText();
        composerStartRestartGroup.startReplaceableGroup(-501905817);
        if (subText != null) {
            m21807PermissionTextyqFBXw(subText, companion4.m21689getBodygxbDmow(), companion5.m22007getCenterROrN78o(), companion6.m21998getNormalWjrlUT0(), 1, false, composerStartRestartGroup, 24632, 16);
        }
        composerStartRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composerStartRestartGroup, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.MediumAndLargeContent.2
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
                    PermissionLayoutKt.MediumAndLargeContent(permissionData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: PermissionIcon-kHDZbjc, reason: not valid java name */
    public static final void m21806PermissionIconkHDZbjc(final float f, final ImageWithBackgroundData imageWithBackgroundData, Composer composer, final int i) {
        long jConvert;
        Composer composerStartRestartGroup = composer.startRestartGroup(496096497);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(496096497, i, -1, "androidx.glance.oneui.template.layout.compose.PermissionIcon (PermissionLayout.kt:101)");
        }
        float fM20968constructorimpl = imageWithBackgroundData.getImageType() == ImageType.Icon ? C2256Dp.m20968constructorimpl(0.2f * f) : C2256Dp.m20968constructorimpl(0);
        if (imageWithBackgroundData.getImageType() == ImageType.AppIcon) {
            composerStartRestartGroup.startReplaceableGroup(-1248764853);
            jConvert = ComposeUtilsKt.convert(ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1248764773);
            ColorProvider backgroundColor = imageWithBackgroundData.getBackgroundColor();
            composerStartRestartGroup.startReplaceableGroup(-1248764754);
            if (backgroundColor == null) {
                backgroundColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface();
            }
            composerStartRestartGroup.endReplaceableGroup();
            jConvert = ComposeUtilsKt.convert(backgroundColor, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        }
        ImageButtonKt.m21712ComposeImageButtonLFFoFBE(imageWithBackgroundData, f, fM20968constructorimpl, jConvert, imageWithBackgroundData.getBackgroundResId(), null, composerStartRestartGroup, ((i << 3) & 112) | 8, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt$PermissionIcon$1
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
                    PermissionLayoutKt.m21806PermissionIconkHDZbjc(f, imageWithBackgroundData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: PermissionText-yq-FBXw, reason: not valid java name */
    public static final void m21807PermissionTextyqFBXw(final TextData textData, final int i, final int i2, final int i4, final int i5, boolean z, Composer composer, final int i6, final int i7) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1440185858);
        boolean z2 = (i7 & 16) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1440185858, i6, -1, "androidx.glance.oneui.template.layout.compose.PermissionText (PermissionLayout.kt:82)");
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        textData.m21678setTextAlignb1psNo$glance_oneui_template_release(i2);
        TextKt.m21728ComposeText2T94tj4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), textData, new TextPercentData(0.0f, 0.0f, 0.0f, m21810getTextViewHeightw94YkXw(i, i5, composerStartRestartGroup, ((i6 >> 3) & 14) | ((i6 >> 9) & 112)), TextType.m21682covertToCategoryimpl(i), z2, 7, null), i4, ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground(), textData.getTextColor()), composerStartRestartGroup, (TextPercentData.$stable << 6) | 32838 | (i6 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt$PermissionText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    PermissionLayoutKt.m21807PermissionTextyqFBXw(textData, i, i2, i4, i5, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SmallContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1042609433);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1042609433, i, -1, "androidx.glance.oneui.template.layout.compose.SmallContent (PermissionLayout.kt:136)");
        }
        CombineTemplateKt.m21658CombineTemplatehlbQeY0(new CombineData(new PrimaryContentData(permissionData.getIcon()), null, null, 6, null), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -818819117, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.SmallContent.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818819117, i2, -1, "androidx.glance.oneui.template.layout.compose.SmallContent.<anonymous> (PermissionLayout.kt:140)");
                }
                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(6), 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 10, null);
                PermissionData permissionData2 = permissionData;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                Density density = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                PermissionLayoutKt.m21807PermissionTextyqFBXw(permissionData2.getMainText(), TextType.INSTANCE.m21689getBodygxbDmow(), TextAlign.INSTANCE.m22011getStartROrN78o(), FontWeight.INSTANCE.m21998getNormalWjrlUT0(), permissionData2.getMainText().getMaxLines(), false, composer2, 56, 16);
                if (AbstractC2821a.m2209D(composer2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 0, null, 0, composerStartRestartGroup, 392, 58);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.SmallContent.2
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
                    PermissionLayoutKt.SmallContent(permissionData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TinyContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1755484860);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1755484860, i, -1, "androidx.glance.oneui.template.layout.compose.TinyContent (PermissionLayout.kt:117)");
        }
        Modifier modifierDebugBox = Debug.INSTANCE.debugBox(ComposeModifierUtilsKt.m21956padding6PoWaU8(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.1f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 438, 12), "Permission1");
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
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
        m21807PermissionTextyqFBXw(permissionData.getMainText(), TextType.INSTANCE.m21693getLabelgxbDmow(), TextAlign.INSTANCE.m22007getCenterROrN78o(), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), permissionData.getMainText().getMaxLines(), true, composerStartRestartGroup, 196664, 0);
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.TinyContent.2
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
                    PermissionLayoutKt.TinyContent(permissionData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void WideSmallContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(924130580);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(924130580, i, -1, "androidx.glance.oneui.template.layout.compose.WideSmallContent (PermissionLayout.kt:153)");
        }
        CombineTemplateKt.m21658CombineTemplatehlbQeY0(new CombineData(new PrimaryContentData(permissionData.getIcon()), null, null, 6, null), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2140697600, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.WideSmallContent.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2140697600, i2, -1, "androidx.glance.oneui.template.layout.compose.WideSmallContent.<anonymous> (PermissionLayout.kt:157)");
                }
                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(6), 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 10, null);
                PermissionData permissionData2 = permissionData;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                Density density = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                TextData mainText = permissionData2.getMainText();
                TextType.Companion companion2 = TextType.INSTANCE;
                int iM21694getTitlegxbDmow = companion2.m21694getTitlegxbDmow();
                TextAlign.Companion companion3 = TextAlign.INSTANCE;
                int iM22011getStartROrN78o = companion3.m22011getStartROrN78o();
                FontWeight.Companion companion4 = FontWeight.INSTANCE;
                int maxLines = 1;
                int iM21999getSemiBoldWjrlUT0 = companion4.m21999getSemiBoldWjrlUT0();
                if (permissionData2.getSubText() == null) {
                    maxLines = permissionData2.getMainText().getMaxLines();
                }
                PermissionLayoutKt.m21807PermissionTextyqFBXw(mainText, iM21694getTitlegxbDmow, iM22011getStartROrN78o, iM21999getSemiBoldWjrlUT0, maxLines, false, composer2, 56, 16);
                TextData subText = permissionData2.getSubText();
                composer2.startReplaceableGroup(1279652998);
                if (subText != null) {
                    PermissionLayoutKt.m21807PermissionTextyqFBXw(subText, companion2.m21689getBodygxbDmow(), companion3.m22011getStartROrN78o(), companion4.m21998getNormalWjrlUT0(), 1, false, composer2, 24632, 16);
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 0, null, 0, composerStartRestartGroup, 392, 58);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.PermissionLayoutKt.WideSmallContent.2
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
                    PermissionLayoutKt.WideSmallContent(permissionData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    /* JADX INFO: renamed from: getTextViewHeight-w94YkXw, reason: not valid java name */
    private static final float m21810getTextViewHeightw94YkXw(int i, int i2, Composer composer, int i4) {
        float f;
        composer.startReplaceableGroup(-1874436497);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1874436497, i4, -1, "androidx.glance.oneui.template.layout.compose.getTextViewHeight (PermissionLayout.kt:53)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
            f = AppWidgetSize.m21546compareToL2j3NV4(mask, companion2.m21573getWideSmallrx25Pp4()) <= 0 ? 0.31f : AppWidgetSize.m21546compareToL2j3NV4(mask, companion2.m21568getLargerx25Pp4()) <= 0 ? i2 == 1 ? 0.125f : 0.245f : 0.055f;
        } else if (TextType.m21684equalsimpl0(i, companion.m21689getBodygxbDmow())) {
            AppWidgetSize.Companion companion3 = AppWidgetSize.INSTANCE;
            f = AppWidgetSize.m21546compareToL2j3NV4(mask, companion3.m21573getWideSmallrx25Pp4()) <= 0 ? i2 == 1 ? 0.26f : 0.52f : AppWidgetSize.m21546compareToL2j3NV4(mask, companion3.m21568getLargerx25Pp4()) <= 0 ? 0.105f : 0.04f;
        } else {
            f = i2 == 1 ? 0.4f : 0.8f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }
}
