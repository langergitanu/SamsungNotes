package androidx.compose.material;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/material/ContentAlpha;", "", "()V", "disabled", "", "getDisabled", "(Landroidx/compose/runtime/Composer;I)F", "high", "getHigh", Constants.ScionAnalytics.PARAM_MEDIUM, "getMedium", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ContentAlpha {
    public static final int $stable = 0;

    @NotNull
    public static final ContentAlpha INSTANCE = new ContentAlpha();

    private ContentAlpha() {
    }

    @Composable
    private final float contentAlpha(float f, float f4, Composer composer, int i) {
        composer.startReplaceableGroup(-1528360391);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1528360391, i, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:70)");
        }
        long jM18535unboximpl = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
        if (!MaterialTheme.INSTANCE.getColors(composer, 6).isLight() ? ColorKt.m18577luminance8_81llA(jM18535unboximpl) >= 0.5d : ColorKt.m18577luminance8_81llA(jM18535unboximpl) <= 0.5d) {
            f = f4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }

    @Composable
    @JvmName(name = "getDisabled")
    public final float getDisabled(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(621183615);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(621183615, i, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:56)");
        }
        float fContentAlpha = contentAlpha(0.38f, 0.38f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fContentAlpha;
    }

    @Composable
    @JvmName(name = "getHigh")
    public final float getHigh(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(629162431);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(629162431, i, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:34)");
        }
        float fContentAlpha = contentAlpha(1.0f, 0.87f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fContentAlpha;
    }

    @Composable
    @JvmName(name = "getMedium")
    public final float getMedium(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1999054879);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1999054879, i, -1, "androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:45)");
        }
        float fContentAlpha = contentAlpha(0.74f, 0.6f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fContentAlpha;
    }
}
