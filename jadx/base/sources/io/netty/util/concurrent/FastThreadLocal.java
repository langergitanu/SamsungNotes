package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FastThreadLocal<V> {
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set setNewSetFromMap;
        int i = InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX;
        Object objIndexedVariable = internalThreadLocalMap.indexedVariable(i);
        if (objIndexedVariable == InternalThreadLocalMap.UNSET || objIndexedVariable == null) {
            setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i, setNewSetFromMap);
        } else {
            setNewSetFromMap = (Set) objIndexedVariable;
        }
        setNewSetFromMap.add(fastThreadLocal);
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) throws Throwable {
        V vInitialValue;
        try {
            vInitialValue = initialValue();
        } catch (Exception e) {
            e = e;
            vInitialValue = null;
        }
        try {
            if (vInitialValue == InternalThreadLocalMap.UNSET) {
                throw new IllegalArgumentException("InternalThreadLocalMap.UNSET can not be initial value.");
            }
        } catch (Exception e2) {
            e = e2;
            PlatformDependent.throwException(e);
        }
        internalThreadLocalMap.setIndexedVariable(this.index, vInitialValue);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return vInitialValue;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object objIndexedVariable = ifSet.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
            if (objIndexedVariable != null && objIndexedVariable != InternalThreadLocalMap.UNSET) {
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) ((Set) objIndexedVariable).toArray(new FastThreadLocal[0])) {
                    fastThreadLocal.remove(ifSet);
                }
            }
        } finally {
            InternalThreadLocalMap.remove();
        }
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object objIndexedVariable = internalThreadLocalMap.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
        if (objIndexedVariable == InternalThreadLocalMap.UNSET || objIndexedVariable == null) {
            return;
        }
        ((Set) objIndexedVariable).remove(fastThreadLocal);
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    public static int size() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return 0;
        }
        return ifSet.size();
    }

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V v = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v != InternalThreadLocalMap.UNSET ? v : initialize(internalThreadLocalMap);
    }

    public final V getIfExists() {
        V v;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null || (v = (V) ifSet.indexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return null;
        }
        return v;
    }

    public V initialValue() {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    public final void remove() throws Throwable {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v) throws Throwable {
        if (v != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v);
        } else {
            remove();
        }
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap) {
        return internalThreadLocalMap != null && internalThreadLocalMap.isIndexedVariableSet(this.index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap internalThreadLocalMap) throws Throwable {
        Object objRemoveIndexedVariable;
        if (internalThreadLocalMap == null || (objRemoveIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return;
        }
        removeFromVariablesToRemove(internalThreadLocalMap, this);
        try {
            onRemoval(objRemoveIndexedVariable);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
        }
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v != InternalThreadLocalMap.UNSET ? v : initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v) throws Throwable {
        if (v != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v);
        } else {
            remove(internalThreadLocalMap);
        }
    }

    public void onRemoval(V v) {
    }
}
