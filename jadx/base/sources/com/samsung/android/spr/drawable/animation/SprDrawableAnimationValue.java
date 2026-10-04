package com.samsung.android.spr.drawable.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeAnimatorSet;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeFill;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeMatrix;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStroke;
import com.samsung.android.spr.drawable.document.shape.SprObjectBase;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprDrawableAnimationValue extends SprDrawableAnimation {
    private final ArrayList<AnimatorData> mAnimatingList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AnimatorData {
        public AnimatorSet animatorSet;
        public long duration;
        public SprAttributeFill fillPaint;
        public boolean isRunning;
        public SprAttributeMatrix matrix;
        public SprObjectBase object;
        public int repeatCount;
        public long startTime;
        public SprAttributeStroke strokePaint;
        public SprAnimatorBase.UpdateParameter updateParameter;

        private AnimatorData() {
            this.updateParameter = new SprAnimatorBase.UpdateParameter();
        }
    }

    public SprDrawableAnimationValue(Drawable drawable, SprDocument sprDocument) {
        super((byte) 1, drawable, sprDocument);
        this.mAnimatingList = new ArrayList<>();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zUpdateAnimatorData;
        if (this.mAnimatingList.size() == 0) {
            this.mIsRunning = false;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = 0;
        while (i < this.mAnimatingList.size()) {
            AnimatorData animatorData = this.mAnimatingList.get(i);
            if (animatorData.isRunning) {
                if (jUptimeMillis > animatorData.startTime + animatorData.duration) {
                    zUpdateAnimatorData = updateAnimatorData(animatorData, true);
                    animatorData.animatorSet.cancel();
                    if (animatorData.repeatCount != 0) {
                        animatorData.animatorSet.start();
                        animatorData.startTime = jUptimeMillis;
                        int i2 = animatorData.repeatCount;
                        if (i2 > 0) {
                            animatorData.repeatCount = i2 - 1;
                        }
                    } else {
                        this.mAnimatingList.remove(i);
                        i--;
                    }
                } else {
                    zUpdateAnimatorData = updateAnimatorData(animatorData, false);
                }
                if (zUpdateAnimatorData) {
                    animatorData.object.preDraw(this.mDocument);
                }
            } else if (jUptimeMillis > animatorData.startTime) {
                animatorData.animatorSet.start();
                animatorData.startTime = jUptimeMillis;
                animatorData.isRunning = true;
            }
            i++;
        }
        if (this.mAnimatingList.size() > 0) {
            this.mDrawable.scheduleSelf(this, jUptimeMillis + ((long) this.mInterval));
        }
        this.mDrawable.invalidateSelf();
    }

    @Override // com.samsung.android.spr.drawable.animation.SprDrawableAnimation
    public void start() {
        super.start();
        this.mAnimatingList.clear();
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (SprObjectBase sprObjectBase : this.mDocument.getValueAnimationObjects()) {
            SprAttributeAnimatorSet sprAttributeAnimatorSet = null;
            SprAttributeFill sprAttributeFill = null;
            SprAttributeStroke sprAttributeStroke = null;
            SprAttributeMatrix sprAttributeMatrixMo22166clone = null;
            for (SprAttributeBase sprAttributeBase : sprObjectBase.mAttributeList) {
                byte b = sprAttributeBase.mType;
                if (b == 32) {
                    sprAttributeFill = (SprAttributeFill) sprAttributeBase;
                } else if (b == 35) {
                    sprAttributeStroke = (SprAttributeStroke) sprAttributeBase;
                } else if (b == 64) {
                    sprAttributeMatrixMo22166clone = (SprAttributeMatrix) sprAttributeBase;
                } else if (b == 97) {
                    sprAttributeAnimatorSet = (SprAttributeAnimatorSet) sprAttributeBase;
                }
            }
            if (sprAttributeAnimatorSet != null) {
                AnimatorData animatorData = new AnimatorData();
                AnimatorSet animatorSet = new AnimatorSet();
                animatorData.animatorSet = animatorSet;
                animatorSet.playTogether(sprAttributeAnimatorSet.getAnimators());
                if (sprAttributeFill == null) {
                    SprAttributeFill sprAttributeFill2 = sprObjectBase.hasFillAnimation ? new SprAttributeFill() : new SprAttributeFill((byte) 0, 0);
                    sprObjectBase.getIntrinsic().appendAttribute(sprAttributeFill2);
                    try {
                        sprAttributeFill = (SprAttributeFill) sprAttributeFill2.mo22166clone();
                        sprObjectBase.appendAttribute(sprAttributeFill);
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (sprAttributeStroke == null) {
                    SprAttributeStroke sprAttributeStroke2 = sprObjectBase.hasStrokeAnimation ? new SprAttributeStroke() : new SprAttributeStroke((byte) 0, 0);
                    sprObjectBase.getIntrinsic().appendAttribute(sprAttributeStroke2);
                    try {
                        sprAttributeStroke = (SprAttributeStroke) sprAttributeStroke2.mo22166clone();
                        sprObjectBase.appendAttribute(sprAttributeStroke);
                    } catch (CloneNotSupportedException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                if (sprAttributeMatrixMo22166clone == null) {
                    SprAttributeMatrix sprAttributeMatrix = new SprAttributeMatrix();
                    sprObjectBase.getIntrinsic().appendAttribute(sprAttributeMatrix);
                    try {
                        sprAttributeMatrixMo22166clone = sprAttributeMatrix.mo22166clone();
                        sprObjectBase.appendAttribute(sprAttributeMatrixMo22166clone);
                    } catch (CloneNotSupportedException e3) {
                        throw new RuntimeException(e3);
                    }
                }
                animatorData.matrix = sprAttributeMatrixMo22166clone;
                animatorData.fillPaint = sprAttributeFill;
                animatorData.strokePaint = sprAttributeStroke;
                animatorData.object = sprObjectBase;
                animatorData.startTime = jUptimeMillis;
                animatorData.duration = sprAttributeAnimatorSet.duration;
                animatorData.repeatCount = sprAttributeAnimatorSet.repeatCount;
                this.mAnimatingList.add(animatorData);
            }
        }
        this.mDrawable.scheduleSelf(this, jUptimeMillis);
    }

    @Override // com.samsung.android.spr.drawable.animation.SprDrawableAnimation
    public void stop() {
        super.stop();
        Iterator<AnimatorData> it = this.mAnimatingList.iterator();
        while (it.hasNext()) {
            it.next().animatorSet.cancel();
        }
        this.mAnimatingList.clear();
    }

    @Override // com.samsung.android.spr.drawable.animation.SprDrawableAnimation
    public void update() {
        super.update();
        Iterator<AnimatorData> it = this.mAnimatingList.iterator();
        while (it.hasNext()) {
            updateAnimatorData(it.next(), false);
        }
    }

    public boolean updateAnimatorData(AnimatorData animatorData, boolean z) {
        SprAnimatorBase.UpdateParameter updateParameter = animatorData.updateParameter;
        updateParameter.isLastFrame = z;
        boolean z2 = false;
        updateParameter.isUpdatedStrokeColor = false;
        updateParameter.isUpdatedFillColor = false;
        updateParameter.isUpdatedTranslate = false;
        updateParameter.isUpdatedRotate = false;
        updateParameter.isUpdatedScale = false;
        updateParameter.alpha = animatorData.object.alpha;
        Iterator<Animator> it = animatorData.animatorSet.getChildAnimations().iterator();
        while (it.hasNext()) {
            if (((SprAnimatorBase) it.next()).update(animatorData.updateParameter)) {
                z2 = true;
            }
        }
        animatorData.matrix.reset();
        SprAnimatorBase.UpdateParameter updateParameter2 = animatorData.updateParameter;
        if (updateParameter2.isUpdatedScale) {
            animatorData.matrix.matrix.postScale(updateParameter2.scaleX, updateParameter2.scaleY, updateParameter2.scalePivotX, updateParameter2.scalePivotY);
        }
        SprAnimatorBase.UpdateParameter updateParameter3 = animatorData.updateParameter;
        if (updateParameter3.isUpdatedRotate) {
            animatorData.matrix.matrix.postRotate(updateParameter3.rotateDegree, updateParameter3.rotatePivotX, updateParameter3.rotatePivotY);
        }
        SprAnimatorBase.UpdateParameter updateParameter4 = animatorData.updateParameter;
        if (updateParameter4.isUpdatedTranslate) {
            animatorData.matrix.matrix.postTranslate(updateParameter4.translateDx, updateParameter4.translateDy);
        }
        SprAnimatorBase.UpdateParameter updateParameter5 = animatorData.updateParameter;
        if (updateParameter5.isUpdatedFillColor) {
            animatorData.fillPaint.color = updateParameter5.fillColor;
        }
        if (updateParameter5.isUpdatedStrokeColor) {
            animatorData.strokePaint.color = updateParameter5.strokeColor;
        }
        animatorData.object.alpha = updateParameter5.alpha;
        return z2;
    }
}
