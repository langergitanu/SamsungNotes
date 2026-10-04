package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ExceptionTransformer<T, R> implements Transformer<T, R>, Serializable {
    public static final Transformer INSTANCE = new ExceptionTransformer();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionTransformer() {
    }

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        throw new FunctorException("ExceptionTransformer invoked");
    }
}
