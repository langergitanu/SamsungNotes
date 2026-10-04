package com.vladsch.flexmark.util.dependency;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class FlatDependencyStage<T> {
    private final List<T> dependents;

    public FlatDependencyStage(List<T> list) {
        this.dependents = list;
    }

    public List<T> getDependents() {
        return this.dependents;
    }
}
