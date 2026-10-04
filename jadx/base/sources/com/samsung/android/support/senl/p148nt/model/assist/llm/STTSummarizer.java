package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class STTSummarizer extends Summarizer {
    public STTSummarizer(String str, SummaryStyle summaryStyle) {
        super(str, summaryStyle);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer, com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.STTSummary;
    }

    public STTSummarizer(String str, SummaryStyle summaryStyle, boolean z) {
        super(str, summaryStyle, z);
    }
}
