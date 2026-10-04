package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ParagraphRenderLineBreaker implements LineBreaker {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BulletParagraphDetector {
        private static final String SPECIAL_CHAR = "•-*#+@0123456789";
        private final boolean isBulletParagraph;

        public BulletParagraphDetector(LttOcrResult.BlockInfo blockInfo) {
            this.isBulletParagraph = !blockInfo.getLineInfo().isEmpty() && ((double) blockInfo.getLineInfo().stream().filter(new C7141j(2)).count()) / ((double) blockInfo.getLineInfo().size()) >= 0.4d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(LttOcrResult.LineInfo lineInfo) {
            if (lineInfo.getString().trim().isEmpty()) {
                return false;
            }
            return SPECIAL_CHAR.contains(Character.toString(lineInfo.getString().trim().charAt(0)));
        }

        public boolean isBulletLine(LttOcrResult.LineInfo lineInfo) {
            String strTrim = lineInfo.getString().trim();
            return !strTrim.isEmpty() && this.isBulletParagraph && SPECIAL_CHAR.contains(Character.toString(strTrim.charAt(0)));
        }
    }

    private static int getFirstWordWidth(LttOcrResult.LineInfo lineInfo) {
        if (lineInfo.getWordInfo().isEmpty()) {
            return 0;
        }
        LttOcrResult.WordInfo wordInfo = lineInfo.getWordInfo().get(0);
        int iWidth = wordInfo.getRect().width();
        return (wordInfo.getString().length() > 3 || lineInfo.getWordInfo().size() <= 1) ? iWidth : lineInfo.getWordInfo().get(1).getRect().width() + iWidth;
    }

    @Override // com.samsung.android.imagetranslation.util.LineBreaker
    public String getLinedString(LttOcrResult.BlockInfo blockInfo) {
        StringBuilder sb = new StringBuilder();
        int maxLineWidth = BlockInfoUtil.getMaxLineWidth(blockInfo);
        BrokenLineDetector brokenLineDetector = new BrokenLineDetector(blockInfo);
        BulletParagraphDetector bulletParagraphDetector = new BulletParagraphDetector(blockInfo);
        for (int i = 0; i < blockInfo.getLineInfo().size(); i++) {
            LttOcrResult.LineInfo lineInfo = blockInfo.getLineInfo().get(i);
            sb.append(lineInfo.getString());
            if (i != blockInfo.getLineInfo().size() - 1) {
                LttOcrResult.LineInfo lineInfo2 = blockInfo.getLineInfo().get(i + 1);
                if (!lineInfo2.getWordInfo().isEmpty() && ((maxLineWidth - lineInfo.getRect().width() > getFirstWordWidth(lineInfo2) && !brokenLineDetector.isContinuousLine(lineInfo2)) || bulletParagraphDetector.isBulletLine(lineInfo2))) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
