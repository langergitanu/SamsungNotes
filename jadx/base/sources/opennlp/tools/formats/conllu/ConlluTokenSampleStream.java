package opennlp.tools.formats.conllu;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.IOException;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.StringUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConlluTokenSampleStream extends FilterObjectStream<ConlluSentence, TokenSample> {
    public ConlluTokenSampleStream(ObjectStream<ConlluSentence> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() throws IOException {
        ConlluSentence conlluSentence = (ConlluSentence) this.samples.read();
        if (conlluSentence == null) {
            return null;
        }
        if (conlluSentence.getTextComment() == null) {
            throw new IOException("Sentence is missing raw text sample!");
        }
        StringBuilder sb = new StringBuilder(conlluSentence.getTextComment());
        int length = 0;
        for (ConlluWordLine conlluWordLine : conlluSentence.getWordLines()) {
            if (!conlluWordLine.getId().contains(Extension.DOT)) {
                String form = conlluWordLine.getForm();
                int iIndexOf = sb.indexOf(form, length);
                if (iIndexOf == -1) {
                    StringBuilder sbM16m = AbstractC0000a.m16m("Failed to match token [", form, "] in sentence [", conlluSentence.getSentenceIdComment(), "] with text [");
                    sbM16m.append((Object) sb);
                    sbM16m.append("]");
                    throw new IOException(sbM16m.toString());
                }
                length = iIndexOf + form.length();
                if (length < sb.length() && !StringUtil.isWhitespace(sb.charAt(length))) {
                    sb.insert(length, TokenSample.DEFAULT_SEPARATOR_CHARS);
                }
            }
        }
        return TokenSample.parse(sb.toString(), TokenSample.DEFAULT_SEPARATOR_CHARS);
    }
}
