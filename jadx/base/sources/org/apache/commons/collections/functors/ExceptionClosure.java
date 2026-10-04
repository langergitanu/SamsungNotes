package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.FunctorException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ExceptionClosure implements Closure, Serializable {
    public static final Closure INSTANCE = new ExceptionClosure();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionClosure() {
    }

    public static Closure getInstance() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        throw new FunctorException("ExceptionClosure invoked");
    }
}
