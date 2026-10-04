package opennlp.tools.langdetect;

import java.util.ArrayList;
import java.util.Iterator;
import opennlp.tools.ngram.NGramCharModel;
import opennlp.tools.util.normalizer.AggregateCharSequenceNormalizer;
import opennlp.tools.util.normalizer.CharSequenceNormalizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultLanguageDetectorContextGenerator implements LanguageDetectorContextGenerator {
    private static final long serialVersionUID = 8891936509865460799L;
    protected final int maxLength;
    protected final int minLength;
    protected final CharSequenceNormalizer normalizer;

    public DefaultLanguageDetectorContextGenerator(int i, int i2, CharSequenceNormalizer... charSequenceNormalizerArr) {
        this.minLength = i;
        this.maxLength = i2;
        this.normalizer = new AggregateCharSequenceNormalizer(charSequenceNormalizerArr);
    }

    @Override // opennlp.tools.langdetect.LanguageDetectorContextGenerator
    public <T extends CharSequence> T[] getContext(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        NGramCharModel nGramCharModel = new NGramCharModel();
        nGramCharModel.add(this.normalizer.normalize(charSequence), this.minLength, this.maxLength);
        Iterator<CharSequence> it = nGramCharModel.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return (T[]) ((CharSequence[]) arrayList.toArray(new CharSequence[0]));
    }
}
