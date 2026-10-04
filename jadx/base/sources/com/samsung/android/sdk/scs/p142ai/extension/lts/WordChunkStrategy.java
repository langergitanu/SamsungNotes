package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class WordChunkStrategy implements TextChunkStrategy {
    private static final double MARGIN_RATIO = 0.05d;
    private static final String TAG = "WordChunkStrategy";
    private static final String WORD_SPLIT_PATTERN = "\\s+";

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public boolean canHandle(String str, int i, int i2) {
        return true;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public List<String> chunkText(String str, int i, int i2) {
        Log.d(TAG, "Using word chunking strategy (fallback)");
        return TextChunkUtils.splitWordsIntoChunks(str.trim().split(WORD_SPLIT_PATTERN), (int) ((((double) i2) * MARGIN_RATIO) + ((double) i)));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public String getStrategyName() {
        return "Word";
    }
}
