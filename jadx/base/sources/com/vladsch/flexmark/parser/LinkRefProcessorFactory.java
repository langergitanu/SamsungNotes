package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LinkRefProcessorFactory extends Function<Document, LinkRefProcessor> {
    @Override // java.util.function.Function
    @NotNull
    LinkRefProcessor apply(@NotNull Document document);

    int getBracketNestingLevel(@NotNull DataHolder dataHolder);

    boolean getWantExclamationPrefix(@NotNull DataHolder dataHolder);
}
