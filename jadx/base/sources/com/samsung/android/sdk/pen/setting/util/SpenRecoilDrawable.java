package com.samsung.android.sdk.pen.setting.util;

import android.R;
import android.animation.ValueAnimator;
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
import androidx.annotation.RequiresApi;
import androidx.appcompat.animation.C0421a;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RequiresApi(api = 34)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 D2\u00020\u0001:\u0001DB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016J.\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0014J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002J \u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\fH\u0002J\b\u0010:\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020\u0014H\u0002J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00103\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010-R\u0014\u0010<\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenRecoilDrawable;", "Landroid/graphics/drawable/LayerDrawable;", "<init>", "()V", RtspHeaders.Values.LAYERS, "", "Landroid/graphics/drawable/Drawable;", "([Landroid/graphics/drawable/Drawable;)V", "mTintColor", "", "mRadius", "mHotspotPointX", "", "mHotspotPointY", "mAnimator", "Landroid/animation/ValueAnimator;", "mMask", "mIsActive", "", "close", "", "isStateful", "isProjected", "setHotspot", "x", "y", "inflate", "resources", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", BaseWidgetConstant.WIDGET_THEME, "Landroid/content/res/Resources$Theme;", "onStateChange", "state", "", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "draw", "canvas", "Landroid/graphics/Canvas;", "hasFocusStateSpecified", "isActive", "()Z", "init", "initAnimator", "updateStateFromTypedArray", "a", "Landroid/content/res/TypedArray;", "isDrawHotspot", "setActive", "focused", "hovered", "pressed", "startEnterAnimation", "opacity", "startExitAnimation", "setTint", "animatingTintColor", "getAnimatingTintColor", "()I", "drawHotspot", "radius", "getRadius", "()F", "updateMaskLayer", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecoilDrawable extends LayerDrawable {
    private static final int DEFAULT_TINT_COLOR = 419430400;
    private static final long PRESS_ANIMATION_DURATION = 100;
    private static final int RADIUS_AUTO = -1;
    private static final long RELEASE_ANIMATION_DURATION = 350;

    @NotNull
    private static final String TAG = "SpenRecoilDrawable";

    @Nullable
    private ValueAnimator mAnimator;
    private float mHotspotPointX;
    private float mHotspotPointY;
    private boolean mIsActive;

    @Nullable
    private Drawable mMask;
    private int mRadius;
    private int mTintColor;

    public SpenRecoilDrawable() {
        super(new Drawable[0]);
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
        canvas.clipRect(getBounds());
        canvas.translate(fCenterX, fCenterY);
        Paint paint = new Paint();
        paint.setColor(getAnimatingTintColor());
        canvas.drawCircle(0.0f, 0.0f, getRadius(), paint);
        canvas.translate(-fCenterX, -fCenterY);
    }

    private final int getAnimatingTintColor() {
        float fAlpha = Color.valueOf(this.mTintColor).alpha();
        ValueAnimator valueAnimator = this.mAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        return ColorUtils.setAlphaComponent(this.mTintColor, (int) (((Float) animatedValue).floatValue() * fAlpha * 255));
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
        initAnimator();
    }

    private final void initAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f);
        this.mAnimator = valueAnimatorOfFloat;
        if (valueAnimatorOfFloat != null) {
            valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 13));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$0(SpenRecoilDrawable spenRecoilDrawable, ValueAnimator valueAnimator) {
        spenRecoilDrawable.setTint();
        spenRecoilDrawable.invalidateSelf();
    }

    private final boolean isDrawHotspot() {
        return getNumberOfLayers() <= 0;
    }

    private final void setActive(boolean focused, boolean hovered, boolean pressed) {
        boolean z = focused || hovered || pressed;
        if (pressed) {
            startEnterAnimation(1.0f);
        } else if (hovered) {
            startEnterAnimation(0.6f);
        } else if (focused) {
            startEnterAnimation(0.8f);
        } else {
            startExitAnimation();
        }
        this.mIsActive = z;
    }

    private final void setTint() {
        int animatingTintColor = getAnimatingTintColor();
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(animatingTintColor);
            return;
        }
        BlendMode unused = BlendMode.HARD_LIGHT;
        setTintBlendMode(BlendMode.HARD_LIGHT);
        setTint(animatingTintColor);
    }

    private final void startEnterAnimation(float opacity) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            ValueAnimator valueAnimator2 = this.mAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            Object animatedValue = valueAnimator2.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            valueAnimator.setFloatValues(((Float) animatedValue).floatValue(), opacity);
            valueAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
            valueAnimator.setDuration(100L);
            valueAnimator.start();
        }
    }

    private final void startExitAnimation() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            ValueAnimator valueAnimator2 = this.mAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            Object animatedValue = valueAnimator2.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            valueAnimator.setFloatValues(((Float) animatedValue).floatValue(), 0.0f);
            valueAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(19));
            valueAnimator.setDuration(350L);
            valueAnimator.start();
        }
    }

    private final void updateMaskLayer() {
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(R.id.mask);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(0);
            BlendMode unused = BlendMode.SRC_IN;
            drawableFindDrawableByLayerId.setTintBlendMode(BlendMode.SRC_IN);
        }
    }

    private final void updateStateFromTypedArray(TypedArray a) {
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            if (index == C7932R.styleable.SpenRecoilEffect_recoilColor) {
                this.mTintColor = a.getColor(index, DEFAULT_TINT_COLOR);
            } else if (index == C7932R.styleable.SpenRecoilEffect_recoilRadius) {
                this.mRadius = a.getDimensionPixelSize(index, -1);
            } else if (index == C7932R.styleable.SpenRecoilEffect_recoilMask) {
                Drawable drawable = a.getDrawable(index);
                this.mMask = drawable;
                if (drawable != null) {
                    setId(addLayer(drawable), R.id.mask);
                }
            }
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
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
    public void inflate(@NotNull Resources resources, @NotNull XmlPullParser parser, @NotNull AttributeSet attrs, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attrs, C7932R.styleable.SpenRecoilEffect);
        try {
            try {
                Intrinsics.checkNotNull(typedArrayObtainAttributes);
                updateStateFromTypedArray(typedArrayObtainAttributes);
            } catch (RuntimeException e) {
                Log.e(TAG, "Failed to updateState ", e);
            }
            super.inflate(resources, parser, attrs, theme);
            updateMaskLayer();
        } finally {
            typedArrayObtainAttributes.recycle();
        }
    }

    public final boolean isActive() {
        if (this.mIsActive) {
            return true;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        return valueAnimator.isRunning();
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

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setHotspot(float x, float y2) {
        super.setHotspot(x, y2);
        this.mHotspotPointX = x;
        this.mHotspotPointY = y2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRecoilDrawable(@NotNull Drawable[] layers) {
        super(layers);
        Intrinsics.checkNotNullParameter(layers, "layers");
        init();
    }
}
