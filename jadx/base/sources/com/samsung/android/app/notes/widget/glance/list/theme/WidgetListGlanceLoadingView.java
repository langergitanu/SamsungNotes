package com.samsung.android.app.notes.widget.glance.list.theme;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJ-\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0017¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceLoadingView;", "", "<init>", "()V", "Content", "", "uuidListSize", "", "isMediumOrLarger", "", "themeManager", "Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;", "(IZLcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;Landroidx/compose/runtime/Composer;I)V", "LoadingViewTemplate", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "itemColor", "(ILandroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;ZLandroidx/compose/runtime/Composer;I)V", "LoadingViewTemplateWidgetSmall", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;ZLandroidx/compose/runtime/Composer;I)V", "ItemLoadingView", "(Landroidx/glance/unit/ColorProvider;ZLandroidx/compose/runtime/Composer;I)V", "skeletonBackground", "Landroidx/glance/GlanceModifier;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListGlanceLoadingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlanceLoadingView.kt\ncom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceLoadingView\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,136:1\n149#2:137\n149#2:138\n149#2:139\n*S KotlinDebug\n*F\n+ 1 WidgetListGlanceLoadingView.kt\ncom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceLoadingView\n*L\n99#1:137\n100#1:138\n127#1:139\n*E\n"})
public final class WidgetListGlanceLoadingView {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(WidgetListGlanceLoadingView widgetListGlanceLoadingView, int i, boolean z, WidgetListGlanceTheme widgetListGlanceTheme, int i2, Composer composer, int i4) {
        widgetListGlanceLoadingView.Content(i, z, widgetListGlanceTheme, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemLoadingView$lambda$3(WidgetListGlanceLoadingView widgetListGlanceLoadingView, ColorProvider colorProvider, boolean z, int i, Composer composer, int i2) {
        widgetListGlanceLoadingView.ItemLoadingView(colorProvider, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingViewTemplate$lambda$1(WidgetListGlanceLoadingView widgetListGlanceLoadingView, int i, ColorProvider colorProvider, ColorProvider colorProvider2, boolean z, int i2, Composer composer, int i4) {
        widgetListGlanceLoadingView.LoadingViewTemplate(i, colorProvider, colorProvider2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingViewTemplateWidgetSmall$lambda$2(WidgetListGlanceLoadingView widgetListGlanceLoadingView, ColorProvider colorProvider, ColorProvider colorProvider2, boolean z, int i, Composer composer, int i2) {
        widgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall(colorProvider, colorProvider2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Composable
    public final void Content(final int i, final boolean z, @NotNull final WidgetListGlanceTheme themeManager, @Nullable Composer composer, final int i2) {
        int i4;
        WidgetListGlanceLoadingView widgetListGlanceLoadingView;
        Composer composer2;
        Intrinsics.checkNotNullParameter(themeManager, "themeManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1632843102);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(themeManager) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            widgetListGlanceLoadingView = this;
            i4 |= composerStartRestartGroup.changed(widgetListGlanceLoadingView) ? 2048 : 1024;
        } else {
            widgetListGlanceLoadingView = this;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632843102, i4, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.Content (WidgetListGlanceLoadingView.kt:21)");
            }
            ColorProvider colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(themeManager.isBlackBackground() ? ColorKt.Color(1711341826) : ColorKt.Color(4294769919L), themeManager.getAlphaBackground(), 0.0f, 0.0f, 0.0f, 14, null));
            ColorProvider colorProviderM22055ColorProvider8_81llA2 = ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(themeManager.isBlackBackground() ? 352321535 : 335544320));
            if (z) {
                composerStartRestartGroup.startReplaceGroup(771248581);
                composer2 = composerStartRestartGroup;
                widgetListGlanceLoadingView.LoadingViewTemplate(i, colorProviderM22055ColorProvider8_81llA, colorProviderM22055ColorProvider8_81llA2, true, composer2, (i4 & 14) | 3072 | ((i4 << 3) & 57344));
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(771344743);
                LoadingViewTemplateWidgetSmall(colorProviderM22055ColorProvider8_81llA, colorProviderM22055ColorProvider8_81llA2, false, composerStartRestartGroup, (i4 & 7168) | 384);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceLoadingView.Content$lambda$0(this.f4615a, i, z, themeManager, i2, (Composer) obj, iIntValue);
                }
            });
        }
    }

    @Composable
    public final void ItemLoadingView(@NotNull final ColorProvider itemColor, final boolean z, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(itemColor, "itemColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(540890645);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(itemColor) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(540890645, i2, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.ItemLoadingView (WidgetListGlanceLoadingView.kt:93)");
            }
            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
            RowKt.m21502RowlMAjyxE(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxWidth(companion), C2256Dp.m20968constructorimpl(46), 0.0f, C2256Dp.m20968constructorimpl(18), 0.0f, 10, null), 0, 0, ComposableLambdaKt.rememberComposableLambda(-714859655, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.ItemLoadingView.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(RowScope Row, Composer composer2, int i4) {
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-714859655, i4, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.ItemLoadingView.<anonymous> (WidgetListGlanceLoadingView.kt:102)");
                    }
                    GlanceModifier glanceModifierFillMaxWidth = SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE);
                    final ColorProvider colorProvider = itemColor;
                    ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxWidth, 0, 0, ComposableLambdaKt.rememberComposableLambda(218536431, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.ItemLoadingView.1.1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(ColumnScope Column, Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(218536431, i5, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.ItemLoadingView.<anonymous>.<anonymous> (WidgetListGlanceLoadingView.kt:105)");
                            }
                            GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                            float f = 6;
                            GlanceModifier glanceModifierBackground = BackgroundKt.background(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion2), C2256Dp.m20968constructorimpl(12)), C2256Dp.m20968constructorimpl(f)), colorProvider);
                            ComposableSingletons$WidgetListGlanceLoadingViewKt composableSingletons$WidgetListGlanceLoadingViewKt = ComposableSingletons$WidgetListGlanceLoadingViewKt.INSTANCE;
                            BoxKt.Box(glanceModifierBackground, null, composableSingletons$WidgetListGlanceLoadingViewKt.getLambda$1242099021$ntHomeWidget_release(), composer3, 384, 2);
                            SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion2, C2256Dp.m20968constructorimpl(f)), composer3, 0, 0);
                            BoxKt.Box(BackgroundKt.background(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21505height3ABfNKs(SizeModifiersKt.fillMaxWidth(companion2), C2256Dp.m20968constructorimpl(10)), C2256Dp.m20968constructorimpl(f)), colorProvider), null, composableSingletons$WidgetListGlanceLoadingViewKt.getLambda$557194628$ntHomeWidget_release(), composer3, 384, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
            if (z) {
                SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion, C2256Dp.m20968constructorimpl(20)), composerStartRestartGroup, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceLoadingView.ItemLoadingView$lambda$3(this, itemColor, z, i, (Composer) obj, iIntValue);
                }
            });
        }
    }

    @Composable
    public final void LoadingViewTemplate(final int i, @NotNull final ColorProvider backgroundColor, @NotNull final ColorProvider itemColor, final boolean z, @Nullable Composer composer, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(itemColor, "itemColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1571831821);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(backgroundColor) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(itemColor) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
        }
        if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1571831821, i4, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate (WidgetListGlanceLoadingView.kt:34)");
            }
            BoxKt.Box(BackgroundKt.background(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), backgroundColor), null, ComposableLambdaKt.rememberComposableLambda(-1632624533, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(Composer composer2, int i5) {
                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1632624533, i5, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate.<anonymous> (WidgetListGlanceLoadingView.kt:40)");
                    }
                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    int iM21434getTopmnfRV0w = Alignment.INSTANCE.m21434getTopmnfRV0w();
                    final int i6 = i;
                    final WidgetListGlanceLoadingView widgetListGlanceLoadingView = this;
                    final ColorProvider colorProvider = itemColor;
                    final boolean z2 = z;
                    ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, iM21434getTopmnfRV0w, 0, ComposableLambdaKt.rememberComposableLambda(-1547349579, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate.1.1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(ColumnScope Column, Composer composer3, int i7) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1547349579, i7, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate.<anonymous>.<anonymous> (WidgetListGlanceLoadingView.kt:45)");
                            }
                            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
                            float f = 18;
                            GlanceModifier glanceModifierM21500paddingqDBjuR0$default = PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.fillMaxWidth(companion), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(21), C2256Dp.m20968constructorimpl(f), 0.0f, 8, null);
                            int iM21453getCenterVerticallymnfRV0w = Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w();
                            final ColorProvider colorProvider2 = colorProvider;
                            RowKt.m21502RowlMAjyxE(glanceModifierM21500paddingqDBjuR0$default, 0, iM21453getCenterVerticallymnfRV0w, ComposableLambdaKt.rememberComposableLambda(1591232465, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate.1.1.1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                    invoke(rowScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(RowScope Row, Composer composer4, int i8) {
                                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1591232465, i8, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplate.<anonymous>.<anonymous>.<anonymous> (WidgetListGlanceLoadingView.kt:55)");
                                    }
                                    GlanceModifier.Companion companion2 = GlanceModifier.INSTANCE;
                                    BoxKt.Box(BackgroundKt.background(CornerRadiusKt.m21286cornerRadius3ABfNKs(SizeModifiersKt.m21505height3ABfNKs(Row.defaultWeight(companion2), C2256Dp.m20968constructorimpl(17)), C2256Dp.m20968constructorimpl(6)), colorProvider2), null, ComposableSingletons$WidgetListGlanceLoadingViewKt.INSTANCE.getLambda$149602739$ntHomeWidget_release(), composer4, 384, 2);
                                    SpacerKt.Spacer(SizeModifiersKt.m21508width3ABfNKs(companion2, C2256Dp.m20968constructorimpl(26)), composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 3072, 2);
                            SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(companion, C2256Dp.m20968constructorimpl(f)), composer3, 0, 0);
                            composer3.startReplaceGroup(-944232792);
                            for (int i8 = 0; i8 < i6; i8++) {
                                widgetListGlanceLoadingView.ItemLoadingView(colorProvider, z2, composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            SpacerKt.Spacer(SizeModifiersKt.m21505height3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(24)), composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceLoadingView.LoadingViewTemplate$lambda$1(this.f4604a, i, backgroundColor, itemColor, z, i2, (Composer) obj, iIntValue);
                }
            });
        }
    }

    @Composable
    public final void LoadingViewTemplateWidgetSmall(@NotNull final ColorProvider backgroundColor, @NotNull final ColorProvider itemColor, final boolean z, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(itemColor, "itemColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(482103155);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(backgroundColor) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(itemColor) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(482103155, i2, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall (WidgetListGlanceLoadingView.kt:75)");
            }
            BoxKt.Box(BackgroundKt.background(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), backgroundColor), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.rememberComposableLambda(-1160844971, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1160844971, i4, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall.<anonymous> (WidgetListGlanceLoadingView.kt:82)");
                    }
                    GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                    int iM21431getCenterVerticallymnfRV0w = Alignment.INSTANCE.m21431getCenterVerticallymnfRV0w();
                    final WidgetListGlanceLoadingView widgetListGlanceLoadingView = WidgetListGlanceLoadingView.this;
                    final ColorProvider colorProvider = itemColor;
                    final boolean z2 = z;
                    ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, iM21431getCenterVerticallymnfRV0w, 0, ComposableLambdaKt.rememberComposableLambda(-456683317, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall.1.1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(ColumnScope Column, Composer composer3, int i5) {
                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-456683317, i5, -1, "com.samsung.android.app.notes.widget.glance.list.theme.WidgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall.<anonymous>.<anonymous> (WidgetListGlanceLoadingView.kt:87)");
                            }
                            widgetListGlanceLoadingView.ItemLoadingView(colorProvider, z2, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return WidgetListGlanceLoadingView.LoadingViewTemplateWidgetSmall$lambda$2(this.f4610a, backgroundColor, itemColor, z, i, (Composer) obj, iIntValue);
                }
            });
        }
    }

    @NotNull
    public final GlanceModifier skeletonBackground(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(BackgroundKt.background(GlanceModifier.INSTANCE, ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4292927712L))));
    }
}
