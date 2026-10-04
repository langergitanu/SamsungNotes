package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;

    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;

    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private final Path lastSegmentPath = new Path();
    private final PathMeasure lastSegmentPathMeasure = new PathMeasure();
    private final float[] lastSegmentPosition = new float[2];
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.PolystarContent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C43191 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = floatKeyframeAnimationCreateAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation = polystarShape.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimationCreateAnimation;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation2 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = floatKeyframeAnimationCreateAnimation2;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation3 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = floatKeyframeAnimationCreateAnimation3;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation4 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = floatKeyframeAnimationCreateAnimation4;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation3);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation4);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        double d;
        float f;
        float f4;
        float f5;
        int iFloor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d2 = iFloor;
        float fFloatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d3 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d3);
        float fSin = (float) (Math.sin(radians) * d3);
        this.path.moveTo(fCos, fSin);
        double d4 = (float) (6.283185307179586d / d2);
        double dCeil = Math.ceil(d2);
        double d5 = radians + d4;
        int i = 0;
        while (true) {
            double d6 = i;
            if (d6 >= dCeil) {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
            float fCos2 = (float) (Math.cos(d5) * d3);
            float fSin2 = (float) (Math.sin(d5) * d3);
            if (fFloatValue != 0.0f) {
                d = dCeil;
                f = fFloatValue;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f6 = fFloatValue2 * f * 0.25f;
                float f7 = f6 * fCos3;
                float f8 = f6 * fSin3;
                float fCos4 = ((float) Math.cos(dAtan22)) * f6;
                float fSin4 = f6 * ((float) Math.sin(dAtan22));
                if (d6 == d - 1.0d) {
                    this.lastSegmentPath.reset();
                    this.lastSegmentPath.moveTo(fCos, fSin);
                    float f9 = fCos - f7;
                    float f10 = fSin - f8;
                    float f11 = fCos2 + fCos4;
                    float f12 = fSin2 + fSin4;
                    f4 = fCos2;
                    f5 = fSin2;
                    this.lastSegmentPath.cubicTo(f9, f10, f11, f12, f4, f5);
                    this.lastSegmentPathMeasure.setPath(this.lastSegmentPath, false);
                    PathMeasure pathMeasure = this.lastSegmentPathMeasure;
                    pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, this.lastSegmentPosition, null);
                    Path path = this.path;
                    float[] fArr = this.lastSegmentPosition;
                    path.cubicTo(f9, f10, f11, f12, fArr[0], fArr[1]);
                } else {
                    f4 = fCos2;
                    f5 = fSin2;
                    this.path.cubicTo(fCos - f7, fSin - f8, f4 + fCos4, f5 + fSin4, f4, f5);
                }
                fCos = f4;
                fSin = f5;
            } else {
                fCos = fCos2;
                fSin = fSin2;
                d = dCeil;
                f = fFloatValue;
                if (d6 == d - 1.0d) {
                    i++;
                    dCeil = d;
                    fFloatValue = f;
                } else {
                    this.path.lineTo(fCos, fSin);
                }
            }
            d5 += d4;
            i++;
            dCeil = d;
            fFloatValue = f;
        }
    }

    private void createStarPath() {
        float f;
        float f4;
        int i;
        float fCos;
        float fSin;
        float f5;
        float f6;
        double d;
        float fM29z;
        int i2;
        float f7;
        double d2;
        float f8;
        float f9;
        double d3;
        float f10;
        float f11;
        float fFloatValue = this.pointsAnimation.getValue().floatValue();
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f12 = (float) (6.283185307179586d / d4);
        if (this.isReversed) {
            f12 *= -1.0f;
        }
        float f13 = f12 / 2.0f;
        float f14 = fFloatValue - ((int) fFloatValue);
        int i4 = (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1));
        if (i4 != 0) {
            radians += (double) ((1.0f - f14) * f13);
        }
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float fFloatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.innerRoundednessAnimation;
        float fFloatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.outerRoundednessAnimation;
        float fFloatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        if (i4 != 0) {
            fM29z = AbstractC0000a.m29z(fFloatValue2, fFloatValue3, f14, fFloatValue3);
            f4 = 0.0f;
            i = i4;
            double d5 = fM29z;
            f = 2.0f;
            float fCos2 = (float) (Math.cos(radians) * d5);
            fSin = (float) (Math.sin(radians) * d5);
            this.path.moveTo(fCos2, fSin);
            d = radians + ((double) ((f12 * f14) / 2.0f));
            f5 = f14;
            fCos = fCos2;
            f6 = f13;
        } else {
            f = 2.0f;
            f4 = 0.0f;
            i = i4;
            double d6 = fFloatValue2;
            fCos = (float) (Math.cos(radians) * d6);
            fSin = (float) (d6 * Math.sin(radians));
            this.path.moveTo(fCos, fSin);
            f5 = f14;
            f6 = f13;
            d = radians + ((double) f6);
            fM29z = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i5 = 0;
        boolean z = false;
        double d7 = d;
        float f15 = fSin;
        float f16 = fCos;
        double d8 = d7;
        while (true) {
            double d9 = i5;
            if (d9 >= dCeil) {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
            float f17 = z ? fFloatValue2 : fFloatValue3;
            if (fM29z == f4 || d9 != dCeil - 2.0d) {
                i2 = i5;
                f7 = f6;
            } else {
                i2 = i5;
                f7 = (f12 * f5) / f;
            }
            if (fM29z == f4 || d9 != dCeil - 1.0d) {
                d2 = d9;
                f8 = f17;
            } else {
                d2 = d9;
                f8 = fM29z;
            }
            double d10 = f8;
            float fCos3 = (float) (Math.cos(d8) * d10);
            float f18 = f12;
            float fSin2 = (float) (Math.sin(d8) * d10);
            if (fFloatValue4 == f4 && fFloatValue5 == f4) {
                this.path.lineTo(fCos3, fSin2);
                f11 = fCos3;
                f10 = fSin2;
                f9 = f6;
                d3 = d8;
            } else {
                f9 = f6;
                d3 = d8;
                double dAtan2 = (float) (Math.atan2(f15, f16) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                float f19 = f16;
                float f20 = f15;
                f10 = fSin2;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f21 = z ? fFloatValue4 : fFloatValue5;
                float f22 = z ? fFloatValue5 : fFloatValue4;
                float f23 = z ? fFloatValue3 : fFloatValue2;
                float f24 = z ? fFloatValue2 : fFloatValue3;
                float f25 = f23 * f21 * POLYSTAR_MAGIC_NUMBER;
                float f26 = fCos4 * f25;
                float f27 = f25 * fSin3;
                float f28 = f24 * f22 * POLYSTAR_MAGIC_NUMBER;
                float f29 = fCos5 * f28;
                float f30 = f28 * fSin4;
                if (i != 0) {
                    if (i2 == 0) {
                        f26 *= f5;
                        f27 *= f5;
                    } else if (d2 == dCeil - 1.0d) {
                        f29 *= f5;
                        f30 *= f5;
                    }
                }
                f11 = fCos3;
                this.path.cubicTo(f19 - f26, f20 - f27, fCos3 + f29, f10 + f30, f11, f10);
            }
            d8 = d3 + ((double) f7);
            z = !z;
            i5 = i2 + 1;
            f6 = f9;
            f16 = f11;
            f15 = f10;
            f12 = f18;
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i = C43191.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }
}
