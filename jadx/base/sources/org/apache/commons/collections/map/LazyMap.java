package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.FactoryTransformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazyMap extends AbstractMapDecorator implements Map, Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer factory;

    public LazyMap(Map map, Factory factory) {
        super(map);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = FactoryTransformer.getInstance(factory);
    }

    public static Map decorate(Map map, Factory factory) {
        return new LazyMap(map, factory);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Object get(Object obj) {
        if (this.map.containsKey(obj)) {
            return this.map.get(obj);
        }
        Object objTransform = this.factory.transform(obj);
        this.map.put(obj, objTransform);
        return objTransform;
    }

    public static Map decorate(Map map, Transformer transformer) {
        return new LazyMap(map, transformer);
    }

    public LazyMap(Map map, Transformer transformer) {
        super(map);
        if (transformer != null) {
            this.factory = transformer;
            return;
        }
        throw new IllegalArgumentException("Factory must not be null");
    }
}
