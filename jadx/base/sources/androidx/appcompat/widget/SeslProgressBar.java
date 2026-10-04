package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.IntProperty;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.InterpolatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.reflect.graphics.drawable.SeslStateListDrawableReflector;
import androidx.reflect.view.SeslViewReflector;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 24)
@RemoteViews.RemoteView
public class SeslProgressBar extends View {
    private static final int MAX_LEVEL = 10000;
    public static final int MODE_CIRCLE = 7;
    public static final int MODE_DUAL_COLOR = 2;
    public static final int MODE_EXPAND = 5;
    public static final int MODE_EXPAND_VERTICAL = 6;
    public static final int MODE_GRADIENT_CIRCLE = 10;
    public static final int MODE_GRADIENT_HORIZONTAL = 9;
    public static final int MODE_LEVEL_BAR = 8;
    public static final int MODE_SPLIT = 4;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected static final int MODE_STANDARD = 0;
    public static final int MODE_VERTICAL = 3;
    public static final int MODE_WARNING = 1;
    private static final int PROGRESS_ANIM_DURATION = 80;
    private static final DecelerateInterpolator PROGRESS_ANIM_INTERPOLATOR = new DecelerateInterpolator();
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private final FloatProperty<SeslProgressBar> VISUAL_PROGRESS;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mAggregatedIsVisible;
    private AlphaAnimation mAnimation;
    private boolean mAttached;
    private int mBehavior;

    @Nullable
    private Locale mCachedLocale;
    private CircleAnimationCallback mCircleAnimationCallback;
    private int[] mCircleGradientColors;
    private float[] mCircleGradientPositions;
    private int mCircleGradientStyle;
    private int mCirclePadding;
    private Drawable mCurrentDrawable;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected int mCurrentMode;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected float mDensity;
    private int mDuration;
    private boolean mHasAnimation;
    private boolean mInDrawing;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private Drawable mIndeterminateHorizontalLarge;
    private Drawable mIndeterminateHorizontalMedium;
    private Drawable mIndeterminateHorizontalSmall;
    private Drawable mIndeterminateHorizontalXlarge;
    private Drawable mIndeterminateHorizontalXsmall;
    private Interpolator mInterpolator;
    private boolean mIsGradient;
    private int mMax;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int mMaxHeight;
    private boolean mMaxInitialized;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int mMaxWidth;
    private int mMin;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int mMinHeight;
    private boolean mMinInitialized;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int mMinWidth;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean mMirrorForRtl;
    private boolean mNoInvalidate;
    private boolean mOnlyIndeterminate;

    @Nullable
    private NumberFormat mPercentFormat;
    private int mProgress;
    private Drawable mProgressDrawable;
    private ProgressTintInfo mProgressTintInfo;
    private final ArrayList<RefreshData> mRefreshData;
    private boolean mRefreshIsPosted;
    private RefreshProgressRunnable mRefreshProgressRunnable;
    private int mRoundStrokeWidth;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int mSampleWidth;
    private int mSecondaryProgress;
    private boolean mShouldStartAnimationDrawable;
    private Transformation mTransformation;
    private long mUiThreadId;
    private boolean mUseCustomWidthForCircleMode;
    private boolean mUseHorizontalProgress;
    private float mVisualProgress;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SeslProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CirCleProgressDrawable extends Drawable {
        private final IntProperty<CirCleProgressDrawable> VISUAL_CIRCLE_PROGRESS;
        int mAlpha;
        private RectF mArcRect;

        @ColorInt
        int mColor;
        ColorStateList mColorStateList;
        private SweepGradient mGradientShader;
        private boolean mIsBackground;
        private final Paint mPaint;
        public int mProgress;
        private final ProgressState mState;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class ProgressState extends Drawable.ConstantState {
            private ProgressState() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            @NonNull
            public Drawable newDrawable() {
                return CirCleProgressDrawable.this;
            }
        }

        public CirCleProgressDrawable(boolean z, ColorStateList colorStateList) {
            Paint paint = new Paint();
            this.mPaint = paint;
            this.mAlpha = 255;
            this.mArcRect = new RectF();
            this.mState = new ProgressState();
            this.VISUAL_CIRCLE_PROGRESS = new IntProperty<CirCleProgressDrawable>("visual_progress") { // from class: androidx.appcompat.widget.SeslProgressBar.CirCleProgressDrawable.1
                @Override // android.util.Property
                public Integer get(CirCleProgressDrawable cirCleProgressDrawable) {
                    return Integer.valueOf(cirCleProgressDrawable.mProgress);
                }

                @Override // android.util.IntProperty
                public void setValue(CirCleProgressDrawable cirCleProgressDrawable, int i) {
                    cirCleProgressDrawable.mProgress = i;
                    CirCleProgressDrawable.this.invalidateSelf();
                }
            };
            this.mIsBackground = z;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            this.mColorStateList = colorStateList;
            int defaultColor = colorStateList.getDefaultColor();
            this.mColor = defaultColor;
            paint.setColor(defaultColor);
            this.mProgress = 0;
        }

        private int modulateAlpha(int i, int i2) {
            return ((i2 + (i2 >>> 7)) * i) >>> 8;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.mPaint.setStrokeWidth(SeslProgressBar.this.mRoundStrokeWidth);
            int alpha = this.mPaint.getAlpha();
            this.mPaint.setAlpha(modulateAlpha(alpha, this.mAlpha));
            this.mPaint.setAntiAlias(true);
            this.mArcRect.set((SeslProgressBar.this.mRoundStrokeWidth / 2.0f) + SeslProgressBar.this.mCirclePadding, (SeslProgressBar.this.mRoundStrokeWidth / 2.0f) + SeslProgressBar.this.mCirclePadding, (SeslProgressBar.this.getWidth() - (SeslProgressBar.this.mRoundStrokeWidth / 2.0f)) - SeslProgressBar.this.mCirclePadding, (SeslProgressBar.this.getWidth() - (SeslProgressBar.this.mRoundStrokeWidth / 2.0f)) - SeslProgressBar.this.mCirclePadding);
            if (SeslProgressBar.this.mIsGradient && !this.mIsBackground) {
                if (this.mGradientShader == null) {
                    float fCenterX = this.mArcRect.centerX();
                    float fCenterY = this.mArcRect.centerY();
                    this.mGradientShader = new SweepGradient(fCenterX, fCenterY, SeslProgressBar.this.mCircleGradientColors, SeslProgressBar.this.mCircleGradientPositions);
                    Matrix matrix = new Matrix();
                    matrix.preRotate(-90.0f, fCenterX, fCenterY);
                    this.mGradientShader.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.mGradientShader);
            } else if (SeslProgressBar.this.mIsGradient) {
                this.mPaint.setShader(null);
            }
            int i = SeslProgressBar.this.mMax - SeslProgressBar.this.mMin;
            float f = i > 0 ? (this.mProgress - SeslProgressBar.this.mMin) / i : 0.0f;
            canvas.save();
            if (this.mIsBackground) {
                canvas.drawArc(this.mArcRect, 270.0f, 360.0f, false, this.mPaint);
            } else {
                canvas.drawArc(this.mArcRect, 270.0f, f * 360.0f, false, this.mPaint);
            }
            canvas.restore();
            this.mPaint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        @Nullable
        public Drawable.ConstantState getConstantState() {
            return this.mState;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            Paint paint = this.mPaint;
            if (paint.getXfermode() != null) {
                return -3;
            }
            int alpha = paint.getAlpha();
            if (alpha == 0) {
                return -2;
            }
            return alpha == 255 ? -1 : -3;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean onStateChange(int[] iArr) {
            boolean zOnStateChange = super.onStateChange(iArr);
            int colorForState = this.mColorStateList.getColorForState(iArr, this.mColor);
            if (this.mColor != colorForState) {
                this.mColor = colorForState;
                this.mPaint.setColor(colorForState);
                invalidateSelf();
            }
            return zOnStateChange;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mAlpha = i;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setProgress(int i, boolean z) {
            if (!z) {
                this.mProgress = i;
                SeslProgressBar.this.invalidate();
                return;
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, this.VISUAL_CIRCLE_PROGRESS, i);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(80L);
            objectAnimatorOfInt.setInterpolator(SeslProgressBar.PROGRESS_ANIM_INTERPOLATOR);
            objectAnimatorOfInt.start();
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(@Nullable ColorStateList colorStateList) {
            super.setTintList(colorStateList);
            if (colorStateList != null) {
                this.mColorStateList = colorStateList;
                int defaultColor = colorStateList.getDefaultColor();
                this.mColor = defaultColor;
                this.mPaint.setColor(defaultColor);
                invalidateSelf();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CircleAnimationCallback extends Animatable2.AnimationCallback {
        final Handler mHandler = new Handler(Looper.getMainLooper());
        private WeakReference<SeslProgressBar> mProgressBar;

        public CircleAnimationCallback(SeslProgressBar seslProgressBar) {
            this.mProgressBar = new WeakReference<>(seslProgressBar);
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            this.mHandler.post(new Runnable() { // from class: androidx.appcompat.widget.SeslProgressBar.CircleAnimationCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    SeslProgressBar seslProgressBar = (SeslProgressBar) CircleAnimationCallback.this.mProgressBar.get();
                    if (seslProgressBar == null) {
                        return;
                    }
                    ((AnimatedVectorDrawable) seslProgressBar.mIndeterminateDrawable).start();
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProgressTintInfo {
        boolean mHasIndeterminateTint;
        boolean mHasIndeterminateTintMode;
        boolean mHasProgressBackgroundTint;
        boolean mHasProgressBackgroundTintMode;
        boolean mHasProgressTint;
        boolean mHasProgressTintMode;
        boolean mHasSecondaryProgressTint;
        boolean mHasSecondaryProgressTintMode;
        ColorStateList mIndeterminateTintList;
        PorterDuff.Mode mIndeterminateTintMode;
        ColorStateList mProgressBackgroundTintList;
        PorterDuff.Mode mProgressBackgroundTintMode;
        ColorStateList mProgressTintList;
        PorterDuff.Mode mProgressTintMode;
        ColorStateList mSecondaryProgressTintList;
        PorterDuff.Mode mSecondaryProgressTintMode;

        private ProgressTintInfo() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RefreshData {
        private static final int POOL_MAX = 24;
        private static final Pools.SynchronizedPool<RefreshData> sPool = new Pools.SynchronizedPool<>(24);
        public boolean animate;
        public boolean fromUser;

        /* JADX INFO: renamed from: id */
        public int f945id;
        public int progress;

        private RefreshData() {
        }

        public static RefreshData obtain(int i, int i2, boolean z, boolean z2) {
            RefreshData refreshDataAcquire = sPool.acquire();
            if (refreshDataAcquire == null) {
                refreshDataAcquire = new RefreshData();
            }
            refreshDataAcquire.f945id = i;
            refreshDataAcquire.progress = i2;
            refreshDataAcquire.fromUser = z;
            refreshDataAcquire.animate = z2;
            return refreshDataAcquire;
        }

        public void recycle() {
            sPool.release(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RefreshProgressRunnable implements Runnable {
        private RefreshProgressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (SeslProgressBar.this) {
                try {
                    int size = SeslProgressBar.this.mRefreshData.size();
                    for (int i = 0; i < size; i++) {
                        RefreshData refreshData = (RefreshData) SeslProgressBar.this.mRefreshData.get(i);
                        SeslProgressBar.this.doRefreshProgress(refreshData.f945id, refreshData.progress, refreshData.fromUser, true, refreshData.animate);
                        refreshData.recycle();
                    }
                    SeslProgressBar.this.mRefreshData.clear();
                    SeslProgressBar.this.mRefreshIsPosted = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.SeslProgressBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;
        int secondaryProgress;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.secondaryProgress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            this.secondaryProgress = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface SeekBarMode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StateListDrawableCompat {
        private static final boolean IS_BASE_SDK_VERSION = false;

        private StateListDrawableCompat() {
        }

        public static int getStateCount(StateListDrawable stateListDrawable) {
            if (!IS_BASE_SDK_VERSION) {
                return 0;
            }
            SeslStateListDrawableReflector.getStateCount(stateListDrawable);
            return 0;
        }

        @Nullable
        public static Drawable getStateDrawable(StateListDrawable stateListDrawable, int i) {
            if (IS_BASE_SDK_VERSION) {
                return SeslStateListDrawableReflector.getStateDrawable(stateListDrawable, i);
            }
            return null;
        }

        @Nullable
        public static int[] getStateSet(StateListDrawable stateListDrawable, int i) {
            if (IS_BASE_SDK_VERSION) {
                return SeslStateListDrawableReflector.getStateSet(stateListDrawable, i);
            }
            return null;
        }
    }

    public SeslProgressBar(Context context) {
        this(context, null);
    }

    private void applyIndeterminateTint() {
        ProgressTintInfo progressTintInfo;
        Drawable drawable = this.mIndeterminateDrawable;
        if (drawable == null || (progressTintInfo = this.mProgressTintInfo) == null) {
            return;
        }
        if (progressTintInfo.mHasIndeterminateTint || progressTintInfo.mHasIndeterminateTintMode) {
            Drawable drawableMutate = drawable.mutate();
            this.mIndeterminateDrawable = drawableMutate;
            if (progressTintInfo.mHasIndeterminateTint) {
                DrawableCompat.setTintList(drawableMutate, progressTintInfo.mIndeterminateTintList);
            }
            if (progressTintInfo.mHasIndeterminateTintMode) {
                DrawableCompat.setTintMode(this.mIndeterminateDrawable, progressTintInfo.mIndeterminateTintMode);
            }
            if (this.mIndeterminateDrawable.isStateful()) {
                this.mIndeterminateDrawable.setState(getDrawableState());
            }
        }
    }

    private void applyPrimaryProgressTint() {
        Drawable tintTarget;
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if ((progressTintInfo.mHasProgressTint || progressTintInfo.mHasProgressTintMode) && (tintTarget = getTintTarget(R.id.progress, true)) != null) {
            ProgressTintInfo progressTintInfo2 = this.mProgressTintInfo;
            if (progressTintInfo2.mHasProgressTint) {
                DrawableCompat.setTintList(tintTarget, progressTintInfo2.mProgressTintList);
            }
            ProgressTintInfo progressTintInfo3 = this.mProgressTintInfo;
            if (progressTintInfo3.mHasProgressTintMode) {
                DrawableCompat.setTintMode(tintTarget, progressTintInfo3.mProgressTintMode);
            }
            if (tintTarget.isStateful()) {
                tintTarget.setState(getDrawableState());
            }
        }
    }

    private void applyProgressBackgroundTint() {
        Drawable tintTarget;
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if ((progressTintInfo.mHasProgressBackgroundTint || progressTintInfo.mHasProgressBackgroundTintMode) && (tintTarget = getTintTarget(R.id.background, false)) != null) {
            ProgressTintInfo progressTintInfo2 = this.mProgressTintInfo;
            if (progressTintInfo2.mHasProgressBackgroundTint) {
                DrawableCompat.setTintList(tintTarget, progressTintInfo2.mProgressBackgroundTintList);
            }
            ProgressTintInfo progressTintInfo3 = this.mProgressTintInfo;
            if (progressTintInfo3.mHasProgressBackgroundTintMode) {
                DrawableCompat.setTintMode(tintTarget, progressTintInfo3.mProgressBackgroundTintMode);
            }
            if (tintTarget.isStateful()) {
                tintTarget.setState(getDrawableState());
            }
        }
    }

    private void applyProgressTints() {
        if (this.mProgressDrawable == null || this.mProgressTintInfo == null) {
            return;
        }
        applyPrimaryProgressTint();
        applyProgressBackgroundTint();
        applySecondaryProgressTint();
    }

    private void applySecondaryProgressTint() {
        Drawable tintTarget;
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if ((progressTintInfo.mHasSecondaryProgressTint || progressTintInfo.mHasSecondaryProgressTintMode) && (tintTarget = getTintTarget(R.id.secondaryProgress, false)) != null) {
            ProgressTintInfo progressTintInfo2 = this.mProgressTintInfo;
            if (progressTintInfo2.mHasSecondaryProgressTint) {
                DrawableCompat.setTintList(tintTarget, progressTintInfo2.mSecondaryProgressTintList);
            }
            ProgressTintInfo progressTintInfo3 = this.mProgressTintInfo;
            if (progressTintInfo3.mHasSecondaryProgressTintMode) {
                DrawableCompat.setTintMode(tintTarget, progressTintInfo3.mSecondaryProgressTintMode);
            }
            if (tintTarget.isStateful()) {
                tintTarget.setState(getDrawableState());
            }
        }
    }

    private ColorStateList colorToColorStateList(int i) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{i});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doRefreshProgress(int i, int i2, boolean z, boolean z2, boolean z3) {
        Drawable drawableFindDrawableByLayerId;
        try {
            int i4 = this.mMax;
            int i5 = this.mMin;
            int i6 = i4 - i5;
            float f = i6 > 0 ? (i2 - i5) / i6 : 0.0f;
            float f4 = i6 > 0 ? (this.mVisualProgress - i5) / i6 : 0.0f;
            boolean z4 = i == 16908301;
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                int i7 = (int) (10000.0f * f);
                if (drawable instanceof LayerDrawable) {
                    Drawable drawableFindDrawableByLayerId2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
                    if (drawableFindDrawableByLayerId2 != null && canResolveLayoutDirection()) {
                        DrawableCompat.setLayoutDirection(drawableFindDrawableByLayerId2, ViewCompat.getLayoutDirection(this));
                    }
                    if (drawableFindDrawableByLayerId2 != null) {
                        drawable = drawableFindDrawableByLayerId2;
                    }
                    drawable.setLevel(i7);
                } else if (drawable instanceof StateListDrawable) {
                    int stateCount = StateListDrawableCompat.getStateCount((StateListDrawable) drawable);
                    for (int i8 = 0; i8 < stateCount; i8++) {
                        Drawable stateDrawable = StateListDrawableCompat.getStateDrawable((StateListDrawable) drawable, i8);
                        if (stateDrawable == null) {
                            return;
                        }
                        if (stateDrawable instanceof LayerDrawable) {
                            drawableFindDrawableByLayerId = ((LayerDrawable) stateDrawable).findDrawableByLayerId(i);
                            if (drawableFindDrawableByLayerId != null && canResolveLayoutDirection()) {
                                DrawableCompat.setLayoutDirection(drawableFindDrawableByLayerId, ViewCompat.getLayoutDirection(this));
                            }
                        } else {
                            drawableFindDrawableByLayerId = null;
                        }
                        if (drawableFindDrawableByLayerId == null) {
                            drawableFindDrawableByLayerId = drawable;
                        }
                        drawableFindDrawableByLayerId.setLevel(i7);
                    }
                } else {
                    drawable.setLevel(i7);
                }
            } else {
                invalidate();
            }
            if (z4 && z3) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.VISUAL_PROGRESS, f4, f);
                objectAnimatorOfFloat.setAutoCancel(true);
                objectAnimatorOfFloat.setDuration(80L);
                objectAnimatorOfFloat.setInterpolator(PROGRESS_ANIM_INTERPOLATOR);
                objectAnimatorOfFloat.start();
            } else {
                setVisualProgress(i, f);
            }
            if (z4 && z2) {
                onProgressRefresh(f, z, i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private CharSequence formatStateDescription(int i) {
        Locale locale = getResources().getConfiguration().locale;
        if (!locale.equals(this.mCachedLocale) || this.mPercentFormat == null) {
            this.mCachedLocale = locale;
            this.mPercentFormat = NumberFormat.getPercentInstance(locale);
        }
        return this.mPercentFormat.format(getPercent(i));
    }

    private float getPercent(int i) {
        float max = getMax();
        float min = getMin();
        float f = max - min;
        if (f <= 0.0f) {
            return 0.0f;
        }
        return MathUtils.clamp((i - min) / f, 0.0f, 1.0f);
    }

    private static String getStringById(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", TelemetryEventStrings.C6439Os.OS_NAME);
        if (identifier <= 0) {
            return "";
        }
        try {
            return context.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Nullable
    private Drawable getTintTarget(int i, boolean z) {
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            this.mProgressDrawable = drawable.mutate();
            drawableFindDrawableByLayerId = drawable instanceof LayerDrawable ? ((LayerDrawable) drawable).findDrawableByLayerId(i) : null;
            if (z && drawableFindDrawableByLayerId == null) {
                return drawable;
            }
        }
        return drawableFindDrawableByLayerId;
    }

    private void initCirCleStrokeWidth(int i) {
        if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_size_small) == i) {
            this.mRoundStrokeWidth = getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_circle_size_small_width);
            this.mCirclePadding = getResources().getDimensionPixelOffset(C0419R.dimen.sesl_progress_circle_size_small_padding);
            return;
        }
        if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_size_small_title) == i) {
            this.mRoundStrokeWidth = getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_circle_size_small_title_width);
            this.mCirclePadding = getResources().getDimensionPixelOffset(C0419R.dimen.sesl_progress_circle_size_small_title_padding);
        } else if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_size_large) == i) {
            this.mRoundStrokeWidth = getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_circle_size_large_width);
            this.mCirclePadding = getResources().getDimensionPixelOffset(C0419R.dimen.sesl_progress_circle_size_large_padding);
        } else if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_size_xlarge) == i) {
            this.mRoundStrokeWidth = getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_circle_size_xlarge_width);
            this.mCirclePadding = getResources().getDimensionPixelOffset(C0419R.dimen.sesl_progress_circle_size_xlarge_padding);
        } else {
            this.mRoundStrokeWidth = (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_circle_size_small_width) * i) / getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_size_small);
            this.mCirclePadding = (getResources().getDimensionPixelOffset(C0419R.dimen.sesl_progress_circle_size_small_padding) * i) / getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_size_small);
        }
    }

    private void initProgressBar() {
        this.mMin = 0;
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mIndeterminate = false;
        this.mOnlyIndeterminate = false;
        this.mDuration = 4000;
        this.mBehavior = 1;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }

    private void initializeGradientHorizontalMode() {
        this.mOnlyIndeterminate = false;
        setIndeterminate(false);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new GradientHorizontalProgressDrawable(true, getResources().getColor(C0419R.color.sesl_progress_control_color_background)), new GradientHorizontalProgressDrawable(false, new int[]{-13075713, -12727161, -13075713, -12727161}, new float[]{0.0f, 0.19f, 0.37f, 1.0f})});
        layerDrawable.setPaddingMode(1);
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        setProgressDrawable(layerDrawable);
    }

    private void initializeRoundCircleMode() {
        this.mOnlyIndeterminate = false;
        setIndeterminate(false);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new CirCleProgressDrawable(true, colorToColorStateList(getResources().getColor(C0419R.color.sesl_progress_control_color_background))), new CirCleProgressDrawable(false, colorToColorStateList(getResources().getColor(C0419R.color.sesl_progress_control_color_activated_light)))});
        layerDrawable.setPaddingMode(1);
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        setProgressDrawable(layerDrawable);
    }

    private static boolean needsTileify(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                if (needsTileify(layerDrawable.getDrawable(i))) {
                    return true;
                }
            }
            return false;
        }
        if (!(drawable instanceof StateListDrawable)) {
            return drawable instanceof BitmapDrawable;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        int stateCount = StateListDrawableCompat.getStateCount(stateListDrawable);
        for (int i2 = 0; i2 < stateCount; i2++) {
            Drawable stateDrawable = StateListDrawableCompat.getStateDrawable(stateListDrawable, i2);
            if (stateDrawable != null && needsTileify(stateDrawable)) {
                return true;
            }
        }
        return false;
    }

    private synchronized void refreshProgress(int i, int i2, boolean z, boolean z2) throws Throwable {
        try {
            try {
                if (this.mUiThreadId == Thread.currentThread().getId()) {
                    doRefreshProgress(i, i2, z, true, z2);
                } else {
                    if (this.mRefreshProgressRunnable == null) {
                        this.mRefreshProgressRunnable = new RefreshProgressRunnable();
                    }
                    this.mRefreshData.add(RefreshData.obtain(i, i2, z, z2));
                    if (this.mAttached && !this.mRefreshIsPosted) {
                        post(this.mRefreshProgressRunnable);
                        this.mRefreshIsPosted = true;
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void scheduleAccessibilityEventSender() {
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        postDelayed(this.mAccessibilityEventSender, 200L);
    }

    private void seslSetIndeterminateProgressDrawable(int i) {
        if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_indeterminate_xsmall) >= i) {
            setIndeterminateDrawable(this.mIndeterminateHorizontalXsmall);
            return;
        }
        if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_indeterminate_small) >= i) {
            setIndeterminateDrawable(this.mIndeterminateHorizontalSmall);
            return;
        }
        if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_indeterminate_medium) >= i) {
            setIndeterminateDrawable(this.mIndeterminateHorizontalMedium);
        } else if (getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_indeterminate_large) >= i) {
            setIndeterminateDrawable(this.mIndeterminateHorizontalLarge);
        } else {
            setIndeterminateDrawable(this.mIndeterminateHorizontalXlarge);
        }
    }

    private void setGradientColorsForCircle() {
        if (this.mCircleGradientStyle == 0) {
            this.mCircleGradientColors = new int[]{-432227934, -432157561, -432506113, -1724144701, -1724003193, -1724351745, -432227934};
        } else {
            this.mCircleGradientColors = new int[]{-855835393, 1727855871, -855835393, 872217855, 1727855871, 1727855871, -855835393};
        }
        this.mCircleGradientPositions = new float[]{0.0f, 0.12222222f, 0.20555556f, 0.47777778f, 0.5888889f, 0.69722223f, 0.8277778f};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisualProgress(int i, float f) {
        this.mVisualProgress = f;
        Drawable drawableFindDrawableByLayerId = this.mCurrentDrawable;
        if ((drawableFindDrawableByLayerId instanceof LayerDrawable) && (drawableFindDrawableByLayerId = ((LayerDrawable) drawableFindDrawableByLayerId).findDrawableByLayerId(i)) == null) {
            drawableFindDrawableByLayerId = this.mCurrentDrawable;
        }
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setLevel((int) (10000.0f * f));
        } else {
            invalidate();
        }
        onVisualProgressChanged(i, f);
    }

    private void startAnimation() {
        if (getVisibility() == 0) {
            Drawable drawable = this.mIndeterminateDrawable;
            if (drawable instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
                this.mHasAnimation = false;
                if (drawable instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) drawable).registerAnimationCallback(this.mCircleAnimationCallback);
                }
            } else {
                this.mHasAnimation = true;
                if (this.mInterpolator == null) {
                    this.mInterpolator = new LinearInterpolator();
                }
                Transformation transformation = this.mTransformation;
                if (transformation == null) {
                    this.mTransformation = new Transformation();
                } else {
                    transformation.clear();
                }
                AlphaAnimation alphaAnimation = this.mAnimation;
                if (alphaAnimation == null) {
                    this.mAnimation = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    alphaAnimation.reset();
                }
                this.mAnimation.setRepeatMode(this.mBehavior);
                this.mAnimation.setRepeatCount(-1);
                this.mAnimation.setDuration(this.mDuration);
                this.mAnimation.setInterpolator(this.mInterpolator);
                this.mAnimation.setStartTime(-1L);
            }
            postInvalidate();
        }
    }

    private void stopAnimation() {
        this.mHasAnimation = false;
        Object obj = this.mIndeterminateDrawable;
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
            Drawable drawable = this.mIndeterminateDrawable;
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).unregisterAnimationCallback(this.mCircleAnimationCallback);
            }
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    private void swapCurrentDrawable(Drawable drawable) {
        Drawable drawable2 = this.mCurrentDrawable;
        this.mCurrentDrawable = drawable;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setVisible(false, false);
            }
            Drawable drawable3 = this.mCurrentDrawable;
            if (drawable3 != null) {
                drawable3.setVisible(getWindowVisibility() == 0 && isShown(), false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable] */
    private Drawable tileify(Drawable drawable, boolean z) {
        int i = 0;
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof StateListDrawable)) {
                if (drawable instanceof BitmapDrawable) {
                    drawable = (BitmapDrawable) drawable.getConstantState().newDrawable(getResources());
                    drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                    if (this.mSampleWidth <= 0) {
                        this.mSampleWidth = drawable.getIntrinsicWidth();
                    }
                    if (z) {
                        return new ClipDrawable(drawable, 3, 1);
                    }
                }
                return drawable;
            }
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            int stateCount = StateListDrawableCompat.getStateCount(stateListDrawable);
            while (i < stateCount) {
                int[] stateSet = StateListDrawableCompat.getStateSet(stateListDrawable, i);
                Drawable stateDrawable = StateListDrawableCompat.getStateDrawable(stateListDrawable, i);
                if (stateDrawable != null) {
                    stateListDrawable2.addState(stateSet, tileify(stateDrawable, z));
                }
                i++;
            }
            return stateListDrawable2;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            int id = layerDrawable.getId(i2);
            drawableArr[i2] = tileify(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        while (i < numberOfLayers) {
            layerDrawable2.setId(i, layerDrawable.getId(i));
            layerDrawable2.setLayerGravity(i, layerDrawable.getLayerGravity(i));
            layerDrawable2.setLayerWidth(i, layerDrawable.getLayerWidth(i));
            layerDrawable2.setLayerHeight(i, layerDrawable.getLayerHeight(i));
            layerDrawable2.setLayerInsetLeft(i, layerDrawable.getLayerInsetLeft(i));
            layerDrawable2.setLayerInsetRight(i, layerDrawable.getLayerInsetRight(i));
            layerDrawable2.setLayerInsetTop(i, layerDrawable.getLayerInsetTop(i));
            layerDrawable2.setLayerInsetBottom(i, layerDrawable.getLayerInsetBottom(i));
            layerDrawable2.setLayerInsetStart(i, layerDrawable.getLayerInsetStart(i));
            layerDrawable2.setLayerInsetEnd(i, layerDrawable.getLayerInsetEnd(i));
            i++;
        }
        return layerDrawable2;
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableTileify = tileify(animationDrawable.getFrame(i), true);
            drawableTileify.setLevel(10000);
            animationDrawable2.addFrame(drawableTileify, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private void updateDrawableState() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mProgressDrawable;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drawTrack(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != 0) {
            int iSave = canvas.save();
            if (this.mCurrentMode != 3 && this.mMirrorForRtl && ViewUtils.isLayoutRtl(this)) {
                canvas.translate(getWidth() - getPaddingRight(), getPaddingTop());
                canvas.scale(-1.0f, 1.0f);
            } else {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            long drawingTime = getDrawingTime();
            if (this.mHasAnimation) {
                this.mAnimation.getTransformation(drawingTime, this.mTransformation);
                float alpha = this.mTransformation.getAlpha();
                try {
                    this.mInDrawing = true;
                    drawable.setLevel((int) (alpha * 10000.0f));
                    this.mInDrawing = false;
                    ViewCompat.postInvalidateOnAnimation(this);
                } catch (Throwable th) {
                    this.mInDrawing = false;
                    throw th;
                }
            }
            drawable.draw(canvas);
            canvas.restoreToCount(iSave);
            if (this.mShouldStartAnimationDrawable && (drawable instanceof Animatable)) {
                ((Animatable) drawable).start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f4) {
        super.drawableHotspotChanged(f, f4);
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f4);
        }
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f, f4);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return this.mCurrentDrawable;
    }

    public Drawable getIndeterminateDrawable() {
        return this.mIndeterminateDrawable;
    }

    @Nullable
    public ColorStateList getIndeterminateTintList() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mIndeterminateTintList;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getIndeterminateTintMode() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mIndeterminateTintMode;
        }
        return null;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        return this.mMax;
    }

    @Px
    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMin() {
        return this.mMin;
    }

    @Px
    public int getMinHeight() {
        return this.mMinHeight;
    }

    @Px
    public int getMinWidth() {
        return this.mMinWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean getMirrorForRtl() {
        return this.mMirrorForRtl;
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return SeslViewReflector.getField_mPaddingLeft(this);
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return SeslViewReflector.getField_mPaddingRight(this);
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        return this.mIndeterminate ? 0 : this.mProgress;
    }

    @Nullable
    public ColorStateList getProgressBackgroundTintList() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mProgressBackgroundTintList;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getProgressBackgroundTintMode() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mProgressBackgroundTintMode;
        }
        return null;
    }

    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }

    @Nullable
    public ColorStateList getProgressTintList() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mProgressTintList;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getProgressTintMode() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mProgressTintMode;
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        return this.mIndeterminate ? 0 : this.mSecondaryProgress;
    }

    @Nullable
    public ColorStateList getSecondaryProgressTintList() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mSecondaryProgressTintList;
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSecondaryProgressTintMode() {
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo != null) {
            return progressTintInfo.mSecondaryProgressTintMode;
        }
        return null;
    }

    public final synchronized void incrementProgressBy(int i) {
        setProgress(this.mProgress + i);
    }

    public final synchronized void incrementSecondaryProgressBy(int i) {
        setSecondaryProgress(this.mSecondaryProgress + i);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (this.mInDrawing) {
            return;
        }
        if (!verifyDrawable(drawable)) {
            super.invalidateDrawable(drawable);
            return;
        }
        Rect bounds = drawable.getBounds();
        int paddingLeft = getPaddingLeft() + getScrollX();
        int paddingTop = getPaddingTop() + getScrollY();
        invalidate(bounds.left + paddingLeft, bounds.top + paddingTop, bounds.right + paddingLeft, bounds.bottom + paddingTop);
    }

    public boolean isAnimating() {
        return isIndeterminate() && getWindowVisibility() == 0 && isShown();
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized boolean isIndeterminate() {
        return this.mIndeterminate;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws Throwable {
        super.onAttachedToWindow();
        if (this.mIndeterminate) {
            startAnimation();
        }
        synchronized (this) {
            try {
                int size = this.mRefreshData.size();
                for (int i = 0; i < size; i++) {
                    RefreshData refreshData = this.mRefreshData.get(i);
                    try {
                        doRefreshProgress(refreshData.f945id, refreshData.progress, refreshData.fromUser, true, refreshData.animate);
                        refreshData.recycle();
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                this.mRefreshData.clear();
                this.mAttached = true;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (this.mIndeterminate) {
            stopAnimation();
        } else {
            this.mCircleAnimationCallback = null;
        }
        RefreshProgressRunnable refreshProgressRunnable = this.mRefreshProgressRunnable;
        if (refreshProgressRunnable != null) {
            removeCallbacks(refreshProgressRunnable);
            this.mRefreshIsPosted = false;
        }
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTrack(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(this.mMax - this.mMin);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int i = Build.VERSION.SDK_INT;
        if (!isIndeterminate()) {
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, getMin(), getMax(), getProgress()));
        }
        if (i < 30 || getStateDescription() != null) {
            return;
        }
        if (isIndeterminate()) {
            accessibilityNodeInfo.setStateDescription(getStringById(getContext(), "in_progress"));
        } else {
            accessibilityNodeInfo.setStateDescription(formatStateDescription(getProgress()));
        }
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i, int i2) {
        int iMax;
        int iMax2;
        try {
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                iMax2 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, drawable.getIntrinsicWidth()));
                iMax = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, drawable.getIntrinsicHeight()));
            } else {
                iMax = 0;
                iMax2 = 0;
            }
            updateDrawableState();
            int paddingLeft = getPaddingLeft() + getPaddingRight() + iMax2;
            int paddingTop = getPaddingTop() + getPaddingBottom() + iMax;
            int iResolveSizeAndState = View.resolveSizeAndState(paddingLeft, i, 0);
            int iResolveSizeAndState2 = View.resolveSizeAndState(paddingTop, i2, 0);
            if (!this.mUseCustomWidthForCircleMode) {
                initCirCleStrokeWidth((iResolveSizeAndState - getPaddingLeft()) - getPaddingRight());
            }
            if (this.mUseHorizontalProgress && this.mIndeterminate) {
                seslSetIndeterminateProgressDrawable((iResolveSizeAndState - getPaddingLeft()) - getPaddingRight());
            }
            setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onProgressRefresh(float f, boolean z, int i) throws Throwable {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            scheduleAccessibilityEventSender();
        }
        int i2 = this.mSecondaryProgress;
        if (i2 <= this.mProgress || z) {
            return;
        }
        refreshProgress(R.id.secondaryProgress, i2, false, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onResolveDrawables(int i) {
        Drawable drawable = this.mCurrentDrawable;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (drawable != null) {
            DrawableCompat.setLayoutDirection(drawable, layoutDirection);
        }
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setLayoutDirection(drawable2, layoutDirection);
        }
        Drawable drawable3 = this.mProgressDrawable;
        if (drawable3 != null) {
            DrawableCompat.setLayoutDirection(drawable3, layoutDirection);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
        setSecondaryProgress(savedState.secondaryProgress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        savedState.secondaryProgress = this.mSecondaryProgress;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        updateDrawableBounds(i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onSlidingRefresh(int i) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            Drawable drawableFindDrawableByLayerId = drawable instanceof LayerDrawable ? ((LayerDrawable) drawable).findDrawableByLayerId(R.id.progress) : null;
            if (drawableFindDrawableByLayerId != null) {
                drawableFindDrawableByLayerId.setLevel(i);
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z != this.mAggregatedIsVisible) {
            this.mAggregatedIsVisible = z;
            if (this.mIndeterminate) {
                if (z) {
                    startAnimation();
                } else {
                    stopAnimation();
                }
            }
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (this.mNoInvalidate) {
            return;
        }
        super.postInvalidate();
    }

    public synchronized void setIndeterminate(boolean z) {
        try {
            if (!this.mOnlyIndeterminate || !this.mIndeterminate) {
                if (z != this.mIndeterminate) {
                    this.mIndeterminate = z;
                    if (z) {
                        swapCurrentDrawable(this.mIndeterminateDrawable);
                        startAnimation();
                    } else {
                        swapCurrentDrawable(this.mProgressDrawable);
                        stopAnimation();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        Drawable drawable2 = this.mIndeterminateDrawable;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                if (this.mUseHorizontalProgress) {
                    stopAnimation();
                }
                this.mIndeterminateDrawable.setCallback(null);
                unscheduleDrawable(this.mIndeterminateDrawable);
            }
            this.mIndeterminateDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                applyIndeterminateTint();
            }
            if (this.mIndeterminate) {
                if (this.mUseHorizontalProgress) {
                    startAnimation();
                }
                swapCurrentDrawable(drawable);
                postInvalidate();
            }
        }
    }

    public void setIndeterminateDrawableTiled(Drawable drawable) {
        if (drawable != null) {
            drawable = tileifyIndeterminate(drawable);
        }
        setIndeterminateDrawable(drawable);
    }

    public void setIndeterminateTintList(@Nullable ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mIndeterminateTintList = colorStateList;
        progressTintInfo.mHasIndeterminateTint = true;
        applyIndeterminateTint();
    }

    public void setIndeterminateTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mIndeterminateTintMode = mode;
        progressTintInfo.mHasIndeterminateTintMode = true;
        applyIndeterminateTint();
    }

    public void setInterpolator(Context context, @InterpolatorRes int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public synchronized void setMax(int i) {
        int i2;
        try {
            boolean z = this.mMinInitialized;
            if (z && i < (i2 = this.mMin)) {
                i = i2;
            }
            this.mMaxInitialized = true;
            if (!z || i == this.mMax) {
                this.mMax = i;
            } else {
                this.mMax = i;
                postInvalidate();
                if (this.mProgress > i) {
                    this.mProgress = i;
                }
                refreshProgress(R.id.progress, this.mProgress, false, false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMaxHeight(@Px int i) {
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(@Px int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public synchronized void setMin(int i) {
        int i2;
        try {
            boolean z = this.mMaxInitialized;
            if (z && i > (i2 = this.mMax)) {
                i = i2;
            }
            this.mMinInitialized = true;
            if (!z || i == this.mMin) {
                this.mMin = i;
            } else {
                this.mMin = i;
                postInvalidate();
                if (this.mProgress < i) {
                    this.mProgress = i;
                }
                refreshProgress(R.id.progress, this.mProgress, false, false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setMinHeight(@Px int i) {
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(@Px int i) {
        this.mMinWidth = i;
        requestLayout();
    }

    public void setMode(int i) {
        Drawable drawable;
        this.mCurrentMode = i;
        if (i == 3) {
            drawable = ContextCompat.getDrawable(getContext(), C0419R.drawable.sesl_scrubber_progress_vertical);
        } else if (i != 4) {
            if (i == 7) {
                initializeRoundCircleMode();
            } else if (i == 9) {
                initializeGradientHorizontalMode();
            } else if (i == 10) {
                this.mIsGradient = true;
                setGradientColorsForCircle();
                initializeRoundCircleMode();
            }
            drawable = null;
        } else {
            drawable = ContextCompat.getDrawable(getContext(), C0419R.drawable.sesl_split_seekbar_background_progress);
        }
        if (drawable != null) {
            setProgressDrawableTiled(drawable);
        }
    }

    public synchronized void setProgress(int i) {
        setProgressInternal(i, false, false);
    }

    public void setProgressBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mProgressBackgroundTintList = colorStateList;
        progressTintInfo.mHasProgressBackgroundTint = true;
        if (this.mProgressDrawable != null) {
            applyProgressBackgroundTint();
        }
    }

    public void setProgressBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mProgressBackgroundTintMode = mode;
        progressTintInfo.mHasProgressBackgroundTintMode = true;
        if (this.mProgressDrawable != null) {
            applyProgressBackgroundTint();
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mProgressDrawable);
            }
            this.mProgressDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.mCurrentMode == 3) {
                    int minimumWidth = drawable.getMinimumWidth();
                    if (this.mMaxWidth < minimumWidth) {
                        this.mMaxWidth = minimumWidth;
                        requestLayout();
                    }
                } else {
                    int minimumHeight = drawable.getMinimumHeight();
                    if (this.mMaxHeight < minimumHeight) {
                        this.mMaxHeight = minimumHeight;
                        requestLayout();
                    }
                }
                applyProgressTints();
            }
            if (!this.mIndeterminate) {
                swapCurrentDrawable(drawable);
                postInvalidate();
            }
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(R.id.progress, this.mProgress, false, false, false);
            doRefreshProgress(R.id.secondaryProgress, this.mSecondaryProgress, false, false, false);
            if (getImportantForAccessibility() == 0) {
                setImportantForAccessibility(1);
            }
        }
    }

    public void setProgressDrawableTiled(Drawable drawable) {
        if (drawable != null) {
            drawable = tileify(drawable, false);
        }
        setProgressDrawable(drawable);
    }

    public synchronized boolean setProgressInternal(int i, boolean z, boolean z2) {
        Drawable drawableFindDrawableByLayerId;
        Drawable drawableFindDrawableByLayerId2;
        if (this.mIndeterminate) {
            return false;
        }
        int iClamp = MathUtils.clamp(i, this.mMin, this.mMax);
        int i2 = this.mProgress;
        if (iClamp == i2) {
            return false;
        }
        this.mVisualProgress = i2;
        this.mProgress = iClamp;
        if (this.mCurrentMode == 9 && (getProgressDrawable() instanceof LayerDrawable) && (drawableFindDrawableByLayerId2 = ((LayerDrawable) getProgressDrawable()).findDrawableByLayerId(R.id.progress)) != null && (drawableFindDrawableByLayerId2 instanceof GradientHorizontalProgressDrawable)) {
            ((GradientHorizontalProgressDrawable) drawableFindDrawableByLayerId2).setProgress(iClamp, z2);
            return true;
        }
        int i4 = this.mCurrentMode;
        if ((i4 == 7 || i4 == 10) && (getProgressDrawable() instanceof LayerDrawable) && (drawableFindDrawableByLayerId = ((LayerDrawable) getProgressDrawable()).findDrawableByLayerId(R.id.progress)) != null && (drawableFindDrawableByLayerId instanceof CirCleProgressDrawable)) {
            ((CirCleProgressDrawable) drawableFindDrawableByLayerId).setProgress(iClamp, z2);
        }
        refreshProgress(R.id.progress, this.mProgress, z, z2);
        return true;
    }

    public void setProgressTintList(@Nullable ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mProgressTintList = colorStateList;
        progressTintInfo.mHasProgressTint = true;
        if (this.mProgressDrawable != null) {
            applyPrimaryProgressTint();
        }
    }

    public void setProgressTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mProgressTintMode = mode;
        progressTintInfo.mHasProgressTintMode = true;
        if (this.mProgressDrawable != null) {
            applyPrimaryProgressTint();
        }
    }

    public synchronized void setSecondaryProgress(int i) {
        if (this.mIndeterminate) {
            return;
        }
        int i2 = this.mMin;
        if (i < i2) {
            i = i2;
        }
        int i4 = this.mMax;
        if (i > i4) {
            i = i4;
        }
        if (i != this.mSecondaryProgress) {
            this.mSecondaryProgress = i;
            refreshProgress(R.id.secondaryProgress, i, false, false);
        }
    }

    public void setSecondaryProgressTintList(@Nullable ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mSecondaryProgressTintList = colorStateList;
        progressTintInfo.mHasSecondaryProgressTint = true;
        if (this.mProgressDrawable != null) {
            applySecondaryProgressTint();
        }
    }

    public void setSecondaryProgressTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        progressTintInfo.mSecondaryProgressTintMode = mode;
        progressTintInfo.mHasSecondaryProgressTintMode = true;
        if (this.mProgressDrawable != null) {
            applySecondaryProgressTint();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateDrawableBounds(int i, int i2) {
        int i4;
        int i5;
        int i6;
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingBottom = i2 - (getPaddingBottom() + getPaddingTop());
        Drawable drawable = this.mIndeterminateDrawable;
        if (drawable != null) {
            if (!this.mOnlyIndeterminate || (drawable instanceof AnimationDrawable)) {
                i4 = paddingLeft;
                i5 = 0;
                i6 = 0;
                if (this.mMirrorForRtl || !ViewUtils.isLayoutRtl(this)) {
                    paddingLeft = i4;
                } else {
                    int i7 = paddingLeft - i4;
                    paddingLeft -= i6;
                    i6 = i7;
                }
                this.mIndeterminateDrawable.setBounds(i6, i5, paddingLeft, paddingBottom);
            } else {
                float intrinsicWidth = drawable.getIntrinsicWidth() / this.mIndeterminateDrawable.getIntrinsicHeight();
                float f = paddingLeft;
                float f4 = paddingBottom;
                float f5 = f / f4;
                if (Math.abs(intrinsicWidth - f5) < 1.0E-7d) {
                    if (f5 > intrinsicWidth) {
                        int i8 = (int) (f4 * intrinsicWidth);
                        int i9 = (paddingLeft - i8) / 2;
                        i6 = i9;
                        i4 = i8 + i9;
                        i5 = 0;
                    } else {
                        int i10 = (int) ((1.0f / intrinsicWidth) * f);
                        int i11 = (paddingBottom - i10) / 2;
                        int i12 = i10 + i11;
                        i5 = i11;
                        paddingBottom = i12;
                        i4 = paddingLeft;
                        i6 = 0;
                    }
                }
                if (this.mMirrorForRtl) {
                    paddingLeft = i4;
                    this.mIndeterminateDrawable.setBounds(i6, i5, paddingLeft, paddingBottom);
                }
            }
        }
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, paddingLeft, paddingBottom);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return drawable == this.mProgressDrawable || drawable == this.mIndeterminateDrawable || super.verifyDrawable(drawable);
    }

    public SeslProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public SeslProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public void setProgress(int i, boolean z) {
        setProgressInternal(i, false, z);
    }

    public SeslProgressBar(Context context, AttributeSet attributeSet, int i, int i2) throws Throwable {
        SeslProgressBar seslProgressBar;
        Context context2;
        super(context, attributeSet, i, i2);
        this.mCurrentMode = 0;
        this.mUseCustomWidthForCircleMode = false;
        this.mIsGradient = false;
        this.mCircleGradientStyle = 0;
        this.mUseHorizontalProgress = false;
        this.mSampleWidth = 0;
        this.mMirrorForRtl = false;
        this.mRefreshData = new ArrayList<>();
        this.VISUAL_PROGRESS = new FloatProperty<SeslProgressBar>("visual_progress") { // from class: androidx.appcompat.widget.SeslProgressBar.1
            @Override // android.util.Property
            public Float get(SeslProgressBar seslProgressBar2) {
                return Float.valueOf(seslProgressBar2.mVisualProgress);
            }

            @Override // android.util.FloatProperty
            public void setValue(SeslProgressBar seslProgressBar2, float f) {
                seslProgressBar2.setVisualProgress(R.id.progress, f);
                seslProgressBar2.mVisualProgress = f;
            }
        };
        this.mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.ProgressBar, i, i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                seslProgressBar = this;
                context2 = context;
                try {
                    seslProgressBar.saveAttributeDataForStyleable(context2, C0419R.styleable.ProgressBar, attributeSet, typedArrayObtainStyledAttributes, i, i2);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    typedArrayObtainStyledAttributes.recycle();
                    throw th2;
                }
            } else {
                seslProgressBar = this;
                context2 = context;
            }
            seslProgressBar.mNoInvalidate = true;
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.ProgressBar_android_progressDrawable);
            if (drawable != null) {
                if (needsTileify(drawable)) {
                    setProgressDrawableTiled(drawable);
                } else {
                    setProgressDrawable(drawable);
                }
            }
            seslProgressBar.mDuration = typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_indeterminateDuration, seslProgressBar.mDuration);
            seslProgressBar.mCircleGradientStyle = typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_sesl_progressCircleGradientStyle, seslProgressBar.mCircleGradientStyle);
            seslProgressBar.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ProgressBar_android_minWidth, seslProgressBar.mMinWidth);
            seslProgressBar.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ProgressBar_android_maxWidth, seslProgressBar.mMaxWidth);
            seslProgressBar.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ProgressBar_android_minHeight, seslProgressBar.mMinHeight);
            seslProgressBar.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ProgressBar_android_maxHeight, seslProgressBar.mMaxHeight);
            seslProgressBar.mBehavior = typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_indeterminateBehavior, seslProgressBar.mBehavior);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.ProgressBar_android_interpolator, R.anim.linear_interpolator);
            if (resourceId > 0) {
                setInterpolator(context2, resourceId);
            }
            setMin(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_min, seslProgressBar.mMin));
            setMax(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_max, seslProgressBar.mMax));
            setProgress(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_progress, seslProgressBar.mProgress));
            setSecondaryProgress(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_secondaryProgress, seslProgressBar.mSecondaryProgress));
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.ProgressBar_android_indeterminateDrawable);
            if (drawable2 != null) {
                if (needsTileify(drawable2)) {
                    setIndeterminateDrawableTiled(drawable2);
                } else {
                    setIndeterminateDrawable(drawable2);
                }
            }
            boolean z = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.ProgressBar_android_indeterminateOnly, seslProgressBar.mOnlyIndeterminate);
            seslProgressBar.mOnlyIndeterminate = z;
            seslProgressBar.mNoInvalidate = false;
            setIndeterminate(z || typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.ProgressBar_android_indeterminate, seslProgressBar.mIndeterminate));
            seslProgressBar.mMirrorForRtl = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.ProgressBar_android_mirrorForRtl, seslProgressBar.mMirrorForRtl);
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_progressTintMode)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mProgressTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_progressTintMode, -1), null);
                seslProgressBar.mProgressTintInfo.mHasProgressTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_progressTint)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mProgressTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.ProgressBar_android_progressTint);
                seslProgressBar.mProgressTintInfo.mHasProgressTint = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_progressBackgroundTintMode)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mProgressBackgroundTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_progressBackgroundTintMode, -1), null);
                seslProgressBar.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_progressBackgroundTint)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mProgressBackgroundTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.ProgressBar_android_progressBackgroundTint);
                seslProgressBar.mProgressTintInfo.mHasProgressBackgroundTint = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_secondaryProgressTintMode)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mSecondaryProgressTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_secondaryProgressTintMode, -1), null);
                seslProgressBar.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_secondaryProgressTint)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mSecondaryProgressTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.ProgressBar_android_secondaryProgressTint);
                seslProgressBar.mProgressTintInfo.mHasSecondaryProgressTint = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_indeterminateTintMode)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mIndeterminateTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.ProgressBar_android_indeterminateTintMode, -1), null);
                seslProgressBar.mProgressTintInfo.mHasIndeterminateTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.ProgressBar_android_indeterminateTint)) {
                if (seslProgressBar.mProgressTintInfo == null) {
                    seslProgressBar.mProgressTintInfo = new ProgressTintInfo();
                }
                seslProgressBar.mProgressTintInfo.mIndeterminateTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.ProgressBar_android_indeterminateTint);
                seslProgressBar.mProgressTintInfo.mHasIndeterminateTint = true;
            }
            boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.ProgressBar_seslUseCustomWidthForCircleMode, seslProgressBar.mUseCustomWidthForCircleMode);
            seslProgressBar.mUseCustomWidthForCircleMode = z2;
            if (z2) {
                seslProgressBar.mRoundStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ProgressBar_seslCircleModeStrokeWidth, getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_circle_size_small_width));
                seslProgressBar.mCirclePadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.ProgressBar_seslCircleModePadding, getResources().getDimensionPixelOffset(C0419R.dimen.sesl_progress_circle_size_small_padding));
            }
            seslProgressBar.mUseHorizontalProgress = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.ProgressBar_useHorizontalProgress, seslProgressBar.mUseHorizontalProgress);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context2, C0419R.style.Base_V7_Theme_AppCompat_Light);
            seslProgressBar.mIndeterminateHorizontalXsmall = getResources().getDrawable(C0419R.drawable.sesl_progress_bar_indeterminate_xsmall_transition, contextThemeWrapper.getTheme());
            seslProgressBar.mIndeterminateHorizontalSmall = getResources().getDrawable(C0419R.drawable.sesl_progress_bar_indeterminate_small_transition, contextThemeWrapper.getTheme());
            seslProgressBar.mIndeterminateHorizontalMedium = getResources().getDrawable(C0419R.drawable.sesl_progress_bar_indeterminate_medium_transition, contextThemeWrapper.getTheme());
            seslProgressBar.mIndeterminateHorizontalLarge = getResources().getDrawable(C0419R.drawable.sesl_progress_bar_indeterminate_large_transition, contextThemeWrapper.getTheme());
            seslProgressBar.mIndeterminateHorizontalXlarge = getResources().getDrawable(C0419R.drawable.sesl_progress_bar_indeterminate_xlarge_transition, contextThemeWrapper.getTheme());
            typedArrayObtainStyledAttributes.recycle();
            applyProgressTints();
            applyIndeterminateTint();
            if (ViewCompat.getImportantForAccessibility(this) == 0) {
                ViewCompat.setImportantForAccessibility(this, 1);
            }
            seslProgressBar.mDensity = context2.getResources().getDisplayMetrics().density;
            seslProgressBar.mCircleAnimationCallback = new CircleAnimationCallback(this);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GradientHorizontalProgressDrawable extends Drawable {
        private final IntProperty<GradientHorizontalProgressDrawable> VISUAL_HORIZONTAL_PROGRESS;
        private int mAlpha;

        @ColorInt
        int mColor;
        private int[] mGradientColors;
        private float[] mGradientPositions;
        private final boolean mIsBackground;
        private final Paint mPaint;
        public int mProgress;

        public GradientHorizontalProgressDrawable(boolean z, int i) {
            Paint paint = new Paint();
            this.mPaint = paint;
            this.mProgress = 0;
            this.mAlpha = 255;
            this.VISUAL_HORIZONTAL_PROGRESS = new IntProperty<GradientHorizontalProgressDrawable>("visual_progress") { // from class: androidx.appcompat.widget.SeslProgressBar.GradientHorizontalProgressDrawable.1
                @Override // android.util.Property
                public Integer get(GradientHorizontalProgressDrawable gradientHorizontalProgressDrawable) {
                    return Integer.valueOf(gradientHorizontalProgressDrawable.mProgress);
                }

                @Override // android.util.IntProperty
                public void setValue(GradientHorizontalProgressDrawable gradientHorizontalProgressDrawable, int i2) {
                    gradientHorizontalProgressDrawable.mProgress = i2;
                    GradientHorizontalProgressDrawable.this.invalidateSelf();
                }
            };
            this.mIsBackground = z;
            this.mColor = i;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.mColor);
        }

        private int modulateAlpha(int i, int i2) {
            return ((i2 + (i2 >>> 7)) * i) >>> 8;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            Rect bounds = getBounds();
            if (bounds.width() <= 0 || bounds.height() <= 0) {
                return;
            }
            float dimensionPixelSize = SeslProgressBar.this.getResources().getDimensionPixelSize(C0419R.dimen.sesl_progress_bar_height) / 2.0f;
            float fExactCenterY = bounds.exactCenterY();
            float f = fExactCenterY - dimensionPixelSize;
            float f4 = fExactCenterY + dimensionPixelSize;
            int alpha = this.mPaint.getAlpha();
            this.mPaint.setAlpha(modulateAlpha(alpha, this.mAlpha));
            if (this.mIsBackground) {
                this.mPaint.setColor(this.mColor);
                this.mPaint.setShader(null);
                canvas.drawRoundRect(new RectF(bounds.left, f, bounds.right, f4), dimensionPixelSize, dimensionPixelSize, this.mPaint);
            } else {
                int i = SeslProgressBar.this.mMax - SeslProgressBar.this.mMin;
                float fWidth = bounds.width() * (i > 0 ? (this.mProgress - SeslProgressBar.this.mMin) / i : 0.0f);
                if (fWidth > 0.0f) {
                    this.mPaint.setShader(new LinearGradient(bounds.left, f, bounds.right, f, this.mGradientColors, this.mGradientPositions, Shader.TileMode.CLAMP));
                    int i2 = bounds.left;
                    canvas.drawRoundRect(new RectF(i2, f, i2 + fWidth, f4), dimensionPixelSize, dimensionPixelSize, this.mPaint);
                }
            }
            this.mPaint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            if (this.mPaint.getXfermode() != null) {
                return -3;
            }
            int alpha = this.mPaint.getAlpha();
            if (alpha == 0) {
                return -2;
            }
            return alpha == 255 ? -1 : -3;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            if (this.mAlpha != i) {
                this.mAlpha = i;
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setProgress(int i, boolean z) {
            if (!z) {
                this.mProgress = i;
                invalidateSelf();
                return;
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, this.VISUAL_HORIZONTAL_PROGRESS, i);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(80L);
            objectAnimatorOfInt.setInterpolator(SeslProgressBar.PROGRESS_ANIM_INTERPOLATOR);
            objectAnimatorOfInt.start();
        }

        public GradientHorizontalProgressDrawable(boolean z, int[] iArr, float[] fArr) {
            Paint paint = new Paint();
            this.mPaint = paint;
            this.mProgress = 0;
            this.mAlpha = 255;
            this.VISUAL_HORIZONTAL_PROGRESS = new IntProperty<GradientHorizontalProgressDrawable>("visual_progress") { // from class: androidx.appcompat.widget.SeslProgressBar.GradientHorizontalProgressDrawable.1
                @Override // android.util.Property
                public Integer get(GradientHorizontalProgressDrawable gradientHorizontalProgressDrawable) {
                    return Integer.valueOf(gradientHorizontalProgressDrawable.mProgress);
                }

                @Override // android.util.IntProperty
                public void setValue(GradientHorizontalProgressDrawable gradientHorizontalProgressDrawable, int i2) {
                    gradientHorizontalProgressDrawable.mProgress = i2;
                    GradientHorizontalProgressDrawable.this.invalidateSelf();
                }
            };
            this.mIsBackground = z;
            this.mGradientColors = iArr;
            this.mGradientPositions = fArr;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void onVisualProgressChanged(int i, float f) {
    }
}
