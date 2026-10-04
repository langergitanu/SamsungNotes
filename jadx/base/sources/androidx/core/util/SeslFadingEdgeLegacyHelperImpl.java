package androidx.core.util;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.core.C2337R;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.SeslFadingEdgeHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.sun.imageio.plugins.jpeg.JPEG;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslFadingEdgeLegacyHelperImpl implements SeslFadingEdgeHelper {
    private static final long COLOR_ANIMATION_DURATION = 300;
    private static final String NAVIGATION_MODE = "navigation_mode";
    private static final int NAV_BAR_MODE_3BUTTON = 0;
    private static final int NAV_BAR_MODE_GESTURAL = 2;
    private static final int NONE_COLOR = 0;
    private static final String TAG = "SeslFadingEdgeLegacyHelperImpl";
    private boolean mAllowTopFadingEdgeEdgeWithoutEdgeToEdge;
    private final ColorAnimationManager mAnimationManager;
    private LinearGradient mBottomFadingEdgeGradient;
    private final ColorStateManager mColorStateManager;
    private final Context mContext;
    private int mDistanceFromWindowBottom;
    private boolean mExtendBottomFadingEdge;
    private boolean mExtendTopFadingEdge;
    private LinearGradient mExtraBottomFadingEdgeGradient;
    private LinearGradient mExtraTopFadingEdgeGradient;
    private float mExtraTopRatio;
    private int mFadingEdgeBottomHeight;
    private int mFadingEdgeBottomOffset;
    private int mFadingEdgeBottomPadding;
    private final Matrix mFadingEdgeMatrix;
    private int mFadingEdgeOnNaviBarBottomHeight;
    private final Paint mFadingEdgePaint;
    private int mFadingEdgeTopHeight;
    private int mForcedFadingEdgeBottomHeight;
    private int mForcedFadingEdgeTopHeight;
    private int[] mGradientBottomColors;
    private int[] mGradientBottomExtraColors;
    private int[] mGradientTopColors;
    private int[] mGradientTopExtraColors;
    private boolean mHideBottom;
    private boolean mHideTop;
    private boolean mIsAppCustomized;
    private boolean mIsFadingEdgeEnabled;
    private int mNaviBarTop;
    private Rect mRectForFadingEffect;
    private View mTargetView;
    private LinearGradient mTopFadingEdgeGradient;
    private boolean mWindowBottomAlignment;
    private static final int[] GRADIENT_ALPHA_TOP = {255, JPEG.APP0, 0};
    private static final int[] GRADIENT_ALPHA_BOTTOM = {255, JPEG.APP0, 0};
    private static final int[] GRADIENT_ALPHA_TOP_EXTRA = {255, JPEG.APP0, 163, 0};
    private static final int[] GRADIENT_ALPHA_BOTTOM_EXTRA = {255, JPEG.APP0, 163, 0};
    private static final float[] GRADIENT_POSITION_TOP = {0.0f, 0.28f, 1.0f};
    private static final float[] GRADIENT_POSITION_BOTTOM = {0.0f, 0.32f, 1.0f};
    private static final float[] GRADIENT_POSITION_TOP_EXTRA = {0.0f, 0.16f, 0.65f, 1.0f};
    private static final float[] GRADIENT_POSITION_BOTTOM_EXTRA = {0.0f, 0.12f, 0.48f, 1.0f};

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
            SeslFadingEdgeLegacyHelperImpl.this.applyAnimatedColor(iBlendARGB);
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
            this.mAnimator.addUpdateListener(new C2426c(this, i, i2, runnable, 1));
            this.mAnimator.start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorStateManager {
        private ColorStateManager() {
        }

        private void applyGradientAlpha(int[] iArr, int i, int[] iArr2) {
            if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
                return;
            }
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = ColorUtils.setAlphaComponent(i, iArr2[i2]);
            }
        }

        public int getCurrentBaseColor() {
            return SeslFadingEdgeLegacyHelperImpl.this.mGradientTopColors[0] & 16777215;
        }

        public void recreateGradients() {
            SeslFadingEdgeLegacyHelperImpl seslFadingEdgeLegacyHelperImpl = SeslFadingEdgeLegacyHelperImpl.this;
            seslFadingEdgeLegacyHelperImpl.mTopFadingEdgeGradient = seslFadingEdgeLegacyHelperImpl.createFadingEdgeGradient(seslFadingEdgeLegacyHelperImpl.mGradientTopColors, SeslFadingEdgeLegacyHelperImpl.GRADIENT_POSITION_TOP);
            SeslFadingEdgeLegacyHelperImpl seslFadingEdgeLegacyHelperImpl2 = SeslFadingEdgeLegacyHelperImpl.this;
            seslFadingEdgeLegacyHelperImpl2.mBottomFadingEdgeGradient = seslFadingEdgeLegacyHelperImpl2.createFadingEdgeGradient(seslFadingEdgeLegacyHelperImpl2.mGradientBottomColors, SeslFadingEdgeLegacyHelperImpl.GRADIENT_POSITION_BOTTOM);
            if (SeslFadingEdgeLegacyHelperImpl.this.mExtraTopFadingEdgeGradient != null) {
                SeslFadingEdgeLegacyHelperImpl seslFadingEdgeLegacyHelperImpl3 = SeslFadingEdgeLegacyHelperImpl.this;
                seslFadingEdgeLegacyHelperImpl3.mExtraTopFadingEdgeGradient = seslFadingEdgeLegacyHelperImpl3.createFadingEdgeGradient(seslFadingEdgeLegacyHelperImpl3.mGradientTopExtraColors, SeslFadingEdgeLegacyHelperImpl.GRADIENT_POSITION_TOP_EXTRA);
            }
            if (SeslFadingEdgeLegacyHelperImpl.this.mExtraBottomFadingEdgeGradient != null) {
                SeslFadingEdgeLegacyHelperImpl seslFadingEdgeLegacyHelperImpl4 = SeslFadingEdgeLegacyHelperImpl.this;
                seslFadingEdgeLegacyHelperImpl4.mExtraBottomFadingEdgeGradient = seslFadingEdgeLegacyHelperImpl4.createFadingEdgeGradient(seslFadingEdgeLegacyHelperImpl4.mGradientBottomExtraColors, SeslFadingEdgeLegacyHelperImpl.GRADIENT_POSITION_BOTTOM_EXTRA);
            }
        }

        public boolean shouldAnimateColorChange(int i, int i2) {
            return (i == 0 || i2 == 0) ? false : true;
        }

        public void updateGradientColors(int i) {
            applyGradientAlpha(SeslFadingEdgeLegacyHelperImpl.this.mGradientTopColors, i, SeslFadingEdgeLegacyHelperImpl.GRADIENT_ALPHA_TOP);
            applyGradientAlpha(SeslFadingEdgeLegacyHelperImpl.this.mGradientBottomColors, i, SeslFadingEdgeLegacyHelperImpl.GRADIENT_ALPHA_BOTTOM);
            applyGradientAlpha(SeslFadingEdgeLegacyHelperImpl.this.mGradientTopExtraColors, i, SeslFadingEdgeLegacyHelperImpl.GRADIENT_ALPHA_TOP_EXTRA);
            applyGradientAlpha(SeslFadingEdgeLegacyHelperImpl.this.mGradientBottomExtraColors, i, SeslFadingEdgeLegacyHelperImpl.GRADIENT_ALPHA_BOTTOM_EXTRA);
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

    public SeslFadingEdgeLegacyHelperImpl(Context context) {
        Paint paint = new Paint();
        this.mFadingEdgePaint = paint;
        this.mFadingEdgeMatrix = new Matrix();
        this.mTopFadingEdgeGradient = null;
        this.mBottomFadingEdgeGradient = null;
        this.mExtraTopFadingEdgeGradient = null;
        this.mExtraBottomFadingEdgeGradient = null;
        this.mExtraTopRatio = -1.0f;
        this.mIsFadingEdgeEnabled = false;
        this.mForcedFadingEdgeTopHeight = 0;
        this.mForcedFadingEdgeBottomHeight = 0;
        this.mFadingEdgeBottomPadding = 0;
        this.mExtendTopFadingEdge = false;
        this.mExtendBottomFadingEdge = false;
        this.mGradientTopColors = new int[3];
        this.mGradientBottomColors = new int[3];
        this.mGradientTopExtraColors = new int[4];
        this.mGradientBottomExtraColors = new int[4];
        this.mFadingEdgeBottomOffset = 0;
        this.mDistanceFromWindowBottom = 0;
        this.mNaviBarTop = -1;
        this.mIsAppCustomized = false;
        this.mHideTop = false;
        this.mHideBottom = false;
        this.mAllowTopFadingEdgeEdgeWithoutEdgeToEdge = false;
        this.mWindowBottomAlignment = true;
        this.mAnimationManager = new ColorAnimationManager();
        ColorStateManager colorStateManager = new ColorStateManager();
        this.mColorStateManager = colorStateManager;
        this.mContext = context;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        colorStateManager.updateGradientColors(getRoundedCornerColor(context));
    }

    private void animateColorChange(int i, int i2, Runnable runnable) {
        this.mAnimationManager.startAnimation(i, i2, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyAnimatedColor(int i) {
        this.mColorStateManager.updateGradientColors(i);
        this.mColorStateManager.recreateGradients();
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

    /* JADX INFO: Access modifiers changed from: private */
    public LinearGradient createFadingEdgeGradient(int[] iArr, float[] fArr) {
        if (iArr == null || fArr == null || iArr.length != fArr.length) {
            return null;
        }
        return new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, iArr, fArr, Shader.TileMode.CLAMP);
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

    private LinearGradient getGradientForEdge(EdgeType edgeType) {
        LinearGradient linearGradient;
        LinearGradient linearGradient2;
        return edgeType == EdgeType.TOP ? (!this.mExtendTopFadingEdge || (linearGradient2 = this.mExtraTopFadingEdgeGradient) == null) ? this.mTopFadingEdgeGradient : linearGradient2 : (!this.mExtendBottomFadingEdge || (linearGradient = this.mExtraBottomFadingEdgeGradient) == null) ? this.mBottomFadingEdgeGradient : linearGradient;
    }

    private int getPreviousColor() {
        int targetColor = this.mAnimationManager.getTargetColor();
        return targetColor != 0 ? targetColor : this.mColorStateManager.getCurrentBaseColor();
    }

    private int getRoundedCornerColor(Context context) {
        try {
            return this.mContext.getColor(this.mContext.getResources().getIdentifier(isNightMode(this.mContext) ? "sesl_round_and_bgcolor_dark" : "sesl_round_and_bgcolor_light", "color", this.mContext.getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    private Rect getWindowBounds() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
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
        if (i <= 0 || Settings.Secure.getInt(view.getContext().getContentResolver(), NAVIGATION_MODE, 0) == 2) {
            this.mNaviBarTop = -1;
            return windowInsetsCompat;
        }
        this.mNaviBarTop = Resources.getSystem().getDisplayMetrics().heightPixels - i;
        return windowInsetsCompat;
    }

    private void renderBottomFadingEdge(Canvas canvas, int i) {
        if (this.mHideBottom) {
            return;
        }
        Rect rect = this.mRectForFadingEffect;
        renderFadingEdge(canvas, EdgeType.BOTTOM, i, rect.left, rect.bottom - this.mFadingEdgeBottomPadding);
    }

    private void renderFadingEdge(Canvas canvas, EdgeType edgeType, int i, float f, float f4) {
        this.mFadingEdgeMatrix.setScale(1.0f, i);
        if (edgeType.getRotationDegrees() > 0.0f) {
            this.mFadingEdgeMatrix.postRotate(edgeType.getRotationDegrees());
        }
        this.mFadingEdgeMatrix.postTranslate(f, f4);
        LinearGradient gradientForEdge = getGradientForEdge(edgeType);
        gradientForEdge.setLocalMatrix(this.mFadingEdgeMatrix);
        this.mFadingEdgePaint.setShader(gradientForEdge);
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

    private void renderTopFadingEdge(Canvas canvas, int i) {
        if (this.mHideTop) {
            return;
        }
        Rect rect = this.mRectForFadingEffect;
        renderFadingEdge(canvas, EdgeType.TOP, i, rect.left, rect.top);
    }

    private void setColorImmediate(int i) {
        this.mAnimationManager.cancelCurrentAnimation();
        this.mAnimationManager.setTargetColorImmediate(i);
        this.mColorStateManager.updateGradientColors(i);
        this.mColorStateManager.recreateGradients();
    }

    private void setOnApplyWindowInsetsListener() {
        View view = this.mTargetView;
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (!this.mIsFadingEdgeEnabled || this.mIsAppCustomized) ? null : new C0061b(this, 5));
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
        if (this.mIsFadingEdgeEnabled) {
            int distanceFromWindowBottom = getDistanceFromWindowBottom();
            this.mDistanceFromWindowBottom = distanceFromWindowBottom;
            this.mRectForFadingEffect = new Rect(i, i2, i4, i5 - distanceFromWindowBottom);
        }
    }

    @Override // androidx.core.util.SeslFadingEdgeHelper
    public void renderFadingEffect(Canvas canvas, SeslFadingEdgeHelper.ScrollInfoProvider scrollInfoProvider) {
        if (!this.mIsFadingEdgeEnabled || this.mRectForFadingEffect == null) {
            return;
        }
        int iCalculateDynamicTopHeight = calculateDynamicTopHeight(scrollInfoProvider);
        renderBottomFadingEdge(canvas, calculateDynamicBottomHeight(scrollInfoProvider));
        renderTopFadingEdge(canvas, iCalculateDynamicTopHeight);
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
        setColorImmediate(i);
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
                this.mTopFadingEdgeGradient = createFadingEdgeGradient(this.mGradientTopColors, GRADIENT_POSITION_TOP);
                this.mBottomFadingEdgeGradient = createFadingEdgeGradient(this.mGradientBottomColors, GRADIENT_POSITION_BOTTOM);
            } else {
                this.mTopFadingEdgeGradient = null;
                this.mBottomFadingEdgeGradient = null;
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
        int previousColor = getPreviousColor();
        if (this.mColorStateManager.shouldAnimateColorChange(previousColor, i)) {
            animateColorChange(previousColor, i, runnable);
        } else {
            setColorImmediate(i);
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
            this.mExtraTopFadingEdgeGradient = createFadingEdgeGradient(this.mGradientTopExtraColors, GRADIENT_POSITION_TOP_EXTRA);
            dimensionPixelSize = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_extra_top_height);
            this.mExtraTopRatio = dimensionPixelSize / resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_top_height);
        } else {
            this.mExtraTopFadingEdgeGradient = null;
            this.mExtraTopRatio = -1.0f;
            dimensionPixelSize = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_top_height);
        }
        if (z3) {
            this.mExtraBottomFadingEdgeGradient = createFadingEdgeGradient(this.mGradientBottomExtraColors, GRADIENT_POSITION_BOTTOM_EXTRA);
            dimensionPixelSize2 = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_extra_bottom_height);
            this.mFadingEdgeOnNaviBarBottomHeight = resources.getDimensionPixelSize(C2337R.dimen.sesl_fading_edge_on_navi_bar_extra_bottom_height);
        } else {
            this.mExtraBottomFadingEdgeGradient = null;
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
