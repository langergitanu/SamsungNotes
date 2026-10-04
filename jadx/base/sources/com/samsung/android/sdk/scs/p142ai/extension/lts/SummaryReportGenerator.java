package com.samsung.android.sdk.scs.p142ai.extension.lts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SummaryReportGenerator {

    /* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.extension.lts.SummaryReportGenerator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C77291 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$scs$ai$extension$lts$SummaryStyle */
        static final /* synthetic */ int[] f5180x19d8e798;

        static {
            int[] iArr = new int[SummaryStyle.values().length];
            f5180x19d8e798 = iArr;
            try {
                iArr[SummaryStyle.EXTRACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5180x19d8e798[SummaryStyle.MIXED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5180x19d8e798[SummaryStyle.ABSTRACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String generateReport(SummaryScores summaryScores, String str, String str2, String str3, SummaryStyle summaryStyle) {
        return String.format("Coverage: %.2f (%s) → ", Double.valueOf(summaryScores.coverage), str) + getCoverageText(summaryScores.coverage, str) + String.format("Density: %.2f (%s) → ", Double.valueOf(summaryScores.density), str2) + getDensityText(summaryScores.density, str2) + String.format("Compression: %.2f (%s) → ", Double.valueOf(summaryScores.compression), str3) + getCompressionText(summaryScores.compression, str3) + "Style Classification: " + summaryStyle + "\nRecommendations: " + getStyleFeedback(summaryStyle);
    }

    public String getCompressionText(double d, String str) {
        str.getClass();
        return !str.equals("Medium") ? !str.equals("High") ? "Summary is longer than source — possibly verbose or not a true summary.\n" : "Very short summary — may omit important details.\n" : "Moderately compressed — likely concise and informative.\n";
    }

    public String getCoverageText(double d, String str) {
        str.getClass();
        return !str.equals("Medium") ? !str.equals("High") ? "Summary mostly uses new or unrelated words.\n" : "Most summary words are taken directly from the source.\n" : "Summary contains a mix of original and new words.\n";
    }

    public String getDensityText(double d, String str) {
        str.getClass();
        return !str.equals("Medium") ? !str.equals("High") ? "Summary is highly rephrased (abstractive).\n" : "Long continuous spans were extracted from the source.\n" : "Shorter fragments with some rephrasing.\n";
    }

    public String getStyleFeedback(SummaryStyle summaryStyle) {
        int i = C77291.f5180x19d8e798[summaryStyle.ordinal()];
        if (i == 1) {
            return "Consider adding more creative rephrasing to improve readability while maintaining the key information. Try to combine related sentences and use more concise expressions.\n";
        }
        if (i == 2) {
            return "This is a well-balanced summary. To further improve, ensure that the rephrased content accurately captures the original meaning and maintains logical flow between extracted and rephrased parts.\n";
        }
        if (i == 3) {
            return "Review the summary to ensure all critical information from the source is preserved. Consider adding more specific details or examples from the original text to increase accuracy.\n";
        }
        throw new IncompatibleClassChangeError();
    }
}
