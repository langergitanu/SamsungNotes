package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface UriContentResolverFactory extends Function<LinkResolverBasicContext, UriContentResolver>, Dependent {
    @Override // com.vladsch.flexmark.util.dependency.Dependent
    boolean affectsGlobalScope();

    @Override // java.util.function.Function
    @NotNull
    UriContentResolver apply(@NotNull LinkResolverBasicContext linkResolverBasicContext);

    @Override // com.vladsch.flexmark.util.dependency.Dependent
    @Nullable
    Set<Class<?>> getAfterDependents();

    @Override // com.vladsch.flexmark.util.dependency.Dependent
    @Nullable
    Set<Class<?>> getBeforeDependents();
}
