package androidx.glance;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"Landroidx/glance/ButtonDefaults;", "", "()V", "buttonColors", "Landroidx/glance/ButtonColors;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "contentColor", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)Landroidx/glance/ButtonColors;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();

    private ButtonDefaults() {
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    @NotNull
    public final ButtonColors buttonColors(@Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(207135993);
        if ((i2 & 1) != 0) {
            colorProvider = GlanceTheme.INSTANCE.getColors(composer, 6).getPrimary();
        }
        if ((i2 & 2) != 0) {
            colorProvider2 = GlanceTheme.INSTANCE.getColors(composer, 6).getOnPrimary();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(207135993, i, -1, "androidx.glance.ButtonDefaults.buttonColors (Button.kt:196)");
        }
        ButtonColors buttonColors = new ButtonColors(colorProvider, colorProvider2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }
}
