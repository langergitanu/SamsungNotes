package opennlp.tools.namefind;

import java.util.LinkedList;
import java.util.Objects;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryNameFinder implements TokenNameFinder {
    private static final String DEFAULT_TYPE = "default";
    private final Dictionary mDictionary;
    private final String type;

    public DictionaryNameFinder(Dictionary dictionary, String str) {
        Objects.requireNonNull(dictionary, "dictionary must not be null");
        this.mDictionary = dictionary;
        Objects.requireNonNull(str, "type must not be null");
        this.type = str;
    }

    @Override // opennlp.tools.namefind.TokenNameFinder
    public Span[] find(String[] strArr) {
        int i;
        LinkedList linkedList = new LinkedList();
        boolean zIsCaseSensitive = this.mDictionary.isCaseSensitive();
        int maxTokenCount = this.mDictionary.getMaxTokenCount();
        int length = 0;
        while (length < strArr.length) {
            Span span = null;
            for (int i2 = length; i2 < strArr.length && (i = (i2 - length) + 1) <= maxTokenCount; i2++) {
                String[] strArr2 = new String[i];
                System.arraycopy(strArr, length, strArr2, 0, i);
                if (this.mDictionary.contains(new StringList(zIsCaseSensitive, strArr2))) {
                    span = new Span(length, i2 + 1, this.type);
                }
            }
            if (span != null) {
                linkedList.add(span);
                length += span.length() - 1;
            }
            length++;
        }
        return (Span[]) linkedList.toArray(new Span[0]);
    }

    public DictionaryNameFinder(Dictionary dictionary) {
        this(dictionary, "default");
    }

    @Override // opennlp.tools.namefind.TokenNameFinder
    public void clearAdaptiveData() {
    }
}
