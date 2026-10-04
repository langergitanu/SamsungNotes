package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class LineChunkStrategy implements TextChunkStrategy {
    private static final String LINE_SPLIT_PATTERN = "\\n";
    private static final double MARGIN_RATIO = 0.3d;
    private static final String TAG = "LineChunkStrategy";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$canHandle$0(int i, String str) {
        return str.length() > i;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public boolean canHandle(String str, int i, int i2) {
        return Arrays.stream(str.trim().split(LINE_SPLIT_PATTERN)).noneMatch(new C7730a((int) ((((double) i2) * MARGIN_RATIO) + ((double) i)), 0));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public List<String> chunkText(String str, int i, int i2) {
        Log.d(TAG, "Using line chunking strategy");
        return TextChunkUtils.splitWordsIntoChunks(str.trim().split(LINE_SPLIT_PATTERN), (int) ((((double) i2) * MARGIN_RATIO) + ((double) i)));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public String getStrategyName() {
        return "Line";
    }
}
