package opennlp.tools.sentdetect;

import androidx.compose.runtime.AbstractC1974b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.sentdetect.lang.Factory;
import opennlp.tools.util.DownloadUtil;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;
import opennlp.tools.util.TrainingParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceDetectorME implements SentenceDetector {
    public static final String NO_SPLIT = "n";
    public static final String SPLIT = "s";
    private final Dictionary abbDict;
    private final SDContextGenerator cgen;
    private final MaxentModel model;
    private final EndOfSentenceScanner scanner;
    private final List<Double> sentProbs;
    protected final boolean useTokenEnd;

    public SentenceDetectorME(String str) {
        this((SentenceModel) DownloadUtil.downloadModel(str, DownloadUtil.ModelType.SENTENCE_DETECTOR, SentenceModel.class));
    }

    private static Set<String> getAbbreviations(Dictionary dictionary) {
        return dictionary == null ? Collections.EMPTY_SET : dictionary.asStringSet();
    }

    private int getFirstNonWS(CharSequence charSequence, int i) {
        while (i < charSequence.length() && StringUtil.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        return i;
    }

    private int getFirstWS(CharSequence charSequence, int i) {
        while (i < charSequence.length() && !StringUtil.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        return i;
    }

    public static SentenceModel train(String str, ObjectStream<SentenceSample> objectStream, SentenceDetectorFactory sentenceDetectorFactory, TrainingParameters trainingParameters) {
        HashMap map = new HashMap();
        return new SentenceModel(str, TrainerFactory.getEventTrainer(trainingParameters, map).train(new SDEventStream(objectStream, sentenceDetectorFactory.getSDContextGenerator(), sentenceDetectorFactory.getEndOfSentenceScanner())), map, sentenceDetectorFactory);
    }

    public double[] getSentenceProbabilities() {
        int size = this.sentProbs.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = this.sentProbs.get(i).doubleValue();
        }
        return dArr;
    }

    public boolean isAcceptableBreak(CharSequence charSequence, int i, int i2) {
        Dictionary dictionary = this.abbDict;
        if (dictionary == null) {
            return true;
        }
        Iterator<StringList> it = dictionary.iterator();
        while (it.hasNext()) {
            String token = it.next().getToken(0);
            int length = token.length();
            int iIndexOf = charSequence.toString().indexOf(token, i);
            if (length + iIndexOf >= i2 && iIndexOf <= i2) {
                return false;
            }
        }
        return true;
    }

    @Override // opennlp.tools.sentdetect.SentenceDetector
    public String[] sentDetect(CharSequence charSequence) {
        Span[] spanArrSentPosDetect = sentPosDetect(charSequence);
        if (spanArrSentPosDetect.length == 0) {
            return new String[0];
        }
        String[] strArr = new String[spanArrSentPosDetect.length];
        for (int i = 0; i < spanArrSentPosDetect.length; i++) {
            strArr[i] = spanArrSentPosDetect[i].getCoveredText(charSequence).toString();
        }
        return strArr;
    }

    @Override // opennlp.tools.sentdetect.SentenceDetector
    public Span[] sentPosDetect(CharSequence charSequence) {
        Double dValueOf = Double.valueOf(1.0d);
        this.sentProbs.clear();
        List<Integer> positions = this.scanner.getPositions(charSequence);
        ArrayList arrayList = new ArrayList(positions.size());
        int size = positions.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int iIntValue = positions.get(i).intValue();
            int i4 = iIntValue + 1;
            int firstWS = getFirstWS(charSequence, i4);
            i++;
            if (i >= size || positions.get(i).intValue() >= firstWS) {
                if (arrayList.size() <= 0 || iIntValue >= ((Integer) AbstractC1974b.m1313f(1, arrayList)).intValue()) {
                    double[] dArrEval = this.model.eval(this.cgen.getContext(charSequence, iIntValue));
                    String bestOutcome = this.model.getBestOutcome(dArrEval);
                    if (bestOutcome.equals("s") && isAcceptableBreak(charSequence, i2, iIntValue)) {
                        if (i2 != iIntValue) {
                            if (this.useTokenEnd) {
                                arrayList.add(Integer.valueOf(getFirstNonWS(charSequence, getFirstWS(charSequence, i4))));
                            } else {
                                arrayList.add(Integer.valueOf(getFirstNonWS(charSequence, i4)));
                            }
                            this.sentProbs.add(Double.valueOf(dArrEval[this.model.getIndex(bestOutcome)]));
                        }
                        i2 = i4;
                    }
                }
            }
        }
        int size2 = arrayList.size();
        int[] iArr = new int[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        if (size2 == 0) {
            int length = charSequence.length();
            int i6 = 0;
            while (i6 < charSequence.length() && StringUtil.isWhitespace(charSequence.charAt(i6))) {
                i6++;
            }
            while (length > 0 && StringUtil.isWhitespace(charSequence.charAt(length - 1))) {
                length--;
            }
            if (length - i6 <= 0) {
                return new Span[0];
            }
            this.sentProbs.add(dValueOf);
            return new Span[]{new Span(i6, length)};
        }
        int i7 = size2 - 1;
        boolean z = iArr[i7] != charSequence.length();
        int i8 = z ? size2 + 1 : size2;
        Span[] spanArr = new Span[i8];
        int i9 = 0;
        while (i9 < size2) {
            Span spanTrim = new Span(i9 == 0 ? 0 : iArr[i9 - 1], iArr[i9]).trim(charSequence);
            if (spanTrim.length() > 0) {
                spanArr[i9] = spanTrim;
            } else {
                this.sentProbs.remove(i9);
            }
            i9++;
        }
        if (z) {
            Span spanTrim2 = new Span(iArr[i7], charSequence.length()).trim(charSequence);
            if (spanTrim2.length() > 0) {
                spanArr[i8 - 1] = spanTrim2;
                this.sentProbs.add(dValueOf);
            }
        }
        for (int i10 = 0; i10 < i8; i10++) {
            spanArr[i10] = new Span(spanArr[i10], this.sentProbs.get(i10).doubleValue());
        }
        return spanArr;
    }

    public SentenceDetectorME(SentenceModel sentenceModel) {
        this.sentProbs = new ArrayList();
        SentenceDetectorFactory factory = sentenceModel.getFactory();
        this.model = sentenceModel.getMaxentModel();
        this.cgen = factory.getSDContextGenerator();
        this.scanner = factory.getEndOfSentenceScanner();
        this.abbDict = sentenceModel.getAbbreviations();
        this.useTokenEnd = factory.isUseTokenEnd();
    }

    @Deprecated
    public SentenceDetectorME(SentenceModel sentenceModel, Factory factory) {
        this.sentProbs = new ArrayList();
        this.model = sentenceModel.getMaxentModel();
        char[] eosCharacters = sentenceModel.getEosCharacters();
        if (eosCharacters == null) {
            this.cgen = factory.createSentenceContextGenerator(sentenceModel.getLanguage(), getAbbreviations(sentenceModel.getAbbreviations()));
            this.scanner = factory.createEndOfSentenceScanner(sentenceModel.getLanguage());
        } else {
            this.cgen = factory.createSentenceContextGenerator(getAbbreviations(sentenceModel.getAbbreviations()), eosCharacters);
            this.scanner = factory.createEndOfSentenceScanner(eosCharacters);
        }
        this.abbDict = sentenceModel.getAbbreviations();
        this.useTokenEnd = sentenceModel.useTokenEnd();
    }
}
