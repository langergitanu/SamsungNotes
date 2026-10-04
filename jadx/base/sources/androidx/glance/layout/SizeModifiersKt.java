package androidx.glance.layout;

import androidx.annotation.DimenRes;
import androidx.glance.GlanceModifier;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\u001c\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a$\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\b\u001a\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\b\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\b\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"fillMaxHeight", "Landroidx/glance/GlanceModifier;", "fillMaxSize", "fillMaxWidth", "height", "Landroidx/compose/ui/unit/Dp;", "height-3ABfNKs", "(Landroidx/glance/GlanceModifier;F)Landroidx/glance/GlanceModifier;", "", "size", "size-3ABfNKs", "width", "size-VpY3zN4", "(Landroidx/glance/GlanceModifier;FF)Landroidx/glance/GlanceModifier;", "width-3ABfNKs", "wrapContentHeight", "wrapContentSize", "wrapContentWidth", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SizeModifiersKt {
    @NotNull
    public static final GlanceModifier fillMaxHeight(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new HeightModifier(Dimension.Fill.INSTANCE));
    }

    @NotNull
    public static final GlanceModifier fillMaxSize(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return fillMaxHeight(fillMaxWidth(glanceModifier));
    }

    @NotNull
    public static final GlanceModifier fillMaxWidth(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new WidthModifier(Dimension.Fill.INSTANCE));
    }

    @NotNull
    public static final GlanceModifier height(@NotNull GlanceModifier glanceModifier, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new HeightModifier(new Dimension.Resource(i)));
    }

    @NotNull
    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21505height3ABfNKs(@NotNull GlanceModifier height, float f) {
        Intrinsics.checkNotNullParameter(height, "$this$height");
        return height.then(new HeightModifier(new Dimension.C3532Dp(f, null)));
    }

    @NotNull
    public static final GlanceModifier size(@NotNull GlanceModifier glanceModifier, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return height(width(glanceModifier, i), i);
    }

    @NotNull
    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21506size3ABfNKs(@NotNull GlanceModifier size, float f) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return m21505height3ABfNKs(m21508width3ABfNKs(size, f), f);
    }

    @NotNull
    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final GlanceModifier m21507sizeVpY3zN4(@NotNull GlanceModifier size, float f, float f4) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return m21505height3ABfNKs(m21508width3ABfNKs(size, f), f4);
    }

    @NotNull
    public static final GlanceModifier width(@NotNull GlanceModifier glanceModifier, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new WidthModifier(new Dimension.Resource(i)));
    }

    @NotNull
    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21508width3ABfNKs(@NotNull GlanceModifier width, float f) {
        Intrinsics.checkNotNullParameter(width, "$this$width");
        return width.then(new WidthModifier(new Dimension.C3532Dp(f, null)));
    }

    @NotNull
    public static final GlanceModifier wrapContentHeight(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new HeightModifier(Dimension.Wrap.INSTANCE));
    }

    @NotNull
    public static final GlanceModifier wrapContentSize(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return wrapContentWidth(wrapContentHeight(glanceModifier));
    }

    @NotNull
    public static final GlanceModifier wrapContentWidth(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new WidthModifier(Dimension.Wrap.INSTANCE));
    }

    @NotNull
    public static final GlanceModifier size(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return height(width(glanceModifier, i), i2);
    }
}
