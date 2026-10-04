package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "sizeOffset", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCurvedSliderThumbView extends View {
    private static final int SHADOW_COLOR = 855638016;

    @NotNull
    private Paint paint;
    private float sizeOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCurvedSliderThumbView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_seekbar_thumb_stroke_width);
        this.sizeOffset = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_seekbar_thumb_size_offset);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(-1);
        paint.setStrokeWidth(dimensionPixelSize);
        this.paint = paint;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin = (Math.min(width, height) - (this.paint.getStrokeWidth() / 2.0f)) - this.sizeOffset;
        this.paint.setColor(-1);
        Paint paint = this.paint;
        paint.setShadowLayer(paint.getStrokeWidth(), 0.0f, 0.0f, SHADOW_COLOR);
        canvas.drawCircle(width, height, fMin, this.paint);
    }
}
