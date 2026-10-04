package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.StructuredAutoFormatStreamingPostProcessor;
import com.samsung.android.support.senl.p148nt.model.assist.llm.preprocessor.LinePreProcessor;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StructuredAutoFormatter extends Operator {
    private static final boolean ENABLE_POSTPROCESS = false;
    private static final String TAG = "Ai$StructuredAutoFormatter";
    private String mLanguage;
    private String mRequestContent;
    private final Style mStyle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Style {
        Note,
        VoiceRecorder
    }

    public StructuredAutoFormatter(String str, Style style) {
        this(str, style, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.StructuredAutoFormat;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public boolean isPostProcessingError(String str) {
        return "AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED".equals(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(String str) {
        this.mRequestContent = str;
        HashMap map = new HashMap();
        map.put("style", this.mStyle.toString());
        map.put("language", this.mLanguage);
        this.mImpl.requestText(getRequestType(), map, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String postProcessing(String str) {
        return CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? new StructuredAutoFormatStreamingPostProcessor(str).getResult() : str.replace("\\t", "\t");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public String preProcessing(String str) {
        return new LinePreProcessor().removeRepeatedEmptyLine(str);
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public StructuredAutoFormatter(String str, Style style, boolean z) {
        super(str, z);
        this.mLanguage = "Korean";
        this.mRequestContent = "";
        this.mStyle = style;
    }
}
