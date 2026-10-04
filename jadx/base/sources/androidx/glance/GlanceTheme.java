package androidx.glance;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.color.ColorProviders;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/GlanceTheme;", "", "()V", "colors", "Landroidx/glance/color/ColorProviders;", "getColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/color/ColorProviders;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceTheme.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceTheme.kt\nandroidx/glance/GlanceTheme\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,49:1\n74#2:50\n*S KotlinDebug\n*F\n+ 1 GlanceTheme.kt\nandroidx/glance/GlanceTheme\n*L\n31#1:50\n*E\n"})
public final class GlanceTheme {
    public static final int $stable = 0;

    @NotNull
    public static final GlanceTheme INSTANCE = new GlanceTheme();

    private GlanceTheme() {
    }

    @GlanceComposable
    @JvmName(name = "getColors")
    @NotNull
    @Composable
    @ReadOnlyComposable
    public final ColorProviders getColors(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2066266949, i, -1, "androidx.glance.GlanceTheme.<get-colors> (GlanceTheme.kt:30)");
        }
        ColorProviders colorProviders = (ColorProviders) composer.consume(CompositionLocalsKt.getLocalColors());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return colorProviders;
    }
}
