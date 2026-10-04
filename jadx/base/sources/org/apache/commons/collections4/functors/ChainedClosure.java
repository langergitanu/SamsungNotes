package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChainedClosure<T> implements Closure<T>, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure<? super T>[] iClosures;

    private ChainedClosure(boolean z, Closure<? super T>... closureArr) {
        this.iClosures = z ? (Closure[]) FunctorUtils.copy(closureArr) : closureArr;
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        FunctorUtils.validate(closureArr);
        return closureArr.length == 0 ? NOPClosure.nopClosure() : new ChainedClosure(closureArr);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        for (Closure<? super T> closure : this.iClosures) {
            closure.accept(t);
        }
    }

    public Closure<? super T>[] getClosures() {
        return (Closure[]) FunctorUtils.copy(this.iClosures);
    }

    public ChainedClosure(Closure<? super T>... closureArr) {
        this(true, closureArr);
    }

    public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> collection) {
        Objects.requireNonNull(collection, "closures");
        if (collection.isEmpty()) {
            return NOPClosure.nopClosure();
        }
        Closure[] closureArr = new Closure[collection.size()];
        Iterator<? extends Closure<? super E>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            closureArr[i] = it.next();
            i++;
        }
        FunctorUtils.validate(closureArr);
        return new ChainedClosure(false, closureArr);
    }
}
