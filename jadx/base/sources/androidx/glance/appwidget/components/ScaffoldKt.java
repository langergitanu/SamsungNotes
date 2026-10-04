package androidx.glance.appwidget.components;

import android.R;
import android.content.Context;
import android.os.Build;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.AppWidgetBackgroundKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m13886d2 = {"Scaffold", "", "modifier", "Landroidx/glance/GlanceModifier;", "titleBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "horizontalPadding", "Landroidx/compose/ui/unit/Dp;", "content", "Scaffold-hGBTI10", "(Landroidx/glance/GlanceModifier;Lkotlin/jvm/functions/Function2;Landroidx/glance/unit/ColorProvider;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScaffold.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scaffold.kt\nandroidx/glance/appwidget/components/ScaffoldKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,79:1\n154#2:80\n74#3:81\n*S KotlinDebug\n*F\n+ 1 Scaffold.kt\nandroidx/glance/appwidget/components/ScaffoldKt\n*L\n51#1:80\n59#1:81\n*E\n"})
public final class ScaffoldKt {
    /* JADX WARN: Removed duplicated region for block: B:39:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable][androidx.glance.GlanceComposable]]")
    /* JADX INFO: renamed from: Scaffold-hGBTI10, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21338ScaffoldhGBTI10(@Nullable GlanceModifier glanceModifier, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable ColorProvider colorProvider, float f, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        float f4;
        ColorProvider widgetBackground;
        final float fM20968constructorimpl;
        GlanceModifier glanceModifierAppWidgetBackground;
        final ColorProvider colorProvider2;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(123646151);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i4 |= 128;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 7168) == 0) {
                f4 = f;
                i4 |= composerStartRestartGroup.changed(f4) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i4 |= 24576;
            } else if ((57344 & i) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
            }
            if (i7 != 4 && (46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                colorProvider2 = colorProvider;
                f5 = f4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        glanceModifier = GlanceModifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    }
                    if (i7 == 0) {
                        widgetBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getWidgetBackground();
                        i4 &= -897;
                    } else {
                        widgetBackground = colorProvider;
                    }
                    if (i8 == 0) {
                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(12);
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(123646151, i4, -1, "androidx.glance.appwidget.components.Scaffold (Scaffold.kt:52)");
                    }
                    glanceModifierAppWidgetBackground = AppWidgetBackgroundKt.appWidgetBackground(BackgroundKt.background(SizeModifiersKt.fillMaxSize(glanceModifier), widgetBackground));
                    boolean z = ((Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext())).getResources().getResourceName(R.dimen.system_app_widget_background_radius) != null;
                    if (Build.VERSION.SDK_INT >= 31 && z) {
                        glanceModifierAppWidgetBackground = CornerRadiusKt.cornerRadius(glanceModifierAppWidgetBackground, R.dimen.system_app_widget_background_radius);
                    }
                    BoxKt.Box(glanceModifierAppWidgetBackground, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1361862747, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$1
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

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer2, int i9) {
                            if ((i9 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1361862747, i9, -1, "androidx.glance.appwidget.components.Scaffold.<anonymous> (Scaffold.kt:69)");
                            }
                            GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            final float f6 = fM20968constructorimpl;
                            final Function2<Composer, Integer, Unit> function23 = content;
                            ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, 0, 0, ComposableLambdaKt.composableLambda(composer2, -2017632145, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i10) {
                                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2017632145, i10, -1, "androidx.glance.appwidget.components.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:70)");
                                    }
                                    Function2<Composer, Integer, Unit> function24 = function22;
                                    composer3.startReplaceableGroup(-365765424);
                                    if (function24 != null) {
                                        function24.invoke(composer3, 0);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer3.endReplaceableGroup();
                                    BoxKt.Box(Column.defaultWeight(PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, f6, 0.0f, 2, null)), null, function23, composer3, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, 384, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    colorProvider2 = widgetBackground;
                    f5 = fM20968constructorimpl;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if (i7 != 0) {
                        i4 &= -897;
                    }
                    widgetBackground = colorProvider;
                }
                fM20968constructorimpl = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                glanceModifierAppWidgetBackground = AppWidgetBackgroundKt.appWidgetBackground(BackgroundKt.background(SizeModifiersKt.fillMaxSize(glanceModifier), widgetBackground));
                if (((Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext())).getResources().getResourceName(R.dimen.system_app_widget_background_radius) != null) {
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    glanceModifierAppWidgetBackground = CornerRadiusKt.cornerRadius(glanceModifierAppWidgetBackground, R.dimen.system_app_widget_background_radius);
                }
                BoxKt.Box(glanceModifierAppWidgetBackground, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1361862747, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$1
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

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i9) {
                        if ((i9 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1361862747, i9, -1, "androidx.glance.appwidget.components.Scaffold.<anonymous> (Scaffold.kt:69)");
                        }
                        GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                        final float f6 = fM20968constructorimpl;
                        final Function2<? super Composer, ? super Integer, Unit> function23 = content;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, 0, 0, ComposableLambdaKt.composableLambda(composer2, -2017632145, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i10) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2017632145, i10, -1, "androidx.glance.appwidget.components.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:70)");
                                }
                                Function2<Composer, Integer, Unit> function24 = function22;
                                composer3.startReplaceableGroup(-365765424);
                                if (function24 != null) {
                                    function24.invoke(composer3, 0);
                                    Unit unit = Unit.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                BoxKt.Box(Column.defaultWeight(PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, f6, 0.0f, 2, null)), null, function23, composer3, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                }
                colorProvider2 = widgetBackground;
                f5 = fM20968constructorimpl;
            }
            final GlanceModifier glanceModifier2 = glanceModifier;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$2
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
                        ScaffoldKt.m21338ScaffoldhGBTI10(glanceModifier2, function22, colorProvider2, f5, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 3072;
        f4 = f;
        if ((i2 & 16) == 0) {
        }
        if (i7 != 4) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                    fM20968constructorimpl = f4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                glanceModifierAppWidgetBackground = AppWidgetBackgroundKt.appWidgetBackground(BackgroundKt.background(SizeModifiersKt.fillMaxSize(glanceModifier), widgetBackground));
                if (((Context) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalContext())).getResources().getResourceName(R.dimen.system_app_widget_background_radius) != null) {
                }
                if (Build.VERSION.SDK_INT >= 31) {
                }
                BoxKt.Box(glanceModifierAppWidgetBackground, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1361862747, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$1
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

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i9) {
                        if ((i9 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1361862747, i9, -1, "androidx.glance.appwidget.components.Scaffold.<anonymous> (Scaffold.kt:69)");
                        }
                        GlanceModifier glanceModifierFillMaxSize = SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE);
                        final Function2<? super Composer, ? super Integer, Unit> function222 = function2;
                        final float f6 = fM20968constructorimpl;
                        final Function2<? super Composer, ? super Integer, Unit> function23 = content;
                        ColumnKt.m21455ColumnK4GKKTE(glanceModifierFillMaxSize, 0, 0, ComposableLambdaKt.composableLambda(composer2, -2017632145, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ScaffoldKt$Scaffold$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                            public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer3, int i10) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2017632145, i10, -1, "androidx.glance.appwidget.components.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:70)");
                                }
                                Function2<Composer, Integer, Unit> function24 = function222;
                                composer3.startReplaceableGroup(-365765424);
                                if (function24 != null) {
                                    function24.invoke(composer3, 0);
                                    Unit unit = Unit.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                BoxKt.Box(Column.defaultWeight(PaddingKt.m21498paddingVpY3zN4$default(GlanceModifier.INSTANCE, f6, 0.0f, 2, null)), null, function23, composer3, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                }
                colorProvider2 = widgetBackground;
                f5 = fM20968constructorimpl;
            }
        }
        final GlanceModifier glanceModifier22 = glanceModifier;
        final Function2<? super Composer, ? super Integer, Unit> function222 = function2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
