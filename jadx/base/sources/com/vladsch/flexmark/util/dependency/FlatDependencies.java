package com.vladsch.flexmark.util.dependency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class FlatDependencies<T> extends ResolvedDependencies<FlatDependencyStage<T>> {
    ArrayList<T> dependencies;

    public FlatDependencies(List<FlatDependencyStage<T>> list) {
        super(list);
        ArrayList<T> arrayList = new ArrayList<>();
        Iterator<FlatDependencyStage<T>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getDependents());
        }
        this.dependencies = arrayList;
    }
}
