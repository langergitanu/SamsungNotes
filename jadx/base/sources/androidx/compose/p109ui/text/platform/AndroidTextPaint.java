package androidx.compose.p109ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.Paint;
import androidx.compose.p109ui.graphics.PaintingStyle;
import androidx.compose.p109ui.graphics.ShaderBrush;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDrawStyleKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00107\u001a\u000208H\u0002J,\u00109\u001a\u0002082\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010:\u001a\u00020\u001b2\b\b\u0002\u0010;\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0018\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u0002082\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010D\u001a\u0002082\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u0010E\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0081\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010&\u001a\u0012\u0012\f\u0012\n\u0018\u00010(j\u0004\u0018\u0001`)\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020/8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, m13886d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release$annotations", "()V", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release$annotations", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text_release", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text_release", "(Landroidx/compose/runtime/State;)V", VElementKey.SHADOW, "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "clearShader", "", "setBrush", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", AppWidgetConstants.OPTION_APPWIDGET_STYLE_SHOW_SHADOW, "setTextDecoration", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidTextPaint.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidTextPaint.android.kt\nandroidx/compose/ui/text/platform/AndroidTextPaint\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n+ 4 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n*L\n1#1,203:1\n1#2:204\n696#3:205\n198#4:206\n*S KotlinDebug\n*F\n+ 1 AndroidTextPaint.android.kt\nandroidx/compose/ui/text/platform/AndroidTextPaint\n*L\n105#1:205\n131#1:206\n*E\n"})
public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private int backingBlendMode;

    @Nullable
    private Paint backingComposePaint;

    @Nullable
    private Brush brush;

    @Nullable
    private Size brushSize;

    @Nullable
    private DrawStyle drawStyle;

    @Nullable
    private State<? extends Shader> shaderState;

    @NotNull
    private Shadow shadow;

    @NotNull
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i, float f) {
        super(i);
        ((TextPaint) this).density = f;
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.backingBlendMode = DrawScope.INSTANCE.m19078getDefaultBlendMode0nO6VwU();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }

    private final Paint getComposePaint() {
        Paint paint = this.backingComposePaint;
        if (paint != null) {
            return paint;
        }
        Paint paintAsComposePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = paintAsComposePaint;
        return paintAsComposePaint;
    }

    /* JADX INFO: renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m20716setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m20720setBrush12SF9DM(brush, j, f);
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getBackingBlendMode() {
        return this.backingBlendMode;
    }

    @Nullable
    /* JADX INFO: renamed from: getBrush$ui_text_release, reason: from getter */
    public final Brush getBrush() {
        return this.brush;
    }

    @Nullable
    /* JADX INFO: renamed from: getBrushSize-VsRJwc0$ui_text_release, reason: not valid java name and from getter */
    public final Size getBrushSize() {
        return this.brushSize;
    }

    @Nullable
    public final State<Shader> getShaderState$ui_text_release() {
        return this.shaderState;
    }

    @NotNull
    /* JADX INFO: renamed from: getShadow$ui_text_release, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m20719setBlendModes9anfk8(int i) {
        if (BlendMode.m18436equalsimpl0(i, this.backingBlendMode)) {
            return;
        }
        getComposePaint().mo18403setBlendModes9anfk8(i);
        this.backingBlendMode = i;
    }

    public final void setBrush$ui_text_release(@Nullable Brush brush) {
        this.brush = brush;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX INFO: renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m20720setBrush12SF9DM(@Nullable final Brush brush, final long size, float alpha) {
        if (brush == null) {
            clearShader();
            return;
        }
        if (brush instanceof SolidColor) {
            m20722setColor8_81llA(TextDrawStyleKt.m20877modulateDxMtmZc(((SolidColor) brush).getValue(), alpha));
            return;
        }
        if (brush instanceof ShaderBrush) {
            if (Intrinsics.areEqual(this.brush, brush)) {
                Size size2 = this.brushSize;
                if (!(size2 == null ? false : Size.m18349equalsimpl0(size2.getPackedValue(), size))) {
                }
            } else {
                if (size != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    this.brush = brush;
                    this.brushSize = Size.m18341boximpl(size);
                    this.shaderState = SnapshotStateKt.derivedStateOf(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Shader invoke() {
                            return ((ShaderBrush) brush).mo18494createShaderuvyYCjk(size);
                        }
                    });
                }
            }
            Paint composePaint = getComposePaint();
            State<? extends Shader> state = this.shaderState;
            composePaint.setShader(state != null ? state.getValue() : null);
            AndroidTextPaint_androidKt.setAlpha(this, alpha);
        }
    }

    /* JADX INFO: renamed from: setBrushSize-iaC8Vc4$ui_text_release, reason: not valid java name */
    public final void m20721setBrushSizeiaC8Vc4$ui_text_release(@Nullable Size size) {
        this.brushSize = size;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m20722setColor8_81llA(long color) {
        if (color != 16) {
            setColor(ColorKt.m18579toArgb8_81llA(color));
            clearShader();
        }
    }

    public final void setDrawStyle(@Nullable DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (drawStyle instanceof Stroke) {
            getComposePaint().mo18408setStylek9PVt8s(PaintingStyle.INSTANCE.m18793getStrokeTiuSbCo());
            Stroke stroke = (Stroke) drawStyle;
            getComposePaint().setStrokeWidth(stroke.getWidth());
            getComposePaint().setStrokeMiterLimit(stroke.getMiter());
            getComposePaint().mo18407setStrokeJoinWw9F2mQ(stroke.getJoin());
            getComposePaint().mo18406setStrokeCapBeK7IIE(stroke.getCap());
            getComposePaint().setPathEffect(stroke.getPathEffect());
        }
    }

    public final void setShaderState$ui_text_release(@Nullable State<? extends Shader> state) {
        this.shaderState = state;
    }

    public final void setShadow(@Nullable Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.INSTANCE.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m18284getXimpl(this.shadow.getOffset()), Offset.m18285getYimpl(this.shadow.getOffset()), ColorKt.m18579toArgb8_81llA(this.shadow.getColor()));
        }
    }

    public final void setShadow$ui_text_release(@NotNull Shadow shadow) {
        this.shadow = shadow;
    }

    public final void setTextDecoration(@Nullable TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.INSTANCE;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }

    @VisibleForTesting
    public static /* synthetic */ void getBrush$ui_text_release$annotations() {
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: getBrushSize-VsRJwc0$ui_text_release$annotations, reason: not valid java name */
    public static /* synthetic */ void m20715getBrushSizeVsRJwc0$ui_text_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }
}
