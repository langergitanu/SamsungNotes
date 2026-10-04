package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@InternalCoroutinesApi
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0005j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0017\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0010\u001cJ\r\u0010\u001d\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001eJ$\u0010 \u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b¢\u0006\u0002\u0010\u001cJ\u0013\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010$J,\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00028\u00002\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00152\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010)J\u000f\u0010*\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001eJ\u0015\u0010+\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010$J\u0011\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0082\u0010J\u0011\u00101\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0082\u0010J\u0015\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tH\u0002¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002R\u001a\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u00066"}, m13886d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "<init>", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "_size", "Lkotlinx/atomicfu/AtomicInt;", "value", "", "size", "getSize", "()I", "setSize", "(I)V", "isEmpty", "", "()Z", "find", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "removeFirstIf", "addLast", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLastIf", "cond", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "siftUpFrom", "i", "siftDownFrom", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "swap", "j", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n27#2:160\n27#2:162\n27#2:164\n27#2:166\n27#2:168\n27#2:170\n27#2:172\n16#3:161\n16#3:163\n16#3:165\n16#3:167\n16#3:169\n16#3:171\n16#3:173\n1#4:174\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n33#1:160\n41#1:162\n43#1:164\n51#1:166\n60#1:168\n63#1:170\n72#1:172\n33#1:161\n41#1:163\n43#1:165\n51#1:167\n60#1:169\n63#1:171\n72#1:173\n*E\n"})
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    @Nullable
    private T[] a;

    private final /* synthetic */ int get_size$volatile() {
        return this._size$volatile;
    }

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (getSize() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, getSize() * 2);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void setSize(int i) {
        _size$volatile$FU.set(this, i);
    }

    private final /* synthetic */ void set_size$volatile(int i) {
        this._size$volatile = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = i * 2;
            int i4 = i2 + 1;
            if (i4 >= getSize()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i5 = i2 + 2;
            if (i5 < getSize()) {
                T t = tArr[i5];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i4];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) >= 0) {
                    i5 = i4;
                }
            }
            T t5 = tArr[i];
            Intrinsics.checkNotNull(t5);
            T t6 = tArr[i5];
            Intrinsics.checkNotNull(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            swap(i, i5);
            i = i5;
        }
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private final void swap(int i, int j) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[j];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[j] = t2;
        t.setIndex(i);
        t2.setIndex(j);
    }

    @PublishedApi
    public final void addImpl(@NotNull T node) {
        node.setHeap(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArrRealloc = realloc();
        int size = getSize();
        setSize(size + 1);
        threadSafeHeapNodeArrRealloc[size] = node;
        node.setIndex(size);
        siftUpFrom(size);
    }

    public final void addLast(@NotNull T node) {
        synchronized (this) {
            addImpl(node);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(@NotNull T node, @NotNull Function1<? super T, Boolean> cond) {
        boolean z;
        synchronized (this) {
            try {
                if (cond.invoke(firstImpl()).booleanValue()) {
                    addImpl(node);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return z;
    }

    @Nullable
    public final T find(@NotNull Function1<? super T, Boolean> predicate) {
        T t;
        synchronized (this) {
            try {
                int size = getSize();
                int i = 0;
                while (true) {
                    t = null;
                    if (i >= size) {
                        break;
                    }
                    T[] tArr = this.a;
                    if (tArr != null) {
                        t = (Object) tArr[i];
                    }
                    Intrinsics.checkNotNull(t);
                    if (predicate.invoke(t).booleanValue()) {
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @PublishedApi
    @Nullable
    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return _size$volatile$FU.get(this);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    @Nullable
    public final T peek() {
        T t;
        synchronized (this) {
            t = (T) firstImpl();
        }
        return t;
    }

    public final boolean remove(@NotNull T node) {
        boolean z;
        synchronized (this) {
            if (node.getHeap() == null) {
                z = false;
            } else {
                removeAtImpl(node.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    @PublishedApi
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T removeAtImpl(int index) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        setSize(getSize() - 1);
        if (index < getSize()) {
            swap(index, getSize());
            int i = (index - 1) / 2;
            if (index > 0) {
                T t = tArr[index];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    swap(index, i);
                    siftUpFrom(i);
                } else {
                    siftDownFrom(index);
                }
            }
        }
        T t5 = tArr[getSize()];
        Intrinsics.checkNotNull(t5);
        t5.setHeap(null);
        t5.setIndex(-1);
        tArr[getSize()] = null;
        return t5;
    }

    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> predicate) {
        synchronized (this) {
            try {
                ThreadSafeHeapNode threadSafeHeapNodeFirstImpl = firstImpl();
                T t = null;
                if (threadSafeHeapNodeFirstImpl == null) {
                    InlineMarker.finallyStart(2);
                    InlineMarker.finallyEnd(2);
                    return null;
                }
                if (predicate.invoke(threadSafeHeapNodeFirstImpl).booleanValue()) {
                    t = (T) removeAtImpl(0);
                }
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return t;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        T t;
        synchronized (this) {
            t = getSize() > 0 ? (T) removeAtImpl(0) : null;
        }
        return t;
    }
}
