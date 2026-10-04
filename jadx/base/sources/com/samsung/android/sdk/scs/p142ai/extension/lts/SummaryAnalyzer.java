package com.samsung.android.sdk.scs.p142ai.extension.lts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SummaryAnalyzer {
    private double compressionHigh;
    private double compressionLow;
    private double coverageHigh;
    private double coverageLow;
    private double densityHigh;
    private double densityLow;
    private final SummaryReportGenerator mReportGenerator;

    public SummaryAnalyzer(SummaryReportGenerator summaryReportGenerator) {
        this.coverageLow = 0.33d;
        this.coverageHigh = 0.67d;
        this.densityLow = 1.0d;
        this.densityHigh = 2.0d;
        this.compressionLow = 2.5d;
        this.compressionHigh = 5.0d;
        if (summaryReportGenerator == null) {
            throw new IllegalArgumentException("SummaryReportGenerator cannot be null");
        }
        this.mReportGenerator = summaryReportGenerator;
    }

    public SummaryAnalysisResult analyze(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("Source text and summary text cannot be null");
        }
        SummaryScores summaryScoresEvaluate = evaluate(str, str2);
        return new SummaryAnalysisResult(summaryScoresEvaluate, classifyStyle(summaryScoresEvaluate), interpretCoverage(summaryScoresEvaluate.coverage), interpretDensity(summaryScoresEvaluate.density), interpretCompression(summaryScoresEvaluate.compression));
    }

    public SummaryStyle classifyStyle(SummaryScores summaryScores) {
        String strInterpretCoverage = interpretCoverage(summaryScores.coverage);
        String strInterpretDensity = interpretDensity(summaryScores.density);
        String strInterpretCompression = interpretCompression(summaryScores.compression);
        return (strInterpretCoverage.equals("High") && strInterpretDensity.equals("High") && !strInterpretCompression.equals("High")) ? SummaryStyle.EXTRACTIVE : (strInterpretCoverage.equals("Low") && strInterpretDensity.equals("Low") && strInterpretCompression.equals("High")) ? SummaryStyle.ABSTRACTIVE : SummaryStyle.MIXED;
    }

    public SummaryScores evaluate(String str, String str2) {
        return new SummaryScores(SummaryEvaluator.calculateCoverage(str, str2), SummaryEvaluator.calculateDensity(str, str2), SummaryEvaluator.calculateCompression(str, str2));
    }

    public String generateSummaryReport(SummaryScores summaryScores) {
        return this.mReportGenerator.generateReport(summaryScores, interpretCoverage(summaryScores.coverage), interpretDensity(summaryScores.density), interpretCompression(summaryScores.compression), classifyStyle(summaryScores));
    }

    public String interpretCompression(double d) {
        return d < this.compressionLow ? "Low" : d < this.compressionHigh ? "Medium" : "High";
    }

    public String interpretCoverage(double d) {
        return d < this.coverageLow ? "Low" : d < this.coverageHigh ? "Medium" : "High";
    }

    public String interpretDensity(double d) {
        return d < this.densityLow ? "Low" : d < this.densityHigh ? "Medium" : "High";
    }

    public String generateSummaryReport(String str, String str2) {
        if (str != null && str2 != null) {
            return generateSummaryReport(evaluate(str, str2));
        }
        throw new NullPointerException("Source text and summary text cannot be null");
    }

    public SummaryAnalyzer(SummaryReportGenerator summaryReportGenerator, double d, double d2, double d3, double d4, double d5, double d6) {
        this.coverageLow = 0.33d;
        this.coverageHigh = 0.67d;
        this.densityLow = 1.0d;
        this.densityHigh = 2.0d;
        this.compressionLow = 2.5d;
        this.compressionHigh = 5.0d;
        if (summaryReportGenerator != null) {
            this.mReportGenerator = summaryReportGenerator;
            this.coverageLow = d;
            this.coverageHigh = d2;
            this.densityLow = d3;
            this.densityHigh = d4;
            this.compressionLow = d5;
            this.compressionHigh = d6;
            return;
        }
        throw new IllegalArgumentException("SummaryReportGenerator cannot be null");
    }
}
