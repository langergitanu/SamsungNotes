package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class BrokenLineDetector {
    private final boolean couldBeBrokenLineBlock;

    /* JADX INFO: renamed from: com.samsung.android.livetranslation.util.BrokenLineDetector$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71671 {
        boolean isUppercaseExist = false;
        boolean isLowercaseExist = false;

        public C71671() {
        }

        public boolean isMixedCaseExist() {
            return this.isUppercaseExist && this.isLowercaseExist;
        }
    }

    public BrokenLineDetector(LttOcrResult.BlockInfo blockInfo) {
        C71671 c71671 = new C71671();
        blockInfo.getLineInfo().forEach(new C7171b(c71671, 0));
        this.couldBeBrokenLineBlock = c71671.isMixedCaseExist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(C71671 c71671, LttOcrResult.LineInfo lineInfo) {
        char cCharAt = lineInfo.getString().trim().charAt(0);
        if (!c71671.isUppercaseExist) {
            c71671.isUppercaseExist = Character.isUpperCase(cCharAt);
        }
        if (c71671.isLowercaseExist) {
            return;
        }
        c71671.isLowercaseExist = Character.isLowerCase(cCharAt);
    }

    public boolean isContinuousLine(LttOcrResult.LineInfo lineInfo) {
        return !lineInfo.getString().trim().isEmpty() && this.couldBeBrokenLineBlock && Character.isLowerCase(lineInfo.getString().trim().charAt(0));
    }
}
