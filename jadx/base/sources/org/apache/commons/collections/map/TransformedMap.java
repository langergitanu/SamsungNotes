package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedMap extends AbstractInputCheckedMapDecorator implements Serializable {
    private static final long serialVersionUID = 7023152376788900464L;
    protected final Transformer keyTransformer;
    protected final Transformer valueTransformer;

    public TransformedMap(Map map, Transformer transformer, Transformer transformer2) {
        super(map);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    public static Map decorate(Map map, Transformer transformer, Transformer transformer2) {
        return new TransformedMap(map, transformer, transformer2);
    }

    public static Map decorateTransform(Map map, Transformer transformer, Transformer transformer2) {
        TransformedMap transformedMap = new TransformedMap(map, transformer, transformer2);
        if (map.size() > 0) {
            Map mapTransformMap = transformedMap.transformMap(map);
            transformedMap.clear();
            transformedMap.getMap().putAll(mapTransformMap);
        }
        return transformedMap;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections.map.AbstractInputCheckedMapDecorator
    public Object checkSetValue(Object obj) {
        return this.valueTransformer.transform(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractInputCheckedMapDecorator
    public boolean isSetValueChecking() {
        return this.valueTransformer != null;
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        return getMap().put(transformKey(obj), transformValue(obj2));
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        getMap().putAll(transformMap(map));
    }

    public Object transformKey(Object obj) {
        Transformer transformer = this.keyTransformer;
        return transformer == null ? obj : transformer.transform(obj);
    }

    public Map transformMap(Map map) {
        if (map.isEmpty()) {
            return map;
        }
        LinkedMap linkedMap = new LinkedMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            linkedMap.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
        }
        return linkedMap;
    }

    public Object transformValue(Object obj) {
        Transformer transformer = this.valueTransformer;
        return transformer == null ? obj : transformer.transform(obj);
    }
}
