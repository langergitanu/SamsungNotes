package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class BrokenLineDetector {
    private final boolean couldBeBrokenLineBlock;

    /* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.BrokenLineDetector$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71291 {
        boolean isUppercaseExist = false;
        boolean isLowercaseExist = false;

        public C71291() {
        }

        public boolean isMixedCaseExist() {
            return this.isUppercaseExist && this.isLowercaseExist;
        }
    }

    public BrokenLineDetector(LttOcrResult.BlockInfo blockInfo) {
        C71291 c71291 = new C71291();
        blockInfo.getLineInfo().forEach(new C7135d(c71291, 0));
        this.couldBeBrokenLineBlock = c71291.isMixedCaseExist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(C71291 c71291, LttOcrResult.LineInfo lineInfo) {
        if (lineInfo.getString().trim().isEmpty()) {
            return;
        }
        char cCharAt = lineInfo.getString().trim().charAt(0);
        if (!c71291.isUppercaseExist) {
            c71291.isUppercaseExist = Character.isUpperCase(cCharAt);
        }
        if (c71291.isLowercaseExist) {
            return;
        }
        c71291.isLowercaseExist = Character.isLowerCase(cCharAt);
    }

    public boolean isContinuousLine(LttOcrResult.LineInfo lineInfo) {
        return !lineInfo.getString().trim().isEmpty() && this.couldBeBrokenLineBlock && Character.isLowerCase(lineInfo.getString().trim().charAt(0));
    }
}
