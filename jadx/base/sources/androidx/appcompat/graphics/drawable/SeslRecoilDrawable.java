package androidx.appcompat.graphics.drawable;

import android.R;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.C0421a;
import androidx.core.graphics.ColorUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 29)
public class SeslRecoilDrawable extends LayerDrawable {
    private static final int DEFAULT_TINT_COLOR = 419430400;
    private static final int RADIUS_AUTO = -1;
    private static final String TAG = "SeslRecoilDrawable";
    private final ValueAnimator mAnimator;
    private float mHotspotPointX;
    private float mHotspotPointY;
    private boolean mIsActive;
    private boolean mIsPressed;
    private SeslRecoilDrawableListener mListener;
    private Drawable mMask;
    private long mPressDuration;
    private int mRadius;
    private long mReleaseDuration;
    private int mTintColor;
    private static final Long PRESS_ANIMATION_DURATION = 100L;
    private static final Long RELEASE_ANIMATION_DURATION = 350L;
    private static final Interpolator PRESS_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator RELEASE_INTERPOLATOR = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslRecoilDrawableListener {
        void onReleaseAnimationStart();
    }

    public SeslRecoilDrawable() {
        super(new Drawable[0]);
        this.mIsActive = false;
        this.mIsPressed = false;
        this.mAnimator = ValueAnimator.ofFloat(0.0f);
        this.mListener = null;
        init();
    }

    private void drawHotspot(Canvas canvas) {
        float fCenterX = this.mHotspotPointX;
        float fCenterY = this.mHotspotPointY;
        Rect rect = new Rect();
        getHotspotBounds(rect);
        if (rect.height() > 0) {
            fCenterX = rect.centerX();
            fCenterY = rect.centerY();
        }
        canvas.translate(fCenterX, fCenterY);
        Paint paint = new Paint();
        paint.setColor(getAnimatingTintColor());
        canvas.drawCircle(0.0f, 0.0f, getRadius(), paint);
        canvas.translate(-fCenterX, -fCenterY);
    }

    private int getAnimatingTintColor() {
        return ColorUtils.setAlphaComponent(this.mTintColor, (int) (((Float) this.mAnimator.getAnimatedValue()).floatValue() * Color.valueOf(this.mTintColor).alpha() * 255.0f));
    }

    private float getRadius() {
        int i = this.mRadius;
        if (i > 0) {
            return i;
        }
        Rect rect = new Rect();
        getHotspotBounds(rect);
        int iHeight = rect.height() / 2;
        return iHeight > 0 ? iHeight : getBounds().height() / 2;
    }

    private void init() {
        this.mPressDuration = PRESS_ANIMATION_DURATION.longValue();
        this.mReleaseDuration = RELEASE_ANIMATION_DURATION.longValue();
        initAnimator();
        setPaddingMode(1);
    }

    private void initAnimator() {
        this.mAnimator.addUpdateListener(new C0421a(this, 1));
    }

    private boolean isDrawHotspot() {
        return getNumberOfLayers() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAnimator$0(ValueAnimator valueAnimator) {
        setTint();
        invalidateSelf();
    }

    private void setActive(boolean z, boolean z2, boolean z3) {
        boolean z4 = z || z2 || z3;
        if (z3) {
            this.mIsPressed = true;
            startEnterAnimation(1.0f);
        } else if (z2) {
            startEnterAnimation(0.6f);
        } else if (z) {
            startEnterAnimation(0.8f);
        } else if (this.mIsActive && !z4) {
            startExitAnimation();
        }
        this.mIsActive = z4;
        this.mIsPressed = z3;
    }

    private void setTint() {
        int animatingTintColor = getAnimatingTintColor();
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(animatingTintColor);
        } else {
            setTintBlendMode(BlendMode.HARD_LIGHT);
            setTint(animatingTintColor);
        }
    }

    private void startEnterAnimation(float f) {
        if (this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        ValueAnimator valueAnimator = this.mAnimator;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), f);
        this.mAnimator.setInterpolator(PRESS_INTERPOLATOR);
        this.mAnimator.setDuration(this.mPressDuration);
        this.mAnimator.start();
    }

    private void startExitAnimation() {
        if (this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        this.mAnimator.setFloatValues(!this.mIsPressed ? ((Float) this.mAnimator.getAnimatedValue()).floatValue() : 1.0f, 0.0f);
        this.mAnimator.setInterpolator(RELEASE_INTERPOLATOR);
        this.mAnimator.setDuration(this.mReleaseDuration);
        this.mAnimator.start();
        SeslRecoilDrawableListener seslRecoilDrawableListener = this.mListener;
        if (seslRecoilDrawableListener != null) {
            seslRecoilDrawableListener.onReleaseAnimationStart();
        }
    }

    private void updateMaskLayer() {
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(0);
            BlendMode unused = BlendMode.SRC_IN;
            drawableFindDrawableByLayerId.setTintBlendMode(BlendMode.SRC_IN);
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index = typedArray.getIndex(i);
            if (index == C0419R.styleable.SeslRecoil_seslRecoilColor) {
                this.mTintColor = typedArray.getColor(index, DEFAULT_TINT_COLOR);
            } else if (index == C0419R.styleable.SeslRecoil_seslRecoilRadius) {
                this.mRadius = typedArray.getDimensionPixelSize(index, -1);
            } else if (index == C0419R.styleable.SeslRecoil_seslRecoilMask) {
                Drawable drawable = typedArray.getDrawable(index);
                this.mMask = drawable;
                if (drawable != null) {
                    setId(addLayer(drawable), R.id.mask);
                }
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        if (isDrawHotspot()) {
            drawHotspot(canvas);
        } else {
            super.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return null;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean hasFocusStateSpecified() {
        return true;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, C0419R.styleable.SeslRecoil);
        try {
            try {
                updateStateFromTypedArray(typedArrayObtainAttributes);
            } catch (XmlPullParserException e) {
                Log.e(TAG, "Failed to parse!!", e);
            }
            super.inflate(resources, xmlPullParser, attributeSet, theme);
            updateMaskLayer();
        } finally {
            typedArrayObtainAttributes.recycle();
        }
    }

    public boolean isActive() {
        if (this.mIsActive) {
            return true;
        }
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return isDrawHotspot();
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.mAnimator.isRunning()) {
            this.mAnimator.end();
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i : iArr) {
            if (i == 16842908) {
                z = true;
            } else if (i == 16842919) {
                z3 = true;
            } else if (i == 16843623) {
                z2 = true;
            }
        }
        setActive(z, z2, z3);
        return super.onStateChange(iArr);
    }

    public void removeListener() {
        if (this.mListener != null) {
            this.mListener = null;
        }
    }

    public void setCancel() {
        setState(new int[0]);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setHotspot(float f, float f4) {
        super.setHotspot(f, f4);
        this.mHotspotPointX = f;
        this.mHotspotPointY = f4;
    }

    public void setListener(SeslRecoilDrawableListener seslRecoilDrawableListener) {
        if (this.mListener == null) {
            this.mListener = seslRecoilDrawableListener;
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setTintBlendMode(@NonNull BlendMode blendMode) {
        super.setTintBlendMode(blendMode);
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTintBlendMode(BlendMode.SRC_IN);
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(getAnimatingTintColor());
        }
    }

    public SeslRecoilDrawable(@NonNull Drawable[] drawableArr) {
        super(drawableArr);
        this.mIsActive = false;
        this.mIsPressed = false;
        this.mAnimator = ValueAnimator.ofFloat(0.0f);
        this.mListener = null;
        init();
    }

    public SeslRecoilDrawable(@ColorInt int i, @NonNull Drawable[] drawableArr, @Nullable Drawable drawable) {
        this(drawableArr);
        init();
        this.mTintColor = i;
        if (drawable != null) {
            this.mMask = drawable;
            setId(addLayer(drawable), R.id.mask);
        }
    }
}
