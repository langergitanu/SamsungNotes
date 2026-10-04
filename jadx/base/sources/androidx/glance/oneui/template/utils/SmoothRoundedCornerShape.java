package androidx.glance.oneui.template.utils;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p109ui.geometry.CornerRadiusKt;
import androidx.compose.p109ui.geometry.RoundRectKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB'\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0016JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J8\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"Landroidx/glance/oneui/template/utils/SmoothRoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "radius", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "topStart", "topEnd", "bottomEnd", "bottomStart", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/foundation/shape/CornerSize;", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "getControlRatio", "rad", "maxRad", "getRadius", "getSmoothCornerRectPath", "Landroidx/compose/ui/graphics/Path;", "width", "height", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "getVertexRatio", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SmoothRoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public /* synthetic */ SmoothRoundedCornerShape(float f, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6);
    }

    private final float getControlRatio(float rad, float maxRad) {
        float f = rad / maxRad;
        if (f <= 0.6d) {
            return 1.0f;
        }
        return (Math.min(1.0f, (f - 0.6f) / 0.3f) * 0.042454004f) + 1;
    }

    private final float getRadius(float rad, float maxRad) {
        return Math.min(Math.max(rad, 0.0f), maxRad);
    }

    private final Path getSmoothCornerRectPath(float width, float height, float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        Path Path = AndroidPath_androidKt.Path();
        if (width <= 0.0f || height <= 0.0f) {
            GlanceLog.Companion companion = GlanceLog.INSTANCE;
            String callers = Debug.INSTANCE.getCallers(15);
            StringBuilder sbM1176v = AbstractC0622a.m1176v("IllegalArguments: w=", width, ", h=", height, ", callers=");
            sbM1176v.append(callers);
            companion.m2305w("ComposeRoundedCorner", sbM1176v.toString());
            return AndroidPath_androidKt.Path();
        }
        float f = width / 2.0f;
        float fMin = Math.min(f, height / 2.0f);
        float radius = getRadius(topRightRadius, fMin);
        float vertexRatio = getVertexRatio(radius, fMin);
        float controlRatio = getControlRatio(radius, fMin);
        Path.moveTo(f + 0.0f, 0.0f);
        float f4 = 2;
        float f5 = width / f4;
        float f6 = radius / 100.0f;
        float f7 = f6 * 128.19f * vertexRatio;
        Path.lineTo(Math.max(f5, width - f7) + 0.0f, 0.0f);
        float f8 = width + 0.0f;
        float f9 = f6 * 83.62f * controlRatio;
        float f10 = f6 * 67.45f;
        float f11 = f6 * 4.64f;
        float f12 = f6 * 51.16f;
        float f13 = f6 * 13.36f;
        Path.cubicTo(f8 - f9, 0.0f, f8 - f10, f11 + 0.0f, f8 - f12, f13 + 0.0f);
        float f14 = f6 * 34.86f;
        float f15 = f6 * 22.07f;
        Path.cubicTo(f8 - f14, f15 + 0.0f, f8 - f15, f14 + 0.0f, f8 - f13, f12 + 0.0f);
        float f16 = height / f4;
        Path.cubicTo(f8 - f11, f10 + 0.0f, f8, f9 + 0.0f, f8, Math.min(f16, f7) + 0.0f);
        float radius2 = getRadius(bottomRightRadius, fMin);
        float vertexRatio2 = getVertexRatio(radius2, fMin);
        float controlRatio2 = getControlRatio(radius2, fMin);
        float f17 = radius2 / 100.0f;
        float f18 = f17 * 128.19f * vertexRatio2;
        Path.lineTo(f8, Math.max(f16, height - f18) + 0.0f);
        float f19 = height + 0.0f;
        float f20 = f17 * 83.62f * controlRatio2;
        float f21 = f17 * 4.64f;
        float f22 = f17 * 67.45f;
        float f23 = f17 * 13.36f;
        float f24 = f17 * 51.16f;
        Path.cubicTo(f8, f19 - f20, f8 - f21, f19 - f22, f8 - f23, f19 - f24);
        float f25 = f17 * 22.07f;
        float f26 = f17 * 34.86f;
        Path.cubicTo(f8 - f25, f19 - f26, f8 - f26, f19 - f25, f8 - f24, f19 - f23);
        Path.cubicTo(f8 - f22, f19 - f21, f8 - f20, f19, Math.max(f5, width - f18) + 0.0f, f19);
        float radius3 = getRadius(bottomLeftRadius, fMin);
        float vertexRatio3 = getVertexRatio(radius3, fMin);
        float controlRatio3 = getControlRatio(radius3, fMin);
        float f27 = radius3 / 100.0f;
        float f28 = f27 * 128.19f * vertexRatio3;
        Path.lineTo(Math.min(f5, f28) + 0.0f, f19);
        float f29 = f27 * 83.62f * controlRatio3;
        float f30 = f27 * 67.45f;
        float f31 = f27 * 4.64f;
        float f32 = f27 * 51.16f;
        float f33 = f27 * 13.36f;
        Path.cubicTo(f29 + 0.0f, f19, f30 + 0.0f, f19 - f31, f32 + 0.0f, f19 - f33);
        float f34 = f27 * 34.86f;
        float f35 = f27 * 22.07f;
        Path.cubicTo(f34 + 0.0f, f19 - f35, f35 + 0.0f, f19 - f34, f33 + 0.0f, f19 - f32);
        Path.cubicTo(f31 + 0.0f, f19 - f30, 0.0f, f19 - f29, 0.0f, Math.max(f16, height - f28) + 0.0f);
        float radius4 = getRadius(topLeftRadius, fMin);
        float vertexRatio4 = getVertexRatio(radius4, fMin);
        float controlRatio4 = getControlRatio(radius4, fMin);
        float f36 = radius4 / 100.0f;
        float f37 = 128.19f * f36 * vertexRatio4;
        Path.lineTo(0.0f, Math.min(f16, f37) + 0.0f);
        float f38 = (83.62f * f36 * controlRatio4) + 0.0f;
        float f39 = (4.64f * f36) + 0.0f;
        float f40 = (67.45f * f36) + 0.0f;
        float f41 = (13.36f * f36) + 0.0f;
        float f42 = (51.16f * f36) + 0.0f;
        Path.cubicTo(0.0f, f38, f39, f40, f41, f42);
        float f43 = (22.07f * f36) + 0.0f;
        float f44 = (f36 * 34.86f) + 0.0f;
        Path.cubicTo(f43, f44, f44, f43, f42, f41);
        Path.cubicTo(f40, f39, f38, 0.0f, Math.min(f5, f37) + 0.0f, 0.0f);
        Path.close();
        return Path;
    }

    private final float getVertexRatio(float rad, float maxRad) {
        float f = rad / maxRad;
        if (f > 0.5f) {
            return 1.0f - (Math.min(1.0f, (f - 0.5f) / 0.4f) * 0.13877845f);
        }
        return 1.0f;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo16120createOutlineLjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (topStart == bottomStart) {
            float f = 2;
            if (topStart >= Size.m18350getHeightimpl(size) / f && topEnd == bottomEnd && topEnd >= Size.m18350getHeightimpl(size) / f) {
                return new Outline.Rounded(RoundRectKt.m18336RoundRectZAM2FJo(SizeKt.m18374toRectuvyYCjk(size), CornerRadiusKt.CornerRadius$default(topStart, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(topEnd, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(bottomEnd, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(bottomStart, 0.0f, 2, null)));
            }
        }
        return new Outline.Generic(getSmoothCornerRectPath(Size.m18353getWidthimpl(size), Size.m18350getHeightimpl(size), topStart, topEnd, bottomEnd, bottomStart));
    }

    public /* synthetic */ SmoothRoundedCornerShape(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public SmoothRoundedCornerShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        return new SmoothRoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }

    private SmoothRoundedCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    private SmoothRoundedCornerShape(float f) {
        this(CornerSizeKt.m16129CornerSize0680j_4(f), CornerSizeKt.m16129CornerSize0680j_4(f), CornerSizeKt.m16129CornerSize0680j_4(f), CornerSizeKt.m16129CornerSize0680j_4(f));
    }

    private SmoothRoundedCornerShape(float f, float f4, float f5, float f6) {
        this(CornerSizeKt.m16129CornerSize0680j_4(f), CornerSizeKt.m16129CornerSize0680j_4(f4), CornerSizeKt.m16129CornerSize0680j_4(f5), CornerSizeKt.m16129CornerSize0680j_4(f6));
    }
}
