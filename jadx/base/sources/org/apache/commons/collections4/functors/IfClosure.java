package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IfClosure<T> implements Closure<T>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super T> iFalseClosure;
    private final Predicate<? super T> iPredicate;
    private final Closure<? super T> iTrueClosure;

    public IfClosure(Predicate<? super T> predicate, Closure<? super T> closure) {
        this(predicate, closure, NOPClosure.nopClosure());
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return ifClosure(predicate, closure, NOPClosure.nopClosure());
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        if (this.iPredicate.test(t)) {
            this.iTrueClosure.accept(t);
        } else {
            this.iFalseClosure.accept(t);
        }
    }

    public Closure<? super T> getFalseClosure() {
        return this.iFalseClosure;
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    public Closure<? super T> getTrueClosure() {
        return this.iTrueClosure;
    }

    public IfClosure(Predicate<? super T> predicate, Closure<? super T> closure, Closure<? super T> closure2) {
        this.iPredicate = predicate;
        this.iTrueClosure = closure;
        this.iFalseClosure = closure2;
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(closure, "trueClosure");
        Objects.requireNonNull(closure2, "falseClosure");
        return new IfClosure(predicate, closure, closure2);
    }
}
