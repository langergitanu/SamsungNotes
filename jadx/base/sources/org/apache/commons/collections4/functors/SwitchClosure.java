package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SwitchClosure<T> implements Closure<T>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super T>[] iClosures;
    private final Closure<? super T> iDefault;
    private final Predicate<? super T>[] iPredicates;

    private SwitchClosure(boolean z, Predicate<? super T>[] predicateArr, Closure<? super T>[] closureArr, Closure<? super T> closure) {
        this.iPredicates = z ? (Predicate[]) FunctorUtils.copy(predicateArr) : predicateArr;
        this.iClosures = z ? (Closure[]) FunctorUtils.copy(closureArr) : closureArr;
        this.iDefault = closure == null ? NOPClosure.nopClosure() : closure;
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        Objects.requireNonNull(map, "predicatesAndClosures");
        Closure<E> closureRemove = map.remove(null);
        int size = map.size();
        if (size == 0) {
            return closureRemove == null ? NOPClosure.nopClosure() : closureRemove;
        }
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry<Predicate<E>, Closure<E>> entry : map.entrySet()) {
            predicateArr[i] = entry.getKey();
            closureArr[i] = entry.getValue();
            i++;
        }
        return new SwitchClosure(false, predicateArr, closureArr, closureRemove);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        int i = 0;
        while (true) {
            Predicate<? super T>[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                this.iDefault.accept(t);
                return;
            } else {
                if (predicateArr[i].test(t)) {
                    this.iClosures[i].accept(t);
                    return;
                }
                i++;
            }
        }
    }

    public Closure<? super T>[] getClosures() {
        return (Closure[]) FunctorUtils.copy(this.iClosures);
    }

    public Closure<? super T> getDefaultClosure() {
        return this.iDefault;
    }

    public Predicate<? super T>[] getPredicates() {
        return (Predicate[]) FunctorUtils.copy(this.iPredicates);
    }

    public SwitchClosure(Predicate<? super T>[] predicateArr, Closure<? super T>[] closureArr, Closure<? super T> closure) {
        this(true, predicateArr, closureArr, closure);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length == closureArr.length) {
            if (predicateArr.length == 0) {
                return closure == 0 ? NOPClosure.nopClosure() : closure;
            }
            return new SwitchClosure(predicateArr, closureArr, closure);
        }
        throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
    }
}
