package com.vladsch.flexmark.util.dependency;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
import com.vladsch.flexmark.util.dependency.Dependent;
import com.vladsch.flexmark.util.dependency.ResolvedDependencies;
import com.vladsch.flexmark.util.misc.Ref;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public abstract class DependencyHandler<D extends Dependent, S, R extends ResolvedDependencies<S>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NotNull
    public abstract R createResolvedDependencies(List<S> list);

    @NotNull
    public abstract S createStage(List<D> list);

    @NotNull
    public abstract Class getDependentClass(D d);

    public DependentItemMap<D> prioritize(DependentItemMap<D> dependentItemMap) {
        return dependentItemMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public R resolveDependencies(List<D> list) {
        if (list.size() == 0) {
            return (R) createResolvedDependencies(Collections.EMPTY_LIST);
        }
        if (list.size() == 1) {
            return (R) createResolvedDependencies(Collections.singletonList(createStage(Collections.singletonList(list.get(0)))));
        }
        DependentItemMap<D> dependentItemMap = new DependentItemMap<>(list.size());
        for (D d : list) {
            Class dependentClass = getDependentClass(d);
            if (dependentItemMap.containsKey(dependentClass)) {
                throw new IllegalStateException(AbstractC0541b.m768j(dependentClass, "Dependent class ", " is duplicated. Only one instance can be present in the list"));
            }
            dependentItemMap.put(dependentClass, new DependentItem(dependentItemMap.size(), d, getDependentClass(d), d.affectsGlobalScope()));
        }
        ReversibleIndexedIterator it = dependentItemMap.iterator();
        while (it.hasNext()) {
            DependentItem dependentItem = (DependentItem) ((Map.Entry) it.next()).getValue();
            Set<Class<?>> afterDependents = ((Dependent) dependentItem.dependent).getAfterDependents();
            if (afterDependents != null && afterDependents.size() > 0) {
                Iterator<Class<?>> it2 = afterDependents.iterator();
                while (it2.hasNext()) {
                    DependentItem dependentItem2 = (DependentItem) dependentItemMap.get(it2.next());
                    if (dependentItem2 != null) {
                        dependentItem.addDependency(dependentItem2);
                        dependentItem2.addDependent(dependentItem);
                    }
                }
            }
            Set<Class<?>> beforeDependents = ((Dependent) dependentItem.dependent).getBeforeDependents();
            if (beforeDependents != null && beforeDependents.size() > 0) {
                Iterator<Class<?>> it3 = beforeDependents.iterator();
                while (it3.hasNext()) {
                    DependentItem dependentItem3 = (DependentItem) dependentItemMap.get(it3.next());
                    if (dependentItem3 != null) {
                        dependentItem3.addDependency(dependentItem);
                        dependentItem.addDependent(dependentItem3);
                    }
                }
            }
        }
        DependentItemMap<D> dependentItemMapPrioritize = prioritize(dependentItemMap);
        int size = dependentItemMapPrioritize.size();
        BitSet bitSet = new BitSet(size);
        Ref ref = new Ref(bitSet);
        Iterator itValueIterator = dependentItemMapPrioritize.valueIterator();
        while (itValueIterator.hasNext()) {
            DependentItem dependentItem4 = (DependentItem) itValueIterator.next();
            if (!dependentItem4.hasDependencies()) {
                ((BitSet) ref.value).set(dependentItem4.index);
            }
        }
        BitSet bitSet2 = new BitSet(size);
        bitSet2.set(0, dependentItemMapPrioritize.size());
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
                DependentItem value = dependentItemMapPrioritize.getValue(iNextSetBit);
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
                        if (!dependentItemMapPrioritize.getValue(iNextSetBit2).removeDependency(value)) {
                            if (value.isGlobalScope) {
                                bitSet3.set(iNextSetBit2);
                            } else {
                                bitSet.set(iNextSetBit2);
                            }
                        }
                    }
                }
            }
            arrayList.add(createStage(arrayList2));
            bitSet = bitSet3;
        }
        if (bitSet2.nextSetBit(0) == -1) {
            return (R) createResolvedDependencies(arrayList);
        }
        throw new IllegalStateException("have dependents with dependency cycles" + bitSet2);
    }
}
