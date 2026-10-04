package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Closure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChainedClosure implements Closure, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure[] iClosures;

    public ChainedClosure(Closure[] closureArr) {
        this.iClosures = closureArr;
    }

    public static Closure getInstance(Closure[] closureArr) {
        FunctorUtils.validate(closureArr);
        return closureArr.length == 0 ? NOPClosure.INSTANCE : new ChainedClosure(FunctorUtils.copy(closureArr));
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        int i = 0;
        while (true) {
            Closure[] closureArr = this.iClosures;
            if (i >= closureArr.length) {
                return;
            }
            closureArr[i].execute(obj);
            i++;
        }
    }

    public Closure[] getClosures() {
        return this.iClosures;
    }

    public static Closure getInstance(Collection collection) {
        if (collection != null) {
            if (collection.size() == 0) {
                return NOPClosure.INSTANCE;
            }
            Closure[] closureArr = new Closure[collection.size()];
            Iterator it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                closureArr[i] = (Closure) it.next();
                i++;
            }
            FunctorUtils.validate(closureArr);
            return new ChainedClosure(closureArr);
        }
        throw new IllegalArgumentException("Closure collection must not be null");
    }

    public static Closure getInstance(Closure closure, Closure closure2) {
        if (closure != null && closure2 != null) {
            return new ChainedClosure(new Closure[]{closure, closure2});
        }
        throw new IllegalArgumentException("Closures must not be null");
    }
}
