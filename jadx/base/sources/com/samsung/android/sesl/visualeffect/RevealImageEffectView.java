package com.samsung.android.sesl.visualeffect;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RenderEffect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sesl.outerGlow.AbstractC7839a;
import com.samsung.android.sesl.visualeffect.surfaceeffects.circularreveal.CircularRevealShader;
import com.samsung.android.sesl.visualeffect.surfaceeffects.roundedrectreveal.RoundedRectRevealShader;
import com.samsung.android.sesl.visualeffect.utils.EffectFrameRateHelper;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u000234B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020-H\u0017J\b\u0010/\u001a\u00020-H\u0003J\b\u00100\u001a\u00020-H\u0003J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020-H\u0017R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/RevealImageEffectView;", "Lcom/samsung/android/sesl/visualeffect/EffectView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revealShader", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/circularreveal/CircularRevealShader;", "revealShaderRoundedRect", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/roundedrectreveal/RoundedRectRevealShader;", "animation", "Landroid/animation/ValueAnimator;", "mainImageContainer", "Landroid/widget/FrameLayout;", "getMainImageContainer", "()Landroid/widget/FrameLayout;", "setMainImageContainer", "(Landroid/widget/FrameLayout;)V", "subImageContainer", "getSubImageContainer", "setSubImageContainer", "mainImage", "Landroid/widget/ImageView;", "getMainImage", "()Landroid/widget/ImageView;", "setMainImage", "(Landroid/widget/ImageView;)V", "subImage", "getSubImage", "setSubImage", VMetaDataKey.META_KEY_SHAPE, "Lcom/samsung/android/sesl/visualeffect/RevealImageEffectView$Shape;", "getShape", "()Lcom/samsung/android/sesl/visualeffect/RevealImageEffectView$Shape;", "setShape", "(Lcom/samsung/android/sesl/visualeffect/RevealImageEffectView$Shape;)V", "interpolator", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "initView", "", "startAnimation", "startCircularAnimation", "startRoundRectAnimation", "cancelAnimation", "reset", "Companion", "Shape", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class RevealImageEffectView extends EffectView {
    public static final long DEFAULT_REVEAL_DURATION_MS = 2000;

    @Nullable
    private ValueAnimator animation;

    @NotNull
    private Interpolator interpolator;
    public ImageView mainImage;
    public FrameLayout mainImageContainer;

    @RequiresApi(33)
    @NotNull
    private final CircularRevealShader revealShader;

    @RequiresApi(33)
    @NotNull
    private final RoundedRectRevealShader revealShaderRoundedRect;

    @NotNull
    private Shape shape;
    public ImageView subImage;
    public FrameLayout subImageContainer;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/RevealImageEffectView$Shape;", "", "<init>", "(Ljava/lang/String;I)V", "Circular", "RoundRect", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Shape {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Shape[] $VALUES;
        public static final Shape Circular = new Shape("Circular", 0);
        public static final Shape RoundRect = new Shape("RoundRect", 1);

        private static final /* synthetic */ Shape[] $values() {
            return new Shape[]{Circular, RoundRect};
        }

        static {
            Shape[] shapeArr$values = $values();
            $VALUES = shapeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(shapeArr$values);
        }

        private Shape(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Shape> getEntries() {
            return $ENTRIES;
        }

        public static Shape valueOf(String str) {
            return (Shape) Enum.valueOf(Shape.class, str);
        }

        public static Shape[] values() {
            return (Shape[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shape.values().length];
            try {
                iArr[Shape.Circular.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shape.RoundRect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevealImageEffectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.revealShader = new CircularRevealShader();
        this.revealShaderRoundedRect = new RoundedRectRevealShader();
        this.shape = Shape.Circular;
        this.interpolator = new PathInterpolator(0.22f, 0.5f, 0.2f, 1.0f);
        setDuration(2000L);
        LayoutInflater.from(context).inflate(C7843R.layout.reveal_effect_view, this);
        initView();
    }

    @RequiresApi(33)
    private final void startCircularAnimation() {
        CircularRevealShader circularRevealShader = this.revealShader;
        circularRevealShader.setCenter(getWidth() * 0.5f, getHeight() * 0.5f);
        circularRevealShader.setBlur(1.0f);
        getMainImageContainer().bringToFront();
        int i = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(getDuration());
        valueAnimatorOfFloat.setInterpolator(this.interpolator);
        C7844a c7844a = new C7844a(this, 0);
        Float fM6545xfc4e826a = getRequestedEffectFrameRate();
        if (fM6545xfc4e826a != null) {
            float fFloatValue = fM6545xfc4e826a.floatValue();
            if (EffectFrameRateHelper.INSTANCE.isViewFrameRateUpdateAvailable()) {
                valueAnimatorOfFloat.addUpdateListener(c7844a);
            } else {
                valueAnimatorOfFloat.addUpdateListener(new EffectFrameRateHelper.FrameRateAnimatorUpdateListener(fFloatValue, new C4202b(c7844a, i)));
            }
        } else {
            valueAnimatorOfFloat.addUpdateListener(c7844a);
        }
        valueAnimatorOfFloat.start();
        this.animation = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startCircularAnimation$lambda$4$lambda$1(RevealImageEffectView revealImageEffectView, ValueAnimator valueAnimator) {
        revealImageEffectView.revealShader.setRadius(RangesKt.coerceAtLeast(revealImageEffectView.getWidth(), revealImageEffectView.getHeight()) * ((Float) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Float")).floatValue());
        revealImageEffectView.getMainImage().setRenderEffect(RenderEffect.createRuntimeShaderEffect(AbstractC7839a.m6521c(revealImageEffectView.revealShader), "in_src"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCircularAnimation$lambda$4$lambda$3$lambda$2(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        animatorUpdateListener.onAnimationUpdate(animator);
        return Unit.INSTANCE;
    }

    @RequiresApi(33)
    private final void startRoundRectAnimation() {
        RoundedRectRevealShader roundedRectRevealShader = this.revealShaderRoundedRect;
        roundedRectRevealShader.setCenter(getWidth() * 0.5f, getHeight() * 0.5f);
        roundedRectRevealShader.setBlur(1.0f);
        roundedRectRevealShader.setScreenRadio(getWidth() / getHeight());
        getMainImageContainer().bringToFront();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(getDuration());
        valueAnimatorOfFloat.setInterpolator(this.interpolator);
        C7844a c7844a = new C7844a(this, 1);
        Float fM6545xfc4e826a = getRequestedEffectFrameRate();
        if (fM6545xfc4e826a != null) {
            float fFloatValue = fM6545xfc4e826a.floatValue();
            if (EffectFrameRateHelper.INSTANCE.isViewFrameRateUpdateAvailable()) {
                valueAnimatorOfFloat.addUpdateListener(c7844a);
            } else {
                valueAnimatorOfFloat.addUpdateListener(new EffectFrameRateHelper.FrameRateAnimatorUpdateListener(fFloatValue, new C4202b(c7844a, 3)));
            }
        }
        valueAnimatorOfFloat.start();
        this.animation = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRoundRectAnimation$lambda$9$lambda$6(RevealImageEffectView revealImageEffectView, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Float")).floatValue();
        revealImageEffectView.revealShaderRoundedRect.setRadius(RangesKt.coerceAtLeast(revealImageEffectView.getWidth(), revealImageEffectView.getHeight()) * fFloatValue);
        revealImageEffectView.revealShaderRoundedRect.setCornerRadius(RangesKt.coerceAtLeast(revealImageEffectView.getWidth(), revealImageEffectView.getHeight()) * 0.35f * fFloatValue);
        revealImageEffectView.getMainImage().setRenderEffect(RenderEffect.createRuntimeShaderEffect(AbstractC7839a.m6521c(revealImageEffectView.revealShaderRoundedRect), "in_src"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRoundRectAnimation$lambda$9$lambda$8$lambda$7(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        animatorUpdateListener.onAnimationUpdate(animator);
        return Unit.INSTANCE;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void cancelAnimation() {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.cancelAnimation();
    }

    @NotNull
    public final Interpolator getInterpolator() {
        return this.interpolator;
    }

    @NotNull
    public final ImageView getMainImage() {
        ImageView imageView = this.mainImage;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainImage");
        return null;
    }

    @NotNull
    public final FrameLayout getMainImageContainer() {
        FrameLayout frameLayout = this.mainImageContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainImageContainer");
        return null;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    @NotNull
    public final ImageView getSubImage() {
        ImageView imageView = this.subImage;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subImage");
        return null;
    }

    @NotNull
    public final FrameLayout getSubImageContainer() {
        FrameLayout frameLayout = this.subImageContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subImageContainer");
        return null;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void initView() {
        setMainImageContainer((FrameLayout) findViewById(C7843R.id.main_image_view_container));
        setMainImage((ImageView) findViewById(C7843R.id.main_image_view));
        setSubImageContainer((FrameLayout) findViewById(C7843R.id.sub_image_view_container));
        setSubImage((ImageView) findViewById(C7843R.id.sub_image_view));
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    @RequiresApi(31)
    public void reset() {
        getMainImageContainer().bringToFront();
        getMainImage().setRenderEffect(null);
    }

    public final void setInterpolator(@NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "<set-?>");
        this.interpolator = interpolator;
    }

    public final void setMainImage(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mainImage = imageView;
    }

    public final void setMainImageContainer(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mainImageContainer = frameLayout;
    }

    public final void setShape(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        this.shape = shape;
    }

    public final void setSubImage(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.subImage = imageView;
    }

    public final void setSubImageContainer(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.subImageContainer = frameLayout;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    @RequiresApi(33)
    public void startAnimation() {
        super.startAnimation();
        reset();
        int i = WhenMappings.$EnumSwitchMapping$0[this.shape.ordinal()];
        if (i == 1) {
            startCircularAnimation();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            startRoundRectAnimation();
        }
    }
}
