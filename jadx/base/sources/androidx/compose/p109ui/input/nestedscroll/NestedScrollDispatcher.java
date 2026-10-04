package androidx.compose.p109ui.input.nestedscroll;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.unit.Velocity;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J(\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m13886d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "()V", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scope", "getScope$ui_release", "setScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "dispatchPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreScroll", "dispatchPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;

    @NotNull
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final CoroutineScope invoke() {
            return this.this$0.getScope();
        }
    };

    @Nullable
    private NestedScrollNode nestedScrollNode;

    @Nullable
    private CoroutineScope scope;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Nullable
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m19602dispatchPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        long jM21216getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            int i = nestedScrollDispatcher$dispatchPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
            }
        }
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$12 = nestedScrollDispatcher$dispatchPostFling$1;
        Object objMo15655onPostFlingRZ2iAVY = nestedScrollDispatcher$dispatchPostFling$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollDispatcher$dispatchPostFling$12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
            NestedScrollConnection parent$ui_release = getParent$ui_release();
            if (parent$ui_release == null) {
                jM21216getZero9UxMQ8M = Velocity.INSTANCE.m21216getZero9UxMQ8M();
                return Velocity.m21196boximpl(jM21216getZero9UxMQ8M);
            }
            nestedScrollDispatcher$dispatchPostFling$12.label = 1;
            objMo15655onPostFlingRZ2iAVY = parent$ui_release.mo15655onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$12);
            if (objMo15655onPostFlingRZ2iAVY == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
        }
        jM21216getZero9UxMQ8M = ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue();
        return Velocity.m21196boximpl(jM21216getZero9UxMQ8M);
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m19603dispatchPostScrollDzOQY0M(long consumed, long available, int source) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo15656onPostScrollDzOQY0M(consumed, available, source) : Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m19604dispatchPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long jM21216getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            int i = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
            }
        }
        Object objMo15929onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo15929onPreFlingQWom1Mo);
            NestedScrollConnection parent$ui_release = getParent$ui_release();
            if (parent$ui_release == null) {
                jM21216getZero9UxMQ8M = Velocity.INSTANCE.m21216getZero9UxMQ8M();
                return Velocity.m21196boximpl(jM21216getZero9UxMQ8M);
            }
            nestedScrollDispatcher$dispatchPreFling$1.label = 1;
            objMo15929onPreFlingQWom1Mo = parent$ui_release.mo15929onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
            if (objMo15929onPreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo15929onPreFlingQWom1Mo);
        }
        jM21216getZero9UxMQ8M = ((Velocity) objMo15929onPreFlingQWom1Mo).getPackedValue();
        return Velocity.m21196boximpl(jM21216getZero9UxMQ8M);
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m19605dispatchPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo15930onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    @NotNull
    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScopeInvoke = this.calculateNestedScrollScope.invoke();
        if (coroutineScopeInvoke != null) {
            return coroutineScopeInvoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Nullable
    /* JADX INFO: renamed from: getNestedScrollNode$ui_release, reason: from getter */
    public final NestedScrollNode getNestedScrollNode() {
        return this.nestedScrollNode;
    }

    @Nullable
    public final NestedScrollConnection getParent$ui_release() {
        NestedScrollNode nestedScrollNode = this.nestedScrollNode;
        if (nestedScrollNode != null) {
            return nestedScrollNode.getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: getScope$ui_release, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui_release(@NotNull Function0<? extends CoroutineScope> function0) {
        this.calculateNestedScrollScope = function0;
    }

    public final void setNestedScrollNode$ui_release(@Nullable NestedScrollNode nestedScrollNode) {
        this.nestedScrollNode = nestedScrollNode;
    }

    public final void setScope$ui_release(@Nullable CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }
}
