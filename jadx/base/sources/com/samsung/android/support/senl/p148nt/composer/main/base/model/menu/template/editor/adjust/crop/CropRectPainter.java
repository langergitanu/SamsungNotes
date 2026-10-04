package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CropRectPainter {
    private int mInsideBorderOffset;
    private Paint mInsideBorderPaint;
    private Paint mTrimAreaPaint;
    private Paint mTrimAreaPaintInMoving;

    public CropRectPainter(IResourceInjector iResourceInjector) {
        this.mInsideBorderOffset = iResourceInjector.getBorderThickness() / 2;
        this.mInsideBorderPaint = iResourceInjector.getInsideBorderPaint();
        this.mTrimAreaPaint = iResourceInjector.getTrimAreaPaint();
        this.mTrimAreaPaintInMoving = iResourceInjector.getTrimAreaPaintInMoving();
    }

    public void drawBorders(@NonNull Canvas canvas, RectF rectF) {
        float f = rectF.left;
        int i = this.mInsideBorderOffset;
        canvas.drawRect(f + i, rectF.top + i, rectF.right - i, rectF.bottom - i, this.mInsideBorderPaint);
    }

    public void drawTrimArea(@NonNull Canvas canvas, RectF rectF, RectF rectF2, boolean z) {
        Paint paint = z ? this.mTrimAreaPaintInMoving : this.mTrimAreaPaint;
        canvas.drawRect(rectF2.left, rectF2.top, rectF2.right, rectF.top, paint);
        canvas.drawRect(rectF2.left, rectF.bottom, rectF2.right, rectF2.bottom, paint);
        canvas.drawRect(rectF2.left, rectF.top, rectF.left, rectF.bottom, paint);
        canvas.drawRect(rectF.right, rectF.top, rectF2.right, rectF.bottom, paint);
    }
}
