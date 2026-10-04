package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FactoryTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory iFactory;

    public FactoryTransformer(Factory factory) {
        this.iFactory = factory;
    }

    public static Transformer getInstance(Factory factory) {
        if (factory != null) {
            return new FactoryTransformer(factory);
        }
        throw new IllegalArgumentException("Factory must not be null");
    }

    public Factory getFactory() {
        return this.iFactory;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return this.iFactory.create();
    }
}
