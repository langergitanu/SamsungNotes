package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LinkResolverFactory extends Function<LinkResolverBasicContext, LinkResolver>, Dependent {
    boolean affectsGlobalScope();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    @NotNull
    LinkResolver apply(@NotNull LinkResolverBasicContext linkResolverBasicContext);

    @Nullable
    Set<Class<?>> getAfterDependents();

    @Nullable
    Set<Class<?>> getBeforeDependents();
}
