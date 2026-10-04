package opennlp.tools.tokenize;

import java.util.ArrayList;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SimpleTokenizer extends AbstractTokenizer {
    public static final SimpleTokenizer INSTANCE = new SimpleTokenizer();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CharacterEnum {
        private final String name;
        static final CharacterEnum WHITESPACE = new CharacterEnum("whitespace");
        static final CharacterEnum ALPHABETIC = new CharacterEnum("alphabetic");
        static final CharacterEnum NUMERIC = new CharacterEnum("numeric");
        static final CharacterEnum OTHER = new CharacterEnum("other");

        private CharacterEnum(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    private SimpleTokenizer() {
    }

    private boolean isLineSeparator(char c) {
        return c == '\r' || c == '\n';
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
        CharacterEnum characterEnum = CharacterEnum.WHITESPACE;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = -1;
        int i2 = 0;
        char c = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            CharacterEnum characterEnum2 = StringUtil.isWhitespace(cCharAt) ? CharacterEnum.WHITESPACE : Character.isAlphabetic(cCharAt) ? CharacterEnum.ALPHABETIC : Character.isDigit(cCharAt) ? CharacterEnum.NUMERIC : CharacterEnum.OTHER;
            CharacterEnum characterEnum3 = CharacterEnum.WHITESPACE;
            if (characterEnum == characterEnum3) {
                if (characterEnum2 != characterEnum3) {
                    i = i2;
                }
            } else if (characterEnum2 != characterEnum || (characterEnum2 == CharacterEnum.OTHER && cCharAt != c)) {
                arrayList.add(new Span(i, i2));
                i = i2;
            }
            if (this.keepNewLines && isLineSeparator(cCharAt)) {
                int i4 = i + 1;
                arrayList.add(new Span(i, i4));
                i = i4;
            }
            i2++;
            c = cCharAt;
            characterEnum = characterEnum2;
        }
        if (characterEnum != CharacterEnum.WHITESPACE) {
            arrayList.add(new Span(i, length));
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }
}
