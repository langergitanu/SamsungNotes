package androidx.core.util;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.C2337R;
import androidx.core.graphics.ColorUtils;
import androidx.core.text.util.AbstractC2402b;
import androidx.core.util.SeslFadingEdgeHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.reflect.graphics.SeslCanvasReflector;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslFadingEdgeHelperImpl implements SeslFadingEdgeHelper {
    private static final long COLOR_ANIMATION_DURATION = 300;
    private static final float DEFAULT_START_ALPHA = 0.04f;
    private static final float GESTURE_BAR_ONLY_START_ALPHA = 0.2f;
    private static final String NAVIGATION_MODE = "navigation_mode";
    private static final int NAV_BAR_MODE_3BUTTON = 0;
    private static final int NAV_BAR_MODE_GESTURAL = 2;
    private static final int NONE_COLOR = 0;
    private static final String TAG = "SeslFadingEdgeHelperImpl";
    private int mCanvasSaveCount;
    private int mColor;
    private final Context mContext;
    private int mFadingEdgeBottomHeight;
    private int mFadingEdgeOnNaviBarBottomHeight;
    private int mFadingEdgeTopHeight;
    private Rect mRectForFadingEffect;
    private View mTargetView;
    private static final float[] INTERPOLATOR_TOP = {0.42f, 0.0f, 0.58f, 1.0f};
    private static final float[] INTERPOLATOR_TOP_EXTRA = {0.7f, 0.0f, 0.8f, 1.0f};
    private static final float[] INTERPOLATOR_BOTTOM_WITH_NAVI_BAR = {0.46f, 0.0f, 0.58f, 1.0f};
    private static final float[] INTERPOLATOR_BOTTOM_EXTRA_WITH_NAVI_BAR = {0.35f, 0.0f, 0.6f, 1.0f};
    private static final float[] INTERPOLATOR_BOTTOM = {0.35f, 0.0f, 0.4f, 1.0f};
    private static final float[] INTERPOLATOR_BOTTOM_EXTRA = {0.35f, 0.0f, 0.6f, 1.0f};
    private final Paint mFadingEdgePaint = new Paint();
    private final Matrix mFadingEdgeMatrix = new Matrix();
    private RuntimeShader mTopShader = null;
    private RuntimeShader mBottomShader = null;
    private RuntimeShader mExtraTopShader = null;
    private RuntimeShader mExtraBottomShader = null;
    private float mExtraTopRatio = -1.0f;
    private boolean mIsFadingEdgeEnabled = false;
    private int mForcedFadingEdgeTopHeight = 0;
    private int mForcedFadingEdgeBottomHeight = 0;
    private int mFadingEdgeBottomPadding = 0;
    private int mTopSaveCount = -1;
    private int mBottomSaveCount = -1;
    private boolean mExtendTopFadingEdge = false;
    private boolean mExtendBottomFadingEdge = false;
    private int mFadingEdgeBottomOffset = 0;
    private int mDistanceFromWindowBottom = 0;
    private int mNaviBarTop = -1;
    private boolean mIsAppCustomized = false;
    private boolean mIsNaviBarOverlapped = false;
    private boolean mHideTop = false;
    private boolean mHideBottom = false;
    private boolean mAllowTopFadingEdgeEdgeWithoutEdgeToEdge = false;
    private boolean mWindowBottomAlignment = true;
    private final ColorAnimationManager mAnimationManager = new ColorAnimationManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorAnimationManager {
        private ValueAnimator mAnimator;
        private int mCurrentColor = 0;
        private int mTargetColor = 0;

        public ColorAnimationManager() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startAnimation$0(int i, int i2, Runnable runnable, ValueAnimator valueAnimator) {
            int iBlendARGB = ColorUtils.blendARGB(i, i2, valueAnimator.getAnimatedFraction());
            this.mCurrentColor = iBlendARGB;
            SeslFadingEdgeHelperImpl.this.applyColor(iBlendARGB);
            runnable.run();
        }

        public void cancelCurrentAnimation() {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.mAnimator.cancel();
        }

        public int getTargetColor() {
            return this.mTargetColor;
        }

        public boolean isAnimating() {
            ValueAnimator valueAnimator = this.mAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        public void setTargetColorImmediate(int i) {
            this.mTargetColor = i;
            this.mCurrentColor = i;
        }

        public void startAnimation(int i, int i2, Runnable runnable) {
            cancelCurrentAnimation();
            this.mCurrentColor = i;
            this.mTargetColor = i2;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.mAnimator.addUpdateListener(new C2426c(this, i, i2, runnable, 0));
            this.mAnimator.start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum EdgeType {
        TOP(false, 0.0f),
        BOTTOM(true, 180.0f);

        private final boolean mCanUseExtendedGradient;
        private final float mRotationDegrees;

        EdgeType(boolean z, float f) {
            this.mCanUseExtendedGradient = z;
            this.mRotationDegrees = f;
        }

        public boolean canUseExtendedGradient() {
            return this.mCanUseExtendedGradient;
        }

        public float getRotationDegrees() {
            return this.mRotationDegrees;
        }
    }

    public SeslFadingEdgeHelperImpl(Context context) {
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 36) {
            setFadingEdgeColor(0);
        } else {
            setFadingEdgeColor(getRoundedCornerColor(context));
        }
    }

    private void animateColorChange(int i, int i2, Runnable runnable) {
        this.mAnimationManager.startAnimation(i, i2, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyColor(int i) {
        int i2 = i & 16777215;
        this.mColor = i2;
        RuntimeShader runtimeShader = this.mTopShader;
        if (runtimeShader != null) {
            updateShaderColor(runtimeShader, i2);
        }
        RuntimeShader runtimeShader2 = this.mBottomShader;
        if (runtimeShader2 != null) {
            updateShaderColor(runtimeShader2, this.mColor);
        }
        RuntimeShader runtimeShader3 = this.mExtraTopShader;
        if (runtimeShader3 != null) {
            updateShaderColor(runtimeShader3, this.mColor);
        }
        RuntimeShader runtimeShader4 = this.mExtraBottomShader;
        if (runtimeShader4 != null) {
            updateShaderColor(runtimeShader4, this.mColor);
        }
    }

    private int calculateDynamicBottomHeight(SeslFadingEdgeHelper.ScrollInfoProvider scrollInfoProvider) {
        if (this.mTargetView == null) {
            return 0;
        }
        Rect rect = this.mRectForFadingEffect;
        int i = rect.top;
        int i2 = rect.bottom;
        int i4 = (this.mIsAppCustomized || !isNaviBarOverlapped()) ? this.mFadingEdgeBottomHeight : this.mFadingEdgeOnNaviBarBottomHeight;
        if (i + i4 > i2 - i4) {
            i4 = (i2 - i) / 2;
        }
        int iMax = Math.max(i4, 0);
        if (iMax == 0) {
            return 0;
        }
        int iMax2 = Math.max((Math.max(scrollInfoProvider.computeVerticalScrollRange() + this.mDistanceFromWindowBottom, 0) - Math.max(scrollInfoProvider.computeVerticalScrollExtent(), 0)) - Math.max(scrollInfoProvider.computeVerticalScrollOffset(), 0), 0);
        if (scrollInfoProvider.shouldNormalizeFadingEdge()) {
            int lastItemHeightIfVisible = scrollInfoProvider.getLastItemHeightIfVisible();
            if (lastItemHeightIfVisible <= 0) {
                iMax2 = iMax;
            } else if (lastItemHeightIfVisible < iMax) {
                iMax2 = (int) ((iMax / lastItemHeightIfVisible) * iMax2);
            }
        }
        return Math.max(this.mForcedFadingEdgeBottomHeight, Math.min(iMax2, iMax));
    }

    private int calculateDynamicTopHeight(SeslFadingEdgeHelper.ScrollInfoProvider scrollInfoProvider) {
        if (this.mTargetView == null) {
            return 0;
        }
        Rect rect = this.mRectForFadingEffect;
        int i = rect.top;
        int i2 = rect.bottom;
        int i4 = this.mFadingEdgeTopHeight;
        if (i + i4 > i2 - i4) {
            i4 = (i2 - i) / 2;
        }
        int iMax = Math.max(i4, 0);
        if (iMax == 0) {
            return 0;
        }
        int iMin = Math.min(Math.max(scrollInfoProvider.computeVerticalScrollOffset(), 0), iMax);
        if (!this.mAllowTopFadingEdgeEdgeWithoutEdgeToEdge) {
            int distanceFromWindowTop = getDistanceFromWindowTop();
            if (distanceFromWindowTop < 0 || distanceFromWindowTop > iMin) {
                return this.mForcedFadingEdgeTopHeight;
            }
            iMin -= distanceFromWindowTop;
        }
        return Math.min(Math.max(this.mForcedFadingEdgeTopHeight, iMin), this.mFadingEdgeTopHeight);
    }

    private RuntimeShader createRuntimeShader(int i, float f, float[] fArr) {
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        RuntimeShader runtimeShaderM1738c = AbstractC2402b.m1738c();
        runtimeShaderM1738c.setFloatUniform(DeviceInfoUtil.CONTENTS_TYPE_RESOLUTION, 1.0f, 1.0f);
        updateShaderStartAlpha(runtimeShaderM1738c, f);
        updateShaderInterpolator(runtimeShaderM1738c, fArr);
        updateShaderColor(runtimeShaderM1738c, i);
        return runtimeShaderM1738c;
    }

    public static SeslFadingEdgeHelper createSeslFadingEdgeHelper(Context context) {
        return Build.VERSION.SDK_INT >= 33 ? new SeslFadingEdgeHelperImpl(context) : new SeslFadingEdgeLegacyHelperImpl(context);
    }

    private int getDistanceFromWindowBottom() {
        View view = this.mTargetView;
        if (view == null || !this.mWindowBottomAlignment) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[1];
        int height = this.mTargetView.getHeight() + i;
        int height2 = this.mTargetView.getRootView().getHeight();
        int iMax = height - height2;
        if (iMax > 0) {
            Rect rect = new Rect();
            this.mTargetView.getLocalVisibleRect(rect);
            iMax += Math.max(0, height2 - (i + rect.bottom));
        }
        return Math.max(0, iMax);
    }

    private int getDistanceFromWindowTop() {
        View view = this.mTargetView;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    private Shader getGradientForEdge(EdgeType edgeType) {
        RuntimeShader runtimeShader;
        RuntimeShader runtimeShader2;
        return edgeType == EdgeType.TOP ? (!this.mExtendTopFadingEdge || (runtimeShader2 = this.mExtraTopShader) == null) ? this.mTopShader : runtimeShader2 : (!this.mExtendBottomFadingEdge || (runtimeShader = this.mExtraBottomShader) == null) ? this.mBottomShader : runtimeShader;
    }

    private int getPreviousColor() {
        int targetColor = this.mAnimationManager.getTargetColor();
        return targetColor != 0 ? targetColor : this.mColor;
    }

    private boolean isNaviBarOverlapped() {
        View view = this.mTargetView;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = this.mTargetView.getHeight() + iArr[1];
            int i = this.mNaviBarTop;
            if (i > 0 && height > i) {
                return true;
            }
        }
        return false;
    }

    private boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat lambda$setOnApplyWindowInsetsListener$0(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        if (i <= 0) {
            this.mNaviBarTop = -1;
            return windowInsetsCompat;
        }
        if (Settings.Secure.getInt(view.getContext().getContentResolver(), NAVIGATION_MODE, 0) != 2) {
            this.mNaviBarTop = Resources.getSystem().getDisplayMetrics().heightPixels - i;
        }
        return windowInsetsCompat;
    }

    private void renderBottomFadingEdge(Canvas canvas, int i) {
        if (this.mHideBottom) {
            return;
        }
        Rect rect = this.mRectForFadingEffect;
        renderFadingEdge(canvas, EdgeType.BOTTOM, i, this.mBottomSaveCount, rect.left, rect.bottom - this.mFadingEdgeBottomPadding);
    }

    private void renderFadingEdge(Canvas canvas, EdgeType edgeType, int i, int i2, float f, float f4) {
        this.mFadingEdgeMatrix.setScale(1.0f, i);
        if (edgeType.getRotationDegrees() > 0.0f) {
            this.mFadingEdgeMatrix.postRotate(edgeType.getRotationDegrees());
        }
        this.mFadingEdgeMatrix.postTranslate(f, f4);
        Shader gradientForEdge = getGradientForEdge(edgeType);
        if (gradientForEdge != null) {
            gradientForEdge.setLocalMatrix(this.mFadingEdgeMatrix);
            this.mFadingEdgePaint.setShader(gradientForEdge);
            if (getPreviousColor() == 0) {
                if (i2 > 0) {
                    SeslCanvasReflector.restoreUnclippedLayer(canvas, i2, this.mFadingEdgePaint);
                    return;
                }
                return;
            }
            if (i > 0) {
                try {
                    if (edgeType == EdgeType.TOP) {
                        Rect rect = this.mRectForFadingEffect;
                        canvas.drawRect(rect.left, rect.top, rect.right, r10 + i, this.mFadingEdgePaint);
                        return;
                    }
                    Rect rect2 = this.mRectForFadingEffect;
                    canvas.drawRect(rect2.left, (r8 - i) - this.mFadingEdgeBottomPadding, rect2.right, rect2.bottom, this.mFadingEdgePaint);
                } catch (Exception e) {
                    Log.e(TAG, "Unable to draw on Canvas.", e);
                }
            }
        }
    }

    private void renderTopFadingEdge(Canvas canvas, int i) {
        if (this.mHideTop) {
            return;
        }
        Rect rect = this.mRectForFadingEffect;
        renderFadingEdge(canvas, EdgeType.TOP, i, this.mTopSaveCount, rect.left, rect.top);
    }

    private void restoreCanvasState(Canvas canvas) {
        if (getPreviousColor() == 0) {
            canvas.restoreToCount(this.mCanvasSaveCount);
        }
        this.mRectForFadingEffect = null;
    }

    private void setColorImmediate(int i) {
        this.mAnimationManager.cancelCurrentAnimation();
        this.mAnimationManager.setTargetColorImmediate(i);
        applyColor(i);
    }

    private void setOnApplyWindowInsetsListener() {
        View view = this.mTargetView;
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (!this.mIsFadingEdgeEnabled || this.mIsAppCustomized) ? null : new C0061b(this, 4));
        }
    }

    private void updateShaderColor(@NonNull RuntimeShader runtimeShader, int i) {
        if (Build.VERSION.SDK_INT >= 33) {
            runtimeShader.setFloatUniform("color", Color.red(i) / 255.0f, Color.green(i) / 255.0f, Color.blue(i) / 255.0f, 1.0f);
        }
    }

    private void updateShaderInterpolator(@NonNull RuntimeShader runtimeShader, float[] fArr) {
        if (Build.VERSION.SDK_INT >= 33) {
            runtimeShader.setFloatUniform("easing", fArr[0], fArr[1], fArr[2], fArr[3]);
        }
    }

    private void updateShaderStartAlpha(@NonNull RuntimeShader runtimeShader, float f) {
        if (Build.VERSION.SDK_INT >= 33) {
            runtimeShader.setFloatUniform("startAlpha", f);
        }
    }

    private void updateShadersForNavBarType() {
        boolean z = !this.mIsAppCustomized && isNaviBarOverlapped();
        if (this.mIsNaviBarOverlapped != z) {
            this.mIsNaviBarOverlapped = z;
            RuntimeShader runtimeShader = this.mBottomShader;
            if (runtimeShader != null) {
                updateShaderInterpolator(runtimeShader, z ? INTERPOLATOR_BOTTOM_WITH_NAVI_BAR : INTERPOLATOR_BOTTOM);
                updateShaderStartAlpha(this.mBottomShader, z ? 0.04f : 0.2f);
            }
            RuntimeShader runtimeShader2 = this.mExtraBottomShader;
            if (runtimeShader2 != null) {
                updateShaderInterpolator(runtimeShader2, z ? INTERPOLATOR_BOTTOM_EXTRA_WITH_NAVI_BAR : INTERPOLATOR_BOTTOM_EXTRA);
            }
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void forceBottomFadingEdgeClamped(int i) {
        this.mForcedFadingEdgeBottomHeight = Math.max(0, i);
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void forceTopFadingEdgeClamped(int i) {
        float f = this.mExtraTopRatio;
        if (f > 0.0f) {
            i = (int) (f * i);
        }
        this.mForcedFadingEdgeTopHeight = Math.max(0, i);
    }

    public int getBottomPaddingResource() {
        return this.mContext.getResources().getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_bottom_padding);
    }

    public int getFadingEdgeBottomHeight() {
        return this.mFadingEdgeBottomHeight;
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public int getFadingEdgeBottomOffset() {
        return this.mFadingEdgeBottomOffset;
    }

    public int getFadingEdgeTopHeight() {
        return this.mFadingEdgeTopHeight;
    }

    public int getRoundedCornerColor(Context context) {
        try {
            return this.mContext.getColor(this.mContext.getResources().getIdentifier(isNightMode(this.mContext) ? "sesl_round_and_bgcolor_dark" : "sesl_round_and_bgcolor_light", "color", this.mContext.getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void hideBottomFadingEdge(boolean z) {
        if (this.mHideBottom != z) {
            this.mHideBottom = z;
            View view = this.mTargetView;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void hideTopFadingEdge(boolean z) {
        if (this.mHideTop != z) {
            this.mHideTop = z;
            View view = this.mTargetView;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public boolean isFadingEdgeEnabled() {
        return this.mIsFadingEdgeEnabled;
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void prepareFadingEffect(Canvas canvas, int i, int i2, int i4, int i5) {
        if (this.mIsFadingEdgeEnabled && Build.VERSION.SDK_INT >= 33) {
            updateShadersForNavBarType();
            int distanceFromWindowBottom = getDistanceFromWindowBottom();
            this.mDistanceFromWindowBottom = distanceFromWindowBottom;
            int i6 = i5 - distanceFromWindowBottom;
            int i7 = this.mFadingEdgeTopHeight;
            if (i2 + i7 > i6 - i7) {
                i7 = (i6 - i2) / 2;
            }
            int i8 = (this.mIsAppCustomized || !isNaviBarOverlapped()) ? this.mFadingEdgeBottomHeight : this.mFadingEdgeOnNaviBarBottomHeight;
            if (i2 + i8 > i6 - i8) {
                i8 = (i6 - i2) / 2;
            }
            if (getPreviousColor() == 0) {
                this.mCanvasSaveCount = canvas.getSaveCount();
                this.mTopSaveCount = -1;
                this.mBottomSaveCount = -1;
                if (!this.mHideTop) {
                    this.mTopSaveCount = SeslCanvasReflector.saveUnclippedLayer(canvas, i, i2, i4, i7 + i2);
                }
                if (!this.mHideBottom) {
                    this.mBottomSaveCount = SeslCanvasReflector.saveUnclippedLayer(canvas, i, (i6 - i8) - this.mFadingEdgeBottomPadding, i4, i6);
                }
            }
            this.mRectForFadingEffect = new Rect(i, i2, i4, i6);
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void renderFadingEffect(Canvas canvas, SeslFadingEdgeHelper.ScrollInfoProvider scrollInfoProvider) {
        if (!this.mIsFadingEdgeEnabled || this.mRectForFadingEffect == null || Build.VERSION.SDK_INT < 33) {
            return;
        }
        int iCalculateDynamicTopHeight = calculateDynamicTopHeight(scrollInfoProvider);
        renderBottomFadingEdge(canvas, calculateDynamicBottomHeight(scrollInfoProvider));
        renderTopFadingEdge(canvas, iCalculateDynamicTopHeight);
        restoreCanvasState(canvas);
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setAllowTopFadingEdgeWithoutEdgeToEdge(boolean z) {
        this.mAllowTopFadingEdgeEdgeWithoutEdgeToEdge = z;
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeBottomOffset(int i) {
        this.mFadingEdgeBottomOffset = i;
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeColor(@ColorInt int i) {
        setFadingEdgeColor(i, null);
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeEnabled(boolean z, int i, int i2) {
        this.mExtendTopFadingEdge = false;
        this.mExtendBottomFadingEdge = false;
        if (this.mIsFadingEdgeEnabled != z || (z && (this.mFadingEdgeTopHeight != i || this.mFadingEdgeBottomHeight != i2))) {
            this.mIsFadingEdgeEnabled = z;
            if (z) {
                this.mFadingEdgeTopHeight = i;
                this.mFadingEdgeBottomHeight = i2;
                this.mTopShader = createRuntimeShader(this.mColor, 0.04f, INTERPOLATOR_TOP);
                this.mBottomShader = createRuntimeShader(this.mColor, 0.04f, INTERPOLATOR_BOTTOM);
            } else {
                this.mTopShader = null;
                this.mBottomShader = null;
                this.mFadingEdgeBottomPadding = 0;
            }
        }
        setOnApplyWindowInsetsListener();
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setTargetView(View view) {
        this.mTargetView = view;
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setWindowBottomAlignment(boolean z) {
        this.mWindowBottomAlignment = z;
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeColor(@ColorInt int i, Runnable runnable) {
        int previousColor;
        this.mFadingEdgePaint.setXfermode(new PorterDuffXfermode(i == 0 ? PorterDuff.Mode.DST_OUT : PorterDuff.Mode.SRC_OVER));
        if (runnable == null || (previousColor = getPreviousColor()) == 0 || i == 0) {
            setColorImmediate(i);
        } else {
            animateColorChange(previousColor, i, runnable);
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeEnabled(boolean z, int i, int i2, boolean z2) {
        this.mIsAppCustomized = z2;
        setFadingEdgeEnabled(z, i, i2);
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeEnabled(boolean z) {
        Resources resources = this.mContext.getResources();
        setFadingEdgeEnabled(z, resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_top_height), resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_bottom_height));
        this.mFadingEdgeOnNaviBarBottomHeight = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_on_navi_bar_bottom_height);
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void setFadingEdgeEnabled(boolean z, boolean z2, boolean z3) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Resources resources = this.mContext.getResources();
        if (z2) {
            this.mExtraTopShader = createRuntimeShader(this.mColor, 0.04f, INTERPOLATOR_TOP_EXTRA);
            dimensionPixelSize = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_extra_top_height);
            this.mExtraTopRatio = dimensionPixelSize / resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_top_height);
        } else {
            this.mExtraTopShader = null;
            this.mExtraTopRatio = -1.0f;
            dimensionPixelSize = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_top_height);
        }
        if (z3) {
            this.mExtraBottomShader = createRuntimeShader(this.mColor, 0.04f, INTERPOLATOR_BOTTOM_EXTRA);
            dimensionPixelSize2 = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_extra_bottom_height);
            this.mFadingEdgeOnNaviBarBottomHeight = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_on_navi_bar_extra_bottom_height);
        } else {
            this.mExtraBottomShader = null;
            dimensionPixelSize2 = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_bottom_height);
            this.mFadingEdgeOnNaviBarBottomHeight = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_on_navi_bar_bottom_height);
        }
        setFadingEdgeEnabled(z, dimensionPixelSize, dimensionPixelSize2);
        this.mExtendTopFadingEdge = z2;
        this.mExtendBottomFadingEdge = z3;
    }

    public void enableBottomPadding(boolean z) {
    }
}
