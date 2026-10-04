package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.SpellingCorrectorPostProcessor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SpellingCorrector extends Operator {
    public SpellingCorrector(String str) {
        super(str, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.SpellingCorrection;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(String str) {
        this.mImpl.requestText(getRequestType(), null, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String postProcessing(String str) {
        return CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? str : new SpellingCorrectorPostProcessor(this.mContent, str).getResult();
    }

    public SpellingCorrector(String str, boolean z) {
        super(str, z);
    }
}
