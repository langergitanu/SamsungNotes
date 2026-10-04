package com.samsung.android.livetranslation.util;

import androidx.annotation.NonNull;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.util.LineWidthRule;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class LineWidthRule implements Rule {
    private static final double MAX_LINE_WIDTH_RATIO = 0.8d;
    private static final int MIN_LINE_COUNT = 2;

    /* JADX INFO: renamed from: com.samsung.android.livetranslation.util.LineWidthRule$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71681 {
        double score = 0.0d;
        int multiLineBlockCount = 0;

        public C71681() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.livetranslation.util.LineWidthRule$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71692 {
        double value = 0.0d;

        public C71692() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LineOutlierDetector {
        private double meanHeight;
        private double stdDeviation;

        public LineOutlierDetector(@NonNull LttOcrResult.BlockInfo blockInfo) {
            this.meanHeight = 0.0d;
            this.stdDeviation = 0.0d;
            if (blockInfo.getLineInfo().size() > 2) {
                double meanHeight = getMeanHeight(blockInfo);
                this.meanHeight = meanHeight;
                this.stdDeviation = getStdDeviation(blockInfo, meanHeight);
            }
        }

        private static double getMeanHeight(LttOcrResult.BlockInfo blockInfo) {
            if (blockInfo.getLineInfo().isEmpty()) {
                return 0.0d;
            }
            return blockInfo.getLineInfo().stream().mapToInt(new C7179j()).average().orElse(0.0d);
        }

        private static double getStdDeviation(LttOcrResult.BlockInfo blockInfo, final double d) {
            if (blockInfo.getLineInfo().isEmpty()) {
                return 0.0d;
            }
            return Math.sqrt((blockInfo.getLineInfo().stream().mapToDouble(new C7177h()).reduce(0.0d, new DoubleBinaryOperator() { // from class: com.samsung.android.livetranslation.util.i
                @Override // java.util.function.DoubleBinaryOperator
                public final double applyAsDouble(double d2, double d3) {
                    return LineWidthRule.LineOutlierDetector.lambda$getStdDeviation$2(d, d2, d3);
                }
            }) / ((double) blockInfo.getLineInfo().size())) - 1.0d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$getMeanHeight$0(LttOcrResult.LineInfo lineInfo) {
            return lineInfo.getRect().height();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ double lambda$getStdDeviation$1(LttOcrResult.LineInfo lineInfo) {
            return lineInfo.getRect().height();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ double lambda$getStdDeviation$2(double d, double d2, double d3) {
            double d4 = d3 - d;
            return (d4 * d4) + d2;
        }

        public boolean isOutlier(LttOcrResult.LineInfo lineInfo) {
            if (this.meanHeight == 0.0d) {
                return false;
            }
            return ((double) lineInfo.getRect().height()) > (this.stdDeviation * 1.25d) + this.meanHeight;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getScore$0(LttOcrResult.BlockInfo blockInfo) {
        return blockInfo.getLineInfo().size() >= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getScore$1(LineOutlierDetector lineOutlierDetector, LttOcrResult.LineInfo lineInfo) {
        return !lineOutlierDetector.isOutlier(lineInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getScore$2(C71692 c71692, LttOcrResult.LineInfo lineInfo) {
        c71692.value += 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getScore$3(double d, LttOcrResult.LineInfo lineInfo) {
        return ((double) lineInfo.getRect().width()) > d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getScore$4(C71681 c71681, LttOcrResult.BlockInfo blockInfo) {
        final double maxLineWidth = ((double) BlockInfoUtil.getMaxLineWidth(blockInfo)) * MAX_LINE_WIDTH_RATIO;
        LineOutlierDetector lineOutlierDetector = new LineOutlierDetector(blockInfo);
        C71692 c71692 = new C71692();
        double dCount = blockInfo.getLineInfo().stream().filter(new C7173d(lineOutlierDetector, 0)).peek(new C7171b(c71692, 1)).filter(new Predicate() { // from class: com.samsung.android.livetranslation.util.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return LineWidthRule.lambda$getScore$3(maxLineWidth, (LttOcrResult.LineInfo) obj);
            }
        }).count();
        double d = c71681.score;
        double d2 = c71692.value;
        c71681.score = d + (d2 > 0.0d ? dCount / d2 : 0.0d);
        c71681.multiLineBlockCount++;
    }

    @Override // com.samsung.android.livetranslation.util.Rule
    public double getScore(@NonNull List<LttOcrResult.BlockInfo> list) {
        final C71681 c71681 = new C71681();
        list.stream().filter(new C7175f(0)).forEach(new Consumer() { // from class: com.samsung.android.livetranslation.util.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f4834a.lambda$getScore$4(c71681, (LttOcrResult.BlockInfo) obj);
            }
        });
        int i = c71681.multiLineBlockCount;
        if (i > 0) {
            return c71681.score / ((double) i);
        }
        return 0.0d;
    }
}
