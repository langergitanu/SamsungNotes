package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.SentenceSeparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SummarizerPostProcessor {
    private final String mSource;

    public SummarizerPostProcessor(@NonNull String str) {
        this.mSource = str;
    }

    private String separateSentences() {
        List<Sentence> listExecute = new SentenceSeparator(this.mSource).execute();
        StringBuilder sb = new StringBuilder();
        Iterator<Sentence> it = listExecute.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String getResult() {
        return TextUtils.isEmpty(this.mSource) ? this.mSource : separateSentences();
    }
}
