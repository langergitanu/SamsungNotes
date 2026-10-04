package opennlp.tools.formats.p216ad;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.p216ad.ADSentenceStream;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.lang.Factory;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ADSentenceSampleStream implements ObjectStream<SentenceSample> {
    private static final Pattern META_1 = Pattern.compile("^(?:[a-zA-Z\\-]*(\\d+)).*?p=(\\d+).*");
    private final ObjectStream<ADSentenceStream.Sentence> adSentenceStream;
    private final boolean isIncludeTitles;
    private boolean isSamePara;
    private boolean isSameText;
    private boolean isTitle;
    private int para;
    private final char[] ptEosCharacters;
    private ADSentenceStream.Sentence sent;
    private int text;

    public ADSentenceSampleStream(ObjectStream<String> objectStream, boolean z) {
        this.text = -1;
        this.para = -1;
        this.adSentenceStream = new ADSentenceStream(objectStream);
        char[] cArr = Factory.ptEosCharacters;
        this.ptEosCharacters = cArr;
        Arrays.sort(cArr);
        this.isIncludeTitles = z;
    }

    private boolean hasPunctuation(String str) {
        String strTrim = str.trim();
        if (strTrim.length() > 0) {
            if (Arrays.binarySearch(this.ptEosCharacters, AbstractC0000a.m4a(1, strTrim)) >= 0) {
                return true;
            }
        }
        return false;
    }

    private void updateMeta() {
        ADSentenceStream.Sentence sentence = this.sent;
        if (sentence == null) {
            this.isSameText = false;
            this.isSamePara = false;
            return;
        }
        String metadata = sentence.getMetadata();
        Matcher matcher = META_1.matcher(metadata);
        if (!matcher.matches()) {
            throw new RuntimeException(AbstractC0541b.m772n("Invalid metadata: ", metadata));
        }
        int i = Integer.parseInt(matcher.group(1));
        int i2 = Integer.parseInt(matcher.group(2));
        this.isSameText = false;
        this.isSamePara = false;
        if (i == this.text) {
            this.isSameText = true;
        }
        if (this.isSameText && i2 == this.para) {
            this.isSamePara = true;
        }
        this.isTitle = metadata.contains("title");
        this.text = i;
        this.para = i2;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.adSentenceStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.adSentenceStream.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        if (this.sent == null) {
            this.sent = this.adSentenceStream.read();
            updateMeta();
            if (this.sent == null) {
                return null;
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        while (true) {
            if ((!this.isTitle || this.isIncludeTitles) && hasPunctuation(this.sent.getText())) {
                int length = sb.length();
                sb.append(this.sent.getText());
                arrayList.add(new Span(length, sb.length()));
                sb.append(" ");
            }
            this.sent = this.adSentenceStream.read();
            updateMeta();
            if (!this.isSamePara && !this.isSameText) {
                break;
            }
        }
        return new SentenceSample(sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString(), (Span[]) arrayList.toArray(new Span[0]));
    }

    public ADSentenceSampleStream(InputStreamFactory inputStreamFactory, String str, boolean z) {
        this(new PlainTextByLineStream(inputStreamFactory, str), z);
    }
}
