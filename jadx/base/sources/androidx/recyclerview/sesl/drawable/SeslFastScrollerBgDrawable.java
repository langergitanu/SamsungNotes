package androidx.recyclerview.sesl.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, m13886d2 = {"Landroidx/recyclerview/sesl/drawable/SeslFastScrollerBgDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroidx/recyclerview/sesl/drawable/SeslAutowiredDrawable;", "", "()V", "paint", "Landroid/graphics/Paint;", "value", "getValue", "()Ljava/lang/Float;", "setValue", "(F)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setArgb", "Argb", BaseWidgetConstant.SET_COLOR_FILTER, "colorFilter", "Landroid/graphics/ColorFilter;", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SeslFastScrollerBgDrawable extends Drawable implements SeslAutowiredDrawable<Float> {

    @NotNull
    private final Paint paint;
    private float value;

    public SeslFastScrollerBgDrawable() {
        Paint paint = new Paint(1);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAlpha(8);
        paint.setColor(ColorUtils.setAlphaComponent(-16777216, 255));
        this.paint = paint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.paint.setStrokeWidth(getValue().floatValue());
        float f = 2;
        canvas.drawLine(canvas.getWidth() / f, this.paint.getStrokeWidth() / f, canvas.getWidth() / f, canvas.getHeight() - (this.paint.getStrokeWidth() / f), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "deprecated from Drawable#getOpacity")
    public int getOpacity() {
        return -2;
    }

    public final void setArgb(int Argb) {
        this.paint.setColor(Argb);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // androidx.recyclerview.sesl.drawable.SeslAutowiredDrawable
    public /* bridge */ /* synthetic */ void setValue(Float f) {
        setValue(f.floatValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.sesl.drawable.SeslAutowiredDrawable
    @NotNull
    public Float getValue() {
        return Float.valueOf(this.value);
    }

    public void setValue(float f) {
        this.value = f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }
}
