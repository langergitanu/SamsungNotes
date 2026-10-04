package androidx.glance.oneui.template.legacy;

import android.os.Build;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.action.Action;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.unit.ColorProvider;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a5\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\b\u001a3\u0010\f\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\u000b\u001a+\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\b¨\u0006\u000e"}, m13886d2 = {"SummaryComplicationTemplate", "", "item", "Landroidx/glance/oneui/template/legacy/SummaryTemplateItem;", "action", "Landroidx/glance/action/Action;", "contentDescription", "", "(Landroidx/glance/oneui/template/legacy/SummaryTemplateItem;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", XmlErrorCodes.LIST, "", "(Ljava/util/List;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WidgetLayoutSmall", "WidgetLayoutTiny", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSummaryComplicationTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SummaryComplicationTemplate.kt\nandroidx/glance/oneui/template/legacy/SummaryComplicationTemplateKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,247:1\n74#2:248\n164#3:249\n154#3:250\n*S KotlinDebug\n*F\n+ 1 SummaryComplicationTemplate.kt\nandroidx/glance/oneui/template/legacy/SummaryComplicationTemplateKt\n*L\n84#1:248\n166#1:249\n218#1:250\n*E\n"})
public final class SummaryComplicationTemplateKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void SummaryComplicationTemplate(@NotNull final SummaryTemplateItem item, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        Action action2;
        String str2;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1119764042);
        Action action3 = (i2 & 2) != 0 ? null : action;
        String str3 = (i2 & 4) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1119764042, i, -1, "androidx.glance.oneui.template.legacy.SummaryComplicationTemplate (SummaryComplicationTemplate.kt:79)");
        }
        if (Build.VERSION.SDK_INT > 34) {
            composerStartRestartGroup.startReplaceableGroup(-18211643);
            BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str3, composerStartRestartGroup, ((i >> 3) & 112) | 6, 0), null, ComposableSingletons$SummaryComplicationTemplateKt.INSTANCE.m21886getLambda1$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
            composerStartRestartGroup.endReplaceableGroup();
            action2 = action3;
            str2 = str3;
        } else {
            composerStartRestartGroup.startReplaceableGroup(-18211530);
            if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(-18211453);
                action2 = action3;
                str2 = str3;
                WidgetLayoutTiny(item, action2, str2, composerStartRestartGroup, (i & 896) | 72, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                action2 = action3;
                str2 = str3;
                composerStartRestartGroup.startReplaceableGroup(-18211382);
                WidgetLayoutSmall(item, action2, str2, composerStartRestartGroup, (i & 896) | 72, 0);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Action action4 = action2;
            final String str4 = str2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.SummaryComplicationTemplate.1
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
                    SummaryComplicationTemplateKt.SummaryComplicationTemplate(item, action4, str4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutSmall(final SummaryTemplateItem summaryTemplateItem, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1655263589);
        final String str2 = (i2 & 4) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1655263589, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall (SummaryComplicationTemplate.kt:160)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=summary size=small dataType=single action=" + action);
        ColumnKt.m21455ColumnK4GKKTE(PaddingKt.m21498paddingVpY3zN4$default(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), 0.0f, C2256Dp.m20968constructorimpl((float) 2.5d), 1, null), Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), 0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 270718949, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.1
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
            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i4) {
                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(270718949, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous> (SummaryComplicationTemplate.kt:168)");
                }
                final ImageData icon = summaryTemplateItem.getIcon();
                composer2.startReplaceableGroup(1063114475);
                if (icon != null) {
                    final SummaryTemplateItem summaryTemplateItem2 = summaryTemplateItem;
                    RowKt.m21502RowlMAjyxE(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), C2256Dp.m20968constructorimpl(7), 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 10, null), 0, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer2, -824173503, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt$WidgetLayoutSmall$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-824173503, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:176)");
                            }
                            GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21907getTinyAKcXBXg(), composer3, 56);
                            int i6 = 1;
                            AbstractC2821a.m2232w(1, GlanceModifier.INSTANCE, composer3, 0, 0);
                            String text1 = summaryTemplateItem2.getText1();
                            int iM21689getBodygxbDmow = TextType.INSTANCE.m21689getBodygxbDmow();
                            ColorProvider onPrimary = GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary();
                            if (summaryTemplateItem2.getText2() == null && summaryTemplateItem2.getText3() == null) {
                                i6 = 3;
                            }
                            GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text1, iM21689getBodygxbDmow, onPrimary, null, i6, composer3, 560, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 2);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceableGroup();
                GlanceModifier glanceModifierM21498paddingVpY3zN4$default = PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), C2256Dp.m20968constructorimpl(8), 0.0f, 2, null);
                final SummaryTemplateItem summaryTemplateItem3 = summaryTemplateItem;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21498paddingVpY3zN4$default, 0, 0, ComposableLambdaKt.composableLambda(composer2, 777244719, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.1.2
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
                    public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(777244719, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:189)");
                        }
                        composer3.startReplaceableGroup(842082623);
                        if (summaryTemplateItem3.getIcon() == null) {
                            GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(summaryTemplateItem3.getText1(), TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary(), null, (summaryTemplateItem3.getText2() == null && summaryTemplateItem3.getText3() == null) ? 3 : 1, composer3, 560, 8);
                        }
                        composer3.endReplaceableGroup();
                        String text2 = summaryTemplateItem3.getText2();
                        composer3.startReplaceableGroup(842082938);
                        if (text2 != null) {
                            SummaryTemplateItem summaryTemplateItem4 = summaryTemplateItem3;
                            GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text2, summaryTemplateItem4.getText3() == null ? TextType.INSTANCE.m21693getLabelgxbDmow() : TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary(), null, summaryTemplateItem4.getText3() == null ? 2 : 1, composer3, 512, 8);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                        String text3 = summaryTemplateItem3.getText3();
                        if (text3 != null) {
                            GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text3, TextType.INSTANCE.m21693getLabelgxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary(), null, 0, composer3, 560, 24);
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
        }), composerStartRestartGroup, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.2
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
                    SummaryComplicationTemplateKt.WidgetLayoutSmall(summaryTemplateItem, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutTiny(final SummaryTemplateItem summaryTemplateItem, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-629582838);
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-629582838, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny (SummaryComplicationTemplate.kt:121)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=summary size=tiny dataType=single action=" + action);
        BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2104477032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutTiny.1
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
                    ComposerKt.traceEventStart(2104477032, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous> (SummaryComplicationTemplate.kt:127)");
                }
                GlanceModifier glanceModifierWrapContentSize = SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE);
                int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                final SummaryTemplateItem summaryTemplateItem2 = summaryTemplateItem;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierWrapContentSize, 0, iM21430getCenterHorizontallyPGIyAqw, ComposableLambdaKt.composableLambda(composer2, 161386930, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutTiny.1.1
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
                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(161386930, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:131)");
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        GlanceModifier glanceModifierM21508width3ABfNKs = SizeModifiersKt.m21508width3ABfNKs(SizeModifiersKt.wrapContentHeight(companion), C2256Dp.m20968constructorimpl(40));
                        final SummaryTemplateItem summaryTemplateItem3 = summaryTemplateItem2;
                        BoxKt.Box(glanceModifierM21508width3ABfNKs, null, ComposableLambdaKt.composableLambda(composer3, 311539220, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutTiny.1.1.1
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
                            public final void invoke(@Nullable Composer composer4, int i6) {
                                if ((i6 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(311539220, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:132)");
                                }
                                final ImageData icon = summaryTemplateItem3.getIcon();
                                composer4.startReplaceableGroup(1059091140);
                                if (icon != null) {
                                    ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, Alignment.INSTANCE.m21433getStartPGIyAqw(), ComposableLambdaKt.composableLambda(composer4, 1854270666, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt$WidgetLayoutTiny$1$1$1$1$1
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
                                        public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer5, int i7) {
                                            Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1854270666, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:137)");
                                            }
                                            GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21907getTinyAKcXBXg(), composer5, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer4, 3072, 2);
                                    Unit unit = Unit.INSTANCE;
                                }
                                composer4.endReplaceableGroup();
                                if (summaryTemplateItem3.getText2() != null) {
                                    final SummaryTemplateItem summaryTemplateItem4 = summaryTemplateItem3;
                                    ColumnKt.m21455ColumnK4GKKTE(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0, Alignment.INSTANCE.m21432getEndPGIyAqw(), ComposableLambdaKt.composableLambda(composer4, -948815401, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt$WidgetLayoutTiny$1$1$1$2$1
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
                                        public final void invoke(@NotNull ColumnScope Column2, @Nullable Composer composer5, int i7) {
                                            Intrinsics.checkNotNullParameter(Column2, "$this$Column");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-948815401, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:145)");
                                            }
                                            GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(summaryTemplateItem4.getText2(), TextType.INSTANCE.m21693getLabelgxbDmow(), GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnPrimary(), null, 0, composer5, 560, 24);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer4, 3072, 2);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 384, 2);
                        AbstractC2821a.m2232w(1, companion, composer3, 0, 0);
                        GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(summaryTemplateItem2.getText1(), TextType.INSTANCE.m21691getDisplaygxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary(), null, 0, composer3, 560, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutTiny.2
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
                    SummaryComplicationTemplateKt.WidgetLayoutTiny(summaryTemplateItem, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutSmall(final List<SummaryTemplateItem> list, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556551562);
        if ((i2 & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1556551562, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall (SummaryComplicationTemplate.kt:215)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=summary size=small dataType=multiple action=" + action);
        final float fM20968constructorimpl = C2256Dp.m20968constructorimpl((float) 17);
        BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1153693268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.3
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
                    ComposerKt.traceEventStart(1153693268, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous> (SummaryComplicationTemplate.kt:222)");
                }
                GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                final List<SummaryTemplateItem> list2 = list;
                final float f = fM20968constructorimpl;
                RowKt.m21502RowlMAjyxE(glanceModifierWrapContentHeight, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1224764048, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                        invoke(rowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Row, "$this$Row");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1224764048, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:223)");
                        }
                        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                        float f4 = 5;
                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(f4), 0.0f, 0.0f, 0.0f, 14, null);
                        final List<SummaryTemplateItem> list3 = list2;
                        final float f5 = f;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default, 0, 0, ComposableLambdaKt.composableLambda(composer3, 1432009146, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.3.1.1
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i6) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1432009146, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:224)");
                                }
                                for (final SummaryTemplateItem summaryTemplateItem : list3) {
                                    RowKt.m21502RowlMAjyxE(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.wrapContentWidth(GlanceModifier.INSTANCE), f5), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer4, 1005578932, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.3.1.1.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                            invoke(rowScope, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                        @Composable
                                        public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer5, int i7) {
                                            Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1005578932, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:229)");
                                            }
                                            ImageData icon = summaryTemplateItem.getIcon();
                                            if (icon != null) {
                                                GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21907getTinyAKcXBXg(), composer5, 56);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer4, 3072, 2);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 3072, 6);
                        GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(companion), C2256Dp.m20968constructorimpl(2), 0.0f, C2256Dp.m20968constructorimpl(f4), 0.0f, 10, null);
                        final List<SummaryTemplateItem> list4 = list2;
                        final float f6 = f;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default2, 0, 0, ComposableLambdaKt.composableLambda(composer3, -1899103517, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.3.1.2
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i6) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1899103517, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:234)");
                                }
                                for (final SummaryTemplateItem summaryTemplateItem : list4) {
                                    RowKt.m21502RowlMAjyxE(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), f6), 0, Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composer4, 618321245, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.3.1.2.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer5, Integer num) {
                                            invoke(rowScope, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                        @Composable
                                        public final void invoke(@NotNull RowScope Row2, @Nullable Composer composer5, int i7) {
                                            Intrinsics.checkNotNullParameter(Row2, "$this$Row");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(618321245, i7, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SummaryComplicationTemplate.kt:239)");
                                            }
                                            GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(summaryTemplateItem.getText1(), TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer5, GlanceTheme.$stable).getOnSecondary(), null, 0, composer5, 560, 24);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer4, 3072, 2);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List<SummaryTemplateItem> list2 = list;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.WidgetLayoutSmall.4
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
                    SummaryComplicationTemplateKt.WidgetLayoutSmall(list2, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void SummaryComplicationTemplate(@Nullable List<SummaryTemplateItem> list, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        List<SummaryTemplateItem> list2;
        Action action2;
        String str2;
        final List<SummaryTemplateItem> list3;
        final Action action3;
        final String str3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-753179973);
        int i4 = i2 & 1;
        int i5 = i4 != 0 ? i | 2 : i;
        int i6 = i2 & 2;
        if (i6 != 0) {
            i5 |= 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i2 & 3) == 3 && (i5 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            list3 = list;
            action3 = action;
            str3 = str;
        } else {
            if (i4 != 0) {
                list = CollectionsKt.emptyList();
            }
            if (i6 != 0) {
                action = null;
            }
            if (i7 != 0) {
                str = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-753179973, i5, -1, "androidx.glance.oneui.template.legacy.SummaryComplicationTemplate (SummaryComplicationTemplate.kt:108)");
            }
            if (Build.VERSION.SDK_INT > 34) {
                composerStartRestartGroup.startReplaceableGroup(-18210503);
                BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str, composerStartRestartGroup, ((i5 >> 3) & 112) | 6, 0), null, ComposableSingletons$SummaryComplicationTemplateKt.INSTANCE.m21887getLambda2$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
                composerStartRestartGroup.endReplaceableGroup();
                list2 = list;
                action2 = action;
                str2 = str;
            } else if (!list.isEmpty()) {
                composerStartRestartGroup.startReplaceableGroup(-18210367);
                list2 = list;
                action2 = action;
                str2 = str;
                WidgetLayoutSmall(list2, action2, str2, composerStartRestartGroup, (i5 & 896) | 72, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                list2 = list;
                action2 = action;
                str2 = str;
                composerStartRestartGroup.startReplaceableGroup(-18210300);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            list3 = list2;
            action3 = action2;
            str3 = str2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SummaryComplicationTemplateKt.SummaryComplicationTemplate.2
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
                    SummaryComplicationTemplateKt.SummaryComplicationTemplate(list3, action3, str3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
