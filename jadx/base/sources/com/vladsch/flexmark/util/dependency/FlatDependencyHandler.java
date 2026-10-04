package com.vladsch.flexmark.util.dependency;

import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class FlatDependencyHandler<T extends Dependent> extends DependencyHandler<T, FlatDependencyStage<T>, FlatDependencies<T>> {
    public static <T extends Dependent> List<T> computeDependencies(List<T> list) {
        return new FlatDependencyHandler().resolvedDependencies(list);
    }

    @Override // com.vladsch.flexmark.util.dependency.DependencyHandler
    @NotNull
    public Class<? extends T> getDependentClass(T t) {
        return (Class<? extends T>) t.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> resolvedDependencies(List<T> list) {
        return resolveDependencies(list).dependencies;
    }

    @Override // com.vladsch.flexmark.util.dependency.DependencyHandler
    @NotNull
    public FlatDependencies<T> createResolvedDependencies(List<FlatDependencyStage<T>> list) {
        return new FlatDependencies<>(list);
    }

    @Override // com.vladsch.flexmark.util.dependency.DependencyHandler
    @NotNull
    public FlatDependencyStage<T> createStage(List<T> list) {
        return new FlatDependencyStage<>(list);
    }
}
