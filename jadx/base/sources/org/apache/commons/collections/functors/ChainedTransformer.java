package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChainedTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer[] iTransformers;

    public ChainedTransformer(Transformer[] transformerArr) {
        this.iTransformers = transformerArr;
    }

    public static Transformer getInstance(Transformer[] transformerArr) {
        FunctorUtils.validate(transformerArr);
        return transformerArr.length == 0 ? NOPTransformer.INSTANCE : new ChainedTransformer(FunctorUtils.copy(transformerArr));
    }

    public Transformer[] getTransformers() {
        return this.iTransformers;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        int i = 0;
        while (true) {
            Transformer[] transformerArr = this.iTransformers;
            if (i >= transformerArr.length) {
                return obj;
            }
            obj = transformerArr[i].transform(obj);
            i++;
        }
    }

    public static Transformer getInstance(Collection collection) {
        if (collection != null) {
            if (collection.size() == 0) {
                return NOPTransformer.INSTANCE;
            }
            Transformer[] transformerArr = new Transformer[collection.size()];
            Iterator it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                transformerArr[i] = (Transformer) it.next();
                i++;
            }
            FunctorUtils.validate(transformerArr);
            return new ChainedTransformer(transformerArr);
        }
        throw new IllegalArgumentException("Transformer collection must not be null");
    }

    public static Transformer getInstance(Transformer transformer, Transformer transformer2) {
        if (transformer != null && transformer2 != null) {
            return new ChainedTransformer(new Transformer[]{transformer, transformer2});
        }
        throw new IllegalArgumentException("Transformers must not be null");
    }
}
