package com.google.api.client.repackaged.com.google.common.base;

import androidx.compose.runtime.AbstractC1974b;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@GwtCompatible
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public Present(T t) {
        this.reference = t;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    /* JADX INFO: renamed from: or */
    public T mo4213or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public String toString() {
        return AbstractC1974b.m1320m(new StringBuilder("Optional.of("), this.reference, ")");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    /* JADX INFO: renamed from: or */
    public Optional<T> mo4211or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    /* JADX INFO: renamed from: or */
    public T mo4212or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }
}
