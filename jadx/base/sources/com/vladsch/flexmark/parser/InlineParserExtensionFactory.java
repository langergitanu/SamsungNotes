package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface InlineParserExtensionFactory extends Function<LightInlineParser, InlineParserExtension>, Dependent {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    @NotNull
    InlineParserExtension apply(@NotNull LightInlineParser lightInlineParser);

    @NotNull
    CharSequence getCharacters();
}
