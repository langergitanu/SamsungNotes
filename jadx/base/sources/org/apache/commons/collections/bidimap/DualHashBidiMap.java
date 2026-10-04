package org.apache.commons.collections.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.BidiMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DualHashBidiMap extends AbstractDualBidiMap implements Serializable {
    private static final long serialVersionUID = 721969328361808L;

    public DualHashBidiMap() {
        super(new HashMap(), new HashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.maps[0] = new HashMap();
        this.maps[1] = new HashMap();
        putAll((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.maps[0]);
    }

    @Override // org.apache.commons.collections.bidimap.AbstractDualBidiMap
    public BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap) {
        return new DualHashBidiMap(map, map2, bidiMap);
    }

    public DualHashBidiMap(Map map) {
        super(new HashMap(), new HashMap());
        putAll(map);
    }

    public DualHashBidiMap(Map map, Map map2, BidiMap bidiMap) {
        super(map, map2, bidiMap);
    }
}
