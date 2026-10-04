package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.ContentScale;
import androidx.glance.unit.ColorProvider;
import com.bumptech.glide.Registry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/glance/BackgroundModifier;", "Landroidx/glance/GlanceModifier$Element;", Registry.BUCKET_BITMAP, "Color", "Image", "Landroidx/glance/BackgroundModifier$Bitmap;", "Landroidx/glance/BackgroundModifier$Color;", "Landroidx/glance/BackgroundModifier$Image;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface BackgroundModifier extends GlanceModifier.Element {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/glance/BackgroundModifier$Color;", "Landroidx/glance/BackgroundModifier;", "colorProvider", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/unit/ColorProvider;)V", "getColorProvider", "()Landroidx/glance/unit/ColorProvider;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Color implements BackgroundModifier {
        public static final int $stable = 0;

        @NotNull
        private final ColorProvider colorProvider;

        public Color(@NotNull ColorProvider colorProvider) {
            Intrinsics.checkNotNullParameter(colorProvider, "colorProvider");
            this.colorProvider = colorProvider;
        }

        @NotNull
        public final ColorProvider getColorProvider() {
            return this.colorProvider;
        }

        @NotNull
        public String toString() {
            return "BackgroundModifier(colorProvider=" + this.colorProvider + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/BackgroundModifier$Image;", "Landroidx/glance/BackgroundModifier;", "imageProvider", "Landroidx/glance/ImageProvider;", "contentScale", "Landroidx/glance/layout/ContentScale;", "colorFilter", "Landroidx/glance/ColorFilter;", "(Landroidx/glance/ImageProvider;ILandroidx/glance/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColorFilter", "()Landroidx/glance/ColorFilter;", "getContentScale-Ae3V0ko", "()I", "I", "getImageProvider", "()Landroidx/glance/ImageProvider;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Image implements BackgroundModifier {
        public static final int $stable = 0;

        @Nullable
        private final ColorFilter colorFilter;
        private final int contentScale;

        @Nullable
        private final ImageProvider imageProvider;

        public /* synthetic */ Image(ImageProvider imageProvider, int i, ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageProvider, i, colorFilter);
        }

        @Nullable
        public final ColorFilter getColorFilter() {
            return this.colorFilter;
        }

        /* JADX INFO: renamed from: getContentScale-Ae3V0ko, reason: not valid java name and from getter */
        public final int getContentScale() {
            return this.contentScale;
        }

        @Nullable
        public final ImageProvider getImageProvider() {
            return this.imageProvider;
        }

        @NotNull
        public String toString() {
            ColorFilter colorFilter = this.colorFilter;
            ImageProvider imageProvider = this.imageProvider;
            String strM21463toStringimpl = ContentScale.m21463toStringimpl(this.contentScale);
            StringBuilder sb = new StringBuilder("BackgroundModifier(colorFilter=");
            sb.append(colorFilter);
            sb.append(", imageProvider=");
            sb.append(imageProvider);
            sb.append(", contentScale=");
            return AbstractC0622a.m1170p(strM21463toStringimpl, ")", sb);
        }

        private Image(ImageProvider imageProvider, int i, ColorFilter colorFilter) {
            this.imageProvider = imageProvider;
            this.contentScale = i;
            this.colorFilter = colorFilter;
        }

        public /* synthetic */ Image(ImageProvider imageProvider, int i, ColorFilter colorFilter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageProvider, (i2 & 2) != 0 ? ContentScale.INSTANCE.m21466getFillBoundsAe3V0ko() : i, (i2 & 4) != 0 ? null : colorFilter, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m13886d2 = {"Landroidx/glance/BackgroundModifier$Bitmap;", "Landroidx/glance/BackgroundModifier;", "bitmap", "Landroid/graphics/Bitmap;", "alpha", "", "(Landroid/graphics/Bitmap;F)V", "getAlpha", "()F", "getBitmap", "()Landroid/graphics/Bitmap;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Bitmap implements BackgroundModifier {
        public static final int $stable = 0;
        private final float alpha;

        @NotNull
        private final android.graphics.Bitmap bitmap;

        public Bitmap(@NotNull android.graphics.Bitmap bitmap, float f) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.bitmap = bitmap;
            this.alpha = f;
        }

        public final float getAlpha() {
            return this.alpha;
        }

        @NotNull
        public final android.graphics.Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public String toString() {
            return "BackgroundModifier(bitmap=" + this.bitmap + ")";
        }

        public /* synthetic */ Bitmap(android.graphics.Bitmap bitmap, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, (i & 2) != 0 ? 1.0f : f);
        }
    }
}
