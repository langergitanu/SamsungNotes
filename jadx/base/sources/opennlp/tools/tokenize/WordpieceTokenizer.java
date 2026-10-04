package opennlp.tools.tokenize;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Pattern;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WordpieceTokenizer implements Tokenizer {
    private static final String CLASSIFICATION_TOKEN = "[CLS]";
    private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("\\p{Punct}+");
    private static final String SEPARATOR_TOKEN = "[SEP]";
    private static final String UNKNOWN_TOKEN = "[UNK]";
    private int maxTokenLength;
    private final Set<String> vocabulary;

    public WordpieceTokenizer(Set<String> set) {
        this.maxTokenLength = 50;
        this.vocabulary = set;
    }

    public int getMaxTokenLength() {
        return this.maxTokenLength;
    }

    @Override // opennlp.tools.tokenize.Tokenizer
    public String[] tokenize(String str) {
        int length;
        String strValueOf;
        LinkedList linkedList = new LinkedList();
        linkedList.add(CLASSIFICATION_TOKEN);
        for (String str2 : WhitespaceTokenizer.INSTANCE.tokenize(PUNCTUATION_PATTERN.matcher(str).replaceAll(" $0 "))) {
            char[] charArray = str2.toCharArray();
            if (charArray.length <= this.maxTokenLength) {
                int i = 0;
                while (true) {
                    if (i < charArray.length) {
                        length = charArray.length;
                        while (i < length) {
                            strValueOf = String.valueOf(charArray, i, length - i);
                            if (i > 0) {
                                strValueOf = AbstractC0541b.m772n("##", strValueOf);
                            }
                            if (this.vocabulary.contains(strValueOf)) {
                                break;
                            }
                            length--;
                        }
                        linkedList.add(UNKNOWN_TOKEN);
                        break;
                    }
                    linkedList.add(strValueOf);
                    i = length;
                }
            } else {
                linkedList.add(UNKNOWN_TOKEN);
            }
        }
        linkedList.add(SEPARATOR_TOKEN);
        return (String[]) linkedList.toArray(new String[0]);
    }

    @Override // opennlp.tools.tokenize.Tokenizer
    public Span[] tokenizePos(String str) {
        return null;
    }

    public WordpieceTokenizer(Set<String> set, int i) {
        this(set);
        this.maxTokenLength = i;
    }
}
