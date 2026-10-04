package org.apache.commons.lang3.tuple;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ImmutablePair<L, R> extends Pair<L, R> {
    public static final ImmutablePair<?, ?>[] EMPTY_ARRAY = new ImmutablePair[0];
    private static final ImmutablePair NULL = new ImmutablePair(null, null);
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, R> ImmutablePair<L, R>[] emptyArray() {
        return (ImmutablePair<L, R>[]) EMPTY_ARRAY;
    }

    public static <L, R> Pair<L, R> left(L l) {
        return m14893of((Object) l, (Object) null);
    }

    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> ImmutablePair<L, R> m14893of(L l, R r) {
        return (l == null && r == null) ? nullPair() : new ImmutablePair<>(l, r);
    }

    public static <L, R> ImmutablePair<L, R> ofNonNull(L l, R r) {
        Objects.requireNonNull(l, "left");
        Objects.requireNonNull(r, "right");
        return m14893of((Object) l, (Object) r);
    }

    public static <L, R> Pair<L, R> right(R r) {
        return m14893of((Object) null, (Object) r);
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> ImmutablePair<L, R> m14894of(Map.Entry<L, R> entry) {
        return entry != null ? new ImmutablePair<>(entry.getKey(), entry.getValue()) : nullPair();
    }
}
