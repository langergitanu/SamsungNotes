package androidx.glance.oneui.template;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BitmapImageProvider;
import androidx.glance.IconImageProvider;
import androidx.glance.ImageProvider;
import androidx.glance.layout.ContentScale;
import com.bumptech.glide.Registry;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/oneui/template/AppWidgetBackground;", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "(Landroidx/glance/oneui/template/Shape;)V", "getShape$glance_oneui_template_release", "()Landroidx/glance/oneui/template/Shape;", "isBlurAvailable", "", "toString", "", Registry.BUCKET_BITMAP, "Color", "Gradient", "Image", "Transparent", "Landroidx/glance/oneui/template/AppWidgetBackground$Bitmap;", "Landroidx/glance/oneui/template/AppWidgetBackground$Color;", "Landroidx/glance/oneui/template/AppWidgetBackground$Gradient;", "Landroidx/glance/oneui/template/AppWidgetBackground$Image;", "Landroidx/glance/oneui/template/AppWidgetBackground$Transparent;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class AppWidgetBackground {
    public static final int $stable = 0;

    @NotNull
    private final Shape shape;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/template/AppWidgetBackground$Color;", "Landroidx/glance/oneui/template/AppWidgetBackground;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "(Landroidx/glance/oneui/template/Shape;)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Color extends AppWidgetBackground {
        public static final int $stable = 0;

        /* JADX WARN: Multi-variable type inference failed */
        public Color() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Color(@NotNull Shape shape) {
            super(shape, null);
            Intrinsics.checkNotNullParameter(shape, "shape");
        }

        public /* synthetic */ Color(Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Shape.None : shape);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/template/AppWidgetBackground$Gradient;", "Landroidx/glance/oneui/template/AppWidgetBackground;", "resId", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "(ILandroidx/glance/oneui/template/Shape;)V", "getResId", "()I", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Gradient extends AppWidgetBackground {
        public static final int $stable = 0;
        private final int resId;

        public /* synthetic */ Gradient(int i, Shape shape, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? Shape.None : shape);
        }

        public final int getResId() {
            return this.resId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gradient(@DrawableRes int i, @NotNull Shape shape) {
            super(shape, null);
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.resId = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/oneui/template/AppWidgetBackground$Image;", "Landroidx/glance/oneui/template/AppWidgetBackground;", "imageProvider", "Landroidx/glance/ImageProvider;", "contentScale", "Landroidx/glance/layout/ContentScale;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "(Landroidx/glance/ImageProvider;ILandroidx/glance/oneui/template/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentScale-Ae3V0ko", "()I", "I", "getImageProvider", "()Landroidx/glance/ImageProvider;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Image extends AppWidgetBackground {
        public static final int $stable = 8;
        private final int contentScale;

        @NotNull
        private final ImageProvider imageProvider;

        public /* synthetic */ Image(ImageProvider imageProvider, int i, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageProvider, i, shape);
        }

        /* JADX INFO: renamed from: getContentScale-Ae3V0ko, reason: not valid java name and from getter */
        public final int getContentScale() {
            return this.contentScale;
        }

        @NotNull
        public final ImageProvider getImageProvider() {
            return this.imageProvider;
        }

        public /* synthetic */ Image(ImageProvider imageProvider, int i, Shape shape, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageProvider, (i2 & 2) != 0 ? ContentScale.INSTANCE.m21466getFillBoundsAe3V0ko() : i, (i2 & 4) != 0 ? Shape.None : shape, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Image(ImageProvider imageProvider, int i, Shape shape) {
            super(shape, null);
            Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.imageProvider = imageProvider;
            this.contentScale = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/oneui/template/AppWidgetBackground$Transparent;", "Landroidx/glance/oneui/template/AppWidgetBackground;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class Transparent extends AppWidgetBackground {
        public static final int $stable = 0;

        @NotNull
        public static final Transparent INSTANCE = new Transparent();

        private Transparent() {
            super(Shape.None, null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Transparent);
        }

        public int hashCode() {
            return 1674227244;
        }

        @Override // androidx.glance.oneui.template.AppWidgetBackground
        @NotNull
        public String toString() {
            return "Transparent";
        }
    }

    public /* synthetic */ AppWidgetBackground(Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(shape);
    }

    @NotNull
    /* JADX INFO: renamed from: getShape$glance_oneui_template_release, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    public final boolean isBlurAvailable() {
        if ((this instanceof Color) || (this instanceof Gradient)) {
            return true;
        }
        if (this instanceof Image) {
            return false;
        }
        if (this instanceof Bitmap) {
            return true;
        }
        if (Intrinsics.areEqual(this, Transparent.INSTANCE)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String toString() {
        if (this instanceof Color) {
            return "color, shape=" + this.shape;
        }
        if (this instanceof Gradient) {
            return "gradient, shape=" + this.shape;
        }
        if (!(this instanceof Image)) {
            if (this instanceof Bitmap) {
                return "bitmap, shape=" + this.shape;
            }
            return "transparent, shape=" + this.shape;
        }
        ImageProvider imageProvider = ((Image) this).getImageProvider();
        if (imageProvider instanceof AndroidResourceImageProvider) {
            return "image(android-res), shape=" + this.shape;
        }
        if (imageProvider instanceof BitmapImageProvider) {
            return "image(bitmap), shape=" + this.shape;
        }
        if (imageProvider instanceof IconImageProvider) {
            return "image(icon), shape=" + this.shape;
        }
        return "image, shape=" + this.shape;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/AppWidgetBackground$Bitmap;", "Landroidx/glance/oneui/template/AppWidgetBackground;", "bitmap", "Landroid/graphics/Bitmap;", "alpha", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "(Landroid/graphics/Bitmap;FLandroidx/glance/oneui/template/Shape;)V", "getAlpha", "()F", "getBitmap", "()Landroid/graphics/Bitmap;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Bitmap extends AppWidgetBackground {
        public static final int $stable = 8;
        private final float alpha;

        @NotNull
        private final android.graphics.Bitmap bitmap;

        public /* synthetic */ Bitmap(android.graphics.Bitmap bitmap, float f, Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? Shape.None : shape);
        }

        public final float getAlpha() {
            return this.alpha;
        }

        @NotNull
        public final android.graphics.Bitmap getBitmap() {
            return this.bitmap;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bitmap(@NotNull android.graphics.Bitmap bitmap, float f, @NotNull Shape shape) {
            super(shape, null);
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.bitmap = bitmap;
            this.alpha = f;
        }
    }

    private AppWidgetBackground(Shape shape) {
        this.shape = shape;
    }
}
