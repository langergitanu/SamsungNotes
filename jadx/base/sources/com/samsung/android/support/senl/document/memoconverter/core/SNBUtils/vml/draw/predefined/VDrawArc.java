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
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedArc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawArc {
    public static Picture createPicture(VPredefinedArc vPredefinedArc, RectF rectF, float f, String str, String str2) {
        Canvas canvas;
        Picture picture = new Picture();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        VAttributeCore coreAttrs = vPredefinedArc.getCoreAttrs();
        VAttributeShape shapeAttrs = vPredefinedArc.getShapeAttrs();
        VCommonStyle style = coreAttrs.getStyle();
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        int i = (int) fWidth;
        int i2 = (int) fHeight;
        float width = style.getWidth() + 80.0f;
        float height = style.getHeight() + 80.0f;
        float f4 = fWidth / width;
        float f5 = fHeight / height;
        float f6 = (height - 40.0f) * f5;
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        RectF rectF2 = new RectF(f4 * 40.0f, f5 * 40.0f, (width - 40.0f) * f4, f6);
        float startAngle = vPredefinedArc.getStartAngle() - 90.0f;
        float endAngle = vPredefinedArc.getEndAngle();
        String fillColor = (str2 == null || str2.isEmpty()) ? shapeAttrs.getFillColor() : str2;
        if (shapeAttrs.getFill() || !(str2 == null || str2.isEmpty())) {
            float color = fillColor != null ? VUtilString.parseColor(fillColor) : VUtilString.parseColor(VDrawConst.DEFAULT_FILL_COLOR);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor((int) color);
            canvas = canvasBeginRecording;
            canvas.drawArc(rectF2, startAngle, endAngle, false, paint);
        } else {
            canvas = canvasBeginRecording;
        }
        if (f < 0.0f) {
            f = shapeAttrs.getStrokeWeight();
        }
        if (str == null || str.isEmpty()) {
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
            canvas.drawArc(rectF2, startAngle, endAngle, false, paint);
        }
        picture.endRecording();
        return picture;
    }
}
