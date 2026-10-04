package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class TextChunkContext {
    private static final String CHUNK = "Chunk";
    private static final String TAG = "TextChunkContext";
    private final List<TextChunkStrategy> mStrategies = Arrays.asList(new ParagraphChunkStrategy(), new SentenceChunkStrategy(), new LineChunkStrategy(), new WordChunkStrategy());

    public List<String> chunkText(String str, int i, int i2) {
        if (str == null || str.isEmpty()) {
            return new ArrayList();
        }
        for (TextChunkStrategy textChunkStrategy : this.mStrategies) {
            if (textChunkStrategy.canHandle(str, i, i2)) {
                AbstractC11014a.m12338w(new StringBuilder("Selected strategy: "), textChunkStrategy.getStrategyName(), TAG);
                List<String> listChunkText = textChunkStrategy.chunkText(str, i, i2);
                TextChunkUtils.printLogs(CHUNK, listChunkText);
                return listChunkText;
            }
        }
        Log.w(TAG, "No strategy could handle the text, using fallback");
        return new ArrayList();
    }

    public List<String> chunkTextWithDefaultSize(String str) {
        return chunkText(str, 2950, 0);
    }
}
