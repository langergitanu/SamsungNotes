package com.vladsch.flexmark.parser.core;

import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.internal.InlineParserImpl;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReferencePreProcessorFactory implements ParagraphPreProcessorFactory {
    @Override // com.vladsch.flexmark.util.dependency.Dependent
    public boolean affectsGlobalScope() {
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory, java.util.function.Function
    public ParagraphPreProcessor apply(ParserState parserState) {
        return (InlineParserImpl) parserState.getInlineParser();
    }
}
