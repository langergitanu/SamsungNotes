package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.model.assist.llm.preprocessor.LinePreProcessor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MeetingAutoFormatter extends Operator {
    public MeetingAutoFormatter(String str) {
        this(str, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.MeetingAutoFormat;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(String str) {
        this.mImpl.requestText(getRequestType(), null, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String preProcessing(String str) {
        return new LinePreProcessor().removeRepeatedEmptyLine(str);
    }

    public MeetingAutoFormatter(String str, boolean z) {
        super(str, z);
    }
}
