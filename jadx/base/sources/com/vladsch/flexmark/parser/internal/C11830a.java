package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.InlineParserFactory;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.vladsch.flexmark.parser.internal.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11830a implements InlineParserFactory {
    @Override // com.vladsch.flexmark.parser.InlineParserFactory
    public final InlineParser inlineParser(DataHolder dataHolder, BitSet bitSet, BitSet bitSet2, Map map, LinkRefProcessorData linkRefProcessorData, List list) {
        return new CommonmarkInlineParser(dataHolder, bitSet, bitSet2, map, linkRefProcessorData, list);
    }
}
