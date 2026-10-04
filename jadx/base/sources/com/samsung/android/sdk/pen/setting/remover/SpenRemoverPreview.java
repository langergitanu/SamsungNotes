package com.samsung.android.sdk.pen.setting.remover;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.samsung.android.sdk.pen.engine.util.SpenEngineUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bJ(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0014J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverPreview;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mBitmap", "Landroid/graphics/Bitmap;", "mBitmapPaint", "Landroid/graphics/Paint;", "mDensity", "", "mSize", "mFillColor", "", "close", "", "setRemoverSize", "size", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRemoverPreview.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRemoverPreview.kt\ncom/samsung/android/sdk/pen/setting/remover/SpenRemoverPreview\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
public final class SpenRemoverPreview extends View {

    @Nullable
    private Bitmap mBitmap;

    @Nullable
    private Paint mBitmapPaint;
    private final float mDensity;
    private final int mFillColor;
    private float mSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRemoverPreview(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mSize = 0.0f;
        this.mBitmapPaint = new Paint(4);
        this.mFillColor = SpenSettingUtil.getColor(context, C7932R.color.setting_bg_color);
    }

    public final void close() {
        this.mBitmapPaint = null;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || this.mSize <= 0.0f) {
            return;
        }
        bitmap.eraseColor(0);
        float f = this.mDensity;
        SpenEngineUtil.drawRemoverPreview(bitmap, f, 1.0f, 6 * f * this.mSize, -6842473, this.mFillColor);
        Paint paint = this.mBitmapPaint;
        if (paint != null) {
            paint.setColor(-16777216);
        }
        Paint paint2 = this.mBitmapPaint;
        if (paint2 != null) {
            paint2.setAntiAlias(true);
        }
        canvas.drawBitmap(bitmap, getPaddingStart(), getPaddingTop(), this.mBitmapPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w <= 0 || h <= 0) {
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        this.mBitmap = Bitmap.createBitmap((w - getPaddingStart()) - getPaddingEnd(), (h - getPaddingTop()) - getPaddingBottom(), Bitmap.Config.ARGB_8888);
    }

    public final void setRemoverSize(float size) {
        this.mSize = size;
    }
}
