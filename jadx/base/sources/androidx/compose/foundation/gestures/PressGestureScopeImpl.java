package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0015\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u0018*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u0017H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010#J\u0017\u0010$\u001a\u00020%*\u00020&H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u0005*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010\"J\u0017\u0010)\u001a\u00020\u0005*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 J\r\u0010,\u001a\u00020-*\u00020.H\u0097\u0001J\u0017\u0010/\u001a\u00020&*\u00020%H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010(J\u0017\u00101\u001a\u00020\u001b*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001a\u00101\u001a\u00020\u001b*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00103J\u001a\u00101\u001a\u00020\u001b*\u00020\u0017H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, m13886d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "(Landroidx/compose/ui/unit/Density;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "isCanceled", "", "isReleased", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "reset", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PressGestureScopeImpl implements PressGestureScope, Density {
    public static final int $stable = 0;
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;

    @NotNull
    private final Mutex mutex = MutexKt.Mutex(false);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", m14021f = "TapGestureDetector.kt", m14022i = {}, m14023l = {363}, m14024m = "awaitRelease", m14025n = {}, m14026s = {})
    public static final class C09001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C09001(Continuation<? super C09001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.awaitRelease(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", m14021f = "TapGestureDetector.kt", m14022i = {0}, m14023l = {357}, m14024m = "reset", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C09011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09011(Continuation<? super C09011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", m14021f = "TapGestureDetector.kt", m14022i = {0}, m14023l = {370}, m14024m = "tryAwaitRelease", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C09021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09021(Continuation<? super C09021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.tryAwaitRelease(this);
        }
    }

    public PressGestureScopeImpl(@NotNull Density density) {
        this.$$delegate_0 = density;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitRelease(@NotNull Continuation<? super Unit> continuation) {
        C09001 c09001;
        if (continuation instanceof C09001) {
            c09001 = (C09001) continuation;
            int i = c09001.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09001.label = i - Integer.MIN_VALUE;
            } else {
                c09001 = new C09001(continuation);
            }
        }
        Object objTryAwaitRelease = c09001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09001.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objTryAwaitRelease);
            c09001.label = 1;
            objTryAwaitRelease = tryAwaitRelease(c09001);
            if (objTryAwaitRelease == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objTryAwaitRelease);
        }
        if (((Boolean) objTryAwaitRelease).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new GestureCancellationException("The press gesture was canceled.");
    }

    public final void cancel() {
        this.isCanceled = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reset(@NotNull Continuation<? super Unit> continuation) {
        C09011 c09011;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof C09011) {
            c09011 = (C09011) continuation;
            int i = c09011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09011.label = i - Integer.MIN_VALUE;
            } else {
                c09011 = new C09011(continuation);
            }
        }
        Object obj = c09011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09011.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex = this.mutex;
            c09011.L$0 = this;
            c09011.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c09011, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pressGestureScopeImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pressGestureScopeImpl = (PressGestureScopeImpl) c09011.L$0;
            ResultKt.throwOnFailure(obj);
        }
        pressGestureScopeImpl.isReleased = false;
        pressGestureScopeImpl.isCanceled = false;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo15539roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo15539roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo15540roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo15540roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo15541toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo15541toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15542toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo15542toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo15544toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo15544toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo15545toPxR2X_6o(long j) {
        return this.$$delegate_0.mo15545toPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo15546toPx0680j_4(float f) {
        return this.$$delegate_0.mo15546toPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo15547toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo15547toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo15548toSp0xMU5do(float f) {
        return this.$$delegate_0.mo15548toSp0xMU5do(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15549toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo15549toSpkPz2Gy4(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object tryAwaitRelease(@NotNull Continuation<? super Boolean> continuation) {
        C09021 c09021;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof C09021) {
            c09021 = (C09021) continuation;
            int i = c09021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09021.label = i - Integer.MIN_VALUE;
            } else {
                c09021 = new C09021(continuation);
            }
        }
        Object obj = c09021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09021.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isReleased || this.isCanceled) {
                pressGestureScopeImpl = this;
                return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
            }
            Mutex mutex = this.mutex;
            c09021.L$0 = this;
            c09021.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c09021, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pressGestureScopeImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pressGestureScopeImpl = (PressGestureScopeImpl) c09021.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Mutex.DefaultImpls.unlock$default(pressGestureScopeImpl.mutex, null, 1, null);
        return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15543toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo15543toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15550toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo15550toSpkPz2Gy4(i);
    }
}
