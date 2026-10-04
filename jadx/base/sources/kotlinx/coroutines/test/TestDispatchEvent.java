package kotlinx.coroutines.test;

import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00022\u00020\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\u00182\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, m13886d2 = {"Lkotlinx/coroutines/test/TestDispatchEvent;", "T", "", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "dispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "count", "", "time", "marker", "isForeground", "", "isCancelled", "Lkotlin/Function0;", "<init>", "(Lkotlinx/coroutines/test/TestDispatcher;JJLjava/lang/Object;ZLkotlin/jvm/functions/Function0;)V", "Ljava/lang/Object;", "heap", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "toString", "", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
final class TestDispatchEvent<T> implements Comparable<TestDispatchEvent<?>>, ThreadSafeHeapNode {
    private final long count;

    @JvmField
    @NotNull
    public final TestDispatcher dispatcher;

    @Nullable
    private ThreadSafeHeap<?> heap;
    private int index;

    @JvmField
    @NotNull
    public final Function0<Boolean> isCancelled;

    @JvmField
    public final boolean isForeground;

    @JvmField
    public final T marker;

    @JvmField
    public final long time;

    public TestDispatchEvent(@NotNull TestDispatcher testDispatcher, long j, long j2, T t, boolean z, @NotNull Function0<Boolean> function0) {
        this.dispatcher = testDispatcher;
        this.count = j;
        this.time = j2;
        this.marker = t;
        this.isForeground = z;
        this.isCancelled = function0;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    @Nullable
    public ThreadSafeHeap<?> getHeap() {
        return this.heap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.index;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setHeap(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
        this.heap = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.index = i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("TestDispatchEvent(time=");
        sb.append(this.time);
        sb.append(", dispatcher=");
        sb.append(this.dispatcher);
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.isForeground ? "" : ", background", sb);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull TestDispatchEvent<?> other) {
        return ComparisonsKt.compareValuesBy((TestDispatchEvent<?>) this, other, (Function1<? super TestDispatchEvent<?>, ? extends Comparable<?>>[]) new Function1[]{new PropertyReference1Impl() { // from class: kotlinx.coroutines.test.TestDispatchEvent.compareTo.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Long.valueOf(((TestDispatchEvent) obj).time);
            }
        }, new PropertyReference1Impl() { // from class: kotlinx.coroutines.test.TestDispatchEvent.compareTo.2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Long.valueOf(((TestDispatchEvent) obj).count);
            }
        }});
    }
}
