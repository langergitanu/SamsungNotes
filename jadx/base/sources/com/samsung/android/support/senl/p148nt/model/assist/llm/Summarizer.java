package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeSubTask;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.SummarizerPostProcessor;
import com.samsung.android.support.senl.p148nt.model.assist.llm.preprocessor.LinePreProcessor;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Summarizer extends Operator {
    private String mExtraKey;
    final AppInfo.RequestType mPrevRequestType;
    SummarizeSubTask mSummarizeSubTask;
    final SummaryStyle mSummaryStyle;

    public Summarizer(String str, SummaryStyle summaryStyle) {
        this(str, summaryStyle, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String getCacheKey() {
        return super.getCacheKey() + this.mSummaryStyle.toString() + this.mExtraKey;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.Summary;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void onPreExecute(String str) {
        super.onPreExecute(str);
        if (this.mPrevRequestType != SCSTools.getRequestType()) {
            deleteCache();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(String str) {
        HashMap map = new HashMap();
        map.put("style", this.mSummaryStyle);
        map.put("summarize_subtask", this.mSummarizeSubTask);
        this.mImpl.requestText(getRequestType(), map, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String postProcessing(String str) {
        String strPostProcessing = CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? super.postProcessing(str) : new SummarizerPostProcessor(str).getResult();
        if (strPostProcessing.contains("।.")) {
            strPostProcessing = strPostProcessing.replace("।.", "।");
        }
        return strPostProcessing.contains("</Summary>") ? strPostProcessing.replace("</Summary>", "").trim() : strPostProcessing;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String preProcessing(String str) {
        return new LinePreProcessor().removeRepeatedEmptyLine(str);
    }

    public void setExtraKey(String str) {
        this.mExtraKey = str;
    }

    public void setSummarizeSubTask(SummarizeSubTask summarizeSubTask) {
        this.mSummarizeSubTask = summarizeSubTask;
    }

    public Summarizer(String str, SummaryStyle summaryStyle, boolean z) {
        super(str, z);
        this.mExtraKey = "";
        this.mSummaryStyle = summaryStyle;
        this.mPrevRequestType = SCSTools.getRequestType();
    }

    public void unloadModel() {
    }

    public void setContinuousListSize(int i) {
    }

    public void setDetectedLanguage(String str) {
    }
}
