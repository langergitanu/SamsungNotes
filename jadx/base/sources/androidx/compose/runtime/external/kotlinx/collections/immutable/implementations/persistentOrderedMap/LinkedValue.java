package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006B!\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002J\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001b"}, m13886d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "value", "(Ljava/lang/Object;)V", "previous", "(Ljava/lang/Object;Ljava/lang/Object;)V", "next", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "getNext", "()Ljava/lang/Object;", "getPrevious", "getValue", "Ljava/lang/Object;", "withNext", "newNext", "withPrevious", "newPrevious", "withValue", "newValue", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LinkedValue<V> {
    public static final int $stable = 8;

    @Nullable
    private final Object next;

    @Nullable
    private final Object previous;
    private final V value;

    public LinkedValue(V v, @Nullable Object obj, @Nullable Object obj2) {
        this.value = v;
        this.previous = obj;
        this.next = obj2;
    }

    public final boolean getHasNext() {
        return this.next != EndOfChain.INSTANCE;
    }

    public final boolean getHasPrevious() {
        return this.previous != EndOfChain.INSTANCE;
    }

    @Nullable
    public final Object getNext() {
        return this.next;
    }

    @Nullable
    public final Object getPrevious() {
        return this.previous;
    }

    public final V getValue() {
        return this.value;
    }

    @NotNull
    public final LinkedValue<V> withNext(@Nullable Object newNext) {
        return new LinkedValue<>(this.value, this.previous, newNext);
    }

    @NotNull
    public final LinkedValue<V> withPrevious(@Nullable Object newPrevious) {
        return new LinkedValue<>(this.value, newPrevious, this.next);
    }

    @NotNull
    public final LinkedValue<V> withValue(V newValue) {
        return new LinkedValue<>(newValue, this.previous, this.next);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LinkedValue(V v) {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this(v, endOfChain, endOfChain);
    }

    public LinkedValue(V v, @Nullable Object obj) {
        this(v, obj, EndOfChain.INSTANCE);
    }
}
