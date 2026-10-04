package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class MapTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 862391807045468939L;
    private final Map iMap;

    private MapTransformer(Map map) {
        this.iMap = map;
    }

    public static Transformer getInstance(Map map) {
        return map == null ? ConstantTransformer.NULL_INSTANCE : new MapTransformer(map);
    }

    public Map getMap() {
        return this.iMap;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return this.iMap.get(obj);
    }
}
