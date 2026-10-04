package kotlinx.coroutines;

import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.C7868a;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0005j\u0002`\u00042\u00020\u0006B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0001J\u0015\u00100\u001a\n\u0018\u000102j\u0004\u0018\u0001`1H\u0016¢\u0006\u0002\u00103J\u000f\u00104\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0002\b5J\u001f\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u00010\u00172\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\b:J\u0010\u0010;\u001a\u00020!2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010<\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0015\u0010=\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0000¢\u0006\u0002\b>J\u0017\u0010?\u001a\u00020*2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020*0AH\u0082\bJ\u0018\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\b\u00108\u001a\u0004\u0018\u000109J\u001e\u0010E\u001a\u00020*2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030G2\b\u00108\u001a\u0004\u0018\u000109H\u0002Jn\u0010H\u001a\u00020*\"\u0004\b\u0001\u0010I2K\u0010J\u001aG\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*0K2\u0006\u00108\u001a\u0002092\u0006\u0010N\u001a\u0002HI¢\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020!H\u0002J\b\u0010T\u001a\u00020!H\u0002J\n\u0010U\u001a\u0004\u0018\u00010\u0017H\u0001J\n\u0010V\u001a\u0004\u0018\u00010\u0019H\u0002J\r\u0010W\u001a\u00020*H\u0000¢\u0006\u0002\bXJ\u001b\u0010Y\u001a\u00020*2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0016¢\u0006\u0002\u0010\\J:\u0010]\u001a\u00020*2\u0006\u0010N\u001a\u00028\u00002#\u0010J\u001a\u001f\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020*\u0018\u00010^H\u0016¢\u0006\u0002\u0010_Jn\u0010]\u001a\u00020*\"\b\b\u0001\u0010I*\u00028\u00002\u0006\u0010N\u001a\u0002HI2M\u0010J\u001aI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0016¢\u0006\u0002\u0010`J\u001c\u0010a\u001a\u00020*2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030G2\u0006\u0010b\u001a\u00020\nH\u0016J6\u0010a\u001a\u00020*2'\u0010C\u001a#\u0012\u0015\u0012\u0013\u0018\u000109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020*0^j\u0002`cH\u0016¢\u0006\u0002\u0010dJ\u0015\u0010e\u001a\u00020*2\u0006\u0010C\u001a\u00020DH\u0000¢\u0006\u0002\bfJ\u0010\u0010g\u001a\u00020*2\u0006\u0010C\u001a\u00020\u0017H\u0002J\u001a\u0010h\u001a\u00020*2\u0006\u0010C\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\nH\u0002J\u0086\u0001\u0010k\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0001\u0010I2\u0006\u0010\u001d\u001a\u00020l2\u0006\u0010m\u001a\u0002HI2\u0006\u0010\t\u001a\u00020\n2M\u0010J\u001aI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010K2\b\u0010n\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010oJv\u0010p\u001a\u00020*\"\u0004\b\u0001\u0010I2\u0006\u0010m\u001a\u0002HI2\u0006\u0010\t\u001a\u00020\n2O\b\u0002\u0010J\u001aI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0000¢\u0006\u0004\bq\u0010rJv\u0010s\u001a\u0004\u0018\u00010t\"\u0004\b\u0001\u0010I2\u0006\u0010m\u001a\u0002HI2\b\u0010n\u001a\u0004\u0018\u00010\u00172M\u0010J\u001aI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0002¢\u0006\u0002\u0010uJ\u0012\u0010v\u001a\u00020w2\b\u0010m\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010x\u001a\u00020*H\u0002J\r\u0010y\u001a\u00020*H\u0000¢\u0006\u0002\bzJ!\u0010T\u001a\u0004\u0018\u00010\u00172\u0006\u0010N\u001a\u00028\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010{Jz\u0010T\u001a\u0004\u0018\u00010\u0017\"\b\b\u0001\u0010I*\u00028\u00002\u0006\u0010N\u001a\u0002HI2\b\u0010n\u001a\u0004\u0018\u00010\u00172M\u0010J\u001aI\u0012\u0013\u0012\u001109¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011HI¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020*\u0018\u00010KH\u0016¢\u0006\u0002\u0010|J\u0012\u0010}\u001a\u0004\u0018\u00010\u00172\u0006\u0010~\u001a\u000209H\u0016J\u0011\u0010\u007f\u001a\u00020*2\u0007\u0010\u0080\u0001\u001a\u00020\u0017H\u0016J\u001c\u0010\u0081\u0001\u001a\u00020**\u00030\u0082\u00012\u0006\u0010N\u001a\u00028\u0000H\u0016¢\u0006\u0003\u0010\u0083\u0001J\u0016\u0010\u0084\u0001\u001a\u00020**\u00030\u0082\u00012\u0006\u0010~\u001a\u000209H\u0016J\"\u0010\u0085\u0001\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u0001092\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0003\b\u0089\u0001J\t\u0010\u008a\u0001\u001a\u00020&H\u0016J\t\u0010\u008b\u0001\u001a\u00020&H\u0014R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\t\u0010\u0013\u001a\u00020\u0014X\u0082\u0004R\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004R\u0011\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016X\u0082\u0004R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010-\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006\u008c\u0001"}, m13886d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "isActive", "", "()Z", "isCompleted", "isCancelled", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "initCancellability", "", "isReusable", "resetStateReusable", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Lkotlinx/coroutines/internal/StackTraceElement;", "Ljava/lang/StackTraceElement;", "()Ljava/lang/StackTraceElement;", "takeState", "takeState$kotlinx_coroutines_core", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "cancel", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callCancelHandler", "handler", "Lkotlinx/coroutines/CancelHandler;", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "callOnCancellation", "R", "onCancellation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Ljava/lang/Object;)V", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "trySuspend", "tryResume", "getResult", "installParentHandle", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resume", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "invokeOnCancellation", "index", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCancellationInternal", "invokeOnCancellationInternal$kotlinx_coroutines_core", "invokeOnCancellationImpl", "multipleHandlersError", "dispatchResume", "mode", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "idempotent", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;", "resumeImpl", "resumeImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function3;)V", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/internal/Symbol;", "alreadyResumedError", "", "detachChildIfNonResuable", "detachChild", "detachChild$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "tryResumeWithException", "exception", "completeResume", ResponseType.TOKEN, "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "toString", "nameString", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,701:1\n227#1,10:705\n227#1,10:716\n1#2:702\n20#3:703\n20#3:704\n18#3:715\n17#3:726\n18#3,3:727\n17#3:730\n18#3,3:731\n18#3:738\n17#3,4:739\n57#4,2:734\n57#4,2:736\n57#4,2:743\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n239#1:705,10\n244#1:716,10\n69#1:703\n155#1:704\n242#1:715\n271#1:726\n272#1:727,3\n281#1:730\n282#1:731,3\n387#1:738\n390#1:739,4\n323#1:734,2\n333#1:736,2\n614#1:743,2\n*E\n"})
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    @NotNull
    private final CoroutineContext context;

    @NotNull
    private final Continuation<T> delegate;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        this.context = continuation.get$context();
        this._decisionAndIndex$volatile = SegmentTree.MAX_VALUE;
        this._state$volatile = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    private final void callCancelHandlerSafely(Function0<Unit> block) {
        try {
            block.invoke();
        } catch (Throwable th) {
            CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable cause) {
        int i = _decisionAndIndex$volatile$FU.get(this) & SegmentTree.MAX_VALUE;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment.onCancellation(i, cause, get$context());
        } catch (Throwable th) {
            CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final boolean cancelLater(Throwable cause) {
        if (!isReusable()) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).postponeCancellation$kotlinx_coroutines_core(cause);
    }

    private final void detachChildIfNonResuable() {
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    private final void dispatchResume(int mode) {
        if (tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, mode);
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) _parentHandle$volatile$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return state$kotlinx_coroutines_core instanceof NotCompleted ? "Active" : state$kotlinx_coroutines_core instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    private final /* synthetic */ int get_decisionAndIndex$volatile() {
        return this._decisionAndIndex$volatile;
    }

    private final /* synthetic */ Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job) get$context().get(Job.INSTANCE);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleInvokeOnCompletion$default = JobKt__JobKt.invokeOnCompletion$default(job, false, new ChildContinuation(this), 1, null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, disposableHandleInvokeOnCompletion$default)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                return disposableHandleInvokeOnCompletion$default;
            }
        }
        return disposableHandleInvokeOnCompletion$default;
    }

    private final void invokeOnCancellationImpl(Object handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Active) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, handler)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof CancelHandler) && !(obj instanceof Segment)) {
                if (obj instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (!completedExceptionally.makeHandled()) {
                        multipleHandlersError(handler, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        Throwable th = completedExceptionally.cause;
                        if (handler instanceof CancelHandler) {
                            callCancelHandler((CancelHandler) handler, th);
                            return;
                        } else {
                            Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            callSegmentOnCancellation((Segment) handler, th);
                            return;
                        }
                    }
                    return;
                }
                if (!(obj instanceof CompletedContinuation)) {
                    if (handler instanceof Segment) {
                        return;
                    }
                    Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CompletedContinuation completedContinuation = new CompletedContinuation(obj, (CancelHandler) handler, null, null, null, 28, null);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = _state$volatile$FU;
                    while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, completedContinuation)) {
                        if (atomicReferenceFieldUpdater3.get(this) != obj) {
                            break;
                        }
                    }
                    return;
                }
                CompletedContinuation completedContinuation2 = (CompletedContinuation) obj;
                if (completedContinuation2.cancelHandler != null) {
                    multipleHandlersError(handler, obj);
                }
                if (handler instanceof Segment) {
                    return;
                }
                Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                CancelHandler cancelHandler = (CancelHandler) handler;
                if (completedContinuation2.getCancelled()) {
                    callCancelHandler(cancelHandler, completedContinuation2.cancelCause);
                    return;
                }
                CompletedContinuation completedContinuationCopy$default = CompletedContinuation.copy$default(completedContinuation2, null, cancelHandler, null, null, null, 29, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater4.compareAndSet(this, obj, completedContinuationCopy$default)) {
                    if (atomicReferenceFieldUpdater4.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            multipleHandlersError(handler, obj);
        }
    }

    private final boolean isReusable() {
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).isReusable$kotlinx_coroutines_core();
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final void multipleHandlersError(Object handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resume$lambda$13$lambda$12(Function1 function1, Throwable th, Object obj, CoroutineContext coroutineContext) {
        function1.invoke(th);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void resumeImpl$kotlinx_coroutines_core$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function3 function3, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function3 = null;
        }
        cancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core(obj, i, function3);
    }

    private final <R> Object resumedState(NotCompleted state, R proposedUpdate, int resumeMode, Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof CompletedExceptionally) {
            return proposedUpdate;
        }
        if ((DispatchedTaskKt.isCancellableMode(resumeMode) || idempotent != null) && !(onCancellation == null && !(state instanceof CancelHandler) && idempotent == null)) {
            return new CompletedContinuation(proposedUpdate, state instanceof CancelHandler ? (CancelHandler) state : null, onCancellation, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    private final /* synthetic */ void set_decisionAndIndex$volatile(int i) {
        this._decisionAndIndex$volatile = i;
    }

    private final /* synthetic */ void set_parentHandle$volatile(Object obj) {
        this._parentHandle$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean tryResume() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, i, 1073741824 + (536870911 & i)));
        return true;
    }

    private final <R> Symbol tryResumeImpl(R proposedUpdate, Object idempotent, Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        R r;
        Object obj;
        Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> function3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof NotCompleted)) {
                Object obj3 = idempotent;
                if ((obj2 instanceof CompletedContinuation) && obj3 != null && ((CompletedContinuation) obj2).idempotentResume == obj3) {
                    return CancellableContinuationImplKt.RESUME_TOKEN;
                }
                return null;
            }
            r = proposedUpdate;
            obj = idempotent;
            function3 = onCancellation;
            Object objResumedState = resumedState((NotCompleted) obj2, r, this.resumeMode, function3, obj);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, objResumedState)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                    break;
                }
            }
            detachChildIfNonResuable();
            return CancellableContinuationImplKt.RESUME_TOKEN;
            proposedUpdate = r;
            onCancellation = function3;
            idempotent = obj;
        }
    }

    private final boolean trySuspend() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1) {
        int i;
        do {
            i = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i, function1.invoke(Integer.valueOf(i)).intValue()));
    }

    public final void callCancelHandler(@NotNull CancelHandler handler, @Nullable Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable th) {
            CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> void callOnCancellation(@NotNull Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation, @NotNull Throwable cause, R value) {
        try {
            onCancellation.invoke(cause, value, get$context());
        } catch (Throwable th) {
            CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@Nullable Throwable cause) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, cause, (obj instanceof CancelHandler) || (obj instanceof Segment));
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, cancelledContinuation)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj) {
                    break;
                }
            }
            NotCompleted notCompleted = (NotCompleted) obj;
            if (notCompleted instanceof CancelHandler) {
                callCancelHandler((CancelHandler) obj, cause);
            } else if (notCompleted instanceof Segment) {
                callSegmentOnCancellation((Segment) obj, cause);
            }
            detachChildIfNonResuable();
            dispatchResume(this.resumeMode);
            return true;
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof NotCompleted) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof CompletedExceptionally) {
                return;
            }
            if (!(obj instanceof CompletedContinuation)) {
                th = cause;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                CompletedContinuation completedContinuation = new CompletedContinuation(obj, null, null, null, th, 14, null);
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, completedContinuation)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            CompletedContinuation completedContinuation2 = (CompletedContinuation) obj;
            if (completedContinuation2.getCancelled()) {
                throw new IllegalStateException("Must be called at most once");
            }
            Throwable th2 = cause;
            CompletedContinuation completedContinuationCopy$default = CompletedContinuation.copy$default(completedContinuation2, null, null, null, null, th2, 15, null);
            th = th2;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = _state$volatile$FU;
            while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, completedContinuationCopy$default)) {
                if (atomicReferenceFieldUpdater3.get(this) != obj) {
                    break;
                }
            }
            completedContinuation2.invokeHandlers(this, th);
            return;
            cause = th;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@NotNull Object token) {
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle == null) {
            return;
        }
        parentHandle.dispose();
        _parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    /* JADX INFO: renamed from: getContext, reason: from getter */
    public CoroutineContext get$context() {
        return this.context;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job parent) {
        return parent.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object state) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Job job;
        boolean zIsReusable = isReusable();
        if (trySuspend()) {
            if (getParentHandle() == null) {
                installParentHandle();
            }
            if (zIsReusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (zIsReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        if (!DispatchedTaskKt.isCancellableMode(this.resumeMode) || (job = (Job) get$context().get(Job.INSTANCE)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        }
        CancellationException cancellationException = job.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
        throw cancellationException;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle disposableHandleInstallParentHandle = installParentHandle();
        if (disposableHandleInstallParentHandle != null && isCompleted()) {
            disposableHandleInstallParentHandle.dispose();
            _parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & SegmentTree.MAX_VALUE) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, ((i >> 29) << 29) + index));
        invokeOnCancellationImpl(segment);
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(@NotNull CancelHandler handler) {
        invokeOnCancellationImpl(handler);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @NotNull
    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable cause) {
        if (cancelLater(cause)) {
            return;
        }
        cancel(cause);
        detachChildIfNonResuable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Throwable thTryReleaseClaimedContinuation$kotlinx_coroutines_core;
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation == null || (thTryReleaseClaimedContinuation$kotlinx_coroutines_core = dispatchedContinuation.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(thTryReleaseClaimedContinuation$kotlinx_coroutines_core);
    }

    @JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        Object obj = _state$volatile$FU.get(this);
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        _decisionAndIndex$volatile$FU.set(this, SegmentTree.MAX_VALUE);
        _state$volatile$FU.set(this, Active.INSTANCE);
        return true;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T value, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        resumeImpl$kotlinx_coroutines_core(value, this.resumeMode, onCancellation != null ? new C7868a(onCancellation, 4) : null);
    }

    public final <R> void resumeImpl$kotlinx_coroutines_core(R proposedUpdate, int resumeMode, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        R r;
        int i;
        Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> function3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof NotCompleted) {
                r = proposedUpdate;
                i = resumeMode;
                function3 = onCancellation;
                Object objResumedState = resumedState((NotCompleted) obj, r, i, function3, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, objResumedState)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                detachChildIfNonResuable();
                dispatchResume(i);
                return;
            }
            R r2 = proposedUpdate;
            Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> function32 = onCancellation;
            if (obj instanceof CancelledContinuation) {
                CancelledContinuation cancelledContinuation = (CancelledContinuation) obj;
                if (cancelledContinuation.makeResumed()) {
                    if (function32 != null) {
                        callOnCancellation(function32, cancelledContinuation.cause, r2);
                        return;
                    }
                    return;
                }
            }
            alreadyResumedError(r2);
            throw new KotlinNothingValueException();
            proposedUpdate = r;
            resumeMode = i;
            onCancellation = function3;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$kotlinx_coroutines_core$default(this, t, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$kotlinx_coroutines_core$default(this, new CompletedExceptionally(th, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        resumeImpl$kotlinx_coroutines_core$default(this, CompletionStateKt.toState(result, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @NotNull
    public String toString() {
        return nameString() + PropertyUtils.MAPPED_DELIM + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable exception) {
        return tryResumeImpl(new CompletedExceptionally(exception, false, 2, null), null, null);
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public <R extends T> void resume(R value, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        resumeImpl$kotlinx_coroutines_core(value, this.resumeMode, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> handler) {
        CancellableContinuationKt.invokeOnCancellation(this, new CancelHandler.UserSupplied(handler));
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T value, @Nullable Object idempotent) {
        return tryResumeImpl(value, idempotent, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public <R extends T> Object tryResume(R value, @Nullable Object idempotent, @Nullable Function3<? super Throwable, ? super R, ? super CoroutineContext, Unit> onCancellation) {
        return tryResumeImpl(value, idempotent, onCancellation);
    }
}
