package androidx.compose.foundation.lazy.layout;

import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifier;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAwaitFirstLayoutModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitFirstLayoutModifier.kt\nandroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public static final int $stable = 0;

    @Nullable
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier", m14021f = "AwaitFirstLayoutModifier.kt", m14022i = {0, 0}, m14023l = {35}, m14024m = "waitForFirstLayout", m14025n = {"this", "oldContinuation"}, m14026s = {"L$0", "L$1"})
    public static final class C11111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11111(Continuation<? super C11111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitFirstLayoutModifier.this.waitForFirstLayout(this);
        }
    }

    @Override // androidx.compose.p109ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        if (this.wasPositioned) {
            return;
        }
        this.wasPositioned = true;
        Continuation<? super Unit> continuation = this.continuation;
        if (continuation != null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
        this.continuation = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForFirstLayout(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        C11111 c11111;
        Continuation<? super Unit> continuation2;
        if (continuation instanceof C11111) {
            c11111 = (C11111) continuation;
            int i = c11111.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c11111.label = i - Integer.MIN_VALUE;
            } else {
                c11111 = new C11111(continuation);
            }
        }
        Object obj = c11111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11111.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.wasPositioned) {
                Continuation<? super Unit> continuation3 = this.continuation;
                c11111.L$0 = this;
                c11111.L$1 = continuation3;
                c11111.label = 1;
                SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c11111));
                this.continuation = safeContinuation;
                Object orThrow = safeContinuation.getOrThrow();
                if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c11111);
                }
                if (orThrow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                continuation2 = continuation3;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        continuation2 = (Continuation) c11111.L$1;
        ResultKt.throwOnFailure(obj);
        if (continuation2 != null) {
            Result.Companion companion = Result.INSTANCE;
            continuation2.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }
}
