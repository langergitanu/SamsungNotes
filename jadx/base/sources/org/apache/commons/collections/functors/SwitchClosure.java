package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SwitchClosure implements Closure, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure[] iClosures;
    private final Closure iDefault;
    private final Predicate[] iPredicates;

    public SwitchClosure(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        this.iPredicates = predicateArr;
        this.iClosures = closureArr;
        this.iDefault = closure == null ? NOPClosure.INSTANCE : closure;
    }

    public static Closure getInstance(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length == closureArr.length) {
            return predicateArr.length == 0 ? closure == null ? NOPClosure.INSTANCE : closure : new SwitchClosure(FunctorUtils.copy(predicateArr), FunctorUtils.copy(closureArr), closure);
        }
        throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                this.iDefault.execute(obj);
                return;
            } else {
                if (predicateArr[i].evaluate(obj)) {
                    this.iClosures[i].execute(obj);
                    return;
                }
                i++;
            }
        }
    }

    public Closure[] getClosures() {
        return this.iClosures;
    }

    public Closure getDefaultClosure() {
        return this.iDefault;
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public static Closure getInstance(Map map) {
        if (map != null) {
            if (map.size() == 0) {
                return NOPClosure.INSTANCE;
            }
            Closure closure = (Closure) map.remove(null);
            int size = map.size();
            if (size == 0) {
                return closure == null ? NOPClosure.INSTANCE : closure;
            }
            Closure[] closureArr = new Closure[size];
            Predicate[] predicateArr = new Predicate[size];
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                predicateArr[i] = (Predicate) entry.getKey();
                closureArr[i] = (Closure) entry.getValue();
                i++;
            }
            return new SwitchClosure(predicateArr, closureArr, closure);
        }
        throw new IllegalArgumentException("The predicate and closure map must not be null");
    }
}
