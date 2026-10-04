package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonStyle;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedLine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawLine {
    public static Picture createPicture(VPredefinedLine vPredefinedLine, RectF rectF, float f, String str, String str2) {
        Picture picture = new Picture();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        VAttributeCore coreAttrs = vPredefinedLine.getCoreAttrs();
        VAttributeShape shapeAttrs = vPredefinedLine.getShapeAttrs();
        VCommonStyle style = coreAttrs.getStyle();
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        int i = (int) fWidth;
        int i2 = (int) fHeight;
        float width = fWidth / (style.getWidth() + 80.0f);
        float height = fHeight / (style.getHeight() + 80.0f);
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        float sx = (vPredefinedLine.getFrom().getSx() + 40.0f) * width;
        float sy = (vPredefinedLine.getFrom().getSy() + 40.0f) * height;
        float sx2 = (vPredefinedLine.getTo().getSx() + 40.0f) * width;
        float sy2 = (vPredefinedLine.getTo().getSy() + 40.0f) * height;
        if (f < 0.0f) {
            f = shapeAttrs.getStrokeWeight();
        }
        if (str == null || str.isEmpty()) {
            str = shapeAttrs.getStrokeColor();
        }
        if ((shapeAttrs.getStroke() || f >= 1.0f) && str != null) {
            float color = VUtilString.parseColor(str);
            paint.setStrokeWidth(f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(1.0f);
            paint.setColor((int) color);
            canvasBeginRecording.drawLine(sx, sy, sx2, sy2, paint);
        }
        picture.endRecording();
        return picture;
    }
}
