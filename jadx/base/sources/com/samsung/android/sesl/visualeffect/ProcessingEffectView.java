package com.samsung.android.sesl.visualeffect;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.MultiRippleController;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.MultiRippleView;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimation;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimationConfig;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader;
import com.samsung.android.sesl.visualeffect.utils.DisplayUtils;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010@\u001a\u00020AH\u0014J\b\u0010B\u001a\u00020AH\u0017J\b\u0010C\u001a\u00020AH\u0003J\b\u0010D\u001a\u00020EH\u0003J\b\u0010F\u001a\u00020AH\u0016J\b\u0010G\u001a\u00020AH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R4\u00105\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000104@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\u001b\u001a\u0004\u0018\u00010:8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/ProcessingEffectView;", "Lcom/samsung/android/sesl/visualeffect/EffectView;", "Lcom/samsung/android/sesl/visualeffect/MaskingSupportedEffectView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sparkleView", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView;", "sparkleController", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleController;", "processingLottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "getProcessingLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setProcessingLottieView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "sparkleAnimationCoroutine", "Lkotlinx/coroutines/Job;", "sparkleColor", "", "getSparkleColor", "()I", "setSparkleColor", "(I)V", "value", "", "sparkleInterval", "getSparkleInterval", "()J", "setSparkleInterval", "(J)V", "sparkleStrength", "", "getSparkleStrength", "()F", "setSparkleStrength", "(F)V", "sparkleSizeScale", "getSparkleSizeScale", "setSparkleSizeScale", "sparkleDuration", "getSparkleDuration", "setSparkleDuration", "sparkleFadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "getSparkleFadeParams", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "setSparkleFadeParams", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;)V", "Ljava/util/function/Consumer;", "onSparkleCountUpdatedListener", "getOnSparkleCountUpdatedListener", "()Ljava/util/function/Consumer;", "setOnSparkleCountUpdatedListener", "(Ljava/util/function/Consumer;)V", "Landroid/graphics/Path;", "maskPath", "getMaskPath", "()Landroid/graphics/Path;", "setMaskPath", "(Landroid/graphics/Path;)V", "initView", "", "startAnimation", "startSparkleAnimation", "createSparkleAnimation", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;", "cancelAnimation", "reset", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ProcessingEffectView extends EffectView implements MaskingSupportedEffectView {
    public static final long SPARKLE_DEFAULT_DURATION = 3100;
    public static final long SPARKLE_DEFAULT_INTERVAL = 470;
    public static final float SPARKLE_DEFAULT_SCALE = 1.0f;
    public static final float SPARKLE_DEFAULT_STRENGTH = 0.45f;
    public static final long SPARKLE_INTERVAL_MINIMUM = 100;

    @Nullable
    private Consumer<Integer> onSparkleCountUpdatedListener;
    public LottieAnimationView processingLottieView;

    @Nullable
    private Job sparkleAnimationCoroutine;
    private int sparkleColor;
    private MultiRippleController sparkleController;
    private long sparkleDuration;

    @RequiresApi(33)
    @NotNull
    private RippleShader.FadeParams sparkleFadeParams;
    private long sparkleInterval;
    private float sparkleSizeScale;
    private float sparkleStrength;
    private MultiRippleView sparkleView;

    /* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.ProcessingEffectView$startSparkleAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.sesl.visualeffect.ProcessingEffectView$startSparkleAnimation$1", m14021f = "ProcessingEffectView.kt", m14022i = {0}, m14023l = {106, 111}, m14024m = "invokeSuspend", m14025n = {"times"}, m14026s = {"I$0"})
    public static final class C78421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        int label;

        public C78421(Continuation<? super C78421> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProcessingEffectView.this.new C78421(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r8, r10) == r0) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0073 -> B:20:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProcessingEffectView processingEffectView;
            int i;
            int i2;
            long sparkleInterval;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                if (ProcessingEffectView.this.getDuration() > 0) {
                    int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (ProcessingEffectView.this.getDuration() / ProcessingEffectView.this.getSparkleInterval()), 1);
                    processingEffectView = ProcessingEffectView.this;
                    i = 0;
                    i2 = iCoerceAtLeast;
                    if (i >= i2) {
                    }
                }
            } else if (i4 == 1) {
                i = this.I$1;
                i2 = this.I$0;
                processingEffectView = (ProcessingEffectView) this.L$0;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i >= i2) {
                    return Unit.INSTANCE;
                }
                MultiRippleController multiRippleController = processingEffectView.sparkleController;
                if (multiRippleController == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sparkleController");
                    multiRippleController = null;
                }
                MultiRippleController.play$default(multiRippleController, processingEffectView.createSparkleAnimation(), null, 2, null);
                long sparkleInterval2 = processingEffectView.getSparkleInterval();
                this.L$0 = processingEffectView;
                this.I$0 = i2;
                this.I$1 = i;
                this.label = 1;
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            do {
                MultiRippleController multiRippleController2 = ProcessingEffectView.this.sparkleController;
                if (multiRippleController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sparkleController");
                    multiRippleController2 = null;
                }
                MultiRippleController.play$default(multiRippleController2, ProcessingEffectView.this.createSparkleAnimation(), null, 2, null);
                sparkleInterval = ProcessingEffectView.this.getSparkleInterval();
                this.label = 2;
            } while (DelayKt.delay(sparkleInterval, this) != coroutine_suspended);
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C78421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessingEffectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sparkleColor = Color.parseColor("#FF0000");
        this.sparkleInterval = 470L;
        this.sparkleStrength = 0.45f;
        this.sparkleSizeScale = 1.0f;
        this.sparkleDuration = SPARKLE_DEFAULT_DURATION;
        this.sparkleFadeParams = new RippleShader.FadeParams(0.0f, 0.5f, 0.15f, 0.0f, 8, null);
        LayoutInflater.from(context).inflate(C7843R.layout.processing_effect_view, this);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    @RequiresApi(33)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RippleAnimation createSparkleAnimation() {
        float f;
        float fNextInt;
        MultiRippleView multiRippleView = this.sparkleView;
        MultiRippleView multiRippleView2 = null;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        if (multiRippleView.getWidth() <= 0) {
            MultiRippleView multiRippleView3 = this.sparkleView;
            if (multiRippleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
                multiRippleView3 = null;
            }
            int width = multiRippleView3.getWidth();
            MultiRippleView multiRippleView4 = this.sparkleView;
            if (multiRippleView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            } else {
                multiRippleView2 = multiRippleView4;
            }
            Log.w(EffectView.TAG, AbstractC0622a.m1164j(width, multiRippleView2.getHeight(), "wrong sparkle view size is detected. (w=", ", h=", ")"));
            f = 0.0f;
            fNextInt = 0.0f;
        } else {
            MultiRippleView multiRippleView5 = this.sparkleView;
            if (multiRippleView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
                multiRippleView5 = null;
            }
            if (multiRippleView5.getHeight() > 0) {
                Random random = new Random();
                MultiRippleView multiRippleView6 = this.sparkleView;
                if (multiRippleView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
                    multiRippleView6 = null;
                }
                float fNextInt2 = random.nextInt(multiRippleView6.getWidth());
                Random random2 = new Random();
                MultiRippleView multiRippleView7 = this.sparkleView;
                if (multiRippleView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
                } else {
                    multiRippleView2 = multiRippleView7;
                }
                f = fNextInt2;
                fNextInt = random2.nextInt(multiRippleView2.getHeight());
            }
        }
        DisplayUtils displayUtils = DisplayUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int iDpToPx = displayUtils.dpToPx(context, 250.0f);
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        float fHypot = (float) Math.hypot(dRandom, dRandom);
        return new RippleAnimation(new RippleAnimationConfig(getRequestedEffectFrameRate(), this.sparkleDuration, f, fNextInt, new Random().nextInt(400) - 200.0f, new Random().nextInt(400) - 200.0f, this.sparkleSizeScale, fHypot, fHypot, 1.3f * getContext().getResources().getDisplayMetrics().density, 0, this.sparkleColor, 0, this.sparkleStrength, null, this.sparkleFadeParams, null, false, false, new PathInterpolator(0.22f, 0.5f, 0.2f, 1.0f), true));
    }

    @RequiresApi(33)
    private final void startSparkleAnimation() {
        MultiRippleView multiRippleView = null;
        this.sparkleAnimationCoroutine = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C78421(null), 3, null);
        MultiRippleView multiRippleView2 = this.sparkleView;
        if (multiRippleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
        } else {
            multiRippleView = multiRippleView2;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(multiRippleView, "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void cancelAnimation() {
        Job job;
        Job job2 = this.sparkleAnimationCoroutine;
        MultiRippleView multiRippleView = null;
        if (job2 != null && job2.isActive() && (job = this.sparkleAnimationCoroutine) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getProcessingLottieView(), "alpha", 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
        MultiRippleView multiRippleView2 = this.sparkleView;
        if (multiRippleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
        } else {
            multiRippleView = multiRippleView2;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(multiRippleView, "alpha", 0.0f);
        objectAnimatorOfFloat2.setDuration(100L);
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat2.start();
        super.cancelAnimation();
    }

    @Override // com.samsung.android.sesl.visualeffect.MaskingSupportedEffectView
    @Nullable
    public Path getMaskPath() {
        MultiRippleView multiRippleView = this.sparkleView;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        return multiRippleView.getMaskPath();
    }

    @Nullable
    public final Consumer<Integer> getOnSparkleCountUpdatedListener() {
        return this.onSparkleCountUpdatedListener;
    }

    @NotNull
    public final LottieAnimationView getProcessingLottieView() {
        LottieAnimationView lottieAnimationView = this.processingLottieView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("processingLottieView");
        return null;
    }

    public final int getSparkleColor() {
        return this.sparkleColor;
    }

    public final long getSparkleDuration() {
        return this.sparkleDuration;
    }

    @NotNull
    public final RippleShader.FadeParams getSparkleFadeParams() {
        return this.sparkleFadeParams;
    }

    public final long getSparkleInterval() {
        return this.sparkleInterval;
    }

    public final float getSparkleSizeScale() {
        return this.sparkleSizeScale;
    }

    public final float getSparkleStrength() {
        return this.sparkleStrength;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void initView() {
        this.sparkleView = (MultiRippleView) findViewById(C7843R.id.sparkle_view);
        MultiRippleView multiRippleView = this.sparkleView;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        this.sparkleController = new MultiRippleController(multiRippleView);
        setProcessingLottieView((LottieAnimationView) findViewById(C7843R.id.lottie_view));
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    public void reset() {
        MultiRippleView multiRippleView = this.sparkleView;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        multiRippleView.setAlpha(0.0f);
        getProcessingLottieView().setAlpha(0.0f);
    }

    @Override // com.samsung.android.sesl.visualeffect.MaskingSupportedEffectView
    public void setMaskPath(@Nullable Path path) {
        MultiRippleView multiRippleView = this.sparkleView;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        multiRippleView.setMaskPath(path);
    }

    public final void setOnSparkleCountUpdatedListener(@Nullable Consumer<Integer> consumer) {
        MultiRippleView multiRippleView = this.sparkleView;
        if (multiRippleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sparkleView");
            multiRippleView = null;
        }
        multiRippleView.setAnimationCountChangeListener(consumer);
        this.onSparkleCountUpdatedListener = consumer;
    }

    public final void setProcessingLottieView(@NotNull LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.processingLottieView = lottieAnimationView;
    }

    public final void setSparkleColor(int i) {
        this.sparkleColor = i;
    }

    public final void setSparkleDuration(long j) {
        this.sparkleDuration = j;
    }

    public final void setSparkleFadeParams(@NotNull RippleShader.FadeParams fadeParams) {
        Intrinsics.checkNotNullParameter(fadeParams, "<set-?>");
        this.sparkleFadeParams = fadeParams;
    }

    public final void setSparkleInterval(long j) {
        if (j <= 100) {
            Log.e(EffectView.TAG, "interval is too low. minimum supported interval is 100");
        }
        this.sparkleInterval = RangesKt.coerceAtLeast(j, 100L);
    }

    public final void setSparkleSizeScale(float f) {
        this.sparkleSizeScale = f;
    }

    public final void setSparkleStrength(float f) {
        this.sparkleStrength = f;
    }

    @Override // com.samsung.android.sesl.visualeffect.EffectView
    @RequiresApi(33)
    public void startAnimation() {
        super.startAnimation();
        startSparkleAnimation();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getProcessingLottieView(), "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
    }
}
