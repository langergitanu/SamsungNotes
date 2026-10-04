package com.samsung.android.imagetranslation.util;

import androidx.annotation.NonNull;
import com.samsung.android.imagetranslation.data.LttOcrResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class BlockInfoUtil {
    public static int getMaxLineWidth(@NonNull LttOcrResult.BlockInfo blockInfo) {
        return ((Integer) blockInfo.getLineInfo().stream().map(new C7132a(1)).max(new C7134c()).orElse(0)).intValue();
    }

    public static int getWordCount(@NonNull LttOcrResult.BlockInfo blockInfo) {
        return ((Integer) blockInfo.getLineInfo().stream().map(new C7132a(0)).reduce(0, new C7133b())).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getMaxLineWidth$0(LttOcrResult.LineInfo lineInfo) {
        return Integer.valueOf(lineInfo.getRect().width());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getWordCount$1(LttOcrResult.LineInfo lineInfo) {
        return Integer.valueOf(lineInfo.getWordInfo().size());
    }
}
