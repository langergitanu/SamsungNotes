package opennlp.tools.util.featuregen;

import java.util.List;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.namefind.DictionaryNameFinder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryFeatureGenerator implements AdaptiveFeatureGenerator {
    private InSpanGenerator isg;

    public DictionaryFeatureGenerator(Dictionary dictionary) {
        this("", dictionary);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        this.isg.createFeatures(list, strArr, i, strArr2);
    }

    public void setDictionary(Dictionary dictionary) {
        setDictionary("", dictionary);
    }

    public DictionaryFeatureGenerator(String str, Dictionary dictionary) {
        setDictionary(str, dictionary);
    }

    public void setDictionary(String str, Dictionary dictionary) {
        this.isg = new InSpanGenerator(str, new DictionaryNameFinder(dictionary));
    }
}
