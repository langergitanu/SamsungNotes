package opennlp.tools.namefind;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.featuregen.BrownCluster;
import opennlp.tools.util.featuregen.WordClusterDictionary;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.BaseModel;
import opennlp.tools.util.model.ByteArraySerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenNameFinderModel extends BaseModel {
    private static final String COMPONENT_NAME = "NameFinderME";
    static final String GENERATOR_DESCRIPTOR_ENTRY_NAME = "generator.featuregen";
    private static final String MAXENT_MODEL_ENTRY_NAME = "nameFinder.model";
    static final String SEQUENCE_CODEC_CLASS_NAME_PARAMETER = "sequenceCodecImplName";
    private static final long serialVersionUID = -459655422186301499L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FeatureGeneratorCreationError extends RuntimeException {
        private static final long serialVersionUID = -7004590770543145243L;

        public FeatureGeneratorCreationError(Throwable th) {
            super(th);
        }
    }

    public TokenNameFinderModel(String str, SequenceClassificationModel sequenceClassificationModel, byte[] bArr, Map<String, Object> map, Map<String, String> map2, SequenceCodec<String> sequenceCodec, TokenNameFinderFactory tokenNameFinderFactory) {
        super(COMPONENT_NAME, str, map2, tokenNameFinderFactory);
        init(sequenceClassificationModel, bArr, map, map2, sequenceCodec);
        if (!sequenceCodec.areOutcomesCompatible(sequenceClassificationModel.getOutcomes())) {
            throw new IllegalArgumentException("Model not compatible with name finder!");
        }
    }

    private void init(Object obj, byte[] bArr, Map<String, Object> map, Map<String, String> map2, SequenceCodec<String> sequenceCodec) {
        ((Properties) this.artifactMap.get("manifest.properties")).put(SEQUENCE_CODEC_CLASS_NAME_PARAMETER, sequenceCodec.getClass().getName());
        this.artifactMap.put(MAXENT_MODEL_ENTRY_NAME, obj);
        if (bArr != null && bArr.length > 0) {
            this.artifactMap.put(GENERATOR_DESCRIPTOR_ENTRY_NAME, bArr);
        }
        if (map != null) {
            if (map.containsKey(MAXENT_MODEL_ENTRY_NAME) || map.containsKey(GENERATOR_DESCRIPTOR_ENTRY_NAME)) {
                throw new IllegalArgumentException();
            }
            this.artifactMap.putAll(map);
        }
        checkArtifactMap();
    }

    private boolean isModelValid(MaxentModel maxentModel) {
        String[] strArr = new String[maxentModel.getNumOutcomes()];
        for (int i = 0; i < maxentModel.getNumOutcomes(); i++) {
            strArr[i] = maxentModel.getOutcome(i);
        }
        return getFactory().createSequenceCodec().areOutcomesCompatible(strArr);
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void createArtifactSerializers(Map<String, ArtifactSerializer<?>> map) {
        super.createArtifactSerializers(map);
        map.put("featuregen", new ByteArraySerializer());
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return TokenNameFinderFactory.class;
    }

    public TokenNameFinderFactory getFactory() {
        return (TokenNameFinderFactory) this.toolFactory;
    }

    public SequenceClassificationModel getNameFinderSequenceModel() {
        Properties properties = (Properties) this.artifactMap.get("manifest.properties");
        if (this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME) instanceof MaxentModel) {
            String property = properties.getProperty(BeamSearch.BEAM_SIZE_PARAMETER);
            return new BeamSearch(property != null ? Integer.parseInt(property) : 3, (MaxentModel) this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME));
        }
        if (this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME) instanceof SequenceClassificationModel) {
            return (SequenceClassificationModel) this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME);
        }
        return null;
    }

    public SequenceCodec<String> getSequenceCodec() {
        return getFactory().getSequenceCodec();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME) instanceof MaxentModel) && !(this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME) instanceof SequenceClassificationModel)) {
            throw new InvalidFormatException("Token Name Finder model is incomplete!");
        }
    }

    public static Map<String, ArtifactSerializer<?>> createArtifactSerializers() {
        Map<String, ArtifactSerializer<?>> mapCreateArtifactSerializers = BaseModel.createArtifactSerializers();
        mapCreateArtifactSerializers.put("featuregen", new ByteArraySerializer());
        mapCreateArtifactSerializers.put("wordcluster", new WordClusterDictionary.WordClusterDictionarySerializer());
        mapCreateArtifactSerializers.put("brownclustertoken", new BrownCluster.BrownClusterSerializer());
        mapCreateArtifactSerializers.put("brownclustertokenclass", new BrownCluster.BrownClusterSerializer());
        mapCreateArtifactSerializers.put("brownclusterbigram", new BrownCluster.BrownClusterSerializer());
        return mapCreateArtifactSerializers;
    }

    public TokenNameFinderModel(String str, MaxentModel maxentModel, int i, byte[] bArr, Map<String, Object> map, Map<String, String> map2, SequenceCodec<String> sequenceCodec, TokenNameFinderFactory tokenNameFinderFactory) {
        super(COMPONENT_NAME, str, map2, tokenNameFinderFactory);
        ((Properties) this.artifactMap.get("manifest.properties")).put(BeamSearch.BEAM_SIZE_PARAMETER, Integer.toString(i));
        init(maxentModel, bArr, map, map2, sequenceCodec);
        if (!isModelValid(maxentModel)) {
            throw new IllegalArgumentException("Model not compatible with name finder!");
        }
    }

    public TokenNameFinderModel(String str, MaxentModel maxentModel, byte[] bArr, Map<String, Object> map, Map<String, String> map2) {
        this(str, maxentModel, 3, bArr, map, map2, new BioCodec(), new TokenNameFinderFactory());
    }

    public TokenNameFinderModel(String str, MaxentModel maxentModel, int i, byte[] bArr, Map<String, Object> map, Map<String, String> map2) {
        this(str, maxentModel, i, bArr, map, map2, new BioCodec(), new TokenNameFinderFactory());
    }

    public TokenNameFinderModel(String str, MaxentModel maxentModel, Map<String, Object> map, Map<String, String> map2) {
        this(str, maxentModel, null, map, map2);
    }

    public TokenNameFinderModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public TokenNameFinderModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public TokenNameFinderModel(Path path) {
        super(COMPONENT_NAME, path);
    }

    public TokenNameFinderModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
