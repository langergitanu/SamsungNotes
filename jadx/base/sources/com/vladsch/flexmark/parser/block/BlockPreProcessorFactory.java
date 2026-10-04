package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface BlockPreProcessorFactory extends Function<ParserState, BlockPreProcessor>, Dependent {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    @NotNull
    BlockPreProcessor apply(@NotNull ParserState parserState);

    @NotNull
    Set<Class<? extends Block>> getBlockTypes();
}
