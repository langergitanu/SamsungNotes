package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ExceptionTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new ExceptionTransformer();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionTransformer() {
    }

    public static Transformer getInstance() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        throw new FunctorException("ExceptionTransformer invoked");
    }
}
