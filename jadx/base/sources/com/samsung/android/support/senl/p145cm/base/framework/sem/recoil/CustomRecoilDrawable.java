package com.samsung.android.support.senl.p145cm.base.framework.sem.recoil;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
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
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.ColorInt;
import androidx.appcompat.animation.C0421a;
import androidx.core.graphics.ColorUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 W2\u00020\u0001:\u0002VWB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0002\u0010\u0007B-\b\u0016\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001f\u001a\u00020\u001dJ\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0014J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0016J \u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u001dH\u0002J.\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0018\u00010<R\u000206H\u0016J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020?H\u0002J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010K\u001a\u00020\u001dH\u0002J\u0018\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0016J\b\u0010R\u001a\u00020\rH\u0016J\b\u0010S\u001a\u00020\u001dH\u0002J\u0006\u0010U\u001a\u00020\u001dR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010H\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0011\u0010T\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bT\u0010A¨\u0006X"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilDrawable;", "Landroid/graphics/drawable/LayerDrawable;", "<init>", "()V", RtspHeaders.Values.LAYERS, "", "Landroid/graphics/drawable/Drawable;", "([Landroid/graphics/drawable/Drawable;)V", "color", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "(I[Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "mIsActive", "", "mIsPressed", "mAnimator", "Landroid/animation/ValueAnimator;", "mPressDuration", "", "mReleaseDuration", "mTintColor", "mRadius", "mMask", "mHotspotPointX", "", "mHotspotPointY", "mListener", "Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilDrawable$RecoilDrawableListener;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "init", "isStateful", "hasFocusStateSpecified", "onStateChange", "state", "", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "setActive", "focused", "hovered", "pressed", "initAnimator", "startEnterAnimation", "opacity", "startExitAnimation", "inflate", "r", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", BaseWidgetConstant.WIDGET_THEME, "Landroid/content/res/Resources$Theme;", "updateStateFromTypedArray", "a", "Landroid/content/res/TypedArray;", "isDrawHotspot", "()Z", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "draw", "canvas", "Landroid/graphics/Canvas;", "drawHotspot", "radius", "getRadius", "()F", "setTint", "animatingTintColor", "getAnimatingTintColor", "()I", "setHotspot", "x", "y", "isProjected", "updateMaskLayer", "isActive", "setCancel", "RecoilDrawableListener", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CustomRecoilDrawable extends LayerDrawable {
    private static final int DEFAULT_TINT_COLOR = 419430400;
    private static final long PRESS_ANIMATION_DURATION = 100;
    private static final int RADIUS_AUTO = -1;
    private static final long RELEASE_ANIMATION_DURATION = 350;

    @NotNull
    private static final String TAG = "CustomRecoilDrawable";

    @NotNull
    private final ValueAnimator mAnimator;
    private float mHotspotPointX;
    private float mHotspotPointY;
    private boolean mIsActive;
    private boolean mIsPressed;

    @Nullable
    private RecoilDrawableListener mListener;

    @Nullable
    private Drawable mMask;
    private long mPressDuration;
    private int mRadius;
    private long mReleaseDuration;
    private int mTintColor;

    @NotNull
    private static final Interpolator PRESS_INTERPOLATOR = new LinearInterpolator();

    @NotNull
    private static final Interpolator RELEASE_INTERPOLATOR = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilDrawable$RecoilDrawableListener;", "", "onReleaseAnimationStart", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface RecoilDrawableListener {
        void onReleaseAnimationStart();
    }

    public CustomRecoilDrawable() {
        super(new Drawable[0]);
        this.mIsActive = false;
        this.mIsPressed = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.mAnimator = valueAnimatorOfFloat;
        this.mListener = null;
        init();
    }

    private final void drawHotspot(Canvas canvas) {
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

    private final int getAnimatingTintColor() {
        float fAlpha = Color.valueOf(this.mTintColor).alpha();
        Object animatedValue = this.mAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        return ColorUtils.setAlphaComponent(this.mTintColor, (int) (((Float) animatedValue).floatValue() * fAlpha * 255.0f));
    }

    private final float getRadius() {
        int i = this.mRadius;
        if (i > 0) {
            return i;
        }
        Rect rect = new Rect();
        getHotspotBounds(rect);
        int iHeight = rect.height() / 2;
        return iHeight > 0 ? iHeight : getBounds().height() / 2;
    }

    private final void init() {
        this.mPressDuration = 100L;
        this.mReleaseDuration = 350L;
        initAnimator();
        setPaddingMode(1);
    }

    private final void initAnimator() {
        this.mAnimator.addUpdateListener(new C0421a(this, 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$0(CustomRecoilDrawable customRecoilDrawable, ValueAnimator valueAnimator) {
        customRecoilDrawable.setTint();
        customRecoilDrawable.invalidateSelf();
    }

    private final boolean isDrawHotspot() {
        return getNumberOfLayers() <= 0;
    }

    private final void setActive(boolean focused, boolean hovered, boolean pressed) {
        boolean z = focused || hovered || pressed;
        if (pressed) {
            this.mIsPressed = true;
            startEnterAnimation(1.0f);
        } else if (hovered) {
            startEnterAnimation(0.6f);
        } else if (focused) {
            startEnterAnimation(0.8f);
        } else if (this.mIsActive && !z) {
            startExitAnimation();
        }
        this.mIsActive = z;
        this.mIsPressed = pressed;
    }

    private final void setTint() {
        int animatingTintColor = getAnimatingTintColor();
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(animatingTintColor);
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            setTintBlendMode(BlendMode.HARD_LIGHT);
        }
        setTint(animatingTintColor);
    }

    private final void startEnterAnimation(float opacity) {
        if (this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        ValueAnimator valueAnimator = this.mAnimator;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        valueAnimator.setFloatValues(((Float) animatedValue).floatValue(), opacity);
        this.mAnimator.setInterpolator(PRESS_INTERPOLATOR);
        this.mAnimator.setDuration(this.mPressDuration);
        this.mAnimator.start();
    }

    private final void startExitAnimation() {
        float fFloatValue;
        if (this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (this.mIsPressed) {
            fFloatValue = 1.0f;
        } else {
            Object animatedValue = this.mAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            fFloatValue = ((Float) animatedValue).floatValue();
        }
        this.mAnimator.setFloatValues(fFloatValue, 0.0f);
        this.mAnimator.setInterpolator(RELEASE_INTERPOLATOR);
        this.mAnimator.setDuration(this.mReleaseDuration);
        this.mAnimator.start();
        RecoilDrawableListener recoilDrawableListener = this.mListener;
        if (recoilDrawableListener != null) {
            Intrinsics.checkNotNull(recoilDrawableListener);
            recoilDrawableListener.onReleaseAnimationStart();
        }
    }

    private final void updateMaskLayer() {
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(0);
            if (Build.VERSION.SDK_INT >= 29) {
                BlendMode unused = BlendMode.SRC_IN;
                drawableFindDrawableByLayerId.setTintBlendMode(BlendMode.SRC_IN);
            }
        }
    }

    private final void updateStateFromTypedArray(TypedArray a) {
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            if (index == C7968R.styleable.CustomRecoil_customControlHighlightRecoilColor) {
                Context applicationContext = BaseUtils.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext);
                this.mTintColor = ResourceUtils.getControlHighlightColor(applicationContext);
            } else if (index == C7968R.styleable.CustomRecoil_customRecoilColor) {
                this.mTintColor = a.getColor(index, DEFAULT_TINT_COLOR);
            } else if (index == C7968R.styleable.CustomRecoil_customRecoilRadius) {
                this.mRadius = a.getDimensionPixelSize(index, -1);
            } else if (index == C7968R.styleable.CustomRecoil_customRecoilMask) {
                Drawable drawable = a.getDrawable(index);
                this.mMask = drawable;
                if (drawable != null) {
                    setId(addLayer(drawable), R.id.mask);
                }
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int saveCount = canvas.getSaveCount();
        if (isDrawHotspot()) {
            drawHotspot(canvas);
        } else {
            super.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return null;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean hasFocusStateSpecified() {
        return true;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void inflate(@NotNull Resources r, @NotNull XmlPullParser parser, @NotNull AttributeSet attrs, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = r.obtainAttributes(attrs, C7968R.styleable.CustomRecoil);
        try {
            try {
                Intrinsics.checkNotNull(typedArrayObtainAttributes);
                updateStateFromTypedArray(typedArrayObtainAttributes);
            } catch (XmlPullParserException e) {
                Log.e(TAG, "Failed to parse!!", e);
            }
            super.inflate(r, parser, attrs, theme);
            updateMaskLayer();
        } finally {
            typedArrayObtainAttributes.recycle();
        }
    }

    public final boolean isActive() {
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
    public boolean onStateChange(@NotNull int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i : state) {
            if (i == 16842908) {
                z = true;
            } else if (i == 16842919) {
                z3 = true;
            } else if (i == 16843623) {
                z2 = true;
            }
        }
        setActive(z, z2, z3);
        return super.onStateChange(state);
    }

    public final void removeListener() {
        if (this.mListener != null) {
            this.mListener = null;
        }
    }

    public final void setCancel() {
        setState(new int[0]);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setHotspot(float x, float y2) {
        super.setHotspot(x, y2);
        this.mHotspotPointX = x;
        this.mHotspotPointY = y2;
    }

    public final void setListener(@Nullable RecoilDrawableListener listener) {
        if (this.mListener == null) {
            this.mListener = listener;
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setTintBlendMode(@NotNull BlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        super.setTintBlendMode(blendMode);
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        drawableFindDrawableByLayerId.setTintBlendMode(BlendMode.SRC_IN);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList tint) {
        super.setTintList(tint);
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(getAnimatingTintColor());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRecoilDrawable(@NotNull Drawable[] layers) {
        super(layers);
        Intrinsics.checkNotNullParameter(layers, "layers");
        this.mIsActive = false;
        this.mIsPressed = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.mAnimator = valueAnimatorOfFloat;
        this.mListener = null;
        init();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomRecoilDrawable(@ColorInt int i, @NotNull Drawable[] layers, @Nullable Drawable drawable) {
        this(layers);
        Intrinsics.checkNotNullParameter(layers, "layers");
        init();
        this.mTintColor = i;
        if (drawable != null) {
            this.mMask = drawable;
            setId(addLayer(drawable), R.id.mask);
        }
    }
}
