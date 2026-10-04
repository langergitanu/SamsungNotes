package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.common.VDrawConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonStyle;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedCurve;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawCurve {
    public static Picture createPicture(VPredefinedCurve vPredefinedCurve, RectF rectF, float f, String str, String str2) {
        Picture picture = new Picture();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        VAttributeCore coreAttrs = vPredefinedCurve.getCoreAttrs();
        VAttributeShape shapeAttrs = vPredefinedCurve.getShapeAttrs();
        VCommonStyle style = coreAttrs.getStyle();
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        int i = (int) fWidth;
        int i2 = (int) fHeight;
        float width = fWidth / (style.getWidth() + 80.0f);
        float height = fHeight / (style.getHeight() + 80.0f);
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        float sx = (vPredefinedCurve.getFrom().getSx() + 40.0f) * width;
        float sy = (vPredefinedCurve.getFrom().getSy() + 40.0f) * height;
        float sx2 = (vPredefinedCurve.getTo().getSx() + 40.0f) * width;
        float sy2 = (vPredefinedCurve.getTo().getSy() + 40.0f) * height;
        float sx3 = (vPredefinedCurve.getControl1().getSx() + 40.0f) * width;
        float sy3 = (vPredefinedCurve.getControl1().getSy() + 40.0f) * height;
        float sx4 = (vPredefinedCurve.getControl2().getSx() + 40.0f) * width;
        float sy4 = (vPredefinedCurve.getControl2().getSy() + 40.0f) * height;
        Path path = new Path();
        path.moveTo(sx, sy);
        path.cubicTo(sx3, sy3, sx4, sy4, sx2, sy2);
        String fillColor = (str2 == null || str2.isEmpty()) ? shapeAttrs.getFillColor() : str2;
        if (shapeAttrs.getFill() || (str2 != null && !str2.isEmpty())) {
            float color = fillColor != null ? VUtilString.parseColor(fillColor) : VUtilString.parseColor(VDrawConst.DEFAULT_FILL_COLOR);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor((int) color);
            canvasBeginRecording.drawPath(path, paint);
        }
        float strokeWeight = f < 0.0f ? shapeAttrs.getStrokeWeight() : f;
        String strokeColor = (str == null || str.isEmpty()) ? shapeAttrs.getStrokeColor() : str;
        if ((shapeAttrs.getStroke() || strokeWeight >= 1.0f) && strokeColor != null) {
            float color2 = VUtilString.parseColor(strokeColor);
            paint.setStrokeWidth(strokeWeight);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(1.0f);
            paint.setColor((int) color2);
            canvasBeginRecording.drawPath(path, paint);
        }
        picture.endRecording();
        return picture;
    }
}
