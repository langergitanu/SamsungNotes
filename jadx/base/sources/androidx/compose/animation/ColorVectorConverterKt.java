package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import androidx.compose.p109ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"5\u0010\u0000\u001a)\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"<\u0010\t\u001a)\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0001*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"ColorToVector", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "Lkotlin/ParameterName;", "name", "colorSpace", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "VectorConverter", "Landroidx/compose/ui/graphics/Color$Companion;", "getVectorConverter", "(Landroidx/compose/ui/graphics/Color$Companion;)Lkotlin/jvm/functions/Function1;", "animation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ColorVectorConverterKt {

    @NotNull
    private static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> ColorToVector = new Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final TwoWayConverter<Color, AnimationVector4D> invoke(@NotNull final ColorSpace colorSpace) {
            return VectorConvertersKt.TwoWayConverter(new Function1<Color, AnimationVector4D>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ AnimationVector4D invoke(Color color) {
                    return m15246invoke8_81llA(color.m18535unboximpl());
                }

                @NotNull
                /* JADX INFO: renamed from: invoke-8_81llA, reason: not valid java name */
                public final AnimationVector4D m15246invoke8_81llA(long j) {
                    long jM18522convertvNxB06k = Color.m18522convertvNxB06k(j, ColorSpaces.INSTANCE.getOklab());
                    return new AnimationVector4D(Color.m18527getAlphaimpl(jM18522convertvNxB06k), Color.m18531getRedimpl(jM18522convertvNxB06k), Color.m18530getGreenimpl(jM18522convertvNxB06k), Color.m18528getBlueimpl(jM18522convertvNxB06k));
                }
            }, new Function1<AnimationVector4D, Color>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Color invoke(AnimationVector4D animationVector4D) {
                    return Color.m18515boximpl(m15247invokevNxB06k(animationVector4D));
                }

                /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m15247invokevNxB06k(@NotNull AnimationVector4D animationVector4D) {
                    float v22 = animationVector4D.getV2();
                    if (v22 < 0.0f) {
                        v22 = 0.0f;
                    }
                    if (v22 > 1.0f) {
                        v22 = 1.0f;
                    }
                    float v32 = animationVector4D.getV3();
                    if (v32 < -0.5f) {
                        v32 = -0.5f;
                    }
                    if (v32 > 0.5f) {
                        v32 = 0.5f;
                    }
                    float v4 = animationVector4D.getV4();
                    float f = v4 >= -0.5f ? v4 : -0.5f;
                    float f4 = f <= 0.5f ? f : 0.5f;
                    float v12 = animationVector4D.getV1();
                    float f5 = v12 >= 0.0f ? v12 : 0.0f;
                    return Color.m18522convertvNxB06k(ColorKt.Color(v22, v32, f4, f5 <= 1.0f ? f5 : 1.0f, ColorSpaces.INSTANCE.getOklab()), colorSpace);
                }
            });
        }
    };

    @NotNull
    public static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> getVectorConverter(@NotNull Color.Companion companion) {
        return ColorToVector;
    }
}
