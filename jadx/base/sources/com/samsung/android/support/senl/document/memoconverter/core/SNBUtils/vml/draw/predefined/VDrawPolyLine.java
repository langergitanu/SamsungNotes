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
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonStyle;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedPolyLine;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawPolyLine {
    public static Picture createPicture(VPredefinedPolyLine vPredefinedPolyLine, RectF rectF, float f, String str, String str2) {
        Picture picture = new Picture();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        VAttributeCore coreAttrs = vPredefinedPolyLine.getCoreAttrs();
        VAttributeShape shapeAttrs = vPredefinedPolyLine.getShapeAttrs();
        VCommonStyle style = coreAttrs.getStyle();
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        int i = (int) fWidth;
        int i2 = (int) fHeight;
        float width = fWidth / (style.getWidth() + 80.0f);
        float height = fHeight / (style.getHeight() + 80.0f);
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        ArrayList<VCommonPoint> arrayList = new ArrayList();
        for (VCommonPoint vCommonPoint : vPredefinedPolyLine.getPoints()) {
            VCommonPoint vCommonPoint2 = new VCommonPoint();
            vCommonPoint2.setSx((vCommonPoint.getSx() + 40.0f) * width);
            vCommonPoint2.setSy((vCommonPoint.getSy() + 40.0f) * height);
            arrayList.add(vCommonPoint2);
        }
        Path path = new Path();
        int i4 = 0;
        for (VCommonPoint vCommonPoint3 : arrayList) {
            if (i4 == 0) {
                path.moveTo(vCommonPoint3.getSx(), vCommonPoint3.getSy());
                i4++;
            } else {
                path.lineTo(vCommonPoint3.getSx(), vCommonPoint3.getSy());
            }
        }
        String fillColor = (str2 == null || str2.isEmpty()) ? shapeAttrs.getFillColor() : str2;
        if (shapeAttrs.getFill() || (str2 != null && !str2.isEmpty())) {
            float color = fillColor != null ? VUtilString.parseColor(fillColor) : VUtilString.parseColor(VDrawConst.DEFAULT_FILL_COLOR);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor((int) color);
            canvasBeginRecording.drawPath(path, paint);
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
            canvasBeginRecording.drawPath(path, paint);
        }
        picture.endRecording();
        return picture;
    }
}
