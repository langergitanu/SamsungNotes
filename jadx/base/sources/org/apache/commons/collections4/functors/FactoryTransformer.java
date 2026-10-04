package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FactoryTransformer<T, R> implements Transformer<T, R>, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory<? extends R> iFactory;

    public FactoryTransformer(Factory<? extends R> factory) {
        this.iFactory = factory;
    }

    public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> factory) {
        Objects.requireNonNull(factory, "factory");
        return new FactoryTransformer(factory);
    }

    public Factory<? extends R> getFactory() {
        return this.iFactory;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        return this.iFactory.get();
    }
}
