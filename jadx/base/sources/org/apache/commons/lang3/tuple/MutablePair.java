package org.apache.commons.lang3.tuple;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    public static final MutablePair<?, ?>[] EMPTY_ARRAY = new MutablePair[0];
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public MutablePair() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, R> MutablePair<L, R>[] emptyArray() {
        return (MutablePair<L, R>[]) EMPTY_ARRAY;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> MutablePair<L, R> m14896of(L l, R r) {
        return new MutablePair<>(l, r);
    }

    public static <L, R> MutablePair<L, R> ofNonNull(L l, R r) {
        Objects.requireNonNull(l, "left");
        Objects.requireNonNull(r, "right");
        return m14896of((Object) l, (Object) r);
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    public void setLeft(L l) {
        this.left = l;
    }

    public void setRight(R r) {
        this.right = r;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        R right = getRight();
        setRight(r);
        return right;
    }

    public MutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> MutablePair<L, R> m14897of(Map.Entry<L, R> entry) {
        L key;
        R value;
        if (entry != null) {
            key = entry.getKey();
            value = entry.getValue();
        } else {
            key = null;
            value = null;
        }
        return new MutablePair<>(key, value);
    }
}
