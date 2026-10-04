package androidx.glance;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.color.ColorProviders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"GlanceTheme", "", "colors", "Landroidx/glance/color/ColorProviders;", "content", "Lkotlin/Function0;", "Landroidx/glance/GlanceComposable;", "Landroidx/compose/runtime/Composable;", "(Landroidx/glance/color/ColorProviders;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceTheme.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceTheme.kt\nandroidx/glance/GlanceThemeKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,49:1\n74#2:50\n*S KotlinDebug\n*F\n+ 1 GlanceTheme.kt\nandroidx/glance/GlanceThemeKt\n*L\n41#1:50\n*E\n"})
public final class GlanceThemeKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GlanceTheme(@Nullable final ColorProviders colorProviders, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1977781714);
        if ((i & 14) == 0) {
            i4 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(colorProviders)) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorProviders = (ColorProviders) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalColors());
                    i4 &= -15;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1977781714, i4, -1, "androidx.glance.GlanceTheme (GlanceTheme.kt:42)");
                }
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalColors().provides(colorProviders), content, composerStartRestartGroup, i4 & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i4 &= -15;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalColors().provides(colorProviders), content, composerStartRestartGroup, i4 & 112);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.GlanceThemeKt.GlanceTheme.1
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    GlanceThemeKt.GlanceTheme(colorProviders, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
