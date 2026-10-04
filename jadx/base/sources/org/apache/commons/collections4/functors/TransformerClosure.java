package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformerClosure<T> implements Closure<T>, Serializable {
    private static final long serialVersionUID = -5194992589193388969L;
    private final Transformer<? super T, ?> iTransformer;

    public TransformerClosure(Transformer<? super T, ?> transformer) {
        this.iTransformer = transformer;
    }

    public static <E> Closure<E> transformerClosure(Transformer<? super E, ?> transformer) {
        return transformer == null ? NOPClosure.nopClosure() : new TransformerClosure(transformer);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(T t) {
        this.iTransformer.apply(t);
    }

    public Transformer<? super T, ?> getTransformer() {
        return this.iTransformer;
    }
}
