package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConstantTransformer<T, R> implements Transformer<T, R>, Serializable {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer(null);
    private static final long serialVersionUID = 6374440726369055124L;
    private final R iConstant;

    public ConstantTransformer(R r) {
        this.iConstant = r;
    }

    public static <I, O> Transformer<I, O> constantTransformer(O o) {
        return o == null ? nullTransformer() : new ConstantTransformer(o);
    }

    public static <I, O> Transformer<I, O> nullTransformer() {
        return NULL_INSTANCE;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConstantTransformer) {
            return Objects.equals(((ConstantTransformer) obj).getConstant(), getConstant());
        }
        return false;
    }

    public R getConstant() {
        return this.iConstant;
    }

    public int hashCode() {
        if (getConstant() != null) {
            return getConstant().hashCode() | (-144463148);
        }
        return -144463148;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        return this.iConstant;
    }
}
