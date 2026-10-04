package androidx.glance;

import android.graphics.Bitmap;
import androidx.annotation.ColorRes;
import androidx.annotation.RestrictTo;
import androidx.glance.BackgroundModifier;
import androidx.glance.layout.ContentScale;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0006\u001a\u00020\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m13886d2 = {"background", "Landroidx/glance/GlanceModifier;", "bitmap", "Landroid/graphics/Bitmap;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "background-4WTKRHQ", "(Landroidx/glance/GlanceModifier;J)Landroidx/glance/GlanceModifier;", "imageProvider", "Landroidx/glance/ImageProvider;", "contentScale", "Landroidx/glance/layout/ContentScale;", "background-l7F5y5Q", "(Landroidx/glance/GlanceModifier;Landroidx/glance/ImageProvider;I)Landroidx/glance/GlanceModifier;", "colorFilter", "Landroidx/glance/ColorFilter;", "background-PLcKuY0", "(Landroidx/glance/GlanceModifier;Landroidx/glance/ImageProvider;ILandroidx/glance/ColorFilter;)Landroidx/glance/GlanceModifier;", "colorProvider", "Landroidx/glance/unit/ColorProvider;", "", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class BackgroundKt {
    @NotNull
    public static final GlanceModifier background(@NotNull GlanceModifier glanceModifier, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return background(glanceModifier, ColorProviderKt.ColorProvider(i));
    }

    public static /* synthetic */ GlanceModifier background$default(GlanceModifier glanceModifier, Bitmap bitmap, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        return background(glanceModifier, bitmap, f);
    }

    @NotNull
    /* JADX INFO: renamed from: background-4WTKRHQ, reason: not valid java name */
    public static final GlanceModifier m21250background4WTKRHQ(@NotNull GlanceModifier background, long j) {
        Intrinsics.checkNotNullParameter(background, "$this$background");
        return background(background, ColorProviderKt.m22055ColorProvider8_81llA(j));
    }

    @NotNull
    /* JADX INFO: renamed from: background-PLcKuY0, reason: not valid java name */
    public static final GlanceModifier m21251backgroundPLcKuY0(@NotNull GlanceModifier background, @NotNull ImageProvider imageProvider, int i, @Nullable ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(background, "$this$background");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        return background.then(new BackgroundModifier.Image(imageProvider, i, colorFilter, null));
    }

    /* JADX INFO: renamed from: background-PLcKuY0$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21252backgroundPLcKuY0$default(GlanceModifier glanceModifier, ImageProvider imageProvider, int i, ColorFilter colorFilter, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ContentScale.INSTANCE.m21466getFillBoundsAe3V0ko();
        }
        if ((i2 & 4) != 0) {
            colorFilter = null;
        }
        return m21251backgroundPLcKuY0(glanceModifier, imageProvider, i, colorFilter);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the one that accepts a colorFilter.")
    /* JADX INFO: renamed from: background-l7F5y5Q, reason: not valid java name */
    public static final /* synthetic */ GlanceModifier m21253backgroundl7F5y5Q(GlanceModifier background, ImageProvider imageProvider, int i) {
        Intrinsics.checkNotNullParameter(background, "$this$background");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        return background.then(new BackgroundModifier.Image(imageProvider, i, null, 4, null));
    }

    /* JADX INFO: renamed from: background-l7F5y5Q$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21254backgroundl7F5y5Q$default(GlanceModifier glanceModifier, ImageProvider imageProvider, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ContentScale.INSTANCE.m21466getFillBoundsAe3V0ko();
        }
        return m21253backgroundl7F5y5Q(glanceModifier, imageProvider, i);
    }

    @NotNull
    public static final GlanceModifier background(@NotNull GlanceModifier glanceModifier, @NotNull ColorProvider colorProvider) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(colorProvider, "colorProvider");
        return glanceModifier.then(new BackgroundModifier.Color(colorProvider));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier background(@NotNull GlanceModifier glanceModifier, @NotNull Bitmap bitmap, float f) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return glanceModifier.then(new BackgroundModifier.Bitmap(bitmap, f));
    }
}
