package androidx.compose.p109ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.p109ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.p109ui.graphics.PathEffect;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.StrokeJoin;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/ui/text/platform/style/DrawStyleSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    public static final int $stable = 8;

    @NotNull
    private final DrawStyle drawStyle;

    public DrawStyleSpan(@NotNull DrawStyle drawStyle) {
        this.drawStyle = drawStyle;
    }

    /* JADX INFO: renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    private final Paint.Cap m20737toAndroidCapBeK7IIE(int i) {
        StrokeCap.Companion companion = StrokeCap.INSTANCE;
        return StrokeCap.m18874equalsimpl0(i, companion.m18878getButtKaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.m18874equalsimpl0(i, companion.m18879getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m18874equalsimpl0(i, companion.m18880getSquareKaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    /* JADX INFO: renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    private final Paint.Join m20738toAndroidJoinWw9F2mQ(int i) {
        StrokeJoin.Companion companion = StrokeJoin.INSTANCE;
        return StrokeJoin.m18884equalsimpl0(i, companion.m18889getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m18884equalsimpl0(i, companion.m18890getRoundLxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.m18884equalsimpl0(i, companion.m18888getBevelLxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    @NotNull
    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@Nullable TextPaint textPaint) {
        if (textPaint != null) {
            DrawStyle drawStyle = this.drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (drawStyle instanceof Stroke) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((Stroke) this.drawStyle).getWidth());
                textPaint.setStrokeMiter(((Stroke) this.drawStyle).getMiter());
                textPaint.setStrokeJoin(m20738toAndroidJoinWw9F2mQ(((Stroke) this.drawStyle).getJoin()));
                textPaint.setStrokeCap(m20737toAndroidCapBeK7IIE(((Stroke) this.drawStyle).getCap()));
                PathEffect pathEffect = ((Stroke) this.drawStyle).getPathEffect();
                textPaint.setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
            }
        }
    }
}
