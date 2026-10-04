package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SwitchTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer iDefault;
    private final Predicate[] iPredicates;
    private final Transformer[] iTransformers;

    public SwitchTransformer(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        this.iPredicates = predicateArr;
        this.iTransformers = transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
    }

    public static Transformer getInstance(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length == transformerArr.length) {
            return predicateArr.length == 0 ? transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer : new SwitchTransformer(FunctorUtils.copy(predicateArr), FunctorUtils.copy(transformerArr), transformer);
        }
        throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
    }

    public Transformer getDefaultTransformer() {
        return this.iDefault;
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public Transformer[] getTransformers() {
        return this.iTransformers;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                return this.iDefault.transform(obj);
            }
            if (predicateArr[i].evaluate(obj)) {
                return this.iTransformers[i].transform(obj);
            }
            i++;
        }
    }

    public static Transformer getInstance(Map map) {
        if (map != null) {
            if (map.size() == 0) {
                return ConstantTransformer.NULL_INSTANCE;
            }
            Transformer transformer = (Transformer) map.remove(null);
            int size = map.size();
            if (size == 0) {
                return transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
            }
            Transformer[] transformerArr = new Transformer[size];
            Predicate[] predicateArr = new Predicate[size];
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                predicateArr[i] = (Predicate) entry.getKey();
                transformerArr[i] = (Transformer) entry.getValue();
                i++;
            }
            return new SwitchTransformer(predicateArr, transformerArr, transformer);
        }
        throw new IllegalArgumentException("The predicate and transformer map must not be null");
    }
}
