package com.samsung.android.ocr;

import com.samsung.android.ocr.MOCRConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCROptions {
    private final boolean detectOrientation;
    private final boolean detectTables;
    private final boolean disableLineProcessing;
    private final boolean filterIcons;
    private final boolean forceLang;
    private final boolean getCharResult;
    private final int imageType;
    private final int languageMode;
    private final int numThreads;
    private final int ocrMode;
    private final boolean optimizeCpu;
    private final boolean runInverted;
    private final boolean useBeamSearch;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private boolean useBeamSearch = false;
        private boolean disableLineProcessing = false;
        private boolean optimizeCpu = false;
        private boolean getCharResult = false;
        private boolean forceLang = false;
        private boolean runInverted = false;
        private int numThreads = 4;
        private boolean filterIcons = true;
        private boolean detectOrientation = true;
        private boolean detectTables = true;
        private int languageMode = MOCRConstants.MOCRLanguageMode.Auto.getValue();
        public int ocrMode = MOCRConstants.MOCRSTRBackbone.Auto.getValue();
        private int imageType = MOCRConstants.MOCRImageType.Generic.getValue();

        public MOCROptions build() {
            return new MOCROptions(this, 0);
        }

        public Builder setDetectOrientation(boolean z) {
            this.detectOrientation = z;
            return this;
        }

        public Builder setDetectTables(boolean z) {
            this.detectTables = z;
            return this;
        }

        public Builder setDisableLineProcessing(boolean z) {
            this.disableLineProcessing = z;
            return this;
        }

        public Builder setFilterIcons(boolean z) {
            this.filterIcons = z;
            return this;
        }

        public Builder setForceLang(boolean z) {
            this.forceLang = z;
            return this;
        }

        public Builder setGetCharResult(boolean z) {
            this.getCharResult = z;
            return this;
        }

        public Builder setImageType(int i) {
            this.imageType = i;
            return this;
        }

        public Builder setLanguageMode(int i) {
            this.languageMode = i;
            return this;
        }

        public Builder setNumThreads(int i) {
            this.numThreads = i;
            return this;
        }

        public Builder setOptimizeCpu(boolean z) {
            this.optimizeCpu = z;
            return this;
        }

        public Builder setRunInverted(boolean z) {
            this.runInverted = z;
            return this;
        }

        public Builder setSTRBackbone(int i) {
            this.ocrMode = i;
            return this;
        }

        public Builder setUseBeamSearch(boolean z) {
            this.useBeamSearch = z;
            return this;
        }
    }

    public /* synthetic */ MOCROptions(Builder builder, int i) {
        this(builder);
    }

    public int getImageType() {
        return this.imageType;
    }

    public int getLanguageMode() {
        return this.languageMode;
    }

    public int getNumThreads() {
        return this.numThreads;
    }

    public int getSTRBackbone() {
        return this.ocrMode;
    }

    public boolean isDetectOrientation() {
        return this.detectOrientation;
    }

    public boolean isDetectTables() {
        return this.detectTables;
    }

    public boolean isDisableLineProcessing() {
        return this.disableLineProcessing;
    }

    public boolean isFilterIcons() {
        return this.filterIcons;
    }

    public boolean isForceLang() {
        return this.forceLang;
    }

    public boolean isGetCharResult() {
        return this.getCharResult;
    }

    public boolean isOptimizeCpu() {
        return this.optimizeCpu;
    }

    public boolean isRunInverted() {
        return this.runInverted;
    }

    public boolean isUseBeamSearch() {
        return this.useBeamSearch;
    }

    private MOCROptions(Builder builder) {
        this.useBeamSearch = builder.useBeamSearch;
        this.disableLineProcessing = builder.disableLineProcessing;
        this.optimizeCpu = builder.optimizeCpu;
        this.getCharResult = builder.getCharResult;
        this.forceLang = builder.forceLang;
        this.runInverted = builder.runInverted;
        this.numThreads = builder.numThreads;
        this.filterIcons = builder.filterIcons;
        this.detectOrientation = builder.detectOrientation;
        this.detectTables = builder.detectTables;
        this.languageMode = builder.languageMode;
        this.ocrMode = builder.ocrMode;
        this.imageType = builder.imageType;
    }
}
