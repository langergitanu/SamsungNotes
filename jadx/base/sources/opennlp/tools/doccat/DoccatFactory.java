package opennlp.tools.doccat;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.model.ArtifactProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoccatFactory extends BaseToolFactory {
    private static final String FEATURE_GENERATORS = "doccat.featureGenerators";
    private FeatureGenerator[] featureGenerators;

    public DoccatFactory() {
    }

    public static DoccatFactory create(String str, FeatureGenerator[] featureGeneratorArr) throws InvalidFormatException {
        if (str == null) {
            return new DoccatFactory(featureGeneratorArr);
        }
        try {
            DoccatFactory doccatFactory = (DoccatFactory) ExtensionLoader.instantiateExtension(DoccatFactory.class, str);
            doccatFactory.init(featureGeneratorArr);
            return doccatFactory;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
        }
    }

    private String featureGeneratorsAsString() {
        Iterator it = Arrays.asList(getFeatureGenerators()).iterator();
        StringBuilder sb = new StringBuilder();
        if (it.hasNext()) {
            sb.append(((FeatureGenerator) it.next()).getClass().getCanonicalName());
            while (it.hasNext()) {
                sb.append(',');
                sb.append(((FeatureGenerator) it.next()).getClass().getCanonicalName());
            }
        }
        return sb.toString();
    }

    private FeatureGenerator[] loadFeatureGenerators(String str) {
        String[] strArrSplit = str.split(",");
        FeatureGenerator[] featureGeneratorArr = new FeatureGenerator[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            featureGeneratorArr[i] = (FeatureGenerator) ExtensionLoader.instantiateExtension(FeatureGenerator.class, strArrSplit[i]);
        }
        return featureGeneratorArr;
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public Map<String, String> createManifestEntries() {
        Map<String, String> mapCreateManifestEntries = super.createManifestEntries();
        if (getFeatureGenerators() != null) {
            mapCreateManifestEntries.put(FEATURE_GENERATORS, featureGeneratorsAsString());
        }
        return mapCreateManifestEntries;
    }

    public FeatureGenerator[] getFeatureGenerators() {
        String manifestProperty;
        if (this.featureGenerators == null) {
            ArtifactProvider artifactProvider = this.artifactProvider;
            if (artifactProvider != null && (manifestProperty = artifactProvider.getManifestProperty(FEATURE_GENERATORS)) != null) {
                this.featureGenerators = loadFeatureGenerators(manifestProperty);
            }
            if (this.featureGenerators == null) {
                this.featureGenerators = new FeatureGenerator[]{new BagOfWordsFeatureGenerator()};
            }
        }
        return this.featureGenerators;
    }

    public void init(FeatureGenerator[] featureGeneratorArr) {
        this.featureGenerators = featureGeneratorArr;
    }

    public void setFeatureGenerators(FeatureGenerator[] featureGeneratorArr) {
        this.featureGenerators = featureGeneratorArr;
    }

    public DoccatFactory(FeatureGenerator[] featureGeneratorArr) {
        init(featureGeneratorArr);
    }

    @Override // opennlp.tools.util.BaseToolFactory
    public void validateArtifactMap() {
    }
}
