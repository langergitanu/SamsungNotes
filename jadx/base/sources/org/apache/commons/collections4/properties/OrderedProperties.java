package org.apache.commons.collections4.properties;

import androidx.emoji2.text.flatbuffer.C2747a;
import com.opencsv.bean.C6618c;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OrderedProperties extends Properties {
    private static final long serialVersionUID = 1;
    private final LinkedHashSet<Object> orderedKeys = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractMap.SimpleEntry lambda$entrySet$0(Object obj) {
        return new AbstractMap.SimpleEntry(obj, get(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forEach$1(BiConsumer biConsumer, Object obj) {
        biConsumer.accept(obj, get(obj));
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void clear() {
        this.orderedKeys.clear();
        super.clear();
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object compute(Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        Object objCompute;
        objCompute = super.compute(obj, biFunction);
        if (objCompute != null) {
            this.orderedKeys.add(obj);
        }
        return objCompute;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object computeIfAbsent(Object obj, Function<? super Object, ? extends Object> function) {
        Object objComputeIfAbsent;
        objComputeIfAbsent = super.computeIfAbsent(obj, function);
        if (objComputeIfAbsent != null) {
            this.orderedKeys.add(obj);
        }
        return objComputeIfAbsent;
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return (Set) this.orderedKeys.stream().map(new C0332a(this, 14)).collect(Collectors.toCollection(new C2747a(12)));
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void forEach(BiConsumer<? super Object, ? super Object> biConsumer) {
        Objects.requireNonNull(biConsumer);
        this.orderedKeys.forEach(new C6618c(this, biConsumer, 10));
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Object> keySet() {
        return this.orderedKeys;
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(this.orderedKeys);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object merge(Object obj, Object obj2, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        this.orderedKeys.add(obj);
        return super.merge(obj, obj2, biFunction);
    }

    @Override // java.util.Properties
    public Enumeration<?> propertyNames() {
        return Collections.enumeration(this.orderedKeys);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object obj, Object obj2) {
        Object objPut;
        objPut = super.put(obj, obj2);
        if (objPut == null) {
            this.orderedKeys.add(obj);
        }
        return objPut;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void putAll(Map<? extends Object, ? extends Object> map) {
        this.orderedKeys.addAll(map.keySet());
        super.putAll(map);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object putIfAbsent(Object obj, Object obj2) {
        Object objPutIfAbsent;
        objPutIfAbsent = super.putIfAbsent(obj, obj2);
        if (objPutIfAbsent == null) {
            this.orderedKeys.add(obj);
        }
        return objPutIfAbsent;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object obj) {
        Object objRemove;
        objRemove = super.remove(obj);
        if (objRemove != null) {
            this.orderedKeys.remove(obj);
        }
        return objRemove;
    }

    @Override // java.util.Hashtable
    public synchronized String toString() {
        int size = size() - 1;
        if (size == -1) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
        sb.append('{');
        int i = 0;
        while (true) {
            Map.Entry<Object, Object> next = it.next();
            Object key = next.getKey();
            Object value = next.getValue();
            sb.append(key == this ? "(this Map)" : key.toString());
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value.toString());
            if (i == size) {
                sb.append('}');
                return sb.toString();
            }
            sb.append(SQLKeyword.COMMA);
            i++;
        }
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean remove(Object obj, Object obj2) {
        boolean zRemove;
        zRemove = super.remove(obj, obj2);
        if (zRemove) {
            this.orderedKeys.remove(obj);
        }
        return zRemove;
    }
}
