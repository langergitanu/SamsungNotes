package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\r\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0080\b\u001as\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u000228\b\b\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0080\b\u001a!\u0010\u0012\u001a\u0002H\u0013\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u0013H\u0000¢\u0006\u0002\u0010\u0015\u001a8\u0010\u0016\u001a\u00020\r*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u001bH\u0082\b\"\u000e\u0010\u001d\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"findSegmentInternal", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "id", "", "createNewSegment", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "", "Lkotlinx/atomicfu/AtomicRef;", "to", "findSegmentAndMoveForward", "startFrom", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "addConditionally", "Lkotlinx/atomicfu/AtomicInt;", "delta", "", "condition", "Lkotlin/Function1;", "cur", "POINTERS_SHIFT", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,265:1\n42#1,8:280\n103#2,7:266\n103#2,7:273\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n70#1:280,8\n23#1:266,7\n81#1:273,7\n*E\n"})
public final class ConcurrentLinkedListKt {

    @NotNull
    private static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    private static final /* synthetic */ boolean addConditionally$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i, Function1<? super Integer, Boolean> function1) {
        int i2;
        do {
            i2 = atomicIntegerFieldUpdater.get(obj);
            if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i2, i2 + i));
        return true;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$array(AtomicIntegerArray atomicIntegerArray, int i, int i2, Function1<? super Integer, Boolean> function1) {
        int i4;
        do {
            i4 = atomicIntegerArray.get(i);
            if (!function1.invoke(Integer.valueOf(i4)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i4, i4 + i2));
        return true;
    }

    @NotNull
    public static final <N extends ConcurrentLinkedListNode<N>> N close(@NotNull N n) {
        while (true) {
            Object nextOrClosed = n.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n;
            }
            ConcurrentLinkedListNode concurrentLinkedListNode = (ConcurrentLinkedListNode) nextOrClosed;
            if (concurrentLinkedListNode != null) {
                n = (N) concurrentLinkedListNode;
            } else if (n.markAsClosed()) {
                return n;
            }
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            Object objFindSegmentInternal = findSegmentInternal(s, j, function2);
            if (SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
                return objFindSegmentInternal;
            }
            Segment segmentM23769getSegmentimpl = SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(obj);
                if (segment.id >= segmentM23769getSegmentimpl.id) {
                    return objFindSegmentInternal;
                }
                if (!segmentM23769getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(obj, segment, segmentM23769getSegmentimpl)) {
                    if (atomicReferenceFieldUpdater.get(obj) != segment) {
                        if (segmentM23769getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            segmentM23769getSegmentimpl.remove();
                        }
                    }
                }
                if (segment.decPointers$kotlinx_coroutines_core()) {
                    segment.remove();
                }
                return objFindSegmentInternal;
            }
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu$array(AtomicReferenceArray atomicReferenceArray, int i, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            Object objFindSegmentInternal = findSegmentInternal(s, j, function2);
            if (SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
                return objFindSegmentInternal;
            }
            Segment segmentM23769getSegmentimpl = SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceArray.get(i);
                if (segment.id >= segmentM23769getSegmentimpl.id) {
                    return objFindSegmentInternal;
                }
                if (!segmentM23769getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (!atomicReferenceArray.compareAndSet(i, segment, segmentM23769getSegmentimpl)) {
                    if (atomicReferenceArray.get(i) != segment) {
                        if (segmentM23769getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            segmentM23769getSegmentimpl.remove();
                        }
                    }
                }
                if (segment.decPointers$kotlinx_coroutines_core()) {
                    segment.remove();
                }
                return objFindSegmentInternal;
            }
        }
    }

    @NotNull
    public static final <S extends Segment<S>> Object findSegmentInternal(@NotNull S s, long j, @NotNull Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s.id >= j && !s.isRemoved()) {
                return SegmentOrClosed.m23766constructorimpl(s);
            }
            Object nextOrClosed = s.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return SegmentOrClosed.m23766constructorimpl(CLOSED);
            }
            S sInvoke = (S) ((ConcurrentLinkedListNode) nextOrClosed);
            if (sInvoke == null) {
                sInvoke = function2.invoke(Long.valueOf(s.id + 1), s);
                if (s.trySetNext(sInvoke)) {
                    if (s.isRemoved()) {
                        s.remove();
                    }
                }
            }
            s = (Object) sInvoke;
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, S s) {
        while (true) {
            Segment segment = (Segment) atomicReferenceFieldUpdater.get(obj);
            if (segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(obj, segment, s)) {
                if (atomicReferenceFieldUpdater.get(obj) != segment) {
                    if (s.decPointers$kotlinx_coroutines_core()) {
                        s.remove();
                    }
                }
            }
            if (segment.decPointers$kotlinx_coroutines_core()) {
                segment.remove();
            }
            return true;
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu$array(AtomicReferenceArray atomicReferenceArray, int i, S s) {
        while (true) {
            Segment segment = (Segment) atomicReferenceArray.get(i);
            if (segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            while (!atomicReferenceArray.compareAndSet(i, segment, s)) {
                if (atomicReferenceArray.get(i) != segment) {
                    if (s.decPointers$kotlinx_coroutines_core()) {
                        s.remove();
                    }
                }
            }
            if (segment.decPointers$kotlinx_coroutines_core()) {
                segment.remove();
            }
            return true;
        }
    }
}
