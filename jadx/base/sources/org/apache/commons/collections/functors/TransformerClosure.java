package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformerClosure implements Closure, Serializable {
    private static final long serialVersionUID = -5194992589193388969L;
    private final Transformer iTransformer;

    public TransformerClosure(Transformer transformer) {
        this.iTransformer = transformer;
    }

    public static Closure getInstance(Transformer transformer) {
        return transformer == null ? NOPClosure.INSTANCE : new TransformerClosure(transformer);
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        this.iTransformer.transform(obj);
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
