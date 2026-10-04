package androidx.glance.appwidget.components;

import android.annotation.SuppressLint;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextKt;
import androidx.glance.text.TextStyle;
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
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ai\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001e\b\u0002\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"TitleBar", "", "startIcon", "Landroidx/glance/ImageProvider;", "title", "", "iconColor", "Landroidx/glance/unit/ColorProvider;", "textColor", "modifier", "Landroidx/glance/GlanceModifier;", "fontFamily", "Landroidx/glance/text/FontFamily;", "actions", "Lkotlin/Function1;", "Landroidx/glance/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/GlanceModifier;Landroidx/glance/text/FontFamily;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTitleBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TitleBar.kt\nandroidx/glance/appwidget/components/TitleBarKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,105:1\n154#2:106\n154#2:107\n*S KotlinDebug\n*F\n+ 1 TitleBar.kt\nandroidx/glance/appwidget/components/TitleBarKt\n*L\n97#1:106\n69#1:107\n*E\n"})
public final class TitleBarKt {
    @Composable
    @SuppressLint({"ComposableLambdaParameterNaming"})
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    public static final void TitleBar(@NotNull final ImageProvider startIcon, @NotNull final String title, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable GlanceModifier glanceModifier, @Nullable FontFamily fontFamily, @Nullable Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i, final int i2) {
        final int i4;
        final ColorProvider onSurface;
        int i5;
        final ColorProvider onSurface2;
        Intrinsics.checkNotNullParameter(startIcon, "startIcon");
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-115331762);
        if ((i2 & 4) != 0) {
            i4 = i;
            onSurface = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface();
            i5 = i4 & (-897);
        } else {
            i4 = i;
            onSurface = colorProvider;
            i5 = i4;
        }
        if ((i2 & 8) != 0) {
            i5 &= -7169;
            onSurface2 = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnSurface();
        } else {
            onSurface2 = colorProvider2;
        }
        GlanceModifier glanceModifier2 = (i2 & 16) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? null : fontFamily;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M21336getLambda1$glance_appwidget_release = (i2 & 64) != 0 ? ComposableSingletons$TitleBarKt.INSTANCE.m21336getLambda1$glance_appwidget_release() : function3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-115331762, i5, -1, "androidx.glance.appwidget.components.TitleBar (TitleBar.kt:64)");
        }
        final FontFamily fontFamily3 = fontFamily2;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3M21336getLambda1$glance_appwidget_release;
        final ColorProvider colorProvider3 = onSurface;
        final ColorProvider colorProvider4 = onSurface2;
        RowKt.m21502RowlMAjyxE(PaddingKt.m21498paddingVpY3zN4$default(SizeModifiersKt.fillMaxWidth(glanceModifier2), 0.0f, C2256Dp.m20968constructorimpl(4), 1, null), 0, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1801178218, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.TitleBarKt.TitleBar.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@NotNull RowScope Row, @Nullable Composer composer2, int i6) {
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1801178218, i6, -1, "androidx.glance.appwidget.components.TitleBar.<anonymous> (TitleBar.kt:99)");
                }
                TitleBarKt.TitleBar$StartIcon(onSurface, startIcon, composer2, 0);
                TitleBarKt.TitleBar$Title(Row, onSurface2, fontFamily3, title, composer2, 8);
                function32.invoke(Row, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 3072, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.TitleBarKt.TitleBar.2
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    TitleBarKt.TitleBar(startIcon, title, colorProvider3, colorProvider4, glanceModifier3, fontFamily3, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void TitleBar$StartIcon(final ColorProvider colorProvider, final ImageProvider imageProvider, Composer composer, int i) {
        composer.startReplaceableGroup(-1386071477);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1386071477, i, -1, "androidx.glance.appwidget.components.TitleBar.StartIcon (TitleBar.kt:66)");
        }
        BoxKt.Box(PaddingKt.m21500paddingqDBjuR0$default(SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(48)), C2256Dp.m20968constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composer, -100804051, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.TitleBarKt$TitleBar$StartIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-100804051, i2, -1, "androidx.glance.appwidget.components.TitleBar.StartIcon.<anonymous> (TitleBar.kt:71)");
                }
                GlanceModifier glanceModifierM21506size3ABfNKs = SizeModifiersKt.m21506size3ABfNKs(GlanceModifier.INSTANCE, C2256Dp.m20968constructorimpl(24));
                ColorProvider colorProvider2 = colorProvider;
                ImageKt.m21259ImageGCr5PR4(imageProvider, "", glanceModifierM21506size3ABfNKs, 0, colorProvider2 != null ? ColorFilter.INSTANCE.tint(colorProvider2) : null, composer2, (ColorFilter.$stable << 12) | 56, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, (Alignment.$stable << 3) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void TitleBar$Title(RowScope rowScope, ColorProvider colorProvider, FontFamily fontFamily, String str, Composer composer, int i) {
        composer.startReplaceableGroup(-1943256666);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1943256666, i, -1, "androidx.glance.appwidget.components.TitleBar.Title (TitleBar.kt:81)");
        }
        TextKt.Text(str, rowScope.defaultWeight(GlanceModifier.INSTANCE), new TextStyle(colorProvider, TextUnit.m21151boximpl(TextUnitKt.getSp(16)), FontWeight.m21989boximpl(FontWeight.INSTANCE.m21997getMediumWjrlUT0()), null, null, null, fontFamily, 0, false, null, null, 0, null, null, 0, 32696, null), 1, 0.0f, composer, 3072, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
