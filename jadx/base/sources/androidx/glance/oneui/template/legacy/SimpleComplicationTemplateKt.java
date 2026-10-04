package androidx.glance.oneui.template.legacy;

import android.os.Build;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnitKt;
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
import androidx.glance.appwidget.lazy.GridCells;
import androidx.glance.appwidget.lazy.LazyItemScope;
import androidx.glance.appwidget.lazy.LazyVerticalGridKt;
import androidx.glance.appwidget.lazy.LazyVerticalGridScope;
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
import androidx.glance.text.FontWeight;
import androidx.glance.unit.ColorProvider;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a5\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\b\u001a3\u0010\f\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\u000b\u001a+\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\b¨\u0006\u000e"}, m13886d2 = {"SimpleComplicationTemplate", "", "item", "Landroidx/glance/oneui/template/legacy/SimpleTemplateItem;", "action", "Landroidx/glance/action/Action;", "contentDescription", "", "(Landroidx/glance/oneui/template/legacy/SimpleTemplateItem;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", XmlErrorCodes.LIST, "", "(Ljava/util/List;Landroidx/glance/action/Action;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WidgetLayoutSmall", "WidgetLayoutTiny", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSimpleComplicationTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleComplicationTemplate.kt\nandroidx/glance/oneui/template/legacy/SimpleComplicationTemplateKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,288:1\n74#2:289\n*S KotlinDebug\n*F\n+ 1 SimpleComplicationTemplate.kt\nandroidx/glance/oneui/template/legacy/SimpleComplicationTemplateKt\n*L\n97#1:289\n*E\n"})
public final class SimpleComplicationTemplateKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void SimpleComplicationTemplate(@NotNull final SimpleTemplateItem item, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        Action action2;
        String str2;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer composerStartRestartGroup = composer.startRestartGroup(683092516);
        Action action3 = (i2 & 2) != 0 ? null : action;
        String str3 = (i2 & 4) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(683092516, i, -1, "androidx.glance.oneui.template.legacy.SimpleComplicationTemplate (SimpleComplicationTemplate.kt:92)");
        }
        if (Build.VERSION.SDK_INT > 34) {
            composerStartRestartGroup.startReplaceableGroup(455781937);
            BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str3, composerStartRestartGroup, ((i >> 3) & 112) | 6, 0), null, ComposableSingletons$SimpleComplicationTemplateKt.INSTANCE.m21884getLambda1$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
            composerStartRestartGroup.endReplaceableGroup();
            action2 = action3;
            str2 = str3;
        } else {
            composerStartRestartGroup.startReplaceableGroup(455782050);
            if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4())) {
                composerStartRestartGroup.startReplaceableGroup(455782128);
                action2 = action3;
                str2 = str3;
                WidgetLayoutSmall(item, action2, str2, composerStartRestartGroup, (i & 896) | 72, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                action2 = action3;
                str2 = str3;
                composerStartRestartGroup.startReplaceableGroup(455782200);
                WidgetLayoutTiny(item, action2, str2, composerStartRestartGroup, (i & 896) | 72, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.SimpleComplicationTemplate.1
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
                    SimpleComplicationTemplateKt.SimpleComplicationTemplate(item, action4, str4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutSmall(final SimpleTemplateItem simpleTemplateItem, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1855485425);
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1855485425, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall (SimpleComplicationTemplate.kt:216)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=simple, size=small dataType=single action=" + action);
        BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 142565587, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.1
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
                    ComposerKt.traceEventStart(142565587, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous> (SimpleComplicationTemplate.kt:222)");
                }
                GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), 0.0f, C2256Dp.m20968constructorimpl(2), C2256Dp.m20968constructorimpl(1), 0.0f, 9, null);
                int iM21453getCenterVerticallymnfRV0w = Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w();
                final SimpleTemplateItem simpleTemplateItem2 = simpleTemplateItem;
                RowKt.m21502RowlMAjyxE(glanceModifierM21500paddingqDBjuR0$default, 0, iM21453getCenterVerticallymnfRV0w, ComposableLambdaKt.composableLambda(composer2, -1029689545, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.1.1
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
                            ComposerKt.traceEventStart(-1029689545, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous> (SimpleComplicationTemplate.kt:226)");
                        }
                        GlanceModifier glanceModifierM21508width3ABfNKs = SizeModifiersKt.m21508width3ABfNKs(SizeModifiersKt.wrapContentHeight(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(59));
                        final SimpleTemplateItem simpleTemplateItem3 = simpleTemplateItem2;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21508width3ABfNKs, 0, 0, ComposableLambdaKt.composableLambda(composer3, 177984301, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.1.1.1
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
                                    ComposerKt.traceEventStart(177984301, i6, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (SimpleComplicationTemplate.kt:227)");
                                }
                                String text2 = simpleTemplateItem3.getText2();
                                composer4.startReplaceableGroup(-1368795579);
                                if (text2 != null) {
                                    GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(simpleTemplateItem3.getText2(), TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnSecondary(), null, 0, composer4, 560, 24);
                                    AbstractC2821a.m2232w(1, GlanceModifier.INSTANCE, composer4, 0, 0);
                                    Unit unit = Unit.INSTANCE;
                                }
                                composer4.endReplaceableGroup();
                                if (simpleTemplateItem3.getText1() != null) {
                                    GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(simpleTemplateItem3.getText1(), TextType.INSTANCE.m21691getDisplaygxbDmow(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnPrimary(), null, 0, composer4, 560, 24);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 3072, 6);
                        if (simpleTemplateItem2.getIcon() != null) {
                            GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(simpleTemplateItem2.getIcon(), IconSize.INSTANCE.m21902getExtraLargeAKcXBXg(), composer3, 56);
                        }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.2
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
                    SimpleComplicationTemplateKt.WidgetLayoutSmall(simpleTemplateItem, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutTiny(final SimpleTemplateItem simpleTemplateItem, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(95660832);
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(95660832, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny (SimpleComplicationTemplate.kt:134)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=simple size=tiny dataType=single action=" + action);
        BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 733142014, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutTiny.1
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
                    ComposerKt.traceEventStart(733142014, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous> (SimpleComplicationTemplate.kt:140)");
                }
                GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                final SimpleTemplateItem simpleTemplateItem2 = simpleTemplateItem;
                ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, 0, iM21430getCenterHorizontallyPGIyAqw, ComposableLambdaKt.composableLambda(composer2, 1557934792, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutTiny.1.1
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
                        int i6;
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1557934792, i5, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous>.<anonymous> (SimpleComplicationTemplate.kt:144)");
                        }
                        if (simpleTemplateItem2.getText1() != null) {
                            composer3.startReplaceableGroup(483178817);
                            if (simpleTemplateItem2.getText2() == null || (simpleTemplateItem2.getIcon() == null && simpleTemplateItem2.getText3() == null)) {
                                composer3.startReplaceableGroup(483180932);
                                GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                                AbstractC2821a.m2232w(6, companion, composer3, 0, 0);
                                ImageData icon = simpleTemplateItem2.getIcon();
                                composer3.startReplaceableGroup(483181066);
                                if (icon != null) {
                                    GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(simpleTemplateItem2.getIcon(), IconSize.INSTANCE.m21906getSmallAKcXBXg(), composer3, 56);
                                    AbstractC2821a.m2232w(1, companion, composer3, 0, 0);
                                    Unit unit = Unit.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                String text2 = simpleTemplateItem2.getText2();
                                composer3.startReplaceableGroup(483181296);
                                if (text2 != null) {
                                    GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(simpleTemplateItem2.getText2(), TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnSecondary(), null, 0, composer3, 560, 24);
                                    AbstractC2821a.m2232w(4, companion, composer3, 0, 0);
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(simpleTemplateItem2.getText1(), TextType.INSTANCE.m21691getDisplaygxbDmow(), GlanceTheme.INSTANCE.getColors(composer3, GlanceTheme.$stable).getOnPrimary(), null, 0, composer3, 560, 24);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(483178906);
                                ImageData icon2 = simpleTemplateItem2.getIcon();
                                composer3.startReplaceableGroup(483178939);
                                if (icon2 == null) {
                                    i6 = 13;
                                } else {
                                    SimpleTemplateItem simpleTemplateItem3 = simpleTemplateItem2;
                                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                    float f = (float) 2.5d;
                                    AbstractC2821a.m2232w(f, companion2, composer3, 0, 0);
                                    GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(simpleTemplateItem3.getIcon(), IconSize.INSTANCE.m21907getTinyAKcXBXg(), composer3, 56);
                                    String text1 = simpleTemplateItem3.getText1();
                                    GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                                    int i7 = GlanceTheme.$stable;
                                    ColorProvider onPrimary = glanceTheme.getColors(composer3, i7).getOnPrimary();
                                    long sp = TextUnitKt.getSp(13);
                                    FontWeight.Companion companion3 = FontWeight.INSTANCE;
                                    i6 = 13;
                                    GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(text1, onPrimary, sp, 0, 0, 0, companion3.m21999getSemiBoldWjrlUT0(), null, 0, composer3, 448, 440);
                                    GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(simpleTemplateItem3.getText2(), glanceTheme.getColors(composer3, i7).getOnPrimary(), TextUnitKt.getSp(12), 0, 0, 0, companion3.m21998getNormalWjrlUT0(), null, 0, composer3, 448, 440);
                                    AbstractC2821a.m2232w(f, companion2, composer3, 0, 0);
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                if (simpleTemplateItem2.getText3() != null) {
                                    SimpleTemplateItem simpleTemplateItem4 = simpleTemplateItem2;
                                    GlanceModifier.Companion companion4 = GlanceModifier.INSTANCE;
                                    float f4 = 2;
                                    AbstractC2821a.m2232w(f4, companion4, composer3, 0, 0);
                                    String text22 = simpleTemplateItem4.getText2();
                                    GlanceTheme glanceTheme2 = GlanceTheme.INSTANCE;
                                    int i8 = GlanceTheme.$stable;
                                    ColorProvider onTertiary = glanceTheme2.getColors(composer3, i8).getOnTertiary();
                                    long sp2 = TextUnitKt.getSp(12);
                                    FontWeight.Companion companion5 = FontWeight.INSTANCE;
                                    GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(text22, onTertiary, sp2, 0, 0, 0, companion5.m21998getNormalWjrlUT0(), null, 0, composer3, 448, 440);
                                    GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(simpleTemplateItem4.getText1(), glanceTheme2.getColors(composer3, i8).getOnTertiary(), TextUnitKt.getSp(i6), 0, 0, 0, companion5.m21999getSemiBoldWjrlUT0(), null, 0, composer3, 448, 440);
                                    GlanceAppWidgetTemplatesKt.m21892TemplateText5OKhOMc(simpleTemplateItem4.getText3(), glanceTheme2.getColors(composer3, i8).getOnTertiary(), TextUnitKt.getSp(12), 0, 0, 0, companion5.m21998getNormalWjrlUT0(), null, 0, composer3, 448, 440);
                                    AbstractC2821a.m2232w(f4, companion4, composer3, 0, 0);
                                }
                                composer3.endReplaceableGroup();
                            }
                            composer3.endReplaceableGroup();
                        } else if (simpleTemplateItem2.getIcon() != null) {
                            composer3.startReplaceableGroup(483181642);
                            GlanceModifier glanceModifierFillMaxSize2 = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            final SimpleTemplateItem simpleTemplateItem5 = simpleTemplateItem2;
                            BoxKt.Box(glanceModifierFillMaxSize2, center, ComposableLambdaKt.composableLambda(composer3, 562667686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutTiny.1.1.5
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
                                public final void invoke(@Nullable Composer composer4, int i9) {
                                    if ((i9 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(562667686, i9, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutTiny.<anonymous>.<anonymous>.<anonymous> (SimpleComplicationTemplate.kt:204)");
                                    }
                                    GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(simpleTemplateItem5.getIcon(), IconSize.INSTANCE.m21904getLargeAKcXBXg(), composer4, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, (Alignment.$stable << 3) | 384, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(483181859);
                            composer3.endReplaceableGroup();
                        }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutTiny.2
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
                    SimpleComplicationTemplateKt.WidgetLayoutTiny(simpleTemplateItem, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void WidgetLayoutSmall(List<SimpleTemplateItem> list, final Action action, String str, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1231554608);
        if ((i2 & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        final List<SimpleTemplateItem> list2 = list;
        if ((i2 & 4) != 0) {
            str = null;
        }
        final String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1231554608, i, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall (SimpleComplicationTemplate.kt:245)");
        }
        GlanceLog.INSTANCE.m2297d(GlanceTemplateLayout.TAG, "templateName=simple size=small dataType=multiple action=" + action);
        final int iCoerceAtMost = RangesKt.coerceAtMost(list2.size(), 3);
        final boolean z = list2.get(0).getIcon() != null;
        BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(action, str2, composerStartRestartGroup, ((i >> 3) & 112) | 8, 0), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 379893298, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.3
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
                    ComposerKt.traceEventStart(379893298, i4, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous> (SimpleComplicationTemplate.kt:253)");
                }
                float f = (float) 5.75d;
                GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), C2256Dp.m20968constructorimpl(f), 0.0f, C2256Dp.m20968constructorimpl(f), 0.0f, 10, null);
                int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                GridCells.Fixed fixed = new GridCells.Fixed(iCoerceAtMost);
                final int i5 = iCoerceAtMost;
                final boolean z2 = z;
                final List<SimpleTemplateItem> list3 = list2;
                LazyVerticalGridKt.m21348LazyVerticalGridca5uSD8(fixed, glanceModifierM21500paddingqDBjuR0$default, iM21430getCenterHorizontallyPGIyAqw, new Function1<LazyVerticalGridScope, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyVerticalGridScope lazyVerticalGridScope) {
                        invoke2(lazyVerticalGridScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LazyVerticalGridScope LazyVerticalGrid) {
                        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
                        int i6 = i5;
                        final boolean z3 = z2;
                        final List<SimpleTemplateItem> list4 = list3;
                        LazyVerticalGridScope.items$default(LazyVerticalGrid, i6, null, ComposableLambdaKt.composableLambdaInstance(1311114803, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.3.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                            @Composable
                            public final void invoke(@NotNull LazyItemScope items, final int i7, @Nullable Composer composer3, int i8) {
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1311114803, i8, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous> (SimpleComplicationTemplate.kt:261)");
                                }
                                float f4 = (float) 1.25d;
                                GlanceModifier glanceModifierM21500paddingqDBjuR0$default2 = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.m21508width3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl((float) 37.5d)), C2256Dp.m20968constructorimpl(f4), 0.0f, C2256Dp.m20968constructorimpl(f4), 0.0f, 10, null);
                                Alignment.Companion companion = Alignment.INSTANCE;
                                int iM21430getCenterHorizontallyPGIyAqw2 = companion.m21430getCenterHorizontallyPGIyAqw();
                                int iM21431getCenterVerticallymnfRV0w = companion.m21431getCenterVerticallymnfRV0w();
                                final boolean z4 = z3;
                                final List<SimpleTemplateItem> list5 = list4;
                                ColumnKt.m21455ColumnK4GKKTE(glanceModifierM21500paddingqDBjuR0$default2, iM21431getCenterVerticallymnfRV0w, iM21430getCenterHorizontallyPGIyAqw2, ComposableLambdaKt.composableLambda(composer3, -1688203479, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.3.1.1.1
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
                                    public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer4, int i9) {
                                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1688203479, i9, -1, "androidx.glance.oneui.template.legacy.WidgetLayoutSmall.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SimpleComplicationTemplate.kt:268)");
                                        }
                                        if (z4) {
                                            composer4.startReplaceableGroup(171579600);
                                            ImageData icon = list5.get(i7).getIcon();
                                            composer4.startReplaceableGroup(171579644);
                                            if (icon != null) {
                                                GlanceAppWidgetTemplatesKt.m21888TemplateIcon3Tup6A(icon, IconSize.INSTANCE.m21905getMediumAKcXBXg(), composer4, 56);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer4.endReplaceableGroup();
                                            String text1 = list5.get(i7).getText1();
                                            if (text1 != null) {
                                                GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text1, TextType.INSTANCE.m21692getHeadlinegxbDmow(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnPrimary(), null, 0, composer4, 560, 24);
                                            }
                                            composer4.endReplaceableGroup();
                                        } else {
                                            composer4.startReplaceableGroup(171579882);
                                            String text12 = list5.get(i7).getText1();
                                            composer4.startReplaceableGroup(171579927);
                                            if (text12 != null) {
                                                GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text12, TextType.INSTANCE.m21694getTitlegxbDmow(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnPrimary(), null, 0, composer4, 560, 24);
                                                AbstractC2821a.m2232w(4, GlanceModifier.INSTANCE, composer4, 0, 0);
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            composer4.endReplaceableGroup();
                                            String text2 = list5.get(i7).getText2();
                                            if (text2 != null) {
                                                GlanceAppWidgetTemplatesKt.m21893TemplateTexte4lg5Cc(text2, TextType.INSTANCE.m21692getHeadlinegxbDmow(), GlanceTheme.INSTANCE.getColors(composer4, GlanceTheme.$stable).getOnSecondary(), null, 0, composer4, 560, 24);
                                            }
                                            composer4.endReplaceableGroup();
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
                        }), 2, null);
                    }
                }, composer2, GridCells.Fixed.$stable, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.WidgetLayoutSmall.4
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
                    SimpleComplicationTemplateKt.WidgetLayoutSmall(list2, action, str2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
    @Composable
    public static final void SimpleComplicationTemplate(@Nullable List<SimpleTemplateItem> list, @Nullable Action action, @Nullable String str, @Nullable Composer composer, final int i, final int i2) {
        List<SimpleTemplateItem> list2;
        Action action2;
        String str2;
        final List<SimpleTemplateItem> list3;
        final Action action3;
        final String str3;
        Composer composerStartRestartGroup = composer.startRestartGroup(270381379);
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
                ComposerKt.traceEventStart(270381379, i5, -1, "androidx.glance.oneui.template.legacy.SimpleComplicationTemplate (SimpleComplicationTemplate.kt:121)");
            }
            if (Build.VERSION.SDK_INT > 34) {
                composerStartRestartGroup.startReplaceableGroup(455783074);
                BoxKt.Box(GlanceAppWidgetTemplatesKt.createTopLevelModifier(null, str, composerStartRestartGroup, ((i5 >> 3) & 112) | 6, 0), null, ComposableSingletons$SimpleComplicationTemplateKt.INSTANCE.m21885getLambda2$glance_oneui_template_release(), composerStartRestartGroup, 384, 2);
                composerStartRestartGroup.endReplaceableGroup();
                list2 = list;
                action2 = action;
                str2 = str;
            } else if (!list.isEmpty()) {
                composerStartRestartGroup.startReplaceableGroup(455783210);
                list2 = list;
                action2 = action;
                str2 = str;
                WidgetLayoutSmall(list2, action2, str2, composerStartRestartGroup, (i5 & 896) | 72, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                list2 = list;
                action2 = action;
                str2 = str;
                composerStartRestartGroup.startReplaceableGroup(455783277);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.SimpleComplicationTemplateKt.SimpleComplicationTemplate.2
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
                    SimpleComplicationTemplateKt.SimpleComplicationTemplate(list3, action3, str3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
