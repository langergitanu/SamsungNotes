package androidx.recyclerview.animation;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003!\"#B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00028\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00028\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, m13886d2 = {"Landroidx/recyclerview/animation/SeslAnimatable;", "T", "", "Lkotlinx/coroutines/DisposableHandle;", "initialValue", "defaultAnimationSpec", "Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;", "(Ljava/lang/Object;Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "Ljava/lang/Object;", "value", "getValue", "()Ljava/lang/Object;", "animateTo", "", "targetValue", "animationSpec", "(Ljava/lang/Object;Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAnimateTo", "Lkotlinx/coroutines/Job;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/lang/Object;Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/Job;", "trySnapTo", "(Ljava/lang/Object;Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/Job;", "AnimationSpec", "SimpleAnimationSpec", "SnapAnimationSpec", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class SeslAnimatable<T> implements DisposableHandle {

    @Nullable
    private ValueAnimator animator;

    @NotNull
    private final AnimationSpec defaultAnimationSpec;

    @NotNull
    private final T initialValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m13886d2 = {"Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;", "", "invoke", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface AnimationSpec {
        void invoke(@NotNull ValueAnimator valueAnimator);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, m13886d2 = {"Landroidx/recyclerview/animation/SeslAnimatable$SimpleAnimationSpec;", "Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;", XmlErrorCodes.DURATION, "", "interpolator", "Landroid/view/animation/Interpolator;", "(JLandroid/view/animation/Interpolator;)V", "getDuration", "()J", "getInterpolator", "()Landroid/view/animation/Interpolator;", "invoke", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SimpleAnimationSpec implements AnimationSpec {
        private final long duration;

        @NotNull
        private final Interpolator interpolator;

        public SimpleAnimationSpec(long j, @NotNull Interpolator interpolator) {
            Intrinsics.checkNotNullParameter(interpolator, "interpolator");
            this.duration = j;
            this.interpolator = interpolator;
        }

        public final long getDuration() {
            return this.duration;
        }

        @NotNull
        public final Interpolator getInterpolator() {
            return this.interpolator;
        }

        @Override // androidx.recyclerview.animation.SeslAnimatable.AnimationSpec
        public void invoke(@NotNull ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
            valueAnimator.setDuration(this.duration);
            valueAnimator.setInterpolator(this.interpolator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m13886d2 = {"Landroidx/recyclerview/animation/SeslAnimatable$SnapAnimationSpec;", "Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;", "()V", "invoke", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SnapAnimationSpec implements AnimationSpec {

        @NotNull
        public static final SnapAnimationSpec INSTANCE = new SnapAnimationSpec();

        private SnapAnimationSpec() {
        }

        @Override // androidx.recyclerview.animation.SeslAnimatable.AnimationSpec
        public void invoke(@NotNull ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
            valueAnimator.setDuration(0L);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.animation.SeslAnimatable$tryAnimateTo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.recyclerview.animation.SeslAnimatable$tryAnimateTo$1", m14021f = "SeslAnimatable.kt", m14022i = {}, m14023l = {36}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C37291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec $animationSpec;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ SeslAnimatable<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37291(SeslAnimatable<T> seslAnimatable, T t, AnimationSpec animationSpec, Continuation<? super C37291> continuation) {
            super(2, continuation);
            this.this$0 = seslAnimatable;
            this.$targetValue = t;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37291(this.this$0, this.$targetValue, this.$animationSpec, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SeslAnimatable<T> seslAnimatable = this.this$0;
                T t = this.$targetValue;
                AnimationSpec animationSpec = this.$animationSpec;
                this.label = 1;
                if (seslAnimatable.animateTo(t, animationSpec, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C37291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.animation.SeslAnimatable$trySnapTo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.recyclerview.animation.SeslAnimatable$trySnapTo$1", m14021f = "SeslAnimatable.kt", m14022i = {}, m14023l = {61}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C37301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ SeslAnimatable<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37301(SeslAnimatable<T> seslAnimatable, T t, Continuation<? super C37301> continuation) {
            super(2, continuation);
            this.this$0 = seslAnimatable;
            this.$targetValue = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37301(this.this$0, this.$targetValue, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SeslAnimatable<T> seslAnimatable = this.this$0;
                T t = this.$targetValue;
                this.label = 1;
                if (seslAnimatable.snapTo(t, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C37301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SeslAnimatable(@NotNull T initialValue, @NotNull AnimationSpec defaultAnimationSpec) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(defaultAnimationSpec, "defaultAnimationSpec");
        this.initialValue = initialValue;
        this.defaultAnimationSpec = defaultAnimationSpec;
    }

    public static /* synthetic */ Object animateTo$default(SeslAnimatable seslAnimatable, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = seslAnimatable.defaultAnimationSpec;
        }
        return seslAnimatable.animateTo(obj, animationSpec, continuation);
    }

    public static /* synthetic */ Job tryAnimateTo$default(SeslAnimatable seslAnimatable, Object obj, AnimationSpec animationSpec, CoroutineDispatcher coroutineDispatcher, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryAnimateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = seslAnimatable.defaultAnimationSpec;
        }
        if ((i & 4) != 0) {
            coroutineDispatcher = Dispatchers.getMain().getImmediate();
        }
        return seslAnimatable.tryAnimateTo(obj, animationSpec, coroutineDispatcher);
    }

    public static /* synthetic */ Job trySnapTo$default(SeslAnimatable seslAnimatable, Object obj, CoroutineDispatcher coroutineDispatcher, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trySnapTo");
        }
        if ((i & 2) != 0) {
            coroutineDispatcher = Dispatchers.getMain().getImmediate();
        }
        return seslAnimatable.trySnapTo(obj, coroutineDispatcher);
    }

    @Nullable
    public abstract Object animateTo(@NotNull T t, @NotNull AnimationSpec animationSpec, @NotNull Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Nullable
    public final ValueAnimator getAnimator() {
        return this.animator;
    }

    @NotNull
    public final T getValue() {
        ValueAnimator valueAnimator = this.animator;
        T t = null;
        Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
        if (animatedValue != null) {
            t = (T) animatedValue;
        }
        return t == null ? this.initialValue : t;
    }

    public final void setAnimator(@Nullable ValueAnimator valueAnimator) {
        this.animator = valueAnimator;
    }

    @Nullable
    public final Object snapTo(@NotNull T t, @NotNull Continuation<? super Unit> continuation) {
        Object objAnimateTo = animateTo(t, SnapAnimationSpec.INSTANCE, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    @JvmOverloads
    @NotNull
    public final Job tryAnimateTo(@NotNull T targetValue) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        return tryAnimateTo$default(this, targetValue, null, null, 6, null);
    }

    @JvmOverloads
    @NotNull
    public final Job trySnapTo(@NotNull T targetValue) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        return trySnapTo$default(this, targetValue, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Job tryAnimateTo(@NotNull T targetValue, @NotNull AnimationSpec animationSpec) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return tryAnimateTo$default(this, targetValue, animationSpec, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final Job trySnapTo(@NotNull T targetValue, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new C37301(this, targetValue, null), 3, null);
    }

    @JvmOverloads
    @NotNull
    public final Job tryAnimateTo(@NotNull T targetValue, @NotNull AnimationSpec animationSpec, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new C37291(this, targetValue, animationSpec, null), 3, null);
    }
}
