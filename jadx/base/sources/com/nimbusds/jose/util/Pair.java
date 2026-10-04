package com.nimbusds.jose.util;

import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class Pair<L, R> {
    private final L left;
    private final R right;

    public Pair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* JADX INFO: renamed from: of */
    public static <L, R> Pair<L, R> m4638of(L l, R r) {
        return new Pair<>(l, r);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }
}
