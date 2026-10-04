package opennlp.tools.tokenize;

import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractTokenizer implements Tokenizer {
    protected boolean keepNewLines = false;

    public void setKeepNewLines(boolean z) {
        this.keepNewLines = z;
    }

    @Override // opennlp.tools.tokenize.Tokenizer
    public String[] tokenize(String str) {
        return Span.spansToStrings(tokenizePos(str), str);
    }
}
