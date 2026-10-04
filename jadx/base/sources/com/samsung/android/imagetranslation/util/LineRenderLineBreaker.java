package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class LineRenderLineBreaker implements LineBreaker {
    @Override // com.samsung.android.imagetranslation.util.LineBreaker
    public String getLinedString(LttOcrResult.BlockInfo blockInfo) {
        return (String) blockInfo.getLineInfo().stream().map(new C7132a(2)).collect(Collectors.joining("\n"));
    }
}
