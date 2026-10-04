package opennlp.tools.postag;

import java.io.File;
import java.util.Map;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTaggerCrossValidator {
    private POSTaggerFactory factory;
    private String factoryClassName;
    private byte[] featureGeneratorBytes;
    private final String languageCode;
    private final POSTaggerEvaluationMonitor[] listeners;
    private final TrainingParameters params;
    private final POSTagFormat posTagFormat;
    private Map<String, Object> resources;
    private File tagDictionaryFile;
    private final Integer tagdicCutoff;
    private final Mean wordAccuracy;

    public POSTaggerCrossValidator(String str, TrainingParameters trainingParameters, File file, byte[] bArr, Map<String, Object> map, Integer num, String str2, POSTagFormat pOSTagFormat, POSTaggerEvaluationMonitor... pOSTaggerEvaluationMonitorArr) {
        this.wordAccuracy = new Mean();
        this.languageCode = str;
        this.params = trainingParameters;
        this.featureGeneratorBytes = bArr;
        this.resources = map;
        this.listeners = pOSTaggerEvaluationMonitorArr;
        this.factoryClassName = str2;
        this.tagdicCutoff = num;
        this.tagDictionaryFile = file;
        this.posTagFormat = pOSTagFormat;
    }

    public void evaluate(ObjectStream<POSSample> objectStream, int i) {
        TagDictionary tagDictionary;
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            if (this.tagDictionaryFile != null && this.factory.getTagDictionary() == null) {
                POSTaggerFactory pOSTaggerFactory = this.factory;
                pOSTaggerFactory.setTagDictionary(pOSTaggerFactory.createTagDictionary(this.tagDictionaryFile));
            }
            if (this.tagdicCutoff != null) {
                tagDictionary = this.factory.getTagDictionary();
                if (tagDictionary == null) {
                    tagDictionary = this.factory.createEmptyTagDictionary();
                }
                if (!(tagDictionary instanceof MutableTagDictionary)) {
                    throw new IllegalArgumentException("Can't extend a TagDictionary that does not implement MutableTagDictionary.");
                }
                POSTaggerME.populatePOSDictionary(next, (MutableTagDictionary) tagDictionary, this.tagdicCutoff.intValue());
                next.reset();
            } else {
                tagDictionary = null;
            }
            if (this.factory == null) {
                this.factory = POSTaggerFactory.create(this.factoryClassName, null, null);
            }
            this.factory.init(this.featureGeneratorBytes, this.resources, tagDictionary);
            POSEvaluator pOSEvaluator = new POSEvaluator(new POSTaggerME(POSTaggerME.train(this.languageCode, next, this.params, this.factory), this.posTagFormat), this.listeners);
            pOSEvaluator.evaluate(next.getTestSampleStream());
            this.wordAccuracy.add(pOSEvaluator.getWordAccuracy(), pOSEvaluator.getWordCount());
            if (this.tagdicCutoff != null) {
                this.factory.setTagDictionary(null);
            }
        }
    }

    public double getWordAccuracy() {
        return this.wordAccuracy.mean();
    }

    public long getWordCount() {
        return this.wordAccuracy.count();
    }

    public POSTaggerCrossValidator(String str, TrainingParameters trainingParameters, File file, byte[] bArr, Map<String, Object> map, Integer num, String str2, POSTaggerEvaluationMonitor... pOSTaggerEvaluationMonitorArr) {
        this(str, trainingParameters, file, bArr, map, num, str2, POSTagFormat.UD, pOSTaggerEvaluationMonitorArr);
    }

    public POSTaggerCrossValidator(String str, TrainingParameters trainingParameters, POSTaggerFactory pOSTaggerFactory, POSTaggerEvaluationMonitor... pOSTaggerEvaluationMonitorArr) {
        this(str, trainingParameters, pOSTaggerFactory, POSTagFormat.UD, pOSTaggerEvaluationMonitorArr);
    }

    public POSTaggerCrossValidator(String str, TrainingParameters trainingParameters, POSTaggerFactory pOSTaggerFactory, POSTagFormat pOSTagFormat, POSTaggerEvaluationMonitor... pOSTaggerEvaluationMonitorArr) {
        this.wordAccuracy = new Mean();
        this.languageCode = str;
        this.params = trainingParameters;
        this.listeners = pOSTaggerEvaluationMonitorArr;
        this.factory = pOSTaggerFactory;
        this.posTagFormat = pOSTagFormat;
        this.tagdicCutoff = null;
    }
}
