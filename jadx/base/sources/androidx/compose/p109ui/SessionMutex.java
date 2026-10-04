package androidx.compose.p109ui;

import androidx.annotation.RestrictTo;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001'B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B1\b\u0002\u0012&\u0010\u0005\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007`\b¢\u0006\u0004\b\u0003\u0010\tJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0001\u0010\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000\u001d21\u0010\u001f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0$\u0012\u0006\u0012\u0004\u0018\u00010\u00020 H\u0086@¢\u0006\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR.\u0010\u0005\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0005\u0092\u0001\"\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0007`\b¨\u0006("}, m13886d2 = {"Landroidx/compose/ui/SessionMutex;", "T", "", "constructor-impl", "()Ljava/util/concurrent/atomic/AtomicReference;", "currentSessionHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/SessionMutex$Session;", "Landroidx/compose/ui/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "currentSession", "getCurrentSession-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)I", "toString", "", "toString-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/String;", "withSessionCancellingPrevious", "R", "sessionInitializer", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "session", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "Lkotlin/coroutines/Continuation;", "withSessionCancellingPrevious-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RtspHeaders.Names.SESSION, "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@InternalComposeUiApi
@JvmInline
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SessionMutex<T> {

    @NotNull
    private final AtomicReference<Session<T>> currentSessionHolder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/SessionMutex$Session;", "T", "", "job", "Lkotlinx/coroutines/Job;", "value", "(Lkotlinx/coroutines/Job;Ljava/lang/Object;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Session<T> {

        @NotNull
        private final Job job;
        private final T value;

        public Session(@NotNull Job job, T t) {
            this.job = job;
            this.value = t;
        }

        @NotNull
        public final Job getJob() {
            return this.job;
        }

        public final T getValue() {
            return this.value;
        }
    }

    private /* synthetic */ SessionMutex(AtomicReference atomicReference) {
        this.currentSessionHolder = atomicReference;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SessionMutex m18132boximpl(AtomicReference atomicReference) {
        return new SessionMutex(atomicReference);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static <T> AtomicReference<Session<T>> m18134constructorimpl(AtomicReference<Session<T>> atomicReference) {
        return atomicReference;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m18135equalsimpl(AtomicReference<Session<T>> atomicReference, Object obj) {
        return (obj instanceof SessionMutex) && Intrinsics.areEqual(atomicReference, ((SessionMutex) obj).getCurrentSessionHolder());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18136equalsimpl0(AtomicReference<Session<T>> atomicReference, AtomicReference<Session<T>> atomicReference2) {
        return Intrinsics.areEqual(atomicReference, atomicReference2);
    }

    @Nullable
    /* JADX INFO: renamed from: getCurrentSession-impl, reason: not valid java name */
    public static final T m18137getCurrentSessionimpl(AtomicReference<Session<T>> atomicReference) {
        Session<T> session = atomicReference.get();
        if (session != null) {
            return session.getValue();
        }
        return null;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18138hashCodeimpl(AtomicReference<Session<T>> atomicReference) {
        return atomicReference.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18139toStringimpl(AtomicReference<Session<T>> atomicReference) {
        return "SessionMutex(currentSessionHolder=" + atomicReference + PropertyUtils.MAPPED_DELIM2;
    }

    @Nullable
    /* JADX INFO: renamed from: withSessionCancellingPrevious-impl, reason: not valid java name */
    public static final <R> Object m18140withSessionCancellingPreviousimpl(AtomicReference<Session<T>> atomicReference, @NotNull Function1<? super CoroutineScope, ? extends T> function1, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, null), continuation);
    }

    public boolean equals(Object obj) {
        return m18135equalsimpl(this.currentSessionHolder, obj);
    }

    public int hashCode() {
        return m18138hashCodeimpl(this.currentSessionHolder);
    }

    public String toString() {
        return m18139toStringimpl(this.currentSessionHolder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ AtomicReference getCurrentSessionHolder() {
        return this.currentSessionHolder;
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> AtomicReference<Session<T>> m18133constructorimpl() {
        return m18134constructorimpl(new AtomicReference(null));
    }
}
