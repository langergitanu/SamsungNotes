package com.vladsch.flexmark.util.dependency;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import com.vladsch.flexmark.util.misc.Ref;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DependencyResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <D extends Dependent> List<List<D>> resolveDependencies(@NotNull List<D> list, @Nullable Function<DependentItemMap<D>, DependentItemMap<D>> function, @Nullable Function<? super D, Class<?>> function2) {
        if (list.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        if (list.size() == 1) {
            return Collections.singletonList(list);
        }
        DependentItemMap<D> dependentItemMap = new DependentItemMap<>(list.size());
        if (function2 == null) {
            function2 = new C11419a(13);
        }
        for (D d : list) {
            Class<?> clsApply = function2.apply(d);
            if (dependentItemMap.containsKey(clsApply)) {
                throw new IllegalStateException(AbstractC0541b.m768j(clsApply, "Dependent class ", " is duplicated. Only one instance can be present in the list"));
            }
            dependentItemMap.put(clsApply, new DependentItem(dependentItemMap.size(), d, function2.apply(d), d.affectsGlobalScope()));
        }
        Iterator it = dependentItemMap.iterator();
        while (it.hasNext()) {
            DependentItem dependentItem = (DependentItem) ((Map.Entry) it.next()).getValue();
            Set<Class<?>> afterDependents = ((Dependent) dependentItem.dependent).getAfterDependents();
            if (afterDependents != null && afterDependents.size() > 0) {
                for (Class<?> cls : afterDependents) {
                    if (cls == LastDependent.class) {
                        ReversibleIterator it2 = dependentItemMap.valueIterable().iterator();
                        while (it2.hasNext()) {
                            DependentItem dependentItem2 = (DependentItem) it2.next();
                            if (dependentItem2 != null && dependentItem2 != dependentItem) {
                                dependentItem.addDependency(dependentItem2);
                                dependentItem2.addDependent(dependentItem);
                            }
                        }
                    } else {
                        DependentItem dependentItem3 = dependentItemMap.get(cls);
                        if (dependentItem3 != null) {
                            dependentItem.addDependency(dependentItem3);
                            dependentItem3.addDependent(dependentItem);
                        }
                    }
                }
            }
            Set<Class<?>> beforeDependents = ((Dependent) dependentItem.dependent).getBeforeDependents();
            if (beforeDependents != null && beforeDependents.size() > 0) {
                for (Class<?> cls2 : beforeDependents) {
                    if (cls2 == FirstDependent.class) {
                        ReversibleIterator it3 = dependentItemMap.valueIterable().iterator();
                        while (it3.hasNext()) {
                            DependentItem dependentItem4 = (DependentItem) it3.next();
                            if (dependentItem4 != null && dependentItem4 != dependentItem) {
                                dependentItem4.addDependency(dependentItem);
                                dependentItem.addDependent(dependentItem4);
                            }
                        }
                    } else {
                        DependentItem dependentItem5 = dependentItemMap.get(cls2);
                        if (dependentItem5 != null) {
                            dependentItem5.addDependency(dependentItem);
                            dependentItem.addDependent(dependentItem5);
                        }
                    }
                }
            }
        }
        if (function != null) {
            dependentItemMap = function.apply(dependentItemMap);
        }
        int size = dependentItemMap.size();
        BitSet bitSet = new BitSet(size);
        Ref ref = new Ref(bitSet);
        Iterator itValueIterator = dependentItemMap.valueIterator();
        while (itValueIterator.hasNext()) {
            DependentItem dependentItem6 = (DependentItem) itValueIterator.next();
            if (!dependentItem6.hasDependencies()) {
                ((BitSet) ref.value).set(dependentItem6.index);
            }
        }
        BitSet bitSet2 = new BitSet(size);
        bitSet2.set(0, dependentItemMap.size());
        ArrayList arrayList = new ArrayList();
        while (bitSet.nextSetBit(0) != -1) {
            ArrayList arrayList2 = new ArrayList();
            BitSet bitSet3 = new BitSet();
            while (true) {
                int iNextSetBit = bitSet.nextSetBit(0);
                if (iNextSetBit < 0) {
                    break;
                }
                bitSet.clear(iNextSetBit);
                DependentItem value = dependentItemMap.getValue(iNextSetBit);
                arrayList2.add((Dependent) value.dependent);
                bitSet2.clear(iNextSetBit);
                if (!value.hasDependents()) {
                    if (value.isGlobalScope) {
                        bitSet3.or(bitSet);
                        break;
                    }
                } else {
                    while (true) {
                        int iNextSetBit2 = value.dependents.nextSetBit(0);
                        if (iNextSetBit2 < 0) {
                            break;
                        }
                        value.dependents.clear(iNextSetBit2);
                        if (!dependentItemMap.getValue(iNextSetBit2).removeDependency(value)) {
                            if (value.isGlobalScope) {
                                bitSet3.set(iNextSetBit2);
                            } else {
                                bitSet.set(iNextSetBit2);
                            }
                        }
                    }
                }
            }
            arrayList.add(arrayList2);
            bitSet = bitSet3;
        }
        if (bitSet2.nextSetBit(0) == -1) {
            return arrayList;
        }
        throw new IllegalStateException("have dependents with dependency cycles" + bitSet2);
    }

    @NotNull
    public static <D extends Dependent> List<D> resolveFlatDependencies(@NotNull List<D> list, @Nullable Function<DependentItemMap<D>, DependentItemMap<D>> function, @Nullable Function<? super D, Class<?>> function2) {
        List listResolveDependencies = resolveDependencies(list, function, function2);
        if (listResolveDependencies.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        int size = 0;
        if (listResolveDependencies.size() == 1) {
            return (List) listResolveDependencies.get(0);
        }
        Iterator it = listResolveDependencies.iterator();
        while (it.hasNext()) {
            size += ((List) it.next()).size();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it2 = listResolveDependencies.iterator();
        while (it2.hasNext()) {
            arrayList.addAll((List) it2.next());
        }
        return arrayList;
    }
}
