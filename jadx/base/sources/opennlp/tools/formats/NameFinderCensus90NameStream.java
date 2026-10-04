package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.nio.charset.Charset;
import java.util.Locale;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class NameFinderCensus90NameStream implements ObjectStream<StringList> {
    private final Charset encoding;
    private final ObjectStream<String> lineStream;
    private final Locale locale;

    public NameFinderCensus90NameStream(ObjectStream<String> objectStream) {
        this.locale = new Locale("en");
        this.encoding = Charset.defaultCharset();
        this.lineStream = objectStream;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.lineStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.lineStream.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public StringList read() {
        int iIndexOf;
        String str = this.lineStream.read();
        if (str == null || StringUtil.isEmpty(str) || (iIndexOf = str.indexOf(32)) == -1) {
            return null;
        }
        String strSubstring = str.substring(0, iIndexOf);
        return new StringList((strSubstring.length() <= 2 || !strSubstring.startsWith("MC")) ? AbstractC0541b.m756B(strSubstring.substring(0, 1).toUpperCase(this.locale), strSubstring.substring(1).toLowerCase(this.locale)) : AbstractC2821a.m2221l(strSubstring.substring(0, 1).toUpperCase(this.locale), strSubstring.substring(1, 2).toLowerCase(this.locale), strSubstring.substring(2, 3).toUpperCase(this.locale), strSubstring.substring(3).toLowerCase(this.locale)));
    }

    public NameFinderCensus90NameStream(InputStreamFactory inputStreamFactory, Charset charset) {
        this.locale = new Locale("en");
        this.encoding = charset;
        this.lineStream = new PlainTextByLineStream(inputStreamFactory, charset);
    }
}
