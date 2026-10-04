package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface PostProcessorFactory extends Function<Document, PostProcessor>, Dependent {
    @Override // java.util.function.Function
    @NotNull
    PostProcessor apply(@NotNull Document document);

    @Nullable
    Map<Class<?>, Set<Class<?>>> getNodeTypes();
}
