package com.samsung.android.sdk.scs.p142ai.extension.lts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SummaryAnalysisResult {
    private final String mCompressionLevel;
    private final String mCoverageLevel;
    private final String mDensityLevel;
    private final SummaryScores mScores;
    private final SummaryStyle mStyle;

    public SummaryAnalysisResult(SummaryScores summaryScores, SummaryStyle summaryStyle, String str, String str2, String str3) {
        this.mScores = summaryScores;
        this.mStyle = summaryStyle;
        this.mCoverageLevel = str;
        this.mDensityLevel = str2;
        this.mCompressionLevel = str3;
    }

    public String getCompressionLevel() {
        return this.mCompressionLevel;
    }

    public String getCoverageLevel() {
        return this.mCoverageLevel;
    }

    public String getDensityLevel() {
        return this.mDensityLevel;
    }

    public SummaryScores getScores() {
        return this.mScores;
    }

    public SummaryStyle getStyle() {
        return this.mStyle;
    }
}
