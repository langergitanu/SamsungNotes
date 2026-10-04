package androidx.glance.appwidget;

import androidx.annotation.DrawableRes;
import androidx.annotation.RestrictTo;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.oneui.common.AppWidgetConstants;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0007\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\n\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0014\u001a\"\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u001e\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cH\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m13886d2 = {"alpha", "Landroidx/glance/GlanceModifier;", "", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "backgroundTint", "tint", "Landroidx/glance/unit/ColorProvider;", "clipToOutline", "clip", "", "enabled", "fadingEdge", "edgeLength", "Landroidx/compose/ui/unit/Dp;", "fadingEdge-3ABfNKs", "(Landroidx/glance/GlanceModifier;F)Landroidx/glance/GlanceModifier;", "keepColor", "enable", "layoutDirection", "", "scrollToPosition", "position", "shapeBackground", "resId", "colorProvider", "tag", "key", "", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class AppWidgetModifiersKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier alpha(@NotNull GlanceModifier glanceModifier, float f) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new AlphaModifier(f));
    }

    @NotNull
    public static final GlanceModifier animation(@NotNull GlanceModifier glanceModifier, @NotNull RemoteAnimation animation) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(animation, "animation");
        return glanceModifier.then(new AnimationModifier(animation));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier backgroundTint(@NotNull GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new BackgroundTintModifier(colorProvider));
    }

    public static /* synthetic */ GlanceModifier backgroundTint$default(GlanceModifier glanceModifier, ColorProvider colorProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            colorProvider = null;
        }
        return backgroundTint(glanceModifier, colorProvider);
    }

    @NotNull
    public static final GlanceModifier clipToOutline(@NotNull GlanceModifier glanceModifier, boolean z) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new ClipToOutlineModifier(z));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier enabled(@NotNull GlanceModifier glanceModifier, boolean z) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new EnabledModifier(z));
    }

    @NotNull
    /* JADX INFO: renamed from: fadingEdge-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21263fadingEdge3ABfNKs(@NotNull GlanceModifier fadingEdge, float f) {
        Intrinsics.checkNotNullParameter(fadingEdge, "$this$fadingEdge");
        return fadingEdge.then(new FadingEdgeModifier(f, null));
    }

    @NotNull
    public static final GlanceModifier keepColor(@NotNull GlanceModifier glanceModifier, boolean z) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return z ? tag(glanceModifier, AppWidgetConstants.VIEW_TAG_KEY_KEEP_CURRENT_COLOR, "true") : glanceModifier;
    }

    @NotNull
    public static final GlanceModifier layoutDirection(@NotNull GlanceModifier glanceModifier, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new LayoutDirectionModifier(i));
    }

    @NotNull
    public static final GlanceModifier scrollToPosition(@NotNull GlanceModifier glanceModifier, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new ScrollModifier(i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier shapeBackground(@NotNull GlanceModifier glanceModifier, @DrawableRes int i, @Nullable ColorProvider colorProvider) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new ShapeBackgroundModifier(i, colorProvider));
    }

    public static /* synthetic */ GlanceModifier shapeBackground$default(GlanceModifier glanceModifier, int i, ColorProvider colorProvider, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            colorProvider = null;
        }
        return shapeBackground(glanceModifier, i, colorProvider);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier tag(@NotNull GlanceModifier glanceModifier, int i, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new KeyedTagModifier(i, obj));
    }
}
