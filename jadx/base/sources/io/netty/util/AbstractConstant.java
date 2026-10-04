package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();

    /* JADX INFO: renamed from: id */
    private final int f8958id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    public AbstractConstant(int i, String str) {
        this.f8958id = i;
        this.name = str;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // io.netty.util.Constant
    /* JADX INFO: renamed from: id */
    public final int mo13776id() {
        return this.f8958id;
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    public final String toString() {
        return name();
    }

    @Override // java.lang.Comparable
    public final int compareTo(T t) {
        if (this == t) {
            return 0;
        }
        int iHashCode = hashCode() - t.hashCode();
        if (iHashCode != 0) {
            return iHashCode;
        }
        long j = this.uniquifier;
        long j2 = t.uniquifier;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
