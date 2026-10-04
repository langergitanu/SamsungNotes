package opennlp.tools.tokenize;

import java.util.ArrayList;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WhitespaceTokenizer extends AbstractTokenizer {
    public static final WhitespaceTokenizer INSTANCE = new WhitespaceTokenizer();

    private WhitespaceTokenizer() {
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
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = -1;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            if (StringUtil.isWhitespace(str.charAt(i2))) {
                if (z) {
                    arrayList.add(new Span(i, i2));
                    i = -1;
                    z = false;
                }
                if (this.keepNewLines && isLineSeparator(str.charAt(i2))) {
                    arrayList.add(new Span(i2, i2 + 1));
                    i = -1;
                }
            } else if (!z) {
                z = true;
                i = i2;
            }
        }
        if (z) {
            arrayList.add(new Span(i, length));
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }
}
