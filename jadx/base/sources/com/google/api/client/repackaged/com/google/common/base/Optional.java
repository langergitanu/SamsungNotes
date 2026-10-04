package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@GwtCompatible(serializable = true)
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@Nullable T t) {
        return t == null ? absent() : new Present(t);
    }

    /* JADX INFO: renamed from: of */
    public static <T> Optional<T> m4218of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterable<T>() { // from class: com.google.api.client.repackaged.com.google.common.base.Optional.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() { // from class: com.google.api.client.repackaged.com.google.common.base.Optional.1.1
                    private final Iterator<? extends Optional<? extends T>> iterator;

                    {
                        this.iterator = (Iterator) Preconditions.checkNotNull(iterable.iterator());
                    }

                    @Override // com.google.api.client.repackaged.com.google.common.base.AbstractIterator
                    public T computeNext() {
                        while (this.iterator.hasNext()) {
                            Optional<? extends T> next = this.iterator.next();
                            if (next.isPresent()) {
                                return next.get();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@Nullable Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    /* JADX INFO: renamed from: or */
    public abstract Optional<T> mo4211or(Optional<? extends T> optional);

    @Beta
    /* JADX INFO: renamed from: or */
    public abstract T mo4212or(Supplier<? extends T> supplier);

    /* JADX INFO: renamed from: or */
    public abstract T mo4213or(T t);

    @Nullable
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
