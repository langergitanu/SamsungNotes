package opennlp.tools.namefind;

import java.util.ArrayList;
import java.util.Objects;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;
import opennlp.tools.util.featuregen.FeatureGeneratorUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultNameContextGenerator implements NameContextGenerator {
    protected AdaptiveFeatureGenerator[] featureGenerators;

    public DefaultNameContextGenerator(AdaptiveFeatureGenerator... adaptiveFeatureGeneratorArr) {
        Objects.requireNonNull(adaptiveFeatureGeneratorArr, "Please specify at least one featureGenerator");
        this.featureGenerators = adaptiveFeatureGeneratorArr;
    }

    @Override // opennlp.tools.namefind.NameContextGenerator
    public void addFeatureGenerator(AdaptiveFeatureGenerator adaptiveFeatureGenerator) {
        AdaptiveFeatureGenerator[] adaptiveFeatureGeneratorArr = this.featureGenerators;
        AdaptiveFeatureGenerator[] adaptiveFeatureGeneratorArr2 = new AdaptiveFeatureGenerator[adaptiveFeatureGeneratorArr.length + 1];
        this.featureGenerators = adaptiveFeatureGeneratorArr2;
        System.arraycopy(adaptiveFeatureGeneratorArr, 0, adaptiveFeatureGeneratorArr2, 0, adaptiveFeatureGeneratorArr.length);
        this.featureGenerators[r0.length - 1] = adaptiveFeatureGenerator;
    }

    @Override // opennlp.tools.namefind.NameContextGenerator
    public void clearAdaptiveData() {
        for (AdaptiveFeatureGenerator adaptiveFeatureGenerator : this.featureGenerators) {
            adaptiveFeatureGenerator.clearAdaptiveData();
        }
    }

    @Override // opennlp.tools.namefind.NameContextGenerator
    public void updateAdaptiveData(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != strArr2.length) {
            throw new IllegalArgumentException("The tokens and outcome arrays MUST have the same size!");
        }
        for (AdaptiveFeatureGenerator adaptiveFeatureGenerator : this.featureGenerators) {
            adaptiveFeatureGenerator.updateAdaptiveData(strArr, strArr2);
        }
    }

    @Override // opennlp.tools.util.BeamSearchContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (AdaptiveFeatureGenerator adaptiveFeatureGenerator : this.featureGenerators) {
            adaptiveFeatureGenerator.createFeatures(arrayList, strArr, i, strArr2);
        }
        if (strArr2 != null) {
            String str = i > 1 ? strArr2[i - 2] : "other";
            String str2 = i > 0 ? strArr2[i - 1] : "other";
            arrayList.add("po=" + str2);
            arrayList.add("pow=" + str2 + "," + strArr[i]);
            arrayList.add("powf=" + str2 + "," + FeatureGeneratorUtil.tokenFeature(strArr[i]));
            StringBuilder sb = new StringBuilder("ppo=");
            sb.append(str);
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
