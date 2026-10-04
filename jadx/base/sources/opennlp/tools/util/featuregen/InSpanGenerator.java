package opennlp.tools.util.featuregen;

import java.util.List;
import java.util.Objects;
import opennlp.tools.namefind.TokenNameFinder;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InSpanGenerator implements AdaptiveFeatureGenerator {
    private Span[] currentNames;
    private String[] currentSentence;
    private final TokenNameFinder finder;
    private final String prefix;

    public InSpanGenerator(String str, TokenNameFinder tokenNameFinder) {
        Objects.requireNonNull(str, "prefix must not be null");
        this.prefix = str;
        Objects.requireNonNull(tokenNameFinder, "finder must not be null");
        this.finder = tokenNameFinder;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (this.currentSentence != strArr) {
            this.currentSentence = strArr;
            this.currentNames = this.finder.find(strArr);
        }
        for (Span span : this.currentNames) {
            if (span.contains(i)) {
                list.add(this.prefix + ":w=dic");
                list.add(this.prefix + ":w=dic=" + strArr[i]);
                return;
            }
        }
    }
}
