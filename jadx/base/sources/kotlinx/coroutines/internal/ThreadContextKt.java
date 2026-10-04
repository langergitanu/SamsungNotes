package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "threadContextElements", "context", "Lkotlin/coroutines/CoroutineContext;", "updateThreadContext", "countOrElement", "restoreThreadContext", "", "oldState", "kotlinx-coroutines-core"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ThreadContextKt {

    @JvmField
    @NotNull
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");

    @NotNull
    private static final Function2<Object, CoroutineContext.Element, Object> countAll;

    @NotNull
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne;

    @NotNull
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState;

    static {
        final int i = 1;
        countAll = new Function2() { // from class: kotlinx.coroutines.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        return ThreadContextKt.updateState$lambda$2((ThreadState) obj, (CoroutineContext.Element) obj2);
                    case 1:
                        return ThreadContextKt.countAll$lambda$0(obj, (CoroutineContext.Element) obj2);
                    default:
                        return ThreadContextKt.findOne$lambda$1((ThreadContextElement) obj, (CoroutineContext.Element) obj2);
                }
            }
        };
        final int i2 = 2;
        findOne = new Function2() { // from class: kotlinx.coroutines.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        return ThreadContextKt.updateState$lambda$2((ThreadState) obj, (CoroutineContext.Element) obj2);
                    case 1:
                        return ThreadContextKt.countAll$lambda$0(obj, (CoroutineContext.Element) obj2);
                    default:
                        return ThreadContextKt.findOne$lambda$1((ThreadContextElement) obj, (CoroutineContext.Element) obj2);
                }
            }
        };
        final int i4 = 0;
        updateState = new Function2() { // from class: kotlinx.coroutines.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i4) {
                    case 0:
                        return ThreadContextKt.updateState$lambda$2((ThreadState) obj, (CoroutineContext.Element) obj2);
                    case 1:
                        return ThreadContextKt.countAll$lambda$0(obj, (CoroutineContext.Element) obj2);
                    default:
                        return ThreadContextKt.findOne$lambda$1((ThreadContextElement) obj, (CoroutineContext.Element) obj2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object countAll$lambda$0(Object obj, CoroutineContext.Element element) {
        if (!(element instanceof ThreadContextElement)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? element : Integer.valueOf(iIntValue + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadContextElement<?> findOne$lambda$1(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
        if (threadContextElement != null) {
            return threadContextElement;
        }
        if (element instanceof ThreadContextElement) {
            return (ThreadContextElement) element;
        }
        return null;
    }

    public static final void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).restore(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, findOne);
        Intrinsics.checkNotNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) objFold).restoreThreadContext(coroutineContext, obj);
    }

    @NotNull
    public static final Object threadContextElements(@NotNull CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, countAll);
        Intrinsics.checkNotNull(objFold);
        return objFold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadState updateState$lambda$2(ThreadState threadState, CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            ThreadContextElement<?> threadContextElement = (ThreadContextElement) element;
            threadState.append(threadContextElement, threadContextElement.updateThreadContext(threadState.context));
        }
        return threadState;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
