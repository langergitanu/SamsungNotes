package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.PostProcessor;
import com.vladsch.flexmark.util.ast.Document;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NodePostProcessor implements PostProcessor {
    @Override // com.vladsch.flexmark.parser.PostProcessor
    @NotNull
    public final Document processDocument(@NotNull Document document) {
        return document;
    }
}
