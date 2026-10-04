package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableBiFunction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    public static final Pair<?, ?>[] EMPTY_ARRAY = new Pair[0];
    private static final long serialVersionUID = 4954918890077093841L;

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, R> Pair<L, R>[] emptyArray() {
        return (Pair<L, R>[]) EMPTY_ARRAY;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> Pair<L, R> m14899of(L l, R r) {
        return ImmutablePair.m14893of((Object) l, (Object) r);
    }

    public static <L, R> Pair<L, R> ofNonNull(L l, R r) {
        return ImmutablePair.ofNonNull((Object) l, (Object) r);
    }

    public <E extends Throwable> void accept(FailableBiConsumer<L, R, E> failableBiConsumer) {
        failableBiConsumer.accept(getKey(), getValue());
    }

    public <V, E extends Throwable> V apply(FailableBiFunction<L, R, V, E> failableBiFunction) {
        return failableBiFunction.apply(getKey(), getValue());
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return getLeft();
    }

    public abstract L getLeft();

    public abstract R getRight();

    @Override // java.util.Map.Entry
    public R getValue() {
        return getRight();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    public String toString() {
        return "(" + getLeft() + ',' + getRight() + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> Pair<L, R> m14900of(Map.Entry<L, R> entry) {
        return ImmutablePair.m14894of((Map.Entry) entry);
    }

    @Override // java.lang.Comparable
    public int compareTo(Pair<L, R> pair) {
        return new CompareToBuilder().append(getLeft(), pair.getLeft()).append(getRight(), pair.getRight()).toComparison();
    }

    public String toString(String str) {
        return String.format(str, getLeft(), getRight());
    }
}
