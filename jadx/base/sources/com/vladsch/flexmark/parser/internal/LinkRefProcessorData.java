package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkRefProcessorData {
    public final int maxNesting;
    public final int[] nestingIndex;
    public final List<LinkRefProcessorFactory> processors;

    public LinkRefProcessorData(List<LinkRefProcessorFactory> list, int i, int[] iArr) {
        this.processors = list;
        this.maxNesting = i;
        this.nestingIndex = iArr;
    }
}
