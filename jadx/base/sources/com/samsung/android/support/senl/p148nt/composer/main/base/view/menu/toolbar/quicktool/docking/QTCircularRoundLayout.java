package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.appcompat.animation.C0421a;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0018\u0018\u0000 72\u00020\u0001:\u000278B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bJ\u0016\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJ\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0002J(\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0014J\b\u00102\u001a\u00020\u001bH\u0002J\u000e\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u0012J\u000e\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mClipPath", "Landroid/graphics/Path;", "mRoundThickness", "", "mRadius", "mDrawColor", "", "mStartAngle", "mEndAngle", "mAnimationFillType", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout$AnimationFillType;", "mRatioAnimator", "Landroid/animation/ValueAnimator;", "mCurrentBgAniRatio", "mCurrentRoundThicknessAniValue", "mBgStrokeWidthFloatProperty", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout$mBgStrokeWidthFloatProperty$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout$mBgStrokeWidthFloatProperty$1;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawCanvasColor", "color", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setAngle", "startAngle", "endAngle", "isRawPointInPath", "absX", "absY", "isPointInPath", "x", "y", "onSizeChanged", "w", "h", "oldw", "oldh", "updateClipPath", "setAnimationFillType", "type", "startAnimation", "isShow", "Companion", "AnimationFillType", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTCircularRoundLayout extends FrameLayout {
    private static final long HIDE_ANIMATION_DURATION = 350;
    private static final float HIDE_DAMPING_RATIO = 1.0f;
    private static final float HIDE_STIFFNESS = 400.0f;
    private static final long SHOW_ANIMATION_DURATION = 400;
    private static final float SHOW_DAMPING_RATIO = 0.3f;
    private static final float SHOW_STIFFNESS = 200.0f;

    @NotNull
    private AnimationFillType mAnimationFillType;

    @NotNull
    private final QTCircularRoundLayout$mBgStrokeWidthFloatProperty$1 mBgStrokeWidthFloatProperty;

    @NotNull
    private final Path mClipPath;
    private float mCurrentBgAniRatio;
    private float mCurrentRoundThicknessAniValue;
    private final int mDrawColor;
    private float mEndAngle;
    private final float mRadius;

    @Nullable
    private ValueAnimator mRatioAnimator;
    private final float mRoundThickness;
    private float mStartAngle;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout$AnimationFillType;", "", "<init>", "(Ljava/lang/String;I)V", "START_TO_END", "CENTER_OUTWARD", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AnimationFillType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationFillType[] $VALUES;
        public static final AnimationFillType START_TO_END = new AnimationFillType("START_TO_END", 0);
        public static final AnimationFillType CENTER_OUTWARD = new AnimationFillType("CENTER_OUTWARD", 1);

        private static final /* synthetic */ AnimationFillType[] $values() {
            return new AnimationFillType[]{START_TO_END, CENTER_OUTWARD};
        }

        static {
            AnimationFillType[] animationFillTypeArr$values = $values();
            $VALUES = animationFillTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(animationFillTypeArr$values);
        }

        private AnimationFillType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<AnimationFillType> getEntries() {
            return $ENTRIES;
        }

        public static AnimationFillType valueOf(String str) {
            return (AnimationFillType) Enum.valueOf(AnimationFillType.class, str);
        }

        public static AnimationFillType[] values() {
            return (AnimationFillType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ QTCircularRoundLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void drawCanvasColor(Canvas canvas, int color) {
        if (Build.VERSION.SDK_INT >= 29) {
            canvas.drawColor(color);
        } else {
            canvas.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
        }
    }

    private final boolean isPointInPath(int x, int y2) {
        Region region = new Region();
        region.setPath(this.mClipPath, new Region(0, 0, getWidth(), getHeight()));
        return region.contains(x, y2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$0(QTCircularRoundLayout qTCircularRoundLayout, ValueAnimator valueAnimator) {
        qTCircularRoundLayout.mCurrentBgAniRatio = ((Float) AbstractC6670b.m4742c(valueAnimator, "value", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        qTCircularRoundLayout.updateClipPath();
    }

    private final void updateClipPath() {
        float f = this.mEndAngle;
        float f4 = this.mStartAngle;
        float f5 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f6 = ((f - f4) + f5) % f5;
        float f7 = this.mCurrentBgAniRatio * f6;
        if (this.mAnimationFillType == AnimationFillType.CENTER_OUTWARD) {
            f4 += (f6 - f7) / 2;
        }
        float f8 = f4;
        float f9 = f7 + f8;
        float f10 = this.mCurrentRoundThicknessAniValue;
        float f11 = 2;
        float f12 = f10 / f11;
        float f13 = this.mRadius;
        float f14 = (f10 / f11) + f13;
        float f15 = f13 - (f10 / f11);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        double radians = Math.toRadians(f8);
        float f16 = width;
        double d = f16;
        float fM2210a = (float) AbstractC2821a.m2210a(radians, this.mRadius, d);
        float f17 = height;
        double d2 = f17;
        float fM5b = (float) AbstractC0000a.m5b(radians, this.mRadius, d2);
        double radians2 = Math.toRadians(f9);
        float fM2210a2 = (float) AbstractC2821a.m2210a(radians2, this.mRadius, d);
        float fM5b2 = (float) AbstractC0000a.m5b(radians2, this.mRadius, d2);
        this.mClipPath.reset();
        this.mClipPath.arcTo(fM2210a - f12, fM5b - f12, fM2210a + f12, fM5b + f12, f8 - 180, 180.0f, false);
        this.mClipPath.arcTo(f16 - f14, f17 - f14, f16 + f14, f14 + f17, f8, f9 - f8, false);
        this.mClipPath.arcTo(fM2210a2 - f12, fM5b2 - f12, fM2210a2 + f12, fM5b2 + f12, f9, 180.0f, false);
        this.mClipPath.arcTo(f16 - f15, f17 - f15, f16 + f15, f17 + f15, f9, f8 - f9, false);
        invalidate();
    }

    public final boolean isRawPointInPath(float absX, float absY) {
        getLocationOnScreen(new int[2]);
        return isPointInPath((int) (absX - r0[0]), (int) (absY - r0[1]));
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.clipPath(this.mClipPath);
        drawCanvasColor(canvas, this.mDrawColor);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent event) {
        if (event == null || event.getAction() != 0 || isPointInPath((int) event.getX(), (int) event.getY())) {
            return super.onInterceptTouchEvent(event);
        }
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateClipPath();
    }

    public final void setAngle(float startAngle, float endAngle) {
        this.mStartAngle = startAngle;
        this.mEndAngle = endAngle;
        updateClipPath();
    }

    public final void setAnimationFillType(@NotNull AnimationFillType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.mAnimationFillType = type;
    }

    public final void startAnimation(boolean isShow) {
        if (this.mRatioAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mRatioAnimator = valueAnimator;
            valueAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
            ValueAnimator valueAnimator2 = this.mRatioAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new C0421a(this, 26));
            }
        }
        float f = isShow ? 0.0f : 1.0f;
        ValueAnimator valueAnimator3 = this.mRatioAnimator;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            ValueAnimator valueAnimator4 = this.mRatioAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
            }
            f = this.mCurrentBgAniRatio;
        }
        ValueAnimator valueAnimator5 = this.mRatioAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.setDuration(isShow ? 400L : 350L);
        }
        ValueAnimator valueAnimator6 = this.mRatioAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.setFloatValues(f, isShow ? 1.0f : 0.0f);
        }
        ValueAnimator valueAnimator7 = this.mRatioAnimator;
        if (valueAnimator7 != null) {
            valueAnimator7.start();
        }
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_thickness_bg_min_stroke_width);
        float dimension2 = getResources().getDimension(C9086R.dimen.composer_qt_thickness_bg_max_stroke_width);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(isShow ? dimension : dimension2), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(isShow ? 0.3f : 1.0f);
        springForce.setStiffness(isShow ? 200.0f : 400.0f);
        if (isShow) {
            dimension = dimension2;
        }
        springForce.setFinalPosition(dimension);
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircularRoundLayout$mBgStrokeWidthFloatProperty$1] */
    public QTCircularRoundLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClipPath = new Path();
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_dial_bg_thickness);
        this.mRoundThickness = dimension;
        this.mRadius = getResources().getDimension(C9086R.dimen.composer_qt_circle_radius);
        this.mDrawColor = SpenSettingUtil.getColor(context, C9086R.color.setting_qt_dial_bg_color);
        this.mEndAngle = 360.0f;
        this.mAnimationFillType = AnimationFillType.CENTER_OUTWARD;
        this.mCurrentBgAniRatio = 1.0f;
        this.mCurrentRoundThicknessAniValue = dimension;
        this.mBgStrokeWidthFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircularRoundLayout$mBgStrokeWidthFloatProperty$1
            {
                super("customFloat");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mCurrentRoundThicknessAniValue = value;
            }
        };
        setWillNotDraw(false);
    }
}
