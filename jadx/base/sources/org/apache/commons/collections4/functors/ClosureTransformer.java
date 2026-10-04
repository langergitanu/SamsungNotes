package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ClosureTransformer<T> implements Transformer<T, T>, Serializable {
    private static final long serialVersionUID = 478466901448617286L;
    private final Closure<? super T> iClosure;

    public ClosureTransformer(Closure<? super T> closure) {
        this.iClosure = closure;
    }

    public static <T> Transformer<T, T> closureTransformer(Closure<? super T> closure) {
        Objects.requireNonNull(closure, "closure");
        return new ClosureTransformer(closure);
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        this.iClosure.accept(t);
        return t;
    }
}
