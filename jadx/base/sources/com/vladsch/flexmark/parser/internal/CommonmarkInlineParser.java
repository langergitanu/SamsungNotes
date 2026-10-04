package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CommonmarkInlineParser extends InlineParserImpl {
    public CommonmarkInlineParser(DataHolder dataHolder, BitSet bitSet, BitSet bitSet2, Map<Character, DelimiterProcessor> map, LinkRefProcessorData linkRefProcessorData, List<InlineParserExtensionFactory> list) {
        super(dataHolder, bitSet, bitSet2, map, linkRefProcessorData, list);
    }

    @Override // com.vladsch.flexmark.parser.internal.InlineParserImpl, com.vladsch.flexmark.parser.InlineParser
    public void initializeDocument(@NotNull Document document) {
        super.initializeDocument(document);
    }
}
