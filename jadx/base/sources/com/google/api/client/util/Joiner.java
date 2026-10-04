package com.google.api.client.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Joiner {
    private final com.google.api.client.repackaged.com.google.common.base.Joiner wrapped;

    private Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner joiner) {
        this.wrapped = joiner;
    }

    /* JADX INFO: renamed from: on */
    public static Joiner m4228on(char c) {
        return new Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner.m4216on(c));
    }

    public final String join(Iterable<?> iterable) {
        return this.wrapped.join(iterable);
    }
}
