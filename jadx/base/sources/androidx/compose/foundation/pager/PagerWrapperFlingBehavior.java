package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class PagerWrapperFlingBehavior implements FlingBehavior {

    @NotNull
    private final TargetedFlingBehavior originalFlingBehavior;

    @NotNull
    private final PagerState pagerState;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.pager.PagerWrapperFlingBehavior", m14021f = "LazyLayoutPager.kt", m14022i = {}, m14023l = {383}, m14024m = "performFling", m14025n = {}, m14026s = {})
    public static final class C11861 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C11861(Continuation<? super C11861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerWrapperFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    public PagerWrapperFlingBehavior(@NotNull TargetedFlingBehavior targetedFlingBehavior, @NotNull PagerState pagerState) {
        this.originalFlingBehavior = targetedFlingBehavior;
        this.pagerState = pagerState;
    }

    @NotNull
    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    @NotNull
    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(@NotNull final ScrollScope scrollScope, float f, @NotNull Continuation<? super Float> continuation) {
        C11861 c11861;
        if (continuation instanceof C11861) {
            c11861 = (C11861) continuation;
            int i = c11861.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c11861.label = i - Integer.MIN_VALUE;
            } else {
                c11861 = new C11861(continuation);
            }
        }
        Object objPerformFling = c11861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11861.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objPerformFling);
            TargetedFlingBehavior targetedFlingBehavior = this.originalFlingBehavior;
            Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f4) {
                    invoke(f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f4) {
                    this.this$0.getPagerState().updateTargetPage(scrollScope, this.this$0.getPagerState().getCurrentPage() + MathKt.roundToInt(this.this$0.getPagerState().getPageSizeWithSpacing$foundation_release() != 0 ? f4 / this.this$0.getPagerState().getPageSizeWithSpacing$foundation_release() : 0.0f));
                }
            };
            c11861.label = 1;
            objPerformFling = targetedFlingBehavior.performFling(scrollScope, f, function1, c11861);
            if (objPerformFling == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objPerformFling);
        }
        return Boxing.boxFloat(((Number) objPerformFling).floatValue());
    }
}
