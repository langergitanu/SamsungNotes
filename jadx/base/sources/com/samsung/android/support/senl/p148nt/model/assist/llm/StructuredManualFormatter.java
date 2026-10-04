package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.StructuredManualFormatPostProcessor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StructuredManualFormatter extends CoverMaker {
    private String mRequestContent;

    public StructuredManualFormatter(String str) {
        super(str);
        this.mRequestContent = "";
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.CoverMaker, com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(String str) {
        this.mRequestContent = str;
        super.operate(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String postProcessing(String str) {
        return new StructuredManualFormatPostProcessor(this.mRequestContent, str).getResult();
    }
}
