package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;

    @Nullable
    private ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.lottieDrawable = lottieDrawable;
        this.name = roundedCorners.getName();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation = roundedCorners.getCornerRadius().createAnimation();
        this.roundedCorners = baseKeyframeAnimationCreateAnimation;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
    }

    private static int floorDiv(int i, int i2) {
        int i4 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i4 == i) ? i4 : i4 - 1;
    }

    private static int floorMod(int i, int i2) {
        return i - (floorDiv(i, i2) * i2);
    }

    @NonNull
    private ShapeData getShapeData(ShapeData shapeData) {
        List<CubicCurveData> curves = shapeData.getCurves();
        boolean zIsClosed = shapeData.isClosed();
        int size = curves.size() - 1;
        int i = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(size - 1, curves.size()));
            PointF vertex = (size != 0 || zIsClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
            i = (((size != 0 || zIsClosed) ? cubicCurveData2.getControlPoint2() : vertex).equals(vertex) && cubicCurveData.getControlPoint1().equals(vertex) && !(!shapeData.isClosed() && (size == 0 || size == curves.size() - 1))) ? i + 2 : i + 1;
            size--;
        }
        ShapeData shapeData2 = this.shapeData;
        if (shapeData2 == null || shapeData2.getCurves().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.shapeData.setClosed(zIsClosed);
        return this.shapeData;
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public void addUpdateListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.roundedCorners.addUpdateListener(animationListener);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeData modifyShape(ShapeData shapeData) {
        boolean z;
        List<CubicCurveData> list;
        List<CubicCurveData> curves = shapeData.getCurves();
        if (curves.size() > 2) {
            float fFloatValue = this.roundedCorners.getValue().floatValue();
            if (fFloatValue != 0.0f) {
                ShapeData shapeData2 = getShapeData(shapeData);
                shapeData2.setInitialPoint(shapeData.getInitialPoint().x, shapeData.getInitialPoint().y);
                List<CubicCurveData> curves2 = shapeData2.getCurves();
                boolean zIsClosed = shapeData.isClosed();
                int i = 0;
                int i2 = 0;
                while (i < curves.size()) {
                    CubicCurveData cubicCurveData = curves.get(i);
                    CubicCurveData cubicCurveData2 = curves.get(floorMod(i - 1, curves.size()));
                    CubicCurveData cubicCurveData3 = curves.get(floorMod(i - 2, curves.size()));
                    PointF vertex = (i != 0 || zIsClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
                    PointF controlPoint2 = (i != 0 || zIsClosed) ? cubicCurveData2.getControlPoint2() : vertex;
                    PointF controlPoint1 = cubicCurveData.getControlPoint1();
                    PointF vertex2 = cubicCurveData3.getVertex();
                    PointF vertex3 = cubicCurveData.getVertex();
                    if (!shapeData.isClosed()) {
                        z = true;
                        if (i != 0 && i != curves.size() - 1) {
                            z = false;
                        }
                    }
                    if (controlPoint2.equals(vertex) && controlPoint1.equals(vertex) && !z) {
                        float f = vertex.x;
                        float f4 = f - vertex2.x;
                        float f5 = vertex.y;
                        float f6 = f5 - vertex2.y;
                        float f7 = vertex3.x - f;
                        float f8 = vertex3.y - f5;
                        list = curves;
                        float fHypot = (float) Math.hypot(f4, f6);
                        float fHypot2 = (float) Math.hypot(f7, f8);
                        float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                        float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                        float f9 = vertex.x;
                        float fM29z = AbstractC0000a.m29z(vertex2.x, f9, fMin, f9);
                        float f10 = vertex.y;
                        float fM29z2 = AbstractC0000a.m29z(vertex2.y, f10, fMin, f10);
                        float fM29z3 = AbstractC0000a.m29z(vertex3.x, f9, fMin2, f9);
                        float fM29z4 = AbstractC0000a.m29z(vertex3.y, f10, fMin2, f10);
                        float f11 = fM29z - ((fM29z - f9) * ROUNDED_CORNER_MAGIC_NUMBER);
                        float f12 = fM29z2 - ((fM29z2 - f10) * ROUNDED_CORNER_MAGIC_NUMBER);
                        float f13 = fM29z3 - ((fM29z3 - f9) * ROUNDED_CORNER_MAGIC_NUMBER);
                        float f14 = fM29z4 - ((fM29z4 - f10) * ROUNDED_CORNER_MAGIC_NUMBER);
                        CubicCurveData cubicCurveData4 = curves2.get(floorMod(i2 - 1, curves2.size()));
                        CubicCurveData cubicCurveData5 = curves2.get(i2);
                        cubicCurveData4.setControlPoint2(fM29z, fM29z2);
                        cubicCurveData4.setVertex(fM29z, fM29z2);
                        if (i == 0) {
                            shapeData2.setInitialPoint(fM29z, fM29z2);
                        }
                        cubicCurveData5.setControlPoint1(f11, f12);
                        CubicCurveData cubicCurveData6 = curves2.get(i2 + 1);
                        cubicCurveData5.setControlPoint2(f13, f14);
                        cubicCurveData5.setVertex(fM29z3, fM29z4);
                        cubicCurveData6.setControlPoint1(fM29z3, fM29z4);
                        i2 += 2;
                    } else {
                        list = curves;
                        CubicCurveData cubicCurveData7 = curves2.get(floorMod(i2 - 1, curves2.size()));
                        CubicCurveData cubicCurveData8 = curves2.get(i2);
                        cubicCurveData7.setControlPoint2(cubicCurveData2.getControlPoint2().x, cubicCurveData2.getControlPoint2().y);
                        cubicCurveData7.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                        cubicCurveData8.setControlPoint1(cubicCurveData.getControlPoint1().x, cubicCurveData.getControlPoint1().y);
                        i2++;
                    }
                    i++;
                    curves = list;
                }
                return shapeData2;
            }
        }
        return shapeData;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
