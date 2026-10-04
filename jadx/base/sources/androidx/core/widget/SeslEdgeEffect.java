package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslEdgeEffect extends EdgeEffect {
    private static final int APPEAR_TIME = 250;
    private static final boolean DEBUG = false;
    private static final float EDGE_CONTROL_POINT_HEIGHT_WITHOUT_TAB_IN_DIP = 29.0f;
    private static final float EDGE_CONTROL_POINT_HEIGHT_WITH_TAB_IN_DIP = 19.0f;
    private static final float EDGE_MAX_ALPAH_DARK = 0.08f;
    private static final float EDGE_MAX_ALPAH_LIGHT = 0.05f;
    private static final float EDGE_PADDING_WITHOUT_TAB_IN_DIP = 5.0f;
    private static final float EDGE_PADDING_WITH_TAB_IN_DIP = 3.0f;
    private static final float EPSILON = 0.001f;
    private static final int KEEP_TIME = 0;
    private static final float MAX_GLOW_SCALE = 2.0f;
    private static final int MAX_VELOCITY = 10000;
    private static final int MIN_VELOCITY = 100;
    private static final int MSG_CALL_ONRELEASE = 1;
    private static final float PULL_GLOW_BEGIN = 0.0f;
    private static final int PULL_TIME = 167;
    private static final float RADIUS_FACTOR = 0.75f;
    private static final int RECEDE_TIME = 450;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_APPEAR = 5;
    private static final int STATE_IDLE = 0;
    private static final int STATE_KEEP = 6;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final float TAB_HEIGHT_BUFFER_IN_DIP = 5.0f;
    private static final float TAB_HEIGHT_IN_DIP = 85.0f;
    private static final String TAG = "SeslEdgeEffect";
    private static float sMaxAlpha;
    private float MAX_SCALE;
    private final Rect mBounds;
    private boolean mCanVerticalScroll;
    private float mDisplacement;
    private final DisplayMetrics mDisplayMetrics;
    private float mDuration;
    private float mEdgeControlPointHeight;
    private float mEdgeEffectMargin;
    private float mEdgePadding;
    private Runnable mForceCallOnRelease;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private final Handler mHandler;
    private View mHostView;
    private final Interpolator mInterpolator;
    protected boolean mOnReleaseCalled;
    private final Paint mPaint;
    private final Path mPath;
    private float mPullDistance;
    private long mStartTime;
    private int mState;
    private final float mTabHeight;
    private final float mTabHeightBuffer;
    private float mTargetDisplacement;
    private float mTempDeltaDistance;
    private float mTempDisplacement;
    private static final double ANGLE = 0.5235987755982988d;
    private static final float SIN = (float) Math.sin(ANGLE);
    private static final float COS = (float) Math.cos(ANGLE);
    private static final int[] ATTRS = {R.attr.colorEdgeEffect};

    public SeslEdgeEffect(Context context) {
        super(context);
        this.MAX_SCALE = 1.0f;
        this.mState = 0;
        this.mBounds = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mDisplacement = 0.5f;
        this.mTargetDisplacement = 0.5f;
        this.mOnReleaseCalled = false;
        this.mPath = new Path();
        this.mEdgeEffectMargin = 0.0f;
        this.mCanVerticalScroll = true;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: androidx.core.widget.SeslEdgeEffect.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                SeslEdgeEffect.this.onRelease();
            }
        };
        this.mForceCallOnRelease = new Runnable() { // from class: androidx.core.widget.SeslEdgeEffect.2
            @Override // java.lang.Runnable
            public void run() {
                SeslEdgeEffect seslEdgeEffect = SeslEdgeEffect.this;
                seslEdgeEffect.mOnReleaseCalled = true;
                seslEdgeEffect.onPull(seslEdgeEffect.mTempDeltaDistance, SeslEdgeEffect.this.mTempDisplacement);
                SeslEdgeEffect.this.mHandler.sendEmptyMessageDelayed(1, 700L);
            }
        };
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(ATTRS);
        int color = typedArrayObtainStyledAttributes.getColor(0, -10066330);
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(color & 16777215);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        sMaxAlpha = isLightTheme(context) ? 0.05f : 0.08f;
        this.mInterpolator = new DecelerateInterpolator();
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
        this.mTabHeight = dipToPixels(TAB_HEIGHT_IN_DIP);
        this.mTabHeightBuffer = dipToPixels(5.0f);
    }

    private float calculateEdgeEffectMargin(int i) {
        return ((float) (((double) i) * 0.136d)) / 2.0f;
    }

    private float dipToPixels(float f) {
        return TypedValue.applyDimension(1, f, this.mDisplayMetrics);
    }

    private boolean isEdgeEffectRunning() {
        int i = this.mState;
        return i == 5 || i == 6 || i == 3 || i == 2;
    }

    private boolean isLightTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        return (context.getTheme().resolveAttribute(R.attr.isLightTheme, typedValue, true) && typedValue.data == 0) ? false : true;
    }

    private void update() {
        float fMin = Math.min((AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) / this.mDuration, 1.0f);
        float interpolation = this.mInterpolator.getInterpolation(fMin);
        float f = this.mGlowAlphaStart;
        this.mGlowAlpha = AbstractC0000a.m29z(this.mGlowAlphaFinish, f, interpolation, f);
        float f4 = this.mGlowScaleYStart;
        this.mGlowScaleY = AbstractC0000a.m29z(this.mGlowScaleYFinish, f4, interpolation, f4);
        this.mDisplacement = (this.mDisplacement + this.mTargetDisplacement) / 2.0f;
        if (fMin >= 0.999f || this.mState == 1) {
            switch (this.mState) {
                case 1:
                    this.mState = 5;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 250.0f;
                    this.mGlowAlphaStart = 0.0f;
                    this.mGlowScaleYStart = 0.0f;
                    this.mGlowAlphaFinish = sMaxAlpha;
                    this.mGlowScaleYFinish = this.MAX_SCALE;
                    this.mGlowScaleY = 0.0f;
                    this.mOnReleaseCalled = false;
                    break;
                case 2:
                    this.mState = 6;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 0.0f;
                    float f5 = sMaxAlpha;
                    this.mGlowAlphaStart = f5;
                    this.mGlowAlphaFinish = f5;
                    float f6 = this.MAX_SCALE;
                    this.mGlowScaleYStart = f6;
                    this.mGlowScaleYFinish = f6;
                    break;
                case 3:
                    this.mState = 0;
                    break;
                case 4:
                    this.mState = 3;
                    break;
                case 5:
                    this.mState = 6;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 0.0f;
                    float f7 = sMaxAlpha;
                    this.mGlowAlphaStart = f7;
                    this.mGlowAlphaFinish = f7;
                    float f8 = this.MAX_SCALE;
                    this.mGlowScaleYStart = f8;
                    this.mGlowScaleYFinish = f8;
                    break;
                case 6:
                    this.mState = 3;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 450.0f;
                    this.mGlowAlphaStart = this.mGlowAlpha;
                    this.mGlowScaleYStart = this.mGlowScaleY;
                    this.mGlowAlphaFinish = 0.0f;
                    this.mGlowScaleYFinish = 0.0f;
                    break;
            }
        }
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas canvas) {
        boolean z;
        update();
        int iSave = canvas.save();
        float fCenterX = this.mBounds.centerX();
        canvas.scale(1.0f, Math.min(this.mGlowScaleY, 1.0f), fCenterX, 0.0f);
        Math.max(0.0f, Math.min(this.mDisplacement, 1.0f));
        float f = this.mEdgeControlPointHeight;
        float fWidth = this.mBounds.width() * 0.2f;
        this.mPath.reset();
        this.mPath.moveTo(this.mEdgeEffectMargin, 0.0f);
        this.mPath.lineTo(this.mEdgeEffectMargin, 0.0f);
        this.mPath.cubicTo(fCenterX - fWidth, f, fCenterX + fWidth, f, this.mBounds.width() - this.mEdgeEffectMargin, 0.0f);
        this.mPath.lineTo(this.mBounds.width() - this.mEdgeEffectMargin, 0.0f);
        this.mPath.close();
        this.mPaint.setAlpha((int) (this.mGlowAlpha * 255.0f));
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restoreToCount(iSave);
        if (this.mState == 3 && this.mGlowScaleY == 0.0f) {
            this.mState = 0;
            z = true;
        } else {
            z = false;
        }
        return this.mState != 0 || z;
    }

    @Override // android.widget.EdgeEffect
    public void finish() {
        this.mState = 0;
    }

    @Override // android.widget.EdgeEffect
    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    @Override // android.widget.EdgeEffect
    public int getMaxHeight() {
        return (int) ((this.mBounds.height() * 2.0f) + 0.5f);
    }

    @Override // android.widget.EdgeEffect
    public boolean isFinished() {
        return this.mState == 0;
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int i) {
        if (isEdgeEffectRunning()) {
            return;
        }
        View view = this.mHostView;
        if (view != null) {
            view.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(28));
        }
        this.mOnReleaseCalled = true;
        this.mState = 2;
        Math.min(Math.max(100, Math.abs(i)), 10000);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = 250.0f;
        this.mGlowAlphaStart = 0.0f;
        this.mGlowScaleYStart = 0.0f;
        this.mGlowScaleYFinish = this.MAX_SCALE;
        this.mGlowAlphaFinish = sMaxAlpha;
        this.mTargetDisplacement = 0.5f;
        this.mHandler.sendEmptyMessageDelayed(1, 700L);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f) {
        onPull(f, 0.5f);
    }

    public void onPullCallOnRelease(float f, float f4, int i) {
        this.mTempDeltaDistance = f;
        this.mTempDisplacement = f4;
        if (i != 0) {
            this.mHandler.postDelayed(this.mForceCallOnRelease, i);
            return;
        }
        this.mOnReleaseCalled = true;
        onPull(f, f4);
        this.mHandler.sendEmptyMessageDelayed(1, 700L);
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.mPullDistance = 0.0f;
        this.mOnReleaseCalled = true;
        int i = this.mState;
        if (i == 1 || i == 4) {
            this.mState = 3;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 450.0f;
        }
    }

    @Override // android.widget.EdgeEffect
    public void setColor(@ColorInt int i) {
        this.mPaint.setColor(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setHostView(View view, boolean z) {
        this.mHostView = view;
        this.mCanVerticalScroll = z;
    }

    @Override // android.widget.EdgeEffect
    public void setSize(int i, int i2) {
        float f = i;
        float f4 = (0.75f * f) / SIN;
        float f5 = f4 - (COS * f4);
        float f6 = i2;
        if (f <= this.mTabHeight + this.mTabHeightBuffer) {
            this.mEdgePadding = dipToPixels(3.0f);
            this.mEdgeControlPointHeight = dipToPixels(EDGE_CONTROL_POINT_HEIGHT_WITH_TAB_IN_DIP);
        } else {
            this.mEdgePadding = dipToPixels(5.0f);
            this.mEdgeControlPointHeight = dipToPixels(EDGE_CONTROL_POINT_HEIGHT_WITHOUT_TAB_IN_DIP);
        }
        if (this.mCanVerticalScroll) {
            this.mEdgeEffectMargin = calculateEdgeEffectMargin(i);
        }
        Rect rect = this.mBounds;
        rect.set(rect.left, rect.top, i, (int) Math.min(f6, f5));
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f, float f4) {
        int iSemGetVibrationIndex;
        if (this.mPullDistance == 0.0f) {
            this.mOnReleaseCalled = false;
            if (isEdgeEffectRunning()) {
                this.mPullDistance += f;
            }
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mTargetDisplacement = f4;
        int i = this.mState;
        if (i != 4 || jCurrentAnimationTimeMillis - this.mStartTime >= this.mDuration) {
            if (i != 1) {
                this.mGlowScaleY = Math.max(0.0f, this.mGlowScaleY);
            }
            if (isEdgeEffectRunning()) {
                return;
            }
            if (this.mPullDistance == 0.0f || this.mOnReleaseCalled) {
                if (this.mHostView != null && (iSemGetVibrationIndex = SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(28)) != -1) {
                    this.mHostView.performHapticFeedback(iSemGetVibrationIndex);
                }
                this.mState = 1;
                this.mStartTime = jCurrentAnimationTimeMillis;
                this.mDuration = 167.0f;
                this.mPullDistance += f;
            }
        }
    }
}
