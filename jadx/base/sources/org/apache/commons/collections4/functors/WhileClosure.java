package org.apache.commons.collections4.functors;

import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WhileClosure<T> implements Closure<T> {
    private final Closure<? super T> iClosure;
    private final boolean iDoLoop;
    private final Predicate<? super T> iPredicate;

    public WhileClosure(Predicate<? super T> predicate, Closure<? super T> closure, boolean z) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z;
    }

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(closure, "closure");
        return new WhileClosure(predicate, closure, z);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        if (this.iDoLoop) {
            this.iClosure.accept(t);
        }
        while (this.iPredicate.test(t)) {
            this.iClosure.accept(t);
        }
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
