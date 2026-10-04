package androidx.glance.oneui.template.layout.glance;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CombineTemplateKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.PermissionData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.oneui.template.utils.GlanceModifierUtilsKt;
import androidx.glance.semantics.SemanticsModifierKt;
import androidx.glance.semantics.SemanticsPropertiesKt;
import androidx.glance.semantics.SemanticsPropertyReceiver;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a@\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"ExtraLargeContent", "", "data", "Landroidx/glance/oneui/template/PermissionData;", "(Landroidx/glance/oneui/template/PermissionData;Landroidx/compose/runtime/Composer;I)V", "GlancePermissionLayout", "MediumAndLargeContent", "PermissionIcon", "size", "Landroidx/compose/ui/unit/Dp;", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "PermissionIcon-kHDZbjc", "(FLandroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/compose/runtime/Composer;I)V", "SmallContent", "TinyContent", "WideSmallContent", "getTextViewHeight", "", "textType", "Landroidx/glance/oneui/template/TextType;", "maxLines", "", "getTextViewHeight-w94YkXw", "(IILandroidx/compose/runtime/Composer;I)F", "PermissionText", "Landroidx/glance/oneui/template/TextData;", "textAlign", "Landroidx/glance/text/TextAlign;", "fontWeight", "Landroidx/glance/text/FontWeight;", "autoResize", "", "PermissionText-yq-FBXw", "(Landroidx/glance/oneui/template/TextData;IIIIZLandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPermissionLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionLayout.kt\nandroidx/glance/oneui/template/layout/glance/PermissionLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,250:1\n74#2:251\n74#2:252\n75#3:253\n*S KotlinDebug\n*F\n+ 1 PermissionLayout.kt\nandroidx/glance/oneui/template/layout/glance/PermissionLayoutKt\n*L\n48#1:251\n61#1:252\n123#1:253\n*E\n"})
public final class PermissionLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void ExtraLargeContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(313731467);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(313731467, i, -1, "androidx.glance.oneui.template.layout.glance.ExtraLargeContent (PermissionLayout.kt:222)");
        }
        final float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(0.28f, 0.11f, 0.0f, 0.0f, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24630, 12));
        Debug.INSTANCE.debugBox(PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0.0f, 0.045f, 0.0f, 0.0f, composerStartRestartGroup, 432, 12), Alignment.INSTANCE.getCenter(), "Permission4", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -675177996, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.ExtraLargeContent.1
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
                    ComposerKt.traceEventStart(-675177996, i2, -1, "androidx.glance.oneui.template.layout.glance.ExtraLargeContent.<anonymous> (PermissionLayout.kt:231)");
                }
                GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(16), 0.0f, 2, null);
                int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                final float f = fM21064getHeightD9Ej5fM;
                final PermissionData permissionData2 = permissionData;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21498paddingVpY3zN4$default, 0, iM21430getCenterHorizontallyPGIyAqw, ComposableLambdaKt.composableLambda(composer2, -644691862, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.ExtraLargeContent.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-644691862, i4, -1, "androidx.glance.oneui.template.layout.glance.ExtraLargeContent.<anonymous>.<anonymous> (PermissionLayout.kt:235)");
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        SpacerKt.Spacer(Column.defaultWeight(companion), composer3, 0, 0);
                        PermissionLayoutKt.m21847PermissionIconkHDZbjc(f, permissionData2.getIcon(), composer3, 64);
                        AbstractC2821a.m2232w(12, companion, composer3, 0, 0);
                        TextData mainText = permissionData2.getMainText();
                        TextType.Companion companion2 = TextType.INSTANCE;
                        int iM21694getTitlegxbDmow = companion2.m21694getTitlegxbDmow();
                        TextAlign.Companion companion3 = TextAlign.INSTANCE;
                        int iM22007getCenterROrN78o = companion3.m22007getCenterROrN78o();
                        FontWeight.Companion companion4 = FontWeight.INSTANCE;
                        PermissionLayoutKt.m21848PermissionTextyqFBXw(mainText, iM21694getTitlegxbDmow, iM22007getCenterROrN78o, companion4.m21999getSemiBoldWjrlUT0(), permissionData2.getMainText().getMaxLines(), false, composer3, 56, 16);
                        TextData subText = permissionData2.getSubText();
                        composer3.startReplaceableGroup(321254289);
                        if (subText != null) {
                            PermissionLayoutKt.m21848PermissionTextyqFBXw(subText, companion2.m21689getBodygxbDmow(), companion3.m22007getCenterROrN78o(), companion4.m21998getNormalWjrlUT0(), 1, false, composer3, 24632, 16);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                        SpacerKt.Spacer(Column.defaultWeight(companion), composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.ExtraLargeContent.2
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

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void GlancePermissionLayout(@NotNull final PermissionData data, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1090678234);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1090678234, i, -1, "androidx.glance.oneui.template.layout.glance.GlancePermissionLayout (PermissionLayout.kt:46)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1146531655);
            TinyContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1146531704);
            SmallContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1146531758);
            WideSmallContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1146531813);
            MediumAndLargeContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1146531872);
            MediumAndLargeContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1146531916);
            ExtraLargeContent(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.GlancePermissionLayout.1
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
                    PermissionLayoutKt.GlancePermissionLayout(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void MediumAndLargeContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1110013981);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1110013981, i, -1, "androidx.glance.oneui.template.layout.glance.MediumAndLargeContent (PermissionLayout.kt:192)");
        }
        final float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(0.28f, 0.245f, 0.0f, 0.0f, 1.0f, composerStartRestartGroup, (PercentSizeUtils.$stable << 15) | 24630, 12));
        Debug.INSTANCE.debugBox(PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0.0f, 0.1f, 0.0f, 0.0f, composerStartRestartGroup, 432, 12), Alignment.INSTANCE.getCenter(), "Permission3", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 4688902, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.MediumAndLargeContent.1
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
                    ComposerKt.traceEventStart(4688902, i2, -1, "androidx.glance.oneui.template.layout.glance.MediumAndLargeContent.<anonymous> (PermissionLayout.kt:201)");
                }
                GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(16), 0.0f, 2, null);
                int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                final float f = fM21064getHeightD9Ej5fM;
                final PermissionData permissionData2 = permissionData;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21498paddingVpY3zN4$default, 0, iM21430getCenterHorizontallyPGIyAqw, ComposableLambdaKt.composableLambda(composer2, 1079021436, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.MediumAndLargeContent.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1079021436, i4, -1, "androidx.glance.oneui.template.layout.glance.MediumAndLargeContent.<anonymous>.<anonymous> (PermissionLayout.kt:205)");
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        SpacerKt.Spacer(Column.defaultWeight(companion), composer3, 0, 0);
                        PermissionLayoutKt.m21847PermissionIconkHDZbjc(f, permissionData2.getIcon(), composer3, 64);
                        SpacerKt.Spacer(Column.defaultWeight(companion), composer3, 0, 0);
                        TextData mainText = permissionData2.getMainText();
                        TextType.Companion companion2 = TextType.INSTANCE;
                        int iM21694getTitlegxbDmow = companion2.m21694getTitlegxbDmow();
                        TextAlign.Companion companion3 = TextAlign.INSTANCE;
                        int iM22007getCenterROrN78o = companion3.m22007getCenterROrN78o();
                        FontWeight.Companion companion4 = FontWeight.INSTANCE;
                        PermissionLayoutKt.m21848PermissionTextyqFBXw(mainText, iM21694getTitlegxbDmow, iM22007getCenterROrN78o, companion4.m21999getSemiBoldWjrlUT0(), permissionData2.getMainText().getMaxLines(), false, composer3, 56, 16);
                        AbstractC2821a.m2232w(2, companion, composer3, 0, 0);
                        TextData subText = permissionData2.getSubText();
                        composer3.startReplaceableGroup(1791278041);
                        if (subText != null) {
                            PermissionLayoutKt.m21848PermissionTextyqFBXw(subText, companion2.m21689getBodygxbDmow(), companion3.m22007getCenterROrN78o(), companion4.m21998getNormalWjrlUT0(), 1, false, composer3, 24632, 16);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                        SpacerKt.Spacer(Column.defaultWeight(companion), composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.MediumAndLargeContent.2
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
    public static final void m21847PermissionIconkHDZbjc(final float f, final ImageWithBackgroundData imageWithBackgroundData, Composer composer, final int i) {
        GlanceModifier glanceModifierBackground;
        Composer composerStartRestartGroup = composer.startRestartGroup(867728737);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(867728737, i, -1, "androidx.glance.oneui.template.layout.glance.PermissionIcon (PermissionLayout.kt:108)");
        }
        if (imageWithBackgroundData.getBackgroundResId() != 0) {
            glanceModifierBackground = BackgroundKt.m21252backgroundPLcKuY0$default(GlanceModifier.INSTANCE, ImageKt.ImageProvider(imageWithBackgroundData.getBackgroundResId()), 0, null, 6, null);
        } else if (imageWithBackgroundData.getBackgroundColor() != null) {
            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
            ColorProvider backgroundColor = imageWithBackgroundData.getBackgroundColor();
            Intrinsics.checkNotNull(backgroundColor);
            glanceModifierBackground = BackgroundKt.background(companion, backgroundColor);
        } else {
            glanceModifierBackground = GlanceModifier.INSTANCE;
        }
        if (imageWithBackgroundData instanceof ImageButtonData) {
            ImageButtonData imageButtonData = (ImageButtonData) imageWithBackgroundData;
            if (imageButtonData.getOnClick() != null) {
                glanceModifierBackground = SemanticsModifierKt.semantics(ActionKt.clickable(glanceModifierBackground, imageButtonData.getOnClick()), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt$PermissionIcon$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        String contentDescription = imageWithBackgroundData.getContentDescription();
                        if (contentDescription == null) {
                            contentDescription = "";
                        }
                        SemanticsPropertiesKt.setContentDescription(semantics, contentDescription);
                    }
                });
            }
        }
        Debug.INSTANCE.debugBox(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21506size3ABfNKs(glanceModifierBackground, f), C2256Dp.m20968constructorimpl(f / 2)), Alignment.INSTANCE.getCenter(), "Permission1", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1845005544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt$PermissionIcon$2
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
                    ComposerKt.traceEventStart(-1845005544, i2, -1, "androidx.glance.oneui.template.layout.glance.PermissionIcon.<anonymous> (PermissionLayout.kt:126)");
                }
                ImageKt.m21259ImageGCr5PR4(imageWithBackgroundData.getImageProvider(), imageWithBackgroundData.getContentDescription(), AppWidgetModifiersKt.keepColor(GlanceModifierUtilsKt.maybeAnimation(GlanceModifierUtilsKt.contentDescription(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, imageWithBackgroundData.getImageType() == ImageType.Icon ? C2256Dp.m20968constructorimpl(f * 0.6f) : f), imageWithBackgroundData.getContentDescription()), imageWithBackgroundData.getAnimation()), imageWithBackgroundData.getKeepColor()), 0, null, composer2, 8, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt$PermissionIcon$3
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
                    PermissionLayoutKt.m21847PermissionIconkHDZbjc(f, imageWithBackgroundData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: PermissionText-yq-FBXw, reason: not valid java name */
    public static final void m21848PermissionTextyqFBXw(final TextData textData, final int i, final int i2, final int i4, final int i5, boolean z, Composer composer, final int i6, final int i7) {
        Composer composerStartRestartGroup = composer.startRestartGroup(343993904);
        boolean z2 = (i7 & 16) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(343993904, i6, -1, "androidx.glance.oneui.template.layout.glance.PermissionText (PermissionLayout.kt:88)");
        }
        textData.m21679setTextVerticalAlignm3QoQYQ(TextVerticalAlign.INSTANCE.m22053getCenterJ86Ipig());
        textData.m21678setTextAlignb1psNo$glance_oneui_template_release(i2);
        textData.setMaxLines$glance_oneui_template_release(i5);
        TextKt.m21750GlanceText2T94tj4(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), textData, new TextPercentData(0.0f, 0.0f, 0.0f, m21851getTextViewHeightw94YkXw(i, i5, composerStartRestartGroup, ((i6 >> 3) & 14) | ((i6 >> 9) & 112)), TextType.m21682covertToCategoryimpl(i), z2, 7, null), i4, ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground(), textData.getTextColor()), composerStartRestartGroup, (TextPercentData.$stable << 6) | 32832 | (i6 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt$PermissionText$1
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
                    PermissionLayoutKt.m21848PermissionTextyqFBXw(textData, i, i2, i4, i5, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SmallContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2065019051);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065019051, i, -1, "androidx.glance.oneui.template.layout.glance.SmallContent (PermissionLayout.kt:157)");
        }
        CombineTemplateKt.m21658CombineTemplatehlbQeY0(new CombineData(new PrimaryContentData(permissionData.getIcon()), null, null, 6, null), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -560161217, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.SmallContent.1
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
                    ComposerKt.traceEventStart(-560161217, i2, -1, "androidx.glance.oneui.template.layout.glance.SmallContent.<anonymous> (PermissionLayout.kt:161)");
                }
                GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(6), 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 10, null);
                final PermissionData permissionData2 = permissionData;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1327757515, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.SmallContent.1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1327757515, i4, -1, "androidx.glance.oneui.template.layout.glance.SmallContent.<anonymous>.<anonymous> (PermissionLayout.kt:162)");
                        }
                        PermissionLayoutKt.m21848PermissionTextyqFBXw(permissionData2.getMainText(), TextType.INSTANCE.m21689getBodygxbDmow(), TextAlign.INSTANCE.m22011getStartROrN78o(), FontWeight.INSTANCE.m21998getNormalWjrlUT0(), permissionData2.getMainText().getMaxLines(), false, composer3, 56, 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.SmallContent.2
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
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TinyContent(final PermissionData permissionData, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1308403146);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1308403146, i, -1, "androidx.glance.oneui.template.layout.glance.TinyContent (PermissionLayout.kt:139)");
        }
        final TextData mainText = permissionData.getMainText();
        Debug.INSTANCE.debugBox(PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), 0.1f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 432, 12), Alignment.INSTANCE.getCenter(), "Permission2", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1121677985, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.TinyContent.1
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
                    ComposerKt.traceEventStart(-1121677985, i2, -1, "androidx.glance.oneui.template.layout.glance.TinyContent.<anonymous> (PermissionLayout.kt:146)");
                }
                PermissionLayoutKt.m21848PermissionTextyqFBXw(mainText, TextType.INSTANCE.m21693getLabelgxbDmow(), TextAlign.INSTANCE.m22007getCenterROrN78o(), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), permissionData.getMainText().getMaxLines(), true, composer2, 196664, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 221568, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.TinyContent.2
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
        Composer composerStartRestartGroup = composer.startRestartGroup(-1335221026);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1335221026, i, -1, "androidx.glance.oneui.template.layout.glance.WideSmallContent (PermissionLayout.kt:174)");
        }
        CombineTemplateKt.m21658CombineTemplatehlbQeY0(new CombineData(new PrimaryContentData(permissionData.getIcon()), null, null, 6, null), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -187160462, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.WideSmallContent.1
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
                    ComposerKt.traceEventStart(-187160462, i2, -1, "androidx.glance.oneui.template.layout.glance.WideSmallContent.<anonymous> (PermissionLayout.kt:178)");
                }
                GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(6), 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 10, null);
                final PermissionData permissionData2 = permissionData;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer2, 1454253672, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.WideSmallContent.1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i4) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1454253672, i4, -1, "androidx.glance.oneui.template.layout.glance.WideSmallContent.<anonymous>.<anonymous> (PermissionLayout.kt:179)");
                        }
                        TextData mainText = permissionData2.getMainText();
                        TextType.Companion companion = TextType.INSTANCE;
                        int iM21694getTitlegxbDmow = companion.m21694getTitlegxbDmow();
                        TextAlign.Companion companion2 = TextAlign.INSTANCE;
                        int iM22011getStartROrN78o = companion2.m22011getStartROrN78o();
                        FontWeight.Companion companion3 = FontWeight.INSTANCE;
                        PermissionLayoutKt.m21848PermissionTextyqFBXw(mainText, iM21694getTitlegxbDmow, iM22011getStartROrN78o, companion3.m21999getSemiBoldWjrlUT0(), permissionData2.getSubText() != null ? 1 : permissionData2.getMainText().getMaxLines(), false, composer3, 56, 16);
                        TextData subText = permissionData2.getSubText();
                        if (subText != null) {
                            PermissionLayoutKt.m21848PermissionTextyqFBXw(subText, companion.m21689getBodygxbDmow(), companion2.m22011getStartROrN78o(), companion3.m21998getNormalWjrlUT0(), 1, false, composer3, 24632, 16);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.PermissionLayoutKt.WideSmallContent.2
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
    private static final float m21851getTextViewHeightw94YkXw(int i, int i2, Composer composer, int i4) {
        float f;
        composer.startReplaceableGroup(1068354595);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068354595, i4, -1, "androidx.glance.oneui.template.layout.glance.getTextViewHeight (PermissionLayout.kt:59)");
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
