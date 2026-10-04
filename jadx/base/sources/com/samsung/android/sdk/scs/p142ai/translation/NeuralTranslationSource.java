package com.samsung.android.sdk.scs.p142ai.translation;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NeuralTranslationSource {
    private Boolean appendMeta;
    private int contextCandidate;
    private boolean endOfContext;
    private String fallbackLanguage;
    private Boolean forcePivot;
    private Boolean formality;

    /* JADX INFO: renamed from: id */
    private String f5228id;
    private String mode;
    private boolean needSentenceSplit;
    private String requestingPackageName;
    private String requestingSourceId;
    private String sourceLanguage;
    private String sourceText;
    private String targetLanguage;
    private Boolean verbose;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TranslationSourceBuilder {
        Boolean appendMeta;
        int contextCandidate;
        boolean endOfContext;
        Boolean forcePivot;
        Boolean formality;
        String mode;
        boolean needSentenceSplit;
        String requestingPackageName;
        String requestingSourceId;
        String sourceLanguage;
        String sourceText;
        String targetLanguage;
        Boolean verbose;

        /* JADX INFO: renamed from: id */
        String f5229id = "";
        String fallbackLanguage = "en";

        public TranslationSourceBuilder(String str, String str2, String str3) {
            Boolean bool = Boolean.FALSE;
            this.verbose = bool;
            this.appendMeta = bool;
            this.formality = bool;
            this.mode = "plain";
            this.forcePivot = bool;
            this.requestingPackageName = "";
            this.needSentenceSplit = true;
            this.requestingSourceId = "";
            this.endOfContext = false;
            this.contextCandidate = 1;
            this.sourceText = str;
            this.sourceLanguage = str2;
            this.targetLanguage = str3;
        }

        public TranslationSourceBuilder appendMeta(Boolean bool) {
            this.appendMeta = bool;
            return this;
        }

        public NeuralTranslationSource build() {
            NeuralTranslationSource neuralTranslationSource = new NeuralTranslationSource(0);
            neuralTranslationSource.sourceText = this.sourceText;
            neuralTranslationSource.sourceLanguage = this.sourceLanguage;
            neuralTranslationSource.targetLanguage = this.targetLanguage;
            neuralTranslationSource.verbose = this.verbose;
            neuralTranslationSource.appendMeta = this.appendMeta;
            neuralTranslationSource.f5228id = this.f5229id;
            neuralTranslationSource.fallbackLanguage = this.fallbackLanguage;
            neuralTranslationSource.forcePivot = this.forcePivot;
            neuralTranslationSource.mode = this.mode;
            neuralTranslationSource.formality = this.formality;
            neuralTranslationSource.requestingPackageName = this.requestingPackageName;
            neuralTranslationSource.needSentenceSplit = this.needSentenceSplit;
            neuralTranslationSource.requestingSourceId = this.requestingSourceId;
            neuralTranslationSource.endOfContext = this.endOfContext;
            neuralTranslationSource.contextCandidate = this.contextCandidate;
            return neuralTranslationSource;
        }

        public TranslationSourceBuilder contextCandidate(int i) {
            this.contextCandidate = i;
            return this;
        }

        public TranslationSourceBuilder endOfContext(boolean z) {
            this.endOfContext = z;
            return this;
        }

        public TranslationSourceBuilder fallbackLanguage(String str) {
            this.fallbackLanguage = str;
            return this;
        }

        public TranslationSourceBuilder forcePivot(Boolean bool) {
            this.forcePivot = bool;
            return this;
        }

        public TranslationSourceBuilder formality(Boolean bool) {
            this.formality = bool;
            return this;
        }

        /* JADX INFO: renamed from: id */
        public TranslationSourceBuilder m6443id(String str) {
            this.f5229id = str;
            return this;
        }

        public TranslationSourceBuilder mode(String str) {
            this.mode = str;
            return this;
        }

        public TranslationSourceBuilder requestingPackageName(String str) {
            this.requestingPackageName = str;
            return this;
        }

        public TranslationSourceBuilder requestingSourceId(String str) {
            this.requestingSourceId = str;
            return this;
        }

        public TranslationSourceBuilder sentenceSplit(boolean z) {
            this.needSentenceSplit = z;
            return this;
        }

        public TranslationSourceBuilder verbose(Boolean bool) {
            this.verbose = bool;
            return this;
        }
    }

    public /* synthetic */ NeuralTranslationSource(int i) {
        this();
    }

    public static TranslationSourceBuilder builder(String str, String str2, String str3) {
        return new TranslationSourceBuilder(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NeuralTranslationSource neuralTranslationSource = (NeuralTranslationSource) obj;
            if (Objects.equals(this.sourceLanguage, neuralTranslationSource.sourceLanguage) && Objects.equals(this.targetLanguage, neuralTranslationSource.targetLanguage) && Objects.equals(this.sourceText, neuralTranslationSource.sourceText) && Objects.equals(this.f5228id, neuralTranslationSource.f5228id) && Objects.equals(this.fallbackLanguage, neuralTranslationSource.fallbackLanguage) && Objects.equals(this.verbose, neuralTranslationSource.verbose) && Objects.equals(this.appendMeta, neuralTranslationSource.appendMeta) && Objects.equals(this.formality, neuralTranslationSource.formality) && Objects.equals(this.mode, neuralTranslationSource.mode) && Objects.equals(this.forcePivot, neuralTranslationSource.forcePivot) && Objects.equals(this.requestingPackageName, neuralTranslationSource.requestingPackageName) && Boolean.valueOf(this.needSentenceSplit).equals(Boolean.valueOf(neuralTranslationSource.needSentenceSplit)) && Objects.equals(this.requestingSourceId, neuralTranslationSource.requestingSourceId) && Boolean.valueOf(this.endOfContext).equals(Boolean.valueOf(neuralTranslationSource.endOfContext)) && Integer.valueOf(this.contextCandidate).equals(Integer.valueOf(neuralTranslationSource.contextCandidate))) {
                return true;
            }
        }
        return false;
    }

    public Boolean getAppendMeta() {
        return this.appendMeta;
    }

    public int getContextCandidate() {
        return this.contextCandidate;
    }

    public boolean getEndOfContext() {
        return this.endOfContext;
    }

    public String getFallbackLanguage() {
        return this.fallbackLanguage;
    }

    public Boolean getForcePivot() {
        return this.forcePivot;
    }

    public Boolean getFormality() {
        return this.formality;
    }

    public String getId() {
        return this.f5228id;
    }

    public String getMode() {
        return this.mode;
    }

    public String getRequestingPackageName() {
        return this.requestingPackageName;
    }

    public String getRequestingSourceId() {
        return this.requestingSourceId;
    }

    public boolean getSentenceSplit() {
        return this.needSentenceSplit;
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

    public Boolean getVerbose() {
        return this.verbose;
    }

    public int hashCode() {
        return Objects.hash(this.sourceLanguage, this.targetLanguage, this.sourceText, this.f5228id, this.fallbackLanguage, this.verbose, this.appendMeta, this.formality, this.mode, this.forcePivot, this.requestingPackageName, Boolean.valueOf(this.needSentenceSplit), this.requestingSourceId, Boolean.valueOf(this.endOfContext), Integer.valueOf(this.contextCandidate));
    }

    private NeuralTranslationSource() {
    }
}
