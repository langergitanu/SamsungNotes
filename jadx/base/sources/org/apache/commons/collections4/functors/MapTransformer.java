package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class MapTransformer<T, R> implements Transformer<T, R>, Serializable {
    private static final long serialVersionUID = 862391807045468939L;
    private final Map<? super T, ? extends R> iMap;

    private MapTransformer(Map<? super T, ? extends R> map) {
        this.iMap = map;
    }

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> map) {
        return map == null ? ConstantTransformer.nullTransformer() : new MapTransformer(map);
    }

    public Map<? super T, ? extends R> getMap() {
        return this.iMap;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        return this.iMap.get(t);
    }
}
