package com.samsung.android.sdk.scs.p142ai.translation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NeuralTranslationResult {
    private Boolean appendMeta;
    private Boolean forcePivot;
    private Boolean formality;

    /* JADX INFO: renamed from: id */
    private String f5226id;
    private String interimResult;
    private Boolean isComplete;
    private String sourceLanguage;
    private String sourceText;
    private String targetLanguage;
    private String targetText;
    private Boolean verbose;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TranslationResultBuilder {
        private Boolean appendMeta;
        private Boolean forcePivot;
        private Boolean formality;
        private String interimResult;
        private Boolean isComplete;
        private String targetLanguage;
        private Boolean verbose;
        private String sourceLanguage = "";
        private String sourceText = "";
        private String targetText = "";

        /* JADX INFO: renamed from: id */
        private String f5227id = "";

        public TranslationResultBuilder() {
            Boolean bool = Boolean.FALSE;
            this.verbose = bool;
            this.appendMeta = bool;
            this.formality = bool;
            this.forcePivot = bool;
            this.interimResult = "";
            this.isComplete = bool;
        }

        public TranslationResultBuilder appendMeta(Boolean bool) {
            this.appendMeta = bool;
            return this;
        }

        public NeuralTranslationResult build() {
            NeuralTranslationResult neuralTranslationResult = new NeuralTranslationResult();
            neuralTranslationResult.sourceText = this.sourceText;
            neuralTranslationResult.targetText = this.targetText;
            neuralTranslationResult.sourceLanguage = this.sourceLanguage;
            neuralTranslationResult.targetLanguage = this.targetLanguage;
            neuralTranslationResult.f5226id = this.f5227id;
            neuralTranslationResult.verbose = this.verbose;
            neuralTranslationResult.appendMeta = this.appendMeta;
            neuralTranslationResult.formality = this.formality;
            neuralTranslationResult.forcePivot = this.forcePivot;
            neuralTranslationResult.interimResult = this.interimResult;
            neuralTranslationResult.isComplete = this.isComplete;
            return neuralTranslationResult;
        }

        public TranslationResultBuilder forcePivot(Boolean bool) {
            this.forcePivot = bool;
            return this;
        }

        public TranslationResultBuilder formality(Boolean bool) {
            this.formality = bool;
            return this;
        }

        /* JADX INFO: renamed from: id */
        public TranslationResultBuilder m6423id(String str) {
            this.f5227id = str;
            return this;
        }

        public TranslationResultBuilder interimResult(String str) {
            this.interimResult = str;
            return this;
        }

        public TranslationResultBuilder isComplete(Boolean bool) {
            this.isComplete = bool;
            return this;
        }

        public TranslationResultBuilder sourceLanguage(String str) {
            this.sourceLanguage = str;
            return this;
        }

        public TranslationResultBuilder sourceText(String str) {
            this.sourceText = str;
            return this;
        }

        public TranslationResultBuilder targetLanguage(String str) {
            this.targetLanguage = str;
            return this;
        }

        public TranslationResultBuilder targetText(String str) {
            this.targetText = str;
            return this;
        }

        public TranslationResultBuilder verbose(Boolean bool) {
            this.verbose = bool;
            return this;
        }
    }

    public static TranslationResultBuilder builder() {
        return new TranslationResultBuilder();
    }

    public Boolean getAppendMeta() {
        return this.appendMeta;
    }

    public Boolean getForcePivot() {
        return this.forcePivot;
    }

    public Boolean getFormality() {
        return this.formality;
    }

    public String getId() {
        return this.f5226id;
    }

    public String getInterimResult() {
        return this.interimResult;
    }

    public String getSourceLanguage() {
        return this.sourceLanguage;
    }

    public String getSourceText() {
        return this.sourceText;
    }

    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getTargetText() {
        return this.targetText;
    }

    public Boolean getVerbose() {
        return this.verbose;
    }

    public boolean isComplete() {
        return this.isComplete.booleanValue();
    }
}
