package com.vladsch.flexmark.util.dependency;

import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DependentItem<D> {
    BitSet dependencies;
    public final D dependent;
    public final Class<?> dependentClass;
    BitSet dependents;
    public final int index;
    public final boolean isGlobalScope;

    public DependentItem(int i, D d, Class<?> cls, boolean z) {
        this.index = i;
        this.dependent = d;
        this.dependentClass = cls;
        this.isGlobalScope = z;
    }

    public void addDependency(DependentItem<D> dependentItem) {
        if (this.dependencies == null) {
            this.dependencies = new BitSet();
        }
        this.dependencies.set(dependentItem.index);
    }

    public void addDependent(DependentItem<D> dependentItem) {
        if (this.dependents == null) {
            this.dependents = new BitSet();
        }
        this.dependents.set(dependentItem.index);
    }

    public boolean hasDependencies() {
        BitSet bitSet = this.dependencies;
        return (bitSet == null || bitSet.nextSetBit(0) == -1) ? false : true;
    }

    public boolean hasDependents() {
        BitSet bitSet = this.dependents;
        return (bitSet == null || bitSet.nextSetBit(0) == -1) ? false : true;
    }

    public boolean removeDependency(DependentItem<D> dependentItem) {
        BitSet bitSet = this.dependencies;
        if (bitSet != null) {
            bitSet.clear(dependentItem.index);
        }
        return hasDependencies();
    }

    public void removeDependent(DependentItem<D> dependentItem) {
        BitSet bitSet = this.dependents;
        if (bitSet != null) {
            bitSet.clear(dependentItem.index);
        }
    }

    public void addDependency(BitSet bitSet) {
        if (this.dependencies == null) {
            this.dependencies = new BitSet();
        }
        this.dependencies.or(bitSet);
    }

    public void addDependent(BitSet bitSet) {
        if (this.dependents == null) {
            this.dependents = new BitSet();
        }
        this.dependents.or(bitSet);
    }

    public void removeDependent(BitSet bitSet) {
        BitSet bitSet2 = this.dependents;
        if (bitSet2 != null) {
            bitSet2.andNot(bitSet);
        }
    }

    public boolean removeDependency(BitSet bitSet) {
        BitSet bitSet2 = this.dependencies;
        if (bitSet2 != null) {
            bitSet2.andNot(bitSet);
        }
        return hasDependencies();
    }
}
