package opennlp.tools.tokenize;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.tokenize.lang.Factory;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.model.ArtifactProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenizerFactory extends BaseToolFactory {
    private static final String ABBREVIATIONS_ENTRY_NAME = "abbreviations.dictionary";
    private static final String ALPHA_NUMERIC_PATTERN = "alphaNumericPattern";
    private static final String USE_ALPHA_NUMERIC_OPTIMIZATION = "useAlphaNumericOptimization";
    private Dictionary abbreviationDictionary;
    private Pattern alphaNumericPattern;
    private String languageCode;
    private Boolean useAlphaNumericOptimization = Boolean.FALSE;

    public TokenizerFactory() {
    }

    public static TokenizerFactory create(String str, String str2, Dictionary dictionary, boolean z, Pattern pattern) throws InvalidFormatException {
        if (str == null) {
            return new TokenizerFactory(str2, dictionary, z, pattern);
        }
        try {
            TokenizerFactory tokenizerFactory = (TokenizerFactory) ExtensionLoader.instantiateExtension(TokenizerFactory.class, str);
            tokenizerFactory.init(str2, dictionary, z, pattern);
            return tokenizerFactory;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization throw an exception."), e);
        }
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public Map<String, Object> createArtifactMap() {
        Map<String, Object> mapCreateArtifactMap = super.createArtifactMap();
        Dictionary dictionary = this.abbreviationDictionary;
        if (dictionary != null) {
            mapCreateArtifactMap.put(ABBREVIATIONS_ENTRY_NAME, dictionary);
        }
        return mapCreateArtifactMap;
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public Map<String, String> createManifestEntries() {
        Map<String, String> mapCreateManifestEntries = super.createManifestEntries();
        mapCreateManifestEntries.put(USE_ALPHA_NUMERIC_OPTIMIZATION, Boolean.toString(isUseAlphaNumericOptimization()));
        if (getAlphaNumericPattern() != null) {
            mapCreateManifestEntries.put(ALPHA_NUMERIC_PATTERN, getAlphaNumericPattern().pattern());
        }
        return mapCreateManifestEntries;
    }

    public Dictionary getAbbreviationDictionary() {
        ArtifactProvider artifactProvider;
        if (this.abbreviationDictionary == null && (artifactProvider = this.artifactProvider) != null) {
            this.abbreviationDictionary = (Dictionary) artifactProvider.getArtifact(ABBREVIATIONS_ENTRY_NAME);
        }
        return this.abbreviationDictionary;
    }

    public Pattern getAlphaNumericPattern() {
        String manifestProperty;
        if (this.alphaNumericPattern == null) {
            ArtifactProvider artifactProvider = this.artifactProvider;
            if (artifactProvider != null && (manifestProperty = artifactProvider.getManifestProperty(ALPHA_NUMERIC_PATTERN)) != null) {
                this.alphaNumericPattern = Pattern.compile(manifestProperty);
            }
            if (this.alphaNumericPattern == null) {
                this.alphaNumericPattern = new Factory().getAlphanumeric(this.languageCode);
            }
        }
        return this.alphaNumericPattern;
    }

    public TokenContextGenerator getContextGenerator() {
        Factory factory = new Factory();
        Dictionary abbreviationDictionary = getAbbreviationDictionary();
        return factory.createTokenContextGenerator(getLanguageCode(), abbreviationDictionary != null ? abbreviationDictionary.asStringSet() : Collections.EMPTY_SET);
    }

    public String getLanguageCode() {
        ArtifactProvider artifactProvider;
        if (this.languageCode == null && (artifactProvider = this.artifactProvider) != null) {
            this.languageCode = artifactProvider.getLanguage();
        }
        return this.languageCode;
    }

    public void init(String str, Dictionary dictionary, boolean z, Pattern pattern) {
        this.languageCode = str;
        this.useAlphaNumericOptimization = Boolean.valueOf(z);
        this.alphaNumericPattern = pattern;
        this.abbreviationDictionary = dictionary;
    }

    public boolean isUseAlphaNumericOptimization() {
        ArtifactProvider artifactProvider = this.artifactProvider;
        if (artifactProvider != null) {
            this.useAlphaNumericOptimization = Boolean.valueOf(artifactProvider.getManifestProperty(USE_ALPHA_NUMERIC_OPTIMIZATION));
        }
        return this.useAlphaNumericOptimization.booleanValue();
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() throws InvalidFormatException {
        if (this.artifactProvider.getManifestProperty(USE_ALPHA_NUMERIC_OPTIMIZATION) == null) {
            throw new InvalidFormatException("useAlphaNumericOptimization is a mandatory property!");
        }
        Object artifact = this.artifactProvider.getArtifact(ABBREVIATIONS_ENTRY_NAME);
        if (artifact != null && !(artifact instanceof Dictionary)) {
            throw new InvalidFormatException(AbstractC0622a.m1165k(artifact, "Abbreviations dictionary '", "' has wrong type, needs to be of type Dictionary!"));
        }
    }

    public TokenizerFactory(String str, Dictionary dictionary, boolean z, Pattern pattern) {
        init(str, dictionary, z, pattern);
    }
}
