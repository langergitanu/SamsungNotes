package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.common.VDrawConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonStyle;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedRoundRect;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawRoundRect {
    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Picture createPicture(VPredefinedRoundRect vPredefinedRoundRect, RectF rectF, float f, String str, String str2) {
        float f4;
        String fillColor;
        float f5;
        Picture picture = new Picture();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        VAttributeCore coreAttrs = vPredefinedRoundRect.getCoreAttrs();
        VAttributeShape shapeAttrs = vPredefinedRoundRect.getShapeAttrs();
        VCommonStyle style = coreAttrs.getStyle();
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        int i = (int) fWidth;
        int i2 = (int) fHeight;
        float width = style.getWidth() + 80.0f;
        float height = style.getHeight() + 80.0f;
        float f6 = fWidth / width;
        float f7 = fHeight / height;
        float f8 = (height - 40.0f) * f7;
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        RectF rectF2 = new RectF(f6 * 40.0f, f7 * 40.0f, (width - 40.0f) * f6, f8);
        char arcUnit = vPredefinedRoundRect.getArcUnit();
        float arcSize = vPredefinedRoundRect.getArcSize();
        if (arcUnit != 'f') {
            f5 = arcUnit == '%' ? 100.0f : 65536.0f;
            float f9 = rectF2.right - rectF2.left;
            float f10 = rectF2.bottom - rectF2.top;
            f4 = f9 <= f10 ? (f10 / 2.0f) * arcSize : (f9 / 2.0f) * arcSize;
            fillColor = (str2 != null || str2.isEmpty()) ? shapeAttrs.getFillColor() : str2;
            if (!shapeAttrs.getFill() || (str2 != null && !str2.isEmpty())) {
                float color = fillColor == null ? VUtilString.parseColor(fillColor) : VUtilString.parseColor(VDrawConst.DEFAULT_FILL_COLOR);
                paint.setStyle(Paint.Style.FILL);
                paint.setColor((int) color);
                canvasBeginRecording.drawRoundRect(rectF2, f4, f4, paint);
            }
            if (f < 0.0f) {
                f = shapeAttrs.getStrokeWeight();
            }
            if (str != null || str.isEmpty()) {
                str = shapeAttrs.getStrokeColor();
            }
            if ((shapeAttrs.getStroke() || f >= 1.0f) && str != null) {
                float color2 = VUtilString.parseColor(str);
                paint.setStrokeWidth(f);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setStrokeJoin(Paint.Join.MITER);
                paint.setStrokeMiter(1.0f);
                paint.setColor((int) color2);
                canvasBeginRecording.drawRoundRect(rectF2, f4, f4, paint);
            }
            picture.endRecording();
            return picture;
        }
        arcSize /= f5;
        float f92 = rectF2.right - rectF2.left;
        float f102 = rectF2.bottom - rectF2.top;
        if (f92 <= f102) {
        }
        if (str2 != null) {
        }
        if (!shapeAttrs.getFill()) {
            float color3 = fillColor == null ? VUtilString.parseColor(fillColor) : VUtilString.parseColor(VDrawConst.DEFAULT_FILL_COLOR);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor((int) color3);
            canvasBeginRecording.drawRoundRect(rectF2, f4, f4, paint);
        }
        if (f < 0.0f) {
        }
        if (str != null) {
            str = shapeAttrs.getStrokeColor();
        }
        if (shapeAttrs.getStroke()) {
            float color22 = VUtilString.parseColor(str);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(1.0f);
            paint.setColor((int) color22);
            canvasBeginRecording.drawRoundRect(rectF2, f4, f4, paint);
        } else {
            float color222 = VUtilString.parseColor(str);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(1.0f);
            paint.setColor((int) color222);
            canvasBeginRecording.drawRoundRect(rectF2, f4, f4, paint);
        }
        picture.endRecording();
        return picture;
    }
}
