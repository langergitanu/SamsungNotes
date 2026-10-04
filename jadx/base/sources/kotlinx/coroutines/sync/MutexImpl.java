package kotlinx.coroutines.sync;

import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.C7868a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.MutexImpl;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002-.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010!\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010(\u001a\u00020\u00152\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0014J\u001e\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004R{\u0010\n\u001am\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\f0\fj\u0002`\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R(\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020#8VX\u0096\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006/"}, m13886d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "<init>", "(Z)V", "owner", "Lkotlinx/atomicfu/AtomicRef;", "", "onSelectCancellationUnlockConstructor", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", Bixby2Constants.BIXBY_PARAM_SELECT, "param", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "", "Lkotlin/jvm/functions/Function3;", "isLocked", "()Z", "holdsLock", "holdsLockImpl", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "tryLock", "tryLockImpl", "unlock", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLockRegFunction", "onLockProcessResult", "result", "toString", "", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n369#2,12:315\n1#3:327\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n171#1:315,12\n*E\n"})
public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    private static final /* synthetic */ AtomicReferenceFieldUpdater owner$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");

    @NotNull
    private final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> onSelectCancellationUnlockConstructor;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJz\u0010\n\u001a\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u0002H\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00072M\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0016Jn\u0010\u0017\u001a\u00020\u0002\"\b\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u0002H\u000b2M\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0007H\u0097\u0001J\t\u0010\u001d\u001a\u00020\u0002H\u0097\u0001J2\u0010\u001e\u001a\u00020\u00022'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020!j\u0002` H\u0096\u0001J\u001d\u0010\u001e\u001a\u00020\u00022\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010$\u001a\u00020%H\u0096\u0001J6\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010!H\u0097\u0001J\u0015\u0010&\u001a\u00020\u0002*\u00020'2\u0006\u0010\f\u001a\u00020\u0002H\u0097\u0001J\u0015\u0010(\u001a\u00020\u0002*\u00020'2\u0006\u0010)\u001a\u00020\u0010H\u0097\u0001J\u0017\u0010*\u001a\u00020\u00022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,H\u0096\u0001J\u001d\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0097\u0001J\u0013\u0010-\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u0010H\u0097\u0001R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0015\u001a\u00020\u0014X\u0096\u0005R\t\u0010.\u001a\u00020\u001aX\u0096\u0005R\t\u0010/\u001a\u00020\u001aX\u0096\u0005R\t\u00100\u001a\u00020\u001aX\u0096\u0005¨\u00061"}, m13886d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "owner", "", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "tryResume", "R", "value", "idempotent", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "resume", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function3;)V", "cancel", "", "completeResume", ResponseType.TOKEN, "initCancellability", "invokeOnCancellation", "handler", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function1;", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatchedWithException", "exception", "resumeWith", "result", "Lkotlin/Result;", "tryResumeWithException", "isActive", "isCancelled", "isCompleted", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n1#2:315\n*E\n"})
    public final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {

        @JvmField
        @NotNull
        public final CancellableContinuationImpl<Unit> cont;

        @JvmField
        @Nullable
        public final Object owner;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(@NotNull CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, @Nullable Object obj) {
            this.cont = cancellableContinuationImpl;
            this.owner = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit resume$lambda$6(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner, Throwable th) {
            mutexImpl.unlock(cancellableContinuationWithOwner.owner);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit tryResume$lambda$3(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner, Throwable th, Unit unit, CoroutineContext coroutineContext) {
            MutexImpl.getOwner$volatile$FU().set(mutexImpl, cancellableContinuationWithOwner.owner);
            mutexImpl.unlock(cancellableContinuationWithOwner.owner);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(@Nullable Throwable cause) {
            return this.cont.cancel(cause);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @InternalCoroutinesApi
        public void completeResume(@NotNull Object token) {
            this.cont.completeResume(token);
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @InternalCoroutinesApi
        public void initCancellability() {
            this.cont.initCancellability();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> handler) {
            this.cont.invokeOnCancellation(handler);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCancelled() {
            return this.cont.isCancelled();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use the overload that also accepts the `value` and the coroutine context in lambda", replaceWith = @ReplaceWith(expression = "resume(value) { cause, _, _ -> onCancellation(cause) }", imports = {}))
        /* JADX INFO: renamed from: resume, reason: avoid collision after fix types in other method */
        public void resume2(@NotNull Unit unit, @Nullable Function1<? super Throwable, Unit> function1) {
            this.cont.resume(unit, function1);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @ExperimentalCoroutinesApi
        public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Unit unit) {
            this.cont.resumeUndispatched(coroutineDispatcher, unit);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @ExperimentalCoroutinesApi
        public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
            this.cont.resumeUndispatchedWithException(coroutineDispatcher, th);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object obj) {
            this.cont.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @InternalCoroutinesApi
        @Nullable
        public Object tryResume(@NotNull Unit unit, @Nullable Object obj) {
            return this.cont.tryResume(unit, obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @InternalCoroutinesApi
        @Nullable
        public Object tryResumeWithException(@NotNull Throwable exception) {
            return this.cont.tryResumeWithException(exception);
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.cont.invokeOnCancellation(segment, index);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ void resume(Unit unit, Function1 function1) {
            resume2(unit, (Function1<? super Throwable, Unit>) function1);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ void resume(Object obj, Function3 function3) {
            resume((Unit) obj, (Function3<? super Throwable, ? super Unit, ? super CoroutineContext, Unit>) function3);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ Object tryResume(Object obj, Object obj2, Function3 function3) {
            return tryResume((Unit) obj, obj2, (Function3<? super Throwable, ? super Unit, ? super CoroutineContext, Unit>) function3);
        }

        public <R extends Unit> void resume(@NotNull R value, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
            MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            CancellableContinuationImpl<Unit> cancellableContinuationImpl = this.cont;
            final MutexImpl mutexImpl = MutexImpl.this;
            cancellableContinuationImpl.resume(value, new Function1() { // from class: kotlinx.coroutines.sync.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MutexImpl.CancellableContinuationWithOwner.resume$lambda$6(mutexImpl, this, (Throwable) obj);
                }
            });
        }

        @Nullable
        public <R extends Unit> Object tryResume(@NotNull R value, @Nullable Object idempotent, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
            Object objTryResume = this.cont.tryResume(value, idempotent, new C13471a(MutexImpl.this, this, 0));
            if (objTryResume != null) {
                MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            }
            return objTryResume;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u001d\u0010\u0012\u001a\u00020\r2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0017\u001a\u00020\u0018X\u0096\u0005¨\u0006\u0019"}, m13886d2 = {"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", Bixby2Constants.BIXBY_PARAM_SELECT, "owner", "", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "trySelect", "", "clauseObject", "result", "selectInRegistrationPhase", "", "internalResult", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n1#2:315\n*E\n"})
    public final class SelectInstanceWithOwner<Q> implements SelectInstanceInternal<Q> {

        @JvmField
        @Nullable
        public final Object owner;

        @JvmField
        @NotNull
        public final SelectInstanceInternal<Q> select;

        public SelectInstanceWithOwner(@NotNull SelectInstanceInternal<Q> selectInstanceInternal, @Nullable Object obj) {
            this.select = selectInstanceInternal;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
            this.select.disposeOnCompletion(disposableHandle);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        @NotNull
        public CoroutineContext getContext() {
            return this.select.getContext();
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.select.invokeOnCancellation(segment, index);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public void selectInRegistrationPhase(@Nullable Object internalResult) {
            MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            this.select.selectInRegistrationPhase(internalResult);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public boolean trySelect(@NotNull Object clauseObject, @Nullable Object result) {
            boolean zTrySelect = this.select.trySelect(clauseObject, result);
            MutexImpl mutexImpl = MutexImpl.this;
            if (zTrySelect) {
                MutexImpl.getOwner$volatile$FU().set(mutexImpl, this.owner);
            }
            return zTrySelect;
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        this.owner$volatile = z ? null : MutexKt.NO_OWNER;
        this.onSelectCancellationUnlockConstructor = new C7868a(this, 5);
    }

    private final /* synthetic */ Object getOwner$volatile() {
        return this.owner$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getOwner$volatile$FU() {
        return owner$volatile$FU;
    }

    private final int holdsLockImpl(Object owner) {
        while (isLocked()) {
            Object obj = owner$volatile$FU.get(this);
            if (obj != MutexKt.NO_OWNER) {
                return obj == owner ? 1 : 2;
            }
        }
        return 0;
    }

    public static /* synthetic */ Object lock$suspendImpl(MutexImpl mutexImpl, Object obj, Continuation<? super Unit> continuation) {
        if (mutexImpl.tryLock(obj)) {
            return Unit.INSTANCE;
        }
        Object objLockSuspend = mutexImpl.lockSuspend(obj, continuation);
        return objLockSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLockSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object lockSuspend(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            acquire((CancellableContinuation<? super Unit>) new CancellableContinuationWithOwner(orCreateCancellableContinuation, obj));
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 onSelectCancellationUnlockConstructor$lambda$1(MutexImpl mutexImpl, SelectInstance selectInstance, Object obj, Object obj2) {
        return new C13471a(mutexImpl, obj, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelectCancellationUnlockConstructor$lambda$1$lambda$0(MutexImpl mutexImpl, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        mutexImpl.unlock(obj);
        return Unit.INSTANCE;
    }

    private final /* synthetic */ void setOwner$volatile(Object obj) {
        this.owner$volatile = obj;
    }

    private final int tryLockImpl(Object owner) {
        while (!tryAcquire()) {
            if (owner == null) {
                return 1;
            }
            int iHoldsLockImpl = holdsLockImpl(owner);
            if (iHoldsLockImpl == 1) {
                return 2;
            }
            if (iHoldsLockImpl == 2) {
                return 1;
            }
        }
        owner$volatile$FU.set(this, owner);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @NotNull
    public SelectClause2<Object, Mutex> getOnLock() {
        MutexImpl$onLock$1 mutexImpl$onLock$1 = MutexImpl$onLock$1.INSTANCE;
        Intrinsics.checkNotNull(mutexImpl$onLock$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(mutexImpl$onLock$1, 3);
        MutexImpl$onLock$2 mutexImpl$onLock$2 = MutexImpl$onLock$2.INSTANCE;
        Intrinsics.checkNotNull(mutexImpl$onLock$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(mutexImpl$onLock$2, 3), this.onSelectCancellationUnlockConstructor);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(@NotNull Object owner) {
        return holdsLockImpl(owner) == 1;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        return getAvailablePermits() == 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        return lock$suspendImpl(this, obj, continuation);
    }

    @Nullable
    public Object onLockProcessResult(@Nullable Object owner, @Nullable Object result) {
        if (!Intrinsics.areEqual(result, MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
    }

    public void onLockRegFunction(@NotNull SelectInstance<?> select, @Nullable Object owner) {
        if (owner != null && holdsLock(owner)) {
            select.selectInRegistrationPhase(MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER);
        } else {
            Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            onAcquireRegFunction(new SelectInstanceWithOwner((SelectInstanceInternal) select, owner), owner);
        }
    }

    @NotNull
    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + owner$volatile$FU.get(this) + PropertyUtils.INDEXED_DELIM2;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@Nullable Object owner) {
        int iTryLockImpl = tryLockImpl(owner);
        if (iTryLockImpl == 0) {
            return true;
        }
        if (iTryLockImpl == 1) {
            return false;
        }
        if (iTryLockImpl != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(@Nullable Object owner) {
        while (isLocked()) {
            Object obj = owner$volatile$FU.get(this);
            if (obj != MutexKt.NO_OWNER) {
                if (obj != owner && owner != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj + ", but " + owner + " is expected").toString());
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = owner$volatile$FU;
                Symbol symbol = MutexKt.NO_OWNER;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                release();
                return;
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public static /* synthetic */ void getOnLock$annotations() {
    }
}
