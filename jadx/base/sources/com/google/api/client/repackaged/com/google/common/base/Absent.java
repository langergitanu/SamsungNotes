package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@GwtCompatible
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.EMPTY_SET;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean equals(@Nullable Object obj) {
        return obj == this;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public int hashCode() {
        return 1502476572;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    /* JADX INFO: renamed from: or */
    public T mo4213or(T t) {
        return (T) Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    @Nullable
    public T orNull() {
        return null;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    /* JADX INFO: renamed from: or */
    public Optional<T> mo4211or(Optional<? extends T> optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    /* JADX INFO: renamed from: or */
    public T mo4212or(Supplier<? extends T> supplier) {
        return (T) Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
