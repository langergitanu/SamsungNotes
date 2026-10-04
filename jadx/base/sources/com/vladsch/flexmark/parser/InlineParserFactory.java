package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
import com.vladsch.flexmark.parser.internal.LinkRefProcessorData;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface InlineParserFactory {
    InlineParser inlineParser(@NotNull DataHolder dataHolder, @NotNull BitSet bitSet, @NotNull BitSet bitSet2, @NotNull Map<Character, DelimiterProcessor> map, @NotNull LinkRefProcessorData linkRefProcessorData, @NotNull List<InlineParserExtensionFactory> list);
}
