package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J9\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "message", "", "actionLabel", "withDismissAction", "", XmlErrorCodes.DURATION, "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "SnackbarVisualsImpl", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SnackbarHostState {

    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: currentSnackbarData$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState currentSnackbarData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "dismiss", "", "equals", "", "other", "", "hashCode", "", "performAction", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {

        @NotNull
        private final CancellableContinuation<SnackbarResult> continuation;

        @NotNull
        private final SnackbarVisuals visuals;

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(@NotNull SnackbarVisuals visuals, @NotNull CancellableContinuation<? super SnackbarResult> continuation) {
            Intrinsics.checkNotNullParameter(visuals, "visuals");
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.visuals = visuals;
            this.continuation = continuation;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SnackbarDataImpl.class), Reflection.getOrCreateKotlinClass(other.getClass()))) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) other;
            return Intrinsics.areEqual(getVisuals(), snackbarDataImpl.getVisuals()) && Intrinsics.areEqual(this.continuation, snackbarDataImpl.continuation);
        }

        @Override // androidx.compose.material3.SnackbarData
        @NotNull
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public int hashCode() {
            return this.continuation.hashCode() + (getVisuals().hashCode() * 31);
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(SnackbarResult.ActionPerformed));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", XmlErrorCodes.DURATION, "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getMessage", "getWithDismissAction", "()Z", "equals", "other", "", "hashCode", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class SnackbarVisualsImpl implements SnackbarVisuals {

        @Nullable
        private final String actionLabel;

        @NotNull
        private final SnackbarDuration duration;

        @NotNull
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(@NotNull String message, @Nullable String str, boolean z, @NotNull SnackbarDuration duration) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.message = message;
            this.actionLabel = str;
            this.withDismissAction = z;
            this.duration = duration;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(SnackbarVisualsImpl.class), Reflection.getOrCreateKotlinClass(other.getClass()))) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) other;
            return Intrinsics.areEqual(getMessage(), snackbarVisualsImpl.getMessage()) && Intrinsics.areEqual(getActionLabel(), snackbarVisualsImpl.getActionLabel()) && getWithDismissAction() == snackbarVisualsImpl.getWithDismissAction() && getDuration() == snackbarVisualsImpl.getDuration();
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        @Nullable
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        @NotNull
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public int hashCode() {
            int iHashCode = getMessage().hashCode() * 31;
            String actionLabel = getActionLabel();
            return getDuration().hashCode() + AbstractC0622a.m1160f(getWithDismissAction(), (iHashCode + (actionLabel != null ? actionLabel.hashCode() : 0)) * 31, 31);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material3.SnackbarHostState", m14021f = "SnackbarHost.kt", m14022i = {0, 0, 0, 1, 1, 1, 1}, m14023l = {464, 467}, m14024m = "showSnackbar", m14025n = {"this", "visuals", "$this$withLock_u24default$iv", "this", "visuals", "$this$withLock_u24default$iv", "$completion$iv"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class C18702 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C18702(Continuation<? super C18702> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            snackbarDuration = str3 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
        }
        return snackbarHostState.showSnackbar(str, str3, z2, snackbarDuration, continuation);
    }

    @Nullable
    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData.getValue();
    }

    @Nullable
    public final Object showSnackbar(@NotNull String str, @Nullable String str2, boolean z, @NotNull SnackbarDuration snackbarDuration, @NotNull Continuation<? super SnackbarResult> continuation) {
        return showSnackbar(new SnackbarVisualsImpl(str, str2, z, snackbarDuration), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @ExperimentalMaterial3Api
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showSnackbar(@NotNull SnackbarVisuals snackbarVisuals, @NotNull Continuation<? super SnackbarResult> continuation) {
        C18702 c18702;
        Mutex mutex;
        SnackbarHostState snackbarHostState;
        SnackbarVisuals snackbarVisuals2;
        Throwable th;
        SnackbarHostState snackbarHostState2;
        Mutex mutex2;
        if (continuation instanceof C18702) {
            c18702 = (C18702) continuation;
            int i = c18702.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c18702.label = i - Integer.MIN_VALUE;
            } else {
                c18702 = new C18702(continuation);
            }
        }
        Object obj = c18702.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c18702.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.mutex;
                    c18702.L$0 = this;
                    c18702.L$1 = snackbarVisuals;
                    c18702.L$2 = mutex;
                    c18702.label = 1;
                    if (mutex.lock(null, c18702) != coroutine_suspended) {
                        snackbarHostState = this;
                        snackbarVisuals2 = snackbarVisuals;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) c18702.L$2;
                    snackbarHostState2 = (SnackbarHostState) c18702.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        snackbarHostState2.setCurrentSnackbarData(null);
                        mutex2.unlock(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        snackbarHostState2.setCurrentSnackbarData(null);
                        throw th;
                    }
                }
                Mutex mutex3 = (Mutex) c18702.L$2;
                SnackbarVisuals snackbarVisuals3 = (SnackbarVisuals) c18702.L$1;
                snackbarHostState = (SnackbarHostState) c18702.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                snackbarVisuals2 = snackbarVisuals3;
                c18702.L$0 = snackbarHostState;
                c18702.L$1 = snackbarVisuals2;
                c18702.L$2 = mutex;
                c18702.L$3 = c18702;
                c18702.label = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c18702), 1);
                cancellableContinuationImpl.initCancellability();
                snackbarHostState.setCurrentSnackbarData(new SnackbarDataImpl(snackbarVisuals2, cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c18702);
                }
                if (result != coroutine_suspended) {
                    Mutex mutex4 = mutex;
                    obj = result;
                    mutex2 = mutex4;
                    snackbarHostState2 = snackbarHostState;
                    snackbarHostState2.setCurrentSnackbarData(null);
                    mutex2.unlock(null);
                    return obj;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                snackbarHostState2 = snackbarHostState;
                snackbarHostState2.setCurrentSnackbarData(null);
                throw th;
            }
        } catch (Throwable th4) {
            snackbarVisuals.unlock(null);
            throw th4;
        }
    }
}
