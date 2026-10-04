package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.p142ai.language.service.SummarizationServiceExecutorForExternal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SummarizerForExternal extends Summarizer {
    public SummarizerForExternal(@NonNull Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.language.Summarizer
    public void createExecutor(Context context) {
        this.mServiceExecutor = new SummarizationServiceExecutorForExternal(context);
        this.featureName = "FEATURE_AI_GEN_SUMMARY_FOR_EXTERNAL";
    }
}
