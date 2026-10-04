package opennlp.tools.tokenize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.DownloadUtil;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringList;
import opennlp.tools.util.TrainingParameters;
import p075S.C0255g;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenizerME extends AbstractTokenizer {
    public static final String NO_SPLIT = "F";
    public static final String SPLIT = "T";
    private final Dictionary abbDict;
    private final Pattern alphanumeric;

    /* JADX INFO: renamed from: cg */
    private final TokenContextGenerator f9695cg;
    private final MaxentModel model;
    private final List<Span> newTokens;
    private final List<Double> tokProbs;
    private final boolean useAlphaNumericOptimization;

    public TokenizerME(String str) {
        this((TokenizerModel) DownloadUtil.downloadModel(str, DownloadUtil.ModelType.TOKENIZER, TokenizerModel.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$tokenizePos$0(int i) {
        return i == 46;
    }

    public static TokenizerModel train(ObjectStream<TokenSample> objectStream, TokenizerFactory tokenizerFactory, TrainingParameters trainingParameters) {
        HashMap map = new HashMap();
        return new TokenizerModel(TrainerFactory.getEventTrainer(trainingParameters, map).train(new TokSpanEventStream(objectStream, tokenizerFactory.isUseAlphaNumericOptimization(), tokenizerFactory.getAlphaNumericPattern(), tokenizerFactory.getContextGenerator())), map, tokenizerFactory);
    }

    public double[] getTokenProbabilities() {
        int size = this.tokProbs.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = this.tokProbs.get(i).doubleValue();
        }
        return dArr;
    }

    public boolean isAcceptableAbbreviation(CharSequence charSequence) {
        Dictionary dictionary = this.abbDict;
        if (dictionary == null) {
            return false;
        }
        return dictionary.contains(new StringList(charSequence.toString()));
    }

    @Override // opennlp.tools.tokenize.AbstractTokenizer
    public /* bridge */ /* synthetic */ void setKeepNewLines(boolean z) {
        super.setKeepNewLines(z);
    }

    @Override // opennlp.tools.tokenize.AbstractTokenizer, opennlp.tools.tokenize.Tokenizer
    public /* bridge */ /* synthetic */ String[] tokenize(String str) {
        return super.tokenize(str);
    }

    @Override // opennlp.tools.tokenize.Tokenizer
    public Span[] tokenizePos(String str) {
        int i;
        double d = 1.0d;
        Double dValueOf = Double.valueOf(1.0d);
        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
        whitespaceTokenizer.setKeepNewLines(this.keepNewLines);
        Span[] spanArr = whitespaceTokenizer.tokenizePos(str);
        this.newTokens.clear();
        this.tokProbs.clear();
        int length = spanArr.length;
        int i2 = 0;
        while (i2 < length) {
            Span span = spanArr[i2];
            String strSubstring = str.substring(span.getStart(), span.getEnd());
            if (strSubstring.length() < 2) {
                this.newTokens.add(span);
                this.tokProbs.add(dValueOf);
            } else if (useAlphaNumericOptimization() && this.alphanumeric.matcher(strSubstring).matches()) {
                this.newTokens.add(span);
                this.tokProbs.add(dValueOf);
            } else {
                int start = span.getStart();
                int end = span.getEnd();
                int start2 = span.getStart();
                int i4 = start2 + 1;
                double d2 = d;
                while (i4 < end) {
                    double[] dArrEval = this.model.eval(this.f9695cg.getContext(strSubstring, i4 - start2));
                    String bestOutcome = this.model.getBestOutcome(dArrEval);
                    d2 *= dArrEval[this.model.getIndex(bestOutcome)];
                    if (bestOutcome.equals("T")) {
                        if (isAcceptableAbbreviation(strSubstring)) {
                            this.newTokens.add(new Span(start, end));
                            this.tokProbs.add(Double.valueOf(d2));
                            int iCount = i4 + ((int) strSubstring.codePoints().filter(new C0255g(3)).count());
                            i4 = iCount + 1;
                            i = iCount;
                        } else {
                            this.newTokens.add(new Span(start, i4));
                            this.tokProbs.add(Double.valueOf(d2));
                            i = i4;
                        }
                        start = i4;
                        d2 = 1.0d;
                        i4 = i;
                    }
                    i4++;
                }
                if (start < end) {
                    this.newTokens.add(new Span(start, end));
                    this.tokProbs.add(Double.valueOf(d2));
                }
            }
            i2++;
            d = 1.0d;
        }
        Span[] spanArr2 = new Span[this.newTokens.size()];
        this.newTokens.toArray(spanArr2);
        return spanArr2;
    }

    public boolean useAlphaNumericOptimization() {
        return this.useAlphaNumericOptimization;
    }

    public TokenizerME(TokenizerModel tokenizerModel) {
        TokenizerFactory factory = tokenizerModel.getFactory();
        this.alphanumeric = factory.getAlphaNumericPattern();
        this.f9695cg = factory.getContextGenerator();
        this.model = tokenizerModel.getMaxentModel();
        this.useAlphaNumericOptimization = factory.isUseAlphaNumericOptimization();
        this.abbDict = tokenizerModel.getAbbreviations();
        this.newTokens = new ArrayList();
        this.tokProbs = new ArrayList(50);
    }
}
