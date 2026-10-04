package opennlp.tools.langdetect;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.p217ml.AbstractEventTrainer;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.util.MutableInt;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorME implements LanguageDetector {
    private static final long serialVersionUID = 2426614409522429702L;
    private final LanguageDetectorContextGenerator mContextGenerator;
    protected final LanguageDetectorModel model;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringCPLengthPair extends AbstractC12991c {
        private final int length;

        /* JADX INFO: renamed from: s */
        private final String f9667s;

        public /* synthetic */ StringCPLengthPair(String str, int i, int i2) {
            this(str, i);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof StringCPLengthPair)) {
                return false;
            }
            StringCPLengthPair stringCPLengthPair = (StringCPLengthPair) obj;
            return this.length == stringCPLengthPair.length && Objects.equals(this.f9667s, stringCPLengthPair.f9667s);
        }

        public String getString() {
            return this.f9667s;
        }

        public final int hashCode() {
            int i = this.length;
            return Objects.hashCode(this.f9667s) + (i * 31);
        }

        public int length() {
            return this.length;
        }

        /* JADX INFO: renamed from: s */
        public String m14472s() {
            return this.f9667s;
        }

        public final String toString() {
            Object[] objArr = {this.f9667s, Integer.valueOf(this.length)};
            String[] strArrSplit = "s;length".length() == 0 ? new String[0] : "s;length".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(StringCPLengthPair.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        private StringCPLengthPair(String str, int i) {
            this.f9667s = str;
            this.length = i;
        }
    }

    public LanguageDetectorME(LanguageDetectorModel languageDetectorModel) {
        this.model = languageDetectorModel;
        this.mContextGenerator = languageDetectorModel.getFactory().getContextGenerator();
    }

    private Map<CharSequence, MutableInt> arrayToCounts(CharSequence[] charSequenceArr) {
        HashMap map = new HashMap();
        updateCounts(charSequenceArr, map);
        return map;
    }

    private StringCPLengthPair chunk(CharSequence charSequence, int i, int i2) {
        int i4 = 0;
        if (i != 0 || i2 <= charSequence.length()) {
            int[] array = charSequence.codePoints().skip(i).limit(i2).toArray();
            return new StringCPLengthPair(new String(array, 0, array.length), array.length, i4);
        }
        String string = charSequence.toString();
        return new StringCPLengthPair(string, string.codePointCount(0, string.length()), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$predict$0(Language language, Language language2) {
        return Double.compare(language2.getConfidence(), language.getConfidence());
    }

    private Language[] predict(Map<CharSequence, MutableInt> map) {
        String[] strArr = new String[map.size()];
        float[] fArr = new float[map.size()];
        Iterator<Map.Entry<CharSequence, MutableInt>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().getKey().toString();
            fArr[i] = 1.0f;
            i++;
        }
        double[] dArrEval = this.model.getMaxentModel().eval(strArr, fArr);
        Language[] languageArr = new Language[dArrEval.length];
        for (int i2 = 0; i2 < dArrEval.length; i2++) {
            languageArr[i2] = new Language(this.model.getMaxentModel().getOutcome(i2), dArrEval[i2]);
        }
        Arrays.sort(languageArr, new C0016a(21));
        return languageArr;
    }

    public static LanguageDetectorModel train(ObjectStream<LanguageSample> objectStream, TrainingParameters trainingParameters, LanguageDetectorFactory languageDetectorFactory) {
        HashMap map = new HashMap();
        trainingParameters.putIfAbsent(AbstractEventTrainer.DATA_INDEXER_PARAM, AbstractEventTrainer.DATA_INDEXER_ONE_PASS_VALUE);
        return new LanguageDetectorModel(TrainerFactory.getEventTrainer(trainingParameters, map).train(new LanguageDetectorEventStream(objectStream, languageDetectorFactory.getContextGenerator())), map, languageDetectorFactory);
    }

    private void updateCounts(CharSequence[] charSequenceArr, Map<CharSequence, MutableInt> map) {
        for (CharSequence charSequence : charSequenceArr) {
            MutableInt mutableInt = map.get(charSequence);
            if (mutableInt == null) {
                map.put(charSequence, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
    }

    @Override // opennlp.tools.langdetect.LanguageDetector
    public String[] getSupportedLanguages() {
        int numOutcomes = this.model.getMaxentModel().getNumOutcomes();
        String[] strArr = new String[numOutcomes];
        for (int i = 0; i < numOutcomes; i++) {
            strArr[i] = this.model.getMaxentModel().getOutcome(i);
        }
        return strArr;
    }

    @Override // opennlp.tools.langdetect.LanguageDetector
    public Language predictLanguage(CharSequence charSequence) {
        return predictLanguages(charSequence)[0];
    }

    @Override // opennlp.tools.langdetect.LanguageDetector
    public Language[] predictLanguages(CharSequence charSequence) {
        return predict(arrayToCounts(this.mContextGenerator.getContext(charSequence)));
    }

    public ProbingLanguageDetectionResult probingPredictLanguages(CharSequence charSequence) {
        return probingPredictLanguages(charSequence, LanguageDetectorConfig.DEFAULT_LANGUAGE_DETECTOR_CONFIG);
    }

    public boolean seenEnough(List<Language[]> list, Language[] languageArr, Map<CharSequence, MutableInt> map, LanguageDetectorConfig languageDetectorConfig) {
        if (list.size() < languageDetectorConfig.getMinConsecImprovements()) {
            list.add(languageArr);
            return false;
        }
        if (list.size() > languageDetectorConfig.getMinConsecImprovements() && list.size() > 0) {
            list.remove(0);
        }
        list.add(languageArr);
        if (languageDetectorConfig.getMinDiff() > 0.0d && languageArr[0].getConfidence() - languageArr[1].getConfidence() < languageDetectorConfig.getMinDiff()) {
            return false;
        }
        String lang = null;
        double confidence = -1.0d;
        for (Language[] languageArr2 : list) {
            if (lang == null) {
                lang = languageArr2[0].getLang();
                confidence = languageArr2[0].getConfidence();
            } else {
                if (!lang.equals(languageArr2[0].getLang()) || confidence > languageArr2[0].getConfidence()) {
                    return false;
                }
                lang = languageArr2[0].getLang();
                confidence = languageArr2[0].getConfidence();
            }
        }
        return true;
    }

    public ProbingLanguageDetectionResult probingPredictLanguages(CharSequence charSequence, LanguageDetectorConfig languageDetectorConfig) {
        LinkedList linkedList = new LinkedList();
        HashMap map = new HashMap();
        int length = 0;
        Language[] languageArrPredict = null;
        do {
            StringCPLengthPair stringCPLengthPairChunk = chunk(charSequence, length, languageDetectorConfig.getChunkSize() + length > languageDetectorConfig.getMaxLength() ? languageDetectorConfig.getMaxLength() - length : languageDetectorConfig.getChunkSize());
            if (stringCPLengthPairChunk.length() == 0) {
                return languageArrPredict == null ? new ProbingLanguageDetectionResult(predict(map), length) : new ProbingLanguageDetectionResult(languageArrPredict, length);
            }
            length += stringCPLengthPairChunk.length();
            updateCounts(this.mContextGenerator.getContext(stringCPLengthPairChunk.f9667s), map);
            languageArrPredict = predict(map);
        } while (!seenEnough(linkedList, languageArrPredict, map, languageDetectorConfig));
        return new ProbingLanguageDetectionResult(languageArrPredict, length);
    }
}
