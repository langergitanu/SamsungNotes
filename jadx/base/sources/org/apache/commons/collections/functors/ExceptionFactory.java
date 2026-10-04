package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ExceptionFactory implements Factory, Serializable {
    public static final Factory INSTANCE = new ExceptionFactory();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionFactory() {
    }

    public static Factory getInstance() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections.Factory
    public Object create() {
        throw new FunctorException("ExceptionFactory invoked");
    }
}
