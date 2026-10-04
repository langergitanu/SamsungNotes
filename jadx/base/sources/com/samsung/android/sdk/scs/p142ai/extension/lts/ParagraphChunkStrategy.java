package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class ParagraphChunkStrategy implements TextChunkStrategy {
    private static final double MARGIN_RATIO = 0.3d;
    private static final String PARAGRAPH_SPLIT_PATTERN = "(?m)^$.*?^";
    private static final String TAG = "ParagraphChunkStrategy";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$canHandle$0(int i, String str) {
        return str.length() > i;
    }

    private String[] splitByParagraph(String str) {
        return Pattern.compile(PARAGRAPH_SPLIT_PATTERN).split(str);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public boolean canHandle(String str, int i, int i2) {
        return Arrays.stream(splitByParagraph(str)).noneMatch(new C7730a((int) ((((double) i2) * MARGIN_RATIO) + ((double) i)), 1));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public List<String> chunkText(String str, int i, int i2) {
        Log.d(TAG, "Using paragraph chunking strategy");
        return TextChunkUtils.splitWordsIntoChunks(splitByParagraph(str), (int) ((((double) i2) * MARGIN_RATIO) + ((double) i)));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.extension.lts.TextChunkStrategy
    public String getStrategyName() {
        return "Paragraph";
    }
}
