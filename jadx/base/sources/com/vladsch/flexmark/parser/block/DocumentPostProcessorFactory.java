package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.PostProcessorFactory;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DocumentPostProcessorFactory implements PostProcessorFactory {
    @Override // com.vladsch.flexmark.util.dependency.Dependent
    public final boolean affectsGlobalScope() {
        return true;
    }

    @Override // com.vladsch.flexmark.util.dependency.Dependent
    @Nullable
    public Set<Class<?>> getAfterDependents() {
        return null;
    }

    @Override // com.vladsch.flexmark.util.dependency.Dependent
    @Nullable
    public Set<Class<?>> getBeforeDependents() {
        return null;
    }

    @Override // com.vladsch.flexmark.parser.PostProcessorFactory
    public final Map<Class<?>, Set<Class<?>>> getNodeTypes() {
        return null;
    }
}
