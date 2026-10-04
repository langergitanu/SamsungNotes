package com.samsung.android.sdk.scs.p142ai;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.extension.lts.ILongTextSummarizer;
import com.samsung.android.sdk.scs.p142ai.extension.lts.LongTextSummarizer;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AiServicesExtension {
    private AiServicesExtension() {
    }

    public static ILongTextSummarizer getLongTextSummarizer(@NonNull Context context, @NonNull Summarizer summarizer) {
        return new LongTextSummarizer(context, summarizer);
    }
}
