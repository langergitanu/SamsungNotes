package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C4306L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    @Nullable
    private BaseKeyframeAnimation<Float, Float> blurAnimation;
    float blurMaskFilterRadius;

    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;

    @Nullable
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    /* JADX INFO: renamed from: pm */
    private final PathMeasure f1907pm = new PathMeasure();
    private final Path path = new Path();
    private final Path trimPathPath = new Path();
    private final RectF rect = new RectF();
    private final List<PathGroup> pathGroups = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PathGroup {
        private final List<PathContent> paths;

        @Nullable
        private final TrimPathContent trimPath;

        private PathGroup(@Nullable TrimPathContent trimPathContent) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.blurMaskFilterRadius = 0.0f;
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = animatableFloatValue2.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.dashPatternAnimations.add(list.get(i).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
            baseLayer.addAnimation(this.dashPatternAnimations.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.dashPatternAnimations.get(i4).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
        if (baseLayer.getBlurEffect() != null) {
            FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = baseLayer.getBlurEffect().getBlurriness().createAnimation();
            this.blurAnimation = floatKeyframeAnimationCreateAnimation;
            floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.blurAnimation);
        }
    }

    private void applyDashPatternIfNeeded() {
        if (C4306L.isTraceEnabled()) {
            C4306L.beginSection("StrokeContent#applyDashPattern");
        }
        if (this.dashPatternAnimations.isEmpty()) {
            if (C4306L.isTraceEnabled()) {
                C4306L.endSection("StrokeContent#applyDashPattern");
                return;
            }
            return;
        }
        for (int i = 0; i < this.dashPatternAnimations.size(); i++) {
            this.dashPatternValues[i] = this.dashPatternAnimations.get(i).getValue().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.dashPatternValues;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.dashPatternValues;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.getValue().floatValue()));
        if (C4306L.isTraceEnabled()) {
            C4306L.endSection("StrokeContent#applyDashPattern");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyTrimPath(Canvas canvas, PathGroup pathGroup) {
        if (C4306L.isTraceEnabled()) {
            C4306L.beginSection("StrokeContent#applyTrimPath");
        }
        if (pathGroup.trimPath == null) {
            if (C4306L.isTraceEnabled()) {
                C4306L.endSection("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.path.reset();
        for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
            this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath());
        }
        float fFloatValue = pathGroup.trimPath.getStart().getValue().floatValue() / 100.0f;
        float fFloatValue2 = pathGroup.trimPath.getEnd().getValue().floatValue() / 100.0f;
        float fFloatValue3 = pathGroup.trimPath.getOffset().getValue().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.path, this.paint);
            if (C4306L.isTraceEnabled()) {
                C4306L.endSection("StrokeContent#applyTrimPath");
                return;
            }
            return;
        }
        this.f1907pm.setPath(this.path, false);
        float length = this.f1907pm.getLength();
        while (this.f1907pm.nextContour()) {
            length += this.f1907pm.getLength();
        }
        float f = fFloatValue3 * length;
        float f4 = (fFloatValue * length) + f;
        float fMin = Math.min((fFloatValue2 * length) + f, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = pathGroup.paths.size() - 1; size2 >= 0; size2--) {
            this.trimPathPath.set(((PathContent) pathGroup.paths.get(size2)).getPath());
            this.f1907pm.setPath(this.trimPathPath, false);
            float length2 = this.f1907pm.getLength();
            if (fMin > length) {
                float f6 = fMin - length;
                if (f6 >= f5 + length2 || f5 >= f6) {
                    float f7 = f5 + length2;
                    if (f7 >= f4 && f5 <= fMin) {
                        if (f7 > fMin || f4 >= f5) {
                            Utils.applyTrimPathIfNeeded(this.trimPathPath, f4 < f5 ? 0.0f : (f4 - f5) / length2, fMin > f7 ? 1.0f : (fMin - f5) / length2, 0.0f);
                            canvas.drawPath(this.trimPathPath, this.paint);
                        } else {
                            canvas.drawPath(this.trimPathPath, this.paint);
                        }
                    }
                } else {
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, f4 > length ? (f4 - length) / length2 : 0.0f, Math.min(f6 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.trimPathPath, this.paint);
                }
            }
            f5 += length2;
        }
        if (C4306L.isTraceEnabled()) {
            C4306L.endSection("StrokeContent#applyTrimPath");
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
            return;
        }
        if (t == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.blurAnimation;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.blurAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.layer.addAnimation(this.blurAnimation);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i, @Nullable DropShadow dropShadow) {
        if (C4306L.isTraceEnabled()) {
            C4306L.beginSection("StrokeContent#draw");
        }
        if (Utils.hasZeroScaleAxis(matrix)) {
            if (C4306L.isTraceEnabled()) {
                C4306L.endSection("StrokeContent#draw");
                return;
            }
            return;
        }
        float fIntValue = this.opacityAnimation.getValue().intValue() / 100.0f;
        this.paint.setAlpha(MiscUtils.clamp((int) (i * fIntValue), 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue());
        if (this.paint.getStrokeWidth() <= 0.0f) {
            if (C4306L.isTraceEnabled()) {
                C4306L.endSection("StrokeContent#draw");
                return;
            }
            return;
        }
        applyDashPatternIfNeeded();
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.blurAnimation;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2.getValue().floatValue();
            if (fFloatValue == 0.0f) {
                this.paint.setMaskFilter(null);
            } else if (fFloatValue != this.blurMaskFilterRadius) {
                this.paint.setMaskFilter(this.layer.getBlurMaskFilter(fFloatValue));
            }
            this.blurMaskFilterRadius = fFloatValue;
        }
        if (dropShadow != null) {
            dropShadow.applyWithAlpha((int) (fIntValue * 255.0f), this.paint);
        }
        canvas.save();
        canvas.concat(matrix);
        for (int i2 = 0; i2 < this.pathGroups.size(); i2++) {
            PathGroup pathGroup = this.pathGroups.get(i2);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas, pathGroup);
            } else {
                if (C4306L.isTraceEnabled()) {
                    C4306L.beginSection("StrokeContent#buildPath");
                }
                this.path.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath());
                }
                if (C4306L.isTraceEnabled()) {
                    C4306L.endSection("StrokeContent#buildPath");
                    C4306L.beginSection("StrokeContent#drawPath");
                }
                canvas.drawPath(this.path, this.paint);
                if (C4306L.isTraceEnabled()) {
                    C4306L.endSection("StrokeContent#drawPath");
                }
            }
        }
        canvas.restore();
        if (C4306L.isTraceEnabled()) {
            C4306L.endSection("StrokeContent#draw");
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        if (C4306L.isTraceEnabled()) {
            C4306L.beginSection("StrokeContent#getBounds");
        }
        this.path.reset();
        for (int i = 0; i < this.pathGroups.size(); i++) {
            PathGroup pathGroup = this.pathGroups.get(i);
            for (int i2 = 0; i2 < pathGroup.paths.size(); i2++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(i2)).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF rectF2 = this.rect;
        float f = floatValue / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        if (C4306L.isTraceEnabled()) {
            C4306L.endSection("StrokeContent#getBounds");
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.addListener(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.pathGroups.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.addListener(this);
                } else if (content2 instanceof PathContent) {
                    if (pathGroup == null) {
                        pathGroup = new PathGroup(trimPathContent);
                    }
                    pathGroup.paths.add((PathContent) content2);
                }
            }
        }
        if (pathGroup != null) {
            this.pathGroups.add(pathGroup);
        }
    }
}
