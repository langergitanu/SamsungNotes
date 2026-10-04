package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ForClosure<T> implements Closure<T> {
    private final Closure<? super T> iClosure;
    private final int iCount;

    public ForClosure(int i, Closure<? super T> closure) {
        this.iCount = i;
        this.iClosure = closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> forClosure(int i, Closure<? super E> closure) {
        return (i <= 0 || closure == 0) ? NOPClosure.nopClosure() : i == 1 ? closure : new ForClosure(i, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        for (int i = 0; i < this.iCount; i++) {
            this.iClosure.accept(t);
        }
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
