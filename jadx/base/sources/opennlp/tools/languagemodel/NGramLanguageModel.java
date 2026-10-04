package opennlp.tools.languagemodel;

import java.io.InputStream;
import java.util.Iterator;
import opennlp.tools.ngram.NGramModel;
import opennlp.tools.ngram.NGramUtils;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramLanguageModel extends NGramModel implements LanguageModel {
    private static final int DEFAULT_N = 3;

    /* JADX INFO: renamed from: n */
    private final int f9668n;

    public NGramLanguageModel() {
        this(3);
    }

    private double stupidBackoff(StringList stringList) {
        int count = getCount(stringList);
        StringList nMinusOneTokenFirst = NGramUtils.getNMinusOneTokenFirst(stringList);
        if (nMinusOneTokenFirst == null || nMinusOneTokenFirst.size() == 0) {
            return ((double) count) / ((double) size());
        }
        if (count <= 0) {
            return stupidBackoff(NGramUtils.getNMinusOneTokenLast(stringList)) * 0.4d;
        }
        double count2 = getCount(nMinusOneTokenFirst);
        if (count2 == 0.0d) {
            count2 = size();
        }
        return ((double) count) / count2;
    }

    public void add(String... strArr) {
        add(new StringList(strArr), 1, this.f9668n);
    }

    @Override // opennlp.tools.languagemodel.LanguageModel
    public double calculateProbability(String... strArr) {
        double d = 0.0d;
        if (size() <= 0) {
            return 0.0d;
        }
        Iterator<String[]> it = NGramUtils.getNGrams(strArr, this.f9668n).iterator();
        double dLog = 0.0d;
        while (true) {
            if (!it.hasNext()) {
                d = dLog;
                break;
            }
            dLog += StrictMath.log(stupidBackoff(new StringList(it.next())));
            if (Double.isNaN(dLog)) {
                break;
            }
        }
        return StrictMath.exp(d);
    }

    @Override // opennlp.tools.languagemodel.LanguageModel
    public String[] predictNextTokens(String... strArr) {
        double d = Double.NEGATIVE_INFINITY;
        String[] strArr2 = null;
        for (StringList stringList : this) {
            String[] strArr3 = new String[stringList.size() + strArr.length];
            System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
            for (int i = 0; i < stringList.size(); i++) {
                strArr3[strArr.length + i] = stringList.getToken(i);
            }
            double dCalculateProbability = calculateProbability(strArr3);
            if (dCalculateProbability > d) {
                String[] strArr4 = new String[stringList.size()];
                for (int i2 = 0; i2 < stringList.size(); i2++) {
                    strArr4[i2] = stringList.getToken(i2);
                }
                strArr2 = strArr4;
                d = dCalculateProbability;
            }
        }
        return strArr2;
    }

    public NGramLanguageModel(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Parameter 'n' must be greater than 0.");
        }
        this.f9668n = i;
    }

    public NGramLanguageModel(InputStream inputStream) {
        this(inputStream, 3);
    }

    public NGramLanguageModel(InputStream inputStream, int i) {
        super(inputStream);
        if (i > 0) {
            this.f9668n = i;
            return;
        }
        throw new IllegalArgumentException("Parameter 'n' must be greater than 0.");
    }

    private double calculateProbability(StringList stringList) {
        double d = 0.0d;
        if (size() <= 0) {
            return 0.0d;
        }
        Iterator<StringList> it = NGramUtils.getNGrams(stringList, this.f9668n).iterator();
        double dLog = 0.0d;
        while (true) {
            if (!it.hasNext()) {
                d = dLog;
                break;
            }
            dLog += StrictMath.log(stupidBackoff(it.next()));
            if (Double.isNaN(dLog)) {
                break;
            }
        }
        return StrictMath.exp(d);
    }
}
