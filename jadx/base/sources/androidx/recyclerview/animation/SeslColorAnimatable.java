package androidx.recyclerview.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.animation.SeslAnimatable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/recyclerview/animation/SeslColorAnimatable;", "Lkotlinx/coroutines/DisposableHandle;", "Landroidx/recyclerview/animation/SeslAnimatable;", "", "initialValue", "defaultAnimationSpec", "Landroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;", "onValueUpdated", "Lkotlin/Function1;", "", "(ILandroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "animateTo", "targetValue", "animationSpec", "(ILandroidx/recyclerview/animation/SeslAnimatable$AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSeslColorAnimatable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeslColorAnimatable.kt\nandroidx/recyclerview/animation/SeslColorAnimatable\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,51:1\n314#2,9:52\n323#2,2:80\n29#3:61\n85#3,18:62\n*S KotlinDebug\n*F\n+ 1 SeslColorAnimatable.kt\nandroidx/recyclerview/animation/SeslColorAnimatable\n*L\n29#1:52,9\n29#1:80,2\n41#1:61\n41#1:62,18\n*E\n"})
public final class SeslColorAnimatable extends SeslAnimatable<Integer> implements DisposableHandle {

    @NotNull
    private final Function1<Integer, Unit> onValueUpdated;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SeslColorAnimatable(int i, @NotNull SeslAnimatable.AnimationSpec defaultAnimationSpec, @NotNull Function1<? super Integer, Unit> onValueUpdated) {
        super(Integer.valueOf(i), defaultAnimationSpec);
        Intrinsics.checkNotNullParameter(defaultAnimationSpec, "defaultAnimationSpec");
        Intrinsics.checkNotNullParameter(onValueUpdated, "onValueUpdated");
        this.onValueUpdated = onValueUpdated;
    }

    @Override // androidx.recyclerview.animation.SeslAnimatable
    public /* bridge */ /* synthetic */ Object animateTo(Integer num, SeslAnimatable.AnimationSpec animationSpec, Continuation continuation) {
        return animateTo(num.intValue(), animationSpec, (Continuation<? super Unit>) continuation);
    }

    @RequiresApi(21)
    @Nullable
    public Object animateTo(int i, @NotNull SeslAnimatable.AnimationSpec animationSpec, @NotNull Continuation<? super Unit> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.recyclerview.animation.SeslColorAnimatable$animateTo$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.this$0.dispose();
            }
        });
        dispose();
        if (getValue().intValue() != i) {
            ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(getValue().intValue(), i);
            Intrinsics.checkNotNullExpressionValue(valueAnimatorOfArgb, "this");
            animationSpec.invoke(valueAnimatorOfArgb);
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.animation.SeslColorAnimatable$animateTo$2$2$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function1 function1 = this.this$0.onValueUpdated;
                    Object animatedValue = it.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                    function1.invoke((Integer) animatedValue);
                }
            });
            valueAnimatorOfArgb.addListener(new Animator.AnimatorListener() { // from class: androidx.recyclerview.animation.SeslColorAnimatable$animateTo$lambda$2$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Unit unit = Unit.INSTANCE;
                    final SeslColorAnimatable seslColorAnimatable = this;
                    cancellableContinuation.resume(unit, new Function1<Throwable, Unit>() { // from class: androidx.recyclerview.animation.SeslColorAnimatable$animateTo$2$2$2$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            seslColorAnimatable.dispose();
                        }
                    });
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            setAnimator(valueAnimatorOfArgb);
            valueAnimatorOfArgb.start();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
