package org.apache.commons.collections.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.AbstractHashedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultiKeyMap implements IterableMap, Serializable {
    private static final long serialVersionUID = -1788199231038721040L;
    protected final AbstractHashedMap map;

    public MultiKeyMap() {
        this.map = new HashedMap();
    }

    public static MultiKeyMap decorate(AbstractHashedMap abstractHashedMap) {
        if (abstractHashedMap == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        if (abstractHashedMap.size() <= 0) {
            return new MultiKeyMap(abstractHashedMap);
        }
        throw new IllegalArgumentException("Map must be empty");
    }

    public void checkKey(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Key must not be null");
        }
        if (!(obj instanceof MultiKey)) {
            throw new ClassCastException("Key must be a MultiKey");
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new MultiKeyMap((AbstractHashedMap) this.map.clone());
    }

    public boolean containsKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.map.equals(obj);
    }

    public Object get(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int hash(Object obj, Object obj2) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i4 = i2 + (i2 << 4);
        return i4 ^ (i4 >>> 10);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 2 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.map.keySet();
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return this.map.mapIterator();
    }

    public Object put(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        for (AbstractHashedMap.HashEntry hashEntry = this.map.data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj3);
                return value;
            }
        }
        this.map.addMapping(iHashIndex, iHash, new MultiKey(obj, obj2), obj3);
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey(it.next());
        }
        this.map.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public boolean removeAll(Object obj) {
        MapIterator mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 1) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key == null) {
                        mapIterator.remove();
                        z = true;
                    }
                } else if (obj.equals(key)) {
                    mapIterator.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.map.toString();
    }

    @Override // java.util.Map
    public Collection values() {
        return this.map.values();
    }

    public MultiKeyMap(AbstractHashedMap abstractHashedMap) {
        this.map = abstractHashedMap;
    }

    public int hash(Object obj, Object obj2, Object obj3) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i4 = i2 + (i2 << 4);
        return i4 ^ (i4 >>> 10);
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 3 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null) && (obj2 != null ? obj2.equals(multiKey.getKey(1)) : multiKey.getKey(1) == null)) {
            Object key = multiKey.getKey(2);
            if (obj3 != null ? obj3.equals(key) : key == null) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 4 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null) && (obj2 != null ? obj2.equals(multiKey.getKey(1)) : multiKey.getKey(1) == null)) {
            Object key = multiKey.getKey(2);
            if (obj3 != null ? obj3.equals(key) : key == null) {
                Object key2 = multiKey.getKey(3);
                if (obj4 != null ? obj4.equals(key2) : key2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i4 = i2 + (i2 << 4);
        return i4 ^ (i4 >>> 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean removeAll(Object obj, Object obj2) {
        MapIterator mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 2) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key == null) {
                        Object key2 = multiKey.getKey(1);
                        if (obj2 != null) {
                            if (key2 == null) {
                                mapIterator.remove();
                                z = true;
                            }
                        } else if (obj2.equals(key2)) {
                            mapIterator.remove();
                            z = true;
                        }
                    }
                } else if (obj.equals(key)) {
                    Object key22 = multiKey.getKey(1);
                    if (obj2 != null) {
                    }
                }
            }
        }
        return z;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 5 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null) && (obj2 != null ? obj2.equals(multiKey.getKey(1)) : multiKey.getKey(1) == null)) {
            Object key = multiKey.getKey(2);
            if (obj3 != null ? obj3.equals(key) : key == null) {
                Object key2 = multiKey.getKey(3);
                if (obj4 != null ? obj4.equals(key2) : key2 == null) {
                    Object key3 = multiKey.getKey(4);
                    if (obj5 != null ? obj5.equals(key3) : key3 == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Object remove(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    return true;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry = hashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return false;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        for (AbstractHashedMap.HashEntry hashEntry = this.map.data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj4);
                return value;
            }
        }
        this.map.addMapping(iHashIndex, iHash, new MultiKey(obj, obj2, obj3), obj4);
        return null;
    }

    public int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        if (obj5 != null) {
            iHashCode ^= obj5.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i4 = i2 + (i2 << 4);
        return i4 ^ (i4 >>> 10);
    }

    public Object get(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    return hashEntry.getValue();
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry = hashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean removeAll(Object obj, Object obj2, Object obj3) {
        MapIterator mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 3) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key == null) {
                        Object key2 = multiKey.getKey(1);
                        if (obj2 != null) {
                            if (key2 == null) {
                                Object key3 = multiKey.getKey(2);
                                if (obj3 != null) {
                                    if (key3 == null) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                } else if (obj3.equals(key3)) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            }
                        } else if (obj2.equals(key2)) {
                            Object key32 = multiKey.getKey(2);
                            if (obj3 != null) {
                            }
                        }
                    }
                } else if (obj.equals(key)) {
                    Object key22 = multiKey.getKey(1);
                    if (obj2 != null) {
                    }
                }
            }
        }
        return z;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        MultiKeyMap multiKeyMap = this;
        AbstractHashedMap abstractHashedMap = multiKeyMap.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj6 = obj;
                if (multiKeyMap.isEqualKey(hashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return true;
                }
            } else {
                obj6 = obj;
            }
            hashEntry = hashEntry.next;
            multiKeyMap = this;
            obj = obj6;
        }
        return false;
    }

    public Object remove(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[iHashIndex];
        AbstractHashedMap.HashEntry hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    Object value = hashEntry.getValue();
                    this.map.removeMapping(hashEntry, iHashIndex, hashEntry2);
                    return value;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry2 = hashEntry;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
            hashEntry = hashEntry.next;
            obj = obj5;
        }
        return null;
    }

    public Object get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        MultiKeyMap multiKeyMap = this;
        AbstractHashedMap abstractHashedMap = multiKeyMap.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(iHash, hashEntryArr.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj6 = obj;
                if (multiKeyMap.isEqualKey(hashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return hashEntry.getValue();
                }
            } else {
                obj6 = obj;
            }
            hashEntry = hashEntry.next;
            multiKeyMap = this;
            obj = obj6;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean removeAll(Object obj, Object obj2, Object obj3, Object obj4) {
        MapIterator mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 4) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key == null) {
                        Object key2 = multiKey.getKey(1);
                        if (obj2 != null) {
                            if (key2 == null) {
                                Object key3 = multiKey.getKey(2);
                                if (obj3 != null) {
                                    if (key3 == null) {
                                        Object key4 = multiKey.getKey(3);
                                        if (obj4 != null) {
                                            if (key4 == null) {
                                                mapIterator.remove();
                                                z = true;
                                            }
                                        } else if (obj4.equals(key4)) {
                                            mapIterator.remove();
                                            z = true;
                                        }
                                    }
                                } else if (obj3.equals(key3)) {
                                    Object key42 = multiKey.getKey(3);
                                    if (obj4 != null) {
                                    }
                                }
                            }
                        } else if (obj2.equals(key2)) {
                            Object key32 = multiKey.getKey(2);
                            if (obj3 != null) {
                            }
                        }
                    }
                } else if (obj.equals(key)) {
                    Object key22 = multiKey.getKey(1);
                    if (obj2 != null) {
                    }
                }
            }
        }
        return z;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[iHashIndex];
        while (hashEntry != null) {
            Object obj6 = obj;
            Object obj7 = obj2;
            Object obj8 = obj3;
            Object obj9 = obj4;
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj6, obj7, obj8, obj9)) {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj5);
                return value;
            }
            hashEntry = hashEntry.next;
            obj = obj6;
            obj2 = obj7;
            obj3 = obj8;
            obj4 = obj9;
        }
        this.map.addMapping(iHashIndex, iHash, new MultiKey(obj, obj2, obj3, obj4), obj5);
        return null;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public Object remove(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.map.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3, obj4, obj5)) {
                Object value = hashEntry2.getValue();
                this.map.removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object obj7;
        MultiKeyMap multiKeyMap;
        AbstractHashedMap.HashEntry hashEntry;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        MultiKeyMap multiKeyMap2 = this;
        AbstractHashedMap abstractHashedMap = multiKeyMap2.map;
        int iHashIndex = abstractHashedMap.hashIndex(iHash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry2 = multiKeyMap2.map.data[iHashIndex];
        while (hashEntry2 != null) {
            if (hashEntry2.hashCode == iHash) {
                Object obj9 = obj;
                Object obj10 = obj2;
                boolean zIsEqualKey = multiKeyMap2.isEqualKey(hashEntry2, obj9, obj10, obj3, obj4, obj5);
                multiKeyMap = multiKeyMap2;
                hashEntry = hashEntry2;
                obj8 = obj9;
                obj7 = obj10;
                if (zIsEqualKey) {
                    Object value = hashEntry.getValue();
                    multiKeyMap.map.updateEntry(hashEntry, obj6);
                    return value;
                }
            } else {
                obj7 = obj2;
                multiKeyMap = multiKeyMap2;
                hashEntry = hashEntry2;
                obj8 = obj;
            }
            AbstractHashedMap.HashEntry hashEntry3 = hashEntry.next;
            Object obj11 = obj8;
            hashEntry2 = hashEntry3;
            obj = obj11;
            multiKeyMap2 = multiKeyMap;
            obj2 = obj7;
        }
        multiKeyMap2.map.addMapping(iHashIndex, iHash, new MultiKey(obj, obj2, obj3, obj4, obj5), obj6);
        return null;
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        checkKey(obj);
        return this.map.put(obj, obj2);
    }
}
