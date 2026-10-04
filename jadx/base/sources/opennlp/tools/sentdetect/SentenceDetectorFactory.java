package opennlp.tools.sentdetect;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.sentdetect.lang.Factory;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.model.ArtifactProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceDetectorFactory extends BaseToolFactory {
    private static final String ABBREVIATIONS_ENTRY_NAME = "abbreviations.dictionary";
    private static final String EOS_CHARACTERS_PROPERTY = "eosCharacters";
    private static final String TOKEN_END_PROPERTY = "useTokenEnd";
    private Dictionary abbreviationDictionary;
    private char[] eosCharacters;
    private String languageCode;
    private Boolean useTokenEnd = null;

    public SentenceDetectorFactory() {
    }

    public static SentenceDetectorFactory create(String str, String str2, boolean z, Dictionary dictionary, char[] cArr) throws InvalidFormatException {
        if (str == null) {
            return new SentenceDetectorFactory(str2, z, dictionary, cArr);
        }
        try {
            SentenceDetectorFactory sentenceDetectorFactory = (SentenceDetectorFactory) ExtensionLoader.instantiateExtension(SentenceDetectorFactory.class, str);
            sentenceDetectorFactory.init(str2, z, dictionary, cArr);
            return sentenceDetectorFactory;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization throw an exception."), e);
        }
    }

    private String eosCharArrayToString(char[] cArr) {
        return String.valueOf(cArr);
    }

    private char[] eosStringToCharArray(String str) {
        return str.toCharArray();
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
        mapCreateManifestEntries.put(TOKEN_END_PROPERTY, Boolean.toString(isUseTokenEnd()));
        if (getEOSCharacters() != null) {
            mapCreateManifestEntries.put(EOS_CHARACTERS_PROPERTY, eosCharArrayToString(getEOSCharacters()));
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

    public char[] getEOSCharacters() {
        if (this.eosCharacters == null) {
            ArtifactProvider artifactProvider = this.artifactProvider;
            if (artifactProvider != null) {
                String manifestProperty = artifactProvider.getManifestProperty(EOS_CHARACTERS_PROPERTY);
                if (manifestProperty != null) {
                    this.eosCharacters = eosStringToCharArray(manifestProperty);
                }
            } else {
                this.eosCharacters = new Factory().getEOSCharacters(this.languageCode);
            }
        }
        return this.eosCharacters;
    }

    public EndOfSentenceScanner getEndOfSentenceScanner() {
        Factory factory = new Factory();
        char[] eOSCharacters = getEOSCharacters();
        return (eOSCharacters == null || eOSCharacters.length <= 0) ? factory.createEndOfSentenceScanner(this.languageCode) : factory.createEndOfSentenceScanner(eOSCharacters);
    }

    public String getLanguageCode() {
        ArtifactProvider artifactProvider;
        if (this.languageCode == null && (artifactProvider = this.artifactProvider) != null) {
            this.languageCode = artifactProvider.getLanguage();
        }
        return this.languageCode;
    }

    public SDContextGenerator getSDContextGenerator() {
        Factory factory = new Factory();
        char[] eOSCharacters = getEOSCharacters();
        Dictionary abbreviationDictionary = getAbbreviationDictionary();
        Set<String> setAsStringSet = abbreviationDictionary != null ? abbreviationDictionary.asStringSet() : Collections.EMPTY_SET;
        return (eOSCharacters == null || eOSCharacters.length <= 0) ? factory.createSentenceContextGenerator(this.languageCode, setAsStringSet) : factory.createSentenceContextGenerator(setAsStringSet, eOSCharacters);
    }

    public void init(String str, boolean z, Dictionary dictionary, char[] cArr) {
        this.languageCode = str;
        this.useTokenEnd = Boolean.valueOf(z);
        this.eosCharacters = cArr;
        this.abbreviationDictionary = dictionary;
    }

    public boolean isUseTokenEnd() {
        ArtifactProvider artifactProvider;
        if (this.useTokenEnd == null && (artifactProvider = this.artifactProvider) != null) {
            this.useTokenEnd = Boolean.valueOf(artifactProvider.getManifestProperty(TOKEN_END_PROPERTY));
        }
        return this.useTokenEnd.booleanValue();
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() throws InvalidFormatException {
        if (this.artifactProvider.getManifestProperty(TOKEN_END_PROPERTY) == null) {
            throw new InvalidFormatException("useTokenEnd is a mandatory property!");
        }
        Object artifact = this.artifactProvider.getArtifact(ABBREVIATIONS_ENTRY_NAME);
        if (artifact != null && !(artifact instanceof Dictionary)) {
            throw new InvalidFormatException(AbstractC0622a.m1165k(artifact, "Abbreviations dictionary '", "' has wrong type, needs to be of type Dictionary!"));
        }
    }

    public SentenceDetectorFactory(String str, boolean z, Dictionary dictionary, char[] cArr) {
        init(str, z, dictionary, cArr);
    }
}
