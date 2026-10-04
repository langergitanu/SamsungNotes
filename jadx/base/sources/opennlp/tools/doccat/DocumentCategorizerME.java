package opennlp.tools.doccat;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentCategorizerME implements DocumentCategorizer {
    private final DocumentCategorizerContextGenerator mContextGenerator;
    private final DoccatModel model;

    public DocumentCategorizerME(DoccatModel doccatModel) {
        this.model = doccatModel;
        this.mContextGenerator = new DocumentCategorizerContextGenerator(doccatModel.getFactory().getFeatureGenerators());
    }

    public static DoccatModel train(String str, ObjectStream<DocumentSample> objectStream, TrainingParameters trainingParameters, DoccatFactory doccatFactory) {
        HashMap map = new HashMap();
        return new DoccatModel(str, TrainerFactory.getEventTrainer(trainingParameters, map).train(new DocumentCategorizerEventStream(objectStream, doccatFactory.getFeatureGenerators())), map, doccatFactory);
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public double[] categorize(String[] strArr, Map<String, Object> map) {
        return this.model.getMaxentModel().eval(this.mContextGenerator.getContext(strArr, map));
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public String getAllResults(double[] dArr) {
        return this.model.getMaxentModel().getAllOutcomes(dArr);
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public String getBestCategory(double[] dArr) {
        return this.model.getMaxentModel().getBestOutcome(dArr);
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public String getCategory(int i) {
        return this.model.getMaxentModel().getOutcome(i);
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public int getIndex(String str) {
        return this.model.getMaxentModel().getIndex(str);
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public int getNumberOfCategories() {
        return this.model.getMaxentModel().getNumOutcomes();
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public Map<String, Double> scoreMap(String[] strArr) {
        HashMap map = new HashMap();
        double[] dArrCategorize = categorize(strArr);
        int numberOfCategories = getNumberOfCategories();
        for (int i = 0; i < numberOfCategories; i++) {
            String category = getCategory(i);
            map.put(category, Double.valueOf(dArrCategorize[getIndex(category)]));
        }
        return map;
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public SortedMap<Double, Set<String>> sortedScoreMap(String[] strArr) {
        TreeMap treeMap = new TreeMap();
        double[] dArrCategorize = categorize(strArr);
        int numberOfCategories = getNumberOfCategories();
        for (int i = 0; i < numberOfCategories; i++) {
            String category = getCategory(i);
            double d = dArrCategorize[getIndex(category)];
            if (treeMap.containsKey(Double.valueOf(d))) {
                ((Set) treeMap.get(Double.valueOf(d))).add(category);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(category);
                treeMap.put(Double.valueOf(d), hashSet);
            }
        }
        return treeMap;
    }

    @Override // opennlp.tools.doccat.DocumentCategorizer
    public double[] categorize(String[] strArr) {
        return categorize(strArr, Collections.EMPTY_MAP);
    }
}
